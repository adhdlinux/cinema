package androidx.appcompat.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.graphics.drawable.DrawableContainerCompat;

public class StateListDrawableCompat extends DrawableContainerCompat {

    /* renamed from: n  reason: collision with root package name */
    private StateListState f641n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f642o;

    static class StateListState extends DrawableContainerCompat.DrawableContainerState {
        int[][] J;

        StateListState(StateListState stateListState, StateListDrawableCompat stateListDrawableCompat, Resources resources) {
            super(stateListState, stateListDrawableCompat, resources);
            if (stateListState != null) {
                this.J = stateListState.J;
            } else {
                this.J = new int[f()][];
            }
        }

        /* access modifiers changed from: package-private */
        public int A(int[] iArr, Drawable drawable) {
            int a2 = a(drawable);
            this.J[a2] = iArr;
            return a2;
        }

        /* access modifiers changed from: package-private */
        public int B(int[] iArr) {
            int[][] iArr2 = this.J;
            int h2 = h();
            for (int i2 = 0; i2 < h2; i2++) {
                if (StateSet.stateSetMatches(iArr2[i2], iArr)) {
                    return i2;
                }
            }
            return -1;
        }

        public Drawable newDrawable() {
            return new StateListDrawableCompat(this, (Resources) null);
        }

        public void o(int i2, int i3) {
            super.o(i2, i3);
            int[][] iArr = new int[i3][];
            System.arraycopy(this.J, 0, iArr, 0, i2);
            this.J = iArr;
        }

        /* access modifiers changed from: package-private */
        public void s() {
            int[] iArr;
            int[][] iArr2 = this.J;
            int[][] iArr3 = new int[iArr2.length][];
            for (int length = iArr2.length - 1; length >= 0; length--) {
                int[] iArr4 = this.J[length];
                if (iArr4 != null) {
                    iArr = (int[]) iArr4.clone();
                } else {
                    iArr = null;
                }
                iArr3[length] = iArr;
            }
            this.J = iArr3;
        }

        public Drawable newDrawable(Resources resources) {
            return new StateListDrawableCompat(this, resources);
        }
    }

    public StateListDrawableCompat() {
        this((StateListState) null, (Resources) null);
    }

    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    /* access modifiers changed from: package-private */
    public void h(DrawableContainerCompat.DrawableContainerState drawableContainerState) {
        super.h(drawableContainerState);
        if (drawableContainerState instanceof StateListState) {
            this.f641n = (StateListState) drawableContainerState;
        }
    }

    public boolean isStateful() {
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public StateListState b() {
        return new StateListState(this.f641n, this, (Resources) null);
    }

    /* access modifiers changed from: package-private */
    public int[] k(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i2 = 0;
        for (int i3 = 0; i3 < attributeCount; i3++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i3);
            if (!(attributeNameResource == 0 || attributeNameResource == 16842960 || attributeNameResource == 16843161)) {
                int i4 = i2 + 1;
                if (!attributeSet.getAttributeBooleanValue(i3, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i2] = attributeNameResource;
                i2 = i4;
            }
        }
        return StateSet.trimStateSet(iArr, i2);
    }

    public Drawable mutate() {
        if (!this.f642o && super.mutate() == this) {
            this.f641n.s();
            this.f642o = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int B = this.f641n.B(iArr);
        if (B < 0) {
            B = this.f641n.B(StateSet.WILD_CARD);
        }
        if (g(B) || onStateChange) {
            return true;
        }
        return false;
    }

    StateListDrawableCompat(StateListState stateListState, Resources resources) {
        h(new StateListState(stateListState, this, resources));
        onStateChange(getState());
    }

    StateListDrawableCompat(StateListState stateListState) {
        if (stateListState != null) {
            h(stateListState);
        }
    }
}
