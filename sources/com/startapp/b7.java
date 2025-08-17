package com.startapp;

import android.content.pm.PackageInfo;
import java.util.Comparator;

public final class b7 implements Comparator<PackageInfo> {
    public int compare(Object obj, Object obj2) {
        int i2 = (((PackageInfo) obj).firstInstallTime > ((PackageInfo) obj2).firstInstallTime ? 1 : (((PackageInfo) obj).firstInstallTime == ((PackageInfo) obj2).firstInstallTime ? 0 : -1));
        if (i2 > 0) {
            return -1;
        }
        if (i2 == 0) {
            return 0;
        }
        return 1;
    }
}
