package com.google.android.material.shape;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.TintAwareDrawable;
import com.facebook.imageutils.JfifUtil;

public class MaterialShapeDrawable extends Drawable implements TintAwareDrawable {
    private ColorStateList A;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f29954b;

    /* renamed from: c  reason: collision with root package name */
    private final Matrix[] f29955c;

    /* renamed from: d  reason: collision with root package name */
    private final Matrix[] f29956d;

    /* renamed from: e  reason: collision with root package name */
    private final ShapePath[] f29957e;

    /* renamed from: f  reason: collision with root package name */
    private final Matrix f29958f;

    /* renamed from: g  reason: collision with root package name */
    private final Path f29959g;

    /* renamed from: h  reason: collision with root package name */
    private final PointF f29960h;

    /* renamed from: i  reason: collision with root package name */
    private final ShapePath f29961i;

    /* renamed from: j  reason: collision with root package name */
    private final Region f29962j;

    /* renamed from: k  reason: collision with root package name */
    private final Region f29963k;

    /* renamed from: l  reason: collision with root package name */
    private final float[] f29964l;

    /* renamed from: m  reason: collision with root package name */
    private final float[] f29965m;

    /* renamed from: n  reason: collision with root package name */
    private ShapePathModel f29966n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f29967o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f29968p;

    /* renamed from: q  reason: collision with root package name */
    private float f29969q;

    /* renamed from: r  reason: collision with root package name */
    private int f29970r;

    /* renamed from: s  reason: collision with root package name */
    private int f29971s;

    /* renamed from: t  reason: collision with root package name */
    private int f29972t;

    /* renamed from: u  reason: collision with root package name */
    private int f29973u;

    /* renamed from: v  reason: collision with root package name */
    private float f29974v;

    /* renamed from: w  reason: collision with root package name */
    private float f29975w;

    /* renamed from: x  reason: collision with root package name */
    private Paint.Style f29976x;

    /* renamed from: y  reason: collision with root package name */
    private PorterDuffColorFilter f29977y;

    /* renamed from: z  reason: collision with root package name */
    private PorterDuff.Mode f29978z;

    public MaterialShapeDrawable() {
        this((ShapePathModel) null);
    }

    private float a(int i2, int i3, int i4) {
        e(((i2 - 1) + 4) % 4, i3, i4, this.f29960h);
        PointF pointF = this.f29960h;
        float f2 = pointF.x;
        float f3 = pointF.y;
        e((i2 + 1) % 4, i3, i4, pointF);
        PointF pointF2 = this.f29960h;
        float f4 = pointF2.x;
        float f5 = pointF2.y;
        e(i2, i3, i4, pointF2);
        PointF pointF3 = this.f29960h;
        float f6 = pointF3.x;
        float f7 = pointF3.y;
        float f8 = f5 - f7;
        float atan2 = ((float) Math.atan2((double) (f3 - f7), (double) (f2 - f6))) - ((float) Math.atan2((double) f8, (double) (f4 - f6)));
        if (atan2 < 0.0f) {
            return (float) (((double) atan2) + 6.283185307179586d);
        }
        return atan2;
    }

    private float b(int i2, int i3, int i4) {
        e(i2, i3, i4, this.f29960h);
        PointF pointF = this.f29960h;
        float f2 = pointF.x;
        float f3 = pointF.y;
        e((i2 + 1) % 4, i3, i4, pointF);
        PointF pointF2 = this.f29960h;
        return (float) Math.atan2((double) (pointF2.y - f3), (double) (pointF2.x - f2));
    }

    private void c(int i2, Path path) {
        float[] fArr = this.f29964l;
        ShapePath shapePath = this.f29957e[i2];
        fArr[0] = shapePath.f29979a;
        fArr[1] = shapePath.f29980b;
        this.f29955c[i2].mapPoints(fArr);
        if (i2 == 0) {
            float[] fArr2 = this.f29964l;
            path.moveTo(fArr2[0], fArr2[1]);
        } else {
            float[] fArr3 = this.f29964l;
            path.lineTo(fArr3[0], fArr3[1]);
        }
        this.f29957e[i2].b(this.f29955c[i2], path);
    }

