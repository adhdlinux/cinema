package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import java.io.IOException;

public interface MediaPeriod extends SequenceableLoader {

    public interface Callback extends SequenceableLoader.Callback<MediaPeriod> {
        void p(MediaPeriod mediaPeriod);
    }

    long b();

    boolean c();

    long e();

    void f(long j2);

    long g(long j2, SeekParameters seekParameters);

    boolean h(long j2);

    long i(long j2);

    long j();

    void l() throws IOException;

    TrackGroupArray n();

    void o(long j2, boolean z2);

    void r(Callback callback, long j2);

    long s(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2);
}
