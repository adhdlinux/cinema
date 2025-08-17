package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.ActionMode;

public abstract class ActionBar {

    public interface OnMenuVisibilityListener {
        void onMenuVisibilityChanged(boolean z2);
    }

    @Deprecated
    public static abstract class Tab {
        public abstract CharSequence a();

        public abstract View b();

        public abstract Drawable c();

        public abstract CharSequence d();

        public abstract void e();
    }

    public abstract void A(CharSequence charSequence);

    public abstract void B(CharSequence charSequence);

    public void C(CharSequence charSequence) {
    }

    public ActionMode D(ActionMode.Callback callback) {
        return null;
    }

    public boolean f() {
        return false;
    }

    public boolean g() {
        return false;
    }

    public void h(boolean z2) {
    }

    public abstract int i();

    public Context j() {
        return null;
    }

    public boolean k() {
        return false;
    }

    public void l(Configuration configuration) {
    }

    /* access modifiers changed from: package-private */
    public void m() {
    }

    public boolean n(int i2, KeyEvent keyEvent) {
        return false;
    }

    public boolean o(KeyEvent keyEvent) {
        return false;
    }

    public boolean p() {
        return false;
    }

    public void q(boolean z2) {
    }

    public abstract void r(boolean z2);

    public abstract void s(int i2, int i3);

    public abstract void t(boolean z2);

    public abstract void u(boolean z2);

    public void v(int i2) {
    }

    public void w(int i2) {
    }

    public void x(Drawable drawable) {
    }

    public void y(boolean z2) {
    }

    public void z(boolean z2) {
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f306a = 8388627;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f292t);
            this.f306a = obtainStyledAttributes.getInt(R$styleable.f294u, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f306a = layoutParams.f306a;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
