package androidx.media3.extractor.text;

import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.decoder.DecoderOutputBuffer;
import com.facebook.common.time.Clock;
import java.util.List;

public abstract class SubtitleOutputBuffer extends DecoderOutputBuffer implements Subtitle {

    /* renamed from: b  reason: collision with root package name */
    private Subtitle f8796b;

    /* renamed from: c  reason: collision with root package name */
    private long f8797c;

    public int a(long j2) {
        return ((Subtitle) Assertions.f(this.f8796b)).a(j2 - this.f8797c);
    }

    public List<Cue> b(long j2) {
        return ((Subtitle) Assertions.f(this.f8796b)).b(j2 - this.f8797c);
    }

    public long c(int i2) {
        return ((Subtitle) Assertions.f(this.f8796b)).c(i2) + this.f8797c;
    }

    public void clear() {
        super.clear();
        this.f8796b = null;
    }

    public int d() {
        return ((Subtitle) Assertions.f(this.f8796b)).d();
    }

    public void e(long j2, Subtitle subtitle, long j3) {
        this.timeUs = j2;
        this.f8796b = subtitle;
        if (j3 != Clock.MAX_TIME) {
            j2 = j3;
        }
        this.f8797c = j2;
    }
}
