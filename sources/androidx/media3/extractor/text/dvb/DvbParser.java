package androidx.media3.extractor.text.dvb;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.f;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.common.collect.ImmutableList;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.ArrayList;
import java.util.List;

public final class DvbParser implements SubtitleParser {

    /* renamed from: h  reason: collision with root package name */
    private static final byte[] f8903h = {0, 7, 8, 15};

    /* renamed from: i  reason: collision with root package name */
    private static final byte[] f8904i = {0, 119, -120, -1};

    /* renamed from: j  reason: collision with root package name */
    private static final byte[] f8905j = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};

    /* renamed from: a  reason: collision with root package name */
    private final Paint f8906a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f8907b;

    /* renamed from: c  reason: collision with root package name */
    private final Canvas f8908c = new Canvas();

    /* renamed from: d  reason: collision with root package name */
    private final DisplayDefinition f8909d = new DisplayDefinition(719, 575, 0, 719, 0, 575);

    /* renamed from: e  reason: collision with root package name */
    private final ClutDefinition f8910e = new ClutDefinition(0, e(), f(), g());

    /* renamed from: f  reason: collision with root package name */
    private final SubtitleService f8911f;

    /* renamed from: g  reason: collision with root package name */
    private Bitmap f8912g;

    private static final class ClutDefinition {

        /* renamed from: a  reason: collision with root package name */
        public final int f8913a;

        /* renamed from: b  reason: collision with root package name */
        public final int[] f8914b;

        /* renamed from: c  reason: collision with root package name */
        public final int[] f8915c;

        /* renamed from: d  reason: collision with root package name */
        public final int[] f8916d;

        public ClutDefinition(int i2, int[] iArr, int[] iArr2, int[] iArr3) {
            this.f8913a = i2;
            this.f8914b = iArr;
            this.f8915c = iArr2;
            this.f8916d = iArr3;
        }
    }

    private static final class DisplayDefinition {

        /* renamed from: a  reason: collision with root package name */
        public final int f8917a;

        /* renamed from: b  reason: collision with root package name */
        public final int f8918b;

        /* renamed from: c  reason: collision with root package name */
        public final int f8919c;

        /* renamed from: d  reason: collision with root package name */
        public final int f8920d;

        /* renamed from: e  reason: collision with root package name */
        public final int f8921e;

        /* renamed from: f  reason: collision with root package name */
        public final int f8922f;

        public DisplayDefinition(int i2, int i3, int i4, int i5, int i6, int i7) {
            this.f8917a = i2;
            this.f8918b = i3;
            this.f8919c = i4;
            this.f8920d = i5;
            this.f8921e = i6;
            this.f8922f = i7;
        }
    }

    private static final class ObjectData {

        /* renamed from: a  reason: collision with root package name */
        public final int f8923a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f8924b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f8925c;

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f8926d;

        public ObjectData(int i2, boolean z2, byte[] bArr, byte[] bArr2) {
            this.f8923a = i2;
            this.f8924b = z2;
            this.f8925c = bArr;
            this.f8926d = bArr2;
        }
    }

    private static final class PageComposition {

        /* renamed from: a  reason: collision with root package name */
        public final int f8927a;

        /* renamed from: b  reason: collision with root package name */
        public final int f8928b;

        /* renamed from: c  reason: collision with root package name */
        public final int f8929c;

        /* renamed from: d  reason: collision with root package name */
        public final SparseArray<PageRegion> f8930d;

        public PageComposition(int i2, int i3, int i4, SparseArray<PageRegion> sparseArray) {
            this.f8927a = i2;
            this.f8928b = i3;
            this.f8929c = i4;
            this.f8930d = sparseArray;
        }
    }

    private static final class PageRegion {

        /* renamed from: a  reason: collision with root package name */
        public final int f8931a;

        /* renamed from: b  reason: collision with root package name */
        public final int f8932b;

        public PageRegion(int i2, int i3) {
            this.f8931a = i2;
            this.f8932b = i3;
        }
    }

    private static final class RegionComposition {

        /* renamed from: a  reason: collision with root package name */
        public final int f8933a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f8934b;

        /* renamed from: c  reason: collision with root package name */
        public final int f8935c;

        /* renamed from: d  reason: collision with root package name */
        public final int f8936d;

        /* renamed from: e  reason: collision with root package name */
        public final int f8937e;

        /* renamed from: f  reason: collision with root package name */
        public final int f8938f;

        /* renamed from: g  reason: collision with root package name */
        public final int f8939g;

        /* renamed from: h  reason: collision with root package name */
        public final int f8940h;

        /* renamed from: i  reason: collision with root package name */
        public final int f8941i;

        /* renamed from: j  reason: collision with root package name */
        public final int f8942j;

        /* renamed from: k  reason: collision with root package name */
        public final SparseArray<RegionObject> f8943k;

        public RegionComposition(int i2, boolean z2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, SparseArray<RegionObject> sparseArray) {
            this.f8933a = i2;
            this.f8934b = z2;
            this.f8935c = i3;
            this.f8936d = i4;
            this.f8937e = i5;
            this.f8938f = i6;
            this.f8939g = i7;
            this.f8940h = i8;
            this.f8941i = i9;
            this.f8942j = i10;
            this.f8943k = sparseArray;
        }

        public void a(RegionComposition regionComposition) {
            SparseArray<RegionObject> sparseArray = regionComposition.f8943k;
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                this.f8943k.put(sparseArray.keyAt(i2), sparseArray.valueAt(i2));
            }
        }
    }

    private static final class RegionObject {

        /* renamed from: a  reason: collision with root package name */
        public final int f8944a;

        /* renamed from: b  reason: collision with root package name */
        public final int f8945b;

        /* renamed from: c  reason: collision with root package name */
        public final int f8946c;

        /* renamed from: d  reason: collision with root package name */
        public final int f8947d;

        /* renamed from: e  reason: collision with root package name */
        public final int f8948e;

        /* renamed from: f  reason: collision with root package name */
        public final int f8949f;

        public RegionObject(int i2, int i3, int i4, int i5, int i6, int i7) {
            this.f8944a = i2;
            this.f8945b = i3;
            this.f8946c = i4;
            this.f8947d = i5;
            this.f8948e = i6;
            this.f8949f = i7;
        }
    }

    private static final class SubtitleService {

        /* renamed from: a  reason: collision with root package name */
        public final int f8950a;

        /* renamed from: b  reason: collision with root package name */
        public final int f8951b;

        /* renamed from: c  reason: collision with root package name */
        public final SparseArray<RegionComposition> f8952c = new SparseArray<>();

        /* renamed from: d  reason: collision with root package name */
        public final SparseArray<ClutDefinition> f8953d = new SparseArray<>();

        /* renamed from: e  reason: collision with root package name */
        public final SparseArray<ObjectData> f8954e = new SparseArray<>();

        /* renamed from: f  reason: collision with root package name */
        public final SparseArray<ClutDefinition> f8955f = new SparseArray<>();

        /* renamed from: g  reason: collision with root package name */
        public final SparseArray<ObjectData> f8956g = new SparseArray<>();

        /* renamed from: h  reason: collision with root package name */
        public DisplayDefinition f8957h;

        /* renamed from: i  reason: collision with root package name */
        public PageComposition f8958i;

        public SubtitleService(int i2, int i3) {
            this.f8950a = i2;
            this.f8951b = i3;
        }

        public void a() {
            this.f8952c.clear();
            this.f8953d.clear();
            this.f8954e.clear();
            this.f8955f.clear();
            this.f8956g.clear();
            this.f8957h = null;
            this.f8958i = null;
        }
    }

    public DvbParser(List<byte[]> list) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(list.get(0));
        int N = parsableByteArray.N();
        int N2 = parsableByteArray.N();
        Paint paint = new Paint();
        this.f8906a = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect((PathEffect) null);
        Paint paint2 = new Paint();
        this.f8907b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect((PathEffect) null);
        this.f8911f = new SubtitleService(N, N2);
    }

    private static byte[] d(int i2, int i3, ParsableBitArray parsableBitArray) {
        byte[] bArr = new byte[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            bArr[i4] = (byte) parsableBitArray.h(i3);
        }
        return bArr;
    }

    private static int[] e() {
        return new int[]{0, -1, -16777216, -8421505};
    }

    private static int[] f() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i7 = 1; i7 < 16; i7++) {
            if (i7 < 8) {
                if ((i7 & 1) != 0) {
                    i4 = JfifUtil.MARKER_FIRST_BYTE;
                } else {
                    i4 = 0;
                }
                if ((i7 & 2) != 0) {
                    i5 = JfifUtil.MARKER_FIRST_BYTE;
                } else {
                    i5 = 0;
                }
                if ((i7 & 4) != 0) {
                    i6 = JfifUtil.MARKER_FIRST_BYTE;
                } else {
                    i6 = 0;
                }
                iArr[i7] = h(JfifUtil.MARKER_FIRST_BYTE, i4, i5, i6);
            } else {
                int i8 = 127;
                if ((i7 & 1) != 0) {
                    i2 = 127;
                } else {
                    i2 = 0;
                }
                if ((i7 & 2) != 0) {
                    i3 = 127;
                } else {
                    i3 = 0;
                }
                if ((i7 & 4) == 0) {
                    i8 = 0;
                }
                iArr[i7] = h(JfifUtil.MARKER_FIRST_BYTE, i2, i3, i8);
            }
        }
        return iArr;
    }

    private static int[] g() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int[] iArr = new int[UserVerificationMethods.USER_VERIFY_HANDPRINT];
        iArr[0] = 0;
        for (int i20 = 0; i20 < 256; i20++) {
            int i21 = JfifUtil.MARKER_FIRST_BYTE;
            if (i20 < 8) {
                if ((i20 & 1) != 0) {
                    i18 = JfifUtil.MARKER_FIRST_BYTE;
                } else {
                    i18 = 0;
                }
                if ((i20 & 2) != 0) {
                    i19 = JfifUtil.MARKER_FIRST_BYTE;
                } else {
                    i19 = 0;
                }
                if ((i20 & 4) == 0) {
                    i21 = 0;
                }
                iArr[i20] = h(63, i18, i19, i21);
            } else {
                int i22 = i20 & Sdk$SDKError.Reason.PRIVACY_URL_ERROR_VALUE;
                int i23 = 170;
                int i24 = 85;
                if (i22 == 0) {
                    if ((i20 & 1) != 0) {
                        i2 = 85;
                    } else {
                        i2 = 0;
                    }
                    if ((i20 & 16) != 0) {
                        i3 = 170;
                    } else {
                        i3 = 0;
                    }
                    int i25 = i2 + i3;
                    if ((i20 & 2) != 0) {
                        i4 = 85;
                    } else {
                        i4 = 0;
                    }
                    if ((i20 & 32) != 0) {
                        i5 = 170;
                    } else {
                        i5 = 0;
                    }
                    int i26 = i4 + i5;
                    if ((i20 & 4) == 0) {
                        i24 = 0;
                    }
                    if ((i20 & 64) == 0) {
                        i23 = 0;
                    }
                    iArr[i20] = h(JfifUtil.MARKER_FIRST_BYTE, i25, i26, i24 + i23);
                } else if (i22 != 8) {
                    int i27 = 43;
                    if (i22 == 128) {
                        if ((i20 & 1) != 0) {
                            i10 = 43;
                        } else {
                            i10 = 0;
                        }
                        int i28 = i10 + 127;
                        if ((i20 & 16) != 0) {
                            i11 = 85;
                        } else {
                            i11 = 0;
                        }
                        int i29 = i28 + i11;
                        if ((i20 & 2) != 0) {
                            i12 = 43;
                        } else {
                            i12 = 0;
                        }
                        int i30 = i12 + 127;
                        if ((i20 & 32) != 0) {
                            i13 = 85;
                        } else {
                            i13 = 0;
                        }
                        int i31 = i30 + i13;
                        if ((i20 & 4) == 0) {
                            i27 = 0;
                        }
                        int i32 = i27 + 127;
                        if ((i20 & 64) == 0) {
                            i24 = 0;
                        }
                        iArr[i20] = h(JfifUtil.MARKER_FIRST_BYTE, i29, i31, i32 + i24);
                    } else if (i22 == 136) {
                        if ((i20 & 1) != 0) {
                            i14 = 43;
                        } else {
                            i14 = 0;
                        }
                        if ((i20 & 16) != 0) {
                            i15 = 85;
                        } else {
                            i15 = 0;
                        }
                        int i33 = i14 + i15;
                        if ((i20 & 2) != 0) {
                            i16 = 43;
                        } else {
                            i16 = 0;
                        }
                        if ((i20 & 32) != 0) {
                            i17 = 85;
                        } else {
                            i17 = 0;
                        }
                        int i34 = i16 + i17;
                        if ((i20 & 4) == 0) {
                            i27 = 0;
                        }
                        if ((i20 & 64) == 0) {
                            i24 = 0;
                        }
                        iArr[i20] = h(JfifUtil.MARKER_FIRST_BYTE, i33, i34, i27 + i24);
                    }
                } else {
                    if ((i20 & 1) != 0) {
                        i6 = 85;
                    } else {
                        i6 = 0;
                    }
                    if ((i20 & 16) != 0) {
                        i7 = 170;
                    } else {
                        i7 = 0;
                    }
                    int i35 = i6 + i7;
                    if ((i20 & 2) != 0) {
                        i8 = 85;
                    } else {
                        i8 = 0;
                    }
                    if ((i20 & 32) != 0) {
                        i9 = 170;
                    } else {
                        i9 = 0;
                    }
                    int i36 = i8 + i9;
                    if ((i20 & 4) == 0) {
                        i24 = 0;
                    }
                    if ((i20 & 64) == 0) {
                        i23 = 0;
                    }
                    iArr[i20] = h(127, i35, i36, i24 + i23);
                }
            }
        }
        return iArr;
    }

    private static int h(int i2, int i3, int i4, int i5) {
        return (i2 << 24) | (i3 << 16) | (i4 << 8) | i5;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v24, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0083 A[LOOP:0: B:1:0x0009->B:31:0x0083, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0082 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int i(androidx.media3.common.util.ParsableBitArray r13, int[] r14, byte[] r15, int r16, int r17, android.graphics.Paint r18, android.graphics.Canvas r19) {
        /*
            r0 = r13
            r1 = r17
            r8 = r18
            r9 = 0
            r10 = r16
            r2 = 0
        L_0x0009:
            r3 = 2
            int r4 = r13.h(r3)
            r5 = 1
            if (r4 == 0) goto L_0x0014
            r11 = r2
        L_0x0012:
            r12 = 1
            goto L_0x0061
        L_0x0014:
            boolean r4 = r13.g()
            r6 = 3
            if (r4 == 0) goto L_0x0028
            int r4 = r13.h(r6)
            int r4 = r4 + r6
            int r3 = r13.h(r3)
        L_0x0024:
            r11 = r2
            r12 = r4
            r4 = r3
            goto L_0x0061
        L_0x0028:
            boolean r4 = r13.g()
            if (r4 == 0) goto L_0x0031
            r11 = r2
            r4 = 0
            goto L_0x0012
        L_0x0031:
            int r4 = r13.h(r3)
            if (r4 == 0) goto L_0x005e
            if (r4 == r5) goto L_0x005a
            if (r4 == r3) goto L_0x004e
            if (r4 == r6) goto L_0x0041
            r11 = r2
            r4 = 0
        L_0x003f:
            r12 = 0
            goto L_0x0061
        L_0x0041:
            r4 = 8
            int r4 = r13.h(r4)
            int r4 = r4 + 29
            int r3 = r13.h(r3)
            goto L_0x0024
        L_0x004e:
            r4 = 4
            int r4 = r13.h(r4)
            int r4 = r4 + 12
            int r3 = r13.h(r3)
            goto L_0x0024
        L_0x005a:
            r11 = r2
            r4 = 0
            r12 = 2
            goto L_0x0061
        L_0x005e:
            r4 = 0
            r11 = 1
            goto L_0x003f
        L_0x0061:
            if (r12 == 0) goto L_0x007f
            if (r8 == 0) goto L_0x007f
            if (r15 == 0) goto L_0x0069
            byte r4 = r15[r4]
        L_0x0069:
            r2 = r14[r4]
            r8.setColor(r2)
            float r3 = (float) r10
            float r4 = (float) r1
            int r2 = r10 + r12
            float r6 = (float) r2
            int r2 = r1 + 1
            float r7 = (float) r2
            r2 = r19
            r5 = r6
            r6 = r7
            r7 = r18
            r2.drawRect(r3, r4, r5, r6, r7)
        L_0x007f:
            int r10 = r10 + r12
            if (r11 == 0) goto L_0x0083
            return r10
        L_0x0083:
            r2 = r11
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.dvb.DvbParser.i(androidx.media3.common.util.ParsableBitArray, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v24, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0090 A[LOOP:0: B:1:0x0009->B:34:0x0090, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int j(androidx.media3.common.util.ParsableBitArray r13, int[] r14, byte[] r15, int r16, int r17, android.graphics.Paint r18, android.graphics.Canvas r19) {
        /*
            r0 = r13
            r1 = r17
            r8 = r18
            r9 = 0
            r10 = r16
            r2 = 0
        L_0x0009:
            r3 = 4
            int r4 = r13.h(r3)
            r5 = 1
            if (r4 == 0) goto L_0x0015
            r11 = r2
        L_0x0012:
            r12 = 1
            goto L_0x006e
        L_0x0015:
            boolean r4 = r13.g()
            r6 = 3
            if (r4 != 0) goto L_0x002b
            int r3 = r13.h(r6)
            if (r3 == 0) goto L_0x0028
            int r3 = r3 + 2
            r11 = r2
            r12 = r3
            r4 = 0
            goto L_0x006e
        L_0x0028:
            r4 = 0
            r11 = 1
            goto L_0x004d
        L_0x002b:
            boolean r4 = r13.g()
            r7 = 2
            if (r4 != 0) goto L_0x003f
            int r4 = r13.h(r7)
            int r4 = r4 + r3
            int r3 = r13.h(r3)
        L_0x003b:
            r11 = r2
            r12 = r4
            r4 = r3
            goto L_0x006e
        L_0x003f:
            int r4 = r13.h(r7)
            if (r4 == 0) goto L_0x006b
            if (r4 == r5) goto L_0x0067
            if (r4 == r7) goto L_0x005c
            if (r4 == r6) goto L_0x004f
            r11 = r2
            r4 = 0
        L_0x004d:
            r12 = 0
            goto L_0x006e
        L_0x004f:
            r4 = 8
            int r4 = r13.h(r4)
            int r4 = r4 + 25
            int r3 = r13.h(r3)
            goto L_0x003b
        L_0x005c:
            int r4 = r13.h(r3)
            int r4 = r4 + 9
            int r3 = r13.h(r3)
            goto L_0x003b
        L_0x0067:
            r11 = r2
            r4 = 0
            r12 = 2
            goto L_0x006e
        L_0x006b:
            r11 = r2
            r4 = 0
            goto L_0x0012
        L_0x006e:
            if (r12 == 0) goto L_0x008c
            if (r8 == 0) goto L_0x008c
            if (r15 == 0) goto L_0x0076
            byte r4 = r15[r4]
        L_0x0076:
            r2 = r14[r4]
            r8.setColor(r2)
            float r3 = (float) r10
            float r4 = (float) r1
            int r2 = r10 + r12
            float r6 = (float) r2
            int r2 = r1 + 1
            float r7 = (float) r2
            r2 = r19
            r5 = r6
            r6 = r7
            r7 = r18
            r2.drawRect(r3, r4, r5, r6, r7)
        L_0x008c:
            int r10 = r10 + r12
            if (r11 == 0) goto L_0x0090
            return r10
        L_0x0090:
            r2 = r11
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.dvb.DvbParser.j(androidx.media3.common.util.ParsableBitArray, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int k(androidx.media3.common.util.ParsableBitArray r13, int[] r14, byte[] r15, int r16, int r17, android.graphics.Paint r18, android.graphics.Canvas r19) {
        /*
            r0 = r13
            r1 = r17
            r8 = r18
            r9 = 0
            r10 = r16
            r2 = 0
        L_0x0009:
            r3 = 8
            int r4 = r13.h(r3)
            r5 = 1
            if (r4 == 0) goto L_0x0015
            r11 = r2
            r12 = 1
            goto L_0x0035
        L_0x0015:
            boolean r4 = r13.g()
            r6 = 7
            if (r4 != 0) goto L_0x002a
            int r3 = r13.h(r6)
            if (r3 == 0) goto L_0x0026
            r11 = r2
            r12 = r3
            r4 = 0
            goto L_0x0035
        L_0x0026:
            r4 = 0
            r11 = 1
            r12 = 0
            goto L_0x0035
        L_0x002a:
            int r4 = r13.h(r6)
            int r3 = r13.h(r3)
            r11 = r2
            r12 = r4
            r4 = r3
        L_0x0035:
            if (r12 == 0) goto L_0x0053
            if (r8 == 0) goto L_0x0053
            if (r15 == 0) goto L_0x003d
            byte r4 = r15[r4]
        L_0x003d:
            r2 = r14[r4]
            r8.setColor(r2)
            float r3 = (float) r10
            float r4 = (float) r1
            int r2 = r10 + r12
            float r6 = (float) r2
            int r2 = r1 + 1
            float r7 = (float) r2
            r2 = r19
            r5 = r6
            r6 = r7
            r7 = r18
            r2.drawRect(r3, r4, r5, r6, r7)
        L_0x0053:
            int r10 = r10 + r12
            if (r11 == 0) goto L_0x0057
            return r10
        L_0x0057:
            r2 = r11
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.dvb.DvbParser.k(androidx.media3.common.util.ParsableBitArray, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    private static void l(byte[] bArr, int[] iArr, int i2, int i3, int i4, Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        byte[] bArr5;
        int i5 = i2;
        byte[] bArr6 = bArr;
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr);
        int i6 = i3;
        int i7 = i4;
        byte[] bArr7 = null;
        byte[] bArr8 = null;
        byte[] bArr9 = null;
        while (parsableBitArray.b() != 0) {
            int h2 = parsableBitArray.h(8);
            if (h2 != 240) {
                switch (h2) {
                    case 16:
                        if (i5 != 3) {
                            if (i5 != 2) {
                                bArr2 = null;
                                i6 = i(parsableBitArray, iArr, bArr2, i6, i7, paint, canvas);
                                parsableBitArray.c();
                                break;
                            } else if (bArr9 == null) {
                                bArr3 = f8903h;
                            } else {
                                bArr3 = bArr9;
                            }
                        } else if (bArr7 == null) {
                            bArr3 = f8904i;
                        } else {
                            bArr3 = bArr7;
                        }
                        bArr2 = bArr3;
                        i6 = i(parsableBitArray, iArr, bArr2, i6, i7, paint, canvas);
                        parsableBitArray.c();
                    case 17:
                        if (i5 == 3) {
                            if (bArr8 == null) {
                                bArr5 = f8905j;
                            } else {
                                bArr5 = bArr8;
                            }
                            bArr4 = bArr5;
                        } else {
                            bArr4 = null;
                        }
                        i6 = j(parsableBitArray, iArr, bArr4, i6, i7, paint, canvas);
                        parsableBitArray.c();
                        break;
                    case 18:
                        i6 = k(parsableBitArray, iArr, (byte[]) null, i6, i7, paint, canvas);
                        break;
                    default:
                        switch (h2) {
                            case 32:
                                bArr9 = d(4, 4, parsableBitArray);
                                break;
                            case 33:
                                bArr7 = d(4, 8, parsableBitArray);
                                break;
                            case 34:
                                bArr8 = d(16, 8, parsableBitArray);
                                break;
                        }
                }
            } else {
                i7 += 2;
                i6 = i3;
            }
        }
    }

    private static void m(ObjectData objectData, ClutDefinition clutDefinition, int i2, int i3, int i4, Paint paint, Canvas canvas) {
        int[] iArr;
        if (i2 == 3) {
            iArr = clutDefinition.f8916d;
        } else if (i2 == 2) {
            iArr = clutDefinition.f8915c;
        } else {
            iArr = clutDefinition.f8914b;
        }
        int[] iArr2 = iArr;
        int i5 = i2;
        int i6 = i3;
        Paint paint2 = paint;
        Canvas canvas2 = canvas;
        l(objectData.f8925c, iArr2, i5, i6, i4, paint2, canvas2);
        l(objectData.f8926d, iArr2, i5, i6, i4 + 1, paint2, canvas2);
    }

    private CuesWithTiming n(ParsableBitArray parsableBitArray) {
        int i2;
        ObjectData objectData;
        int i3;
        SparseArray<RegionObject> sparseArray;
        Paint paint;
        ParsableBitArray parsableBitArray2 = parsableBitArray;
        while (parsableBitArray.b() >= 48 && parsableBitArray2.h(8) == 15) {
            t(parsableBitArray2, this.f8911f);
        }
        SubtitleService subtitleService = this.f8911f;
        PageComposition pageComposition = subtitleService.f8958i;
        if (pageComposition == null) {
            return new CuesWithTiming(ImmutableList.r(), -9223372036854775807L, -9223372036854775807L);
        }
        DisplayDefinition displayDefinition = subtitleService.f8957h;
        if (displayDefinition == null) {
            displayDefinition = this.f8909d;
        }
        Bitmap bitmap = this.f8912g;
        if (!(bitmap != null && displayDefinition.f8917a + 1 == bitmap.getWidth() && displayDefinition.f8918b + 1 == this.f8912g.getHeight())) {
            Bitmap createBitmap = Bitmap.createBitmap(displayDefinition.f8917a + 1, displayDefinition.f8918b + 1, Bitmap.Config.ARGB_8888);
            this.f8912g = createBitmap;
            this.f8908c.setBitmap(createBitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<PageRegion> sparseArray2 = pageComposition.f8930d;
        for (int i4 = 0; i4 < sparseArray2.size(); i4++) {
            this.f8908c.save();
            PageRegion valueAt = sparseArray2.valueAt(i4);
            RegionComposition regionComposition = this.f8911f.f8952c.get(sparseArray2.keyAt(i4));
            int i5 = valueAt.f8931a + displayDefinition.f8919c;
            int i6 = valueAt.f8932b + displayDefinition.f8921e;
            this.f8908c.clipRect(i5, i6, Math.min(regionComposition.f8935c + i5, displayDefinition.f8920d), Math.min(regionComposition.f8936d + i6, displayDefinition.f8922f));
            ClutDefinition clutDefinition = this.f8911f.f8953d.get(regionComposition.f8939g);
            if (clutDefinition == null && (clutDefinition = this.f8911f.f8955f.get(regionComposition.f8939g)) == null) {
                clutDefinition = this.f8910e;
            }
            SparseArray<RegionObject> sparseArray3 = regionComposition.f8943k;
            int i7 = 0;
            while (i7 < sparseArray3.size()) {
                int keyAt = sparseArray3.keyAt(i7);
                RegionObject valueAt2 = sparseArray3.valueAt(i7);
                ObjectData objectData2 = this.f8911f.f8954e.get(keyAt);
                if (objectData2 == null) {
                    objectData = this.f8911f.f8956g.get(keyAt);
                } else {
                    objectData = objectData2;
                }
                if (objectData != null) {
                    if (objectData.f8924b) {
                        paint = null;
                    } else {
                        paint = this.f8906a;
                    }
                    int i8 = i6 + valueAt2.f8947d;
                    ClutDefinition clutDefinition2 = clutDefinition;
                    i3 = i7;
                    int i9 = i8;
                    sparseArray = sparseArray3;
                    m(objectData, clutDefinition2, regionComposition.f8938f, valueAt2.f8946c + i5, i9, paint, this.f8908c);
                } else {
                    i3 = i7;
                    sparseArray = sparseArray3;
                }
                i7 = i3 + 1;
                sparseArray3 = sparseArray;
            }
            if (regionComposition.f8934b) {
                int i10 = regionComposition.f8938f;
                if (i10 == 3) {
                    i2 = clutDefinition.f8916d[regionComposition.f8940h];
                } else if (i10 == 2) {
                    i2 = clutDefinition.f8915c[regionComposition.f8941i];
                } else {
                    i2 = clutDefinition.f8914b[regionComposition.f8942j];
                }
                this.f8907b.setColor(i2);
                this.f8908c.drawRect((float) i5, (float) i6, (float) (regionComposition.f8935c + i5), (float) (regionComposition.f8936d + i6), this.f8907b);
            }
            arrayList.add(new Cue.Builder().f(Bitmap.createBitmap(this.f8912g, i5, i6, regionComposition.f8935c, regionComposition.f8936d)).k(((float) i5) / ((float) displayDefinition.f8917a)).l(0).h(((float) i6) / ((float) displayDefinition.f8918b), 0).i(0).n(((float) regionComposition.f8935c) / ((float) displayDefinition.f8917a)).g(((float) regionComposition.f8936d) / ((float) displayDefinition.f8918b)).a());
            this.f8908c.drawColor(0, PorterDuff.Mode.CLEAR);
            this.f8908c.restore();
        }
        return new CuesWithTiming(arrayList, -9223372036854775807L, -9223372036854775807L);
    }

    private static ClutDefinition o(ParsableBitArray parsableBitArray, int i2) {
        int[] iArr;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        ParsableBitArray parsableBitArray2 = parsableBitArray;
        int i8 = 8;
        int h2 = parsableBitArray2.h(8);
        parsableBitArray2.r(8);
        int i9 = 2;
        int i10 = i2 - 2;
        int[] e2 = e();
        int[] f2 = f();
        int[] g2 = g();
        while (i10 > 0) {
            int h3 = parsableBitArray2.h(i8);
            int h4 = parsableBitArray2.h(i8);
            int i11 = i10 - 2;
            if ((h4 & 128) != 0) {
                iArr = e2;
            } else if ((h4 & 64) != 0) {
                iArr = f2;
            } else {
                iArr = g2;
            }
            if ((h4 & 1) != 0) {
                i6 = parsableBitArray2.h(i8);
                i5 = parsableBitArray2.h(i8);
                i4 = parsableBitArray2.h(i8);
                i3 = parsableBitArray2.h(i8);
                i7 = i11 - 4;
            } else {
                i4 = parsableBitArray2.h(4) << 4;
                i7 = i11 - 2;
                int h5 = parsableBitArray2.h(4) << 4;
                i3 = parsableBitArray2.h(i9) << 6;
                i6 = parsableBitArray2.h(6) << i9;
                i5 = h5;
            }
            if (i6 == 0) {
                i5 = 0;
                i4 = 0;
                i3 = JfifUtil.MARKER_FIRST_BYTE;
            }
            double d2 = (double) i6;
            double d3 = (double) (i5 - 128);
            double d4 = (double) (i4 - 128);
            iArr[h3] = h((byte) (255 - (i3 & JfifUtil.MARKER_FIRST_BYTE)), Util.p((int) (d2 + (1.402d * d3)), 0, JfifUtil.MARKER_FIRST_BYTE), Util.p((int) ((d2 - (0.34414d * d4)) - (d3 * 0.71414d)), 0, JfifUtil.MARKER_FIRST_BYTE), Util.p((int) (d2 + (d4 * 1.772d)), 0, JfifUtil.MARKER_FIRST_BYTE));
            i10 = i7;
            h2 = h2;
            i8 = 8;
            i9 = 2;
        }
        return new ClutDefinition(h2, e2, f2, g2);
    }

    private static DisplayDefinition p(ParsableBitArray parsableBitArray) {
        int i2;
        int i3;
        int i4;
        int i5;
        parsableBitArray.r(4);
        boolean g2 = parsableBitArray.g();
        parsableBitArray.r(3);
        int h2 = parsableBitArray.h(16);
        int h3 = parsableBitArray.h(16);
        if (g2) {
            int h4 = parsableBitArray.h(16);
            int h5 = parsableBitArray.h(16);
            int h6 = parsableBitArray.h(16);
            i2 = parsableBitArray.h(16);
            i4 = h5;
            i3 = h6;
            i5 = h4;
        } else {
            i4 = h2;
            i2 = h3;
            i5 = 0;
            i3 = 0;
        }
        return new DisplayDefinition(h2, h3, i5, i4, i3, i2);
    }

    private static ObjectData q(ParsableBitArray parsableBitArray) {
        byte[] bArr;
        int h2 = parsableBitArray.h(16);
        parsableBitArray.r(4);
        int h3 = parsableBitArray.h(2);
        boolean g2 = parsableBitArray.g();
        parsableBitArray.r(1);
        byte[] bArr2 = Util.f4719f;
        if (h3 == 1) {
            parsableBitArray.r(parsableBitArray.h(8) * 16);
        } else if (h3 == 0) {
            int h4 = parsableBitArray.h(16);
            int h5 = parsableBitArray.h(16);
            if (h4 > 0) {
                bArr2 = new byte[h4];
                parsableBitArray.k(bArr2, 0, h4);
            }
            if (h5 > 0) {
                bArr = new byte[h5];
                parsableBitArray.k(bArr, 0, h5);
                return new ObjectData(h2, g2, bArr2, bArr);
            }
        }
        bArr = bArr2;
        return new ObjectData(h2, g2, bArr2, bArr);
    }

    private static PageComposition r(ParsableBitArray parsableBitArray, int i2) {
        int h2 = parsableBitArray.h(8);
        int h3 = parsableBitArray.h(4);
        int h4 = parsableBitArray.h(2);
        parsableBitArray.r(2);
        int i3 = i2 - 2;
        SparseArray sparseArray = new SparseArray();
        while (i3 > 0) {
            int h5 = parsableBitArray.h(8);
            parsableBitArray.r(8);
            i3 -= 6;
            sparseArray.put(h5, new PageRegion(parsableBitArray.h(16), parsableBitArray.h(16)));
        }
        return new PageComposition(h2, h3, h4, sparseArray);
    }

    private static RegionComposition s(ParsableBitArray parsableBitArray, int i2) {
        int i3;
        int i4;
        ParsableBitArray parsableBitArray2 = parsableBitArray;
        int h2 = parsableBitArray2.h(8);
        parsableBitArray2.r(4);
        boolean g2 = parsableBitArray.g();
        parsableBitArray2.r(3);
        int i5 = 16;
        int h3 = parsableBitArray2.h(16);
        int h4 = parsableBitArray2.h(16);
        int h5 = parsableBitArray2.h(3);
        int h6 = parsableBitArray2.h(3);
        int i6 = 2;
        parsableBitArray2.r(2);
        int h7 = parsableBitArray2.h(8);
        int h8 = parsableBitArray2.h(8);
        int h9 = parsableBitArray2.h(4);
        int h10 = parsableBitArray2.h(2);
        parsableBitArray2.r(2);
        int i7 = i2 - 10;
        SparseArray sparseArray = new SparseArray();
        while (i7 > 0) {
            int h11 = parsableBitArray2.h(i5);
            int h12 = parsableBitArray2.h(i6);
            int h13 = parsableBitArray2.h(i6);
            int h14 = parsableBitArray2.h(12);
            int i8 = h10;
            parsableBitArray2.r(4);
            int h15 = parsableBitArray2.h(12);
            i7 -= 6;
            if (h12 == 1 || h12 == 2) {
                i7 -= 2;
                i4 = parsableBitArray2.h(8);
                i3 = parsableBitArray2.h(8);
            } else {
                i4 = 0;
                i3 = 0;
            }
            sparseArray.put(h11, new RegionObject(h12, h13, h14, h15, i4, i3));
            h10 = i8;
            i6 = 2;
            i5 = 16;
        }
        return new RegionComposition(h2, g2, h3, h4, h5, h6, h7, h8, h9, h10, sparseArray);
    }

    private static void t(ParsableBitArray parsableBitArray, SubtitleService subtitleService) {
        RegionComposition regionComposition;
        int h2 = parsableBitArray.h(8);
        int h3 = parsableBitArray.h(16);
        int h4 = parsableBitArray.h(16);
        int d2 = parsableBitArray.d() + h4;
        if (h4 * 8 > parsableBitArray.b()) {
            Log.h("DvbParser", "Data field length exceeds limit");
            parsableBitArray.r(parsableBitArray.b());
            return;
        }
        switch (h2) {
            case 16:
                if (h3 == subtitleService.f8950a) {
                    PageComposition pageComposition = subtitleService.f8958i;
                    PageComposition r2 = r(parsableBitArray, h4);
                    if (r2.f8929c == 0) {
                        if (!(pageComposition == null || pageComposition.f8928b == r2.f8928b)) {
                            subtitleService.f8958i = r2;
                            break;
                        }
                    } else {
                        subtitleService.f8958i = r2;
                        subtitleService.f8952c.clear();
                        subtitleService.f8953d.clear();
                        subtitleService.f8954e.clear();
                        break;
                    }
                }
                break;
            case 17:
                PageComposition pageComposition2 = subtitleService.f8958i;
                if (h3 == subtitleService.f8950a && pageComposition2 != null) {
                    RegionComposition s2 = s(parsableBitArray, h4);
                    if (pageComposition2.f8929c == 0 && (regionComposition = subtitleService.f8952c.get(s2.f8933a)) != null) {
                        s2.a(regionComposition);
                    }
                    subtitleService.f8952c.put(s2.f8933a, s2);
                    break;
                }
            case 18:
                if (h3 != subtitleService.f8950a) {
                    if (h3 == subtitleService.f8951b) {
                        ClutDefinition o2 = o(parsableBitArray, h4);
                        subtitleService.f8955f.put(o2.f8913a, o2);
                        break;
                    }
                } else {
                    ClutDefinition o3 = o(parsableBitArray, h4);
                    subtitleService.f8953d.put(o3.f8913a, o3);
                    break;
                }
                break;
            case 19:
                if (h3 != subtitleService.f8950a) {
                    if (h3 == subtitleService.f8951b) {
                        ObjectData q2 = q(parsableBitArray);
                        subtitleService.f8956g.put(q2.f8923a, q2);
                        break;
                    }
                } else {
                    ObjectData q3 = q(parsableBitArray);
                    subtitleService.f8954e.put(q3.f8923a, q3);
                    break;
                }
                break;
            case 20:
                if (h3 == subtitleService.f8950a) {
                    subtitleService.f8957h = p(parsableBitArray);
                    break;
                }
                break;
        }
        parsableBitArray.s(d2 - parsableBitArray.d());
    }

    public void a(byte[] bArr, int i2, int i3, SubtitleParser.OutputOptions outputOptions, Consumer<CuesWithTiming> consumer) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr, i3 + i2);
        parsableBitArray.p(i2);
        consumer.accept(n(parsableBitArray));
    }

    public /* synthetic */ Subtitle b(byte[] bArr, int i2, int i3) {
        return f.a(this, bArr, i2, i3);
    }

    public int c() {
        return 2;
    }

    public void reset() {
        this.f8911f.a();
    }
}
