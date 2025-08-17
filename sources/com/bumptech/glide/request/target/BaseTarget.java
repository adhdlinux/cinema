package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.Request;

@Deprecated
public abstract class BaseTarget<Z> implements Target<Z> {

    /* renamed from: b  reason: collision with root package name */
    private Request f17101b;

    public Request getRequest() {
        return this.f17101b;
    }

    public void onDestroy() {
    }

    public void onLoadCleared(Drawable drawable) {
    }

    public void onLoadFailed(Drawable drawable) {
    }

    public void onLoadStarted(Drawable drawable) {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void setRequest(Request request) {
        this.f17101b = request;
    }
}
