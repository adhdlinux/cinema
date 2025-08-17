package com.utils.subtitle.converter;

import java.util.ArrayList;

public class FormatASS implements TimedTextFileFormat {
    private int c(boolean z2, String str) {
        String str2 = str;
        if (z2) {
            if ("bottom-left".equals(str2)) {
                return 1;
            }
            if (!"bottom-center".equals(str2)) {
                if ("bottom-right".equals(str2)) {
                    return 3;
                }
                if ("mid-left".equals(str2)) {
                    return 4;
                }
                if ("mid-center".equals(str2)) {
                    return 5;
                }
                if ("mid-right".equals(str2)) {
                    return 6;
                }
                if ("top-left".equals(str2)) {
                    return 7;
                }
                if ("top-center".equals(str2)) {
                    return 8;
                }
                if ("top-right".equals(str2)) {
                    return 9;
                }
            }
            return 2;
        } else if ("bottom-left".equals(str2)) {
            return 9;
        } else {
            if (!"bottom-center".equals(str2)) {
                if ("bottom-right".equals(str2)) {
                    return 11;
                }
                if ("mid-left".equals(str2)) {
                    return 1;
                }
                if ("mid-center".equals(str2)) {
                    return 2;
                }
                if ("mid-right".equals(str2)) {
                    return 3;
                }
                if ("top-left".equals(str2)) {
                    return 5;
                }
                if ("top-center".equals(str2)) {
                    return 6;
                }
                if ("top-right".equals(str2)) {
                    return 7;
                }
            }
            return 10;
        }
    }

    private String d(boolean z2, Style style) {
        if (z2) {
            return Integer.parseInt("00" + style.f37726d.substring(4, 6) + style.f37726d.substring(2, 4) + style.f37726d.substring(0, 2), 16) + ",16777215,0," + Long.parseLong("80" + style.f37727e.substring(4, 6) + style.f37727e.substring(2, 4) + style.f37727e.substring(0, 2), 16) + ",";
        }
        String str = style.f37726d.substring(4, 6) + style.f37726d.substring(2, 4) + style.f37726d.substring(0, 2);
        String str2 = style.f37727e.substring(4, 6) + style.f37727e.substring(2, 4) + style.f37727e.substring(0, 2);
        return Long.parseLong(str, 16) + ",16777215,0," + Long.parseLong(str2, 16) + ",";
    }

    private String e(boolean z2, Style style) {
        String str;
        String str2;
        String str3;
        if (style.f37730h) {
            str = "-1,";
        } else {
            str = "0,";
        }
        if (style.f37729g) {
            str2 = str + "-1,";
        } else {
            str2 = str + "0,";
        }
        if (!z2) {
            return str2;
        }
        if (style.f37731i) {
            str3 = str2 + "-1,";
        } else {
            str3 = str2 + "0,";
        }
        return str3 + "0,100,100,0,0,";
    }

    private Caption f(String[] strArr, String[] strArr2, float f2, TimedTextObject timedTextObject) {
        Caption caption = new Caption();
        caption.f37720d = strArr[9].replaceAll("\\{.*?\\}", "").replace(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE, "<br />").replace("\\N", "<br />");
        for (int i2 = 0; i2 < strArr2.length; i2++) {
            if (strArr2[i2].trim().equalsIgnoreCase("Style")) {
                Style style = timedTextObject.f37739g.get(strArr[i2].trim());
                if (style != null) {
                    caption.f37717a = style;
                } else {
                    timedTextObject.f37742j += "undefined style: " + strArr[i2].trim() + "\n\n";
                }
            } else if (strArr2[i2].trim().equalsIgnoreCase("Start")) {
                caption.f37718b = new Time("h:mm:ss.cs", strArr[i2].trim());
            } else if (strArr2[i2].trim().equalsIgnoreCase("End")) {
                caption.f37719c = new Time("h:mm:ss.cs", strArr[i2].trim());
            }
        }
        if (f2 != 100.0f) {
            Time time = caption.f37718b;
            float f3 = f2 / 100.0f;
            time.f37732a = (int) (((float) time.f37732a) / f3);
            Time time2 = caption.f37719c;
            time2.f37732a = (int) (((float) time2.f37732a) / f3);
        }
        return caption;
    }

