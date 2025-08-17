package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

final class PlaylistTimeline extends AbstractConcatenatedTimeline {

    /* renamed from: j  reason: collision with root package name */
    private final int f23441j;

    /* renamed from: k  reason: collision with root package name */
    private final int f23442k;

    /* renamed from: l  reason: collision with root package name */
    private final int[] f23443l;

    /* renamed from: m  reason: collision with root package name */
    private final int[] f23444m;

    /* renamed from: n  reason: collision with root package name */
    private final Timeline[] f23445n;

    /* renamed from: o  reason: collision with root package name */
    private final Object[] f23446o;

    /* renamed from: p  reason: collision with root package name */
    private final HashMap<Object, Integer> f23447p = new HashMap<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlaylistTimeline(Collection<? extends MediaSourceInfoHolder> collection, ShuffleOrder shuffleOrder) {
        super(false, shuffleOrder);
        int i2 = 0;
        int size = collection.size();
        this.f23443l = new int[size];
        this.f23444m = new int[size];
        this.f23445n = new Timeline[size];
        this.f23446o = new Object[size];
        int i3 = 0;
        int i4 = 0;
        for (MediaSourceInfoHolder mediaSourceInfoHolder : collection) {
            this.f23445n[i4] = mediaSourceInfoHolder.b();
            this.f23444m[i4] = i2;
            this.f23443l[i4] = i3;
            i2 += this.f23445n[i4].t();
            i3 += this.f23445n[i4].m();
            this.f23446o[i4] = mediaSourceInfoHolder.a();
            this.f23447p.put(this.f23446o[i4], Integer.valueOf(i4));
            i4++;
        }
        this.f23441j = i2;
        this.f23442k = i3;
    }

    /* access modifiers changed from: protected */
    public Object B(int i2) {
        return this.f23446o[i2];
    }

    /* access modifiers changed from: protected */
    public int D(int i2) {
        return this.f23443l[i2];
    }

    /* access modifiers changed from: protected */
    public int E(int i2) {
        return this.f23444m[i2];
    }

    /* access modifiers changed from: protected */
    public Timeline H(int i2) {
        return this.f23445n[i2];
    }

    /* access modifiers changed from: package-private */
    public List<Timeline> I() {
        return Arrays.asList(this.f23445n);
    }

    public int m() {
        return this.f23442k;
    }

    public int t() {
        return this.f23441j;
    }

    /* access modifiers changed from: protected */
    public int w(Object obj) {
        Integer num = this.f23447p.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    /* access modifiers changed from: protected */
    public int x(int i2) {
        return Util.h(this.f23443l, i2 + 1, false, false);
    }

    /* access modifiers changed from: protected */
    public int y(int i2) {
        return Util.h(this.f23444m, i2 + 1, false, false);
    }
}
