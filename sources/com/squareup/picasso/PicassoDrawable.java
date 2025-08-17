package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.widget.ImageView;
import com.facebook.imageutils.JfifUtil;
import com.squareup.picasso.Picasso;

final class PicassoDrawable extends BitmapDrawable {
    private static final Paint DEBUG_PAINT = new Paint();
    private static final float FADE_DURATION = 200.0f;
    int alpha = JfifUtil.MARKER_FIRST_BYTE;
    boolean animating;
    private final boolean debugging;
    private final float density;
    private final Picasso.LoadedFrom loadedFrom;
    Drawable placeholder;
    long startTimeMillis;

    PicassoDrawable(Context context, Bitmap bitmap, Drawable drawable, Picasso.LoadedFrom loadedFrom2, boolean z2, boolean z3) {
        super(context.getResources(), bitmap);
        boolean z4;
        this.debugging = z3;
        this.density = context.getResources().getDisplayMetrics().density;
        this.loadedFrom = loadedFrom2;
        if (loadedFrom2 == Picasso.LoadedFrom.MEMORY || z2) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (z4) {
            this.placeholder = drawable;
            this.animating = true;
            this.startTimeMillis = SystemClock.uptimeMillis();
        }
    }

    private void drawDebugIndicator(Canvas canvas) {
        Paint paint = DEBUG_PAINT;
        paint.setColor(-1);
        canvas.drawPath(getTrianglePath(0, 0, (int) (this.density * 16.0f)), paint);
        paint.setColor(this.loadedFrom.debugColor);
        canvas.drawPath(getTrianglePath(0, 0, (int) (this.density * 15.0f)), paint);
    }

    private static Path getTrianglePath(int i2, int i3, int i4) {
        Path path = new Path();
        float f2 = (float) i2;
        float f3 = (float) i3;
        path.moveTo(f2, f3);
        path.lineTo((float) (i2 + i4), f3);
        path.lineTo(f2, (float) (i3 + i4));
        return path;
    }

    static void setBitmap(ImageView imageView, Context context, Bitmap bitmap, Picasso.LoadedFrom loadedFrom2, boolean z2, boolean z3) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).stop();
        }
        imageView.setImageDrawable(new PicassoDrawable(context, bitmap, drawable, loadedFrom2, z2, z3));
    }

    static void setPlaceholder(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
        if (imageView.getDrawable() instanceof Animatable) {
            ((Animatable) imageView.getDrawable()).start();
        }
    }

    public void draw(Canvas canvas) {
        if (!this.animating) {
            super.draw(canvas);
        } else {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.startTimeMillis)) / FADE_DURATION;
            if (uptimeMillis >= 1.0f) {
                this.animating = false;
                this.placeholder = null;
                super.draw(canvas);
            } else {
                Drawable drawable = this.placeholder;
                if (drawable != null) {
                    drawable.draw(canvas);
                }
                super.setAlpha((int) (((float) this.alpha) * uptimeMillis));
                super.draw(canvas);
                super.setAlpha(this.alpha);
            }
        }
        if (this.debugging) {
            drawDebugIndicator(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.placeholder;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    public void setAlpha(int i2) {
        this.alpha = i2;
        Drawable drawable = this.placeholder;
        if (drawable != null) {
            drawable.setAlpha(i2);
        }
        super.setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.placeholder;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }
}
