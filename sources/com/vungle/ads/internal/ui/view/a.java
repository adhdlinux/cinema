package com.vungle.ads.internal.ui.view;

import android.view.MotionEvent;
import android.view.View;

public final /* synthetic */ class a implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MRAIDAdWidget f37934b;

    public /* synthetic */ a(MRAIDAdWidget mRAIDAdWidget) {
        this.f37934b = mRAIDAdWidget;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return MRAIDAdWidget.m221bindListeners$lambda0(this.f37934b, view, motionEvent);
    }
}
