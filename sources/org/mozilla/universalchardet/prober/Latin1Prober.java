package org.mozilla.universalchardet.prober;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.ByteBuffer;
import org.mozilla.universalchardet.Constants;
import org.mozilla.universalchardet.prober.CharsetProber;

public class Latin1Prober extends CharsetProber {

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f41928e;

    /* renamed from: f  reason: collision with root package name */
    private static final byte[] f41929f = {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3, 3, 0, 3, 3, 3, 3, 3, 3, 3, 0, 3, 3, 3, 1, 1, 3, 3, 0, 3, 3, 3, 1, 2, 1, 2, 0, 3, 3, 3, 3, 3, 3, 3, 0, 3, 1, 3, 1, 1, 1, 3, 0, 3, 1, 3, 1, 1, 3, 3};

    /* renamed from: b  reason: collision with root package name */
    private CharsetProber.ProbingState f41930b;

    /* renamed from: c  reason: collision with root package name */
    private byte f41931c;

    /* renamed from: d  reason: collision with root package name */
    private int[] f41932d = new int[4];

    static {
        byte[] bArr = new byte[UserVerificationMethods.USER_VERIFY_HANDPRINT];
        // fill-array-data instruction
        bArr[0] = 1;
        bArr[1] = 1;
        bArr[2] = 1;
        bArr[3] = 1;
        bArr[4] = 1;
        bArr[5] = 1;
        bArr[6] = 1;
        bArr[7] = 1;
        bArr[8] = 1;
        bArr[9] = 1;
        bArr[10] = 1;
        bArr[11] = 1;
        bArr[12] = 1;
        bArr[13] = 1;
        bArr[14] = 1;
        bArr[15] = 1;
        bArr[16] = 1;
        bArr[17] = 1;
        bArr[18] = 1;
        bArr[19] = 1;
        bArr[20] = 1;
        bArr[21] = 1;
        bArr[22] = 1;
        bArr[23] = 1;
        bArr[24] = 1;
        bArr[25] = 1;
        bArr[26] = 1;
        bArr[27] = 1;
        bArr[28] = 1;
        bArr[29] = 1;
        bArr[30] = 1;
        bArr[31] = 1;
        bArr[32] = 1;
        bArr[33] = 1;
        bArr[34] = 1;
        bArr[35] = 1;
        bArr[36] = 1;
        bArr[37] = 1;
        bArr[38] = 1;
        bArr[39] = 1;
        bArr[40] = 1;
        bArr[41] = 1;
        bArr[42] = 1;
        bArr[43] = 1;
        bArr[44] = 1;
        bArr[45] = 1;
        bArr[46] = 1;
        bArr[47] = 1;
        bArr[48] = 1;
        bArr[49] = 1;
        bArr[50] = 1;
        bArr[51] = 1;
        bArr[52] = 1;
        bArr[53] = 1;
        bArr[54] = 1;
        bArr[55] = 1;
        bArr[56] = 1;
        bArr[57] = 1;
        bArr[58] = 1;
        bArr[59] = 1;
        bArr[60] = 1;
        bArr[61] = 1;
        bArr[62] = 1;
        bArr[63] = 1;
        bArr[64] = 1;
        bArr[65] = 2;
        bArr[66] = 2;
        bArr[67] = 2;
        bArr[68] = 2;
        bArr[69] = 2;
        bArr[70] = 2;
        bArr[71] = 2;
        bArr[72] = 2;
        bArr[73] = 2;
        bArr[74] = 2;
        bArr[75] = 2;
        bArr[76] = 2;
        bArr[77] = 2;
        bArr[78] = 2;
        bArr[79] = 2;
        bArr[80] = 2;
        bArr[81] = 2;
        bArr[82] = 2;
        bArr[83] = 2;
        bArr[84] = 2;
        bArr[85] = 2;
        bArr[86] = 2;
        bArr[87] = 2;
        bArr[88] = 2;
        bArr[89] = 2;
        bArr[90] = 2;
        bArr[91] = 1;
        bArr[92] = 1;
        bArr[93] = 1;
        bArr[94] = 1;
        bArr[95] = 1;
        bArr[96] = 1;
        bArr[97] = 3;
        bArr[98] = 3;
        bArr[99] = 3;
        bArr[100] = 3;
        bArr[101] = 3;
        bArr[102] = 3;
        bArr[103] = 3;
        bArr[104] = 3;
        bArr[105] = 3;
        bArr[106] = 3;
        bArr[107] = 3;
        bArr[108] = 3;
        bArr[109] = 3;
        bArr[110] = 3;
        bArr[111] = 3;
        bArr[112] = 3;
        bArr[113] = 3;
        bArr[114] = 3;
        bArr[115] = 3;
        bArr[116] = 3;
        bArr[117] = 3;
        bArr[118] = 3;
        bArr[119] = 3;
        bArr[120] = 3;
        bArr[121] = 3;
        bArr[122] = 3;
        bArr[123] = 1;
        bArr[124] = 1;
        bArr[125] = 1;
        bArr[126] = 1;
        bArr[127] = 1;
        bArr[128] = 1;
        bArr[129] = 0;
        bArr[130] = 1;
        bArr[131] = 7;
        bArr[132] = 1;
        bArr[133] = 1;
        bArr[134] = 1;
        bArr[135] = 1;
        bArr[136] = 1;
        bArr[137] = 1;
        bArr[138] = 5;
        bArr[139] = 1;
        bArr[140] = 5;
        bArr[141] = 0;
        bArr[142] = 5;
        bArr[143] = 0;
        bArr[144] = 0;
        bArr[145] = 1;
        bArr[146] = 1;
        bArr[147] = 1;
        bArr[148] = 1;
        bArr[149] = 1;
        bArr[150] = 1;
        bArr[151] = 1;
        bArr[152] = 1;
        bArr[153] = 1;
        bArr[154] = 7;
        bArr[155] = 1;
        bArr[156] = 7;
        bArr[157] = 0;
        bArr[158] = 7;
        bArr[159] = 5;
        bArr[160] = 1;
        bArr[161] = 1;
        bArr[162] = 1;
        bArr[163] = 1;
        bArr[164] = 1;
        bArr[165] = 1;
        bArr[166] = 1;
        bArr[167] = 1;
        bArr[168] = 1;
        bArr[169] = 1;
        bArr[170] = 1;
        bArr[171] = 1;
        bArr[172] = 1;
        bArr[173] = 1;
        bArr[174] = 1;
        bArr[175] = 1;
        bArr[176] = 1;
        bArr[177] = 1;
        bArr[178] = 1;
        bArr[179] = 1;
        bArr[180] = 1;
        bArr[181] = 1;
        bArr[182] = 1;
        bArr[183] = 1;
        bArr[184] = 1;
        bArr[185] = 1;
        bArr[186] = 1;
        bArr[187] = 1;
        bArr[188] = 1;
        bArr[189] = 1;
        bArr[190] = 1;
        bArr[191] = 1;
        bArr[192] = 4;
        bArr[193] = 4;
        bArr[194] = 4;
        bArr[195] = 4;
        bArr[196] = 4;
        bArr[197] = 4;
        bArr[198] = 5;
        bArr[199] = 5;
        bArr[200] = 4;
        bArr[201] = 4;
        bArr[202] = 4;
        bArr[203] = 4;
        bArr[204] = 4;
        bArr[205] = 4;
        bArr[206] = 4;
        bArr[207] = 4;
        bArr[208] = 5;
        bArr[209] = 5;
        bArr[210] = 4;
        bArr[211] = 4;
        bArr[212] = 4;
        bArr[213] = 4;
        bArr[214] = 4;
        bArr[215] = 1;
        bArr[216] = 4;
        bArr[217] = 4;
        bArr[218] = 4;
        bArr[219] = 4;
        bArr[220] = 4;
        bArr[221] = 5;
        bArr[222] = 5;
        bArr[223] = 5;
        bArr[224] = 6;
        bArr[225] = 6;
        bArr[226] = 6;
        bArr[227] = 6;
        bArr[228] = 6;
        bArr[229] = 6;
        bArr[230] = 7;
        bArr[231] = 7;
        bArr[232] = 6;
        bArr[233] = 6;
        bArr[234] = 6;
        bArr[235] = 6;
        bArr[236] = 6;
        bArr[237] = 6;
        bArr[238] = 6;
        bArr[239] = 6;
        bArr[240] = 7;
        bArr[241] = 7;
        bArr[242] = 6;
        bArr[243] = 6;
        bArr[244] = 6;
        bArr[245] = 6;
        bArr[246] = 6;
        bArr[247] = 1;
        bArr[248] = 6;
        bArr[249] = 6;
        bArr[250] = 6;
        bArr[251] = 6;
        bArr[252] = 6;
        bArr[253] = 7;
        bArr[254] = 7;
        bArr[255] = 7;
        f41928e = bArr;
    }

