package androidx.core.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import java.util.List;
import java.util.Map;

public abstract class SharedElementCallback {

    /* renamed from: a  reason: collision with root package name */
    private Matrix f2471a;

    public interface OnSharedElementsReadyListener {
        void onSharedElementsReady();
    }

    private static Bitmap a(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return null;
        }
        float min = Math.min(1.0f, 1048576.0f / ((float) (intrinsicWidth * intrinsicHeight)));
        if ((drawable instanceof BitmapDrawable) && min == 1.0f) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int i2 = (int) (((float) intrinsicWidth) * min);
        int i3 = (int) (((float) intrinsicHeight) * min);
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Rect bounds = drawable.getBounds();
        int i4 = bounds.left;
        int i5 = bounds.top;
        int i6 = bounds.right;
        int i7 = bounds.bottom;
        drawable.setBounds(0, 0, i2, i3);
        drawable.draw(canvas);
        drawable.setBounds(i4, i5, i6, i7);
        return createBitmap;
    }

    public Parcelable b(View view, Matrix matrix, RectF rectF) {
        Bitmap a2;
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            Drawable drawable = imageView.getDrawable();
            Drawable background = imageView.getBackground();
            if (!(drawable == null || background != null || (a2 = a(drawable)) == null)) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("sharedElement:snapshot:bitmap", a2);
                bundle.putString("sharedElement:snapshot:imageScaleType", imageView.getScaleType().toString());
                if (imageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                    float[] fArr = new float[9];
                    imageView.getImageMatrix().getValues(fArr);
                    bundle.putFloatArray("sharedElement:snapshot:imageMatrix", fArr);
                }
                return bundle;
            }
        }
        int round = Math.round(rectF.width());
        int round2 = Math.round(rectF.height());
        if (round <= 0 || round2 <= 0) {
            return null;
        }
        float min = Math.min(1.0f, 1048576.0f / ((float) (round * round2)));
        int i2 = (int) (((float) round) * min);
        int i3 = (int) (((float) round2) * min);
        if (this.f2471a == null) {
            this.f2471a = new Matrix();
        }
        this.f2471a.set(matrix);
        this.f2471a.postTranslate(-rectF.left, -rectF.top);
        this.f2471a.postScale(min, min);
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.concat(this.f2471a);
        view.draw(canvas);
        return createBitmap;
    }

    public View c(Context context, Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            Bitmap bitmap = (Bitmap) bundle.getParcelable("sharedElement:snapshot:bitmap");
            if (bitmap == null) {
                return null;
            }
            ImageView imageView = new ImageView(context);
            imageView.setImageBitmap(bitmap);
            imageView.setScaleType(ImageView.ScaleType.valueOf(bundle.getString("sharedElement:snapshot:imageScaleType")));
            if (imageView.getScaleType() != ImageView.ScaleType.MATRIX) {
                return imageView;
            }
            float[] floatArray = bundle.getFloatArray("sharedElement:snapshot:imageMatrix");
            Matrix matrix = new Matrix();
            matrix.setValues(floatArray);
            imageView.setImageMatrix(matrix);
            return imageView;
        } else if (!(parcelable instanceof Bitmap)) {
            return null;
        } else {
            ImageView imageView2 = new ImageView(context);
            imageView2.setImageBitmap((Bitmap) parcelable);
            return imageView2;
        }
    }

    public void d(List<String> list, Map<String, View> map) {
    }

    public void e(List<View> list) {
    }

    public void f(List<String> list, List<View> list2, List<View> list3) {
    }

    public void g(List<String> list, List<View> list2, List<View> list3) {
    }

    public void h(List<String> list, List<View> list2, OnSharedElementsReadyListener onSharedElementsReadyListener) {
        onSharedElementsReadyListener.onSharedElementsReady();
    }
}
