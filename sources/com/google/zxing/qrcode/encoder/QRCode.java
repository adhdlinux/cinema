package com.google.zxing.qrcode.encoder;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;

public final class QRCode {

    /* renamed from: a  reason: collision with root package name */
    private Mode f31275a;

    /* renamed from: b  reason: collision with root package name */
    private ErrorCorrectionLevel f31276b;

    /* renamed from: c  reason: collision with root package name */
    private Version f31277c;

    /* renamed from: d  reason: collision with root package name */
    private int f31278d = -1;

    /* renamed from: e  reason: collision with root package name */
    private ByteMatrix f31279e;

    public static boolean b(int i2) {
        return i2 >= 0 && i2 < 8;
    }

    public ByteMatrix a() {
        return this.f31279e;
    }

    public void c(ErrorCorrectionLevel errorCorrectionLevel) {
        this.f31276b = errorCorrectionLevel;
    }

    public void d(int i2) {
        this.f31278d = i2;
    }

    public void e(ByteMatrix byteMatrix) {
        this.f31279e = byteMatrix;
    }

    public void f(Mode mode) {
        this.f31275a = mode;
    }

    public void g(Version version) {
        this.f31277c = version;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n");
        sb.append(" mode: ");
        sb.append(this.f31275a);
        sb.append("\n ecLevel: ");
        sb.append(this.f31276b);
        sb.append("\n version: ");
        sb.append(this.f31277c);
        sb.append("\n maskPattern: ");
        sb.append(this.f31278d);
        if (this.f31279e == null) {
            sb.append("\n matrix: null\n");
        } else {
            sb.append("\n matrix:\n");
            sb.append(this.f31279e);
        }
        sb.append(">>\n");
        return sb.toString();
    }
}
