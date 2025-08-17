package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

public final class ya extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a  reason: collision with root package name */
    public final GestureDetector f19098a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f19099b;

    public ya(Context context) {
        Intrinsics.f(context, "context");
        this.f19098a = new GestureDetector(context, this);
    }

    public final boolean a() {
        return this.f19099b;
    }

    public final void b() {
        this.f19099b = false;
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        Intrinsics.f(motionEvent, "e");
        this.f19099b = true;
        return super.onSingleTapUp(motionEvent);
    }

    public final boolean a(MotionEvent motionEvent) {
        Intrinsics.f(motionEvent, "event");
        return this.f19098a.onTouchEvent(motionEvent);
    }
}
