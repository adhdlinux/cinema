package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzfin implements zzfhs {
    private static final zzfin zza = new zzfin();
    private static final Handler zzb = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public static Handler zzc = null;
    /* access modifiers changed from: private */
    public static final Runnable zzd = new zzfij();
    /* access modifiers changed from: private */
    public static final Runnable zze = new zzfik();
    private final List zzf = new ArrayList();
    private int zzg;
    private boolean zzh = false;
    private final List zzi = new ArrayList();
    private final zzfhu zzj = new zzfhu();
    private final zzfig zzk = new zzfig();
    /* access modifiers changed from: private */
    public final zzfih zzl = new zzfih(new zzfiq());
    private long zzm;

    zzfin() {
    }

    public static zzfin zzd() {
        return zza;
    }

    static /* bridge */ /* synthetic */ void zzg(zzfin zzfin) {
        zzfin.zzg = 0;
        zzfin.zzi.clear();
        zzfin.zzh = false;
        for (zzfha zzfha : zzfhl.zza().zzb()) {
        }
        zzfin.zzm = System.nanoTime();
        zzfin.zzk.zzi();
        long nanoTime = System.nanoTime();
        zzfht zza2 = zzfin.zzj.zza();
        if (zzfin.zzk.zze().size() > 0) {
            Iterator it2 = zzfin.zzk.zze().iterator();
            while (it2.hasNext()) {
                String str = (String) it2.next();
                JSONObject zza3 = zzfib.zza(0, 0, 0, 0);
                View zza4 = zzfin.zzk.zza(str);
                zzfht zzb2 = zzfin.zzj.zzb();
                String zzc2 = zzfin.zzk.zzc(str);
                if (zzc2 != null) {
                    JSONObject zza5 = zzb2.zza(zza4);
                    zzfib.zzb(zza5, str);
                    try {
                        zza5.put("notVisibleReason", zzc2);
                    } catch (JSONException e2) {
                        zzfic.zza("Error with setting not visible reason", e2);
                    }
                    zzfib.zzc(zza3, zza5);
                }
                zzfib.zzf(zza3);
                HashSet hashSet = new HashSet();
                hashSet.add(str);
                zzfin.zzl.zzc(zza3, hashSet, nanoTime);
            }
        }
        if (zzfin.zzk.zzf().size() > 0) {
            JSONObject zza6 = zzfib.zza(0, 0, 0, 0);
            zzfin.zzk((View) null, zza2, zza6, 1, false);
            zzfib.zzf(zza6);
            zzfin.zzl.zzd(zza6, zzfin.zzk.zzf(), nanoTime);
        } else {
            zzfin.zzl.zzb();
        }
        zzfin.zzk.zzg();
        long nanoTime2 = System.nanoTime() - zzfin.zzm;
        if (zzfin.zzf.size() > 0) {
            for (zzfim zzfim : zzfin.zzf) {
                TimeUnit.NANOSECONDS.toMillis(nanoTime2);
                zzfim.zzb();
                if (zzfim instanceof zzfil) {
                    ((zzfil) zzfim).zza();
                }
            }
        }
    }

    private final void zzk(View view, zzfht zzfht, JSONObject jSONObject, int i2, boolean z2) {
        zzfht.zzb(view, jSONObject, this, i2 == 1, z2);
    }

    private static final void zzl() {
        Handler handler = zzc;
        if (handler != null) {
            handler.removeCallbacks(zze);
            zzc = null;
        }
    }

    public final void zza(View view, zzfht zzfht, JSONObject jSONObject, boolean z2) {
        int zzk2;
        boolean z3;
        boolean z4;
        if (zzfie.zzb(view) == null && (zzk2 = this.zzk.zzk(view)) != 3) {
            JSONObject zza2 = zzfht.zza(view);
            zzfib.zzc(jSONObject, zza2);
            String zzd2 = this.zzk.zzd(view);
            if (zzd2 != null) {
                zzfib.zzb(zza2, zzd2);
                try {
                    zza2.put("hasWindowFocus", Boolean.valueOf(this.zzk.zzj(view)));
                } catch (JSONException e2) {
                    zzfic.zza("Error with setting not visible reason", e2);
                }
                this.zzk.zzh();
            } else {
                zzfif zzb2 = this.zzk.zzb(view);
                if (zzb2 != null) {
                    zzfhn zza3 = zzb2.zza();
                    JSONArray jSONArray = new JSONArray();
                    ArrayList zzb3 = zzb2.zzb();
                    int size = zzb3.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        jSONArray.put((String) zzb3.get(i2));
                    }
                    try {
                        zza2.put("isFriendlyObstructionFor", jSONArray);
                        zza2.put("friendlyObstructionClass", zza3.zzd());
                        zza2.put("friendlyObstructionPurpose", zza3.zza());
                        zza2.put("friendlyObstructionReason", zza3.zzc());
                    } catch (JSONException e3) {
                        zzfic.zza("Error with setting friendly obstruction", e3);
                    }
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z2 || z3) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                zzk(view, zzfht, zza2, zzk2, z4);
            }
            this.zzg++;
        }
    }

    public final void zzh() {
        zzl();
    }

    public final void zzi() {
        if (zzc == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            zzc = handler;
            handler.post(zzd);
            zzc.postDelayed(zze, 200);
        }
    }

    public final void zzj() {
        zzl();
        this.zzf.clear();
        zzb.post(new zzfii(this));
    }
}
