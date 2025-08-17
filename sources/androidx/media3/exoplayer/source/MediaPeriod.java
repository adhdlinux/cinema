package androidx.media3.exoplayer.source;

import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.SequenceableLoader;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import java.io.IOException;

public interface MediaPeriod extends SequenceableLoader {

    public interface Callback extends SequenceableLoader.Callback<MediaPeriod> {
        void m(MediaPeriod mediaPeriod);
    }

    long b();

    boolean c();

    long e();

    void f(long j2);

    boolean g(LoadingInfo loadingInfo);

    long h(long j2, SeekParameters seekParameters);

    long i(long j2);

    long j();

    void l() throws IOException;

    TrackGroupArray n();

    void o(long j2, boolean z2);

    long q(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2);

    void s(Callback callback, long j2);
}
