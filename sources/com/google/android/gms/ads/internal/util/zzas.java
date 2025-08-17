package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzcae;
import com.google.android.gms.internal.ads.zzdst;
import com.google.android.gms.internal.ads.zzdsx;
import com.google.android.gms.internal.ads.zzfwn;
import com.uwetrottmann.trakt5.TraktV2;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzas {
    private final Context zza;
    private final zzdsx zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private int zzg;
    private int zzh;
    private PointF zzi;
    private PointF zzj;
    private Handler zzk;
    private Runnable zzl;

    public zzas(Context context) {
        this.zzg = 0;
        this.zzl = new zzar(this);
        this.zza = context;
        this.zzh = ViewConfiguration.get(context).getScaledTouchSlop();
        zzt.zzt().zzb();
        this.zzk = zzt.zzt().zza();
        this.zzb = zzt.zzs().zza();
    }

    private final void zzs(Context context) {
        int i2;
        ArrayList arrayList = new ArrayList();
        int zzu = zzu(arrayList, "None", true);
        int zzu2 = zzu(arrayList, "Shake", true);
        int zzu3 = zzu(arrayList, "Flick", true);
        zzdst zzdst = zzdst.NONE;
        int ordinal = this.zzb.zza().ordinal();
        if (ordinal == 1) {
            i2 = zzu2;
        } else if (ordinal != 2) {
            i2 = zzu;
        } else {
            i2 = zzu3;
        }
        zzt.zzp();
        AlertDialog.Builder zzG = zzs.zzG(context);
        AtomicInteger atomicInteger = new AtomicInteger(i2);
        zzG.setTitle("Setup gesture");
        zzG.setSingleChoiceItems((CharSequence[]) arrayList.toArray(new String[0]), i2, new zzaj(atomicInteger));
        zzG.setNegativeButton("Dismiss", new zzak(this));
        zzG.setPositiveButton("Save", new zzal(this, atomicInteger, i2, zzu2, zzu3));
        zzG.setOnCancelListener(new zzam(this));
        zzG.create().show();
    }

    private final boolean zzt(float f2, float f3, float f4, float f5) {
        if (Math.abs(this.zzi.x - f2) >= ((float) this.zzh) || Math.abs(this.zzi.y - f3) >= ((float) this.zzh) || Math.abs(this.zzj.x - f4) >= ((float) this.zzh) || Math.abs(this.zzj.y - f5) >= ((float) this.zzh)) {
            return false;
        }
        return true;
    }

    private static final int zzu(List list, String str, boolean z2) {
        if (!z2) {
            return -1;
        }
        list.add(str);
        return list.size() - 1;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append("{Dialog: ");
        sb.append(this.zzc);
        sb.append(",DebugSignal: ");
        sb.append(this.zzf);
        sb.append(",AFMA Version: ");
        sb.append(this.zze);
        sb.append(",Ad Unit ID: ");
        sb.append(this.zzd);
        sb.append("}");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza() {
        zzs(this.zza);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb() {
        zzs(this.zza);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzfwn zzfwn) {
        if (!zzt.zzs().zzj(this.zza, this.zzd, this.zze)) {
            zzt.zzs().zzd(this.zza, this.zzd, this.zze);
        } else {
            zzfwn.execute(new zzaf(this));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzfwn zzfwn) {
        if (!zzt.zzs().zzj(this.zza, this.zzd, this.zze)) {
            zzt.zzs().zzd(this.zza, this.zzd, this.zze);
        } else {
            zzfwn.execute(new zzaq(this));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze() {
        zzt.zzs().zzc(this.zza);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf() {
        zzt.zzs().zzc(this.zza);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg() {
        this.zzg = 4;
        zzr();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(AtomicInteger atomicInteger, int i2, int i3, int i4, DialogInterface dialogInterface, int i5) {
        if (atomicInteger.get() != i2) {
            if (atomicInteger.get() == i3) {
                this.zzb.zzk(zzdst.SHAKE);
            } else if (atomicInteger.get() == i4) {
                this.zzb.zzk(zzdst.FLICK);
            } else {
                this.zzb.zzk(zzdst.NONE);
            }
        }
        zzr();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(String str, DialogInterface dialogInterface, int i2) {
        zzt.zzp();
        zzs.zzP(this.zza, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", str), "Share via"));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(int i2, int i3, int i4, int i5, int i6, DialogInterface dialogInterface, int i7) {
        if (i7 == i2) {
            if (!(this.zza instanceof Activity)) {
                zzbzr.zzi("Can not create dialog without Activity Context");
                return;
            }
            String str = this.zzc;
            String str2 = "No debug information";
            if (!TextUtils.isEmpty(str)) {
                Uri build = new Uri.Builder().encodedQuery(str.replaceAll("\\+", "%20")).build();
                StringBuilder sb = new StringBuilder();
                zzt.zzp();
                Map zzL = zzs.zzL(build);
                for (String str3 : zzL.keySet()) {
                    sb.append(str3);
                    sb.append(" = ");
                    sb.append((String) zzL.get(str3));
                    sb.append("\n\n");
                }
                String trim = sb.toString().trim();
                if (!TextUtils.isEmpty(trim)) {
                    str2 = trim;
                }
            }
            zzt.zzp();
            AlertDialog.Builder zzG = zzs.zzG(this.zza);
            zzG.setMessage(str2);
            zzG.setTitle("Ad Information");
            zzG.setPositiveButton("Share", new zzad(this, str2));
            zzG.setNegativeButton("Close", zzae.zza);
            zzG.create().show();
        } else if (i7 == i3) {
            zzbzr.zze("Debug mode [Creative Preview] selected.");
            zzcae.zza.execute(new zzac(this));
        } else if (i7 == i4) {
            zzbzr.zze("Debug mode [Troubleshooting] selected.");
            zzcae.zza.execute(new zzag(this));
        } else if (i7 == i5) {
            zzfwn zzfwn = zzcae.zze;
            zzfwn zzfwn2 = zzcae.zza;
            if (this.zzb.zzo()) {
                zzfwn.execute(new zzan(this));
            } else {
                zzfwn2.execute(new zzao(this, zzfwn));
            }
        } else if (i7 == i6) {
            zzfwn zzfwn3 = zzcae.zze;
            zzfwn zzfwn4 = zzcae.zza;
            if (this.zzb.zzo()) {
                zzfwn3.execute(new zzah(this));
            } else {
                zzfwn4.execute(new zzai(this, zzfwn3));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk() {
        zzaw zzs = zzt.zzs();
        Context context = this.zza;
        String str = this.zzd;
        String str2 = this.zze;
        String str3 = this.zzf;
        boolean zzm = zzs.zzm();
        zzs.zzh(zzs.zzj(context, str, str2));
        if (zzs.zzm()) {
            if (!zzm && !TextUtils.isEmpty(str3)) {
                zzs.zze(context, str2, str3, str);
            }
            zzbzr.zze("Device is linked for debug signals.");
            zzs.zzi(context, "The device is successfully linked for troubleshooting.", false, true);
            return;
        }
        zzs.zzd(context, str, str2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzl() {
        zzaw zzs = zzt.zzs();
        Context context = this.zza;
        String str = this.zzd;
        String str2 = this.zze;
        if (!zzs.zzk(context, str, str2)) {
            zzs.zzi(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
        } else if (TraktV2.API_VERSION.equals(zzs.zza)) {
            zzbzr.zze("Creative is not pushed for this device.");
            zzs.zzi(context, "There was no creative pushed from DFP to the device.", false, false);
        } else if ("1".equals(zzs.zza)) {
            zzbzr.zze("The app is not linked for creative preview.");
            zzs.zzd(context, str, str2);
        } else if ("0".equals(zzs.zza)) {
            zzbzr.zze("Device is linked for in app preview.");
            zzs.zzi(context, "The device is successfully linked for creative preview.", false, true);
        }
    }

    public final void zzm(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int historySize = motionEvent.getHistorySize();
        int pointerCount = motionEvent.getPointerCount();
        if (actionMasked == 0) {
            this.zzg = 0;
            this.zzi = new PointF(motionEvent.getX(0), motionEvent.getY(0));
            return;
        }
        int i2 = this.zzg;
        if (i2 != -1) {
            if (i2 == 0) {
                if (actionMasked == 5) {
                    this.zzg = 5;
                    this.zzj = new PointF(motionEvent.getX(1), motionEvent.getY(1));
                    this.zzk.postDelayed(this.zzl, ((Long) zzba.zzc().zzb(zzbbm.zzet)).longValue());
                }
            } else if (i2 == 5) {
                if (pointerCount == 2) {
                    if (actionMasked == 2) {
                        boolean z2 = false;
                        for (int i3 = 0; i3 < historySize; i3++) {
                            z2 |= !zzt(motionEvent.getHistoricalX(0, i3), motionEvent.getHistoricalY(0, i3), motionEvent.getHistoricalX(1, i3), motionEvent.getHistoricalY(1, i3));
                        }
                        if (zzt(motionEvent.getX(), motionEvent.getY(), motionEvent.getX(1), motionEvent.getY(1)) && !z2) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                this.zzg = -1;
                this.zzk.removeCallbacks(this.zzl);
            }
        }
    }

    public final void zzn(String str) {
        this.zzd = str;
    }

    public final void zzo(String str) {
        this.zze = str;
    }

    public final void zzp(String str) {
        this.zzc = str;
    }

    public final void zzq(String str) {
        this.zzf = str;
    }

    public final void zzr() {
        try {
            if (!(this.zza instanceof Activity)) {
                zzbzr.zzi("Can not create dialog without Activity Context");
                return;
            }
            String str = "Creative preview (enabled)";
            if (true == TextUtils.isEmpty(zzt.zzs().zzb())) {
                str = "Creative preview";
            }
            String str2 = "Troubleshooting (enabled)";
            if (true != zzt.zzs().zzm()) {
                str2 = "Troubleshooting";
            }
            ArrayList arrayList = new ArrayList();
            int zzu = zzu(arrayList, "Ad information", true);
            int zzu2 = zzu(arrayList, str, true);
            int zzu3 = zzu(arrayList, str2, true);
            boolean booleanValue = ((Boolean) zzba.zzc().zzb(zzbbm.zziJ)).booleanValue();
            int zzu4 = zzu(arrayList, "Open ad inspector", booleanValue);
            int zzu5 = zzu(arrayList, "Ad inspector settings", booleanValue);
            zzt.zzp();
            AlertDialog.Builder zzG = zzs.zzG(this.zza);
            zzG.setTitle("Select a debug mode").setItems((CharSequence[]) arrayList.toArray(new String[0]), new zzap(this, zzu, zzu2, zzu3, zzu4, zzu5));
            zzG.create().show();
        } catch (WindowManager.BadTokenException e2) {
            zze.zzb("", e2);
        }
    }

    public zzas(Context context, String str) {
        this(context);
        this.zzc = str;
    }
}
