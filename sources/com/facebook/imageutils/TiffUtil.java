package com.facebook.imageutils;

import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.infer.annotation.Nullsafe;
import java.io.IOException;
import java.io.InputStream;

@Nullsafe(Nullsafe.Mode.STRICT)
class TiffUtil {
    private static final Class<?> TAG = TiffUtil.class;
    public static final int TIFF_BYTE_ORDER_BIG_END = 1296891946;
    public static final int TIFF_BYTE_ORDER_LITTLE_END = 1229531648;
    public static final int TIFF_TAG_ORIENTATION = 274;
    public static final int TIFF_TYPE_SHORT = 3;

    private static class TiffHeader {
        int byteOrder;
        int firstIfdOffset;
        boolean isLittleEndian;

        private TiffHeader() {
        }
    }

    TiffUtil() {
    }

    public static int getAutoRotateAngleFromOrientation(int i2) {
        if (i2 == 3) {
            return RotationOptions.ROTATE_180;
        }
        if (i2 == 6) {
            return 90;
        }
        if (i2 != 8) {
            return 0;
        }
        return RotationOptions.ROTATE_270;
    }

    private static int getOrientationFromTiffEntry(InputStream inputStream, int i2, boolean z2) throws IOException {
        if (i2 >= 10 && StreamProcessor.readPackedInt(inputStream, 2, z2) == 3 && StreamProcessor.readPackedInt(inputStream, 4, z2) == 1) {
            return StreamProcessor.readPackedInt(inputStream, 2, z2);
        }
        return 0;
    }

    private static int moveToTiffEntryWithTag(InputStream inputStream, int i2, boolean z2, int i3) throws IOException {
        if (i2 < 14) {
            return 0;
        }
        int readPackedInt = StreamProcessor.readPackedInt(inputStream, 2, z2);
        int i4 = i2 - 2;
        while (true) {
            int i5 = readPackedInt - 1;
            if (readPackedInt <= 0 || i4 < 12) {
                return 0;
            }
            int i6 = i4 - 2;
            if (StreamProcessor.readPackedInt(inputStream, 2, z2) == i3) {
                return i6;
            }
            inputStream.skip(10);
            i4 = i6 - 10;
            readPackedInt = i5;
        }
        return 0;
    }

    public static int readOrientationFromTIFF(InputStream inputStream, int i2) throws IOException {
        TiffHeader tiffHeader = new TiffHeader();
        int readTiffHeader = readTiffHeader(inputStream, i2, tiffHeader);
        int i3 = tiffHeader.firstIfdOffset - 8;
        if (readTiffHeader == 0 || i3 > readTiffHeader) {
            return 0;
        }
        inputStream.skip((long) i3);
        return getOrientationFromTiffEntry(inputStream, moveToTiffEntryWithTag(inputStream, readTiffHeader - i3, tiffHeader.isLittleEndian, TIFF_TAG_ORIENTATION), tiffHeader.isLittleEndian);
    }

    private static int readTiffHeader(InputStream inputStream, int i2, TiffHeader tiffHeader) throws IOException {
        boolean z2;
        if (i2 <= 8) {
            return 0;
        }
        int readPackedInt = StreamProcessor.readPackedInt(inputStream, 4, false);
        tiffHeader.byteOrder = readPackedInt;
        int i3 = i2 - 4;
        if (readPackedInt == 1229531648 || readPackedInt == 1296891946) {
            if (readPackedInt == 1229531648) {
                z2 = true;
            } else {
                z2 = false;
            }
            tiffHeader.isLittleEndian = z2;
            int readPackedInt2 = StreamProcessor.readPackedInt(inputStream, 4, z2);
            tiffHeader.firstIfdOffset = readPackedInt2;
            int i4 = i3 - 4;
            if (readPackedInt2 >= 8 && readPackedInt2 - 8 <= i4) {
                return i4;
            }
            FLog.e(TAG, "Invalid offset");
            return 0;
        }
        FLog.e(TAG, "Invalid TIFF header");
        return 0;
    }
}
