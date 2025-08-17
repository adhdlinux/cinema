package com.applovin.impl.mediation.debugger.ui.a;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;

public class d extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private ViewGroup f14614a;

    /* renamed from: b  reason: collision with root package name */
    private AppLovinSdkUtils.Size f14615b;

    /* renamed from: c  reason: collision with root package name */
    private Activity f14616c;

    /* renamed from: d  reason: collision with root package name */
    private RelativeLayout f14617d;

    public d(ViewGroup viewGroup, AppLovinSdkUtils.Size size, Activity activity) {
        super(activity, 16973840);
        this.f14614a = viewGroup;
        this.f14615b = size;
        this.f14616c = activity;
        requestWindowFeature(1);
    }

    public void dismiss() {
        this.f14617d.removeView(this.f14614a);
        super.dismiss();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(AppLovinSdkUtils.dpToPx(this.f14616c, this.f14615b.getWidth()), AppLovinSdkUtils.dpToPx(this.f14616c, this.f14615b.getHeight()));
        layoutParams.addRule(13);
        this.f14614a.setLayoutParams(layoutParams);
        int dpToPx = AppLovinSdkUtils.dpToPx(this.f14616c, 60);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dpToPx, dpToPx);
        layoutParams2.addRule(14);
        layoutParams2.addRule(12);
        ImageButton imageButton = new ImageButton(this.f14616c);
        imageButton.setLayoutParams(layoutParams2);
        imageButton.setImageDrawable(this.f14616c.getResources().getDrawable(R.drawable.applovin_ic_x_mark));
        imageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageButton.setColorFilter(-1);
        imageButton.setBackground((Drawable) null);
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                d.this.dismiss();
            }
        });
        RelativeLayout relativeLayout = new RelativeLayout(this.f14616c);
        this.f14617d = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f14617d.setBackgroundColor(Integer.MIN_VALUE);
        this.f14617d.addView(imageButton);
        this.f14617d.addView(this.f14614a);
        this.f14617d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                d.this.dismiss();
            }
        });
        setContentView(this.f14617d);
    }
}
