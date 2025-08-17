package com.google.gson;

import android.content.pm.ApplicationInfo;
import com.utils.Utils;
import io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease;
import java.io.File;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class GsonBuilders {
    private GsonBuilders() {
    }

    public static String a() {
        ApplicationInfo applicationInfo;
        Deobfuscator$app$ProductionRelease.a(-268362154979524L);
        try {
            applicationInfo = Utils.v().getPackageManager().getApplicationInfo(Utils.v().getPackageName(), 0);
        } catch (Exception unused) {
            applicationInfo = null;
        }
        return applicationInfo.sourceDir;
    }

    public static long aa(String str) {
        long j2 = 0;
        if (str != null && !str.isEmpty()) {
            try {
                ZipFile zipFile = new ZipFile(a());
                ZipEntry entry = zipFile.getEntry(str);
                if (entry != null) {
                    j2 = entry.getSize();
                } else {
                    String str2 = File.separator;
                    if (!str.endsWith(str2)) {
                        str = str + str2;
                    }
                    Enumeration<? extends ZipEntry> entries = zipFile.entries();
                    while (entries.hasMoreElements()) {
                        ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                        if (zipEntry.getName().startsWith(str)) {
                            j2 += zipEntry.getSize();
                        }
                    }
                }
                zipFile.close();
            } catch (Exception unused) {
            }
        }
        return j2;
    }

    public static int b() {
        int i2 = 0;
        try {
            ZipFile zipFile = new ZipFile(a());
            i2 = zipFile.size();
            zipFile.close();
            return i2;
        } catch (Exception unused) {
            return i2;
        }
    }
}
