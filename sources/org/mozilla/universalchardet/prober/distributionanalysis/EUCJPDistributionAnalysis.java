package org.mozilla.universalchardet.prober.distributionanalysis;

public class EUCJPDistributionAnalysis extends JISDistributionAnalysis {
    /* access modifiers changed from: protected */
    public int b(byte[] bArr, int i2) {
        byte b2 = bArr[i2] & 255;
        if (b2 < 161) {
            return -1;
        }
        return (((b2 - 161) * 94) + (bArr[i2 + 1] & 255)) - 161;
    }
}
