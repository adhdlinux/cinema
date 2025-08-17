package com.facebook.ads.internal.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public class w extends View {

    /* renamed from: a  reason: collision with root package name */
    private v f21730a;

    public w(Context context, v vVar) {
        super(context);
        this.f21730a = vVar;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    public void onWindowVisibilityChanged(int i2) {
        v vVar = this.f21730a;
        if (vVar != null) {
            vVar.a(i2);
        }
    }
}
