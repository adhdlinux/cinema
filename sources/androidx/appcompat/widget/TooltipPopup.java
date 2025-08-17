package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;

class TooltipPopup {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1538a;

    /* renamed from: b  reason: collision with root package name */
    private final View f1539b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f1540c;

    /* renamed from: d  reason: collision with root package name */
    private final WindowManager.LayoutParams f1541d;

    /* renamed from: e  reason: collision with root package name */
    private final Rect f1542e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    private final int[] f1543f = new int[2];

    /* renamed from: g  reason: collision with root package name */
    private final int[] f1544g = new int[2];

    TooltipPopup(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f1541d = layoutParams;
        this.f1538a = context;
        View inflate = LayoutInflater.from(context).inflate(R$layout.f212u, (ViewGroup) null);
        this.f1539b = inflate;
        this.f1540c = (TextView) inflate.findViewById(R$id.f190y);
        layoutParams.setTitle(getClass().getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R$style.f229a;
        layoutParams.flags = 24;
    }

    private void a(View view, int i2, int i3, boolean z2, WindowManager.LayoutParams layoutParams) {
        int i4;
        int i5;
        int i6;
        int i7;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f1538a.getResources().getDimensionPixelOffset(R$dimen.f137m);
        if (view.getWidth() < dimensionPixelOffset) {
            i2 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f1538a.getResources().getDimensionPixelOffset(R$dimen.f136l);
            i5 = i3 + dimensionPixelOffset2;
            i4 = i3 - dimensionPixelOffset2;
        } else {
            i5 = view.getHeight();
            i4 = 0;
        }
        layoutParams.gravity = 49;
        Resources resources = this.f1538a.getResources();
        if (z2) {
            i6 = R$dimen.f139o;
        } else {
            i6 = R$dimen.f138n;
        }
        int dimensionPixelOffset3 = resources.getDimensionPixelOffset(i6);
        View b2 = b(view);
        if (b2 == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        b2.getWindowVisibleDisplayFrame(this.f1542e);
        Rect rect = this.f1542e;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources2 = this.f1538a.getResources();
            int identifier = resources2.getIdentifier("status_bar_height", "dimen", "android");
            if (identifier != 0) {
                i7 = resources2.getDimensionPixelSize(identifier);
            } else {
                i7 = 0;
            }
            DisplayMetrics displayMetrics = resources2.getDisplayMetrics();
            this.f1542e.set(0, i7, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        b2.getLocationOnScreen(this.f1544g);
        view.getLocationOnScreen(this.f1543f);
        int[] iArr = this.f1543f;
        int i8 = iArr[0];
        int[] iArr2 = this.f1544g;
        int i9 = i8 - iArr2[0];
        iArr[0] = i9;
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (i9 + i2) - (b2.getWidth() / 2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f1539b.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.f1539b.getMeasuredHeight();
        int i10 = this.f1543f[1];
        int i11 = ((i4 + i10) - dimensionPixelOffset3) - measuredHeight;
        int i12 = i10 + i5 + dimensionPixelOffset3;
        if (z2) {
            if (i11 >= 0) {
                layoutParams.y = i11;
            } else {
                layoutParams.y = i12;
            }
        } else if (measuredHeight + i12 <= this.f1542e.height()) {
            layoutParams.y = i12;
        } else {
            layoutParams.y = i11;
        }
    }

    private static View b(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (d()) {
            ((WindowManager) this.f1538a.getSystemService("window")).removeView(this.f1539b);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.f1539b.getParent() != null;
    }

    /* access modifiers changed from: package-private */
    public void e(View view, int i2, int i3, boolean z2, CharSequence charSequence) {
        if (d()) {
            c();
        }
        this.f1540c.setText(charSequence);
        a(view, i2, i3, z2, this.f1541d);
        ((WindowManager) this.f1538a.getSystemService("window")).addView(this.f1539b, this.f1541d);
    }
}
