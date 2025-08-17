package org.mozilla.universalchardet.prober.contextanalysis;

public class EUCJPContextAnalysis extends JapaneseContextAnalysis {
    /* access modifiers changed from: protected */
    public int b(byte[] bArr, int i2) {
        byte b2;
        if ((bArr[i2] & 255) != 164 || (b2 = bArr[i2 + 1] & 255) < 161 || b2 > 243) {
            return -1;
        }
        return b2 - 161;
    }
}
