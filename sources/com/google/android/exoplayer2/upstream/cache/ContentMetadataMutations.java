package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContentMetadataMutations {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Object> f28622a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f28623b = new ArrayList();

    private ContentMetadataMutations a(String str, Object obj) {
        this.f28622a.put((String) Assertions.e(str), Assertions.e(obj));
        this.f28623b.remove(str);
        return this;
    }

    public static ContentMetadataMutations g(ContentMetadataMutations contentMetadataMutations, long j2) {
        return contentMetadataMutations.e("exo_len", j2);
    }

    public static ContentMetadataMutations h(ContentMetadataMutations contentMetadataMutations, Uri uri) {
        if (uri == null) {
            return contentMetadataMutations.d("exo_redir");
        }
        return contentMetadataMutations.f("exo_redir", uri.toString());
    }

    public Map<String, Object> b() {
        HashMap hashMap = new HashMap(this.f28622a);
        for (Map.Entry entry : hashMap.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                entry.setValue(Arrays.copyOf(bArr, bArr.length));
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public List<String> c() {
        return Collections.unmodifiableList(new ArrayList(this.f28623b));
    }

    public ContentMetadataMutations d(String str) {
        this.f28623b.add(str);
        this.f28622a.remove(str);
        return this;
    }

    public ContentMetadataMutations e(String str, long j2) {
        return a(str, Long.valueOf(j2));
    }

    public ContentMetadataMutations f(String str, String str2) {
        return a(str, str2);
    }
}
