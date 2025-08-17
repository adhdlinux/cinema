package com.facebook.ads.internal.q.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import com.facebook.ads.internal.q.a.x;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class c {
    private static int a(BitmapFactory.Options options, int i2, int i3) {
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        int i6 = 1;
        if (i4 > i3 || i5 > i2) {
            int i7 = i4 / 2;
            int i8 = i5 / 2;
            while (i7 / i6 >= i3 && i8 / i6 >= i2) {
                i6 *= 2;
            }
        }
        return i6;
    }

    public static Bitmap a(b bVar) {
        byte[] decode = Base64.decode(bVar.a(x.f20694b), 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    public static Bitmap a(InputStream inputStream, int i2, int i3) {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        bufferedInputStream.mark(8192);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(bufferedInputStream, (Rect) null, options);
        try {
            bufferedInputStream.reset();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        options.inSampleSize = a(options, i3, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeStream(bufferedInputStream, (Rect) null, options);
    }

    public static Bitmap a(String str, int i2, int i3) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = a(options, i3, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static Drawable a(Context context, b bVar) {
        return new BitmapDrawable(context.getResources(), a(bVar));
    }
}
