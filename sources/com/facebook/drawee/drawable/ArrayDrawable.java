package com.facebook.drawee.drawable;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;

public class ArrayDrawable extends Drawable implements Drawable.Callback, TransformCallback, TransformAwareDrawable {
    private final DrawableParent[] mDrawableParents;
    private final DrawableProperties mDrawableProperties = new DrawableProperties();
    private boolean mIsMutated;
    private boolean mIsStateful;
    private boolean mIsStatefulCalculated;
    private final Drawable[] mLayers;
    private final Rect mTmpRect = new Rect();
    private TransformCallback mTransformCallback;

    public ArrayDrawable(Drawable[] drawableArr) {
        int i2 = 0;
        this.mIsStateful = false;
        this.mIsStatefulCalculated = false;
        this.mIsMutated = false;
        Preconditions.checkNotNull(drawableArr);
        this.mLayers = drawableArr;
        while (true) {
            Drawable[] drawableArr2 = this.mLayers;
            if (i2 < drawableArr2.length) {
                DrawableUtils.setCallbacks(drawableArr2[i2], this, this);
                i2++;
            } else {
                this.mDrawableParents = new DrawableParent[drawableArr2.length];
                return;
            }
        }
    }

    private DrawableParent createDrawableParentForIndex(final int i2) {
        return new DrawableParent() {
            public Drawable getDrawable() {
                return ArrayDrawable.this.getDrawable(i2);
            }

            public Drawable setDrawable(Drawable drawable) {
                return ArrayDrawable.this.setDrawable(i2, drawable);
            }
        };
    }

