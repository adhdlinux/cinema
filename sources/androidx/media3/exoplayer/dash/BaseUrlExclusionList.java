package androidx.media3.exoplayer.dash;

import android.os.SystemClock;
import android.util.Pair;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.dash.manifest.BaseUrl;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class BaseUrlExclusionList {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Long> f5903a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Integer, Long> f5904b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<List<Pair<String, Integer>>, BaseUrl> f5905c;

    /* renamed from: d  reason: collision with root package name */
    private final Random f5906d;

    public BaseUrlExclusionList() {
        this(new Random());
    }

    private static <T> void b(T t2, long j2, Map<T, Long> map) {
        if (map.containsKey(t2)) {
            j2 = Math.max(j2, ((Long) Util.i(map.get(t2))).longValue());
        }
        map.put(t2, Long.valueOf(j2));
    }

    private List<BaseUrl> c(List<BaseUrl> list) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        h(elapsedRealtime, this.f5903a);
        h(elapsedRealtime, this.f5904b);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            BaseUrl baseUrl = list.get(i2);
            if (!this.f5903a.containsKey(baseUrl.f6046b) && !this.f5904b.containsKey(Integer.valueOf(baseUrl.f6047c))) {
                arrayList.add(baseUrl);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static int d(BaseUrl baseUrl, BaseUrl baseUrl2) {
        int compare = Integer.compare(baseUrl.f6047c, baseUrl2.f6047c);
        if (compare != 0) {
            return compare;
        }
        return baseUrl.f6046b.compareTo(baseUrl2.f6046b);
    }

    public static int f(List<BaseUrl> list) {
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < list.size(); i2++) {
            hashSet.add(Integer.valueOf(list.get(i2).f6047c));
        }
        return hashSet.size();
    }

    private static <T> void h(long j2, Map<T, Long> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : map.entrySet()) {
            if (((Long) next.getValue()).longValue() <= j2) {
                arrayList.add(next.getKey());
            }
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            map.remove(arrayList.get(i2));
        }
    }

    private BaseUrl k(List<BaseUrl> list) {
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            i2 += list.get(i3).f6048d;
        }
        int nextInt = this.f5906d.nextInt(i2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            BaseUrl baseUrl = list.get(i5);
            i4 += baseUrl.f6048d;
            if (nextInt < i4) {
                return baseUrl;
            }
        }
        return (BaseUrl) Iterables.d(list);
    }

    public void e(BaseUrl baseUrl, long j2) {
        long elapsedRealtime = SystemClock.elapsedRealtime() + j2;
        b(baseUrl.f6046b, elapsedRealtime, this.f5903a);
        int i2 = baseUrl.f6047c;
        if (i2 != Integer.MIN_VALUE) {
            b(Integer.valueOf(i2), elapsedRealtime, this.f5904b);
        }
    }

    public int g(List<BaseUrl> list) {
        HashSet hashSet = new HashSet();
        List<BaseUrl> c2 = c(list);
        for (int i2 = 0; i2 < c2.size(); i2++) {
            hashSet.add(Integer.valueOf(c2.get(i2).f6047c));
        }
        return hashSet.size();
    }

    public void i() {
        this.f5903a.clear();
        this.f5904b.clear();
        this.f5905c.clear();
    }

    public BaseUrl j(List<BaseUrl> list) {
        List<BaseUrl> c2 = c(list);
        if (c2.size() < 2) {
            return (BaseUrl) Iterables.c(c2, null);
        }
        Collections.sort(c2, new a());
        ArrayList arrayList = new ArrayList();
        int i2 = c2.get(0).f6047c;
        int i3 = 0;
        while (true) {
            if (i3 >= c2.size()) {
                break;
            }
            BaseUrl baseUrl = c2.get(i3);
            if (i2 == baseUrl.f6047c) {
                arrayList.add(new Pair(baseUrl.f6046b, Integer.valueOf(baseUrl.f6048d)));
                i3++;
            } else if (arrayList.size() == 1) {
                return c2.get(0);
            }
        }
        BaseUrl baseUrl2 = this.f5905c.get(arrayList);
        if (baseUrl2 != null) {
            return baseUrl2;
        }
        BaseUrl k2 = k(c2.subList(0, arrayList.size()));
        this.f5905c.put(arrayList, k2);
        return k2;
    }

    BaseUrlExclusionList(Random random) {
        this.f5905c = new HashMap();
        this.f5906d = random;
        this.f5903a = new HashMap();
        this.f5904b = new HashMap();
    }
}
