package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextPaint;
import android.util.Log;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.material.R$styleable;

public class TextAppearance {

    /* renamed from: a  reason: collision with root package name */
    public final float f29924a;

    /* renamed from: b  reason: collision with root package name */
    public final ColorStateList f29925b;

    /* renamed from: c  reason: collision with root package name */
    public final ColorStateList f29926c;

    /* renamed from: d  reason: collision with root package name */
    public final ColorStateList f29927d;

    /* renamed from: e  reason: collision with root package name */
    public final int f29928e;

    /* renamed from: f  reason: collision with root package name */
    public final int f29929f;

    /* renamed from: g  reason: collision with root package name */
    public final String f29930g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f29931h;

    /* renamed from: i  reason: collision with root package name */
    public final ColorStateList f29932i;

    /* renamed from: j  reason: collision with root package name */
    public final float f29933j;

    /* renamed from: k  reason: collision with root package name */
    public final float f29934k;

    /* renamed from: l  reason: collision with root package name */
    public final float f29935l;

    /* renamed from: m  reason: collision with root package name */
    private final int f29936m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public boolean f29937n = false;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public Typeface f29938o;

    public TextAppearance(Context context, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, R$styleable.p3);
        this.f29924a = obtainStyledAttributes.getDimension(R$styleable.q3, 0.0f);
        this.f29925b = MaterialResources.a(context, obtainStyledAttributes, R$styleable.t3);
        this.f29926c = MaterialResources.a(context, obtainStyledAttributes, R$styleable.u3);
        this.f29927d = MaterialResources.a(context, obtainStyledAttributes, R$styleable.v3);
        this.f29928e = obtainStyledAttributes.getInt(R$styleable.s3, 0);
        this.f29929f = obtainStyledAttributes.getInt(R$styleable.r3, 1);
        int c2 = MaterialResources.c(obtainStyledAttributes, R$styleable.B3, R$styleable.A3);
        this.f29936m = obtainStyledAttributes.getResourceId(c2, 0);
        this.f29930g = obtainStyledAttributes.getString(c2);
        this.f29931h = obtainStyledAttributes.getBoolean(R$styleable.C3, false);
        this.f29932i = MaterialResources.a(context, obtainStyledAttributes, R$styleable.w3);
        this.f29933j = obtainStyledAttributes.getFloat(R$styleable.x3, 0.0f);
        this.f29934k = obtainStyledAttributes.getFloat(R$styleable.y3, 0.0f);
        this.f29935l = obtainStyledAttributes.getFloat(R$styleable.z3, 0.0f);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: private */
    public void d() {
        if (this.f29938o == null) {
            this.f29938o = Typeface.create(this.f29930g, this.f29928e);
        }
        if (this.f29938o == null) {
            int i2 = this.f29929f;
            if (i2 == 1) {
                this.f29938o = Typeface.SANS_SERIF;
            } else if (i2 == 2) {
                this.f29938o = Typeface.SERIF;
            } else if (i2 != 3) {
                this.f29938o = Typeface.DEFAULT;
            } else {
                this.f29938o = Typeface.MONOSPACE;
            }
            Typeface typeface = this.f29938o;
            if (typeface != null) {
                this.f29938o = Typeface.create(typeface, this.f29928e);
            }
        }
    }

    public Typeface e(Context context) {
        if (this.f29937n) {
            return this.f29938o;
        }
        if (!context.isRestricted()) {
            try {
                Typeface g2 = ResourcesCompat.g(context, this.f29936m);
                this.f29938o = g2;
                if (g2 != null) {
                    this.f29938o = Typeface.create(g2, this.f29928e);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e2) {
                Log.d("TextAppearance", "Error loading font " + this.f29930g, e2);
            }
        }
        d();
        this.f29937n = true;
        return this.f29938o;
    }

    public void f(Context context, final TextPaint textPaint, final ResourcesCompat.FontCallback fontCallback) {
        if (this.f29937n) {
            i(textPaint, this.f29938o);
            return;
        }
        d();
        if (context.isRestricted()) {
            this.f29937n = true;
            i(textPaint, this.f29938o);
            return;
        }
        try {
            ResourcesCompat.i(context, this.f29936m, new ResourcesCompat.FontCallback() {
                public void h(int i2) {
                    TextAppearance.this.d();
                    boolean unused = TextAppearance.this.f29937n = true;
                    fontCallback.f(i2);
                }

                public void i(Typeface typeface) {
                    TextAppearance textAppearance = TextAppearance.this;
                    Typeface unused = textAppearance.f29938o = Typeface.create(typeface, textAppearance.f29928e);
                    TextAppearance.this.i(textPaint, typeface);
                    boolean unused2 = TextAppearance.this.f29937n = true;
                    fontCallback.g(typeface);
                }
            }, (Handler) null);
        } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
        } catch (Exception e2) {
            Log.d("TextAppearance", "Error loading font " + this.f29930g, e2);
        }
    }

    public void g(Context context, TextPaint textPaint, ResourcesCompat.FontCallback fontCallback) {
        int i2;
        int i3;
        h(context, textPaint, fontCallback);
        ColorStateList colorStateList = this.f29925b;
        if (colorStateList != null) {
            i2 = colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor());
        } else {
            i2 = -16777216;
        }
        textPaint.setColor(i2);
        float f2 = this.f29935l;
        float f3 = this.f29933j;
        float f4 = this.f29934k;
        ColorStateList colorStateList2 = this.f29932i;
        if (colorStateList2 != null) {
            i3 = colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor());
        } else {
            i3 = 0;
        }
        textPaint.setShadowLayer(f2, f3, f4, i3);
    }

    public void h(Context context, TextPaint textPaint, ResourcesCompat.FontCallback fontCallback) {
        if (TextAppearanceConfig.a()) {
            i(textPaint, e(context));
            return;
        }
        f(context, textPaint, fontCallback);
        if (!this.f29937n) {
            i(textPaint, this.f29938o);
        }
    }

    public void i(TextPaint textPaint, Typeface typeface) {
        boolean z2;
        float f2;
        textPaint.setTypeface(typeface);
        int i2 = (~typeface.getStyle()) & this.f29928e;
        if ((i2 & 1) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        textPaint.setFakeBoldText(z2);
        if ((i2 & 2) != 0) {
            f2 = -0.25f;
        } else {
            f2 = 0.0f;
        }
        textPaint.setTextSkewX(f2);
        textPaint.setTextSize(this.f29924a);
    }
}
