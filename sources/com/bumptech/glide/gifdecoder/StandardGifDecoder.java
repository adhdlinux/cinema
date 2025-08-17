package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

public class StandardGifDecoder implements GifDecoder {

    /* renamed from: u  reason: collision with root package name */
    private static final String f16251u = "StandardGifDecoder";

    /* renamed from: a  reason: collision with root package name */
    private int[] f16252a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f16253b;

    /* renamed from: c  reason: collision with root package name */
    private final GifDecoder.BitmapProvider f16254c;

    /* renamed from: d  reason: collision with root package name */
    private ByteBuffer f16255d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f16256e;

    /* renamed from: f  reason: collision with root package name */
    private short[] f16257f;

    /* renamed from: g  reason: collision with root package name */
    private byte[] f16258g;

    /* renamed from: h  reason: collision with root package name */
    private byte[] f16259h;

    /* renamed from: i  reason: collision with root package name */
    private byte[] f16260i;

    /* renamed from: j  reason: collision with root package name */
    private int[] f16261j;

    /* renamed from: k  reason: collision with root package name */
    private int f16262k;

    /* renamed from: l  reason: collision with root package name */
    private GifHeader f16263l;

    /* renamed from: m  reason: collision with root package name */
    private Bitmap f16264m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f16265n;

    /* renamed from: o  reason: collision with root package name */
    private int f16266o;

    /* renamed from: p  reason: collision with root package name */
    private int f16267p;

    /* renamed from: q  reason: collision with root package name */
    private int f16268q;

    /* renamed from: r  reason: collision with root package name */
    private int f16269r;

    /* renamed from: s  reason: collision with root package name */
    private Boolean f16270s;

    /* renamed from: t  reason: collision with root package name */
    private Bitmap.Config f16271t;

    public StandardGifDecoder(GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer, int i2) {
        this(bitmapProvider);
        q(gifHeader, byteBuffer, i2);
    }

