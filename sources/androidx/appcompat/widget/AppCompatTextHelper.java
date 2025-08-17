package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import java.lang.ref.WeakReference;
import java.util.Locale;

class AppCompatTextHelper {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f1193a;

    /* renamed from: b  reason: collision with root package name */
    private TintInfo f1194b;

    /* renamed from: c  reason: collision with root package name */
    private TintInfo f1195c;

    /* renamed from: d  reason: collision with root package name */
    private TintInfo f1196d;

    /* renamed from: e  reason: collision with root package name */
    private TintInfo f1197e;

    /* renamed from: f  reason: collision with root package name */
    private TintInfo f1198f;

    /* renamed from: g  reason: collision with root package name */
    private TintInfo f1199g;

    /* renamed from: h  reason: collision with root package name */
    private TintInfo f1200h;

    /* renamed from: i  reason: collision with root package name */
    private final AppCompatTextViewAutoSizeHelper f1201i;

    /* renamed from: j  reason: collision with root package name */
    private int f1202j = 0;

    /* renamed from: k  reason: collision with root package name */
    private int f1203k = -1;

    /* renamed from: l  reason: collision with root package name */
    private Typeface f1204l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f1205m;

    static class Api17Impl {
        private Api17Impl() {
        }

        static Drawable[] a(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }

        static void b(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }

        static void c(TextView textView, Locale locale) {
            textView.setTextLocale(locale);
        }
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }

        static void b(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static int a(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        static void b(TextView textView, int i2, int i3, int i4, int i5) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
        }

        static void c(TextView textView, int[] iArr, int i2) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
        }

        static boolean d(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static Typeface a(Typeface typeface, int i2, boolean z2) {
            return Typeface.create(typeface, i2, z2);
        }
    }

    AppCompatTextHelper(TextView textView) {
        this.f1193a = textView;
        this.f1201i = new AppCompatTextViewAutoSizeHelper(textView);
    }

    private void B(int i2, float f2) {
        this.f1201i.t(i2, f2);
    }

