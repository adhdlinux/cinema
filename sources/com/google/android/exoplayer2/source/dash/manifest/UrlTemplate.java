package com.google.android.exoplayer2.source.dash.manifest;

import java.util.Locale;

public final class UrlTemplate {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f26364a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f26365b;

    /* renamed from: c  reason: collision with root package name */
    private final String[] f26366c;

    /* renamed from: d  reason: collision with root package name */
    private final int f26367d;

    private UrlTemplate(String[] strArr, int[] iArr, String[] strArr2, int i2) {
        this.f26364a = strArr;
        this.f26365b = iArr;
        this.f26366c = strArr2;
        this.f26367d = i2;
    }

    public static UrlTemplate b(String str) {
        String[] strArr = new String[5];
        int[] iArr = new int[4];
        String[] strArr2 = new String[4];
        return new UrlTemplate(strArr, iArr, strArr2, c(str, strArr, iArr, strArr2));
    }

    private static int c(String str, String[] strArr, int[] iArr, String[] strArr2) {
        String str2;
        strArr[0] = "";
        int i2 = 0;
        int i3 = 0;
        while (i2 < str.length()) {
            int indexOf = str.indexOf("$", i2);
            char c2 = 65535;
            if (indexOf == -1) {
                strArr[i3] = strArr[i3] + str.substring(i2);
                i2 = str.length();
            } else if (indexOf != i2) {
                strArr[i3] = strArr[i3] + str.substring(i2, indexOf);
                i2 = indexOf;
            } else if (str.startsWith("$$", i2)) {
                strArr[i3] = strArr[i3] + "$";
                i2 += 2;
            } else {
                int i4 = i2 + 1;
                int indexOf2 = str.indexOf("$", i4);
                String substring = str.substring(i4, indexOf2);
                if (substring.equals("RepresentationID")) {
                    iArr[i3] = 1;
                } else {
                    int indexOf3 = substring.indexOf("%0");
                    if (indexOf3 != -1) {
                        str2 = substring.substring(indexOf3);
                        if (!str2.endsWith("d") && !str2.endsWith("x") && !str2.endsWith("X")) {
                            str2 = str2 + "d";
                        }
                        substring = substring.substring(0, indexOf3);
                    } else {
                        str2 = "%01d";
                    }
                    substring.hashCode();
                    switch (substring.hashCode()) {
                        case -1950496919:
                            if (substring.equals("Number")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 2606829:
                            if (substring.equals("Time")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 38199441:
                            if (substring.equals("Bandwidth")) {
                                c2 = 2;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                            iArr[i3] = 2;
                            break;
                        case 1:
                            iArr[i3] = 4;
                            break;
                        case 2:
                            iArr[i3] = 3;
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid template: " + str);
                    }
                    strArr2[i3] = str2;
                }
                i3++;
                strArr[i3] = "";
                i2 = indexOf2 + 1;
            }
        }
        return i3;
    }

    public String a(String str, long j2, int i2, long j3) {
        StringBuilder sb = new StringBuilder();
        int i3 = 0;
        while (true) {
            int i4 = this.f26367d;
            if (i3 < i4) {
                sb.append(this.f26364a[i3]);
                int i5 = this.f26365b[i3];
                if (i5 == 1) {
                    sb.append(str);
                } else if (i5 == 2) {
                    sb.append(String.format(Locale.US, this.f26366c[i3], new Object[]{Long.valueOf(j2)}));
                } else if (i5 == 3) {
                    sb.append(String.format(Locale.US, this.f26366c[i3], new Object[]{Integer.valueOf(i2)}));
                } else if (i5 == 4) {
                    sb.append(String.format(Locale.US, this.f26366c[i3], new Object[]{Long.valueOf(j3)}));
                }
                i3++;
            } else {
                sb.append(this.f26364a[i4]);
                return sb.toString();
            }
        }
    }
}
