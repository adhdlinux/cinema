package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.facebook.common.util.UriUtil;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class zzbsw implements zzbsy {
    static zzbsy zza;
    static zzbsy zzb;
    private static final Object zzc = new Object();
    private final Object zzd = new Object();
    private final Context zze;
    private final WeakHashMap zzf = new WeakHashMap();
    private final ExecutorService zzg;
    private final zzbzx zzh;

    protected zzbsw(Context context, zzbzx zzbzx) {
        zzfmc.zza();
        this.zzg = Executors.unconfigurableExecutorService(Executors.newCachedThreadPool());
        this.zze = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzh = zzbzx;
    }

    public static zzbsy zza(Context context) {
        synchronized (zzc) {
            if (zza == null) {
                if (((Boolean) zzbdn.zze.zze()).booleanValue()) {
                    if (!((Boolean) zzba.zzc().zzb(zzbbm.zzhq)).booleanValue()) {
                        zza = new zzbsw(context, zzbzx.zza());
                    }
                }
                zza = new zzbsx();
            }
        }
        return zza;
    }

    public static zzbsy zzb(Context context, zzbzx zzbzx) {
        synchronized (zzc) {
            if (zzb == null) {
                if (((Boolean) zzbdn.zze.zze()).booleanValue()) {
                    if (!((Boolean) zzba.zzc().zzb(zzbbm.zzhq)).booleanValue()) {
                        zzbsw zzbsw = new zzbsw(context, zzbzx);
                        Thread thread = Looper.getMainLooper().getThread();
                        if (thread != null) {
                            synchronized (zzbsw.zzd) {
                                zzbsw.zzf.put(thread, Boolean.TRUE);
                            }
                            thread.setUncaughtExceptionHandler(new zzbsv(zzbsw, thread.getUncaughtExceptionHandler()));
                        }
                        Thread.setDefaultUncaughtExceptionHandler(new zzbsu(zzbsw, Thread.getDefaultUncaughtExceptionHandler()));
                        zzb = zzbsw;
                    }
                }
                zzb = new zzbsx();
            }
        }
        return zzb;
    }

    public static String zzc(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static String zzd(Throwable th) {
        return zzfpw.zzc(zzbzk.zzf(zzc(th)));
    }

    /* access modifiers changed from: protected */
    public final void zze(Thread thread, Throwable th) {
        if (th != null) {
            boolean z2 = false;
            boolean z3 = false;
            for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
                for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
                    z2 |= zzbzk.zzo(stackTraceElement.getClassName());
                    z3 |= zzbsw.class.getName().equals(stackTraceElement.getClassName());
                }
            }
            if (z2 && !z3) {
                zzg(th, "", 1.0f);
            }
        }
    }

    public final void zzf(Throwable th, String str) {
        zzg(th, str, 1.0f);
    }

    public final void zzg(Throwable th, String str, float f2) {
        Throwable th2;
        String str2;
        int i2;
        String str3;
        String str4;
        Throwable th3;
        float f3 = f2;
        Handler handler = zzbzk.zza;
        boolean z2 = false;
        if (((Boolean) zzbdn.zzf.zze()).booleanValue()) {
            th2 = th;
        } else {
            LinkedList linkedList = new LinkedList();
            for (Throwable th4 = th; th4 != null; th4 = th4.getCause()) {
                linkedList.push(th4);
            }
            th2 = null;
            while (!linkedList.isEmpty()) {
                Throwable th5 = (Throwable) linkedList.pop();
                StackTraceElement[] stackTrace = th5.getStackTrace();
                ArrayList arrayList = new ArrayList();
                arrayList.add(new StackTraceElement(th5.getClass().getName(), "<filtered>", "<filtered>", 1));
                boolean z3 = false;
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (zzbzk.zzo(stackTraceElement.getClassName())) {
                        arrayList.add(stackTraceElement);
                        z3 = true;
                    } else {
                        String className = stackTraceElement.getClassName();
                        if (!TextUtils.isEmpty(className) && (className.startsWith("android.") || className.startsWith("java."))) {
                            arrayList.add(stackTraceElement);
                        } else {
                            arrayList.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
                        }
                    }
                }
                if (z3) {
                    if (th2 == null) {
                        th3 = new Throwable(th5.getMessage());
                    } else {
                        th3 = new Throwable(th5.getMessage(), th2);
                    }
                    th2 = th3;
                    th2.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
                }
            }
        }
        if (th2 != null) {
            String name = th.getClass().getName();
            String zzc2 = zzc(th);
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzip)).booleanValue()) {
                str2 = zzd(th);
            } else {
                str2 = "";
            }
            double d2 = (double) f3;
            int i3 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
            double random = Math.random();
            if (i3 > 0) {
                i2 = (int) (1.0f / f3);
            } else {
                i2 = 1;
            }
            if (random < d2) {
                ArrayList<String> arrayList2 = new ArrayList<>();
                try {
                    z2 = Wrappers.packageManager(this.zze).isCallerInstantApp();
                } catch (Throwable th6) {
                    zzbzr.zzh("Error fetching instant app info", th6);
                }
                try {
                    str3 = this.zze.getPackageName();
                } catch (Throwable unused) {
                    zzbzr.zzj("Cannot obtain package name, proceeding.");
                    str3 = "unknown";
                }
                Uri.Builder appendQueryParameter = new Uri.Builder().scheme(UriUtil.HTTPS_SCHEME).path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("is_aia", Boolean.toString(z2)).appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT));
                String str5 = Build.MANUFACTURER;
                String str6 = Build.MODEL;
                if (!str6.startsWith(str5)) {
                    str6 = str5 + " " + str6;
                }
                Uri.Builder appendQueryParameter2 = appendQueryParameter.appendQueryParameter("device", str6).appendQueryParameter("js", this.zzh.zza).appendQueryParameter("appid", str3).appendQueryParameter("exceptiontype", name).appendQueryParameter("stacktrace", zzc2).appendQueryParameter("eids", TextUtils.join(",", zzba.zza().zza())).appendQueryParameter("exceptionkey", str).appendQueryParameter("cl", "549114221").appendQueryParameter("rc", "dev").appendQueryParameter("sampling_rate", Integer.toString(i2)).appendQueryParameter("pb_tm", String.valueOf(zzbdn.zzc.zze())).appendQueryParameter("gmscv", String.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zze)));
                if (true != this.zzh.zze) {
                    str4 = "0";
                } else {
                    str4 = "1";
                }
                Uri.Builder appendQueryParameter3 = appendQueryParameter2.appendQueryParameter("lite", str4);
                if (!TextUtils.isEmpty(str2)) {
                    appendQueryParameter3.appendQueryParameter("hash", str2);
                }
                arrayList2.add(appendQueryParameter3.toString());
                for (String zzbst : arrayList2) {
                    this.zzg.execute(new zzbst(new zzbzw((String) null), zzbst));
                }
            }
        }
    }
}
