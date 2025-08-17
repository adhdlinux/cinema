package com.facebook.fresco.ui.common;

import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class BaseControllerListener2<INFO> implements ControllerListener2<INFO> {
    private static final ControllerListener2 NO_OP_LISTENER = new BaseControllerListener2();

    public static <I> ControllerListener2<I> getNoOpListener() {
        return NO_OP_LISTENER;
    }

    public void onFailure(String str, Throwable th, ControllerListener2.Extras extras) {
    }

    public void onFinalImageSet(String str, INFO info, ControllerListener2.Extras extras) {
    }

    public void onIntermediateImageFailed(String str) {
    }

    public void onIntermediateImageSet(String str, INFO info) {
    }

    public void onRelease(String str, ControllerListener2.Extras extras) {
    }

    public void onSubmit(String str, Object obj, ControllerListener2.Extras extras) {
    }
}
