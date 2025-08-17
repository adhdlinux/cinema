package com.google.android.material.animation;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

public class ImageMatrixProperty extends Property<ImageView, Matrix> {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f29404a = new Matrix();

    public ImageMatrixProperty() {
        super(Matrix.class, "imageMatrixProperty");
    }

    /* renamed from: a */
    public Matrix get(ImageView imageView) {
        this.f29404a.set(imageView.getImageMatrix());
        return this.f29404a;
    }

    /* renamed from: b */
    public void set(ImageView imageView, Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }
}
