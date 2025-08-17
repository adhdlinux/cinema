package com.google.android.gms.internal.ads;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

final class zzame extends FilterInputStream {
    private final long zza;
    private long zzb;

    zzame(InputStream inputStream, long j2) {
        super(inputStream);
        this.zza = j2;
    }

    public final int read() throws IOException {
        int read = super.read();
        if (read != -1) {
            this.zzb++;
        }
        return read;
    }

    /* access modifiers changed from: package-private */
    public final long zza() {
        return this.zza - this.zzb;
    }

    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        int read = super.read(bArr, i2, i3);
        if (read != -1) {
            this.zzb += (long) read;
        }
        return read;
    }
}
