package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

final class zzgpz extends InputStream {
    private Iterator zza;
    private ByteBuffer zzb;
    private int zzc = 0;
    private int zzd;
    private int zze;
    private boolean zzf;
    private byte[] zzg;
    private int zzh;
    private long zzi;

    zzgpz(Iterable iterable) {
        this.zza = iterable.iterator();
        Iterator it2 = iterable.iterator();
        while (it2.hasNext()) {
            ByteBuffer byteBuffer = (ByteBuffer) it2.next();
            this.zzc++;
        }
        this.zzd = -1;
        if (!zzb()) {
            this.zzb = zzgpw.zze;
            this.zzd = 0;
            this.zze = 0;
            this.zzi = 0;
        }
    }

    private final void zza(int i2) {
        int i3 = this.zze + i2;
        this.zze = i3;
        if (i3 == this.zzb.limit()) {
            zzb();
        }
    }

    private final boolean zzb() {
        this.zzd++;
        if (!this.zza.hasNext()) {
            return false;
        }
        ByteBuffer byteBuffer = (ByteBuffer) this.zza.next();
        this.zzb = byteBuffer;
        this.zze = byteBuffer.position();
        if (this.zzb.hasArray()) {
            this.zzf = true;
            this.zzg = this.zzb.array();
            this.zzh = this.zzb.arrayOffset();
        } else {
            this.zzf = false;
            this.zzi = zzgsq.zze(this.zzb);
            this.zzg = null;
        }
        return true;
    }

    public final int read() throws IOException {
        if (this.zzd == this.zzc) {
            return -1;
        }
        if (this.zzf) {
            byte b2 = this.zzg[this.zze + this.zzh] & 255;
            zza(1);
            return b2;
        }
        byte zza2 = zzgsq.zza(((long) this.zze) + this.zzi) & 255;
        zza(1);
        return zza2;
    }

    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        if (this.zzd == this.zzc) {
            return -1;
        }
        int limit = this.zzb.limit();
        int i4 = this.zze;
        int i5 = limit - i4;
        if (i3 > i5) {
            i3 = i5;
        }
        if (this.zzf) {
            System.arraycopy(this.zzg, i4 + this.zzh, bArr, i2, i3);
            zza(i3);
        } else {
            int position = this.zzb.position();
            this.zzb.position(this.zze);
            this.zzb.get(bArr, i2, i3);
            this.zzb.position(position);
            zza(i3);
        }
        return i3;
    }
}
