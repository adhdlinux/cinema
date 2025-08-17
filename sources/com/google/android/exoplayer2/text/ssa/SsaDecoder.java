package com.google.android.exoplayer2.text.ssa;

import android.graphics.PointF;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.ssa.SsaStyle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
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

public final class SsaDecoder extends SimpleSubtitleDecoder {

    /* renamed from: t  reason: collision with root package name */
    private static final Pattern f27441t = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");

    /* renamed from: o  reason: collision with root package name */
    private final boolean f27442o;

    /* renamed from: p  reason: collision with root package name */
    private final SsaDialogueFormat f27443p;

    /* renamed from: q  reason: collision with root package name */
    private Map<String, SsaStyle> f27444q;

    /* renamed from: r  reason: collision with root package name */
    private float f27445r;

    /* renamed from: s  reason: collision with root package name */
    private float f27446s;

    public SsaDecoder() {
        this((List<byte[]>) null);
    }

    private static int B(long j2, List<Long> list, List<List<Cue>> list2) {
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

    private static float C(int i2) {
        if (i2 == 0) {
            return 0.05f;
        }
        if (i2 != 1) {
            return i2 != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    private static Cue D(String str, SsaStyle ssaStyle, SsaStyle.Overrides overrides, float f2, float f3) {
        SpannableString spannableString = new SpannableString(str);
        Cue.Builder o2 = new Cue.Builder().o(spannableString);
        if (ssaStyle != null) {
            if (ssaStyle.f27454c != null) {
                spannableString.setSpan(new ForegroundColorSpan(ssaStyle.f27454c.intValue()), 0, spannableString.length(), 33);
            }
            if (ssaStyle.f27461j == 3 && ssaStyle.f27455d != null) {
                spannableString.setSpan(new BackgroundColorSpan(ssaStyle.f27455d.intValue()), 0, spannableString.length(), 33);
            }
            float f4 = ssaStyle.f27456e;
            if (!(f4 == -3.4028235E38f || f3 == -3.4028235E38f)) {
                o2.q(f4 / f3, 1);
            }
            boolean z2 = ssaStyle.f27457f;
            if (z2 && ssaStyle.f27458g) {
                spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
            } else if (z2) {
                spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
            } else if (ssaStyle.f27458g) {
                spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
            }
            if (ssaStyle.f27459h) {
                spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 33);
            }
            if (ssaStyle.f27460i) {
                spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
            }
        }
        int i2 = overrides.f27477a;
        if (i2 == -1) {
            if (ssaStyle != null) {
                i2 = ssaStyle.f27453b;
            } else {
                i2 = -1;
            }
        }
        o2.p(N(i2)).l(M(i2)).i(L(i2));
        PointF pointF = overrides.f27478b;
        if (pointF == null || f3 == -3.4028235E38f || f2 == -3.4028235E38f) {
            o2.k(C(o2.d()));
            o2.h(C(o2.c()), 0);
        } else {
            o2.k(pointF.x / f2);
            o2.h(overrides.f27478b.y / f3, 0);
        }
        return o2.a();
    }

    private Charset E(ParsableByteArray parsableByteArray) {
        Charset P = parsableByteArray.P();
        if (P != null) {
            return P;
        }
        return Charsets.UTF_8;
    }

    private void F(String str, SsaDialogueFormat ssaDialogueFormat, List<List<Cue>> list, List<Long> list2) {
        SsaStyle ssaStyle;
        int i2;
        Assertions.a(str.startsWith("Dialogue:"));
        String[] split = str.substring(9).split(",", ssaDialogueFormat.f27451e);
        if (split.length != ssaDialogueFormat.f27451e) {
            Log.i("SsaDecoder", "Skipping dialogue line with fewer columns than format: " + str);
            return;
        }
        long K = K(split[ssaDialogueFormat.f27447a]);
        if (K == -9223372036854775807L) {
            Log.i("SsaDecoder", "Skipping invalid timing: " + str);
            return;
        }
        long K2 = K(split[ssaDialogueFormat.f27448b]);
        if (K2 == -9223372036854775807L) {
            Log.i("SsaDecoder", "Skipping invalid timing: " + str);
            return;
        }
        Map<String, SsaStyle> map = this.f27444q;
        if (map == null || (i2 = ssaDialogueFormat.f27449c) == -1) {
            ssaStyle = null;
        } else {
            ssaStyle = map.get(split[i2].trim());
        }
        String str2 = split[ssaDialogueFormat.f27450d];
        Cue D = D(SsaStyle.Overrides.d(str2).replace("\\N", ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE).replace("\\n", ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE).replace("\\h", " "), ssaStyle, SsaStyle.Overrides.b(str2), this.f27445r, this.f27446s);
        int B = B(K2, list2, list);
        for (int B2 = B(K, list2, list); B2 < B; B2++) {
            list.get(B2).add(D);
        }
    }

    private void G(ParsableByteArray parsableByteArray, List<List<Cue>> list, List<Long> list2, Charset charset) {
        SsaDialogueFormat ssaDialogueFormat;
        if (this.f27442o) {
            ssaDialogueFormat = this.f27443p;
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
                    Log.i("SsaDecoder", "Skipping dialogue line before complete format: " + t2);
                } else {
                    F(t2, ssaDialogueFormat, list, list2);
                }
            }
        }
    }

