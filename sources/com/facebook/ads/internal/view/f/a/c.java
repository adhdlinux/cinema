package com.facebook.ads.internal.view.f.a;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.view.f.a;

public abstract class c extends RelativeLayout implements b {

    /* renamed from: a  reason: collision with root package name */
    private a f21261a;

    public c(Context context) {
        super(context);
    }

    public c(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    }

    /* access modifiers changed from: protected */
    public void a() {
    }

    public void a(a aVar) {
        this.f21261a = aVar;
        a();
    }

    /* access modifiers changed from: protected */
    public void b() {
    }

    public void b(a aVar) {
        b();
        this.f21261a = null;
    }

    /* access modifiers changed from: protected */
    public a getVideoView() {
        return this.f21261a;
    }
}
