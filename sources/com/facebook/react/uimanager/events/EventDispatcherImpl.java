package com.facebook.react.uimanager.events;

import android.util.LongSparseArray;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.modules.core.ChoreographerCompat;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.systrace.Systrace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.internal.ws.WebSocketProtocol;

public class EventDispatcherImpl implements EventDispatcher, LifecycleEventListener {
    /* access modifiers changed from: private */
    public static final Comparator<Event> EVENT_COMPARATOR = new Comparator<Event>() {
        public int compare(Event event, Event event2) {
            if (event == null && event2 == null) {
                return 0;
            }
            if (event == null) {
                return -1;
            }
            if (event2 == null) {
                return 1;
            }
            int i2 = ((event.getTimestampMs() - event2.getTimestampMs()) > 0 ? 1 : ((event.getTimestampMs() - event2.getTimestampMs()) == 0 ? 0 : -1));
            if (i2 == 0) {
                return 0;
            }
            return i2 < 0 ? -1 : 1;
        }
    };
    /* access modifiers changed from: private */
    public final ScheduleDispatchFrameCallback mCurrentFrameCallback = new ScheduleDispatchFrameCallback();
    /* access modifiers changed from: private */
    public final DispatchEventsRunnable mDispatchEventsRunnable = new DispatchEventsRunnable();
    /* access modifiers changed from: private */
    public final LongSparseArray<Integer> mEventCookieToLastEventIdx = new LongSparseArray<>();
    private final Map<String, Short> mEventNameToEventId = MapBuilder.newHashMap();
    private final ArrayList<Event> mEventStaging = new ArrayList<>();
    private final Object mEventsStagingLock = new Object();
    /* access modifiers changed from: private */
    public Event[] mEventsToDispatch = new Event[16];
    /* access modifiers changed from: private */
    public final Object mEventsToDispatchLock = new Object();
    /* access modifiers changed from: private */
    public int mEventsToDispatchSize = 0;
    /* access modifiers changed from: private */
    public volatile boolean mHasDispatchScheduled = false;
    /* access modifiers changed from: private */
    public final AtomicInteger mHasDispatchScheduledCount = new AtomicInteger();
    private final CopyOnWriteArrayList<EventDispatcherListener> mListeners = new CopyOnWriteArrayList<>();
    private short mNextEventTypeId = 0;
    /* access modifiers changed from: private */
    public final CopyOnWriteArrayList<BatchEventDispatchedListener> mPostEventDispatchListeners = new CopyOnWriteArrayList<>();
    /* access modifiers changed from: private */
    public final ReactApplicationContext mReactContext;
    /* access modifiers changed from: private */
    public volatile ReactEventEmitter mReactEventEmitter;

    private class DispatchEventsRunnable implements Runnable {
        private DispatchEventsRunnable() {
        }

        public void run() {
            Systrace.beginSection(0, "DispatchEventsRunnable");
            try {
                Systrace.endAsyncFlow(0, "ScheduleDispatchFrameCallback", EventDispatcherImpl.this.mHasDispatchScheduledCount.getAndIncrement());
                boolean unused = EventDispatcherImpl.this.mHasDispatchScheduled = false;
                Assertions.assertNotNull(EventDispatcherImpl.this.mReactEventEmitter);
                synchronized (EventDispatcherImpl.this.mEventsToDispatchLock) {
                    if (EventDispatcherImpl.this.mEventsToDispatchSize > 0) {
                        if (EventDispatcherImpl.this.mEventsToDispatchSize > 1) {
                            Arrays.sort(EventDispatcherImpl.this.mEventsToDispatch, 0, EventDispatcherImpl.this.mEventsToDispatchSize, EventDispatcherImpl.EVENT_COMPARATOR);
                        }
                        for (int i2 = 0; i2 < EventDispatcherImpl.this.mEventsToDispatchSize; i2++) {
                            Event event = EventDispatcherImpl.this.mEventsToDispatch[i2];
                            if (event != null) {
                                Systrace.endAsyncFlow(0, event.getEventName(), event.getUniqueID());
                                event.dispatchModern(EventDispatcherImpl.this.mReactEventEmitter);
                                event.dispose();
                            }
                        }
                        EventDispatcherImpl.this.clearEventsToDispatch();
                        EventDispatcherImpl.this.mEventCookieToLastEventIdx.clear();
                    }
                }
                Iterator it2 = EventDispatcherImpl.this.mPostEventDispatchListeners.iterator();
                while (it2.hasNext()) {
                    ((BatchEventDispatchedListener) it2.next()).onBatchEventDispatched();
                }
                Systrace.endSection(0);
            } catch (Throwable th) {
                Systrace.endSection(0);
                throw th;
            }
        }
    }

