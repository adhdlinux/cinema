package com.startapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataStyle;
import com.startapp.sdk.json.RatingBar;

public class k4 {

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f34813a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f34814b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f34815c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f34816d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f34817e;

    /* renamed from: f  reason: collision with root package name */
    public RatingBar f34818f;

    /* renamed from: g  reason: collision with root package name */
    public MetaDataStyle f34819g = null;

    public class a extends ShapeDrawable {
        public a(k4 k4Var, Shape shape) {
            super(shape);
        }

        public void onDraw(Shape shape, Canvas canvas, Paint paint) {
            paint.setColor(-11363070);
            paint.setMaskFilter(new EmbossMaskFilter(new float[]{1.0f, 1.0f, 1.0f}, 0.4f, 5.0f, 3.0f));
            super.onDraw(shape, canvas, paint);
        }
    }

    public k4(Context context) {
        Context context2 = context;
        context2.setTheme(16973829);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -2);
        this.f34813a = new RelativeLayout(context2);
        this.f34813a.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{AdsCommonMetaData.k().p(), AdsCommonMetaData.k().o()}));
        this.f34813a.setLayoutParams(layoutParams);
        int a2 = p.a(context2, 3);
        int a3 = p.a(context2, 4);
        int a4 = p.a(context2, 5);
        int a5 = p.a(context2, 6);
        int a6 = p.a(context2, 10);
        int a7 = p.a(context2, 84);
        this.f34813a.setPadding(a6, a2, a6, a2);
        this.f34813a.setTag(this);
        ImageView imageView = new ImageView(context2);
        this.f34814b = imageView;
        imageView.setId(1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a7, a7);
        layoutParams2.addRule(15);
        this.f34814b.setLayoutParams(layoutParams2);
        this.f34814b.setPadding(0, 0, a5, 0);
        TextView textView = new TextView(context2);
        this.f34815c = textView;
        textView.setId(2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(hc.a(17), 1);
        layoutParams3.addRule(6, 1);
        this.f34815c.setLayoutParams(layoutParams3);
        this.f34815c.setPadding(0, 0, 0, a4);
        this.f34815c.setTextColor(AdsCommonMetaData.k().q().intValue());
        this.f34815c.setTextSize((float) AdsCommonMetaData.k().s().intValue());
        this.f34815c.setSingleLine(true);
        this.f34815c.setEllipsize(TextUtils.TruncateAt.END);
        p.a(this.f34815c, AdsCommonMetaData.k().r());
        TextView textView2 = new TextView(context2);
        this.f34816d = textView2;
        textView2.setId(3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(hc.a(17), 1);
        layoutParams4.addRule(3, 2);
        layoutParams4.setMargins(0, 0, 0, a4);
        this.f34816d.setLayoutParams(layoutParams4);
        this.f34816d.setTextColor(AdsCommonMetaData.k().l().intValue());
        this.f34816d.setTextSize((float) AdsCommonMetaData.k().n().intValue());
        this.f34816d.setSingleLine(true);
        this.f34816d.setEllipsize(TextUtils.TruncateAt.END);
        p.a(this.f34816d, AdsCommonMetaData.k().m());
        this.f34818f = new RatingBar(context2);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(hc.a(17), 1);
        layoutParams5.addRule(8, 1);
        layoutParams5.setMargins(0, 0, 0, -a4);
        this.f34818f.setLayoutParams(layoutParams5);
        this.f34818f.setPadding(0, 0, 0, a3);
        this.f34818f.setId(5);
        this.f34817e = new TextView(context2);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(hc.a(21));
        layoutParams6.addRule(8, 1);
        this.f34817e.setLayoutParams(layoutParams6);
        a(false);
        this.f34817e.setTextColor(-1);
        this.f34817e.setTextSize(12.0f);
        this.f34817e.setTypeface((Typeface) null, 1);
        this.f34817e.setPadding(a6, a5, a6, a5);
        this.f34817e.setId(4);
        this.f34817e.setShadowLayer(2.5f, -3.0f, 3.0f, -9013642);
        this.f34817e.setBackgroundDrawable(new a(this, new RoundRectShape(new float[]{10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f}, (RectF) null, (float[]) null)));
        this.f34813a.addView(this.f34814b);
        this.f34813a.addView(this.f34815c);
        this.f34813a.addView(this.f34816d);
        this.f34813a.addView(this.f34818f);
        this.f34813a.addView(this.f34817e);
    }

    public void a(boolean z2) {
        if (z2) {
            this.f34817e.setText("Open");
        } else {
            this.f34817e.setText("Download");
        }
    }
}
