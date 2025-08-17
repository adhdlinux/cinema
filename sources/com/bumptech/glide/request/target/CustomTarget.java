package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Util;

public abstract class CustomTarget<T> implements Target<T> {

    /* renamed from: b  reason: collision with root package name */
    private final int f17102b;

    /* renamed from: c  reason: collision with root package name */
    private final int f17103c;

    /* renamed from: d  reason: collision with root package name */
    private Request f17104d;

    public CustomTarget() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public final Request getRequest() {
        return this.f17104d;
    }

    public final void getSize(SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.onSizeReady(this.f17102b, this.f17103c);
    }

    public void onDestroy() {
    }

    public void onLoadFailed(Drawable drawable) {
    }

    public void onLoadStarted(Drawable drawable) {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public final void removeCallback(SizeReadyCallback sizeReadyCallback) {
    }

    public final void setRequest(Request request) {
        this.f17104d = request;
    }

    public CustomTarget(int i2, int i3) {
        if (Util.r(i2, i3)) {
            this.f17102b = i2;
            this.f17103c = i3;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i2 + " and height: " + i3);
    }
}
