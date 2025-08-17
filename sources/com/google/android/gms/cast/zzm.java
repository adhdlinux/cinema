package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.internal.zzak;
import com.google.android.gms.cast.internal.zzw;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.io.IOException;

public final class zzm implements Cast.CastApi {
    public final int getActiveInputState(GoogleApiClient googleApiClient) throws IllegalStateException {
        return ((zzw) googleApiClient.getClient(zzak.zza)).zzr();
    }

    public final ApplicationMetadata getApplicationMetadata(GoogleApiClient googleApiClient) throws IllegalStateException {
        return ((zzw) googleApiClient.getClient(zzak.zza)).zzt();
    }

    public final String getApplicationStatus(GoogleApiClient googleApiClient) throws IllegalStateException {
        return ((zzw) googleApiClient.getClient(zzak.zza)).zzz();
    }

    public final int getStandbyState(GoogleApiClient googleApiClient) throws IllegalStateException {
        return ((zzw) googleApiClient.getClient(zzak.zza)).zzs();
    }

    public final double getVolume(GoogleApiClient googleApiClient) throws IllegalStateException {
        return ((zzw) googleApiClient.getClient(zzak.zza)).zzq();
    }

    public final boolean isMute(GoogleApiClient googleApiClient) throws IllegalStateException {
        return ((zzw) googleApiClient.getClient(zzak.zza)).zzX();
    }

    public final PendingResult<Cast.ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient) {
        return zza(googleApiClient, (String) null, (String) null, (zzbu) null);
    }

    public final PendingResult<Cast.ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.execute(new zzg(this, googleApiClient, str));
    }

    public final PendingResult<Status> leaveApplication(GoogleApiClient googleApiClient) {
        return googleApiClient.execute(new zzj(this, googleApiClient));
    }

    public final void removeMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str) throws IOException, IllegalArgumentException {
        try {
            ((zzw) googleApiClient.getClient(zzak.zza)).zzO(str);
        } catch (RemoteException unused) {
            throw new IOException("service error");
        }
    }

    public final void requestStatus(GoogleApiClient googleApiClient) throws IOException, IllegalStateException {
        try {
            ((zzw) googleApiClient.getClient(zzak.zza)).zzP();
        } catch (RemoteException unused) {
            throw new IOException("service error");
        }
    }

    public final PendingResult<Status> sendMessage(GoogleApiClient googleApiClient, String str, String str2) {
        return googleApiClient.execute(new zzf(this, googleApiClient, str, str2));
    }

    public final void setMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str, Cast.MessageReceivedCallback messageReceivedCallback) throws IOException, IllegalStateException {
        try {
            ((zzw) googleApiClient.getClient(zzak.zza)).zzS(str, messageReceivedCallback);
        } catch (RemoteException unused) {
            throw new IOException("service error");
        }
    }

    public final void setMute(GoogleApiClient googleApiClient, boolean z2) throws IOException, IllegalStateException {
        try {
            ((zzw) googleApiClient.getClient(zzak.zza)).zzT(z2);
        } catch (RemoteException unused) {
            throw new IOException("service error");
        }
    }

    public final void setVolume(GoogleApiClient googleApiClient, double d2) throws IOException, IllegalArgumentException, IllegalStateException {
        try {
            ((zzw) googleApiClient.getClient(zzak.zza)).zzU(d2);
        } catch (RemoteException unused) {
            throw new IOException("service error");
        }
    }

    public final PendingResult<Status> stopApplication(GoogleApiClient googleApiClient) {
        return googleApiClient.execute(new zzk(this, googleApiClient));
    }

    @ShowFirstParty
    public final PendingResult zza(GoogleApiClient googleApiClient, String str, String str2, zzbu zzbu) {
        return googleApiClient.execute(new zzi(this, googleApiClient, str, str2, (zzbu) null));
    }

    public final PendingResult<Cast.ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str) {
        return zza(googleApiClient, str, (String) null, (zzbu) null);
    }

    public final PendingResult<Cast.ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, LaunchOptions launchOptions) {
        return googleApiClient.execute(new zzh(this, googleApiClient, str, launchOptions));
    }

    public final PendingResult<Status> stopApplication(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.execute(new zzl(this, googleApiClient, str));
    }

    public final PendingResult<Cast.ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str, String str2) {
        return zza(googleApiClient, str, str2, (zzbu) null);
    }

    @Deprecated
    public final PendingResult<Cast.ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, boolean z2) {
        LaunchOptions.Builder builder = new LaunchOptions.Builder();
        builder.setRelaunchIfRunning(z2);
        return googleApiClient.execute(new zzh(this, googleApiClient, str, builder.build()));
    }
}
