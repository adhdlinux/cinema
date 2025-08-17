package com.google.android.gms.internal.ads;

import android.os.Environment;
import android.util.Base64;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public final class zzawz {
    private final zzaxf zza;
    private final zzayo zzb;
    private final boolean zzc;

    private zzawz() {
        this.zzb = zzayp.zzd();
        this.zzc = false;
        this.zza = new zzaxf();
    }

    public static zzawz zza() {
        return new zzawz();
    }

    private final synchronized String zzd(int i2) {
        return String.format("id=%s,timestamp=%s,event=%s,data=%s\n", new Object[]{this.zzb.zzk(), Long.valueOf(zzt.zzB().elapsedRealtime()), Integer.valueOf(i2 - 1), Base64.encodeToString(((zzayp) this.zzb.zzal()).zzax(), 3)});
    }

    private final synchronized void zze(int i2) {
        FileOutputStream fileOutputStream;
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            try {
                fileOutputStream = new FileOutputStream(new File(externalStorageDirectory, "clearcut_events.txt"), true);
                try {
                    fileOutputStream.write(zzd(i2).getBytes());
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                        zze.zza("Could not close Clearcut output stream.");
                    }
                } catch (IOException unused2) {
                    zze.zza("Could not write Clearcut to file.");
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused3) {
                        zze.zza("Could not close Clearcut output stream.");
                    }
                }
            } catch (FileNotFoundException unused4) {
                zze.zza("Could not find file for Clearcut");
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused5) {
                    zze.zza("Could not close Clearcut output stream.");
                }
                throw th;
            }
        }
    }

    private final synchronized void zzf(int i2) {
        zzayo zzayo = this.zzb;
        zzayo.zzd();
        zzayo.zzc(zzs.zzd());
        zzaxe zzaxe = new zzaxe(this.zza, ((zzayp) this.zzb.zzal()).zzax(), (zzaxd) null);
        int i3 = i2 - 1;
        zzaxe.zza(i3);
        zzaxe.zzc();
        zze.zza("Logging Event with event code : ".concat(String.valueOf(Integer.toString(i3, 10))));
    }

    public final synchronized void zzb(zzawy zzawy) {
        if (this.zzc) {
            try {
                zzawy.zza(this.zzb);
            } catch (NullPointerException e2) {
                zzt.zzo().zzu(e2, "AdMobClearcutLogger.modify");
            }
        }
    }

    public final synchronized void zzc(int i2) {
        if (this.zzc) {
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzeH)).booleanValue()) {
                zze(i2);
            } else {
                zzf(i2);
            }
        }
    }

    public zzawz(zzaxf zzaxf) {
        this.zzb = zzayp.zzd();
        this.zza = zzaxf;
        this.zzc = ((Boolean) zzba.zzc().zzb(zzbbm.zzeG)).booleanValue();
    }
}
