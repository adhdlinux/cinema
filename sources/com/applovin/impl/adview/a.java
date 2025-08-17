package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.applovin.sdk.AppLovinSdkUtils;

public class a extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private final ProgressBar f13845a;

    public a(Context context, int i2, int i3) {
        super(context);
        RelativeLayout.LayoutParams layoutParams;
        setClickable(false);
        ProgressBar progressBar = new ProgressBar(context, (AttributeSet) null, i3);
        this.f13845a = progressBar;
        progressBar.setIndeterminate(true);
        progressBar.setClickable(false);
        if (i2 == -2 || i2 == -1) {
            layoutParams = new RelativeLayout.LayoutParams(i2, i2);
        } else {
            int dpToPx = AppLovinSdkUtils.dpToPx(context, i2);
            layoutParams = new RelativeLayout.LayoutParams(dpToPx, dpToPx);
        }
        layoutParams.addRule(13);
        progressBar.setLayoutParams(layoutParams);
        addView(progressBar);
    }

    public void a() {
        setVisibility(0);
    }

    public void b() {
        setVisibility(8);
    }

    public void setColor(int i2) {
        this.f13845a.getIndeterminateDrawable().setColorFilter(i2, PorterDuff.Mode.SRC_IN);
    }
}
