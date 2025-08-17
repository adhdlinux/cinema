package com.facebook.react.uimanager.events;

import android.view.MotionEvent;
import androidx.core.util.Pools$SynchronizedPool;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.WritableMap;
import java.util.ArrayList;

public class PointerEvent extends Event<PointerEvent> {
    private static final Pools$SynchronizedPool<PointerEvent> EVENTS_POOL = new Pools$SynchronizedPool<>(6);
    private static final int POINTER_EVENTS_POOL_SIZE = 6;
    private static final String TAG = "PointerEvent";
    private static final int UNSET_COALESCING_KEY = -1;
    private int mCoalescingKey = -1;
    private String mEventName;
    private MotionEvent mMotionEvent;

    private PointerEvent() {
    }

    private WritableMap createPointerEvent(int i2) {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("pointerId", (double) this.mMotionEvent.getPointerId(i2));
        createMap.putDouble("pressure", (double) this.mMotionEvent.getPressure(i2));
        createMap.putString("pointerType", PointerEventHelper.getW3CPointerType(this.mMotionEvent.getToolType(i2)));
        createMap.putDouble("clientX", (double) this.mMotionEvent.getX(i2));
        createMap.putDouble("clientY", (double) this.mMotionEvent.getY(i2));
        createMap.putInt(TouchesHelper.TARGET_KEY, getViewTag());
        createMap.putDouble("timestamp", (double) getTimestampMs());
        return createMap;
    }

    private ArrayList<WritableMap> createPointerEvents() {
        MotionEvent motionEvent = this.mMotionEvent;
        ArrayList<WritableMap> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < motionEvent.getPointerCount(); i2++) {
            arrayList.add(createPointerEvent(i2));
        }
        return arrayList;
    }

    private void init(String str, int i2, int i3, MotionEvent motionEvent, int i4) {
        super.init(i2, i3, motionEvent.getEventTime());
        this.mEventName = str;
        this.mMotionEvent = MotionEvent.obtain(motionEvent);
        this.mCoalescingKey = i4;
    }

    public static PointerEvent obtain(String str, int i2, int i3, MotionEvent motionEvent) {
        PointerEvent acquire = EVENTS_POOL.acquire();
        if (acquire == null) {
            acquire = new PointerEvent();
        }
        acquire.init(str, i2, i3, (MotionEvent) Assertions.assertNotNull(motionEvent), 0);
        return acquire;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dispatchModern(com.facebook.react.uimanager.events.RCTModernEventEmitter r15) {
        /*
            r14 = this;
            android.view.MotionEvent r0 = r14.mMotionEvent
            if (r0 != 0) goto L_0x0011
            java.lang.String r15 = TAG
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Cannot dispatch a Pointer that has no MotionEvent; the PointerEvehas been recycled"
            r0.<init>(r1)
            com.facebook.react.bridge.ReactSoftExceptionLogger.logSoftException(r15, r0)
            return
        L_0x0011:
            int r0 = r0.getActionIndex()
            java.lang.String r1 = r14.mEventName
            r1.hashCode()
            int r2 = r1.hashCode()
            r3 = -1
            r4 = 0
            r5 = 1
            switch(r2) {
                case -1779094471: goto L_0x005d;
                case -1304584214: goto L_0x0052;
                case -1065042973: goto L_0x0047;
                case 383186882: goto L_0x003c;
                case 452631970: goto L_0x0031;
                case 644174243: goto L_0x0026;
                default: goto L_0x0024;
            }
        L_0x0024:
            r1 = -1
            goto L_0x0067
        L_0x0026:
            java.lang.String r2 = "topPointerLeave2"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x002f
            goto L_0x0024
        L_0x002f:
            r1 = 5
            goto L_0x0067
        L_0x0031:
            java.lang.String r2 = "topPointerEnter2"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x003a
            goto L_0x0024
        L_0x003a:
            r1 = 4
            goto L_0x0067
        L_0x003c:
            java.lang.String r2 = "topPointerCancel"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0045
            goto L_0x0024
        L_0x0045:
            r1 = 3
            goto L_0x0067
        L_0x0047:
            java.lang.String r2 = "topPointerUp"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0050
            goto L_0x0024
        L_0x0050:
            r1 = 2
            goto L_0x0067
        L_0x0052:
            java.lang.String r2 = "topPointerDown"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x005b
            goto L_0x0024
        L_0x005b:
            r1 = 1
            goto L_0x0067
        L_0x005d:
            java.lang.String r2 = "topPointerMove2"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0066
            goto L_0x0024
        L_0x0066:
            r1 = 0
        L_0x0067:
            switch(r1) {
                case 0: goto L_0x0079;
                case 1: goto L_0x006c;
                case 2: goto L_0x006c;
                case 3: goto L_0x0079;
                case 4: goto L_0x006c;
                case 5: goto L_0x006c;
                default: goto L_0x006a;
            }
        L_0x006a:
            r0 = 0
            goto L_0x007d
        L_0x006c:
            com.facebook.react.bridge.WritableMap[] r1 = new com.facebook.react.bridge.WritableMap[r5]
            com.facebook.react.bridge.WritableMap r0 = r14.createPointerEvent(r0)
            r1[r4] = r0
            java.util.List r0 = java.util.Arrays.asList(r1)
            goto L_0x007d
        L_0x0079:
            java.util.ArrayList r0 = r14.createPointerEvents()
        L_0x007d:
            if (r0 != 0) goto L_0x0080
            return
        L_0x0080:
            int r1 = r0.size()
            if (r1 <= r5) goto L_0x0088
            r1 = 1
            goto L_0x0089
        L_0x0088:
            r1 = 0
        L_0x0089:
            java.util.Iterator r0 = r0.iterator()
        L_0x008d:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00ba
            java.lang.Object r2 = r0.next()
            com.facebook.react.bridge.WritableMap r2 = (com.facebook.react.bridge.WritableMap) r2
            if (r1 == 0) goto L_0x009f
            com.facebook.react.bridge.WritableMap r2 = r2.copy()
        L_0x009f:
            r12 = r2
            int r7 = r14.getSurfaceId()
            int r8 = r14.getViewTag()
            java.lang.String r9 = r14.mEventName
            int r11 = r14.mCoalescingKey
            if (r11 == r3) goto L_0x00b0
            r10 = 1
            goto L_0x00b1
        L_0x00b0:
            r10 = 0
        L_0x00b1:
            int r13 = com.facebook.react.uimanager.events.PointerEventHelper.getEventCategory(r9)
            r6 = r15
            r6.receiveEvent(r7, r8, r9, r10, r11, r12, r13)
            goto L_0x008d
        L_0x00ba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.events.PointerEvent.dispatchModern(com.facebook.react.uimanager.events.RCTModernEventEmitter):void");
    }

    public String getEventName() {
        return this.mEventName;
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

    public static PointerEvent obtain(String str, int i2, int i3, MotionEvent motionEvent, int i4) {
        PointerEvent acquire = EVENTS_POOL.acquire();
        if (acquire == null) {
            acquire = new PointerEvent();
        }
        acquire.init(str, i2, i3, (MotionEvent) Assertions.assertNotNull(motionEvent), i4);
        return acquire;
    }
}