    private void d(int i2, Path path) {
        int i3 = (i2 + 1) % 4;
        float[] fArr = this.f29964l;
        ShapePath shapePath = this.f29957e[i2];
        fArr[0] = shapePath.f29981c;
        fArr[1] = shapePath.f29982d;
        this.f29955c[i2].mapPoints(fArr);
        float[] fArr2 = this.f29965m;
        ShapePath shapePath2 = this.f29957e[i3];
        fArr2[0] = shapePath2.f29979a;
        fArr2[1] = shapePath2.f29980b;
        this.f29955c[i3].mapPoints(fArr2);
        float[] fArr3 = this.f29964l;
        float f2 = fArr3[0];
        float[] fArr4 = this.f29965m;
        this.f29961i.d(0.0f, 0.0f);
        g(i2).a((float) Math.hypot((double) (f2 - fArr4[0]), (double) (fArr3[1] - fArr4[1])), this.f29969q, this.f29961i);
        this.f29961i.b(this.f29956d[i2], path);
    }

    private void e(int i2, int i3, int i4, PointF pointF) {
        if (i2 == 1) {
            pointF.set((float) i3, 0.0f);
        } else if (i2 == 2) {
            pointF.set((float) i3, (float) i4);
        } else if (i2 != 3) {
            pointF.set(0.0f, 0.0f);
        } else {
            pointF.set(0.0f, (float) i4);
        }
    }

    private CornerTreatment f(int i2) {
        if (i2 == 1) {
            return this.f29966n.h();
        }
        if (i2 == 2) {
            return this.f29966n.c();
        }
        if (i2 != 3) {
            return this.f29966n.g();
        }
        return this.f29966n.b();
    }

    private EdgeTreatment g(int i2) {
        if (i2 == 1) {
            return this.f29966n.e();
        }
        if (i2 == 2) {
            return this.f29966n.a();
        }
        if (i2 != 3) {
            return this.f29966n.f();
        }
        return this.f29966n.d();
    }

    private void i(int i2, int i3, Path path) {
        j(i2, i3, path);
        if (this.f29974v != 1.0f) {
            this.f29958f.reset();
            Matrix matrix = this.f29958f;
            float f2 = this.f29974v;
            matrix.setScale(f2, f2, (float) (i2 / 2), (float) (i3 / 2));
            path.transform(this.f29958f);
        }
    }

    private static int l(int i2, int i3) {
        return (i2 * (i3 + (i3 >>> 7))) >>> 8;
    }

    private void m(int i2, int i3, int i4) {
        e(i2, i3, i4, this.f29960h);
        f(i2).a(a(i2, i3, i4), this.f29969q, this.f29957e[i2]);
        this.f29955c[i2].reset();
        Matrix matrix = this.f29955c[i2];
        PointF pointF = this.f29960h;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f29955c[i2].preRotate((float) Math.toDegrees((double) (b(((i2 - 1) + 4) % 4, i3, i4) + 1.5707964f)));
    }

    private void n(int i2, int i3, int i4) {
        float[] fArr = this.f29964l;
        ShapePath shapePath = this.f29957e[i2];
        fArr[0] = shapePath.f29981c;
        fArr[1] = shapePath.f29982d;
        this.f29955c[i2].mapPoints(fArr);
        float b2 = b(i2, i3, i4);
        this.f29956d[i2].reset();
        Matrix matrix = this.f29956d[i2];
        float[] fArr2 = this.f29964l;
        matrix.setTranslate(fArr2[0], fArr2[1]);
        this.f29956d[i2].preRotate((float) Math.toDegrees((double) b2));
    }

