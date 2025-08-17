package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

public class MotionTiming {

    /* renamed from: a  reason: collision with root package name */
    private long f29409a;

    /* renamed from: b  reason: collision with root package name */
    private long f29410b;

    /* renamed from: c  reason: collision with root package name */
    private TimeInterpolator f29411c;

    /* renamed from: d  reason: collision with root package name */
    private int f29412d;

    /* renamed from: e  reason: collision with root package name */
    private int f29413e;

    public MotionTiming(long j2, long j3) {
        this.f29411c = null;
        this.f29412d = 0;
        this.f29413e = 1;
        this.f29409a = j2;
        this.f29410b = j3;
    }

    static MotionTiming b(ValueAnimator valueAnimator) {
        MotionTiming motionTiming = new MotionTiming(valueAnimator.getStartDelay(), valueAnimator.getDuration(), f(valueAnimator));
        motionTiming.f29412d = valueAnimator.getRepeatCount();
        motionTiming.f29413e = valueAnimator.getRepeatMode();
        return motionTiming;
    }

    private static TimeInterpolator f(ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
            return AnimationUtils.f29396b;
        }
        if (interpolator instanceof AccelerateInterpolator) {
            return AnimationUtils.f29397c;
        }
        if (interpolator instanceof DecelerateInterpolator) {
            return AnimationUtils.f29398d;
        }
        return interpolator;
    }

    public void a(Animator animator) {
        animator.setStartDelay(c());
        animator.setDuration(d());
        animator.setInterpolator(e());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(g());
            valueAnimator.setRepeatMode(h());
        }
    }

    public long c() {
        return this.f29409a;
    }

    public long d() {
        return this.f29410b;
    }

    public TimeInterpolator e() {
        TimeInterpolator timeInterpolator = this.f29411c;
        return timeInterpolator != null ? timeInterpolator : AnimationUtils.f29396b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MotionTiming motionTiming = (MotionTiming) obj;
        if (c() == motionTiming.c() && d() == motionTiming.d() && g() == motionTiming.g() && h() == motionTiming.h()) {
            return e().getClass().equals(motionTiming.e().getClass());
        }
        return false;
    }

    public int g() {
        return this.f29412d;
    }

    public int h() {
        return this.f29413e;
    }

    public int hashCode() {
        return (((((((((int) (c() ^ (c() >>> 32))) * 31) + ((int) (d() ^ (d() >>> 32)))) * 31) + e().getClass().hashCode()) * 31) + g()) * 31) + h();
    }

    public String toString() {
        return 10 + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + c() + " duration: " + d() + " interpolator: " + e().getClass() + " repeatCount: " + g() + " repeatMode: " + h() + "}\n";
    }

    public MotionTiming(long j2, long j3, TimeInterpolator timeInterpolator) {
        this.f29412d = 0;
        this.f29413e = 1;
        this.f29409a = j2;
        this.f29410b = j3;
        this.f29411c = timeInterpolator;
    }
}
