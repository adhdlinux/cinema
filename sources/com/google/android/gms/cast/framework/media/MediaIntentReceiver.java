package com.google.android.gms.cast.framework.media;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.annotation.Keep;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONObject;

@Keep
public class MediaIntentReceiver extends BroadcastReceiver {
    public static final String ACTION_DISCONNECT = "com.google.android.gms.cast.framework.action.DISCONNECT";
    public static final String ACTION_FORWARD = "com.google.android.gms.cast.framework.action.FORWARD";
    public static final String ACTION_REWIND = "com.google.android.gms.cast.framework.action.REWIND";
    public static final String ACTION_SKIP_NEXT = "com.google.android.gms.cast.framework.action.SKIP_NEXT";
    public static final String ACTION_SKIP_PREV = "com.google.android.gms.cast.framework.action.SKIP_PREV";
    public static final String ACTION_STOP_CASTING = "com.google.android.gms.cast.framework.action.STOP_CASTING";
    public static final String ACTION_TOGGLE_PLAYBACK = "com.google.android.gms.cast.framework.action.TOGGLE_PLAYBACK";
    public static final String EXTRA_SKIP_STEP_MS = "googlecast-extra_skip_step_ms";
    private static final String TAG = "MediaIntentReceiver";
    private static final Logger log = new Logger(TAG);

    private static RemoteMediaClient getRemoteMediaClient(CastSession castSession) {
        if (castSession == null || !castSession.isConnected()) {
            return null;
        }
        return castSession.getRemoteMediaClient();
    }

    private void seek(CastSession castSession, long j2) {
        RemoteMediaClient remoteMediaClient;
        if (j2 != 0 && (remoteMediaClient = getRemoteMediaClient(castSession)) != null && !remoteMediaClient.isLiveStream() && !remoteMediaClient.isPlayingAd()) {
            remoteMediaClient.seek(remoteMediaClient.getApproximateStreamPosition() + j2);
        }
    }

