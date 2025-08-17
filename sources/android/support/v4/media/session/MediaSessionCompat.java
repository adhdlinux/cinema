package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.RemoteControlClient;
import android.media.VolumeProvider;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.core.app.BundleCompat;
import androidx.media.MediaSessionManager$RemoteUserInfo;
import androidx.media.VolumeProviderCompat;
import androidx.media.session.MediaButtonReceiver;
import androidx.versionedparcelable.ParcelUtils;
import androidx.versionedparcelable.VersionedParcelable;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.unity3d.services.core.device.MimeTypes;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class MediaSessionCompat {
    public static final String ACTION_ARGUMENT_CAPTIONING_ENABLED = "android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED";
    public static final String ACTION_ARGUMENT_EXTRAS = "android.support.v4.media.session.action.ARGUMENT_EXTRAS";
    public static final String ACTION_ARGUMENT_MEDIA_ID = "android.support.v4.media.session.action.ARGUMENT_MEDIA_ID";
    public static final String ACTION_ARGUMENT_PLAYBACK_SPEED = "android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED";
    public static final String ACTION_ARGUMENT_QUERY = "android.support.v4.media.session.action.ARGUMENT_QUERY";
    public static final String ACTION_ARGUMENT_RATING = "android.support.v4.media.session.action.ARGUMENT_RATING";
    public static final String ACTION_ARGUMENT_REPEAT_MODE = "android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE";
    public static final String ACTION_ARGUMENT_SHUFFLE_MODE = "android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE";
    public static final String ACTION_ARGUMENT_URI = "android.support.v4.media.session.action.ARGUMENT_URI";
    public static final String ACTION_FLAG_AS_INAPPROPRIATE = "android.support.v4.media.session.action.FLAG_AS_INAPPROPRIATE";
    public static final String ACTION_FOLLOW = "android.support.v4.media.session.action.FOLLOW";
    public static final String ACTION_PLAY_FROM_URI = "android.support.v4.media.session.action.PLAY_FROM_URI";
    public static final String ACTION_PREPARE = "android.support.v4.media.session.action.PREPARE";
    public static final String ACTION_PREPARE_FROM_MEDIA_ID = "android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID";
    public static final String ACTION_PREPARE_FROM_SEARCH = "android.support.v4.media.session.action.PREPARE_FROM_SEARCH";
    public static final String ACTION_PREPARE_FROM_URI = "android.support.v4.media.session.action.PREPARE_FROM_URI";
    public static final String ACTION_SET_CAPTIONING_ENABLED = "android.support.v4.media.session.action.SET_CAPTIONING_ENABLED";
    public static final String ACTION_SET_PLAYBACK_SPEED = "android.support.v4.media.session.action.SET_PLAYBACK_SPEED";
    public static final String ACTION_SET_RATING = "android.support.v4.media.session.action.SET_RATING";
    public static final String ACTION_SET_REPEAT_MODE = "android.support.v4.media.session.action.SET_REPEAT_MODE";
    public static final String ACTION_SET_SHUFFLE_MODE = "android.support.v4.media.session.action.SET_SHUFFLE_MODE";
    public static final String ACTION_SKIP_AD = "android.support.v4.media.session.action.SKIP_AD";
    public static final String ACTION_UNFOLLOW = "android.support.v4.media.session.action.UNFOLLOW";
    public static final String ARGUMENT_MEDIA_ATTRIBUTE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE";
    public static final String ARGUMENT_MEDIA_ATTRIBUTE_VALUE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE_VALUE";
    private static final String DATA_CALLING_PACKAGE = "data_calling_pkg";
    private static final String DATA_CALLING_PID = "data_calling_pid";
    private static final String DATA_CALLING_UID = "data_calling_uid";
    private static final String DATA_EXTRAS = "data_extras";
    @Deprecated
    public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1;
    public static final int FLAG_HANDLES_QUEUE_COMMANDS = 4;
    @Deprecated
    public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2;
    public static final String KEY_EXTRA_BINDER = "android.support.v4.media.session.EXTRA_BINDER";
    public static final String KEY_SESSION2_TOKEN = "android.support.v4.media.session.SESSION_TOKEN2";
    public static final String KEY_TOKEN = "android.support.v4.media.session.TOKEN";
    private static final int MAX_BITMAP_SIZE_IN_DP = 320;
    public static final int MEDIA_ATTRIBUTE_ALBUM = 1;
    public static final int MEDIA_ATTRIBUTE_ARTIST = 0;
    public static final int MEDIA_ATTRIBUTE_PLAYLIST = 2;
    static final String TAG = "MediaSessionCompat";
    static int sMaxBitmapSize;
    private final ArrayList<OnActiveChangeListener> mActiveListeners;
    private final MediaControllerCompat mController;
    private final MediaSessionImpl mImpl;

    public static abstract class Callback {
        final MediaSession.Callback mCallbackFwk = new MediaSessionCallbackApi21();
        CallbackHandler mCallbackHandler;
        final Object mLock = new Object();
        private boolean mMediaPlayPausePendingOnHandler;
        WeakReference<MediaSessionImpl> mSessionImpl = new WeakReference<>((Object) null);

        private class CallbackHandler extends Handler {
            private static final int MSG_MEDIA_PLAY_PAUSE_KEY_DOUBLE_TAP_TIMEOUT = 1;

            CallbackHandler(Looper looper) {
                super(looper);
            }

            public void handleMessage(Message message) {
                MediaSessionImpl mediaSessionImpl;
                Callback callback;
                CallbackHandler callbackHandler;
                if (message.what == 1) {
                    synchronized (Callback.this.mLock) {
                        mediaSessionImpl = Callback.this.mSessionImpl.get();
                        callback = Callback.this;
                        callbackHandler = callback.mCallbackHandler;
                    }
                    if (mediaSessionImpl != null && callback == mediaSessionImpl.getCallback() && callbackHandler != null) {
                        mediaSessionImpl.setCurrentControllerInfo((MediaSessionManager$RemoteUserInfo) message.obj);
                        Callback.this.handleMediaPlayPauseIfPendingOnHandler(mediaSessionImpl, callbackHandler);
                        mediaSessionImpl.setCurrentControllerInfo((MediaSessionManager$RemoteUserInfo) null);
                    }
                }
            }
        }

        private class MediaSessionCallbackApi21 extends MediaSession.Callback {
            MediaSessionCallbackApi21() {
            }

            private void clearCurrentControllerInfo(MediaSessionImpl mediaSessionImpl) {
                mediaSessionImpl.setCurrentControllerInfo((MediaSessionManager$RemoteUserInfo) null);
            }

            private MediaSessionImplApi21 getSessionImplIfCallbackIsSet() {
                MediaSessionImplApi21 mediaSessionImplApi21;
                synchronized (Callback.this.mLock) {
                    mediaSessionImplApi21 = (MediaSessionImplApi21) Callback.this.mSessionImpl.get();
                }
                if (mediaSessionImplApi21 == null || Callback.this != mediaSessionImplApi21.getCallback()) {
                    return null;
                }
                return mediaSessionImplApi21;
            }

            private void setCurrentControllerInfo(MediaSessionImpl mediaSessionImpl) {
                if (Build.VERSION.SDK_INT < 28) {
                    String callingPackage = mediaSessionImpl.getCallingPackage();
                    if (TextUtils.isEmpty(callingPackage)) {
                        callingPackage = "android.media.session.MediaController";
                    }
                    mediaSessionImpl.setCurrentControllerInfo(new MediaSessionManager$RemoteUserInfo(callingPackage, -1, -1));
                }
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: android.support.v4.media.session.MediaSessionCompat$QueueItem} */
            /* JADX WARNING: type inference failed for: r2v0 */
            /* JADX WARNING: type inference failed for: r2v4, types: [android.os.IBinder] */
            /* JADX WARNING: type inference failed for: r2v6 */
            /* JADX WARNING: type inference failed for: r2v7 */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onCommand(java.lang.String r6, android.os.Bundle r7, android.os.ResultReceiver r8) {
                /*
                    r5 = this;
                    android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi21 r0 = r5.getSessionImplIfCallbackIsSet()
                    if (r0 != 0) goto L_0x0007
                    return
                L_0x0007:
                    android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(r7)
                    r5.setCurrentControllerInfo(r0)
                    java.lang.String r1 = "android.support.v4.media.session.command.GET_EXTRA_BINDER"
                    boolean r1 = r6.equals(r1)     // Catch:{ BadParcelableException -> 0x00b8 }
                    r2 = 0
                    if (r1 == 0) goto L_0x003e
                    android.os.Bundle r6 = new android.os.Bundle     // Catch:{ BadParcelableException -> 0x00b8 }
                    r6.<init>()     // Catch:{ BadParcelableException -> 0x00b8 }
                    android.support.v4.media.session.MediaSessionCompat$Token r7 = r0.getSessionToken()     // Catch:{ BadParcelableException -> 0x00b8 }
                    android.support.v4.media.session.IMediaSession r1 = r7.getExtraBinder()     // Catch:{ BadParcelableException -> 0x00b8 }
                    java.lang.String r3 = "android.support.v4.media.session.EXTRA_BINDER"
                    if (r1 != 0) goto L_0x0028
                    goto L_0x002c
                L_0x0028:
                    android.os.IBinder r2 = r1.asBinder()     // Catch:{ BadParcelableException -> 0x00b8 }
                L_0x002c:
                    androidx.core.app.BundleCompat.b(r6, r3, r2)     // Catch:{ BadParcelableException -> 0x00b8 }
                    java.lang.String r1 = "android.support.v4.media.session.SESSION_TOKEN2"
                    androidx.versionedparcelable.VersionedParcelable r7 = r7.getSession2Token()     // Catch:{ BadParcelableException -> 0x00b8 }
                    androidx.versionedparcelable.ParcelUtils.c(r6, r1, r7)     // Catch:{ BadParcelableException -> 0x00b8 }
                    r7 = 0
                    r8.send(r7, r6)     // Catch:{ BadParcelableException -> 0x00b8 }
                    goto L_0x00bf
                L_0x003e:
                    java.lang.String r1 = "android.support.v4.media.session.command.ADD_QUEUE_ITEM"
                    boolean r1 = r6.equals(r1)     // Catch:{ BadParcelableException -> 0x00b8 }
                    java.lang.String r3 = "android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"
                    if (r1 == 0) goto L_0x0054
                    android.support.v4.media.session.MediaSessionCompat$Callback r6 = android.support.v4.media.session.MediaSessionCompat.Callback.this     // Catch:{ BadParcelableException -> 0x00b8 }
                    android.os.Parcelable r7 = r7.getParcelable(r3)     // Catch:{ BadParcelableException -> 0x00b8 }
                    android.support.v4.media.MediaDescriptionCompat r7 = (android.support.v4.media.MediaDescriptionCompat) r7     // Catch:{ BadParcelableException -> 0x00b8 }
                    r6.onAddQueueItem(r7)     // Catch:{ BadParcelableException -> 0x00b8 }
                    goto L_0x00bf
                L_0x0054:
                    java.lang.String r1 = "android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT"
                    boolean r1 = r6.equals(r1)     // Catch:{ BadParcelableException -> 0x00b8 }
                    java.lang.String r4 = "android.support.v4.media.session.command.ARGUMENT_INDEX"
                    if (r1 == 0) goto L_0x006e
                    android.support.v4.media.session.MediaSessionCompat$Callback r6 = android.support.v4.media.session.MediaSessionCompat.Callback.this     // Catch:{ BadParcelableException -> 0x00b8 }
                    android.os.Parcelable r8 = r7.getParcelable(r3)     // Catch:{ BadParcelableException -> 0x00b8 }
                    android.support.v4.media.MediaDescriptionCompat r8 = (android.support.v4.media.MediaDescriptionCompat) r8     // Catch:{ BadParcelableException -> 0x00b8 }
                    int r7 = r7.getInt(r4)     // Catch:{ BadParcelableException -> 0x00b8 }
                    r6.onAddQueueItem(r8, r7)     // Catch:{ BadParcelableException -> 0x00b8 }
                    goto L_0x00bf
                L_0x006e:
                    java.lang.String r1 = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM"
                    boolean r1 = r6.equals(r1)     // Catch:{ BadParcelableException -> 0x00b8 }
                    if (r1 == 0) goto L_0x0082
                    android.support.v4.media.session.MediaSessionCompat$Callback r6 = android.support.v4.media.session.MediaSessionCompat.Callback.this     // Catch:{ BadParcelableException -> 0x00b8 }
                    android.os.Parcelable r7 = r7.getParcelable(r3)     // Catch:{ BadParcelableException -> 0x00b8 }
                    android.support.v4.media.MediaDescriptionCompat r7 = (android.support.v4.media.MediaDescriptionCompat) r7     // Catch:{ BadParcelableException -> 0x00b8 }
                    r6.onRemoveQueueItem(r7)     // Catch:{ BadParcelableException -> 0x00b8 }
                    goto L_0x00bf
                L_0x0082:
                    java.lang.String r1 = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT"
                    boolean r1 = r6.equals(r1)     // Catch:{ BadParcelableException -> 0x00b8 }
                    if (r1 == 0) goto L_0x00b2
                    java.util.List<android.support.v4.media.session.MediaSessionCompat$QueueItem> r6 = r0.mQueue     // Catch:{ BadParcelableException -> 0x00b8 }
                    if (r6 == 0) goto L_0x00bf
                    r6 = -1
                    int r6 = r7.getInt(r4, r6)     // Catch:{ BadParcelableException -> 0x00b8 }
                    if (r6 < 0) goto L_0x00a6
                    java.util.List<android.support.v4.media.session.MediaSessionCompat$QueueItem> r7 = r0.mQueue     // Catch:{ BadParcelableException -> 0x00b8 }
                    int r7 = r7.size()     // Catch:{ BadParcelableException -> 0x00b8 }
                    if (r6 >= r7) goto L_0x00a6
                    java.util.List<android.support.v4.media.session.MediaSessionCompat$QueueItem> r7 = r0.mQueue     // Catch:{ BadParcelableException -> 0x00b8 }
                    java.lang.Object r6 = r7.get(r6)     // Catch:{ BadParcelableException -> 0x00b8 }
                    r2 = r6
                    android.support.v4.media.session.MediaSessionCompat$QueueItem r2 = (android.support.v4.media.session.MediaSessionCompat.QueueItem) r2     // Catch:{ BadParcelableException -> 0x00b8 }
                L_0x00a6:
                    if (r2 == 0) goto L_0x00bf
                    android.support.v4.media.session.MediaSessionCompat$Callback r6 = android.support.v4.media.session.MediaSessionCompat.Callback.this     // Catch:{ BadParcelableException -> 0x00b8 }
                    android.support.v4.media.MediaDescriptionCompat r7 = r2.getDescription()     // Catch:{ BadParcelableException -> 0x00b8 }
                    r6.onRemoveQueueItem(r7)     // Catch:{ BadParcelableException -> 0x00b8 }
                    goto L_0x00bf
                L_0x00b2:
                    android.support.v4.media.session.MediaSessionCompat$Callback r1 = android.support.v4.media.session.MediaSessionCompat.Callback.this     // Catch:{ BadParcelableException -> 0x00b8 }
                    r1.onCommand(r6, r7, r8)     // Catch:{ BadParcelableException -> 0x00b8 }
                    goto L_0x00bf
                L_0x00b8:
                    java.lang.String r6 = "MediaSessionCompat"
                    java.lang.String r7 = "Could not unparcel the extra data."
                    android.util.Log.e(r6, r7)
                L_0x00bf:
                    r5.clearCurrentControllerInfo(r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.Callback.MediaSessionCallbackApi21.onCommand(java.lang.String, android.os.Bundle, android.os.ResultReceiver):void");
            }

            public void onCustomAction(String str, Bundle bundle) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet != null) {
                    MediaSessionCompat.ensureClassLoader(bundle);
                    setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    try {
                        if (str.equals(MediaSessionCompat.ACTION_PLAY_FROM_URI)) {
                            Bundle bundle2 = bundle.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                            MediaSessionCompat.ensureClassLoader(bundle2);
                            Callback.this.onPlayFromUri((Uri) bundle.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI), bundle2);
                        } else if (str.equals(MediaSessionCompat.ACTION_PREPARE)) {
                            Callback.this.onPrepare();
                        } else if (str.equals(MediaSessionCompat.ACTION_PREPARE_FROM_MEDIA_ID)) {
                            String string = bundle.getString(MediaSessionCompat.ACTION_ARGUMENT_MEDIA_ID);
                            Bundle bundle3 = bundle.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                            MediaSessionCompat.ensureClassLoader(bundle3);
                            Callback.this.onPrepareFromMediaId(string, bundle3);
                        } else if (str.equals(MediaSessionCompat.ACTION_PREPARE_FROM_SEARCH)) {
                            String string2 = bundle.getString(MediaSessionCompat.ACTION_ARGUMENT_QUERY);
                            Bundle bundle4 = bundle.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                            MediaSessionCompat.ensureClassLoader(bundle4);
                            Callback.this.onPrepareFromSearch(string2, bundle4);
                        } else if (str.equals(MediaSessionCompat.ACTION_PREPARE_FROM_URI)) {
                            Bundle bundle5 = bundle.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                            MediaSessionCompat.ensureClassLoader(bundle5);
                            Callback.this.onPrepareFromUri((Uri) bundle.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI), bundle5);
                        } else if (str.equals(MediaSessionCompat.ACTION_SET_CAPTIONING_ENABLED)) {
                            Callback.this.onSetCaptioningEnabled(bundle.getBoolean(MediaSessionCompat.ACTION_ARGUMENT_CAPTIONING_ENABLED));
                        } else if (str.equals(MediaSessionCompat.ACTION_SET_REPEAT_MODE)) {
                            Callback.this.onSetRepeatMode(bundle.getInt(MediaSessionCompat.ACTION_ARGUMENT_REPEAT_MODE));
                        } else if (str.equals(MediaSessionCompat.ACTION_SET_SHUFFLE_MODE)) {
                            Callback.this.onSetShuffleMode(bundle.getInt(MediaSessionCompat.ACTION_ARGUMENT_SHUFFLE_MODE));
                        } else if (str.equals(MediaSessionCompat.ACTION_SET_RATING)) {
                            Bundle bundle6 = bundle.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                            MediaSessionCompat.ensureClassLoader(bundle6);
                            Callback.this.onSetRating((RatingCompat) bundle.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_RATING), bundle6);
                        } else if (str.equals(MediaSessionCompat.ACTION_SET_PLAYBACK_SPEED)) {
                            Callback.this.onSetPlaybackSpeed(bundle.getFloat(MediaSessionCompat.ACTION_ARGUMENT_PLAYBACK_SPEED, 1.0f));
                        } else {
                            Callback.this.onCustomAction(str, bundle);
                        }
                    } catch (BadParcelableException unused) {
                        Log.e(MediaSessionCompat.TAG, "Could not unparcel the data.");
                    }
                    clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                }
            }

            public void onFastForward() {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet != null) {
                    setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    Callback.this.onFastForward();
                    clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                }
            }

            public boolean onMediaButtonEvent(Intent intent) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet == null) {
                    return false;
                }
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                boolean onMediaButtonEvent = Callback.this.onMediaButtonEvent(intent);
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                if (onMediaButtonEvent || super.onMediaButtonEvent(intent)) {
                    return true;
                }
                return false;
            }

            public void onPause() {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet != null) {
                    setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    Callback.this.onPause();
                    clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                }
            }

            public void onPlay() {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet != null) {
                    setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    Callback.this.onPlay();
                    clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                }
            }

            public void onPlayFromMediaId(String str, Bundle bundle) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet != null) {
                    MediaSessionCompat.ensureClassLoader(bundle);
                    setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    Callback.this.onPlayFromMediaId(str, bundle);
                    clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                }
            }

            public void onPlayFromSearch(String str, Bundle bundle) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet != null) {
                    MediaSessionCompat.ensureClassLoader(bundle);
                    setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    Callback.this.onPlayFromSearch(str, bundle);
                    clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                }
            }

            public void onPlayFromUri(Uri uri, Bundle bundle) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet != null) {
                    MediaSessionCompat.ensureClassLoader(bundle);
                    setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    Callback.this.onPlayFromUri(uri, bundle);
                    clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                }
            }

            public void onPrepare() {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet != null) {
                    setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    Callback.this.onPrepare();
                    clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                }
            }

            public void onPrepareFromMediaId(String str, Bundle bundle) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet != null) {
                    MediaSessionCompat.ensureClassLoader(bundle);
                    setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    Callback.this.onPrepareFromMediaId(str, bundle);
                    clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                }
            }

            public void onPrepareFromSearch(String str, Bundle bundle) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet != null) {
                    MediaSessionCompat.ensureClassLoader(bundle);
                    setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    Callback.this.onPrepareFromSearch(str, bundle);
                    clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                }
            }

            public void onPrepareFromUri(Uri uri, Bundle bundle) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet != null) {
                    MediaSessionCompat.ensureClassLoader(bundle);
                    setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    Callback.this.onPrepareFromUri(uri, bundle);
                    clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                }
            }

            public void onRewind() {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet != null) {
                    setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    Callback.this.onRewind();
                    clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                }
            }

            public void onSeekTo(long j2) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet != null) {
                    setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    Callback.this.onSeekTo(j2);
                    clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                }
            }

            public void onSetPlaybackSpeed(float f2) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet != null) {
                    setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    Callback.this.onSetPlaybackSpeed(f2);
                    clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                }
            }

            public void onSetRating(Rating rating) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet != null) {
                    setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    Callback.this.onSetRating(RatingCompat.fromRating(rating));
                    clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                }
            }

            public void onSkipToNext() {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet != null) {
                    setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    Callback.this.onSkipToNext();
                    clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                }
            }

            public void onSkipToPrevious() {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet != null) {
                    setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    Callback.this.onSkipToPrevious();
                    clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                }
            }

            public void onSkipToQueueItem(long j2) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet != null) {
                    setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    Callback.this.onSkipToQueueItem(j2);
                    clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                }
            }

            public void onStop() {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet != null) {
                    setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    Callback.this.onStop();
                    clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void handleMediaPlayPauseIfPendingOnHandler(MediaSessionImpl mediaSessionImpl, Handler handler) {
            long j2;
            boolean z2;
            boolean z3;
            if (this.mMediaPlayPausePendingOnHandler) {
                boolean z4 = false;
                this.mMediaPlayPausePendingOnHandler = false;
                handler.removeMessages(1);
                PlaybackStateCompat playbackState = mediaSessionImpl.getPlaybackState();
                if (playbackState == null) {
                    j2 = 0;
                } else {
                    j2 = playbackState.getActions();
                }
                if (playbackState == null || playbackState.getState() != 3) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if ((516 & j2) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if ((j2 & 514) != 0) {
                    z4 = true;
                }
                if (z2 && z4) {
                    onPause();
                } else if (!z2 && z3) {
                    onPlay();
                }
            }
        }

        public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i2) {
        }

        public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
        }

        public void onCustomAction(String str, Bundle bundle) {
        }

        public void onFastForward() {
        }

        public boolean onMediaButtonEvent(Intent intent) {
            MediaSessionImpl mediaSessionImpl;
            CallbackHandler callbackHandler;
            KeyEvent keyEvent;
            long j2;
            if (Build.VERSION.SDK_INT >= 27) {
                return false;
            }
            synchronized (this.mLock) {
                mediaSessionImpl = this.mSessionImpl.get();
                callbackHandler = this.mCallbackHandler;
            }
            if (mediaSessionImpl == null || callbackHandler == null || (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) == null || keyEvent.getAction() != 0) {
                return false;
            }
            MediaSessionManager$RemoteUserInfo currentControllerInfo = mediaSessionImpl.getCurrentControllerInfo();
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 79 || keyCode == 85) {
                if (keyEvent.getRepeatCount() != 0) {
                    handleMediaPlayPauseIfPendingOnHandler(mediaSessionImpl, callbackHandler);
                } else if (this.mMediaPlayPausePendingOnHandler) {
                    callbackHandler.removeMessages(1);
                    this.mMediaPlayPausePendingOnHandler = false;
                    PlaybackStateCompat playbackState = mediaSessionImpl.getPlaybackState();
                    if (playbackState == null) {
                        j2 = 0;
                    } else {
                        j2 = playbackState.getActions();
                    }
                    if ((j2 & 32) != 0) {
                        onSkipToNext();
                    }
                } else {
                    this.mMediaPlayPausePendingOnHandler = true;
                    callbackHandler.sendMessageDelayed(callbackHandler.obtainMessage(1, currentControllerInfo), (long) ViewConfiguration.getDoubleTapTimeout());
                }
                return true;
            }
            handleMediaPlayPauseIfPendingOnHandler(mediaSessionImpl, callbackHandler);
            return false;
        }

        public void onPause() {
        }

        public void onPlay() {
        }

        public void onPlayFromMediaId(String str, Bundle bundle) {
        }

        public void onPlayFromSearch(String str, Bundle bundle) {
        }

        public void onPlayFromUri(Uri uri, Bundle bundle) {
        }

        public void onPrepare() {
        }

        public void onPrepareFromMediaId(String str, Bundle bundle) {
        }

        public void onPrepareFromSearch(String str, Bundle bundle) {
        }

        public void onPrepareFromUri(Uri uri, Bundle bundle) {
        }

        public void onRemoveQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        @Deprecated
        public void onRemoveQueueItemAt(int i2) {
        }

        public void onRewind() {
        }

        public void onSeekTo(long j2) {
        }

        public void onSetCaptioningEnabled(boolean z2) {
        }

        public void onSetPlaybackSpeed(float f2) {
        }

        public void onSetRating(RatingCompat ratingCompat) {
        }

        public void onSetRating(RatingCompat ratingCompat, Bundle bundle) {
        }

        public void onSetRepeatMode(int i2) {
        }

        public void onSetShuffleMode(int i2) {
        }

        public void onSkipToNext() {
        }

        public void onSkipToPrevious() {
        }

        public void onSkipToQueueItem(long j2) {
        }

        public void onStop() {
        }

        /* access modifiers changed from: package-private */
        public void setSessionImpl(MediaSessionImpl mediaSessionImpl, Handler handler) {
            synchronized (this.mLock) {
                this.mSessionImpl = new WeakReference<>(mediaSessionImpl);
                CallbackHandler callbackHandler = this.mCallbackHandler;
                CallbackHandler callbackHandler2 = null;
                if (callbackHandler != null) {
                    callbackHandler.removeCallbacksAndMessages((Object) null);
                }
                if (mediaSessionImpl != null) {
                    if (handler != null) {
                        callbackHandler2 = new CallbackHandler(handler.getLooper());
                    }
                }
                this.mCallbackHandler = callbackHandler2;
            }
        }
    }

    interface MediaSessionImpl {
        Callback getCallback();

        String getCallingPackage();

        MediaSessionManager$RemoteUserInfo getCurrentControllerInfo();

        Object getMediaSession();

        PlaybackStateCompat getPlaybackState();

        Object getRemoteControlClient();

        Token getSessionToken();

        boolean isActive();

        void release();

        void sendSessionEvent(String str, Bundle bundle);

        void setActive(boolean z2);

        void setCallback(Callback callback, Handler handler);

        void setCaptioningEnabled(boolean z2);

        void setCurrentControllerInfo(MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo);

        void setExtras(Bundle bundle);

        void setFlags(int i2);

        void setMediaButtonReceiver(PendingIntent pendingIntent);

        void setMetadata(MediaMetadataCompat mediaMetadataCompat);

        void setPlaybackState(PlaybackStateCompat playbackStateCompat);

        void setPlaybackToLocal(int i2);

        void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat);

        void setQueue(List<QueueItem> list);

        void setQueueTitle(CharSequence charSequence);

        void setRatingType(int i2);

        void setRegistrationCallback(RegistrationCallback registrationCallback, Handler handler);

        void setRepeatMode(int i2);

        void setSessionActivity(PendingIntent pendingIntent);

        void setShuffleMode(int i2);
    }

    static class MediaSessionImplApi18 extends MediaSessionImplBase {
        private static boolean sIsMbrPendingIntentSupported = true;

        MediaSessionImplApi18(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, VersionedParcelable versionedParcelable, Bundle bundle) {
            super(context, str, componentName, pendingIntent, versionedParcelable, bundle);
        }

        /* access modifiers changed from: package-private */
        public int getRccTransportControlFlagsFromActions(long j2) {
            int rccTransportControlFlagsFromActions = super.getRccTransportControlFlagsFromActions(j2);
            return (j2 & 256) != 0 ? rccTransportControlFlagsFromActions | UserVerificationMethods.USER_VERIFY_HANDPRINT : rccTransportControlFlagsFromActions;
        }

        /* access modifiers changed from: package-private */
        public void registerMediaButtonEventReceiver(PendingIntent pendingIntent, ComponentName componentName) {
            if (sIsMbrPendingIntentSupported) {
                try {
                    this.mAudioManager.registerMediaButtonEventReceiver(pendingIntent);
                } catch (NullPointerException unused) {
                    Log.w(MediaSessionCompat.TAG, "Unable to register media button event receiver with PendingIntent, falling back to ComponentName.");
                    sIsMbrPendingIntentSupported = false;
                }
            }
            if (!sIsMbrPendingIntentSupported) {
                super.registerMediaButtonEventReceiver(pendingIntent, componentName);
            }
        }

        public void setCallback(Callback callback, Handler handler) {
            super.setCallback(callback, handler);
            if (callback == null) {
                this.mRcc.setPlaybackPositionUpdateListener((RemoteControlClient.OnPlaybackPositionUpdateListener) null);
                return;
            }
            this.mRcc.setPlaybackPositionUpdateListener(new RemoteControlClient.OnPlaybackPositionUpdateListener() {
                public void onPlaybackPositionUpdate(long j2) {
                    MediaSessionImplApi18.this.postToHandler(18, -1, -1, Long.valueOf(j2), (Bundle) null);
                }
            });
        }

        /* access modifiers changed from: package-private */
        public void setRccState(PlaybackStateCompat playbackStateCompat) {
            long position = playbackStateCompat.getPosition();
            float playbackSpeed = playbackStateCompat.getPlaybackSpeed();
            long lastPositionUpdateTime = playbackStateCompat.getLastPositionUpdateTime();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (playbackStateCompat.getState() == 3) {
                long j2 = 0;
                if (position > 0) {
                    if (lastPositionUpdateTime > 0) {
                        j2 = elapsedRealtime - lastPositionUpdateTime;
                        if (playbackSpeed > 0.0f && playbackSpeed != 1.0f) {
                            j2 = (long) (((float) j2) * playbackSpeed);
                        }
                    }
                    position += j2;
                }
            }
            this.mRcc.setPlaybackState(getRccStateFromState(playbackStateCompat.getState()), position, playbackSpeed);
        }

        /* access modifiers changed from: package-private */
        public void unregisterMediaButtonEventReceiver(PendingIntent pendingIntent, ComponentName componentName) {
            if (sIsMbrPendingIntentSupported) {
                this.mAudioManager.unregisterMediaButtonEventReceiver(pendingIntent);
            } else {
                super.unregisterMediaButtonEventReceiver(pendingIntent, componentName);
            }
        }
    }

    static class MediaSessionImplApi19 extends MediaSessionImplApi18 {
        MediaSessionImplApi19(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, VersionedParcelable versionedParcelable, Bundle bundle) {
            super(context, str, componentName, pendingIntent, versionedParcelable, bundle);
        }

        /* access modifiers changed from: package-private */
        public RemoteControlClient.MetadataEditor buildRccMetadata(Bundle bundle) {
            long j2;
            RemoteControlClient.MetadataEditor buildRccMetadata = super.buildRccMetadata(bundle);
            PlaybackStateCompat playbackStateCompat = this.mState;
            if (playbackStateCompat == null) {
                j2 = 0;
            } else {
                j2 = playbackStateCompat.getActions();
            }
            if ((j2 & 128) != 0) {
                buildRccMetadata.addEditableKey(268435457);
            }
            if (bundle == null) {
                return buildRccMetadata;
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_YEAR)) {
                buildRccMetadata.putLong(8, bundle.getLong(MediaMetadataCompat.METADATA_KEY_YEAR));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_RATING)) {
                buildRccMetadata.putObject(101, bundle.getParcelable(MediaMetadataCompat.METADATA_KEY_RATING));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_USER_RATING)) {
                buildRccMetadata.putObject(268435457, bundle.getParcelable(MediaMetadataCompat.METADATA_KEY_USER_RATING));
            }
            return buildRccMetadata;
        }

        /* access modifiers changed from: package-private */
        public int getRccTransportControlFlagsFromActions(long j2) {
            int rccTransportControlFlagsFromActions = super.getRccTransportControlFlagsFromActions(j2);
            return (j2 & 128) != 0 ? rccTransportControlFlagsFromActions | 512 : rccTransportControlFlagsFromActions;
        }

        public void setCallback(Callback callback, Handler handler) {
            super.setCallback(callback, handler);
            if (callback == null) {
                this.mRcc.setMetadataUpdateListener((RemoteControlClient.OnMetadataUpdateListener) null);
                return;
            }
            this.mRcc.setMetadataUpdateListener(new RemoteControlClient.OnMetadataUpdateListener() {
                public void onMetadataUpdate(int i2, Object obj) {
                    if (i2 == 268435457 && (obj instanceof Rating)) {
                        MediaSessionImplApi19.this.postToHandler(19, -1, -1, RatingCompat.fromRating(obj), (Bundle) null);
                    }
                }
            });
        }
    }

    static class MediaSessionImplApi22 extends MediaSessionImplApi21 {
        MediaSessionImplApi22(Context context, String str, VersionedParcelable versionedParcelable, Bundle bundle) {
            super(context, str, versionedParcelable, bundle);
        }

        public void setRatingType(int i2) {
            this.mSessionFwk.setRatingType(i2);
        }

        MediaSessionImplApi22(Object obj) {
            super(obj);
        }
    }

    static class MediaSessionImplApi28 extends MediaSessionImplApi22 {
        MediaSessionImplApi28(Context context, String str, VersionedParcelable versionedParcelable, Bundle bundle) {
            super(context, str, versionedParcelable, bundle);
        }

        public final MediaSessionManager$RemoteUserInfo getCurrentControllerInfo() {
            return new MediaSessionManager$RemoteUserInfo(this.mSessionFwk.getCurrentControllerInfo());
        }

        public void setCurrentControllerInfo(MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo) {
        }

        MediaSessionImplApi28(Object obj) {
            super(obj);
        }
    }

    static class MediaSessionImplApi29 extends MediaSessionImplApi28 {
        MediaSessionImplApi29(Context context, String str, VersionedParcelable versionedParcelable, Bundle bundle) {
            super(context, str, versionedParcelable, bundle);
        }

        public MediaSession createFwkMediaSession(Context context, String str, Bundle bundle) {
            return new MediaSession(context, str, bundle);
        }

        MediaSessionImplApi29(Object obj) {
            super(obj);
            this.mSessionInfo = ((MediaSession) obj).getController().getSessionInfo();
        }
    }

    static class MediaSessionImplBase implements MediaSessionImpl {
        static final int RCC_PLAYSTATE_NONE = 0;
        final AudioManager mAudioManager;
        volatile Callback mCallback;
        boolean mCaptioningEnabled;
        private final Context mContext;
        final RemoteCallbackList<IMediaControllerCallback> mControllerCallbacks = new RemoteCallbackList<>();
        boolean mDestroyed = false;
        Bundle mExtras;
        int mFlags = 3;
        private MessageHandler mHandler;
        boolean mIsActive = false;
        int mLocalStream;
        final Object mLock = new Object();
        private final ComponentName mMediaButtonReceiverComponentName;
        private final PendingIntent mMediaButtonReceiverIntent;
        MediaMetadataCompat mMetadata;
        List<QueueItem> mQueue;
        CharSequence mQueueTitle;
        int mRatingType;
        final RemoteControlClient mRcc;
        RegistrationCallbackHandler mRegistrationCallbackHandler;
        private MediaSessionManager$RemoteUserInfo mRemoteUserInfo;
        int mRepeatMode;
        PendingIntent mSessionActivity;
        final Bundle mSessionInfo;
        int mShuffleMode;
        PlaybackStateCompat mState;
        private final MediaSessionStub mStub;
        private final Token mToken;
        private VolumeProviderCompat.Callback mVolumeCallback = new VolumeProviderCompat.Callback() {
            public void onVolumeChanged(VolumeProviderCompat volumeProviderCompat) {
                if (MediaSessionImplBase.this.mVolumeProvider == volumeProviderCompat) {
                    MediaSessionImplBase mediaSessionImplBase = MediaSessionImplBase.this;
                    MediaSessionImplBase.this.sendVolumeInfoChanged(new ParcelableVolumeInfo(mediaSessionImplBase.mVolumeType, mediaSessionImplBase.mLocalStream, volumeProviderCompat.c(), volumeProviderCompat.b(), volumeProviderCompat.a()));
                }
            }
        };
        VolumeProviderCompat mVolumeProvider;
        int mVolumeType;

        private static final class Command {
            public final String command;
            public final Bundle extras;
            public final ResultReceiver stub;

            public Command(String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.command = str;
                this.extras = bundle;
                this.stub = resultReceiver;
            }
        }

        static class MediaSessionStub extends IMediaSession.Stub {
            private final AtomicReference<MediaSessionImplBase> mMediaSessionImplRef;
            private final String mPackageName;
            private final String mTag;

            MediaSessionStub(MediaSessionImplBase mediaSessionImplBase, String str, String str2) {
                this.mMediaSessionImplRef = new AtomicReference<>(mediaSessionImplBase);
                this.mPackageName = str;
                this.mTag = str2;
            }

            public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                postToHandler(25, (Object) mediaDescriptionCompat);
            }

            public void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat, int i2) {
                postToHandler(26, mediaDescriptionCompat, i2, (Bundle) null);
            }

            public void adjustVolume(int i2, int i3, String str) {
                MediaSessionImplBase mediaSessionImplBase = this.mMediaSessionImplRef.get();
                if (mediaSessionImplBase != null) {
                    mediaSessionImplBase.adjustVolume(i2, i3);
                }
            }

            public void fastForward() {
                postToHandler(16);
            }

            public Bundle getExtras() {
                Bundle bundle;
                MediaSessionImplBase mediaSessionImplBase = this.mMediaSessionImplRef.get();
                if (mediaSessionImplBase == null) {
                    return null;
                }
                synchronized (mediaSessionImplBase.mLock) {
                    bundle = mediaSessionImplBase.mExtras;
                }
                return bundle;
            }

            public long getFlags() {
                long j2;
                MediaSessionImplBase mediaSessionImplBase = this.mMediaSessionImplRef.get();
                if (mediaSessionImplBase == null) {
                    return 0;
                }
                synchronized (mediaSessionImplBase.mLock) {
                    j2 = (long) mediaSessionImplBase.mFlags;
                }
                return j2;
            }

            public PendingIntent getLaunchPendingIntent() {
                PendingIntent pendingIntent;
                MediaSessionImplBase mediaSessionImplBase = this.mMediaSessionImplRef.get();
                if (mediaSessionImplBase == null) {
                    return null;
                }
                synchronized (mediaSessionImplBase.mLock) {
                    pendingIntent = mediaSessionImplBase.mSessionActivity;
                }
                return pendingIntent;
            }

            public MediaMetadataCompat getMetadata() {
                MediaSessionImplBase mediaSessionImplBase = this.mMediaSessionImplRef.get();
                if (mediaSessionImplBase != null) {
                    return mediaSessionImplBase.mMetadata;
                }
                return null;
            }

            public String getPackageName() {
                return this.mPackageName;
            }

            public PlaybackStateCompat getPlaybackState() {
                PlaybackStateCompat playbackStateCompat;
                MediaMetadataCompat mediaMetadataCompat;
                MediaSessionImplBase mediaSessionImplBase = this.mMediaSessionImplRef.get();
                if (mediaSessionImplBase == null) {
                    return null;
                }
                synchronized (mediaSessionImplBase.mLock) {
                    playbackStateCompat = mediaSessionImplBase.mState;
                    mediaMetadataCompat = mediaSessionImplBase.mMetadata;
                }
                return MediaSessionCompat.getStateWithUpdatedPosition(playbackStateCompat, mediaMetadataCompat);
            }

            public List<QueueItem> getQueue() {
                List<QueueItem> list;
                MediaSessionImplBase mediaSessionImplBase = this.mMediaSessionImplRef.get();
                if (mediaSessionImplBase == null) {
                    return null;
                }
                synchronized (mediaSessionImplBase.mLock) {
                    list = mediaSessionImplBase.mQueue;
                }
                return list;
            }

            public CharSequence getQueueTitle() {
                MediaSessionImplBase mediaSessionImplBase = this.mMediaSessionImplRef.get();
                if (mediaSessionImplBase != null) {
                    return mediaSessionImplBase.mQueueTitle;
                }
                return null;
            }

            public int getRatingType() {
                MediaSessionImplBase mediaSessionImplBase = this.mMediaSessionImplRef.get();
                if (mediaSessionImplBase != null) {
                    return mediaSessionImplBase.mRatingType;
                }
                return 0;
            }

            public int getRepeatMode() {
                MediaSessionImplBase mediaSessionImplBase = this.mMediaSessionImplRef.get();
                if (mediaSessionImplBase != null) {
                    return mediaSessionImplBase.mRepeatMode;
                }
                return -1;
            }

            public Bundle getSessionInfo() {
                MediaSessionImplBase mediaSessionImplBase = this.mMediaSessionImplRef.get();
                if (mediaSessionImplBase == null || mediaSessionImplBase.mSessionInfo == null) {
                    return null;
                }
                return new Bundle(mediaSessionImplBase.mSessionInfo);
            }

            public int getShuffleMode() {
                MediaSessionImplBase mediaSessionImplBase = this.mMediaSessionImplRef.get();
                if (mediaSessionImplBase != null) {
                    return mediaSessionImplBase.mShuffleMode;
                }
                return -1;
            }

            public String getTag() {
                return this.mTag;
            }

            public ParcelableVolumeInfo getVolumeAttributes() {
                int i2;
                int i3;
                ParcelableVolumeInfo parcelableVolumeInfo;
                MediaSessionImplBase mediaSessionImplBase = this.mMediaSessionImplRef.get();
                if (mediaSessionImplBase == null) {
                    return null;
                }
                synchronized (mediaSessionImplBase.mLock) {
                    int i4 = mediaSessionImplBase.mVolumeType;
                    int i5 = mediaSessionImplBase.mLocalStream;
                    VolumeProviderCompat volumeProviderCompat = mediaSessionImplBase.mVolumeProvider;
                    int i6 = 2;
                    if (i4 == 2) {
                        int c2 = volumeProviderCompat.c();
                        int b2 = volumeProviderCompat.b();
                        i2 = volumeProviderCompat.a();
                        i3 = b2;
                        i6 = c2;
                    } else {
                        int streamMaxVolume = mediaSessionImplBase.mAudioManager.getStreamMaxVolume(i5);
                        i2 = mediaSessionImplBase.mAudioManager.getStreamVolume(i5);
                        i3 = streamMaxVolume;
                    }
                    parcelableVolumeInfo = new ParcelableVolumeInfo(i4, i5, i6, i3, i2);
                }
                return parcelableVolumeInfo;
            }

            public boolean isCaptioningEnabled() {
                MediaSessionImplBase mediaSessionImplBase = this.mMediaSessionImplRef.get();
                if (mediaSessionImplBase == null || !mediaSessionImplBase.mCaptioningEnabled) {
                    return false;
                }
                return true;
            }

            public boolean isShuffleModeEnabledRemoved() {
                return false;
            }

            public boolean isTransportControlEnabled() {
                return true;
            }

            public void next() {
                postToHandler(14);
            }

            public void pause() {
                postToHandler(12);
            }

            public void play() throws RemoteException {
                postToHandler(7);
            }

            public void playFromMediaId(String str, Bundle bundle) {
                postToHandler(8, str, bundle);
            }

            public void playFromSearch(String str, Bundle bundle) {
                postToHandler(9, str, bundle);
            }

            public void playFromUri(Uri uri, Bundle bundle) {
                postToHandler(10, uri, bundle);
            }

            /* access modifiers changed from: package-private */
            public void postToHandler(int i2) {
                postToHandler(i2, (Object) null, 0, (Bundle) null);
            }

            public void prepare() throws RemoteException {
                postToHandler(3);
            }

            public void prepareFromMediaId(String str, Bundle bundle) {
                postToHandler(4, str, bundle);
            }

            public void prepareFromSearch(String str, Bundle bundle) {
                postToHandler(5, str, bundle);
            }

            public void prepareFromUri(Uri uri, Bundle bundle) {
                postToHandler(6, uri, bundle);
            }

            public void previous() {
                postToHandler(15);
            }

            public void rate(RatingCompat ratingCompat) {
                postToHandler(19, (Object) ratingCompat);
            }

            public void rateWithExtras(RatingCompat ratingCompat, Bundle bundle) {
                postToHandler(31, ratingCompat, bundle);
            }

            public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                MediaSessionImplBase mediaSessionImplBase = this.mMediaSessionImplRef.get();
                if (mediaSessionImplBase == null) {
                    try {
                        iMediaControllerCallback.onSessionDestroyed();
                    } catch (Exception unused) {
                    }
                } else {
                    int callingPid = Binder.getCallingPid();
                    int callingUid = Binder.getCallingUid();
                    mediaSessionImplBase.mControllerCallbacks.register(iMediaControllerCallback, new MediaSessionManager$RemoteUserInfo(mediaSessionImplBase.getPackageNameForUid(callingUid), callingPid, callingUid));
                    synchronized (mediaSessionImplBase.mLock) {
                        RegistrationCallbackHandler registrationCallbackHandler = mediaSessionImplBase.mRegistrationCallbackHandler;
                        if (registrationCallbackHandler != null) {
                            registrationCallbackHandler.postCallbackRegistered(callingPid, callingUid);
                        }
                    }
                }
            }

            public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                postToHandler(27, (Object) mediaDescriptionCompat);
            }

            public void removeQueueItemAt(int i2) {
                postToHandler(28, i2);
            }

            public void rewind() {
                postToHandler(17);
            }

            public void seekTo(long j2) {
                postToHandler(18, (Object) Long.valueOf(j2));
            }

            public void sendCommand(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                ResultReceiver resultReceiver;
                if (resultReceiverWrapper == null) {
                    resultReceiver = null;
                } else {
                    resultReceiver = resultReceiverWrapper.mResultReceiver;
                }
                postToHandler(1, (Object) new Command(str, bundle, resultReceiver));
            }

            public void sendCustomAction(String str, Bundle bundle) throws RemoteException {
                postToHandler(20, str, bundle);
            }

            public boolean sendMediaButton(KeyEvent keyEvent) {
                postToHandler(21, (Object) keyEvent);
                return true;
            }

            public void setCaptioningEnabled(boolean z2) {
                postToHandler(29, (Object) Boolean.valueOf(z2));
            }

            public void setPlaybackSpeed(float f2) {
                postToHandler(32, (Object) Float.valueOf(f2));
            }

            public void setRepeatMode(int i2) {
                postToHandler(23, i2);
            }

            public void setShuffleMode(int i2) {
                postToHandler(30, i2);
            }

            public void setShuffleModeEnabledRemoved(boolean z2) {
            }

            public void setVolumeTo(int i2, int i3, String str) {
                MediaSessionImplBase mediaSessionImplBase = this.mMediaSessionImplRef.get();
                if (mediaSessionImplBase != null) {
                    mediaSessionImplBase.setVolumeTo(i2, i3);
                }
            }

            public void skipToQueueItem(long j2) {
                postToHandler(11, (Object) Long.valueOf(j2));
            }

            public void stop() {
                postToHandler(13);
            }

            public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                MediaSessionImplBase mediaSessionImplBase = this.mMediaSessionImplRef.get();
                if (mediaSessionImplBase != null) {
                    mediaSessionImplBase.mControllerCallbacks.unregister(iMediaControllerCallback);
                    int callingPid = Binder.getCallingPid();
                    int callingUid = Binder.getCallingUid();
                    synchronized (mediaSessionImplBase.mLock) {
                        RegistrationCallbackHandler registrationCallbackHandler = mediaSessionImplBase.mRegistrationCallbackHandler;
                        if (registrationCallbackHandler != null) {
                            registrationCallbackHandler.postCallbackUnregistered(callingPid, callingUid);
                        }
                    }
                }
            }

            /* access modifiers changed from: package-private */
            public void postToHandler(int i2, int i3) {
                postToHandler(i2, (Object) null, i3, (Bundle) null);
            }

            /* access modifiers changed from: package-private */
            public void postToHandler(int i2, Object obj) {
                postToHandler(i2, obj, 0, (Bundle) null);
            }

            /* access modifiers changed from: package-private */
            public void postToHandler(int i2, Object obj, Bundle bundle) {
                postToHandler(i2, obj, 0, bundle);
            }

            /* access modifiers changed from: package-private */
            public void postToHandler(int i2, Object obj, int i3, Bundle bundle) {
                MediaSessionImplBase mediaSessionImplBase = this.mMediaSessionImplRef.get();
                if (mediaSessionImplBase != null) {
                    mediaSessionImplBase.postToHandler(i2, i3, 0, obj, bundle);
                }
            }
        }

        class MessageHandler extends Handler {
            private static final int KEYCODE_MEDIA_PAUSE = 127;
            private static final int KEYCODE_MEDIA_PLAY = 126;
            private static final int MSG_ADD_QUEUE_ITEM = 25;
            private static final int MSG_ADD_QUEUE_ITEM_AT = 26;
            private static final int MSG_ADJUST_VOLUME = 2;
            private static final int MSG_COMMAND = 1;
            private static final int MSG_CUSTOM_ACTION = 20;
            private static final int MSG_FAST_FORWARD = 16;
            private static final int MSG_MEDIA_BUTTON = 21;
            private static final int MSG_NEXT = 14;
            private static final int MSG_PAUSE = 12;
            private static final int MSG_PLAY = 7;
            private static final int MSG_PLAY_MEDIA_ID = 8;
            private static final int MSG_PLAY_SEARCH = 9;
            private static final int MSG_PLAY_URI = 10;
            private static final int MSG_PREPARE = 3;
            private static final int MSG_PREPARE_MEDIA_ID = 4;
            private static final int MSG_PREPARE_SEARCH = 5;
            private static final int MSG_PREPARE_URI = 6;
            private static final int MSG_PREVIOUS = 15;
            private static final int MSG_RATE = 19;
            private static final int MSG_RATE_EXTRA = 31;
            private static final int MSG_REMOVE_QUEUE_ITEM = 27;
            private static final int MSG_REMOVE_QUEUE_ITEM_AT = 28;
            private static final int MSG_REWIND = 17;
            private static final int MSG_SEEK_TO = 18;
            private static final int MSG_SET_CAPTIONING_ENABLED = 29;
            private static final int MSG_SET_PLAYBACK_SPEED = 32;
            private static final int MSG_SET_REPEAT_MODE = 23;
            private static final int MSG_SET_SHUFFLE_MODE = 30;
            private static final int MSG_SET_VOLUME = 22;
            private static final int MSG_SKIP_TO_ITEM = 11;
            private static final int MSG_STOP = 13;

            public MessageHandler(Looper looper) {
                super(looper);
            }

            private void onMediaButtonEvent(KeyEvent keyEvent, Callback callback) {
                long j2;
                if (keyEvent != null && keyEvent.getAction() == 0) {
                    PlaybackStateCompat playbackStateCompat = MediaSessionImplBase.this.mState;
                    if (playbackStateCompat == null) {
                        j2 = 0;
                    } else {
                        j2 = playbackStateCompat.getActions();
                    }
                    int keyCode = keyEvent.getKeyCode();
                    if (keyCode != 79) {
                        if (keyCode != 126) {
                            if (keyCode != 127) {
                                switch (keyCode) {
                                    case 85:
                                        break;
                                    case 86:
                                        if ((j2 & 1) != 0) {
                                            callback.onStop();
                                            return;
                                        }
                                        return;
                                    case 87:
                                        if ((j2 & 32) != 0) {
                                            callback.onSkipToNext();
                                            return;
                                        }
                                        return;
                                    case 88:
                                        if ((j2 & 16) != 0) {
                                            callback.onSkipToPrevious();
                                            return;
                                        }
                                        return;
                                    case 89:
                                        if ((j2 & 8) != 0) {
                                            callback.onRewind();
                                            return;
                                        }
                                        return;
                                    case 90:
                                        if ((j2 & 64) != 0) {
                                            callback.onFastForward();
                                            return;
                                        }
                                        return;
                                    default:
                                        return;
                                }
                            } else if ((j2 & 2) != 0) {
                                callback.onPause();
                                return;
                            } else {
                                return;
                            }
                        } else if ((j2 & 4) != 0) {
                            callback.onPlay();
                            return;
                        } else {
                            return;
                        }
                    }
                    Log.w(MediaSessionCompat.TAG, "KEYCODE_MEDIA_PLAY_PAUSE and KEYCODE_HEADSETHOOK are handled already");
                }
            }

            public void handleMessage(Message message) {
                QueueItem queueItem;
                Callback callback = MediaSessionImplBase.this.mCallback;
                if (callback != null) {
                    Bundle data = message.getData();
                    MediaSessionCompat.ensureClassLoader(data);
                    MediaSessionImplBase.this.setCurrentControllerInfo(new MediaSessionManager$RemoteUserInfo(data.getString(MediaSessionCompat.DATA_CALLING_PACKAGE), data.getInt(MediaSessionCompat.DATA_CALLING_PID), data.getInt(MediaSessionCompat.DATA_CALLING_UID)));
                    Bundle bundle = data.getBundle(MediaSessionCompat.DATA_EXTRAS);
                    MediaSessionCompat.ensureClassLoader(bundle);
                    try {
                        switch (message.what) {
                            case 1:
                                Command command = (Command) message.obj;
                                callback.onCommand(command.command, command.extras, command.stub);
                                break;
                            case 2:
                                MediaSessionImplBase.this.adjustVolume(message.arg1, 0);
                                break;
                            case 3:
                                callback.onPrepare();
                                break;
                            case 4:
                                callback.onPrepareFromMediaId((String) message.obj, bundle);
                                break;
                            case 5:
                                callback.onPrepareFromSearch((String) message.obj, bundle);
                                break;
                            case 6:
                                callback.onPrepareFromUri((Uri) message.obj, bundle);
                                break;
                            case 7:
                                callback.onPlay();
                                break;
                            case 8:
                                callback.onPlayFromMediaId((String) message.obj, bundle);
                                break;
                            case 9:
                                callback.onPlayFromSearch((String) message.obj, bundle);
                                break;
                            case 10:
                                callback.onPlayFromUri((Uri) message.obj, bundle);
                                break;
                            case 11:
                                callback.onSkipToQueueItem(((Long) message.obj).longValue());
                                break;
                            case 12:
                                callback.onPause();
                                break;
                            case 13:
                                callback.onStop();
                                break;
                            case 14:
                                callback.onSkipToNext();
                                break;
                            case 15:
                                callback.onSkipToPrevious();
                                break;
                            case 16:
                                callback.onFastForward();
                                break;
                            case 17:
                                callback.onRewind();
                                break;
                            case 18:
                                callback.onSeekTo(((Long) message.obj).longValue());
                                break;
                            case 19:
                                callback.onSetRating((RatingCompat) message.obj);
                                break;
                            case 20:
                                callback.onCustomAction((String) message.obj, bundle);
                                break;
                            case 21:
                                KeyEvent keyEvent = (KeyEvent) message.obj;
                                Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                                intent.putExtra("android.intent.extra.KEY_EVENT", keyEvent);
                                if (!callback.onMediaButtonEvent(intent)) {
                                    onMediaButtonEvent(keyEvent, callback);
                                    break;
                                }
                                break;
                            case 22:
                                MediaSessionImplBase.this.setVolumeTo(message.arg1, 0);
                                break;
                            case 23:
                                callback.onSetRepeatMode(message.arg1);
                                break;
                            case 25:
                                callback.onAddQueueItem((MediaDescriptionCompat) message.obj);
                                break;
                            case 26:
                                callback.onAddQueueItem((MediaDescriptionCompat) message.obj, message.arg1);
                                break;
                            case 27:
                                callback.onRemoveQueueItem((MediaDescriptionCompat) message.obj);
                                break;
                            case 28:
                                List<QueueItem> list = MediaSessionImplBase.this.mQueue;
                                if (list != null) {
                                    int i2 = message.arg1;
                                    if (i2 < 0 || i2 >= list.size()) {
                                        queueItem = null;
                                    } else {
                                        queueItem = MediaSessionImplBase.this.mQueue.get(message.arg1);
                                    }
                                    if (queueItem != null) {
                                        callback.onRemoveQueueItem(queueItem.getDescription());
                                        break;
                                    }
                                }
                                break;
                            case 29:
                                callback.onSetCaptioningEnabled(((Boolean) message.obj).booleanValue());
                                break;
                            case 30:
                                callback.onSetShuffleMode(message.arg1);
                                break;
                            case 31:
                                callback.onSetRating((RatingCompat) message.obj, bundle);
                                break;
                            case 32:
                                callback.onSetPlaybackSpeed(((Float) message.obj).floatValue());
                                break;
                        }
                    } finally {
                        MediaSessionImplBase.this.setCurrentControllerInfo((MediaSessionManager$RemoteUserInfo) null);
                    }
                }
            }
        }

        public MediaSessionImplBase(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, VersionedParcelable versionedParcelable, Bundle bundle) {
            if (componentName != null) {
                this.mContext = context;
                this.mSessionInfo = bundle;
                this.mAudioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
                this.mMediaButtonReceiverComponentName = componentName;
                this.mMediaButtonReceiverIntent = pendingIntent;
                MediaSessionStub mediaSessionStub = new MediaSessionStub(this, context.getPackageName(), str);
                this.mStub = mediaSessionStub;
                this.mToken = new Token(mediaSessionStub, (IMediaSession) null, versionedParcelable);
                this.mRatingType = 0;
                this.mVolumeType = 1;
                this.mLocalStream = 3;
                this.mRcc = new RemoteControlClient(pendingIntent);
                return;
            }
            throw new IllegalArgumentException("MediaButtonReceiver component may not be null");
        }

        private void sendCaptioningEnabled(boolean z2) {
            synchronized (this.mLock) {
                for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onCaptioningEnabledChanged(z2);
                    } catch (RemoteException unused) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendEvent(String str, Bundle bundle) {
            synchronized (this.mLock) {
                for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onEvent(str, bundle);
                    } catch (RemoteException unused) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendExtras(Bundle bundle) {
            synchronized (this.mLock) {
                for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onExtrasChanged(bundle);
                    } catch (RemoteException unused) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendMetadata(MediaMetadataCompat mediaMetadataCompat) {
            synchronized (this.mLock) {
                for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onMetadataChanged(mediaMetadataCompat);
                    } catch (RemoteException unused) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendQueue(List<QueueItem> list) {
            synchronized (this.mLock) {
                for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onQueueChanged(list);
                    } catch (RemoteException unused) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendQueueTitle(CharSequence charSequence) {
            synchronized (this.mLock) {
                for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onQueueTitleChanged(charSequence);
                    } catch (RemoteException unused) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendRepeatMode(int i2) {
            synchronized (this.mLock) {
                for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onRepeatModeChanged(i2);
                    } catch (RemoteException unused) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendSessionDestroyed() {
            synchronized (this.mLock) {
                for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onSessionDestroyed();
                    } catch (RemoteException unused) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
                this.mControllerCallbacks.kill();
            }
        }

        private void sendShuffleMode(int i2) {
            synchronized (this.mLock) {
                for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onShuffleModeChanged(i2);
                    } catch (RemoteException unused) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        private void sendState(PlaybackStateCompat playbackStateCompat) {
            synchronized (this.mLock) {
                for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onPlaybackStateChanged(playbackStateCompat);
                    } catch (RemoteException unused) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        /* access modifiers changed from: package-private */
        public void adjustVolume(int i2, int i3) {
            if (this.mVolumeType == 2) {
                VolumeProviderCompat volumeProviderCompat = this.mVolumeProvider;
                if (volumeProviderCompat != null) {
                    volumeProviderCompat.e(i2);
                    return;
                }
                return;
            }
            this.mAudioManager.adjustStreamVolume(this.mLocalStream, i2, i3);
        }

        /* access modifiers changed from: package-private */
        public RemoteControlClient.MetadataEditor buildRccMetadata(Bundle bundle) {
            RemoteControlClient.MetadataEditor editMetadata = this.mRcc.editMetadata(true);
            if (bundle == null) {
                return editMetadata;
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_ART)) {
                Bitmap bitmap = (Bitmap) bundle.getParcelable(MediaMetadataCompat.METADATA_KEY_ART);
                if (bitmap != null) {
                    bitmap = bitmap.copy(bitmap.getConfig(), false);
                }
                editMetadata.putBitmap(100, bitmap);
            } else if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_ALBUM_ART)) {
                Bitmap bitmap2 = (Bitmap) bundle.getParcelable(MediaMetadataCompat.METADATA_KEY_ALBUM_ART);
                if (bitmap2 != null) {
                    bitmap2 = bitmap2.copy(bitmap2.getConfig(), false);
                }
                editMetadata.putBitmap(100, bitmap2);
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_ALBUM)) {
                editMetadata.putString(1, bundle.getString(MediaMetadataCompat.METADATA_KEY_ALBUM));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST)) {
                editMetadata.putString(13, bundle.getString(MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_ARTIST)) {
                editMetadata.putString(2, bundle.getString(MediaMetadataCompat.METADATA_KEY_ARTIST));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_AUTHOR)) {
                editMetadata.putString(3, bundle.getString(MediaMetadataCompat.METADATA_KEY_AUTHOR));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_COMPILATION)) {
                editMetadata.putString(15, bundle.getString(MediaMetadataCompat.METADATA_KEY_COMPILATION));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_COMPOSER)) {
                editMetadata.putString(4, bundle.getString(MediaMetadataCompat.METADATA_KEY_COMPOSER));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_DATE)) {
                editMetadata.putString(5, bundle.getString(MediaMetadataCompat.METADATA_KEY_DATE));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_DISC_NUMBER)) {
                editMetadata.putLong(14, bundle.getLong(MediaMetadataCompat.METADATA_KEY_DISC_NUMBER));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_DURATION)) {
                editMetadata.putLong(9, bundle.getLong(MediaMetadataCompat.METADATA_KEY_DURATION));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_GENRE)) {
                editMetadata.putString(6, bundle.getString(MediaMetadataCompat.METADATA_KEY_GENRE));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_TITLE)) {
                editMetadata.putString(7, bundle.getString(MediaMetadataCompat.METADATA_KEY_TITLE));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_TRACK_NUMBER)) {
                editMetadata.putLong(0, bundle.getLong(MediaMetadataCompat.METADATA_KEY_TRACK_NUMBER));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_WRITER)) {
                editMetadata.putString(11, bundle.getString(MediaMetadataCompat.METADATA_KEY_WRITER));
            }
            return editMetadata;
        }

        public Callback getCallback() {
            Callback callback;
            synchronized (this.mLock) {
                callback = this.mCallback;
            }
            return callback;
        }

        public String getCallingPackage() {
            return null;
        }

        public MediaSessionManager$RemoteUserInfo getCurrentControllerInfo() {
            MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo;
            synchronized (this.mLock) {
                mediaSessionManager$RemoteUserInfo = this.mRemoteUserInfo;
            }
            return mediaSessionManager$RemoteUserInfo;
        }

        public Object getMediaSession() {
            return null;
        }

        /* access modifiers changed from: package-private */
        public String getPackageNameForUid(int i2) {
            String nameForUid = this.mContext.getPackageManager().getNameForUid(i2);
            if (TextUtils.isEmpty(nameForUid)) {
                return "android.media.session.MediaController";
            }
            return nameForUid;
        }

        public PlaybackStateCompat getPlaybackState() {
            PlaybackStateCompat playbackStateCompat;
            synchronized (this.mLock) {
                playbackStateCompat = this.mState;
            }
            return playbackStateCompat;
        }

        /* access modifiers changed from: package-private */
        public int getRccStateFromState(int i2) {
            switch (i2) {
                case 0:
                    return 0;
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                case 8:
                    return 8;
                case 7:
                    return 9;
                case 9:
                    return 7;
                case 10:
                case 11:
                    return 6;
                default:
                    return -1;
            }
        }

        /* access modifiers changed from: package-private */
        public int getRccTransportControlFlagsFromActions(long j2) {
            int i2 = (1 & j2) != 0 ? 32 : 0;
            if ((2 & j2) != 0) {
                i2 |= 16;
            }
            if ((4 & j2) != 0) {
                i2 |= 4;
            }
            if ((8 & j2) != 0) {
                i2 |= 2;
            }
            if ((16 & j2) != 0) {
                i2 |= 1;
            }
            if ((32 & j2) != 0) {
                i2 |= 128;
            }
            if ((64 & j2) != 0) {
                i2 |= 64;
            }
            return (j2 & 512) != 0 ? i2 | 8 : i2;
        }

        public Object getRemoteControlClient() {
            return null;
        }

        public Token getSessionToken() {
            return this.mToken;
        }

        public boolean isActive() {
            return this.mIsActive;
        }

        /* access modifiers changed from: package-private */
        public void postToHandler(int i2, int i3, int i4, Object obj, Bundle bundle) {
            synchronized (this.mLock) {
                MessageHandler messageHandler = this.mHandler;
                if (messageHandler != null) {
                    Message obtainMessage = messageHandler.obtainMessage(i2, i3, i4, obj);
                    Bundle bundle2 = new Bundle();
                    int callingUid = Binder.getCallingUid();
                    bundle2.putInt(MediaSessionCompat.DATA_CALLING_UID, callingUid);
                    bundle2.putString(MediaSessionCompat.DATA_CALLING_PACKAGE, getPackageNameForUid(callingUid));
                    int callingPid = Binder.getCallingPid();
                    if (callingPid > 0) {
                        bundle2.putInt(MediaSessionCompat.DATA_CALLING_PID, callingPid);
                    } else {
                        bundle2.putInt(MediaSessionCompat.DATA_CALLING_PID, -1);
                    }
                    if (bundle != null) {
                        bundle2.putBundle(MediaSessionCompat.DATA_EXTRAS, bundle);
                    }
                    obtainMessage.setData(bundle2);
                    obtainMessage.sendToTarget();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void registerMediaButtonEventReceiver(PendingIntent pendingIntent, ComponentName componentName) {
            this.mAudioManager.registerMediaButtonEventReceiver(componentName);
        }

        public void release() {
            this.mIsActive = false;
            this.mDestroyed = true;
            updateMbrAndRcc();
            sendSessionDestroyed();
            setCallback((Callback) null, (Handler) null);
        }

        public void sendSessionEvent(String str, Bundle bundle) {
            sendEvent(str, bundle);
        }

        /* access modifiers changed from: package-private */
        public void sendVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) {
            synchronized (this.mLock) {
                for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onVolumeInfoChanged(parcelableVolumeInfo);
                    } catch (RemoteException unused) {
                    }
                }
                this.mControllerCallbacks.finishBroadcast();
            }
        }

        public void setActive(boolean z2) {
            if (z2 != this.mIsActive) {
                this.mIsActive = z2;
                updateMbrAndRcc();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0030  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void setCallback(android.support.v4.media.session.MediaSessionCompat.Callback r5, android.os.Handler r6) {
            /*
                r4 = this;
                java.lang.Object r0 = r4.mLock
                monitor-enter(r0)
                android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$MessageHandler r1 = r4.mHandler     // Catch:{ all -> 0x0037 }
                r2 = 0
                if (r1 == 0) goto L_0x000b
                r1.removeCallbacksAndMessages(r2)     // Catch:{ all -> 0x0037 }
            L_0x000b:
                if (r5 == 0) goto L_0x001a
                if (r6 != 0) goto L_0x0010
                goto L_0x001a
            L_0x0010:
                android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$MessageHandler r1 = new android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$MessageHandler     // Catch:{ all -> 0x0037 }
                android.os.Looper r3 = r6.getLooper()     // Catch:{ all -> 0x0037 }
                r1.<init>(r3)     // Catch:{ all -> 0x0037 }
                goto L_0x001b
            L_0x001a:
                r1 = r2
            L_0x001b:
                r4.mHandler = r1     // Catch:{ all -> 0x0037 }
                android.support.v4.media.session.MediaSessionCompat$Callback r1 = r4.mCallback     // Catch:{ all -> 0x0037 }
                if (r1 == r5) goto L_0x002a
                android.support.v4.media.session.MediaSessionCompat$Callback r1 = r4.mCallback     // Catch:{ all -> 0x0037 }
                if (r1 == 0) goto L_0x002a
                android.support.v4.media.session.MediaSessionCompat$Callback r1 = r4.mCallback     // Catch:{ all -> 0x0037 }
                r1.setSessionImpl(r2, r2)     // Catch:{ all -> 0x0037 }
            L_0x002a:
                r4.mCallback = r5     // Catch:{ all -> 0x0037 }
                android.support.v4.media.session.MediaSessionCompat$Callback r5 = r4.mCallback     // Catch:{ all -> 0x0037 }
                if (r5 == 0) goto L_0x0035
                android.support.v4.media.session.MediaSessionCompat$Callback r5 = r4.mCallback     // Catch:{ all -> 0x0037 }
                r5.setSessionImpl(r4, r6)     // Catch:{ all -> 0x0037 }
            L_0x0035:
                monitor-exit(r0)     // Catch:{ all -> 0x0037 }
                return
            L_0x0037:
                r5 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0037 }
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.setCallback(android.support.v4.media.session.MediaSessionCompat$Callback, android.os.Handler):void");
        }

        public void setCaptioningEnabled(boolean z2) {
            if (this.mCaptioningEnabled != z2) {
                this.mCaptioningEnabled = z2;
                sendCaptioningEnabled(z2);
            }
        }

        public void setCurrentControllerInfo(MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo) {
            synchronized (this.mLock) {
                this.mRemoteUserInfo = mediaSessionManager$RemoteUserInfo;
            }
        }

        public void setExtras(Bundle bundle) {
            this.mExtras = bundle;
            sendExtras(bundle);
        }

        public void setFlags(int i2) {
            synchronized (this.mLock) {
                this.mFlags = i2 | 1 | 2;
            }
        }

        public void setMediaButtonReceiver(PendingIntent pendingIntent) {
        }

        public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
            Bundle bundle;
            if (mediaMetadataCompat != null) {
                mediaMetadataCompat = new MediaMetadataCompat.Builder(mediaMetadataCompat, MediaSessionCompat.sMaxBitmapSize).build();
            }
            synchronized (this.mLock) {
                this.mMetadata = mediaMetadataCompat;
            }
            sendMetadata(mediaMetadataCompat);
            if (this.mIsActive) {
                if (mediaMetadataCompat == null) {
                    bundle = null;
                } else {
                    bundle = mediaMetadataCompat.getBundle();
                }
                buildRccMetadata(bundle).apply();
            }
        }

        public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
            synchronized (this.mLock) {
                this.mState = playbackStateCompat;
            }
            sendState(playbackStateCompat);
            if (this.mIsActive) {
                if (playbackStateCompat == null) {
                    this.mRcc.setPlaybackState(0);
                    this.mRcc.setTransportControlFlags(0);
                    return;
                }
                setRccState(playbackStateCompat);
                this.mRcc.setTransportControlFlags(getRccTransportControlFlagsFromActions(playbackStateCompat.getActions()));
            }
        }

        public void setPlaybackToLocal(int i2) {
            VolumeProviderCompat volumeProviderCompat = this.mVolumeProvider;
            if (volumeProviderCompat != null) {
                volumeProviderCompat.g((VolumeProviderCompat.Callback) null);
            }
            this.mLocalStream = i2;
            this.mVolumeType = 1;
            int i3 = this.mVolumeType;
            int i4 = this.mLocalStream;
            sendVolumeInfoChanged(new ParcelableVolumeInfo(i3, i4, 2, this.mAudioManager.getStreamMaxVolume(i4), this.mAudioManager.getStreamVolume(this.mLocalStream)));
        }

        public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat) {
            if (volumeProviderCompat != null) {
                VolumeProviderCompat volumeProviderCompat2 = this.mVolumeProvider;
                if (volumeProviderCompat2 != null) {
                    volumeProviderCompat2.g((VolumeProviderCompat.Callback) null);
                }
                this.mVolumeType = 2;
                this.mVolumeProvider = volumeProviderCompat;
                sendVolumeInfoChanged(new ParcelableVolumeInfo(this.mVolumeType, this.mLocalStream, this.mVolumeProvider.c(), this.mVolumeProvider.b(), this.mVolumeProvider.a()));
                volumeProviderCompat.g(this.mVolumeCallback);
                return;
            }
            throw new IllegalArgumentException("volumeProvider may not be null");
        }

        public void setQueue(List<QueueItem> list) {
            this.mQueue = list;
            sendQueue(list);
        }

        public void setQueueTitle(CharSequence charSequence) {
            this.mQueueTitle = charSequence;
            sendQueueTitle(charSequence);
        }

        public void setRatingType(int i2) {
            this.mRatingType = i2;
        }

        /* access modifiers changed from: package-private */
        public void setRccState(PlaybackStateCompat playbackStateCompat) {
            this.mRcc.setPlaybackState(getRccStateFromState(playbackStateCompat.getState()));
        }

        public void setRegistrationCallback(RegistrationCallback registrationCallback, Handler handler) {
            synchronized (this.mLock) {
                RegistrationCallbackHandler registrationCallbackHandler = this.mRegistrationCallbackHandler;
                if (registrationCallbackHandler != null) {
                    registrationCallbackHandler.removeCallbacksAndMessages((Object) null);
                }
                if (registrationCallback != null) {
                    this.mRegistrationCallbackHandler = new RegistrationCallbackHandler(handler.getLooper(), registrationCallback);
                } else {
                    this.mRegistrationCallbackHandler = null;
                }
            }
        }

        public void setRepeatMode(int i2) {
            if (this.mRepeatMode != i2) {
                this.mRepeatMode = i2;
                sendRepeatMode(i2);
            }
        }

        public void setSessionActivity(PendingIntent pendingIntent) {
            synchronized (this.mLock) {
                this.mSessionActivity = pendingIntent;
            }
        }

        public void setShuffleMode(int i2) {
            if (this.mShuffleMode != i2) {
                this.mShuffleMode = i2;
                sendShuffleMode(i2);
            }
        }

        /* access modifiers changed from: package-private */
        public void setVolumeTo(int i2, int i3) {
            if (this.mVolumeType == 2) {
                VolumeProviderCompat volumeProviderCompat = this.mVolumeProvider;
                if (volumeProviderCompat != null) {
                    volumeProviderCompat.f(i2);
                    return;
                }
                return;
            }
            this.mAudioManager.setStreamVolume(this.mLocalStream, i2, i3);
        }

        /* access modifiers changed from: package-private */
        public void unregisterMediaButtonEventReceiver(PendingIntent pendingIntent, ComponentName componentName) {
            this.mAudioManager.unregisterMediaButtonEventReceiver(componentName);
        }

        /* access modifiers changed from: package-private */
        public void updateMbrAndRcc() {
            if (this.mIsActive) {
                registerMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
                this.mAudioManager.registerRemoteControlClient(this.mRcc);
                setMetadata(this.mMetadata);
                setPlaybackState(this.mState);
                return;
            }
            unregisterMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
            this.mRcc.setPlaybackState(0);
            this.mAudioManager.unregisterRemoteControlClient(this.mRcc);
        }
    }

    public interface OnActiveChangeListener {
        void onActiveChanged();
    }

    @SuppressLint({"BanParcelableUsage"})
    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new Parcelable.Creator<QueueItem>() {
            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            public QueueItem[] newArray(int i2) {
                return new QueueItem[i2];
            }
        };
        public static final int UNKNOWN_ID = -1;
        private final MediaDescriptionCompat mDescription;
        private final long mId;
        private MediaSession.QueueItem mItemFwk;

        private static class Api21Impl {
            private Api21Impl() {
            }

            static MediaSession.QueueItem createQueueItem(MediaDescription mediaDescription, long j2) {
                return new MediaSession.QueueItem(mediaDescription, j2);
            }

            static MediaDescription getDescription(MediaSession.QueueItem queueItem) {
                return queueItem.getDescription();
            }

            static long getQueueId(MediaSession.QueueItem queueItem) {
                return queueItem.getQueueId();
            }
        }

        public QueueItem(MediaDescriptionCompat mediaDescriptionCompat, long j2) {
            this((MediaSession.QueueItem) null, mediaDescriptionCompat, j2);
        }

        public static QueueItem fromQueueItem(Object obj) {
            if (obj == null) {
                return null;
            }
            MediaSession.QueueItem queueItem = (MediaSession.QueueItem) obj;
            return new QueueItem(queueItem, MediaDescriptionCompat.fromMediaDescription(Api21Impl.getDescription(queueItem)), Api21Impl.getQueueId(queueItem));
        }

        public static List<QueueItem> fromQueueItemList(List<?> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (Object fromQueueItem : list) {
                arrayList.add(fromQueueItem(fromQueueItem));
            }
            return arrayList;
        }

        public int describeContents() {
            return 0;
        }

        public MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public long getQueueId() {
            return this.mId;
        }

        public Object getQueueItem() {
            MediaSession.QueueItem queueItem = this.mItemFwk;
            if (queueItem != null) {
                return queueItem;
            }
            MediaSession.QueueItem createQueueItem = Api21Impl.createQueueItem((MediaDescription) this.mDescription.getMediaDescription(), this.mId);
            this.mItemFwk = createQueueItem;
            return createQueueItem;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.mDescription + ", Id=" + this.mId + " }";
        }

        public void writeToParcel(Parcel parcel, int i2) {
            this.mDescription.writeToParcel(parcel, i2);
            parcel.writeLong(this.mId);
        }

        private QueueItem(MediaSession.QueueItem queueItem, MediaDescriptionCompat mediaDescriptionCompat, long j2) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null");
            } else if (j2 != -1) {
                this.mDescription = mediaDescriptionCompat;
                this.mId = j2;
                this.mItemFwk = queueItem;
            } else {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
        }

        QueueItem(Parcel parcel) {
            this.mDescription = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.mId = parcel.readLong();
        }
    }

    public interface RegistrationCallback {
        void onCallbackRegistered(int i2, int i3);

        void onCallbackUnregistered(int i2, int i3);
    }

    static final class RegistrationCallbackHandler extends Handler {
        private static final int MSG_CALLBACK_REGISTERED = 1001;
        private static final int MSG_CALLBACK_UNREGISTERED = 1002;
        private final RegistrationCallback mCallback;

        RegistrationCallbackHandler(Looper looper, RegistrationCallback registrationCallback) {
            super(looper);
            this.mCallback = registrationCallback;
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i2 = message.what;
            if (i2 == 1001) {
                this.mCallback.onCallbackRegistered(message.arg1, message.arg2);
            } else if (i2 == 1002) {
                this.mCallback.onCallbackUnregistered(message.arg1, message.arg2);
            }
        }

        public void postCallbackRegistered(int i2, int i3) {
            obtainMessage(1001, i2, i3).sendToTarget();
        }

        public void postCallbackUnregistered(int i2, int i3) {
            obtainMessage(1002, i2, i3).sendToTarget();
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new Parcelable.Creator<Token>() {
            public Token createFromParcel(Parcel parcel) {
                return new Token(parcel.readParcelable((ClassLoader) null));
            }

            public Token[] newArray(int i2) {
                return new Token[i2];
            }
        };
        private IMediaSession mExtraBinder;
        private final Object mInner;
        private final Object mLock;
        private VersionedParcelable mSession2Token;

        Token(Object obj) {
            this(obj, (IMediaSession) null, (VersionedParcelable) null);
        }

        public static Token fromBundle(Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            bundle.setClassLoader(Token.class.getClassLoader());
            IMediaSession asInterface = IMediaSession.Stub.asInterface(BundleCompat.a(bundle, MediaSessionCompat.KEY_EXTRA_BINDER));
            VersionedParcelable b2 = ParcelUtils.b(bundle, MediaSessionCompat.KEY_SESSION2_TOKEN);
            Token token = (Token) bundle.getParcelable(MediaSessionCompat.KEY_TOKEN);
            if (token == null) {
                return null;
            }
            return new Token(token.mInner, asInterface, b2);
        }

        public static Token fromToken(Object obj) {
            return fromToken(obj, (IMediaSession) null);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            Object obj2 = this.mInner;
            if (obj2 != null) {
                Object obj3 = token.mInner;
                if (obj3 == null) {
                    return false;
                }
                return obj2.equals(obj3);
            } else if (token.mInner == null) {
                return true;
            } else {
                return false;
            }
        }

        public IMediaSession getExtraBinder() {
            IMediaSession iMediaSession;
            synchronized (this.mLock) {
                iMediaSession = this.mExtraBinder;
            }
            return iMediaSession;
        }

        public VersionedParcelable getSession2Token() {
            VersionedParcelable versionedParcelable;
            synchronized (this.mLock) {
                versionedParcelable = this.mSession2Token;
            }
            return versionedParcelable;
        }

        public Object getToken() {
            return this.mInner;
        }

        public int hashCode() {
            Object obj = this.mInner;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public void setExtraBinder(IMediaSession iMediaSession) {
            synchronized (this.mLock) {
                this.mExtraBinder = iMediaSession;
            }
        }

        public void setSession2Token(VersionedParcelable versionedParcelable) {
            synchronized (this.mLock) {
                this.mSession2Token = versionedParcelable;
            }
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putParcelable(MediaSessionCompat.KEY_TOKEN, this);
            synchronized (this.mLock) {
                IMediaSession iMediaSession = this.mExtraBinder;
                if (iMediaSession != null) {
                    BundleCompat.b(bundle, MediaSessionCompat.KEY_EXTRA_BINDER, iMediaSession.asBinder());
                }
                VersionedParcelable versionedParcelable = this.mSession2Token;
                if (versionedParcelable != null) {
                    ParcelUtils.c(bundle, MediaSessionCompat.KEY_SESSION2_TOKEN, versionedParcelable);
                }
            }
            return bundle;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeParcelable((Parcelable) this.mInner, i2);
        }

        Token(Object obj, IMediaSession iMediaSession) {
            this(obj, iMediaSession, (VersionedParcelable) null);
        }

        public static Token fromToken(Object obj, IMediaSession iMediaSession) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof MediaSession.Token) {
                return new Token(obj, iMediaSession);
            }
            throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
        }

        Token(Object obj, IMediaSession iMediaSession, VersionedParcelable versionedParcelable) {
            this.mLock = new Object();
            this.mInner = obj;
            this.mExtraBinder = iMediaSession;
            this.mSession2Token = versionedParcelable;
        }
    }

    public MediaSessionCompat(Context context, String str) {
        this(context, str, (ComponentName) null, (PendingIntent) null);
    }

    public static void ensureClassLoader(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    public static MediaSessionCompat fromMediaSession(Context context, Object obj) {
        MediaSessionImpl mediaSessionImpl;
        int i2 = Build.VERSION.SDK_INT;
        if (context == null || obj == null) {
            return null;
        }
        if (i2 >= 29) {
            mediaSessionImpl = new MediaSessionImplApi29(obj);
        } else if (i2 >= 28) {
            mediaSessionImpl = new MediaSessionImplApi28(obj);
        } else {
            mediaSessionImpl = new MediaSessionImplApi21(obj);
        }
        return new MediaSessionCompat(context, mediaSessionImpl);
    }

    static PlaybackStateCompat getStateWithUpdatedPosition(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat) {
        long j2;
        if (playbackStateCompat == null) {
            return playbackStateCompat;
        }
        long j3 = -1;
        if (playbackStateCompat.getPosition() == -1) {
            return playbackStateCompat;
        }
        if (playbackStateCompat.getState() != 3 && playbackStateCompat.getState() != 4 && playbackStateCompat.getState() != 5) {
            return playbackStateCompat;
        }
        long lastPositionUpdateTime = playbackStateCompat.getLastPositionUpdateTime();
        if (lastPositionUpdateTime <= 0) {
            return playbackStateCompat;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long playbackSpeed = ((long) (playbackStateCompat.getPlaybackSpeed() * ((float) (elapsedRealtime - lastPositionUpdateTime)))) + playbackStateCompat.getPosition();
        if (mediaMetadataCompat != null && mediaMetadataCompat.containsKey(MediaMetadataCompat.METADATA_KEY_DURATION)) {
            j3 = mediaMetadataCompat.getLong(MediaMetadataCompat.METADATA_KEY_DURATION);
        }
        if (j3 >= 0 && playbackSpeed > j3) {
            j2 = j3;
        } else if (playbackSpeed < 0) {
            j2 = 0;
        } else {
            j2 = playbackSpeed;
        }
        return new PlaybackStateCompat.Builder(playbackStateCompat).setState(playbackStateCompat.getState(), j2, playbackStateCompat.getPlaybackSpeed(), elapsedRealtime).build();
    }

    public static Bundle unparcelWithClassLoader(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        ensureClassLoader(bundle);
        try {
            bundle.isEmpty();
            return bundle;
        } catch (BadParcelableException unused) {
            Log.e(TAG, "Could not unparcel the data.");
            return null;
        }
    }

    public void addOnActiveChangeListener(OnActiveChangeListener onActiveChangeListener) {
        if (onActiveChangeListener != null) {
            this.mActiveListeners.add(onActiveChangeListener);
            return;
        }
        throw new IllegalArgumentException("Listener may not be null");
    }

    public String getCallingPackage() {
        return this.mImpl.getCallingPackage();
    }

    public MediaControllerCompat getController() {
        return this.mController;
    }

    public final MediaSessionManager$RemoteUserInfo getCurrentControllerInfo() {
        return this.mImpl.getCurrentControllerInfo();
    }

    public Object getMediaSession() {
        return this.mImpl.getMediaSession();
    }

    public Object getRemoteControlClient() {
        return this.mImpl.getRemoteControlClient();
    }

    public Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public boolean isActive() {
        return this.mImpl.isActive();
    }

    public void release() {
        this.mImpl.release();
    }

    public void removeOnActiveChangeListener(OnActiveChangeListener onActiveChangeListener) {
        if (onActiveChangeListener != null) {
            this.mActiveListeners.remove(onActiveChangeListener);
            return;
        }
        throw new IllegalArgumentException("Listener may not be null");
    }

    public void sendSessionEvent(String str, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            this.mImpl.sendSessionEvent(str, bundle);
            return;
        }
        throw new IllegalArgumentException("event cannot be null or empty");
    }

    public void setActive(boolean z2) {
        this.mImpl.setActive(z2);
        Iterator<OnActiveChangeListener> it2 = this.mActiveListeners.iterator();
        while (it2.hasNext()) {
            it2.next().onActiveChanged();
        }
    }

    public void setCallback(Callback callback) {
        setCallback(callback, (Handler) null);
    }

    public void setCaptioningEnabled(boolean z2) {
        this.mImpl.setCaptioningEnabled(z2);
    }

    public void setExtras(Bundle bundle) {
        this.mImpl.setExtras(bundle);
    }

    public void setFlags(int i2) {
        this.mImpl.setFlags(i2);
    }

    public void setMediaButtonReceiver(PendingIntent pendingIntent) {
        this.mImpl.setMediaButtonReceiver(pendingIntent);
    }

    public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
        this.mImpl.setMetadata(mediaMetadataCompat);
    }

    public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
        this.mImpl.setPlaybackState(playbackStateCompat);
    }

    public void setPlaybackToLocal(int i2) {
        this.mImpl.setPlaybackToLocal(i2);
    }

    public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat) {
        if (volumeProviderCompat != null) {
            this.mImpl.setPlaybackToRemote(volumeProviderCompat);
            return;
        }
        throw new IllegalArgumentException("volumeProvider may not be null!");
    }

    public void setQueue(List<QueueItem> list) {
        if (list != null) {
            HashSet hashSet = new HashSet();
            for (QueueItem next : list) {
                if (next != null) {
                    if (hashSet.contains(Long.valueOf(next.getQueueId()))) {
                        Log.e(TAG, "Found duplicate queue id: " + next.getQueueId(), new IllegalArgumentException("id of each queue item should be unique"));
                    }
                    hashSet.add(Long.valueOf(next.getQueueId()));
                } else {
                    throw new IllegalArgumentException("queue shouldn't have null items");
                }
            }
        }
        this.mImpl.setQueue(list);
    }

    public void setQueueTitle(CharSequence charSequence) {
        this.mImpl.setQueueTitle(charSequence);
    }

    public void setRatingType(int i2) {
        this.mImpl.setRatingType(i2);
    }

    public void setRegistrationCallback(RegistrationCallback registrationCallback, Handler handler) {
        this.mImpl.setRegistrationCallback(registrationCallback, handler);
    }

    public void setRepeatMode(int i2) {
        this.mImpl.setRepeatMode(i2);
    }

    public void setSessionActivity(PendingIntent pendingIntent) {
        this.mImpl.setSessionActivity(pendingIntent);
    }

    public void setShuffleMode(int i2) {
        this.mImpl.setShuffleMode(i2);
    }

    @SuppressLint({"BanParcelableUsage"})
    static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new Parcelable.Creator<ResultReceiverWrapper>() {
            public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            public ResultReceiverWrapper[] newArray(int i2) {
                return new ResultReceiverWrapper[i2];
            }
        };
        ResultReceiver mResultReceiver;

        public ResultReceiverWrapper(ResultReceiver resultReceiver) {
            this.mResultReceiver = resultReceiver;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            this.mResultReceiver.writeToParcel(parcel, i2);
        }

        ResultReceiverWrapper(Parcel parcel) {
            this.mResultReceiver = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }
    }

    public MediaSessionCompat(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
        this(context, str, componentName, pendingIntent, (Bundle) null);
    }

    public void setCallback(Callback callback, Handler handler) {
        if (callback == null) {
            this.mImpl.setCallback((Callback) null, (Handler) null);
            return;
        }
        MediaSessionImpl mediaSessionImpl = this.mImpl;
        if (handler == null) {
            handler = new Handler();
        }
        mediaSessionImpl.setCallback(callback, handler);
    }

    public MediaSessionCompat(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, Bundle bundle) {
        this(context, str, componentName, pendingIntent, bundle, (VersionedParcelable) null);
    }

    public MediaSessionCompat(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, Bundle bundle, VersionedParcelable versionedParcelable) {
        this.mActiveListeners = new ArrayList<>();
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        } else if (!TextUtils.isEmpty(str)) {
            if (componentName == null && (componentName = MediaButtonReceiver.a(context)) == null) {
                Log.w(TAG, "Couldn't find a unique registered media button receiver in the given context.");
            }
            if (componentName != null && pendingIntent == null) {
                Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                intent.setComponent(componentName);
                pendingIntent = PendingIntent.getBroadcast(context, 0, intent, Build.VERSION.SDK_INT >= 31 ? 33554432 : 0);
            }
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                this.mImpl = new MediaSessionImplApi29(context, str, versionedParcelable, bundle);
            } else if (i2 >= 28) {
                this.mImpl = new MediaSessionImplApi28(context, str, versionedParcelable, bundle);
            } else if (i2 >= 22) {
                this.mImpl = new MediaSessionImplApi22(context, str, versionedParcelable, bundle);
            } else {
                this.mImpl = new MediaSessionImplApi21(context, str, versionedParcelable, bundle);
            }
            setCallback(new Callback() {
            }, new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()));
            this.mImpl.setMediaButtonReceiver(pendingIntent);
            this.mController = new MediaControllerCompat(context, this);
            if (sMaxBitmapSize == 0) {
                sMaxBitmapSize = (int) (TypedValue.applyDimension(1, 320.0f, context.getResources().getDisplayMetrics()) + 0.5f);
            }
        } else {
            throw new IllegalArgumentException("tag must not be null or empty");
        }
    }

    static class MediaSessionImplApi21 implements MediaSessionImpl {
        Callback mCallback;
        boolean mCaptioningEnabled;
        boolean mDestroyed = false;
        final RemoteCallbackList<IMediaControllerCallback> mExtraControllerCallbacks = new RemoteCallbackList<>();
        final ExtraSession mExtraSession;
        final Object mLock = new Object();
        MediaMetadataCompat mMetadata;
        PlaybackStateCompat mPlaybackState;
        List<QueueItem> mQueue;
        int mRatingType;
        RegistrationCallbackHandler mRegistrationCallbackHandler;
        MediaSessionManager$RemoteUserInfo mRemoteUserInfo;
        int mRepeatMode;
        final MediaSession mSessionFwk;
        Bundle mSessionInfo;
        int mShuffleMode;
        final Token mToken;

        private static class ExtraSession extends IMediaSession.Stub {
            private final AtomicReference<MediaSessionImplApi21> mMediaSessionImplRef;

            ExtraSession(MediaSessionImplApi21 mediaSessionImplApi21) {
                this.mMediaSessionImplRef = new AtomicReference<>(mediaSessionImplApi21);
            }

            public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            public void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat, int i2) {
                throw new AssertionError();
            }

            public void adjustVolume(int i2, int i3, String str) {
                throw new AssertionError();
            }

            public void fastForward() {
                throw new AssertionError();
            }

            public Bundle getExtras() {
                throw new AssertionError();
            }

            public long getFlags() {
                throw new AssertionError();
            }

            public PendingIntent getLaunchPendingIntent() {
                throw new AssertionError();
            }

            public MediaMetadataCompat getMetadata() {
                throw new AssertionError();
            }

            public String getPackageName() {
                throw new AssertionError();
            }

            public PlaybackStateCompat getPlaybackState() {
                MediaSessionImplApi21 mediaSessionImplApi21 = this.mMediaSessionImplRef.get();
                if (mediaSessionImplApi21 != null) {
                    return MediaSessionCompat.getStateWithUpdatedPosition(mediaSessionImplApi21.mPlaybackState, mediaSessionImplApi21.mMetadata);
                }
                return null;
            }

            public List<QueueItem> getQueue() {
                return null;
            }

            public CharSequence getQueueTitle() {
                throw new AssertionError();
            }

            public int getRatingType() {
                MediaSessionImplApi21 mediaSessionImplApi21 = this.mMediaSessionImplRef.get();
                if (mediaSessionImplApi21 != null) {
                    return mediaSessionImplApi21.mRatingType;
                }
                return 0;
            }

            public int getRepeatMode() {
                MediaSessionImplApi21 mediaSessionImplApi21 = this.mMediaSessionImplRef.get();
                if (mediaSessionImplApi21 != null) {
                    return mediaSessionImplApi21.mRepeatMode;
                }
                return -1;
            }

            public Bundle getSessionInfo() {
                MediaSessionImplApi21 mediaSessionImplApi21 = this.mMediaSessionImplRef.get();
                if (mediaSessionImplApi21.mSessionInfo == null) {
                    return null;
                }
                return new Bundle(mediaSessionImplApi21.mSessionInfo);
            }

            public int getShuffleMode() {
                MediaSessionImplApi21 mediaSessionImplApi21 = this.mMediaSessionImplRef.get();
                if (mediaSessionImplApi21 != null) {
                    return mediaSessionImplApi21.mShuffleMode;
                }
                return -1;
            }

            public String getTag() {
                throw new AssertionError();
            }

            public ParcelableVolumeInfo getVolumeAttributes() {
                throw new AssertionError();
            }

            public boolean isCaptioningEnabled() {
                MediaSessionImplApi21 mediaSessionImplApi21 = this.mMediaSessionImplRef.get();
                if (mediaSessionImplApi21 == null || !mediaSessionImplApi21.mCaptioningEnabled) {
                    return false;
                }
                return true;
            }

            public boolean isShuffleModeEnabledRemoved() {
                return false;
            }

            public boolean isTransportControlEnabled() {
                throw new AssertionError();
            }

            public void next() {
                throw new AssertionError();
            }

            public void pause() {
                throw new AssertionError();
            }

            public void play() throws RemoteException {
                throw new AssertionError();
            }

            public void playFromMediaId(String str, Bundle bundle) {
                throw new AssertionError();
            }

            public void playFromSearch(String str, Bundle bundle) {
                throw new AssertionError();
            }

            public void playFromUri(Uri uri, Bundle bundle) {
                throw new AssertionError();
            }

            public void prepare() throws RemoteException {
                throw new AssertionError();
            }

            public void prepareFromMediaId(String str, Bundle bundle) {
                throw new AssertionError();
            }

            public void prepareFromSearch(String str, Bundle bundle) {
                throw new AssertionError();
            }

            public void prepareFromUri(Uri uri, Bundle bundle) {
                throw new AssertionError();
            }

            public void previous() {
                throw new AssertionError();
            }

            public void rate(RatingCompat ratingCompat) {
                throw new AssertionError();
            }

            public void rateWithExtras(RatingCompat ratingCompat, Bundle bundle) {
                throw new AssertionError();
            }

            public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                MediaSessionImplApi21 mediaSessionImplApi21 = this.mMediaSessionImplRef.get();
                if (mediaSessionImplApi21 != null) {
                    int callingPid = Binder.getCallingPid();
                    int callingUid = Binder.getCallingUid();
                    mediaSessionImplApi21.mExtraControllerCallbacks.register(iMediaControllerCallback, new MediaSessionManager$RemoteUserInfo("android.media.session.MediaController", callingPid, callingUid));
                    synchronized (mediaSessionImplApi21.mLock) {
                        RegistrationCallbackHandler registrationCallbackHandler = mediaSessionImplApi21.mRegistrationCallbackHandler;
                        if (registrationCallbackHandler != null) {
                            registrationCallbackHandler.postCallbackRegistered(callingPid, callingUid);
                        }
                    }
                }
            }

            public void release() {
                this.mMediaSessionImplRef.set((Object) null);
            }

            public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            public void removeQueueItemAt(int i2) {
                throw new AssertionError();
            }

            public void rewind() {
                throw new AssertionError();
            }

            public void seekTo(long j2) {
                throw new AssertionError();
            }

            public void sendCommand(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                throw new AssertionError();
            }

            public void sendCustomAction(String str, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            public boolean sendMediaButton(KeyEvent keyEvent) {
                throw new AssertionError();
            }

            public void setCaptioningEnabled(boolean z2) {
                throw new AssertionError();
            }

            public void setPlaybackSpeed(float f2) {
                throw new AssertionError();
            }

            public void setRepeatMode(int i2) {
                throw new AssertionError();
            }

            public void setShuffleMode(int i2) throws RemoteException {
                throw new AssertionError();
            }

            public void setShuffleModeEnabledRemoved(boolean z2) {
            }

            public void setVolumeTo(int i2, int i3, String str) {
                throw new AssertionError();
            }

            public void skipToQueueItem(long j2) {
                throw new AssertionError();
            }

            public void stop() {
                throw new AssertionError();
            }

            public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                MediaSessionImplApi21 mediaSessionImplApi21 = this.mMediaSessionImplRef.get();
                if (mediaSessionImplApi21 != null) {
                    mediaSessionImplApi21.mExtraControllerCallbacks.unregister(iMediaControllerCallback);
                    int callingPid = Binder.getCallingPid();
                    int callingUid = Binder.getCallingUid();
                    synchronized (mediaSessionImplApi21.mLock) {
                        RegistrationCallbackHandler registrationCallbackHandler = mediaSessionImplApi21.mRegistrationCallbackHandler;
                        if (registrationCallbackHandler != null) {
                            registrationCallbackHandler.postCallbackUnregistered(callingPid, callingUid);
                        }
                    }
                }
            }
        }

        MediaSessionImplApi21(Context context, String str, VersionedParcelable versionedParcelable, Bundle bundle) {
            MediaSession createFwkMediaSession = createFwkMediaSession(context, str, bundle);
            this.mSessionFwk = createFwkMediaSession;
            ExtraSession extraSession = new ExtraSession(this);
            this.mExtraSession = extraSession;
            this.mToken = new Token(createFwkMediaSession.getSessionToken(), extraSession, versionedParcelable);
            this.mSessionInfo = bundle;
            setFlags(3);
        }

        public MediaSession createFwkMediaSession(Context context, String str, Bundle bundle) {
            return new MediaSession(context, str);
        }

        public Callback getCallback() {
            Callback callback;
            synchronized (this.mLock) {
                callback = this.mCallback;
            }
            return callback;
        }

        public String getCallingPackage() {
            if (Build.VERSION.SDK_INT < 24) {
                return null;
            }
            try {
                return (String) this.mSessionFwk.getClass().getMethod("getCallingPackage", new Class[0]).invoke(this.mSessionFwk, new Object[0]);
            } catch (Exception e2) {
                Log.e(MediaSessionCompat.TAG, "Cannot execute MediaSession.getCallingPackage()", e2);
                return null;
            }
        }

        public MediaSessionManager$RemoteUserInfo getCurrentControllerInfo() {
            MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo;
            synchronized (this.mLock) {
                mediaSessionManager$RemoteUserInfo = this.mRemoteUserInfo;
            }
            return mediaSessionManager$RemoteUserInfo;
        }

        public Object getMediaSession() {
            return this.mSessionFwk;
        }

        public PlaybackStateCompat getPlaybackState() {
            return this.mPlaybackState;
        }

        public Object getRemoteControlClient() {
            return null;
        }

        public Token getSessionToken() {
            return this.mToken;
        }

        public boolean isActive() {
            return this.mSessionFwk.isActive();
        }

        public void release() {
            this.mDestroyed = true;
            this.mExtraControllerCallbacks.kill();
            if (Build.VERSION.SDK_INT == 27) {
                try {
                    Field declaredField = this.mSessionFwk.getClass().getDeclaredField("mCallback");
                    declaredField.setAccessible(true);
                    Handler handler = (Handler) declaredField.get(this.mSessionFwk);
                    if (handler != null) {
                        handler.removeCallbacksAndMessages((Object) null);
                    }
                } catch (Exception e2) {
                    Log.w(MediaSessionCompat.TAG, "Exception happened while accessing MediaSession.mCallback.", e2);
                }
            }
            this.mSessionFwk.setCallback((MediaSession.Callback) null);
            this.mExtraSession.release();
            this.mSessionFwk.release();
        }

        public void sendSessionEvent(String str, Bundle bundle) {
            if (Build.VERSION.SDK_INT < 23) {
                synchronized (this.mLock) {
                    for (int beginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                        try {
                            this.mExtraControllerCallbacks.getBroadcastItem(beginBroadcast).onEvent(str, bundle);
                        } catch (RemoteException unused) {
                        }
                    }
                    this.mExtraControllerCallbacks.finishBroadcast();
                }
            }
            this.mSessionFwk.sendSessionEvent(str, bundle);
        }

        public void setActive(boolean z2) {
            this.mSessionFwk.setActive(z2);
        }

        public void setCallback(Callback callback, Handler handler) {
            MediaSession.Callback callback2;
            synchronized (this.mLock) {
                this.mCallback = callback;
                MediaSession mediaSession = this.mSessionFwk;
                if (callback == null) {
                    callback2 = null;
                } else {
                    callback2 = callback.mCallbackFwk;
                }
                mediaSession.setCallback(callback2, handler);
                if (callback != null) {
                    callback.setSessionImpl(this, handler);
                }
            }
        }

        public void setCaptioningEnabled(boolean z2) {
            if (this.mCaptioningEnabled != z2) {
                this.mCaptioningEnabled = z2;
                synchronized (this.mLock) {
                    for (int beginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                        try {
                            this.mExtraControllerCallbacks.getBroadcastItem(beginBroadcast).onCaptioningEnabledChanged(z2);
                        } catch (RemoteException unused) {
                        }
                    }
                    this.mExtraControllerCallbacks.finishBroadcast();
                }
            }
        }

        public void setCurrentControllerInfo(MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo) {
            synchronized (this.mLock) {
                this.mRemoteUserInfo = mediaSessionManager$RemoteUserInfo;
            }
        }

        public void setExtras(Bundle bundle) {
            this.mSessionFwk.setExtras(bundle);
        }

        @SuppressLint({"WrongConstant"})
        public void setFlags(int i2) {
            this.mSessionFwk.setFlags(i2 | 1 | 2);
        }

        public void setMediaButtonReceiver(PendingIntent pendingIntent) {
            this.mSessionFwk.setMediaButtonReceiver(pendingIntent);
        }

        public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
            MediaMetadata mediaMetadata;
            this.mMetadata = mediaMetadataCompat;
            MediaSession mediaSession = this.mSessionFwk;
            if (mediaMetadataCompat == null) {
                mediaMetadata = null;
            } else {
                mediaMetadata = (MediaMetadata) mediaMetadataCompat.getMediaMetadata();
            }
            mediaSession.setMetadata(mediaMetadata);
        }

        public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
            PlaybackState playbackState;
            this.mPlaybackState = playbackStateCompat;
            synchronized (this.mLock) {
                for (int beginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mExtraControllerCallbacks.getBroadcastItem(beginBroadcast).onPlaybackStateChanged(playbackStateCompat);
                    } catch (RemoteException unused) {
                    }
                }
                this.mExtraControllerCallbacks.finishBroadcast();
            }
            MediaSession mediaSession = this.mSessionFwk;
            if (playbackStateCompat == null) {
                playbackState = null;
            } else {
                playbackState = (PlaybackState) playbackStateCompat.getPlaybackState();
            }
            mediaSession.setPlaybackState(playbackState);
        }

        public void setPlaybackToLocal(int i2) {
            AudioAttributes.Builder builder = new AudioAttributes.Builder();
            builder.setLegacyStreamType(i2);
            this.mSessionFwk.setPlaybackToLocal(builder.build());
        }

        public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat) {
            this.mSessionFwk.setPlaybackToRemote((VolumeProvider) volumeProviderCompat.d());
        }

        public void setQueue(List<QueueItem> list) {
            this.mQueue = list;
            if (list == null) {
                this.mSessionFwk.setQueue((List) null);
                return;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (QueueItem queueItem : list) {
                arrayList.add((MediaSession.QueueItem) queueItem.getQueueItem());
            }
            this.mSessionFwk.setQueue(arrayList);
        }

        public void setQueueTitle(CharSequence charSequence) {
            this.mSessionFwk.setQueueTitle(charSequence);
        }

        public void setRatingType(int i2) {
            this.mRatingType = i2;
        }

        public void setRegistrationCallback(RegistrationCallback registrationCallback, Handler handler) {
            synchronized (this.mLock) {
                RegistrationCallbackHandler registrationCallbackHandler = this.mRegistrationCallbackHandler;
                if (registrationCallbackHandler != null) {
                    registrationCallbackHandler.removeCallbacksAndMessages((Object) null);
                }
                if (registrationCallback != null) {
                    this.mRegistrationCallbackHandler = new RegistrationCallbackHandler(handler.getLooper(), registrationCallback);
                } else {
                    this.mRegistrationCallbackHandler = null;
                }
            }
        }

        public void setRepeatMode(int i2) {
            if (this.mRepeatMode != i2) {
                this.mRepeatMode = i2;
                synchronized (this.mLock) {
                    for (int beginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                        try {
                            this.mExtraControllerCallbacks.getBroadcastItem(beginBroadcast).onRepeatModeChanged(i2);
                        } catch (RemoteException unused) {
                        }
                    }
                    this.mExtraControllerCallbacks.finishBroadcast();
                }
            }
        }

        public void setSessionActivity(PendingIntent pendingIntent) {
            this.mSessionFwk.setSessionActivity(pendingIntent);
        }

        public void setShuffleMode(int i2) {
            if (this.mShuffleMode != i2) {
                this.mShuffleMode = i2;
                synchronized (this.mLock) {
                    for (int beginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                        try {
                            this.mExtraControllerCallbacks.getBroadcastItem(beginBroadcast).onShuffleModeChanged(i2);
                        } catch (RemoteException unused) {
                        }
                    }
                    this.mExtraControllerCallbacks.finishBroadcast();
                }
            }
        }

        MediaSessionImplApi21(Object obj) {
            if (obj instanceof MediaSession) {
                MediaSession mediaSession = (MediaSession) obj;
                this.mSessionFwk = mediaSession;
                ExtraSession extraSession = new ExtraSession(this);
                this.mExtraSession = extraSession;
                this.mToken = new Token(mediaSession.getSessionToken(), extraSession);
                this.mSessionInfo = null;
                setFlags(3);
                return;
            }
            throw new IllegalArgumentException("mediaSession is not a valid MediaSession object");
        }
    }

    private MediaSessionCompat(Context context, MediaSessionImpl mediaSessionImpl) {
        this.mActiveListeners = new ArrayList<>();
        this.mImpl = mediaSessionImpl;
        this.mController = new MediaControllerCompat(context, this);
    }
}