    private void H(ParsableByteArray parsableByteArray, Charset charset) {
        while (true) {
            String t2 = parsableByteArray.t(charset);
            if (t2 == null) {
                return;
            }
            if ("[Script Info]".equalsIgnoreCase(t2)) {
                I(parsableByteArray, charset);
            } else if ("[V4+ Styles]".equalsIgnoreCase(t2)) {
                this.f27444q = J(parsableByteArray, charset);
            } else if ("[V4 Styles]".equalsIgnoreCase(t2)) {
                Log.f("SsaDecoder", "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(t2)) {
                return;
            }
        }
    }

    private void I(ParsableByteArray parsableByteArray, Charset charset) {
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
                        this.f27445r = Float.parseFloat(split[1].trim());
                    } else if (e2.equals("playresy")) {
                        try {
                            this.f27446s = Float.parseFloat(split[1].trim());
                        } catch (NumberFormatException unused) {
                        }
                    }
                }
            } else {
                return;
            }
        }
    }

    private static Map<String, SsaStyle> J(ParsableByteArray parsableByteArray, Charset charset) {
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
                    Log.i("SsaDecoder", "Skipping 'Style:' line before 'Format:' line: " + t2);
                } else {
                    SsaStyle b2 = SsaStyle.b(t2, format);
                    if (b2 != null) {
                        linkedHashMap.put(b2.f27452a, b2);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    private static long K(String str) {
        Matcher matcher = f27441t.matcher(str.trim());
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        return (Long.parseLong((String) Util.j(matcher.group(1))) * 60 * 60 * 1000000) + (Long.parseLong((String) Util.j(matcher.group(2))) * 60 * 1000000) + (Long.parseLong((String) Util.j(matcher.group(3))) * 1000000) + (Long.parseLong((String) Util.j(matcher.group(4))) * NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS);
    }

    private static int L(int i2) {
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
                Log.i("SsaDecoder", "Unknown alignment: " + i2);
                return Integer.MIN_VALUE;
        }
    }

    private static int M(int i2) {
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
                Log.i("SsaDecoder", "Unknown alignment: " + i2);
                return Integer.MIN_VALUE;
        }
    }

    private static Layout.Alignment N(int i2) {
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
                Log.i("SsaDecoder", "Unknown alignment: " + i2);
                return null;
        }
    }

    /* access modifiers changed from: protected */
    public Subtitle z(byte[] bArr, int i2, boolean z2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i2);
        Charset E = E(parsableByteArray);
        if (!this.f27442o) {
            H(parsableByteArray, E);
        }
        G(parsableByteArray, arrayList, arrayList2, E);
        return new SsaSubtitle(arrayList, arrayList2);
    }

    public SsaDecoder(List<byte[]> list) {
        super("SsaDecoder");
        this.f27445r = -3.4028235E38f;
        this.f27446s = -3.4028235E38f;
        if (list == null || list.isEmpty()) {
            this.f27442o = false;
            this.f27443p = null;
            return;
        }
        this.f27442o = true;
        String D = Util.D(list.get(0));
        Assertions.a(D.startsWith("Format:"));
        this.f27443p = (SsaDialogueFormat) Assertions.e(SsaDialogueFormat.a(D));
        H(new ParsableByteArray(list.get(1)), Charsets.UTF_8);
    }
}
