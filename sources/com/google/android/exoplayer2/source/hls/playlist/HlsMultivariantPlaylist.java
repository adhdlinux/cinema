package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.offline.StreamKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class HlsMultivariantPlaylist extends HlsPlaylist {

    /* renamed from: n  reason: collision with root package name */
    public static final HlsMultivariantPlaylist f26624n = new HlsMultivariantPlaylist("", Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), (Format) null, Collections.emptyList(), false, Collections.emptyMap(), Collections.emptyList());

    /* renamed from: d  reason: collision with root package name */
    public final List<Uri> f26625d;

    /* renamed from: e  reason: collision with root package name */
    public final List<Variant> f26626e;

    /* renamed from: f  reason: collision with root package name */
    public final List<Rendition> f26627f;

    /* renamed from: g  reason: collision with root package name */
    public final List<Rendition> f26628g;

    /* renamed from: h  reason: collision with root package name */
    public final List<Rendition> f26629h;

    /* renamed from: i  reason: collision with root package name */
    public final List<Rendition> f26630i;

    /* renamed from: j  reason: collision with root package name */
    public final Format f26631j;

    /* renamed from: k  reason: collision with root package name */
    public final List<Format> f26632k;

    /* renamed from: l  reason: collision with root package name */
    public final Map<String, String> f26633l;

    /* renamed from: m  reason: collision with root package name */
    public final List<DrmInitData> f26634m;

    public static final class Rendition {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f26635a;

        /* renamed from: b  reason: collision with root package name */
        public final Format f26636b;

        /* renamed from: c  reason: collision with root package name */
        public final String f26637c;

        /* renamed from: d  reason: collision with root package name */
        public final String f26638d;

        public Rendition(Uri uri, Format format, String str, String str2) {
            this.f26635a = uri;
            this.f26636b = format;
            this.f26637c = str;
            this.f26638d = str2;
        }
    }

    public static final class Variant {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f26639a;

        /* renamed from: b  reason: collision with root package name */
        public final Format f26640b;

        /* renamed from: c  reason: collision with root package name */
        public final String f26641c;

        /* renamed from: d  reason: collision with root package name */
        public final String f26642d;

        /* renamed from: e  reason: collision with root package name */
        public final String f26643e;

        /* renamed from: f  reason: collision with root package name */
        public final String f26644f;

        public Variant(Uri uri, Format format, String str, String str2, String str3, String str4) {
            this.f26639a = uri;
            this.f26640b = format;
            this.f26641c = str;
            this.f26642d = str2;
            this.f26643e = str3;
            this.f26644f = str4;
        }

        public static Variant b(Uri uri) {
            return new Variant(uri, new Format.Builder().U("0").M("application/x-mpegURL").G(), (String) null, (String) null, (String) null, (String) null);
        }

        public Variant a(Format format) {
            return new Variant(this.f26639a, format, this.f26641c, this.f26642d, this.f26643e, this.f26644f);
        }
    }

    public HlsMultivariantPlaylist(String str, List<String> list, List<Variant> list2, List<Rendition> list3, List<Rendition> list4, List<Rendition> list5, List<Rendition> list6, Format format, List<Format> list7, boolean z2, Map<String, String> map, List<DrmInitData> list8) {
        super(str, list, z2);
        List<Format> list9;
        this.f26625d = Collections.unmodifiableList(f(list2, list3, list4, list5, list6));
        this.f26626e = Collections.unmodifiableList(list2);
        this.f26627f = Collections.unmodifiableList(list3);
        this.f26628g = Collections.unmodifiableList(list4);
        this.f26629h = Collections.unmodifiableList(list5);
        this.f26630i = Collections.unmodifiableList(list6);
        this.f26631j = format;
        if (list7 != null) {
            list9 = Collections.unmodifiableList(list7);
        } else {
            list9 = null;
        }
        this.f26632k = list9;
        this.f26633l = Collections.unmodifiableMap(map);
        this.f26634m = Collections.unmodifiableList(list8);
    }

    private static void b(List<Rendition> list, List<Uri> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            Uri uri = list.get(i2).f26635a;
            if (uri != null && !list2.contains(uri)) {
                list2.add(uri);
            }
        }
    }

    private static <T> List<T> d(List<T> list, int i2, List<StreamKey> list2) {
        ArrayList arrayList = new ArrayList(list2.size());
        for (int i3 = 0; i3 < list.size(); i3++) {
            T t2 = list.get(i3);
            int i4 = 0;
            while (true) {
                if (i4 >= list2.size()) {
                    break;
                }
                StreamKey streamKey = list2.get(i4);
                if (streamKey.f25637c == i2 && streamKey.f25638d == i3) {
                    arrayList.add(t2);
                    break;
                }
                i4++;
            }
        }
        return arrayList;
    }

    public static HlsMultivariantPlaylist e(String str) {
        return new HlsMultivariantPlaylist("", Collections.emptyList(), Collections.singletonList(Variant.b(Uri.parse(str))), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), (Format) null, (List<Format>) null, false, Collections.emptyMap(), Collections.emptyList());
    }

    private static List<Uri> f(List<Variant> list, List<Rendition> list2, List<Rendition> list3, List<Rendition> list4, List<Rendition> list5) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            Uri uri = list.get(i2).f26639a;
            if (!arrayList.contains(uri)) {
                arrayList.add(uri);
            }
        }
        b(list2, arrayList);
        b(list3, arrayList);
        b(list4, arrayList);
        b(list5, arrayList);
        return arrayList;
    }

    /* renamed from: c */
    public HlsMultivariantPlaylist a(List<StreamKey> list) {
        return new HlsMultivariantPlaylist(this.f26645a, this.f26646b, d(this.f26626e, 0, list), Collections.emptyList(), d(this.f26628g, 1, list), d(this.f26629h, 2, list), Collections.emptyList(), this.f26631j, this.f26632k, this.f26647c, this.f26633l, this.f26634m);
    }
}
