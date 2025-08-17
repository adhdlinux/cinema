package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.facebook.react.uimanager.IllegalViewOperationException;

abstract class BaseLayoutAnimation extends AbstractLayoutAnimation {

    /* renamed from: com.facebook.react.uimanager.layoutanimation.BaseLayoutAnimation$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$uimanager$layoutanimation$AnimatedPropertyType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.facebook.react.uimanager.layoutanimation.AnimatedPropertyType[] r0 = com.facebook.react.uimanager.layoutanimation.AnimatedPropertyType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$react$uimanager$layoutanimation$AnimatedPropertyType = r0
                com.facebook.react.uimanager.layoutanimation.AnimatedPropertyType r1 = com.facebook.react.uimanager.layoutanimation.AnimatedPropertyType.OPACITY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$layoutanimation$AnimatedPropertyType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.react.uimanager.layoutanimation.AnimatedPropertyType r1 = com.facebook.react.uimanager.layoutanimation.AnimatedPropertyType.SCALE_XY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$layoutanimation$AnimatedPropertyType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.react.uimanager.layoutanimation.AnimatedPropertyType r1 = com.facebook.react.uimanager.layoutanimation.AnimatedPropertyType.SCALE_X     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$layoutanimation$AnimatedPropertyType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.react.uimanager.layoutanimation.AnimatedPropertyType r1 = com.facebook.react.uimanager.layoutanimation.AnimatedPropertyType.SCALE_Y     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.layoutanimation.BaseLayoutAnimation.AnonymousClass1.<clinit>():void");
        }
    }

    BaseLayoutAnimation() {
    }

    /* access modifiers changed from: package-private */
    public Animation createAnimationImpl(View view, int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        AnimatedPropertyType animatedPropertyType = this.mAnimatedProperty;
        if (animatedPropertyType != null) {
            int i6 = AnonymousClass1.$SwitchMap$com$facebook$react$uimanager$layoutanimation$AnimatedPropertyType[animatedPropertyType.ordinal()];
            float f9 = 0.0f;
            if (i6 == 1) {
                if (isReverse()) {
                    f2 = view.getAlpha();
                } else {
                    f2 = 0.0f;
                }
                if (!isReverse()) {
                    f9 = view.getAlpha();
                }
                return new OpacityAnimation(view, f2, f9);
            } else if (i6 == 2) {
                if (isReverse()) {
                    f3 = 1.0f;
                } else {
                    f3 = 0.0f;
                }
                if (isReverse()) {
                    f4 = 0.0f;
                } else {
                    f4 = 1.0f;
                }
                return new ScaleAnimation(f3, f4, f3, f4, 1, 0.5f, 1, 0.5f);
            } else if (i6 == 3) {
                if (isReverse()) {
                    f5 = 1.0f;
                } else {
                    f5 = 0.0f;
                }
                if (isReverse()) {
                    f6 = 0.0f;
                } else {
                    f6 = 1.0f;
                }
                return new ScaleAnimation(f5, f6, 1.0f, 1.0f, 1, 0.5f, 1, 0.0f);
            } else if (i6 == 4) {
                if (isReverse()) {
                    f7 = 1.0f;
                } else {
                    f7 = 0.0f;
                }
                if (isReverse()) {
                    f8 = 0.0f;
                } else {
                    f8 = 1.0f;
                }
                return new ScaleAnimation(1.0f, 1.0f, f7, f8, 1, 0.0f, 1, 0.5f);
            } else {
                throw new IllegalViewOperationException("Missing animation for property : " + this.mAnimatedProperty);
            }
        } else {
            throw new IllegalViewOperationException("Missing animated property from animation config");
        }
    }

    /* access modifiers changed from: package-private */
    public abstract boolean isReverse();

    /* access modifiers changed from: package-private */
    public boolean isValid() {
        return this.mDurationMs > 0 && this.mAnimatedProperty != null;
    }
}
