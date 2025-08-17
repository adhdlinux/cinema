package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.CheckedTextViewCompat;

class AppCompatCheckedTextViewHelper {

    /* renamed from: a  reason: collision with root package name */
    private final CheckedTextView f1110a;

    /* renamed from: b  reason: collision with root package name */
    private ColorStateList f1111b = null;

    /* renamed from: c  reason: collision with root package name */
    private PorterDuff.Mode f1112c = null;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1113d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1114e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1115f;

    AppCompatCheckedTextViewHelper(CheckedTextView checkedTextView) {
        this.f1110a = checkedTextView;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        Drawable a2 = CheckedTextViewCompat.a(this.f1110a);
        if (a2 == null) {
            return;
        }
        if (this.f1113d || this.f1114e) {
            Drawable mutate = DrawableCompat.r(a2).mutate();
            if (this.f1113d) {
                DrawableCompat.o(mutate, this.f1111b);
            }
            if (this.f1114e) {
                DrawableCompat.p(mutate, this.f1112c);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.f1110a.getDrawableState());
            }
            this.f1110a.setCheckMarkDrawable(mutate);
        }
    }

    /* access modifiers changed from: package-private */
    public ColorStateList b() {
        return this.f1111b;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode c() {
        return this.f1112c;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e A[SYNTHETIC, Splitter:B:12:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0061 A[Catch:{ all -> 0x0085 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0072 A[Catch:{ all -> 0x0085 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(android.util.AttributeSet r10, int r11) {
        /*
            r9 = this;
            android.widget.CheckedTextView r0 = r9.f1110a
            android.content.Context r0 = r0.getContext()
            int[] r3 = androidx.appcompat.R$styleable.R0
            r8 = 0
            androidx.appcompat.widget.TintTypedArray r0 = androidx.appcompat.widget.TintTypedArray.v(r0, r10, r3, r11, r8)
            android.widget.CheckedTextView r1 = r9.f1110a
            android.content.Context r2 = r1.getContext()
            android.content.res.TypedArray r5 = r0.r()
            r7 = 0
            r4 = r10
            r6 = r11
            androidx.core.view.ViewCompat.p0(r1, r2, r3, r4, r5, r6, r7)
            int r10 = androidx.appcompat.R$styleable.T0     // Catch:{ all -> 0x0085 }
            boolean r11 = r0.s(r10)     // Catch:{ all -> 0x0085 }
            if (r11 == 0) goto L_0x003b
            int r10 = r0.n(r10, r8)     // Catch:{ all -> 0x0085 }
            if (r10 == 0) goto L_0x003b
            android.widget.CheckedTextView r11 = r9.f1110a     // Catch:{ NotFoundException -> 0x003a }
            android.content.Context r1 = r11.getContext()     // Catch:{ NotFoundException -> 0x003a }
            android.graphics.drawable.Drawable r10 = androidx.appcompat.content.res.AppCompatResources.b(r1, r10)     // Catch:{ NotFoundException -> 0x003a }
            r11.setCheckMarkDrawable(r10)     // Catch:{ NotFoundException -> 0x003a }
            r10 = 1
            goto L_0x003c
        L_0x003a:
        L_0x003b:
            r10 = 0
        L_0x003c:
            if (r10 != 0) goto L_0x0059
            int r10 = androidx.appcompat.R$styleable.S0     // Catch:{ all -> 0x0085 }
            boolean r11 = r0.s(r10)     // Catch:{ all -> 0x0085 }
            if (r11 == 0) goto L_0x0059
            int r10 = r0.n(r10, r8)     // Catch:{ all -> 0x0085 }
            if (r10 == 0) goto L_0x0059
            android.widget.CheckedTextView r11 = r9.f1110a     // Catch:{ all -> 0x0085 }
            android.content.Context r1 = r11.getContext()     // Catch:{ all -> 0x0085 }
            android.graphics.drawable.Drawable r10 = androidx.appcompat.content.res.AppCompatResources.b(r1, r10)     // Catch:{ all -> 0x0085 }
            r11.setCheckMarkDrawable(r10)     // Catch:{ all -> 0x0085 }
        L_0x0059:
            int r10 = androidx.appcompat.R$styleable.U0     // Catch:{ all -> 0x0085 }
            boolean r11 = r0.s(r10)     // Catch:{ all -> 0x0085 }
            if (r11 == 0) goto L_0x006a
            android.widget.CheckedTextView r11 = r9.f1110a     // Catch:{ all -> 0x0085 }
            android.content.res.ColorStateList r10 = r0.c(r10)     // Catch:{ all -> 0x0085 }
            androidx.core.widget.CheckedTextViewCompat.b(r11, r10)     // Catch:{ all -> 0x0085 }
        L_0x006a:
            int r10 = androidx.appcompat.R$styleable.V0     // Catch:{ all -> 0x0085 }
            boolean r11 = r0.s(r10)     // Catch:{ all -> 0x0085 }
            if (r11 == 0) goto L_0x0081
            android.widget.CheckedTextView r11 = r9.f1110a     // Catch:{ all -> 0x0085 }
            r1 = -1
            int r10 = r0.k(r10, r1)     // Catch:{ all -> 0x0085 }
            r1 = 0
            android.graphics.PorterDuff$Mode r10 = androidx.appcompat.widget.DrawableUtils.e(r10, r1)     // Catch:{ all -> 0x0085 }
            androidx.core.widget.CheckedTextViewCompat.c(r11, r10)     // Catch:{ all -> 0x0085 }
        L_0x0081:
            r0.w()
            return
        L_0x0085:
            r10 = move-exception
            r0.w()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatCheckedTextViewHelper.d(android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: package-private */
    public void e() {
        if (this.f1115f) {
            this.f1115f = false;
            return;
        }
        this.f1115f = true;
        a();
    }

    /* access modifiers changed from: package-private */
    public void f(ColorStateList colorStateList) {
        this.f1111b = colorStateList;
        this.f1113d = true;
        a();
    }

    /* access modifiers changed from: package-private */
    public void g(PorterDuff.Mode mode) {
        this.f1112c = mode;
        this.f1114e = true;
        a();
    }
}
