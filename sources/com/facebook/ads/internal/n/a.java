package com.facebook.ads.internal.n;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.facebook.ads.AdIconView;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.view.component.c;
import com.facebook.ads.internal.view.component.g;
import java.util.ArrayList;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final float f20307a = x.f20694b;

    /* renamed from: b  reason: collision with root package name */
    private final k f20308b;

    /* renamed from: c  reason: collision with root package name */
    private final f f20309c;

    /* renamed from: d  reason: collision with root package name */
    private final RelativeLayout f20310d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<View> f20311e = new ArrayList<>();

    /* renamed from: com.facebook.ads.internal.n.a$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f20312a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.facebook.ads.internal.n.l[] r0 = com.facebook.ads.internal.n.l.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f20312a = r0
                com.facebook.ads.internal.n.l r1 = com.facebook.ads.internal.n.l.HEIGHT_400     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20312a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.ads.internal.n.l r1 = com.facebook.ads.internal.n.l.HEIGHT_300     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20312a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.ads.internal.n.l r1 = com.facebook.ads.internal.n.l.HEIGHT_100     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f20312a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.ads.internal.n.l r1 = com.facebook.ads.internal.n.l.HEIGHT_120     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.n.a.AnonymousClass1.<clinit>():void");
        }
    }

    /* JADX WARNING: type inference failed for: r10v0, types: [com.facebook.ads.AdIconView] */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0078, code lost:
        if (r2 != 2) goto L_0x0081;
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(android.content.Context r5, com.facebook.ads.internal.n.f r6, android.widget.RelativeLayout r7, android.widget.RelativeLayout r8, com.facebook.ads.MediaView r9, com.facebook.ads.AdIconView r10, com.facebook.ads.internal.n.l r11, com.facebook.ads.internal.n.k r12) {
        /*
            r4 = this;
            r4.<init>()
            r4.f20310d = r7
            int r0 = r12.b()
            com.facebook.ads.internal.q.a.x.a((android.view.View) r7, (int) r0)
            r4.f20308b = r12
            r4.f20309c = r6
            int r12 = r11.b()
            android.widget.RelativeLayout$LayoutParams r0 = new android.widget.RelativeLayout$LayoutParams
            float r12 = (float) r12
            float r1 = f20307a
            float r12 = r12 * r1
            int r12 = java.lang.Math.round(r12)
            r2 = -1
            r0.<init>(r2, r12)
            r7.setLayoutParams(r0)
            com.facebook.ads.internal.view.r r12 = new com.facebook.ads.internal.view.r
            r12.<init>(r5)
            r0 = 1133248512(0x438c0000, float:280.0)
            float r0 = r0 * r1
            int r0 = java.lang.Math.round(r0)
            r12.setMinWidth(r0)
            r0 = 1136361472(0x43bb8000, float:375.0)
            float r0 = r0 * r1
            int r0 = java.lang.Math.round(r0)
            r12.setMaxWidth(r0)
            android.widget.RelativeLayout$LayoutParams r0 = new android.widget.RelativeLayout$LayoutParams
            r0.<init>(r2, r2)
            r3 = 13
            r0.addRule(r3, r2)
            r12.setLayoutParams(r0)
            r7.addView(r12)
            android.widget.LinearLayout r0 = new android.widget.LinearLayout
            r0.<init>(r5)
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r4.f20311e = r5
            r5 = 1
            r0.setOrientation(r5)
            android.widget.RelativeLayout$LayoutParams r3 = new android.widget.RelativeLayout$LayoutParams
            r3.<init>(r2, r2)
            r0.setLayoutParams(r3)
            r12.addView(r0)
            int[] r2 = com.facebook.ads.internal.n.a.AnonymousClass1.f20312a
            int r3 = r11.ordinal()
            r2 = r2[r3]
            if (r2 == r5) goto L_0x007b
            r5 = 2
            if (r2 == r5) goto L_0x007e
            goto L_0x0081
        L_0x007b:
            r4.a((android.view.ViewGroup) r0)
        L_0x007e:
            r4.a(r0, r9)
        L_0x0081:
            r4.a(r0, r11, r10)
            if (r9 == 0) goto L_0x0087
            goto L_0x0088
        L_0x0087:
            r9 = r10
        L_0x0088:
            java.util.ArrayList<android.view.View> r5 = r4.f20311e
            r6.a((android.view.View) r7, (com.facebook.ads.internal.n.g) r9, (java.util.List<android.view.View>) r5)
            android.view.ViewGroup$LayoutParams r5 = r8.getLayoutParams()
            android.widget.RelativeLayout$LayoutParams r5 = (android.widget.RelativeLayout.LayoutParams) r5
            r6 = 11
            r5.addRule(r6)
            r6 = 1082130432(0x40800000, float:4.0)
            float r7 = r1 * r6
            int r7 = java.lang.Math.round(r7)
            float r9 = r1 * r6
            int r9 = java.lang.Math.round(r9)
            float r10 = r1 * r6
            int r10 = java.lang.Math.round(r10)
            float r1 = r1 * r6
            int r6 = java.lang.Math.round(r1)
            r5.setMargins(r7, r9, r10, r6)
            r12.addView(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.n.a.<init>(android.content.Context, com.facebook.ads.internal.n.f, android.widget.RelativeLayout, android.widget.RelativeLayout, com.facebook.ads.MediaView, com.facebook.ads.AdIconView, com.facebook.ads.internal.n.l, com.facebook.ads.internal.n.k):void");
    }

    private void a(ViewGroup viewGroup) {
        g gVar = new g(this.f20310d.getContext(), this.f20309c, this.f20308b);
        gVar.setLayoutParams(new LinearLayout.LayoutParams(-1, Math.round(f20307a * 110.0f)));
        viewGroup.addView(gVar);
    }

    private void a(ViewGroup viewGroup, RelativeLayout relativeLayout) {
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f20310d.getContext());
        float f2 = f20307a;
        relativeLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, Math.round(f2 * 180.0f)));
        x.a((View) relativeLayout2, this.f20308b.b());
        relativeLayout2.addView(relativeLayout);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) (f2 * 180.0f));
        layoutParams.addRule(13, -1);
        relativeLayout.setLayoutParams(layoutParams);
        viewGroup.addView(relativeLayout2);
        this.f20311e.add(relativeLayout);
    }

    private void a(ViewGroup viewGroup, l lVar, AdIconView adIconView) {
        c cVar = new c(this.f20310d.getContext(), this.f20309c, this.f20308b, adIconView, a(lVar), b(lVar));
        cVar.setLayoutParams(new LinearLayout.LayoutParams(-1, Math.round(((float) b(lVar)) * f20307a)));
        viewGroup.addView(cVar);
        this.f20311e.add(cVar.getIconView());
        this.f20311e.add(cVar.getCallToActionView());
    }

    private boolean a(l lVar) {
        return lVar == l.HEIGHT_300 || lVar == l.HEIGHT_120;
    }

    private int b(l lVar) {
        int i2 = AnonymousClass1.f20312a[lVar.ordinal()];
        if (i2 == 1) {
            return (lVar.b() - 180) / 2;
        }
        if (i2 == 2) {
            return lVar.b() - 180;
        }
        if (i2 == 3 || i2 == 4) {
            return lVar.b();
        }
        return 0;
    }

    public void a() {
        this.f20309c.J();
    }
}
