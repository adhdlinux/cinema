package com.google.android.exoplayer2.text.ttml;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import com.facebook.common.callercontext.ContextChain;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

final class TtmlNode {

    /* renamed from: a  reason: collision with root package name */
    public final String f27512a;

    /* renamed from: b  reason: collision with root package name */
    public final String f27513b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f27514c;

    /* renamed from: d  reason: collision with root package name */
    public final long f27515d;

    /* renamed from: e  reason: collision with root package name */
    public final long f27516e;

    /* renamed from: f  reason: collision with root package name */
    public final TtmlStyle f27517f;

    /* renamed from: g  reason: collision with root package name */
    private final String[] f27518g;

    /* renamed from: h  reason: collision with root package name */
    public final String f27519h;

    /* renamed from: i  reason: collision with root package name */
    public final String f27520i;

    /* renamed from: j  reason: collision with root package name */
    public final TtmlNode f27521j;

    /* renamed from: k  reason: collision with root package name */
    private final HashMap<String, Integer> f27522k;

    /* renamed from: l  reason: collision with root package name */
    private final HashMap<String, Integer> f27523l;

    /* renamed from: m  reason: collision with root package name */
    private List<TtmlNode> f27524m;

    private TtmlNode(String str, String str2, long j2, long j3, TtmlStyle ttmlStyle, String[] strArr, String str3, String str4, TtmlNode ttmlNode) {
        boolean z2;
        this.f27512a = str;
        this.f27513b = str2;
        this.f27520i = str4;
        this.f27517f = ttmlStyle;
        this.f27518g = strArr;
        if (str2 != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f27514c = z2;
        this.f27515d = j2;
        this.f27516e = j3;
        this.f27519h = (String) Assertions.e(str3);
        this.f27521j = ttmlNode;
        this.f27522k = new HashMap<>();
        this.f27523l = new HashMap<>();
    }

    private void b(Map<String, TtmlStyle> map, Cue.Builder builder, int i2, int i3, int i4) {
        TtmlStyle f2 = TtmlRenderUtil.f(this.f27517f, this.f27518g, map);
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) builder.e();
        if (spannableStringBuilder == null) {
            spannableStringBuilder = new SpannableStringBuilder();
            builder.o(spannableStringBuilder);
        }
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        if (f2 != null) {
            TtmlRenderUtil.a(spannableStringBuilder2, i2, i3, f2, this.f27521j, map, i4);
            if (ContextChain.TAG_PRODUCT.equals(this.f27512a)) {
                if (f2.k() != Float.MAX_VALUE) {
                    builder.m((f2.k() * -90.0f) / 100.0f);
                }
                if (f2.m() != null) {
                    builder.p(f2.m());
                }
                if (f2.h() != null) {
                    builder.j(f2.h());
                }
            }
        }
    }

    public static TtmlNode c(String str, long j2, long j3, TtmlStyle ttmlStyle, String[] strArr, String str2, String str3, TtmlNode ttmlNode) {
        return new TtmlNode(str, (String) null, j2, j3, ttmlStyle, strArr, str2, str3, ttmlNode);
    }

    public static TtmlNode d(String str) {
        return new TtmlNode((String) null, TtmlRenderUtil.b(str), -9223372036854775807L, -9223372036854775807L, (TtmlStyle) null, (String[]) null, "", (String) null, (TtmlNode) null);
    }

