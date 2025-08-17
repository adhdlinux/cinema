package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

public class ShapePath {

    /* renamed from: a  reason: collision with root package name */
    public float f29979a;

    /* renamed from: b  reason: collision with root package name */
    public float f29980b;

    /* renamed from: c  reason: collision with root package name */
    public float f29981c;

    /* renamed from: d  reason: collision with root package name */
    public float f29982d;

    /* renamed from: e  reason: collision with root package name */
    private final List<PathOperation> f29983e = new ArrayList();

    public static class PathArcOperation extends PathOperation {

        /* renamed from: h  reason: collision with root package name */
        private static final RectF f29984h = new RectF();

        /* renamed from: b  reason: collision with root package name */
        public float f29985b;

        /* renamed from: c  reason: collision with root package name */
        public float f29986c;

        /* renamed from: d  reason: collision with root package name */
        public float f29987d;

        /* renamed from: e  reason: collision with root package name */
        public float f29988e;

        /* renamed from: f  reason: collision with root package name */
        public float f29989f;

        /* renamed from: g  reason: collision with root package name */
        public float f29990g;

        public PathArcOperation(float f2, float f3, float f4, float f5) {
            this.f29985b = f2;
            this.f29986c = f3;
            this.f29987d = f4;
            this.f29988e = f5;
        }

        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f29993a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f29984h;
            rectF.set(this.f29985b, this.f29986c, this.f29987d, this.f29988e);
            path.arcTo(rectF, this.f29989f, this.f29990g, false);
            path.transform(matrix);
        }
    }

    public static class PathLineOperation extends PathOperation {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public float f29991b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public float f29992c;

        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f29993a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f29991b, this.f29992c);
            path.transform(matrix);
        }
    }

    public static abstract class PathOperation {

        /* renamed from: a  reason: collision with root package name */
        protected final Matrix f29993a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    public ShapePath() {
        d(0.0f, 0.0f);
    }

    public void a(float f2, float f3, float f4, float f5, float f6, float f7) {
        PathArcOperation pathArcOperation = new PathArcOperation(f2, f3, f4, f5);
        pathArcOperation.f29989f = f6;
        pathArcOperation.f29990g = f7;
        this.f29983e.add(pathArcOperation);
        double d2 = (double) (f6 + f7);
        this.f29981c = ((f2 + f4) * 0.5f) + (((f4 - f2) / 2.0f) * ((float) Math.cos(Math.toRadians(d2))));
        this.f29982d = ((f3 + f5) * 0.5f) + (((f5 - f3) / 2.0f) * ((float) Math.sin(Math.toRadians(d2))));
    }

    public void b(Matrix matrix, Path path) {
        int size = this.f29983e.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f29983e.get(i2).a(matrix, path);
        }
    }

    public void c(float f2, float f3) {
        PathLineOperation pathLineOperation = new PathLineOperation();
        float unused = pathLineOperation.f29991b = f2;
        float unused2 = pathLineOperation.f29992c = f3;
        this.f29983e.add(pathLineOperation);
        this.f29981c = f2;
        this.f29982d = f3;
    }

    public void d(float f2, float f3) {
        this.f29979a = f2;
        this.f29980b = f3;
        this.f29981c = f2;
        this.f29982d = f3;
        this.f29983e.clear();
    }
}
