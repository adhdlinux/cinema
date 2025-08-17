package com.facebook.ads.internal.view.e;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.view.component.f;

class d extends f {

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f21196a;

    public d(Context context) {
        super(context);
        ImageView imageView = new ImageView(context);
        this.f21196a = imageView;
        imageView.setAdjustViewBounds(true);
        addView(imageView, new RelativeLayout.LayoutParams(-2, -1));
    }

    public void a(String str) {
        com.facebook.ads.internal.view.b.d dVar = new com.facebook.ads.internal.view.b.d(this.f21196a);
        dVar.a();
        dVar.a(str);
    }
}
