package androidx.media3.datasource;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.ParserException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class BitmapUtil {
    private BitmapUtil() {
    }

    public static Bitmap a(byte[] bArr, int i2, BitmapFactory.Options options) throws IOException {
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, i2, options);
        if (decodeByteArray != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                ExifInterface exifInterface = new ExifInterface((InputStream) byteArrayInputStream);
                byteArrayInputStream.close();
                int l2 = exifInterface.l();
                if (l2 == 0) {
                    return decodeByteArray;
                }
                Matrix matrix = new Matrix();
                matrix.postRotate((float) l2);
                return Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, false);
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            throw ParserException.a("Could not decode image data", new IllegalStateException());
        }
        throw th;
    }
}
