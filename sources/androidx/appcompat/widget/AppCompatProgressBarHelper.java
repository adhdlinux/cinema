package androidx.appcompat.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.core.graphics.drawable.WrappedDrawable;

class AppCompatProgressBarHelper {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f1153c = {16843067, 16843068};

    /* renamed from: a  reason: collision with root package name */
    private final ProgressBar f1154a;

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f1155b;

    private static class Api23Impl {
        private Api23Impl() {
        }

        public static void a(LayerDrawable layerDrawable, LayerDrawable layerDrawable2, int i2) {
            layerDrawable2.setLayerGravity(i2, layerDrawable.getLayerGravity(i2));
            layerDrawable2.setLayerWidth(i2, layerDrawable.getLayerWidth(i2));
            layerDrawable2.setLayerHeight(i2, layerDrawable.getLayerHeight(i2));
            layerDrawable2.setLayerInsetLeft(i2, layerDrawable.getLayerInsetLeft(i2));
            layerDrawable2.setLayerInsetRight(i2, layerDrawable.getLayerInsetRight(i2));
            layerDrawable2.setLayerInsetTop(i2, layerDrawable.getLayerInsetTop(i2));
            layerDrawable2.setLayerInsetBottom(i2, layerDrawable.getLayerInsetBottom(i2));
            layerDrawable2.setLayerInsetStart(i2, layerDrawable.getLayerInsetStart(i2));
            layerDrawable2.setLayerInsetEnd(i2, layerDrawable.getLayerInsetEnd(i2));
        }
    }

    AppCompatProgressBarHelper(ProgressBar progressBar) {
        this.f1154a = progressBar;
    }

    private Shape a() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, (RectF) null, (float[]) null);
    }

    private Drawable e(Drawable drawable) {
        if (!(drawable instanceof AnimationDrawable)) {
            return drawable;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        AnimationDrawable animationDrawable2 = new AnimationDrawable();
        animationDrawable2.setOneShot(animationDrawable.isOneShot());
        for (int i2 = 0; i2 < numberOfFrames; i2++) {
            Drawable d2 = d(animationDrawable.getFrame(i2), true);
            d2.setLevel(10000);
            animationDrawable2.addFrame(d2, animationDrawable.getDuration(i2));
        }
        animationDrawable2.setLevel(10000);
        return animationDrawable2;
    }

    /* access modifiers changed from: package-private */
    public Bitmap b() {
        return this.f1155b;
    }

    /* access modifiers changed from: package-private */
    public void c(AttributeSet attributeSet, int i2) {
        TintTypedArray v2 = TintTypedArray.v(this.f1154a.getContext(), attributeSet, f1153c, i2, 0);
        Drawable h2 = v2.h(0);
        if (h2 != null) {
            this.f1154a.setIndeterminateDrawable(e(h2));
        }
        Drawable h3 = v2.h(1);
        if (h3 != null) {
            this.f1154a.setProgressDrawable(d(h3, false));
        }
        v2.w();
    }

    /* access modifiers changed from: package-private */
    public Drawable d(Drawable drawable, boolean z2) {
        boolean z3;
        if (drawable instanceof WrappedDrawable) {
            WrappedDrawable wrappedDrawable = (WrappedDrawable) drawable;
            Drawable a2 = wrappedDrawable.a();
            if (a2 != null) {
                wrappedDrawable.b(d(a2, z2));
            }
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                int id = layerDrawable.getId(i2);
                Drawable drawable2 = layerDrawable.getDrawable(i2);
                if (id == 16908301 || id == 16908303) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                drawableArr[i2] = d(drawable2, z3);
            }
            LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
            for (int i3 = 0; i3 < numberOfLayers; i3++) {
                layerDrawable2.setId(i3, layerDrawable.getId(i3));
                if (Build.VERSION.SDK_INT >= 23) {
                    Api23Impl.a(layerDrawable, layerDrawable2, i3);
                }
            }
            return layerDrawable2;
        } else if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (this.f1155b == null) {
                this.f1155b = bitmap;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable(a());
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            if (z2) {
                return new ClipDrawable(shapeDrawable, 3, 1);
            }
            return shapeDrawable;
        }
        return drawable;
    }
}
