package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;

public final class TrackEncryptionBox {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f24670a;

    /* renamed from: b  reason: collision with root package name */
    public final String f24671b;

    /* renamed from: c  reason: collision with root package name */
    public final TrackOutput.CryptoData f24672c;

    /* renamed from: d  reason: collision with root package name */
    public final int f24673d;

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f24674e;

    public TrackEncryptionBox(boolean z2, String str, int i2, byte[] bArr, int i3, int i4, byte[] bArr2) {
        boolean z3;
        boolean z4 = true;
        if (i2 == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assertions.a((bArr2 != null ? false : z4) ^ z3);
        this.f24670a = z2;
        this.f24671b = str;
        this.f24673d = i2;
        this.f24674e = bArr2;
        this.f24672c = new TrackOutput.CryptoData(a(str), bArr, i3, i4);
    }

    private static int a(String str) {
        if (str == null) {
            return 1;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case 3046605:
                if (str.equals("cbc1")) {
                    c2 = 0;
                    break;
                }
                break;
            case 3046671:
                if (str.equals("cbcs")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3049879:
                if (str.equals("cenc")) {
                    c2 = 2;
                    break;
                }
                break;
            case 3049895:
                if (str.equals("cens")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
                return 2;
            case 2:
            case 3:
                break;
            default:
                Log.i("TrackEncryptionBox", "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.");
                break;
        }
        return 1;
    }
}
