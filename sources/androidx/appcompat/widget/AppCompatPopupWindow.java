package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R$styleable;
import androidx.core.widget.PopupWindowCompat;

class AppCompatPopupWindow extends PopupWindow {

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f1151b = false;

    /* renamed from: a  reason: collision with root package name */
    private boolean f1152a;

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet, i2, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i2, int i3) {
        TintTypedArray v2 = TintTypedArray.v(context, attributeSet, R$styleable.i2, i2, i3);
        int i4 = R$styleable.k2;
        if (v2.s(i4)) {
            b(v2.a(i4, false));
        }
        setBackgroundDrawable(v2.g(R$styleable.j2));
        v2.w();
    }

    private void b(boolean z2) {
        if (f1151b) {
            this.f1152a = z2;
        } else {
            PopupWindowCompat.a(this, z2);
        }
    }

    public void showAsDropDown(View view, int i2, int i3) {
        if (f1151b && this.f1152a) {
            i3 -= view.getHeight();
        }
        super.showAsDropDown(view, i2, i3);
    }

    public void update(View view, int i2, int i3, int i4, int i5) {
        if (f1151b && this.f1152a) {
            i3 -= view.getHeight();
        }
        super.update(view, i2, i3, i4, i5);
    }

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(context, attributeSet, i2, i3);
    }

    public void showAsDropDown(View view, int i2, int i3, int i4) {
        if (f1151b && this.f1152a) {
            i3 -= view.getHeight();
        }
        super.showAsDropDown(view, i2, i3, i4);
    }
}
