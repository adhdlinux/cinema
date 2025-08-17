package com.google.android.gms.internal.ads;

import android.util.Base64OutputStream;
import com.google.protobuf.CodedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

final class zzavd {
    ByteArrayOutputStream zza = new ByteArrayOutputStream(CodedOutputStream.DEFAULT_BUFFER_SIZE);
    Base64OutputStream zzb = new Base64OutputStream(this.zza, 10);

    public final String toString() {
        try {
            this.zzb.close();
        } catch (IOException e2) {
            zzbzr.zzh("HashManager: Unable to convert to Base64.", e2);
        }
        try {
            this.zza.close();
            return this.zza.toString();
        } catch (IOException e3) {
            zzbzr.zzh("HashManager: Unable to convert to Base64.", e3);
            return "";
        } finally {
            this.zza = null;
            this.zzb = null;
        }
    }
}
