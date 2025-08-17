package androidx.media3.exoplayer.dash.manifest;

import android.net.Uri;
import androidx.media3.common.StreamKey;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.offline.FilterableManifest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DashManifest implements FilterableManifest<DashManifest> {

    /* renamed from: a  reason: collision with root package name */
    public final long f6049a;

    /* renamed from: b  reason: collision with root package name */
    public final long f6050b;

    /* renamed from: c  reason: collision with root package name */
    public final long f6051c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f6052d;

    /* renamed from: e  reason: collision with root package name */
    public final long f6053e;

    /* renamed from: f  reason: collision with root package name */
    public final long f6054f;

    /* renamed from: g  reason: collision with root package name */
    public final long f6055g;

    /* renamed from: h  reason: collision with root package name */
    public final long f6056h;

    /* renamed from: i  reason: collision with root package name */
    public final UtcTimingElement f6057i;

    /* renamed from: j  reason: collision with root package name */
    public final ServiceDescriptionElement f6058j;

    /* renamed from: k  reason: collision with root package name */
    public final Uri f6059k;

    /* renamed from: l  reason: collision with root package name */
    public final ProgramInformation f6060l;

    /* renamed from: m  reason: collision with root package name */
    private final List<Period> f6061m;

    public DashManifest(long j2, long j3, long j4, boolean z2, long j5, long j6, long j7, long j8, ProgramInformation programInformation, UtcTimingElement utcTimingElement, ServiceDescriptionElement serviceDescriptionElement, Uri uri, List<Period> list) {
        List<Period> list2;
        this.f6049a = j2;
        this.f6050b = j3;
        this.f6051c = j4;
        this.f6052d = z2;
        this.f6053e = j5;
        this.f6054f = j6;
        this.f6055g = j7;
        this.f6056h = j8;
        this.f6060l = programInformation;
        this.f6057i = utcTimingElement;
        this.f6059k = uri;
        this.f6058j = serviceDescriptionElement;
        if (list == null) {
            list2 = Collections.emptyList();
        } else {
            list2 = list;
        }
        this.f6061m = list2;
    }

    private static ArrayList<AdaptationSet> c(List<AdaptationSet> list, LinkedList<StreamKey> linkedList) {
        StreamKey poll = linkedList.poll();
        int i2 = poll.f4339b;
        ArrayList<AdaptationSet> arrayList = new ArrayList<>();
        do {
            int i3 = poll.f4340c;
            AdaptationSet adaptationSet = list.get(i3);
            List<Representation> list2 = adaptationSet.f6041c;
            ArrayList arrayList2 = new ArrayList();
            do {
                arrayList2.add(list2.get(poll.f4341d));
                poll = linkedList.poll();
                if (!(poll.f4339b == i2 && poll.f4340c == i3)) {
                    arrayList.add(new AdaptationSet(adaptationSet.f6039a, adaptationSet.f6040b, arrayList2, adaptationSet.f6042d, adaptationSet.f6043e, adaptationSet.f6044f));
                }
                arrayList2.add(list2.get(poll.f4341d));
                poll = linkedList.poll();
                break;
            } while (poll.f4340c == i3);
            arrayList.add(new AdaptationSet(adaptationSet.f6039a, adaptationSet.f6040b, arrayList2, adaptationSet.f6042d, adaptationSet.f6043e, adaptationSet.f6044f));
        } while (poll.f4339b == i2);
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
            if (((StreamKey) linkedList.peek()).f4339b != i2) {
                long f2 = f(i2);
                if (f2 != -9223372036854775807L) {
                    j3 += f2;
                }
            } else {
                Period d2 = d(i2);
                arrayList.add(new Period(d2.f6084a, d2.f6085b - j3, c(d2.f6086c, linkedList), d2.f6087d));
            }
            i2++;
        }
        long j4 = this.f6050b;
        if (j4 != -9223372036854775807L) {
            j2 = j4 - j3;
        }
        return new DashManifest(this.f6049a, j2, this.f6051c, this.f6052d, this.f6053e, this.f6054f, this.f6055g, this.f6056h, this.f6060l, this.f6057i, this.f6058j, this.f6059k, arrayList);
    }

    public final Period d(int i2) {
        return this.f6061m.get(i2);
    }

    public final int e() {
        return this.f6061m.size();
    }

    public final long f(int i2) {
        long j2;
        long j3;
        if (i2 == this.f6061m.size() - 1) {
            j3 = this.f6050b;
            if (j3 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            j2 = this.f6061m.get(i2).f6085b;
        } else {
            j3 = this.f6061m.get(i2 + 1).f6085b;
            j2 = this.f6061m.get(i2).f6085b;
        }
        return j3 - j2;
    }

    public final long g(int i2) {
        return Util.P0(f(i2));
    }
}
