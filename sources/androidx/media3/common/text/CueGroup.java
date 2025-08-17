package androidx.media3.common.text;

import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import java.util.List;

public final class CueGroup {

    /* renamed from: c  reason: collision with root package name */
    public static final CueGroup f4592c = new CueGroup(ImmutableList.r(), 0);

    /* renamed from: d  reason: collision with root package name */
    private static final String f4593d = Util.B0(0);

    /* renamed from: e  reason: collision with root package name */
    private static final String f4594e = Util.B0(1);

    /* renamed from: a  reason: collision with root package name */
    public final ImmutableList<Cue> f4595a;

    /* renamed from: b  reason: collision with root package name */
    public final long f4596b;

    public CueGroup(List<Cue> list, long j2) {
        this.f4595a = ImmutableList.n(list);
        this.f4596b = j2;
    }
}
