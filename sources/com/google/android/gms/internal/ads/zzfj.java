package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.media.AudioFormat;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.ads.AdError;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.hermes.intl.Constants;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.startapp.de;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import com.unity3d.services.core.device.MimeTypes;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

public final class zzfj {
    public static final int zza;
    public static final String zzb;
    public static final String zzc;
    public static final String zzd;
    public static final String zze;
    public static final byte[] zzf = new byte[0];
    private static final Pattern zzg = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
    private static final Pattern zzh = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
    private static final Pattern zzi = Pattern.compile("%([A-Fa-f0-9]{2})");
    private static final Pattern zzj = Pattern.compile("(?:.*\\.)?isml?(?:/(manifest(.*))?)?", 2);
    private static HashMap zzk;
    private static final String[] zzl = {"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", de.f34377a, "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "arb", "ar-arb", ScarConstants.IN_SIGNAL_KEY, "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
    private static final String[] zzm = {"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
    private static final int[] zzn;
    private static final int[] zzo;

    static {
        int i2 = Build.VERSION.SDK_INT;
        zza = i2;
        String str = Build.DEVICE;
        zzb = str;
        String str2 = Build.MANUFACTURER;
        zzc = str2;
        String str3 = Build.MODEL;
        zzd = str3;
        zze = str + ", " + str3 + ", " + str2 + ", " + i2;
        int[] iArr = new int[UserVerificationMethods.USER_VERIFY_HANDPRINT];
        // fill-array-data instruction
        iArr[0] = 0;
        iArr[1] = 79764919;
        iArr[2] = 159529838;
        iArr[3] = 222504665;
        iArr[4] = 319059676;
        iArr[5] = 398814059;
        iArr[6] = 445009330;
        iArr[7] = 507990021;
        iArr[8] = 638119352;
        iArr[9] = 583659535;
        iArr[10] = 797628118;
        iArr[11] = 726387553;
        iArr[12] = 890018660;
        iArr[13] = 835552979;
        iArr[14] = 1015980042;
        iArr[15] = 944750013;
        iArr[16] = 1276238704;
        iArr[17] = 1221641927;
        iArr[18] = 1167319070;
        iArr[19] = 1095957929;
        iArr[20] = 1595256236;
        iArr[21] = 1540665371;
        iArr[22] = 1452775106;
        iArr[23] = 1381403509;
        iArr[24] = 1780037320;
        iArr[25] = 1859660671;
        iArr[26] = 1671105958;
        iArr[27] = 1733955601;
        iArr[28] = 2031960084;
        iArr[29] = 2111593891;
        iArr[30] = 1889500026;
        iArr[31] = 1952343757;
        iArr[32] = -1742489888;
        iArr[33] = -1662866601;
        iArr[34] = -1851683442;
        iArr[35] = -1788833735;
        iArr[36] = -1960329156;
        iArr[37] = -1880695413;
        iArr[38] = -2103051438;
        iArr[39] = -2040207643;
        iArr[40] = -1104454824;
        iArr[41] = -1159051537;
        iArr[42] = -1213636554;
        iArr[43] = -1284997759;
        iArr[44] = -1389417084;
        iArr[45] = -1444007885;
        iArr[46] = -1532160278;
        iArr[47] = -1603531939;
        iArr[48] = -734892656;
        iArr[49] = -789352409;
        iArr[50] = -575645954;
        iArr[51] = -646886583;
        iArr[52] = -952755380;
        iArr[53] = -1007220997;
        iArr[54] = -827056094;
        iArr[55] = -898286187;
        iArr[56] = -231047128;
        iArr[57] = -151282273;
        iArr[58] = -71779514;
        iArr[59] = -8804623;
        iArr[60] = -515967244;
        iArr[61] = -436212925;
        iArr[62] = -390279782;
        iArr[63] = -327299027;
        iArr[64] = 881225847;
        iArr[65] = 809987520;
        iArr[66] = 1023691545;
        iArr[67] = 969234094;
        iArr[68] = 662832811;
        iArr[69] = 591600412;
        iArr[70] = 771767749;
        iArr[71] = 717299826;
        iArr[72] = 311336399;
        iArr[73] = 374308984;
        iArr[74] = 453813921;
        iArr[75] = 533576470;
        iArr[76] = 25881363;
        iArr[77] = 88864420;
        iArr[78] = 134795389;
        iArr[79] = 214552010;
        iArr[80] = 2023205639;
        iArr[81] = 2086057648;
        iArr[82] = 1897238633;
        iArr[83] = 1976864222;
        iArr[84] = 1804852699;
        iArr[85] = 1867694188;
        iArr[86] = 1645340341;
        iArr[87] = 1724971778;
        iArr[88] = 1587496639;
        iArr[89] = 1516133128;
        iArr[90] = 1461550545;
        iArr[91] = 1406951526;
        iArr[92] = 1302016099;
        iArr[93] = 1230646740;
        iArr[94] = 1142491917;
        iArr[95] = 1087903418;
        iArr[96] = -1398421865;
        iArr[97] = -1469785312;
        iArr[98] = -1524105735;
        iArr[99] = -1578704818;
        iArr[100] = -1079922613;
        iArr[101] = -1151291908;
        iArr[102] = -1239184603;
        iArr[103] = -1293773166;
        iArr[104] = -1968362705;
        iArr[105] = -1905510760;
        iArr[106] = -2094067647;
        iArr[107] = -2014441994;
        iArr[108] = -1716953613;
        iArr[109] = -1654112188;
        iArr[110] = -1876203875;
        iArr[111] = -1796572374;
        iArr[112] = -525066777;
        iArr[113] = -462094256;
        iArr[114] = -382327159;
        iArr[115] = -302564546;
        iArr[116] = -206542021;
        iArr[117] = -143559028;
        iArr[118] = -97365931;
        iArr[119] = -17609246;
        iArr[120] = -960696225;
        iArr[121] = -1031934488;
        iArr[122] = -817968335;
        iArr[123] = -872425850;
        iArr[124] = -709327229;
        iArr[125] = -780559564;
        iArr[126] = -600130067;
        iArr[127] = -654598054;
        iArr[128] = 1762451694;
        iArr[129] = 1842216281;
        iArr[130] = 1619975040;
        iArr[131] = 1682949687;
        iArr[132] = 2047383090;
        iArr[133] = 2127137669;
        iArr[134] = 1938468188;
        iArr[135] = 2001449195;
        iArr[136] = 1325665622;
        iArr[137] = 1271206113;
        iArr[138] = 1183200824;
        iArr[139] = 1111960463;
        iArr[140] = 1543535498;
        iArr[141] = 1489069629;
        iArr[142] = 1434599652;
        iArr[143] = 1363369299;
        iArr[144] = 622672798;
        iArr[145] = 568075817;
        iArr[146] = 748617968;
        iArr[147] = 677256519;
        iArr[148] = 907627842;
        iArr[149] = 853037301;
        iArr[150] = 1067152940;
        iArr[151] = 995781531;
        iArr[152] = 51762726;
        iArr[153] = 131386257;
        iArr[154] = 177728840;
        iArr[155] = 240578815;
        iArr[156] = 269590778;
        iArr[157] = 349224269;
        iArr[158] = 429104020;
        iArr[159] = 491947555;
        iArr[160] = -248556018;
        iArr[161] = -168932423;
        iArr[162] = -122852000;
        iArr[163] = -60002089;
        iArr[164] = -500490030;
        iArr[165] = -420856475;
        iArr[166] = -341238852;
        iArr[167] = -278395381;
        iArr[168] = -685261898;
        iArr[169] = -739858943;
        iArr[170] = -559578920;
        iArr[171] = -630940305;
        iArr[172] = -1004286614;
        iArr[173] = -1058877219;
        iArr[174] = -845023740;
        iArr[175] = -916395085;
        iArr[176] = -1119974018;
        iArr[177] = -1174433591;
        iArr[178] = -1262701040;
        iArr[179] = -1333941337;
        iArr[180] = -1371866206;
        iArr[181] = -1426332139;
        iArr[182] = -1481064244;
        iArr[183] = -1552294533;
        iArr[184] = -1690935098;
        iArr[185] = -1611170447;
        iArr[186] = -1833673816;
        iArr[187] = -1770699233;
        iArr[188] = -2009983462;
        iArr[189] = -1930228819;
        iArr[190] = -2119160460;
        iArr[191] = -2056179517;
        iArr[192] = 1569362073;
        iArr[193] = 1498123566;
        iArr[194] = 1409854455;
        iArr[195] = 1355396672;
        iArr[196] = 1317987909;
        iArr[197] = 1246755826;
        iArr[198] = 1192025387;
        iArr[199] = 1137557660;
        iArr[200] = 2072149281;
        iArr[201] = 2135122070;
        iArr[202] = 1912620623;
        iArr[203] = 1992383480;
        iArr[204] = 1753615357;
        iArr[205] = 1816598090;
        iArr[206] = 1627664531;
        iArr[207] = 1707420964;
        iArr[208] = 295390185;
        iArr[209] = 358241886;
        iArr[210] = 404320391;
        iArr[211] = 483945776;
        iArr[212] = 43990325;
        iArr[213] = 106832002;
        iArr[214] = 186451547;
        iArr[215] = 266083308;
        iArr[216] = 932423249;
        iArr[217] = 861060070;
        iArr[218] = 1041341759;
        iArr[219] = 986742920;
        iArr[220] = 613929101;
        iArr[221] = 542559546;
        iArr[222] = 756411363;
        iArr[223] = 701822548;
        iArr[224] = -978770311;
        iArr[225] = -1050133554;
        iArr[226] = -869589737;
        iArr[227] = -924188512;
        iArr[228] = -693284699;
        iArr[229] = -764654318;
        iArr[230] = -550540341;
        iArr[231] = -605129092;
        iArr[232] = -475935807;
        iArr[233] = -413084042;
        iArr[234] = -366743377;
        iArr[235] = -287118056;
        iArr[236] = -257573603;
        iArr[237] = -194731862;
        iArr[238] = -114850189;
        iArr[239] = -35218492;
        iArr[240] = -1984365303;
        iArr[241] = -1921392450;
        iArr[242] = -2143631769;
        iArr[243] = -2063868976;
        iArr[244] = -1698919467;
        iArr[245] = -1635936670;
        iArr[246] = -1824608069;
        iArr[247] = -1744851700;
        iArr[248] = -1347415887;
        iArr[249] = -1418654458;
        iArr[250] = -1506661409;
        iArr[251] = -1561119128;
        iArr[252] = -1129027987;
        iArr[253] = -1200260134;
        iArr[254] = -1254728445;
        iArr[255] = -1309196108;
        zzn = iArr;
        int[] iArr2 = new int[UserVerificationMethods.USER_VERIFY_HANDPRINT];
        // fill-array-data instruction
        iArr2[0] = 0;
        iArr2[1] = 7;
        iArr2[2] = 14;
        iArr2[3] = 9;
        iArr2[4] = 28;
        iArr2[5] = 27;
        iArr2[6] = 18;
        iArr2[7] = 21;
        iArr2[8] = 56;
        iArr2[9] = 63;
        iArr2[10] = 54;
        iArr2[11] = 49;
        iArr2[12] = 36;
        iArr2[13] = 35;
        iArr2[14] = 42;
        iArr2[15] = 45;
        iArr2[16] = 112;
        iArr2[17] = 119;
        iArr2[18] = 126;
        iArr2[19] = 121;
        iArr2[20] = 108;
        iArr2[21] = 107;
        iArr2[22] = 98;
        iArr2[23] = 101;
        iArr2[24] = 72;
        iArr2[25] = 79;
        iArr2[26] = 70;
        iArr2[27] = 65;
        iArr2[28] = 84;
        iArr2[29] = 83;
        iArr2[30] = 90;
        iArr2[31] = 93;
        iArr2[32] = 224;
        iArr2[33] = 231;
        iArr2[34] = 238;
        iArr2[35] = 233;
        iArr2[36] = 252;
        iArr2[37] = 251;
        iArr2[38] = 242;
        iArr2[39] = 245;
        iArr2[40] = 216;
        iArr2[41] = 223;
        iArr2[42] = 214;
        iArr2[43] = 209;
        iArr2[44] = 196;
        iArr2[45] = 195;
        iArr2[46] = 202;
        iArr2[47] = 205;
        iArr2[48] = 144;
        iArr2[49] = 151;
        iArr2[50] = 158;
        iArr2[51] = 153;
        iArr2[52] = 140;
        iArr2[53] = 139;
        iArr2[54] = 130;
        iArr2[55] = 133;
        iArr2[56] = 168;
        iArr2[57] = 175;
        iArr2[58] = 166;
        iArr2[59] = 161;
        iArr2[60] = 180;
        iArr2[61] = 179;
        iArr2[62] = 186;
        iArr2[63] = 189;
        iArr2[64] = 199;
        iArr2[65] = 192;
        iArr2[66] = 201;
        iArr2[67] = 206;
        iArr2[68] = 219;
        iArr2[69] = 220;
        iArr2[70] = 213;
        iArr2[71] = 210;
        iArr2[72] = 255;
        iArr2[73] = 248;
        iArr2[74] = 241;
        iArr2[75] = 246;
        iArr2[76] = 227;
        iArr2[77] = 228;
        iArr2[78] = 237;
        iArr2[79] = 234;
        iArr2[80] = 183;
        iArr2[81] = 176;
        iArr2[82] = 185;
        iArr2[83] = 190;
        iArr2[84] = 171;
        iArr2[85] = 172;
        iArr2[86] = 165;
        iArr2[87] = 162;
        iArr2[88] = 143;
        iArr2[89] = 136;
        iArr2[90] = 129;
        iArr2[91] = 134;
        iArr2[92] = 147;
        iArr2[93] = 148;
        iArr2[94] = 157;
        iArr2[95] = 154;
        iArr2[96] = 39;
        iArr2[97] = 32;
        iArr2[98] = 41;
        iArr2[99] = 46;
        iArr2[100] = 59;
        iArr2[101] = 60;
        iArr2[102] = 53;
        iArr2[103] = 50;
        iArr2[104] = 31;
        iArr2[105] = 24;
        iArr2[106] = 17;
        iArr2[107] = 22;
        iArr2[108] = 3;
        iArr2[109] = 4;
        iArr2[110] = 13;
        iArr2[111] = 10;
        iArr2[112] = 87;
        iArr2[113] = 80;
        iArr2[114] = 89;
        iArr2[115] = 94;
        iArr2[116] = 75;
        iArr2[117] = 76;
        iArr2[118] = 69;
        iArr2[119] = 66;
        iArr2[120] = 111;
        iArr2[121] = 104;
        iArr2[122] = 97;
        iArr2[123] = 102;
        iArr2[124] = 115;
        iArr2[125] = 116;
        iArr2[126] = 125;
        iArr2[127] = 122;
        iArr2[128] = 137;
        iArr2[129] = 142;
        iArr2[130] = 135;
        iArr2[131] = 128;
        iArr2[132] = 149;
        iArr2[133] = 146;
        iArr2[134] = 155;
        iArr2[135] = 156;
        iArr2[136] = 177;
        iArr2[137] = 182;
        iArr2[138] = 191;
        iArr2[139] = 184;
        iArr2[140] = 173;
        iArr2[141] = 170;
        iArr2[142] = 163;
        iArr2[143] = 164;
        iArr2[144] = 249;
        iArr2[145] = 254;
        iArr2[146] = 247;
        iArr2[147] = 240;
        iArr2[148] = 229;
        iArr2[149] = 226;
        iArr2[150] = 235;
        iArr2[151] = 236;
        iArr2[152] = 193;
        iArr2[153] = 198;
        iArr2[154] = 207;
        iArr2[155] = 200;
        iArr2[156] = 221;
        iArr2[157] = 218;
        iArr2[158] = 211;
        iArr2[159] = 212;
        iArr2[160] = 105;
        iArr2[161] = 110;
        iArr2[162] = 103;
        iArr2[163] = 96;
        iArr2[164] = 117;
        iArr2[165] = 114;
        iArr2[166] = 123;
        iArr2[167] = 124;
        iArr2[168] = 81;
        iArr2[169] = 86;
        iArr2[170] = 95;
        iArr2[171] = 88;
        iArr2[172] = 77;
        iArr2[173] = 74;
        iArr2[174] = 67;
        iArr2[175] = 68;
        iArr2[176] = 25;
        iArr2[177] = 30;
        iArr2[178] = 23;
        iArr2[179] = 16;
        iArr2[180] = 5;
        iArr2[181] = 2;
        iArr2[182] = 11;
        iArr2[183] = 12;
        iArr2[184] = 33;
        iArr2[185] = 38;
        iArr2[186] = 47;
        iArr2[187] = 40;
        iArr2[188] = 61;
        iArr2[189] = 58;
        iArr2[190] = 51;
        iArr2[191] = 52;
        iArr2[192] = 78;
        iArr2[193] = 73;
        iArr2[194] = 64;
        iArr2[195] = 71;
        iArr2[196] = 82;
        iArr2[197] = 85;
        iArr2[198] = 92;
        iArr2[199] = 91;
        iArr2[200] = 118;
        iArr2[201] = 113;
        iArr2[202] = 120;
        iArr2[203] = 127;
        iArr2[204] = 106;
        iArr2[205] = 109;
        iArr2[206] = 100;
        iArr2[207] = 99;
        iArr2[208] = 62;
        iArr2[209] = 57;
        iArr2[210] = 48;
        iArr2[211] = 55;
        iArr2[212] = 34;
        iArr2[213] = 37;
        iArr2[214] = 44;
        iArr2[215] = 43;
        iArr2[216] = 6;
        iArr2[217] = 1;
        iArr2[218] = 8;
        iArr2[219] = 15;
        iArr2[220] = 26;
        iArr2[221] = 29;
        iArr2[222] = 20;
        iArr2[223] = 19;
        iArr2[224] = 174;
        iArr2[225] = 169;
        iArr2[226] = 160;
        iArr2[227] = 167;
        iArr2[228] = 178;
        iArr2[229] = 181;
        iArr2[230] = 188;
        iArr2[231] = 187;
        iArr2[232] = 150;
        iArr2[233] = 145;
        iArr2[234] = 152;
        iArr2[235] = 159;
        iArr2[236] = 138;
        iArr2[237] = 141;
        iArr2[238] = 132;
        iArr2[239] = 131;
        iArr2[240] = 222;
        iArr2[241] = 217;
        iArr2[242] = 208;
        iArr2[243] = 215;
        iArr2[244] = 194;
        iArr2[245] = 197;
        iArr2[246] = 204;
        iArr2[247] = 203;
        iArr2[248] = 230;
        iArr2[249] = 225;
        iArr2[250] = 232;
        iArr2[251] = 239;
        iArr2[252] = 250;
        iArr2[253] = 253;
        iArr2[254] = 244;
        iArr2[255] = 243;
        zzo = iArr2;
    }

    public static ExecutorService zzA(String str) {
        return Executors.newSingleThreadExecutor(new zzfi(str));
    }

    public static void zzB(long[] jArr, long j2, long j3) {
        int i2 = 0;
        int i3 = (j3 > 1000000 ? 1 : (j3 == 1000000 ? 0 : -1));
        if (i3 >= 0 && j3 % 1000000 == 0) {
            long j4 = j3 / 1000000;
            while (i2 < jArr.length) {
                jArr[i2] = jArr[i2] / j4;
                i2++;
            }
        } else if (i3 >= 0 || 1000000 % j3 != 0) {
            double d2 = (double) j3;
            while (i2 < jArr.length) {
                jArr[i2] = (long) (((double) jArr[i2]) * (1000000.0d / d2));
                i2++;
            }
        } else {
            long j5 = 1000000 / j3;
            while (i2 < jArr.length) {
                jArr[i2] = jArr[i2] * j5;
                i2++;
            }
        }
    }

    public static boolean zzC(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static boolean zzD(int i2) {
        return i2 == 3 || i2 == 2 || i2 == 268435456 || i2 == 536870912 || i2 == 805306368 || i2 == 4;
    }

    public static boolean zzE(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
        if (uiModeManager == null || uiModeManager.getCurrentModeType() != 4) {
            return false;
        }
        return true;
    }

    public static boolean zzF(Handler handler, Runnable runnable) {
        if (!handler.getLooper().getThread().isAlive()) {
            return false;
        }
        if (handler.getLooper() != Looper.myLooper()) {
            return handler.post(runnable);
        }
        runnable.run();
        return true;
    }

    public static Object[] zzG(Object[] objArr, int i2) {
        boolean z2;
        if (i2 <= objArr.length) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzdy.zzd(z2);
        return Arrays.copyOf(objArr, i2);
    }

    private static String zzH(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{str});
        } catch (Exception e2) {
            zzer.zzd("Util", "Failed to read system property ".concat(str), e2);
            return null;
        }
    }

    private static HashMap zzI() {
        int length = zzl.length;
        HashMap hashMap = new HashMap(r2 + 88);
        int i2 = 0;
        for (String str : Locale.getISOLanguages()) {
            try {
                String iSO3Language = new Locale(str).getISO3Language();
                if (!TextUtils.isEmpty(iSO3Language)) {
                    hashMap.put(iSO3Language, str);
                }
            } catch (MissingResourceException unused) {
            }
        }
        while (true) {
            String[] strArr = zzl;
            int length2 = strArr.length;
            if (i2 >= 88) {
                return hashMap;
            }
            hashMap.put(strArr[i2], strArr[i2 + 1]);
            i2 += 2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0015  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zza(long[] r3, long r4, boolean r6, boolean r7) {
        /*
            int r7 = java.util.Arrays.binarySearch(r3, r4)
            if (r7 >= 0) goto L_0x0008
            int r3 = ~r7
            goto L_0x0016
        L_0x0008:
            int r7 = r7 + 1
            int r0 = r3.length
            if (r7 >= r0) goto L_0x0013
            r0 = r3[r7]
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0008
        L_0x0013:
            if (r6 != 0) goto L_0x0017
            r3 = r7
        L_0x0016:
            return r3
        L_0x0017:
            int r7 = r7 + -1
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfj.zza(long[], long, boolean, boolean):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0014  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzb(int[] r2, int r3, boolean r4, boolean r5) {
        /*
            int r0 = java.util.Arrays.binarySearch(r2, r3)
            if (r0 >= 0) goto L_0x000a
            int r0 = r0 + 2
            int r2 = -r0
            goto L_0x0018
        L_0x000a:
            int r0 = r0 + -1
            if (r0 < 0) goto L_0x0012
            r1 = r2[r0]
            if (r1 == r3) goto L_0x000a
        L_0x0012:
            if (r4 == 0) goto L_0x0017
            int r2 = r0 + 1
            goto L_0x0018
        L_0x0017:
            r2 = r0
        L_0x0018:
            if (r5 == 0) goto L_0x001f
            r3 = 0
            int r2 = java.lang.Math.max(r3, r2)
        L_0x001f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfj.zzb(int[], int, boolean, boolean):int");
    }

    public static int zzc(long[] jArr, long j2, boolean z2, boolean z3) {
        int i2;
        int binarySearch = Arrays.binarySearch(jArr, j2);
        if (binarySearch < 0) {
            i2 = -(binarySearch + 2);
        } else {
            do {
                binarySearch--;
                if (binarySearch < 0 || jArr[binarySearch] != j2) {
                    i2 = binarySearch + 1;
                }
                binarySearch--;
                break;
            } while (jArr[binarySearch] != j2);
            i2 = binarySearch + 1;
        }
        if (z3) {
            return Math.max(0, i2);
        }
        return i2;
    }

    public static int zzd(byte[] bArr, int i2, int i3, int i4) {
        while (i2 < i3) {
            i4 = zzn[(i4 >>> 24) ^ (bArr[i2] & 255)] ^ (i4 << 8);
            i2++;
        }
        return i4;
    }

    public static int zze(byte[] bArr, int i2, int i3, int i4) {
        int i5 = 0;
        while (i2 < i3) {
            i5 = zzo[i5 ^ (bArr[i2] & 255)];
            i2++;
        }
        return i5;
    }

    @SuppressLint({"InlinedApi"})
    public static int zzf(int i2) {
        switch (i2) {
            case 1:
                return 4;
            case 2:
                return 12;
            case 3:
                return 28;
            case 4:
                return 204;
            case 5:
                return Sdk$SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE;
            case 6:
                return 252;
            case 7:
                return 1276;
            case 8:
                break;
            case 10:
                if (zza >= 32) {
                    return 737532;
                }
                break;
            case 12:
                return 743676;
            default:
                return 0;
        }
        return 6396;
    }

    public static int zzg(ByteBuffer byteBuffer, int i2) {
        int i3 = byteBuffer.getInt(i2);
        if (byteBuffer.order() == ByteOrder.BIG_ENDIAN) {
            return i3;
        }
        return Integer.reverseBytes(i3);
    }

    public static int zzh(int i2) {
        if (i2 == 2 || i2 == 4) {
            return 6005;
        }
        if (i2 == 10) {
            return 6004;
        }
        if (i2 == 7) {
            return 6005;
        }
        if (i2 == 8) {
            return AdError.AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE;
        }
        switch (i2) {
            case 15:
                return AdError.AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE;
            case 16:
            case 18:
                return 6005;
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
                return 6004;
            default:
                switch (i2) {
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                        return AdError.ICONVIEW_MISSING_ERROR_CODE;
                    default:
                        return 6006;
                }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0004, code lost:
        r4 = r4.split("_", -1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzi(java.lang.String r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = "_"
            r2 = -1
            java.lang.String[] r4 = r4.split(r1, r2)
            int r1 = r4.length
            r2 = 2
            if (r1 >= r2) goto L_0x0010
            return r0
        L_0x0010:
            int r2 = r1 + -1
            r2 = r4[r2]
            r3 = 3
            if (r1 < r3) goto L_0x0025
            int r1 = r1 + -2
            r4 = r4[r1]
            java.lang.String r1 = "neg"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x0025
            r4 = 1
            goto L_0x0026
        L_0x0025:
            r4 = 0
        L_0x0026:
            r2.getClass()
            int r0 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x0031 }
            if (r4 == 0) goto L_0x0031
            int r4 = -r0
            return r4
        L_0x0031:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfj.zzi(java.lang.String):int");
    }

    public static int zzj(int i2) {
        if (i2 == 8) {
            return 3;
        }
        if (i2 == 16) {
            return 2;
        }
        if (i2 != 24) {
            return i2 != 32 ? 0 : 805306368;
        }
        return 536870912;
    }

    public static int zzk(int i2, int i3) {
        if (i2 != 2) {
            if (i2 == 3) {
                return i3;
            }
            if (i2 != 4) {
                if (i2 != 268435456) {
                    if (i2 == 536870912) {
                        return i3 * 3;
                    }
                    if (i2 != 805306368) {
                        throw new IllegalArgumentException();
                    }
                }
            }
            return i3 * 4;
        }
        return i3 + i3;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzl(android.net.Uri r7) {
        /*
            java.lang.String r0 = r7.getScheme()
            r1 = 3
            if (r0 == 0) goto L_0x0011
            java.lang.String r2 = "rtsp"
            boolean r0 = com.google.android.gms.internal.ads.zzfon.zzc(r2, r0)
            if (r0 != 0) goto L_0x0010
            goto L_0x0011
        L_0x0010:
            return r1
        L_0x0011:
            java.lang.String r0 = r7.getLastPathSegment()
            r2 = 4
            if (r0 != 0) goto L_0x0019
            return r2
        L_0x0019:
            r3 = 46
            int r3 = r0.lastIndexOf(r3)
            r4 = 0
            r5 = 2
            r6 = 1
            if (r3 < 0) goto L_0x0071
            int r3 = r3 + r6
            java.lang.String r0 = r0.substring(r3)
            java.lang.String r0 = com.google.android.gms.internal.ads.zzfon.zza(r0)
            int r3 = r0.hashCode()
            switch(r3) {
                case 104579: goto L_0x0053;
                case 108321: goto L_0x0049;
                case 3242057: goto L_0x003f;
                case 3299913: goto L_0x0035;
                default: goto L_0x0034;
            }
        L_0x0034:
            goto L_0x005d
        L_0x0035:
            java.lang.String r3 = "m3u8"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x005d
            r0 = 1
            goto L_0x005e
        L_0x003f:
            java.lang.String r3 = "isml"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x005d
            r0 = 3
            goto L_0x005e
        L_0x0049:
            java.lang.String r3 = "mpd"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x005d
            r0 = 0
            goto L_0x005e
        L_0x0053:
            java.lang.String r3 = "ism"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x005d
            r0 = 2
            goto L_0x005e
        L_0x005d:
            r0 = -1
        L_0x005e:
            if (r0 == 0) goto L_0x006c
            if (r0 == r6) goto L_0x006a
            if (r0 == r5) goto L_0x0068
            if (r0 == r1) goto L_0x0068
            r0 = 4
            goto L_0x006d
        L_0x0068:
            r0 = 1
            goto L_0x006d
        L_0x006a:
            r0 = 2
            goto L_0x006d
        L_0x006c:
            r0 = 0
        L_0x006d:
            if (r0 != r2) goto L_0x0070
            goto L_0x0071
        L_0x0070:
            return r0
        L_0x0071:
            java.util.regex.Pattern r0 = zzj
            java.lang.String r7 = r7.getPath()
            r7.getClass()
            java.util.regex.Matcher r7 = r0.matcher(r7)
            boolean r0 = r7.matches()
            if (r0 == 0) goto L_0x009d
            java.lang.String r7 = r7.group(r5)
            if (r7 == 0) goto L_0x009c
            java.lang.String r0 = "format=mpd-time-csf"
            boolean r0 = r7.contains(r0)
            if (r0 == 0) goto L_0x0093
            return r4
        L_0x0093:
            java.lang.String r0 = "format=m3u8-aapl"
            boolean r7 = r7.contains(r0)
            if (r7 == 0) goto L_0x009c
            return r5
        L_0x009c:
            return r6
        L_0x009d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfj.zzl(android.net.Uri):int");
    }

    public static long zzm(long j2, float f2) {
        return f2 == 1.0f ? j2 : Math.round(((double) j2) * ((double) f2));
    }

    public static long zzn(long j2, float f2) {
        return f2 == 1.0f ? j2 : Math.round(((double) j2) / ((double) f2));
    }

    public static long zzo(long j2) {
        return (j2 == -9223372036854775807L || j2 == Long.MIN_VALUE) ? j2 : j2 * 1000;
    }

    public static long zzp(long j2, long j3, long j4) {
        int i2 = (j4 > j3 ? 1 : (j4 == j3 ? 0 : -1));
        if (i2 >= 0 && j4 % j3 == 0) {
            return j2 / (j4 / j3);
        }
        if (i2 >= 0 || j3 % j4 != 0) {
            return (long) (((double) j2) * (((double) j3) / ((double) j4)));
        }
        return j2 * (j3 / j4);
    }

    public static long zzq(long j2) {
        return (j2 == -9223372036854775807L || j2 == Long.MIN_VALUE) ? j2 : j2 / 1000;
    }

    public static Point zzr(Context context) {
        Display display;
        String str;
        DisplayManager displayManager = (DisplayManager) context.getSystemService(ViewProps.DISPLAY);
        if (displayManager != null) {
            display = displayManager.getDisplay(0);
        } else {
            display = null;
        }
        if (display == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            windowManager.getClass();
            display = windowManager.getDefaultDisplay();
        }
        if (display.getDisplayId() == 0 && zzE(context)) {
            if (zza < 28) {
                str = zzH("sys.display-size");
            } else {
                str = zzH("vendor.display-size");
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    String[] split = str.trim().split("x", -1);
                    if (split.length == 2) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        if (parseInt > 0 && parseInt2 > 0) {
                            return new Point(parseInt, parseInt2);
                        }
                    }
                } catch (NumberFormatException unused) {
                }
                zzer.zzc("Util", "Invalid display size: ".concat(String.valueOf(str)));
            }
            if ("Sony".equals(zzc) && zzd.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new Point(3840, 2160);
            }
        }
        Point point = new Point();
        if (zza >= 23) {
            Display.Mode a2 = display.getMode();
            point.x = a2.getPhysicalWidth();
            point.y = a2.getPhysicalHeight();
            return point;
        }
        display.getRealSize(point);
        return point;
    }

    public static AudioFormat zzs(int i2, int i3, int i4) {
        return new AudioFormat.Builder().setSampleRate(i2).setChannelMask(i3).setEncoding(i4).build();
    }

    public static Handler zzt(Handler.Callback callback) {
        Looper myLooper = Looper.myLooper();
        zzdy.zzb(myLooper);
        return new Handler(myLooper, (Handler.Callback) null);
    }

    public static Looper zzu() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            return myLooper;
        }
        return Looper.getMainLooper();
    }

    public static zzam zzv(int i2, int i3, int i4) {
        zzak zzak = new zzak();
        zzak.zzS("audio/raw");
        zzak.zzw(i3);
        zzak.zzT(i4);
        zzak.zzN(i2);
        return zzak.zzY();
    }

    public static String zzw(byte[] bArr, int i2, int i3) {
        return new String(bArr, i2, i3, zzfot.zzc);
    }

    public static String zzx(Locale locale) {
        if (zza >= 21) {
            return locale.toLanguageTag();
        }
        return locale.toString();
    }

    public static String zzy(int i2) {
        switch (i2) {
            case -2:
                return "none";
            case -1:
                return "unknown";
            case 0:
                return Constants.COLLATION_DEFAULT;
            case 1:
                return MimeTypes.BASE_TYPE_AUDIO;
            case 2:
                return MimeTypes.BASE_TYPE_VIDEO;
            case 3:
                return "text";
            case 4:
                return "image";
            case 5:
                return "metadata";
            default:
                return "camera motion";
        }
    }

    public static String zzz(String str) {
        if (str == null) {
            return null;
        }
        String replace = str.replace('_', '-');
        if (!replace.isEmpty() && !replace.equals("und")) {
            str = replace;
        }
        String zza2 = zzfon.zza(str);
        int i2 = 0;
        String str2 = zza2.split("-", 2)[0];
        if (zzk == null) {
            zzk = zzI();
        }
        String str3 = (String) zzk.get(str2);
        if (str3 != null) {
            zza2 = str3.concat(String.valueOf(zza2.substring(str2.length())));
            str2 = str3;
        }
        if (!"no".equals(str2) && !ContextChain.TAG_INFRA.equals(str2) && !"zh".equals(str2)) {
            return zza2;
        }
        while (true) {
            String[] strArr = zzm;
            int length = strArr.length;
            if (i2 >= 18) {
                return zza2;
            }
            if (zza2.startsWith(strArr[i2])) {
                return String.valueOf(strArr[i2 + 1]).concat(String.valueOf(zza2.substring(strArr[i2].length())));
            }
            i2 += 2;
        }
    }
}
