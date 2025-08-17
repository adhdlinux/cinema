package androidx.media3.extractor.avi;

import androidx.media3.common.util.ParsableByteArray;

final class StreamNameChunk implements AviChunk {

    /* renamed from: a  reason: collision with root package name */
    public final String f8185a;

    private StreamNameChunk(String str) {
        this.f8185a = str;
    }

    public static StreamNameChunk a(ParsableByteArray parsableByteArray) {
        return new StreamNameChunk(parsableByteArray.E(parsableByteArray.a()));
    }

    public int getType() {
        return 1852994675;
    }
}
