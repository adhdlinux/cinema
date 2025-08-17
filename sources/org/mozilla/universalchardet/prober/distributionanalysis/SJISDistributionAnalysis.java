package org.mozilla.universalchardet.prober.distributionanalysis;

import com.vungle.ads.internal.protos.Sdk$SDKError;

public class SJISDistributionAnalysis extends JISDistributionAnalysis {
    /* access modifiers changed from: protected */
    public int b(byte[] bArr, int i2) {
        int i3;
        byte b2 = bArr[i2] & 255;
        if (b2 >= 129 && b2 <= 159) {
            i3 = b2 - Sdk$SDKError.Reason.EMPTY_TPAT_ERROR_VALUE;
        } else if (b2 < 224 || b2 > 239) {
            return -1;
        } else {
            i3 = (b2 - 224) + 31;
        }
        int i4 = i3 * 188;
        byte b3 = bArr[i2 + 1] & 255;
        int i5 = i4 + (b3 - 64);
        if (b3 >= 128) {
            return i5 - 1;
        }
        return i5;
    }
}