    private void r() {
        ColorStateList colorStateList = this.A;
        if (colorStateList == null || this.f29978z == null) {
            this.f29977y = null;
            return;
        }
        int colorForState = colorStateList.getColorForState(getState(), 0);
        this.f29977y = new PorterDuffColorFilter(colorForState, this.f29978z);
        if (this.f29968p) {
            this.f29970r = colorForState;
        }
    }

    public void draw(Canvas canvas) {
        this.f29954b.setColorFilter(this.f29977y);
        int alpha = this.f29954b.getAlpha();
        this.f29954b.setAlpha(l(alpha, this.f29973u));
        this.f29954b.setStrokeWidth(this.f29975w);
        this.f29954b.setStyle(this.f29976x);
        int i2 = this.f29971s;
        if (i2 > 0 && this.f29967o) {
            this.f29954b.setShadowLayer((float) this.f29972t, 0.0f, (float) i2, this.f29970r);
        }
        if (this.f29966n != null) {
            i(canvas.getWidth(), canvas.getHeight(), this.f29959g);
            canvas.drawPath(this.f29959g, this.f29954b);
        } else {
            canvas.drawRect(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), this.f29954b);
        }
        this.f29954b.setAlpha(alpha);
    }

    public int getOpacity() {
        return -3;
    }

    public Region getTransparentRegion() {
        Rect bounds = getBounds();
        this.f29962j.set(bounds);
        i(bounds.width(), bounds.height(), this.f29959g);
        this.f29963k.setPath(this.f29959g, this.f29962j);
        this.f29962j.op(this.f29963k, Region.Op.DIFFERENCE);
        return this.f29962j;
    }

    public float h() {
        return this.f29969q;
    }

    public void j(int i2, int i3, Path path) {
        path.rewind();
        if (this.f29966n != null) {
            for (int i4 = 0; i4 < 4; i4++) {
                m(i4, i2, i3);
                n(i4, i2, i3);
            }
            for (int i5 = 0; i5 < 4; i5++) {
                c(i5, path);
                d(i5, path);
            }
            path.close();
        }
    }

    public ColorStateList k() {
        return this.A;
    }

    public void o(float f2) {
        this.f29969q = f2;
        invalidateSelf();
    }

    public void p(Paint.Style style) {
        this.f29976x = style;
        invalidateSelf();
    }

    public void q(boolean z2) {
        this.f29967o = z2;
        invalidateSelf();
    }

    public void setAlpha(int i2) {
        this.f29973u = i2;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f29954b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.A = colorStateList;
        r();
        invalidateSelf();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.f29978z = mode;
        r();
        invalidateSelf();
    }

    public MaterialShapeDrawable(ShapePathModel shapePathModel) {
        this.f29954b = new Paint();
        this.f29955c = new Matrix[4];
        this.f29956d = new Matrix[4];
        this.f29957e = new ShapePath[4];
        this.f29958f = new Matrix();
        this.f29959g = new Path();
        this.f29960h = new PointF();
        this.f29961i = new ShapePath();
        this.f29962j = new Region();
        this.f29963k = new Region();
        this.f29964l = new float[2];
        this.f29965m = new float[2];
        this.f29966n = null;
        this.f29967o = false;
        this.f29968p = false;
        this.f29969q = 1.0f;
        this.f29970r = -16777216;
        this.f29971s = 5;
        this.f29972t = 10;
        this.f29973u = JfifUtil.MARKER_FIRST_BYTE;
        this.f29974v = 1.0f;
        this.f29975w = 0.0f;
        this.f29976x = Paint.Style.FILL_AND_STROKE;
        this.f29978z = PorterDuff.Mode.SRC_IN;
        this.A = null;
        this.f29966n = shapePathModel;
        for (int i2 = 0; i2 < 4; i2++) {
            this.f29955c[i2] = new Matrix();
            this.f29956d[i2] = new Matrix();
            this.f29957e[i2] = new ShapePath();
        }
    }
}
