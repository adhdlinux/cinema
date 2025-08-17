package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class ScriptTagPayloadReader extends TagPayloadReader {

    /* renamed from: b  reason: collision with root package name */
    private long f24381b = -9223372036854775807L;

    /* renamed from: c  reason: collision with root package name */
    private long[] f24382c = new long[0];

    /* renamed from: d  reason: collision with root package name */
    private long[] f24383d = new long[0];

    public ScriptTagPayloadReader() {
        super(new DummyTrackOutput());
    }

    private static Boolean g(ParsableByteArray parsableByteArray) {
        boolean z2 = true;
        if (parsableByteArray.H() != 1) {
            z2 = false;
        }
        return Boolean.valueOf(z2);
    }

    private static Object h(ParsableByteArray parsableByteArray, int i2) {
        if (i2 == 0) {
            return j(parsableByteArray);
        }
        if (i2 == 1) {
            return g(parsableByteArray);
        }
        if (i2 == 2) {
            return n(parsableByteArray);
        }
        if (i2 == 3) {
            return l(parsableByteArray);
        }
        if (i2 == 8) {
            return k(parsableByteArray);
        }
        if (i2 == 10) {
            return m(parsableByteArray);
        }
        if (i2 != 11) {
            return null;
        }
        return i(parsableByteArray);
    }

    private static Date i(ParsableByteArray parsableByteArray) {
        Date date = new Date((long) j(parsableByteArray).doubleValue());
        parsableByteArray.V(2);
        return date;
    }

    private static Double j(ParsableByteArray parsableByteArray) {
        return Double.valueOf(Double.longBitsToDouble(parsableByteArray.A()));
    }

    private static HashMap<String, Object> k(ParsableByteArray parsableByteArray) {
        int L = parsableByteArray.L();
        HashMap<String, Object> hashMap = new HashMap<>(L);
        for (int i2 = 0; i2 < L; i2++) {
            String n2 = n(parsableByteArray);
            Object h2 = h(parsableByteArray, o(parsableByteArray));
            if (h2 != null) {
                hashMap.put(n2, h2);
            }
        }
        return hashMap;
    }

    private static HashMap<String, Object> l(ParsableByteArray parsableByteArray) {
        HashMap<String, Object> hashMap = new HashMap<>();
        while (true) {
            String n2 = n(parsableByteArray);
            int o2 = o(parsableByteArray);
            if (o2 == 9) {
                return hashMap;
            }
            Object h2 = h(parsableByteArray, o2);
            if (h2 != null) {
                hashMap.put(n2, h2);
            }
        }
    }

    private static ArrayList<Object> m(ParsableByteArray parsableByteArray) {
        int L = parsableByteArray.L();
        ArrayList<Object> arrayList = new ArrayList<>(L);
        for (int i2 = 0; i2 < L; i2++) {
            Object h2 = h(parsableByteArray, o(parsableByteArray));
            if (h2 != null) {
                arrayList.add(h2);
            }
        }
        return arrayList;
    }

    private static String n(ParsableByteArray parsableByteArray) {
        int N = parsableByteArray.N();
        int f2 = parsableByteArray.f();
        parsableByteArray.V(N);
        return new String(parsableByteArray.e(), f2, N);
    }

    private static int o(ParsableByteArray parsableByteArray) {
        return parsableByteArray.H();
    }

    /* access modifiers changed from: protected */
    public boolean b(ParsableByteArray parsableByteArray) {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean c(ParsableByteArray parsableByteArray, long j2) {
        if (o(parsableByteArray) != 2 || !"onMetaData".equals(n(parsableByteArray)) || parsableByteArray.a() == 0 || o(parsableByteArray) != 8) {
            return false;
        }
        HashMap<String, Object> k2 = k(parsableByteArray);
        Object obj = k2.get("duration");
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            if (doubleValue > 0.0d) {
                this.f24381b = (long) (doubleValue * 1000000.0d);
            }
        }
        Object obj2 = k2.get("keyframes");
        if (obj2 instanceof Map) {
            Map map = (Map) obj2;
            Object obj3 = map.get("filepositions");
            Object obj4 = map.get("times");
            if ((obj3 instanceof List) && (obj4 instanceof List)) {
                List list = (List) obj3;
                List list2 = (List) obj4;
                int size = list2.size();
                this.f24382c = new long[size];
                this.f24383d = new long[size];
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    Object obj5 = list.get(i2);
                    Object obj6 = list2.get(i2);
                    if (!(obj6 instanceof Double) || !(obj5 instanceof Double)) {
                        this.f24382c = new long[0];
                        this.f24383d = new long[0];
                    } else {
                        this.f24382c[i2] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                        this.f24383d[i2] = ((Double) obj5).longValue();
                        i2++;
                    }
                }
                this.f24382c = new long[0];
                this.f24383d = new long[0];
            }
        }
        return false;
    }

    public long d() {
        return this.f24381b;
    }

    public long[] e() {
        return this.f24383d;
    }

    public long[] f() {
        return this.f24382c;
    }
}
