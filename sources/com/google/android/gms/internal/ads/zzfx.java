package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class zzfx extends zzfy {
    private final AssetManager zza;
    private Uri zzb;
    private InputStream zzc;
    private long zzd;
    private boolean zze;

    public zzfx(Context context) {
        super(false);
        this.zza = context.getAssets();
    }

    public final int zza(byte[] bArr, int i2, int i3) throws zzfw {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.zzd;
        if (j2 == 0) {
            return -1;
        }
        if (j2 != -1) {
            try {
                i3 = (int) Math.min(j2, (long) i3);
            } catch (IOException e2) {
                throw new zzfw(e2, 2000);
            }
        }
        InputStream inputStream = this.zzc;
        int i4 = zzfj.zza;
        int read = inputStream.read(bArr, i2, i3);
        if (read == -1) {
            return -1;
        }
        long j3 = this.zzd;
        if (j3 != -1) {
            this.zzd = j3 - ((long) read);
        }
        zzg(read);
        return read;
    }

    public final long zzb(zzgj zzgj) throws zzfw {
        int i2;
        try {
            Uri uri = zzgj.zza;
            this.zzb = uri;
            String path = uri.getPath();
            path.getClass();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            zzi(zzgj);
            InputStream open = this.zza.open(path, 1);
            this.zzc = open;
            if (open.skip(zzgj.zzf) >= zzgj.zzf) {
                long j2 = zzgj.zzg;
                if (j2 != -1) {
                    this.zzd = j2;
                } else {
                    long available = (long) this.zzc.available();
                    this.zzd = available;
                    if (available == 2147483647L) {
                        this.zzd = -1;
                    }
                }
                this.zze = true;
                zzj(zzgj);
                return this.zzd;
            }
            throw new zzfw((Throwable) null, 2008);
        } catch (zzfw e2) {
            throw e2;
        } catch (IOException e3) {
            if (true != (e3 instanceof FileNotFoundException)) {
                i2 = 2000;
            } else {
                i2 = 2005;
            }
            throw new zzfw(e3, i2);
        }
    }

    public final Uri zzc() {
        return this.zzb;
    }

    public final void zzd() throws zzfw {
        this.zzb = null;
        try {
            InputStream inputStream = this.zzc;
            if (inputStream != null) {
                inputStream.close();
            }
            this.zzc = null;
            if (this.zze) {
                this.zze = false;
                zzh();
            }
        } catch (IOException e2) {
            throw new zzfw(e2, 2000);
        } catch (Throwable th) {
            this.zzc = null;
            if (this.zze) {
                this.zze = false;
                zzh();
            }
            throw th;
        }
    }
}
