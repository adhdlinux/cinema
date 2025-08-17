package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.transition.Transition;

public interface Target<R> extends LifecycleListener {
    public static final int SIZE_ORIGINAL = Integer.MIN_VALUE;

    Request getRequest();

    void getSize(SizeReadyCallback sizeReadyCallback);

    /* synthetic */ void onDestroy();

    void onLoadCleared(Drawable drawable);

    void onLoadFailed(Drawable drawable);

    void onLoadStarted(Drawable drawable);

    void onResourceReady(R r2, Transition<? super R> transition);

    /* synthetic */ void onStart();

    /* synthetic */ void onStop();

    void removeCallback(SizeReadyCallback sizeReadyCallback);

    void setRequest(Request request);
}
