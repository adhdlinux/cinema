package androidx.media3.session.legacy;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.media3.session.legacy.MediaSessionCompat;
import java.util.List;

public interface IMediaControllerCallback extends IInterface {

    public static abstract class Stub extends Binder implements IMediaControllerCallback {

        private static class Proxy implements IMediaControllerCallback {

            /* renamed from: b  reason: collision with root package name */
            private IBinder f9668b;

            Proxy(IBinder iBinder) {
                this.f9668b = iBinder;
            }

            public IBinder asBinder() {
                return this.f9668b;
            }
        }

        public Stub() {
            attachInterface(this, android.support.v4.media.session.IMediaControllerCallback.DESCRIPTOR);
        }

        public static IMediaControllerCallback G(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(android.support.v4.media.session.IMediaControllerCallback.DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IMediaControllerCallback)) {
                return new Proxy(iBinder);
            }
            return (IMediaControllerCallback) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: androidx.media3.session.legacy.PlaybackStateCompat} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: androidx.media3.session.legacy.MediaMetadataCompat} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: androidx.media3.session.legacy.ParcelableVolumeInfo} */
        /* JADX WARNING: type inference failed for: r3v0 */
        /* JADX WARNING: type inference failed for: r3v10, types: [java.lang.CharSequence] */
        /* JADX WARNING: type inference failed for: r3v19 */
        /* JADX WARNING: type inference failed for: r3v20 */
        /* JADX WARNING: type inference failed for: r3v21 */
        /* JADX WARNING: type inference failed for: r3v22 */
        /* JADX WARNING: type inference failed for: r3v23 */
        /* JADX WARNING: type inference failed for: r3v24 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r5, android.os.Parcel r6, android.os.Parcel r7, int r8) throws android.os.RemoteException {
            /*
                r4 = this;
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                r1 = 1
                java.lang.String r2 = "android.support.v4.media.session.IMediaControllerCallback"
                if (r5 == r0) goto L_0x00e7
                r0 = 0
                r3 = 0
                switch(r5) {
                    case 1: goto L_0x00cd;
                    case 2: goto L_0x00c6;
                    case 3: goto L_0x00b0;
                    case 4: goto L_0x009a;
                    case 5: goto L_0x008d;
                    case 6: goto L_0x0077;
                    case 7: goto L_0x0061;
                    case 8: goto L_0x004b;
                    case 9: goto L_0x0040;
                    case 10: goto L_0x0032;
                    case 11: goto L_0x0024;
                    case 12: goto L_0x0019;
                    case 13: goto L_0x0012;
                    default: goto L_0x000d;
                }
            L_0x000d:
                boolean r5 = super.onTransact(r5, r6, r7, r8)
                return r5
            L_0x0012:
                r6.enforceInterface(r2)
                r4.onSessionReady()
                return r1
            L_0x0019:
                r6.enforceInterface(r2)
                int r5 = r6.readInt()
                r4.onShuffleModeChanged(r5)
                return r1
            L_0x0024:
                r6.enforceInterface(r2)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x002e
                r0 = 1
            L_0x002e:
                r4.onCaptioningEnabledChanged(r0)
                return r1
            L_0x0032:
                r6.enforceInterface(r2)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x003c
                r0 = 1
            L_0x003c:
                r4.onShuffleModeChangedRemoved(r0)
                return r1
            L_0x0040:
                r6.enforceInterface(r2)
                int r5 = r6.readInt()
                r4.onRepeatModeChanged(r5)
                return r1
            L_0x004b:
                r6.enforceInterface(r2)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x005d
                android.os.Parcelable$Creator<androidx.media3.session.legacy.ParcelableVolumeInfo> r5 = androidx.media3.session.legacy.ParcelableVolumeInfo.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                r3 = r5
                androidx.media3.session.legacy.ParcelableVolumeInfo r3 = (androidx.media3.session.legacy.ParcelableVolumeInfo) r3
            L_0x005d:
                r4.m(r3)
                return r1
            L_0x0061:
                r6.enforceInterface(r2)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x0073
                android.os.Parcelable$Creator r5 = android.os.Bundle.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                r3 = r5
                android.os.Bundle r3 = (android.os.Bundle) r3
            L_0x0073:
                r4.onExtrasChanged(r3)
                return r1
            L_0x0077:
                r6.enforceInterface(r2)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x0089
                android.os.Parcelable$Creator r5 = android.text.TextUtils.CHAR_SEQUENCE_CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                r3 = r5
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            L_0x0089:
                r4.onQueueTitleChanged(r3)
                return r1
            L_0x008d:
                r6.enforceInterface(r2)
                android.os.Parcelable$Creator<androidx.media3.session.legacy.MediaSessionCompat$QueueItem> r5 = androidx.media3.session.legacy.MediaSessionCompat.QueueItem.CREATOR
                java.util.ArrayList r5 = r6.createTypedArrayList(r5)
                r4.onQueueChanged(r5)
                return r1
            L_0x009a:
                r6.enforceInterface(r2)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x00ac
                android.os.Parcelable$Creator<androidx.media3.session.legacy.MediaMetadataCompat> r5 = androidx.media3.session.legacy.MediaMetadataCompat.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                r3 = r5
                androidx.media3.session.legacy.MediaMetadataCompat r3 = (androidx.media3.session.legacy.MediaMetadataCompat) r3
            L_0x00ac:
                r4.g(r3)
                return r1
            L_0x00b0:
                r6.enforceInterface(r2)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x00c2
                android.os.Parcelable$Creator<androidx.media3.session.legacy.PlaybackStateCompat> r5 = androidx.media3.session.legacy.PlaybackStateCompat.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                r3 = r5
                androidx.media3.session.legacy.PlaybackStateCompat r3 = (androidx.media3.session.legacy.PlaybackStateCompat) r3
            L_0x00c2:
                r4.k(r3)
                return r1
            L_0x00c6:
                r6.enforceInterface(r2)
                r4.onSessionDestroyed()
                return r1
            L_0x00cd:
                r6.enforceInterface(r2)
                java.lang.String r5 = r6.readString()
                int r7 = r6.readInt()
                if (r7 == 0) goto L_0x00e3
                android.os.Parcelable$Creator r7 = android.os.Bundle.CREATOR
                java.lang.Object r6 = r7.createFromParcel(r6)
                r3 = r6
                android.os.Bundle r3 = (android.os.Bundle) r3
            L_0x00e3:
                r4.onEvent(r5, r3)
                return r1
            L_0x00e7:
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeString(r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.legacy.IMediaControllerCallback.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void g(MediaMetadataCompat mediaMetadataCompat) throws RemoteException;

    void k(PlaybackStateCompat playbackStateCompat) throws RemoteException;

    void m(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException;

    void onCaptioningEnabledChanged(boolean z2) throws RemoteException;

    void onEvent(String str, Bundle bundle) throws RemoteException;

    void onExtrasChanged(Bundle bundle) throws RemoteException;

    void onQueueChanged(List<MediaSessionCompat.QueueItem> list) throws RemoteException;

    void onQueueTitleChanged(CharSequence charSequence) throws RemoteException;

    void onRepeatModeChanged(int i2) throws RemoteException;

    void onSessionDestroyed() throws RemoteException;

    void onSessionReady() throws RemoteException;

    void onShuffleModeChanged(int i2) throws RemoteException;

    void onShuffleModeChangedRemoved(boolean z2) throws RemoteException;
}
