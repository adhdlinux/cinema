package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class zzgvp implements Iterator, Closeable, zzamx {
    private static final zzamw zza = new zzgvo("eof ");
    private static final zzgvw zzb = zzgvw.zzb(zzgvp.class);
    protected zzamt zzc;
    protected zzgvq zzd;
    zzamw zze = null;
    long zzf = 0;
    long zzg = 0;
    private final List zzh = new ArrayList();

    public void close() throws IOException {
    }

    public final boolean hasNext() {
        zzamw zzamw = this.zze;
        if (zzamw == zza) {
            return false;
        }
        if (zzamw != null) {
            return true;
        }
        try {
            this.zze = next();
            return true;
        } catch (NoSuchElementException unused) {
            this.zze = zza;
            return false;
        }
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        for (int i2 = 0; i2 < this.zzh.size(); i2++) {
            if (i2 > 0) {
                sb.append(";");
            }
            sb.append(((zzamw) this.zzh.get(i2)).toString());
        }
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: zzd */
    public final zzamw next() {
        zzamw zzb2;
        zzamw zzamw = this.zze;
        if (zzamw == null || zzamw == zza) {
            zzgvq zzgvq = this.zzd;
            if (zzgvq == null || this.zzf >= this.zzg) {
                this.zze = zza;
                throw new NoSuchElementException();
            }
            try {
                synchronized (zzgvq) {
                    this.zzd.zze(this.zzf);
                    zzb2 = this.zzc.zzb(this.zzd, this);
                    this.zzf = this.zzd.zzb();
                }
                return zzb2;
            } catch (EOFException unused) {
                throw new NoSuchElementException();
            } catch (IOException unused2) {
                throw new NoSuchElementException();
            }
        } else {
            this.zze = null;
            return zzamw;
        }
    }

    public final List zze() {
        return (this.zzd == null || this.zze == zza) ? this.zzh : new zzgvv(this.zzh, this);
    }

    public final void zzf(zzgvq zzgvq, long j2, zzamt zzamt) throws IOException {
        this.zzd = zzgvq;
        this.zzf = zzgvq.zzb();
        zzgvq.zze(zzgvq.zzb() + j2);
        this.zzg = zzgvq.zzb();
        this.zzc = zzamt;
    }
}
