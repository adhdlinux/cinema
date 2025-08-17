package com.google.android.exoplayer2.util;

import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.hardware.display.DisplayManager;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.ads.AdError;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.hermes.intl.Constants;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.Player;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.common.base.Ascii;
import com.google.common.base.Charsets;
import com.google.protobuf.CodedOutputStream;
import com.startapp.de;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import com.unity3d.services.core.device.MimeTypes;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class Util {

    /* renamed from: a  reason: collision with root package name */
    public static final int f28808a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f28809b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f28810c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f28811d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f28812e;

    /* renamed from: f  reason: collision with root package name */
    public static final byte[] f28813f = new byte[0];

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f28814g = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");

    /* renamed from: h  reason: collision with root package name */
    private static final Pattern f28815h = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");

    /* renamed from: i  reason: collision with root package name */
    private static final Pattern f28816i = Pattern.compile("%([A-Fa-f0-9]{2})");

    /* renamed from: j  reason: collision with root package name */
    private static final Pattern f28817j = Pattern.compile("(?:.*\\.)?isml?(?:/(manifest(.*))?)?", 2);

    /* renamed from: k  reason: collision with root package name */
    private static HashMap<String, String> f28818k;

    /* renamed from: l  reason: collision with root package name */
    private static final String[] f28819l = {"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", de.f34377a, "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "arb", "ar-arb", ScarConstants.IN_SIGNAL_KEY, "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};

    /* renamed from: m  reason: collision with root package name */
    private static final String[] f28820m = {"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};

    /* renamed from: n  reason: collision with root package name */
    private static final int[] f28821n;

    /* renamed from: o  reason: collision with root package name */
    private static final int[] f28822o;

    private static final class Api21 {
        private Api21() {
        }

        public static Drawable a(Context context, Resources resources, int i2) {
            return resources.getDrawable(i2, context.getTheme());
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        f28808a = i2;
        String str = Build.DEVICE;
        f28809b = str;
        String str2 = Build.MANUFACTURER;
        f28810c = str2;
        String str3 = Build.MODEL;
        f28811d = str3;
        f28812e = str + ", " + str3 + ", " + str2 + ", " + i2;
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
        f28821n = iArr;
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
        f28822o = iArr2;
    }

    private Util() {
    }

    private static HashMap<String, String> A() {
        String[] iSOLanguages = Locale.getISOLanguages();
        HashMap<String, String> hashMap = new HashMap<>(iSOLanguages.length + f28819l.length);
        int i2 = 0;
        for (String str : iSOLanguages) {
            try {
                String iSO3Language = new Locale(str).getISO3Language();
                if (!TextUtils.isEmpty(iSO3Language)) {
                    hashMap.put(iSO3Language, str);
                }
            } catch (MissingResourceException unused) {
            }
        }
        while (true) {
            String[] strArr = f28819l;
            if (i2 >= strArr.length) {
                return hashMap;
            }
            hashMap.put(strArr[i2], strArr[i2 + 1]);
            i2 += 2;
        }
    }

    public static boolean A0(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
        if (uiModeManager == null || uiModeManager.getCurrentModeType() != 4) {
            return false;
        }
        return true;
    }

    public static Uri B(Uri uri) {
        String path = uri.getPath();
        if (path == null) {
            return uri;
        }
        Matcher matcher = f28817j.matcher(path);
        if (!matcher.matches() || matcher.group(1) != null) {
            return uri;
        }
        return Uri.withAppendedPath(uri, "Manifest");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Thread B0(String str, Runnable runnable) {
        return new Thread(runnable, str);
    }

    public static String C(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static int C0(int[] iArr, int i2) {
        for (int i3 = 0; i3 < iArr.length; i3++) {
            if (iArr[i3] == i2) {
                return i3;
            }
        }
        return -1;
    }

    public static String D(byte[] bArr) {
        return new String(bArr, Charsets.UTF_8);
    }

    private static String D0(String str) {
        int i2 = 0;
        while (true) {
            String[] strArr = f28820m;
            if (i2 >= strArr.length) {
                return str;
            }
            if (str.startsWith(strArr[i2])) {
                return strArr[i2 + 1] + str.substring(strArr[i2].length());
            }
            i2 += 2;
        }
    }

    public static String E(byte[] bArr, int i2, int i3) {
        return new String(bArr, i2, i3, Charsets.UTF_8);
    }

    public static <T> void E0(List<T> list, int i2, int i3, int i4) {
        ArrayDeque arrayDeque = new ArrayDeque();
        for (int i5 = (i3 - i2) - 1; i5 >= 0; i5--) {
            arrayDeque.addFirst(list.remove(i2 + i5));
        }
        list.addAll(Math.min(i4, list.size()), arrayDeque);
    }

    public static int F(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (audioManager == null) {
            return -1;
        }
        return audioManager.generateAudioSessionId();
    }

    public static long F0(long j2) {
        return (j2 == -9223372036854775807L || j2 == Long.MIN_VALUE) ? j2 : j2 * 1000;
    }

    @SuppressLint({"InlinedApi"})
    public static int G(int i2) {
        if (i2 == 12) {
            return 743676;
        }
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
                return 6396;
            default:
                return 0;
        }
    }

    public static ExecutorService G0(String str) {
        return Executors.newSingleThreadExecutor(new f(str));
    }

    public static Player.Commands H(Player player, Player.Commands commands) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean f2 = player.f();
        boolean L = player.L();
        boolean H = player.H();
        boolean n2 = player.n();
        boolean U = player.U();
        boolean r2 = player.r();
        boolean u2 = player.t().u();
        Player.Commands.Builder d2 = new Player.Commands.Builder().b(commands).d(4, !f2);
        boolean z8 = false;
        if (!L || f2) {
            z2 = false;
        } else {
            z2 = true;
        }
        Player.Commands.Builder d3 = d2.d(5, z2);
        if (!H || f2) {
            z3 = false;
        } else {
            z3 = true;
        }
        Player.Commands.Builder d4 = d3.d(6, z3);
        if (u2 || ((!H && U && !L) || f2)) {
            z4 = false;
        } else {
            z4 = true;
        }
        Player.Commands.Builder d5 = d4.d(7, z4);
        if (!n2 || f2) {
            z5 = false;
        } else {
            z5 = true;
        }
        Player.Commands.Builder d6 = d5.d(8, z5);
        if (u2 || ((!n2 && (!U || !r2)) || f2)) {
            z6 = false;
        } else {
            z6 = true;
        }
        Player.Commands.Builder d7 = d6.d(9, z6).d(10, !f2);
        if (!L || f2) {
            z7 = false;
        } else {
            z7 = true;
        }
        Player.Commands.Builder d8 = d7.d(11, z7);
        if (L && !f2) {
            z8 = true;
        }
        return d8.d(12, z8).e();
    }

    public static String H0(String str) {
        if (str == null) {
            return null;
        }
        String replace = str.replace('_', '-');
        if (!replace.isEmpty() && !replace.equals("und")) {
            str = replace;
        }
        String e2 = Ascii.e(str);
        String str2 = X0(e2, "-")[0];
        if (f28818k == null) {
            f28818k = A();
        }
        String str3 = f28818k.get(str2);
        if (str3 != null) {
            e2 = str3 + e2.substring(str2.length());
            str2 = str3;
        }
        if ("no".equals(str2) || ContextChain.TAG_INFRA.equals(str2) || "zh".equals(str2)) {
            return D0(e2);
        }
        return e2;
    }

    public static int I(ByteBuffer byteBuffer, int i2) {
        int i3 = byteBuffer.getInt(i2);
        if (byteBuffer.order() == ByteOrder.BIG_ENDIAN) {
            return i3;
        }
        return Integer.reverseBytes(i3);
    }

    public static <T> T[] I0(T[] tArr, T t2) {
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length + 1);
        copyOf[tArr.length] = t2;
        return k(copyOf);
    }

    public static byte[] J(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) ((Character.digit(str.charAt(i3), 16) << 4) + Character.digit(str.charAt(i3 + 1), 16));
        }
        return bArr;
    }

    public static <T> T[] J0(T[] tArr, T[] tArr2) {
        T[] copyOf = Arrays.copyOf(tArr, tArr.length + tArr2.length);
        System.arraycopy(tArr2, 0, copyOf, tArr.length, tArr2.length);
        return copyOf;
    }

    public static int K(String str, int i2) {
        int i3 = 0;
        for (String m2 : Y0(str)) {
            if (i2 == MimeTypes.m(m2)) {
                i3++;
            }
        }
        return i3;
    }

    public static <T> T[] K0(T[] tArr, int i2) {
        boolean z2;
        if (i2 <= tArr.length) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        return Arrays.copyOf(tArr, i2);
    }

    public static String L(String str, int i2) {
        String[] Y0 = Y0(str);
        if (Y0.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : Y0) {
            if (i2 == MimeTypes.m(str2)) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str2);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    public static <T> T[] L0(T[] tArr, int i2, int i3) {
        boolean z2;
        boolean z3 = true;
        if (i2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        if (i3 > tArr.length) {
            z3 = false;
        }
        Assertions.a(z3);
        return Arrays.copyOfRange(tArr, i2, i3);
    }

    public static String M(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < objArr.length; i2++) {
            sb.append(objArr[i2].getClass().getSimpleName());
            if (i2 < objArr.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public static long M0(String str) throws ParserException {
        Matcher matcher = f28814g.matcher(str);
        if (matcher.matches()) {
            int i2 = 0;
            if (matcher.group(9) != null && !matcher.group(9).equalsIgnoreCase("Z")) {
                i2 = (Integer.parseInt(matcher.group(12)) * 60) + Integer.parseInt(matcher.group(13));
                if ("-".equals(matcher.group(11))) {
                    i2 *= -1;
                }
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
            gregorianCalendar.clear();
            gregorianCalendar.set(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
            if (!TextUtils.isEmpty(matcher.group(8))) {
                gregorianCalendar.set(14, new BigDecimal("0." + matcher.group(8)).movePointRight(3).intValue());
            }
            long timeInMillis = gregorianCalendar.getTimeInMillis();
            if (i2 != 0) {
                return timeInMillis - (((long) i2) * 60000);
            }
            return timeInMillis;
        }
        throw ParserException.a("Invalid date/time format: " + str, (Throwable) null);
    }

    public static String N(Context context) {
        TelephonyManager telephonyManager;
        if (!(context == null || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null)) {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!TextUtils.isEmpty(networkCountryIso)) {
                return Ascii.f(networkCountryIso);
            }
        }
        return Ascii.f(Locale.getDefault().getCountry());
    }

    public static long N0(String str) {
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        Matcher matcher = f28815h.matcher(str);
        if (!matcher.matches()) {
            return (long) (Double.parseDouble(str) * 3600.0d * 1000.0d);
        }
        boolean isEmpty = true ^ TextUtils.isEmpty(matcher.group(1));
        String group = matcher.group(3);
        double d7 = 0.0d;
        if (group != null) {
            d2 = Double.parseDouble(group) * 3.1556908E7d;
        } else {
            d2 = 0.0d;
        }
        String group2 = matcher.group(5);
        if (group2 != null) {
            d3 = Double.parseDouble(group2) * 2629739.0d;
        } else {
            d3 = 0.0d;
        }
        double d8 = d2 + d3;
        String group3 = matcher.group(7);
        if (group3 != null) {
            d4 = Double.parseDouble(group3) * 86400.0d;
        } else {
            d4 = 0.0d;
        }
        double d9 = d8 + d4;
        String group4 = matcher.group(10);
        if (group4 != null) {
            d5 = Double.parseDouble(group4) * 3600.0d;
        } else {
            d5 = 0.0d;
        }
        double d10 = d9 + d5;
        String group5 = matcher.group(12);
        if (group5 != null) {
            d6 = Double.parseDouble(group5) * 60.0d;
        } else {
            d6 = 0.0d;
        }
        double d11 = d10 + d6;
        String group6 = matcher.group(14);
        if (group6 != null) {
            d7 = Double.parseDouble(group6);
        }
        long j2 = (long) ((d11 + d7) * 1000.0d);
        if (isEmpty) {
            return -j2;
        }
        return j2;
    }

    public static Point O(Context context) {
        Display display;
        DisplayManager displayManager;
        if (f28808a < 17 || (displayManager = (DisplayManager) context.getSystemService(ViewProps.DISPLAY)) == null) {
            display = null;
        } else {
            display = displayManager.getDisplay(0);
        }
        if (display == null) {
            display = ((WindowManager) Assertions.e((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
        }
        return P(context, display);
    }

    public static boolean O0(Handler handler, Runnable runnable) {
        if (!handler.getLooper().getThread().isAlive()) {
            return false;
        }
        if (handler.getLooper() != Looper.myLooper()) {
            return handler.post(runnable);
        }
        runnable.run();
        return true;
    }

    public static Point P(Context context, Display display) {
        String str;
        if (display.getDisplayId() == 0 && A0(context)) {
            if (f28808a < 28) {
                str = m0("sys.display-size");
            } else {
                str = m0("vendor.display-size");
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    String[] W0 = W0(str.trim(), "x");
                    if (W0.length == 2) {
                        int parseInt = Integer.parseInt(W0[0]);
                        int parseInt2 = Integer.parseInt(W0[1]);
                        if (parseInt > 0 && parseInt2 > 0) {
                            return new Point(parseInt, parseInt2);
                        }
                    }
                } catch (NumberFormatException unused) {
                }
                Log.c("Util", "Invalid display size: " + str);
            }
            if ("Sony".equals(f28810c) && f28811d.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new Point(3840, 2160);
            }
        }
        Point point = new Point();
        int i2 = f28808a;
        if (i2 >= 23) {
            U(display, point);
        } else if (i2 >= 17) {
            T(display, point);
        } else {
            S(display, point);
        }
        return point;
    }

    public static boolean P0(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    public static Looper Q() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            return myLooper;
        }
        return Looper.getMainLooper();
    }

    public static <T> void Q0(List<T> list, int i2, int i3) {
        if (i2 < 0 || i3 > list.size() || i2 > i3) {
            throw new IllegalArgumentException();
        } else if (i2 != i3) {
            list.subList(i2, i3).clear();
        }
    }

    public static Locale R() {
        return f28808a >= 24 ? Locale.getDefault(Locale.Category.DISPLAY) : Locale.getDefault();
    }

    public static long R0(long j2, long j3, long j4) {
        int i2 = (j4 > j3 ? 1 : (j4 == j3 ? 0 : -1));
        if (i2 >= 0 && j4 % j3 == 0) {
            return j2 / (j4 / j3);
        }
        if (i2 < 0 && j3 % j4 == 0) {
            return j2 * (j3 / j4);
        }
        return (long) (((double) j2) * (((double) j3) / ((double) j4)));
    }

    private static void S(Display display, Point point) {
        display.getSize(point);
    }

    public static long[] S0(List<Long> list, long j2, long j3) {
        int size = list.size();
        long[] jArr = new long[size];
        int i2 = 0;
        int i3 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
        if (i3 >= 0 && j3 % j2 == 0) {
            long j4 = j3 / j2;
            while (i2 < size) {
                jArr[i2] = list.get(i2).longValue() / j4;
                i2++;
            }
        } else if (i3 >= 0 || j2 % j3 != 0) {
            double d2 = ((double) j2) / ((double) j3);
            while (i2 < size) {
                jArr[i2] = (long) (((double) list.get(i2).longValue()) * d2);
                i2++;
            }
        } else {
            long j5 = j2 / j3;
            while (i2 < size) {
                jArr[i2] = list.get(i2).longValue() * j5;
                i2++;
            }
        }
        return jArr;
    }

    private static void T(Display display, Point point) {
        display.getRealSize(point);
    }

    public static void T0(long[] jArr, long j2, long j3) {
        int i2 = 0;
        int i3 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
        if (i3 >= 0 && j3 % j2 == 0) {
            long j4 = j3 / j2;
            while (i2 < jArr.length) {
                jArr[i2] = jArr[i2] / j4;
                i2++;
            }
        } else if (i3 >= 0 || j2 % j3 != 0) {
            double d2 = ((double) j2) / ((double) j3);
            while (i2 < jArr.length) {
                jArr[i2] = (long) (((double) jArr[i2]) * d2);
                i2++;
            }
        } else {
            long j5 = j2 / j3;
            while (i2 < jArr.length) {
                jArr[i2] = jArr[i2] * j5;
                i2++;
            }
        }
    }

    private static void U(Display display, Point point) {
        Display.Mode a2 = display.getMode();
        point.x = a2.getPhysicalWidth();
        point.y = a2.getPhysicalHeight();
    }

    public static void U0(Throwable th) {
        V0(th);
    }

    public static Drawable V(Context context, Resources resources, int i2) {
        if (f28808a >= 21) {
            return Api21.a(context, resources, i2);
        }
        return resources.getDrawable(i2);
    }

    private static <T extends Throwable> void V0(Throwable th) throws Throwable {
        throw th;
    }

    public static int W(int i2) {
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

    public static String[] W0(String str, String str2) {
        return str.split(str2, -1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0004, code lost:
        r5 = W0(r5, "_");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int X(java.lang.String r5) {
        /*
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = "_"
            java.lang.String[] r5 = W0(r5, r1)
            int r1 = r5.length
            r2 = 2
            if (r1 >= r2) goto L_0x000f
            return r0
        L_0x000f:
            int r3 = r1 + -1
            r3 = r5[r3]
            r4 = 3
            if (r1 < r4) goto L_0x0023
            int r1 = r1 - r2
            r5 = r5[r1]
            java.lang.String r1 = "neg"
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x0023
            r5 = 1
            goto L_0x0024
        L_0x0023:
            r5 = 0
        L_0x0024:
            java.lang.Object r1 = com.google.android.exoplayer2.util.Assertions.e(r3)     // Catch:{ NumberFormatException -> 0x0031 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ NumberFormatException -> 0x0031 }
            int r0 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x0031 }
            if (r5 == 0) goto L_0x0031
            int r0 = -r0
        L_0x0031:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.Util.X(java.lang.String):int");
    }

    public static String[] X0(String str, String str2) {
        return str.split(str2, 2);
    }

    public static String Y(int i2) {
        if (i2 == 0) {
            return "NO";
        }
        if (i2 == 1) {
            return "NO_UNSUPPORTED_TYPE";
        }
        if (i2 == 2) {
            return "NO_UNSUPPORTED_DRM";
        }
        if (i2 == 3) {
            return "NO_EXCEEDS_CAPABILITIES";
        }
        if (i2 == 4) {
            return "YES";
        }
        throw new IllegalStateException();
    }

    public static String[] Y0(String str) {
        if (TextUtils.isEmpty(str)) {
            return new String[0];
        }
        return W0(str.trim(), "(\\s*,\\s*)");
    }

    public static String Z(Locale locale) {
        return f28808a >= 21 ? a0(locale) : locale.toString();
    }

    public static ComponentName Z0(Context context, Intent intent) {
        if (f28808a >= 26) {
            return context.startForegroundService(intent);
        }
        return context.startService(intent);
    }

    private static String a0(Locale locale) {
        return locale.toLanguageTag();
    }

    public static long a1(long j2, long j3, long j4) {
        long j5 = j2 - j3;
        return ((j2 ^ j5) & (j3 ^ j2)) < 0 ? j4 : j5;
    }

    public static long b(long j2, long j3, long j4) {
        long j5 = j2 + j3;
        return ((j2 ^ j5) & (j3 ^ j5)) < 0 ? j4 : j5;
    }

    public static long b0(long j2, float f2) {
        return f2 == 1.0f ? j2 : Math.round(((double) j2) * ((double) f2));
    }

    public static boolean b1(SQLiteDatabase sQLiteDatabase, String str) {
        if (DatabaseUtils.queryNumEntries(sQLiteDatabase, "sqlite_master", "tbl_name = ?", new String[]{str}) > 0) {
            return true;
        }
        return false;
    }

    public static boolean c(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static long c0(long j2) {
        if (j2 == -9223372036854775807L) {
            return System.currentTimeMillis();
        }
        return j2 + SystemClock.elapsedRealtime();
    }

    public static byte[] c1(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T extends java.lang.Comparable<? super T>> int d(java.util.List<? extends java.lang.Comparable<? super T>> r3, T r4, boolean r5, boolean r6) {
        /*
            int r0 = java.util.Collections.binarySearch(r3, r4)
            if (r0 >= 0) goto L_0x0008
            int r4 = ~r0
            goto L_0x0023
        L_0x0008:
            int r1 = r3.size()
        L_0x000c:
            int r0 = r0 + 1
            if (r0 >= r1) goto L_0x001d
            java.lang.Object r2 = r3.get(r0)
            java.lang.Comparable r2 = (java.lang.Comparable) r2
            int r2 = r2.compareTo(r4)
            if (r2 != 0) goto L_0x001d
            goto L_0x000c
        L_0x001d:
            if (r5 == 0) goto L_0x0022
            int r4 = r0 + -1
            goto L_0x0023
        L_0x0022:
            r4 = r0
        L_0x0023:
            if (r6 == 0) goto L_0x002f
            int r3 = r3.size()
            int r3 = r3 + -1
            int r4 = java.lang.Math.min(r3, r4)
        L_0x002f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.Util.d(java.util.List, java.lang.Comparable, boolean, boolean):int");
    }

    public static int d0(int i2) {
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

    public static String d1(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            sb.append(Character.forDigit((bArr[i2] >> 4) & 15, 16));
            sb.append(Character.forDigit(bArr[i2] & 15, 16));
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0016  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0019  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int e(long[] r4, long r5, boolean r7, boolean r8) {
        /*
            int r0 = java.util.Arrays.binarySearch(r4, r5)
            if (r0 >= 0) goto L_0x0008
            int r5 = ~r0
            goto L_0x001a
        L_0x0008:
            int r0 = r0 + 1
            int r1 = r4.length
            if (r0 >= r1) goto L_0x0014
            r1 = r4[r0]
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 != 0) goto L_0x0014
            goto L_0x0008
        L_0x0014:
            if (r7 == 0) goto L_0x0019
            int r5 = r0 + -1
            goto L_0x001a
        L_0x0019:
            r5 = r0
        L_0x001a:
            if (r8 == 0) goto L_0x0023
            int r4 = r4.length
            int r4 = r4 + -1
            int r5 = java.lang.Math.min(r4, r5)
        L_0x0023:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.Util.e(long[], long, boolean, boolean):int");
    }

    public static Format e0(int i2, int i3, int i4) {
        return new Format.Builder().g0("audio/raw").J(i3).h0(i4).a0(i2).G();
    }

    public static long e1(int i2, int i3) {
        return f1(i3) | (f1(i2) << 32);
    }

    public static int f(LongArray longArray, long j2, boolean z2, boolean z3) {
        int i2;
        int c2 = longArray.c() - 1;
        int i3 = 0;
        while (i3 <= c2) {
            int i4 = (i3 + c2) >>> 1;
            if (longArray.b(i4) < j2) {
                i3 = i4 + 1;
            } else {
                c2 = i4 - 1;
            }
        }
        if (z2 && (i2 = c2 + 1) < longArray.c() && longArray.b(i2) == j2) {
            return i2;
        }
        if (!z3 || c2 != -1) {
            return c2;
        }
        return 0;
    }

    public static int f0(int i2, int i3) {
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
        return i3 * 2;
    }

    public static long f1(int i2) {
        return ((long) i2) & 4294967295L;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x001d  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0020  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T extends java.lang.Comparable<? super T>> int g(java.util.List<? extends java.lang.Comparable<? super T>> r2, T r3, boolean r4, boolean r5) {
        /*
            int r0 = java.util.Collections.binarySearch(r2, r3)
            if (r0 >= 0) goto L_0x000a
            int r0 = r0 + 2
            int r2 = -r0
            goto L_0x0021
        L_0x000a:
            int r0 = r0 + -1
            if (r0 < 0) goto L_0x001b
            java.lang.Object r1 = r2.get(r0)
            java.lang.Comparable r1 = (java.lang.Comparable) r1
            int r1 = r1.compareTo(r3)
            if (r1 != 0) goto L_0x001b
            goto L_0x000a
        L_0x001b:
            if (r4 == 0) goto L_0x0020
            int r2 = r0 + 1
            goto L_0x0021
        L_0x0020:
            r2 = r0
        L_0x0021:
            if (r5 == 0) goto L_0x0028
            r3 = 0
            int r2 = java.lang.Math.max(r3, r2)
        L_0x0028:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.Util.g(java.util.List, java.lang.Comparable, boolean, boolean):int");
    }

    public static long g0(long j2, float f2) {
        return f2 == 1.0f ? j2 : Math.round(((double) j2) / ((double) f2));
    }

    public static CharSequence g1(CharSequence charSequence, int i2) {
        return charSequence.length() <= i2 ? charSequence : charSequence.subSequence(0, i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0015  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int h(int[] r2, int r3, boolean r4, boolean r5) {
        /*
            int r0 = java.util.Arrays.binarySearch(r2, r3)
            if (r0 >= 0) goto L_0x000a
            int r0 = r0 + 2
            int r2 = -r0
            goto L_0x0019
        L_0x000a:
            int r0 = r0 + -1
            if (r0 < 0) goto L_0x0013
            r1 = r2[r0]
            if (r1 != r3) goto L_0x0013
            goto L_0x000a
        L_0x0013:
            if (r4 == 0) goto L_0x0018
            int r2 = r0 + 1
            goto L_0x0019
        L_0x0018:
            r2 = r0
        L_0x0019:
            if (r5 == 0) goto L_0x0020
            r3 = 0
            int r2 = java.lang.Math.max(r3, r2)
        L_0x0020:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.Util.h(int[], int, boolean, boolean):int");
    }

    public static int h0(int i2) {
        if (i2 == 13) {
            return 1;
        }
        switch (i2) {
            case 2:
                return 0;
            case 3:
                return 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            default:
                return 3;
        }
    }

    public static String h1(String str) {
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (str.charAt(i4) == '%') {
                i3++;
            }
        }
        if (i3 == 0) {
            return str;
        }
        int i5 = length - (i3 * 2);
        StringBuilder sb = new StringBuilder(i5);
        Matcher matcher = f28816i.matcher(str);
        while (i3 > 0 && matcher.find()) {
            sb.append(str, i2, matcher.start());
            sb.append((char) Integer.parseInt((String) Assertions.e(matcher.group(1)), 16));
            i2 = matcher.end();
            i3--;
        }
        if (i2 < length) {
            sb.append(str, i2, length);
        }
        if (sb.length() != i5) {
            return null;
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0017  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int i(long[] r4, long r5, boolean r7, boolean r8) {
        /*
            int r0 = java.util.Arrays.binarySearch(r4, r5)
            if (r0 >= 0) goto L_0x000a
            int r0 = r0 + 2
            int r4 = -r0
            goto L_0x001b
        L_0x000a:
            int r0 = r0 + -1
            if (r0 < 0) goto L_0x0015
            r1 = r4[r0]
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 != 0) goto L_0x0015
            goto L_0x000a
        L_0x0015:
            if (r7 == 0) goto L_0x001a
            int r4 = r0 + 1
            goto L_0x001b
        L_0x001a:
            r4 = r0
        L_0x001b:
            if (r8 == 0) goto L_0x0022
            r5 = 0
            int r4 = java.lang.Math.max(r5, r4)
        L_0x0022:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.Util.i(long[], long, boolean, boolean):int");
    }

    public static String i0(StringBuilder sb, Formatter formatter, long j2) {
        String str;
        if (j2 == -9223372036854775807L) {
            j2 = 0;
        }
        if (j2 < 0) {
            str = "-";
        } else {
            str = "";
        }
        long abs = (Math.abs(j2) + 500) / 1000;
        long j3 = abs % 60;
        long j4 = (abs / 60) % 60;
        long j5 = abs / 3600;
        sb.setLength(0);
        if (j5 > 0) {
            return formatter.format("%s%d:%02d:%02d", new Object[]{str, Long.valueOf(j5), Long.valueOf(j4), Long.valueOf(j3)}).toString();
        }
        return formatter.format("%s%02d:%02d", new Object[]{str, Long.valueOf(j4), Long.valueOf(j3)}).toString();
    }

    public static long i1(long j2) {
        return (j2 == -9223372036854775807L || j2 == Long.MIN_VALUE) ? j2 : j2 / 1000;
    }

    @EnsuresNonNull({"#1"})
    public static <T> T j(T t2) {
        return t2;
    }

    public static String[] j0() {
        String[] k02 = k0();
        for (int i2 = 0; i2 < k02.length; i2++) {
            k02[i2] = H0(k02[i2]);
        }
        return k02;
    }

    public static void j1(Parcel parcel, boolean z2) {
        parcel.writeInt(z2 ? 1 : 0);
    }

    @EnsuresNonNull({"#1"})
    public static <T> T[] k(T[] tArr) {
        return tArr;
    }

    private static String[] k0() {
        Configuration configuration = Resources.getSystem().getConfiguration();
        if (f28808a >= 24) {
            return l0(configuration);
        }
        return new String[]{Z(configuration.locale)};
    }

    public static int l(int i2, int i3) {
        return ((i2 + i3) - 1) / i3;
    }

    private static String[] l0(Configuration configuration) {
        return W0(configuration.getLocales().toLanguageTags(), ",");
    }

    public static long m(long j2, long j3) {
        return ((j2 + j3) - 1) / j3;
    }

    private static String m0(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{str});
        } catch (Exception e2) {
            Log.d("Util", "Failed to read system property " + str, e2);
            return null;
        }
    }

    public static void n(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String n0(int i2) {
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
            case 6:
                return "camera motion";
            default:
                if (i2 < 10000) {
                    return "?";
                }
                return "custom (" + i2 + ")";
        }
    }

    public static int o(long j2, long j3) {
        int i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
        if (i2 < 0) {
            return -1;
        }
        return i2 == 0 ? 0 : 1;
    }

    public static String o0(Context context, String str) {
        String str2;
        try {
            str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "?";
        }
        return str + "/" + str2 + " (Linux;Android " + Build.VERSION.RELEASE + ") " + "ExoPlayerLib/2.18.7";
    }

    public static float p(float f2, float f3, float f4) {
        return Math.max(f3, Math.min(f2, f4));
    }

    public static byte[] p0(String str) {
        return str.getBytes(Charsets.UTF_8);
    }

    public static int q(int i2, int i3, int i4) {
        return Math.max(i3, Math.min(i2, i4));
    }

    public static int q0(Uri uri) {
        int r02;
        String scheme = uri.getScheme();
        if (scheme != null && Ascii.a("rtsp", scheme)) {
            return 3;
        }
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return 4;
        }
        int lastIndexOf = lastPathSegment.lastIndexOf(46);
        if (lastIndexOf >= 0 && (r02 = r0(lastPathSegment.substring(lastIndexOf + 1))) != 4) {
            return r02;
        }
        Matcher matcher = f28817j.matcher((CharSequence) Assertions.e(uri.getPath()));
        if (!matcher.matches()) {
            return 4;
        }
        String group = matcher.group(2);
        if (group != null) {
            if (group.contains("format=mpd-time-csf")) {
                return 0;
            }
            if (group.contains("format=m3u8-aapl")) {
                return 2;
            }
        }
        return 1;
    }

    public static long r(long j2, long j3, long j4) {
        return Math.max(j3, Math.min(j2, j4));
    }

    public static int r0(String str) {
        String e2 = Ascii.e(str);
        e2.hashCode();
        char c2 = 65535;
        switch (e2.hashCode()) {
            case 104579:
                if (e2.equals("ism")) {
                    c2 = 0;
                    break;
                }
                break;
            case 108321:
                if (e2.equals("mpd")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3242057:
                if (e2.equals("isml")) {
                    c2 = 2;
                    break;
                }
                break;
            case 3299913:
                if (e2.equals("m3u8")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 2:
                return 1;
            case 1:
                return 0;
            case 3:
                return 2;
            default:
                return 4;
        }
    }

    public static boolean s(Object[] objArr, Object obj) {
        for (Object c2 : objArr) {
            if (c(c2, obj)) {
                return true;
            }
        }
        return false;
    }

    public static int s0(Uri uri, String str) {
        if (str == null) {
            return q0(uri);
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -979127466:
                if (str.equals("application/x-mpegURL")) {
                    c2 = 0;
                    break;
                }
                break;
            case -156749520:
                if (str.equals("application/vnd.ms-sstr+xml")) {
                    c2 = 1;
                    break;
                }
                break;
            case 64194685:
                if (str.equals("application/dash+xml")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1154777587:
                if (str.equals("application/x-rtsp")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 2;
            case 1:
                return 1;
            case 2:
                return 0;
            case 3:
                return 3;
            default:
                return 4;
        }
    }

    public static int t(byte[] bArr, int i2, int i3, int i4) {
        while (i2 < i3) {
            i4 = f28821n[((i4 >>> 24) ^ (bArr[i2] & 255)) & 255] ^ (i4 << 8);
            i2++;
        }
        return i4;
    }

    public static boolean t0(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, Inflater inflater) {
        if (parsableByteArray.a() <= 0) {
            return false;
        }
        if (parsableByteArray2.b() < parsableByteArray.a()) {
            parsableByteArray2.c(parsableByteArray.a() * 2);
        }
        if (inflater == null) {
            inflater = new Inflater();
        }
        inflater.setInput(parsableByteArray.e(), parsableByteArray.f(), parsableByteArray.a());
        int i2 = 0;
        while (true) {
            try {
                i2 += inflater.inflate(parsableByteArray2.e(), i2, parsableByteArray2.b() - i2);
                if (inflater.finished()) {
                    parsableByteArray2.T(i2);
                    inflater.reset();
                    return true;
                } else if (inflater.needsDictionary()) {
                    break;
                } else if (inflater.needsInput()) {
                    break;
                } else if (i2 == parsableByteArray2.b()) {
                    parsableByteArray2.c(parsableByteArray2.b() * 2);
                }
            } catch (DataFormatException unused) {
                return false;
            } finally {
                inflater.reset();
            }
        }
        return false;
    }

    public static int u(byte[] bArr, int i2, int i3, int i4) {
        while (i2 < i3) {
            i4 = f28822o[i4 ^ (bArr[i2] & 255)];
            i2++;
        }
        return i4;
    }

    public static String u0(int i2) {
        return Integer.toString(i2, 36);
    }

    public static Handler v(Looper looper, Handler.Callback callback) {
        return new Handler(looper, callback);
    }

    public static boolean v0(Context context) {
        if (f28808a < 23 || !context.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) {
            return false;
        }
        return true;
    }

    public static Handler w() {
        return x((Handler.Callback) null);
    }

    public static boolean w0(int i2) {
        return i2 == 536870912 || i2 == 805306368 || i2 == 4;
    }

    public static Handler x(Handler.Callback callback) {
        return v((Looper) Assertions.i(Looper.myLooper()), callback);
    }

    public static boolean x0(int i2) {
        return i2 == 3 || i2 == 2 || i2 == 268435456 || i2 == 536870912 || i2 == 805306368 || i2 == 4;
    }

    public static Handler y() {
        return z((Handler.Callback) null);
    }

    public static boolean y0(int i2) {
        return i2 == 10 || i2 == 13;
    }

    public static Handler z(Handler.Callback callback) {
        return v(Q(), callback);
    }

    public static boolean z0(Uri uri) {
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme) || "file".equals(scheme)) {
            return true;
        }
        return false;
    }
}
