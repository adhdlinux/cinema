package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;

public class ImageViewCompat {

    static class Api21Impl {
        private Api21Impl() {
        }

        static ColorStateList a(ImageView imageView) {
            return imageView.getImageTintList();
        }

        static PorterDuff.Mode b(ImageView imageView) {
            return imageView.getImageTintMode();
        }

        static void c(ImageView imageView, ColorStateList colorStateList) {
            imageView.setImageTintList(colorStateList);
        }

        static void d(ImageView imageView, PorterDuff.Mode mode) {
            imageView.setImageTintMode(mode);
        }
    }

    private ImageViewCompat() {
    }

    public static ColorStateList a(ImageView imageView) {
        return Api21Impl.a(imageView);
    }

    public static PorterDuff.Mode b(ImageView imageView) {
        return Api21Impl.b(imageView);
    }

    public static void c(ImageView imageView, ColorStateList colorStateList) {
        Drawable drawable;
        int i2 = Build.VERSION.SDK_INT;
        Api21Impl.c(imageView, colorStateList);
        if (i2 == 21 && (drawable = imageView.getDrawable()) != null && Api21Impl.a(imageView) != null) {
            if (drawable.isStateful()) {
                drawable.setState(imageView.getDrawableState());
            }
            imageView.setImageDrawable(drawable);
        }
    }

    public static void d(ImageView imageView, PorterDuff.Mode mode) {
        Drawable drawable;
        int i2 = Build.VERSION.SDK_INT;
        Api21Impl.d(imageView, mode);
        if (i2 == 21 && (drawable = imageView.getDrawable()) != null && Api21Impl.a(imageView) != null) {
            if (drawable.isStateful()) {
                drawable.setState(imageView.getDrawableState());
            }
            imageView.setImageDrawable(drawable);
        }
    }
}
