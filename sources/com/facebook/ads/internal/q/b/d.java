package com.facebook.ads.internal.q.b;

import android.graphics.Bitmap;
import com.facebook.imageutils.JfifUtil;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

class d implements a {

    /* renamed from: a  reason: collision with root package name */
    private static final short[] f20713a;

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f20714b;

    private static class a implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        private final int[] f20715a;

        /* renamed from: b  reason: collision with root package name */
        private final int f20716b;

        /* renamed from: c  reason: collision with root package name */
        private final int f20717c;

        /* renamed from: d  reason: collision with root package name */
        private final int f20718d;

        /* renamed from: e  reason: collision with root package name */
        private final int f20719e;

        /* renamed from: f  reason: collision with root package name */
        private final int f20720f;

        /* renamed from: g  reason: collision with root package name */
        private final int f20721g;

        public a(int[] iArr, int i2, int i3, int i4, int i5, int i6, int i7) {
            this.f20715a = iArr;
            this.f20716b = i2;
            this.f20717c = i3;
            this.f20718d = i4;
            this.f20719e = i5;
            this.f20720f = i6;
            this.f20721g = i7;
        }

        /* renamed from: a */
        public Void call() {
            d.b(this.f20715a, this.f20716b, this.f20717c, this.f20718d, this.f20719e, this.f20720f, this.f20721g);
            return null;
        }
    }

    static {
        short[] sArr = new short[JfifUtil.MARKER_FIRST_BYTE];
        // fill-array-data instruction
        sArr[0] = 512;
        sArr[1] = 512;
        sArr[2] = 456;
        sArr[3] = 512;
        sArr[4] = 328;
        sArr[5] = 456;
        sArr[6] = 335;
        sArr[7] = 512;
        sArr[8] = 405;
        sArr[9] = 328;
        sArr[10] = 271;
        sArr[11] = 456;
        sArr[12] = 388;
        sArr[13] = 335;
        sArr[14] = 292;
        sArr[15] = 512;
        sArr[16] = 454;
        sArr[17] = 405;
        sArr[18] = 364;
        sArr[19] = 328;
        sArr[20] = 298;
        sArr[21] = 271;
        sArr[22] = 496;
        sArr[23] = 456;
        sArr[24] = 420;
        sArr[25] = 388;
        sArr[26] = 360;
        sArr[27] = 335;
        sArr[28] = 312;
        sArr[29] = 292;
        sArr[30] = 273;
        sArr[31] = 512;
        sArr[32] = 482;
        sArr[33] = 454;
        sArr[34] = 428;
        sArr[35] = 405;
        sArr[36] = 383;
        sArr[37] = 364;
        sArr[38] = 345;
        sArr[39] = 328;
        sArr[40] = 312;
        sArr[41] = 298;
        sArr[42] = 284;
        sArr[43] = 271;
        sArr[44] = 259;
        sArr[45] = 496;
        sArr[46] = 475;
        sArr[47] = 456;
        sArr[48] = 437;
        sArr[49] = 420;
        sArr[50] = 404;
        sArr[51] = 388;
        sArr[52] = 374;
        sArr[53] = 360;
        sArr[54] = 347;
        sArr[55] = 335;
        sArr[56] = 323;
        sArr[57] = 312;
        sArr[58] = 302;
        sArr[59] = 292;
        sArr[60] = 282;
        sArr[61] = 273;
        sArr[62] = 265;
        sArr[63] = 512;
        sArr[64] = 497;
        sArr[65] = 482;
        sArr[66] = 468;
        sArr[67] = 454;
        sArr[68] = 441;
        sArr[69] = 428;
        sArr[70] = 417;
        sArr[71] = 405;
        sArr[72] = 394;
        sArr[73] = 383;
        sArr[74] = 373;
        sArr[75] = 364;
        sArr[76] = 354;
        sArr[77] = 345;
        sArr[78] = 337;
        sArr[79] = 328;
        sArr[80] = 320;
        sArr[81] = 312;
        sArr[82] = 305;
        sArr[83] = 298;
        sArr[84] = 291;
        sArr[85] = 284;
        sArr[86] = 278;
        sArr[87] = 271;
        sArr[88] = 265;
        sArr[89] = 259;
        sArr[90] = 507;
        sArr[91] = 496;
        sArr[92] = 485;
        sArr[93] = 475;
        sArr[94] = 465;
        sArr[95] = 456;
        sArr[96] = 446;
        sArr[97] = 437;
        sArr[98] = 428;
        sArr[99] = 420;
        sArr[100] = 412;
        sArr[101] = 404;
        sArr[102] = 396;
        sArr[103] = 388;
        sArr[104] = 381;
        sArr[105] = 374;
        sArr[106] = 367;
        sArr[107] = 360;
        sArr[108] = 354;
        sArr[109] = 347;
        sArr[110] = 341;
        sArr[111] = 335;
        sArr[112] = 329;
        sArr[113] = 323;
        sArr[114] = 318;
        sArr[115] = 312;
        sArr[116] = 307;
        sArr[117] = 302;
        sArr[118] = 297;
        sArr[119] = 292;
        sArr[120] = 287;
        sArr[121] = 282;
        sArr[122] = 278;
        sArr[123] = 273;
        sArr[124] = 269;
        sArr[125] = 265;
        sArr[126] = 261;
        sArr[127] = 512;
        sArr[128] = 505;
        sArr[129] = 497;
        sArr[130] = 489;
        sArr[131] = 482;
        sArr[132] = 475;
        sArr[133] = 468;
        sArr[134] = 461;
        sArr[135] = 454;
        sArr[136] = 447;
        sArr[137] = 441;
        sArr[138] = 435;
        sArr[139] = 428;
        sArr[140] = 422;
        sArr[141] = 417;
        sArr[142] = 411;
        sArr[143] = 405;
        sArr[144] = 399;
        sArr[145] = 394;
        sArr[146] = 389;
        sArr[147] = 383;
        sArr[148] = 378;
        sArr[149] = 373;
        sArr[150] = 368;
        sArr[151] = 364;
        sArr[152] = 359;
        sArr[153] = 354;
        sArr[154] = 350;
        sArr[155] = 345;
        sArr[156] = 341;
        sArr[157] = 337;
        sArr[158] = 332;
        sArr[159] = 328;
        sArr[160] = 324;
        sArr[161] = 320;
        sArr[162] = 316;
        sArr[163] = 312;
        sArr[164] = 309;
        sArr[165] = 305;
        sArr[166] = 301;
        sArr[167] = 298;
        sArr[168] = 294;
        sArr[169] = 291;
        sArr[170] = 287;
        sArr[171] = 284;
        sArr[172] = 281;
        sArr[173] = 278;
        sArr[174] = 274;
        sArr[175] = 271;
        sArr[176] = 268;
        sArr[177] = 265;
        sArr[178] = 262;
        sArr[179] = 259;
        sArr[180] = 257;
        sArr[181] = 507;
        sArr[182] = 501;
        sArr[183] = 496;
        sArr[184] = 491;
        sArr[185] = 485;
        sArr[186] = 480;
        sArr[187] = 475;
        sArr[188] = 470;
        sArr[189] = 465;
        sArr[190] = 460;
        sArr[191] = 456;
        sArr[192] = 451;
        sArr[193] = 446;
        sArr[194] = 442;
        sArr[195] = 437;
        sArr[196] = 433;
        sArr[197] = 428;
        sArr[198] = 424;
        sArr[199] = 420;
        sArr[200] = 416;
        sArr[201] = 412;
        sArr[202] = 408;
        sArr[203] = 404;
        sArr[204] = 400;
        sArr[205] = 396;
        sArr[206] = 392;
        sArr[207] = 388;
        sArr[208] = 385;
        sArr[209] = 381;
        sArr[210] = 377;
        sArr[211] = 374;
        sArr[212] = 370;
        sArr[213] = 367;
        sArr[214] = 363;
        sArr[215] = 360;
        sArr[216] = 357;
        sArr[217] = 354;
        sArr[218] = 350;
        sArr[219] = 347;
        sArr[220] = 344;
        sArr[221] = 341;
        sArr[222] = 338;
        sArr[223] = 335;
        sArr[224] = 332;
        sArr[225] = 329;
        sArr[226] = 326;
        sArr[227] = 323;
        sArr[228] = 320;
        sArr[229] = 318;
        sArr[230] = 315;
        sArr[231] = 312;
        sArr[232] = 310;
        sArr[233] = 307;
        sArr[234] = 304;
        sArr[235] = 302;
        sArr[236] = 299;
        sArr[237] = 297;
        sArr[238] = 294;
        sArr[239] = 292;
        sArr[240] = 289;
        sArr[241] = 287;
        sArr[242] = 285;
        sArr[243] = 282;
        sArr[244] = 280;
        sArr[245] = 278;
        sArr[246] = 275;
        sArr[247] = 273;
        sArr[248] = 271;
        sArr[249] = 269;
        sArr[250] = 267;
        sArr[251] = 265;
        sArr[252] = 263;
        sArr[253] = 261;
        sArr[254] = 259;
        f20713a = sArr;
        byte[] bArr = new byte[JfifUtil.MARKER_FIRST_BYTE];
        // fill-array-data instruction
        bArr[0] = 9;
        bArr[1] = 11;
        bArr[2] = 12;
        bArr[3] = 13;
        bArr[4] = 13;
        bArr[5] = 14;
        bArr[6] = 14;
        bArr[7] = 15;
        bArr[8] = 15;
        bArr[9] = 15;
        bArr[10] = 15;
        bArr[11] = 16;
        bArr[12] = 16;
        bArr[13] = 16;
        bArr[14] = 16;
        bArr[15] = 17;
        bArr[16] = 17;
        bArr[17] = 17;
        bArr[18] = 17;
        bArr[19] = 17;
        bArr[20] = 17;
        bArr[21] = 17;
        bArr[22] = 18;
        bArr[23] = 18;
        bArr[24] = 18;
        bArr[25] = 18;
        bArr[26] = 18;
        bArr[27] = 18;
        bArr[28] = 18;
        bArr[29] = 18;
        bArr[30] = 18;
        bArr[31] = 19;
        bArr[32] = 19;
        bArr[33] = 19;
        bArr[34] = 19;
        bArr[35] = 19;
        bArr[36] = 19;
        bArr[37] = 19;
        bArr[38] = 19;
        bArr[39] = 19;
        bArr[40] = 19;
        bArr[41] = 19;
        bArr[42] = 19;
        bArr[43] = 19;
        bArr[44] = 19;
        bArr[45] = 20;
        bArr[46] = 20;
        bArr[47] = 20;
        bArr[48] = 20;
        bArr[49] = 20;
        bArr[50] = 20;
        bArr[51] = 20;
        bArr[52] = 20;
        bArr[53] = 20;
        bArr[54] = 20;
        bArr[55] = 20;
        bArr[56] = 20;
        bArr[57] = 20;
        bArr[58] = 20;
        bArr[59] = 20;
        bArr[60] = 20;
        bArr[61] = 20;
        bArr[62] = 20;
        bArr[63] = 21;
        bArr[64] = 21;
        bArr[65] = 21;
        bArr[66] = 21;
        bArr[67] = 21;
        bArr[68] = 21;
        bArr[69] = 21;
        bArr[70] = 21;
        bArr[71] = 21;
        bArr[72] = 21;
        bArr[73] = 21;
        bArr[74] = 21;
        bArr[75] = 21;
        bArr[76] = 21;
        bArr[77] = 21;
        bArr[78] = 21;
        bArr[79] = 21;
        bArr[80] = 21;
        bArr[81] = 21;
        bArr[82] = 21;
        bArr[83] = 21;
        bArr[84] = 21;
        bArr[85] = 21;
        bArr[86] = 21;
        bArr[87] = 21;
        bArr[88] = 21;
        bArr[89] = 21;
        bArr[90] = 22;
        bArr[91] = 22;
        bArr[92] = 22;
        bArr[93] = 22;
        bArr[94] = 22;
        bArr[95] = 22;
        bArr[96] = 22;
        bArr[97] = 22;
        bArr[98] = 22;
        bArr[99] = 22;
        bArr[100] = 22;
        bArr[101] = 22;
        bArr[102] = 22;
        bArr[103] = 22;
        bArr[104] = 22;
        bArr[105] = 22;
        bArr[106] = 22;
        bArr[107] = 22;
        bArr[108] = 22;
        bArr[109] = 22;
        bArr[110] = 22;
        bArr[111] = 22;
        bArr[112] = 22;
        bArr[113] = 22;
        bArr[114] = 22;
        bArr[115] = 22;
        bArr[116] = 22;
        bArr[117] = 22;
        bArr[118] = 22;
        bArr[119] = 22;
        bArr[120] = 22;
        bArr[121] = 22;
        bArr[122] = 22;
        bArr[123] = 22;
        bArr[124] = 22;
        bArr[125] = 22;
        bArr[126] = 22;
        bArr[127] = 23;
        bArr[128] = 23;
        bArr[129] = 23;
        bArr[130] = 23;
        bArr[131] = 23;
        bArr[132] = 23;
        bArr[133] = 23;
        bArr[134] = 23;
        bArr[135] = 23;
        bArr[136] = 23;
        bArr[137] = 23;
        bArr[138] = 23;
        bArr[139] = 23;
        bArr[140] = 23;
        bArr[141] = 23;
        bArr[142] = 23;
        bArr[143] = 23;
        bArr[144] = 23;
        bArr[145] = 23;
        bArr[146] = 23;
        bArr[147] = 23;
        bArr[148] = 23;
        bArr[149] = 23;
        bArr[150] = 23;
        bArr[151] = 23;
        bArr[152] = 23;
        bArr[153] = 23;
        bArr[154] = 23;
        bArr[155] = 23;
        bArr[156] = 23;
        bArr[157] = 23;
        bArr[158] = 23;
        bArr[159] = 23;
        bArr[160] = 23;
        bArr[161] = 23;
        bArr[162] = 23;
        bArr[163] = 23;
        bArr[164] = 23;
        bArr[165] = 23;
        bArr[166] = 23;
        bArr[167] = 23;
        bArr[168] = 23;
        bArr[169] = 23;
        bArr[170] = 23;
        bArr[171] = 23;
        bArr[172] = 23;
        bArr[173] = 23;
        bArr[174] = 23;
        bArr[175] = 23;
        bArr[176] = 23;
        bArr[177] = 23;
        bArr[178] = 23;
        bArr[179] = 23;
        bArr[180] = 23;
        bArr[181] = 24;
        bArr[182] = 24;
        bArr[183] = 24;
        bArr[184] = 24;
        bArr[185] = 24;
        bArr[186] = 24;
        bArr[187] = 24;
        bArr[188] = 24;
        bArr[189] = 24;
        bArr[190] = 24;
        bArr[191] = 24;
        bArr[192] = 24;
        bArr[193] = 24;
        bArr[194] = 24;
        bArr[195] = 24;
        bArr[196] = 24;
        bArr[197] = 24;
        bArr[198] = 24;
        bArr[199] = 24;
        bArr[200] = 24;
        bArr[201] = 24;
        bArr[202] = 24;
        bArr[203] = 24;
        bArr[204] = 24;
        bArr[205] = 24;
        bArr[206] = 24;
        bArr[207] = 24;
        bArr[208] = 24;
        bArr[209] = 24;
        bArr[210] = 24;
        bArr[211] = 24;
        bArr[212] = 24;
        bArr[213] = 24;
        bArr[214] = 24;
        bArr[215] = 24;
        bArr[216] = 24;
        bArr[217] = 24;
        bArr[218] = 24;
        bArr[219] = 24;
        bArr[220] = 24;
        bArr[221] = 24;
        bArr[222] = 24;
        bArr[223] = 24;
        bArr[224] = 24;
        bArr[225] = 24;
        bArr[226] = 24;
        bArr[227] = 24;
        bArr[228] = 24;
        bArr[229] = 24;
        bArr[230] = 24;
        bArr[231] = 24;
        bArr[232] = 24;
        bArr[233] = 24;
        bArr[234] = 24;
        bArr[235] = 24;
        bArr[236] = 24;
        bArr[237] = 24;
        bArr[238] = 24;
        bArr[239] = 24;
        bArr[240] = 24;
        bArr[241] = 24;
        bArr[242] = 24;
        bArr[243] = 24;
        bArr[244] = 24;
        bArr[245] = 24;
        bArr[246] = 24;
        bArr[247] = 24;
        bArr[248] = 24;
        bArr[249] = 24;
        bArr[250] = 24;
        bArr[251] = 24;
        bArr[252] = 24;
        bArr[253] = 24;
        bArr[254] = 24;
        f20714b = bArr;
    }

    d() {
    }

    /* access modifiers changed from: private */
    public static void b(int[] iArr, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i7;
        int i12 = i8 - 1;
        int i13 = i9 - 1;
        int i14 = (i10 * 2) + 1;
        short s2 = f20713a[i10];
        byte b2 = f20714b[i10];
        int[] iArr2 = new int[i14];
        if (i11 == 1) {
            int i15 = (i6 * i9) / i5;
            int i16 = ((i6 + 1) * i9) / i5;
            while (i15 < i16) {
                int i17 = i8 * i15;
                int i18 = 0;
                long j2 = 0;
                long j3 = 0;
                long j4 = 0;
                long j5 = 0;
                long j6 = 0;
                long j7 = 0;
                while (i18 <= i10) {
                    iArr2[i18] = iArr[i17];
                    int i19 = iArr[i17];
                    i18++;
                    j2 += (long) (((i19 >>> 16) & JfifUtil.MARKER_FIRST_BYTE) * i18);
                    j3 += (long) (((i19 >>> 8) & JfifUtil.MARKER_FIRST_BYTE) * i18);
                    j4 += (long) ((i19 & JfifUtil.MARKER_FIRST_BYTE) * i18);
                    j5 += (long) ((i19 >>> 16) & JfifUtil.MARKER_FIRST_BYTE);
                    j6 += (long) ((i19 >>> 8) & JfifUtil.MARKER_FIRST_BYTE);
                    j7 += (long) (i19 & JfifUtil.MARKER_FIRST_BYTE);
                }
                int i20 = i17;
                int i21 = 1;
                long j8 = 0;
                long j9 = 0;
                long j10 = 0;
                while (i21 <= i10) {
                    if (i21 <= i12) {
                        i20++;
                    }
                    iArr2[i21 + i10] = iArr[i20];
                    int i22 = iArr[i20];
                    int i23 = (i10 + 1) - i21;
                    j2 += (long) (((i22 >>> 16) & JfifUtil.MARKER_FIRST_BYTE) * i23);
                    j3 += (long) (((i22 >>> 8) & JfifUtil.MARKER_FIRST_BYTE) * i23);
                    j4 += (long) ((i22 & JfifUtil.MARKER_FIRST_BYTE) * i23);
                    j8 += (long) ((i22 >>> 16) & JfifUtil.MARKER_FIRST_BYTE);
                    j9 += (long) ((i22 >>> 8) & JfifUtil.MARKER_FIRST_BYTE);
                    j10 += (long) (i22 & JfifUtil.MARKER_FIRST_BYTE);
                    i21++;
                    i20 = i20;
                }
                int i24 = i10 > i12 ? i12 : i10;
                int i25 = i24 + i17;
                int i26 = i10;
                int i27 = 0;
                while (i27 < i8) {
                    int i28 = i16;
                    long j11 = j8;
                    int i29 = i27;
                    int i30 = i15;
                    int i31 = i12;
                    long j12 = (long) s2;
                    iArr[i17] = (int) ((((j12 * j4) >>> b2) & 255) | ((long) (iArr[i17] & -16777216)) | ((((j2 * j12) >>> b2) & 255) << 16) | ((((j3 * j12) >>> b2) & 255) << 8));
                    int i32 = i17 + 1;
                    long j13 = j2 - j5;
                    long j14 = j3 - j6;
                    long j15 = j4 - j7;
                    int i33 = (i26 + i14) - i10;
                    if (i33 >= i14) {
                        i33 -= i14;
                    }
                    int i34 = iArr2[i33];
                    long j16 = j5 - ((long) ((i34 >>> 16) & JfifUtil.MARKER_FIRST_BYTE));
                    long j17 = j6 - ((long) ((i34 >>> 8) & JfifUtil.MARKER_FIRST_BYTE));
                    long j18 = j7 - ((long) (i34 & JfifUtil.MARKER_FIRST_BYTE));
                    i12 = i31;
                    if (i24 < i12) {
                        i25++;
                        i24++;
                    }
                    iArr2[i33] = iArr[i25];
                    int i35 = iArr[i25];
                    long j19 = j11 + ((long) ((i35 >>> 16) & JfifUtil.MARKER_FIRST_BYTE));
                    int i36 = i32;
                    int i37 = i24;
                    short s3 = s2;
                    long j20 = j9 + ((long) ((i35 >>> 8) & JfifUtil.MARKER_FIRST_BYTE));
                    long j21 = j10 + ((long) (i35 & JfifUtil.MARKER_FIRST_BYTE));
                    j2 = j13 + j19;
                    j3 = j14 + j20;
                    j4 = j15 + j21;
                    i26++;
                    if (i26 >= i14) {
                        i26 = 0;
                    }
                    int i38 = iArr2[i26];
                    j5 = j16 + ((long) ((i38 >>> 16) & JfifUtil.MARKER_FIRST_BYTE));
                    j6 = j17 + ((long) ((i38 >>> 8) & JfifUtil.MARKER_FIRST_BYTE));
                    j7 = j18 + ((long) (i38 & JfifUtil.MARKER_FIRST_BYTE));
                    long j22 = j19 - ((long) ((i38 >>> 16) & JfifUtil.MARKER_FIRST_BYTE));
                    j9 = j20 - ((long) ((i38 >>> 8) & JfifUtil.MARKER_FIRST_BYTE));
                    j10 = j21 - ((long) (i38 & JfifUtil.MARKER_FIRST_BYTE));
                    i27 = i29 + 1;
                    i17 = i36;
                    i15 = i30;
                    j8 = j22;
                    s2 = s3;
                    i16 = i28;
                    i24 = i37;
                }
                short s4 = s2;
                i15++;
                i16 = i16;
            }
            return;
        }
        short s5 = s2;
        if (i11 == 2) {
            int i39 = (i6 * i8) / i5;
            int i40 = ((i6 + 1) * i8) / i5;
            while (i39 < i40) {
                int i41 = 0;
                long j23 = 0;
                long j24 = 0;
                long j25 = 0;
                long j26 = 0;
                long j27 = 0;
                long j28 = 0;
                while (i41 <= i10) {
                    iArr2[i41] = iArr[i39];
                    int i42 = iArr[i39];
                    i41++;
                    j23 += (long) (((i42 >>> 16) & JfifUtil.MARKER_FIRST_BYTE) * i41);
                    j24 += (long) (((i42 >>> 8) & JfifUtil.MARKER_FIRST_BYTE) * i41);
                    j25 += (long) ((i42 & JfifUtil.MARKER_FIRST_BYTE) * i41);
                    j26 += (long) ((i42 >>> 16) & JfifUtil.MARKER_FIRST_BYTE);
                    j27 += (long) ((i42 >>> 8) & JfifUtil.MARKER_FIRST_BYTE);
                    j28 += (long) (i42 & JfifUtil.MARKER_FIRST_BYTE);
                    i40 = i40;
                    i14 = i14;
                }
                int i43 = i14;
                int i44 = i40;
                int i45 = i39;
                int i46 = 1;
                long j29 = 0;
                long j30 = 0;
                long j31 = 0;
                while (i46 <= i10) {
                    if (i46 <= i13) {
                        i45 += i8;
                    }
                    iArr2[i46 + i10] = iArr[i45];
                    int i47 = iArr[i45];
                    int i48 = (i10 + 1) - i46;
                    j23 += (long) (((i47 >>> 16) & JfifUtil.MARKER_FIRST_BYTE) * i48);
                    j24 += (long) (((i47 >>> 8) & JfifUtil.MARKER_FIRST_BYTE) * i48);
                    j25 += (long) ((i47 & JfifUtil.MARKER_FIRST_BYTE) * i48);
                    j29 += (long) ((i47 >>> 16) & JfifUtil.MARKER_FIRST_BYTE);
                    j30 += (long) ((i47 >>> 8) & JfifUtil.MARKER_FIRST_BYTE);
                    j31 += (long) (i47 & JfifUtil.MARKER_FIRST_BYTE);
                    i46++;
                    i45 = i45;
                    b2 = b2;
                    iArr2 = iArr2;
                }
                byte b3 = b2;
                int[] iArr3 = iArr2;
                int i49 = i10 > i13 ? i13 : i10;
                int i50 = (i49 * i8) + i39;
                int i51 = i10;
                int i52 = i39;
                int i53 = 0;
                while (i53 < i9) {
                    long j32 = j29;
                    int i54 = i39;
                    short s6 = s5;
                    int i55 = i49;
                    long j33 = (long) s6;
                    iArr[i52] = (int) ((((j33 * j25) >>> b3) & 255) | ((long) (iArr[i52] & -16777216)) | ((((j23 * j33) >>> b3) & 255) << 16) | ((((j24 * j33) >>> b3) & 255) << 8));
                    i52 += i8;
                    long j34 = j23 - j26;
                    long j35 = j24 - j27;
                    long j36 = j25 - j28;
                    int i56 = (i51 + i43) - i10;
                    int i57 = i43;
                    if (i56 >= i57) {
                        i56 -= i57;
                    }
                    int i58 = iArr3[i56];
                    short s7 = s6;
                    long j37 = j26 - ((long) ((i58 >>> 16) & JfifUtil.MARKER_FIRST_BYTE));
                    long j38 = j27 - ((long) ((i58 >>> 8) & JfifUtil.MARKER_FIRST_BYTE));
                    long j39 = j28 - ((long) (i58 & JfifUtil.MARKER_FIRST_BYTE));
                    int i59 = i55;
                    if (i59 < i13) {
                        i50 += i8;
                        i59++;
                    }
                    iArr3[i56] = iArr[i50];
                    int i60 = iArr[i50];
                    long j40 = j32 + ((long) ((i60 >>> 16) & JfifUtil.MARKER_FIRST_BYTE));
                    int i61 = i59;
                    long j41 = j30 + ((long) ((i60 >>> 8) & JfifUtil.MARKER_FIRST_BYTE));
                    long j42 = j31 + ((long) (i60 & JfifUtil.MARKER_FIRST_BYTE));
                    j23 = j34 + j40;
                    j24 = j35 + j41;
                    j25 = j36 + j42;
                    i51++;
                    if (i51 >= i57) {
                        i51 = 0;
                    }
                    int i62 = iArr3[i51];
                    j26 = j37 + ((long) ((i62 >>> 16) & JfifUtil.MARKER_FIRST_BYTE));
                    j27 = j38 + ((long) ((i62 >>> 8) & JfifUtil.MARKER_FIRST_BYTE));
                    j28 = j39 + ((long) (i62 & JfifUtil.MARKER_FIRST_BYTE));
                    j29 = j40 - ((long) ((i62 >>> 16) & JfifUtil.MARKER_FIRST_BYTE));
                    j30 = j41 - ((long) ((i62 >>> 8) & JfifUtil.MARKER_FIRST_BYTE));
                    j31 = j42 - ((long) (i62 & JfifUtil.MARKER_FIRST_BYTE));
                    i53++;
                    i8 = i2;
                    i9 = i3;
                    i10 = i4;
                    s5 = s7;
                    i39 = i54;
                    i43 = i57;
                    i49 = i61;
                }
                int i63 = i43;
                short s8 = s5;
                i39++;
                i8 = i2;
                i9 = i3;
                i10 = i4;
                i40 = i44;
                i14 = i63;
                b2 = b3;
                iArr2 = iArr3;
            }
        }
    }

    public Bitmap a(Bitmap bitmap, float f2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        try {
            int[] iArr = new int[(width * height)];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            int i2 = e.f20722a;
            ArrayList arrayList = new ArrayList(i2);
            ArrayList arrayList2 = new ArrayList(i2);
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = (int) f2;
                int[] iArr2 = iArr;
                int i5 = width;
                int i6 = height;
                int i7 = i4;
                int i8 = i4;
                int i9 = i2;
                int i10 = i3;
                a aVar = r0;
                a aVar2 = new a(iArr2, i5, i6, i7, i9, i10, 1);
                arrayList.add(aVar);
                arrayList2.add(new a(iArr2, i5, i6, i8, i9, i10, 2));
            }
            try {
                ExecutorService executorService = e.f20723b;
                executorService.invokeAll(arrayList);
                try {
                    executorService.invokeAll(arrayList2);
                    try {
                        return Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
                    } catch (OutOfMemoryError unused) {
                        return null;
                    }
                } catch (InterruptedException unused2) {
                    return null;
                }
            } catch (InterruptedException unused3) {
                return null;
            }
        } catch (OutOfMemoryError unused4) {
            return null;
        }
    }
}
