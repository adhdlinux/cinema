package com.facebook.react.views.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.react.bridge.ReadableArray;
import java.util.ArrayList;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class ReactTypefaceUtils {
    public static Typeface applyStyles(Typeface typeface, int i2, int i3, String str, AssetManager assetManager) {
        TypefaceStyle typefaceStyle = new TypefaceStyle(i2, i3);
        if (str != null) {
            return ReactFontManager.getInstance().getTypeface(str, typefaceStyle, assetManager);
        }
        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }
        return typefaceStyle.apply(typeface);
    }

    public static int parseFontStyle(String str) {
        if (str == null) {
            return -1;
        }
        if ("italic".equals(str)) {
            return 2;
        }
        if ("normal".equals(str)) {
            return 0;
        }
        return -1;
    }

    public static String parseFontVariant(ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            String string = readableArray.getString(i2);
            if (string != null) {
                char c2 = 65535;
                switch (string.hashCode()) {
                    case -1195362251:
                        if (string.equals("proportional-nums")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -1061392823:
                        if (string.equals("lining-nums")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -771984547:
                        if (string.equals("tabular-nums")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -659678800:
                        if (string.equals("oldstyle-nums")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 1183323111:
                        if (string.equals("small-caps")) {
                            c2 = 4;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        arrayList.add("'pnum'");
                        break;
                    case 1:
                        arrayList.add("'lnum'");
                        break;
                    case 2:
                        arrayList.add("'tnum'");
                        break;
                    case 3:
                        arrayList.add("'onum'");
                        break;
                    case 4:
                        arrayList.add("'smcp'");
                        break;
                }
            }
        }
        return TextUtils.join(", ", arrayList);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int parseFontWeight(java.lang.String r2) {
        /*
            r0 = -1
            if (r2 == 0) goto L_0x00aa
            int r1 = r2.hashCode()
            switch(r1) {
                case -1039745817: goto L_0x0081;
                case 48625: goto L_0x0076;
                case 49586: goto L_0x006b;
                case 50547: goto L_0x0060;
                case 51508: goto L_0x0055;
                case 52469: goto L_0x004a;
                case 53430: goto L_0x003f;
                case 54391: goto L_0x0034;
                case 55352: goto L_0x0027;
                case 56313: goto L_0x001a;
                case 3029637: goto L_0x000d;
                default: goto L_0x000a;
            }
        L_0x000a:
            r2 = -1
            goto L_0x008b
        L_0x000d:
            java.lang.String r1 = "bold"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0016
            goto L_0x000a
        L_0x0016:
            r2 = 10
            goto L_0x008b
        L_0x001a:
            java.lang.String r1 = "900"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0023
            goto L_0x000a
        L_0x0023:
            r2 = 9
            goto L_0x008b
        L_0x0027:
            java.lang.String r1 = "800"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0030
            goto L_0x000a
        L_0x0030:
            r2 = 8
            goto L_0x008b
        L_0x0034:
            java.lang.String r1 = "700"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x003d
            goto L_0x000a
        L_0x003d:
            r2 = 7
            goto L_0x008b
        L_0x003f:
            java.lang.String r1 = "600"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0048
            goto L_0x000a
        L_0x0048:
            r2 = 6
            goto L_0x008b
        L_0x004a:
            java.lang.String r1 = "500"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0053
            goto L_0x000a
        L_0x0053:
            r2 = 5
            goto L_0x008b
        L_0x0055:
            java.lang.String r1 = "400"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x005e
            goto L_0x000a
        L_0x005e:
            r2 = 4
            goto L_0x008b
        L_0x0060:
            java.lang.String r1 = "300"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0069
            goto L_0x000a
        L_0x0069:
            r2 = 3
            goto L_0x008b
        L_0x006b:
            java.lang.String r1 = "200"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0074
            goto L_0x000a
        L_0x0074:
            r2 = 2
            goto L_0x008b
        L_0x0076:
            java.lang.String r1 = "100"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x007f
            goto L_0x000a
        L_0x007f:
            r2 = 1
            goto L_0x008b
        L_0x0081:
            java.lang.String r1 = "normal"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x008a
            goto L_0x000a
        L_0x008a:
            r2 = 0
        L_0x008b:
            switch(r2) {
                case 0: goto L_0x00a7;
                case 1: goto L_0x00a4;
                case 2: goto L_0x00a1;
                case 3: goto L_0x009e;
                case 4: goto L_0x00a7;
                case 5: goto L_0x009b;
                case 6: goto L_0x0098;
                case 7: goto L_0x0095;
                case 8: goto L_0x0092;
                case 9: goto L_0x008f;
                case 10: goto L_0x0095;
                default: goto L_0x008e;
            }
        L_0x008e:
            goto L_0x00aa
        L_0x008f:
            r2 = 900(0x384, float:1.261E-42)
            return r2
        L_0x0092:
            r2 = 800(0x320, float:1.121E-42)
            return r2
        L_0x0095:
            r2 = 700(0x2bc, float:9.81E-43)
            return r2
        L_0x0098:
            r2 = 600(0x258, float:8.41E-43)
            return r2
        L_0x009b:
            r2 = 500(0x1f4, float:7.0E-43)
            return r2
        L_0x009e:
            r2 = 300(0x12c, float:4.2E-43)
            return r2
        L_0x00a1:
            r2 = 200(0xc8, float:2.8E-43)
            return r2
        L_0x00a4:
            r2 = 100
            return r2
        L_0x00a7:
            r2 = 400(0x190, float:5.6E-43)
            return r2
        L_0x00aa:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.ReactTypefaceUtils.parseFontWeight(java.lang.String):int");
    }
}
