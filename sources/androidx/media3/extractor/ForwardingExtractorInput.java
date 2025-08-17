package androidx.media3.extractor;

import java.io.IOException;

public class ForwardingExtractorInput implements ExtractorInput {

    /* renamed from: a  reason: collision with root package name */
    private final ExtractorInput f8033a;

    public ForwardingExtractorInput(ExtractorInput extractorInput) {
        this.f8033a = extractorInput;
    }

    public int a(int i2) throws IOException {
        return this.f8033a.a(i2);
    }

    public boolean c(byte[] bArr, int i2, int i3, boolean z2) throws IOException {
        return this.f8033a.c(bArr, i2, i3, z2);
    }

    public void e() {
        this.f8033a.e();
    }

    public boolean f(byte[] bArr, int i2, int i3, boolean z2) throws IOException {
        return this.f8033a.f(bArr, i2, i3, z2);
    }

    public long g() {
        return this.f8033a.g();
    }

    public long getLength() {
        return this.f8033a.getLength();
    }

    public long getPosition() {
        return this.f8033a.getPosition();
    }

    public void h(int i2) throws IOException {
        this.f8033a.h(i2);
    }

    public int j(byte[] bArr, int i2, int i3) throws IOException {
        return this.f8033a.j(bArr, i2, i3);
    }

    public void k(int i2) throws IOException {
        this.f8033a.k(i2);
    }

    public boolean l(int i2, boolean z2) throws IOException {
        return this.f8033a.l(i2, z2);
    }

    public void m(byte[] bArr, int i2, int i3) throws IOException {
        this.f8033a.m(bArr, i2, i3);
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        return this.f8033a.read(bArr, i2, i3);
    }

    public void readFully(byte[] bArr, int i2, int i3) throws IOException {
        this.f8033a.readFully(bArr, i2, i3);
    }
}
