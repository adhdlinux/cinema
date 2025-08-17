package androidx.media3.extractor.text.ttml;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import com.facebook.common.callercontext.ContextChain;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

final class TtmlNode {

    /* renamed from: a  reason: collision with root package name */
    public final String f9028a;

    /* renamed from: b  reason: collision with root package name */
    public final String f9029b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f9030c;

    /* renamed from: d  reason: collision with root package name */
    public final long f9031d;

    /* renamed from: e  reason: collision with root package name */
    public final long f9032e;

    /* renamed from: f  reason: collision with root package name */
    public final TtmlStyle f9033f;

    /* renamed from: g  reason: collision with root package name */
    private final String[] f9034g;

    /* renamed from: h  reason: collision with root package name */
    public final String f9035h;

    /* renamed from: i  reason: collision with root package name */
    public final String f9036i;

    /* renamed from: j  reason: collision with root package name */
    public final TtmlNode f9037j;

    /* renamed from: k  reason: collision with root package name */
    private final HashMap<String, Integer> f9038k;

    /* renamed from: l  reason: collision with root package name */
    private final HashMap<String, Integer> f9039l;

    /* renamed from: m  reason: collision with root package name */
    private List<TtmlNode> f9040m;

    private TtmlNode(String str, String str2, long j2, long j3, TtmlStyle ttmlStyle, String[] strArr, String str3, String str4, TtmlNode ttmlNode) {
        boolean z2;
        this.f9028a = str;
        this.f9029b = str2;
        this.f9036i = str4;
        this.f9033f = ttmlStyle;
        this.f9034g = strArr;
        if (str2 != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f9030c = z2;
        this.f9031d = j2;
        this.f9032e = j3;
        this.f9035h = (String) Assertions.f(str3);
        this.f9037j = ttmlNode;
        this.f9038k = new HashMap<>();
        this.f9039l = new HashMap<>();
    }

    private void b(Map<String, TtmlStyle> map, Cue.Builder builder, int i2, int i3, int i4) {
        TtmlStyle f2 = TtmlRenderUtil.f(this.f9033f, this.f9034g, map);
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) builder.e();
        if (spannableStringBuilder == null) {
            spannableStringBuilder = new SpannableStringBuilder();
            builder.o(spannableStringBuilder);
        }
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        if (f2 != null) {
            TtmlRenderUtil.a(spannableStringBuilder2, i2, i3, f2, this.f9037j, map, i4);
            if (ContextChain.TAG_PRODUCT.equals(this.f9028a)) {
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
        boolean equals = ContextChain.TAG_PRODUCT.equals(this.f9028a);
        boolean equals2 = "div".equals(this.f9028a);
        if (z2 || equals || (equals2 && this.f9036i != null)) {
            long j2 = this.f9031d;
            if (j2 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j2));
            }
            long j3 = this.f9032e;
            if (j3 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j3));
            }
        }
        if (this.f9040m != null) {
            for (int i2 = 0; i2 < this.f9040m.size(); i2++) {
                TtmlNode ttmlNode = this.f9040m.get(i2);
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
        return (SpannableStringBuilder) Assertions.f(map.get(str).e());
    }

    private void n(long j2, String str, List<Pair<String, String>> list) {
        if (!"".equals(this.f9035h)) {
            str = this.f9035h;
        }
        if (!m(j2) || !"div".equals(this.f9028a) || this.f9036i == null) {
            for (int i2 = 0; i2 < g(); i2++) {
                f(i2).n(j2, str, list);
            }
            return;
        }
        list.add(new Pair(str, this.f9036i));
    }

    private void o(long j2, Map<String, TtmlStyle> map, Map<String, TtmlRegion> map2, String str, Map<String, Cue.Builder> map3) {
        String str2;
        int i2;
        int i3;
        if (m(j2)) {
            if ("".equals(this.f9035h)) {
                str2 = str;
            } else {
                str2 = this.f9035h;
            }
            Iterator<Map.Entry<String, Integer>> it2 = this.f9039l.entrySet().iterator();
            while (true) {
                i2 = 0;
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry next = it2.next();
                String str3 = (String) next.getKey();
                if (this.f9038k.containsKey(str3)) {
                    i3 = this.f9038k.get(str3).intValue();
                } else {
                    i3 = 0;
                }
                int intValue = ((Integer) next.getValue()).intValue();
                if (i3 != intValue) {
                    Map<String, TtmlStyle> map4 = map;
                    b(map4, (Cue.Builder) Assertions.f(map3.get(str3)), i3, intValue, ((TtmlRegion) Assertions.f(map2.get(str2))).f9064j);
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
        this.f9038k.clear();
        this.f9039l.clear();
        if (!"metadata".equals(this.f9028a)) {
            if (!"".equals(this.f9035h)) {
                str = this.f9035h;
            }
            if (this.f9030c && z2) {
                k(str, map).append((CharSequence) Assertions.f(this.f9029b));
            } else if ("br".equals(this.f9028a) && z2) {
                k(str, map).append(10);
            } else if (m(j2)) {
                for (Map.Entry next : map.entrySet()) {
                    this.f9038k.put((String) next.getKey(), Integer.valueOf(((CharSequence) Assertions.f(((Cue.Builder) next.getValue()).e())).length()));
                }
                boolean equals = ContextChain.TAG_PRODUCT.equals(this.f9028a);
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
                    this.f9039l.put((String) next2.getKey(), Integer.valueOf(((CharSequence) Assertions.f(((Cue.Builder) next2.getValue()).e())).length()));
                }
            }
        }
    }

    public void a(TtmlNode ttmlNode) {
        if (this.f9040m == null) {
            this.f9040m = new ArrayList();
        }
        this.f9040m.add(ttmlNode);
    }

    public TtmlNode f(int i2) {
        List<TtmlNode> list = this.f9040m;
        if (list != null) {
            return list.get(i2);
        }
        throw new IndexOutOfBoundsException();
    }

    public int g() {
        List<TtmlNode> list = this.f9040m;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<Cue> h(long j2, Map<String, TtmlStyle> map, Map<String, TtmlRegion> map2, Map<String, String> map3) {
        ArrayList<Pair> arrayList = new ArrayList<>();
        n(j2, this.f9035h, arrayList);
        TreeMap treeMap = new TreeMap();
        long j3 = j2;
        p(j3, false, this.f9035h, treeMap);
        o(j3, map, map2, this.f9035h, treeMap);
        ArrayList arrayList2 = new ArrayList();
        for (Pair pair : arrayList) {
            String str = map3.get(pair.second);
            if (str != null) {
                byte[] decode = Base64.decode(str, 0);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                TtmlRegion ttmlRegion = (TtmlRegion) Assertions.f(map2.get(pair.first));
                arrayList2.add(new Cue.Builder().f(decodeByteArray).k(ttmlRegion.f9056b).l(0).h(ttmlRegion.f9057c, 0).i(ttmlRegion.f9059e).n(ttmlRegion.f9060f).g(ttmlRegion.f9061g).r(ttmlRegion.f9064j).a());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            TtmlRegion ttmlRegion2 = (TtmlRegion) Assertions.f(map2.get(entry.getKey()));
            Cue.Builder builder = (Cue.Builder) entry.getValue();
            e((SpannableStringBuilder) Assertions.f(builder.e()));
            builder.h(ttmlRegion2.f9057c, ttmlRegion2.f9058d);
            builder.i(ttmlRegion2.f9059e);
            builder.k(ttmlRegion2.f9056b);
            builder.n(ttmlRegion2.f9060f);
            builder.q(ttmlRegion2.f9063i, ttmlRegion2.f9062h);
            builder.r(ttmlRegion2.f9064j);
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
        return this.f9034g;
    }

    public boolean m(long j2) {
        long j3 = this.f9031d;
        return (j3 == -9223372036854775807L && this.f9032e == -9223372036854775807L) || (j3 <= j2 && this.f9032e == -9223372036854775807L) || ((j3 == -9223372036854775807L && j2 < this.f9032e) || (j3 <= j2 && j2 < this.f9032e));
    }
}
