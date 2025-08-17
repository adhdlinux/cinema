package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

class AppCompatTextViewAutoSizeHelper {

    /* renamed from: l  reason: collision with root package name */
    private static final RectF f1216l = new RectF();
    @SuppressLint({"BanConcurrentHashMap"})

    /* renamed from: m  reason: collision with root package name */
    private static ConcurrentHashMap<String, Method> f1217m = new ConcurrentHashMap<>();
    @SuppressLint({"BanConcurrentHashMap"})

    /* renamed from: n  reason: collision with root package name */
    private static ConcurrentHashMap<String, Field> f1218n = new ConcurrentHashMap<>();

    /* renamed from: a  reason: collision with root package name */
    private int f1219a = 0;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1220b = false;

    /* renamed from: c  reason: collision with root package name */
    private float f1221c = -1.0f;

    /* renamed from: d  reason: collision with root package name */
    private float f1222d = -1.0f;

    /* renamed from: e  reason: collision with root package name */
    private float f1223e = -1.0f;

    /* renamed from: f  reason: collision with root package name */
    private int[] f1224f = new int[0];

    /* renamed from: g  reason: collision with root package name */
    private boolean f1225g = false;

    /* renamed from: h  reason: collision with root package name */
    private TextPaint f1226h;

    /* renamed from: i  reason: collision with root package name */
    private final TextView f1227i;

    /* renamed from: j  reason: collision with root package name */
    private final Context f1228j;

    /* renamed from: k  reason: collision with root package name */
    private final Impl f1229k;

    private static final class Api16Impl {
        private Api16Impl() {
        }

        static StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i2, TextView textView, TextPaint textPaint) {
            return new StaticLayout(charSequence, textPaint, i2, alignment, textView.getLineSpacingMultiplier(), textView.getLineSpacingExtra(), textView.getIncludeFontPadding());
        }

