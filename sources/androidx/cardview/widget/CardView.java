package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.cardview.R$attr;
import androidx.cardview.R$color;
import androidx.cardview.R$style;
import androidx.cardview.R$styleable;

public class CardView extends FrameLayout {

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f1646i = {16842801};

    /* renamed from: j  reason: collision with root package name */
    private static final CardViewImpl f1647j;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1648b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1649c;

    /* renamed from: d  reason: collision with root package name */
    int f1650d;

    /* renamed from: e  reason: collision with root package name */
    int f1651e;

    /* renamed from: f  reason: collision with root package name */
    final Rect f1652f;

    /* renamed from: g  reason: collision with root package name */
    final Rect f1653g;

    /* renamed from: h  reason: collision with root package name */
    private final CardViewDelegate f1654h;

    static {
        CardViewApi21Impl cardViewApi21Impl = new CardViewApi21Impl();
        f1647j = cardViewApi21Impl;
        cardViewApi21Impl.l();
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.cardViewStyle);
    }

    public void d(int i2, int i3, int i4, int i5) {
        this.f1652f.set(i2, i3, i4, i5);
        f1647j.k(this.f1654h);
    }

    public ColorStateList getCardBackgroundColor() {
        return f1647j.e(this.f1654h);
    }

    public float getCardElevation() {
        return f1647j.i(this.f1654h);
    }

    public int getContentPaddingBottom() {
        return this.f1652f.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f1652f.left;
    }

    public int getContentPaddingRight() {
        return this.f1652f.right;
    }

    public int getContentPaddingTop() {
        return this.f1652f.top;
    }

    public float getMaxCardElevation() {
        return f1647j.d(this.f1654h);
    }

    public boolean getPreventCornerOverlap() {
        return this.f1649c;
    }

    public float getRadius() {
        return f1647j.b(this.f1654h);
    }

    public boolean getUseCompatPadding() {
        return this.f1648b;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        CardViewImpl cardViewImpl = f1647j;
        if (!(cardViewImpl instanceof CardViewApi21Impl)) {
            int mode = View.MeasureSpec.getMode(i2);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) cardViewImpl.m(this.f1654h)), View.MeasureSpec.getSize(i2)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i3);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i3 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) cardViewImpl.f(this.f1654h)), View.MeasureSpec.getSize(i3)), mode2);
            }
            super.onMeasure(i2, i3);
            return;
        }
        super.onMeasure(i2, i3);
    }

    public void setCardBackgroundColor(int i2) {
        f1647j.n(this.f1654h, ColorStateList.valueOf(i2));
    }

    public void setCardElevation(float f2) {
        f1647j.c(this.f1654h, f2);
    }

    public void setMaxCardElevation(float f2) {
        f1647j.o(this.f1654h, f2);
    }

    public void setMinimumHeight(int i2) {
        this.f1651e = i2;
        super.setMinimumHeight(i2);
    }

    public void setMinimumWidth(int i2) {
        this.f1650d = i2;
        super.setMinimumWidth(i2);
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
    }

    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
    }

    public void setPreventCornerOverlap(boolean z2) {
        if (z2 != this.f1649c) {
            this.f1649c = z2;
            f1647j.g(this.f1654h);
        }
    }

    public void setRadius(float f2) {
        f1647j.a(this.f1654h, f2);
    }

    public void setUseCompatPadding(boolean z2) {
        if (this.f1648b != z2) {
            this.f1648b = z2;
            f1647j.j(this.f1654h);
        }
    }

    public CardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        int i3;
        ColorStateList valueOf;
        Rect rect = new Rect();
        this.f1652f = rect;
        this.f1653g = new Rect();
        AnonymousClass1 r3 = new CardViewDelegate() {

            /* renamed from: a  reason: collision with root package name */
            private Drawable f1655a;

            public void a(int i2, int i3, int i4, int i5) {
                CardView.this.f1653g.set(i2, i3, i4, i5);
                CardView cardView = CardView.this;
                Rect rect = cardView.f1652f;
                CardView.super.setPadding(i2 + rect.left, i3 + rect.top, i4 + rect.right, i5 + rect.bottom);
            }

            public void b(Drawable drawable) {
                this.f1655a = drawable;
                CardView.this.setBackgroundDrawable(drawable);
            }

            public boolean c() {
                return CardView.this.getUseCompatPadding();
            }

            public Drawable d() {
                return this.f1655a;
            }

            public boolean e() {
                return CardView.this.getPreventCornerOverlap();
            }

            public View f() {
                return CardView.this;
            }
        };
        this.f1654h = r3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f1632a, i2, R$style.CardView);
        int i4 = R$styleable.f1635d;
        if (obtainStyledAttributes.hasValue(i4)) {
            valueOf = obtainStyledAttributes.getColorStateList(i4);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(f1646i);
            int color = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            if (fArr[2] > 0.5f) {
                i3 = getResources().getColor(R$color.cardview_light_background);
            } else {
                i3 = getResources().getColor(R$color.cardview_dark_background);
            }
            valueOf = ColorStateList.valueOf(i3);
        }
        ColorStateList colorStateList = valueOf;
        float dimension = obtainStyledAttributes.getDimension(R$styleable.f1636e, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(R$styleable.f1637f, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(R$styleable.f1638g, 0.0f);
        this.f1648b = obtainStyledAttributes.getBoolean(R$styleable.f1640i, false);
        this.f1649c = obtainStyledAttributes.getBoolean(R$styleable.f1639h, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f1641j, 0);
        rect.left = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f1643l, dimensionPixelSize);
        rect.top = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f1645n, dimensionPixelSize);
        rect.right = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f1644m, dimensionPixelSize);
        rect.bottom = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f1642k, dimensionPixelSize);
        float f2 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f1650d = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f1633b, 0);
        this.f1651e = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f1634c, 0);
        obtainStyledAttributes.recycle();
        f1647j.h(r3, context, colorStateList, dimension, dimension2, f2);
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f1647j.n(this.f1654h, colorStateList);
    }
}
