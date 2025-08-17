package com.google.android.gms.internal.ads;

import android.os.Parcelable;
import com.facebook.common.time.Clock;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.zzt;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

final class zzfbv implements zzfbu {
    private final ConcurrentHashMap zza;
    private final zzfcb zzb;
    private final zzfbx zzc = new zzfbx();

    public zzfbv(zzfcb zzfcb) {
        this.zza = new ConcurrentHashMap(zzfcb.zzd);
        this.zzb = zzfcb;
    }

    private final void zzf() {
        Parcelable.Creator<zzfcb> creator = zzfcb.CREATOR;
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzgf)).booleanValue()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.zzb.zzb);
            sb.append(" PoolCollection");
            sb.append(this.zzc.zzb());
            int i2 = 0;
            for (Map.Entry entry : this.zza.entrySet()) {
                i2++;
                sb.append(i2);
                sb.append(". ");
                sb.append(entry.getValue());
                sb.append("#");
                sb.append(((zzfce) entry.getKey()).hashCode());
                sb.append("    ");
                for (int i3 = 0; i3 < ((zzfbt) entry.getValue()).zzb(); i3++) {
                    sb.append("[O]");
                }
                for (int zzb2 = ((zzfbt) entry.getValue()).zzb(); zzb2 < this.zzb.zzd; zzb2++) {
                    sb.append("[ ]");
                }
                sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
                sb.append(((zzfbt) entry.getValue()).zzg());
                sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            }
            while (i2 < this.zzb.zzc) {
                i2++;
                sb.append(i2);
                sb.append(".\n");
            }
            zzbzr.zze(sb.toString());
        }
    }

    public final zzfcb zza() {
        return this.zzb;
    }

    public final synchronized zzfcd zzb(zzfce zzfce) {
        zzfcd zzfcd;
        zzfbt zzfbt = (zzfbt) this.zza.get(zzfce);
        if (zzfbt != null) {
            zzfcd = zzfbt.zze();
            if (zzfcd == null) {
                this.zzc.zze();
            }
            zzfcr zzf = zzfbt.zzf();
            if (zzfcd != null) {
                zzaxo zza2 = zzaxu.zza();
                zzaxm zza3 = zzaxn.zza();
                zza3.zzd(2);
                zzaxq zza4 = zzaxr.zza();
                zza4.zza(zzf.zza);
                zza4.zzb(zzf.zzb);
                zza3.zza(zza4);
                zza2.zza(zza3);
                zzfcd.zza.zzb().zzc().zze((zzaxu) zza2.zzal());
            }
            zzf();
        } else {
            this.zzc.zzf();
            zzf();
            zzfcd = null;
        }
        return zzfcd;
    }

    @Deprecated
    public final zzfce zzc(zzl zzl, String str, zzw zzw) {
        return new zzfcf(zzl, str, new zzbui(this.zzb.zza).zza().zzk, this.zzb.zzf, zzw);
    }

    public final synchronized boolean zzd(zzfce zzfce, zzfcd zzfcd) {
        boolean zzh;
        zzfbt zzfbt = (zzfbt) this.zza.get(zzfce);
        zzfcd.zzd = zzt.zzB().currentTimeMillis();
        if (zzfbt == null) {
            zzfcb zzfcb = this.zzb;
            zzfbt = new zzfbt(zzfcb.zzd, zzfcb.zze * 1000);
            int size = this.zza.size();
            zzfcb zzfcb2 = this.zzb;
            if (size == zzfcb2.zzc) {
                int i2 = zzfcb2.zzg;
                int i3 = i2 - 1;
                zzfce zzfce2 = null;
                if (i2 != 0) {
                    long j2 = Clock.MAX_TIME;
                    if (i3 == 0) {
                        for (Map.Entry entry : this.zza.entrySet()) {
                            if (((zzfbt) entry.getValue()).zzc() < j2) {
                                j2 = ((zzfbt) entry.getValue()).zzc();
                                zzfce2 = (zzfce) entry.getKey();
                            }
                        }
                        if (zzfce2 != null) {
                            this.zza.remove(zzfce2);
                        }
                    } else if (i3 == 1) {
                        for (Map.Entry entry2 : this.zza.entrySet()) {
                            if (((zzfbt) entry2.getValue()).zzd() < j2) {
                                j2 = ((zzfbt) entry2.getValue()).zzd();
                                zzfce2 = (zzfce) entry2.getKey();
                            }
                        }
                        if (zzfce2 != null) {
                            this.zza.remove(zzfce2);
                        }
                    } else if (i3 == 2) {
                        int i4 = Integer.MAX_VALUE;
                        for (Map.Entry entry3 : this.zza.entrySet()) {
                            if (((zzfbt) entry3.getValue()).zza() < i4) {
                                i4 = ((zzfbt) entry3.getValue()).zza();
                                zzfce2 = (zzfce) entry3.getKey();
                            }
                        }
                        if (zzfce2 != null) {
                            this.zza.remove(zzfce2);
                        }
                    }
                    this.zzc.zzg();
                } else {
                    throw null;
                }
            }
            this.zza.put(zzfce, zzfbt);
            this.zzc.zzd();
        }
        zzh = zzfbt.zzh(zzfcd);
        this.zzc.zzc();
        zzfbw zza2 = this.zzc.zza();
        zzfcr zzf = zzfbt.zzf();
        zzaxo zza3 = zzaxu.zza();
        zzaxm zza4 = zzaxn.zza();
        zza4.zzd(2);
        zzaxs zza5 = zzaxt.zza();
        zza5.zza(zza2.zza);
        zza5.zzb(zza2.zzb);
        zza5.zzc(zzf.zzb);
        zza4.zzc(zza5);
        zza3.zza(zza4);
        zzfcd.zza.zzb().zzc().zzf((zzaxu) zza3.zzal());
        zzf();
        return zzh;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
        if (r3.zzb() >= r2.zzb.zzd) goto L_0x0018;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0018, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zze(com.google.android.gms.internal.ads.zzfce r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.concurrent.ConcurrentHashMap r0 = r2.zza     // Catch:{ all -> 0x001c }
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x001c }
            com.google.android.gms.internal.ads.zzfbt r3 = (com.google.android.gms.internal.ads.zzfbt) r3     // Catch:{ all -> 0x001c }
            r0 = 1
            if (r3 == 0) goto L_0x001a
            int r3 = r3.zzb()     // Catch:{ all -> 0x001c }
            com.google.android.gms.internal.ads.zzfcb r1 = r2.zzb     // Catch:{ all -> 0x001c }
            int r1 = r1.zzd     // Catch:{ all -> 0x001c }
            monitor-exit(r2)
            if (r3 >= r1) goto L_0x0018
            return r0
        L_0x0018:
            r3 = 0
            return r3
        L_0x001a:
            monitor-exit(r2)
            return r0
        L_0x001c:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfbv.zze(com.google.android.gms.internal.ads.zzfce):boolean");
    }
}
