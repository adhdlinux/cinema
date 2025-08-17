package com.google.android.gms.internal.ads;

import java.io.IOException;

public class zzgpy extends IOException {
    private zzgqw zza = null;
    private boolean zzb;

    public zzgpy(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    static zzgpx zza() {
        return new zzgpx("Protocol message tag had invalid wire type.");
    }

    static zzgpy zzb() {
        return new zzgpy("Protocol message end-group tag did not match expected tag.");
    }

    static zzgpy zzc() {
        return new zzgpy("Protocol message contained an invalid tag (zero).");
    }

    static zzgpy zzd() {
        return new zzgpy("Protocol message had invalid UTF-8.");
    }

    static zzgpy zze() {
        return new zzgpy("CodedInputStream encountered a malformed varint.");
    }

    static zzgpy zzf() {
        return new zzgpy("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzgpy zzg() {
        return new zzgpy("Failed to parse the message.");
    }

    static zzgpy zzi() {
        return new zzgpy("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    static zzgpy zzj() {
        return new zzgpy("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public final zzgpy zzh(zzgqw zzgqw) {
        this.zza = zzgqw;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final void zzk() {
        this.zzb = true;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzl() {
        return this.zzb;
    }

    public zzgpy(String str) {
        super(str);
    }
}
