package androidx.media3.session.legacy;

import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.media3.common.util.Assertions;
import androidx.media3.session.legacy.IMediaControllerCallback;
import androidx.media3.session.legacy.MediaSessionCompat;
import java.lang.ref.WeakReference;
import java.util.List;

public abstract class MediaControllerCompat$Callback implements IBinder.DeathRecipient {

    /* renamed from: a  reason: collision with root package name */
    final MediaController.Callback f9683a = new MediaControllerCallbackApi21(this);

    /* renamed from: b  reason: collision with root package name */
    IMediaControllerCallback f9684b;

    private static class MediaControllerCallbackApi21 extends MediaController.Callback {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<MediaControllerCompat$Callback> f9685a;

        MediaControllerCallbackApi21(MediaControllerCompat$Callback mediaControllerCompat$Callback) {
            this.f9685a = new WeakReference<>(mediaControllerCompat$Callback);
        }

        public void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.f9685a.get();
            if (mediaControllerCompat$Callback != null && playbackInfo != null) {
                mediaControllerCompat$Callback.a(new MediaControllerCompat$PlaybackInfo(playbackInfo.getPlaybackType(), (AudioAttributesCompat) Assertions.f(AudioAttributesCompat.c(playbackInfo.getAudioAttributes())), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume()));
            }
        }

        public void onExtrasChanged(Bundle bundle) {
            MediaSessionCompat.a(bundle);
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.f9685a.get();
            if (mediaControllerCompat$Callback != null) {
                mediaControllerCompat$Callback.b(bundle);
            }
        }

        public void onMetadataChanged(MediaMetadata mediaMetadata) {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.f9685a.get();
            if (mediaControllerCompat$Callback != null) {
                mediaControllerCompat$Callback.c(MediaMetadataCompat.b(mediaMetadata));
            }
        }

        public void onPlaybackStateChanged(PlaybackState playbackState) {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.f9685a.get();
            if (mediaControllerCompat$Callback != null && mediaControllerCompat$Callback.f9684b == null) {
                mediaControllerCompat$Callback.d(PlaybackStateCompat.b(playbackState));
            }
        }

        public void onQueueChanged(List<MediaSession.QueueItem> list) {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.f9685a.get();
            if (mediaControllerCompat$Callback != null) {
                mediaControllerCompat$Callback.e(MediaSessionCompat.QueueItem.c(list));
            }
        }

        public void onQueueTitleChanged(CharSequence charSequence) {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.f9685a.get();
            if (mediaControllerCompat$Callback != null) {
                mediaControllerCompat$Callback.f(charSequence);
            }
        }

        public void onSessionDestroyed() {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.f9685a.get();
            if (mediaControllerCompat$Callback != null) {
                mediaControllerCompat$Callback.g();
            }
        }

        public void onSessionEvent(String str, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.f9685a.get();
            if (mediaControllerCompat$Callback == null) {
                return;
            }
            if (mediaControllerCompat$Callback.f9684b == null || Build.VERSION.SDK_INT >= 23) {
                mediaControllerCompat$Callback.h(str, bundle);
            }
        }
    }

    private static class StubCompat extends IMediaControllerCallback.Stub {

        /* renamed from: b  reason: collision with root package name */
        private final WeakReference<MediaControllerCompat$Callback> f9686b;

        StubCompat(MediaControllerCompat$Callback mediaControllerCompat$Callback) {
            this.f9686b = new WeakReference<>(mediaControllerCompat$Callback);
        }

        public void g(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.f9686b.get();
            if (mediaControllerCompat$Callback != null) {
                mediaControllerCompat$Callback.i(3, mediaMetadataCompat, (Bundle) null);
            }
        }

        public void k(PlaybackStateCompat playbackStateCompat) throws RemoteException {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.f9686b.get();
            if (mediaControllerCompat$Callback != null) {
                mediaControllerCompat$Callback.i(2, playbackStateCompat, (Bundle) null);
            }
        }

        public void m(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
            MediaControllerCompat$PlaybackInfo mediaControllerCompat$PlaybackInfo;
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.f9686b.get();
            if (mediaControllerCompat$Callback != null) {
                if (parcelableVolumeInfo != null) {
                    mediaControllerCompat$PlaybackInfo = new MediaControllerCompat$PlaybackInfo(parcelableVolumeInfo.f9728b, parcelableVolumeInfo.f9729c, parcelableVolumeInfo.f9730d, parcelableVolumeInfo.f9731e, parcelableVolumeInfo.f9732f);
                } else {
                    mediaControllerCompat$PlaybackInfo = null;
                }
                mediaControllerCompat$Callback.i(4, mediaControllerCompat$PlaybackInfo, (Bundle) null);
            }
        }

        public void onCaptioningEnabledChanged(boolean z2) throws RemoteException {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.f9686b.get();
            if (mediaControllerCompat$Callback != null) {
                mediaControllerCompat$Callback.i(11, Boolean.valueOf(z2), (Bundle) null);
            }
        }

        public void onEvent(String str, Bundle bundle) throws RemoteException {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.f9686b.get();
            if (mediaControllerCompat$Callback != null) {
                mediaControllerCompat$Callback.i(1, str, bundle);
            }
        }

        public void onExtrasChanged(Bundle bundle) throws RemoteException {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.f9686b.get();
            if (mediaControllerCompat$Callback != null) {
                mediaControllerCompat$Callback.i(7, bundle, (Bundle) null);
            }
        }

        public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.f9686b.get();
            if (mediaControllerCompat$Callback != null) {
                mediaControllerCompat$Callback.i(5, list, (Bundle) null);
            }
        }

        public void onQueueTitleChanged(CharSequence charSequence) throws RemoteException {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.f9686b.get();
            if (mediaControllerCompat$Callback != null) {
                mediaControllerCompat$Callback.i(6, charSequence, (Bundle) null);
            }
        }

        public void onRepeatModeChanged(int i2) throws RemoteException {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.f9686b.get();
            if (mediaControllerCompat$Callback != null) {
                mediaControllerCompat$Callback.i(9, Integer.valueOf(i2), (Bundle) null);
            }
        }

        public void onSessionDestroyed() throws RemoteException {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.f9686b.get();
            if (mediaControllerCompat$Callback != null) {
                mediaControllerCompat$Callback.i(8, (Object) null, (Bundle) null);
            }
        }

        public void onSessionReady() throws RemoteException {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.f9686b.get();
            if (mediaControllerCompat$Callback != null) {
                mediaControllerCompat$Callback.i(13, (Object) null, (Bundle) null);
            }
        }

        public void onShuffleModeChanged(int i2) throws RemoteException {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = this.f9686b.get();
            if (mediaControllerCompat$Callback != null) {
                mediaControllerCompat$Callback.i(12, Integer.valueOf(i2), (Bundle) null);
            }
        }

        public void onShuffleModeChangedRemoved(boolean z2) throws RemoteException {
        }
    }

    public void a(MediaControllerCompat$PlaybackInfo mediaControllerCompat$PlaybackInfo) {
    }

    public void b(Bundle bundle) {
    }

    public void binderDied() {
        i(8, (Object) null, (Bundle) null);
    }

    public void c(MediaMetadataCompat mediaMetadataCompat) {
    }

    public void d(PlaybackStateCompat playbackStateCompat) {
    }

    public void e(List<MediaSessionCompat.QueueItem> list) {
    }

    public void f(CharSequence charSequence) {
    }

    public void g() {
    }

    public void h(String str, Bundle bundle) {
    }

    /* access modifiers changed from: package-private */
    public void i(int i2, Object obj, Bundle bundle) {
    }
}
