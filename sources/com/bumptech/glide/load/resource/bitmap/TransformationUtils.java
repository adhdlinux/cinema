package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.facebook.imagepipeline.common.RotationOptions;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class TransformationUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final Paint f16885a = new Paint(6);

    /* renamed from: b  reason: collision with root package name */
    private static final Paint f16886b = new Paint(7);

    /* renamed from: c  reason: collision with root package name */
    private static final Paint f16887c;

    /* renamed from: d  reason: collision with root package name */
    private static final Set<String> f16888d;

    /* renamed from: e  reason: collision with root package name */
    private static final Lock f16889e;

    private static final class NoLock implements Lock {
        NoLock() {
        }

        public void lock() {
        }

        public void lockInterruptibly() throws InterruptedException {
        }

        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }

        public boolean tryLock() {
            return true;
        }

        public boolean tryLock(long j2, TimeUnit timeUnit) throws InterruptedException {
            return true;
        }

        public void unlock() {
        }
    }

    static {
        Lock lock;
        HashSet hashSet = new HashSet(Arrays.asList(new String[]{"XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"}));
        f16888d = hashSet;
        if (hashSet.contains(Build.MODEL)) {
            lock = new ReentrantLock();
        } else {
            lock = new NoLock();
        }
        f16889e = lock;
        Paint paint = new Paint(7);
        f16887c = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private TransformationUtils() {
    }

    private static void a(Bitmap bitmap, Bitmap bitmap2, Matrix matrix) {
        Lock lock = f16889e;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, f16885a);
            d(canvas);
            lock.unlock();
        } catch (Throwable th) {
            f16889e.unlock();
            throw th;
        }
    }

    public static Bitmap b(BitmapPool bitmapPool, Bitmap bitmap, int i2, int i3) {
        float f2;
        float f3;
        if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float f4 = 0.0f;
        if (bitmap.getWidth() * i3 > bitmap.getHeight() * i2) {
            f3 = ((float) i3) / ((float) bitmap.getHeight());
            f4 = (((float) i2) - (((float) bitmap.getWidth()) * f3)) * 0.5f;
            f2 = 0.0f;
        } else {
            f3 = ((float) i2) / ((float) bitmap.getWidth());
            f2 = (((float) i3) - (((float) bitmap.getHeight()) * f3)) * 0.5f;
        }
        matrix.setScale(f3, f3);
        matrix.postTranslate((float) ((int) (f4 + 0.5f)), (float) ((int) (f2 + 0.5f)));
        Bitmap d2 = bitmapPool.d(i2, i3, h(bitmap));
        l(bitmap, d2);
        a(bitmap, d2, matrix);
        return d2;
    }

    public static Bitmap c(BitmapPool bitmapPool, Bitmap bitmap, int i2, int i3) {
        if (bitmap.getWidth() > i2 || bitmap.getHeight() > i3) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size too big for input, fit centering instead");
            }
            return e(bitmapPool, bitmap, i2, i3);
        }
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "requested target size larger or equal to input, returning input");
        }
        return bitmap;
    }

    private static void d(Canvas canvas) {
        canvas.setBitmap((Bitmap) null);
    }

    public static Bitmap e(BitmapPool bitmapPool, Bitmap bitmap, int i2, int i3) {
        if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size matches input, returning input");
            }
            return bitmap;
        }
        float min = Math.min(((float) i2) / ((float) bitmap.getWidth()), ((float) i3) / ((float) bitmap.getHeight()));
        int round = Math.round(((float) bitmap.getWidth()) * min);
        int round2 = Math.round(((float) bitmap.getHeight()) * min);
        if (bitmap.getWidth() == round && bitmap.getHeight() == round2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "adjusted target size matches input, returning input");
            }
            return bitmap;
        }
        Bitmap d2 = bitmapPool.d((int) (((float) bitmap.getWidth()) * min), (int) (((float) bitmap.getHeight()) * min), h(bitmap));
        l(bitmap, d2);
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "request: " + i2 + "x" + i3);
            Log.v("TransformationUtils", "toFit:   " + bitmap.getWidth() + "x" + bitmap.getHeight());
            Log.v("TransformationUtils", "toReuse: " + d2.getWidth() + "x" + d2.getHeight());
            StringBuilder sb = new StringBuilder();
            sb.append("minPct:   ");
            sb.append(min);
            Log.v("TransformationUtils", sb.toString());
        }
        Matrix matrix = new Matrix();
        matrix.setScale(min, min);
        a(bitmap, d2, matrix);
        return d2;
    }

    public static Lock f() {
        return f16889e;
    }

    public static int g(int i2) {
        switch (i2) {
            case 3:
            case 4:
                return RotationOptions.ROTATE_180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return RotationOptions.ROTATE_270;
            default:
                return 0;
        }
    }

    private static Bitmap.Config h(Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }

    static void i(int i2, Matrix matrix) {
        switch (i2) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                return;
            case 3:
                matrix.setRotate(180.0f);
                return;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 6:
                matrix.setRotate(90.0f);
                return;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 8:
                matrix.setRotate(-90.0f);
                return;
            default:
                return;
        }
    }

    public static boolean j(int i2) {
        switch (i2) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public static Bitmap k(BitmapPool bitmapPool, Bitmap bitmap, int i2) {
        if (!j(i2)) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        i(i2, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight());
        matrix.mapRect(rectF);
        Bitmap d2 = bitmapPool.d(Math.round(rectF.width()), Math.round(rectF.height()), h(bitmap));
        matrix.postTranslate(-rectF.left, -rectF.top);
        d2.setHasAlpha(bitmap.hasAlpha());
        a(bitmap, d2, matrix);
        return d2;
    }

    public static void l(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }
}
