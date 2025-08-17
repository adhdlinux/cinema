package androidx.media3.exoplayer;

import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.ForwardingTimeline;
import androidx.media3.exoplayer.source.ShuffleOrder;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

final class PlaylistTimeline extends AbstractConcatenatedTimeline {

    /* renamed from: h  reason: collision with root package name */
    private final int f5498h;

    /* renamed from: i  reason: collision with root package name */
    private final int f5499i;

    /* renamed from: j  reason: collision with root package name */
    private final int[] f5500j;

    /* renamed from: k  reason: collision with root package name */
    private final int[] f5501k;

    /* renamed from: l  reason: collision with root package name */
    private final Timeline[] f5502l;

    /* renamed from: m  reason: collision with root package name */
    private final Object[] f5503m;

    /* renamed from: n  reason: collision with root package name */
    private final HashMap<Object, Integer> f5504n;

    public PlaylistTimeline(Collection<? extends MediaSourceInfoHolder> collection, ShuffleOrder shuffleOrder) {
        this(G(collection), H(collection), shuffleOrder);
    }

    private static Timeline[] G(Collection<? extends MediaSourceInfoHolder> collection) {
        Timeline[] timelineArr = new Timeline[collection.size()];
        int i2 = 0;
        for (MediaSourceInfoHolder b2 : collection) {
            timelineArr[i2] = b2.b();
            i2++;
        }
        return timelineArr;
    }

    private static Object[] H(Collection<? extends MediaSourceInfoHolder> collection) {
        Object[] objArr = new Object[collection.size()];
        int i2 = 0;
        for (MediaSourceInfoHolder a2 : collection) {
            objArr[i2] = a2.a();
            i2++;
        }
        return objArr;
    }

    /* access modifiers changed from: protected */
    public int A(int i2) {
        return this.f5501k[i2];
    }

    /* access modifiers changed from: protected */
    public Timeline D(int i2) {
        return this.f5502l[i2];
    }

    public PlaylistTimeline E(ShuffleOrder shuffleOrder) {
        Timeline[] timelineArr = new Timeline[this.f5502l.length];
        int i2 = 0;
        while (true) {
            Timeline[] timelineArr2 = this.f5502l;
            if (i2 >= timelineArr2.length) {
                return new PlaylistTimeline(timelineArr, this.f5503m, shuffleOrder);
            }
            timelineArr[i2] = new ForwardingTimeline(timelineArr2[i2]) {

                /* renamed from: f  reason: collision with root package name */
                private final Timeline.Window f5505f = new Timeline.Window();

                public Timeline.Period g(int i2, Timeline.Period period, boolean z2) {
                    Timeline.Period g2 = super.g(i2, period, z2);
                    if (super.n(g2.f4357c, this.f5505f).f()) {
                        g2.t(period.f4355a, period.f4356b, period.f4357c, period.f4358d, period.f4359e, AdPlaybackState.f3879g, true);
                    } else {
                        g2.f4360f = true;
                    }
                    return g2;
                }
            };
            i2++;
        }
    }

    /* access modifiers changed from: package-private */
    public List<Timeline> F() {
        return Arrays.asList(this.f5502l);
    }

    public int i() {
        return this.f5499i;
    }

    public int p() {
        return this.f5498h;
    }

    /* access modifiers changed from: protected */
    public int s(Object obj) {
        Integer num = this.f5504n.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    /* access modifiers changed from: protected */
    public int t(int i2) {
        return Util.g(this.f5500j, i2 + 1, false, false);
    }

    /* access modifiers changed from: protected */
    public int u(int i2) {
        return Util.g(this.f5501k, i2 + 1, false, false);
    }

    /* access modifiers changed from: protected */
    public Object x(int i2) {
        return this.f5503m[i2];
    }

    /* access modifiers changed from: protected */
    public int z(int i2) {
        return this.f5500j[i2];
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private PlaylistTimeline(Timeline[] timelineArr, Object[] objArr, ShuffleOrder shuffleOrder) {
        super(false, shuffleOrder);
        int i2 = 0;
        int length = timelineArr.length;
        this.f5502l = timelineArr;
        this.f5500j = new int[length];
        this.f5501k = new int[length];
        this.f5503m = objArr;
        this.f5504n = new HashMap<>();
        int length2 = timelineArr.length;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i2 < length2) {
            Timeline timeline = timelineArr[i2];
            this.f5502l[i5] = timeline;
            this.f5501k[i5] = i3;
            this.f5500j[i5] = i4;
            i3 += timeline.p();
            i4 += this.f5502l[i5].i();
            this.f5504n.put(objArr[i5], Integer.valueOf(i5));
            i2++;
            i5++;
        }
        this.f5498h = i3;
        this.f5499i = i4;
    }
}
