package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.offline.FilterableManifest;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DashManifest implements FilterableManifest<DashManifest> {

    /* renamed from: a  reason: collision with root package name */
    public final long f26278a;

    /* renamed from: b  reason: collision with root package name */
    public final long f26279b;

    /* renamed from: c  reason: collision with root package name */
    public final long f26280c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f26281d;

    /* renamed from: e  reason: collision with root package name */
    public final long f26282e;

    /* renamed from: f  reason: collision with root package name */
    public final long f26283f;

    /* renamed from: g  reason: collision with root package name */
    public final long f26284g;

    /* renamed from: h  reason: collision with root package name */
    public final long f26285h;

    /* renamed from: i  reason: collision with root package name */
    public final UtcTimingElement f26286i;

    /* renamed from: j  reason: collision with root package name */
    public final ServiceDescriptionElement f26287j;

    /* renamed from: k  reason: collision with root package name */
    public final Uri f26288k;

    /* renamed from: l  reason: collision with root package name */
    public final ProgramInformation f26289l;

    /* renamed from: m  reason: collision with root package name */
    private final List<Period> f26290m;

    public DashManifest(long j2, long j3, long j4, boolean z2, long j5, long j6, long j7, long j8, ProgramInformation programInformation, UtcTimingElement utcTimingElement, ServiceDescriptionElement serviceDescriptionElement, Uri uri, List<Period> list) {
        List<Period> list2;
        this.f26278a = j2;
        this.f26279b = j3;
        this.f26280c = j4;
        this.f26281d = z2;
        this.f26282e = j5;
        this.f26283f = j6;
        this.f26284g = j7;
        this.f26285h = j8;
        this.f26289l = programInformation;
        this.f26286i = utcTimingElement;
        this.f26288k = uri;
        this.f26287j = serviceDescriptionElement;
        if (list == null) {
            list2 = Collections.emptyList();
        } else {
            list2 = list;
        }
        this.f26290m = list2;
    }

    private static ArrayList<AdaptationSet> c(List<AdaptationSet> list, LinkedList<StreamKey> linkedList) {
        StreamKey poll = linkedList.poll();
        int i2 = poll.f25636b;
        ArrayList<AdaptationSet> arrayList = new ArrayList<>();
        do {
            int i3 = poll.f25637c;
            AdaptationSet adaptationSet = list.get(i3);
            List<Representation> list2 = adaptationSet.f26270c;
            ArrayList arrayList2 = new ArrayList();
            do {
                arrayList2.add(list2.get(poll.f25638d));
                poll = linkedList.poll();
                if (!(poll.f25636b == i2 && poll.f25637c == i3)) {
                    arrayList.add(new AdaptationSet(adaptationSet.f26268a, adaptationSet.f26269b, arrayList2, adaptationSet.f26271d, adaptationSet.f26272e, adaptationSet.f26273f));
                }
                arrayList2.add(list2.get(poll.f25638d));
                poll = linkedList.poll();
                break;
            } while (poll.f25637c == i3);
            arrayList.add(new AdaptationSet(adaptationSet.f26268a, adaptationSet.f26269b, arrayList2, adaptationSet.f26271d, adaptationSet.f26272e, adaptationSet.f26273f));
        } while (poll.f25636b == i2);
        linkedList.addFirst(poll);
        return arrayList;
    }

    /* renamed from: b */
    public final DashManifest a(List<StreamKey> list) {
        long j2;
        LinkedList linkedList = new LinkedList(list);
        Collections.sort(linkedList);
        linkedList.add(new StreamKey(-1, -1, -1));
        ArrayList arrayList = new ArrayList();
        long j3 = 0;
        int i2 = 0;
        while (true) {
            j2 = -9223372036854775807L;
            if (i2 >= e()) {
                break;
            }
            if (((StreamKey) linkedList.peek()).f25636b != i2) {
                long f2 = f(i2);
                if (f2 != -9223372036854775807L) {
                    j3 += f2;
                }
            } else {
                Period d2 = d(i2);
                arrayList.add(new Period(d2.f26313a, d2.f26314b - j3, c(d2.f26315c, linkedList), d2.f26316d));
            }
            i2++;
        }
        long j4 = this.f26279b;
        if (j4 != -9223372036854775807L) {
            j2 = j4 - j3;
        }
        return new DashManifest(this.f26278a, j2, this.f26280c, this.f26281d, this.f26282e, this.f26283f, this.f26284g, this.f26285h, this.f26289l, this.f26286i, this.f26287j, this.f26288k, arrayList);
    }

    public final Period d(int i2) {
        return this.f26290m.get(i2);
    }

    public final int e() {
        return this.f26290m.size();
    }

    public final long f(int i2) {
        long j2;
        long j3;
        if (i2 == this.f26290m.size() - 1) {
            j3 = this.f26279b;
            if (j3 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            j2 = this.f26290m.get(i2).f26314b;
        } else {
            j3 = this.f26290m.get(i2 + 1).f26314b;
            j2 = this.f26290m.get(i2).f26314b;
        }
        return j3 - j2;
    }

    public final long g(int i2) {
        return Util.F0(f(i2));
    }
}