    private class ScheduleDispatchFrameCallback extends ChoreographerCompat.FrameCallback {
        private volatile boolean mIsPosted;
        private boolean mShouldStop;

        private ScheduleDispatchFrameCallback() {
            this.mIsPosted = false;
            this.mShouldStop = false;
        }

        private void post() {
            ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.TIMERS_EVENTS, EventDispatcherImpl.this.mCurrentFrameCallback);
        }

        public void doFrame(long j2) {
            UiThreadUtil.assertOnUiThread();
            if (this.mShouldStop) {
                this.mIsPosted = false;
            } else {
                post();
            }
            Systrace.beginSection(0, "ScheduleDispatchFrameCallback");
            try {
                EventDispatcherImpl.this.moveStagedEventsToDispatchQueue();
                if (!EventDispatcherImpl.this.mHasDispatchScheduled) {
                    boolean unused = EventDispatcherImpl.this.mHasDispatchScheduled = true;
                    Systrace.startAsyncFlow(0, "ScheduleDispatchFrameCallback", EventDispatcherImpl.this.mHasDispatchScheduledCount.get());
                    EventDispatcherImpl.this.mReactContext.runOnJSQueueThread(EventDispatcherImpl.this.mDispatchEventsRunnable);
                }
            } finally {
                Systrace.endSection(0);
            }
        }

        public void maybePost() {
            if (!this.mIsPosted) {
                this.mIsPosted = true;
                post();
            }
        }

        public void maybePostFromNonUI() {
            if (!this.mIsPosted) {
                if (EventDispatcherImpl.this.mReactContext.isOnUiQueueThread()) {
                    maybePost();
                } else {
                    EventDispatcherImpl.this.mReactContext.runOnUiQueueThread(new Runnable() {
                        public void run() {
                            ScheduleDispatchFrameCallback.this.maybePost();
                        }
                    });
                }
            }
        }

