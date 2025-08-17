package com.facebook.fresco.ui.common;

import android.util.Log;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.infer.annotation.Nullsafe;
import java.util.ArrayList;
import java.util.List;

@Nullsafe(Nullsafe.Mode.STRICT)
public class ForwardingControllerListener2<I> extends BaseControllerListener2<I> {
    private static final String TAG = "FwdControllerListener2";
    private final List<ControllerListener2<I>> mListeners = new ArrayList(2);

    private synchronized void onException(String str, Throwable th) {
        Log.e(TAG, str, th);
    }

    public synchronized void addListener(ControllerListener2<I> controllerListener2) {
        this.mListeners.add(controllerListener2);
    }

    public void onFailure(String str, Throwable th, ControllerListener2.Extras extras) {
        int size = this.mListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                ControllerListener2 controllerListener2 = this.mListeners.get(i2);
                if (controllerListener2 != null) {
                    controllerListener2.onFailure(str, th, extras);
                }
            } catch (Exception e2) {
                onException("ForwardingControllerListener2 exception in onFailure", e2);
            }
        }
    }

    public void onFinalImageSet(String str, I i2, ControllerListener2.Extras extras) {
        int size = this.mListeners.size();
        for (int i3 = 0; i3 < size; i3++) {
            try {
                ControllerListener2 controllerListener2 = this.mListeners.get(i3);
                if (controllerListener2 != null) {
                    controllerListener2.onFinalImageSet(str, i2, extras);
                }
            } catch (Exception e2) {
                onException("ForwardingControllerListener2 exception in onFinalImageSet", e2);
            }
        }
    }

    public void onRelease(String str, ControllerListener2.Extras extras) {
        int size = this.mListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                ControllerListener2 controllerListener2 = this.mListeners.get(i2);
                if (controllerListener2 != null) {
                    controllerListener2.onRelease(str, extras);
                }
            } catch (Exception e2) {
                onException("ForwardingControllerListener2 exception in onRelease", e2);
            }
        }
    }

    public void onSubmit(String str, Object obj, ControllerListener2.Extras extras) {
        int size = this.mListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                ControllerListener2 controllerListener2 = this.mListeners.get(i2);
                if (controllerListener2 != null) {
                    controllerListener2.onSubmit(str, obj, extras);
                }
            } catch (Exception e2) {
                onException("ForwardingControllerListener2 exception in onSubmit", e2);
            }
        }
    }

    public synchronized void removeAllListeners() {
        this.mListeners.clear();
    }

    public synchronized void removeListener(ControllerListener2<I> controllerListener2) {
        int indexOf = this.mListeners.indexOf(controllerListener2);
        if (indexOf != -1) {
            this.mListeners.remove(indexOf);
        }
    }
}
