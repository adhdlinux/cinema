package com.google.android.gms.cast.framework;

import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import java.util.HashSet;

final class zzo extends Cast.Listener {
    final /* synthetic */ CastSession zza;

    /* synthetic */ zzo(CastSession castSession, zzn zzn) {
        this.zza = castSession;
    }

    public final void onActiveInputStateChanged(int i2) {
        for (Cast.Listener onActiveInputStateChanged : new HashSet(this.zza.zzd)) {
            onActiveInputStateChanged.onActiveInputStateChanged(i2);
        }
    }

    public final void onApplicationDisconnected(int i2) {
        CastSession.zzg(this.zza, i2);
        this.zza.notifySessionEnded(i2);
        for (Cast.Listener onApplicationDisconnected : new HashSet(this.zza.zzd)) {
            onApplicationDisconnected.onApplicationDisconnected(i2);
        }
    }

    public final void onApplicationMetadataChanged(ApplicationMetadata applicationMetadata) {
        for (Cast.Listener onApplicationMetadataChanged : new HashSet(this.zza.zzd)) {
            onApplicationMetadataChanged.onApplicationMetadataChanged(applicationMetadata);
        }
    }

    public final void onApplicationStatusChanged() {
        for (Cast.Listener onApplicationStatusChanged : new HashSet(this.zza.zzd)) {
            onApplicationStatusChanged.onApplicationStatusChanged();
        }
    }

    public final void onStandbyStateChanged(int i2) {
        for (Cast.Listener onStandbyStateChanged : new HashSet(this.zza.zzd)) {
            onStandbyStateChanged.onStandbyStateChanged(i2);
        }
    }

    public final void onVolumeChanged() {
        for (Cast.Listener onVolumeChanged : new HashSet(this.zza.zzd)) {
            onVolumeChanged.onVolumeChanged();
        }
    }
}
