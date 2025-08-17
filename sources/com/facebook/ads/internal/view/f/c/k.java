package com.facebook.ads.internal.view.f.c;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.j.f;
import com.facebook.ads.internal.view.f.a.c;
import com.facebook.ads.internal.view.f.b.l;

public class k extends c {

    /* renamed from: a  reason: collision with root package name */
    private final f<l> f21446a;

    public k(Context context) {
        this(context, (AttributeSet) null);
    }

    public k(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public k(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f21446a = new f<l>() {
            public Class<l> a() {
                return l.class;
            }

            public void a(l lVar) {
                k.this.setVisibility(8);
            }
        };
        int applyDimension = (int) TypedValue.applyDimension(1, 40.0f, getResources().getDisplayMetrics());
        ProgressBar progressBar = new ProgressBar(getContext());
        progressBar.setIndeterminate(true);
        progressBar.getIndeterminateDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_IN);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(applyDimension, applyDimension);
        layoutParams.addRule(13);
        addView(progressBar, layoutParams);
    }

    /* access modifiers changed from: protected */
    public void a() {
        super.a();
        setVisibility(0);
        if (getVideoView() != null) {
            getVideoView().getEventBus().a(this.f21446a);
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
        if (getVideoView() != null) {
            getVideoView().getEventBus().b(this.f21446a);
        }
        setVisibility(8);
        super.b();
    }
}