    private void C(Context context, TintTypedArray tintTypedArray) {
        String o2;
        boolean z2;
        boolean z3;
        this.f1202j = tintTypedArray.k(R$styleable.f3, this.f1202j);
        int i2 = Build.VERSION.SDK_INT;
        boolean z4 = false;
        if (i2 >= 28) {
            int k2 = tintTypedArray.k(R$styleable.o3, -1);
            this.f1203k = k2;
            if (k2 != -1) {
                this.f1202j = (this.f1202j & 2) | 0;
            }
        }
        int i3 = R$styleable.n3;
        if (tintTypedArray.s(i3) || tintTypedArray.s(R$styleable.p3)) {
            this.f1204l = null;
            int i4 = R$styleable.p3;
            if (tintTypedArray.s(i4)) {
                i3 = i4;
            }
            final int i5 = this.f1203k;
            final int i6 = this.f1202j;
            if (!context.isRestricted()) {
                final WeakReference weakReference = new WeakReference(this.f1193a);
                try {
                    Typeface j2 = tintTypedArray.j(i3, this.f1202j, new ResourcesCompat.FontCallback() {
                        public void h(int i2) {
                        }

                        public void i(Typeface typeface) {
                            int i2;
                            boolean z2;
                            if (Build.VERSION.SDK_INT >= 28 && (i2 = i5) != -1) {
                                if ((i6 & 2) != 0) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                typeface = Api28Impl.a(typeface, i2, z2);
                            }
                            AppCompatTextHelper.this.n(weakReference, typeface);
                        }
                    });
                    if (j2 != null) {
                        if (i2 < 28 || this.f1203k == -1) {
                            this.f1204l = j2;
                        } else {
                            Typeface create = Typeface.create(j2, 0);
                            int i7 = this.f1203k;
                            if ((this.f1202j & 2) != 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            this.f1204l = Api28Impl.a(create, i7, z3);
                        }
                    }
                    if (this.f1204l == null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    this.f1205m = z2;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.f1204l == null && (o2 = tintTypedArray.o(i3)) != null) {
                if (Build.VERSION.SDK_INT < 28 || this.f1203k == -1) {
                    this.f1204l = Typeface.create(o2, this.f1202j);
                    return;
                }
                Typeface create2 = Typeface.create(o2, 0);
                int i8 = this.f1203k;
                if ((this.f1202j & 2) != 0) {
                    z4 = true;
                }
                this.f1204l = Api28Impl.a(create2, i8, z4);
                return;
            }
            return;
        }
        int i9 = R$styleable.e3;
        if (tintTypedArray.s(i9)) {
            this.f1205m = false;
            int k3 = tintTypedArray.k(i9, 1);
            if (k3 == 1) {
                this.f1204l = Typeface.SANS_SERIF;
            } else if (k3 == 2) {
                this.f1204l = Typeface.SERIF;
            } else if (k3 == 3) {
                this.f1204l = Typeface.MONOSPACE;
            }
        }
    }

    private void a(Drawable drawable, TintInfo tintInfo) {
        if (drawable != null && tintInfo != null) {
            AppCompatDrawableManager.i(drawable, tintInfo, this.f1193a.getDrawableState());
        }
    }

    private static TintInfo d(Context context, AppCompatDrawableManager appCompatDrawableManager, int i2) {
        ColorStateList f2 = appCompatDrawableManager.f(context, i2);
        if (f2 == null) {
            return null;
        }
        TintInfo tintInfo = new TintInfo();
        tintInfo.f1464d = true;
        tintInfo.f1461a = f2;
        return tintInfo;
    }

    private void y(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] a2 = Api17Impl.a(this.f1193a);
            TextView textView = this.f1193a;
            if (drawable5 == null) {
                drawable5 = a2[0];
            }
            if (drawable2 == null) {
                drawable2 = a2[1];
            }
            if (drawable6 == null) {
                drawable6 = a2[2];
            }
            if (drawable4 == null) {
                drawable4 = a2[3];
            }
            Api17Impl.b(textView, drawable5, drawable2, drawable6, drawable4);
        } else if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
            Drawable[] a3 = Api17Impl.a(this.f1193a);
            Drawable drawable7 = a3[0];
            if (drawable7 == null && a3[2] == null) {
                Drawable[] compoundDrawables = this.f1193a.getCompoundDrawables();
                TextView textView2 = this.f1193a;
                if (drawable == null) {
                    drawable = compoundDrawables[0];
                }
                if (drawable2 == null) {
                    drawable2 = compoundDrawables[1];
                }
                if (drawable3 == null) {
                    drawable3 = compoundDrawables[2];
                }
                if (drawable4 == null) {
                    drawable4 = compoundDrawables[3];
                }
                textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
                return;
            }
            TextView textView3 = this.f1193a;
            if (drawable2 == null) {
                drawable2 = a3[1];
            }
            Drawable drawable8 = a3[2];
            if (drawable4 == null) {
                drawable4 = a3[3];
            }
            Api17Impl.b(textView3, drawable7, drawable2, drawable8, drawable4);
        }
    }

    private void z() {
        TintInfo tintInfo = this.f1200h;
        this.f1194b = tintInfo;
        this.f1195c = tintInfo;
        this.f1196d = tintInfo;
        this.f1197e = tintInfo;
        this.f1198f = tintInfo;
        this.f1199g = tintInfo;
    }

