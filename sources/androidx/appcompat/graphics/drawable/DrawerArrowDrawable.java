package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$style;
import androidx.appcompat.R$styleable;
import androidx.core.graphics.drawable.DrawableCompat;

public class DrawerArrowDrawable extends Drawable {

    /* renamed from: m  reason: collision with root package name */
    private static final float f628m = ((float) Math.toRadians(45.0d));

    /* renamed from: a  reason: collision with root package name */
    private final Paint f629a;

    /* renamed from: b  reason: collision with root package name */
    private float f630b;

    /* renamed from: c  reason: collision with root package name */
    private float f631c;

    /* renamed from: d  reason: collision with root package name */
    private float f632d;

    /* renamed from: e  reason: collision with root package name */
    private float f633e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f634f;

    /* renamed from: g  reason: collision with root package name */
    private final Path f635g = new Path();

    /* renamed from: h  reason: collision with root package name */
    private final int f636h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f637i = false;

    /* renamed from: j  reason: collision with root package name */
    private float f638j;

    /* renamed from: k  reason: collision with root package name */
    private float f639k;

    /* renamed from: l  reason: collision with root package name */
    private int f640l = 2;

    public DrawerArrowDrawable(Context context) {
        Paint paint = new Paint();
        this.f629a = paint;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes((AttributeSet) null, R$styleable.f240b1, R$attr.C, R$style.f230b);
        c(obtainStyledAttributes.getColor(R$styleable.f252f1, 0));
        b(obtainStyledAttributes.getDimension(R$styleable.f264j1, 0.0f));
        f(obtainStyledAttributes.getBoolean(R$styleable.f261i1, true));
        d((float) Math.round(obtainStyledAttributes.getDimension(R$styleable.f258h1, 0.0f)));
        this.f636h = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f255g1, 0);
        this.f631c = (float) Math.round(obtainStyledAttributes.getDimension(R$styleable.f249e1, 0.0f));
        this.f630b = (float) Math.round(obtainStyledAttributes.getDimension(R$styleable.f243c1, 0.0f));
        this.f632d = obtainStyledAttributes.getDimension(R$styleable.f246d1, 0.0f);
        obtainStyledAttributes.recycle();
    }

    private static float a(float f2, float f3, float f4) {
        return f2 + ((f3 - f2) * f4);
    }

    public void b(float f2) {
        if (this.f629a.getStrokeWidth() != f2) {
            this.f629a.setStrokeWidth(f2);
            this.f639k = (float) (((double) (f2 / 2.0f)) * Math.cos((double) f628m));
            invalidateSelf();
        }
    }

    public void c(int i2) {
        if (i2 != this.f629a.getColor()) {
            this.f629a.setColor(i2);
            invalidateSelf();
        }
    }

    public void d(float f2) {
        if (f2 != this.f633e) {
            this.f633e = f2;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        float f2;
        float f3;
        int i2;
        Canvas canvas2 = canvas;
        Rect bounds = getBounds();
        int i3 = this.f640l;
        boolean z2 = false;
        if (i3 != 0 && (i3 == 1 || (i3 == 3 ? DrawableCompat.f(this) == 0 : DrawableCompat.f(this) == 1))) {
            z2 = true;
        }
        float f4 = this.f630b;
        float a2 = a(this.f631c, (float) Math.sqrt((double) (f4 * f4 * 2.0f)), this.f638j);
        float a3 = a(this.f631c, this.f632d, this.f638j);
        float round = (float) Math.round(a(0.0f, this.f639k, this.f638j));
        float a4 = a(0.0f, f628m, this.f638j);
        if (z2) {
            f2 = 0.0f;
        } else {
            f2 = -180.0f;
        }
        if (z2) {
            f3 = 180.0f;
        } else {
            f3 = 0.0f;
        }
        float a5 = a(f2, f3, this.f638j);
        double d2 = (double) a2;
        float f5 = a5;
        double d3 = (double) a4;
        boolean z3 = z2;
        float round2 = (float) Math.round(Math.cos(d3) * d2);
        float round3 = (float) Math.round(d2 * Math.sin(d3));
        this.f635g.rewind();
        float a6 = a(this.f633e + this.f629a.getStrokeWidth(), -this.f639k, this.f638j);
        float f6 = (-a3) / 2.0f;
        this.f635g.moveTo(f6 + round, 0.0f);
        this.f635g.rLineTo(a3 - (round * 2.0f), 0.0f);
        this.f635g.moveTo(f6, a6);
        this.f635g.rLineTo(round2, round3);
        this.f635g.moveTo(f6, -a6);
        this.f635g.rLineTo(round2, -round3);
        this.f635g.close();
        canvas.save();
        float strokeWidth = this.f629a.getStrokeWidth();
        float height = ((float) bounds.height()) - (3.0f * strokeWidth);
        float f7 = this.f633e;
        canvas2.translate((float) bounds.centerX(), ((float) ((((int) (height - (2.0f * f7))) / 4) * 2)) + (strokeWidth * 1.5f) + f7);
        if (this.f634f) {
            if (this.f637i ^ z3) {
                i2 = -1;
            } else {
                i2 = 1;
            }
            canvas2.rotate(f5 * ((float) i2));
        } else if (z3) {
            canvas2.rotate(180.0f);
        }
        canvas2.drawPath(this.f635g, this.f629a);
        canvas.restore();
    }

    public void e(float f2) {
        if (this.f638j != f2) {
            this.f638j = f2;
            invalidateSelf();
        }
    }

    public void f(boolean z2) {
        if (this.f634f != z2) {
            this.f634f = z2;
            invalidateSelf();
        }
    }

    public void g(boolean z2) {
        if (this.f637i != z2) {
            this.f637i = z2;
            invalidateSelf();
        }
    }

    public int getIntrinsicHeight() {
        return this.f636h;
    }

    public int getIntrinsicWidth() {
        return this.f636h;
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i2) {
        if (i2 != this.f629a.getAlpha()) {
            this.f629a.setAlpha(i2);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f629a.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
