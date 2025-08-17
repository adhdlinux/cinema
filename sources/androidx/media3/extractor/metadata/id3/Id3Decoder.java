package androidx.media3.extractor.metadata.id3;

import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.metadata.MetadataInputBuffer;
import androidx.media3.extractor.metadata.SimpleMetadataDecoder;
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
    public static final FramePredicate f8323b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final FramePredicate f8324a;

    public interface FramePredicate {
        boolean a(int i2, int i3, int i4, int i5, int i6);
    }

    private static final class Id3Header {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f8325a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final boolean f8326b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final int f8327c;

        public Id3Header(int i2, boolean z2, int i3) {
            this.f8325a = i2;
            this.f8326b = z2;
            this.f8327c = i3;
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
    private static boolean C(androidx.media3.common.util.ParsableByteArray r18, int r19, int r20, boolean r21) {
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.metadata.id3.Id3Decoder.C(androidx.media3.common.util.ParsableByteArray, int, int, boolean):boolean");
    }

    private static byte[] d(byte[] bArr, int i2, int i3) {
        if (i3 <= i2) {
            return Util.f4719f;
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

    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0194, code lost:
        if (r13 == 67) goto L_0x0196;
     */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0209  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static androidx.media3.extractor.metadata.id3.Id3Frame k(int r20, androidx.media3.common.util.ParsableByteArray r21, boolean r22, int r23, androidx.media3.extractor.metadata.id3.Id3Decoder.FramePredicate r24) {
        /*
            r7 = r20
            r8 = r21
            int r9 = r21.H()
            int r10 = r21.H()
            int r11 = r21.H()
            r12 = 3
            if (r7 < r12) goto L_0x0019
            int r1 = r21.H()
            r13 = r1
            goto L_0x001a
        L_0x0019:
            r13 = 0
        L_0x001a:
            r14 = 4
            if (r7 != r14) goto L_0x003c
            int r1 = r21.L()
            if (r22 != 0) goto L_0x003a
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
            if (r7 != r12) goto L_0x0043
            int r1 = r21.L()
            goto L_0x003a
        L_0x0043:
            int r1 = r21.K()
            goto L_0x003a
        L_0x0048:
            if (r7 < r12) goto L_0x0050
            int r1 = r21.N()
            r6 = r1
            goto L_0x0051
        L_0x0050:
            r6 = 0
        L_0x0051:
            r16 = 0
            if (r9 != 0) goto L_0x0067
            if (r10 != 0) goto L_0x0067
            if (r11 != 0) goto L_0x0067
            if (r13 != 0) goto L_0x0067
            if (r15 != 0) goto L_0x0067
            if (r6 != 0) goto L_0x0067
            int r0 = r21.g()
            r8.U(r0)
            return r16
        L_0x0067:
            int r1 = r21.f()
            int r5 = r1 + r15
            int r1 = r21.g()
            java.lang.String r4 = "Id3Decoder"
            if (r5 <= r1) goto L_0x0082
            java.lang.String r0 = "Frame size exceeds remaining tag data"
            androidx.media3.common.util.Log.h(r4, r0)
            int r0 = r21.g()
            r8.U(r0)
            return r16
        L_0x0082:
            if (r24 == 0) goto L_0x009a
            r1 = r24
            r2 = r20
            r3 = r9
            r17 = r4
            r4 = r10
            r14 = r5
            r5 = r11
            r0 = r6
            r6 = r13
            boolean r1 = r1.a(r2, r3, r4, r5, r6)
            if (r1 != 0) goto L_0x009e
            r8.U(r14)
            return r16
        L_0x009a:
            r17 = r4
            r14 = r5
            r0 = r6
        L_0x009e:
            r1 = 1
            if (r7 != r12) goto L_0x00bd
            r2 = r0 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x00a7
            r2 = 1
            goto L_0x00a8
        L_0x00a7:
            r2 = 0
        L_0x00a8:
            r3 = r0 & 64
            if (r3 == 0) goto L_0x00ae
            r3 = 1
            goto L_0x00af
        L_0x00ae:
            r3 = 0
        L_0x00af:
            r0 = r0 & 32
            if (r0 == 0) goto L_0x00b5
            r0 = 1
            goto L_0x00b6
        L_0x00b5:
            r0 = 0
        L_0x00b6:
            r18 = r3
            r5 = 0
            r3 = r2
            r2 = r0
            r0 = r3
            goto L_0x00f0
        L_0x00bd:
            r2 = 4
            if (r7 != r2) goto L_0x00ea
            r2 = r0 & 64
            if (r2 == 0) goto L_0x00c6
            r2 = 1
            goto L_0x00c7
        L_0x00c6:
            r2 = 0
        L_0x00c7:
            r3 = r0 & 8
            if (r3 == 0) goto L_0x00cd
            r3 = 1
            goto L_0x00ce
        L_0x00cd:
            r3 = 0
        L_0x00ce:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x00d4
            r4 = 1
            goto L_0x00d5
        L_0x00d4:
            r4 = 0
        L_0x00d5:
            r5 = r0 & 2
            if (r5 == 0) goto L_0x00db
            r5 = 1
            goto L_0x00dc
        L_0x00db:
            r5 = 0
        L_0x00dc:
            r0 = r0 & r1
            if (r0 == 0) goto L_0x00e1
            r0 = 1
            goto L_0x00e2
        L_0x00e1:
            r0 = 0
        L_0x00e2:
            r18 = r4
            r19 = r3
            r3 = r0
            r0 = r19
            goto L_0x00f0
        L_0x00ea:
            r0 = 0
            r2 = 0
            r3 = 0
            r5 = 0
            r18 = 0
        L_0x00f0:
            if (r0 != 0) goto L_0x022c
            if (r18 == 0) goto L_0x00f6
            goto L_0x022c
        L_0x00f6:
            if (r2 == 0) goto L_0x00fd
            int r15 = r15 + -1
            r8.V(r1)
        L_0x00fd:
            if (r3 == 0) goto L_0x0105
            int r15 = r15 + -4
            r0 = 4
            r8.V(r0)
        L_0x0105:
            if (r5 == 0) goto L_0x010b
            int r15 = B(r8, r15)
        L_0x010b:
            r0 = 84
            r1 = 88
            r2 = 2
            if (r9 != r0) goto L_0x0120
            if (r10 != r1) goto L_0x0120
            if (r11 != r1) goto L_0x0120
            if (r7 == r2) goto L_0x011a
            if (r13 != r1) goto L_0x0120
        L_0x011a:
            androidx.media3.extractor.metadata.id3.TextInformationFrame r0 = s(r8, r15)     // Catch:{ OutOfMemoryError -> 0x0132, Exception -> 0x012f, all -> 0x012c }
            goto L_0x01f6
        L_0x0120:
            if (r9 != r0) goto L_0x0135
            java.lang.String r0 = x(r7, r9, r10, r11, r13)     // Catch:{ OutOfMemoryError -> 0x0132, Exception -> 0x012f, all -> 0x012c }
            androidx.media3.extractor.metadata.id3.TextInformationFrame r0 = q(r8, r15, r0)     // Catch:{ OutOfMemoryError -> 0x0132, Exception -> 0x012f, all -> 0x012c }
            goto L_0x01f6
        L_0x012c:
            r0 = move-exception
            goto L_0x0200
        L_0x012f:
            r0 = move-exception
            goto L_0x0204
        L_0x0132:
            r0 = move-exception
            goto L_0x0204
        L_0x0135:
            r3 = 87
            if (r9 != r3) goto L_0x0147
            if (r10 != r1) goto L_0x0147
            if (r11 != r1) goto L_0x0147
            if (r7 == r2) goto L_0x0141
            if (r13 != r1) goto L_0x0147
        L_0x0141:
            androidx.media3.extractor.metadata.id3.UrlLinkFrame r0 = u(r8, r15)     // Catch:{ OutOfMemoryError -> 0x0132, Exception -> 0x012f, all -> 0x012c }
            goto L_0x01f6
        L_0x0147:
            if (r9 != r3) goto L_0x0153
            java.lang.String r0 = x(r7, r9, r10, r11, r13)     // Catch:{ OutOfMemoryError -> 0x0132, Exception -> 0x012f, all -> 0x012c }
            androidx.media3.extractor.metadata.id3.UrlLinkFrame r0 = t(r8, r15, r0)     // Catch:{ OutOfMemoryError -> 0x0132, Exception -> 0x012f, all -> 0x012c }
            goto L_0x01f6
        L_0x0153:
            r1 = 73
            r3 = 80
            if (r9 != r3) goto L_0x0169
            r4 = 82
            if (r10 != r4) goto L_0x0169
            if (r11 != r1) goto L_0x0169
            r4 = 86
            if (r13 != r4) goto L_0x0169
            androidx.media3.extractor.metadata.id3.PrivFrame r0 = o(r8, r15)     // Catch:{ OutOfMemoryError -> 0x0132, Exception -> 0x012f, all -> 0x012c }
            goto L_0x01f6
        L_0x0169:
            r4 = 71
            r5 = 79
            if (r9 != r4) goto L_0x0181
            r4 = 69
            if (r10 != r4) goto L_0x0181
            if (r11 != r5) goto L_0x0181
            r4 = 66
            if (r13 == r4) goto L_0x017b
            if (r7 != r2) goto L_0x0181
        L_0x017b:
            androidx.media3.extractor.metadata.id3.GeobFrame r0 = l(r8, r15)     // Catch:{ OutOfMemoryError -> 0x0132, Exception -> 0x012f, all -> 0x012c }
            goto L_0x01f6
        L_0x0181:
            r4 = 65
            r6 = 67
            if (r7 != r2) goto L_0x018e
            if (r9 != r3) goto L_0x019c
            if (r10 != r1) goto L_0x019c
            if (r11 != r6) goto L_0x019c
            goto L_0x0196
        L_0x018e:
            if (r9 != r4) goto L_0x019c
            if (r10 != r3) goto L_0x019c
            if (r11 != r1) goto L_0x019c
            if (r13 != r6) goto L_0x019c
        L_0x0196:
            androidx.media3.extractor.metadata.id3.ApicFrame r0 = f(r8, r15, r7)     // Catch:{ OutOfMemoryError -> 0x0132, Exception -> 0x012f, all -> 0x012c }
            goto L_0x01f6
        L_0x019c:
            r1 = 77
            if (r9 != r6) goto L_0x01ad
            if (r10 != r5) goto L_0x01ad
            if (r11 != r1) goto L_0x01ad
            if (r13 == r1) goto L_0x01a8
            if (r7 != r2) goto L_0x01ad
        L_0x01a8:
            androidx.media3.extractor.metadata.id3.CommentFrame r0 = j(r8, r15)     // Catch:{ OutOfMemoryError -> 0x0132, Exception -> 0x012f, all -> 0x012c }
            goto L_0x01f6
        L_0x01ad:
            if (r9 != r6) goto L_0x01c7
            r2 = 72
            if (r10 != r2) goto L_0x01c7
            if (r11 != r4) goto L_0x01c7
            if (r13 != r3) goto L_0x01c7
            r1 = r21
            r2 = r15
            r3 = r20
            r4 = r22
            r5 = r23
            r6 = r24
            androidx.media3.extractor.metadata.id3.ChapterFrame r0 = h(r1, r2, r3, r4, r5, r6)     // Catch:{ OutOfMemoryError -> 0x0132, Exception -> 0x012f, all -> 0x012c }
            goto L_0x01f6
        L_0x01c7:
            if (r9 != r6) goto L_0x01df
            if (r10 != r0) goto L_0x01df
            if (r11 != r5) goto L_0x01df
            if (r13 != r6) goto L_0x01df
            r1 = r21
            r2 = r15
            r3 = r20
            r4 = r22
            r5 = r23
            r6 = r24
            androidx.media3.extractor.metadata.id3.ChapterTocFrame r0 = i(r1, r2, r3, r4, r5, r6)     // Catch:{ OutOfMemoryError -> 0x0132, Exception -> 0x012f, all -> 0x012c }
            goto L_0x01f6
        L_0x01df:
            if (r9 != r1) goto L_0x01ee
            r1 = 76
            if (r10 != r1) goto L_0x01ee
            if (r11 != r1) goto L_0x01ee
            if (r13 != r0) goto L_0x01ee
            androidx.media3.extractor.metadata.id3.MlltFrame r0 = n(r8, r15)     // Catch:{ OutOfMemoryError -> 0x0132, Exception -> 0x012f, all -> 0x012c }
            goto L_0x01f6
        L_0x01ee:
            java.lang.String r0 = x(r7, r9, r10, r11, r13)     // Catch:{ OutOfMemoryError -> 0x0132, Exception -> 0x012f, all -> 0x012c }
            androidx.media3.extractor.metadata.id3.BinaryFrame r0 = g(r8, r15, r0)     // Catch:{ OutOfMemoryError -> 0x0132, Exception -> 0x012f, all -> 0x012c }
        L_0x01f6:
            r8.U(r14)
            r19 = r16
            r16 = r0
            r0 = r19
            goto L_0x0207
        L_0x0200:
            r8.U(r14)
            throw r0
        L_0x0204:
            r8.U(r14)
        L_0x0207:
            if (r16 != 0) goto L_0x022b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to decode frame: id="
            r1.append(r2)
            java.lang.String r2 = x(r7, r9, r10, r11, r13)
            r1.append(r2)
            java.lang.String r2 = ", frameSize="
            r1.append(r2)
            r1.append(r15)
            java.lang.String r1 = r1.toString()
            r2 = r17
            androidx.media3.common.util.Log.i(r2, r1, r0)
        L_0x022b:
            return r16
        L_0x022c:
            r2 = r17
            java.lang.String r0 = "Skipping unsupported compressed or encrypted frame"
            androidx.media3.common.util.Log.h(r2, r0)
            r8.U(r14)
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.metadata.id3.Id3Decoder.k(int, androidx.media3.common.util.ParsableByteArray, boolean, int, androidx.media3.extractor.metadata.id3.Id3Decoder$FramePredicate):androidx.media3.extractor.metadata.id3.Id3Frame");
    }

    private static GeobFrame l(ParsableByteArray parsableByteArray, int i2) {
        int H = parsableByteArray.H();
        Charset w2 = w(H);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        parsableByteArray.l(bArr, 0, i3);
        int z2 = z(bArr, 0);
        String t2 = MimeTypes.t(new String(bArr, 0, z2, Charsets.ISO_8859_1));
        int i4 = z2 + 1;
        int y2 = y(bArr, i4, H);
        String p2 = p(bArr, i4, y2, w2);
        int v2 = y2 + v(H);
        int y3 = y(bArr, v2, H);
        return new GeobFrame(t2, p2, p(bArr, v2, y3, w2), d(bArr, y3 + v(H), i3));
    }

    private static Id3Header m(ParsableByteArray parsableByteArray) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        if (parsableByteArray.a() < 10) {
            Log.h("Id3Decoder", "Data too short to be an ID3 tag");
            return null;
        }
        int K = parsableByteArray.K();
        boolean z6 = false;
        if (K != 4801587) {
            Log.h("Id3Decoder", "Unexpected first three bytes of ID3 tag header: 0x" + String.format("%06X", new Object[]{Integer.valueOf(K)}));
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
                Log.h("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
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
            Log.h("Id3Decoder", "Skipped ID3 tag with unsupported majorVersion=" + H);
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
        if (m2.f8325a == 2) {
            i3 = 6;
        } else {
            i3 = 10;
        }
        int b2 = m2.f8327c;
        if (m2.f8326b) {
            b2 = B(parsableByteArray, m2.f8327c);
        }
        parsableByteArray.T(f2 + b2);
        boolean z2 = false;
        if (!C(parsableByteArray, m2.f8325a, i3, false)) {
            if (m2.f8325a != 4 || !C(parsableByteArray, 4, i3, true)) {
                Log.h("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + m2.f8325a);
                return null;
            }
            z2 = true;
        }
        while (parsableByteArray.a() >= i3) {
            Id3Frame k2 = k(m2.f8325a, parsableByteArray, z2, i3, this.f8324a);
            if (k2 != null) {
                arrayList.add(k2);
            }
        }
        return new Metadata((List<? extends Metadata.Entry>) arrayList);
    }

    public Id3Decoder(FramePredicate framePredicate) {
        this.f8324a = framePredicate;
    }
}