    private void togglePlayback(CastSession castSession) {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient(castSession);
        if (remoteMediaClient != null) {
            remoteMediaClient.togglePlayback();
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0014, code lost:
        r1 = com.google.android.gms.cast.framework.CastContext.getSharedInstance(r10).getSessionManager();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(android.content.Context r10, android.content.Intent r11) {
        /*
            r9 = this;
            java.lang.String r0 = r11.getAction()
            com.google.android.gms.cast.internal.Logger r1 = log
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r4 = 0
            r3[r4] = r0
            java.lang.String r5 = "onReceive action: %s"
            r1.d(r5, r3)
            if (r0 != 0) goto L_0x0014
            return
        L_0x0014:
            com.google.android.gms.cast.framework.CastContext r1 = com.google.android.gms.cast.framework.CastContext.getSharedInstance(r10)
            com.google.android.gms.cast.framework.SessionManager r1 = r1.getSessionManager()
            com.google.android.gms.cast.framework.Session r3 = r1.getCurrentSession()
            if (r3 != 0) goto L_0x0023
            return
        L_0x0023:
            int r5 = r0.hashCode()
            switch(r5) {
                case -1699820260: goto L_0x0071;
                case -945151566: goto L_0x0067;
                case -945080078: goto L_0x005d;
                case -668151673: goto L_0x0053;
                case -124479363: goto L_0x0049;
                case 235550565: goto L_0x003f;
                case 1362116196: goto L_0x0035;
                case 1997055314: goto L_0x002b;
                default: goto L_0x002a;
            }
        L_0x002a:
            goto L_0x007b
        L_0x002b:
            java.lang.String r5 = "android.intent.action.MEDIA_BUTTON"
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L_0x007b
            r5 = 7
            goto L_0x007c
        L_0x0035:
            java.lang.String r5 = "com.google.android.gms.cast.framework.action.FORWARD"
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L_0x007b
            r5 = 3
            goto L_0x007c
        L_0x003f:
            java.lang.String r5 = "com.google.android.gms.cast.framework.action.TOGGLE_PLAYBACK"
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L_0x007b
            r5 = 0
            goto L_0x007c
        L_0x0049:
            java.lang.String r5 = "com.google.android.gms.cast.framework.action.DISCONNECT"
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L_0x007b
            r5 = 6
            goto L_0x007c
        L_0x0053:
            java.lang.String r5 = "com.google.android.gms.cast.framework.action.STOP_CASTING"
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L_0x007b
            r5 = 5
            goto L_0x007c
        L_0x005d:
            java.lang.String r5 = "com.google.android.gms.cast.framework.action.SKIP_PREV"
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L_0x007b
            r5 = 2
            goto L_0x007c
        L_0x0067:
            java.lang.String r5 = "com.google.android.gms.cast.framework.action.SKIP_NEXT"
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L_0x007b
            r5 = 1
            goto L_0x007c
        L_0x0071:
            java.lang.String r5 = "com.google.android.gms.cast.framework.action.REWIND"
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L_0x007b
            r5 = 4
            goto L_0x007c
        L_0x007b:
            r5 = -1
        L_0x007c:
            r6 = 0
            java.lang.String r8 = "googlecast-extra_skip_step_ms"
            switch(r5) {
                case 0: goto L_0x00ab;
                case 1: goto L_0x00a7;
                case 2: goto L_0x00a3;
                case 3: goto L_0x009b;
                case 4: goto L_0x0093;
                case 5: goto L_0x008f;
                case 6: goto L_0x008b;
                case 7: goto L_0x0087;
                default: goto L_0x0083;
            }
        L_0x0083:
            r9.onReceiveOtherAction(r10, r0, r11)
            return
        L_0x0087:
            r9.onReceiveActionMediaButton(r3, r11)
            return
        L_0x008b:
            r1.endCurrentSession(r4)
            return
        L_0x008f:
            r1.endCurrentSession(r2)
            return
        L_0x0093:
            long r10 = r11.getLongExtra(r8, r6)
            r9.onReceiveActionRewind(r3, r10)
            return
        L_0x009b:
            long r10 = r11.getLongExtra(r8, r6)
            r9.onReceiveActionForward(r3, r10)
            return
        L_0x00a3:
            r9.onReceiveActionSkipPrev(r3)
            return
        L_0x00a7:
            r9.onReceiveActionSkipNext(r3)
            return
        L_0x00ab:
            r9.onReceiveActionTogglePlayback(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.framework.media.MediaIntentReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }

    /* access modifiers changed from: protected */
    public void onReceiveActionForward(Session session, long j2) {
        if (session instanceof CastSession) {
            seek((CastSession) session, j2);
        }
    }

    /* access modifiers changed from: protected */
    public void onReceiveActionMediaButton(Session session, Intent intent) {
        KeyEvent keyEvent;
        if ((session instanceof CastSession) && intent.hasExtra("android.intent.extra.KEY_EVENT") && (keyEvent = (KeyEvent) ((Bundle) Preconditions.checkNotNull(intent.getExtras())).get("android.intent.extra.KEY_EVENT")) != null && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 85) {
            togglePlayback((CastSession) session);
        }
    }

    /* access modifiers changed from: protected */
    public void onReceiveActionRewind(Session session, long j2) {
        if (session instanceof CastSession) {
            seek((CastSession) session, -j2);
        }
    }

    /* access modifiers changed from: protected */
    public void onReceiveActionSkipNext(Session session) {
        RemoteMediaClient remoteMediaClient;
        if ((session instanceof CastSession) && (remoteMediaClient = getRemoteMediaClient((CastSession) session)) != null && !remoteMediaClient.isPlayingAd()) {
            remoteMediaClient.queueNext((JSONObject) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onReceiveActionSkipPrev(Session session) {
        RemoteMediaClient remoteMediaClient;
        if ((session instanceof CastSession) && (remoteMediaClient = getRemoteMediaClient((CastSession) session)) != null && !remoteMediaClient.isPlayingAd()) {
            remoteMediaClient.queuePrev((JSONObject) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onReceiveActionTogglePlayback(Session session) {
        if (session instanceof CastSession) {
            togglePlayback((CastSession) session);
        }
    }

    /* access modifiers changed from: protected */
    public void onReceiveOtherAction(Context context, String str, Intent intent) {
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onReceiveOtherAction(String str, Intent intent) {
        onReceiveOtherAction((Context) null, str, intent);
    }
}
