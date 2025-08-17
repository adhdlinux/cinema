package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;

public class TintTypedArray {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1466a;

    /* renamed from: b  reason: collision with root package name */
    private final TypedArray f1467b;

    /* renamed from: c  reason: collision with root package name */
    private TypedValue f1468c;

    private TintTypedArray(Context context, TypedArray typedArray) {
        this.f1466a = context;
        this.f1467b = typedArray;
    }

    public static TintTypedArray t(Context context, int i2, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(i2, iArr));
    }

    public static TintTypedArray u(Context context, AttributeSet attributeSet, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static TintTypedArray v(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr, i2, i3));
    }

    public boolean a(int i2, boolean z2) {
        return this.f1467b.getBoolean(i2, z2);
    }

    public int b(int i2, int i3) {
        return this.f1467b.getColor(i2, i3);
    }

    public ColorStateList c(int i2) {
        int resourceId;
        ColorStateList a2;
        if (!this.f1467b.hasValue(i2) || (resourceId = this.f1467b.getResourceId(i2, 0)) == 0 || (a2 = AppCompatResources.a(this.f1466a, resourceId)) == null) {
            return this.f1467b.getColorStateList(i2);
        }
        return a2;
    }

    public float d(int i2, float f2) {
        return this.f1467b.getDimension(i2, f2);
    }

    public int e(int i2, int i3) {
        return this.f1467b.getDimensionPixelOffset(i2, i3);
    }

    public int f(int i2, int i3) {
        return this.f1467b.getDimensionPixelSize(i2, i3);
    }

    public Drawable g(int i2) {
        int resourceId;
        if (!this.f1467b.hasValue(i2) || (resourceId = this.f1467b.getResourceId(i2, 0)) == 0) {
            return this.f1467b.getDrawable(i2);
        }
        return AppCompatResources.b(this.f1466a, resourceId);
    }

    public Drawable h(int i2) {
        int resourceId;
        if (!this.f1467b.hasValue(i2) || (resourceId = this.f1467b.getResourceId(i2, 0)) == 0) {
            return null;
        }
        return AppCompatDrawableManager.b().d(this.f1466a, resourceId, true);
    }

    public float i(int i2, float f2) {
        return this.f1467b.getFloat(i2, f2);
    }

    public Typeface j(int i2, int i3, ResourcesCompat.FontCallback fontCallback) {
        int resourceId = this.f1467b.getResourceId(i2, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f1468c == null) {
            this.f1468c = new TypedValue();
        }
        return ResourcesCompat.h(this.f1466a, resourceId, this.f1468c, i3, fontCallback);
    }

    public int k(int i2, int i3) {
        return this.f1467b.getInt(i2, i3);
    }

    public int l(int i2, int i3) {
        return this.f1467b.getInteger(i2, i3);
    }

    public int m(int i2, int i3) {
        return this.f1467b.getLayoutDimension(i2, i3);
    }

    public int n(int i2, int i3) {
        return this.f1467b.getResourceId(i2, i3);
    }

    public String o(int i2) {
        return this.f1467b.getString(i2);
    }

    public CharSequence p(int i2) {
        return this.f1467b.getText(i2);
    }

    public CharSequence[] q(int i2) {
        return this.f1467b.getTextArray(i2);
    }

    public TypedArray r() {
        return this.f1467b;
    }

    public boolean s(int i2) {
        return this.f1467b.hasValue(i2);
    }

    public void w() {
        this.f1467b.recycle();
    }
}
