package com.google.android.gms.cast.framework.media.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.RemoteException;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.internal.cast.zzaf;

public final class zzf extends AsyncTask {
    private static final Logger zza = new Logger("FetchBitmapTask");
    private final zzi zzb;
    private final zzb zzc;

    public zzf(Context context, int i2, int i3, boolean z2, long j2, int i4, int i5, int i6, zzb zzb2) {
        this.zzc = zzb2;
        this.zzb = zzaf.zze(context.getApplicationContext(), this, new zze(this, (zzd) null), i2, i3, false, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, 5, 333, 10000);
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        Uri uri;
        zzi zzi;
        Uri[] uriArr = (Uri[]) objArr;
        if (uriArr.length != 1 || (uri = uriArr[0]) == null || (zzi = this.zzb) == null) {
            return null;
        }
        try {
            return zzi.zze(uri);
        } catch (RemoteException e2) {
            zza.d(e2, "Unable to call %s on %s.", "doFetch", zzi.class.getSimpleName());
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        zzb zzb2 = this.zzc;
        if (zzb2 != null) {
            zzb2.zzb(bitmap);
        }
    }
}
