package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.common.internal.Preconditions;
import com.facebook.imageutils.JfifUtil;
import com.facebook.infer.annotation.Nullsafe;
import java.util.Arrays;

@Nullsafe(Nullsafe.Mode.STRICT)
public class FadeDrawable extends ArrayDrawable {
    public static final int TRANSITION_NONE = 2;
    public static final int TRANSITION_RUNNING = 1;
    public static final int TRANSITION_STARTING = 0;
    private final int mActualImageLayer;
    int mAlpha;
    int[] mAlphas;
    private final int mDefaultLayerAlpha;
    private final boolean mDefaultLayerIsOn;
    int mDurationMs;
    private boolean mIsFadingActualImage;
    boolean[] mIsLayerOn;
    private final Drawable[] mLayers;
    private boolean mMutateDrawables;
    private OnFadeListener mOnFadeListener;
    private boolean mOnFadeListenerShowImmediately;
    int mPreventInvalidateCount;
    int[] mStartAlphas;
    long mStartTimeMs;
    int mTransitionState;

    public interface OnFadeListener {
        void onFadeFinished();

        void onFadeStarted();

        void onShownImmediately();
    }

    public FadeDrawable(Drawable[] drawableArr) {
        this(drawableArr, false, -1);
    }

    private void drawDrawableWithAlpha(Canvas canvas, Drawable drawable, int i2) {
        if (drawable != null && i2 > 0) {
            this.mPreventInvalidateCount++;
            if (this.mMutateDrawables) {
                drawable.mutate();
            }
            drawable.setAlpha(i2);
            this.mPreventInvalidateCount--;
            drawable.draw(canvas);
        }
    }

    private void maybeOnFadeFinished() {
        if (this.mIsFadingActualImage) {
            this.mIsFadingActualImage = false;
            OnFadeListener onFadeListener = this.mOnFadeListener;
            if (onFadeListener != null) {
                onFadeListener.onFadeFinished();
            }
        }
    }

    private void maybeOnFadeStarted() {
        int i2;
        if (!this.mIsFadingActualImage && (i2 = this.mActualImageLayer) >= 0) {
            boolean[] zArr = this.mIsLayerOn;
            if (i2 < zArr.length && zArr[i2]) {
                this.mIsFadingActualImage = true;
                OnFadeListener onFadeListener = this.mOnFadeListener;
                if (onFadeListener != null) {
                    onFadeListener.onFadeStarted();
                }
            }
        }
    }

    private void maybeOnImageShownImmediately() {
        if (this.mOnFadeListenerShowImmediately && this.mTransitionState == 2 && this.mIsLayerOn[this.mActualImageLayer]) {
            OnFadeListener onFadeListener = this.mOnFadeListener;
            if (onFadeListener != null) {
                onFadeListener.onShownImmediately();
            }
            this.mOnFadeListenerShowImmediately = false;
        }
    }

    private void resetInternal() {
        this.mTransitionState = 2;
        Arrays.fill(this.mStartAlphas, this.mDefaultLayerAlpha);
        this.mStartAlphas[0] = 255;
        Arrays.fill(this.mAlphas, this.mDefaultLayerAlpha);
        this.mAlphas[0] = 255;
        Arrays.fill(this.mIsLayerOn, this.mDefaultLayerIsOn);
        this.mIsLayerOn[0] = true;
    }

    private boolean updateAlphas(float f2) {
        int i2;
        boolean z2 = true;
        for (int i3 = 0; i3 < this.mLayers.length; i3++) {
            boolean z3 = this.mIsLayerOn[i3];
            if (z3) {
                i2 = 1;
            } else {
                i2 = -1;
            }
            int[] iArr = this.mAlphas;
            int i4 = (int) (((float) this.mStartAlphas[i3]) + (((float) (i2 * JfifUtil.MARKER_FIRST_BYTE)) * f2));
            iArr[i3] = i4;
            if (i4 < 0) {
                iArr[i3] = 0;
            }
            if (iArr[i3] > 255) {
                iArr[i3] = 255;
            }
            if (z3 && iArr[i3] < 255) {
                z2 = false;
            }
            if (!z3 && iArr[i3] > 0) {
                z2 = false;
            }
        }
        return z2;
    }

