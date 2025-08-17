package com.google.zxing.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.encoder.Encoder;
import com.google.zxing.qrcode.encoder.QRCode;
import java.util.Map;

public final class QRCodeWriter {
    private static BitMatrix c(QRCode qRCode, int i2, int i3, int i4) {
        ByteMatrix a2 = qRCode.a();
        if (a2 != null) {
            int e2 = a2.e();
            int d2 = a2.d();
            int i5 = i4 * 2;
            int i6 = e2 + i5;
            int i7 = i5 + d2;
            int max = Math.max(i2, i6);
            int max2 = Math.max(i3, i7);
            int min = Math.min(max / i6, max2 / i7);
            int i8 = (max - (e2 * min)) / 2;
            int i9 = (max2 - (d2 * min)) / 2;
            BitMatrix bitMatrix = new BitMatrix(max, max2);
            int i10 = 0;
            while (i10 < d2) {
                int i11 = i8;
                int i12 = 0;
                while (i12 < e2) {
                    if (a2.b(i12, i10) == 1) {
                        bitMatrix.e(i11, i9, min, min);
                    }
                    i12++;
                    i11 += min;
                }
                i10++;
                i9 += min;
            }
            return bitMatrix;
        }
        throw new IllegalStateException();
    }

    public BitMatrix a(String str, BarcodeFormat barcodeFormat, int i2, int i3) throws WriterException {
        return b(str, barcodeFormat, i2, i3, (Map<EncodeHintType, ?>) null);
    }

    public BitMatrix b(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (barcodeFormat != BarcodeFormat.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got " + barcodeFormat);
        } else if (i2 < 0 || i3 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i2 + 'x' + i3);
        } else {
            ErrorCorrectionLevel errorCorrectionLevel = ErrorCorrectionLevel.L;
            int i4 = 4;
            if (map != null) {
                ErrorCorrectionLevel errorCorrectionLevel2 = (ErrorCorrectionLevel) map.get(EncodeHintType.ERROR_CORRECTION);
                if (errorCorrectionLevel2 != null) {
                    errorCorrectionLevel = errorCorrectionLevel2;
                }
                Integer num = (Integer) map.get(EncodeHintType.MARGIN);
                if (num != null) {
                    i4 = num.intValue();
                }
            }
            return c(Encoder.m(str, errorCorrectionLevel, map), i2, i3, i4);
        }
    }
}
