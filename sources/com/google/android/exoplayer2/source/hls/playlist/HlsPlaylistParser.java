package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.protobuf.CodedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

public final class HlsPlaylistParser implements ParsingLoadable.Parser<HlsPlaylist> {
    private static final Pattern A = Pattern.compile("LAST-MSN=(\\d+)\\b");
    private static final Pattern B = Pattern.compile("LAST-PART=(\\d+)\\b");
    private static final Pattern C = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    private static final Pattern D = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    private static final Pattern E = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    private static final Pattern F = Pattern.compile("BYTERANGE-START=(\\d+)\\b");
    private static final Pattern G = Pattern.compile("BYTERANGE-LENGTH=(\\d+)\\b");
    private static final Pattern H = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");
    private static final Pattern I = Pattern.compile("KEYFORMAT=\"(.+?)\"");
    private static final Pattern J = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");
    private static final Pattern K = Pattern.compile("URI=\"(.+?)\"");
    private static final Pattern L = Pattern.compile("IV=([^,.*]+)");
    private static final Pattern M = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    private static final Pattern N = Pattern.compile("TYPE=(PART|MAP)");
    private static final Pattern O = Pattern.compile("LANGUAGE=\"(.+?)\"");
    private static final Pattern P = Pattern.compile("NAME=\"(.+?)\"");
    private static final Pattern Q = Pattern.compile("GROUP-ID=\"(.+?)\"");
    private static final Pattern R = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");
    private static final Pattern S = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    private static final Pattern T = c("AUTOSELECT");
    private static final Pattern U = c("DEFAULT");
    private static final Pattern V = c("FORCED");
    private static final Pattern W = c("INDEPENDENT");
    private static final Pattern X = c("GAP");
    private static final Pattern Y = c("PRECISE");
    private static final Pattern Z = Pattern.compile("VALUE=\"(.+?)\"");

    /* renamed from: a0  reason: collision with root package name */
    private static final Pattern f26648a0 = Pattern.compile("IMPORT=\"(.+?)\"");

    /* renamed from: b0  reason: collision with root package name */
    private static final Pattern f26649b0 = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f26650c = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f26651d = Pattern.compile("VIDEO=\"(.+?)\"");

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f26652e = Pattern.compile("AUDIO=\"(.+?)\"");

    /* renamed from: f  reason: collision with root package name */
    private static final Pattern f26653f = Pattern.compile("SUBTITLES=\"(.+?)\"");

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f26654g = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");

    /* renamed from: h  reason: collision with root package name */
    private static final Pattern f26655h = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");

    /* renamed from: i  reason: collision with root package name */
    private static final Pattern f26656i = Pattern.compile("CHANNELS=\"(.+?)\"");

    /* renamed from: j  reason: collision with root package name */
    private static final Pattern f26657j = Pattern.compile("CODECS=\"(.+?)\"");

    /* renamed from: k  reason: collision with root package name */
    private static final Pattern f26658k = Pattern.compile("RESOLUTION=(\\d+x\\d+)");

    /* renamed from: l  reason: collision with root package name */
    private static final Pattern f26659l = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");

    /* renamed from: m  reason: collision with root package name */
    private static final Pattern f26660m = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");

    /* renamed from: n  reason: collision with root package name */
    private static final Pattern f26661n = Pattern.compile("DURATION=([\\d\\.]+)\\b");

    /* renamed from: o  reason: collision with root package name */
    private static final Pattern f26662o = Pattern.compile("PART-TARGET=([\\d\\.]+)\\b");

    /* renamed from: p  reason: collision with root package name */
    private static final Pattern f26663p = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");

    /* renamed from: q  reason: collision with root package name */
    private static final Pattern f26664q = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");

    /* renamed from: r  reason: collision with root package name */
    private static final Pattern f26665r = Pattern.compile("CAN-SKIP-UNTIL=([\\d\\.]+)\\b");

    /* renamed from: s  reason: collision with root package name */
    private static final Pattern f26666s = c("CAN-SKIP-DATERANGES");

    /* renamed from: t  reason: collision with root package name */
    private static final Pattern f26667t = Pattern.compile("SKIPPED-SEGMENTS=(\\d+)\\b");

    /* renamed from: u  reason: collision with root package name */
    private static final Pattern f26668u = Pattern.compile("[:|,]HOLD-BACK=([\\d\\.]+)\\b");

    /* renamed from: v  reason: collision with root package name */
    private static final Pattern f26669v = Pattern.compile("PART-HOLD-BACK=([\\d\\.]+)\\b");

    /* renamed from: w  reason: collision with root package name */
    private static final Pattern f26670w = c("CAN-BLOCK-RELOAD");

    /* renamed from: x  reason: collision with root package name */
    private static final Pattern f26671x = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");

    /* renamed from: y  reason: collision with root package name */
    private static final Pattern f26672y = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");

    /* renamed from: z  reason: collision with root package name */
    private static final Pattern f26673z = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");

    /* renamed from: a  reason: collision with root package name */
    private final HlsMultivariantPlaylist f26674a;

    /* renamed from: b  reason: collision with root package name */
    private final HlsMediaPlaylist f26675b;

    public static final class DeltaUpdateException extends IOException {
    }

    private static class LineIterator {

        /* renamed from: a  reason: collision with root package name */
        private final BufferedReader f26676a;

        /* renamed from: b  reason: collision with root package name */
        private final Queue<String> f26677b;

        /* renamed from: c  reason: collision with root package name */
        private String f26678c;

        public LineIterator(Queue<String> queue, BufferedReader bufferedReader) {
            this.f26677b = queue;
            this.f26676a = bufferedReader;
        }

        @EnsuresNonNullIf(expression = {"next"}, result = true)
        public boolean a() throws IOException {
            String trim;
            if (this.f26678c != null) {
                return true;
            }
            if (!this.f26677b.isEmpty()) {
                this.f26678c = (String) Assertions.e(this.f26677b.poll());
                return true;
            }
            do {
                String readLine = this.f26676a.readLine();
                this.f26678c = readLine;
                if (readLine == null) {
                    return false;
                }
                trim = readLine.trim();
                this.f26678c = trim;
            } while (trim.isEmpty());
            return true;
        }

        public String b() throws IOException {
            if (a()) {
                String str = this.f26678c;
                this.f26678c = null;
                return str;
            }
            throw new NoSuchElementException();
        }
    }

    public HlsPlaylistParser() {
        this(HlsMultivariantPlaylist.f26624n, (HlsMediaPlaylist) null);
    }

    private static long A(String str, Pattern pattern) throws ParserException {
        return new BigDecimal(z(str, pattern, Collections.emptyMap())).multiply(new BigDecimal(1000000)).longValue();
    }

    private static String B(String str, Map<String, String> map) {
        Matcher matcher = f26649b0.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String group = matcher.group(1);
            if (map.containsKey(group)) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(map.get(group)));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    private static int C(BufferedReader bufferedReader, boolean z2, int i2) throws IOException {
        while (i2 != -1 && Character.isWhitespace(i2) && (z2 || !Util.y0(i2))) {
            i2 = bufferedReader.read();
        }
        return i2;
    }

    private static boolean b(BufferedReader bufferedReader) throws IOException {
        int read = bufferedReader.read();
        if (read == 239) {
            if (bufferedReader.read() != 187 || bufferedReader.read() != 191) {
                return false;
            }
            read = bufferedReader.read();
        }
        int C2 = C(bufferedReader, true, read);
        for (int i2 = 0; i2 < 7; i2++) {
            if (C2 != "#EXTM3U".charAt(i2)) {
                return false;
            }
            C2 = bufferedReader.read();
        }
        return Util.y0(C(bufferedReader, false, C2));
    }

    private static Pattern c(String str) {
        return Pattern.compile(str + "=(" + "NO" + "|" + "YES" + ")");
    }

    private static DrmInitData d(String str, DrmInitData.SchemeData[] schemeDataArr) {
        DrmInitData.SchemeData[] schemeDataArr2 = new DrmInitData.SchemeData[schemeDataArr.length];
        for (int i2 = 0; i2 < schemeDataArr.length; i2++) {
            schemeDataArr2[i2] = schemeDataArr[i2].c((byte[]) null);
        }
        return new DrmInitData(str, schemeDataArr2);
    }

    private static String e(long j2, String str, String str2) {
        if (str == null) {
            return null;
        }
        return str2 != null ? str2 : Long.toHexString(j2);
    }