    private Style g(String[] strArr, String[] strArr2, int i2, boolean z2, String str) {
        String str2;
        String[] strArr3 = strArr;
        String[] strArr4 = strArr2;
        int i3 = i2;
        Style style = new Style(Style.a());
        if (strArr3.length == strArr4.length) {
            String str3 = str;
            int i4 = 0;
            while (i4 < strArr4.length) {
                if (strArr4[i4].trim().equalsIgnoreCase("Name")) {
                    style.f37723a = strArr3[i4].trim();
                } else if (strArr4[i4].trim().equalsIgnoreCase("Fontname")) {
                    style.f37724b = strArr3[i4].trim();
                } else if (strArr4[i4].trim().equalsIgnoreCase("Fontsize")) {
                    style.f37725c = strArr3[i4].trim();
                } else if (strArr4[i4].trim().equalsIgnoreCase("PrimaryColour")) {
                    String trim = strArr3[i4].trim();
                    if (z2) {
                        if (trim.startsWith("&H")) {
                            style.f37726d = Style.b("&HAABBGGRR", trim);
                        } else {
                            style.f37726d = Style.b("decimalCodedAABBGGRR", trim);
                        }
                    } else if (trim.startsWith("&H")) {
                        style.f37726d = Style.b("&HBBGGRR", trim);
                    } else {
                        style.f37726d = Style.b("decimalCodedBBGGRR", trim);
                    }
                } else if (strArr4[i4].trim().equalsIgnoreCase("BackColour")) {
                    String trim2 = strArr3[i4].trim();
                    if (z2) {
                        if (trim2.startsWith("&H")) {
                            style.f37727e = Style.b("&HAABBGGRR", trim2);
                        } else {
                            style.f37727e = Style.b("decimalCodedAABBGGRR", trim2);
                        }
                    } else if (trim2.startsWith("&H")) {
                        style.f37727e = Style.b("&HBBGGRR", trim2);
                    } else {
                        style.f37727e = Style.b("decimalCodedBBGGRR", trim2);
                    }
                } else if (strArr4[i4].trim().equalsIgnoreCase("Bold")) {
                    style.f37730h = Boolean.parseBoolean(strArr3[i4].trim());
                } else if (strArr4[i4].trim().equalsIgnoreCase("Italic")) {
                    style.f37729g = Boolean.parseBoolean(strArr3[i4].trim());
                } else if (strArr4[i4].trim().equalsIgnoreCase("Underline")) {
                    style.f37731i = Boolean.parseBoolean(strArr3[i4].trim());
                } else if (strArr4[i4].trim().equalsIgnoreCase("Alignment")) {
                    int parseInt = Integer.parseInt(strArr3[i4].trim());
                    if (!z2) {
                        switch (parseInt) {
                            case 1:
                                style.f37728f = "mid-left";
                                continue;
                            case 2:
                                style.f37728f = "mid-center";
                                continue;
                            case 3:
                                style.f37728f = "mid-right";
                                continue;
                            case 5:
                                style.f37728f = "top-left";
                                continue;
                            case 6:
                                style.f37728f = "top-center";
                                continue;
                            case 7:
                                style.f37728f = "top-right";
                                continue;
                            case 9:
                                style.f37728f = "bottom-left";
                                continue;
                            case 10:
                                style.f37728f = "bottom-center";
                                continue;
                            case 11:
                                style.f37728f = "bottom-right";
                                continue;
                            default:
                                str2 = str3 + "undefined alignment for style at line " + i3 + "\n\n";
                                break;
                        }
                    } else {
                        switch (parseInt) {
                            case 1:
                                style.f37728f = "bottom-left";
                                continue;
                            case 2:
                                style.f37728f = "bottom-center";
                                continue;
                            case 3:
                                style.f37728f = "bottom-right";
                                continue;
                            case 4:
                                style.f37728f = "mid-left";
                                continue;
                            case 5:
                                style.f37728f = "mid-center";
                                continue;
                            case 6:
                                style.f37728f = "mid-right";
                                continue;
                            case 7:
                                style.f37728f = "top-left";
                                continue;
                            case 8:
                                style.f37728f = "top-center";
                                continue;
                            case 9:
                                style.f37728f = "top-right";
                                continue;
                            default:
                                str2 = str3 + "undefined alignment for style at line " + i3 + "\n\n";
                                break;
                        }
                    }
                    str3 = str2;
                }
                i4++;
                strArr3 = strArr;
                strArr4 = strArr2;
            }
        }
        return style;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x030d, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:?, code lost:
        r1.f37742j += "unexpected end of file, maybe last caption is not complete.\n\n";
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:101:0x030f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.utils.subtitle.converter.TimedTextObject a(java.lang.String r20, java.io.InputStream r21, java.lang.String r22) throws java.io.IOException {
        /*
            r19 = this;
            java.lang.String r0 = "["
            com.utils.subtitle.converter.TimedTextObject r1 = new com.utils.subtitle.converter.TimedTextObject
            r1.<init>()
            r2 = r20
            r1.f37737e = r2
            com.utils.subtitle.converter.Caption r2 = new com.utils.subtitle.converter.Caption
            r2.<init>()
            java.io.InputStreamReader r2 = new java.io.InputStreamReader
            r3 = r21
            r4 = r22
            r2.<init>(r3, r4)
            java.io.BufferedReader r4 = new java.io.BufferedReader
            r4.<init>(r2)
            r2 = 1
            java.lang.String r5 = r4.readLine()     // Catch:{ NullPointerException -> 0x030f }
            r6 = 1120403456(0x42c80000, float:100.0)
            r7 = 0
            r8 = 1
        L_0x0027:
            if (r5 == 0) goto L_0x0306
            java.lang.String r5 = r5.trim()     // Catch:{ NullPointerException -> 0x030f }
            boolean r9 = r5.startsWith(r0)     // Catch:{ NullPointerException -> 0x030f }
            if (r9 == 0) goto L_0x02fe
            java.lang.String r9 = "[Script info]"
            boolean r9 = r5.equalsIgnoreCase(r9)     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r10 = ":"
            if (r9 == 0) goto L_0x00e6
            int r8 = r8 + 1
            java.lang.String r5 = r4.readLine()     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r5 = r5.trim()     // Catch:{ NullPointerException -> 0x030f }
        L_0x0047:
            boolean r9 = r5.startsWith(r0)     // Catch:{ NullPointerException -> 0x030f }
            if (r9 != 0) goto L_0x0027
            java.lang.String r9 = "Title:"
            boolean r9 = r5.startsWith(r9)     // Catch:{ NullPointerException -> 0x030f }
            if (r9 == 0) goto L_0x0063
            java.lang.String[] r5 = r5.split(r10)     // Catch:{ NullPointerException -> 0x030f }
            r5 = r5[r2]     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r5 = r5.trim()     // Catch:{ NullPointerException -> 0x030f }
            r1.f37733a = r5     // Catch:{ NullPointerException -> 0x030f }
            goto L_0x00da
        L_0x0063:
            java.lang.String r9 = "Original Script:"
            boolean r9 = r5.startsWith(r9)     // Catch:{ NullPointerException -> 0x030f }
            if (r9 == 0) goto L_0x0078
            java.lang.String[] r5 = r5.split(r10)     // Catch:{ NullPointerException -> 0x030f }
            r5 = r5[r2]     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r5 = r5.trim()     // Catch:{ NullPointerException -> 0x030f }
            r1.f37736d = r5     // Catch:{ NullPointerException -> 0x030f }
            goto L_0x00da
        L_0x0078:
            java.lang.String r9 = "Script Type:"
            boolean r9 = r5.startsWith(r9)     // Catch:{ NullPointerException -> 0x030f }
            if (r9 == 0) goto L_0x00bc
            java.lang.String[] r9 = r5.split(r10)     // Catch:{ NullPointerException -> 0x030f }
            r9 = r9[r2]     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r9 = r9.trim()     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r11 = "v4.00+"
            boolean r9 = r9.equalsIgnoreCase(r11)     // Catch:{ NullPointerException -> 0x030f }
            if (r9 == 0) goto L_0x0094
            r7 = 1
            goto L_0x00da
        L_0x0094:
            java.lang.String[] r5 = r5.split(r10)     // Catch:{ NullPointerException -> 0x030f }
            r5 = r5[r2]     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r5 = r5.trim()     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r9 = "v4.00"
            boolean r5 = r5.equalsIgnoreCase(r9)     // Catch:{ NullPointerException -> 0x030f }
            if (r5 != 0) goto L_0x00da
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x030f }
            r5.<init>()     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r9 = r1.f37742j     // Catch:{ NullPointerException -> 0x030f }
            r5.append(r9)     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r9 = "Script version is older than 4.00, it may produce parsing errors."
            r5.append(r9)     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r5 = r5.toString()     // Catch:{ NullPointerException -> 0x030f }
            r1.f37742j = r5     // Catch:{ NullPointerException -> 0x030f }
            goto L_0x00da
        L_0x00bc:
            java.lang.String r9 = "Timer:"
            boolean r9 = r5.startsWith(r9)     // Catch:{ NullPointerException -> 0x030f }
            if (r9 == 0) goto L_0x00da
            java.lang.String[] r5 = r5.split(r10)     // Catch:{ NullPointerException -> 0x030f }
            r5 = r5[r2]     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r5 = r5.trim()     // Catch:{ NullPointerException -> 0x030f }
            r6 = 44
            r9 = 46
            java.lang.String r5 = r5.replace(r6, r9)     // Catch:{ NullPointerException -> 0x030f }
            float r6 = java.lang.Float.parseFloat(r5)     // Catch:{ NullPointerException -> 0x030f }
        L_0x00da:
            int r8 = r8 + 1
            java.lang.String r5 = r4.readLine()     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r5 = r5.trim()     // Catch:{ NullPointerException -> 0x030f }
            goto L_0x0047
        L_0x00e6:
            java.lang.String r9 = "[v4 Styles]"
            boolean r9 = r5.equalsIgnoreCase(r9)     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r11 = "Format: (format definition) expected at line "
            java.lang.String r12 = ","
            java.lang.String r13 = "Format:"
            if (r9 != 0) goto L_0x0247
            java.lang.String r9 = "[v4 Styles+]"
            boolean r9 = r5.equalsIgnoreCase(r9)     // Catch:{ NullPointerException -> 0x0243, all -> 0x023e }
            if (r9 != 0) goto L_0x0247
            java.lang.String r9 = "[v4+ Styles]"
            boolean r9 = r5.equalsIgnoreCase(r9)     // Catch:{ NullPointerException -> 0x0243, all -> 0x023e }
            if (r9 == 0) goto L_0x0106
            goto L_0x0247
        L_0x0106:
            java.lang.String r9 = r5.trim()     // Catch:{ NullPointerException -> 0x0243, all -> 0x023e }
            java.lang.String r14 = "[Events]"
            boolean r9 = r9.equalsIgnoreCase(r14)     // Catch:{ NullPointerException -> 0x0243, all -> 0x023e }
            if (r9 == 0) goto L_0x01cd
            int r8 = r8 + 1
            java.lang.String r5 = r4.readLine()     // Catch:{ NullPointerException -> 0x0243, all -> 0x023e }
            java.lang.String r5 = r5.trim()     // Catch:{ NullPointerException -> 0x0243, all -> 0x023e }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x0243, all -> 0x023e }
            r9.<init>()     // Catch:{ NullPointerException -> 0x0243, all -> 0x023e }
            java.lang.String r14 = r1.f37742j     // Catch:{ NullPointerException -> 0x0243, all -> 0x023e }
            r9.append(r14)     // Catch:{ NullPointerException -> 0x0243, all -> 0x023e }
            java.lang.String r14 = "Only dialogue events are considered, all other events are ignored.\n\n"
            r9.append(r14)     // Catch:{ NullPointerException -> 0x0243, all -> 0x023e }
            java.lang.String r9 = r9.toString()     // Catch:{ NullPointerException -> 0x0243, all -> 0x023e }
            r1.f37742j = r9     // Catch:{ NullPointerException -> 0x0243, all -> 0x023e }
            boolean r9 = r5.startsWith(r13)     // Catch:{ NullPointerException -> 0x0243, all -> 0x023e }
            if (r9 != 0) goto L_0x0163
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x030f }
            r9.<init>()     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r14 = r1.f37742j     // Catch:{ NullPointerException -> 0x030f }
            r9.append(r14)     // Catch:{ NullPointerException -> 0x030f }
            r9.append(r11)     // Catch:{ NullPointerException -> 0x030f }
            r9.append(r5)     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r11 = " for the events section\n\n"
            r9.append(r11)     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r9 = r9.toString()     // Catch:{ NullPointerException -> 0x030f }
            r1.f37742j = r9     // Catch:{ NullPointerException -> 0x030f }
        L_0x0152:
            boolean r9 = r5.startsWith(r13)     // Catch:{ NullPointerException -> 0x030f }
            if (r9 != 0) goto L_0x0163
            int r8 = r8 + 1
            java.lang.String r5 = r4.readLine()     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r5 = r5.trim()     // Catch:{ NullPointerException -> 0x030f }
            goto L_0x0152
        L_0x0163:
            java.lang.String[] r5 = r5.split(r10)     // Catch:{ NullPointerException -> 0x0243, all -> 0x023e }
            r5 = r5[r2]     // Catch:{ NullPointerException -> 0x0243, all -> 0x023e }
            java.lang.String r5 = r5.trim()     // Catch:{ NullPointerException -> 0x0243, all -> 0x023e }
            java.lang.String[] r5 = r5.split(r12)     // Catch:{ NullPointerException -> 0x0243, all -> 0x023e }
            int r8 = r8 + r2
            java.lang.String r9 = r4.readLine()     // Catch:{ NullPointerException -> 0x0243, all -> 0x023e }
            java.lang.String r9 = r9.trim()     // Catch:{ NullPointerException -> 0x0243, all -> 0x023e }
        L_0x017a:
            boolean r11 = r9.startsWith(r0)     // Catch:{ NullPointerException -> 0x0243, all -> 0x023e }
            if (r11 != 0) goto L_0x01c9
            java.lang.String r11 = "Dialogue:"
            boolean r11 = r9.startsWith(r11)     // Catch:{ NullPointerException -> 0x0243, all -> 0x023e }
            if (r11 == 0) goto L_0x01bc
            r11 = 2
            java.lang.String[] r9 = r9.split(r10, r11)     // Catch:{ NullPointerException -> 0x0243, all -> 0x023e }
            r9 = r9[r2]     // Catch:{ NullPointerException -> 0x0243, all -> 0x023e }
            java.lang.String r9 = r9.trim()     // Catch:{ NullPointerException -> 0x0243, all -> 0x023e }
            r11 = 10
            java.lang.String[] r9 = r9.split(r12, r11)     // Catch:{ NullPointerException -> 0x0243, all -> 0x023e }
            r15 = r19
            com.utils.subtitle.converter.Caption r9 = r15.f(r9, r5, r6, r1)     // Catch:{ NullPointerException -> 0x030f }
            com.utils.subtitle.converter.Time r11 = r9.f37718b     // Catch:{ NullPointerException -> 0x030f }
            int r11 = r11.f37732a     // Catch:{ NullPointerException -> 0x030f }
        L_0x01a3:
            java.util.TreeMap<java.lang.Integer, com.utils.subtitle.converter.Caption> r13 = r1.f37741i     // Catch:{ NullPointerException -> 0x030f }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r11)     // Catch:{ NullPointerException -> 0x030f }
            boolean r13 = r13.containsKey(r14)     // Catch:{ NullPointerException -> 0x030f }
            if (r13 == 0) goto L_0x01b2
            int r11 = r11 + 1
            goto L_0x01a3
        L_0x01b2:
            java.util.TreeMap<java.lang.Integer, com.utils.subtitle.converter.Caption> r13 = r1.f37741i     // Catch:{ NullPointerException -> 0x030f }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ NullPointerException -> 0x030f }
            r13.put(r11, r9)     // Catch:{ NullPointerException -> 0x030f }
            goto L_0x01be
        L_0x01bc:
            r15 = r19
        L_0x01be:
            int r8 = r8 + 1
            java.lang.String r9 = r4.readLine()     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r9 = r9.trim()     // Catch:{ NullPointerException -> 0x030f }
            goto L_0x017a
        L_0x01c9:
            r15 = r19
            goto L_0x02fb
        L_0x01cd:
            r15 = r19
            java.lang.String r9 = r5.trim()     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r10 = "[Fonts]"
            boolean r9 = r9.equalsIgnoreCase(r10)     // Catch:{ NullPointerException -> 0x030f }
            if (r9 != 0) goto L_0x0213
            java.lang.String r9 = r5.trim()     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r10 = "[Graphics]"
            boolean r9 = r9.equalsIgnoreCase(r10)     // Catch:{ NullPointerException -> 0x030f }
            if (r9 == 0) goto L_0x01e8
            goto L_0x0213
        L_0x01e8:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x030f }
            r9.<init>()     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r10 = r1.f37742j     // Catch:{ NullPointerException -> 0x030f }
            r9.append(r10)     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r10 = "Unrecognized section: "
            r9.append(r10)     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r5 = r5.trim()     // Catch:{ NullPointerException -> 0x030f }
            r9.append(r5)     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r5 = " all information there is ignored."
            r9.append(r5)     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r5 = r9.toString()     // Catch:{ NullPointerException -> 0x030f }
            r1.f37742j = r5     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r5 = r4.readLine()     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r5 = r5.trim()     // Catch:{ NullPointerException -> 0x030f }
            goto L_0x0027
        L_0x0213:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x030f }
            r9.<init>()     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r10 = r1.f37742j     // Catch:{ NullPointerException -> 0x030f }
            r9.append(r10)     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r10 = "The section "
            r9.append(r10)     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r5 = r5.trim()     // Catch:{ NullPointerException -> 0x030f }
            r9.append(r5)     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r5 = " is not supported for conversion, all information there will be lost.\n\n"
            r9.append(r5)     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r5 = r9.toString()     // Catch:{ NullPointerException -> 0x030f }
            r1.f37742j = r5     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r5 = r4.readLine()     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r5 = r5.trim()     // Catch:{ NullPointerException -> 0x030f }
            goto L_0x0027
        L_0x023e:
            r0 = move-exception
            r15 = r19
            goto L_0x0328
        L_0x0243:
            r15 = r19
            goto L_0x030f
        L_0x0247:
            r15 = r19
            java.lang.String r9 = "+"
            boolean r5 = r5.contains(r9)     // Catch:{ NullPointerException -> 0x030f }
            if (r5 == 0) goto L_0x0269
            if (r7 != 0) goto L_0x0269
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x030f }
            r5.<init>()     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r7 = r1.f37742j     // Catch:{ NullPointerException -> 0x030f }
            r5.append(r7)     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r7 = "ScriptType should be set to v4:00+ in the [Script Info] section.\n\n"
            r5.append(r7)     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r5 = r5.toString()     // Catch:{ NullPointerException -> 0x030f }
            r1.f37742j = r5     // Catch:{ NullPointerException -> 0x030f }
            r7 = 1
        L_0x0269:
            int r8 = r8 + 1
            java.lang.String r5 = r4.readLine()     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r5 = r5.trim()     // Catch:{ NullPointerException -> 0x030f }
            boolean r9 = r5.startsWith(r13)     // Catch:{ NullPointerException -> 0x030f }
            if (r9 != 0) goto L_0x02a5
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x030f }
            r9.<init>()     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r14 = r1.f37742j     // Catch:{ NullPointerException -> 0x030f }
            r9.append(r14)     // Catch:{ NullPointerException -> 0x030f }
            r9.append(r11)     // Catch:{ NullPointerException -> 0x030f }
            r9.append(r5)     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r11 = " for the styles section\n\n"
            r9.append(r11)     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r9 = r9.toString()     // Catch:{ NullPointerException -> 0x030f }
            r1.f37742j = r9     // Catch:{ NullPointerException -> 0x030f }
        L_0x0294:
            boolean r9 = r5.startsWith(r13)     // Catch:{ NullPointerException -> 0x030f }
            if (r9 != 0) goto L_0x02a5
            int r8 = r8 + 1
            java.lang.String r5 = r4.readLine()     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r5 = r5.trim()     // Catch:{ NullPointerException -> 0x030f }
            goto L_0x0294
        L_0x02a5:
            java.lang.String[] r5 = r5.split(r10)     // Catch:{ NullPointerException -> 0x030f }
            r5 = r5[r2]     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r5 = r5.trim()     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String[] r5 = r5.split(r12)     // Catch:{ NullPointerException -> 0x030f }
            int r8 = r8 + r2
            java.lang.String r9 = r4.readLine()     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r9 = r9.trim()     // Catch:{ NullPointerException -> 0x030f }
        L_0x02bc:
            boolean r11 = r9.startsWith(r0)     // Catch:{ NullPointerException -> 0x030f }
            if (r11 != 0) goto L_0x02fb
            java.lang.String r11 = "Style:"
            boolean r11 = r9.startsWith(r11)     // Catch:{ NullPointerException -> 0x030f }
            if (r11 == 0) goto L_0x02ee
            java.lang.String[] r9 = r9.split(r10)     // Catch:{ NullPointerException -> 0x030f }
            r9 = r9[r2]     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r9 = r9.trim()     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String[] r14 = r9.split(r12)     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r9 = r1.f37742j     // Catch:{ NullPointerException -> 0x030f }
            r13 = r19
            r15 = r5
            r16 = r8
            r17 = r7
            r18 = r9
            com.utils.subtitle.converter.Style r9 = r13.g(r14, r15, r16, r17, r18)     // Catch:{ NullPointerException -> 0x030f }
            java.util.Hashtable<java.lang.String, com.utils.subtitle.converter.Style> r11 = r1.f37739g     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r13 = r9.f37723a     // Catch:{ NullPointerException -> 0x030f }
            r11.put(r13, r9)     // Catch:{ NullPointerException -> 0x030f }
        L_0x02ee:
            int r8 = r8 + 1
            java.lang.String r9 = r4.readLine()     // Catch:{ NullPointerException -> 0x030f }
            java.lang.String r9 = r9.trim()     // Catch:{ NullPointerException -> 0x030f }
            r15 = r19
            goto L_0x02bc
        L_0x02fb:
            r5 = r9
            goto L_0x0027
        L_0x02fe:
            java.lang.String r5 = r4.readLine()     // Catch:{ NullPointerException -> 0x030f }
            int r8 = r8 + 1
            goto L_0x0027
        L_0x0306:
            r1.a()     // Catch:{ NullPointerException -> 0x030f }
        L_0x0309:
            r21.close()
            goto L_0x0325
        L_0x030d:
            r0 = move-exception
            goto L_0x0328
        L_0x030f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x030d }
            r0.<init>()     // Catch:{ all -> 0x030d }
            java.lang.String r4 = r1.f37742j     // Catch:{ all -> 0x030d }
            r0.append(r4)     // Catch:{ all -> 0x030d }
            java.lang.String r4 = "unexpected end of file, maybe last caption is not complete.\n\n"
            r0.append(r4)     // Catch:{ all -> 0x030d }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x030d }
            r1.f37742j = r0     // Catch:{ all -> 0x030d }
            goto L_0x0309
        L_0x0325:
            r1.f37745m = r2
            return r1
        L_0x0328:
            r21.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.subtitle.converter.FormatASS.a(java.lang.String, java.io.InputStream, java.lang.String):com.utils.subtitle.converter.TimedTextObject");
    }

    /* renamed from: h */
    public String[] b(TimedTextObject timedTextObject) {
        String str;
        String str2;
        int i2;
        int i3;
        int i4;
        int i5;
        String str3;
        if (!timedTextObject.f37745m) {
            return null;
        }
        ArrayList arrayList = new ArrayList(timedTextObject.f37739g.size() + 30 + timedTextObject.f37741i.size());
        arrayList.add(0, "[Script Info]");
        String str4 = timedTextObject.f37733a;
        if (str4 == null || str4.isEmpty()) {
            str = "Title: " + timedTextObject.f37737e;
        } else {
            str = "Title: " + timedTextObject.f37733a;
        }
        arrayList.add(1, str);
        String str5 = timedTextObject.f37736d;
        if (str5 == null || str5.isEmpty()) {
            str2 = "Original Script: " + "Unknown";
        } else {
            str2 = "Original Script: " + timedTextObject.f37736d;
        }
        arrayList.add(2, str2);
        String str6 = timedTextObject.f37735c;
        int i6 = 3;
        if (str6 != null && !str6.isEmpty()) {
            arrayList.add(3, "; " + timedTextObject.f37735c);
            i6 = 4;
        }
        String str7 = timedTextObject.f37734b;
        if (str7 != null && !str7.isEmpty()) {
            arrayList.add(i6, "; " + timedTextObject.f37734b);
            i6++;
        }
        int i7 = i6 + 1;
        arrayList.add(i6, "; Converted by the Online Subtitle Converter developed by J. David Requejo");
        if (timedTextObject.f37743k) {
            i2 = i7 + 1;
            arrayList.add(i7, "Script Type: V4.00+");
        } else {
            i2 = i7 + 1;
            arrayList.add(i7, "Script Type: V4.00");
        }
        int i8 = i2 + 1;
        arrayList.add(i2, "Collisions: Normal");
        int i9 = i8 + 1;
        arrayList.add(i8, "Timer: 100,0000");
        if (timedTextObject.f37743k) {
            arrayList.add(i9, "WrapStyle: 1");
            i9++;
        }
        int i10 = i9 + 1;
        arrayList.add(i9, "");
        if (timedTextObject.f37743k) {
            i3 = i10 + 1;
            arrayList.add(i10, "[V4+ Styles]");
        } else {
            i3 = i10 + 1;
            arrayList.add(i10, "[V4 Styles]");
        }
        if (timedTextObject.f37743k) {
            i4 = i3 + 1;
            arrayList.add(i3, "Format: Name, Fontname, Fontsize, PrimaryColour, SecondaryColour, OutlineColour, BackColour, Bold, Italic, Underline, StrikeOut, ScaleX, ScaleY, Spacing, Angle, BorderStyle, Outline, Shadow, Alignment, MarginL, MarginR, MarginV, Encoding");
        } else {
            i4 = i3 + 1;
            arrayList.add(i3, "Format: Name, Fontname, Fontsize, PrimaryColour, SecondaryColour, TertiaryColour, BackColour, Bold, Italic, BorderStyle, Outline, Shadow, Alignment, MarginL, MarginR, MarginV, AlphaLevel, Encoding");
        }
        for (Style next : timedTextObject.f37739g.values()) {
            String str8 = ((((((("Style: " + next.f37723a + ",") + next.f37724b + ",") + next.f37725c + ",") + d(timedTextObject.f37743k, next)) + e(timedTextObject.f37743k, next)) + "1,2,2,") + c(timedTextObject.f37743k, next.f37728f)) + ",0,0,0,";
            if (!timedTextObject.f37743k) {
                str8 = str8 + "0,";
            }
            arrayList.add(i4, str8 + "0");
            i4++;
        }
        int i11 = i4 + 1;
        arrayList.add(i4, "");
        int i12 = i11 + 1;
        arrayList.add(i11, "[Events]");
        if (timedTextObject.f37743k) {
            i5 = i12 + 1;
            arrayList.add(i12, "Format: Layer, Start, End, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
        } else {
            i5 = i12 + 1;
            arrayList.add(i12, "Format: Marked, Start, End, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
        }
        for (Caption next2 : timedTextObject.f37741i.values()) {
            int i13 = timedTextObject.f37744l;
            if (i13 != 0) {
                next2.f37718b.f37732a += i13;
                next2.f37719c.f37732a += i13;
            }
            String str9 = ("Dialogue: 0," + next2.f37718b.a("h:mm:ss.cs") + ",") + next2.f37719c.a("h:mm:ss.cs") + ",";
            int i14 = timedTextObject.f37744l;
            if (i14 != 0) {
                next2.f37718b.f37732a -= i14;
                next2.f37719c.f37732a -= i14;
            }
            if (next2.f37717a != null) {
                str3 = str9 + next2.f37717a.f37723a;
            } else {
                str3 = str9 + "Default";
            }
            arrayList.add(i5, (str3 + ",,0000,0000,0000,,") + next2.f37720d.replaceAll("<br />", "�N").replaceAll("\\<.*?\\>", "").replace(65533, '\\'));
            i5++;
        }
        arrayList.add(i5, "");
        int size = arrayList.size();
        String[] strArr = new String[size];
        for (int i15 = 0; i15 < size; i15++) {
            strArr[i15] = (String) arrayList.get(i15);
        }
        return strArr;
    }
}
