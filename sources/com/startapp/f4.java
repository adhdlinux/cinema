package com.startapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataStyle;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class f4 extends ArrayAdapter<j4> {

    /* renamed from: a  reason: collision with root package name */
    public String f34506a;

    /* renamed from: b  reason: collision with root package name */
    public String f34507b;

    public f4(Context context, List list, String str, String str2) {
        super(context, 0, list);
        this.f34506a = str;
        this.f34507b = str2;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        k4 k4Var;
        long j2;
        if (view == null) {
            k4Var = new k4(getContext());
            view2 = k4Var.f34813a;
        } else {
            view2 = view;
            k4Var = (k4) view.getTag();
        }
        j4 j4Var = (j4) getItem(i2);
        MetaDataStyle a2 = AdsCommonMetaData.f36186h.a(j4Var.f34732q);
        boolean z2 = true;
        if (k4Var.f34819g != a2) {
            k4Var.f34819g = a2;
            k4Var.f34813a.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{a2.e().intValue(), a2.d().intValue()}));
            k4Var.f34815c.setTextSize((float) a2.h().intValue());
            k4Var.f34815c.setTextColor(a2.f().intValue());
            p.a(k4Var.f34815c, a2.g());
            k4Var.f34816d.setTextSize((float) a2.c().intValue());
            k4Var.f34816d.setTextColor(a2.a().intValue());
            p.a(k4Var.f34816d, a2.b());
        }
        k4Var.f34815c.setText(j4Var.f34722g);
        k4Var.f34816d.setText(j4Var.f34723h);
        l4 a3 = m4.f34897a.a(this.f34507b);
        Bitmap a4 = a3.f34854a.a(i2, j4Var.f34716a, j4Var.f34724i);
        if (a4 == null) {
            k4Var.f34814b.setImageResource(17301651);
            k4Var.f34814b.setTag("tag_error");
        } else {
            k4Var.f34814b.setImageBitmap(a4);
            k4Var.f34814b.setTag("tag_ok");
        }
        k4Var.f34818f.setRating(j4Var.f34725j);
        if (j4Var.f34729n == null) {
            z2 = false;
        }
        k4Var.a(z2);
        l4 a5 = m4.f34897a.a(this.f34507b);
        Context context = getContext();
        String[] strArr = j4Var.f34718c;
        TrackingParams trackingParams = new TrackingParams(this.f34506a);
        Long l2 = j4Var.f34730o;
        if (l2 != null) {
            j2 = TimeUnit.SECONDS.toMillis(l2.longValue());
        } else {
            j2 = TimeUnit.SECONDS.toMillis(MetaData.f36379h.n());
        }
        long j3 = j2;
        e4 e4Var = a5.f34854a;
        String a6 = e4Var.a(strArr, a5.f34856c);
        if (!e4Var.f34424a.containsKey(a6)) {
            z6 z6Var = new z6(context, strArr, trackingParams, j3);
            e4Var.f34424a.put(a6, z6Var);
            z6Var.b();
        }
        return view2;
    }
}
