package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import android.util.Log;
import com.facebook.fresco.ui.common.DimensionsInfo;
import com.facebook.fresco.ui.common.OnDrawControllerListener;
import java.util.ArrayList;
import java.util.List;

public class ForwardingControllerListener<INFO> implements ControllerListener<INFO>, OnDrawControllerListener<INFO> {
    private static final String TAG = "FdingControllerListener";
    private final List<ControllerListener<? super INFO>> mListeners = new ArrayList(2);

    public static <INFO> ForwardingControllerListener<INFO> create() {
        return new ForwardingControllerListener<>();
    }

    public static <INFO> ForwardingControllerListener<INFO> of(ControllerListener<? super INFO> controllerListener) {
        ForwardingControllerListener<INFO> create = create();
        create.addListener(controllerListener);
        return create;
    }

    private synchronized void onException(String str, Throwable th) {
        Log.e(TAG, str, th);
    }

    public synchronized void addListener(ControllerListener<? super INFO> controllerListener) {
        this.mListeners.add(controllerListener);
    }

    public synchronized void clearListeners() {
        this.mListeners.clear();
    }

    public synchronized void onFailure(String str, Throwable th) {
        int size = this.mListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                ControllerListener controllerListener = this.mListeners.get(i2);
                if (controllerListener != null) {
                    controllerListener.onFailure(str, th);
                }
            } catch (Exception e2) {
                onException("InternalListener exception in onFailure", e2);
            }
        }
    }

    public synchronized void onFinalImageSet(String str, INFO info, Animatable animatable) {
        int size = this.mListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                ControllerListener controllerListener = this.mListeners.get(i2);
                if (controllerListener != null) {
                    controllerListener.onFinalImageSet(str, info, animatable);
                }
            } catch (Exception e2) {
                onException("InternalListener exception in onFinalImageSet", e2);
            }
        }
    }

    public void onImageDrawn(String str, INFO info, DimensionsInfo dimensionsInfo) {
        int size = this.mListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                ControllerListener controllerListener = this.mListeners.get(i2);
                if (controllerListener instanceof OnDrawControllerListener) {
                    ((OnDrawControllerListener) controllerListener).onImageDrawn(str, info, dimensionsInfo);
                }
            } catch (Exception e2) {
                onException("InternalListener exception in onImageDrawn", e2);
            }
        }
    }

    public void onIntermediateImageFailed(String str, Throwable th) {
        int size = this.mListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                ControllerListener controllerListener = this.mListeners.get(i2);
                if (controllerListener != null) {
                    controllerListener.onIntermediateImageFailed(str, th);
                }
            } catch (Exception e2) {
                onException("InternalListener exception in onIntermediateImageFailed", e2);
            }
        }
    }

    public void onIntermediateImageSet(String str, INFO info) {
        int size = this.mListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                ControllerListener controllerListener = this.mListeners.get(i2);
                if (controllerListener != null) {
                    controllerListener.onIntermediateImageSet(str, info);
                }
            } catch (Exception e2) {
                onException("InternalListener exception in onIntermediateImageSet", e2);
            }
        }
    }

    public synchronized void onRelease(String str) {
        int size = this.mListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                ControllerListener controllerListener = this.mListeners.get(i2);
                if (controllerListener != null) {
                    controllerListener.onRelease(str);
                }
            } catch (Exception e2) {
                onException("InternalListener exception in onRelease", e2);
            }
        }
    }

    public synchronized void onSubmit(String str, Object obj) {
        int size = this.mListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                ControllerListener controllerListener = this.mListeners.get(i2);
                if (controllerListener != null) {
                    controllerListener.onSubmit(str, obj);
                }
            } catch (Exception e2) {
                onException("InternalListener exception in onSubmit", e2);
            }
        }
    }

    public synchronized void removeListener(ControllerListener<? super INFO> controllerListener) {
        int indexOf = this.mListeners.indexOf(controllerListener);
        if (indexOf != -1) {
            this.mListeners.set(indexOf, (Object) null);
        }
    }

    public static <INFO> ForwardingControllerListener<INFO> of(ControllerListener<? super INFO> controllerListener, ControllerListener<? super INFO> controllerListener2) {
        ForwardingControllerListener<INFO> create = create();
        create.addListener(controllerListener);
        create.addListener(controllerListener2);
        return create;
    }
}
