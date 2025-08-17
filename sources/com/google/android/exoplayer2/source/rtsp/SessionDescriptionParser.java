package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.rtsp.MediaDescription;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.google.android.exoplayer2.util.Assertions;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class SessionDescriptionParser {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f26957a = Pattern.compile("([a-z])=\\s?(.+)");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f26958b = Pattern.compile("([\\x21\\x23-\\x27\\x2a\\x2b\\x2d\\x2e\\x30-\\x39\\x41-\\x5a\\x5e-\\x7e]+)(?::(.*))?");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f26959c = Pattern.compile("(\\S+)\\s(\\S+)\\s(\\S+)\\s(\\S+)");

    private SessionDescriptionParser() {
    }

    private static void a(SessionDescription.Builder builder, MediaDescription.Builder builder2) throws ParserException {
        try {
            builder.n(builder2.j());
        } catch (IllegalArgumentException | IllegalStateException e2) {
            throw ParserException.c((String) null, e2);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x01b2, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.exoplayer2.source.rtsp.SessionDescription b(java.lang.String r12) throws com.google.android.exoplayer2.ParserException {
        /*
            com.google.android.exoplayer2.source.rtsp.SessionDescription$Builder r0 = new com.google.android.exoplayer2.source.rtsp.SessionDescription$Builder
            r0.<init>()
            java.lang.String[] r12 = com.google.android.exoplayer2.source.rtsp.RtspMessageUtil.s(r12)
            int r1 = r12.length
            r2 = 0
            r3 = 0
            r5 = r2
            r4 = 0
        L_0x000e:
            if (r4 >= r1) goto L_0x01cc
            r6 = r12[r4]
            java.lang.String r7 = ""
            boolean r7 = r7.equals(r6)
            if (r7 == 0) goto L_0x001c
            goto L_0x01b2
        L_0x001c:
            java.util.regex.Pattern r7 = f26957a
            java.util.regex.Matcher r7 = r7.matcher(r6)
            boolean r8 = r7.matches()
            if (r8 == 0) goto L_0x01b6
            r8 = 1
            java.lang.String r9 = r7.group(r8)
            java.lang.Object r9 = com.google.android.exoplayer2.util.Assertions.e(r9)
            java.lang.String r9 = (java.lang.String) r9
            r10 = 2
            java.lang.String r7 = r7.group(r10)
            java.lang.Object r7 = com.google.android.exoplayer2.util.Assertions.e(r7)
            java.lang.String r7 = (java.lang.String) r7
            int r11 = r9.hashCode()
            switch(r11) {
                case 97: goto L_0x00de;
                case 98: goto L_0x00d3;
                case 99: goto L_0x00c9;
                case 100: goto L_0x0045;
                case 101: goto L_0x00bf;
                case 102: goto L_0x0045;
                case 103: goto L_0x0045;
                case 104: goto L_0x0045;
                case 105: goto L_0x00b5;
                case 106: goto L_0x0045;
                case 107: goto L_0x00aa;
                case 108: goto L_0x0045;
                case 109: goto L_0x009f;
                case 110: goto L_0x0045;
                case 111: goto L_0x0095;
                case 112: goto L_0x008b;
                case 113: goto L_0x0045;
                case 114: goto L_0x0080;
                case 115: goto L_0x0075;
                case 116: goto L_0x0069;
                case 117: goto L_0x005e;
                case 118: goto L_0x0053;
                case 119: goto L_0x0045;
                case 120: goto L_0x0045;
                case 121: goto L_0x0045;
                case 122: goto L_0x0047;
                default: goto L_0x0045;
            }
        L_0x0045:
            goto L_0x00e9
        L_0x0047:
            java.lang.String r11 = "z"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x00e9
            r9 = 14
            goto L_0x00ea
        L_0x0053:
            java.lang.String r11 = "v"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x00e9
            r9 = 0
            goto L_0x00ea
        L_0x005e:
            java.lang.String r11 = "u"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x00e9
            r9 = 4
            goto L_0x00ea
        L_0x0069:
            java.lang.String r11 = "t"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x00e9
            r9 = 9
            goto L_0x00ea
        L_0x0075:
            java.lang.String r11 = "s"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x00e9
            r9 = 2
            goto L_0x00ea
        L_0x0080:
            java.lang.String r11 = "r"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x00e9
            r9 = 13
            goto L_0x00ea
        L_0x008b:
            java.lang.String r11 = "p"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x00e9
            r9 = 6
            goto L_0x00ea
        L_0x0095:
            java.lang.String r11 = "o"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x00e9
            r9 = 1
            goto L_0x00ea
        L_0x009f:
            java.lang.String r11 = "m"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x00e9
            r9 = 12
            goto L_0x00ea
        L_0x00aa:
            java.lang.String r11 = "k"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x00e9
            r9 = 10
            goto L_0x00ea
        L_0x00b5:
            java.lang.String r11 = "i"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x00e9
            r9 = 3
            goto L_0x00ea
        L_0x00bf:
            java.lang.String r11 = "e"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x00e9
            r9 = 5
            goto L_0x00ea
        L_0x00c9:
            java.lang.String r11 = "c"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x00e9
            r9 = 7
            goto L_0x00ea
        L_0x00d3:
            java.lang.String r11 = "b"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x00e9
            r9 = 8
            goto L_0x00ea
        L_0x00de:
            java.lang.String r11 = "a"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x00e9
            r9 = 11
            goto L_0x00ea
        L_0x00e9:
            r9 = -1
        L_0x00ea:
            switch(r9) {
                case 0: goto L_0x019a;
                case 1: goto L_0x0196;
                case 2: goto L_0x0192;
                case 3: goto L_0x0188;
                case 4: goto L_0x0180;
                case 5: goto L_0x017c;
                case 6: goto L_0x0178;
                case 7: goto L_0x016e;
                case 8: goto L_0x014b;
                case 9: goto L_0x0146;
                case 10: goto L_0x013a;
                case 11: goto L_0x00fa;
                case 12: goto L_0x00ef;
                default: goto L_0x00ed;
            }
        L_0x00ed:
            goto L_0x01b2
        L_0x00ef:
            if (r5 == 0) goto L_0x00f4
            a(r0, r5)
        L_0x00f4:
            com.google.android.exoplayer2.source.rtsp.MediaDescription$Builder r5 = c(r7)
            goto L_0x01b2
        L_0x00fa:
            java.util.regex.Pattern r9 = f26958b
            java.util.regex.Matcher r7 = r9.matcher(r7)
            boolean r9 = r7.matches()
            if (r9 == 0) goto L_0x0124
            java.lang.String r6 = r7.group(r8)
            java.lang.Object r6 = com.google.android.exoplayer2.util.Assertions.e(r6)
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r7 = r7.group(r10)
            java.lang.String r7 = com.google.common.base.Strings.d(r7)
            if (r5 != 0) goto L_0x011f
            r0.m(r6, r7)
            goto L_0x01b2
        L_0x011f:
            r5.i(r6, r7)
            goto L_0x01b2
        L_0x0124:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "Malformed Attribute line: "
            r12.append(r0)
            r12.append(r6)
            java.lang.String r12 = r12.toString()
            com.google.android.exoplayer2.ParserException r12 = com.google.android.exoplayer2.ParserException.c(r12, r2)
            throw r12
        L_0x013a:
            if (r5 != 0) goto L_0x0141
            r0.s(r7)
            goto L_0x01b2
        L_0x0141:
            r5.o(r7)
            goto L_0x01b2
        L_0x0146:
            r0.x(r7)
            goto L_0x01b2
        L_0x014b:
            java.lang.String r6 = ":\\s?"
            java.lang.String[] r6 = com.google.android.exoplayer2.util.Util.W0(r7, r6)
            int r7 = r6.length
            if (r7 != r10) goto L_0x0156
            r7 = 1
            goto L_0x0157
        L_0x0156:
            r7 = 0
        L_0x0157:
            com.google.android.exoplayer2.util.Assertions.a(r7)
            r6 = r6[r8]
            int r6 = java.lang.Integer.parseInt(r6)
            if (r5 != 0) goto L_0x0168
            int r6 = r6 * 1000
            r0.p(r6)
            goto L_0x01b2
        L_0x0168:
            int r6 = r6 * 1000
            r5.m(r6)
            goto L_0x01b2
        L_0x016e:
            if (r5 != 0) goto L_0x0174
            r0.q(r7)
            goto L_0x01b2
        L_0x0174:
            r5.n(r7)
            goto L_0x01b2
        L_0x0178:
            r0.u(r7)
            goto L_0x01b2
        L_0x017c:
            r0.r(r7)
            goto L_0x01b2
        L_0x0180:
            android.net.Uri r6 = android.net.Uri.parse(r7)
            r0.y(r6)
            goto L_0x01b2
        L_0x0188:
            if (r5 != 0) goto L_0x018e
            r0.v(r7)
            goto L_0x01b2
        L_0x018e:
            r5.p(r7)
            goto L_0x01b2
        L_0x0192:
            r0.w(r7)
            goto L_0x01b2
        L_0x0196:
            r0.t(r7)
            goto L_0x01b2
        L_0x019a:
            java.lang.String r6 = "0"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x01a3
            goto L_0x01b2
        L_0x01a3:
            java.lang.Object[] r12 = new java.lang.Object[r8]
            r12[r3] = r7
            java.lang.String r0 = "SDP version %s is not supported."
            java.lang.String r12 = java.lang.String.format(r0, r12)
            com.google.android.exoplayer2.ParserException r12 = com.google.android.exoplayer2.ParserException.c(r12, r2)
            throw r12
        L_0x01b2:
            int r4 = r4 + 1
            goto L_0x000e
        L_0x01b6:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "Malformed SDP line: "
            r12.append(r0)
            r12.append(r6)
            java.lang.String r12 = r12.toString()
            com.google.android.exoplayer2.ParserException r12 = com.google.android.exoplayer2.ParserException.c(r12, r2)
            throw r12
        L_0x01cc:
            if (r5 == 0) goto L_0x01d1
            a(r0, r5)
        L_0x01d1:
            com.google.android.exoplayer2.source.rtsp.SessionDescription r12 = r0.o()     // Catch:{ IllegalArgumentException -> 0x01d8, IllegalStateException -> 0x01d6 }
            return r12
        L_0x01d6:
            r12 = move-exception
            goto L_0x01d9
        L_0x01d8:
            r12 = move-exception
        L_0x01d9:
            com.google.android.exoplayer2.ParserException r12 = com.google.android.exoplayer2.ParserException.c(r2, r12)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.rtsp.SessionDescriptionParser.b(java.lang.String):com.google.android.exoplayer2.source.rtsp.SessionDescription");
    }

    private static MediaDescription.Builder c(String str) throws ParserException {
        Matcher matcher = f26959c.matcher(str);
        if (matcher.matches()) {
            String str2 = (String) Assertions.e(matcher.group(1));
            String str3 = (String) Assertions.e(matcher.group(2));
            try {
                return new MediaDescription.Builder(str2, Integer.parseInt(str3), (String) Assertions.e(matcher.group(3)), Integer.parseInt((String) Assertions.e(matcher.group(4))));
            } catch (NumberFormatException e2) {
                throw ParserException.c("Malformed SDP media description line: " + str, e2);
            }
        } else {
            throw ParserException.c("Malformed SDP media description line: " + str, (Throwable) null);
        }
    }
}
