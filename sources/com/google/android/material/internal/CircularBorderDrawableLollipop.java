package com.google.android.material.internal;

import android.graphics.Outline;

public class CircularBorderDrawableLollipop extends CircularBorderDrawable {
    public void getOutline(Outline outline) {
        copyBounds(this.f29816b);
        outline.setOval(this.f29816b);
    }
}
