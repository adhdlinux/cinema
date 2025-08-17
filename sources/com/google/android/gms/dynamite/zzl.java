package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class zzl implements DynamiteModule.VersionPolicy {
    zzl() {
    }

    public final DynamiteModule.VersionPolicy.SelectionResult selectModule(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) throws DynamiteModule.LoadingException {
        int i2;
        DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
        int zza = iVersions.zza(context, str);
        selectionResult.localVersion = zza;
        int i3 = 0;
        if (zza != 0) {
            i2 = iVersions.zzb(context, str, false);
            selectionResult.remoteVersion = i2;
        } else {
            i2 = iVersions.zzb(context, str, true);
            selectionResult.remoteVersion = i2;
        }
        int i4 = selectionResult.localVersion;
        if (i4 != 0) {
            i3 = i4;
        } else if (i2 == 0) {
            selectionResult.selection = 0;
            return selectionResult;
        }
        if (i2 >= i3) {
            selectionResult.selection = 1;
        } else {
            selectionResult.selection = -1;
        }
        return selectionResult;
    }
}
