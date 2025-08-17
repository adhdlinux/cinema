package com.startapp;

import android.view.MotionEvent;
import com.startapp.sdk.ads.list3d.List3DView;

public class g4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List3DView f34556a;

    public g4(List3DView list3DView) {
        this.f34556a = list3DView;
    }

    public void run() {
        this.f34556a.dispatchTouchEvent(MotionEvent.obtain(System.currentTimeMillis(), System.currentTimeMillis(), 2, 0.0f, -20.0f, 0));
        this.f34556a.dispatchTouchEvent(MotionEvent.obtain(System.currentTimeMillis(), System.currentTimeMillis(), 1, 0.0f, -20.0f, 0));
    }
}
