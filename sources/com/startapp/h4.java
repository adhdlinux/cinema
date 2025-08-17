package com.startapp;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.startapp.sdk.ads.list3d.List3DView;

public class h4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List3DView f34613a;

    public h4(List3DView list3DView) {
        this.f34613a = list3DView;
    }

    public void run() {
        boolean z2;
        boolean z3;
        float f2;
        List3DView list3DView = this.f34613a;
        if (list3DView.f35983l != null) {
            boolean z4 = false;
            View childAt = list3DView.getChildAt(0);
            if (childAt != null) {
                List3DView list3DView2 = this.f34613a;
                int d2 = list3DView2.d(childAt);
                List3DView list3DView3 = this.f34613a;
                list3DView2.f35976e = d2 - list3DView3.f35978g;
                d4 d4Var = list3DView3.f35983l;
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                long j2 = d4Var.f34341e;
                if (j2 != 0) {
                    int i2 = (int) (currentAnimationTimeMillis - j2);
                    if (i2 > 50) {
                        i2 = 50;
                    }
                    o4 o4Var = (o4) d4Var;
                    float f3 = o4Var.f34338b;
                    float f4 = o4Var.f34337a;
                    float f5 = o4Var.f34339c;
                    if (f4 <= f5) {
                        f5 = o4Var.f34340d;
                        if (f4 >= f5) {
                            f2 = 0.0f;
                            float f6 = f3 + (f2 * o4Var.f35550g);
                            o4Var.f34337a = f4 + ((((float) i2) * f6) / 1000.0f);
                            o4Var.f34338b = f6 * o4Var.f35549f;
                        }
                    }
                    f2 = f5 - f4;
                    float f62 = f3 + (f2 * o4Var.f35550g);
                    o4Var.f34337a = f4 + ((((float) i2) * f62) / 1000.0f);
                    o4Var.f34338b = f62 * o4Var.f35549f;
                }
                d4Var.f34341e = currentAnimationTimeMillis;
                List3DView list3DView4 = this.f34613a;
                list3DView4.a(((int) list3DView4.f35983l.f34337a) - list3DView4.f35976e);
            }
            d4 d4Var2 = this.f34613a.f35983l;
            if (Math.abs(d4Var2.f34338b) < 0.5f) {
                z2 = true;
            } else {
                z2 = false;
            }
            float f7 = d4Var2.f34337a;
            if (f7 - 0.4f >= d4Var2.f34339c || f7 + 0.4f <= d4Var2.f34340d) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z2 && z3) {
                z4 = true;
            }
            if (!z4) {
                this.f34613a.postDelayed(this, 16);
            }
        }
    }
}
