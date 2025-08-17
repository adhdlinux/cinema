package androidx.media3.exoplayer.text;

import androidx.media3.common.text.Cue;
import androidx.media3.extractor.text.CuesWithTiming;
import com.google.common.collect.ImmutableList;

interface CuesResolver {
    ImmutableList<Cue> a(long j2);

    boolean b(CuesWithTiming cuesWithTiming, long j2);

    long c(long j2);

    void clear();

    long d(long j2);

    void e(long j2);
}