    public void draw(Canvas canvas) {
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i2 < drawableArr.length) {
                Drawable drawable = drawableArr[i2];
                if (drawable != null) {
                    drawable.draw(canvas);
                }
                i2++;
            } else {
                return;
            }
        }
    }

    public Drawable getDrawable(int i2) {
        boolean z2;
        boolean z3 = true;
        if (i2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z2));
        if (i2 >= this.mLayers.length) {
            z3 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z3));
        return this.mLayers[i2];
    }

    public DrawableParent getDrawableParentForIndex(int i2) {
        boolean z2;
        boolean z3 = true;
        if (i2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z2));
        if (i2 >= this.mDrawableParents.length) {
            z3 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z3));
        DrawableParent[] drawableParentArr = this.mDrawableParents;
        if (drawableParentArr[i2] == null) {
            drawableParentArr[i2] = createDrawableParentForIndex(i2);
        }
        return this.mDrawableParents[i2];
    }

    public int getIntrinsicHeight() {
        int i2 = 0;
        int i3 = -1;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i2 >= drawableArr.length) {
                break;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                i3 = Math.max(i3, drawable.getIntrinsicHeight());
            }
            i2++;
        }
        if (i3 > 0) {
            return i3;
        }
        return -1;
    }

    public int getIntrinsicWidth() {
        int i2 = 0;
        int i3 = -1;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i2 >= drawableArr.length) {
                break;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                i3 = Math.max(i3, drawable.getIntrinsicWidth());
            }
            i2++;
        }
        if (i3 > 0) {
            return i3;
        }
        return -1;
    }

    public int getNumberOfLayers() {
        return this.mLayers.length;
    }

    public int getOpacity() {
        if (this.mLayers.length == 0) {
            return -2;
        }
        int i2 = 1;
        int i3 = -1;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i2 >= drawableArr.length) {
                return i3;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                i3 = Drawable.resolveOpacity(i3, drawable.getOpacity());
            }
            i2++;
        }
    }

    public boolean getPadding(Rect rect) {
        int i2 = 0;
        rect.left = 0;
        rect.top = 0;
        rect.right = 0;
        rect.bottom = 0;
        Rect rect2 = this.mTmpRect;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i2 >= drawableArr.length) {
                return true;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.getPadding(rect2);
                rect.left = Math.max(rect.left, rect2.left);
                rect.top = Math.max(rect.top, rect2.top);
                rect.right = Math.max(rect.right, rect2.right);
                rect.bottom = Math.max(rect.bottom, rect2.bottom);
            }
            i2++;
        }
    }

    public void getRootBounds(RectF rectF) {
        TransformCallback transformCallback = this.mTransformCallback;
        if (transformCallback != null) {
            transformCallback.getRootBounds(rectF);
        } else {
            rectF.set(getBounds());
        }
    }

    public void getTransform(Matrix matrix) {
        TransformCallback transformCallback = this.mTransformCallback;
        if (transformCallback != null) {
            transformCallback.getTransform(matrix);
        } else {
            matrix.reset();
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isStateful() {
        if (!this.mIsStatefulCalculated) {
            this.mIsStateful = false;
            int i2 = 0;
            while (true) {
                Drawable[] drawableArr = this.mLayers;
                boolean z2 = true;
                if (i2 >= drawableArr.length) {
                    break;
                }
                Drawable drawable = drawableArr[i2];
                boolean z3 = this.mIsStateful;
                if (drawable == null || !drawable.isStateful()) {
                    z2 = false;
                }
                this.mIsStateful = z3 | z2;
                i2++;
            }
            this.mIsStatefulCalculated = true;
        }
        return this.mIsStateful;
    }

    public Drawable mutate() {
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i2 < drawableArr.length) {
                Drawable drawable = drawableArr[i2];
                if (drawable != null) {
                    drawable.mutate();
                }
                i2++;
            } else {
                this.mIsMutated = true;
                return this;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i2 < drawableArr.length) {
                Drawable drawable = drawableArr[i2];
                if (drawable != null) {
                    drawable.setBounds(rect);
                }
                i2++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i2) {
        int i3 = 0;
        boolean z2 = false;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i3 >= drawableArr.length) {
                return z2;
            }
            Drawable drawable = drawableArr[i3];
            if (drawable != null && drawable.setLevel(i2)) {
                z2 = true;
            }
            i3++;
        }
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        int i2 = 0;
        boolean z2 = false;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i2 >= drawableArr.length) {
                return z2;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null && drawable.setState(iArr)) {
                z2 = true;
            }
            i2++;
        }
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    public void setAlpha(int i2) {
        this.mDrawableProperties.setAlpha(i2);
        int i3 = 0;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i3 < drawableArr.length) {
                Drawable drawable = drawableArr[i3];
                if (drawable != null) {
                    drawable.setAlpha(i2);
                }
                i3++;
            } else {
                return;
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mDrawableProperties.setColorFilter(colorFilter);
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i2 < drawableArr.length) {
                Drawable drawable = drawableArr[i2];
                if (drawable != null) {
                    drawable.setColorFilter(colorFilter);
                }
                i2++;
            } else {
                return;
            }
        }
    }

    public void setDither(boolean z2) {
        this.mDrawableProperties.setDither(z2);
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i2 < drawableArr.length) {
                Drawable drawable = drawableArr[i2];
                if (drawable != null) {
                    drawable.setDither(z2);
                }
                i2++;
            } else {
                return;
            }
        }
    }

    public Drawable setDrawable(int i2, Drawable drawable) {
        boolean z2;
        boolean z3 = true;
        if (i2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z2));
        if (i2 >= this.mLayers.length) {
            z3 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z3));
        Drawable drawable2 = this.mLayers[i2];
        if (drawable != drawable2) {
            if (drawable != null && this.mIsMutated) {
                drawable.mutate();
            }
            DrawableUtils.setCallbacks(this.mLayers[i2], (Drawable.Callback) null, (TransformCallback) null);
            DrawableUtils.setCallbacks(drawable, (Drawable.Callback) null, (TransformCallback) null);
            DrawableUtils.setDrawableProperties(drawable, this.mDrawableProperties);
            DrawableUtils.copyProperties(drawable, this);
            DrawableUtils.setCallbacks(drawable, this, this);
            this.mIsStatefulCalculated = false;
            this.mLayers[i2] = drawable;
            invalidateSelf();
        }
        return drawable2;
    }

    public void setFilterBitmap(boolean z2) {
        this.mDrawableProperties.setFilterBitmap(z2);
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i2 < drawableArr.length) {
                Drawable drawable = drawableArr[i2];
                if (drawable != null) {
                    drawable.setFilterBitmap(z2);
                }
                i2++;
            } else {
                return;
            }
        }
    }

    @TargetApi(21)
    public void setHotspot(float f2, float f3) {
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i2 < drawableArr.length) {
                Drawable drawable = drawableArr[i2];
                if (drawable != null) {
                    drawable.setHotspot(f2, f3);
                }
                i2++;
            } else {
                return;
            }
        }
    }

    public void setTransformCallback(TransformCallback transformCallback) {
        this.mTransformCallback = transformCallback;
    }

    public boolean setVisible(boolean z2, boolean z3) {
        boolean visible = super.setVisible(z2, z3);
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i2 >= drawableArr.length) {
                return visible;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.setVisible(z2, z3);
            }
            i2++;
        }
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
