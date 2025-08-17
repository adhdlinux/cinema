package com.facebook.drawee.debug;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.debug.listener.ImageLoadingTimeListener;
import com.facebook.drawee.drawable.ScalingUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DebugControllerOverlayDrawable extends Drawable implements ImageLoadingTimeListener {
    private static final float IMAGE_SIZE_THRESHOLD_NOT_OK = 0.5f;
    private static final float IMAGE_SIZE_THRESHOLD_OK = 0.1f;
    private static final int MAX_LINE_WIDTH_EM = 8;
    private static final int MAX_NUMBER_OF_LINES = 9;
    private static final int MAX_TEXT_SIZE_PX = 40;
    private static final int MIN_TEXT_SIZE_PX = 10;
    private static final String NO_CONTROLLER_ID = "none";
    private static final int OUTLINE_COLOR = -26624;
    private static final int OUTLINE_STROKE_WIDTH_PX = 2;
    private static final int TEXT_BACKGROUND_COLOR = 1711276032;
    private static final int TEXT_COLOR = -1;
    static final int TEXT_COLOR_IMAGE_ALMOST_OK = -256;
    static final int TEXT_COLOR_IMAGE_NOT_OK = -65536;
    static final int TEXT_COLOR_IMAGE_OK = -16711936;
    private static final int TEXT_LINE_SPACING_PX = 8;
    private static final int TEXT_PADDING_PX = 10;
    private HashMap<String, String> mAdditionalData = new HashMap<>();
    private String mControllerId;
    private int mCurrentTextXPx;
    private int mCurrentTextYPx;
    private long mFinalImageTimeMs;
    private int mFrameCount;
    private int mHeightPx;
    private String mImageFormat;
    private String mImageId;
    private int mImageSizeBytes;
    private int mLineIncrementPx;
    private int mLoopCount;
    private final Matrix mMatrix = new Matrix();
    private int mOriginColor = -1;
    private String mOriginText;
    private int mOverlayColor = 0;
    private final Paint mPaint = new Paint(1);
    private final Rect mRect = new Rect();
    private final RectF mRectF = new RectF();
    private ScalingUtils.ScaleType mScaleType;
    private int mStartTextXPx;
    private int mStartTextYPx;
    private int mTextGravity = 80;
    private int mWidthPx;

    public DebugControllerOverlayDrawable() {
        reset();
    }

    private void addDebugText(Canvas canvas, String str, Object obj) {
        addDebugText(canvas, str, String.valueOf(obj), -1);
    }

    private static String format(String str, Object... objArr) {
        return objArr == null ? str : String.format(Locale.US, str, objArr);
    }

    private void prepareDebugTextParameters(Rect rect, int i2, int i3) {
        int i4;
        int min = Math.min(40, Math.max(10, Math.min(rect.width() / i3, rect.height() / i2)));
        this.mPaint.setTextSize((float) min);
        int i5 = min + 8;
        this.mLineIncrementPx = i5;
        int i6 = this.mTextGravity;
        if (i6 == 80) {
            this.mLineIncrementPx = i5 * -1;
        }
        this.mStartTextXPx = rect.left + 10;
        if (i6 == 80) {
            i4 = rect.bottom - 10;
        } else {
            i4 = rect.top + 10 + 10;
        }
        this.mStartTextYPx = i4;
    }

    public void addAdditionalData(String str, String str2) {
        this.mAdditionalData.put(str, str2);
    }

    /* access modifiers changed from: package-private */
    public int determineSizeHintColor(int i2, int i3, ScalingUtils.ScaleType scaleType) {
        int width = getBounds().width();
        int height = getBounds().height();
        if (width > 0 && height > 0 && i2 > 0 && i3 > 0) {
            if (scaleType != null) {
                Rect rect = this.mRect;
                rect.top = 0;
                rect.left = 0;
                rect.right = width;
                rect.bottom = height;
                this.mMatrix.reset();
                scaleType.getTransform(this.mMatrix, this.mRect, i2, i3, 0.0f, 0.0f);
                RectF rectF = this.mRectF;
                rectF.top = 0.0f;
                rectF.left = 0.0f;
                rectF.right = (float) i2;
                rectF.bottom = (float) i3;
                this.mMatrix.mapRect(rectF);
                width = Math.min(width, (int) this.mRectF.width());
                height = Math.min(height, (int) this.mRectF.height());
            }
            float f2 = (float) width;
            float f3 = f2 * IMAGE_SIZE_THRESHOLD_OK;
            float f4 = f2 * IMAGE_SIZE_THRESHOLD_NOT_OK;
            float f5 = (float) height;
            float f6 = IMAGE_SIZE_THRESHOLD_OK * f5;
            float f7 = f5 * IMAGE_SIZE_THRESHOLD_NOT_OK;
            int abs = Math.abs(i2 - width);
            int abs2 = Math.abs(i3 - height);
            float f8 = (float) abs;
            if (f8 < f3 && ((float) abs2) < f6) {
                return TEXT_COLOR_IMAGE_OK;
            }
            if (f8 >= f4 || ((float) abs2) >= f7) {
                return TEXT_COLOR_IMAGE_NOT_OK;
            }
            return TEXT_COLOR_IMAGE_ALMOST_OK;
        }
        return TEXT_COLOR_IMAGE_NOT_OK;
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(2.0f);
        this.mPaint.setColor(OUTLINE_COLOR);
        canvas.drawRect((float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, this.mPaint);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.mOverlayColor);
        canvas.drawRect((float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, this.mPaint);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setStrokeWidth(0.0f);
        this.mPaint.setColor(-1);
        this.mCurrentTextXPx = this.mStartTextXPx;
        this.mCurrentTextYPx = this.mStartTextYPx;
        String str = this.mImageId;
        if (str != null) {
            addDebugText(canvas, "IDs", format("%s, %s", this.mControllerId, str));
        } else {
            addDebugText(canvas, "ID", this.mControllerId);
        }
        addDebugText(canvas, "D", format("%dx%d", Integer.valueOf(bounds.width()), Integer.valueOf(bounds.height())));
        addDebugText(canvas, "I", format("%dx%d", Integer.valueOf(this.mWidthPx), Integer.valueOf(this.mHeightPx)), determineSizeHintColor(this.mWidthPx, this.mHeightPx, this.mScaleType));
        addDebugText(canvas, "I", format("%d KiB", Integer.valueOf(this.mImageSizeBytes / 1024)));
        String str2 = this.mImageFormat;
        if (str2 != null) {
            addDebugText(canvas, "i format", str2);
        }
        int i2 = this.mFrameCount;
        if (i2 > 0) {
            addDebugText(canvas, "anim", format("f %d, l %d", Integer.valueOf(i2), Integer.valueOf(this.mLoopCount)));
        }
        ScalingUtils.ScaleType scaleType = this.mScaleType;
        if (scaleType != null) {
            addDebugText(canvas, "scale", (Object) scaleType);
        }
        long j2 = this.mFinalImageTimeMs;
        if (j2 >= 0) {
            addDebugText(canvas, "t", format("%d ms", Long.valueOf(j2)));
        }
        String str3 = this.mOriginText;
        if (str3 != null) {
            addDebugText(canvas, "origin", str3, this.mOriginColor);
        }
        for (Map.Entry next : this.mAdditionalData.entrySet()) {
            addDebugText(canvas, (String) next.getKey(), (String) next.getValue());
        }
    }

    public int getOpacity() {
        return -3;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        prepareDebugTextParameters(rect, 9, 8);
    }

    public void onFinalImageSet(long j2) {
        this.mFinalImageTimeMs = j2;
        invalidateSelf();
    }

    public void reset() {
        this.mWidthPx = -1;
        this.mHeightPx = -1;
        this.mImageSizeBytes = -1;
        this.mAdditionalData = new HashMap<>();
        this.mFrameCount = -1;
        this.mLoopCount = -1;
        this.mImageFormat = null;
        setControllerId((String) null);
        this.mFinalImageTimeMs = -1;
        this.mOriginText = null;
        this.mOriginColor = -1;
        invalidateSelf();
    }

    public void setAlpha(int i2) {
    }

    public void setAnimationInfo(int i2, int i3) {
        this.mFrameCount = i2;
        this.mLoopCount = i3;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void setControllerId(String str) {
        if (str == null) {
            str = "none";
        }
        this.mControllerId = str;
        invalidateSelf();
    }

    public void setDimensions(int i2, int i3) {
        this.mWidthPx = i2;
        this.mHeightPx = i3;
        invalidateSelf();
    }

    public void setFinalImageTimeMs(long j2) {
        this.mFinalImageTimeMs = j2;
    }

    public void setImageFormat(String str) {
        this.mImageFormat = str;
    }

    public void setImageId(String str) {
        this.mImageId = str;
        invalidateSelf();
    }

    public void setImageSize(int i2) {
        this.mImageSizeBytes = i2;
    }

    public void setOrigin(String str, int i2) {
        this.mOriginText = str;
        this.mOriginColor = i2;
        invalidateSelf();
    }

    public void setOverlayColor(int i2) {
        this.mOverlayColor = i2;
    }

    public void setScaleType(ScalingUtils.ScaleType scaleType) {
        this.mScaleType = scaleType;
    }

    public void setTextGravity(int i2) {
        this.mTextGravity = i2;
        invalidateSelf();
    }

    private void addDebugText(Canvas canvas, String str, String str2) {
        addDebugText(canvas, str, str2, -1);
    }

    private void addDebugText(Canvas canvas, String str, String str2, int i2) {
        String str3 = str + ": ";
        float measureText = this.mPaint.measureText(str3);
        float measureText2 = this.mPaint.measureText(str2);
        this.mPaint.setColor(TEXT_BACKGROUND_COLOR);
        int i3 = this.mCurrentTextXPx;
        int i4 = this.mCurrentTextYPx;
        canvas.drawRect((float) (i3 - 4), (float) (i4 + 8), ((float) i3) + measureText + measureText2 + 4.0f, (float) (i4 + this.mLineIncrementPx + 8), this.mPaint);
        this.mPaint.setColor(-1);
        canvas.drawText(str3, (float) this.mCurrentTextXPx, (float) this.mCurrentTextYPx, this.mPaint);
        this.mPaint.setColor(i2);
        canvas.drawText(str2, ((float) this.mCurrentTextXPx) + measureText, (float) this.mCurrentTextYPx, this.mPaint);
        this.mCurrentTextYPx += this.mLineIncrementPx;
    }
}
