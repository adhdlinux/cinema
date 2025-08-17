package com.google.android.exoplayer2.extractor.avi;

import com.google.android.exoplayer2.util.ParsableByteArray;

final class StreamNameChunk implements AviChunk {

    /* renamed from: a  reason: collision with root package name */
    public final String f24341a;

    private StreamNameChunk(String str) {
        this.f24341a = str;
    }

    public static StreamNameChunk a(ParsableByteArray parsableByteArray) {
        return new StreamNameChunk(parsableByteArray.E(parsableByteArray.a()));
    }

    public int getType() {
        return 1852994675;
    }
}
