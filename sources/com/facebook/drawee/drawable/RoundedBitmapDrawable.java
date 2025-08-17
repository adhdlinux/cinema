package com.facebook.drawee.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.lang.ref.WeakReference;

public class RoundedBitmapDrawable extends RoundedDrawable {
    private final Bitmap mBitmap;
    private final Paint mBorderPaint;
    private WeakReference<Bitmap> mLastBitmap;
    private final Paint mPaint;

    public RoundedBitmapDrawable(Resources resources, Bitmap bitmap, Paint paint) {
        super(new BitmapDrawable(resources, bitmap));
        Paint paint2 = new Paint();
        this.mPaint = paint2;
        Paint paint3 = new Paint(1);
        this.mBorderPaint = paint3;
        this.mBitmap = bitmap;
        if (paint != null) {
            paint2.set(paint);
        }
        paint2.setFlags(1);
        paint3.setStyle(Paint.Style.STROKE);
    }

    public static RoundedBitmapDrawable fromBitmapDrawable(Resources resources, BitmapDrawable bitmapDrawable) {
        return new RoundedBitmapDrawable(resources, bitmapDrawable.getBitmap(), bitmapDrawable.getPaint());
    }

    private void updatePaint() {
        WeakReference<Bitmap> weakReference = this.mLastBitmap;
        if (weakReference == null || weakReference.get() != this.mBitmap) {
            this.mLastBitmap = new WeakReference<>(this.mBitmap);
            Paint paint = this.mPaint;
            Bitmap bitmap = this.mBitmap;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
            this.mIsShaderTransformDirty = true;
        }
        if (this.mIsShaderTransformDirty) {
            this.mPaint.getShader().setLocalMatrix(this.mTransform);
            this.mIsShaderTransformDirty = false;
        }
        this.mPaint.setFilterBitmap(getPaintFilterBitmap());
    }

    public void draw(Canvas canvas) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("RoundedBitmapDrawable#draw");
        }
        if (!shouldRound()) {
            super.draw(canvas);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
                return;
            }
            return;
        }
        updateTransform();
        updatePath();
        updatePaint();
        int save = canvas.save();
        canvas.concat(this.mInverseParentTransform);
        canvas.drawPath(this.mPath, this.mPaint);
        float f2 = this.mBorderWidth;
        if (f2 > 0.0f) {
            this.mBorderPaint.setStrokeWidth(f2);
            this.mBorderPaint.setColor(DrawableUtils.multiplyColorAlpha(this.mBorderColor, this.mPaint.getAlpha()));
            canvas.drawPath(this.mBorderPath, this.mBorderPaint);
        }
        canvas.restoreToCount(save);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    /* access modifiers changed from: package-private */
    public Paint getPaint() {
        return this.mPaint;
    }

    public void setAlpha(int i2) {
        super.setAlpha(i2);
        if (i2 != this.mPaint.getAlpha()) {
            this.mPaint.setAlpha(i2);
            super.setAlpha(i2);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
        this.mPaint.setColorFilter(colorFilter);
    }

    /* access modifiers changed from: package-private */
    public boolean shouldRound() {
        return super.shouldRound() && this.mBitmap != null;
    }

    public RoundedBitmapDrawable(Resources resources, Bitmap bitmap) {
        this(resources, bitmap, (Paint) null);
    }
}
