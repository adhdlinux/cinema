package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import android.util.Base64;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

final class RtspMediaTrack {

    /* renamed from: a  reason: collision with root package name */
    public final RtpPayloadFormat f26878a;

    /* renamed from: b  reason: collision with root package name */
    public final Uri f26879b;

    public RtspMediaTrack(MediaDescription mediaDescription, Uri uri) {
        Assertions.b(mediaDescription.f26721i.containsKey("control"), "missing attribute control");
        this.f26878a = b(mediaDescription);
        this.f26879b = a(uri, (String) Util.j(mediaDescription.f26721i.get("control")));
    }

    private static Uri a(Uri uri, String str) {
        Uri parse = Uri.parse(str);
        if (parse.isAbsolute()) {
            return parse;
        }
        if (str.equals("*")) {
            return uri;
        }
        return uri.buildUpon().appendEncodedPath(str).build();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat b(com.google.android.exoplayer2.source.rtsp.MediaDescription r13) {
        /*
            com.google.android.exoplayer2.Format$Builder r0 = new com.google.android.exoplayer2.Format$Builder
            r0.<init>()
            int r1 = r13.f26717e
            if (r1 <= 0) goto L_0x000c
            r0.I(r1)
        L_0x000c:
            com.google.android.exoplayer2.source.rtsp.MediaDescription$RtpMapAttribute r1 = r13.f26722j
            int r4 = r1.f26732a
            java.lang.String r7 = r1.f26733b
            java.lang.String r1 = com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat.a(r7)
            r0.g0(r1)
            com.google.android.exoplayer2.source.rtsp.MediaDescription$RtpMapAttribute r2 = r13.f26722j
            int r5 = r2.f26734c
            java.lang.String r2 = "audio"
            java.lang.String r3 = r13.f26713a
            boolean r2 = r2.equals(r3)
            r3 = -1
            if (r2 == 0) goto L_0x0038
            com.google.android.exoplayer2.source.rtsp.MediaDescription$RtpMapAttribute r2 = r13.f26722j
            int r2 = r2.f26735d
            int r2 = d(r2, r1)
            com.google.android.exoplayer2.Format$Builder r6 = r0.h0(r5)
            r6.J(r2)
            goto L_0x0039
        L_0x0038:
            r2 = -1
        L_0x0039:
            com.google.common.collect.ImmutableMap r6 = r13.a()
            int r13 = r1.hashCode()
            r8 = 2
            r9 = 0
            r10 = 1
            switch(r13) {
                case -1664118616: goto L_0x00d5;
                case -1662541442: goto L_0x00cb;
                case -1606874997: goto L_0x00c1;
                case -53558318: goto L_0x00b7;
                case 187078296: goto L_0x00ac;
                case 187094639: goto L_0x00a1;
                case 1187890754: goto L_0x0097;
                case 1331836730: goto L_0x008d;
                case 1503095341: goto L_0x0083;
                case 1504891608: goto L_0x0079;
                case 1599127256: goto L_0x006d;
                case 1599127257: goto L_0x0061;
                case 1903231877: goto L_0x0055;
                case 1903589369: goto L_0x0049;
                default: goto L_0x0047;
            }
        L_0x0047:
            goto L_0x00df
        L_0x0049:
            java.lang.String r13 = "audio/g711-mlaw"
            boolean r13 = r1.equals(r13)
            if (r13 == 0) goto L_0x00df
            r13 = 13
            goto L_0x00e0
        L_0x0055:
            java.lang.String r13 = "audio/g711-alaw"
            boolean r13 = r1.equals(r13)
            if (r13 == 0) goto L_0x00df
            r13 = 12
            goto L_0x00e0
        L_0x0061:
            java.lang.String r13 = "video/x-vnd.on2.vp9"
            boolean r13 = r1.equals(r13)
            if (r13 == 0) goto L_0x00df
            r13 = 9
            goto L_0x00e0
        L_0x006d:
            java.lang.String r13 = "video/x-vnd.on2.vp8"
            boolean r13 = r1.equals(r13)
            if (r13 == 0) goto L_0x00df
            r13 = 8
            goto L_0x00e0
        L_0x0079:
            java.lang.String r13 = "audio/opus"
            boolean r13 = r1.equals(r13)
            if (r13 == 0) goto L_0x00df
            r13 = 3
            goto L_0x00e0
        L_0x0083:
            java.lang.String r13 = "audio/3gpp"
            boolean r13 = r1.equals(r13)
            if (r13 == 0) goto L_0x00df
            r13 = 1
            goto L_0x00e0
        L_0x008d:
            java.lang.String r13 = "video/avc"
            boolean r13 = r1.equals(r13)
            if (r13 == 0) goto L_0x00df
            r13 = 6
            goto L_0x00e0
        L_0x0097:
            java.lang.String r13 = "video/mp4v-es"
            boolean r13 = r1.equals(r13)
            if (r13 == 0) goto L_0x00df
            r13 = 4
            goto L_0x00e0
        L_0x00a1:
            java.lang.String r13 = "audio/raw"
            boolean r13 = r1.equals(r13)
            if (r13 == 0) goto L_0x00df
            r13 = 10
            goto L_0x00e0
        L_0x00ac:
            java.lang.String r13 = "audio/ac3"
            boolean r13 = r1.equals(r13)
            if (r13 == 0) goto L_0x00df
            r13 = 11
            goto L_0x00e0
        L_0x00b7:
            java.lang.String r13 = "audio/mp4a-latm"
            boolean r13 = r1.equals(r13)
            if (r13 == 0) goto L_0x00df
            r13 = 0
            goto L_0x00e0
        L_0x00c1:
            java.lang.String r13 = "audio/amr-wb"
            boolean r13 = r1.equals(r13)
            if (r13 == 0) goto L_0x00df
            r13 = 2
            goto L_0x00e0
        L_0x00cb:
            java.lang.String r13 = "video/hevc"
            boolean r13 = r1.equals(r13)
            if (r13 == 0) goto L_0x00df
            r13 = 7
            goto L_0x00e0
        L_0x00d5:
            java.lang.String r13 = "video/3gpp"
            boolean r13 = r1.equals(r13)
            if (r13 == 0) goto L_0x00df
            r13 = 5
            goto L_0x00e0
        L_0x00df:
            r13 = -1
        L_0x00e0:
            r1 = 240(0xf0, float:3.36E-43)
            r11 = 320(0x140, float:4.48E-43)
            java.lang.String r12 = "missing attribute fmtp"
            switch(r13) {
                case 0: goto L_0x017e;
                case 1: goto L_0x0151;
                case 2: goto L_0x0151;
                case 3: goto L_0x013a;
                case 4: goto L_0x012d;
                case 5: goto L_0x0120;
                case 6: goto L_0x0113;
                case 7: goto L_0x0106;
                case 8: goto L_0x00fd;
                case 9: goto L_0x00f4;
                case 10: goto L_0x00eb;
                default: goto L_0x00e9;
            }
        L_0x00e9:
            goto L_0x01f7
        L_0x00eb:
            int r13 = com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat.b(r7)
            r0.a0(r13)
            goto L_0x01f7
        L_0x00f4:
            com.google.android.exoplayer2.Format$Builder r13 = r0.n0(r11)
            r13.S(r1)
            goto L_0x01f7
        L_0x00fd:
            com.google.android.exoplayer2.Format$Builder r13 = r0.n0(r11)
            r13.S(r1)
            goto L_0x01f7
        L_0x0106:
            boolean r13 = r6.isEmpty()
            r13 = r13 ^ r10
            com.google.android.exoplayer2.util.Assertions.b(r13, r12)
            h(r0, r6)
            goto L_0x01f7
        L_0x0113:
            boolean r13 = r6.isEmpty()
            r13 = r13 ^ r10
            com.google.android.exoplayer2.util.Assertions.b(r13, r12)
            g(r0, r6)
            goto L_0x01f7
        L_0x0120:
            r13 = 352(0x160, float:4.93E-43)
            com.google.android.exoplayer2.Format$Builder r13 = r0.n0(r13)
            r1 = 288(0x120, float:4.04E-43)
            r13.S(r1)
            goto L_0x01f7
        L_0x012d:
            boolean r13 = r6.isEmpty()
            r13 = r13 ^ r10
            com.google.android.exoplayer2.util.Assertions.a(r13)
            i(r0, r6)
            goto L_0x01f7
        L_0x013a:
            if (r2 == r3) goto L_0x013e
            r13 = 1
            goto L_0x013f
        L_0x013e:
            r13 = 0
        L_0x013f:
            com.google.android.exoplayer2.util.Assertions.a(r13)
            r13 = 48000(0xbb80, float:6.7262E-41)
            if (r5 != r13) goto L_0x0149
            r13 = 1
            goto L_0x014a
        L_0x0149:
            r13 = 0
        L_0x014a:
            java.lang.String r1 = "Invalid OPUS clock rate."
            com.google.android.exoplayer2.util.Assertions.b(r13, r1)
            goto L_0x01f7
        L_0x0151:
            if (r2 != r10) goto L_0x0155
            r13 = 1
            goto L_0x0156
        L_0x0155:
            r13 = 0
        L_0x0156:
            java.lang.String r1 = "Multi channel AMR is not currently supported."
            com.google.android.exoplayer2.util.Assertions.b(r13, r1)
            boolean r13 = r6.isEmpty()
            r13 = r13 ^ r10
            java.lang.String r1 = "fmtp parameters must include octet-align."
            com.google.android.exoplayer2.util.Assertions.b(r13, r1)
            java.lang.String r13 = "octet-align"
            boolean r13 = r6.containsKey(r13)
            java.lang.String r1 = "Only octet aligned mode is currently supported."
            com.google.android.exoplayer2.util.Assertions.b(r13, r1)
            java.lang.String r13 = "interleaving"
            boolean r13 = r6.containsKey(r13)
            r13 = r13 ^ r10
            java.lang.String r1 = "Interleaving mode is not currently supported."
            com.google.android.exoplayer2.util.Assertions.b(r13, r1)
            goto L_0x01f7
        L_0x017e:
            if (r2 == r3) goto L_0x0182
            r13 = 1
            goto L_0x0183
        L_0x0182:
            r13 = 0
        L_0x0183:
            com.google.android.exoplayer2.util.Assertions.a(r13)
            boolean r13 = r6.isEmpty()
            r13 = r13 ^ r10
            com.google.android.exoplayer2.util.Assertions.b(r13, r12)
            java.lang.String r13 = "MP4A-LATM"
            boolean r13 = r7.equals(r13)
            if (r13 == 0) goto L_0x01f4
            java.lang.String r13 = "cpresent"
            boolean r1 = r6.containsKey(r13)
            if (r1 == 0) goto L_0x01ae
            java.lang.Object r13 = r6.get(r13)
            java.lang.String r13 = (java.lang.String) r13
            java.lang.String r1 = "0"
            boolean r13 = r13.equals(r1)
            if (r13 == 0) goto L_0x01ae
            r13 = 1
            goto L_0x01af
        L_0x01ae:
            r13 = 0
        L_0x01af:
            java.lang.String r1 = "Only supports cpresent=0 in AAC audio."
            com.google.android.exoplayer2.util.Assertions.b(r13, r1)
            java.lang.String r13 = "config"
            java.lang.Object r13 = r6.get(r13)
            java.lang.String r13 = (java.lang.String) r13
            java.lang.String r1 = "AAC audio stream must include config fmtp parameter"
            com.google.android.exoplayer2.util.Assertions.f(r13, r1)
            int r1 = r13.length()
            int r1 = r1 % r8
            if (r1 != 0) goto L_0x01ca
            r1 = 1
            goto L_0x01cb
        L_0x01ca:
            r1 = 0
        L_0x01cb:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r8 = "Malformat MPEG4 config: "
            r3.append(r8)
            r3.append(r13)
            java.lang.String r3 = r3.toString()
            com.google.android.exoplayer2.util.Assertions.b(r1, r3)
            com.google.android.exoplayer2.audio.AacUtil$Config r13 = e(r13)
            int r1 = r13.f23633a
            com.google.android.exoplayer2.Format$Builder r1 = r0.h0(r1)
            int r3 = r13.f23634b
            com.google.android.exoplayer2.Format$Builder r1 = r1.J(r3)
            java.lang.String r13 = r13.f23635c
            r1.K(r13)
        L_0x01f4:
            f(r0, r6, r2, r5)
        L_0x01f7:
            if (r5 <= 0) goto L_0x01fa
            r9 = 1
        L_0x01fa:
            com.google.android.exoplayer2.util.Assertions.a(r9)
            com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat r13 = new com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat
            com.google.android.exoplayer2.Format r3 = r0.G()
            r2 = r13
            r2.<init>(r3, r4, r5, r6, r7)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.rtsp.RtspMediaTrack.b(com.google.android.exoplayer2.source.rtsp.MediaDescription):com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat");
    }

    private static byte[] c(String str) {
        byte[] decode = Base64.decode(str, 0);
        int length = decode.length;
        byte[] bArr = NalUnitUtil.f28716a;
        byte[] bArr2 = new byte[(length + bArr.length)];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        System.arraycopy(decode, 0, bArr2, bArr.length, decode.length);
        return bArr2;
    }

    private static int d(int i2, String str) {
        if (i2 != -1) {
            return i2;
        }
        if (str.equals("audio/ac3")) {
            return 6;
        }
        return 1;
    }

    private static AacUtil.Config e(String str) {
        boolean z2;
        boolean z3;
        boolean z4;
        ParsableBitArray parsableBitArray = new ParsableBitArray(Util.J(str));
        boolean z5 = true;
        if (parsableBitArray.h(1) == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.b(z2, "Only supports audio mux version 0.");
        if (parsableBitArray.h(1) == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assertions.b(z3, "Only supports allStreamsSameTimeFraming.");
        parsableBitArray.r(6);
        if (parsableBitArray.h(4) == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.b(z4, "Only supports one program.");
        if (parsableBitArray.h(3) != 0) {
            z5 = false;
        }
        Assertions.b(z5, "Only supports one numLayer.");
        try {
            return AacUtil.e(parsableBitArray, false);
        } catch (ParserException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    private static void f(Format.Builder builder, ImmutableMap<String, String> immutableMap, int i2, int i3) {
        Assertions.b(immutableMap.containsKey("profile-level-id"), "missing profile-level-id param");
        builder.K("mp4a.40." + ((String) Assertions.e(immutableMap.get("profile-level-id"))));
        builder.V(ImmutableList.s(AacUtil.a(i3, i2)));
    }

    private static void g(Format.Builder builder, ImmutableMap<String, String> immutableMap) {
        boolean z2;
        Assertions.b(immutableMap.containsKey("sprop-parameter-sets"), "missing sprop parameter");
        String[] W0 = Util.W0((String) Assertions.e(immutableMap.get("sprop-parameter-sets")), ",");
        if (W0.length == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.b(z2, "empty sprop value");
        ImmutableList t2 = ImmutableList.t(c(W0[0]), c(W0[1]));
        builder.V(t2);
        byte[] bArr = (byte[]) t2.get(0);
        NalUnitUtil.SpsData l2 = NalUnitUtil.l(bArr, NalUnitUtil.f28716a.length, bArr.length);
        builder.c0(l2.f28743h);
        builder.S(l2.f28742g);
        builder.n0(l2.f28741f);
        String str = immutableMap.get("profile-level-id");
        if (str != null) {
            builder.K("avc1." + str);
            return;
        }
        builder.K(CodecSpecificDataUtil.a(l2.f28736a, l2.f28737b, l2.f28738c));
    }

    private static void h(Format.Builder builder, ImmutableMap<String, String> immutableMap) {
        boolean z2;
        if (immutableMap.containsKey("sprop-max-don-diff")) {
            int parseInt = Integer.parseInt((String) Assertions.e(immutableMap.get("sprop-max-don-diff")));
            if (parseInt == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.b(z2, "non-zero sprop-max-don-diff " + parseInt + " is not supported");
        }
        Assertions.b(immutableMap.containsKey("sprop-vps"), "missing sprop-vps parameter");
        Assertions.b(immutableMap.containsKey("sprop-sps"), "missing sprop-sps parameter");
        Assertions.b(immutableMap.containsKey("sprop-pps"), "missing sprop-pps parameter");
        ImmutableList u2 = ImmutableList.u(c((String) Assertions.e(immutableMap.get("sprop-vps"))), c((String) Assertions.e(immutableMap.get("sprop-sps"))), c((String) Assertions.e(immutableMap.get("sprop-pps"))));
        builder.V(u2);
        byte[] bArr = (byte[]) u2.get(1);
        NalUnitUtil.H265SpsData h2 = NalUnitUtil.h(bArr, NalUnitUtil.f28716a.length, bArr.length);
        builder.c0(h2.f28729j);
        builder.S(h2.f28728i).n0(h2.f28727h);
        builder.K(CodecSpecificDataUtil.c(h2.f28720a, h2.f28721b, h2.f28722c, h2.f28723d, h2.f28724e, h2.f28725f));
    }

    private static void i(Format.Builder builder, ImmutableMap<String, String> immutableMap) {
        String str = immutableMap.get("config");
        if (str != null) {
            byte[] J = Util.J(str);
            builder.V(ImmutableList.s(J));
            Pair<Integer, Integer> f2 = CodecSpecificDataUtil.f(J);
            builder.n0(((Integer) f2.first).intValue()).S(((Integer) f2.second).intValue());
        } else {
            builder.n0(352).S(288);
        }
        String str2 = immutableMap.get("profile-level-id");
        StringBuilder sb = new StringBuilder();
        sb.append("mp4v.");
        if (str2 == null) {
            str2 = "1";
        }
        sb.append(str2);
        builder.K(sb.toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RtspMediaTrack.class != obj.getClass()) {
            return false;
        }
        RtspMediaTrack rtspMediaTrack = (RtspMediaTrack) obj;
        if (!this.f26878a.equals(rtspMediaTrack.f26878a) || !this.f26879b.equals(rtspMediaTrack.f26879b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((217 + this.f26878a.hashCode()) * 31) + this.f26879b.hashCode();
    }
}
