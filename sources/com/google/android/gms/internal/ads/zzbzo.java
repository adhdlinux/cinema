package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import com.google.android.gms.common.util.Base64Utils;

public final /* synthetic */ class zzbzo implements zzbzp {
    public final /* synthetic */ byte[] zza;

    public /* synthetic */ zzbzo(byte[] bArr) {
        this.zza = bArr;
    }

    public final void zza(JsonWriter jsonWriter) {
        byte[] bArr = this.zza;
        int i2 = zzbzq.zza;
        jsonWriter.name("params").beginObject();
        int length = bArr.length;
        String encode = Base64Utils.encode(bArr);
        if (length < 10000) {
            jsonWriter.name("body").value(encode);
        } else {
            String zze = zzbzk.zze(encode);
            if (zze != null) {
                jsonWriter.name("bodydigest").value(zze);
            }
        }
        jsonWriter.name("bodylength").value((long) length);
        jsonWriter.endObject();
    }
}
