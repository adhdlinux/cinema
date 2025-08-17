package com.google.zxing.qrcode.decoder;

public enum Mode {
    TERMINATOR(new int[]{0, 0, 0}, 0),
    NUMERIC(new int[]{10, 12, 14}, 1),
    ALPHANUMERIC(new int[]{9, 11, 13}, 2),
    STRUCTURED_APPEND(new int[]{0, 0, 0}, 3),
    BYTE(new int[]{8, 16, 16}, 4),
    ECI(new int[]{0, 0, 0}, 7),
    KANJI(new int[]{8, 10, 12}, 8),
    FNC1_FIRST_POSITION(new int[]{0, 0, 0}, 5),
    FNC1_SECOND_POSITION(new int[]{0, 0, 0}, 9),
    HANZI(new int[]{8, 10, 12}, 13);
    

    /* renamed from: b  reason: collision with root package name */
    private final int[] f31252b;

    /* renamed from: c  reason: collision with root package name */
    private final int f31253c;

    private Mode(int[] iArr, int i2) {
        this.f31252b = iArr;
        this.f31253c = i2;
    }

    public int a() {
        return this.f31253c;
    }

    public int b(Version version) {
        char c2;
        int f2 = version.f();
        if (f2 <= 9) {
            c2 = 0;
        } else if (f2 <= 26) {
            c2 = 1;
        } else {
            c2 = 2;
        }
        return this.f31252b[c2];
    }
}
