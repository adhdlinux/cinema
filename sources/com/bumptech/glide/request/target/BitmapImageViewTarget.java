package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class BitmapImageViewTarget extends ImageViewTarget<Bitmap> {
    public BitmapImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public void f(Bitmap bitmap) {
        ((ImageView) this.f17108c).setImageBitmap(bitmap);
    }
}
