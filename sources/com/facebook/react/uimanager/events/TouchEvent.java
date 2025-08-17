package com.facebook.react.uimanager.events;

import android.view.MotionEvent;
import androidx.core.util.Pools$SynchronizedPool;
import com.facebook.imageutils.JfifUtil;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.SoftAssertions;

public class TouchEvent extends Event<TouchEvent> {
    private static final Pools$SynchronizedPool<TouchEvent> EVENTS_POOL = new Pools$SynchronizedPool<>(3);
    private static final String TAG = "TouchEvent";
    private static final int TOUCH_EVENTS_POOL_SIZE = 3;
    public static final long UNSET = Long.MIN_VALUE;
    private short mCoalescingKey;
    private MotionEvent mMotionEvent;
    private TouchEventType mTouchEventType;
    private float mViewX;
    private float mViewY;

    /* renamed from: com.facebook.react.uimanager.events.TouchEvent$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$uimanager$events$TouchEventType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.facebook.react.uimanager.events.TouchEventType[] r0 = com.facebook.react.uimanager.events.TouchEventType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$react$uimanager$events$TouchEventType = r0
                com.facebook.react.uimanager.events.TouchEventType r1 = com.facebook.react.uimanager.events.TouchEventType.START     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$events$TouchEventType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.react.uimanager.events.TouchEventType r1 = com.facebook.react.uimanager.events.TouchEventType.END     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$events$TouchEventType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.react.uimanager.events.TouchEventType r1 = com.facebook.react.uimanager.events.TouchEventType.CANCEL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$events$TouchEventType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.react.uimanager.events.TouchEventType r1 = com.facebook.react.uimanager.events.TouchEventType.MOVE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.events.TouchEvent.AnonymousClass1.<clinit>():void");
        }
    }

    private TouchEvent() {
    }

    private void init(int i2, int i3, TouchEventType touchEventType, MotionEvent motionEvent, long j2, float f2, float f3, TouchEventCoalescingKeyHelper touchEventCoalescingKeyHelper) {
        boolean z2;
        super.init(i2, i3, motionEvent.getEventTime());
        short s2 = 0;
        if (j2 != Long.MIN_VALUE) {
            z2 = true;
        } else {
            z2 = false;
        }
        SoftAssertions.assertCondition(z2, "Gesture start time must be initialized");
        int action = motionEvent.getAction() & JfifUtil.MARKER_FIRST_BYTE;
        if (action == 0) {
            touchEventCoalescingKeyHelper.addCoalescingKey(j2);
        } else if (action == 1) {
            touchEventCoalescingKeyHelper.removeCoalescingKey(j2);
        } else if (action == 2) {
            s2 = touchEventCoalescingKeyHelper.getCoalescingKey(j2);
        } else if (action == 3) {
            touchEventCoalescingKeyHelper.removeCoalescingKey(j2);
        } else if (action == 5 || action == 6) {
            touchEventCoalescingKeyHelper.incrementCoalescingKey(j2);
        } else {
            throw new RuntimeException("Unhandled MotionEvent action: " + action);
        }
        this.mTouchEventType = touchEventType;
        this.mMotionEvent = MotionEvent.obtain(motionEvent);
        this.mCoalescingKey = s2;
        this.mViewX = f2;
        this.mViewY = f3;
    }

    @Deprecated
    public static TouchEvent obtain(int i2, TouchEventType touchEventType, MotionEvent motionEvent, long j2, float f2, float f3, TouchEventCoalescingKeyHelper touchEventCoalescingKeyHelper) {
        return obtain(-1, i2, touchEventType, (MotionEvent) Assertions.assertNotNull(motionEvent), j2, f2, f3, touchEventCoalescingKeyHelper);
    }

    private boolean verifyMotionEvent() {
        if (this.mMotionEvent != null) {
            return true;
        }
        ReactSoftExceptionLogger.logSoftException(TAG, new IllegalStateException("Cannot dispatch a TouchEvent that has no MotionEvent; the TouchEvent has been recycled"));
        return false;
    }

    public boolean canCoalesce() {
        int i2 = AnonymousClass1.$SwitchMap$com$facebook$react$uimanager$events$TouchEventType[((TouchEventType) Assertions.assertNotNull(this.mTouchEventType)).ordinal()];
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            return false;
        }
        if (i2 == 4) {
            return true;
        }
        throw new RuntimeException("Unknown touch event type: " + this.mTouchEventType);
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        if (verifyMotionEvent()) {
            TouchesHelper.sendTouchesLegacy(rCTEventEmitter, this);
        }
    }

    public void dispatchModern(RCTModernEventEmitter rCTModernEventEmitter) {
        if (verifyMotionEvent()) {
            rCTModernEventEmitter.receiveTouches(this);
        }
    }

    public short getCoalescingKey() {
        return this.mCoalescingKey;
    }

    /* access modifiers changed from: protected */
    public int getEventCategory() {
        TouchEventType touchEventType = this.mTouchEventType;
        if (touchEventType == null) {
            return 2;
        }
        int i2 = AnonymousClass1.$SwitchMap$com$facebook$react$uimanager$events$TouchEventType[touchEventType.ordinal()];
        if (i2 == 1) {
            return 0;
        }
        if (i2 == 2 || i2 == 3) {
            return 1;
        }
        if (i2 != 4) {
            return super.getEventCategory();
        }
        return 4;
    }

    public String getEventName() {
        return TouchEventType.getJSEventName((TouchEventType) Assertions.assertNotNull(this.mTouchEventType));
    }

    public MotionEvent getMotionEvent() {
        Assertions.assertNotNull(this.mMotionEvent);
        return this.mMotionEvent;
    }

    public TouchEventType getTouchEventType() {
        return (TouchEventType) Assertions.assertNotNull(this.mTouchEventType);
    }

    public float getViewX() {
        return this.mViewX;
    }

    public float getViewY() {
        return this.mViewY;
    }

    public void onDispose() {
        MotionEvent motionEvent = this.mMotionEvent;
        this.mMotionEvent = null;
        if (motionEvent != null) {
            motionEvent.recycle();
        }
        try {
            EVENTS_POOL.release(this);
        } catch (IllegalStateException e2) {
            ReactSoftExceptionLogger.logSoftException(TAG, e2);
        }
    }

    public static TouchEvent obtain(int i2, int i3, TouchEventType touchEventType, MotionEvent motionEvent, long j2, float f2, float f3, TouchEventCoalescingKeyHelper touchEventCoalescingKeyHelper) {
        TouchEvent acquire = EVENTS_POOL.acquire();
        if (acquire == null) {
            acquire = new TouchEvent();
        }
        acquire.init(i2, i3, touchEventType, (MotionEvent) Assertions.assertNotNull(motionEvent), j2, f2, f3, touchEventCoalescingKeyHelper);
        return acquire;
    }
}
