package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.os.Build;
import com.bumptech.glide.util.Util;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class SizeConfigStrategy implements LruPoolStrategy {

    /* renamed from: d  reason: collision with root package name */
    private static final Bitmap.Config[] f16610d;

    /* renamed from: e  reason: collision with root package name */
    private static final Bitmap.Config[] f16611e;

    /* renamed from: f  reason: collision with root package name */
    private static final Bitmap.Config[] f16612f = {Bitmap.Config.RGB_565};

    /* renamed from: g  reason: collision with root package name */
    private static final Bitmap.Config[] f16613g = {Bitmap.Config.ARGB_4444};

    /* renamed from: h  reason: collision with root package name */
    private static final Bitmap.Config[] f16614h = {Bitmap.Config.ALPHA_8};

    /* renamed from: a  reason: collision with root package name */
    private final KeyPool f16615a = new KeyPool();

    /* renamed from: b  reason: collision with root package name */
    private final GroupedLinkedMap<Key, Bitmap> f16616b = new GroupedLinkedMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> f16617c = new HashMap();

    /* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f16618a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                android.graphics.Bitmap$Config[] r0 = android.graphics.Bitmap.Config.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f16618a = r0
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f16618a     // Catch:{ NoSuchFieldError -> 0x001d }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f16618a     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_4444     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f16618a     // Catch:{ NoSuchFieldError -> 0x0033 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ALPHA_8     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy.AnonymousClass1.<clinit>():void");
        }
    }

    static final class Key implements Poolable {

        /* renamed from: a  reason: collision with root package name */
        private final KeyPool f16619a;

        /* renamed from: b  reason: collision with root package name */
        int f16620b;

        /* renamed from: c  reason: collision with root package name */
        private Bitmap.Config f16621c;

        public Key(KeyPool keyPool) {
            this.f16619a = keyPool;
        }

        public void a() {
            this.f16619a.c(this);
        }

        public void b(int i2, Bitmap.Config config) {
            this.f16620b = i2;
            this.f16621c = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            if (this.f16620b != key.f16620b || !Util.c(this.f16621c, key.f16621c)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i2;
            int i3 = this.f16620b * 31;
            Bitmap.Config config = this.f16621c;
            if (config != null) {
                i2 = config.hashCode();
            } else {
                i2 = 0;
            }
            return i3 + i2;
        }

        public String toString() {
            return SizeConfigStrategy.h(this.f16620b, this.f16621c);
        }
    }

    static class KeyPool extends BaseKeyPool<Key> {
        KeyPool() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public Key a() {
            return new Key(this);
        }

        public Key e(int i2, Bitmap.Config config) {
            Key key = (Key) b();
            key.b(i2, config);
            return key;
        }
    }

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        f16610d = configArr;
        f16611e = configArr;
    }

    private void f(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> j2 = j(bitmap.getConfig());
        Integer num2 = j2.get(num);
        if (num2 == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + a(bitmap) + ", this: " + this);
        } else if (num2.intValue() == 1) {
            j2.remove(num);
        } else {
            j2.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    private Key g(int i2, Bitmap.Config config) {
        Key e2 = this.f16615a.e(i2, config);
        Bitmap.Config[] i3 = i(config);
        int length = i3.length;
        int i4 = 0;
        while (i4 < length) {
            Bitmap.Config config2 = i3[i4];
            Integer ceilingKey = j(config2).ceilingKey(Integer.valueOf(i2));
            if (ceilingKey == null || ceilingKey.intValue() > i2 * 8) {
                i4++;
            } else {
                if (ceilingKey.intValue() == i2) {
                    if (config2 == null) {
                        if (config == null) {
                            return e2;
                        }
                    } else if (config2.equals(config)) {
                        return e2;
                    }
                }
                this.f16615a.c(e2);
                return this.f16615a.e(ceilingKey.intValue(), config2);
            }
        }
        return e2;
    }

    static String h(int i2, Bitmap.Config config) {
        return "[" + i2 + "](" + config + ")";
    }

    private static Bitmap.Config[] i(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(config)) {
            return f16611e;
        }
        int i2 = AnonymousClass1.f16618a[config.ordinal()];
        if (i2 == 1) {
            return f16610d;
        }
        if (i2 == 2) {
            return f16612f;
        }
        if (i2 == 3) {
            return f16613g;
        }
        if (i2 == 4) {
            return f16614h;
        }
        return new Bitmap.Config[]{config};
    }

    private NavigableMap<Integer, Integer> j(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.f16617c.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f16617c.put(config, treeMap);
        return treeMap;
    }

    public String a(Bitmap bitmap) {
        return h(Util.g(bitmap), bitmap.getConfig());
    }

    public String b(int i2, int i3, Bitmap.Config config) {
        return h(Util.f(i2, i3, config), config);
    }

    public void c(Bitmap bitmap) {
        Key e2 = this.f16615a.e(Util.g(bitmap), bitmap.getConfig());
        this.f16616b.d(e2, bitmap);
        NavigableMap<Integer, Integer> j2 = j(bitmap.getConfig());
        Integer num = j2.get(Integer.valueOf(e2.f16620b));
        Integer valueOf = Integer.valueOf(e2.f16620b);
        int i2 = 1;
        if (num != null) {
            i2 = 1 + num.intValue();
        }
        j2.put(valueOf, Integer.valueOf(i2));
    }

    public Bitmap d(int i2, int i3, Bitmap.Config config) {
        Key g2 = g(Util.f(i2, i3, config), config);
        Bitmap a2 = this.f16616b.a(g2);
        if (a2 != null) {
            f(Integer.valueOf(g2.f16620b), a2);
            a2.reconfigure(i2, i3, config);
        }
        return a2;
    }

    public int e(Bitmap bitmap) {
        return Util.g(bitmap);
    }

    public Bitmap removeLast() {
        Bitmap f2 = this.f16616b.f();
        if (f2 != null) {
            f(Integer.valueOf(Util.g(f2)), f2);
        }
        return f2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.f16616b);
        sb.append(", sortedSizes=(");
        for (Map.Entry next : this.f16617c.entrySet()) {
            sb.append(next.getKey());
            sb.append('[');
            sb.append(next.getValue());
            sb.append("], ");
        }
        if (!this.f16617c.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }
}
