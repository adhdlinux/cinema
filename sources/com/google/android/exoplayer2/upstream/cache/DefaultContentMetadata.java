package com.google.android.exoplayer2.upstream.cache;

import com.google.common.base.Charsets;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class DefaultContentMetadata implements ContentMetadata {

    /* renamed from: c  reason: collision with root package name */
    public static final DefaultContentMetadata f28624c = new DefaultContentMetadata(Collections.emptyMap());

    /* renamed from: a  reason: collision with root package name */
    private int f28625a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, byte[]> f28626b;

    public DefaultContentMetadata() {
        this(Collections.emptyMap());
    }

    private static void c(HashMap<String, byte[]> hashMap, Map<String, Object> map) {
        for (Map.Entry next : map.entrySet()) {
            hashMap.put((String) next.getKey(), g(next.getValue()));
        }
    }

    private static Map<String, byte[]> d(Map<String, byte[]> map, ContentMetadataMutations contentMetadataMutations) {
        HashMap hashMap = new HashMap(map);
        i(hashMap, contentMetadataMutations.c());
        c(hashMap, contentMetadataMutations.b());
        return hashMap;
    }

    private static byte[] g(Object obj) {
        if (obj instanceof Long) {
            return ByteBuffer.allocate(8).putLong(((Long) obj).longValue()).array();
        }
        if (obj instanceof String) {
            return ((String) obj).getBytes(Charsets.UTF_8);
        }
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        throw new IllegalArgumentException();
    }

    private static boolean h(Map<String, byte[]> map, Map<String, byte[]> map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry next : map.entrySet()) {
            if (!Arrays.equals((byte[]) next.getValue(), map2.get(next.getKey()))) {
                return false;
            }
        }
        return true;
    }

    private static void i(HashMap<String, byte[]> hashMap, List<String> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            hashMap.remove(list.get(i2));
        }
    }

    public final long a(String str, long j2) {
        byte[] bArr = this.f28626b.get(str);
        if (bArr != null) {
            return ByteBuffer.wrap(bArr).getLong();
        }
        return j2;
    }

    public final String b(String str, String str2) {
        byte[] bArr = this.f28626b.get(str);
        if (bArr != null) {
            return new String(bArr, Charsets.UTF_8);
        }
        return str2;
    }

    public DefaultContentMetadata e(ContentMetadataMutations contentMetadataMutations) {
        Map<String, byte[]> d2 = d(this.f28626b, contentMetadataMutations);
        if (h(this.f28626b, d2)) {
            return this;
        }
        return new DefaultContentMetadata(d2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DefaultContentMetadata.class != obj.getClass()) {
            return false;
        }
        return h(this.f28626b, ((DefaultContentMetadata) obj).f28626b);
    }

    public Set<Map.Entry<String, byte[]>> f() {
        return this.f28626b.entrySet();
    }

    public int hashCode() {
        if (this.f28625a == 0) {
            int i2 = 0;
            for (Map.Entry next : this.f28626b.entrySet()) {
                i2 += Arrays.hashCode((byte[]) next.getValue()) ^ ((String) next.getKey()).hashCode();
            }
            this.f28625a = i2;
        }
        return this.f28625a;
    }

    public DefaultContentMetadata(Map<String, byte[]> map) {
        this.f28626b = Collections.unmodifiableMap(map);
    }
}
