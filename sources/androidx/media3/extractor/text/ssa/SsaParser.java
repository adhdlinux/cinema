package androidx.media3.extractor.text.ssa;

import android.graphics.PointF;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.f;
import androidx.media3.extractor.text.ssa.SsaStyle;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.common.base.Ascii;
import com.google.common.base.Charsets;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SsaParser implements SubtitleParser {

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f8981g = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");

    /* renamed from: a  reason: collision with root package name */
    private final boolean f8982a;

    /* renamed from: b  reason: collision with root package name */
    private final SsaDialogueFormat f8983b;

    /* renamed from: c  reason: collision with root package name */
    private final ParsableByteArray f8984c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, SsaStyle> f8985d;

    /* renamed from: e  reason: collision with root package name */
    private float f8986e;

    /* renamed from: f  reason: collision with root package name */
    private float f8987f;

    public SsaParser() {
        this((List<byte[]>) null);
    }

    private static int d(long j2, List<Long> list, List<List<Cue>> list2) {
        int i2;
        ArrayList arrayList;
        int size = list.size() - 1;
        while (true) {
            if (size < 0) {
                i2 = 0;
                break;
            } else if (list.get(size).longValue() == j2) {
                return size;
            } else {
                if (list.get(size).longValue() < j2) {
                    i2 = size + 1;
                    break;
                }
                size--;
            }
        }
        list.add(i2, Long.valueOf(j2));
        if (i2 != 0) {
            arrayList = new ArrayList(list2.get(i2 - 1));
        }
        list2.add(i2, arrayList);
        return i2;
    }

    private static float e(int i2) {
        if (i2 == 0) {
            return 0.05f;
        }
        if (i2 != 1) {
            return i2 != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    private static Cue f(String str, SsaStyle ssaStyle, SsaStyle.Overrides overrides, float f2, float f3) {
        SpannableString spannableString = new SpannableString(str);
        Cue.Builder o2 = new Cue.Builder().o(spannableString);
        if (ssaStyle != null) {
            if (ssaStyle.f8990c != null) {
                spannableString.setSpan(new ForegroundColorSpan(ssaStyle.f8990c.intValue()), 0, spannableString.length(), 33);
            }
            if (ssaStyle.f8997j == 3 && ssaStyle.f8991d != null) {
                spannableString.setSpan(new BackgroundColorSpan(ssaStyle.f8991d.intValue()), 0, spannableString.length(), 33);
            }
            float f4 = ssaStyle.f8992e;
            if (!(f4 == -3.4028235E38f || f3 == -3.4028235E38f)) {
                o2.q(f4 / f3, 1);
            }
            boolean z2 = ssaStyle.f8993f;
            if (z2 && ssaStyle.f8994g) {
                spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
            } else if (z2) {
                spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
            } else if (ssaStyle.f8994g) {
                spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
            }
            if (ssaStyle.f8995h) {
                spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 33);
            }
            if (ssaStyle.f8996i) {
                spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
            }
        }
        int i2 = overrides.f9013a;
        if (i2 == -1) {
            if (ssaStyle != null) {
                i2 = ssaStyle.f8989b;
            } else {
                i2 = -1;
            }
        }
        o2.p(p(i2)).l(o(i2)).i(n(i2));
        PointF pointF = overrides.f9014b;
        if (pointF == null || f3 == -3.4028235E38f || f2 == -3.4028235E38f) {
            o2.k(e(o2.d()));
            o2.h(e(o2.c()), 0);
        } else {
            o2.k(pointF.x / f2);
            o2.h(overrides.f9014b.y / f3, 0);
        }
        return o2.a();
    }

    private Charset g(ParsableByteArray parsableByteArray) {
        Charset P = parsableByteArray.P();
        if (P != null) {
            return P;
        }
        return Charsets.UTF_8;
    }

    private void h(String str, SsaDialogueFormat ssaDialogueFormat, List<List<Cue>> list, List<Long> list2) {
        SsaStyle ssaStyle;
        int i2;
        Assertions.a(str.startsWith("Dialogue:"));
        String[] split = str.substring(9).split(",", ssaDialogueFormat.f8980e);
        if (split.length != ssaDialogueFormat.f8980e) {
            Log.h("SsaParser", "Skipping dialogue line with fewer columns than format: " + str);
            return;
        }
        long m2 = m(split[ssaDialogueFormat.f8976a]);
        if (m2 == -9223372036854775807L) {
            Log.h("SsaParser", "Skipping invalid timing: " + str);
            return;
        }
        long m3 = m(split[ssaDialogueFormat.f8977b]);
        if (m3 == -9223372036854775807L) {
            Log.h("SsaParser", "Skipping invalid timing: " + str);
            return;
        }
        Map<String, SsaStyle> map = this.f8985d;
        if (map == null || (i2 = ssaDialogueFormat.f8978c) == -1) {
            ssaStyle = null;
        } else {
            ssaStyle = map.get(split[i2].trim());
        }
        String str2 = split[ssaDialogueFormat.f8979d];
        Cue f2 = f(SsaStyle.Overrides.d(str2).replace("\\N", ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE).replace("\\n", ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE).replace("\\h", " "), ssaStyle, SsaStyle.Overrides.b(str2), this.f8986e, this.f8987f);
        int d2 = d(m3, list2, list);
        for (int d3 = d(m2, list2, list); d3 < d2; d3++) {
            list.get(d3).add(f2);
        }
    }

    private void i(ParsableByteArray parsableByteArray, List<List<Cue>> list, List<Long> list2, Charset charset) {
        SsaDialogueFormat ssaDialogueFormat;
        if (this.f8982a) {
            ssaDialogueFormat = this.f8983b;
        } else {
            ssaDialogueFormat = null;
        }
        while (true) {
            String t2 = parsableByteArray.t(charset);
            if (t2 == null) {
                return;
            }
            if (t2.startsWith("Format:")) {
                ssaDialogueFormat = SsaDialogueFormat.a(t2);
            } else if (t2.startsWith("Dialogue:")) {
                if (ssaDialogueFormat == null) {
                    Log.h("SsaParser", "Skipping dialogue line before complete format: " + t2);
                } else {
                    h(t2, ssaDialogueFormat, list, list2);
                }
            }
        }
    }

    private void j(ParsableByteArray parsableByteArray, Charset charset) {
        while (true) {
            String t2 = parsableByteArray.t(charset);
            if (t2 == null) {
                return;
            }
            if ("[Script Info]".equalsIgnoreCase(t2)) {
                k(parsableByteArray, charset);
            } else if ("[V4+ Styles]".equalsIgnoreCase(t2)) {
                this.f8985d = l(parsableByteArray, charset);
            } else if ("[V4 Styles]".equalsIgnoreCase(t2)) {
                Log.f("SsaParser", "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(t2)) {
                return;
            }
        }
    }

    private void k(ParsableByteArray parsableByteArray, Charset charset) {
        while (true) {
            String t2 = parsableByteArray.t(charset);
            if (t2 == null) {
                return;
            }
            if (parsableByteArray.a() == 0 || parsableByteArray.h(charset) != '[') {
                String[] split = t2.split(":");
                if (split.length == 2) {
                    String e2 = Ascii.e(split[0].trim());
                    e2.hashCode();
                    if (e2.equals("playresx")) {
                        this.f8986e = Float.parseFloat(split[1].trim());
                    } else if (e2.equals("playresy")) {
                        try {
                            this.f8987f = Float.parseFloat(split[1].trim());
                        } catch (NumberFormatException unused) {
                        }
                    }
                }
            } else {
                return;
            }
        }
    }

    private static Map<String, SsaStyle> l(ParsableByteArray parsableByteArray, Charset charset) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        SsaStyle.Format format = null;
        while (true) {
            String t2 = parsableByteArray.t(charset);
            if (t2 == null || (parsableByteArray.a() != 0 && parsableByteArray.h(charset) == '[')) {
                return linkedHashMap;
            }
            if (t2.startsWith("Format:")) {
                format = SsaStyle.Format.a(t2);
            } else if (t2.startsWith("Style:")) {
                if (format == null) {
                    Log.h("SsaParser", "Skipping 'Style:' line before 'Format:' line: " + t2);
                } else {
                    SsaStyle b2 = SsaStyle.b(t2, format);
                    if (b2 != null) {
                        linkedHashMap.put(b2.f8988a, b2);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    private static long m(String str) {
        Matcher matcher = f8981g.matcher(str.trim());
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        return (Long.parseLong((String) Util.i(matcher.group(1))) * 60 * 60 * 1000000) + (Long.parseLong((String) Util.i(matcher.group(2))) * 60 * 1000000) + (Long.parseLong((String) Util.i(matcher.group(3))) * 1000000) + (Long.parseLong((String) Util.i(matcher.group(4))) * NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS);
    }

    private static int n(int i2) {
        switch (i2) {
            case -1:
                return Integer.MIN_VALUE;
            case 1:
            case 2:
            case 3:
                return 2;
            case 4:
            case 5:
            case 6:
                return 1;
            case 7:
            case 8:
            case 9:
                return 0;
            default:
                Log.h("SsaParser", "Unknown alignment: " + i2);
                return Integer.MIN_VALUE;
        }
    }

    private static int o(int i2) {
        switch (i2) {
            case -1:
                return Integer.MIN_VALUE;
            case 1:
            case 4:
            case 7:
                return 0;
            case 2:
            case 5:
            case 8:
                return 1;
            case 3:
            case 6:
            case 9:
                return 2;
            default:
                Log.h("SsaParser", "Unknown alignment: " + i2);
                return Integer.MIN_VALUE;
        }
    }

    private static Layout.Alignment p(int i2) {
        switch (i2) {
            case -1:
                return null;
            case 1:
            case 4:
            case 7:
                return Layout.Alignment.ALIGN_NORMAL;
            case 2:
            case 5:
            case 8:
                return Layout.Alignment.ALIGN_CENTER;
            case 3:
            case 6:
            case 9:
                return Layout.Alignment.ALIGN_OPPOSITE;
            default:
                Log.h("SsaParser", "Unknown alignment: " + i2);
                return null;
        }
    }

    public void a(byte[] bArr, int i2, int i3, SubtitleParser.OutputOptions outputOptions, Consumer<CuesWithTiming> consumer) {
        ArrayList<CuesWithTiming> arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        int i4 = i2;
        SubtitleParser.OutputOptions outputOptions2 = outputOptions;
        Consumer<CuesWithTiming> consumer2 = consumer;
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        this.f8984c.S(bArr, i4 + i3);
        this.f8984c.U(i4);
        Charset g2 = g(this.f8984c);
        if (!this.f8982a) {
            j(this.f8984c, g2);
        }
        i(this.f8984c, arrayList4, arrayList5, g2);
        if (outputOptions2.f8800a == -9223372036854775807L || !outputOptions2.f8801b) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
        }
        int i5 = 0;
        while (i5 < arrayList4.size()) {
            List list = (List) arrayList4.get(i5);
            if (list.isEmpty() && i5 != 0) {
                arrayList3 = arrayList4;
                arrayList2 = arrayList5;
            } else if (i5 != arrayList4.size() - 1) {
                long longValue = ((Long) arrayList5.get(i5)).longValue();
                long longValue2 = ((Long) arrayList5.get(i5 + 1)).longValue() - ((Long) arrayList5.get(i5)).longValue();
                arrayList3 = arrayList4;
                arrayList2 = arrayList5;
                long j2 = outputOptions2.f8800a;
                if (j2 == -9223372036854775807L || longValue >= j2) {
                    consumer2.accept(new CuesWithTiming(list, longValue, longValue2));
                } else if (arrayList != null) {
                    arrayList.add(new CuesWithTiming(list, longValue, longValue2));
                }
            } else {
                throw new IllegalStateException();
            }
            i5++;
            arrayList4 = arrayList3;
            arrayList5 = arrayList2;
        }
        if (arrayList != null) {
            for (CuesWithTiming accept : arrayList) {
                consumer2.accept(accept);
            }
        }
    }

    public /* synthetic */ Subtitle b(byte[] bArr, int i2, int i3) {
        return f.a(this, bArr, i2, i3);
    }

    public int c() {
        return 1;
    }

    public /* synthetic */ void reset() {
        f.b(this);
    }

    public SsaParser(List<byte[]> list) {
        this.f8986e = -3.4028235E38f;
        this.f8987f = -3.4028235E38f;
        this.f8984c = new ParsableByteArray();
        if (list == null || list.isEmpty()) {
            this.f8982a = false;
            this.f8983b = null;
            return;
        }
        this.f8982a = true;
        String H = Util.H(list.get(0));
        Assertions.a(H.startsWith("Format:"));
        this.f8983b = (SsaDialogueFormat) Assertions.f(SsaDialogueFormat.a(H));
        j(new ParsableByteArray(list.get(1)), Charsets.UTF_8);
    }
}
