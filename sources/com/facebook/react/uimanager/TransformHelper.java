package com.facebook.react.uimanager;

import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;

public class TransformHelper {
    private static ThreadLocal<double[]> sHelperMatrix = new ThreadLocal<double[]>() {
        /* access modifiers changed from: protected */
        public double[] initialValue() {
            return new double[16];
        }
    };

    private static double convertToRadians(ReadableMap readableMap, String str) {
        double d2;
        boolean z2 = true;
        if (readableMap.getType(str) == ReadableType.String) {
            String string = readableMap.getString(str);
            if (string.endsWith("rad")) {
                string = string.substring(0, string.length() - 3);
            } else if (string.endsWith("deg")) {
                string = string.substring(0, string.length() - 3);
                z2 = false;
            }
            d2 = (double) Float.parseFloat(string);
        } else {
            d2 = readableMap.getDouble(str);
        }
        if (z2) {
            return d2;
        }
        return MatrixMathHelper.degreesToRadians(d2);
    }

    public static void processTransform(ReadableArray readableArray, double[] dArr) {
        double[] dArr2 = sHelperMatrix.get();
        MatrixMathHelper.resetIdentityMatrix(dArr);
        if (readableArray.size() == 16 && readableArray.getType(0) == ReadableType.Number) {
            for (int i2 = 0; i2 < readableArray.size(); i2++) {
                dArr[i2] = readableArray.getDouble(i2);
            }
            return;
        }
        int size = readableArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            ReadableMap map = readableArray.getMap(i3);
            String nextKey = map.keySetIterator().nextKey();
            MatrixMathHelper.resetIdentityMatrix(dArr2);
            if ("matrix".equals(nextKey)) {
                ReadableArray array = map.getArray(nextKey);
                for (int i4 = 0; i4 < 16; i4++) {
                    dArr2[i4] = array.getDouble(i4);
                }
            } else if ("perspective".equals(nextKey)) {
                MatrixMathHelper.applyPerspective(dArr2, map.getDouble(nextKey));
            } else if ("rotateX".equals(nextKey)) {
                MatrixMathHelper.applyRotateX(dArr2, convertToRadians(map, nextKey));
            } else if ("rotateY".equals(nextKey)) {
                MatrixMathHelper.applyRotateY(dArr2, convertToRadians(map, nextKey));
            } else if ("rotate".equals(nextKey) || "rotateZ".equals(nextKey)) {
                MatrixMathHelper.applyRotateZ(dArr2, convertToRadians(map, nextKey));
            } else if ("scale".equals(nextKey)) {
                double d2 = map.getDouble(nextKey);
                MatrixMathHelper.applyScaleX(dArr2, d2);
                MatrixMathHelper.applyScaleY(dArr2, d2);
            } else if (ViewProps.SCALE_X.equals(nextKey)) {
                MatrixMathHelper.applyScaleX(dArr2, map.getDouble(nextKey));
            } else if (ViewProps.SCALE_Y.equals(nextKey)) {
                MatrixMathHelper.applyScaleY(dArr2, map.getDouble(nextKey));
            } else {
                double d3 = 0.0d;
                if ("translate".equals(nextKey)) {
                    ReadableArray array2 = map.getArray(nextKey);
                    double d4 = array2.getDouble(0);
                    double d5 = array2.getDouble(1);
                    if (array2.size() > 2) {
                        d3 = array2.getDouble(2);
                    }
                    MatrixMathHelper.applyTranslate3D(dArr2, d4, d5, d3);
                } else if (ViewProps.TRANSLATE_X.equals(nextKey)) {
                    MatrixMathHelper.applyTranslate2D(dArr2, map.getDouble(nextKey), 0.0d);
                } else if (ViewProps.TRANSLATE_Y.equals(nextKey)) {
                    MatrixMathHelper.applyTranslate2D(dArr2, 0.0d, map.getDouble(nextKey));
                } else if ("skewX".equals(nextKey)) {
                    MatrixMathHelper.applySkewX(dArr2, convertToRadians(map, nextKey));
                } else if ("skewY".equals(nextKey)) {
                    MatrixMathHelper.applySkewY(dArr2, convertToRadians(map, nextKey));
                } else {
                    throw new JSApplicationIllegalArgumentException("Unsupported transform type: " + nextKey);
                }
            }
            MatrixMathHelper.multiplyInto(dArr, dArr, dArr2);
        }
    }
}
