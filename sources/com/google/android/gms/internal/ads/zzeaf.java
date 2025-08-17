package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzt;
import java.util.ArrayList;

public final class zzeaf extends zzeag {
    private static final SparseArray zzb;
    private final Context zzc;
    private final zzcuk zzd;
    private final TelephonyManager zze;
    /* access modifiers changed from: private */
    public final zzdzx zzf;
    private int zzg;

    static {
        SparseArray sparseArray = new SparseArray();
        zzb = sparseArray;
        sparseArray.put(NetworkInfo.DetailedState.CONNECTED.ordinal(), zzazm.CONNECTED);
        int ordinal = NetworkInfo.DetailedState.AUTHENTICATING.ordinal();
        zzazm zzazm = zzazm.CONNECTING;
        sparseArray.put(ordinal, zzazm);
        sparseArray.put(NetworkInfo.DetailedState.CONNECTING.ordinal(), zzazm);
        sparseArray.put(NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal(), zzazm);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTING.ordinal(), zzazm.DISCONNECTING);
        int ordinal2 = NetworkInfo.DetailedState.BLOCKED.ordinal();
        zzazm zzazm2 = zzazm.DISCONNECTED;
        sparseArray.put(ordinal2, zzazm2);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTED.ordinal(), zzazm2);
        sparseArray.put(NetworkInfo.DetailedState.FAILED.ordinal(), zzazm2);
        sparseArray.put(NetworkInfo.DetailedState.IDLE.ordinal(), zzazm2);
        sparseArray.put(NetworkInfo.DetailedState.SCANNING.ordinal(), zzazm2);
        sparseArray.put(NetworkInfo.DetailedState.SUSPENDED.ordinal(), zzazm.SUSPENDED);
        sparseArray.put(NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), zzazm);
        sparseArray.put(NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal(), zzazm);
    }

    zzeaf(Context context, zzcuk zzcuk, zzdzx zzdzx, zzdzt zzdzt, zzg zzg2) {
        super(zzdzt, zzg2);
        this.zzc = context;
        this.zzd = zzcuk;
        this.zzf = zzdzx;
        this.zze = (TelephonyManager) context.getSystemService("phone");
    }

    static /* bridge */ /* synthetic */ zzazd zza(zzeaf zzeaf, Bundle bundle) {
        zzayw zza = zzazd.zza();
        int i2 = bundle.getInt("cnt", -2);
        int i3 = bundle.getInt("gnt", 0);
        int i4 = 2;
        if (i2 == -1) {
            zzeaf.zzg = 2;
        } else {
            zzeaf.zzg = 1;
            if (i2 == 0) {
                zza.zzb(2);
            } else if (i2 != 1) {
                zza.zzb(1);
            } else {
                zza.zzb(3);
            }
            switch (i3) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    i4 = 3;
                    break;
                case 13:
                    i4 = 5;
                    break;
                default:
                    i4 = 1;
                    break;
            }
            zza.zza(i4);
        }
        return (zzazd) zza.zzal();
    }

    static /* bridge */ /* synthetic */ zzazm zzb(zzeaf zzeaf, Bundle bundle) {
        return (zzazm) zzb.get(zzfat.zza(zzfat.zza(bundle, "device"), "network").getInt("active_network_state", -1), zzazm.UNSPECIFIED);
    }

    static /* bridge */ /* synthetic */ byte[] zze(zzeaf zzeaf, boolean z2, ArrayList arrayList, zzazd zzazd, zzazm zzazm) {
        boolean z3;
        zzazh zzg2 = zzazi.zzg();
        zzg2.zza(arrayList);
        boolean z4 = false;
        if (Settings.Global.getInt(zzeaf.zzc.getContentResolver(), "airplane_mode_on", 0) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzg2.zzi(zzg(z3));
        zzg2.zzj(zzt.zzq().zzj(zzeaf.zzc, zzeaf.zze));
        zzg2.zzf(zzeaf.zzf.zze());
        zzg2.zze(zzeaf.zzf.zzb());
        zzg2.zzb(zzeaf.zzf.zza());
        zzg2.zzc(zzazm);
        zzg2.zzd(zzazd);
        zzg2.zzk(zzeaf.zzg);
        zzg2.zzl(zzg(z2));
        zzg2.zzh(zzeaf.zzf.zzd());
        zzg2.zzg(zzt.zzB().currentTimeMillis());
        if (Settings.Global.getInt(zzeaf.zzc.getContentResolver(), "wifi_on", 0) != 0) {
            z4 = true;
        }
        zzg2.zzm(zzg(z4));
        return ((zzazi) zzg2.zzal()).zzax();
    }

    private static final int zzg(boolean z2) {
        return z2 ? 2 : 1;
    }

    public final void zzd(boolean z2) {
        zzfwc.zzq(this.zzd.zzb(), new zzeae(this, z2), zzcae.zzf);
    }
}
