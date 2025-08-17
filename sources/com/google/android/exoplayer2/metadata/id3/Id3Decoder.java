package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.metadata.SimpleMetadataDecoder;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public final class Id3Decoder extends SimpleMetadataDecoder {

    /* renamed from: b  reason: collision with root package name */
    public static final FramePredicate f25423b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final FramePredicate f25424a;

    public interface FramePredicate {
        boolean a(int i2, int i3, int i4, int i5, int i6);
    }

    private static final class Id3Header {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f25425a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final boolean f25426b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final int f25427c;

        public Id3Header(int i2, boolean z2, int i3) {
            this.f25425a = i2;
            this.f25426b = z2;
            this.f25427c = i3;
        }
    }

    public Id3Decoder() {
        this((FramePredicate) null);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean A(int i2, int i3, int i4, int i5, int i6) {
        return false;
    }

    private static int B(ParsableByteArray parsableByteArray, int i2) {
        byte[] e2 = parsableByteArray.e();
        int f2 = parsableByteArray.f();
        int i3 = f2;
        while (true) {
            int i4 = i3 + 1;
            if (i4 >= f2 + i2) {
                return i2;
            }
            if ((e2[i3] & 255) == 255 && e2[i4] == 0) {
                System.arraycopy(e2, i3 + 2, e2, i4, (i2 - (i3 - f2)) - 2);
                i2--;
            }
            i3 = i4;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0076, code lost:
        if ((r10 & 1) != 0) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0086, code lost:
        if ((r10 & 128) != 0) goto L_0x008b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean C(com.google.android.exoplayer2.util.ParsableByteArray r18, int r19, int r20, boolean r21) {
        /*
            r1 = r18
            r0 = r19
            int r2 = r18.f()
        L_0x0008:
            int r3 = r18.a()     // Catch:{ all -> 0x00af }
            r4 = 1
            r5 = r20
            if (r3 < r5) goto L_0x00ab
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L_0x0022
            int r7 = r18.q()     // Catch:{ all -> 0x00af }
            long r8 = r18.J()     // Catch:{ all -> 0x00af }
            int r10 = r18.N()     // Catch:{ all -> 0x00af }
            goto L_0x002c
        L_0x0022:
            int r7 = r18.K()     // Catch:{ all -> 0x00af }
            int r8 = r18.K()     // Catch:{ all -> 0x00af }
            long r8 = (long) r8
            r10 = 0
        L_0x002c:
            r11 = 0
            if (r7 != 0) goto L_0x003a
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L_0x003a
            if (r10 != 0) goto L_0x003a
            r1.U(r2)
            return r4
        L_0x003a:
            r7 = 4
            if (r0 != r7) goto L_0x006b
            if (r21 != 0) goto L_0x006b
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 == 0) goto L_0x004b
            r1.U(r2)
            return r6
        L_0x004b:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 16
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 14
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 24
            long r8 = r8 >> r15
            long r8 = r8 & r11
            r11 = 21
            long r8 = r8 << r11
            long r8 = r8 | r13
        L_0x006b:
            if (r0 != r7) goto L_0x007b
            r3 = r10 & 64
            if (r3 == 0) goto L_0x0073
            r3 = 1
            goto L_0x0074
        L_0x0073:
            r3 = 0
        L_0x0074:
            r7 = r10 & 1
            if (r7 == 0) goto L_0x0079
            goto L_0x008b
        L_0x0079:
            r4 = 0
            goto L_0x008b
        L_0x007b:
            if (r0 != r3) goto L_0x0089
            r3 = r10 & 32
            if (r3 == 0) goto L_0x0083
            r3 = 1
            goto L_0x0084
        L_0x0083:
            r3 = 0
        L_0x0084:
            r7 = r10 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x0079
            goto L_0x008b
        L_0x0089:
            r3 = 0
            goto L_0x0079
        L_0x008b:
            if (r4 == 0) goto L_0x008f
            int r3 = r3 + 4
        L_0x008f:
            long r3 = (long) r3
            int r7 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r7 >= 0) goto L_0x0098
            r1.U(r2)
            return r6
        L_0x0098:
            int r3 = r18.a()     // Catch:{ all -> 0x00af }
            long r3 = (long) r3
            int r7 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r7 >= 0) goto L_0x00a5
            r1.U(r2)
            return r6
        L_0x00a5:
            int r3 = (int) r8
            r1.V(r3)     // Catch:{ all -> 0x00af }
            goto L_0x0008
        L_0x00ab:
            r1.U(r2)
            return r4
        L_0x00af:
            r0 = move-exception
            r1.U(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.metadata.id3.Id3Decoder.C(com.google.android.exoplayer2.util.ParsableByteArray, int, int, boolean):boolean");
    }

    private static byte[] d(byte[] bArr, int i2, int i3) {
        if (i3 <= i2) {
            return Util.f28813f;
        }
        return Arrays.copyOfRange(bArr, i2, i3);
    }

    private static ApicFrame f(ParsableByteArray parsableByteArray, int i2, int i3) {
        int i4;
        String str;
        int H = parsableByteArray.H();
        Charset w2 = w(H);
        int i5 = i2 - 1;
        byte[] bArr = new byte[i5];
        parsableByteArray.l(bArr, 0, i5);
        if (i3 == 2) {
            str = "image/" + Ascii.e(new String(bArr, 0, 3, Charsets.ISO_8859_1));
            if ("image/jpg".equals(str)) {
                str = "image/jpeg";
            }
            i4 = 2;
        } else {
            i4 = z(bArr, 0);
            String e2 = Ascii.e(new String(bArr, 0, i4, Charsets.ISO_8859_1));
            if (e2.indexOf(47) == -1) {
                str = "image/" + e2;
            } else {
                str = e2;
            }
        }
        int i6 = i4 + 2;
        int y2 = y(bArr, i6, H);
        return new ApicFrame(str, new String(bArr, i6, y2 - i6, w2), bArr[i4 + 1] & 255, d(bArr, y2 + v(H), i5));
    }

    private static BinaryFrame g(ParsableByteArray parsableByteArray, int i2, String str) {
        byte[] bArr = new byte[i2];
        parsableByteArray.l(bArr, 0, i2);
        return new BinaryFrame(str, bArr);
    }

    private static ChapterFrame h(ParsableByteArray parsableByteArray, int i2, int i3, boolean z2, int i4, FramePredicate framePredicate) {
        long j2;
        long j3;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int f2 = parsableByteArray.f();
        int z3 = z(parsableByteArray.e(), f2);
        String str = new String(parsableByteArray.e(), f2, z3 - f2, Charsets.ISO_8859_1);
        parsableByteArray.U(z3 + 1);
        int q2 = parsableByteArray.q();
        int q3 = parsableByteArray.q();
        long J = parsableByteArray.J();
        if (J == 4294967295L) {
            j2 = -1;
        } else {
            j2 = J;
        }
        long J2 = parsableByteArray.J();
        if (J2 == 4294967295L) {
            j3 = -1;
        } else {
            j3 = J2;
        }
        ArrayList arrayList = new ArrayList();
        int i5 = f2 + i2;
        while (parsableByteArray.f() < i5) {
            Id3Frame k2 = k(i3, parsableByteArray, z2, i4, framePredicate);
            if (k2 != null) {
                arrayList.add(k2);
            }
        }
        return new ChapterFrame(str, q2, q3, j2, j3, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    private static ChapterTocFrame i(ParsableByteArray parsableByteArray, int i2, int i3, boolean z2, int i4, FramePredicate framePredicate) {
        boolean z3;
        boolean z4;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int f2 = parsableByteArray.f();
        int z5 = z(parsableByteArray.e(), f2);
        String str = new String(parsableByteArray.e(), f2, z5 - f2, Charsets.ISO_8859_1);
        parsableByteArray2.U(z5 + 1);
        int H = parsableByteArray.H();
        if ((H & 2) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if ((H & 1) != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        int H2 = parsableByteArray.H();
        String[] strArr = new String[H2];
        for (int i5 = 0; i5 < H2; i5++) {
            int f3 = parsableByteArray.f();
            int z6 = z(parsableByteArray.e(), f3);
            strArr[i5] = new String(parsableByteArray.e(), f3, z6 - f3, Charsets.ISO_8859_1);
            parsableByteArray2.U(z6 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i6 = f2 + i2;
        while (parsableByteArray.f() < i6) {
            Id3Frame k2 = k(i3, parsableByteArray2, z2, i4, framePredicate);
            if (k2 != null) {
                arrayList.add(k2);
            }
        }
        return new ChapterTocFrame(str, z3, z4, strArr, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    private static CommentFrame j(ParsableByteArray parsableByteArray, int i2) {
        if (i2 < 4) {
            return null;
        }
        int H = parsableByteArray.H();
        Charset w2 = w(H);
        byte[] bArr = new byte[3];
        parsableByteArray.l(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i3 = i2 - 4;
        byte[] bArr2 = new byte[i3];
        parsableByteArray.l(bArr2, 0, i3);
        int y2 = y(bArr2, 0, H);
        String str2 = new String(bArr2, 0, y2, w2);
        int v2 = y2 + v(H);
        return new CommentFrame(str, str2, p(bArr2, v2, y(bArr2, v2, H), w2));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0190, code lost:
        if (r13 == 67) goto L_0x0192;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.metadata.id3.Id3Frame k(int r19, com.google.android.exoplayer2.util.ParsableByteArray r20, boolean r21, int r22, com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate r23) {
        /*
            r0 = r19
            r7 = r20
            int r8 = r20.H()
            int r9 = r20.H()
            int r10 = r20.H()
            r12 = 3
            if (r0 < r12) goto L_0x0019
            int r1 = r20.H()
            r13 = r1
            goto L_0x001a
        L_0x0019:
            r13 = 0
        L_0x001a:
            r14 = 4
            if (r0 != r14) goto L_0x003c
            int r1 = r20.L()
            if (r21 != 0) goto L_0x003a
            r2 = r1 & 255(0xff, float:3.57E-43)
            int r3 = r1 >> 8
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << 7
            r2 = r2 | r3
            int r3 = r1 >> 16
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << 14
            r2 = r2 | r3
            int r1 = r1 >> 24
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << 21
            r1 = r1 | r2
        L_0x003a:
            r15 = r1
            goto L_0x0048
        L_0x003c:
            if (r0 != r12) goto L_0x0043
            int r1 = r20.L()
            goto L_0x003a
        L_0x0043:
            int r1 = r20.K()
            goto L_0x003a
        L_0x0048:
            if (r0 < r12) goto L_0x0050
            int r1 = r20.N()
            r6 = r1
            goto L_0x0051
        L_0x0050:
            r6 = 0
        L_0x0051:
            r16 = 0
            if (r8 != 0) goto L_0x0067
            if (r9 != 0) goto L_0x0067
            if (r10 != 0) goto L_0x0067
            if (r13 != 0) goto L_0x0067
            if (r15 != 0) goto L_0x0067
            if (r6 != 0) goto L_0x0067
            int r0 = r20.g()
            r7.U(r0)
            return r16
        L_0x0067:
            int r1 = r20.f()
            int r5 = r1 + r15
            int r1 = r20.g()
            java.lang.String r4 = "Id3Decoder"
            if (r5 <= r1) goto L_0x0082
            java.lang.String r0 = "Frame size exceeds remaining tag data"
            com.google.android.exoplayer2.util.Log.i(r4, r0)
            int r0 = r20.g()
            r7.U(r0)
            return r16
        L_0x0082:
            if (r23 == 0) goto L_0x009a
            r1 = r23
            r2 = r19
            r3 = r8
            r11 = r4
            r4 = r9
            r14 = r5
            r5 = r10
            r18 = r6
            r6 = r13
            boolean r1 = r1.a(r2, r3, r4, r5, r6)
            if (r1 != 0) goto L_0x009e
            r7.U(r14)
            return r16
        L_0x009a:
            r11 = r4
            r14 = r5
            r18 = r6
        L_0x009e:
            r1 = 1
            if (r0 != r12) goto L_0x00bc
            r2 = r18
            r3 = r2 & 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x00a9
            r3 = 1
            goto L_0x00aa
        L_0x00a9:
            r3 = 0
        L_0x00aa:
            r4 = r2 & 64
            if (r4 == 0) goto L_0x00b0
            r4 = 1
            goto L_0x00b1
        L_0x00b0:
            r4 = 0
        L_0x00b1:
            r2 = r2 & 32
            if (r2 == 0) goto L_0x00b7
            r2 = 1
            goto L_0x00b8
        L_0x00b7:
            r2 = 0
        L_0x00b8:
            r17 = r3
            r6 = 0
            goto L_0x00f2
        L_0x00bc:
            r2 = r18
            r3 = 4
            if (r0 != r3) goto L_0x00ec
            r3 = r2 & 64
            if (r3 == 0) goto L_0x00c7
            r3 = 1
            goto L_0x00c8
        L_0x00c7:
            r3 = 0
        L_0x00c8:
            r4 = r2 & 8
            if (r4 == 0) goto L_0x00ce
            r4 = 1
            goto L_0x00cf
        L_0x00ce:
            r4 = 0
        L_0x00cf:
            r5 = r2 & 4
            if (r5 == 0) goto L_0x00d5
            r5 = 1
            goto L_0x00d6
        L_0x00d5:
            r5 = 0
        L_0x00d6:
            r6 = r2 & 2
            if (r6 == 0) goto L_0x00dc
            r6 = 1
            goto L_0x00dd
        L_0x00dc:
            r6 = 0
        L_0x00dd:
            r2 = r2 & r1
            if (r2 == 0) goto L_0x00e3
            r17 = 1
            goto L_0x00e5
        L_0x00e3:
            r17 = 0
        L_0x00e5:
            r2 = r3
            r3 = r17
            r17 = r4
            r4 = r5
            goto L_0x00f2
        L_0x00ec:
            r2 = 0
            r3 = 0
            r4 = 0
            r6 = 0
            r17 = 0
        L_0x00f2:
            if (r17 != 0) goto L_0x021c
            if (r4 == 0) goto L_0x00f8
            goto L_0x021c
        L_0x00f8:
            if (r2 == 0) goto L_0x00ff
            int r15 = r15 + -1
            r7.V(r1)
        L_0x00ff:
            if (r3 == 0) goto L_0x0107
            int r15 = r15 + -4
            r1 = 4
            r7.V(r1)
        L_0x0107:
            if (r6 == 0) goto L_0x010d
            int r15 = B(r7, r15)
        L_0x010d:
            r1 = 84
            r2 = 2
            r3 = 88
            if (r8 != r1) goto L_0x0122
            if (r9 != r3) goto L_0x0122
            if (r10 != r3) goto L_0x0122
            if (r0 == r2) goto L_0x011c
            if (r13 != r3) goto L_0x0122
        L_0x011c:
            com.google.android.exoplayer2.metadata.id3.TextInformationFrame r1 = s(r7, r15)     // Catch:{ all -> 0x012e }
            goto L_0x01f2
        L_0x0122:
            if (r8 != r1) goto L_0x0131
            java.lang.String r1 = x(r0, r8, r9, r10, r13)     // Catch:{ all -> 0x012e }
            com.google.android.exoplayer2.metadata.id3.TextInformationFrame r1 = q(r7, r15, r1)     // Catch:{ all -> 0x012e }
            goto L_0x01f2
        L_0x012e:
            r0 = move-exception
            goto L_0x0218
        L_0x0131:
            r4 = 87
            if (r8 != r4) goto L_0x0143
            if (r9 != r3) goto L_0x0143
            if (r10 != r3) goto L_0x0143
            if (r0 == r2) goto L_0x013d
            if (r13 != r3) goto L_0x0143
        L_0x013d:
            com.google.android.exoplayer2.metadata.id3.UrlLinkFrame r1 = u(r7, r15)     // Catch:{ all -> 0x012e }
            goto L_0x01f2
        L_0x0143:
            if (r8 != r4) goto L_0x014f
            java.lang.String r1 = x(r0, r8, r9, r10, r13)     // Catch:{ all -> 0x012e }
            com.google.android.exoplayer2.metadata.id3.UrlLinkFrame r1 = t(r7, r15, r1)     // Catch:{ all -> 0x012e }
            goto L_0x01f2
        L_0x014f:
            r3 = 73
            r4 = 80
            if (r8 != r4) goto L_0x0165
            r5 = 82
            if (r9 != r5) goto L_0x0165
            if (r10 != r3) goto L_0x0165
            r5 = 86
            if (r13 != r5) goto L_0x0165
            com.google.android.exoplayer2.metadata.id3.PrivFrame r1 = o(r7, r15)     // Catch:{ all -> 0x012e }
            goto L_0x01f2
        L_0x0165:
            r5 = 71
            r6 = 79
            if (r8 != r5) goto L_0x017d
            r5 = 69
            if (r9 != r5) goto L_0x017d
            if (r10 != r6) goto L_0x017d
            r5 = 66
            if (r13 == r5) goto L_0x0177
            if (r0 != r2) goto L_0x017d
        L_0x0177:
            com.google.android.exoplayer2.metadata.id3.GeobFrame r1 = l(r7, r15)     // Catch:{ all -> 0x012e }
            goto L_0x01f2
        L_0x017d:
            r5 = 65
            r12 = 67
            if (r0 != r2) goto L_0x018a
            if (r8 != r4) goto L_0x0198
            if (r9 != r3) goto L_0x0198
            if (r10 != r12) goto L_0x0198
            goto L_0x0192
        L_0x018a:
            if (r8 != r5) goto L_0x0198
            if (r9 != r4) goto L_0x0198
            if (r10 != r3) goto L_0x0198
            if (r13 != r12) goto L_0x0198
        L_0x0192:
            com.google.android.exoplayer2.metadata.id3.ApicFrame r1 = f(r7, r15, r0)     // Catch:{ all -> 0x012e }
            goto L_0x01f2
        L_0x0198:
            r3 = 77
            if (r8 != r12) goto L_0x01a9
            if (r9 != r6) goto L_0x01a9
            if (r10 != r3) goto L_0x01a9
            if (r13 == r3) goto L_0x01a4
            if (r0 != r2) goto L_0x01a9
        L_0x01a4:
            com.google.android.exoplayer2.metadata.id3.CommentFrame r1 = j(r7, r15)     // Catch:{ all -> 0x012e }
            goto L_0x01f2
        L_0x01a9:
            if (r8 != r12) goto L_0x01c3
            r2 = 72
            if (r9 != r2) goto L_0x01c3
            if (r10 != r5) goto L_0x01c3
            if (r13 != r4) goto L_0x01c3
            r1 = r20
            r2 = r15
            r3 = r19
            r4 = r21
            r5 = r22
            r6 = r23
            com.google.android.exoplayer2.metadata.id3.ChapterFrame r1 = h(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x012e }
            goto L_0x01f2
        L_0x01c3:
            if (r8 != r12) goto L_0x01db
            if (r9 != r1) goto L_0x01db
            if (r10 != r6) goto L_0x01db
            if (r13 != r12) goto L_0x01db
            r1 = r20
            r2 = r15
            r3 = r19
            r4 = r21
            r5 = r22
            r6 = r23
            com.google.android.exoplayer2.metadata.id3.ChapterTocFrame r1 = i(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x012e }
            goto L_0x01f2
        L_0x01db:
            if (r8 != r3) goto L_0x01ea
            r2 = 76
            if (r9 != r2) goto L_0x01ea
            if (r10 != r2) goto L_0x01ea
            if (r13 != r1) goto L_0x01ea
            com.google.android.exoplayer2.metadata.id3.MlltFrame r1 = n(r7, r15)     // Catch:{ all -> 0x012e }
            goto L_0x01f2
        L_0x01ea:
            java.lang.String r1 = x(r0, r8, r9, r10, r13)     // Catch:{ all -> 0x012e }
            com.google.android.exoplayer2.metadata.id3.BinaryFrame r1 = g(r7, r15, r1)     // Catch:{ all -> 0x012e }
        L_0x01f2:
            if (r1 != 0) goto L_0x0214
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x012e }
            r2.<init>()     // Catch:{ all -> 0x012e }
            java.lang.String r3 = "Failed to decode frame: id="
            r2.append(r3)     // Catch:{ all -> 0x012e }
            java.lang.String r0 = x(r0, r8, r9, r10, r13)     // Catch:{ all -> 0x012e }
            r2.append(r0)     // Catch:{ all -> 0x012e }
            java.lang.String r0 = ", frameSize="
            r2.append(r0)     // Catch:{ all -> 0x012e }
            r2.append(r15)     // Catch:{ all -> 0x012e }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x012e }
            com.google.android.exoplayer2.util.Log.i(r11, r0)     // Catch:{ all -> 0x012e }
        L_0x0214:
            r7.U(r14)
            return r1
        L_0x0218:
            r7.U(r14)
            throw r0
        L_0x021c:
            java.lang.String r0 = "Skipping unsupported compressed or encrypted frame"
            com.google.android.exoplayer2.util.Log.i(r11, r0)
            r7.U(r14)
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.metadata.id3.Id3Decoder.k(int, com.google.android.exoplayer2.util.ParsableByteArray, boolean, int, com.google.android.exoplayer2.metadata.id3.Id3Decoder$FramePredicate):com.google.android.exoplayer2.metadata.id3.Id3Frame");
    }

    private static GeobFrame l(ParsableByteArray parsableByteArray, int i2) {
        int H = parsableByteArray.H();
        Charset w2 = w(H);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        parsableByteArray.l(bArr, 0, i3);
        int z2 = z(bArr, 0);
        String str = new String(bArr, 0, z2, Charsets.ISO_8859_1);
        int i4 = z2 + 1;
        int y2 = y(bArr, i4, H);
        String p2 = p(bArr, i4, y2, w2);
        int v2 = y2 + v(H);
        int y3 = y(bArr, v2, H);
        return new GeobFrame(str, p2, p(bArr, v2, y3, w2), d(bArr, y3 + v(H), i3));
    }

    private static Id3Header m(ParsableByteArray parsableByteArray) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        if (parsableByteArray.a() < 10) {
            Log.i("Id3Decoder", "Data too short to be an ID3 tag");
            return null;
        }
        int K = parsableByteArray.K();
        boolean z6 = false;
        if (K != 4801587) {
            Log.i("Id3Decoder", "Unexpected first three bytes of ID3 tag header: 0x" + String.format("%06X", new Object[]{Integer.valueOf(K)}));
            return null;
        }
        int H = parsableByteArray.H();
        parsableByteArray.V(1);
        int H2 = parsableByteArray.H();
        int G = parsableByteArray.G();
        if (H == 2) {
            if ((H2 & 64) != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (z5) {
                Log.i("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        } else if (H == 3) {
            if ((H2 & 64) != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                int q2 = parsableByteArray.q();
                parsableByteArray.V(q2);
                G -= q2 + 4;
            }
        } else if (H == 4) {
            if ((H2 & 64) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                int G2 = parsableByteArray.G();
                parsableByteArray.V(G2 - 4);
                G -= G2;
            }
            if ((H2 & 16) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                G -= 10;
            }
        } else {
            Log.i("Id3Decoder", "Skipped ID3 tag with unsupported majorVersion=" + H);
            return null;
        }
        if (H < 4 && (H2 & 128) != 0) {
            z6 = true;
        }
        return new Id3Header(H, z6, G);
    }

    private static MlltFrame n(ParsableByteArray parsableByteArray, int i2) {
        int N = parsableByteArray.N();
        int K = parsableByteArray.K();
        int K2 = parsableByteArray.K();
        int H = parsableByteArray.H();
        int H2 = parsableByteArray.H();
        ParsableBitArray parsableBitArray = new ParsableBitArray();
        parsableBitArray.m(parsableByteArray);
        int i3 = ((i2 - 10) * 8) / (H + H2);
        int[] iArr = new int[i3];
        int[] iArr2 = new int[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            int h2 = parsableBitArray.h(H);
            int h3 = parsableBitArray.h(H2);
            iArr[i4] = h2;
            iArr2[i4] = h3;
        }
        return new MlltFrame(N, K, K2, iArr, iArr2);
    }

    private static PrivFrame o(ParsableByteArray parsableByteArray, int i2) {
        byte[] bArr = new byte[i2];
        parsableByteArray.l(bArr, 0, i2);
        int z2 = z(bArr, 0);
        return new PrivFrame(new String(bArr, 0, z2, Charsets.ISO_8859_1), d(bArr, z2 + 1, i2));
    }

    private static String p(byte[] bArr, int i2, int i3, Charset charset) {
        if (i3 <= i2 || i3 > bArr.length) {
            return "";
        }
        return new String(bArr, i2, i3 - i2, charset);
    }

    private static TextInformationFrame q(ParsableByteArray parsableByteArray, int i2, String str) {
        if (i2 < 1) {
            return null;
        }
        int H = parsableByteArray.H();
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        parsableByteArray.l(bArr, 0, i3);
        return new TextInformationFrame(str, (String) null, r(bArr, H, 0));
    }

    private static ImmutableList<String> r(byte[] bArr, int i2, int i3) {
        if (i3 >= bArr.length) {
            return ImmutableList.s("");
        }
        ImmutableList.Builder k2 = ImmutableList.k();
        int y2 = y(bArr, i3, i2);
        while (i3 < y2) {
            k2.d(new String(bArr, i3, y2 - i3, w(i2)));
            i3 = v(i2) + y2;
            y2 = y(bArr, i3, i2);
        }
        ImmutableList<String> k3 = k2.k();
        if (k3.isEmpty()) {
            return ImmutableList.s("");
        }
        return k3;
    }

    private static TextInformationFrame s(ParsableByteArray parsableByteArray, int i2) {
        if (i2 < 1) {
            return null;
        }
        int H = parsableByteArray.H();
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        parsableByteArray.l(bArr, 0, i3);
        int y2 = y(bArr, 0, H);
        return new TextInformationFrame("TXXX", new String(bArr, 0, y2, w(H)), r(bArr, H, y2 + v(H)));
    }

    private static UrlLinkFrame t(ParsableByteArray parsableByteArray, int i2, String str) {
        byte[] bArr = new byte[i2];
        parsableByteArray.l(bArr, 0, i2);
        return new UrlLinkFrame(str, (String) null, new String(bArr, 0, z(bArr, 0), Charsets.ISO_8859_1));
    }

    private static UrlLinkFrame u(ParsableByteArray parsableByteArray, int i2) {
        if (i2 < 1) {
            return null;
        }
        int H = parsableByteArray.H();
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        parsableByteArray.l(bArr, 0, i3);
        int y2 = y(bArr, 0, H);
        String str = new String(bArr, 0, y2, w(H));
        int v2 = y2 + v(H);
        return new UrlLinkFrame("WXXX", str, p(bArr, v2, z(bArr, v2), Charsets.ISO_8859_1));
    }

    private static int v(int i2) {
        return (i2 == 0 || i2 == 3) ? 1 : 2;
    }

    private static Charset w(int i2) {
        if (i2 == 1) {
            return Charsets.UTF_16;
        }
        if (i2 == 2) {
            return Charsets.UTF_16BE;
        }
        if (i2 != 3) {
            return Charsets.ISO_8859_1;
        }
        return Charsets.UTF_8;
    }

    private static String x(int i2, int i3, int i4, int i5, int i6) {
        if (i2 == 2) {
            return String.format(Locale.US, "%c%c%c", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
        }
        return String.format(Locale.US, "%c%c%c%c", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)});
    }

    private static int y(byte[] bArr, int i2, int i3) {
        int z2 = z(bArr, i2);
        if (i3 == 0 || i3 == 3) {
            return z2;
        }
        while (z2 < bArr.length - 1) {
            if ((z2 - i2) % 2 == 0 && bArr[z2 + 1] == 0) {
                return z2;
            }
            z2 = z(bArr, z2 + 1);
        }
        return bArr.length;
    }

    private static int z(byte[] bArr, int i2) {
        while (i2 < bArr.length) {
            if (bArr[i2] == 0) {
                return i2;
            }
            i2++;
        }
        return bArr.length;
    }

    /* access modifiers changed from: protected */
    public Metadata b(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        return e(byteBuffer.array(), byteBuffer.limit());
    }

    public Metadata e(byte[] bArr, int i2) {
        int i3;
        ArrayList arrayList = new ArrayList();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i2);
        Id3Header m2 = m(parsableByteArray);
        if (m2 == null) {
            return null;
        }
        int f2 = parsableByteArray.f();
        if (m2.f25425a == 2) {
            i3 = 6;
        } else {
            i3 = 10;
        }
        int b2 = m2.f25427c;
        if (m2.f25426b) {
            b2 = B(parsableByteArray, m2.f25427c);
        }
        parsableByteArray.T(f2 + b2);
        boolean z2 = false;
        if (!C(parsableByteArray, m2.f25425a, i3, false)) {
            if (m2.f25425a != 4 || !C(parsableByteArray, 4, i3, true)) {
                Log.i("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + m2.f25425a);
                return null;
            }
            z2 = true;
        }
        while (parsableByteArray.a() >= i3) {
            Id3Frame k2 = k(m2.f25425a, parsableByteArray, z2, i3, this.f25424a);
            if (k2 != null) {
                arrayList.add(k2);
            }
        }
        return new Metadata((List<? extends Metadata.Entry>) arrayList);
    }

    public Id3Decoder(FramePredicate framePredicate) {
        this.f25424a = framePredicate;
    }
}