        static int b(TextView textView) {
            return textView.getMaxLines();
        }
    }

    private static final class Api18Impl {
        private Api18Impl() {
        }

        static boolean a(View view) {
            return view.isInLayout();
        }
    }

    private static final class Api23Impl {
        private Api23Impl() {
        }

        static StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i2, int i3, TextView textView, TextPaint textPaint, Impl impl) {
            StaticLayout.Builder a2 = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i2);
            StaticLayout.Builder a3 = a2.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
            if (i3 == -1) {
                i3 = Integer.MAX_VALUE;
            }
            StaticLayout.Builder unused = a3.setMaxLines(i3);
            try {
                impl.a(a2, textView);
            } catch (ClassCastException unused2) {
                Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            }
            return a2.build();
        }
    }

    private static class Impl {
        Impl() {
        }

        /* access modifiers changed from: package-private */
        public void a(StaticLayout.Builder builder, TextView textView) {
        }

        /* access modifiers changed from: package-private */
        public boolean b(TextView textView) {
            return ((Boolean) AppCompatTextViewAutoSizeHelper.m(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    private static class Impl23 extends Impl {
        Impl23() {
        }

        /* access modifiers changed from: package-private */
        public void a(StaticLayout.Builder builder, TextView textView) {
            StaticLayout.Builder unused = builder.setTextDirection((TextDirectionHeuristic) AppCompatTextViewAutoSizeHelper.m(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    private static class Impl29 extends Impl23 {
        Impl29() {
        }

        /* access modifiers changed from: package-private */
        public void a(StaticLayout.Builder builder, TextView textView) {
            StaticLayout.Builder unused = builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        /* access modifiers changed from: package-private */
        public boolean b(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    AppCompatTextViewAutoSizeHelper(TextView textView) {
        this.f1227i = textView;
        this.f1228j = textView.getContext();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            this.f1229k = new Impl29();
        } else if (i2 >= 23) {
            this.f1229k = new Impl23();
        } else {
            this.f1229k = new Impl();
        }
    }

    private int[] b(int[] iArr) {
        if (r0 == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            if (i2 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i2)) < 0) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        if (r0 == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
        }
        return iArr2;
    }

    private void c() {
        this.f1219a = 0;
        this.f1222d = -1.0f;
        this.f1223e = -1.0f;
        this.f1221c = -1.0f;
        this.f1224f = new int[0];
        this.f1220b = false;
    }

    private int e(RectF rectF) {
        int length = this.f1224f.length;
        if (length != 0) {
            int i2 = 1;
            int i3 = length - 1;
            int i4 = 0;
            while (i2 <= i3) {
                int i5 = (i2 + i3) / 2;
                if (x(this.f1224f[i5], rectF)) {
                    int i6 = i5 + 1;
                    i4 = i2;
                    i2 = i6;
                } else {
                    i4 = i5 - 1;
                    i3 = i4;
                }
            }
            return this.f1224f[i4];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    private static Method k(String str) {
        try {
            Method method = f1217m.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                method.setAccessible(true);
                f1217m.put(str, method);
            }
            return method;
        } catch (Exception e2) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e2);
            return null;
        }
    }

    static <T> T m(Object obj, String str, T t2) {
        try {
            return k(str).invoke(obj, new Object[0]);
        } catch (Exception e2) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e2);
            return t2;
        }
    }

    private void s(float f2) {
        if (f2 != this.f1227i.getPaint().getTextSize()) {
            this.f1227i.getPaint().setTextSize(f2);
            boolean a2 = Api18Impl.a(this.f1227i);
            if (this.f1227i.getLayout() != null) {
                this.f1220b = false;
                try {
                    Method k2 = k("nullLayouts");
                    if (k2 != null) {
                        k2.invoke(this.f1227i, new Object[0]);
                    }
                } catch (Exception e2) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e2);
                }
                if (!a2) {
                    this.f1227i.requestLayout();
                } else {
                    this.f1227i.forceLayout();
                }
                this.f1227i.invalidate();
            }
        }
    }

    private boolean u() {
        if (!y() || this.f1219a != 1) {
            this.f1220b = false;
        } else {
            if (!this.f1225g || this.f1224f.length == 0) {
                int floor = ((int) Math.floor((double) ((this.f1223e - this.f1222d) / this.f1221c))) + 1;
                int[] iArr = new int[floor];
                for (int i2 = 0; i2 < floor; i2++) {
                    iArr[i2] = Math.round(this.f1222d + (((float) i2) * this.f1221c));
                }
                this.f1224f = b(iArr);
            }
            this.f1220b = true;
        }
        return this.f1220b;
    }

    private void v(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = typedArray.getDimensionPixelSize(i2, -1);
            }
            this.f1224f = b(iArr);
            w();
        }
    }

    private boolean w() {
        boolean z2;
        int[] iArr = this.f1224f;
        int length = iArr.length;
        if (length > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f1225g = z2;
        if (z2) {
            this.f1219a = 1;
            this.f1222d = (float) iArr[0];
            this.f1223e = (float) iArr[length - 1];
            this.f1221c = -1.0f;
        }
        return z2;
    }

    private boolean x(int i2, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f1227i.getText();
        TransformationMethod transformationMethod = this.f1227i.getTransformationMethod();
        if (!(transformationMethod == null || (transformation = transformationMethod.getTransformation(text, this.f1227i)) == null)) {
            text = transformation;
        }
        int b2 = Api16Impl.b(this.f1227i);
        l(i2);
        StaticLayout d2 = d(text, (Layout.Alignment) m(this.f1227i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), b2);
        if ((b2 == -1 || (d2.getLineCount() <= b2 && d2.getLineEnd(d2.getLineCount() - 1) == text.length())) && ((float) d2.getHeight()) <= rectF.bottom) {
            return true;
        }
        return false;
    }

    private boolean y() {
        return !(this.f1227i instanceof AppCompatEditText);
    }

    private void z(float f2, float f3, float f4) throws IllegalArgumentException {
        if (f2 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f2 + "px) is less or equal to (0px)");
        } else if (f3 <= f2) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f3 + "px) is less or equal to minimum auto-size text size (" + f2 + "px)");
        } else if (f4 > 0.0f) {
            this.f1219a = 1;
            this.f1222d = f2;
            this.f1223e = f3;
            this.f1221c = f4;
            this.f1225g = false;
        } else {
            throw new IllegalArgumentException("The auto-size step granularity (" + f4 + "px) is less or equal to (0px)");
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        int i2;
        if (n()) {
            if (this.f1220b) {
                if (this.f1227i.getMeasuredHeight() > 0 && this.f1227i.getMeasuredWidth() > 0) {
                    if (this.f1229k.b(this.f1227i)) {
                        i2 = 1048576;
                    } else {
                        i2 = (this.f1227i.getMeasuredWidth() - this.f1227i.getTotalPaddingLeft()) - this.f1227i.getTotalPaddingRight();
                    }
                    int height = (this.f1227i.getHeight() - this.f1227i.getCompoundPaddingBottom()) - this.f1227i.getCompoundPaddingTop();
                    if (i2 > 0 && height > 0) {
                        RectF rectF = f1216l;
                        synchronized (rectF) {
                            rectF.setEmpty();
                            rectF.right = (float) i2;
                            rectF.bottom = (float) height;
                            float e2 = (float) e(rectF);
                            if (e2 != this.f1227i.getTextSize()) {
                                t(0, e2);
                            }
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f1220b = true;
        }
    }

    /* access modifiers changed from: package-private */
    public StaticLayout d(CharSequence charSequence, Layout.Alignment alignment, int i2, int i3) {
        if (Build.VERSION.SDK_INT < 23) {
            return Api16Impl.a(charSequence, alignment, i2, this.f1227i, this.f1226h);
        }
        return Api23Impl.a(charSequence, alignment, i2, i3, this.f1227i, this.f1226h, this.f1229k);
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return Math.round(this.f1223e);
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return Math.round(this.f1222d);
    }

    /* access modifiers changed from: package-private */
    public int h() {
        return Math.round(this.f1221c);
    }

    /* access modifiers changed from: package-private */
    public int[] i() {
        return this.f1224f;
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return this.f1219a;
    }

    /* access modifiers changed from: package-private */
    public void l(int i2) {
        TextPaint textPaint = this.f1226h;
        if (textPaint == null) {
            this.f1226h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f1226h.set(this.f1227i.getPaint());
        this.f1226h.setTextSize((float) i2);
    }

    /* access modifiers changed from: package-private */
    public boolean n() {
        return y() && this.f1219a != 0;
    }

    /* access modifiers changed from: package-private */
    public void o(AttributeSet attributeSet, int i2) {
        float f2;
        float f3;
        float f4;
        int resourceId;
        Context context = this.f1228j;
        int[] iArr = R$styleable.f260i0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        TextView textView = this.f1227i;
        ViewCompat.p0(textView, textView.getContext(), iArr, attributeSet, obtainStyledAttributes, i2, 0);
        int i3 = R$styleable.f275n0;
        if (obtainStyledAttributes.hasValue(i3)) {
            this.f1219a = obtainStyledAttributes.getInt(i3, 0);
        }
        int i4 = R$styleable.f272m0;
        if (obtainStyledAttributes.hasValue(i4)) {
            f2 = obtainStyledAttributes.getDimension(i4, -1.0f);
        } else {
            f2 = -1.0f;
        }
        int i5 = R$styleable.f266k0;
        if (obtainStyledAttributes.hasValue(i5)) {
            f3 = obtainStyledAttributes.getDimension(i5, -1.0f);
        } else {
            f3 = -1.0f;
        }
        int i6 = R$styleable.f263j0;
        if (obtainStyledAttributes.hasValue(i6)) {
            f4 = obtainStyledAttributes.getDimension(i6, -1.0f);
        } else {
            f4 = -1.0f;
        }
        int i7 = R$styleable.f269l0;
        if (obtainStyledAttributes.hasValue(i7) && (resourceId = obtainStyledAttributes.getResourceId(i7, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            v(obtainTypedArray);
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (!y()) {
            this.f1219a = 0;
        } else if (this.f1219a == 1) {
            if (!this.f1225g) {
                DisplayMetrics displayMetrics = this.f1228j.getResources().getDisplayMetrics();
                if (f3 == -1.0f) {
                    f3 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (f4 == -1.0f) {
                    f4 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (f2 == -1.0f) {
                    f2 = 1.0f;
                }
                z(f3, f4, f2);
            }
            u();
        }
    }

    /* access modifiers changed from: package-private */
    public void p(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        if (y()) {
            DisplayMetrics displayMetrics = this.f1228j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(i5, (float) i2, displayMetrics), TypedValue.applyDimension(i5, (float) i3, displayMetrics), TypedValue.applyDimension(i5, (float) i4, displayMetrics));
            if (u()) {
                a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void q(int[] iArr, int i2) throws IllegalArgumentException {
        if (y()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i2 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f1228j.getResources().getDisplayMetrics();
                    for (int i3 = 0; i3 < length; i3++) {
                        iArr2[i3] = Math.round(TypedValue.applyDimension(i2, (float) iArr[i3], displayMetrics));
                    }
                }
                this.f1224f = b(iArr2);
                if (!w()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f1225g = false;
            }
            if (u()) {
                a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void r(int i2) {
        if (!y()) {
            return;
        }
        if (i2 == 0) {
            c();
        } else if (i2 == 1) {
            DisplayMetrics displayMetrics = this.f1228j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (u()) {
                a();
            }
        } else {
            throw new IllegalArgumentException("Unknown auto-size text type: " + i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void t(int i2, float f2) {
        Resources resources;
        Context context = this.f1228j;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        s(TypedValue.applyDimension(i2, f2, resources.getDisplayMetrics()));
    }
}