    private int i(int i2, int i3, int i4) {
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = i2; i10 < this.f16267p + i2; i10++) {
            byte[] bArr = this.f16260i;
            if (i10 >= bArr.length || i10 >= i3) {
                break;
            }
            int i11 = this.f16252a[bArr[i10] & 255];
            if (i11 != 0) {
                i5 += (i11 >> 24) & JfifUtil.MARKER_FIRST_BYTE;
                i6 += (i11 >> 16) & JfifUtil.MARKER_FIRST_BYTE;
                i7 += (i11 >> 8) & JfifUtil.MARKER_FIRST_BYTE;
                i8 += i11 & JfifUtil.MARKER_FIRST_BYTE;
                i9++;
            }
        }
        int i12 = i2 + i4;
        for (int i13 = i12; i13 < this.f16267p + i12; i13++) {
            byte[] bArr2 = this.f16260i;
            if (i13 >= bArr2.length || i13 >= i3) {
                break;
            }
            int i14 = this.f16252a[bArr2[i13] & 255];
            if (i14 != 0) {
                i5 += (i14 >> 24) & JfifUtil.MARKER_FIRST_BYTE;
                i6 += (i14 >> 16) & JfifUtil.MARKER_FIRST_BYTE;
                i7 += (i14 >> 8) & JfifUtil.MARKER_FIRST_BYTE;
                i8 += i14 & JfifUtil.MARKER_FIRST_BYTE;
                i9++;
            }
        }
        if (i9 == 0) {
            return 0;
        }
        return ((i5 / i9) << 24) | ((i6 / i9) << 16) | ((i7 / i9) << 8) | (i8 / i9);
    }

    private void j(GifFrame gifFrame) {
        boolean z2;
        boolean z3;
        int i2;
        int i3;
        boolean z4;
        int i4;
        int i5;
        int i6;
        GifFrame gifFrame2 = gifFrame;
        int[] iArr = this.f16261j;
        int i7 = gifFrame2.f16226d;
        int i8 = this.f16267p;
        int i9 = i7 / i8;
        int i10 = gifFrame2.f16224b / i8;
        int i11 = gifFrame2.f16225c / i8;
        int i12 = gifFrame2.f16223a / i8;
        if (this.f16262k == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        int i13 = this.f16269r;
        int i14 = this.f16268q;
        byte[] bArr = this.f16260i;
        int[] iArr2 = this.f16252a;
        Boolean bool = this.f16270s;
        int i15 = 8;
        int i16 = 0;
        int i17 = 0;
        int i18 = 1;
        while (i17 < i9) {
            Boolean bool2 = bool;
            if (gifFrame2.f16227e) {
                if (i16 >= i9) {
                    int i19 = i18 + 1;
                    i2 = i9;
                    if (i19 == 2) {
                        i18 = i19;
                        i16 = 4;
                    } else if (i19 == 3) {
                        i18 = i19;
                        i16 = 2;
                        i15 = 4;
                    } else if (i19 != 4) {
                        i18 = i19;
                    } else {
                        i18 = i19;
                        i16 = 1;
                        i15 = 2;
                    }
                } else {
                    i2 = i9;
                }
                i3 = i16 + i15;
            } else {
                i2 = i9;
                i3 = i16;
                i16 = i17;
            }
            int i20 = i16 + i10;
            if (i8 == 1) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (i20 < i14) {
                int i21 = i20 * i13;
                int i22 = i21 + i12;
                int i23 = i22 + i11;
                int i24 = i21 + i13;
                if (i24 < i23) {
                    i23 = i24;
                }
                i4 = i3;
                int i25 = i17 * i8 * gifFrame2.f16225c;
                if (z4) {
                    int i26 = i22;
                    while (i26 < i23) {
                        int i27 = i10;
                        int i28 = iArr2[bArr[i25] & 255];
                        if (i28 != 0) {
                            iArr[i26] = i28;
                        } else if (z2 && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i25 += i8;
                        i26++;
                        i10 = i27;
                    }
                } else {
                    i6 = i10;
                    int i29 = ((i23 - i22) * i8) + i25;
                    int i30 = i22;
                    while (true) {
                        i5 = i11;
                        if (i30 >= i23) {
                            break;
                        }
                        int i31 = i(i25, i29, gifFrame2.f16225c);
                        if (i31 != 0) {
                            iArr[i30] = i31;
                        } else if (z2 && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i25 += i8;
                        i30++;
                        i11 = i5;
                    }
                    bool = bool2;
                    i17++;
                    i10 = i6;
                    i9 = i2;
                    i11 = i5;
                    i16 = i4;
                }
            } else {
                i4 = i3;
            }
            i6 = i10;
            i5 = i11;
            bool = bool2;
            i17++;
            i10 = i6;
            i9 = i2;
            i11 = i5;
            i16 = i4;
        }
        Boolean bool3 = bool;
        if (this.f16270s == null) {
            if (bool3 == null) {
                z3 = false;
            } else {
                z3 = bool3.booleanValue();
            }
            this.f16270s = Boolean.valueOf(z3);
        }
    }

    private void k(GifFrame gifFrame) {
        boolean z2;
        boolean z3;
        GifFrame gifFrame2 = gifFrame;
        int[] iArr = this.f16261j;
        int i2 = gifFrame2.f16226d;
        int i3 = gifFrame2.f16224b;
        int i4 = gifFrame2.f16225c;
        int i5 = gifFrame2.f16223a;
        if (this.f16262k == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        int i6 = this.f16269r;
        byte[] bArr = this.f16260i;
        int[] iArr2 = this.f16252a;
        int i7 = 0;
        byte b2 = -1;
        while (i7 < i2) {
            int i8 = (i7 + i3) * i6;
            int i9 = i8 + i5;
            int i10 = i9 + i4;
            int i11 = i8 + i6;
            if (i11 < i10) {
                i10 = i11;
            }
            int i12 = gifFrame2.f16225c * i7;
            int i13 = i9;
            while (i13 < i10) {
                byte b3 = bArr[i12];
                int i14 = i2;
                byte b4 = b3 & 255;
                if (b4 != b2) {
                    int i15 = iArr2[b4];
                    if (i15 != 0) {
                        iArr[i13] = i15;
                    } else {
                        b2 = b3;
                    }
                }
                i12++;
                i13++;
                GifFrame gifFrame3 = gifFrame;
                i2 = i14;
            }
            int i16 = i2;
            i7++;
            gifFrame2 = gifFrame;
        }
        Boolean bool = this.f16270s;
        if ((bool == null || !bool.booleanValue()) && (this.f16270s != null || !z2 || b2 == -1)) {
            z3 = false;
        } else {
            z3 = true;
        }
        this.f16270s = Boolean.valueOf(z3);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: byte} */
    /* JADX WARNING: Incorrect type for immutable var: ssa=short, code=int, for r7v13, types: [short] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void l(com.bumptech.glide.gifdecoder.GifFrame r29) {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            if (r1 == 0) goto L_0x000d
            java.nio.ByteBuffer r2 = r0.f16255d
            int r3 = r1.f16232j
            r2.position(r3)
        L_0x000d:
            if (r1 != 0) goto L_0x0016
            com.bumptech.glide.gifdecoder.GifHeader r1 = r0.f16263l
            int r2 = r1.f16239f
            int r1 = r1.f16240g
            goto L_0x001a
        L_0x0016:
            int r2 = r1.f16225c
            int r1 = r1.f16226d
        L_0x001a:
            int r2 = r2 * r1
            byte[] r1 = r0.f16260i
            if (r1 == 0) goto L_0x0023
            int r1 = r1.length
            if (r1 >= r2) goto L_0x002b
        L_0x0023:
            com.bumptech.glide.gifdecoder.GifDecoder$BitmapProvider r1 = r0.f16254c
            byte[] r1 = r1.b(r2)
            r0.f16260i = r1
        L_0x002b:
            byte[] r1 = r0.f16260i
            short[] r3 = r0.f16257f
            r4 = 4096(0x1000, float:5.74E-42)
            if (r3 != 0) goto L_0x0037
            short[] r3 = new short[r4]
            r0.f16257f = r3
        L_0x0037:
            short[] r3 = r0.f16257f
            byte[] r5 = r0.f16258g
            if (r5 != 0) goto L_0x0041
            byte[] r5 = new byte[r4]
            r0.f16258g = r5
        L_0x0041:
            byte[] r5 = r0.f16258g
            byte[] r6 = r0.f16259h
            if (r6 != 0) goto L_0x004d
            r6 = 4097(0x1001, float:5.741E-42)
            byte[] r6 = new byte[r6]
            r0.f16259h = r6
        L_0x004d:
            byte[] r6 = r0.f16259h
            int r7 = r28.p()
            r8 = 1
            int r9 = r8 << r7
            int r10 = r9 + 1
            int r11 = r9 + 2
            int r7 = r7 + r8
            int r12 = r8 << r7
            int r12 = r12 - r8
            r13 = 0
            r14 = 0
        L_0x0060:
            if (r14 >= r9) goto L_0x006a
            r3[r14] = r13
            byte r15 = (byte) r14
            r5[r14] = r15
            int r14 = r14 + 1
            goto L_0x0060
        L_0x006a:
            byte[] r14 = r0.f16256e
            r15 = -1
            r23 = r7
            r21 = r11
            r22 = r12
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r24 = -1
            r25 = 0
            r26 = 0
        L_0x0083:
            if (r13 >= r2) goto L_0x014c
            if (r16 != 0) goto L_0x0094
            int r16 = r28.o()
            if (r16 > 0) goto L_0x0092
            r3 = 3
            r0.f16266o = r3
            goto L_0x014c
        L_0x0092:
            r17 = 0
        L_0x0094:
            byte r4 = r14[r17]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << r18
            int r19 = r19 + r4
            int r18 = r18 + 8
            int r17 = r17 + 1
            int r16 = r16 + -1
            r4 = r18
            r8 = r21
            r15 = r23
            r0 = r24
            r23 = r7
            r7 = r25
        L_0x00ae:
            if (r4 < r15) goto L_0x0136
            r24 = r11
            r11 = r19 & r22
            int r19 = r19 >> r15
            int r4 = r4 - r15
            if (r11 != r9) goto L_0x00c2
            r22 = r12
            r15 = r23
            r8 = r24
            r11 = r8
            r0 = -1
            goto L_0x00ae
        L_0x00c2:
            if (r11 != r10) goto L_0x00d9
            r18 = r4
            r25 = r7
            r21 = r8
            r7 = r23
            r11 = r24
            r4 = 4096(0x1000, float:5.74E-42)
            r8 = 1
            r24 = r0
            r23 = r15
            r15 = -1
            r0 = r28
            goto L_0x0083
        L_0x00d9:
            r25 = r4
            r4 = -1
            if (r0 != r4) goto L_0x00ed
            byte r0 = r5[r11]
            r1[r20] = r0
            int r20 = r20 + 1
            int r13 = r13 + 1
            r0 = r11
            r7 = r0
            r11 = r24
            r4 = r25
            goto L_0x00ae
        L_0x00ed:
            if (r11 < r8) goto L_0x00f6
            byte r7 = (byte) r7
            r6[r26] = r7
            int r26 = r26 + 1
            r7 = r0
            goto L_0x00f7
        L_0x00f6:
            r7 = r11
        L_0x00f7:
            if (r7 < r9) goto L_0x0102
            byte r21 = r5[r7]
            r6[r26] = r21
            int r26 = r26 + 1
            short r7 = r3[r7]
            goto L_0x00f7
        L_0x0102:
            byte r7 = r5[r7]
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r7
            r1[r20] = r4
        L_0x0109:
            int r20 = r20 + 1
            int r13 = r13 + 1
            if (r26 <= 0) goto L_0x0116
            int r26 = r26 + -1
            byte r27 = r6[r26]
            r1[r20] = r27
            goto L_0x0109
        L_0x0116:
            r27 = r6
            r6 = 4096(0x1000, float:5.74E-42)
            if (r8 >= r6) goto L_0x012d
            short r0 = (short) r0
            r3[r8] = r0
            r5[r8] = r4
            int r8 = r8 + 1
            r0 = r8 & r22
            if (r0 != 0) goto L_0x012d
            if (r8 >= r6) goto L_0x012d
            int r15 = r15 + 1
            int r22 = r22 + r8
        L_0x012d:
            r0 = r11
            r11 = r24
            r4 = r25
            r6 = r27
            goto L_0x00ae
        L_0x0136:
            r25 = r4
            r24 = r0
            r21 = r8
            r18 = r25
            r4 = 4096(0x1000, float:5.74E-42)
            r8 = 1
            r0 = r28
            r25 = r7
            r7 = r23
            r23 = r15
            r15 = -1
            goto L_0x0083
        L_0x014c:
            r13 = r20
            r0 = 0
            java.util.Arrays.fill(r1, r13, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.StandardGifDecoder.l(com.bumptech.glide.gifdecoder.GifFrame):void");
    }

    private Bitmap n() {
        Bitmap.Config config;
        Boolean bool = this.f16270s;
        if (bool == null || bool.booleanValue()) {
            config = Bitmap.Config.ARGB_8888;
        } else {
            config = this.f16271t;
        }
        Bitmap c2 = this.f16254c.c(this.f16269r, this.f16268q, config);
        c2.setHasAlpha(true);
        return c2;
    }

    private int o() {
        int p2 = p();
        if (p2 <= 0) {
            return p2;
        }
        ByteBuffer byteBuffer = this.f16255d;
        byteBuffer.get(this.f16256e, 0, Math.min(p2, byteBuffer.remaining()));
        return p2;
    }

    private int p() {
        return this.f16255d.get() & 255;
    }

    private Bitmap r(GifFrame gifFrame, GifFrame gifFrame2) {
        int i2;
        int i3;
        Bitmap bitmap;
        int[] iArr = this.f16261j;
        int i4 = 0;
        if (gifFrame2 == null) {
            Bitmap bitmap2 = this.f16264m;
            if (bitmap2 != null) {
                this.f16254c.a(bitmap2);
            }
            this.f16264m = null;
            Arrays.fill(iArr, 0);
        }
        if (gifFrame2 != null && gifFrame2.f16229g == 3 && this.f16264m == null) {
            Arrays.fill(iArr, 0);
        }
        if (gifFrame2 != null && (i3 = gifFrame2.f16229g) > 0) {
            if (i3 == 2) {
                if (!gifFrame.f16228f) {
                    GifHeader gifHeader = this.f16263l;
                    int i5 = gifHeader.f16245l;
                    if (gifFrame.f16233k == null || gifHeader.f16243j != gifFrame.f16230h) {
                        i4 = i5;
                    }
                }
                int i6 = gifFrame2.f16226d;
                int i7 = this.f16267p;
                int i8 = i6 / i7;
                int i9 = gifFrame2.f16224b / i7;
                int i10 = gifFrame2.f16225c / i7;
                int i11 = gifFrame2.f16223a / i7;
                int i12 = this.f16269r;
                int i13 = (i9 * i12) + i11;
                int i14 = (i8 * i12) + i13;
                while (i13 < i14) {
                    int i15 = i13 + i10;
                    for (int i16 = i13; i16 < i15; i16++) {
                        iArr[i16] = i4;
                    }
                    i13 += this.f16269r;
                }
            } else if (i3 == 3 && (bitmap = this.f16264m) != null) {
                int i17 = this.f16269r;
                bitmap.getPixels(iArr, 0, i17, 0, 0, i17, this.f16268q);
            }
        }
        l(gifFrame);
        if (gifFrame.f16227e || this.f16267p != 1) {
            j(gifFrame);
        } else {
            k(gifFrame);
        }
        if (this.f16265n && ((i2 = gifFrame.f16229g) == 0 || i2 == 1)) {
            if (this.f16264m == null) {
                this.f16264m = n();
            }
            Bitmap bitmap3 = this.f16264m;
            int i18 = this.f16269r;
            bitmap3.setPixels(iArr, 0, i18, 0, 0, i18, this.f16268q);
        }
        Bitmap n2 = n();
        int i19 = this.f16269r;
        n2.setPixels(iArr, 0, i19, 0, 0, i19, this.f16268q);
        return n2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e3, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.graphics.Bitmap a() {
        /*
            r8 = this;
            monitor-enter(r8)
            com.bumptech.glide.gifdecoder.GifHeader r0 = r8.f16263l     // Catch:{ all -> 0x00e4 }
            int r0 = r0.f16236c     // Catch:{ all -> 0x00e4 }
            r1 = 3
            r2 = 1
            if (r0 <= 0) goto L_0x000d
            int r0 = r8.f16262k     // Catch:{ all -> 0x00e4 }
            if (r0 >= 0) goto L_0x0039
        L_0x000d:
            java.lang.String r0 = f16251u     // Catch:{ all -> 0x00e4 }
            boolean r3 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00e4 }
            if (r3 == 0) goto L_0x0037
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e4 }
            r3.<init>()     // Catch:{ all -> 0x00e4 }
            java.lang.String r4 = "Unable to decode frame, frameCount="
            r3.append(r4)     // Catch:{ all -> 0x00e4 }
            com.bumptech.glide.gifdecoder.GifHeader r4 = r8.f16263l     // Catch:{ all -> 0x00e4 }
            int r4 = r4.f16236c     // Catch:{ all -> 0x00e4 }
            r3.append(r4)     // Catch:{ all -> 0x00e4 }
            java.lang.String r4 = ", framePointer="
            r3.append(r4)     // Catch:{ all -> 0x00e4 }
            int r4 = r8.f16262k     // Catch:{ all -> 0x00e4 }
            r3.append(r4)     // Catch:{ all -> 0x00e4 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00e4 }
            android.util.Log.d(r0, r3)     // Catch:{ all -> 0x00e4 }
        L_0x0037:
            r8.f16266o = r2     // Catch:{ all -> 0x00e4 }
        L_0x0039:
            int r0 = r8.f16266o     // Catch:{ all -> 0x00e4 }
            r3 = 0
            if (r0 == r2) goto L_0x00c4
            r4 = 2
            if (r0 != r4) goto L_0x0043
            goto L_0x00c4
        L_0x0043:
            r0 = 0
            r8.f16266o = r0     // Catch:{ all -> 0x00e4 }
            byte[] r5 = r8.f16256e     // Catch:{ all -> 0x00e4 }
            if (r5 != 0) goto L_0x0054
            com.bumptech.glide.gifdecoder.GifDecoder$BitmapProvider r5 = r8.f16254c     // Catch:{ all -> 0x00e4 }
            r6 = 255(0xff, float:3.57E-43)
            byte[] r5 = r5.b(r6)     // Catch:{ all -> 0x00e4 }
            r8.f16256e = r5     // Catch:{ all -> 0x00e4 }
        L_0x0054:
            com.bumptech.glide.gifdecoder.GifHeader r5 = r8.f16263l     // Catch:{ all -> 0x00e4 }
            java.util.List<com.bumptech.glide.gifdecoder.GifFrame> r5 = r5.f16238e     // Catch:{ all -> 0x00e4 }
            int r6 = r8.f16262k     // Catch:{ all -> 0x00e4 }
            java.lang.Object r5 = r5.get(r6)     // Catch:{ all -> 0x00e4 }
            com.bumptech.glide.gifdecoder.GifFrame r5 = (com.bumptech.glide.gifdecoder.GifFrame) r5     // Catch:{ all -> 0x00e4 }
            int r6 = r8.f16262k     // Catch:{ all -> 0x00e4 }
            int r6 = r6 - r2
            if (r6 < 0) goto L_0x0070
            com.bumptech.glide.gifdecoder.GifHeader r7 = r8.f16263l     // Catch:{ all -> 0x00e4 }
            java.util.List<com.bumptech.glide.gifdecoder.GifFrame> r7 = r7.f16238e     // Catch:{ all -> 0x00e4 }
            java.lang.Object r6 = r7.get(r6)     // Catch:{ all -> 0x00e4 }
            com.bumptech.glide.gifdecoder.GifFrame r6 = (com.bumptech.glide.gifdecoder.GifFrame) r6     // Catch:{ all -> 0x00e4 }
            goto L_0x0071
        L_0x0070:
            r6 = r3
        L_0x0071:
            int[] r7 = r5.f16233k     // Catch:{ all -> 0x00e4 }
            if (r7 == 0) goto L_0x0076
            goto L_0x007a
        L_0x0076:
            com.bumptech.glide.gifdecoder.GifHeader r7 = r8.f16263l     // Catch:{ all -> 0x00e4 }
            int[] r7 = r7.f16234a     // Catch:{ all -> 0x00e4 }
        L_0x007a:
            r8.f16252a = r7     // Catch:{ all -> 0x00e4 }
            if (r7 != 0) goto L_0x00a0
            java.lang.String r0 = f16251u     // Catch:{ all -> 0x00e4 }
            boolean r1 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00e4 }
            if (r1 == 0) goto L_0x009c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e4 }
            r1.<init>()     // Catch:{ all -> 0x00e4 }
            java.lang.String r4 = "No valid color table found for frame #"
            r1.append(r4)     // Catch:{ all -> 0x00e4 }
            int r4 = r8.f16262k     // Catch:{ all -> 0x00e4 }
            r1.append(r4)     // Catch:{ all -> 0x00e4 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00e4 }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x00e4 }
        L_0x009c:
            r8.f16266o = r2     // Catch:{ all -> 0x00e4 }
            monitor-exit(r8)
            return r3
        L_0x00a0:
            boolean r1 = r5.f16228f     // Catch:{ all -> 0x00e4 }
            if (r1 == 0) goto L_0x00be
            int[] r1 = r8.f16253b     // Catch:{ all -> 0x00e4 }
            int r2 = r7.length     // Catch:{ all -> 0x00e4 }
            java.lang.System.arraycopy(r7, r0, r1, r0, r2)     // Catch:{ all -> 0x00e4 }
            int[] r1 = r8.f16253b     // Catch:{ all -> 0x00e4 }
            r8.f16252a = r1     // Catch:{ all -> 0x00e4 }
            int r2 = r5.f16230h     // Catch:{ all -> 0x00e4 }
            r1[r2] = r0     // Catch:{ all -> 0x00e4 }
            int r0 = r5.f16229g     // Catch:{ all -> 0x00e4 }
            if (r0 != r4) goto L_0x00be
            int r0 = r8.f16262k     // Catch:{ all -> 0x00e4 }
            if (r0 != 0) goto L_0x00be
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00e4 }
            r8.f16270s = r0     // Catch:{ all -> 0x00e4 }
        L_0x00be:
            android.graphics.Bitmap r0 = r8.r(r5, r6)     // Catch:{ all -> 0x00e4 }
            monitor-exit(r8)
            return r0
        L_0x00c4:
            java.lang.String r0 = f16251u     // Catch:{ all -> 0x00e4 }
            boolean r1 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00e4 }
            if (r1 == 0) goto L_0x00e2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e4 }
            r1.<init>()     // Catch:{ all -> 0x00e4 }
            java.lang.String r2 = "Unable to decode frame, status="
            r1.append(r2)     // Catch:{ all -> 0x00e4 }
            int r2 = r8.f16266o     // Catch:{ all -> 0x00e4 }
            r1.append(r2)     // Catch:{ all -> 0x00e4 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00e4 }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x00e4 }
        L_0x00e2:
            monitor-exit(r8)
            return r3
        L_0x00e4:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.StandardGifDecoder.a():android.graphics.Bitmap");
    }

    public void b() {
        this.f16262k = (this.f16262k + 1) % this.f16263l.f16236c;
    }

    public int c() {
        return this.f16263l.f16236c;
    }

    public void clear() {
        this.f16263l = null;
        byte[] bArr = this.f16260i;
        if (bArr != null) {
            this.f16254c.e(bArr);
        }
        int[] iArr = this.f16261j;
        if (iArr != null) {
            this.f16254c.f(iArr);
        }
        Bitmap bitmap = this.f16264m;
        if (bitmap != null) {
            this.f16254c.a(bitmap);
        }
        this.f16264m = null;
        this.f16255d = null;
        this.f16270s = null;
        byte[] bArr2 = this.f16256e;
        if (bArr2 != null) {
            this.f16254c.e(bArr2);
        }
    }

    public void d(Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.RGB_565) {
            this.f16271t = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
    }

    public int e() {
        int i2;
        if (this.f16263l.f16236c <= 0 || (i2 = this.f16262k) < 0) {
            return 0;
        }
        return m(i2);
    }

    public void f() {
        this.f16262k = -1;
    }

    public int g() {
        return this.f16262k;
    }

    public ByteBuffer getData() {
        return this.f16255d;
    }

    public int h() {
        return this.f16255d.limit() + this.f16260i.length + (this.f16261j.length * 4);
    }

    public int m(int i2) {
        if (i2 >= 0) {
            GifHeader gifHeader = this.f16263l;
            if (i2 < gifHeader.f16236c) {
                return gifHeader.f16238e.get(i2).f16231i;
            }
        }
        return -1;
    }

    public synchronized void q(GifHeader gifHeader, ByteBuffer byteBuffer, int i2) {
        if (i2 > 0) {
            int highestOneBit = Integer.highestOneBit(i2);
            this.f16266o = 0;
            this.f16263l = gifHeader;
            this.f16262k = -1;
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.f16255d = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.f16255d.order(ByteOrder.LITTLE_ENDIAN);
            this.f16265n = false;
            Iterator<GifFrame> it2 = gifHeader.f16238e.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (it2.next().f16229g == 3) {
                        this.f16265n = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            this.f16267p = highestOneBit;
            int i3 = gifHeader.f16239f;
            this.f16269r = i3 / highestOneBit;
            int i4 = gifHeader.f16240g;
            this.f16268q = i4 / highestOneBit;
            this.f16260i = this.f16254c.b(i3 * i4);
            this.f16261j = this.f16254c.d(this.f16269r * this.f16268q);
        } else {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i2);
        }
    }

    public StandardGifDecoder(GifDecoder.BitmapProvider bitmapProvider) {
        this.f16253b = new int[UserVerificationMethods.USER_VERIFY_HANDPRINT];
        this.f16271t = Bitmap.Config.ARGB_8888;
        this.f16254c = bitmapProvider;
        this.f16263l = new GifHeader();
    }
}
