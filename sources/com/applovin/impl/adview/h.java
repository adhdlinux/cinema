package com.applovin.impl.adview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.webkit.WebView;

@SuppressLint({"ViewConstructor"})
public class h extends WebView {

    /* renamed from: a  reason: collision with root package name */
    private PointF f14062a = new PointF();

    public h(Context context) {
        super(context);
    }

    public PointF getAndClearLastClickLocation() {
        PointF pointF = this.f14062a;
        this.f14062a = new PointF();
        return pointF;
    }

    public PointF getLastClickLocation() {
        return this.f14062a;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f14062a = new PointF(motionEvent.getRawX(), motionEvent.getRawY());
        return super.onTouchEvent(motionEvent);
    }
}
