package com.facebook.react.uimanager;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.TouchTargetHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.PointerEvent;
import com.facebook.react.uimanager.events.PointerEventHelper;
import com.facebook.react.uimanager.events.TouchEventCoalescingKeyHelper;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class JSPointerDispatcher {
    private static final float ONMOVE_EPSILON = 1.0f;
    private int mChildHandlingNativeGesture = -1;
    private long mDownStartTime = Long.MIN_VALUE;
    private long mHoverInteractionKey = Long.MIN_VALUE;
    private final float[] mLastEventCoordinates = new float[2];
    private List<TouchTargetHelper.ViewTarget> mLastHitPath = Collections.emptyList();
    private final ViewGroup mRootViewGroup;
    private final float[] mTargetCoordinates = new float[2];
    private final TouchEventCoalescingKeyHelper mTouchEventCoalescingKeyHelper = new TouchEventCoalescingKeyHelper();

    public JSPointerDispatcher(ViewGroup viewGroup) {
        this.mRootViewGroup = viewGroup;
    }

    private void dispatchCancelEvent(List<TouchTargetHelper.ViewTarget> list, MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        boolean z2;
        if (this.mChildHandlingNativeGesture == -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.assertCondition(z2, "Expected to not have already sent a cancel for this gesture");
        int surfaceId = UIManagerHelper.getSurfaceId((View) this.mRootViewGroup);
        if (!list.isEmpty()) {
            ((EventDispatcher) Assertions.assertNotNull(eventDispatcher)).dispatchEvent(PointerEvent.obtain(PointerEventHelper.POINTER_CANCEL, surfaceId, list.get(0).getViewId(), motionEvent));
            for (TouchTargetHelper.ViewTarget viewId : list) {
                eventDispatcher.dispatchEvent(PointerEvent.obtain(PointerEventHelper.POINTER_LEAVE, surfaceId, viewId.getViewId(), motionEvent));
            }
        }
        this.mTouchEventCoalescingKeyHelper.removeCoalescingKey(this.mDownStartTime);
        this.mDownStartTime = Long.MIN_VALUE;
    }

    private int findTargetTagAndSetCoordinates(MotionEvent motionEvent) {
        return TouchTargetHelper.findTargetTagAndCoordinatesForTouch(motionEvent.getX(), motionEvent.getY(), this.mRootViewGroup, this.mTargetCoordinates, (int[]) null);
    }

    private void handleHoverEvent(MotionEvent motionEvent, EventDispatcher eventDispatcher, int i2, List<TouchTargetHelper.ViewTarget> list) {
        boolean z2;
        int i3;
        boolean z3;
        if (motionEvent.getActionMasked() == 7) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (Math.abs(this.mLastEventCoordinates[0] - x2) > 1.0f || Math.abs(this.mLastEventCoordinates[1] - y2) > 1.0f) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (this.mHoverInteractionKey < 0) {
                    long eventTime = motionEvent.getEventTime();
                    this.mHoverInteractionKey = eventTime;
                    this.mTouchEventCoalescingKeyHelper.addCoalescingKey(eventTime);
                }
                if (this.mChildHandlingNativeGesture > 0) {
                    Iterator<TouchTargetHelper.ViewTarget> it2 = list.iterator();
                    int i4 = 0;
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        } else if (it2.next().getViewId() == this.mChildHandlingNativeGesture) {
                            list.subList(0, i4).clear();
                            break;
                        } else {
                            i4++;
                        }
                    }
                }
                if (list.isEmpty()) {
                    i3 = -1;
                } else {
                    i3 = list.get(0).getViewId();
                }
                if (i3 != -1) {
                    int i5 = 0;
                    while (i5 < Math.min(list.size(), this.mLastHitPath.size())) {
                        List<TouchTargetHelper.ViewTarget> list2 = this.mLastHitPath;
                        if (!list.get((list.size() - 1) - i5).equals(list2.get((list2.size() - 1) - i5))) {
                            break;
                        }
                        i5++;
                    }
                    if (i5 < Math.max(list.size(), this.mLastHitPath.size())) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        this.mTouchEventCoalescingKeyHelper.incrementCoalescingKey(this.mHoverInteractionKey);
                        List<TouchTargetHelper.ViewTarget> subList = list.subList(0, list.size() - i5);
                        if (subList.size() > 0) {
                            int size = subList.size();
                            while (true) {
                                int i6 = size - 1;
                                if (size <= 0) {
                                    break;
                                }
                                eventDispatcher.dispatchEvent(PointerEvent.obtain(PointerEventHelper.POINTER_ENTER, i2, subList.get(i6).getViewId(), motionEvent));
                                size = i6;
                            }
                        }
                        List<TouchTargetHelper.ViewTarget> list3 = this.mLastHitPath;
                        List<TouchTargetHelper.ViewTarget> subList2 = list3.subList(0, list3.size() - i5);
                        if (subList2.size() > 0) {
                            for (TouchTargetHelper.ViewTarget viewId : subList2) {
                                eventDispatcher.dispatchEvent(PointerEvent.obtain(PointerEventHelper.POINTER_LEAVE, i2, viewId.getViewId(), motionEvent));
                            }
                        }
                    }
                    eventDispatcher.dispatchEvent(PointerEvent.obtain(PointerEventHelper.POINTER_MOVE, i2, i3, motionEvent, this.mTouchEventCoalescingKeyHelper.getCoalescingKey(this.mHoverInteractionKey)));
                    this.mLastHitPath = list;
                    float[] fArr = this.mLastEventCoordinates;
                    fArr[0] = x2;
                    fArr[1] = y2;
                }
            }
        }
    }

    public void handleMotionEvent(MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        boolean supportsHover = PointerEventHelper.supportsHover(motionEvent.getToolType(motionEvent.getActionIndex()));
        int surfaceId = UIManagerHelper.getSurfaceId((View) this.mRootViewGroup);
        int actionMasked = motionEvent.getActionMasked();
        List<TouchTargetHelper.ViewTarget> findTargetPathAndCoordinatesForTouch = TouchTargetHelper.findTargetPathAndCoordinatesForTouch(motionEvent.getX(), motionEvent.getY(), this.mRootViewGroup, this.mTargetCoordinates);
        if (!findTargetPathAndCoordinatesForTouch.isEmpty()) {
            int viewId = findTargetPathAndCoordinatesForTouch.get(0).getViewId();
            if (supportsHover) {
                if (actionMasked == 7) {
                    handleHoverEvent(motionEvent, eventDispatcher, surfaceId, findTargetPathAndCoordinatesForTouch);
                    return;
                } else if (actionMasked == 10 || actionMasked == 9) {
                    return;
                }
            }
            if (actionMasked == 0) {
                this.mChildHandlingNativeGesture = -1;
                long eventTime = motionEvent.getEventTime();
                this.mDownStartTime = eventTime;
                this.mTouchEventCoalescingKeyHelper.addCoalescingKey(eventTime);
                if (!supportsHover) {
                    int size = findTargetPathAndCoordinatesForTouch.size();
                    while (true) {
                        int i2 = size - 1;
                        if (size <= 0) {
                            break;
                        }
                        eventDispatcher.dispatchEvent(PointerEvent.obtain(PointerEventHelper.POINTER_ENTER, surfaceId, findTargetPathAndCoordinatesForTouch.get(i2).getViewId(), motionEvent));
                        size = i2;
                    }
                }
                eventDispatcher.dispatchEvent(PointerEvent.obtain(PointerEventHelper.POINTER_DOWN, surfaceId, viewId, motionEvent));
            } else if (this.mChildHandlingNativeGesture == -1) {
                if (actionMasked == 5) {
                    this.mTouchEventCoalescingKeyHelper.incrementCoalescingKey(this.mDownStartTime);
                    eventDispatcher.dispatchEvent(PointerEvent.obtain(PointerEventHelper.POINTER_DOWN, surfaceId, viewId, motionEvent));
                } else if (actionMasked == 2) {
                    eventDispatcher.dispatchEvent(PointerEvent.obtain(PointerEventHelper.POINTER_MOVE, surfaceId, viewId, motionEvent, this.mTouchEventCoalescingKeyHelper.getCoalescingKey(this.mDownStartTime)));
                } else if (actionMasked == 6) {
                    this.mTouchEventCoalescingKeyHelper.incrementCoalescingKey(this.mDownStartTime);
                    eventDispatcher.dispatchEvent(PointerEvent.obtain(PointerEventHelper.POINTER_UP, surfaceId, viewId, motionEvent));
                } else if (actionMasked == 1) {
                    this.mTouchEventCoalescingKeyHelper.removeCoalescingKey(this.mDownStartTime);
                    this.mDownStartTime = Long.MIN_VALUE;
                    eventDispatcher.dispatchEvent(PointerEvent.obtain(PointerEventHelper.POINTER_UP, surfaceId, viewId, motionEvent));
                    if (!supportsHover) {
                        for (int i3 = 0; i3 < findTargetPathAndCoordinatesForTouch.size(); i3++) {
                            eventDispatcher.dispatchEvent(PointerEvent.obtain(PointerEventHelper.POINTER_LEAVE, surfaceId, findTargetPathAndCoordinatesForTouch.get(i3).getViewId(), motionEvent));
                        }
                    }
                } else if (actionMasked == 3) {
                    dispatchCancelEvent(findTargetPathAndCoordinatesForTouch, motionEvent, eventDispatcher);
                } else {
                    FLog.w(ReactConstants.TAG, "Warning : Motion Event was ignored. Action=" + actionMasked + " Target=" + viewId + " Supports Hover=" + supportsHover);
                }
            }
        }
    }

    public void onChildEndedNativeGesture() {
        this.mChildHandlingNativeGesture = -1;
    }

    public void onChildStartedNativeGesture(View view, MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        if (this.mChildHandlingNativeGesture == -1 && view != null) {
            dispatchCancelEvent(TouchTargetHelper.findTargetPathAndCoordinatesForTouch(motionEvent.getX(), motionEvent.getY(), this.mRootViewGroup, this.mTargetCoordinates), motionEvent, eventDispatcher);
            this.mChildHandlingNativeGesture = view.getId();
        }
    }
}
