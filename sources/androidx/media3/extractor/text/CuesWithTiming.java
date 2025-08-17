package androidx.media3.extractor.text;

import androidx.media3.common.text.Cue;
import com.google.common.collect.ImmutableList;
import java.util.List;

public class CuesWithTiming {

    /* renamed from: a  reason: collision with root package name */
    public final ImmutableList<Cue> f8773a;

    /* renamed from: b  reason: collision with root package name */
    public final long f8774b;

    /* renamed from: c  reason: collision with root package name */
    public final long f8775c;

    /* renamed from: d  reason: collision with root package name */
    public final long f8776d;

    public CuesWithTiming(List<Cue> list, long j2, long j3) {
        this.f8773a = ImmutableList.n(list);
        this.f8774b = j2;
        this.f8775c = j3;
        long j4 = -9223372036854775807L;
        if (!(j2 == -9223372036854775807L || j3 == -9223372036854775807L)) {
            j4 = j2 + j3;
        }
        this.f8776d = j4;
    }
}
