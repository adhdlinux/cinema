package androidx.media3.exoplayer.hls.playlist;

import android.net.Uri;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.StreamKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class HlsMultivariantPlaylist extends HlsPlaylist {

    /* renamed from: n  reason: collision with root package name */
    public static final HlsMultivariantPlaylist f6541n = new HlsMultivariantPlaylist("", Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), (Format) null, Collections.emptyList(), false, Collections.emptyMap(), Collections.emptyList());

    /* renamed from: d  reason: collision with root package name */
    public final List<Uri> f6542d;

    /* renamed from: e  reason: collision with root package name */
    public final List<Variant> f6543e;

    /* renamed from: f  reason: collision with root package name */
    public final List<Rendition> f6544f;

    /* renamed from: g  reason: collision with root package name */
    public final List<Rendition> f6545g;

    /* renamed from: h  reason: collision with root package name */
    public final List<Rendition> f6546h;

    /* renamed from: i  reason: collision with root package name */
    public final List<Rendition> f6547i;

    /* renamed from: j  reason: collision with root package name */
    public final Format f6548j;

    /* renamed from: k  reason: collision with root package name */
    public final List<Format> f6549k;

    /* renamed from: l  reason: collision with root package name */
    public final Map<String, String> f6550l;

    /* renamed from: m  reason: collision with root package name */
    public final List<DrmInitData> f6551m;

    public static final class Rendition {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f6552a;

        /* renamed from: b  reason: collision with root package name */
        public final Format f6553b;

        /* renamed from: c  reason: collision with root package name */
        public final String f6554c;

        /* renamed from: d  reason: collision with root package name */
        public final String f6555d;

        public Rendition(Uri uri, Format format, String str, String str2) {
            this.f6552a = uri;
            this.f6553b = format;
            this.f6554c = str;
            this.f6555d = str2;
        }
    }

    public static final class Variant {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f6556a;

        /* renamed from: b  reason: collision with root package name */
        public final Format f6557b;

        /* renamed from: c  reason: collision with root package name */
        public final String f6558c;

        /* renamed from: d  reason: collision with root package name */
        public final String f6559d;

        /* renamed from: e  reason: collision with root package name */
        public final String f6560e;

        /* renamed from: f  reason: collision with root package name */
        public final String f6561f;

        public Variant(Uri uri, Format format, String str, String str2, String str3, String str4) {
            this.f6556a = uri;
            this.f6557b = format;
            this.f6558c = str;
            this.f6559d = str2;
            this.f6560e = str3;
            this.f6561f = str4;
        }

        public static Variant b(Uri uri) {
            return new Variant(uri, new Format.Builder().a0("0").Q("application/x-mpegURL").K(), (String) null, (String) null, (String) null, (String) null);
        }

        public Variant a(Format format) {
            return new Variant(this.f6556a, format, this.f6558c, this.f6559d, this.f6560e, this.f6561f);
        }
    }

    public HlsMultivariantPlaylist(String str, List<String> list, List<Variant> list2, List<Rendition> list3, List<Rendition> list4, List<Rendition> list5, List<Rendition> list6, Format format, List<Format> list7, boolean z2, Map<String, String> map, List<DrmInitData> list8) {
        super(str, list, z2);
        List<Format> list9;
        this.f6542d = Collections.unmodifiableList(f(list2, list3, list4, list5, list6));
        this.f6543e = Collections.unmodifiableList(list2);
        this.f6544f = Collections.unmodifiableList(list3);
        this.f6545g = Collections.unmodifiableList(list4);
        this.f6546h = Collections.unmodifiableList(list5);
        this.f6547i = Collections.unmodifiableList(list6);
        this.f6548j = format;
        if (list7 != null) {
            list9 = Collections.unmodifiableList(list7);
        } else {
            list9 = null;
        }
        this.f6549k = list9;
        this.f6550l = Collections.unmodifiableMap(map);
        this.f6551m = Collections.unmodifiableList(list8);
    }

    private static void b(List<Rendition> list, List<Uri> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            Uri uri = list.get(i2).f6552a;
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
                if (streamKey.f4340c == i2 && streamKey.f4341d == i3) {
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
            Uri uri = list.get(i2).f6556a;
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
        return new HlsMultivariantPlaylist(this.f6562a, this.f6563b, d(this.f6543e, 0, list), Collections.emptyList(), d(this.f6545g, 1, list), d(this.f6546h, 2, list), Collections.emptyList(), this.f6548j, this.f6549k, this.f6564c, this.f6550l, this.f6551m);
    }
}
