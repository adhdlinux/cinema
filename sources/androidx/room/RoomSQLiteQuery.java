package androidx.room;

import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class RoomSQLiteQuery implements SupportSQLiteQuery, SupportSQLiteProgram {

    /* renamed from: j  reason: collision with root package name */
    static final TreeMap<Integer, RoomSQLiteQuery> f11492j = new TreeMap<>();

    /* renamed from: b  reason: collision with root package name */
    private volatile String f11493b;

    /* renamed from: c  reason: collision with root package name */
    final long[] f11494c;

    /* renamed from: d  reason: collision with root package name */
    final double[] f11495d;

    /* renamed from: e  reason: collision with root package name */
    final String[] f11496e;

    /* renamed from: f  reason: collision with root package name */
    final byte[][] f11497f;

    /* renamed from: g  reason: collision with root package name */
    private final int[] f11498g;

    /* renamed from: h  reason: collision with root package name */
    final int f11499h;

    /* renamed from: i  reason: collision with root package name */
    int f11500i;

    private RoomSQLiteQuery(int i2) {
        this.f11499h = i2;
        int i3 = i2 + 1;
        this.f11498g = new int[i3];
        this.f11494c = new long[i3];
        this.f11495d = new double[i3];
        this.f11496e = new String[i3];
        this.f11497f = new byte[i3][];
    }

    public static RoomSQLiteQuery i(String str, int i2) {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = f11492j;
        synchronized (treeMap) {
            Map.Entry<Integer, RoomSQLiteQuery> ceilingEntry = treeMap.ceilingEntry(Integer.valueOf(i2));
            if (ceilingEntry != null) {
                treeMap.remove(ceilingEntry.getKey());
                RoomSQLiteQuery value = ceilingEntry.getValue();
                value.k(str, i2);
                return value;
            }
            RoomSQLiteQuery roomSQLiteQuery = new RoomSQLiteQuery(i2);
            roomSQLiteQuery.k(str, i2);
            return roomSQLiteQuery;
        }
    }

    private static void q() {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = f11492j;
        if (treeMap.size() > 15) {
            int size = treeMap.size() - 10;
            Iterator<Integer> it2 = treeMap.descendingKeySet().iterator();
            while (true) {
                int i2 = size - 1;
                if (size > 0) {
                    it2.next();
                    it2.remove();
                    size = i2;
                } else {
                    return;
                }
            }
        }
    }

    public void R(int i2, String str) {
        this.f11498g[i2] = 4;
        this.f11496e[i2] = str;
    }

    public void X(int i2, long j2) {
        this.f11498g[i2] = 2;
        this.f11494c[i2] = j2;
    }

    public void Y(int i2, byte[] bArr) {
        this.f11498g[i2] = 5;
        this.f11497f[i2] = bArr;
    }

    public String a() {
        return this.f11493b;
    }

    public void close() {
    }

    public void d0(int i2) {
        this.f11498g[i2] = 1;
    }

    public void f(SupportSQLiteProgram supportSQLiteProgram) {
        for (int i2 = 1; i2 <= this.f11500i; i2++) {
            int i3 = this.f11498g[i2];
            if (i3 == 1) {
                supportSQLiteProgram.d0(i2);
            } else if (i3 == 2) {
                supportSQLiteProgram.X(i2, this.f11494c[i2]);
            } else if (i3 == 3) {
                supportSQLiteProgram.l(i2, this.f11495d[i2]);
            } else if (i3 == 4) {
                supportSQLiteProgram.R(i2, this.f11496e[i2]);
            } else if (i3 == 5) {
                supportSQLiteProgram.Y(i2, this.f11497f[i2]);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void k(String str, int i2) {
        this.f11493b = str;
        this.f11500i = i2;
    }

    public void l(int i2, double d2) {
        this.f11498g[i2] = 3;
        this.f11495d[i2] = d2;
    }

    public void release() {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = f11492j;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.f11499h), this);
            q();
        }
    }
}