    public void beginBatchMode() {
        this.mPreventInvalidateCount++;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0056 A[LOOP:0: B:20:0x0051->B:22:0x0056, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0072 A[EDGE_INSN: B:26:0x0072->B:23:0x0072 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(android.graphics.Canvas r9) {
        /*
            r8 = this;
            int r0 = r8.mTransitionState
            r1 = 2
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x002b
            if (r0 == r3) goto L_0x000a
            goto L_0x0051
        L_0x000a:
            int r0 = r8.mDurationMs
            if (r0 <= 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            com.facebook.common.internal.Preconditions.checkState(r0)
            long r4 = r8.getCurrentTimeMs()
            long r6 = r8.mStartTimeMs
            long r4 = r4 - r6
            float r0 = (float) r4
            int r4 = r8.mDurationMs
            float r4 = (float) r4
            float r0 = r0 / r4
            boolean r0 = r8.updateAlphas(r0)
            if (r0 == 0) goto L_0x0027
            goto L_0x0028
        L_0x0027:
            r1 = 1
        L_0x0028:
            r8.mTransitionState = r1
            goto L_0x0050
        L_0x002b:
            int[] r0 = r8.mAlphas
            int[] r4 = r8.mStartAlphas
            android.graphics.drawable.Drawable[] r5 = r8.mLayers
            int r5 = r5.length
            java.lang.System.arraycopy(r0, r2, r4, r2, r5)
            long r4 = r8.getCurrentTimeMs()
            r8.mStartTimeMs = r4
            int r0 = r8.mDurationMs
            if (r0 != 0) goto L_0x0042
            r0 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0043
        L_0x0042:
            r0 = 0
        L_0x0043:
            boolean r0 = r8.updateAlphas(r0)
            r8.maybeOnFadeStarted()
            if (r0 == 0) goto L_0x004d
            goto L_0x004e
        L_0x004d:
            r1 = 1
        L_0x004e:
            r8.mTransitionState = r1
        L_0x0050:
            r3 = r0
        L_0x0051:
            android.graphics.drawable.Drawable[] r0 = r8.mLayers
            int r1 = r0.length
            if (r2 >= r1) goto L_0x0072
            r0 = r0[r2]
            int[] r1 = r8.mAlphas
            r1 = r1[r2]
            int r4 = r8.mAlpha
            int r1 = r1 * r4
            double r4 = (double) r1
            r6 = 4643176031446892544(0x406fe00000000000, double:255.0)
            double r4 = r4 / r6
            double r4 = java.lang.Math.ceil(r4)
            int r1 = (int) r4
            r8.drawDrawableWithAlpha(r9, r0, r1)
            int r2 = r2 + 1
            goto L_0x0051
        L_0x0072:
            if (r3 == 0) goto L_0x007b
            r8.maybeOnFadeFinished()
            r8.maybeOnImageShownImmediately()
            goto L_0x007e
        L_0x007b:
            r8.invalidateSelf()
        L_0x007e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.drawable.FadeDrawable.draw(android.graphics.Canvas):void");
    }

    public void endBatchMode() {
        this.mPreventInvalidateCount--;
        invalidateSelf();
    }

    public void fadeInAllLayers() {
        this.mTransitionState = 0;
        Arrays.fill(this.mIsLayerOn, true);
        invalidateSelf();
    }

    public void fadeInLayer(int i2) {
        this.mTransitionState = 0;
        this.mIsLayerOn[i2] = true;
        invalidateSelf();
    }

    public void fadeOutAllLayers() {
        this.mTransitionState = 0;
        Arrays.fill(this.mIsLayerOn, false);
        invalidateSelf();
    }

    public void fadeOutLayer(int i2) {
        this.mTransitionState = 0;
        this.mIsLayerOn[i2] = false;
        invalidateSelf();
    }

    public void fadeToLayer(int i2) {
        this.mTransitionState = 0;
        Arrays.fill(this.mIsLayerOn, false);
        this.mIsLayerOn[i2] = true;
        invalidateSelf();
    }

    public void fadeUpToLayer(int i2) {
        this.mTransitionState = 0;
        int i3 = i2 + 1;
        Arrays.fill(this.mIsLayerOn, 0, i3, true);
        Arrays.fill(this.mIsLayerOn, i3, this.mLayers.length, false);
        invalidateSelf();
    }

    public void finishTransitionImmediately() {
        int i2;
        this.mTransitionState = 2;
        for (int i3 = 0; i3 < this.mLayers.length; i3++) {
            int[] iArr = this.mAlphas;
            if (this.mIsLayerOn[i3]) {
                i2 = JfifUtil.MARKER_FIRST_BYTE;
            } else {
                i2 = 0;
            }
            iArr[i3] = i2;
        }
        invalidateSelf();
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    /* access modifiers changed from: protected */
    public long getCurrentTimeMs() {
        return SystemClock.uptimeMillis();
    }

    public int getTransitionDuration() {
        return this.mDurationMs;
    }

    public int getTransitionState() {
        return this.mTransitionState;
    }

    public void hideLayerImmediately(int i2) {
        this.mIsLayerOn[i2] = false;
        this.mAlphas[i2] = 0;
        invalidateSelf();
    }

    public void invalidateSelf() {
        if (this.mPreventInvalidateCount == 0) {
            super.invalidateSelf();
        }
    }

    public boolean isDefaultLayerIsOn() {
        return this.mDefaultLayerIsOn;
    }

    public boolean isLayerOn(int i2) {
        return this.mIsLayerOn[i2];
    }

    public void reset() {
        resetInternal();
        invalidateSelf();
    }

    public void setAlpha(int i2) {
        if (this.mAlpha != i2) {
            this.mAlpha = i2;
            invalidateSelf();
        }
    }

    public void setMutateDrawables(boolean z2) {
        this.mMutateDrawables = z2;
    }

    public void setOnFadeListener(OnFadeListener onFadeListener) {
        this.mOnFadeListener = onFadeListener;
    }

    public void setTransitionDuration(int i2) {
        this.mDurationMs = i2;
        if (this.mTransitionState == 1) {
            this.mTransitionState = 0;
        }
    }

    public void showLayerImmediately(int i2) {
        this.mIsLayerOn[i2] = true;
        this.mAlphas[i2] = 255;
        if (i2 == this.mActualImageLayer) {
            this.mOnFadeListenerShowImmediately = true;
        }
        invalidateSelf();
    }

    public FadeDrawable(Drawable[] drawableArr, boolean z2, int i2) {
        super(drawableArr);
        boolean z3 = true;
        this.mMutateDrawables = true;
        int i3 = 0;
        Preconditions.checkState(drawableArr.length < 1 ? false : z3, "At least one layer required!");
        this.mLayers = drawableArr;
        this.mStartAlphas = new int[drawableArr.length];
        this.mAlphas = new int[drawableArr.length];
        this.mAlpha = JfifUtil.MARKER_FIRST_BYTE;
        this.mIsLayerOn = new boolean[drawableArr.length];
        this.mPreventInvalidateCount = 0;
        this.mDefaultLayerIsOn = z2;
        this.mDefaultLayerAlpha = z2 ? JfifUtil.MARKER_FIRST_BYTE : i3;
        this.mActualImageLayer = i2;
        resetInternal();
    }
}
