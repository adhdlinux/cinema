package com.applovin.impl.sdk;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.Animation;
import com.applovin.impl.mediation.a.e;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.g;
import com.applovin.sdk.AppLovinSdkUtils;

public class z {

    /* renamed from: a  reason: collision with root package name */
    private final m f15955a;

    /* renamed from: b  reason: collision with root package name */
    private final v f15956b;

    /* renamed from: c  reason: collision with root package name */
    private final View f15957c;

    public z(View view, m mVar) {
        this.f15955a = mVar;
        this.f15956b = mVar.A();
        this.f15957c = view;
    }

    public long a(e eVar) {
        long j2;
        if (v.a()) {
            this.f15956b.b("ViewabilityTracker", "Checking visibility...");
        }
        if (!this.f15957c.isShown()) {
            if (v.a()) {
                this.f15956b.e("ViewabilityTracker", "View is hidden");
            }
            j2 = 2;
        } else {
            j2 = 0;
        }
        if (this.f15957c.getAlpha() < eVar.E()) {
            if (v.a()) {
                this.f15956b.e("ViewabilityTracker", "View is transparent");
            }
            j2 |= 4;
        }
        Animation animation = this.f15957c.getAnimation();
        if (animation != null && animation.hasStarted() && !animation.hasEnded()) {
            if (v.a()) {
                this.f15956b.e("ViewabilityTracker", "View is animating");
            }
            j2 |= 8;
        }
        if (this.f15957c.getParent() == null) {
            if (v.a()) {
                this.f15956b.e("ViewabilityTracker", "No parent view found");
            }
            j2 |= 16;
        }
        int pxToDp = AppLovinSdkUtils.pxToDp(this.f15957c.getContext(), this.f15957c.getWidth());
        if (pxToDp < eVar.C()) {
            if (v.a()) {
                v vVar = this.f15956b;
                vVar.e("ViewabilityTracker", "View has width (" + pxToDp + ") below threshold");
            }
            j2 |= 32;
        }
        int pxToDp2 = AppLovinSdkUtils.pxToDp(this.f15957c.getContext(), this.f15957c.getHeight());
        if (pxToDp2 < eVar.D()) {
            if (v.a()) {
                v vVar2 = this.f15956b;
                vVar2.e("ViewabilityTracker", "View has height (" + pxToDp2 + ") below threshold");
            }
            j2 |= 64;
        }
        Point a2 = g.a(this.f15957c.getContext());
        Rect rect = new Rect(0, 0, a2.x, a2.y);
        int[] iArr = {-1, -1};
        this.f15957c.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        Rect rect2 = new Rect(i2, iArr[1], this.f15957c.getWidth() + i2, iArr[1] + this.f15957c.getHeight());
        if (!Rect.intersects(rect, rect2)) {
            if (v.a()) {
                v vVar3 = this.f15956b;
                vVar3.e("ViewabilityTracker", "Rect (" + rect2 + ") outside of screen's bounds (" + rect + ")");
            }
            j2 |= 128;
        }
        Activity a3 = this.f15955a.af().a();
        if (a3 != null && !Utils.isViewInTopActivity(this.f15957c, a3)) {
            if (v.a()) {
                this.f15956b.e("ViewabilityTracker", "View is not in top activity's view hierarchy");
            }
            j2 |= 256;
        }
        if (v.a()) {
            v vVar4 = this.f15956b;
            vVar4.b("ViewabilityTracker", "Returning flags: " + Long.toBinaryString(j2));
        }
        return j2;
    }
}
