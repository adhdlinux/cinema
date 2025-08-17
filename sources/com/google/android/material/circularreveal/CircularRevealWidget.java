package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import com.google.android.material.math.MathUtils;

public interface CircularRevealWidget {

    public static class CircularRevealEvaluator implements TypeEvaluator<RevealInfo> {

        /* renamed from: b  reason: collision with root package name */
        public static final TypeEvaluator<RevealInfo> f29737b = new CircularRevealEvaluator();

        /* renamed from: a  reason: collision with root package name */
        private final RevealInfo f29738a = new RevealInfo();

        /* renamed from: a */
        public RevealInfo evaluate(float f2, RevealInfo revealInfo, RevealInfo revealInfo2) {
            this.f29738a.a(MathUtils.c(revealInfo.f29741a, revealInfo2.f29741a, f2), MathUtils.c(revealInfo.f29742b, revealInfo2.f29742b, f2), MathUtils.c(revealInfo.f29743c, revealInfo2.f29743c, f2));
            return this.f29738a;
        }
    }

    public static class CircularRevealProperty extends Property<CircularRevealWidget, RevealInfo> {

        /* renamed from: a  reason: collision with root package name */
        public static final Property<CircularRevealWidget, RevealInfo> f29739a = new CircularRevealProperty("circularReveal");

        private CircularRevealProperty(String str) {
            super(RevealInfo.class, str);
        }

        /* renamed from: a */
        public RevealInfo get(CircularRevealWidget circularRevealWidget) {
            return circularRevealWidget.getRevealInfo();
        }

        /* renamed from: b */
        public void set(CircularRevealWidget circularRevealWidget, RevealInfo revealInfo) {
            circularRevealWidget.setRevealInfo(revealInfo);
        }
    }

    public static class CircularRevealScrimColorProperty extends Property<CircularRevealWidget, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public static final Property<CircularRevealWidget, Integer> f29740a = new CircularRevealScrimColorProperty("circularRevealScrimColor");

        private CircularRevealScrimColorProperty(String str) {
            super(Integer.class, str);
        }

        /* renamed from: a */
        public Integer get(CircularRevealWidget circularRevealWidget) {
            return Integer.valueOf(circularRevealWidget.getCircularRevealScrimColor());
        }

        /* renamed from: b */
        public void set(CircularRevealWidget circularRevealWidget, Integer num) {
            circularRevealWidget.setCircularRevealScrimColor(num.intValue());
        }
    }

    public static class RevealInfo {

        /* renamed from: a  reason: collision with root package name */
        public float f29741a;

        /* renamed from: b  reason: collision with root package name */
        public float f29742b;

        /* renamed from: c  reason: collision with root package name */
        public float f29743c;

        public void a(float f2, float f3, float f4) {
            this.f29741a = f2;
            this.f29742b = f3;
            this.f29743c = f4;
        }

        private RevealInfo() {
        }

        public RevealInfo(float f2, float f3, float f4) {
            this.f29741a = f2;
            this.f29742b = f3;
            this.f29743c = f4;
        }
    }

    void a();

    void b();

    int getCircularRevealScrimColor();

    RevealInfo getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i2);

    void setRevealInfo(RevealInfo revealInfo);
}
