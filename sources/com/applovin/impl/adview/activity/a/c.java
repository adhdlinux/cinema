package com.applovin.impl.adview.activity.a;

import android.app.Activity;
import android.view.View;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.b;

public class c extends a {
    public c(e eVar, Activity activity, m mVar) {
        super(eVar, activity, mVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x01db  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.widget.ImageView r20, com.applovin.impl.adview.m r21, com.applovin.impl.adview.t r22, com.applovin.impl.adview.a r23, android.widget.ProgressBar r24, android.view.View r25, com.applovin.adview.AppLovinAdView r26, android.view.ViewGroup r27) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = r23
            r5 = r24
            r6 = r25
            r7 = r26
            r8 = r27
            com.applovin.impl.sdk.ad.e r9 = r0.f13866c
            com.applovin.impl.sdk.ad.e$d r9 = r9.aL()
            com.applovin.impl.sdk.ad.e$d r10 = com.applovin.impl.sdk.ad.e.d.TOP
            r12 = 3
            r13 = 80
            r14 = 48
            r15 = -2
            r11 = -1
            if (r9 != r10) goto L_0x002a
            android.widget.FrameLayout$LayoutParams r9 = new android.widget.FrameLayout$LayoutParams
            r9.<init>(r11, r15, r14)
        L_0x0028:
            r10 = 5
            goto L_0x005e
        L_0x002a:
            com.applovin.impl.sdk.ad.e r9 = r0.f13866c
            com.applovin.impl.sdk.ad.e$d r9 = r9.aL()
            com.applovin.impl.sdk.ad.e$d r10 = com.applovin.impl.sdk.ad.e.d.BOTTOM
            if (r9 != r10) goto L_0x003a
            android.widget.FrameLayout$LayoutParams r9 = new android.widget.FrameLayout$LayoutParams
            r9.<init>(r11, r15, r13)
            goto L_0x0028
        L_0x003a:
            com.applovin.impl.sdk.ad.e r9 = r0.f13866c
            com.applovin.impl.sdk.ad.e$d r9 = r9.aL()
            com.applovin.impl.sdk.ad.e$d r10 = com.applovin.impl.sdk.ad.e.d.LEFT
            if (r9 != r10) goto L_0x004a
            android.widget.FrameLayout$LayoutParams r9 = new android.widget.FrameLayout$LayoutParams
            r9.<init>(r15, r11, r12)
            goto L_0x0028
        L_0x004a:
            com.applovin.impl.sdk.ad.e r9 = r0.f13866c
            com.applovin.impl.sdk.ad.e$d r9 = r9.aL()
            com.applovin.impl.sdk.ad.e$d r10 = com.applovin.impl.sdk.ad.e.d.RIGHT
            if (r9 != r10) goto L_0x005b
            android.widget.FrameLayout$LayoutParams r9 = new android.widget.FrameLayout$LayoutParams
            r10 = 5
            r9.<init>(r15, r11, r10)
            goto L_0x005e
        L_0x005b:
            r10 = 5
            android.widget.FrameLayout$LayoutParams r9 = r0.f13868e
        L_0x005e:
            com.applovin.impl.sdk.ad.e r15 = r0.f13866c
            boolean r15 = r15.aI()
            r10 = 4
            r12 = 0
            if (r15 == 0) goto L_0x009d
            android.widget.FrameLayout$LayoutParams r15 = r0.f13868e
            r7.setLayoutParams(r15)
            android.view.ViewGroup r15 = r0.f13867d
            r15.addView(r7)
            android.view.View r7 = new android.view.View
            android.app.Activity r15 = r0.f13865b
            r7.<init>(r15)
            android.widget.FrameLayout$LayoutParams r15 = r0.f13868e
            r7.setLayoutParams(r15)
            r15 = 254(0xfe, float:3.56E-43)
            int r15 = android.graphics.Color.argb(r15, r12, r12, r12)
            r7.setBackgroundColor(r15)
            com.applovin.impl.adview.activity.a.c$1 r15 = new com.applovin.impl.adview.activity.a.c$1
            r15.<init>()
            r7.setOnTouchListener(r15)
            android.view.ViewGroup r15 = r0.f13867d
            r15.addView(r7)
            r6.setLayoutParams(r9)
            android.view.ViewGroup r7 = r0.f13867d
            r7.addView(r6)
            goto L_0x00b2
        L_0x009d:
            r6.setLayoutParams(r9)
            android.view.ViewGroup r9 = r0.f13867d
            r9.addView(r6)
            android.widget.FrameLayout$LayoutParams r6 = r0.f13868e
            r7.setLayoutParams(r6)
            android.view.ViewGroup r6 = r0.f13867d
            r6.addView(r7)
            r7.setVisibility(r10)
        L_0x00b2:
            if (r3 == 0) goto L_0x0145
            com.applovin.impl.sdk.ad.e r6 = r0.f13866c
            com.applovin.impl.adview.s r6 = r6.C()
            int r7 = r6.a()
            double r11 = (double) r7
            r16 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r11 = r11 / r16
            int r7 = r6.b()
            double r13 = (double) r7
            double r13 = r13 / r16
            if (r8 == 0) goto L_0x00d7
            int r7 = r27.getWidth()
            int r16 = r27.getHeight()
            r9 = r16
            goto L_0x00e6
        L_0x00d7:
            android.app.Activity r7 = r0.f13865b
            android.graphics.Point r7 = com.applovin.impl.sdk.utils.g.a(r7)
            int r9 = r7.x
            int r7 = r7.y
            r18 = r9
            r9 = r7
            r7 = r18
        L_0x00e6:
            double r7 = (double) r7
            double r7 = r7 * r11
            int r7 = (int) r7
            double r8 = (double) r9
            double r8 = r8 * r13
            int r8 = (int) r8
            android.widget.FrameLayout$LayoutParams r9 = new android.widget.FrameLayout$LayoutParams
            int r11 = r6.d()
            r9.<init>(r7, r8, r11)
            android.app.Activity r7 = r0.f13865b
            int r8 = r6.c()
            int r7 = com.applovin.sdk.AppLovinSdkUtils.dpToPx(r7, r8)
            r9.setMargins(r7, r7, r7, r7)
            android.view.ViewGroup r7 = r0.f13867d
            r7.addView(r3, r9)
            float r7 = r6.i()
            r8 = 0
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 <= 0) goto L_0x0129
            r3.setVisibility(r10)
            float r7 = r6.i()
            long r9 = com.applovin.impl.sdk.utils.Utils.secondsToMillisLong(r7)
            long r11 = r6.g()
            com.applovin.impl.adview.activity.a.c$2 r7 = new com.applovin.impl.adview.activity.a.c$2
            r7.<init>(r3, r11)
            com.applovin.sdk.AppLovinSdkUtils.runOnUiThreadDelayed(r7, r9)
        L_0x0129:
            float r7 = r6.j()
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 <= 0) goto L_0x0145
            float r7 = r6.j()
            long r7 = com.applovin.impl.sdk.utils.Utils.secondsToMillisLong(r7)
            long r9 = r6.h()
            com.applovin.impl.adview.activity.a.c$3 r6 = new com.applovin.impl.adview.activity.a.c$3
            r6.<init>(r3, r9)
            com.applovin.sdk.AppLovinSdkUtils.runOnUiThreadDelayed(r6, r7)
        L_0x0145:
            if (r2 == 0) goto L_0x0160
            com.applovin.impl.sdk.ad.e r3 = r0.f13866c
            boolean r3 = r3.ac()
            if (r3 == 0) goto L_0x0153
            r3 = 48
            r11 = 3
            goto L_0x0156
        L_0x0153:
            r3 = 48
            r11 = 5
        L_0x0156:
            r3 = r3 | r11
            com.applovin.impl.sdk.ad.e r6 = r0.f13866c
            com.applovin.impl.sdk.ad.e$c r6 = r6.X()
            r0.a(r6, r3, r2)
        L_0x0160:
            if (r1 == 0) goto L_0x01a5
            android.app.Activity r2 = r0.f13865b
            com.applovin.impl.sdk.m r3 = r0.f13864a
            com.applovin.impl.sdk.c.b<java.lang.Integer> r6 = com.applovin.impl.sdk.c.b.cv
            java.lang.Object r3 = r3.a(r6)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            int r2 = com.applovin.sdk.AppLovinSdkUtils.dpToPx(r2, r3)
            android.widget.FrameLayout$LayoutParams r3 = new android.widget.FrameLayout$LayoutParams
            com.applovin.impl.sdk.m r6 = r0.f13864a
            com.applovin.impl.sdk.c.b<java.lang.Integer> r7 = com.applovin.impl.sdk.c.b.cx
            java.lang.Object r6 = r6.a(r7)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            r3.<init>(r2, r2, r6)
            android.app.Activity r2 = r0.f13865b
            com.applovin.impl.sdk.m r6 = r0.f13864a
            com.applovin.impl.sdk.c.b<java.lang.Integer> r7 = com.applovin.impl.sdk.c.b.cw
            java.lang.Object r6 = r6.a(r7)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            int r2 = com.applovin.sdk.AppLovinSdkUtils.dpToPx(r2, r6)
            r3.setMargins(r2, r2, r2, r2)
            android.view.ViewGroup r2 = r0.f13867d
            r2.addView(r1, r3)
        L_0x01a5:
            if (r4 == 0) goto L_0x01ae
            android.view.ViewGroup r1 = r0.f13867d
            android.widget.FrameLayout$LayoutParams r2 = r0.f13868e
            r1.addView(r4, r2)
        L_0x01ae:
            if (r5 == 0) goto L_0x01d1
            android.widget.FrameLayout$LayoutParams r1 = new android.widget.FrameLayout$LayoutParams
            r2 = 20
            r3 = 80
            r4 = -1
            r1.<init>(r4, r2, r3)
            com.applovin.impl.sdk.m r2 = r0.f13864a
            com.applovin.impl.sdk.c.b<java.lang.Integer> r3 = com.applovin.impl.sdk.c.b.cA
            java.lang.Object r2 = r2.a(r3)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r3 = 0
            r1.setMargins(r3, r3, r3, r2)
            android.view.ViewGroup r2 = r0.f13867d
            r2.addView(r5, r1)
        L_0x01d1:
            r1 = r27
            if (r1 == 0) goto L_0x01db
            android.view.ViewGroup r2 = r0.f13867d
            r1.addView(r2)
            goto L_0x01e2
        L_0x01db:
            android.app.Activity r1 = r0.f13865b
            android.view.ViewGroup r2 = r0.f13867d
            r1.setContentView(r2)
        L_0x01e2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.activity.a.c.a(android.widget.ImageView, com.applovin.impl.adview.m, com.applovin.impl.adview.t, com.applovin.impl.adview.a, android.widget.ProgressBar, android.view.View, com.applovin.adview.AppLovinAdView, android.view.ViewGroup):void");
    }

    public void a(com.applovin.impl.adview.m mVar, View view) {
        if (view != null) {
            view.setVisibility(0);
        }
        b.a(this.f13867d, view);
        if (mVar != null) {
            a(this.f13866c.X(), (this.f13866c.ab() ? 3 : 5) | 48, mVar);
        }
    }
}
