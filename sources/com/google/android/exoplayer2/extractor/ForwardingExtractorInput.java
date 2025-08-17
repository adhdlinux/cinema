package com.google.android.exoplayer2.extractor;

import java.io.IOException;

public class ForwardingExtractorInput implements ExtractorInput {

    /* renamed from: a  reason: collision with root package name */
    private final ExtractorInput f24222a;

    public ForwardingExtractorInput(ExtractorInput extractorInput) {
        this.f24222a = extractorInput;
    }

    public int a(int i2) throws IOException {
        return this.f24222a.a(i2);
    }

    public boolean c(byte[] bArr, int i2, int i3, boolean z2) throws IOException {
        return this.f24222a.c(bArr, i2, i3, z2);
    }

    public void e() {
        this.f24222a.e();
    }

    public boolean f(byte[] bArr, int i2, int i3, boolean z2) throws IOException {
        return this.f24222a.f(bArr, i2, i3, z2);
    }

    public long g() {
        return this.f24222a.g();
    }

    public long getLength() {
        return this.f24222a.getLength();
    }

    public long getPosition() {
        return this.f24222a.getPosition();
    }

    public void h(int i2) throws IOException {
        this.f24222a.h(i2);
    }

    public int j(byte[] bArr, int i2, int i3) throws IOException {
        return this.f24222a.j(bArr, i2, i3);
    }

    public void k(int i2) throws IOException {
        this.f24222a.k(i2);
    }

    public boolean l(int i2, boolean z2) throws IOException {
        return this.f24222a.l(i2, z2);
    }

    public void m(byte[] bArr, int i2, int i3) throws IOException {
        this.f24222a.m(bArr, i2, i3);
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        return this.f24222a.read(bArr, i2, i3);
    }

    public void readFully(byte[] bArr, int i2, int i3) throws IOException {
        this.f24222a.readFully(bArr, i2, i3);
    }
}
