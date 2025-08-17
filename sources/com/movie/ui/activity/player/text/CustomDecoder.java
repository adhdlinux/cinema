package com.movie.ui.activity.player.text;

import androidx.media3.common.Format;
import androidx.media3.extractor.text.SubtitleDecoder;
import androidx.media3.extractor.text.SubtitleInputBuffer;
import androidx.media3.extractor.text.SubtitleOutputBuffer;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import timber.log.Timber;

public final class CustomDecoder implements SubtitleDecoder {

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f32458d = new Companion((DefaultConstructorMarker) null);

    /* renamed from: e  reason: collision with root package name */
    private static String f32459e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f32460f;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f32461g;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f32462h;

    /* renamed from: i  reason: collision with root package name */
    private static final List<Regex> f32463i;

    /* renamed from: j  reason: collision with root package name */
    private static final List<Regex> f32464j = CollectionsKt__CollectionsJVMKt.b(new Regex("(-\\s?|)[\\[({][\\w\\d\\s]*?[])}]\\s*"));

    /* renamed from: a  reason: collision with root package name */
    private final Format f32465a;

    /* renamed from: b  reason: collision with root package name */
    private final Function0<Unit> f32466b;

    /* renamed from: c  reason: collision with root package name */
    private SubtitleDecoder f32467c;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(String str) {
            Intrinsics.f(str, "string");
            return new Regex("[             ]").h(StringsKt__StringsKt.O0(StringsKt__StringsKt.P0(str).toString(), 65279, 8203), " ");
        }
    }

    static {
        RegexOption regexOption = RegexOption.IGNORE_CASE;
        f32463i = CollectionsKt__CollectionsKt.i(new Regex("Support\\s+us\\s+and\\s+become\\s+VIP\\s+member\\s+to\\s+remove\\s+all\\s+ads\\s+from\\s+(www\\.|)OpenSubtitles(\\.org|)", regexOption), new Regex("Please\\s+rate\\s+this\\s+subtitle\\s+at\\s+.*\\s+Help\\s+other\\s+users\\s+to\\s+choose\\s+the\\s+best\\s+subtitles", regexOption), new Regex("Contact\\s(www\\.|)OpenSubtitles(\\.org|)\\s+today", regexOption), new Regex("Advertise\\s+your\\s+product\\s+or\\s+brand\\s+here", regexOption));
    }

    public CustomDecoder(Format format, Function0<Unit> function0) {
        this.f32465a = format;
        this.f32466b = function0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x007a A[EDGE_INSN: B:47:0x007a->B:24:0x007a ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String i(androidx.media3.extractor.text.SubtitleInputBuffer r12) {
        /*
            r11 = this;
            boolean r0 = r11.k(r12)
            java.lang.String r1 = "Failed to parse text returning plain data"
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L_0x00b3
            java.nio.ByteBuffer r12 = r12.f5067d     // Catch:{ IOException -> 0x00aa }
            if (r12 != 0) goto L_0x000f
            return r2
        L_0x000f:
            r12.position(r3)     // Catch:{ IOException -> 0x00aa }
            int r0 = r12.remaining()     // Catch:{ IOException -> 0x00aa }
            byte[] r0 = new byte[r0]     // Catch:{ IOException -> 0x00aa }
            r12.get(r0)     // Catch:{ IOException -> 0x00aa }
            java.util.zip.ZipInputStream r12 = new java.util.zip.ZipInputStream     // Catch:{ IOException -> 0x00aa }
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x00aa }
            r4.<init>(r0)     // Catch:{ IOException -> 0x00aa }
            r12.<init>(r4)     // Catch:{ IOException -> 0x00aa }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00aa }
            r0.<init>()     // Catch:{ IOException -> 0x00aa }
            java.lang.String r4 = ".srt"
            java.lang.String r5 = ".vtt"
            java.lang.String r6 = ".ass"
            java.lang.String r7 = ".mp4vtt"
            java.lang.String r8 = ".ttml"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5, r6, r7, r8}     // Catch:{ IOException -> 0x00aa }
            java.util.List r4 = kotlin.collections.CollectionsKt__CollectionsKt.i(r4)     // Catch:{ IOException -> 0x00aa }
        L_0x003c:
            java.util.zip.ZipEntry r5 = r12.getNextEntry()     // Catch:{ IOException -> 0x00aa }
            if (r5 == 0) goto L_0x009a
            r6 = r4
            java.lang.Iterable r6 = (java.lang.Iterable) r6     // Catch:{ IOException -> 0x00aa }
            boolean r7 = r6 instanceof java.util.Collection     // Catch:{ IOException -> 0x00aa }
            if (r7 == 0) goto L_0x0054
            r7 = r6
            java.util.Collection r7 = (java.util.Collection) r7     // Catch:{ IOException -> 0x00aa }
            boolean r7 = r7.isEmpty()     // Catch:{ IOException -> 0x00aa }
            if (r7 == 0) goto L_0x0054
        L_0x0052:
            r9 = 0
            goto L_0x007a
        L_0x0054:
            java.util.Iterator r6 = r6.iterator()     // Catch:{ IOException -> 0x00aa }
        L_0x0058:
            boolean r7 = r6.hasNext()     // Catch:{ IOException -> 0x00aa }
            if (r7 == 0) goto L_0x0052
            java.lang.Object r7 = r6.next()     // Catch:{ IOException -> 0x00aa }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ IOException -> 0x00aa }
            java.lang.String r8 = r5.getName()     // Catch:{ IOException -> 0x00aa }
            r9 = 1
            if (r8 == 0) goto L_0x0077
            kotlin.jvm.internal.Intrinsics.c(r8)     // Catch:{ IOException -> 0x00aa }
            r10 = 2
            boolean r7 = kotlin.text.StringsKt__StringsJVMKt.s(r8, r7, r3, r10, r2)     // Catch:{ IOException -> 0x00aa }
            if (r7 != r9) goto L_0x0077
            r7 = 1
            goto L_0x0078
        L_0x0077:
            r7 = 0
        L_0x0078:
            if (r7 == 0) goto L_0x0058
        L_0x007a:
            if (r9 == 0) goto L_0x003c
            java.nio.charset.Charset r4 = kotlin.text.Charsets.f40513b     // Catch:{ IOException -> 0x00aa }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00aa }
            r5.<init>(r12, r4)     // Catch:{ IOException -> 0x00aa }
            boolean r12 = r5 instanceof java.io.BufferedReader     // Catch:{ IOException -> 0x00aa }
            if (r12 == 0) goto L_0x008a
            java.io.BufferedReader r5 = (java.io.BufferedReader) r5     // Catch:{ IOException -> 0x00aa }
            goto L_0x0092
        L_0x008a:
            java.io.BufferedReader r12 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00aa }
            r4 = 8192(0x2000, float:1.14794E-41)
            r12.<init>(r5, r4)     // Catch:{ IOException -> 0x00aa }
            r5 = r12
        L_0x0092:
            com.movie.ui.activity.player.text.CustomDecoder$getStr$3 r12 = new com.movie.ui.activity.player.text.CustomDecoder$getStr$3     // Catch:{ IOException -> 0x00aa }
            r12.<init>(r0)     // Catch:{ IOException -> 0x00aa }
            kotlin.io.TextStreamsKt.c(r5, r12)     // Catch:{ IOException -> 0x00aa }
        L_0x009a:
            com.movie.ui.activity.player.text.CustomDecoder$Companion r12 = f32458d     // Catch:{ IOException -> 0x00aa }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x00aa }
            java.lang.String r4 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.e(r0, r4)     // Catch:{ IOException -> 0x00aa }
            java.lang.String r12 = r12.a(r0)     // Catch:{ IOException -> 0x00aa }
            return r12
        L_0x00aa:
            r12 = move-exception
            timber.log.Timber$Forest r0 = timber.log.Timber.f42178a
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r0.d(r12, r1, r3)
            return r2
        L_0x00b3:
            java.nio.ByteBuffer r12 = r12.f5067d     // Catch:{ Exception -> 0x00d5 }
            if (r12 != 0) goto L_0x00b8
            return r2
        L_0x00b8:
            r12.position(r3)     // Catch:{ Exception -> 0x00d5 }
            int r0 = r12.remaining()     // Catch:{ Exception -> 0x00d5 }
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x00d5 }
            r12.get(r0)     // Catch:{ Exception -> 0x00d5 }
            com.movie.ui.activity.player.text.CustomDecoder$Companion r12 = f32458d     // Catch:{ Exception -> 0x00d5 }
            kotlin.Pair r0 = r11.j(r0)     // Catch:{ Exception -> 0x00d5 }
            java.lang.Object r0 = r0.c()     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r12 = r12.a(r0)     // Catch:{ Exception -> 0x00d5 }
            return r12
        L_0x00d5:
            r12 = move-exception
            timber.log.Timber$Forest r0 = timber.log.Timber.f42178a
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r0.d(r12, r1, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.movie.ui.activity.player.text.CustomDecoder.i(androidx.media3.extractor.text.SubtitleInputBuffer):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x003b, code lost:
        if (r3 == null) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlin.Pair<java.lang.String, java.nio.charset.Charset> j(byte[] r9) {
        /*
            r8 = this;
            java.lang.String r0 = "forName(charsetName)"
            java.lang.String r1 = "UTF-8"
            r2 = 0
            java.lang.String r3 = f32459e     // Catch:{ Exception -> 0x003f }
            if (r3 != 0) goto L_0x0019
            org.mozilla.universalchardet.UniversalDetector r3 = new org.mozilla.universalchardet.UniversalDetector     // Catch:{ Exception -> 0x003f }
            r3.<init>()     // Catch:{ Exception -> 0x003f }
            int r4 = r9.length     // Catch:{ Exception -> 0x003f }
            r3.d(r9, r2, r4)     // Catch:{ Exception -> 0x003f }
            r3.a()     // Catch:{ Exception -> 0x003f }
            java.lang.String r3 = r3.c()     // Catch:{ Exception -> 0x003f }
        L_0x0019:
            timber.log.Timber$Forest r4 = timber.log.Timber.f42178a     // Catch:{ Exception -> 0x003f }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x003f }
            r5.<init>()     // Catch:{ Exception -> 0x003f }
            java.lang.String r6 = "Detected encoding with charset "
            r5.append(r6)     // Catch:{ Exception -> 0x003f }
            r5.append(r3)     // Catch:{ Exception -> 0x003f }
            java.lang.String r6 = " and override = "
            r5.append(r6)     // Catch:{ Exception -> 0x003f }
            java.lang.String r6 = f32459e     // Catch:{ Exception -> 0x003f }
            r5.append(r6)     // Catch:{ Exception -> 0x003f }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x003f }
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x003f }
            r4.h(r5, r6)     // Catch:{ Exception -> 0x003f }
            if (r3 != 0) goto L_0x004a
        L_0x003d:
            r3 = r1
            goto L_0x004a
        L_0x003f:
            r3 = move-exception
            timber.log.Timber$Forest r4 = timber.log.Timber.f42178a
            java.lang.String r5 = "Failed to detect encoding throwing error"
            java.lang.Object[] r6 = new java.lang.Object[r2]
            r4.d(r3, r5, r6)
            goto L_0x003d
        L_0x004a:
            java.nio.charset.Charset r4 = java.nio.charset.Charset.forName(r3)     // Catch:{ Exception -> 0x005c }
            kotlin.jvm.internal.Intrinsics.e(r4, r0)     // Catch:{ Exception -> 0x005c }
            kotlin.Pair r5 = new kotlin.Pair     // Catch:{ Exception -> 0x005c }
            java.lang.String r6 = new java.lang.String     // Catch:{ Exception -> 0x005c }
            r6.<init>(r9, r4)     // Catch:{ Exception -> 0x005c }
            r5.<init>(r6, r4)     // Catch:{ Exception -> 0x005c }
            goto L_0x0085
        L_0x005c:
            r4 = move-exception
            timber.log.Timber$Forest r5 = timber.log.Timber.f42178a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Failed to parse using encoding "
            r6.append(r7)
            r6.append(r3)
            java.lang.String r3 = r6.toString()
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r5.d(r4, r3, r2)
            kotlin.Pair r5 = new kotlin.Pair
            java.lang.String r9 = kotlin.text.StringsKt__StringsJVMKt.q(r9)
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)
            kotlin.jvm.internal.Intrinsics.e(r1, r0)
            r5.<init>(r9, r1)
        L_0x0085:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.movie.ui.activity.player.text.CustomDecoder.j(byte[]):kotlin.Pair");
    }

    private final void m(SubtitleInputBuffer subtitleInputBuffer, String str) {
        Charset forName = Charset.forName("UTF-8");
        Intrinsics.e(forName, "forName(charsetName)");
        byte[] bytes = str.getBytes(forName);
        Intrinsics.e(bytes, "this as java.lang.String).getBytes(charset)");
        subtitleInputBuffer.f5067d = ByteBuffer.wrap(bytes);
    }

    public void b(long j2) {
        SubtitleDecoder subtitleDecoder = this.f32467c;
        if (subtitleDecoder != null) {
            subtitleDecoder.b(j2);
        }
    }

    public void e(long j2) {
        SubtitleDecoder subtitleDecoder = this.f32467c;
        if (subtitleDecoder != null) {
            subtitleDecoder.e(j2);
        }
    }

    public void flush() {
        SubtitleDecoder subtitleDecoder = this.f32467c;
        if (subtitleDecoder != null) {
            subtitleDecoder.flush();
        }
    }

    /* renamed from: g */
    public SubtitleInputBuffer d() {
        SubtitleInputBuffer subtitleInputBuffer;
        Timber.f42178a.h("dequeueInputBuffer", new Object[0]);
        SubtitleDecoder subtitleDecoder = this.f32467c;
        if (subtitleDecoder != null) {
            subtitleInputBuffer = (SubtitleInputBuffer) subtitleDecoder.d();
        } else {
            subtitleInputBuffer = null;
        }
        if (subtitleInputBuffer == null) {
            return new SubtitleInputBuffer();
        }
        return subtitleInputBuffer;
    }

    public String getName() {
        SubtitleDecoder subtitleDecoder = this.f32467c;
        String name = subtitleDecoder != null ? subtitleDecoder.getName() : null;
        return name == null ? "javaClass" : name;
    }

    /* renamed from: h */
    public SubtitleOutputBuffer a() {
        SubtitleDecoder subtitleDecoder = this.f32467c;
        if (subtitleDecoder != null) {
            return (SubtitleOutputBuffer) subtitleDecoder.a();
        }
        return null;
    }

    public final boolean k(SubtitleInputBuffer subtitleInputBuffer) {
        Intrinsics.f(subtitleInputBuffer, "subtitleInputBuffer");
        byte[] bArr = {80, 75};
        ByteBuffer byteBuffer = subtitleInputBuffer.f5067d;
        if (byteBuffer == null) {
            return false;
        }
        Intrinsics.c(byteBuffer);
        if (byteBuffer.remaining() < 2) {
            return false;
        }
        ByteBuffer byteBuffer2 = subtitleInputBuffer.f5067d;
        Intrinsics.c(byteBuffer2);
        byteBuffer2.position(0);
        byte b2 = byteBuffer2.get();
        byte b3 = byteBuffer2.get();
        if (b2 == bArr[0] && b3 == bArr[1]) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00ec, code lost:
        r11 = new androidx.media3.extractor.text.cea.Cea608Decoder(r11, r10.f32465a.G, 16000);
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002a A[Catch:{ Exception -> 0x0297 }] */
    /* renamed from: l */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(androidx.media3.extractor.text.SubtitleInputBuffer r11) {
        /*
            r10 = this;
            java.lang.String r0 = "WEBVTT"
            java.lang.String r1 = "inputBuffer"
            kotlin.jvm.internal.Intrinsics.f(r11, r1)
            timber.log.Timber$Forest r1 = timber.log.Timber.f42178a
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.String r4 = "queueInputBuffer"
            r1.h(r4, r3)
            java.lang.String r3 = r10.i(r11)     // Catch:{ Exception -> 0x0297 }
            androidx.media3.extractor.text.SubtitleDecoder r4 = r10.f32467c     // Catch:{ Exception -> 0x0297 }
            java.lang.String r5 = "\n"
            r6 = 1
            if (r4 != 0) goto L_0x021b
            if (r3 == 0) goto L_0x0027
            boolean r4 = kotlin.text.StringsKt__StringsJVMKt.v(r3)     // Catch:{ Exception -> 0x0297 }
            if (r4 == 0) goto L_0x0025
            goto L_0x0027
        L_0x0025:
            r4 = 0
            goto L_0x0028
        L_0x0027:
            r4 = 1
        L_0x0028:
            if (r4 != 0) goto L_0x021b
            java.lang.String r11 = "Got data from queueInputBuffer"
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0297 }
            r1.h(r11, r4)     // Catch:{ Exception -> 0x0297 }
            boolean r11 = kotlin.text.StringsKt__StringsJVMKt.E(r3, r0, r6)     // Catch:{ Exception -> 0x0297 }
            if (r11 == 0) goto L_0x0043
            com.movie.ui.activity.player.text.DelegatingSubtitleDecoder r11 = new com.movie.ui.activity.player.text.DelegatingSubtitleDecoder     // Catch:{ Exception -> 0x0297 }
            androidx.media3.extractor.text.webvtt.WebvttParser r4 = new androidx.media3.extractor.text.webvtt.WebvttParser     // Catch:{ Exception -> 0x0297 }
            r4.<init>()     // Catch:{ Exception -> 0x0297 }
            r11.<init>(r0, r4)     // Catch:{ Exception -> 0x0297 }
            goto L_0x019c
        L_0x0043:
            java.lang.String r11 = "<?xml version=\""
            boolean r11 = kotlin.text.StringsKt__StringsJVMKt.E(r3, r11, r6)     // Catch:{ Exception -> 0x0297 }
            java.lang.String r4 = "TTML"
            if (r11 == 0) goto L_0x0059
            com.movie.ui.activity.player.text.DelegatingSubtitleDecoder r11 = new com.movie.ui.activity.player.text.DelegatingSubtitleDecoder     // Catch:{ Exception -> 0x0297 }
            androidx.media3.extractor.text.ttml.TtmlParser r0 = new androidx.media3.extractor.text.ttml.TtmlParser     // Catch:{ Exception -> 0x0297 }
            r0.<init>()     // Catch:{ Exception -> 0x0297 }
            r11.<init>(r4, r0)     // Catch:{ Exception -> 0x0297 }
            goto L_0x019c
        L_0x0059:
            java.lang.String r11 = "[Script Info]"
            boolean r11 = kotlin.text.StringsKt__StringsJVMKt.E(r3, r11, r6)     // Catch:{ Exception -> 0x0297 }
            java.lang.String r7 = "SSA"
            r8 = 0
            if (r11 != 0) goto L_0x018c
            java.lang.String r11 = "Title:"
            boolean r11 = kotlin.text.StringsKt__StringsJVMKt.E(r3, r11, r6)     // Catch:{ Exception -> 0x0297 }
            if (r11 == 0) goto L_0x006e
            goto L_0x018c
        L_0x006e:
            java.lang.String r11 = "1"
            boolean r11 = kotlin.text.StringsKt__StringsJVMKt.E(r3, r11, r6)     // Catch:{ Exception -> 0x0297 }
            java.lang.String r6 = "Subrip"
            if (r11 == 0) goto L_0x0084
            com.movie.ui.activity.player.text.DelegatingSubtitleDecoder r11 = new com.movie.ui.activity.player.text.DelegatingSubtitleDecoder     // Catch:{ Exception -> 0x0297 }
            androidx.media3.extractor.text.subrip.SubripParser r0 = new androidx.media3.extractor.text.subrip.SubripParser     // Catch:{ Exception -> 0x0297 }
            r0.<init>()     // Catch:{ Exception -> 0x0297 }
            r11.<init>(r6, r0)     // Catch:{ Exception -> 0x0297 }
            goto L_0x019c
        L_0x0084:
            androidx.media3.common.Format r11 = r10.f32465a     // Catch:{ Exception -> 0x0297 }
            if (r11 == 0) goto L_0x018a
            java.lang.String r11 = r11.f4015n     // Catch:{ Exception -> 0x0297 }
            if (r11 == 0) goto L_0x018a
            int r9 = r11.hashCode()     // Catch:{ Exception -> 0x0297 }
            switch(r9) {
                case -1351681404: goto L_0x0170;
                case -1248334819: goto L_0x015a;
                case -1026075066: goto L_0x0144;
                case -1004728940: goto L_0x0130;
                case 691401887: goto L_0x0114;
                case 822864842: goto L_0x00fa;
                case 930165504: goto L_0x00e2;
                case 1566015601: goto L_0x00d8;
                case 1566016562: goto L_0x00c1;
                case 1668750253: goto L_0x00ab;
                case 1693976202: goto L_0x0095;
                default: goto L_0x0093;
            }     // Catch:{ Exception -> 0x0297 }
        L_0x0093:
            goto L_0x018a
        L_0x0095:
            java.lang.String r0 = "application/ttml+xml"
            boolean r11 = r11.equals(r0)     // Catch:{ Exception -> 0x0297 }
            if (r11 != 0) goto L_0x009f
            goto L_0x018a
        L_0x009f:
            com.movie.ui.activity.player.text.DelegatingSubtitleDecoder r11 = new com.movie.ui.activity.player.text.DelegatingSubtitleDecoder     // Catch:{ Exception -> 0x0297 }
            androidx.media3.extractor.text.ttml.TtmlParser r0 = new androidx.media3.extractor.text.ttml.TtmlParser     // Catch:{ Exception -> 0x0297 }
            r0.<init>()     // Catch:{ Exception -> 0x0297 }
            r11.<init>(r4, r0)     // Catch:{ Exception -> 0x0297 }
            goto L_0x019c
        L_0x00ab:
            java.lang.String r0 = "application/x-subrip"
            boolean r11 = r11.equals(r0)     // Catch:{ Exception -> 0x0297 }
            if (r11 != 0) goto L_0x00b5
            goto L_0x018a
        L_0x00b5:
            com.movie.ui.activity.player.text.DelegatingSubtitleDecoder r11 = new com.movie.ui.activity.player.text.DelegatingSubtitleDecoder     // Catch:{ Exception -> 0x0297 }
            androidx.media3.extractor.text.subrip.SubripParser r0 = new androidx.media3.extractor.text.subrip.SubripParser     // Catch:{ Exception -> 0x0297 }
            r0.<init>()     // Catch:{ Exception -> 0x0297 }
            r11.<init>(r6, r0)     // Catch:{ Exception -> 0x0297 }
            goto L_0x019c
        L_0x00c1:
            java.lang.String r0 = "application/cea-708"
            boolean r11 = r11.equals(r0)     // Catch:{ Exception -> 0x0297 }
            if (r11 != 0) goto L_0x00cb
            goto L_0x018a
        L_0x00cb:
            androidx.media3.extractor.text.cea.Cea708Decoder r11 = new androidx.media3.extractor.text.cea.Cea708Decoder     // Catch:{ Exception -> 0x0297 }
            androidx.media3.common.Format r0 = r10.f32465a     // Catch:{ Exception -> 0x0297 }
            int r4 = r0.G     // Catch:{ Exception -> 0x0297 }
            java.util.List<byte[]> r0 = r0.f4018q     // Catch:{ Exception -> 0x0297 }
            r11.<init>(r4, r0)     // Catch:{ Exception -> 0x0297 }
            goto L_0x019c
        L_0x00d8:
            java.lang.String r0 = "application/cea-608"
            boolean r0 = r11.equals(r0)     // Catch:{ Exception -> 0x0297 }
            if (r0 != 0) goto L_0x00ec
            goto L_0x018a
        L_0x00e2:
            java.lang.String r0 = "application/x-mp4-cea-608"
            boolean r0 = r11.equals(r0)     // Catch:{ Exception -> 0x0297 }
            if (r0 != 0) goto L_0x00ec
            goto L_0x018a
        L_0x00ec:
            androidx.media3.extractor.text.cea.Cea608Decoder r0 = new androidx.media3.extractor.text.cea.Cea608Decoder     // Catch:{ Exception -> 0x0297 }
            androidx.media3.common.Format r4 = r10.f32465a     // Catch:{ Exception -> 0x0297 }
            int r4 = r4.G     // Catch:{ Exception -> 0x0297 }
            r6 = 16000(0x3e80, double:7.905E-320)
            r0.<init>(r11, r4, r6)     // Catch:{ Exception -> 0x0297 }
            r11 = r0
            goto L_0x019c
        L_0x00fa:
            java.lang.String r0 = "text/x-ssa"
            boolean r11 = r11.equals(r0)     // Catch:{ Exception -> 0x0297 }
            if (r11 != 0) goto L_0x0104
            goto L_0x018a
        L_0x0104:
            com.movie.ui.activity.player.text.DelegatingSubtitleDecoder r11 = new com.movie.ui.activity.player.text.DelegatingSubtitleDecoder     // Catch:{ Exception -> 0x0297 }
            androidx.media3.extractor.text.ssa.SsaParser r0 = new androidx.media3.extractor.text.ssa.SsaParser     // Catch:{ Exception -> 0x0297 }
            androidx.media3.common.Format r4 = r10.f32465a     // Catch:{ Exception -> 0x0297 }
            java.util.List<byte[]> r4 = r4.f4018q     // Catch:{ Exception -> 0x0297 }
            r0.<init>(r4)     // Catch:{ Exception -> 0x0297 }
            r11.<init>(r7, r0)     // Catch:{ Exception -> 0x0297 }
            goto L_0x019c
        L_0x0114:
            java.lang.String r0 = "application/x-quicktime-tx3g"
            boolean r11 = r11.equals(r0)     // Catch:{ Exception -> 0x0297 }
            if (r11 != 0) goto L_0x011e
            goto L_0x018a
        L_0x011e:
            com.movie.ui.activity.player.text.DelegatingSubtitleDecoder r11 = new com.movie.ui.activity.player.text.DelegatingSubtitleDecoder     // Catch:{ Exception -> 0x0297 }
            java.lang.String r0 = "Tx3g"
            androidx.media3.extractor.text.tx3g.Tx3gParser r4 = new androidx.media3.extractor.text.tx3g.Tx3gParser     // Catch:{ Exception -> 0x0297 }
            androidx.media3.common.Format r6 = r10.f32465a     // Catch:{ Exception -> 0x0297 }
            java.util.List<byte[]> r6 = r6.f4018q     // Catch:{ Exception -> 0x0297 }
            r4.<init>(r6)     // Catch:{ Exception -> 0x0297 }
            r11.<init>(r0, r4)     // Catch:{ Exception -> 0x0297 }
            goto L_0x019c
        L_0x0130:
            java.lang.String r4 = "text/vtt"
            boolean r11 = r11.equals(r4)     // Catch:{ Exception -> 0x0297 }
            if (r11 != 0) goto L_0x0139
            goto L_0x018a
        L_0x0139:
            com.movie.ui.activity.player.text.DelegatingSubtitleDecoder r11 = new com.movie.ui.activity.player.text.DelegatingSubtitleDecoder     // Catch:{ Exception -> 0x0297 }
            androidx.media3.extractor.text.webvtt.WebvttParser r4 = new androidx.media3.extractor.text.webvtt.WebvttParser     // Catch:{ Exception -> 0x0297 }
            r4.<init>()     // Catch:{ Exception -> 0x0297 }
            r11.<init>(r0, r4)     // Catch:{ Exception -> 0x0297 }
            goto L_0x019c
        L_0x0144:
            java.lang.String r0 = "application/x-mp4-vtt"
            boolean r11 = r11.equals(r0)     // Catch:{ Exception -> 0x0297 }
            if (r11 != 0) goto L_0x014d
            goto L_0x018a
        L_0x014d:
            com.movie.ui.activity.player.text.DelegatingSubtitleDecoder r11 = new com.movie.ui.activity.player.text.DelegatingSubtitleDecoder     // Catch:{ Exception -> 0x0297 }
            java.lang.String r0 = "Mp4vtt"
            androidx.media3.extractor.text.webvtt.Mp4WebvttParser r4 = new androidx.media3.extractor.text.webvtt.Mp4WebvttParser     // Catch:{ Exception -> 0x0297 }
            r4.<init>()     // Catch:{ Exception -> 0x0297 }
            r11.<init>(r0, r4)     // Catch:{ Exception -> 0x0297 }
            goto L_0x019c
        L_0x015a:
            java.lang.String r0 = "application/pgs"
            boolean r11 = r11.equals(r0)     // Catch:{ Exception -> 0x0297 }
            if (r11 != 0) goto L_0x0163
            goto L_0x018a
        L_0x0163:
            com.movie.ui.activity.player.text.DelegatingSubtitleDecoder r11 = new com.movie.ui.activity.player.text.DelegatingSubtitleDecoder     // Catch:{ Exception -> 0x0297 }
            java.lang.String r0 = "PGS"
            androidx.media3.extractor.text.pgs.PgsParser r4 = new androidx.media3.extractor.text.pgs.PgsParser     // Catch:{ Exception -> 0x0297 }
            r4.<init>()     // Catch:{ Exception -> 0x0297 }
            r11.<init>(r0, r4)     // Catch:{ Exception -> 0x0297 }
            goto L_0x019c
        L_0x0170:
            java.lang.String r0 = "application/dvbsubs"
            boolean r11 = r11.equals(r0)     // Catch:{ Exception -> 0x0297 }
            if (r11 != 0) goto L_0x0179
            goto L_0x018a
        L_0x0179:
            com.movie.ui.activity.player.text.DelegatingSubtitleDecoder r11 = new com.movie.ui.activity.player.text.DelegatingSubtitleDecoder     // Catch:{ Exception -> 0x0297 }
            java.lang.String r0 = "DVBSUBS"
            androidx.media3.extractor.text.dvb.DvbParser r4 = new androidx.media3.extractor.text.dvb.DvbParser     // Catch:{ Exception -> 0x0297 }
            androidx.media3.common.Format r6 = r10.f32465a     // Catch:{ Exception -> 0x0297 }
            java.util.List<byte[]> r6 = r6.f4018q     // Catch:{ Exception -> 0x0297 }
            r4.<init>(r6)     // Catch:{ Exception -> 0x0297 }
            r11.<init>(r0, r4)     // Catch:{ Exception -> 0x0297 }
            goto L_0x019c
        L_0x018a:
            r11 = r8
            goto L_0x019c
        L_0x018c:
            com.movie.ui.activity.player.text.DelegatingSubtitleDecoder r11 = new com.movie.ui.activity.player.text.DelegatingSubtitleDecoder     // Catch:{ Exception -> 0x0297 }
            androidx.media3.extractor.text.ssa.SsaParser r0 = new androidx.media3.extractor.text.ssa.SsaParser     // Catch:{ Exception -> 0x0297 }
            androidx.media3.common.Format r4 = r10.f32465a     // Catch:{ Exception -> 0x0297 }
            if (r4 == 0) goto L_0x0196
            java.util.List<byte[]> r8 = r4.f4018q     // Catch:{ Exception -> 0x0297 }
        L_0x0196:
            r0.<init>(r8)     // Catch:{ Exception -> 0x0297 }
            r11.<init>(r7, r0)     // Catch:{ Exception -> 0x0297 }
        L_0x019c:
            r10.f32467c = r11     // Catch:{ Exception -> 0x0297 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0297 }
            r11.<init>()     // Catch:{ Exception -> 0x0297 }
            java.lang.String r0 = "Decoder selected: "
            r11.append(r0)     // Catch:{ Exception -> 0x0297 }
            androidx.media3.extractor.text.SubtitleDecoder r0 = r10.f32467c     // Catch:{ Exception -> 0x0297 }
            r11.append(r0)     // Catch:{ Exception -> 0x0297 }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x0297 }
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0297 }
            r1.h(r11, r0)     // Catch:{ Exception -> 0x0297 }
            androidx.media3.extractor.text.SubtitleDecoder r11 = r10.f32467c     // Catch:{ Exception -> 0x0297 }
            if (r11 == 0) goto L_0x02a1
            java.lang.Object r0 = r11.d()     // Catch:{ Exception -> 0x0297 }
            androidx.media3.extractor.text.SubtitleInputBuffer r0 = (androidx.media3.extractor.text.SubtitleInputBuffer) r0     // Catch:{ Exception -> 0x0297 }
            if (r0 == 0) goto L_0x0212
            boolean r1 = r11 instanceof com.movie.ui.activity.player.text.DelegatingSubtitleDecoder     // Catch:{ Exception -> 0x0297 }
            if (r1 != 0) goto L_0x0200
            boolean r1 = f32460f     // Catch:{ Exception -> 0x0297 }
            if (r1 == 0) goto L_0x01e3
            java.util.List<kotlin.text.Regex> r1 = f32464j     // Catch:{ Exception -> 0x0297 }
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch:{ Exception -> 0x0297 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0297 }
        L_0x01d2:
            boolean r4 = r1.hasNext()     // Catch:{ Exception -> 0x0297 }
            if (r4 == 0) goto L_0x01e3
            java.lang.Object r4 = r1.next()     // Catch:{ Exception -> 0x0297 }
            kotlin.text.Regex r4 = (kotlin.text.Regex) r4     // Catch:{ Exception -> 0x0297 }
            java.lang.String r3 = r4.h(r3, r5)     // Catch:{ Exception -> 0x0297 }
            goto L_0x01d2
        L_0x01e3:
            boolean r1 = f32461g     // Catch:{ Exception -> 0x0297 }
            if (r1 == 0) goto L_0x0200
            java.util.List<kotlin.text.Regex> r1 = f32463i     // Catch:{ Exception -> 0x0297 }
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch:{ Exception -> 0x0297 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0297 }
        L_0x01ef:
            boolean r4 = r1.hasNext()     // Catch:{ Exception -> 0x0297 }
            if (r4 == 0) goto L_0x0200
            java.lang.Object r4 = r1.next()     // Catch:{ Exception -> 0x0297 }
            kotlin.text.Regex r4 = (kotlin.text.Regex) r4     // Catch:{ Exception -> 0x0297 }
            java.lang.String r3 = r4.h(r3, r5)     // Catch:{ Exception -> 0x0297 }
            goto L_0x01ef
        L_0x0200:
            kotlin.jvm.internal.Intrinsics.c(r0)     // Catch:{ Exception -> 0x0297 }
            r10.m(r0, r3)     // Catch:{ Exception -> 0x0297 }
            r11.c(r0)     // Catch:{ Exception -> 0x0297 }
            timber.log.Timber$Forest r11 = timber.log.Timber.f42178a     // Catch:{ Exception -> 0x0297 }
            java.lang.String r0 = "Decoder queueInputBuffer successfully"
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0297 }
            r11.h(r0, r1)     // Catch:{ Exception -> 0x0297 }
        L_0x0212:
            kotlin.jvm.functions.Function0<kotlin.Unit> r11 = r10.f32466b     // Catch:{ Exception -> 0x0297 }
            if (r11 == 0) goto L_0x02a1
            r11.invoke()     // Catch:{ Exception -> 0x0297 }
            goto L_0x02a1
        L_0x021b:
            java.lang.String r0 = "Decoder else queueInputBuffer successfully"
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0297 }
            r1.h(r0, r4)     // Catch:{ Exception -> 0x0297 }
            if (r3 == 0) goto L_0x022c
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.v(r3)     // Catch:{ Exception -> 0x0297 }
            if (r0 == 0) goto L_0x022b
            goto L_0x022c
        L_0x022b:
            r6 = 0
        L_0x022c:
            if (r6 != 0) goto L_0x028f
            androidx.media3.extractor.text.SubtitleDecoder r0 = r10.f32467c     // Catch:{ Exception -> 0x0297 }
            boolean r1 = r0 instanceof com.movie.ui.activity.player.text.DelegatingSubtitleDecoder     // Catch:{ Exception -> 0x0297 }
            if (r1 == 0) goto L_0x028c
            java.lang.String r1 = "null cannot be cast to non-null type com.movie.ui.activity.player.text.DelegatingSubtitleDecoder"
            kotlin.jvm.internal.Intrinsics.d(r0, r1)     // Catch:{ Exception -> 0x0297 }
            com.movie.ui.activity.player.text.DelegatingSubtitleDecoder r0 = (com.movie.ui.activity.player.text.DelegatingSubtitleDecoder) r0     // Catch:{ Exception -> 0x0297 }
            androidx.media3.extractor.text.SubtitleParser r0 = r0.D()     // Catch:{ Exception -> 0x0297 }
            boolean r0 = r0 instanceof androidx.media3.extractor.text.ssa.SsaParser     // Catch:{ Exception -> 0x0297 }
            if (r0 == 0) goto L_0x028c
            boolean r0 = f32460f     // Catch:{ Exception -> 0x0297 }
            if (r0 == 0) goto L_0x0260
            java.util.List<kotlin.text.Regex> r0 = f32464j     // Catch:{ Exception -> 0x0297 }
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch:{ Exception -> 0x0297 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0297 }
        L_0x024f:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x0297 }
            if (r1 == 0) goto L_0x0260
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x0297 }
            kotlin.text.Regex r1 = (kotlin.text.Regex) r1     // Catch:{ Exception -> 0x0297 }
            java.lang.String r3 = r1.h(r3, r5)     // Catch:{ Exception -> 0x0297 }
            goto L_0x024f
        L_0x0260:
            boolean r0 = f32461g     // Catch:{ Exception -> 0x0297 }
            if (r0 == 0) goto L_0x027d
            java.util.List<kotlin.text.Regex> r0 = f32463i     // Catch:{ Exception -> 0x0297 }
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch:{ Exception -> 0x0297 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0297 }
        L_0x026c:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x0297 }
            if (r1 == 0) goto L_0x027d
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x0297 }
            kotlin.text.Regex r1 = (kotlin.text.Regex) r1     // Catch:{ Exception -> 0x0297 }
            java.lang.String r3 = r1.h(r3, r5)     // Catch:{ Exception -> 0x0297 }
            goto L_0x026c
        L_0x027d:
            boolean r0 = f32462h     // Catch:{ Exception -> 0x0297 }
            if (r0 == 0) goto L_0x028c
            java.util.Locale r0 = java.util.Locale.ROOT     // Catch:{ Exception -> 0x0297 }
            java.lang.String r3 = r3.toUpperCase(r0)     // Catch:{ Exception -> 0x0297 }
            java.lang.String r0 = "this as java.lang.String).toUpperCase(Locale.ROOT)"
            kotlin.jvm.internal.Intrinsics.e(r3, r0)     // Catch:{ Exception -> 0x0297 }
        L_0x028c:
            r10.m(r11, r3)     // Catch:{ Exception -> 0x0297 }
        L_0x028f:
            androidx.media3.extractor.text.SubtitleDecoder r0 = r10.f32467c     // Catch:{ Exception -> 0x0297 }
            if (r0 == 0) goto L_0x02a1
            r0.c(r11)     // Catch:{ Exception -> 0x0297 }
            goto L_0x02a1
        L_0x0297:
            r11 = move-exception
            timber.log.Timber$Forest r0 = timber.log.Timber.f42178a
            java.lang.String r1 = "error"
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r0.d(r11, r1, r2)
        L_0x02a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.movie.ui.activity.player.text.CustomDecoder.c(androidx.media3.extractor.text.SubtitleInputBuffer):void");
    }

    public void release() {
        SubtitleDecoder subtitleDecoder = this.f32467c;
        if (subtitleDecoder != null) {
            subtitleDecoder.release();
        }
    }
}
