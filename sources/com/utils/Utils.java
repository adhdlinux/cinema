package com.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Point;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.ads.videoreward.AdsManager;
import com.facebook.common.util.UriUtil;
import com.facebook.hermes.intl.Constants;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.protobuf.CodedOutputStream;
import com.movie.FreeMoviesApp;
import com.movie.data.api.GlobalVariable;
import com.movie.data.model.ItemHelpCaptcha;
import com.movie.data.model.tmvdb.FindResult;
import com.movie.ui.activity.BarcodeActivity;
import com.movie.ui.activity.SplashActivity;
import com.movie.ui.activity.settings.SettingsActivity;
import com.original.tase.Logger;
import com.original.tase.debrid.alldebrid.AllDebridCredentialsHelper;
import com.original.tase.debrid.premiumize.PremiumizeCredentialsHelper;
import com.original.tase.debrid.realdebrid.RealDebridCredentialsHelper;
import com.original.tase.helper.DateTimeHelper;
import com.original.tase.helper.crypto.AESEncrypter;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.utils.Regex;
import com.startapp.ae;
import com.startapp.de;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import com.utils.Getlink.Provider.BaseProvider;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.yoku.marumovie.R;
import io.reactivex.disposables.CompositeDisposable;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.regex.Pattern;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import org.json.JSONObject;
import org.mozilla.universalchardet.CharsetListener;
import org.mozilla.universalchardet.UniversalDetector;
import timber.log.Timber;

public final class Utils {

    /* renamed from: a  reason: collision with root package name */
    public static int f37608a = 120;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f37609b = false;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f37610c = false;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f37611d = false;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f37612e = false;

    /* renamed from: f  reason: collision with root package name */
    public static final SimpleDateFormat f37613f = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

    /* renamed from: g  reason: collision with root package name */
    private static String f37614g = "key_pref_captcha";

    /* renamed from: h  reason: collision with root package name */
    public static ArrayList<ItemHelpCaptcha> f37615h;

    /* renamed from: i  reason: collision with root package name */
    public static WeakReference<CompositeDisposable> f37616i = null;

    /* renamed from: j  reason: collision with root package name */
    public static ArrayList<Integer> f37617j = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    public static final String f37618k = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download/cinemahd/%s/history-favorites");

    /* renamed from: l  reason: collision with root package name */
    public static boolean f37619l = false;

    /* renamed from: m  reason: collision with root package name */
    private static String f37620m = "";

    /* renamed from: n  reason: collision with root package name */
    private static WeakReference<Activity> f37621n = null;

    /* renamed from: o  reason: collision with root package name */
    public static String f37622o = "Cinema-AGENT";

    /* renamed from: p  reason: collision with root package name */
    private static WeakReference<Context> f37623p;

    /* renamed from: q  reason: collision with root package name */
    private static String f37624q = "";

    /* renamed from: r  reason: collision with root package name */
    private static int f37625r = -1;

    /* renamed from: s  reason: collision with root package name */
    public static LinkedHashMap<String, String> f37626s = new LinkedHashMap<>();

    /* renamed from: t  reason: collision with root package name */
    public static String f37627t = "";

    /* renamed from: u  reason: collision with root package name */
    private static String f37628u = "";

    /* renamed from: v  reason: collision with root package name */
    public static HashMap<Integer, String> f37629v = new HashMap<>();

    /* renamed from: w  reason: collision with root package name */
    public static int f37630w = 0;

    /* renamed from: x  reason: collision with root package name */
    private static final Pattern f37631x = Pattern.compile("[^\\w-]");

    /* renamed from: y  reason: collision with root package name */
    private static final Pattern f37632y = Pattern.compile("[\\s]");

