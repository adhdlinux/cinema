package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class zzgu extends zzfy {
    private RandomAccessFile zza;
    private Uri zzb;
    private long zzc;
    private boolean zzd;

    public zzgu() {
        super(false);
    }

    public final int zza(byte[] bArr, int i2, int i3) throws zzgt {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.zzc;
        if (j2 == 0) {
            return -1;
        }
        try {
            RandomAccessFile randomAccessFile = this.zza;
            int i4 = zzfj.zza;
            int read = randomAccessFile.read(bArr, i2, (int) Math.min(j2, (long) i3));
            if (read > 0) {
                this.zzc -= (long) read;
                zzg(read);
            }
            return read;
        } catch (IOException e2) {
            throw new zzgt(e2, 2000);
        }
    }

    public final long zzb(zzgj zzgj) throws zzgt {
        Uri uri = zzgj.zza;
        this.zzb = uri;
        zzi(zzgj);
        int i2 = 2006;
        try {
            String path = uri.getPath();
            path.getClass();
            RandomAccessFile randomAccessFile = new RandomAccessFile(path, "r");
            this.zza = randomAccessFile;
            try {
                randomAccessFile.seek(zzgj.zzf);
                long j2 = zzgj.zzg;
                if (j2 == -1) {
                    j2 = this.zza.length() - zzgj.zzf;
                }
                this.zzc = j2;
                if (j2 >= 0) {
                    this.zzd = true;
                    zzj(zzgj);
                    return this.zzc;
                }
                throw new zzgt((String) null, (Throwable) null, 2008);
            } catch (IOException e2) {
                throw new zzgt(e2, 2000);
            }
        } catch (FileNotFoundException e3) {
            if (!TextUtils.isEmpty(uri.getQuery()) || !TextUtils.isEmpty(uri.getFragment())) {
                throw new zzgt(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", new Object[]{uri.getPath(), uri.getQuery(), uri.getFragment()}), e3, GeofenceStatusCodes.GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION);
            }
            if (zzfj.zza < 21 || !zzgs.zzb(e3.getCause())) {
                i2 = 2005;
            }
            throw new zzgt(e3, i2);
        } catch (SecurityException e4) {
            throw new zzgt(e4, 2006);
        } catch (RuntimeException e5) {
            throw new zzgt(e5, 2000);
        }
    }

    public final Uri zzc() {
        return this.zzb;
    }

    public final void zzd() throws zzgt {
        this.zzb = null;
        try {
            RandomAccessFile randomAccessFile = this.zza;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            this.zza = null;
            if (this.zzd) {
                this.zzd = false;
                zzh();
            }
        } catch (IOException e2) {
            throw new zzgt(e2, 2000);
        } catch (Throwable th) {
            this.zza = null;
            if (this.zzd) {
                this.zzd = false;
                zzh();
            }
            throw th;
        }
    }
}
