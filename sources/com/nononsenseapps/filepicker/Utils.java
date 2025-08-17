package com.nononsenseapps.filepicker;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;

public class Utils {
    public static String a(String str, String str2) {
        String str3 = str + "/" + str2;
        while (str3.contains("//")) {
            str3 = str3.replaceAll("//", "/");
        }
        if (str3.length() <= 1 || !str3.endsWith("/")) {
            return str3;
        }
        return str3.substring(0, str3.length() - 1);
    }

    public static File b(Uri uri) {
        String encodedPath = uri.getEncodedPath();
        int indexOf = encodedPath.indexOf(47, 1);
        String decode = Uri.decode(encodedPath.substring(1, indexOf));
        String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
        if ("root".equalsIgnoreCase(decode)) {
            File file = new File("/");
            File file2 = new File(file, decode2);
            try {
                File canonicalFile = file2.getCanonicalFile();
                if (canonicalFile.getPath().startsWith(file.getPath())) {
                    return canonicalFile;
                }
                throw new SecurityException("Resolved path jumped beyond configured root");
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
            }
        } else {
            throw new IllegalArgumentException(String.format("Can't decode paths to '%s', only for 'root' paths.", new Object[]{decode}));
        }
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str) || str.contains("/") || str.equals(".") || str.equals("..")) {
            return false;
        }
        return true;
    }
}
