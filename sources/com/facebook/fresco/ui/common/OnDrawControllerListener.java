package com.facebook.fresco.ui.common;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public interface OnDrawControllerListener<INFO> {
    void onImageDrawn(String str, INFO info, DimensionsInfo dimensionsInfo);
}