    private static HlsMultivariantPlaylist.Variant f(ArrayList<HlsMultivariantPlaylist.Variant> arrayList, String str) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            HlsMultivariantPlaylist.Variant variant = arrayList.get(i2);
            if (str.equals(variant.f26642d)) {
                return variant;
            }
        }
        return null;
    }

    private static HlsMultivariantPlaylist.Variant g(ArrayList<HlsMultivariantPlaylist.Variant> arrayList, String str) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            HlsMultivariantPlaylist.Variant variant = arrayList.get(i2);
            if (str.equals(variant.f26643e)) {
                return variant;
            }
        }
        return null;
    }

    private static HlsMultivariantPlaylist.Variant h(ArrayList<HlsMultivariantPlaylist.Variant> arrayList, String str) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            HlsMultivariantPlaylist.Variant variant = arrayList.get(i2);
            if (str.equals(variant.f26641c)) {
                return variant;
            }
        }
        return null;
    }

    private static double j(String str, Pattern pattern) throws ParserException {
        return Double.parseDouble(z(str, pattern, Collections.emptyMap()));
    }

    private static DrmInitData.SchemeData k(String str, String str2, Map<String, String> map) throws ParserException {
        String u2 = u(str, J, "1", map);
        if ("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(str2)) {
            String z2 = z(str, K, map);
            return new DrmInitData.SchemeData(C.f22819d, "video/mp4", Base64.decode(z2.substring(z2.indexOf(44)), 0));
        } else if ("com.widevine".equals(str2)) {
            return new DrmInitData.SchemeData(C.f22819d, "hls", Util.p0(str));
        } else {
            if (!"com.microsoft.playready".equals(str2) || !"1".equals(u2)) {
                return null;
            }
            String z3 = z(str, K, map);
            byte[] decode = Base64.decode(z3.substring(z3.indexOf(44)), 0);
            UUID uuid = C.f22820e;
            return new DrmInitData.SchemeData(uuid, "video/mp4", PsshAtomUtil.a(uuid, decode));
        }
    }

    private static String l(String str) {
        if ("SAMPLE-AES-CENC".equals(str) || "SAMPLE-AES-CTR".equals(str)) {
            return "cenc";
        }
        return "cbcs";
    }

    private static int m(String str, Pattern pattern) throws ParserException {
        return Integer.parseInt(z(str, pattern, Collections.emptyMap()));
    }

    private static long n(String str, Pattern pattern) throws ParserException {
        return Long.parseLong(z(str, pattern, Collections.emptyMap()));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r65v0, resolved type: com.google.android.exoplayer2.drm.DrmInitData} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r65v1, resolved type: com.google.android.exoplayer2.drm.DrmInitData} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v16, resolved type: java.lang.Object} */
    /* JADX WARNING: type inference failed for: r10v0 */
    /* JADX WARNING: type inference failed for: r10v1, types: [boolean] */
    /* JADX WARNING: type inference failed for: r13v4 */
    /* JADX WARNING: type inference failed for: r10v48 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist o(com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist r92, com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist r93, com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser.LineIterator r94, java.lang.String r95) throws java.io.IOException {
        /*
            r0 = r92
            r1 = r93
            boolean r2 = r0.f26647c
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$ServerControl r7 = new com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$ServerControl
            r17 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r19 = 0
            r20 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r22 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r24 = 0
            r16 = r7
            r16.<init>(r17, r19, r20, r22, r24)
            java.util.TreeMap r9 = new java.util.TreeMap
            r9.<init>()
            r10 = 0
            java.lang.String r13 = ""
            r20 = r13
            r35 = r2
            r56 = r7
            r41 = r20
            r2 = 0
            r14 = 0
            r21 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r23 = 0
            r24 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r30 = 1
            r31 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r33 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r36 = 0
            r37 = 0
            r39 = 0
            r50 = 0
            r51 = 0
            r54 = 0
            r75 = -1
            r77 = 0
            r78 = 0
            r79 = 0
            r80 = 0
            r82 = 0
            r84 = 0
            r85 = 0
            r86 = 0
            r88 = 0
            r7 = r5
            r5 = 0
        L_0x008d:
            boolean r42 = r94.a()
            if (r42 == 0) goto L_0x0646
            java.lang.String r13 = r94.b()
            java.lang.String r12 = "#EXT"
            boolean r12 = r13.startsWith(r12)
            if (r12 == 0) goto L_0x00a2
            r8.add(r13)
        L_0x00a2:
            java.lang.String r12 = "#EXT-X-PLAYLIST-TYPE"
            boolean r12 = r13.startsWith(r12)
            if (r12 == 0) goto L_0x00c4
            java.util.regex.Pattern r12 = f26664q
            java.lang.String r12 = z(r13, r12, r3)
            java.lang.String r13 = "VOD"
            boolean r13 = r13.equals(r12)
            if (r13 == 0) goto L_0x00ba
            r2 = 1
            goto L_0x008d
        L_0x00ba:
            java.lang.String r13 = "EVENT"
            boolean r12 = r13.equals(r12)
            if (r12 == 0) goto L_0x008d
            r2 = 2
            goto L_0x008d
        L_0x00c4:
            java.lang.String r12 = "#EXT-X-I-FRAMES-ONLY"
            boolean r12 = r13.equals(r12)
            if (r12 == 0) goto L_0x00cf
            r84 = 1
            goto L_0x008d
        L_0x00cf:
            java.lang.String r12 = "#EXT-X-START"
            boolean r12 = r13.startsWith(r12)
            r43 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            if (r12 == 0) goto L_0x00ee
            java.util.regex.Pattern r12 = C
            double r21 = j(r13, r12)
            double r11 = r21 * r43
            long r11 = (long) r11
            r21 = r11
            java.util.regex.Pattern r11 = Y
            boolean r23 = q(r13, r11, r10)
            goto L_0x008d
        L_0x00ee:
            java.lang.String r11 = "#EXT-X-SERVER-CONTROL"
            boolean r11 = r13.startsWith(r11)
            if (r11 == 0) goto L_0x00fb
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$ServerControl r56 = y(r13)
            goto L_0x008d
        L_0x00fb:
            java.lang.String r11 = "#EXT-X-PART-INF"
            boolean r11 = r13.startsWith(r11)
            if (r11 == 0) goto L_0x0110
            java.util.regex.Pattern r11 = f26662o
            double r11 = j(r13, r11)
            double r11 = r11 * r43
            long r11 = (long) r11
            r33 = r11
            goto L_0x008d
        L_0x0110:
            java.lang.String r11 = "#EXT-X-MAP"
            boolean r11 = r13.startsWith(r11)
            java.lang.String r12 = "@"
            if (r11 == 0) goto L_0x016f
            java.util.regex.Pattern r11 = K
            java.lang.String r43 = z(r13, r11, r3)
            java.util.regex.Pattern r11 = E
            java.lang.String r11 = v(r13, r11, r3)
            if (r11 == 0) goto L_0x013e
            java.lang.String[] r11 = com.google.android.exoplayer2.util.Util.W0(r11, r12)
            r12 = r11[r10]
            long r75 = java.lang.Long.parseLong(r12)
            int r12 = r11.length
            r13 = 1
            if (r12 <= r13) goto L_0x013e
            r11 = r11[r13]
            long r11 = java.lang.Long.parseLong(r11)
            r39 = r11
        L_0x013e:
            r11 = -1
            int r13 = (r75 > r11 ? 1 : (r75 == r11 ? 0 : -1))
            if (r13 != 0) goto L_0x0146
            r39 = 0
        L_0x0146:
            r11 = r77
            if (r14 == 0) goto L_0x0155
            if (r11 == 0) goto L_0x014d
            goto L_0x0155
        L_0x014d:
            java.lang.String r0 = "The encryption IV attribute must be present when an initialization segment is encrypted with METHOD=AES-128."
            r12 = 0
            com.google.android.exoplayer2.ParserException r0 = com.google.android.exoplayer2.ParserException.c(r0, r12)
            throw r0
        L_0x0155:
            r12 = 0
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Segment r85 = new com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Segment
            r42 = r85
            r44 = r39
            r46 = r75
            r48 = r14
            r49 = r11
            r42.<init>(r43, r44, r46, r48, r49)
            if (r13 == 0) goto L_0x0169
            long r39 = r39 + r75
        L_0x0169:
            r77 = r11
            r75 = -1
            goto L_0x008d
        L_0x016f:
            r11 = r77
            r77 = 0
            java.lang.String r10 = "#EXT-X-TARGETDURATION"
            boolean r10 = r13.startsWith(r10)
            if (r10 == 0) goto L_0x018c
            java.util.regex.Pattern r10 = f26660m
            int r10 = m(r13, r10)
            long r12 = (long) r10
            r31 = 1000000(0xf4240, double:4.940656E-318)
            long r31 = r31 * r12
        L_0x0187:
            r77 = r11
        L_0x0189:
            r10 = 0
            goto L_0x008d
        L_0x018c:
            java.lang.String r10 = "#EXT-X-MEDIA-SEQUENCE"
            boolean r10 = r13.startsWith(r10)
            if (r10 == 0) goto L_0x019f
            java.util.regex.Pattern r10 = f26671x
            long r82 = n(r13, r10)
            r77 = r11
            r28 = r82
            goto L_0x0189
        L_0x019f:
            java.lang.String r10 = "#EXT-X-VERSION"
            boolean r10 = r13.startsWith(r10)
            if (r10 == 0) goto L_0x01ae
            java.util.regex.Pattern r10 = f26663p
            int r30 = m(r13, r10)
            goto L_0x0187
        L_0x01ae:
            java.lang.String r10 = "#EXT-X-DEFINE"
            boolean r10 = r13.startsWith(r10)
            if (r10 == 0) goto L_0x01e9
            java.util.regex.Pattern r10 = f26648a0
            java.lang.String r10 = v(r13, r10, r3)
            if (r10 == 0) goto L_0x01cc
            java.util.Map<java.lang.String, java.lang.String> r12 = r0.f26633l
            java.lang.Object r12 = r12.get(r10)
            java.lang.String r12 = (java.lang.String) r12
            if (r12 == 0) goto L_0x01db
            r3.put(r10, r12)
            goto L_0x01db
        L_0x01cc:
            java.util.regex.Pattern r10 = P
            java.lang.String r10 = z(r13, r10, r3)
            java.util.regex.Pattern r12 = Z
            java.lang.String r12 = z(r13, r12, r3)
            r3.put(r10, r12)
        L_0x01db:
            r12 = r7
            r91 = r8
            r10 = r78
            r7 = r82
            r1 = 0
            r78 = r2
        L_0x01e5:
            r82 = r5
            goto L_0x0633
        L_0x01e9:
            java.lang.String r10 = "#EXTINF"
            boolean r10 = r13.startsWith(r10)
            if (r10 == 0) goto L_0x0200
            java.util.regex.Pattern r10 = f26672y
            long r86 = A(r13, r10)
            java.util.regex.Pattern r10 = f26673z
            r12 = r20
            java.lang.String r41 = u(r13, r10, r12, r3)
            goto L_0x0187
        L_0x0200:
            r10 = r20
            java.lang.String r0 = "#EXT-X-SKIP"
            boolean r0 = r13.startsWith(r0)
            r45 = 1
            if (r0 == 0) goto L_0x02b6
            java.util.regex.Pattern r0 = f26667t
            int r0 = m(r13, r0)
            if (r1 == 0) goto L_0x021c
            boolean r12 = r15.isEmpty()
            if (r12 == 0) goto L_0x021c
            r12 = 1
            goto L_0x021d
        L_0x021c:
            r12 = 0
        L_0x021d:
            com.google.android.exoplayer2.util.Assertions.g(r12)
            java.lang.Object r12 = com.google.android.exoplayer2.util.Util.j(r93)
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist r12 = (com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist) r12
            long r12 = r12.f26589k
            long r12 = r28 - r12
            int r13 = (int) r12
            int r0 = r0 + r13
            if (r13 < 0) goto L_0x02b0
            java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Segment> r12 = r1.f26596r
            int r12 = r12.size()
            if (r0 > r12) goto L_0x02b0
            r20 = r10
            r12 = r11
            r10 = r80
        L_0x023b:
            if (r13 >= r0) goto L_0x02a4
            java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Segment> r14 = r1.f26596r
            java.lang.Object r14 = r14.get(r13)
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Segment r14 = (com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment) r14
            r55 = r7
            r91 = r8
            long r7 = r1.f26589k
            int r38 = (r28 > r7 ? 1 : (r28 == r7 ? 0 : -1))
            if (r38 == 0) goto L_0x025a
            int r7 = r1.f26588j
            int r7 = r7 - r27
            int r8 = r14.f26611e
            int r7 = r7 + r8
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Segment r14 = r14.b(r10, r7)
        L_0x025a:
            r15.add(r14)
            long r7 = r14.f26610d
            long r10 = r10 + r7
            long r7 = r14.f26617k
            r42 = -1
            int r38 = (r7 > r42 ? 1 : (r7 == r42 ? 0 : -1))
            if (r38 == 0) goto L_0x026f
            r38 = r0
            long r0 = r14.f26616j
            long r39 = r0 + r7
            goto L_0x0271
        L_0x026f:
            r38 = r0
        L_0x0271:
            int r0 = r14.f26611e
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Segment r1 = r14.f26609c
            com.google.android.exoplayer2.drm.DrmInitData r7 = r14.f26613g
            java.lang.String r8 = r14.f26614h
            r42 = r0
            java.lang.String r0 = r14.f26615i
            r43 = r1
            if (r0 == 0) goto L_0x028b
            java.lang.String r1 = java.lang.Long.toHexString(r82)
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x028e
        L_0x028b:
            java.lang.String r0 = r14.f26615i
            r12 = r0
        L_0x028e:
            long r82 = r82 + r45
            int r13 = r13 + 1
            r1 = r93
            r50 = r7
            r14 = r8
            r51 = r10
            r0 = r38
            r79 = r42
            r85 = r43
            r7 = r55
            r8 = r91
            goto L_0x023b
        L_0x02a4:
            r55 = r7
            r0 = r92
            r1 = r93
            r80 = r10
            r77 = r12
            goto L_0x0189
        L_0x02b0:
            com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser$DeltaUpdateException r0 = new com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser$DeltaUpdateException
            r0.<init>()
            throw r0
        L_0x02b6:
            r55 = r7
            r91 = r8
            r20 = r10
            java.lang.String r0 = "#EXT-X-KEY"
            boolean r0 = r13.startsWith(r0)
            if (r0 == 0) goto L_0x0320
            java.util.regex.Pattern r0 = H
            java.lang.String r0 = z(r13, r0, r3)
            java.util.regex.Pattern r1 = I
            java.lang.String r7 = "identity"
            java.lang.String r1 = u(r13, r1, r7, r3)
            java.lang.String r8 = "NONE"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x02e3
            r9.clear()
            r8 = r77
            r14 = r8
        L_0x02e0:
            r50 = r14
            goto L_0x0319
        L_0x02e3:
            java.util.regex.Pattern r8 = L
            java.lang.String r8 = v(r13, r8, r3)
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0302
            java.lang.String r1 = "AES-128"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x02ff
            java.util.regex.Pattern r0 = K
            java.lang.String r0 = z(r13, r0, r3)
            r14 = r0
            goto L_0x0319
        L_0x02ff:
            r14 = r77
            goto L_0x0319
        L_0x0302:
            r7 = r78
            if (r7 != 0) goto L_0x030b
            java.lang.String r78 = l(r0)
            goto L_0x030d
        L_0x030b:
            r78 = r7
        L_0x030d:
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData r0 = k(r13, r1, r3)
            if (r0 == 0) goto L_0x02ff
            r9.put(r1, r0)
            r14 = r77
            goto L_0x02e0
        L_0x0319:
            r0 = r92
            r1 = r93
            r77 = r8
            goto L_0x034f
        L_0x0320:
            r7 = r78
            java.lang.String r0 = "#EXT-X-BYTERANGE"
            boolean r0 = r13.startsWith(r0)
            if (r0 == 0) goto L_0x0353
            java.util.regex.Pattern r0 = D
            java.lang.String r0 = z(r13, r0, r3)
            java.lang.String[] r0 = com.google.android.exoplayer2.util.Util.W0(r0, r12)
            r1 = 0
            r8 = r0[r1]
            long r75 = java.lang.Long.parseLong(r8)
            int r1 = r0.length
            r8 = 1
            if (r1 <= r8) goto L_0x0347
            r0 = r0[r8]
            long r0 = java.lang.Long.parseLong(r0)
            r39 = r0
        L_0x0347:
            r0 = r92
            r1 = r93
            r78 = r7
            r77 = r11
        L_0x034f:
            r7 = r55
            goto L_0x0642
        L_0x0353:
            r8 = 1
            java.lang.String r0 = "#EXT-X-DISCONTINUITY-SEQUENCE"
            boolean r0 = r13.startsWith(r0)
            r1 = 58
            if (r0 == 0) goto L_0x037c
            int r0 = r13.indexOf(r1)
            int r0 = r0 + r8
            java.lang.String r0 = r13.substring(r0)
            int r27 = java.lang.Integer.parseInt(r0)
            r0 = r92
            r1 = r93
            r78 = r7
            r77 = r11
            r7 = r55
            r8 = r91
            r10 = 0
            r26 = 1
            goto L_0x008d
        L_0x037c:
            java.lang.String r0 = "#EXT-X-DISCONTINUITY"
            boolean r0 = r13.equals(r0)
            if (r0 == 0) goto L_0x0387
            int r79 = r79 + 1
            goto L_0x0347
        L_0x0387:
            java.lang.String r0 = "#EXT-X-PROGRAM-DATE-TIME"
            boolean r0 = r13.startsWith(r0)
            if (r0 == 0) goto L_0x03b4
            r18 = 0
            int r0 = (r24 > r18 ? 1 : (r24 == r18 ? 0 : -1))
            if (r0 != 0) goto L_0x03aa
            int r0 = r13.indexOf(r1)
            r1 = 1
            int r0 = r0 + r1
            java.lang.String r0 = r13.substring(r0)
            long r0 = com.google.android.exoplayer2.util.Util.M0(r0)
            long r0 = com.google.android.exoplayer2.util.Util.F0(r0)
            long r24 = r0 - r80
            goto L_0x0347
        L_0x03aa:
            r78 = r2
            r10 = r7
        L_0x03ad:
            r12 = r55
            r7 = r82
            r1 = 0
            goto L_0x01e5
        L_0x03b4:
            java.lang.String r0 = "#EXT-X-GAP"
            boolean r0 = r13.equals(r0)
            if (r0 == 0) goto L_0x03cd
            r0 = r92
            r1 = r93
            r78 = r7
            r77 = r11
            r7 = r55
            r8 = r91
            r10 = 0
            r54 = 1
            goto L_0x008d
        L_0x03cd:
            java.lang.String r0 = "#EXT-X-INDEPENDENT-SEGMENTS"
            boolean r0 = r13.equals(r0)
            if (r0 == 0) goto L_0x03e6
            r0 = r92
            r1 = r93
            r78 = r7
            r77 = r11
            r7 = r55
            r8 = r91
            r10 = 0
            r35 = 1
            goto L_0x008d
        L_0x03e6:
            java.lang.String r0 = "#EXT-X-ENDLIST"
            boolean r0 = r13.equals(r0)
            if (r0 == 0) goto L_0x03ff
            r0 = r92
            r1 = r93
            r78 = r7
            r77 = r11
            r7 = r55
            r8 = r91
            r10 = 0
            r36 = 1
            goto L_0x008d
        L_0x03ff:
            java.lang.String r0 = "#EXT-X-RENDITION-REPORT"
            boolean r0 = r13.startsWith(r0)
            if (r0 == 0) goto L_0x0433
            java.util.regex.Pattern r0 = A
            r78 = r2
            r10 = r7
            r1 = -1
            long r7 = t(r13, r0, r1)
            java.util.regex.Pattern r0 = B
            r1 = -1
            int r0 = s(r13, r0, r1)
            java.util.regex.Pattern r1 = K
            java.lang.String r1 = z(r13, r1, r3)
            r2 = r95
            java.lang.String r1 = com.google.android.exoplayer2.util.UriUtil.d(r2, r1)
            android.net.Uri r1 = android.net.Uri.parse(r1)
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$RenditionReport r12 = new com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$RenditionReport
            r12.<init>(r1, r7, r0)
            r6.add(r12)
            goto L_0x03ad
        L_0x0433:
            r78 = r2
            r10 = r7
            r2 = r95
            java.lang.String r0 = "#EXT-X-PRELOAD-HINT"
            boolean r0 = r13.startsWith(r0)
            if (r0 == 0) goto L_0x04cb
            if (r5 == 0) goto L_0x0444
        L_0x0442:
            goto L_0x03ad
        L_0x0444:
            java.util.regex.Pattern r0 = N
            java.lang.String r0 = z(r13, r0, r3)
            java.lang.String r1 = "PART"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0453
            goto L_0x0442
        L_0x0453:
            java.util.regex.Pattern r0 = K
            java.lang.String r58 = z(r13, r0, r3)
            java.util.regex.Pattern r0 = F
            r7 = -1
            long r0 = t(r13, r0, r7)
            java.util.regex.Pattern r12 = G
            long r70 = t(r13, r12, r7)
            r7 = r82
            java.lang.String r67 = e(r7, r14, r11)
            if (r50 != 0) goto L_0x048f
            boolean r12 = r9.isEmpty()
            if (r12 != 0) goto L_0x048f
            java.util.Collection r12 = r9.values()
            r13 = 0
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData[] r2 = new com.google.android.exoplayer2.drm.DrmInitData.SchemeData[r13]
            java.lang.Object[] r2 = r12.toArray(r2)
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData[] r2 = (com.google.android.exoplayer2.drm.DrmInitData.SchemeData[]) r2
            com.google.android.exoplayer2.drm.DrmInitData r12 = new com.google.android.exoplayer2.drm.DrmInitData
            r12.<init>((java.lang.String) r10, (com.google.android.exoplayer2.drm.DrmInitData.SchemeData[]) r2)
            if (r37 != 0) goto L_0x048d
            com.google.android.exoplayer2.drm.DrmInitData r37 = d(r10, r2)
        L_0x048d:
            r50 = r12
        L_0x048f:
            r12 = -1
            int r2 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r2 == 0) goto L_0x0499
            int r38 = (r70 > r12 ? 1 : (r70 == r12 ? 0 : -1))
            if (r38 == 0) goto L_0x04b9
        L_0x0499:
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Part r5 = new com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Part
            r60 = 0
            if (r2 == 0) goto L_0x04a2
            r68 = r0
            goto L_0x04a4
        L_0x04a2:
            r68 = 0
        L_0x04a4:
            r72 = 0
            r73 = 0
            r74 = 1
            r57 = r5
            r59 = r85
            r62 = r79
            r63 = r51
            r65 = r50
            r66 = r14
            r57.<init>(r58, r59, r60, r62, r63, r65, r66, r67, r68, r70, r72, r73, r74)
        L_0x04b9:
            r0 = r92
            r1 = r93
            r82 = r7
            r77 = r11
            r7 = r55
            r2 = r78
            r8 = r91
            r78 = r10
            goto L_0x0189
        L_0x04cb:
            r7 = r82
            java.lang.String r0 = "#EXT-X-PART"
            boolean r0 = r13.startsWith(r0)
            if (r0 == 0) goto L_0x0579
            java.lang.String r67 = e(r7, r14, r11)
            java.util.regex.Pattern r0 = K
            java.lang.String r58 = z(r13, r0, r3)
            java.util.regex.Pattern r0 = f26661n
            double r0 = j(r13, r0)
            double r0 = r0 * r43
            long r0 = (long) r0
            java.util.regex.Pattern r2 = W
            r82 = r5
            r5 = 0
            boolean r2 = q(r13, r2, r5)
            if (r35 == 0) goto L_0x04fc
            boolean r38 = r55.isEmpty()
            if (r38 == 0) goto L_0x04fc
            r38 = 1
            goto L_0x04fe
        L_0x04fc:
            r38 = 0
        L_0x04fe:
            r73 = r2 | r38
            java.util.regex.Pattern r2 = X
            boolean r72 = q(r13, r2, r5)
            java.util.regex.Pattern r2 = E
            java.lang.String r2 = v(r13, r2, r3)
            if (r2 == 0) goto L_0x0527
            java.lang.String[] r2 = com.google.android.exoplayer2.util.Util.W0(r2, r12)
            r12 = r2[r5]
            long r12 = java.lang.Long.parseLong(r12)
            int r5 = r2.length
            r42 = r12
            r12 = 1
            if (r5 <= r12) goto L_0x0524
            r2 = r2[r12]
            long r88 = java.lang.Long.parseLong(r2)
        L_0x0524:
            r12 = -1
            goto L_0x052b
        L_0x0527:
            r12 = -1
            r42 = -1
        L_0x052b:
            int r2 = (r42 > r12 ? 1 : (r42 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x0531
            r88 = 0
        L_0x0531:
            if (r50 != 0) goto L_0x0553
            boolean r5 = r9.isEmpty()
            if (r5 != 0) goto L_0x0553
            java.util.Collection r5 = r9.values()
            r12 = 0
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData[] r13 = new com.google.android.exoplayer2.drm.DrmInitData.SchemeData[r12]
            java.lang.Object[] r5 = r5.toArray(r13)
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData[] r5 = (com.google.android.exoplayer2.drm.DrmInitData.SchemeData[]) r5
            com.google.android.exoplayer2.drm.DrmInitData r12 = new com.google.android.exoplayer2.drm.DrmInitData
            r12.<init>((java.lang.String) r10, (com.google.android.exoplayer2.drm.DrmInitData.SchemeData[]) r5)
            if (r37 != 0) goto L_0x0551
            com.google.android.exoplayer2.drm.DrmInitData r37 = d(r10, r5)
        L_0x0551:
            r50 = r12
        L_0x0553:
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Part r5 = new com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Part
            r57 = r5
            r74 = 0
            r59 = r85
            r60 = r0
            r62 = r79
            r63 = r51
            r65 = r50
            r66 = r14
            r68 = r88
            r70 = r42
            r57.<init>(r58, r59, r60, r62, r63, r65, r66, r67, r68, r70, r72, r73, r74)
            r12 = r55
            r12.add(r5)
            long r51 = r51 + r0
            if (r2 == 0) goto L_0x0633
            long r88 = r88 + r42
            goto L_0x0633
        L_0x0579:
            r82 = r5
            r12 = r55
            java.lang.String r0 = "#"
            boolean r0 = r13.startsWith(r0)
            if (r0 != 0) goto L_0x0632
            java.lang.String r0 = e(r7, r14, r11)
            long r1 = r7 + r45
            java.lang.String r5 = B(r13, r3)
            java.lang.Object r7 = r4.get(r5)
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Segment r7 = (com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment) r7
            r42 = -1
            int r8 = (r75 > r42 ? 1 : (r75 == r42 ? 0 : -1))
            if (r8 != 0) goto L_0x059e
            r57 = 0
            goto L_0x05ba
        L_0x059e:
            if (r84 == 0) goto L_0x05b8
            if (r85 != 0) goto L_0x05b8
            if (r7 != 0) goto L_0x05b8
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Segment r7 = new com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Segment
            r44 = 0
            r48 = 0
            r49 = 0
            r42 = r7
            r43 = r5
            r46 = r39
            r42.<init>(r43, r44, r46, r48, r49)
            r4.put(r5, r7)
        L_0x05b8:
            r57 = r39
        L_0x05ba:
            if (r50 != 0) goto L_0x05dd
            boolean r13 = r9.isEmpty()
            if (r13 != 0) goto L_0x05dd
            java.util.Collection r13 = r9.values()
            r59 = r1
            r1 = 0
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData[] r2 = new com.google.android.exoplayer2.drm.DrmInitData.SchemeData[r1]
            java.lang.Object[] r2 = r13.toArray(r2)
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData[] r2 = (com.google.android.exoplayer2.drm.DrmInitData.SchemeData[]) r2
            com.google.android.exoplayer2.drm.DrmInitData r13 = new com.google.android.exoplayer2.drm.DrmInitData
            r13.<init>((java.lang.String) r10, (com.google.android.exoplayer2.drm.DrmInitData.SchemeData[]) r2)
            if (r37 != 0) goto L_0x05e2
            com.google.android.exoplayer2.drm.DrmInitData r37 = d(r10, r2)
            goto L_0x05e2
        L_0x05dd:
            r59 = r1
            r1 = 0
            r13 = r50
        L_0x05e2:
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Segment r2 = new com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Segment
            if (r85 == 0) goto L_0x05e9
            r40 = r85
            goto L_0x05eb
        L_0x05e9:
            r40 = r7
        L_0x05eb:
            r38 = r2
            r39 = r5
            r42 = r86
            r44 = r79
            r45 = r80
            r47 = r13
            r48 = r14
            r49 = r0
            r50 = r57
            r52 = r75
            r55 = r12
            r38.<init>(r39, r40, r41, r42, r44, r45, r47, r48, r49, r50, r52, r54, r55)
            r15.add(r2)
            long r51 = r80 + r86
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            if (r8 == 0) goto L_0x0612
            long r57 = r57 + r75
        L_0x0612:
            r39 = r57
            r0 = r92
            r1 = r93
            r77 = r11
            r50 = r13
            r41 = r20
            r80 = r51
            r2 = r78
            r5 = r82
            r8 = r91
            r54 = 0
            r75 = -1
            r86 = 0
            r78 = r10
            r82 = r59
            goto L_0x0189
        L_0x0632:
            r1 = 0
        L_0x0633:
            r0 = r92
            r1 = r93
            r77 = r11
            r2 = r78
            r5 = r82
            r82 = r7
            r78 = r10
            r7 = r12
        L_0x0642:
            r8 = r91
            goto L_0x0189
        L_0x0646:
            r78 = r2
            r82 = r5
            r12 = r7
            r91 = r8
            r1 = 0
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r2 = 0
        L_0x0654:
            int r3 = r6.size()
            if (r2 >= r3) goto L_0x06b0
            java.lang.Object r3 = r6.get(r2)
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$RenditionReport r3 = (com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.RenditionReport) r3
            long r4 = r3.f26604b
            r7 = -1
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x0675
            int r4 = r15.size()
            long r4 = (long) r4
            long r4 = r28 + r4
            boolean r9 = r12.isEmpty()
            long r9 = (long) r9
            long r4 = r4 - r9
        L_0x0675:
            int r9 = r3.f26605c
            r10 = -1
            if (r9 != r10) goto L_0x069c
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r11 = (r33 > r13 ? 1 : (r33 == r13 ? 0 : -1))
            if (r11 == 0) goto L_0x069a
            boolean r9 = r12.isEmpty()
            if (r9 == 0) goto L_0x0692
            java.lang.Object r9 = com.google.common.collect.Iterables.d(r15)
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Segment r9 = (com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment) r9
            java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Part> r9 = r9.f26607n
            goto L_0x0693
        L_0x0692:
            r9 = r12
        L_0x0693:
            int r9 = r9.size()
            r11 = 1
            int r9 = r9 - r11
            goto L_0x06a2
        L_0x069a:
            r11 = 1
            goto L_0x06a2
        L_0x069c:
            r11 = 1
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x06a2:
            android.net.Uri r3 = r3.f26603a
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$RenditionReport r1 = new com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$RenditionReport
            r1.<init>(r3, r4, r9)
            r0.put(r3, r1)
            int r2 = r2 + 1
            r1 = 0
            goto L_0x0654
        L_0x06b0:
            r11 = 1
            if (r82 == 0) goto L_0x06b8
            r5 = r82
            r12.add(r5)
        L_0x06b8:
            com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist r1 = new com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist
            r2 = 0
            int r4 = (r24 > r2 ? 1 : (r24 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x06c3
            r90 = 1
            goto L_0x06c5
        L_0x06c3:
            r90 = 0
        L_0x06c5:
            r5 = r1
            r6 = r78
            r55 = r12
            r7 = r95
            r8 = r91
            r9 = r21
            r11 = r23
            r12 = r24
            r14 = r26
            r2 = r15
            r15 = r27
            r16 = r28
            r18 = r30
            r19 = r31
            r21 = r33
            r23 = r35
            r24 = r36
            r25 = r90
            r26 = r37
            r27 = r2
            r28 = r55
            r29 = r56
            r30 = r0
            r5.<init>(r6, r7, r8, r9, r11, r12, r14, r15, r16, r18, r19, r21, r23, r24, r25, r26, r27, r28, r29, r30)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser.o(com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist, com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist, com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser$LineIterator, java.lang.String):com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x045c, code lost:
        r6 = r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x04a4, code lost:
        r0 = r0 + 1;
        r31 = r6;
        r32 = r9;
        r33 = r14;
        r15 = r20;
        r9 = r21;
        r8 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist p(com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser.LineIterator r36, java.lang.String r37) throws java.io.IOException {
        /*
            r1 = r37
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.HashMap r11 = new java.util.HashMap
            r11.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r10 = 0
            r13 = 0
        L_0x0036:
            boolean r14 = r36.a()
            java.lang.String r15 = "application/x-mpegURL"
            if (r14 == 0) goto L_0x021b
            java.lang.String r14 = r36.b()
            java.lang.String r9 = "#EXT"
            boolean r9 = r14.startsWith(r9)
            if (r9 == 0) goto L_0x004d
            r8.add(r14)
        L_0x004d:
            java.lang.String r9 = "#EXT-X-I-FRAME-STREAM-INF"
            boolean r9 = r14.startsWith(r9)
            r19 = r10
            java.lang.String r10 = "#EXT-X-DEFINE"
            boolean r10 = r14.startsWith(r10)
            if (r10 == 0) goto L_0x006d
            java.util.regex.Pattern r9 = P
            java.lang.String r9 = z(r14, r9, r11)
            java.util.regex.Pattern r10 = Z
            java.lang.String r10 = z(r14, r10, r11)
            r11.put(r9, r10)
            goto L_0x00ce
        L_0x006d:
            java.lang.String r10 = "#EXT-X-INDEPENDENT-SEGMENTS"
            boolean r10 = r14.equals(r10)
            if (r10 == 0) goto L_0x0087
            r1 = r0
            r34 = r3
            r33 = r4
            r32 = r5
            r31 = r6
            r29 = r7
            r30 = r8
            r28 = r12
            r10 = 1
            goto L_0x0200
        L_0x0087:
            java.lang.String r10 = "#EXT-X-MEDIA"
            boolean r10 = r14.startsWith(r10)
            if (r10 == 0) goto L_0x0093
            r3.add(r14)
            goto L_0x00ce
        L_0x0093:
            java.lang.String r10 = "#EXT-X-SESSION-KEY"
            boolean r10 = r14.startsWith(r10)
            if (r10 == 0) goto L_0x00c3
            java.util.regex.Pattern r9 = I
            java.lang.String r10 = "identity"
            java.lang.String r9 = u(r14, r9, r10, r11)
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData r9 = k(r14, r9, r11)
            if (r9 == 0) goto L_0x00ce
            java.util.regex.Pattern r10 = H
            java.lang.String r10 = z(r14, r10, r11)
            java.lang.String r10 = l(r10)
            com.google.android.exoplayer2.drm.DrmInitData r14 = new com.google.android.exoplayer2.drm.DrmInitData
            r15 = 1
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData[] r15 = new com.google.android.exoplayer2.drm.DrmInitData.SchemeData[r15]
            r16 = 0
            r15[r16] = r9
            r14.<init>((java.lang.String) r10, (com.google.android.exoplayer2.drm.DrmInitData.SchemeData[]) r15)
            r12.add(r14)
            goto L_0x00ce
        L_0x00c3:
            java.lang.String r10 = "#EXT-X-STREAM-INF"
            boolean r10 = r14.startsWith(r10)
            if (r10 != 0) goto L_0x00e1
            if (r9 == 0) goto L_0x00ce
            goto L_0x00e1
        L_0x00ce:
            r1 = r0
            r34 = r3
            r33 = r4
            r32 = r5
            r31 = r6
            r29 = r7
            r30 = r8
            r28 = r12
            r10 = r19
            goto L_0x0200
        L_0x00e1:
            java.lang.String r10 = "CLOSED-CAPTIONS=NONE"
            boolean r10 = r14.contains(r10)
            r13 = r13 | r10
            if (r9 == 0) goto L_0x00ef
            r10 = 16384(0x4000, float:2.2959E-41)
            r20 = r13
            goto L_0x00f2
        L_0x00ef:
            r20 = r13
            r10 = 0
        L_0x00f2:
            java.util.regex.Pattern r13 = f26655h
            int r13 = m(r14, r13)
            r28 = r12
            java.util.regex.Pattern r12 = f26650c
            r29 = r7
            r7 = -1
            int r12 = s(r14, r12, r7)
            java.util.regex.Pattern r7 = f26657j
            java.lang.String r7 = v(r14, r7, r11)
            r30 = r8
            java.util.regex.Pattern r8 = f26658k
            java.lang.String r8 = v(r14, r8, r11)
            if (r8 == 0) goto L_0x013b
            r31 = r6
            java.lang.String r6 = "x"
            java.lang.String[] r6 = com.google.android.exoplayer2.util.Util.W0(r8, r6)
            r8 = 0
            r21 = r6[r8]
            int r8 = java.lang.Integer.parseInt(r21)
            r18 = 1
            r6 = r6[r18]
            int r6 = java.lang.Integer.parseInt(r6)
            if (r8 <= 0) goto L_0x0132
            if (r6 > 0) goto L_0x012f
            goto L_0x0132
        L_0x012f:
            r17 = r8
            goto L_0x0135
        L_0x0132:
            r6 = -1
            r17 = -1
        L_0x0135:
            r32 = r5
            r8 = r6
            r6 = r17
            goto L_0x0141
        L_0x013b:
            r31 = r6
            r32 = r5
            r6 = -1
            r8 = -1
        L_0x0141:
            java.util.regex.Pattern r5 = f26659l
            java.lang.String r5 = v(r14, r5, r11)
            if (r5 == 0) goto L_0x014e
            float r5 = java.lang.Float.parseFloat(r5)
            goto L_0x0150
        L_0x014e:
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x0150:
            r33 = r4
            java.util.regex.Pattern r4 = f26651d
            java.lang.String r4 = v(r14, r4, r11)
            r34 = r3
            java.util.regex.Pattern r3 = f26652e
            java.lang.String r3 = v(r14, r3, r11)
            r35 = r0
            java.util.regex.Pattern r0 = f26653f
            java.lang.String r0 = v(r14, r0, r11)
            r17 = r0
            java.util.regex.Pattern r0 = f26654g
            java.lang.String r0 = v(r14, r0, r11)
            if (r9 == 0) goto L_0x017d
            java.util.regex.Pattern r9 = K
            java.lang.String r9 = z(r14, r9, r11)
            android.net.Uri r9 = com.google.android.exoplayer2.util.UriUtil.e(r1, r9)
            goto L_0x018f
        L_0x017d:
            boolean r9 = r36.a()
            if (r9 == 0) goto L_0x0213
            java.lang.String r9 = r36.b()
            java.lang.String r9 = B(r9, r11)
            android.net.Uri r9 = com.google.android.exoplayer2.util.UriUtil.e(r1, r9)
        L_0x018f:
            com.google.android.exoplayer2.Format$Builder r14 = new com.google.android.exoplayer2.Format$Builder
            r14.<init>()
            int r1 = r2.size()
            com.google.android.exoplayer2.Format$Builder r1 = r14.T(r1)
            com.google.android.exoplayer2.Format$Builder r1 = r1.M(r15)
            com.google.android.exoplayer2.Format$Builder r1 = r1.K(r7)
            com.google.android.exoplayer2.Format$Builder r1 = r1.I(r12)
            com.google.android.exoplayer2.Format$Builder r1 = r1.b0(r13)
            com.google.android.exoplayer2.Format$Builder r1 = r1.n0(r6)
            com.google.android.exoplayer2.Format$Builder r1 = r1.S(r8)
            com.google.android.exoplayer2.Format$Builder r1 = r1.R(r5)
            com.google.android.exoplayer2.Format$Builder r1 = r1.e0(r10)
            com.google.android.exoplayer2.Format r23 = r1.G()
            com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Variant r1 = new com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Variant
            r21 = r1
            r22 = r9
            r24 = r4
            r25 = r3
            r26 = r17
            r27 = r0
            r21.<init>(r22, r23, r24, r25, r26, r27)
            r2.add(r1)
            r1 = r35
            java.lang.Object r5 = r1.get(r9)
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            if (r5 != 0) goto L_0x01e6
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r1.put(r9, r5)
        L_0x01e6:
            com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry$VariantInfo r6 = new com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry$VariantInfo
            r21 = r6
            r22 = r12
            r23 = r13
            r24 = r4
            r25 = r3
            r26 = r17
            r27 = r0
            r21.<init>(r22, r23, r24, r25, r26, r27)
            r5.add(r6)
            r10 = r19
            r13 = r20
        L_0x0200:
            r0 = r1
            r12 = r28
            r7 = r29
            r8 = r30
            r6 = r31
            r5 = r32
            r4 = r33
            r3 = r34
            r1 = r37
            goto L_0x0036
        L_0x0213:
            java.lang.String r0 = "#EXT-X-STREAM-INF must be followed by another line"
            r1 = 0
            com.google.android.exoplayer2.ParserException r0 = com.google.android.exoplayer2.ParserException.c(r0, r1)
            throw r0
        L_0x021b:
            r1 = r0
            r34 = r3
            r33 = r4
            r32 = r5
            r31 = r6
            r29 = r7
            r30 = r8
            r19 = r10
            r28 = r12
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r4 = 0
        L_0x0237:
            int r5 = r2.size()
            if (r4 >= r5) goto L_0x0290
            java.lang.Object r5 = r2.get(r4)
            com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Variant r5 = (com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist.Variant) r5
            android.net.Uri r6 = r5.f26639a
            boolean r6 = r0.add(r6)
            if (r6 == 0) goto L_0x028c
            com.google.android.exoplayer2.Format r6 = r5.f26640b
            com.google.android.exoplayer2.metadata.Metadata r6 = r6.f23069k
            if (r6 != 0) goto L_0x0253
            r6 = 1
            goto L_0x0254
        L_0x0253:
            r6 = 0
        L_0x0254:
            com.google.android.exoplayer2.util.Assertions.g(r6)
            com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry r6 = new com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry
            android.net.Uri r7 = r5.f26639a
            java.lang.Object r7 = r1.get(r7)
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            java.lang.Object r7 = com.google.android.exoplayer2.util.Assertions.e(r7)
            java.util.List r7 = (java.util.List) r7
            r8 = 0
            r6.<init>(r8, r8, r7)
            com.google.android.exoplayer2.metadata.Metadata r7 = new com.google.android.exoplayer2.metadata.Metadata
            r9 = 1
            com.google.android.exoplayer2.metadata.Metadata$Entry[] r10 = new com.google.android.exoplayer2.metadata.Metadata.Entry[r9]
            r9 = 0
            r10[r9] = r6
            r7.<init>((com.google.android.exoplayer2.metadata.Metadata.Entry[]) r10)
            com.google.android.exoplayer2.Format r6 = r5.f26640b
            com.google.android.exoplayer2.Format$Builder r6 = r6.b()
            com.google.android.exoplayer2.Format$Builder r6 = r6.Z(r7)
            com.google.android.exoplayer2.Format r6 = r6.G()
            com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Variant r5 = r5.a(r6)
            r3.add(r5)
            goto L_0x028d
        L_0x028c:
            r8 = 0
        L_0x028d:
            int r4 = r4 + 1
            goto L_0x0237
        L_0x0290:
            r8 = 0
            r1 = r8
            r9 = r1
            r0 = 0
        L_0x0294:
            int r4 = r34.size()
            if (r0 >= r4) goto L_0x04b3
            r4 = r34
            java.lang.Object r5 = r4.get(r0)
            java.lang.String r5 = (java.lang.String) r5
            java.util.regex.Pattern r6 = Q
            java.lang.String r6 = z(r5, r6, r11)
            java.util.regex.Pattern r7 = P
            java.lang.String r7 = z(r5, r7, r11)
            com.google.android.exoplayer2.Format$Builder r10 = new com.google.android.exoplayer2.Format$Builder
            r10.<init>()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r6)
            java.lang.String r14 = ":"
            r12.append(r14)
            r12.append(r7)
            java.lang.String r12 = r12.toString()
            com.google.android.exoplayer2.Format$Builder r10 = r10.U(r12)
            com.google.android.exoplayer2.Format$Builder r10 = r10.W(r7)
            com.google.android.exoplayer2.Format$Builder r10 = r10.M(r15)
            int r12 = x(r5)
            com.google.android.exoplayer2.Format$Builder r10 = r10.i0(r12)
            int r12 = w(r5, r11)
            com.google.android.exoplayer2.Format$Builder r10 = r10.e0(r12)
            java.util.regex.Pattern r12 = O
            java.lang.String r12 = v(r5, r12, r11)
            com.google.android.exoplayer2.Format$Builder r10 = r10.X(r12)
            java.util.regex.Pattern r12 = K
            java.lang.String r12 = v(r5, r12, r11)
            r14 = r37
            if (r12 != 0) goto L_0x02f9
            r12 = r8
            goto L_0x02fd
        L_0x02f9:
            android.net.Uri r12 = com.google.android.exoplayer2.util.UriUtil.e(r14, r12)
        L_0x02fd:
            com.google.android.exoplayer2.metadata.Metadata r8 = new com.google.android.exoplayer2.metadata.Metadata
            r34 = r4
            r4 = 1
            com.google.android.exoplayer2.metadata.Metadata$Entry[] r14 = new com.google.android.exoplayer2.metadata.Metadata.Entry[r4]
            com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry r4 = new com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry
            r20 = r15
            java.util.List r15 = java.util.Collections.emptyList()
            r4.<init>(r6, r7, r15)
            r15 = 0
            r14[r15] = r4
            r8.<init>((com.google.android.exoplayer2.metadata.Metadata.Entry[]) r14)
            java.util.regex.Pattern r4 = M
            java.lang.String r4 = z(r5, r4, r11)
            r4.hashCode()
            int r14 = r4.hashCode()
            r15 = 2
            switch(r14) {
                case -959297733: goto L_0x0349;
                case -333210994: goto L_0x033e;
                case 62628790: goto L_0x0333;
                case 81665115: goto L_0x0328;
                default: goto L_0x0326;
            }
        L_0x0326:
            r4 = -1
            goto L_0x0353
        L_0x0328:
            java.lang.String r14 = "VIDEO"
            boolean r4 = r4.equals(r14)
            if (r4 != 0) goto L_0x0331
            goto L_0x0326
        L_0x0331:
            r4 = 3
            goto L_0x0353
        L_0x0333:
            java.lang.String r14 = "AUDIO"
            boolean r4 = r4.equals(r14)
            if (r4 != 0) goto L_0x033c
            goto L_0x0326
        L_0x033c:
            r4 = 2
            goto L_0x0353
        L_0x033e:
            java.lang.String r14 = "CLOSED-CAPTIONS"
            boolean r4 = r4.equals(r14)
            if (r4 != 0) goto L_0x0347
            goto L_0x0326
        L_0x0347:
            r4 = 1
            goto L_0x0353
        L_0x0349:
            java.lang.String r14 = "SUBTITLES"
            boolean r4 = r4.equals(r14)
            if (r4 != 0) goto L_0x0352
            goto L_0x0326
        L_0x0352:
            r4 = 0
        L_0x0353:
            switch(r4) {
                case 0: goto L_0x045f;
                case 1: goto L_0x041b;
                case 2: goto L_0x03a8;
                case 3: goto L_0x0362;
                default: goto L_0x0356;
            }
        L_0x0356:
            r21 = r9
            r6 = r31
            r9 = r32
            r14 = r33
        L_0x035e:
            r16 = 0
            goto L_0x04a4
        L_0x0362:
            com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Variant r4 = h(r2, r6)
            if (r4 == 0) goto L_0x038d
            com.google.android.exoplayer2.Format r4 = r4.f26640b
            java.lang.String r5 = r4.f23068j
            java.lang.String r5 = com.google.android.exoplayer2.util.Util.L(r5, r15)
            com.google.android.exoplayer2.Format$Builder r14 = r10.K(r5)
            java.lang.String r5 = com.google.android.exoplayer2.util.MimeTypes.g(r5)
            com.google.android.exoplayer2.Format$Builder r5 = r14.g0(r5)
            int r14 = r4.f23076r
            com.google.android.exoplayer2.Format$Builder r5 = r5.n0(r14)
            int r14 = r4.f23077s
            com.google.android.exoplayer2.Format$Builder r5 = r5.S(r14)
            float r4 = r4.f23078t
            r5.R(r4)
        L_0x038d:
            if (r12 != 0) goto L_0x0390
            goto L_0x0356
        L_0x0390:
            r10.Z(r8)
            com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Rendition r4 = new com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Rendition
            com.google.android.exoplayer2.Format r5 = r10.G()
            r4.<init>(r12, r5, r6, r7)
            r14 = r33
            r14.add(r4)
            r21 = r9
            r6 = r31
            r9 = r32
            goto L_0x035e
        L_0x03a8:
            r14 = r33
            com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Variant r4 = f(r2, r6)
            if (r4 == 0) goto L_0x03c3
            com.google.android.exoplayer2.Format r15 = r4.f26640b
            java.lang.String r15 = r15.f23068j
            r21 = r9
            r9 = 1
            java.lang.String r15 = com.google.android.exoplayer2.util.Util.L(r15, r9)
            r10.K(r15)
            java.lang.String r15 = com.google.android.exoplayer2.util.MimeTypes.g(r15)
            goto L_0x03c6
        L_0x03c3:
            r21 = r9
            r15 = 0
        L_0x03c6:
            java.util.regex.Pattern r9 = f26656i
            java.lang.String r5 = v(r5, r9, r11)
            if (r5 == 0) goto L_0x03f7
            java.lang.String r9 = "/"
            java.lang.String[] r9 = com.google.android.exoplayer2.util.Util.X0(r5, r9)
            r16 = 0
            r9 = r9[r16]
            int r9 = java.lang.Integer.parseInt(r9)
            r10.J(r9)
            java.lang.String r9 = "audio/eac3"
            boolean r9 = r9.equals(r15)
            if (r9 == 0) goto L_0x03f9
            java.lang.String r9 = "/JOC"
            boolean r5 = r5.endsWith(r9)
            if (r5 == 0) goto L_0x03f9
            java.lang.String r5 = "ec+3"
            r10.K(r5)
            java.lang.String r15 = "audio/eac3-joc"
            goto L_0x03f9
        L_0x03f7:
            r16 = 0
        L_0x03f9:
            r10.g0(r15)
            if (r12 == 0) goto L_0x0410
            r10.Z(r8)
            com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Rendition r4 = new com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Rendition
            com.google.android.exoplayer2.Format r5 = r10.G()
            r4.<init>(r12, r5, r6, r7)
            r9 = r32
            r9.add(r4)
            goto L_0x045c
        L_0x0410:
            r9 = r32
            if (r4 == 0) goto L_0x045c
            com.google.android.exoplayer2.Format r4 = r10.G()
            r21 = r4
            goto L_0x045c
        L_0x041b:
            r21 = r9
            r9 = r32
            r14 = r33
            r16 = 0
            java.util.regex.Pattern r4 = S
            java.lang.String r4 = z(r5, r4, r11)
            java.lang.String r5 = "CC"
            boolean r5 = r4.startsWith(r5)
            if (r5 == 0) goto L_0x043c
            java.lang.String r4 = r4.substring(r15)
            int r4 = java.lang.Integer.parseInt(r4)
            java.lang.String r5 = "application/cea-608"
            goto L_0x0447
        L_0x043c:
            r5 = 7
            java.lang.String r4 = r4.substring(r5)
            int r4 = java.lang.Integer.parseInt(r4)
            java.lang.String r5 = "application/cea-708"
        L_0x0447:
            if (r1 != 0) goto L_0x044e
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
        L_0x044e:
            com.google.android.exoplayer2.Format$Builder r5 = r10.g0(r5)
            r5.H(r4)
            com.google.android.exoplayer2.Format r4 = r10.G()
            r1.add(r4)
        L_0x045c:
            r6 = r31
            goto L_0x04a4
        L_0x045f:
            r21 = r9
            r9 = r32
            r14 = r33
            r16 = 0
            com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Variant r4 = g(r2, r6)
            if (r4 == 0) goto L_0x047e
            com.google.android.exoplayer2.Format r4 = r4.f26640b
            java.lang.String r4 = r4.f23068j
            r5 = 3
            java.lang.String r4 = com.google.android.exoplayer2.util.Util.L(r4, r5)
            r10.K(r4)
            java.lang.String r4 = com.google.android.exoplayer2.util.MimeTypes.g(r4)
            goto L_0x047f
        L_0x047e:
            r4 = 0
        L_0x047f:
            if (r4 != 0) goto L_0x0483
            java.lang.String r4 = "text/vtt"
        L_0x0483:
            com.google.android.exoplayer2.Format$Builder r4 = r10.g0(r4)
            r4.Z(r8)
            if (r12 == 0) goto L_0x049b
            com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Rendition r4 = new com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist$Rendition
            com.google.android.exoplayer2.Format r5 = r10.G()
            r4.<init>(r12, r5, r6, r7)
            r6 = r31
            r6.add(r4)
            goto L_0x04a4
        L_0x049b:
            r6 = r31
            java.lang.String r4 = "HlsPlaylistParser"
            java.lang.String r5 = "EXT-X-MEDIA tag with missing mandatory URI attribute: skipping"
            com.google.android.exoplayer2.util.Log.i(r4, r5)
        L_0x04a4:
            int r0 = r0 + 1
            r31 = r6
            r32 = r9
            r33 = r14
            r15 = r20
            r9 = r21
            r8 = 0
            goto L_0x0294
        L_0x04b3:
            r21 = r9
            r6 = r31
            r9 = r32
            r14 = r33
            if (r13 == 0) goto L_0x04c3
            java.util.List r0 = java.util.Collections.emptyList()
            r10 = r0
            goto L_0x04c4
        L_0x04c3:
            r10 = r1
        L_0x04c4:
            com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist r13 = new com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist
            r0 = r13
            r1 = r37
            r2 = r30
            r4 = r14
            r5 = r9
            r7 = r29
            r8 = r21
            r9 = r10
            r10 = r19
            r12 = r28
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser.p(com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser$LineIterator, java.lang.String):com.google.android.exoplayer2.source.hls.playlist.HlsMultivariantPlaylist");
    }

    private static boolean q(String str, Pattern pattern, boolean z2) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return "YES".equals(matcher.group(1));
        }
        return z2;
    }

    private static double r(String str, Pattern pattern, double d2) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return Double.parseDouble((String) Assertions.e(matcher.group(1)));
        }
        return d2;
    }

    private static int s(String str, Pattern pattern, int i2) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return Integer.parseInt((String) Assertions.e(matcher.group(1)));
        }
        return i2;
    }

    private static long t(String str, Pattern pattern, long j2) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return Long.parseLong((String) Assertions.e(matcher.group(1)));
        }
        return j2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String u(java.lang.String r0, java.util.regex.Pattern r1, java.lang.String r2, java.util.Map<java.lang.String, java.lang.String> r3) {
        /*
            java.util.regex.Matcher r0 = r1.matcher(r0)
            boolean r1 = r0.find()
            if (r1 == 0) goto L_0x0016
            r1 = 1
            java.lang.String r0 = r0.group(r1)
            java.lang.Object r0 = com.google.android.exoplayer2.util.Assertions.e(r0)
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2
        L_0x0016:
            boolean r0 = r3.isEmpty()
            if (r0 != 0) goto L_0x0023
            if (r2 != 0) goto L_0x001f
            goto L_0x0023
        L_0x001f:
            java.lang.String r2 = B(r2, r3)
        L_0x0023:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser.u(java.lang.String, java.util.regex.Pattern, java.lang.String, java.util.Map):java.lang.String");
    }

    private static String v(String str, Pattern pattern, Map<String, String> map) {
        return u(str, pattern, (String) null, map);
    }

    private static int w(String str, Map<String, String> map) {
        String v2 = v(str, R, map);
        int i2 = 0;
        if (TextUtils.isEmpty(v2)) {
            return 0;
        }
        String[] W0 = Util.W0(v2, ",");
        if (Util.s(W0, "public.accessibility.describes-video")) {
            i2 = 512;
        }
        if (Util.s(W0, "public.accessibility.transcribes-spoken-dialog")) {
            i2 |= CodedOutputStream.DEFAULT_BUFFER_SIZE;
        }
        if (Util.s(W0, "public.accessibility.describes-music-and-sound")) {
            i2 |= 1024;
        }
        if (Util.s(W0, "public.easy-to-read")) {
            return i2 | 8192;
        }
        return i2;
    }

    private static int x(String str) {
        boolean q2 = q(str, U, false);
        if (q(str, V, false)) {
            q2 |= true;
        }
        return q(str, T, false) ? q2 | true ? 1 : 0 : q2 ? 1 : 0;
    }

    private static HlsMediaPlaylist.ServerControl y(String str) {
        long j2;
        long j3;
        String str2 = str;
        double r2 = r(str2, f26665r, -9.223372036854776E18d);
        long j4 = -9223372036854775807L;
        if (r2 == -9.223372036854776E18d) {
            j2 = -9223372036854775807L;
        } else {
            j2 = (long) (r2 * 1000000.0d);
        }
        boolean q2 = q(str2, f26666s, false);
        double r3 = r(str2, f26668u, -9.223372036854776E18d);
        if (r3 == -9.223372036854776E18d) {
            j3 = -9223372036854775807L;
        } else {
            j3 = (long) (r3 * 1000000.0d);
        }
        double r4 = r(str2, f26669v, -9.223372036854776E18d);
        if (r4 != -9.223372036854776E18d) {
            j4 = (long) (r4 * 1000000.0d);
        }
        return new HlsMediaPlaylist.ServerControl(j2, q2, j3, j4, q(str2, f26670w, false));
    }

    private static String z(String str, Pattern pattern, Map<String, String> map) throws ParserException {
        String v2 = v(str, pattern, map);
        if (v2 != null) {
            return v2;
        }
        throw ParserException.c("Couldn't match " + pattern.pattern() + " in " + str, (Throwable) null);
    }

    /* renamed from: i */
    public HlsPlaylist a(Uri uri, InputStream inputStream) throws IOException {
        String trim;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayDeque arrayDeque = new ArrayDeque();
        try {
            if (b(bufferedReader)) {
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        trim = readLine.trim();
                        if (!trim.isEmpty()) {
                            if (!trim.startsWith("#EXT-X-STREAM-INF")) {
                                if (trim.startsWith("#EXT-X-TARGETDURATION") || trim.startsWith("#EXT-X-MEDIA-SEQUENCE") || trim.startsWith("#EXTINF") || trim.startsWith("#EXT-X-KEY") || trim.startsWith("#EXT-X-BYTERANGE") || trim.equals("#EXT-X-DISCONTINUITY") || trim.equals("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                                    break;
                                } else if (trim.equals("#EXT-X-ENDLIST")) {
                                    break;
                                } else {
                                    arrayDeque.add(trim);
                                }
                            } else {
                                arrayDeque.add(trim);
                                HlsMultivariantPlaylist p2 = p(new LineIterator(arrayDeque, bufferedReader), uri.toString());
                                Util.n(bufferedReader);
                                return p2;
                            }
                        }
                    } else {
                        Util.n(bufferedReader);
                        throw ParserException.c("Failed to parse the playlist, could not identify any tags.", (Throwable) null);
                    }
                }
                arrayDeque.add(trim);
                return o(this.f26674a, this.f26675b, new LineIterator(arrayDeque, bufferedReader), uri.toString());
            }
            throw ParserException.c("Input does not start with the #EXTM3U header.", (Throwable) null);
        } finally {
            Util.n(bufferedReader);
        }
    }

    public HlsPlaylistParser(HlsMultivariantPlaylist hlsMultivariantPlaylist, HlsMediaPlaylist hlsMediaPlaylist) {
        this.f26674a = hlsMultivariantPlaylist;
        this.f26675b = hlsMediaPlaylist;
    }
}
