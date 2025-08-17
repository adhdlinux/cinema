package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.upstream.DataReader;
import java.io.IOException;

public interface ExtractorInput extends DataReader {
    int a(int i2) throws IOException;

    boolean c(byte[] bArr, int i2, int i3, boolean z2) throws IOException;

    void e();

    boolean f(byte[] bArr, int i2, int i3, boolean z2) throws IOException;

    long g();

    long getLength();

    long getPosition();

    void h(int i2) throws IOException;

    int j(byte[] bArr, int i2, int i3) throws IOException;

    void k(int i2) throws IOException;

    boolean l(int i2, boolean z2) throws IOException;

    void m(byte[] bArr, int i2, int i3) throws IOException;

    int read(byte[] bArr, int i2, int i3) throws IOException;

    void readFully(byte[] bArr, int i2, int i3) throws IOException;
}