    private static void e(SpannableStringBuilder spannableStringBuilder) {
        for (DeleteTextSpan deleteTextSpan : (DeleteTextSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), DeleteTextSpan.class)) {
            spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(deleteTextSpan), spannableStringBuilder.getSpanEnd(deleteTextSpan), "");
        }
        for (int i2 = 0; i2 < spannableStringBuilder.length(); i2++) {
            if (spannableStringBuilder.charAt(i2) == ' ') {
                int i3 = i2 + 1;
                int i4 = i3;
                while (i4 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i4) == ' ') {
                    i4++;
                }
                int i5 = i4 - i3;
                if (i5 > 0) {
                    spannableStringBuilder.delete(i2, i5 + i2);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
        }
        for (int i6 = 0; i6 < spannableStringBuilder.length() - 1; i6++) {
            if (spannableStringBuilder.charAt(i6) == 10) {
                int i7 = i6 + 1;
                if (spannableStringBuilder.charAt(i7) == ' ') {
                    spannableStringBuilder.delete(i7, i6 + 2);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
            spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        }
        for (int i8 = 0; i8 < spannableStringBuilder.length() - 1; i8++) {
            if (spannableStringBuilder.charAt(i8) == ' ') {
                int i9 = i8 + 1;
                if (spannableStringBuilder.charAt(i9) == 10) {
                    spannableStringBuilder.delete(i8, i9);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == 10) {
            spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        }
    }

    private void i(TreeSet<Long> treeSet, boolean z2) {
        boolean z3;
        boolean equals = ContextChain.TAG_PRODUCT.equals(this.f27512a);
        boolean equals2 = "div".equals(this.f27512a);
        if (z2 || equals || (equals2 && this.f27520i != null)) {
            long j2 = this.f27515d;
            if (j2 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j2));
            }
            long j3 = this.f27516e;
            if (j3 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j3));
            }
        }
        if (this.f27524m != null) {
            for (int i2 = 0; i2 < this.f27524m.size(); i2++) {
                TtmlNode ttmlNode = this.f27524m.get(i2);
                if (z2 || equals) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                ttmlNode.i(treeSet, z3);
            }
        }
    }

    private static SpannableStringBuilder k(String str, Map<String, Cue.Builder> map) {
        if (!map.containsKey(str)) {
            Cue.Builder builder = new Cue.Builder();
            builder.o(new SpannableStringBuilder());
            map.put(str, builder);
        }
        return (SpannableStringBuilder) Assertions.e(map.get(str).e());
    }

    private void n(long j2, String str, List<Pair<String, String>> list) {
        if (!"".equals(this.f27519h)) {
            str = this.f27519h;
        }
        if (!m(j2) || !"div".equals(this.f27512a) || this.f27520i == null) {
            for (int i2 = 0; i2 < g(); i2++) {
                f(i2).n(j2, str, list);
            }
            return;
        }
        list.add(new Pair(str, this.f27520i));
    }

    private void o(long j2, Map<String, TtmlStyle> map, Map<String, TtmlRegion> map2, String str, Map<String, Cue.Builder> map3) {
        String str2;
        int i2;
        int i3;
        if (m(j2)) {
            if ("".equals(this.f27519h)) {
                str2 = str;
            } else {
                str2 = this.f27519h;
            }
            Iterator<Map.Entry<String, Integer>> it2 = this.f27523l.entrySet().iterator();
            while (true) {
                i2 = 0;
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry next = it2.next();
                String str3 = (String) next.getKey();
                if (this.f27522k.containsKey(str3)) {
                    i3 = this.f27522k.get(str3).intValue();
                } else {
                    i3 = 0;
                }
                int intValue = ((Integer) next.getValue()).intValue();
                if (i3 != intValue) {
                    Map<String, TtmlStyle> map4 = map;
                    b(map4, (Cue.Builder) Assertions.e(map3.get(str3)), i3, intValue, ((TtmlRegion) Assertions.e(map2.get(str2))).f27534j);
                } else {
                    Map<String, TtmlRegion> map5 = map2;
                    Map<String, Cue.Builder> map6 = map3;
                }
            }
            Map<String, TtmlRegion> map7 = map2;
            Map<String, Cue.Builder> map8 = map3;
            while (i2 < g()) {
                f(i2).o(j2, map, map2, str2, map3);
                i2++;
                Map<String, TtmlRegion> map9 = map2;
            }
        }
    }

    private void p(long j2, boolean z2, String str, Map<String, Cue.Builder> map) {
        boolean z3;
        this.f27522k.clear();
        this.f27523l.clear();
        if (!"metadata".equals(this.f27512a)) {
            if (!"".equals(this.f27519h)) {
                str = this.f27519h;
            }
            if (this.f27514c && z2) {
                k(str, map).append((CharSequence) Assertions.e(this.f27513b));
            } else if ("br".equals(this.f27512a) && z2) {
                k(str, map).append(10);
            } else if (m(j2)) {
                for (Map.Entry next : map.entrySet()) {
                    this.f27522k.put((String) next.getKey(), Integer.valueOf(((CharSequence) Assertions.e(((Cue.Builder) next.getValue()).e())).length()));
                }
                boolean equals = ContextChain.TAG_PRODUCT.equals(this.f27512a);
                for (int i2 = 0; i2 < g(); i2++) {
                    TtmlNode f2 = f(i2);
                    if (z2 || equals) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    f2.p(j2, z3, str, map);
                }
                if (equals) {
                    TtmlRenderUtil.c(k(str, map));
                }
                for (Map.Entry next2 : map.entrySet()) {
                    this.f27523l.put((String) next2.getKey(), Integer.valueOf(((CharSequence) Assertions.e(((Cue.Builder) next2.getValue()).e())).length()));
                }
            }
        }
    }

    public void a(TtmlNode ttmlNode) {
        if (this.f27524m == null) {
            this.f27524m = new ArrayList();
        }
        this.f27524m.add(ttmlNode);
    }

    public TtmlNode f(int i2) {
        List<TtmlNode> list = this.f27524m;
        if (list != null) {
            return list.get(i2);
        }
        throw new IndexOutOfBoundsException();
    }

    public int g() {
        List<TtmlNode> list = this.f27524m;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<Cue> h(long j2, Map<String, TtmlStyle> map, Map<String, TtmlRegion> map2, Map<String, String> map3) {
        ArrayList<Pair> arrayList = new ArrayList<>();
        n(j2, this.f27519h, arrayList);
        TreeMap treeMap = new TreeMap();
        long j3 = j2;
        p(j3, false, this.f27519h, treeMap);
        o(j3, map, map2, this.f27519h, treeMap);
        ArrayList arrayList2 = new ArrayList();
        for (Pair pair : arrayList) {
            String str = map3.get(pair.second);
            if (str != null) {
                byte[] decode = Base64.decode(str, 0);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                TtmlRegion ttmlRegion = (TtmlRegion) Assertions.e(map2.get(pair.first));
                arrayList2.add(new Cue.Builder().f(decodeByteArray).k(ttmlRegion.f27526b).l(0).h(ttmlRegion.f27527c, 0).i(ttmlRegion.f27529e).n(ttmlRegion.f27530f).g(ttmlRegion.f27531g).r(ttmlRegion.f27534j).a());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            TtmlRegion ttmlRegion2 = (TtmlRegion) Assertions.e(map2.get(entry.getKey()));
            Cue.Builder builder = (Cue.Builder) entry.getValue();
            e((SpannableStringBuilder) Assertions.e(builder.e()));
            builder.h(ttmlRegion2.f27527c, ttmlRegion2.f27528d);
            builder.i(ttmlRegion2.f27529e);
            builder.k(ttmlRegion2.f27526b);
            builder.n(ttmlRegion2.f27530f);
            builder.q(ttmlRegion2.f27533i, ttmlRegion2.f27532h);
            builder.r(ttmlRegion2.f27534j);
            arrayList2.add(builder.a());
        }
        return arrayList2;
    }

    public long[] j() {
        TreeSet treeSet = new TreeSet();
        int i2 = 0;
        i(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it2 = treeSet.iterator();
        while (it2.hasNext()) {
            jArr[i2] = ((Long) it2.next()).longValue();
            i2++;
        }
        return jArr;
    }

    public String[] l() {
        return this.f27518g;
    }

    public boolean m(long j2) {
        long j3 = this.f27515d;
        return (j3 == -9223372036854775807L && this.f27516e == -9223372036854775807L) || (j3 <= j2 && this.f27516e == -9223372036854775807L) || ((j3 == -9223372036854775807L && j2 < this.f27516e) || (j3 <= j2 && j2 < this.f27516e));
    }
}
