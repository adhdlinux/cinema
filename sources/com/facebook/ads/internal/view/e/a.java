package com.facebook.ads.internal.view.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.adapters.a.d;
import com.facebook.ads.internal.adapters.a.k;
import com.facebook.ads.internal.m.c;
import com.facebook.ads.internal.q.a.u;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.view.a;
import com.facebook.ads.internal.view.component.e;
import com.facebook.ads.internal.view.component.h;
import com.facebook.ads.internal.view.f.b.z;
import java.util.HashMap;

public class a extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final int f21164a;

    /* renamed from: b  reason: collision with root package name */
    private static final int f21165b;

    /* renamed from: c  reason: collision with root package name */
    private final h f21166c;

    /* renamed from: d  reason: collision with root package name */
    private final ImageView f21167d;

    /* renamed from: e  reason: collision with root package name */
    private final RelativeLayout f21168e;

    /* renamed from: f  reason: collision with root package name */
    private final com.facebook.ads.internal.view.component.a f21169f;

    /* renamed from: g  reason: collision with root package name */
    private final int f21170g;

    static {
        float f2 = x.f20694b;
        f21164a = (int) (12.0f * f2);
        f21165b = (int) (f2 * 16.0f);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context, int i2, d dVar, c cVar, a.C0037a aVar, boolean z2, boolean z3, com.facebook.ads.internal.r.a aVar2, u uVar) {
        super(context);
        Context context2 = context;
        int i3 = i2;
        this.f21170g = i3;
        e eVar = new e(context2);
        this.f21167d = eVar;
        x.a((View) eVar, 0);
        x.a((View) eVar);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i3);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        layoutParams.setMargins(0, 0, f21164a, 0);
        if (z3) {
            eVar.setVisibility(8);
        }
        h hVar = new h(context, dVar, true, z2, true);
        this.f21166c = hVar;
        hVar.setAlignment(8388611);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(1, eVar.getId());
        layoutParams2.addRule(15);
        com.facebook.ads.internal.view.component.a aVar3 = r1;
        com.facebook.ads.internal.view.component.a aVar4 = new com.facebook.ads.internal.view.component.a(context, true, false, z.REWARDED_VIDEO_AD_CLICK.a(), dVar, cVar, aVar, aVar2, uVar);
        this.f21169f = aVar3;
        aVar3.setVisibility(8);
        RelativeLayout relativeLayout = new RelativeLayout(context2);
        this.f21168e = relativeLayout;
        x.a((View) relativeLayout);
        relativeLayout.addView(eVar, layoutParams);
        relativeLayout.addView(hVar, layoutParams2);
        addView(relativeLayout, new LinearLayout.LayoutParams(-2, -2));
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, -15658735});
        gradientDrawable.setCornerRadius(0.0f);
        x.a((View) this, (Drawable) gradientDrawable);
    }

    public void a() {
        this.f21169f.setVisibility(0);
    }

    public void a(int i2) {
        x.b(this.f21169f);
        int i3 = 1;
        if (i2 != 1) {
            i3 = 0;
        }
        setOrientation(i3);
        int i4 = -1;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3 != 0 ? -1 : 0, -2);
        layoutParams.weight = 1.0f;
        if (i3 == 0) {
            i4 = -2;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i4, -2);
        layoutParams2.setMargins(i3 != 0 ? 0 : f21165b, i3 != 0 ? f21165b : 0, 0, 0);
        layoutParams2.gravity = 80;
        this.f21168e.setLayoutParams(layoutParams);
        addView(this.f21169f, layoutParams2);
    }

    public void setInfo(k kVar) {
        this.f21166c.a(kVar.b().a(), kVar.b().b(), false, false);
        this.f21169f.a(kVar.c(), kVar.g(), new HashMap());
        com.facebook.ads.internal.view.b.d dVar = new com.facebook.ads.internal.view.b.d(this.f21167d);
        int i2 = this.f21170g;
        dVar.a(i2, i2).a(kVar.a().b());
    }
}
