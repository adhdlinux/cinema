package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.CompoundButtonCompat;

class AppCompatCompoundButtonHelper {

    /* renamed from: a  reason: collision with root package name */
    private final CompoundButton f1116a;

    /* renamed from: b  reason: collision with root package name */
    private ColorStateList f1117b = null;

    /* renamed from: c  reason: collision with root package name */
    private PorterDuff.Mode f1118c = null;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1119d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1120e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1121f;

    AppCompatCompoundButtonHelper(CompoundButton compoundButton) {
        this.f1116a = compoundButton;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        Drawable a2 = CompoundButtonCompat.a(this.f1116a);
        if (a2 == null) {
            return;
        }
        if (this.f1119d || this.f1120e) {
            Drawable mutate = DrawableCompat.r(a2).mutate();
            if (this.f1119d) {
                DrawableCompat.o(mutate, this.f1117b);
            }
            if (this.f1120e) {
                DrawableCompat.p(mutate, this.f1118c);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.f1116a.getDrawableState());
            }
            this.f1116a.setButtonDrawable(mutate);
        }
    }

    /* access modifiers changed from: package-private */
    public int b(int i2) {
        return i2;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList c() {
        return this.f1117b;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        return this.f1118c;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e A[SYNTHETIC, Splitter:B:12:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0061 A[Catch:{ all -> 0x0085 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0072 A[Catch:{ all -> 0x0085 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(android.util.AttributeSet r10, int r11) {
        /*
            r9 = this;
            android.widget.CompoundButton r0 = r9.f1116a
            android.content.Context r0 = r0.getContext()
            int[] r3 = androidx.appcompat.R$styleable.W0
            r8 = 0
            androidx.appcompat.widget.TintTypedArray r0 = androidx.appcompat.widget.TintTypedArray.v(r0, r10, r3, r11, r8)
            android.widget.CompoundButton r1 = r9.f1116a
            android.content.Context r2 = r1.getContext()
            android.content.res.TypedArray r5 = r0.r()
            r7 = 0
            r4 = r10
            r6 = r11
            androidx.core.view.ViewCompat.p0(r1, r2, r3, r4, r5, r6, r7)
            int r10 = androidx.appcompat.R$styleable.Y0     // Catch:{ all -> 0x0085 }
            boolean r11 = r0.s(r10)     // Catch:{ all -> 0x0085 }
            if (r11 == 0) goto L_0x003b
            int r10 = r0.n(r10, r8)     // Catch:{ all -> 0x0085 }
            if (r10 == 0) goto L_0x003b
            android.widget.CompoundButton r11 = r9.f1116a     // Catch:{ NotFoundException -> 0x003a }
            android.content.Context r1 = r11.getContext()     // Catch:{ NotFoundException -> 0x003a }
            android.graphics.drawable.Drawable r10 = androidx.appcompat.content.res.AppCompatResources.b(r1, r10)     // Catch:{ NotFoundException -> 0x003a }
            r11.setButtonDrawable(r10)     // Catch:{ NotFoundException -> 0x003a }
            r10 = 1
            goto L_0x003c
        L_0x003a:
        L_0x003b:
            r10 = 0
        L_0x003c:
            if (r10 != 0) goto L_0x0059
            int r10 = androidx.appcompat.R$styleable.X0     // Catch:{ all -> 0x0085 }
            boolean r11 = r0.s(r10)     // Catch:{ all -> 0x0085 }
            if (r11 == 0) goto L_0x0059
            int r10 = r0.n(r10, r8)     // Catch:{ all -> 0x0085 }
            if (r10 == 0) goto L_0x0059
            android.widget.CompoundButton r11 = r9.f1116a     // Catch:{ all -> 0x0085 }
            android.content.Context r1 = r11.getContext()     // Catch:{ all -> 0x0085 }
            android.graphics.drawable.Drawable r10 = androidx.appcompat.content.res.AppCompatResources.b(r1, r10)     // Catch:{ all -> 0x0085 }
            r11.setButtonDrawable(r10)     // Catch:{ all -> 0x0085 }
        L_0x0059:
            int r10 = androidx.appcompat.R$styleable.Z0     // Catch:{ all -> 0x0085 }
            boolean r11 = r0.s(r10)     // Catch:{ all -> 0x0085 }
            if (r11 == 0) goto L_0x006a
            android.widget.CompoundButton r11 = r9.f1116a     // Catch:{ all -> 0x0085 }
            android.content.res.ColorStateList r10 = r0.c(r10)     // Catch:{ all -> 0x0085 }
            androidx.core.widget.CompoundButtonCompat.b(r11, r10)     // Catch:{ all -> 0x0085 }
        L_0x006a:
            int r10 = androidx.appcompat.R$styleable.f237a1     // Catch:{ all -> 0x0085 }
            boolean r11 = r0.s(r10)     // Catch:{ all -> 0x0085 }
            if (r11 == 0) goto L_0x0081
            android.widget.CompoundButton r11 = r9.f1116a     // Catch:{ all -> 0x0085 }
            r1 = -1
            int r10 = r0.k(r10, r1)     // Catch:{ all -> 0x0085 }
            r1 = 0
            android.graphics.PorterDuff$Mode r10 = androidx.appcompat.widget.DrawableUtils.e(r10, r1)     // Catch:{ all -> 0x0085 }
            androidx.core.widget.CompoundButtonCompat.c(r11, r10)     // Catch:{ all -> 0x0085 }
        L_0x0081:
            r0.w()
            return
        L_0x0085:
            r10 = move-exception
            r0.w()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatCompoundButtonHelper.e(android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: package-private */
    public void f() {
        if (this.f1121f) {
            this.f1121f = false;
            return;
        }
        this.f1121f = true;
        a();
    }

    /* access modifiers changed from: package-private */
    public void g(ColorStateList colorStateList) {
        this.f1117b = colorStateList;
        this.f1119d = true;
        a();
    }

    /* access modifiers changed from: package-private */
    public void h(PorterDuff.Mode mode) {
        this.f1118c = mode;
        this.f1120e = true;
        a();
    }
}
