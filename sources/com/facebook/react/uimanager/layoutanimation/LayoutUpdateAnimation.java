package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.Animation;

class LayoutUpdateAnimation extends AbstractLayoutAnimation {
    private static final boolean USE_TRANSLATE_ANIMATION = false;

    LayoutUpdateAnimation() {
    }

    /* access modifiers changed from: package-private */
    public Animation createAnimationImpl(View view, int i2, int i3, int i4, int i5) {
        boolean z2;
        boolean z3 = false;
        if (view.getX() == ((float) i2) && view.getY() == ((float) i3)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!(view.getWidth() == i4 && view.getHeight() == i5)) {
            z3 = true;
        }
        if (z2 || z3) {
            return new PositionAndSizeAnimation(view, i2, i3, i4, i5);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean isValid() {
        return this.mDurationMs > 0;
    }
}
