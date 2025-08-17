package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

class ImageViewAction extends Action<ImageView> {
    Callback callback;

    ImageViewAction(Picasso picasso, ImageView imageView, Request request, int i2, int i3, int i4, Drawable drawable, String str, Object obj, Callback callback2, boolean z2) {
        super(picasso, imageView, request, i2, i3, i4, drawable, str, obj, z2);
        this.callback = callback2;
    }

    /* access modifiers changed from: package-private */
    public void cancel() {
        super.cancel();
        if (this.callback != null) {
            this.callback = null;
        }
    }

    public void complete(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
        if (bitmap != null) {
            ImageView imageView = (ImageView) this.target.get();
            if (imageView != null) {
                Picasso picasso = this.picasso;
                Bitmap bitmap2 = bitmap;
                Picasso.LoadedFrom loadedFrom2 = loadedFrom;
                PicassoDrawable.setBitmap(imageView, picasso.context, bitmap2, loadedFrom2, this.noFade, picasso.indicatorsEnabled);
                Callback callback2 = this.callback;
                if (callback2 != null) {
                    callback2.onSuccess();
                    return;
                }
                return;
            }
            return;
        }
        throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[]{this}));
    }

    public void error(Exception exc) {
        ImageView imageView = (ImageView) this.target.get();
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).stop();
            }
            int i2 = this.errorResId;
            if (i2 != 0) {
                imageView.setImageResource(i2);
            } else {
                Drawable drawable2 = this.errorDrawable;
                if (drawable2 != null) {
                    imageView.setImageDrawable(drawable2);
                }
            }
            Callback callback2 = this.callback;
            if (callback2 != null) {
                callback2.onError(exc);
            }
        }
    }
}
