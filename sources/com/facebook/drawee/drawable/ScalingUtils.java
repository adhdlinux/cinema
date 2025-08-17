package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class ScalingUtils {

    public static abstract class AbstractScaleType implements ScaleType {
        public Matrix getTransform(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3) {
            int i4 = i2;
            int i5 = i3;
            getTransformImpl(matrix, rect, i4, i5, f2, f3, ((float) rect.width()) / ((float) i4), ((float) rect.height()) / ((float) i5));
            return matrix;
        }

        public abstract void getTransformImpl(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5);
    }

    public interface ScaleType {
        public static final ScaleType CENTER = ScaleTypeCenter.INSTANCE;
        public static final ScaleType CENTER_CROP = ScaleTypeCenterCrop.INSTANCE;
        public static final ScaleType CENTER_INSIDE = ScaleTypeCenterInside.INSTANCE;
        public static final ScaleType FIT_BOTTOM_START = ScaleTypeFitBottomStart.INSTANCE;
        public static final ScaleType FIT_CENTER = ScaleTypeFitCenter.INSTANCE;
        public static final ScaleType FIT_END = ScaleTypeFitEnd.INSTANCE;
        public static final ScaleType FIT_START = ScaleTypeFitStart.INSTANCE;
        public static final ScaleType FIT_X = ScaleTypeFitX.INSTANCE;
        public static final ScaleType FIT_XY = ScaleTypeFitXY.INSTANCE;
        public static final ScaleType FIT_Y = ScaleTypeFitY.INSTANCE;
        public static final ScaleType FOCUS_CROP = ScaleTypeFocusCrop.INSTANCE;

        Matrix getTransform(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3);
    }

    private static class ScaleTypeCenter extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeCenter();

        private ScaleTypeCenter() {
        }

        public void getTransformImpl(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            matrix.setTranslate((float) ((int) (((float) rect.left) + (((float) (rect.width() - i2)) * 0.5f) + 0.5f)), (float) ((int) (((float) rect.top) + (((float) (rect.height() - i3)) * 0.5f) + 0.5f)));
        }

        public String toString() {
            return "center";
        }
    }

    private static class ScaleTypeCenterCrop extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeCenterCrop();

        private ScaleTypeCenterCrop() {
        }

        public void getTransformImpl(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float f6;
            float f7;
            if (f5 > f4) {
                f6 = ((float) rect.left) + ((((float) rect.width()) - (((float) i2) * f5)) * 0.5f);
                f7 = (float) rect.top;
                f4 = f5;
            } else {
                f7 = ((((float) rect.height()) - (((float) i3) * f4)) * 0.5f) + ((float) rect.top);
                f6 = (float) rect.left;
            }
            matrix.setScale(f4, f4);
            matrix.postTranslate((float) ((int) (f6 + 0.5f)), (float) ((int) (f7 + 0.5f)));
        }

        public String toString() {
            return "center_crop";
        }
    }

    private static class ScaleTypeCenterInside extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeCenterInside();

        private ScaleTypeCenterInside() {
        }

        public void getTransformImpl(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float min = Math.min(Math.min(f4, f5), 1.0f);
            float width = ((float) rect.left) + ((((float) rect.width()) - (((float) i2) * min)) * 0.5f);
            float height = ((float) rect.top) + ((((float) rect.height()) - (((float) i3) * min)) * 0.5f);
            matrix.setScale(min, min);
            matrix.postTranslate((float) ((int) (width + 0.5f)), (float) ((int) (height + 0.5f)));
        }

        public String toString() {
            return "center_inside";
        }
    }

    private static class ScaleTypeFitBottomStart extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeFitBottomStart();

        private ScaleTypeFitBottomStart() {
        }

        public void getTransformImpl(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float min = Math.min(f4, f5);
            matrix.setScale(min, min);
            matrix.postTranslate((float) ((int) (((float) rect.left) + 0.5f)), (float) ((int) (((float) rect.top) + (((float) rect.height()) - (((float) i3) * min)) + 0.5f)));
        }

        public String toString() {
            return "fit_bottom_start";
        }
    }

    private static class ScaleTypeFitCenter extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeFitCenter();

        private ScaleTypeFitCenter() {
        }

        public void getTransformImpl(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float min = Math.min(f4, f5);
            float width = ((float) rect.left) + ((((float) rect.width()) - (((float) i2) * min)) * 0.5f);
            float height = ((float) rect.top) + ((((float) rect.height()) - (((float) i3) * min)) * 0.5f);
            matrix.setScale(min, min);
            matrix.postTranslate((float) ((int) (width + 0.5f)), (float) ((int) (height + 0.5f)));
        }

        public String toString() {
            return "fit_center";
        }
    }

    private static class ScaleTypeFitEnd extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeFitEnd();

        private ScaleTypeFitEnd() {
        }

        public void getTransformImpl(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float min = Math.min(f4, f5);
            matrix.setScale(min, min);
            matrix.postTranslate((float) ((int) (((float) rect.left) + (((float) rect.width()) - (((float) i2) * min)) + 0.5f)), (float) ((int) (((float) rect.top) + (((float) rect.height()) - (((float) i3) * min)) + 0.5f)));
        }

        public String toString() {
            return "fit_end";
        }
    }

    private static class ScaleTypeFitStart extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeFitStart();

        private ScaleTypeFitStart() {
        }

        public void getTransformImpl(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float min = Math.min(f4, f5);
            matrix.setScale(min, min);
            matrix.postTranslate((float) ((int) (((float) rect.left) + 0.5f)), (float) ((int) (((float) rect.top) + 0.5f)));
        }

        public String toString() {
            return "fit_start";
        }
    }

    private static class ScaleTypeFitX extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeFitX();

        private ScaleTypeFitX() {
        }

        public void getTransformImpl(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float height = ((float) rect.top) + ((((float) rect.height()) - (((float) i3) * f4)) * 0.5f);
            matrix.setScale(f4, f4);
            matrix.postTranslate((float) ((int) (((float) rect.left) + 0.5f)), (float) ((int) (height + 0.5f)));
        }

        public String toString() {
            return "fit_x";
        }
    }

    private static class ScaleTypeFitXY extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeFitXY();

        private ScaleTypeFitXY() {
        }

        public void getTransformImpl(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            matrix.setScale(f4, f5);
            matrix.postTranslate((float) ((int) (((float) rect.left) + 0.5f)), (float) ((int) (((float) rect.top) + 0.5f)));
        }

        public String toString() {
            return "fit_xy";
        }
    }

    private static class ScaleTypeFitY extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeFitY();

        private ScaleTypeFitY() {
        }

        public void getTransformImpl(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            matrix.setScale(f5, f5);
            matrix.postTranslate((float) ((int) (((float) rect.left) + ((((float) rect.width()) - (((float) i2) * f5)) * 0.5f) + 0.5f)), (float) ((int) (((float) rect.top) + 0.5f)));
        }

        public String toString() {
            return "fit_y";
        }
    }

    private static class ScaleTypeFocusCrop extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeFocusCrop();

        private ScaleTypeFocusCrop() {
        }

        public void getTransformImpl(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float f6;
            float f7;
            if (f5 > f4) {
                float f8 = ((float) i2) * f5;
                f6 = ((float) rect.left) + Math.max(Math.min((((float) rect.width()) * 0.5f) - (f2 * f8), 0.0f), ((float) rect.width()) - f8);
                f7 = (float) rect.top;
                f4 = f5;
            } else {
                f6 = (float) rect.left;
                float f9 = ((float) i3) * f4;
                f7 = Math.max(Math.min((((float) rect.height()) * 0.5f) - (f3 * f9), 0.0f), ((float) rect.height()) - f9) + ((float) rect.top);
            }
            matrix.setScale(f4, f4);
            matrix.postTranslate((float) ((int) (f6 + 0.5f)), (float) ((int) (f7 + 0.5f)));
        }

        public String toString() {
            return "focus_crop";
        }
    }

    public interface StatefulScaleType {
        Object getState();
    }

    public static ScaleTypeDrawable getActiveScaleTypeDrawable(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof ScaleTypeDrawable) {
            return (ScaleTypeDrawable) drawable;
        }
        if (drawable instanceof DrawableParent) {
            return getActiveScaleTypeDrawable(((DrawableParent) drawable).getDrawable());
        }
        if (drawable instanceof ArrayDrawable) {
            ArrayDrawable arrayDrawable = (ArrayDrawable) drawable;
            int numberOfLayers = arrayDrawable.getNumberOfLayers();
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                ScaleTypeDrawable activeScaleTypeDrawable = getActiveScaleTypeDrawable(arrayDrawable.getDrawable(i2));
                if (activeScaleTypeDrawable != null) {
                    return activeScaleTypeDrawable;
                }
            }
        }
        return null;
    }

    public static class InterpolatingScaleType implements ScaleType, StatefulScaleType {
        private final Rect mBoundsFrom;
        private final Rect mBoundsTo;
        private final PointF mFocusPointFrom;
        private final PointF mFocusPointTo;
        private float mInterpolatingValue;
        private final float[] mMatrixValuesFrom;
        private final float[] mMatrixValuesInterpolated;
        private final float[] mMatrixValuesTo;
        private final ScaleType mScaleTypeFrom;
        private final ScaleType mScaleTypeTo;

        public InterpolatingScaleType(ScaleType scaleType, ScaleType scaleType2, Rect rect, Rect rect2, PointF pointF, PointF pointF2) {
            this.mMatrixValuesFrom = new float[9];
            this.mMatrixValuesTo = new float[9];
            this.mMatrixValuesInterpolated = new float[9];
            this.mScaleTypeFrom = scaleType;
            this.mScaleTypeTo = scaleType2;
            this.mBoundsFrom = rect;
            this.mBoundsTo = rect2;
            this.mFocusPointFrom = pointF;
            this.mFocusPointTo = pointF2;
        }

        public Rect getBoundsFrom() {
            return this.mBoundsFrom;
        }

        public Rect getBoundsTo() {
            return this.mBoundsTo;
        }

        public PointF getFocusPointFrom() {
            return this.mFocusPointFrom;
        }

        public PointF getFocusPointTo() {
            return this.mFocusPointTo;
        }

        public ScaleType getScaleTypeFrom() {
            return this.mScaleTypeFrom;
        }

        public ScaleType getScaleTypeTo() {
            return this.mScaleTypeTo;
        }

        public Object getState() {
            return Float.valueOf(this.mInterpolatingValue);
        }

        public Matrix getTransform(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3) {
            Rect rect2;
            Rect rect3;
            float f4;
            float f5;
            float f6;
            float f7;
            Matrix matrix2 = matrix;
            Rect rect4 = this.mBoundsFrom;
            if (rect4 != null) {
                rect2 = rect4;
            } else {
                rect2 = rect;
            }
            Rect rect5 = this.mBoundsTo;
            if (rect5 != null) {
                rect3 = rect5;
            } else {
                rect3 = rect;
            }
            ScaleType scaleType = this.mScaleTypeFrom;
            PointF pointF = this.mFocusPointFrom;
            if (pointF == null) {
                f4 = f2;
            } else {
                f4 = pointF.x;
            }
            if (pointF == null) {
                f5 = f3;
            } else {
                f5 = pointF.y;
            }
            scaleType.getTransform(matrix, rect2, i2, i3, f4, f5);
            matrix.getValues(this.mMatrixValuesFrom);
            ScaleType scaleType2 = this.mScaleTypeTo;
            PointF pointF2 = this.mFocusPointTo;
            if (pointF2 == null) {
                f6 = f2;
            } else {
                f6 = pointF2.x;
            }
            if (pointF2 == null) {
                f7 = f3;
            } else {
                f7 = pointF2.y;
            }
            scaleType2.getTransform(matrix, rect3, i2, i3, f6, f7);
            matrix.getValues(this.mMatrixValuesTo);
            for (int i4 = 0; i4 < 9; i4++) {
                float[] fArr = this.mMatrixValuesInterpolated;
                float f8 = this.mMatrixValuesFrom[i4];
                float f9 = this.mInterpolatingValue;
                fArr[i4] = (f8 * (1.0f - f9)) + (this.mMatrixValuesTo[i4] * f9);
            }
            matrix.setValues(this.mMatrixValuesInterpolated);
            return matrix2;
        }

        public float getValue() {
            return this.mInterpolatingValue;
        }

        public void setValue(float f2) {
            this.mInterpolatingValue = f2;
        }

        public String toString() {
            return String.format("InterpolatingScaleType(%s (%s) -> %s (%s))", new Object[]{String.valueOf(this.mScaleTypeFrom), String.valueOf(this.mFocusPointFrom), String.valueOf(this.mScaleTypeTo), String.valueOf(this.mFocusPointTo)});
        }

        public InterpolatingScaleType(ScaleType scaleType, ScaleType scaleType2, Rect rect, Rect rect2) {
            this(scaleType, scaleType2, rect, rect2, (PointF) null, (PointF) null);
        }

        public InterpolatingScaleType(ScaleType scaleType, ScaleType scaleType2) {
            this(scaleType, scaleType2, (Rect) null, (Rect) null);
        }
    }
}