    /* access modifiers changed from: package-private */
    public void A(int i2, float f2) {
        if (!ViewUtils.f1552b && !l()) {
            B(i2, f2);
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (!(this.f1194b == null && this.f1195c == null && this.f1196d == null && this.f1197e == null)) {
            Drawable[] compoundDrawables = this.f1193a.getCompoundDrawables();
            a(compoundDrawables[0], this.f1194b);
            a(compoundDrawables[1], this.f1195c);
            a(compoundDrawables[2], this.f1196d);
            a(compoundDrawables[3], this.f1197e);
        }
        if (this.f1198f != null || this.f1199g != null) {
            Drawable[] a2 = Api17Impl.a(this.f1193a);
            a(a2[0], this.f1198f);
            a(a2[2], this.f1199g);
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f1201i.a();
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f1201i.f();
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f1201i.g();
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.f1201i.h();
    }

    /* access modifiers changed from: package-private */
    public int[] h() {
        return this.f1201i.i();
    }

    /* access modifiers changed from: package-private */
    public int i() {
        return this.f1201i.j();
    }

    /* access modifiers changed from: package-private */
    public ColorStateList j() {
        TintInfo tintInfo = this.f1200h;
        if (tintInfo != null) {
            return tintInfo.f1461a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode k() {
        TintInfo tintInfo = this.f1200h;
        if (tintInfo != null) {
            return tintInfo.f1462b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return this.f1201i.n();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01e5  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0221  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0264  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x026d  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0273  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x027c  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x028b  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0291  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x02a0  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x02a9  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x02af  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x02c3  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x02d4  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x02e4  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x02fc  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0303  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x030a  */
    /* JADX WARNING: Removed duplicated region for block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01ca  */
    @android.annotation.SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m(android.util.AttributeSet r24, int r25) {
        /*
            r23 = this;
            r7 = r23
            r8 = r24
            r9 = r25
            android.widget.TextView r0 = r7.f1193a
            android.content.Context r10 = r0.getContext()
            androidx.appcompat.widget.AppCompatDrawableManager r11 = androidx.appcompat.widget.AppCompatDrawableManager.b()
            int[] r2 = androidx.appcompat.R$styleable.f236a0
            r12 = 0
            androidx.appcompat.widget.TintTypedArray r13 = androidx.appcompat.widget.TintTypedArray.v(r10, r8, r2, r9, r12)
            android.widget.TextView r0 = r7.f1193a
            android.content.Context r1 = r0.getContext()
            android.content.res.TypedArray r4 = r13.r()
            r6 = 0
            r3 = r24
            r5 = r25
            androidx.core.view.ViewCompat.p0(r0, r1, r2, r3, r4, r5, r6)
            int r0 = androidx.appcompat.R$styleable.f239b0
            r14 = -1
            int r0 = r13.n(r0, r14)
            int r1 = androidx.appcompat.R$styleable.f248e0
            boolean r2 = r13.s(r1)
            if (r2 == 0) goto L_0x0042
            int r1 = r13.n(r1, r12)
            androidx.appcompat.widget.TintInfo r1 = d(r10, r11, r1)
            r7.f1194b = r1
        L_0x0042:
            int r1 = androidx.appcompat.R$styleable.f242c0
            boolean r2 = r13.s(r1)
            if (r2 == 0) goto L_0x0054
            int r1 = r13.n(r1, r12)
            androidx.appcompat.widget.TintInfo r1 = d(r10, r11, r1)
            r7.f1195c = r1
        L_0x0054:
            int r1 = androidx.appcompat.R$styleable.f251f0
            boolean r2 = r13.s(r1)
            if (r2 == 0) goto L_0x0066
            int r1 = r13.n(r1, r12)
            androidx.appcompat.widget.TintInfo r1 = d(r10, r11, r1)
            r7.f1196d = r1
        L_0x0066:
            int r1 = androidx.appcompat.R$styleable.f245d0
            boolean r2 = r13.s(r1)
            if (r2 == 0) goto L_0x0078
            int r1 = r13.n(r1, r12)
            androidx.appcompat.widget.TintInfo r1 = d(r10, r11, r1)
            r7.f1197e = r1
        L_0x0078:
            int r1 = android.os.Build.VERSION.SDK_INT
            int r2 = androidx.appcompat.R$styleable.f254g0
            boolean r3 = r13.s(r2)
            if (r3 == 0) goto L_0x008c
            int r2 = r13.n(r2, r12)
            androidx.appcompat.widget.TintInfo r2 = d(r10, r11, r2)
            r7.f1198f = r2
        L_0x008c:
            int r2 = androidx.appcompat.R$styleable.f257h0
            boolean r3 = r13.s(r2)
            if (r3 == 0) goto L_0x009e
            int r2 = r13.n(r2, r12)
            androidx.appcompat.widget.TintInfo r2 = d(r10, r11, r2)
            r7.f1199g = r2
        L_0x009e:
            r13.w()
            android.widget.TextView r2 = r7.f1193a
            android.text.method.TransformationMethod r2 = r2.getTransformationMethod()
            boolean r2 = r2 instanceof android.text.method.PasswordTransformationMethod
            r3 = 26
            r5 = 23
            if (r0 == r14) goto L_0x011a
            int[] r6 = androidx.appcompat.R$styleable.c3
            androidx.appcompat.widget.TintTypedArray r0 = androidx.appcompat.widget.TintTypedArray.t(r10, r0, r6)
            if (r2 != 0) goto L_0x00c5
            int r6 = androidx.appcompat.R$styleable.r3
            boolean r15 = r0.s(r6)
            if (r15 == 0) goto L_0x00c5
            boolean r6 = r0.a(r6, r12)
            r15 = 1
            goto L_0x00c7
        L_0x00c5:
            r6 = 0
            r15 = 0
        L_0x00c7:
            r7.C(r10, r0)
            if (r1 >= r5) goto L_0x00f5
            int r4 = androidx.appcompat.R$styleable.g3
            boolean r17 = r0.s(r4)
            if (r17 == 0) goto L_0x00d9
            android.content.res.ColorStateList r4 = r0.c(r4)
            goto L_0x00da
        L_0x00d9:
            r4 = 0
        L_0x00da:
            int r13 = androidx.appcompat.R$styleable.h3
            boolean r18 = r0.s(r13)
            if (r18 == 0) goto L_0x00e7
            android.content.res.ColorStateList r13 = r0.c(r13)
            goto L_0x00e8
        L_0x00e7:
            r13 = 0
        L_0x00e8:
            int r14 = androidx.appcompat.R$styleable.i3
            boolean r19 = r0.s(r14)
            if (r19 == 0) goto L_0x00f7
            android.content.res.ColorStateList r14 = r0.c(r14)
            goto L_0x00f8
        L_0x00f5:
            r4 = 0
            r13 = 0
        L_0x00f7:
            r14 = 0
        L_0x00f8:
            int r5 = androidx.appcompat.R$styleable.s3
            boolean r20 = r0.s(r5)
            if (r20 == 0) goto L_0x0105
            java.lang.String r5 = r0.o(r5)
            goto L_0x0106
        L_0x0105:
            r5 = 0
        L_0x0106:
            if (r1 < r3) goto L_0x0115
            int r3 = androidx.appcompat.R$styleable.q3
            boolean r21 = r0.s(r3)
            if (r21 == 0) goto L_0x0115
            java.lang.String r3 = r0.o(r3)
            goto L_0x0116
        L_0x0115:
            r3 = 0
        L_0x0116:
            r0.w()
            goto L_0x0121
        L_0x011a:
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x0121:
            int[] r0 = androidx.appcompat.R$styleable.c3
            androidx.appcompat.widget.TintTypedArray r0 = androidx.appcompat.widget.TintTypedArray.v(r10, r8, r0, r9, r12)
            if (r2 != 0) goto L_0x013c
            int r12 = androidx.appcompat.R$styleable.r3
            boolean r22 = r0.s(r12)
            if (r22 == 0) goto L_0x013c
            r22 = r3
            r3 = 0
            boolean r6 = r0.a(r12, r3)
            r3 = 23
            r15 = 1
            goto L_0x0140
        L_0x013c:
            r22 = r3
            r3 = 23
        L_0x0140:
            if (r1 >= r3) goto L_0x0166
            int r3 = androidx.appcompat.R$styleable.g3
            boolean r12 = r0.s(r3)
            if (r12 == 0) goto L_0x014e
            android.content.res.ColorStateList r4 = r0.c(r3)
        L_0x014e:
            int r3 = androidx.appcompat.R$styleable.h3
            boolean r12 = r0.s(r3)
            if (r12 == 0) goto L_0x015a
            android.content.res.ColorStateList r13 = r0.c(r3)
        L_0x015a:
            int r3 = androidx.appcompat.R$styleable.i3
            boolean r12 = r0.s(r3)
            if (r12 == 0) goto L_0x0166
            android.content.res.ColorStateList r14 = r0.c(r3)
        L_0x0166:
            int r3 = androidx.appcompat.R$styleable.s3
            boolean r12 = r0.s(r3)
            if (r12 == 0) goto L_0x0172
            java.lang.String r5 = r0.o(r3)
        L_0x0172:
            r3 = 26
            if (r1 < r3) goto L_0x0183
            int r3 = androidx.appcompat.R$styleable.q3
            boolean r12 = r0.s(r3)
            if (r12 == 0) goto L_0x0183
            java.lang.String r3 = r0.o(r3)
            goto L_0x0185
        L_0x0183:
            r3 = r22
        L_0x0185:
            r12 = 28
            if (r1 < r12) goto L_0x01a2
            int r12 = androidx.appcompat.R$styleable.d3
            boolean r16 = r0.s(r12)
            if (r16 == 0) goto L_0x01a2
            r16 = r11
            r11 = -1
            int r12 = r0.f(r12, r11)
            if (r12 != 0) goto L_0x01a4
            android.widget.TextView r11 = r7.f1193a
            r12 = 0
            r8 = 0
            r11.setTextSize(r8, r12)
            goto L_0x01a4
        L_0x01a2:
            r16 = r11
        L_0x01a4:
            r7.C(r10, r0)
            r0.w()
            if (r4 == 0) goto L_0x01b1
            android.widget.TextView r0 = r7.f1193a
            r0.setTextColor(r4)
        L_0x01b1:
            if (r13 == 0) goto L_0x01b8
            android.widget.TextView r0 = r7.f1193a
            r0.setHintTextColor(r13)
        L_0x01b8:
            if (r14 == 0) goto L_0x01bf
            android.widget.TextView r0 = r7.f1193a
            r0.setLinkTextColor(r14)
        L_0x01bf:
            if (r2 != 0) goto L_0x01c6
            if (r15 == 0) goto L_0x01c6
            r7.s(r6)
        L_0x01c6:
            android.graphics.Typeface r0 = r7.f1204l
            if (r0 == 0) goto L_0x01dc
            int r2 = r7.f1203k
            r4 = -1
            if (r2 != r4) goto L_0x01d7
            android.widget.TextView r2 = r7.f1193a
            int r4 = r7.f1202j
            r2.setTypeface(r0, r4)
            goto L_0x01dc
        L_0x01d7:
            android.widget.TextView r2 = r7.f1193a
            r2.setTypeface(r0)
        L_0x01dc:
            if (r3 == 0) goto L_0x01e3
            android.widget.TextView r0 = r7.f1193a
            androidx.appcompat.widget.AppCompatTextHelper.Api26Impl.d(r0, r3)
        L_0x01e3:
            if (r5 == 0) goto L_0x0205
            r0 = 24
            if (r1 < r0) goto L_0x01f3
            android.widget.TextView r0 = r7.f1193a
            android.os.LocaleList r1 = androidx.appcompat.widget.AppCompatTextHelper.Api24Impl.a(r5)
            androidx.appcompat.widget.AppCompatTextHelper.Api24Impl.b(r0, r1)
            goto L_0x0205
        L_0x01f3:
            java.lang.String r0 = ","
            java.lang.String[] r0 = r5.split(r0)
            r1 = 0
            r0 = r0[r1]
            android.widget.TextView r1 = r7.f1193a
            java.util.Locale r0 = androidx.appcompat.widget.AppCompatTextHelper.Api21Impl.a(r0)
            androidx.appcompat.widget.AppCompatTextHelper.Api17Impl.c(r1, r0)
        L_0x0205:
            androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper r0 = r7.f1201i
            r1 = r24
            r0.o(r1, r9)
            boolean r0 = androidx.appcompat.widget.ViewUtils.f1552b
            if (r0 == 0) goto L_0x024d
            androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper r0 = r7.f1201i
            int r0 = r0.j()
            if (r0 == 0) goto L_0x024d
            androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper r0 = r7.f1201i
            int[] r0 = r0.i()
            int r2 = r0.length
            if (r2 <= 0) goto L_0x024d
            android.widget.TextView r2 = r7.f1193a
            int r2 = androidx.appcompat.widget.AppCompatTextHelper.Api26Impl.a(r2)
            float r2 = (float) r2
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x0247
            android.widget.TextView r0 = r7.f1193a
            androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper r2 = r7.f1201i
            int r2 = r2.g()
            androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper r3 = r7.f1201i
            int r3 = r3.f()
            androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper r4 = r7.f1201i
            int r4 = r4.h()
            r5 = 0
            androidx.appcompat.widget.AppCompatTextHelper.Api26Impl.b(r0, r2, r3, r4, r5)
            goto L_0x024d
        L_0x0247:
            r5 = 0
            android.widget.TextView r2 = r7.f1193a
            androidx.appcompat.widget.AppCompatTextHelper.Api26Impl.c(r2, r0, r5)
        L_0x024d:
            int[] r0 = androidx.appcompat.R$styleable.f260i0
            androidx.appcompat.widget.TintTypedArray r8 = androidx.appcompat.widget.TintTypedArray.u(r10, r1, r0)
            int r0 = androidx.appcompat.R$styleable.f284q0
            r1 = -1
            int r0 = r8.n(r0, r1)
            r2 = r16
            if (r0 == r1) goto L_0x0264
            android.graphics.drawable.Drawable r0 = r2.c(r10, r0)
            r3 = r0
            goto L_0x0265
        L_0x0264:
            r3 = 0
        L_0x0265:
            int r0 = androidx.appcompat.R$styleable.f297v0
            int r0 = r8.n(r0, r1)
            if (r0 == r1) goto L_0x0273
            android.graphics.drawable.Drawable r0 = r2.c(r10, r0)
            r4 = r0
            goto L_0x0274
        L_0x0273:
            r4 = 0
        L_0x0274:
            int r0 = androidx.appcompat.R$styleable.f287r0
            int r0 = r8.n(r0, r1)
            if (r0 == r1) goto L_0x0282
            android.graphics.drawable.Drawable r0 = r2.c(r10, r0)
            r5 = r0
            goto L_0x0283
        L_0x0282:
            r5 = 0
        L_0x0283:
            int r0 = androidx.appcompat.R$styleable.f278o0
            int r0 = r8.n(r0, r1)
            if (r0 == r1) goto L_0x0291
            android.graphics.drawable.Drawable r0 = r2.c(r10, r0)
            r6 = r0
            goto L_0x0292
        L_0x0291:
            r6 = 0
        L_0x0292:
            int r0 = androidx.appcompat.R$styleable.f290s0
            int r0 = r8.n(r0, r1)
            if (r0 == r1) goto L_0x02a0
            android.graphics.drawable.Drawable r0 = r2.c(r10, r0)
            r9 = r0
            goto L_0x02a1
        L_0x02a0:
            r9 = 0
        L_0x02a1:
            int r0 = androidx.appcompat.R$styleable.f281p0
            int r0 = r8.n(r0, r1)
            if (r0 == r1) goto L_0x02af
            android.graphics.drawable.Drawable r0 = r2.c(r10, r0)
            r10 = r0
            goto L_0x02b0
        L_0x02af:
            r10 = 0
        L_0x02b0:
            r0 = r23
            r1 = r3
            r2 = r4
            r3 = r5
            r4 = r6
            r5 = r9
            r6 = r10
            r0.y(r1, r2, r3, r4, r5, r6)
            int r0 = androidx.appcompat.R$styleable.f293t0
            boolean r1 = r8.s(r0)
            if (r1 == 0) goto L_0x02cc
            android.content.res.ColorStateList r0 = r8.c(r0)
            android.widget.TextView r1 = r7.f1193a
            androidx.core.widget.TextViewCompat.h(r1, r0)
        L_0x02cc:
            int r0 = androidx.appcompat.R$styleable.f295u0
            boolean r1 = r8.s(r0)
            if (r1 == 0) goto L_0x02e4
            r1 = -1
            int r0 = r8.k(r0, r1)
            r2 = 0
            android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.DrawableUtils.e(r0, r2)
            android.widget.TextView r2 = r7.f1193a
            androidx.core.widget.TextViewCompat.i(r2, r0)
            goto L_0x02e5
        L_0x02e4:
            r1 = -1
        L_0x02e5:
            int r0 = androidx.appcompat.R$styleable.f301x0
            int r0 = r8.f(r0, r1)
            int r2 = androidx.appcompat.R$styleable.f303y0
            int r2 = r8.f(r2, r1)
            int r3 = androidx.appcompat.R$styleable.f305z0
            int r3 = r8.f(r3, r1)
            r8.w()
            if (r0 == r1) goto L_0x0301
            android.widget.TextView r4 = r7.f1193a
            androidx.core.widget.TextViewCompat.k(r4, r0)
        L_0x0301:
            if (r2 == r1) goto L_0x0308
            android.widget.TextView r0 = r7.f1193a
            androidx.core.widget.TextViewCompat.l(r0, r2)
        L_0x0308:
            if (r3 == r1) goto L_0x030f
            android.widget.TextView r0 = r7.f1193a
            androidx.core.widget.TextViewCompat.m(r0, r3)
        L_0x030f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatTextHelper.m(android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: package-private */
    public void n(WeakReference<TextView> weakReference, final Typeface typeface) {
        if (this.f1205m) {
            this.f1204l = typeface;
            final TextView textView = weakReference.get();
            if (textView == null) {
                return;
            }
            if (ViewCompat.U(textView)) {
                final int i2 = this.f1202j;
                textView.post(new Runnable() {
                    public void run() {
                        textView.setTypeface(typeface, i2);
                    }
                });
                return;
            }
            textView.setTypeface(typeface, this.f1202j);
        }
    }

    /* access modifiers changed from: package-private */
    public void o(boolean z2, int i2, int i3, int i4, int i5) {
        if (!ViewUtils.f1552b) {
            c();
        }
    }

    /* access modifiers changed from: package-private */
    public void p() {
        b();
    }

    /* access modifiers changed from: package-private */
    public void q(Context context, int i2) {
        String o2;
        ColorStateList c2;
        ColorStateList c3;
        ColorStateList c4;
        TintTypedArray t2 = TintTypedArray.t(context, i2, R$styleable.c3);
        int i3 = R$styleable.r3;
        if (t2.s(i3)) {
            s(t2.a(i3, false));
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 23) {
            int i5 = R$styleable.g3;
            if (t2.s(i5) && (c4 = t2.c(i5)) != null) {
                this.f1193a.setTextColor(c4);
            }
            int i6 = R$styleable.i3;
            if (t2.s(i6) && (c3 = t2.c(i6)) != null) {
                this.f1193a.setLinkTextColor(c3);
            }
            int i7 = R$styleable.h3;
            if (t2.s(i7) && (c2 = t2.c(i7)) != null) {
                this.f1193a.setHintTextColor(c2);
            }
        }
        int i8 = R$styleable.d3;
        if (t2.s(i8) && t2.f(i8, -1) == 0) {
            this.f1193a.setTextSize(0, 0.0f);
        }
        C(context, t2);
        if (i4 >= 26) {
            int i9 = R$styleable.q3;
            if (t2.s(i9) && (o2 = t2.o(i9)) != null) {
                Api26Impl.d(this.f1193a, o2);
            }
        }
        t2.w();
        Typeface typeface = this.f1204l;
        if (typeface != null) {
            this.f1193a.setTypeface(typeface, this.f1202j);
        }
    }

    /* access modifiers changed from: package-private */
    public void r(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT < 30 && inputConnection != null) {
            EditorInfoCompat.f(editorInfo, textView.getText());
        }
    }

    /* access modifiers changed from: package-private */
    public void s(boolean z2) {
        this.f1193a.setAllCaps(z2);
    }

    /* access modifiers changed from: package-private */
    public void t(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        this.f1201i.p(i2, i3, i4, i5);
    }

    /* access modifiers changed from: package-private */
    public void u(int[] iArr, int i2) throws IllegalArgumentException {
        this.f1201i.q(iArr, i2);
    }

    /* access modifiers changed from: package-private */
    public void v(int i2) {
        this.f1201i.r(i2);
    }

    /* access modifiers changed from: package-private */
    public void w(ColorStateList colorStateList) {
        boolean z2;
        if (this.f1200h == null) {
            this.f1200h = new TintInfo();
        }
        TintInfo tintInfo = this.f1200h;
        tintInfo.f1461a = colorStateList;
        if (colorStateList != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        tintInfo.f1464d = z2;
        z();
    }

    /* access modifiers changed from: package-private */
    public void x(PorterDuff.Mode mode) {
        boolean z2;
        if (this.f1200h == null) {
            this.f1200h = new TintInfo();
        }
        TintInfo tintInfo = this.f1200h;
        tintInfo.f1462b = mode;
        if (mode != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        tintInfo.f1463c = z2;
        z();
    }
}
