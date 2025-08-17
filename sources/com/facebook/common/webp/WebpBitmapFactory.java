package com.facebook.common.webp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.facebook.infer.annotation.Nullsafe;
import java.io.FileDescriptor;
import java.io.InputStream;

@Nullsafe(Nullsafe.Mode.STRICT)
public interface WebpBitmapFactory {

    public interface WebpErrorLogger {
        void onWebpErrorLog(String str, String str2);
    }

    Bitmap decodeByteArray(byte[] bArr, int i2, int i3, BitmapFactory.Options options);

    Bitmap decodeFile(String str, BitmapFactory.Options options);

    Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor, Rect rect, BitmapFactory.Options options);

    Bitmap decodeStream(InputStream inputStream, Rect rect, BitmapFactory.Options options);

    void setBitmapCreator(BitmapCreator bitmapCreator);

    void setWebpErrorLogger(WebpErrorLogger webpErrorLogger);
}