        public void stop() {
            this.mShouldStop = true;
        }
    }

    public EventDispatcherImpl(ReactApplicationContext reactApplicationContext) {
        this.mReactContext = reactApplicationContext;
        reactApplicationContext.addLifecycleEventListener(this);
        this.mReactEventEmitter = new ReactEventEmitter(reactApplicationContext);
    }

    private void addEventToEventsToDispatch(Event event) {
        int i2 = this.mEventsToDispatchSize;
        Event[] eventArr = this.mEventsToDispatch;
        if (i2 == eventArr.length) {
            this.mEventsToDispatch = (Event[]) Arrays.copyOf(eventArr, eventArr.length * 2);
        }
        Event[] eventArr2 = this.mEventsToDispatch;
        int i3 = this.mEventsToDispatchSize;
        this.mEventsToDispatchSize = i3 + 1;
        eventArr2[i3] = event;
    }

    /* access modifiers changed from: private */
    public void clearEventsToDispatch() {
        Arrays.fill(this.mEventsToDispatch, 0, this.mEventsToDispatchSize, (Object) null);
        this.mEventsToDispatchSize = 0;
    }

    private long getEventCookie(int i2, String str, short s2) {
        short s3;
        Short sh = this.mEventNameToEventId.get(str);
        if (sh != null) {
            s3 = sh.shortValue();
        } else {
            short s4 = this.mNextEventTypeId;
            this.mNextEventTypeId = (short) (s4 + 1);
            this.mEventNameToEventId.put(str, Short.valueOf(s4));
            s3 = s4;
        }
        return getEventCookie(i2, s3, s2);
    }

    private static long getEventCookie(int i2, short s2, short s3) {
        return ((((long) s2) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((long) i2) | ((((long) s3) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48);
    }

    private void maybePostFrameCallbackFromNonUI() {
        if (this.mReactEventEmitter != null) {
            this.mCurrentFrameCallback.maybePostFromNonUI();
        }
    }

    /* access modifiers changed from: private */
    public void moveStagedEventsToDispatchQueue() {
        synchronized (this.mEventsStagingLock) {
            synchronized (this.mEventsToDispatchLock) {
                for (int i2 = 0; i2 < this.mEventStaging.size(); i2++) {
                    Event event = this.mEventStaging.get(i2);
                    if (!event.canCoalesce()) {
                        addEventToEventsToDispatch(event);
                    } else {
                        long eventCookie = getEventCookie(event.getViewTag(), event.getEventName(), event.getCoalescingKey());
                        Integer num = this.mEventCookieToLastEventIdx.get(eventCookie);
                        Event event2 = null;
                        if (num == null) {
                            this.mEventCookieToLastEventIdx.put(eventCookie, Integer.valueOf(this.mEventsToDispatchSize));
                        } else {
                            Event event3 = this.mEventsToDispatch[num.intValue()];
                            Event coalesce = event.coalesce(event3);
                            if (coalesce != event3) {
                                this.mEventCookieToLastEventIdx.put(eventCookie, Integer.valueOf(this.mEventsToDispatchSize));
                                this.mEventsToDispatch[num.intValue()] = null;
                                event2 = event3;
                                event = coalesce;
                            } else {
                                event2 = event;
                                event = null;
                            }
                        }
                        if (event != null) {
                            addEventToEventsToDispatch(event);
                        }
                        if (event2 != null) {
                            event2.dispose();
                        }
                    }
                }
            }
            this.mEventStaging.clear();
        }
    }

    /* access modifiers changed from: private */
    public void stopFrameCallback() {
        UiThreadUtil.assertOnUiThread();
        this.mCurrentFrameCallback.stop();
    }

    public void addBatchEventDispatchedListener(BatchEventDispatchedListener batchEventDispatchedListener) {
        this.mPostEventDispatchListeners.add(batchEventDispatchedListener);
    }

    public void addListener(EventDispatcherListener eventDispatcherListener) {
        this.mListeners.add(eventDispatcherListener);
    }

    public void dispatchAllEvents() {
        maybePostFrameCallbackFromNonUI();
    }

    public void dispatchEvent(Event event) {
        Assertions.assertCondition(event.isInitialized(), "Dispatched event hasn't been initialized");
        Iterator<EventDispatcherListener> it2 = this.mListeners.iterator();
        while (it2.hasNext()) {
            it2.next().onEventDispatch(event);
        }
        synchronized (this.mEventsStagingLock) {
            this.mEventStaging.add(event);
            Systrace.startAsyncFlow(0, event.getEventName(), event.getUniqueID());
        }
        maybePostFrameCallbackFromNonUI();
    }

    public void onCatalystInstanceDestroyed() {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                EventDispatcherImpl.this.stopFrameCallback();
            }
        });
    }

    public void onHostDestroy() {
        stopFrameCallback();
    }

    public void onHostPause() {
        stopFrameCallback();
    }

    public void onHostResume() {
        maybePostFrameCallbackFromNonUI();
    }

    public void registerEventEmitter(int i2, RCTEventEmitter rCTEventEmitter) {
        this.mReactEventEmitter.register(i2, rCTEventEmitter);
    }

    public void removeBatchEventDispatchedListener(BatchEventDispatchedListener batchEventDispatchedListener) {
        this.mPostEventDispatchListeners.remove(batchEventDispatchedListener);
    }

    public void removeListener(EventDispatcherListener eventDispatcherListener) {
        this.mListeners.remove(eventDispatcherListener);
    }

    public void unregisterEventEmitter(int i2) {
        this.mReactEventEmitter.unregister(i2);
    }

    public void registerEventEmitter(int i2, RCTModernEventEmitter rCTModernEventEmitter) {
        this.mReactEventEmitter.register(i2, rCTModernEventEmitter);
    }
}
