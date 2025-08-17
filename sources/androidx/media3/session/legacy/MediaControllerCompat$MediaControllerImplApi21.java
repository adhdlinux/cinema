package androidx.media3.session.legacy;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.util.Log;
import androidx.media3.session.legacy.IMediaSession;
import androidx.media3.session.legacy.MediaControllerCompat$Callback;
import androidx.media3.session.legacy.MediaSessionCompat;
import androidx.versionedparcelable.ParcelUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

class MediaControllerCompat$MediaControllerImplApi21 {

    /* renamed from: a  reason: collision with root package name */
    final Object f9687a;

    /* renamed from: b  reason: collision with root package name */
    private final List<MediaControllerCompat$Callback> f9688b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap<MediaControllerCompat$Callback, ExtraCallback> f9689c;

    /* renamed from: d  reason: collision with root package name */
    final MediaSessionCompat.Token f9690d;

    private static class ExtraBinderRequestResultReceiver extends ResultReceiver {

        /* renamed from: b  reason: collision with root package name */
        private WeakReference<MediaControllerCompat$MediaControllerImplApi21> f9691b;

        /* access modifiers changed from: protected */
        public void onReceiveResult(int i2, Bundle bundle) {
            MediaControllerCompat$MediaControllerImplApi21 mediaControllerCompat$MediaControllerImplApi21 = this.f9691b.get();
            if (mediaControllerCompat$MediaControllerImplApi21 != null && bundle != null) {
                synchronized (mediaControllerCompat$MediaControllerImplApi21.f9687a) {
                    mediaControllerCompat$MediaControllerImplApi21.f9690d.d(IMediaSession.Stub.G(bundle.getBinder(android.support.v4.media.session.MediaSessionCompat.KEY_EXTRA_BINDER)));
                    mediaControllerCompat$MediaControllerImplApi21.f9690d.e(ParcelUtils.b(bundle, android.support.v4.media.session.MediaSessionCompat.KEY_SESSION2_TOKEN));
                    mediaControllerCompat$MediaControllerImplApi21.a();
                }
            }
        }
    }

    private static class ExtraCallback extends MediaControllerCompat$Callback.StubCompat {
        ExtraCallback(MediaControllerCompat$Callback mediaControllerCompat$Callback) {
            super(mediaControllerCompat$Callback);
        }

        public void g(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
            throw new AssertionError();
        }

        public void m(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
            throw new AssertionError();
        }

        public void onExtrasChanged(Bundle bundle) throws RemoteException {
            throw new AssertionError();
        }

        public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
            throw new AssertionError();
        }

        public void onQueueTitleChanged(CharSequence charSequence) throws RemoteException {
            throw new AssertionError();
        }

        public void onSessionDestroyed() throws RemoteException {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        IMediaSession c2 = this.f9690d.c();
        if (c2 != null) {
            for (MediaControllerCompat$Callback next : this.f9688b) {
                ExtraCallback extraCallback = new ExtraCallback(next);
                this.f9689c.put(next, extraCallback);
                next.f9684b = extraCallback;
                try {
                    c2.F(extraCallback);
                    next.i(13, (Object) null, (Bundle) null);
                } catch (RemoteException e2) {
                    Log.e("MediaControllerCompat", "Dead object in registerCallback.", e2);
                }
            }
            this.f9688b.clear();
        }
    }
}
