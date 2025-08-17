package com.google.android.material.animation;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

public class MatrixEvaluator implements TypeEvaluator<Matrix> {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f29405a = new float[9];

    /* renamed from: b  reason: collision with root package name */
    private final float[] f29406b = new float[9];

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f29407c = new Matrix();

    /* renamed from: a */
    public Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.f29405a);
        matrix2.getValues(this.f29406b);
        for (int i2 = 0; i2 < 9; i2++) {
            float[] fArr = this.f29406b;
            float f3 = fArr[i2];
            float f4 = this.f29405a[i2];
            fArr[i2] = f4 + ((f3 - f4) * f2);
        }
        this.f29407c.setValues(this.f29406b);
        return this.f29407c;
    }
}
