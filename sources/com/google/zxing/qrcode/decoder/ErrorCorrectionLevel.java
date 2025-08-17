package com.google.zxing.qrcode.decoder;

public enum ErrorCorrectionLevel {
    L(1),
    M(0),
    Q(3),
    H(2);
    

    /* renamed from: g  reason: collision with root package name */
    private static final ErrorCorrectionLevel[] f31238g = null;

    /* renamed from: b  reason: collision with root package name */
    private final int f31240b;

    static {
        ErrorCorrectionLevel errorCorrectionLevel;
        ErrorCorrectionLevel errorCorrectionLevel2;
        ErrorCorrectionLevel errorCorrectionLevel3;
        ErrorCorrectionLevel errorCorrectionLevel4;
        f31238g = new ErrorCorrectionLevel[]{errorCorrectionLevel2, errorCorrectionLevel, errorCorrectionLevel4, errorCorrectionLevel3};
    }

    private ErrorCorrectionLevel(int i2) {
        this.f31240b = i2;
    }

    public int a() {
        return this.f31240b;
    }
}
