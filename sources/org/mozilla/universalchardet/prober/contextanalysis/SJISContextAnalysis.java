package org.mozilla.universalchardet.prober.contextanalysis;

public class SJISContextAnalysis extends JapaneseContextAnalysis {
    /* access modifiers changed from: protected */
    public int b(byte[] bArr, int i2) {
        byte b2;
        if ((bArr[i2] & 255) != 130 || (b2 = bArr[i2 + 1] & 255) < 159 || b2 > 241) {
            return -1;
        }
        return b2 - 159;
    }
}
