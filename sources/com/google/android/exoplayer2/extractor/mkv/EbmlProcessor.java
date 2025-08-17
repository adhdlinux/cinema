package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import java.io.IOException;

public interface EbmlProcessor {
    void a(int i2) throws ParserException;

    void b(int i2, double d2) throws ParserException;

    void c(int i2, long j2) throws ParserException;

    int d(int i2);

    boolean e(int i2);

    void f(int i2, String str) throws ParserException;

    void g(int i2, long j2, long j3) throws ParserException;

    void h(int i2, int i3, ExtractorInput extractorInput) throws IOException;
}
