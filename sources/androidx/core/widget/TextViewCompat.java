package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.text.Editable;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.util.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class TextViewCompat {

    static class Api16Impl {
        private Api16Impl() {
        }

        static boolean a(TextView textView) {
            return textView.getIncludeFontPadding();
        }

        static int b(TextView textView) {
            return textView.getMaxLines();
        }

        static int c(TextView textView) {
            return textView.getMinLines();
        }
    }

    static class Api17Impl {
        private Api17Impl() {
        }

        static Drawable[] a(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }

        static int b(View view) {
            return view.getLayoutDirection();
        }

        static int c(View view) {
            return view.getTextDirection();
        }

        static Locale d(TextView textView) {
            return textView.getTextLocale();
        }

        static void e(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        }

        static void f(TextView textView, int i2, int i3, int i4, int i5) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(i2, i3, i4, i5);
        }

        static void g(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }

        static void h(View view, int i2) {
            view.setTextDirection(i2);
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static int a(TextView textView) {
            return textView.getBreakStrategy();
        }

        static ColorStateList b(TextView textView) {
            return textView.getCompoundDrawableTintList();
        }

        static PorterDuff.Mode c(TextView textView) {
            return textView.getCompoundDrawableTintMode();
        }

        static int d(TextView textView) {
            return textView.getHyphenationFrequency();
        }

        static void e(TextView textView, int i2) {
            textView.setBreakStrategy(i2);
        }

        static void f(TextView textView, ColorStateList colorStateList) {
            textView.setCompoundDrawableTintList(colorStateList);
        }

        static void g(TextView textView, PorterDuff.Mode mode) {
            textView.setCompoundDrawableTintMode(mode);
        }

        static void h(TextView textView, int i2) {
            textView.setHyphenationFrequency(i2);
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static DecimalFormatSymbols a(Locale locale) {
            return DecimalFormatSymbols.getInstance(locale);
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static String[] a(DecimalFormatSymbols decimalFormatSymbols) {
            return decimalFormatSymbols.getDigitStrings();
        }

        static PrecomputedText.Params b(TextView textView) {
            return textView.getTextMetricsParams();
        }

        static void c(TextView textView, int i2) {
            textView.setFirstBaselineToTopHeight(i2);
        }
    }

    private static class OreoCallback implements ActionMode.Callback {

        /* renamed from: a  reason: collision with root package name */
        private final ActionMode.Callback f2968a;

        /* renamed from: b  reason: collision with root package name */
        private final TextView f2969b;

        /* renamed from: c  reason: collision with root package name */
        private Class<?> f2970c;

        /* renamed from: d  reason: collision with root package name */
        private Method f2971d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f2972e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f2973f = false;

        OreoCallback(ActionMode.Callback callback, TextView textView) {
            this.f2968a = callback;
            this.f2969b = textView;
        }

        private Intent a() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }

        private Intent b(ResolveInfo resolveInfo, TextView textView) {
            Intent putExtra = a().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !e(textView));
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            return putExtra.setClassName(activityInfo.packageName, activityInfo.name);
        }

        private List<ResolveInfo> c(Context context, PackageManager packageManager) {
            ArrayList arrayList = new ArrayList();
            if (!(context instanceof Activity)) {
                return arrayList;
            }
            for (ResolveInfo next : packageManager.queryIntentActivities(a(), 0)) {
                if (f(next, context)) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        }

        private boolean e(TextView textView) {
            if (!(textView instanceof Editable) || !textView.onCheckIsTextEditor() || !textView.isEnabled()) {
                return false;
            }
            return true;
        }

        private boolean f(ResolveInfo resolveInfo, Context context) {
            if (context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                return true;
            }
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (!activityInfo.exported) {
                return false;
            }
            String str = activityInfo.permission;
            if (str == null || context.checkSelfPermission(str) == 0) {
                return true;
            }
            return false;
        }

        private void g(Menu menu) {
            Method method;
            Context context = this.f2969b.getContext();
            PackageManager packageManager = context.getPackageManager();
            if (!this.f2973f) {
                this.f2973f = true;
                try {
                    Class<?> cls = Class.forName("com.android.internal.view.menu.MenuBuilder");
                    this.f2970c = cls;
                    this.f2971d = cls.getDeclaredMethod("removeItemAt", new Class[]{Integer.TYPE});
                    this.f2972e = true;
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    this.f2970c = null;
                    this.f2971d = null;
                    this.f2972e = false;
                }
            }
            try {
                if (!this.f2972e || !this.f2970c.isInstance(menu)) {
                    method = menu.getClass().getDeclaredMethod("removeItemAt", new Class[]{Integer.TYPE});
                } else {
                    method = this.f2971d;
                }
                for (int size = menu.size() - 1; size >= 0; size--) {
                    MenuItem item = menu.getItem(size);
                    if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                        method.invoke(menu, new Object[]{Integer.valueOf(size)});
                    }
                }
                List<ResolveInfo> c2 = c(context, packageManager);
                for (int i2 = 0; i2 < c2.size(); i2++) {
                    ResolveInfo resolveInfo = c2.get(i2);
                    menu.add(0, 0, i2 + 100, resolveInfo.loadLabel(packageManager)).setIntent(b(resolveInfo, this.f2969b)).setShowAsAction(1);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }

        /* access modifiers changed from: package-private */
        public ActionMode.Callback d() {
            return this.f2968a;
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f2968a.onActionItemClicked(actionMode, menuItem);
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f2968a.onCreateActionMode(actionMode, menu);
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            this.f2968a.onDestroyActionMode(actionMode);
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            g(menu);
            return this.f2968a.onPrepareActionMode(actionMode, menu);
        }
    }

    private TextViewCompat() {
    }

    public static Drawable[] a(TextView textView) {
        return Api17Impl.a(textView);
    }

    public static int b(TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    public static int c(TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    public static int d(TextView textView) {
        return Api16Impl.b(textView);
    }

    private static int e(TextDirectionHeuristic textDirectionHeuristic) {
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL || textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 1;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
            return 3;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
            return 4;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
            return 5;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 6;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
            return 7;
        }
        return 1;
    }

    private static TextDirectionHeuristic f(TextView textView) {
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            return TextDirectionHeuristics.LTR;
        }
        boolean z2 = false;
        if (Build.VERSION.SDK_INT < 28 || (textView.getInputType() & 15) != 3) {
            if (Api17Impl.b(textView) == 1) {
                z2 = true;
            }
            switch (Api17Impl.c(textView)) {
                case 2:
                    return TextDirectionHeuristics.ANYRTL_LTR;
                case 3:
                    return TextDirectionHeuristics.LTR;
                case 4:
                    return TextDirectionHeuristics.RTL;
                case 5:
                    return TextDirectionHeuristics.LOCALE;
                case 6:
                    return TextDirectionHeuristics.FIRSTSTRONG_LTR;
                case 7:
                    return TextDirectionHeuristics.FIRSTSTRONG_RTL;
                default:
                    if (z2) {
                        return TextDirectionHeuristics.FIRSTSTRONG_RTL;
                    }
                    return TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }
        } else {
            byte directionality = Character.getDirectionality(Api28Impl.a(Api24Impl.a(Api17Impl.d(textView)))[0].codePointAt(0));
            if (directionality == 1 || directionality == 2) {
                return TextDirectionHeuristics.RTL;
            }
            return TextDirectionHeuristics.LTR;
        }
    }

    public static PrecomputedTextCompat.Params g(TextView textView) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            return new PrecomputedTextCompat.Params(Api28Impl.b(textView));
        }
        PrecomputedTextCompat.Params.Builder builder = new PrecomputedTextCompat.Params.Builder(new TextPaint(textView.getPaint()));
        if (i2 >= 23) {
            builder.b(Api23Impl.a(textView));
            builder.c(Api23Impl.d(textView));
        }
        builder.d(f(textView));
        return builder.a();
    }

    public static void h(TextView textView, ColorStateList colorStateList) {
        Preconditions.g(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            Api23Impl.f(textView, colorStateList);
        } else if (textView instanceof TintableCompoundDrawablesView) {
            ((TintableCompoundDrawablesView) textView).setSupportCompoundDrawablesTintList(colorStateList);
        }
    }

    public static void i(TextView textView, PorterDuff.Mode mode) {
        Preconditions.g(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            Api23Impl.g(textView, mode);
        } else if (textView instanceof TintableCompoundDrawablesView) {
            ((TintableCompoundDrawablesView) textView).setSupportCompoundDrawablesTintMode(mode);
        }
    }

    public static void j(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        Api17Impl.e(textView, drawable, drawable2, drawable3, drawable4);
    }

    public static void k(TextView textView, int i2) {
        int i3;
        Preconditions.d(i2);
        if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.c(textView, i2);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (Api16Impl.a(textView)) {
            i3 = fontMetricsInt.top;
        } else {
            i3 = fontMetricsInt.ascent;
        }
        if (i2 > Math.abs(i3)) {
            textView.setPadding(textView.getPaddingLeft(), i2 + i3, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void l(TextView textView, int i2) {
        int i3;
        Preconditions.d(i2);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (Api16Impl.a(textView)) {
            i3 = fontMetricsInt.bottom;
        } else {
            i3 = fontMetricsInt.descent;
        }
        if (i2 > Math.abs(i3)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i2 - i3);
        }
    }

    public static void m(TextView textView, int i2) {
        Preconditions.d(i2);
        int fontMetricsInt = textView.getPaint().getFontMetricsInt((Paint.FontMetricsInt) null);
        if (i2 != fontMetricsInt) {
            textView.setLineSpacing((float) (i2 - fontMetricsInt), 1.0f);
        }
    }

    public static void n(TextView textView, PrecomputedTextCompat precomputedTextCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            textView.setText(precomputedTextCompat.b());
        } else if (g(textView).a(precomputedTextCompat.a())) {
            textView.setText(precomputedTextCompat);
        } else {
            throw new IllegalArgumentException("Given text can not be applied to TextView.");
        }
    }

    public static void o(TextView textView, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i2);
        } else {
            textView.setTextAppearance(textView.getContext(), i2);
        }
    }

    public static void p(TextView textView, PrecomputedTextCompat.Params params) {
        int i2 = Build.VERSION.SDK_INT;
        Api17Impl.h(textView, e(params.d()));
        if (i2 < 23) {
            float textScaleX = params.e().getTextScaleX();
            textView.getPaint().set(params.e());
            if (textScaleX == textView.getTextScaleX()) {
                textView.setTextScaleX((textScaleX / 2.0f) + 1.0f);
            }
            textView.setTextScaleX(textScaleX);
            return;
        }
        textView.getPaint().set(params.e());
        Api23Impl.e(textView, params.b());
        Api23Impl.h(textView, params.c());
    }

    public static ActionMode.Callback q(ActionMode.Callback callback) {
        if (!(callback instanceof OreoCallback) || Build.VERSION.SDK_INT < 26) {
            return callback;
        }
        return ((OreoCallback) callback).d();
    }

    public static ActionMode.Callback r(TextView textView, ActionMode.Callback callback) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 26 || i2 > 27 || (callback instanceof OreoCallback) || callback == null) {
            return callback;
        }
        return new OreoCallback(callback, textView);
    }
}
