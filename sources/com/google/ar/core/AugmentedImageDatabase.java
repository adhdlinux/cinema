package com.google.ar.core;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;

public class AugmentedImageDatabase {
    long nativeHandle;
    private final long nativeSymbolTableHandle;
    private final Session session;

    public AugmentedImageDatabase(Session session2) {
        this(session2, nativeCreate(session2.nativeWrapperHandle));
    }

    static ByteBuffer convertBitmapToGrayscaleDirectBuffer(Bitmap bitmap) {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
        Paint paint = new Paint();
        paint.setColorFilter(colorMatrixColorFilter);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawBitmap(bitmap, 0.0f, 0.0f, paint);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bitmap.getWidth() * bitmap.getHeight());
        for (int i2 = 0; i2 < bitmap.getHeight(); i2++) {
            for (int i3 = 0; i3 < bitmap.getWidth(); i3++) {
                allocateDirect.put((bitmap.getWidth() * i2) + i3, (byte) Color.red(createBitmap.getPixel(i3, i2)));
            }
        }
        return allocateDirect;
    }

    public static AugmentedImageDatabase deserialize(Session session2, InputStream inputStream) throws IOException {
        return new AugmentedImageDatabase(session2, nativeDeserialize(session2.nativeWrapperHandle, loadDirectByteBuffer(inputStream)));
    }

    private static ByteBuffer loadDirectByteBuffer(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(32, inputStream.available()));
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(byteArray.length);
                allocateDirect.put(byteArray);
                return allocateDirect;
            }
        }
    }

    private native int nativeAddImage(long j2, long j3, String str, ByteBuffer byteBuffer, int i2, int i3, int i4);

    private native int nativeAddImageWithPhysicalSize(long j2, long j3, String str, ByteBuffer byteBuffer, int i2, int i3, int i4, float f2);

    private static native long nativeCreate(long j2);

    private static native long nativeDeserialize(long j2, ByteBuffer byteBuffer);

    private native int nativeGetNumImages(long j2, long j3);

    private native void nativeReleaseDatabase(long j2, long j3);

    private native ByteBuffer nativeSerialize(long j2, long j3);

    public int addImage(String str, Bitmap bitmap) {
        return nativeAddImage(this.session.nativeWrapperHandle, this.nativeHandle, str, convertBitmapToGrayscaleDirectBuffer(bitmap), bitmap.getWidth(), bitmap.getHeight(), bitmap.getWidth());
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        long j2 = this.nativeHandle;
        if (j2 != 0) {
            nativeReleaseDatabase(this.nativeSymbolTableHandle, j2);
        }
        super.finalize();
    }

    public int getNumImages() {
        return nativeGetNumImages(this.session.nativeWrapperHandle, this.nativeHandle);
    }

    public void serialize(OutputStream outputStream) throws IOException {
        Channels.newChannel(outputStream).write(nativeSerialize(this.session.nativeWrapperHandle, this.nativeHandle));
    }

    AugmentedImageDatabase(Session session2, long j2) {
        this.session = session2;
        this.nativeHandle = j2;
        this.nativeSymbolTableHandle = session2.nativeSymbolTableHandle;
    }

    public int addImage(String str, Bitmap bitmap, float f2) {
        return nativeAddImageWithPhysicalSize(this.session.nativeWrapperHandle, this.nativeHandle, str, convertBitmapToGrayscaleDirectBuffer(bitmap), bitmap.getWidth(), bitmap.getHeight(), bitmap.getWidth(), f2);
    }
}