    public Latin1Prober() {
        j();
    }

    public String c() {
        return Constants.f41861r;
    }

    public float d() {
        int[] iArr;
        float f2;
        if (this.f41930b == CharsetProber.ProbingState.NOT_ME) {
            return 0.01f;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            iArr = this.f41932d;
            if (i2 >= iArr.length) {
                break;
            }
            i3 += iArr[i2];
            i2++;
        }
        float f3 = 0.0f;
        if (i3 <= 0) {
            f2 = 0.0f;
        } else {
            float f4 = (float) i3;
            f2 = ((((float) iArr[3]) * 1.0f) / f4) - ((((float) iArr[1]) * 20.0f) / f4);
        }
        if (f2 >= 0.0f) {
            f3 = f2;
        }
        return f3 * 0.5f;
    }

    public CharsetProber.ProbingState e() {
        return this.f41930b;
    }

    public CharsetProber.ProbingState f(byte[] bArr, int i2, int i3) {
        ByteBuffer a2 = a(bArr, i2, i3);
        byte[] array = a2.array();
        int position = a2.position();
        int i4 = 0;
        while (true) {
            if (i4 >= position) {
                break;
            }
            byte b2 = f41928e[array[i4] & 255];
            byte b3 = f41929f[(this.f41931c * 8) + b2];
            if (b3 == 0) {
                this.f41930b = CharsetProber.ProbingState.NOT_ME;
                break;
            }
            int[] iArr = this.f41932d;
            iArr[b3] = iArr[b3] + 1;
            this.f41931c = b2;
            i4++;
        }
        return this.f41930b;
    }

    public final void j() {
        this.f41930b = CharsetProber.ProbingState.DETECTING;
        this.f41931c = 1;
        int i2 = 0;
        while (true) {
            int[] iArr = this.f41932d;
            if (i2 < iArr.length) {
                iArr[i2] = 0;
                i2++;
            } else {
                return;
            }
        }
    }
}
