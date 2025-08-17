package com.facebook.ads.internal.view;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import androidx.core.graphics.ColorUtils;
import com.facebook.ads.internal.adapters.a.d;
import com.facebook.ads.internal.adapters.a.i;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.q.c.g;
import com.facebook.ads.internal.view.component.CircularProgressView;
import com.facebook.ads.internal.view.f.a;
import com.facebook.ads.internal.view.f.a.b;
import com.facebook.ads.internal.view.f.b.c;
import com.facebook.ads.internal.view.f.b.n;
import com.facebook.ads.internal.view.f.b.o;

public class f extends LinearLayout implements b {

    /* renamed from: c  reason: collision with root package name */
    private static final float f21198c;

    /* renamed from: d  reason: collision with root package name */
    private static final int f21199d;

    /* renamed from: e  reason: collision with root package name */
    private static final int f21200e;

    /* renamed from: f  reason: collision with root package name */
    private static final int f21201f;

    /* renamed from: g  reason: collision with root package name */
    private static final int f21202g;

    /* renamed from: h  reason: collision with root package name */
    private static final int f21203h;

    /* renamed from: i  reason: collision with root package name */
    private static final int f21204i;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final o f21205a = new o() {
        public void a(n nVar) {
            if (f.this.f21214q != null && f.this.f21215r != 0 && f.this.f21210m.isShown()) {
                float currentPositionInMillis = ((float) f.this.f21214q.getCurrentPositionInMillis()) / Math.min(((float) f.this.f21215r) * 1000.0f, (float) f.this.f21214q.getDuration());
                f.this.setProgress(100.0f * currentPositionInMillis);
                if (currentPositionInMillis >= 1.0f) {
                    f.this.a(true);
                    f.this.f21214q.getEventBus().b((T[]) new com.facebook.ads.internal.j.f[]{f.this.f21205a, f.this.f21206b});
                }
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final c f21206b = new c() {
        public void a(com.facebook.ads.internal.view.f.b.b bVar) {
            if (f.this.f21214q != null && f.this.f21215r != 0 && f.this.f21210m.isShown() && !f.this.f21217t) {
                f.this.a(true);
                f.this.f21214q.getEventBus().b((T[]) new com.facebook.ads.internal.j.f[]{f.this.f21205a, f.this.f21206b});
            }
        }
    };

    /* renamed from: j  reason: collision with root package name */
    private final ImageView f21207j;

    /* renamed from: k  reason: collision with root package name */
    private final FrameLayout f21208k;

    /* renamed from: l  reason: collision with root package name */
    private final ImageView f21209l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final CircularProgressView f21210m;

    /* renamed from: n  reason: collision with root package name */
    private final com.facebook.ads.internal.view.c.c f21211n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public final PopupMenu f21212o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public a f21213p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public a f21214q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public int f21215r = 0;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public boolean f21216s = false;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public boolean f21217t = false;

    /* renamed from: u  reason: collision with root package name */
    private PopupMenu.OnDismissListener f21218u;

    public interface a {
        void a();
    }

    static {
        float f2 = Resources.getSystem().getDisplayMetrics().density;
        f21198c = f2;
        f21199d = (int) (40.0f * f2);
        f21200e = (int) (44.0f * f2);
        int i2 = (int) (10.0f * f2);
        f21201f = i2;
        int i3 = (int) (f2 * 16.0f);
        f21202g = i3;
        f21203h = i3 - i2;
        f21204i = (i3 * 2) - i2;
    }

    public f(Context context) {
        super(context);
        setGravity(16);
        this.f21218u = new PopupMenu.OnDismissListener() {
            public void onDismiss(PopupMenu popupMenu) {
                boolean unused = f.this.f21216s = false;
            }
        };
        ImageView imageView = new ImageView(context);
        this.f21209l = imageView;
        int i2 = f21201f;
        imageView.setPadding(i2, i2, i2, i2);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setImageBitmap(com.facebook.ads.internal.q.b.c.a(com.facebook.ads.internal.q.b.b.INTERSTITIAL_CLOSE));
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (f.this.f21213p != null && f.this.f21217t) {
                    f.this.f21213p.a();
                }
            }
        });
        CircularProgressView circularProgressView = new CircularProgressView(context);
        this.f21210m = circularProgressView;
        circularProgressView.setPadding(i2, i2, i2, i2);
        circularProgressView.setProgress(0.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i3 = f21203h;
        layoutParams.setMargins(i3, i3, f21204i, i3);
        int i4 = f21200e;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i4, i4);
        FrameLayout frameLayout = new FrameLayout(context);
        this.f21208k = frameLayout;
        frameLayout.setLayoutTransition(new LayoutTransition());
        frameLayout.addView(imageView, layoutParams2);
        frameLayout.addView(circularProgressView, layoutParams2);
        addView(frameLayout, layoutParams);
        com.facebook.ads.internal.view.c.c cVar = new com.facebook.ads.internal.view.c.c(context);
        this.f21211n = cVar;
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
        layoutParams3.gravity = 17;
        layoutParams3.weight = 1.0f;
        addView(cVar, layoutParams3);
        ImageView imageView2 = new ImageView(context);
        this.f21207j = imageView2;
        imageView2.setPadding(i2, i2, i2, i2);
        imageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView2.setImageBitmap(com.facebook.ads.internal.q.b.c.a(com.facebook.ads.internal.q.b.b.INTERSTITIAL_AD_CHOICES));
        imageView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                f.this.f21212o.show();
                boolean unused = f.this.f21216s = true;
            }
        });
        PopupMenu popupMenu = new PopupMenu(context, imageView2);
        this.f21212o = popupMenu;
        popupMenu.getMenu().add("Ad Choices");
        int i5 = f21199d;
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i5, i5);
        int i6 = f21202g;
        layoutParams4.setMargins(0, i6 / 2, i6 / 2, i6 / 2);
        addView(imageView2, layoutParams4);
    }

    public void a(d dVar, boolean z2) {
        int a2 = dVar.a(z2);
        this.f21211n.a(dVar.g(z2), a2);
        this.f21207j.setColorFilter(a2);
        this.f21209l.setColorFilter(a2);
        this.f21210m.a(ColorUtils.p(a2, 77), a2);
        if (z2) {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1778384896, 0});
            gradientDrawable.setCornerRadius(0.0f);
            x.a((View) this, (Drawable) gradientDrawable);
            return;
        }
        x.a((View) this, 0);
    }

    public void a(final i iVar, final String str, int i2) {
        this.f21215r = i2;
        this.f21211n.setPageDetails(iVar);
        this.f21212o.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem menuItem) {
                boolean unused = f.this.f21216s = false;
                if (TextUtils.isEmpty(iVar.c())) {
                    return true;
                }
                g.a(new g(), f.this.getContext(), Uri.parse(iVar.c()), str);
                return true;
            }
        });
        this.f21212o.setOnDismissListener(this.f21218u);
        a(i2 <= 0);
    }

    public void a(a aVar) {
        this.f21214q = aVar;
        aVar.getEventBus().a((T[]) new com.facebook.ads.internal.j.f[]{this.f21205a, this.f21206b});
    }

    public void a(boolean z2) {
        this.f21217t = z2;
        int i2 = 0;
        this.f21208k.setVisibility(0);
        this.f21210m.setVisibility(z2 ? 4 : 0);
        ImageView imageView = this.f21209l;
        if (!z2) {
            i2 = 4;
        }
        imageView.setVisibility(i2);
    }

    public boolean a() {
        return this.f21217t;
    }

    public void b() {
        this.f21217t = false;
        this.f21208k.setVisibility(4);
        this.f21210m.setVisibility(4);
        this.f21209l.setVisibility(4);
    }

    public void b(a aVar) {
        a aVar2 = this.f21214q;
        if (aVar2 != null) {
            aVar2.getEventBus().b((T[]) new com.facebook.ads.internal.j.f[]{this.f21205a, this.f21206b});
            this.f21214q = null;
        }
    }

    public void c() {
        this.f21211n.setVisibility(4);
    }

    public void d() {
        this.f21212o.setOnDismissListener((PopupMenu.OnDismissListener) null);
        this.f21212o.dismiss();
        this.f21212o.setOnDismissListener(this.f21218u);
    }

    public void e() {
        if (this.f21216s) {
            this.f21212o.show();
        }
    }

    public void setProgress(float f2) {
        this.f21210m.setProgressWithAnimation(f2);
    }

    public void setShowPageDetails(boolean z2) {
        this.f21211n.setVisibility(z2 ? 0 : 4);
    }

    public void setToolbarListener(a aVar) {
        this.f21213p = aVar;
    }
}
