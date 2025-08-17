package com.google.android.gms.cast.framework.media.internal;

import android.content.Intent;
import android.support.v4.media.session.MediaSessionCompat;
import android.view.KeyEvent;
import com.google.android.gms.cast.MediaSeekOptions;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import org.json.JSONObject;

final class zzs extends MediaSessionCompat.Callback {
    final /* synthetic */ zzv zza;

    zzs(zzv zzv) {
        this.zza = zzv;
    }

    private final void zza(long j2) {
        RemoteMediaClient zze = this.zza.zzp;
        if (zze != null) {
            zzb(Math.min(zze.getStreamDuration(), Math.max(0, zze.getApproximateStreamPosition() + j2)));
        }
    }

    private final void zzb(long j2) {
        RemoteMediaClient zze = this.zza.zzp;
        if (zze != null) {
            MediaSeekOptions.Builder builder = new MediaSeekOptions.Builder();
            builder.setPosition(j2);
            zze.seek(builder.build());
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCustomAction(java.lang.String r5, android.os.Bundle r6) {
        /*
            r4 = this;
            com.google.android.gms.cast.internal.Logger r6 = com.google.android.gms.cast.framework.media.internal.zzv.zzb
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r2 = 0
            r1[r2] = r5
            java.lang.String r3 = "onCustomAction with action = %s"
            r6.d(r3, r1)
            int r6 = r5.hashCode()
            r1 = 3
            r3 = 2
            switch(r6) {
                case -1699820260: goto L_0x0037;
                case -668151673: goto L_0x002d;
                case -124479363: goto L_0x0023;
                case 1362116196: goto L_0x0019;
                default: goto L_0x0018;
            }
        L_0x0018:
            goto L_0x0041
        L_0x0019:
            java.lang.String r6 = "com.google.android.gms.cast.framework.action.FORWARD"
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L_0x0041
            r6 = 0
            goto L_0x0042
        L_0x0023:
            java.lang.String r6 = "com.google.android.gms.cast.framework.action.DISCONNECT"
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L_0x0041
            r6 = 3
            goto L_0x0042
        L_0x002d:
            java.lang.String r6 = "com.google.android.gms.cast.framework.action.STOP_CASTING"
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L_0x0041
            r6 = 2
            goto L_0x0042
        L_0x0037:
            java.lang.String r6 = "com.google.android.gms.cast.framework.action.REWIND"
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L_0x0041
            r6 = 1
            goto L_0x0042
        L_0x0041:
            r6 = -1
        L_0x0042:
            if (r6 == 0) goto L_0x0091
            if (r6 == r0) goto L_0x0082
            if (r6 == r3) goto L_0x0072
            if (r6 == r1) goto L_0x0062
            android.content.Intent r6 = new android.content.Intent
            r6.<init>(r5)
            com.google.android.gms.cast.framework.media.internal.zzv r5 = r4.zza
            android.content.ComponentName r5 = r5.zzi
            r6.setComponent(r5)
            com.google.android.gms.cast.framework.media.internal.zzv r5 = r4.zza
            android.content.Context r5 = r5.zzc
            r5.sendBroadcast(r6)
            return
        L_0x0062:
            com.google.android.gms.cast.framework.media.internal.zzv r5 = r4.zza
            com.google.android.gms.cast.framework.SessionManager r6 = r5.zzf
            if (r6 == 0) goto L_0x0081
            com.google.android.gms.cast.framework.SessionManager r5 = r5.zzf
            r5.endCurrentSession(r2)
            return
        L_0x0072:
            com.google.android.gms.cast.framework.media.internal.zzv r5 = r4.zza
            com.google.android.gms.cast.framework.SessionManager r6 = r5.zzf
            if (r6 == 0) goto L_0x0081
            com.google.android.gms.cast.framework.SessionManager r5 = r5.zzf
            r5.endCurrentSession(r0)
        L_0x0081:
            return
        L_0x0082:
            com.google.android.gms.cast.framework.media.internal.zzv r5 = r4.zza
            com.google.android.gms.cast.framework.media.NotificationOptions r5 = r5.zzg
            long r5 = r5.getSkipStepMs()
            long r5 = -r5
            r4.zza(r5)
            return
        L_0x0091:
            com.google.android.gms.cast.framework.media.internal.zzv r5 = r4.zza
            com.google.android.gms.cast.framework.media.NotificationOptions r5 = r5.zzg
            long r5 = r5.getSkipStepMs()
            r4.zza(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.framework.media.internal.zzs.onCustomAction(java.lang.String, android.os.Bundle):void");
    }

    public final boolean onMediaButtonEvent(Intent intent) {
        zzv.zzb.d("onMediaButtonEvent", new Object[0]);
        KeyEvent keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
        if (keyEvent == null) {
            return true;
        }
        if (keyEvent.getKeyCode() != 127 && keyEvent.getKeyCode() != 126) {
            return true;
        }
        zzv zzv = this.zza;
        if (zzv.zzp == null) {
            return true;
        }
        zzv.zzp.togglePlayback();
        return true;
    }

    public final void onPause() {
        zzv.zzb.d("onPause", new Object[0]);
        zzv zzv = this.zza;
        if (zzv.zzp != null) {
            zzv.zzp.togglePlayback();
        }
    }

    public final void onPlay() {
        zzv.zzb.d("onPlay", new Object[0]);
        zzv zzv = this.zza;
        if (zzv.zzp != null) {
            zzv.zzp.togglePlayback();
        }
    }

    public final void onSeekTo(long j2) {
        zzv.zzb.d("onSeekTo %d", Long.valueOf(j2));
        zzb(j2);
    }

    public final void onSkipToNext() {
        zzv.zzb.d("onSkipToNext", new Object[0]);
        zzv zzv = this.zza;
        if (zzv.zzp != null) {
            zzv.zzp.queueNext((JSONObject) null);
        }
    }

    public final void onSkipToPrevious() {
        zzv.zzb.d("onSkipToPrevious", new Object[0]);
        zzv zzv = this.zza;
        if (zzv.zzp != null) {
            zzv.zzp.queuePrev((JSONObject) null);
        }
    }
}
