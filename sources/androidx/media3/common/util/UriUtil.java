package androidx.media3.common.util;

import android.net.Uri;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import java.util.List;

public final class UriUtil {
    private UriUtil() {
    }

    public static String a(Uri uri, Uri uri2) {
        boolean z2;
        if (uri.isOpaque() || uri2.isOpaque()) {
            return uri2.toString();
        }
        String scheme = uri.getScheme();
        String scheme2 = uri2.getScheme();
        int i2 = 0;
        if (scheme != null ? scheme2 == null || !Ascii.a(scheme, scheme2) : scheme2 != null) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2 || !Util.c(uri.getAuthority(), uri2.getAuthority())) {
            return uri2.toString();
        }
        List<String> pathSegments = uri.getPathSegments();
        List<String> pathSegments2 = uri2.getPathSegments();
        int min = Math.min(pathSegments.size(), pathSegments2.size());
        int i3 = 0;
        while (i2 < min && pathSegments.get(i2).equals(pathSegments2.get(i2))) {
            i3++;
            i2++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i4 = i3; i4 < pathSegments.size(); i4++) {
            sb.append("../");
        }
        while (i3 < pathSegments2.size()) {
            sb.append(pathSegments2.get(i3));
            if (i3 < pathSegments2.size() - 1) {
                sb.append("/");
            }
            i3++;
        }
        return sb.toString();
    }

    private static int[] b(String str) {
        boolean z2;
        int i2;
        int[] iArr = new int[4];
        if (TextUtils.isEmpty(str)) {
            iArr[0] = -1;
            return iArr;
        }
        int length = str.length();
        int indexOf = str.indexOf(35);
        if (indexOf != -1) {
            length = indexOf;
        }
        int indexOf2 = str.indexOf(63);
        if (indexOf2 == -1 || indexOf2 > length) {
            indexOf2 = length;
        }
        int indexOf3 = str.indexOf(47);
        if (indexOf3 == -1 || indexOf3 > indexOf2) {
            indexOf3 = indexOf2;
        }
        int indexOf4 = str.indexOf(58);
        if (indexOf4 > indexOf3) {
            indexOf4 = -1;
        }
        int i3 = indexOf4 + 2;
        if (i3 < indexOf2 && str.charAt(indexOf4 + 1) == '/' && str.charAt(i3) == '/') {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            i2 = str.indexOf(47, indexOf4 + 3);
            if (i2 == -1 || i2 > indexOf2) {
                i2 = indexOf2;
            }
        } else {
            i2 = indexOf4 + 1;
        }
        iArr[0] = indexOf4;
        iArr[1] = i2;
        iArr[2] = indexOf2;
        iArr[3] = length;
        return iArr;
    }

    public static boolean c(String str) {
        return (str == null || b(str)[0] == -1) ? false : true;
    }

    private static String d(StringBuilder sb, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        if (i2 >= i3) {
            return sb.toString();
        }
        if (sb.charAt(i2) == '/') {
            i2++;
        }
        int i7 = i2;
        int i8 = i7;
        while (i7 <= i3) {
            if (i7 == i3) {
                i4 = i7;
            } else if (sb.charAt(i7) == '/') {
                i4 = i7 + 1;
            } else {
                i7++;
            }
            int i9 = i8 + 1;
            if (i7 == i9 && sb.charAt(i8) == '.') {
                sb.delete(i8, i4);
                i3 -= i4 - i8;
            } else {
                if (i7 == i8 + 2 && sb.charAt(i8) == '.' && sb.charAt(i9) == '.') {
                    i5 = sb.lastIndexOf("/", i8 - 2) + 1;
                    if (i5 > i2) {
                        i6 = i5;
                    } else {
                        i6 = i2;
                    }
                    sb.delete(i6, i4);
                    i3 -= i4 - i6;
                } else {
                    i5 = i7 + 1;
                }
                i8 = i5;
            }
            i7 = i8;
        }
        return sb.toString();
    }

    public static String e(String str, String str2) {
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        int[] b2 = b(str2);
        if (b2[0] != -1) {
            sb.append(str2);
            d(sb, b2[1], b2[2]);
            return sb.toString();
        }
        int[] b3 = b(str);
        if (b2[3] == 0) {
            sb.append(str, 0, b3[3]);
            sb.append(str2);
            return sb.toString();
        } else if (b2[2] == 0) {
            sb.append(str, 0, b3[2]);
            sb.append(str2);
            return sb.toString();
        } else {
            int i3 = b2[1];
            if (i3 != 0) {
                int i4 = b3[0] + 1;
                sb.append(str, 0, i4);
                sb.append(str2);
                return d(sb, b2[1] + i4, i4 + b2[2]);
            } else if (str2.charAt(i3) == '/') {
                sb.append(str, 0, b3[1]);
                sb.append(str2);
                int i5 = b3[1];
                return d(sb, i5, b2[2] + i5);
            } else {
                int i6 = b3[0] + 2;
                int i7 = b3[1];
                if (i6 >= i7 || i7 != b3[2]) {
                    int lastIndexOf = str.lastIndexOf(47, b3[2] - 1);
                    if (lastIndexOf == -1) {
                        i2 = b3[1];
                    } else {
                        i2 = lastIndexOf + 1;
                    }
                    sb.append(str, 0, i2);
                    sb.append(str2);
                    return d(sb, b3[1], i2 + b2[2]);
                }
                sb.append(str, 0, i7);
                sb.append('/');
                sb.append(str2);
                int i8 = b3[1];
                return d(sb, i8, b2[2] + i8 + 1);
            }
        }
    }

    public static Uri f(String str, String str2) {
        return Uri.parse(e(str, str2));
    }
}
