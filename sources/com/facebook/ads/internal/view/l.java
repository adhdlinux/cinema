package com.facebook.ads.internal.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.ads.internal.n.g;
import com.facebook.ads.internal.q.a.j;

public class l extends g {

    /* renamed from: a  reason: collision with root package name */
    private s f21640a;

    public l(Context context) {
        super(context);
        s sVar = new s(context);
        this.f21640a = sVar;
        sVar.setScaleType(ImageView.ScaleType.CENTER_CROP);
        j.a(this.f21640a, j.INTERNAL_AD_MEDIA);
        addView(this.f21640a, new ViewGroup.LayoutParams(-1, -1));
    }

    public View getAdContentsView() {
        return this.f21640a;
    }
}
