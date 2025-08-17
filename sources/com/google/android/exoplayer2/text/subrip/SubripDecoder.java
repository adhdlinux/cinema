package com.google.android.exoplayer2.text.subrip;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.LongArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.common.base.Charsets;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SubripDecoder extends SimpleSubtitleDecoder {

    /* renamed from: q  reason: collision with root package name */
    private static final Pattern f27481q = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");

    /* renamed from: r  reason: collision with root package name */
    private static final Pattern f27482r = Pattern.compile("\\{\\\\.*?\\}");

    /* renamed from: o  reason: collision with root package name */
    private final StringBuilder f27483o = new StringBuilder();

    /* renamed from: p  reason: collision with root package name */
    private final ArrayList<String> f27484p = new ArrayList<>();

    public SubripDecoder() {
        super("SubripDecoder");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.exoplayer2.text.Cue B(android.text.Spanned r17, java.lang.String r18) {
        /*
            r16 = this;
            r0 = r18
            com.google.android.exoplayer2.text.Cue$Builder r1 = new com.google.android.exoplayer2.text.Cue$Builder
            r1.<init>()
            r2 = r17
            com.google.android.exoplayer2.text.Cue$Builder r1 = r1.o(r2)
            if (r0 != 0) goto L_0x0014
            com.google.android.exoplayer2.text.Cue r0 = r1.a()
            return r0
        L_0x0014:
            int r2 = r18.hashCode()
            java.lang.String r6 = "{\\an9}"
            java.lang.String r7 = "{\\an8}"
            java.lang.String r8 = "{\\an7}"
            java.lang.String r9 = "{\\an6}"
            java.lang.String r10 = "{\\an5}"
            java.lang.String r11 = "{\\an4}"
            java.lang.String r12 = "{\\an3}"
            java.lang.String r13 = "{\\an2}"
            java.lang.String r14 = "{\\an1}"
            r4 = 4
            r5 = 3
            r15 = 2
            r3 = 1
            switch(r2) {
                case -685620710: goto L_0x0073;
                case -685620679: goto L_0x006b;
                case -685620648: goto L_0x0063;
                case -685620617: goto L_0x005b;
                case -685620586: goto L_0x0053;
                case -685620555: goto L_0x004b;
                case -685620524: goto L_0x0043;
                case -685620493: goto L_0x003a;
                case -685620462: goto L_0x0032;
                default: goto L_0x0031;
            }
        L_0x0031:
            goto L_0x007b
        L_0x0032:
            boolean r2 = r0.equals(r6)
            if (r2 == 0) goto L_0x007b
            r2 = 5
            goto L_0x007c
        L_0x003a:
            boolean r2 = r0.equals(r7)
            if (r2 == 0) goto L_0x007b
            r2 = 8
            goto L_0x007c
        L_0x0043:
            boolean r2 = r0.equals(r8)
            if (r2 == 0) goto L_0x007b
            r2 = 2
            goto L_0x007c
        L_0x004b:
            boolean r2 = r0.equals(r9)
            if (r2 == 0) goto L_0x007b
            r2 = 4
            goto L_0x007c
        L_0x0053:
            boolean r2 = r0.equals(r10)
            if (r2 == 0) goto L_0x007b
            r2 = 7
            goto L_0x007c
        L_0x005b:
            boolean r2 = r0.equals(r11)
            if (r2 == 0) goto L_0x007b
            r2 = 1
            goto L_0x007c
        L_0x0063:
            boolean r2 = r0.equals(r12)
            if (r2 == 0) goto L_0x007b
            r2 = 3
            goto L_0x007c
        L_0x006b:
            boolean r2 = r0.equals(r13)
            if (r2 == 0) goto L_0x007b
            r2 = 6
            goto L_0x007c
        L_0x0073:
            boolean r2 = r0.equals(r14)
            if (r2 == 0) goto L_0x007b
            r2 = 0
            goto L_0x007c
        L_0x007b:
            r2 = -1
        L_0x007c:
            if (r2 == 0) goto L_0x0091
            if (r2 == r3) goto L_0x0091
            if (r2 == r15) goto L_0x0091
            if (r2 == r5) goto L_0x008d
            if (r2 == r4) goto L_0x008d
            r4 = 5
            if (r2 == r4) goto L_0x008d
            r1.l(r3)
            goto L_0x0095
        L_0x008d:
            r1.l(r15)
            goto L_0x0095
        L_0x0091:
            r2 = 0
            r1.l(r2)
        L_0x0095:
            int r2 = r18.hashCode()
            switch(r2) {
                case -685620710: goto L_0x00de;
                case -685620679: goto L_0x00d6;
                case -685620648: goto L_0x00ce;
                case -685620617: goto L_0x00c6;
                case -685620586: goto L_0x00be;
                case -685620555: goto L_0x00b5;
                case -685620524: goto L_0x00ad;
                case -685620493: goto L_0x00a5;
                case -685620462: goto L_0x009d;
                default: goto L_0x009c;
            }
        L_0x009c:
            goto L_0x00e6
        L_0x009d:
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x00e6
            r0 = 5
            goto L_0x00e7
        L_0x00a5:
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x00e6
            r0 = 4
            goto L_0x00e7
        L_0x00ad:
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x00e6
            r0 = 3
            goto L_0x00e7
        L_0x00b5:
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x00e6
            r0 = 8
            goto L_0x00e7
        L_0x00be:
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x00e6
            r0 = 7
            goto L_0x00e7
        L_0x00c6:
            boolean r0 = r0.equals(r11)
            if (r0 == 0) goto L_0x00e6
            r0 = 6
            goto L_0x00e7
        L_0x00ce:
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x00e6
            r0 = 2
            goto L_0x00e7
        L_0x00d6:
            boolean r0 = r0.equals(r13)
            if (r0 == 0) goto L_0x00e6
            r0 = 1
            goto L_0x00e7
        L_0x00de:
            boolean r0 = r0.equals(r14)
            if (r0 == 0) goto L_0x00e6
            r0 = 0
            goto L_0x00e7
        L_0x00e6:
            r0 = -1
        L_0x00e7:
            if (r0 == 0) goto L_0x00fe
            if (r0 == r3) goto L_0x00fe
            if (r0 == r15) goto L_0x00fe
            if (r0 == r5) goto L_0x00f9
            r2 = 4
            if (r0 == r2) goto L_0x00f9
            r2 = 5
            if (r0 == r2) goto L_0x00f9
            r1.i(r3)
            goto L_0x0101
        L_0x00f9:
            r0 = 0
            r1.i(r0)
            goto L_0x0101
        L_0x00fe:
            r1.i(r15)
        L_0x0101:
            int r0 = r1.d()
            float r0 = D(r0)
            com.google.android.exoplayer2.text.Cue$Builder r0 = r1.k(r0)
            int r1 = r1.c()
            float r1 = D(r1)
            r2 = 0
            com.google.android.exoplayer2.text.Cue$Builder r0 = r0.h(r1, r2)
            com.google.android.exoplayer2.text.Cue r0 = r0.a()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.subrip.SubripDecoder.B(android.text.Spanned, java.lang.String):com.google.android.exoplayer2.text.Cue");
    }

    private Charset C(ParsableByteArray parsableByteArray) {
        Charset P = parsableByteArray.P();
        if (P != null) {
            return P;
        }
        return Charsets.UTF_8;
    }

    static float D(int i2) {
        if (i2 == 0) {
            return 0.08f;
        }
        if (i2 == 1) {
            return 0.5f;
        }
        if (i2 == 2) {
            return 0.92f;
        }
        throw new IllegalArgumentException();
    }

    private static long E(Matcher matcher, int i2) {
        long j2;
        String group = matcher.group(i2 + 1);
        if (group != null) {
            j2 = Long.parseLong(group) * 60 * 60 * 1000;
        } else {
            j2 = 0;
        }
        long parseLong = j2 + (Long.parseLong((String) Assertions.e(matcher.group(i2 + 2))) * 60 * 1000) + (Long.parseLong((String) Assertions.e(matcher.group(i2 + 3))) * 1000);
        String group2 = matcher.group(i2 + 4);
        if (group2 != null) {
            parseLong += Long.parseLong(group2);
        }
        return parseLong * 1000;
    }

    private String F(String str, ArrayList<String> arrayList) {
        String trim = str.trim();
        StringBuilder sb = new StringBuilder(trim);
        Matcher matcher = f27482r.matcher(trim);
        int i2 = 0;
        while (matcher.find()) {
            String group = matcher.group();
            arrayList.add(group);
            int start = matcher.start() - i2;
            int length = group.length();
            sb.replace(start, start + length, "");
            i2 += length;
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public Subtitle z(byte[] bArr, int i2, boolean z2) {
        String str;
        ArrayList arrayList = new ArrayList();
        LongArray longArray = new LongArray();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i2);
        Charset C = C(parsableByteArray);
        while (true) {
            String t2 = parsableByteArray.t(C);
            int i3 = 0;
            if (t2 == null) {
                break;
            } else if (t2.length() != 0) {
                String t3 = parsableByteArray.t(C);
                if (t3 == null) {
                    Log.i("SubripDecoder", "Unexpected end");
                    break;
                }
                Matcher matcher = f27481q.matcher(t3);
                if (matcher.matches()) {
                    longArray.a(E(matcher, 1));
                    longArray.a(E(matcher, 6));
                    this.f27483o.setLength(0);
                    this.f27484p.clear();
                    for (String t4 = parsableByteArray.t(C); !TextUtils.isEmpty(t4); t4 = parsableByteArray.t(C)) {
                        if (this.f27483o.length() > 0) {
                            this.f27483o.append("<br>");
                        }
                        this.f27483o.append(F(t4, this.f27484p));
                    }
                    Spanned fromHtml = Html.fromHtml(this.f27483o.toString());
                    while (true) {
                        if (i3 >= this.f27484p.size()) {
                            str = null;
                            break;
                        }
                        str = this.f27484p.get(i3);
                        if (str.matches("\\{\\\\an[1-9]\\}")) {
                            break;
                        }
                        i3++;
                    }
                    arrayList.add(B(fromHtml, str));
                    arrayList.add(Cue.f27194s);
                } else {
                    Log.i("SubripDecoder", "Skipping invalid timing: " + t3);
                }
            }
        }
        return new SubripSubtitle((Cue[]) arrayList.toArray(new Cue[0]), longArray.d());
    }
}