    /* renamed from: com.utils.Utils$5  reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f37634a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.utils.Utils$RDTYPE[] r0 = com.utils.Utils.RDTYPE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f37634a = r0
                com.utils.Utils$RDTYPE r1 = com.utils.Utils.RDTYPE.REAL_DEBRID     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f37634a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.utils.Utils$RDTYPE r1 = com.utils.Utils.RDTYPE.ALL_DEBRID     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f37634a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.utils.Utils$RDTYPE r1 = com.utils.Utils.RDTYPE.PREMIUMIZE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.utils.Utils.AnonymousClass5.<clinit>():void");
        }
    }

    public enum RDTYPE {
        REAL_DEBRID,
        ALL_DEBRID,
        PREMIUMIZE
    }

    private Utils() {
        throw new AssertionError("No instances.");
    }

    public static Activity A() {
        WeakReference<Activity> weakReference = f37621n;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static void A0(final Activity activity, String str) {
        String str2;
        String str3;
        if (str.contains("429")) {
            str2 = "Error 429";
            str3 = "Many requests to premium server. \nYou can reduce it in Setting/Limit Request calls per second";
        } else if (str.contains("403")) {
            str2 = "Error 403";
            str3 = "Permission denied (or account locked).\nPlease check your subscription";
        } else if (str.contains("503")) {
            str2 = "Error 503";
            str3 = "Having issue with Premium server";
        } else if (str.contains("queued")) {
            str2 = "Download in Progress";
            str3 = "Real-Debrid is processing the torrent. Please try again later or choose another link.";
        } else {
            str3 = str;
            str2 = "Error";
        }
        new AlertDialog.Builder(activity).setTitle(str2).g(str3).b(false).l("Close", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        }).i("Setting", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                activity.startActivity(new Intent(activity, SettingsActivity.class));
            }
        }).q();
    }

    public static File B() {
        b0();
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).getAbsolutePath() + "/cinema/backup/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static ComponentName B0(Context context, Intent intent) {
        if (Util.f28808a >= 26) {
            return context.startForegroundService(intent);
        }
        return context.startService(intent);
    }

    public static String C() {
        if (f37620m.isEmpty()) {
            String str = Build.MANUFACTURER;
            String str2 = Build.MODEL;
            if (str2.startsWith(str)) {
                f37620m = i(str2);
            } else {
                f37620m = i(str) + "-" + str2;
            }
        }
        return f37620m;
    }

    public static void C0(Context context) {
        B0(context, MyUnboundService.a(context));
    }

    public static long D(File file) {
        long j2;
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            j2 = (statFs.getBlockSizeLong() * statFs.getBlockSizeLong()) / 50;
        } catch (IllegalArgumentException unused) {
            j2 = 10485760;
        }
        return Math.max(Math.min(j2, 52428800), 10485760);
    }

    public static void D0(Context context) {
        context.stopService(MyUnboundService.a(context));
    }

    public static Set<String> E() {
        return FreeMoviesApp.p().getStringSet("pref_choose_provider_disabled", new HashSet());
    }

    public static String F(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            Calendar instance = Calendar.getInstance();
            instance.setTime(f37613f.parse(str));
            return instance.getDisplayName(2, 2, Locale.ENGLISH) + " " + instance.get(1);
        } catch (ParseException e2) {
            Timber.e(e2, "Failed to parse release date.", new Object[0]);
            return "";
        }
    }

    public static String G() {
        String string = FreeMoviesApp.p().getString("pref_default_domain_gg_2", "");
        if (string.isEmpty()) {
            String a2 = a();
            Iterator<Map.Entry<String, String>> it2 = Q().entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry next = it2.next();
                if (a2.toLowerCase().equals((String) next.getKey())) {
                    string = (String) next.getValue();
                    break;
                }
            }
        }
        if (string.isEmpty()) {
            string = "https://www.google.ch";
        }
        if (!string.startsWith(UriUtil.HTTPS_SCHEME)) {
            string = "https://www." + string;
        }
        FreeMoviesApp.p().edit().putString("pref_default_domain_gg_2", string).apply();
        return string;
    }

    public static String H(String str) {
        try {
            String host = new URI(str).getHost();
            int lastIndexOf = host.lastIndexOf(".");
            if (lastIndexOf > -1) {
                host = host.substring(0, lastIndexOf);
            }
            if (host.startsWith("www.")) {
                return host.substring(4);
            }
            return host;
        } catch (URISyntaxException unused) {
            return "UNKNOW HOST";
        }
    }

    public static File I() {
        File file = new File(FreeMoviesApp.p().getString("pref_dowload_path3", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath()));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static long J() {
        StatFs statFs = new StatFs(I().getPath());
        return statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
    }

    public static String K(InputStream inputStream) throws IOException {
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream);
        }
        UniversalDetector universalDetector = new UniversalDetector((CharsetListener) null);
        byte[] bArr = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0 || universalDetector.e()) {
                universalDetector.a();
                String c2 = universalDetector.c();
            } else {
                universalDetector.d(bArr, 0, read);
            }
        }
        universalDetector.a();
        String c22 = universalDetector.c();
        if (c22 != null) {
            PrintStream printStream = System.out;
            printStream.println("Detected encoding = " + c22);
        } else {
            System.out.println("No encoding detected.");
        }
        universalDetector.f();
        return c22;
    }

    public static String L(String str) {
        String lowerCase = Regex.a(str, "(\\.\\w{3,4})(?:$|\\?)", 1).trim().toLowerCase();
        if (!lowerCase.isEmpty() && (lowerCase.equalsIgnoreCase(".avi") || lowerCase.equalsIgnoreCase(".rmvb") || lowerCase.equalsIgnoreCase(".flv") || lowerCase.equalsIgnoreCase(".mkv") || lowerCase.equalsIgnoreCase(".mp2") || lowerCase.equalsIgnoreCase(".mp2v") || lowerCase.equalsIgnoreCase(".mp4") || lowerCase.equalsIgnoreCase(".mp4v") || lowerCase.equalsIgnoreCase(".mpe") || lowerCase.equalsIgnoreCase(".mpeg") || lowerCase.equalsIgnoreCase(".mpeg1") || lowerCase.equalsIgnoreCase(".mpeg2") || lowerCase.equalsIgnoreCase(".mpeg4") || lowerCase.equalsIgnoreCase(".mpg") || lowerCase.equalsIgnoreCase(".ts") || lowerCase.equalsIgnoreCase(".m3u8"))) {
            return lowerCase;
        }
        return ".mp4";
    }

    public static List<String> M() {
        String[] strArr = (String[]) PrefUtils.c("file_to_delete", String[].class);
        if (strArr != null) {
            return new LinkedList(Arrays.asList(strArr));
        }
        return new ArrayList();
    }

    public static String N() {
        File W = W();
        File file = new File(W.getAbsolutePath() + "/cinemahd/memberkey.txt");
        if (!file.exists()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            bufferedReader.close();
        } catch (IOException unused) {
        }
        return sb.toString();
    }

    public static String O() {
        int ipAddress;
        try {
            WifiInfo connectionInfo = ((WifiManager) v().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null && (ipAddress = connectionInfo.getIpAddress()) > 0) {
                if (ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN)) {
                    ipAddress = Integer.reverseBytes(ipAddress);
                }
                return InetAddress.getByAddress(BigInteger.valueOf((long) ipAddress).toByteArray()).getHostAddress();
            }
        } catch (Exception e2) {
            Logger.d(e2, new boolean[0]);
        }
        try {
            Iterator<T> it2 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it2.hasNext()) {
                Iterator<T> it3 = Collections.list(((NetworkInterface) it2.next()).getInetAddresses()).iterator();
                while (true) {
                    if (it3.hasNext()) {
                        InetAddress inetAddress = (InetAddress) it3.next();
                        if (!inetAddress.isLoopbackAddress()) {
                            String hostAddress = inetAddress.getHostAddress();
                            if (hostAddress.indexOf(58) < 0) {
                                return hostAddress;
                            }
                        }
                    }
                }
            }
            return "";
        } catch (Exception e3) {
            Logger.d(e3, new boolean[0]);
            return "";
        }
    }

    public static HashMap<Integer, String> P() {
        if (f37629v.isEmpty()) {
            String[] split = getProvider(27).split(",");
            f37630w = split.length;
            int length = split.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                f37629v.put(Integer.valueOf(i3), split[i2]);
                i2++;
                i3++;
            }
        }
        return f37629v;
    }

    public static LinkedHashMap<String, String> Q() {
        if (f37626s.size() > 0) {
            return f37626s;
        }
        f37626s.put("ac", "google.ac");
        f37626s.put("ad", "google.ad");
        f37626s.put(ae.f34224a, "google.ae");
        f37626s.put("af", "google.com.af");
        f37626s.put("ag", "google.com.ag");
        f37626s.put("ai", "google.com.ai");
        f37626s.put("al", "google.al");
        f37626s.put("am", "google.am");
        f37626s.put("ao", "google.co.ao");
        f37626s.put("ar", "google.com.ar");
        f37626s.put("as", "google.as");
        f37626s.put("at", "google.at");
        f37626s.put("au", "google.com.au");
        f37626s.put("az", "google.az");
        f37626s.put("ba", "google.ba");
        f37626s.put("bd", "google.com.bd");
        f37626s.put("be", "google.be");
        f37626s.put("bf", "google.bf");
        f37626s.put("bg", "google.bg");
        f37626s.put("bh", "google.com.bh");
        f37626s.put("bi", "google.bi");
        f37626s.put("bj", "google.bj");
        f37626s.put("bn", "google.com.bn");
        f37626s.put("bo", "google.com.bo");
        f37626s.put("br", "google.com.br");
        f37626s.put("bs", "google.bs");
        f37626s.put("bt", "google.bt");
        f37626s.put("bw", "google.co.bw");
        f37626s.put("by", "google.by");
        f37626s.put("bz", "google.com.bz");
        f37626s.put("ca", "google.ca");
        f37626s.put("kh", "google.com.kh");
        f37626s.put("cc", "google.cc");
        f37626s.put("cd", "google.cd");
        f37626s.put("cf", "google.cf");
        f37626s.put("cat", "google.cat");
        f37626s.put("cg", "google.cg");
        f37626s.put("ch", "google.ch");
        f37626s.put("ci", "google.ci");
        f37626s.put("ck", "google.co.ck");
        f37626s.put("cl", "google.cl");
        f37626s.put("cm", "google.cm");
        f37626s.put("cn", "google.com.hk");
        f37626s.put(Constants.COLLATION_EXTENSION_KEY_SHORT, "google.com.co");
        f37626s.put("cr", "google.co.cr");
        f37626s.put("cu", "google.com.cu");
        f37626s.put("cv", "google.cv");
        f37626s.put("cy", "google.com.cy");
        f37626s.put("cz", "google.cz");
        f37626s.put(de.f34377a, "google.de");
        f37626s.put("dj", "google.dj");
        f37626s.put("dk", "google.dk");
        f37626s.put("dm", "google.dm");
        f37626s.put("do", "google.com.do");
        f37626s.put("dz", "google.dz");
        f37626s.put("ec", "google.com.ec");
        f37626s.put("ee", "google.ee");
        f37626s.put("eg", "google.com.eg");
        f37626s.put("es", "google.es");
        f37626s.put("et", "google.com.et");
        f37626s.put("fi", "google.fi");
        f37626s.put("fj", "google.com.fj");
        f37626s.put("fm", "google.fm");
        f37626s.put("fr", "google.fr");
        f37626s.put("ga", "google.ga");
        f37626s.put("ge", "google.ge");
        f37626s.put("gf", "google.gf");
        f37626s.put("gg", "google.gg");
        f37626s.put("gh", "google.com.gh");
        f37626s.put("gi", "google.com.gi");
        f37626s.put("gl", "google.gl");
        f37626s.put("gm", "google.gm");
        f37626s.put("gp", "google.gp");
        f37626s.put("gr", "google.gr");
        f37626s.put("gt", "google.com.gt");
        f37626s.put("gy", "google.gy");
        f37626s.put("hk", "google.com.hk");
        f37626s.put("hn", "google.hn");
        f37626s.put("hr", "google.hr");
        f37626s.put("ht", "google.ht");
        f37626s.put("hu", "google.hu");
        f37626s.put("id", "google.co.id");
        f37626s.put("iq", "google.iq");
        f37626s.put("ie", "google.ie");
        f37626s.put("il", "google.co.il");
        f37626s.put("im", "google.im");
        f37626s.put(ScarConstants.IN_SIGNAL_KEY, "google.co.in");
        f37626s.put("io", "google.io");
        f37626s.put("is", "google.is");
        f37626s.put("it", "google.it");
        f37626s.put("je", "google.je");
        f37626s.put("jm", "google.com.jm");
        f37626s.put("jo", "google.jo");
        f37626s.put("jp", "google.co.jp");
        f37626s.put("ke", "google.co.ke");
        f37626s.put("ki", "google.ki");
        f37626s.put("kg", "google.kg");
        f37626s.put("kr", "google.co.kr");
        f37626s.put("kw", "google.com.kw");
        f37626s.put("kz", "google.kz");
        f37626s.put("la", "google.la");
        f37626s.put("lb", "google.com.lb");
        f37626s.put("lc", "google.com.lc");
        f37626s.put("li", "google.li");
        f37626s.put("lk", "google.lk");
        f37626s.put("ls", "google.co.ls");
        f37626s.put("lt", "google.lt");
        f37626s.put("lu", "google.lu");
        f37626s.put("lv", "google.lv");
        f37626s.put("ly", "google.com.ly");
        f37626s.put("ma", "google.co.ma");
        f37626s.put("md", "google.md");
        f37626s.put("me", "google.me");
        f37626s.put("mg", "google.mg");
        f37626s.put("mk", "google.mk");
        f37626s.put("ml", "google.ml");
        f37626s.put("mm", "google.com.mm");
        f37626s.put("mn", "google.mn");
        f37626s.put("ms", "google.ms");
        f37626s.put("mt", "google.com.mt");
        f37626s.put("mu", "google.mu");
        f37626s.put("mv", "google.mv");
        f37626s.put("mw", "google.mw");
        f37626s.put("mx", "google.com.mx");
        f37626s.put("my", "google.com.my");
        f37626s.put("mz", "google.co.mz");
        f37626s.put("na", "google.com.na");
        f37626s.put("ne", "google.ne");
        f37626s.put("nf", "google.com.nf");
        f37626s.put("ng", "google.com.ng");
        f37626s.put("ni", "google.com.ni");
        f37626s.put("nl", "google.nl");
        f37626s.put("no", "google.no");
        f37626s.put("np", "google.com.np");
        f37626s.put("nr", "google.nr");
        f37626s.put("nu", "google.nu");
        f37626s.put("nz", "google.co.nz");
        f37626s.put("om", "google.com.om");
        f37626s.put("pk", "google.com.pk");
        f37626s.put("pa", "google.com.pa");
        f37626s.put("pe", "google.com.pe");
        f37626s.put("ph", "google.com.ph");
        f37626s.put("pl", "google.pl");
        f37626s.put("pg", "google.com.pg");
        f37626s.put("pn", "google.pn");
        f37626s.put("pr", "google.com.pr");
        f37626s.put("ps", "google.ps");
        f37626s.put("pt", "google.pt");
        f37626s.put("py", "google.com.py");
        f37626s.put("qa", "google.com.qa");
        f37626s.put("ro", "google.ro");
        f37626s.put("rs", "google.rs");
        f37626s.put("ru", "google.ru");
        f37626s.put("rw", "google.rw");
        f37626s.put("sa", "google.com.sa");
        f37626s.put("sb", "google.com.sb");
        f37626s.put("sc", "google.sc");
        f37626s.put("se", "google.se");
        f37626s.put("sg", "google.com.sg");
        f37626s.put("sh", "google.sh");
        f37626s.put("si", "google.si");
        f37626s.put("sk", "google.sk");
        f37626s.put("sl", "google.com.sl");
        f37626s.put("sn", "google.sn");
        f37626s.put("sm", "google.sm");
        f37626s.put("so", "google.so");
        f37626s.put("st", "google.st");
        f37626s.put("sr", "google.sr");
        f37626s.put("sv", "google.com.sv");
        f37626s.put("td", "google.td");
        f37626s.put("tg", "google.tg");
        f37626s.put("th", "google.co.th");
        f37626s.put("tj", "google.com.tj");
        f37626s.put("tk", "google.tk");
        f37626s.put("tl", "google.tl");
        f37626s.put("tm", "google.tm");
        f37626s.put("to", "google.to");
        f37626s.put("tn", "google.tn");
        f37626s.put("tr", "google.com.tr");
        f37626s.put("tt", "google.tt");
        f37626s.put("tw", "google.com.tw");
        f37626s.put("tz", "google.co.tz");
        f37626s.put("ua", "google.com.ua");
        f37626s.put("ug", "google.co.ug");
        f37626s.put("uk", "google.co.uk");
        f37626s.put("com", "google.com");
        f37626s.put("uy", "google.com.uy");
        f37626s.put("uz", "google.co.uz");
        f37626s.put("vc", "google.com.vc");
        f37626s.put("ve", "google.co.ve");
        f37626s.put("vg", "google.vg");
        f37626s.put("vi", "google.co.vi");
        f37626s.put("vn", "google.com.vn");
        f37626s.put("vu", "google.vu");
        f37626s.put("ws", "google.ws");
        f37626s.put("za", "google.co.za");
        f37626s.put("zm", "google.co.zm");
        f37626s.put("zw", "google.co.zw");
        return f37626s;
    }

    public static String R() {
        String string = FreeMoviesApp.p().getString("pref_cc_unlock_full_version", "");
        if (string.isEmpty()) {
            string = N();
            if (string.indexOf(" ") >= 0) {
                return "";
            }
            FreeMoviesApp.p().edit().putString("pref_cc_unlock_full_version", string).apply();
        }
        return string;
    }

    public static int S(String str) {
        if (str.contains("Tv/Shows")) {
            return NavIds.NAV_TV_SHOW.b();
        }
        if (str.contains("Movies")) {
            return NavIds.NAV_MOVIE.b();
        }
        if (str.contains("Favorites")) {
            return NavIds.NAV_FAVORITE.b();
        }
        if (str.contains("Featured Lists")) {
            return NavIds.NAV_MY_LIST.b();
        }
        if (str.contains("History")) {
            return NavIds.NAV_HISTORY.b();
        }
        if (str.contains("Calendar")) {
            return NavIds.NAV_CALENDAR.b();
        }
        return NavIds.f37572c.a(PrefUtils.d(v())).b();
    }

    public static Set<String> T() {
        boolean z2;
        String list = GlobalVariable.c().b().getProvider().getList();
        Set<String> stringSet = FreeMoviesApp.p().getStringSet("pref_addition_providers", new HashSet());
        HashSet hashSet = new HashSet();
        hashSet.addAll(stringSet);
        for (String str : list.split(",")) {
            Iterator<String> it2 = stringSet.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (str.toLowerCase().equals(it2.next().toLowerCase())) {
                        z2 = true;
                        break;
                    }
                } else {
                    z2 = false;
                    break;
                }
            }
            if (!str.isEmpty() && !z2) {
                hashSet.add(str);
            }
        }
        return hashSet;
    }

    public static LinkedHashMap<String, Integer> U() {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Small", 10);
        linkedHashMap.put("Medium", 8);
        linkedHashMap.put("Large", 5);
        linkedHashMap.put("Extra Large", 3);
        return linkedHashMap;
    }

    public static String V(String str) {
        return Regex.a(str, "(2160|4K|1080|720|480|360|CAM|2K)", 1);
    }

    public static File W() {
        return v().getExternalFilesDir((String) null);
    }

    public static int X(Activity activity) {
        Point point = new Point();
        activity.getWindowManager().getDefaultDisplay().getSize(point);
        int i2 = point.x;
        int i3 = point.y;
        if (i2 < i3) {
            return 1;
        }
        if (i2 > i3) {
            return 2;
        }
        return 3;
    }

    public static String Y() {
        return getServerUrl(f37619l);
    }

    public static String Z(int i2) {
        return P().get(Integer.valueOf(i2));
    }

    public static String a() {
        String str = f37627t;
        if (str == null || str.isEmpty()) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) v().getSystemService("phone");
                String trim = telephonyManager.getSimCountryIso().trim();
                f37627t = trim;
                if (trim == null || trim.isEmpty()) {
                    f37627t = telephonyManager.getNetworkCountryIso().trim();
                }
            } catch (Throwable th) {
                Logger.d(th, new boolean[0]);
            }
        }
        return f37627t;
    }

    public static native String a(Context context);

    public static File a0(String str) {
        if (v() == null) {
            return null;
        }
        File file = new File(v().getCacheDir(), "subtitles");
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str);
    }

    public static native void a877c(Context context, boolean z2);

    public static native String a98c();

    public static native void ac(int i2);

    public static native String ae();

    public static String b() {
        return a(v());
    }

    public static int b0() {
        if (f37625r == -1) {
            try {
                PackageInfo packageInfo = v().getPackageManager().getPackageInfo(getPackageName(), 0);
                f37624q = packageInfo.versionName;
                f37625r = packageInfo.versionCode;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
        }
        return f37625r;
    }

    public static void c(String str) {
        List list;
        String[] strArr = (String[]) PrefUtils.c("file_to_delete", String[].class);
        if (strArr == null) {
            list = new ArrayList();
        } else {
            list = new LinkedList(Arrays.asList(strArr));
        }
        list.add(str);
        PrefUtils.p("file_to_delete", list);
    }

    public static String c0() {
        if (f37624q.isEmpty()) {
            try {
                PackageInfo packageInfo = v().getPackageManager().getPackageInfo(getPackageName(), 0);
                f37624q = packageInfo.versionName;
                f37625r = packageInfo.versionCode;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
        }
        return f37624q;
    }

    public static String c3c() {
        return PrefUtils.j(v());
    }

    public static String castt() {
        try {
            String str = "";
            for (Signature byteArray : v().getPackageManager().getPackageInfo(v().getPackageName(), 64).signatures) {
                MessageDigest instance = MessageDigest.getInstance("SHA");
                instance.update(byteArray.toByteArray());
                str = new String(Base64.encode(instance.digest(), 0));
            }
            return str;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e("name not found", e2.toString());
            return "";
        } catch (NoSuchAlgorithmException e3) {
            Log.e("no such an algorithm", e3.toString());
            return "";
        } catch (Exception e4) {
            Log.e("exception", e4.toString());
            return "";
        }
    }

    public static native String ccc();

    public static void d(ItemHelpCaptcha itemHelpCaptcha) {
        boolean z2;
        if (f37615h == null) {
            f37615h = new ArrayList<>();
        }
        Iterator<ItemHelpCaptcha> it2 = f37615h.iterator();
        while (true) {
            if (it2.hasNext()) {
                if (it2.next().getProviderName().equals(itemHelpCaptcha.getProviderName())) {
                    z2 = true;
                    break;
                }
            } else {
                z2 = false;
                break;
            }
        }
        if (!z2) {
            f37615h.add(itemHelpCaptcha);
        }
    }

    public static boolean d0() {
        return FreeMoviesApp.p().getBoolean("pref_use_webview_bypass", false);
    }

    public static String de(String str) {
        return AESEncrypter.c(str).replace(" ", "");
    }

    public static void e(String str, String str2) {
        d(new ItemHelpCaptcha(str2, str));
    }

    public static ArrayList<ItemHelpCaptcha> e0() {
        ItemHelpCaptcha[] itemHelpCaptchaArr = (ItemHelpCaptcha[]) PrefUtils.c(f37614g, ItemHelpCaptcha[].class);
        if (f37615h == null) {
            f37615h = new ArrayList<>();
        }
        if (itemHelpCaptchaArr != null) {
            f37615h.addAll(Arrays.asList(itemHelpCaptchaArr));
        }
        return f37615h;
    }

    public static String en(String str) {
        return AESEncrypter.b(str);
    }

    public static String f(ArrayList<String> arrayList, String str, boolean z2) {
        if (arrayList == null || arrayList.size() == 0) {
            return "";
        }
        if (z2) {
            return arrayList.get(0);
        }
        return TextUtils.join(",", arrayList);
    }

    public static boolean f0() {
        if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(v()) == 0) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r2 = r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.reflect.Method findMethod(java.lang.Class<?> r2, java.lang.String r3, java.lang.Class<?>... r4) {
        /*
            r0 = 1
            java.lang.reflect.Method r1 = r2.getDeclaredMethod(r3, r4)     // Catch:{ NoSuchMethodException -> 0x0009 }
            r1.setAccessible(r0)     // Catch:{ NoSuchMethodException -> 0x0009 }
            return r1
        L_0x0009:
            java.lang.Class r2 = r2.getSuperclass()
            if (r2 == 0) goto L_0x0021
            java.lang.Class<java.lang.Object> r1 = java.lang.Object.class
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0019
            goto L_0x0021
        L_0x0019:
            java.lang.reflect.Method r1 = r2.getDeclaredMethod(r3, r4)     // Catch:{ NoSuchMethodException -> 0x0009 }
            r1.setAccessible(r0)     // Catch:{ NoSuchMethodException -> 0x0009 }
            return r1
        L_0x0021:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Utils.findMethod(java.lang.Class, java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }

    public static int g() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        return Math.min(availableProcessors * 2, (int) ((Runtime.getRuntime().maxMemory() - (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())) / 36700160));
    }

    public static void g0(Context context, View view) {
        InputMethodManager inputMethodManager;
        if (context != null && (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) != null && view != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static native String getAndroidID(Context context);

    public static native String getApiKey2();

    public static native String getConfigKey();

    public static native String getFallbackCf();

    public static native String getOpenloadCode();

    public static String getPackageName() {
        return x76asd();
    }

    public static native String getProvider(int i2);

    public static native String getRedirectList();

    public static native String getServerUrl(boolean z2);

    public static void h(OkHttpClient okHttpClient) {
        for (Call cancel : okHttpClient.dispatcher().queuedCalls()) {
            cancel.cancel();
        }
        for (Call cancel2 : okHttpClient.dispatcher().runningCalls()) {
            cancel2.cancel();
        }
        okHttpClient.dispatcher().executorService().shutdown();
    }

    public static void h0(Activity activity, int i2) {
        i0(activity, activity.getString(i2));
    }

    private static String i(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = "";
        boolean z2 = true;
        for (char c2 : str.toCharArray()) {
            if (!z2 || !Character.isLetter(c2)) {
                if (Character.isWhitespace(c2)) {
                    z2 = true;
                }
                str2 = str2 + c2;
            } else {
                str2 = str2 + Character.toUpperCase(c2);
                z2 = false;
            }
        }
        return str2;
    }

    public static void i0(Activity activity, String str) {
        try {
            Snackbar w2 = Snackbar.w(activity.findViewById(16908290), str, 0);
            View k2 = w2.k();
            TextView textView = (TextView) k2.findViewById(R.id.snackbar_text);
            if (textView != null) {
                textView.setTextColor(activity.getResources().getColor(R.color.white));
                k2.setBackgroundColor(activity.getResources().getColor(R.color.primaryBG));
                w2.s();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean j() {
        for (String m02 : GlobalVariable.c().b().getBlocks_package()) {
            if (m0(m02)) {
                return true;
            }
        }
        return false;
    }

    public static void j0(Context context, CompositeDisposable compositeDisposable) {
        f37623p = new WeakReference<>(context);
        a877c(context, false);
        saveOpenCout(PrefUtils.e(context));
        f37616i = new WeakReference<>(compositeDisposable);
    }

    public static native String jha();

    public static boolean k(String str, Set<String> set) {
        for (String lowerCase : set) {
            if (lowerCase.toLowerCase().contains(str.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public static boolean k0() {
        ActivityManager activityManager = (ActivityManager) v().getSystemService("activity");
        if (activityManager.isLowRamDevice() || Runtime.getRuntime().availableProcessors() < 4 || activityManager.getMemoryClass() < 128) {
            return false;
        }
        return true;
    }

    public static boolean l(RDTYPE rdtype) {
        int i2 = AnonymousClass5.f37634a[rdtype.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3 && PremiumizeCredentialsHelper.b().isValid() && FreeMoviesApp.p().getBoolean("pref_premiumize_type", false) && PremiumizeCredentialsHelper.b().getPremium_until() > 0) {
                    return DateTimeHelper.a(DateTimeHelper.c(PremiumizeCredentialsHelper.b().getPremium_until()));
                }
                return false;
            } else if (!AllDebridCredentialsHelper.b().isValid() || !FreeMoviesApp.p().getBoolean("pref_alldebrid_type", false)) {
                return false;
            } else {
                String string = FreeMoviesApp.p().getString("pref_alldebrid_expiration_str", "");
                if (!string.isEmpty()) {
                    return DateTimeHelper.a(DateTimeHelper.d(string));
                }
                return false;
            }
        } else if (!RealDebridCredentialsHelper.d().isValid() || !FreeMoviesApp.p().getBoolean("pref_realdebrid_type", false)) {
            return false;
        } else {
            String string2 = FreeMoviesApp.p().getString("pref_realdebrid_expiration_str", "");
            Logger.b("checkExprirationDB", string2);
            if (!string2.isEmpty()) {
                return DateTimeHelper.a(DateTimeHelper.b(string2));
            }
            return false;
        }
    }

    public static boolean l0(ArrayList<String> arrayList) {
        if (arrayList == null) {
            return false;
        }
        for (ApplicationInfo next : v().getPackageManager().getInstalledApplications(0)) {
            Iterator<String> it2 = arrayList.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (next.packageName.equals(it2.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean m(String str) {
        if (f37617j == null) {
            f37617j = new ArrayList<>();
        }
        int hashCode = str.hashCode();
        if (f37617j.contains(Integer.valueOf(hashCode))) {
            return false;
        }
        f37617j.add(Integer.valueOf(hashCode));
        return true;
    }

    public static boolean m0(String str) {
        try {
            v().getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static String md5(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                String hexString = Integer.toHexString(b2 & 255);
                while (hexString.length() < 2) {
                    hexString = "0" + hexString;
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static void n() {
        ArrayList<Integer> arrayList = f37617j;
        if (arrayList != null) {
            arrayList.clear();
        }
        f37617j = null;
    }

    public static String n0(List<String> list, String str, StringBuilder sb) {
        if (list == null) {
            return "";
        }
        sb.setLength(0);
        if (!Lists.a(list)) {
            for (String next : list) {
                if (sb.length() > 0) {
                    sb.append(str);
                }
                sb.append(next);
            }
        }
        return sb.toString();
    }

    public static String o(long j2, boolean z2) {
        String str;
        String str2;
        if (z2) {
            str = "https://api.themoviedb.org/3/movie/";
        } else {
            str = "https://api.themoviedb.org/3/tv/";
        }
        try {
            String string = FreeMoviesApp.p().getString("last_tmdb_api_key", GlobalVariable.c().b().getTmdb_api_keys().get(0));
            HttpHelper i2 = HttpHelper.i();
            String m2 = i2.m(str + j2 + "?append_to_response=external_ids,content_ratings,videos&language=" + "en-US" + "&api_key=" + string, new Map[0]);
            boolean isEmpty = Regex.a(m2, "\\\"overview\\\"\\s*:\\s*(null|\\\"\\\")\\s*,", 1).isEmpty();
            if (m2.isEmpty()) {
                return "-1";
            }
            JSONObject jSONObject = new JSONObject(m2);
            if (z2) {
                str2 = jSONObject.getString("imdb_id");
            } else {
                str2 = jSONObject.getJSONObject("external_ids").getString("imdb_id");
            }
            if (!str2.isEmpty()) {
                return str2.replaceAll("[^0-9]", "");
            }
            return "-1";
        } catch (Exception e2) {
            Logger.d(e2, new boolean[0]);
            return "-1";
        }
    }

    public static void o0(Activity activity, String str) {
        activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    public static void p(Activity activity, String str, boolean z2) {
        ((ClipboardManager) activity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Copied Address", str));
        i0(activity, "Copied " + str);
        if (z2) {
            Intent intent = new Intent(activity, BarcodeActivity.class);
            intent.putExtra("extra_barcode", str);
            activity.startActivity(intent);
        }
    }

    public static int p0(int i2, int i3) {
        return new Random().nextInt((i3 - i2) + 1) + i2;
    }

    public static void q(Context context) {
        try {
            r(context.getCacheDir());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void q0(Activity activity) {
        Intent intent = new Intent(activity, SplashActivity.class);
        intent.addFlags(268468224);
        activity.startActivity(intent);
        q(activity);
        AdsManager.d().c();
        activity.finishAndRemoveTask();
        Runtime.getRuntime().exit(0);
    }

    public static boolean r(File file) {
        if (file != null && file.isDirectory()) {
            String[] list = file.list();
            for (String file2 : list) {
                if (!r(new File(file, file2))) {
                    return false;
                }
            }
            return file.delete();
        } else if (file == null || !file.isFile()) {
            return false;
        } else {
            return file.delete();
        }
    }

    public static float r0(double d2, int i2) {
        return new BigDecimal(Double.toString(d2)).setScale(i2, 4).floatValue();
    }

    public static FindResult s(String str) {
        String str2 = "https://api.themoviedb.org/3/find/" + str;
        String string = FreeMoviesApp.p().getString("last_tmdb_api_key", GlobalVariable.c().b().getTmdb_api_keys().get(0));
        return (FindResult) new Gson().l(HttpHelper.i().m(str2 + "?language=" + "en-US" + "&api_key=" + string + "&external_source=imdb_id", new Map[0]), FindResult.class);
    }

    public static void s0(String str) {
        FreeMoviesApp.p().edit().putString("pref_cc_unlock_full_version", str).apply();
        File W = W();
        File file = new File(W.getAbsolutePath() + "/cinemahd");
        if (!file.exists()) {
            file.mkdir();
        }
        try {
            new FileOutputStream(new File(file, "memberkey.txt")).write(str.getBytes());
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    public static native void saveOpenCout(int i2);

    public static String t() {
        return getAndroidID(v());
    }

    public static void t0() {
        ArrayList<ItemHelpCaptcha> arrayList = f37615h;
        if (arrayList == null || arrayList.isEmpty()) {
            PrefUtils.o(f37614g, "");
        } else {
            PrefUtils.p(f37614g, f37615h);
        }
    }

    public static String u() {
        return a98c();
    }

    public static void u0(ContextWrapper contextWrapper) {
        if (contextWrapper.getClass() != FreeMoviesApp.class) {
            a877c(contextWrapper, true);
        }
    }

    public static Context v() {
        WeakReference<Context> weakReference = f37623p;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static void v0(String str) {
        FreeMoviesApp.p().edit().putString("pref_backup_folder", str).apply();
    }

    public static String w() {
        return FreeMoviesApp.p().getString("pref_backup_folder", B().getAbsolutePath());
    }

    public static void w0(Activity activity) {
        f37621n = new WeakReference<>(activity);
    }

    public static List<BaseProvider> x() {
        int i2;
        Set<String> T = T();
        Set<String> stringSet = FreeMoviesApp.p().getStringSet("pref_choose_provider_disabled", new HashSet());
        HashSet hashSet = new HashSet();
        Iterator<String> it2 = T.iterator();
        while (true) {
            i2 = 0;
            if (!it2.hasNext()) {
                break;
            }
            String next = it2.next();
            Iterator<String> it3 = stringSet.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                String next2 = it3.next();
                if (next.equals(next2) && !next2.equals("ZeroTV")) {
                    i2 = 1;
                    break;
                }
            }
            if (i2 == 0) {
                hashSet.add(next);
            }
        }
        ArrayList arrayList = new ArrayList();
        BaseProvider[] baseProviderArr = BaseProvider.f37247c;
        int length = baseProviderArr.length;
        while (i2 < length) {
            BaseProvider baseProvider = baseProviderArr[i2];
            Iterator it4 = hashSet.iterator();
            while (true) {
                if (it4.hasNext()) {
                    if (((String) it4.next()).toLowerCase().contains(baseProvider.A().toLowerCase())) {
                        arrayList.add(baseProvider);
                        break;
                    }
                } else {
                    break;
                }
            }
            i2++;
        }
        return BaseProvider.I(arrayList);
    }

    public static void x0(TextView textView, String str, String str2, int i2, float f2) {
        textView.setText(str, TextView.BufferType.SPANNABLE);
        Spannable spannable = (Spannable) textView.getText();
        int indexOf = str.indexOf(str2);
        spannable.setSpan(new ForegroundColorSpan(i2), indexOf, str2.length() + indexOf, 33);
        spannable.setSpan(new RelativeSizeSpan(f2), indexOf, str2.length() + indexOf, 33);
    }

    public static String x76asd() {
        return v().getPackageName();
    }

    public static String y(String str, String str2, String str3) {
        Uri parse = Uri.parse(str);
        String replace = Base64.encodeToString(((parse.getScheme() + "://" + parse.getHost()) + ":443").getBytes(), 0).replace(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE, "").replace("=", ".");
        String str4 = "https://www.google.com/recaptcha/api.js?render=" + str2;
        String a2 = Regex.a(HttpHelper.i().o(str4, str4), "releases\\/([0-9a-zA-Z\\.:_\\&\\#\\*\\%\\~\\^\\-\\!]+)", 1);
        String a3 = Regex.a(HttpHelper.i().m(String.format("https://www.google.com/recaptcha/api2/anchor?ar=1&hl=en&size=invisible&cb=cs3&k=%s&co=%s&v=%s", new Object[]{str2, replace, a2}), new Map[0]), "<input[^>]*recaptcha-token.*value\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>", 1);
        if (a3 != null) {
            String format = String.format("v=%s&k=%s&c=%s&co=%s&reason=q", new Object[]{a2, str2, a3, replace});
            String l2 = HttpHelper.i().l("https://www.google.com/recaptcha/api2/reload?k=" + str2, format, new Map[0]);
            if (!l2.isEmpty()) {
                return Regex.a(l2, "rresp['\"]\\,['\"]([^'\"]+)['\"]", 1);
            }
        }
        return "";
    }

    public static void y0(Activity activity, String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog.Builder message = new AlertDialog.Builder(activity).setTitle(str).setMessage(str2);
        if (onClickListener != null) {
            message.setPositiveButton("Goto User Torrents", onClickListener);
        }
        if (onClickListener2 != null) {
            message.setNegativeButton("Close", onClickListener2);
        }
        message.show();
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0048 A[SYNTHETIC, Splitter:B:29:0x0048] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0053 A[SYNTHETIC, Splitter:B:34:0x0053] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String z(java.lang.String r5) {
        /*
            java.lang.String r0 = "UTF-8"
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x003f, all -> 0x003c }
            r2.<init>(r5)     // Catch:{ Exception -> 0x003f, all -> 0x003c }
            com.utils.UnicodeBOMInputStream r5 = new com.utils.UnicodeBOMInputStream     // Catch:{ Exception -> 0x0037, all -> 0x0033 }
            r5.<init>(r2)     // Catch:{ Exception -> 0x0037, all -> 0x0033 }
            java.lang.String r1 = K(r5)     // Catch:{ Exception -> 0x0031 }
            if (r1 != 0) goto L_0x001b
            com.utils.UnicodeBOMInputStream$BOM r1 = r5.a()     // Catch:{ Exception -> 0x0031 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0031 }
        L_0x001b:
            java.lang.String r3 = "NONE"
            boolean r3 = r1.equals(r3)     // Catch:{ Exception -> 0x0031 }
            if (r3 == 0) goto L_0x0024
            goto L_0x0025
        L_0x0024:
            r0 = r1
        L_0x0025:
            r2.close()     // Catch:{ IOException -> 0x002c }
            r5.close()     // Catch:{ IOException -> 0x002c }
            goto L_0x004e
        L_0x002c:
            r5 = move-exception
            r5.printStackTrace()
            goto L_0x004e
        L_0x0031:
            r1 = move-exception
            goto L_0x0043
        L_0x0033:
            r0 = move-exception
            r5 = r1
        L_0x0035:
            r1 = r2
            goto L_0x0051
        L_0x0037:
            r5 = move-exception
            r4 = r1
            r1 = r5
            r5 = r4
            goto L_0x0043
        L_0x003c:
            r0 = move-exception
            r5 = r1
            goto L_0x0051
        L_0x003f:
            r5 = move-exception
            r2 = r1
            r1 = r5
            r5 = r2
        L_0x0043:
            r1.printStackTrace()     // Catch:{ all -> 0x004f }
            if (r2 == 0) goto L_0x004e
            r2.close()     // Catch:{ IOException -> 0x002c }
            r5.close()     // Catch:{ IOException -> 0x002c }
        L_0x004e:
            return r0
        L_0x004f:
            r0 = move-exception
            goto L_0x0035
        L_0x0051:
            if (r1 == 0) goto L_0x005e
            r1.close()     // Catch:{ IOException -> 0x005a }
            r5.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x005e
        L_0x005a:
            r5 = move-exception
            r5.printStackTrace()
        L_0x005e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Utils.z(java.lang.String):java.lang.String");
    }

    public static void z0(Activity activity, String str, DialogInterface.OnClickListener onClickListener, EditText editText, DialogInterface.OnDismissListener onDismissListener) {
        editText.setInputType(Sdk$SDKError.Reason.EMPTY_TPAT_ERROR_VALUE);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(str);
        builder.setView(editText);
        builder.l("Ok", onClickListener);
        if (onDismissListener != null) {
            builder.j(onDismissListener);
        }
        builder.q();
    }
}
