package com.startapp;

import android.view.View;
import com.startapp.hc;
import com.startapp.sdk.ads.video.VideoMode;

public final class gc implements View.OnLayoutChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ hc.b f34594a;

    public gc(hc.b bVar) {
        this.f34594a = bVar;
    }

    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        a6 a6Var = (a6) this.f34594a;
        VideoMode videoMode = a6Var.f34188a;
        videoMode.X = true;
        if (videoMode.W && videoMode.E()) {
            a6Var.f34188a.B();
        }
    }
}
