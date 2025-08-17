package com.google.common.primitives;

import com.facebook.react.uimanager.events.TouchesHelper;
import com.google.common.base.Preconditions;

public final class Bytes {
    private Bytes() {
    }

    public static int a(byte[] bArr, byte[] bArr2) {
        Preconditions.m(bArr, "array");
        Preconditions.m(bArr2, TouchesHelper.TARGET_KEY);
        if (bArr2.length == 0) {
            return 0;
        }
        int i2 = 0;
        while (i2 < (bArr.length - bArr2.length) + 1) {
            int i3 = 0;
            while (i3 < bArr2.length) {
                if (bArr[i2 + i3] != bArr2[i3]) {
                    i2++;
                } else {
                    i3++;
                }
            }
            return i2;
        }
        return -1;
    }
}
