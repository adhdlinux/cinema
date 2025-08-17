package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;

abstract class TagPayloadReader {

    /* renamed from: a  reason: collision with root package name */
    protected final TrackOutput f24384a;

    public static final class UnsupportedFormatException extends ParserException {
        public UnsupportedFormatException(String str) {
            super(str, (Throwable) null, false, 1);
        }
    }

    protected TagPayloadReader(TrackOutput trackOutput) {
        this.f24384a = trackOutput;
    }

    public final boolean a(ParsableByteArray parsableByteArray, long j2) throws ParserException {
        return b(parsableByteArray) && c(parsableByteArray, j2);
    }

    /* access modifiers changed from: protected */
    public abstract boolean b(ParsableByteArray parsableByteArray) throws ParserException;

    /* access modifiers changed from: protected */
    public abstract boolean c(ParsableByteArray parsableByteArray, long j2) throws ParserException;
}
