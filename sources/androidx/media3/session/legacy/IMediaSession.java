package androidx.media3.session.legacy;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.KeyEvent;
import androidx.media3.common.util.Assertions;
import androidx.media3.session.legacy.MediaSessionCompat;
import java.util.List;

public interface IMediaSession extends IInterface {

    public static abstract class Stub extends Binder implements IMediaSession {

        private static class Proxy implements IMediaSession {

            /* renamed from: c  reason: collision with root package name */
            public static IMediaSession f9669c;

            /* renamed from: b  reason: collision with root package name */
            private IBinder f9670b;

            Proxy(IBinder iBinder) {
                this.f9670b = iBinder;
            }

            public void F(IMediaControllerCallback iMediaControllerCallback) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    if (iMediaControllerCallback != null) {
                        iBinder = iMediaControllerCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (this.f9670b.transact(3, obtain, obtain2, 0) || Stub.H() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    ((IMediaSession) Assertions.f(Stub.H())).F(iMediaControllerCallback);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f9670b;
            }
        }

        public Stub() {
            attachInterface(this, android.support.v4.media.session.IMediaSession.DESCRIPTOR);
        }

        public static IMediaSession G(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IMediaSession)) {
                return new Proxy(iBinder);
            }
            return (IMediaSession) queryLocalInterface;
        }

        public static IMediaSession H() {
            return Proxy.f9669c;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: androidx.media3.session.legacy.MediaSessionCompat$ResultReceiverWrapper} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: android.view.KeyEvent} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: androidx.media3.session.legacy.RatingCompat} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v22, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v25, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v28, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v31, resolved type: androidx.media3.session.legacy.MediaDescriptionCompat} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v34, resolved type: androidx.media3.session.legacy.MediaDescriptionCompat} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v37, resolved type: androidx.media3.session.legacy.MediaDescriptionCompat} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v40, resolved type: android.os.Bundle} */
        /* JADX WARNING: type inference failed for: r3v0 */
        /* JADX WARNING: type inference failed for: r3v43 */
        /* JADX WARNING: type inference failed for: r3v44 */
        /* JADX WARNING: type inference failed for: r3v45 */
        /* JADX WARNING: type inference failed for: r3v46 */
        /* JADX WARNING: type inference failed for: r3v47 */
        /* JADX WARNING: type inference failed for: r3v48 */
        /* JADX WARNING: type inference failed for: r3v49 */
        /* JADX WARNING: type inference failed for: r3v50 */
        /* JADX WARNING: type inference failed for: r3v51 */
        /* JADX WARNING: type inference failed for: r3v52 */
        /* JADX WARNING: type inference failed for: r3v53 */
        /* JADX WARNING: type inference failed for: r3v54 */
        /* JADX WARNING: type inference failed for: r3v55 */
        /* JADX WARNING: type inference failed for: r3v56 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r5, android.os.Parcel r6, android.os.Parcel r7, int r8) throws android.os.RemoteException {
            /*
                r4 = this;
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                r1 = 1
                java.lang.String r2 = "android.support.v4.media.session.IMediaSession"
                if (r5 == r0) goto L_0x05db
                r0 = 0
                r3 = 0
                switch(r5) {
                    case 1: goto L_0x05a8;
                    case 2: goto L_0x057f;
                    case 3: goto L_0x0567;
                    case 4: goto L_0x054f;
                    case 5: goto L_0x0535;
                    case 6: goto L_0x051b;
                    case 7: goto L_0x0501;
                    case 8: goto L_0x04d8;
                    case 9: goto L_0x04be;
                    case 10: goto L_0x0495;
                    case 11: goto L_0x0479;
                    case 12: goto L_0x045d;
                    case 13: goto L_0x044d;
                    case 14: goto L_0x042a;
                    case 15: goto L_0x0407;
                    case 16: goto L_0x03d8;
                    case 17: goto L_0x03c4;
                    case 18: goto L_0x03b4;
                    case 19: goto L_0x03a4;
                    case 20: goto L_0x0394;
                    case 21: goto L_0x0384;
                    case 22: goto L_0x0374;
                    case 23: goto L_0x0364;
                    case 24: goto L_0x0350;
                    case 25: goto L_0x0331;
                    case 26: goto L_0x030e;
                    case 27: goto L_0x02e5;
                    case 28: goto L_0x02bc;
                    case 29: goto L_0x02a2;
                    case 30: goto L_0x0279;
                    case 31: goto L_0x0250;
                    case 32: goto L_0x0236;
                    case 33: goto L_0x0226;
                    case 34: goto L_0x0203;
                    case 35: goto L_0x01e0;
                    case 36: goto L_0x01b1;
                    case 37: goto L_0x0197;
                    case 38: goto L_0x017d;
                    case 39: goto L_0x0169;
                    case 40: goto L_0x0152;
                    case 41: goto L_0x0133;
                    case 42: goto L_0x0110;
                    case 43: goto L_0x00f1;
                    case 44: goto L_0x00dd;
                    case 45: goto L_0x00c3;
                    case 46: goto L_0x00ac;
                    case 47: goto L_0x0092;
                    case 48: goto L_0x007e;
                    case 49: goto L_0x006a;
                    case 50: goto L_0x0041;
                    case 51: goto L_0x0012;
                    default: goto L_0x000d;
                }
            L_0x000d:
                boolean r5 = super.onTransact(r5, r6, r7, r8)
                return r5
            L_0x0012:
                r6.enforceInterface(r2)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x0024
                android.os.Parcelable$Creator<androidx.media3.session.legacy.RatingCompat> r5 = androidx.media3.session.legacy.RatingCompat.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                androidx.media3.session.legacy.RatingCompat r5 = (androidx.media3.session.legacy.RatingCompat) r5
                goto L_0x0025
            L_0x0024:
                r5 = r3
            L_0x0025:
                int r8 = r6.readInt()
                if (r8 == 0) goto L_0x0034
                android.os.Parcelable$Creator r8 = android.os.Bundle.CREATOR
                java.lang.Object r6 = r8.createFromParcel(r6)
                r3 = r6
                android.os.Bundle r3 = (android.os.Bundle) r3
            L_0x0034:
                r4.r(r5, r3)
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeNoException()
                return r1
            L_0x0041:
                r6.enforceInterface(r2)
                android.os.Bundle r5 = r4.getSessionInfo()
                java.lang.Object r6 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r6 = (android.os.Parcel) r6
                r6.writeNoException()
                if (r5 == 0) goto L_0x0060
                java.lang.Object r6 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r6 = (android.os.Parcel) r6
                r6.writeInt(r1)
                r5.writeToParcel(r7, r1)
                goto L_0x0069
            L_0x0060:
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeInt(r0)
            L_0x0069:
                return r1
            L_0x006a:
                r6.enforceInterface(r2)
                float r5 = r6.readFloat()
                r4.setPlaybackSpeed(r5)
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeNoException()
                return r1
            L_0x007e:
                r6.enforceInterface(r2)
                int r5 = r6.readInt()
                r4.setShuffleMode(r5)
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeNoException()
                return r1
            L_0x0092:
                r6.enforceInterface(r2)
                int r5 = r4.getShuffleMode()
                java.lang.Object r6 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r6 = (android.os.Parcel) r6
                r6.writeNoException()
                java.lang.Object r6 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r6 = (android.os.Parcel) r6
                r6.writeInt(r5)
                return r1
            L_0x00ac:
                r6.enforceInterface(r2)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x00b6
                r0 = 1
            L_0x00b6:
                r4.setCaptioningEnabled(r0)
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeNoException()
                return r1
            L_0x00c3:
                r6.enforceInterface(r2)
                boolean r5 = r4.isCaptioningEnabled()
                java.lang.Object r6 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r6 = (android.os.Parcel) r6
                r6.writeNoException()
                java.lang.Object r6 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r6 = (android.os.Parcel) r6
                r6.writeInt(r5)
                return r1
            L_0x00dd:
                r6.enforceInterface(r2)
                int r5 = r6.readInt()
                r4.removeQueueItemAt(r5)
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeNoException()
                return r1
            L_0x00f1:
                r6.enforceInterface(r2)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x0103
                android.os.Parcelable$Creator<androidx.media3.session.legacy.MediaDescriptionCompat> r5 = androidx.media3.session.legacy.MediaDescriptionCompat.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                r3 = r5
                androidx.media3.session.legacy.MediaDescriptionCompat r3 = (androidx.media3.session.legacy.MediaDescriptionCompat) r3
            L_0x0103:
                r4.y(r3)
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeNoException()
                return r1
            L_0x0110:
                r6.enforceInterface(r2)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x0122
                android.os.Parcelable$Creator<androidx.media3.session.legacy.MediaDescriptionCompat> r5 = androidx.media3.session.legacy.MediaDescriptionCompat.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                r3 = r5
                androidx.media3.session.legacy.MediaDescriptionCompat r3 = (androidx.media3.session.legacy.MediaDescriptionCompat) r3
            L_0x0122:
                int r5 = r6.readInt()
                r4.b(r3, r5)
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeNoException()
                return r1
            L_0x0133:
                r6.enforceInterface(r2)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x0145
                android.os.Parcelable$Creator<androidx.media3.session.legacy.MediaDescriptionCompat> r5 = androidx.media3.session.legacy.MediaDescriptionCompat.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                r3 = r5
                androidx.media3.session.legacy.MediaDescriptionCompat r3 = (androidx.media3.session.legacy.MediaDescriptionCompat) r3
            L_0x0145:
                r4.u(r3)
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeNoException()
                return r1
            L_0x0152:
                r6.enforceInterface(r2)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x015c
                r0 = 1
            L_0x015c:
                r4.setShuffleModeEnabledRemoved(r0)
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeNoException()
                return r1
            L_0x0169:
                r6.enforceInterface(r2)
                int r5 = r6.readInt()
                r4.setRepeatMode(r5)
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeNoException()
                return r1
            L_0x017d:
                r6.enforceInterface(r2)
                boolean r5 = r4.isShuffleModeEnabledRemoved()
                java.lang.Object r6 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r6 = (android.os.Parcel) r6
                r6.writeNoException()
                java.lang.Object r6 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r6 = (android.os.Parcel) r6
                r6.writeInt(r5)
                return r1
            L_0x0197:
                r6.enforceInterface(r2)
                int r5 = r4.getRepeatMode()
                java.lang.Object r6 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r6 = (android.os.Parcel) r6
                r6.writeNoException()
                java.lang.Object r6 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r6 = (android.os.Parcel) r6
                r6.writeInt(r5)
                return r1
            L_0x01b1:
                r6.enforceInterface(r2)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x01c3
                android.os.Parcelable$Creator r5 = android.net.Uri.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                android.net.Uri r5 = (android.net.Uri) r5
                goto L_0x01c4
            L_0x01c3:
                r5 = r3
            L_0x01c4:
                int r8 = r6.readInt()
                if (r8 == 0) goto L_0x01d3
                android.os.Parcelable$Creator r8 = android.os.Bundle.CREATOR
                java.lang.Object r6 = r8.createFromParcel(r6)
                r3 = r6
                android.os.Bundle r3 = (android.os.Bundle) r3
            L_0x01d3:
                r4.prepareFromUri(r5, r3)
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeNoException()
                return r1
            L_0x01e0:
                r6.enforceInterface(r2)
                java.lang.String r5 = r6.readString()
                int r8 = r6.readInt()
                if (r8 == 0) goto L_0x01f6
                android.os.Parcelable$Creator r8 = android.os.Bundle.CREATOR
                java.lang.Object r6 = r8.createFromParcel(r6)
                r3 = r6
                android.os.Bundle r3 = (android.os.Bundle) r3
            L_0x01f6:
                r4.prepareFromSearch(r5, r3)
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeNoException()
                return r1
            L_0x0203:
                r6.enforceInterface(r2)
                java.lang.String r5 = r6.readString()
                int r8 = r6.readInt()
                if (r8 == 0) goto L_0x0219
                android.os.Parcelable$Creator r8 = android.os.Bundle.CREATOR
                java.lang.Object r6 = r8.createFromParcel(r6)
                r3 = r6
                android.os.Bundle r3 = (android.os.Bundle) r3
            L_0x0219:
                r4.prepareFromMediaId(r5, r3)
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeNoException()
                return r1
            L_0x0226:
                r6.enforceInterface(r2)
                r4.prepare()
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeNoException()
                return r1
            L_0x0236:
                r6.enforceInterface(r2)
                int r5 = r4.getRatingType()
                java.lang.Object r6 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r6 = (android.os.Parcel) r6
                r6.writeNoException()
                java.lang.Object r6 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r6 = (android.os.Parcel) r6
                r6.writeInt(r5)
                return r1
            L_0x0250:
                r6.enforceInterface(r2)
                android.os.Bundle r5 = r4.getExtras()
                java.lang.Object r6 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r6 = (android.os.Parcel) r6
                r6.writeNoException()
                if (r5 == 0) goto L_0x026f
                java.lang.Object r6 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r6 = (android.os.Parcel) r6
                r6.writeInt(r1)
                r5.writeToParcel(r7, r1)
                goto L_0x0278
            L_0x026f:
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeInt(r0)
            L_0x0278:
                return r1
            L_0x0279:
                r6.enforceInterface(r2)
                java.lang.CharSequence r5 = r4.getQueueTitle()
                java.lang.Object r6 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r6 = (android.os.Parcel) r6
                r6.writeNoException()
                if (r5 == 0) goto L_0x0298
                java.lang.Object r6 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r6 = (android.os.Parcel) r6
                r6.writeInt(r1)
                android.text.TextUtils.writeToParcel(r5, r7, r1)
                goto L_0x02a1
            L_0x0298:
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeInt(r0)
            L_0x02a1:
                return r1
            L_0x02a2:
                r6.enforceInterface(r2)
                java.util.List r5 = r4.getQueue()
                java.lang.Object r6 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r6 = (android.os.Parcel) r6
                r6.writeNoException()
                java.lang.Object r6 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r6 = (android.os.Parcel) r6
                r6.writeTypedList(r5)
                return r1
            L_0x02bc:
                r6.enforceInterface(r2)
                androidx.media3.session.legacy.PlaybackStateCompat r5 = r4.getPlaybackState()
                java.lang.Object r6 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r6 = (android.os.Parcel) r6
                r6.writeNoException()
                if (r5 == 0) goto L_0x02db
                java.lang.Object r6 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r6 = (android.os.Parcel) r6
                r6.writeInt(r1)
                r5.writeToParcel(r7, r1)
                goto L_0x02e4
            L_0x02db:
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeInt(r0)
            L_0x02e4:
                return r1
            L_0x02e5:
                r6.enforceInterface(r2)
                androidx.media3.session.legacy.MediaMetadataCompat r5 = r4.getMetadata()
                java.lang.Object r6 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r6 = (android.os.Parcel) r6
                r6.writeNoException()
                if (r5 == 0) goto L_0x0304
                java.lang.Object r6 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r6 = (android.os.Parcel) r6
                r6.writeInt(r1)
                r5.writeToParcel(r7, r1)
                goto L_0x030d
            L_0x0304:
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeInt(r0)
            L_0x030d:
                return r1
            L_0x030e:
                r6.enforceInterface(r2)
                java.lang.String r5 = r6.readString()
                int r8 = r6.readInt()
                if (r8 == 0) goto L_0x0324
                android.os.Parcelable$Creator r8 = android.os.Bundle.CREATOR
                java.lang.Object r6 = r8.createFromParcel(r6)
                r3 = r6
                android.os.Bundle r3 = (android.os.Bundle) r3
            L_0x0324:
                r4.sendCustomAction(r5, r3)
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeNoException()
                return r1
            L_0x0331:
                r6.enforceInterface(r2)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x0343
                android.os.Parcelable$Creator<androidx.media3.session.legacy.RatingCompat> r5 = androidx.media3.session.legacy.RatingCompat.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                r3 = r5
                androidx.media3.session.legacy.RatingCompat r3 = (androidx.media3.session.legacy.RatingCompat) r3
            L_0x0343:
                r4.p(r3)
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeNoException()
                return r1
            L_0x0350:
                r6.enforceInterface(r2)
                long r5 = r6.readLong()
                r4.seekTo(r5)
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeNoException()
                return r1
            L_0x0364:
                r6.enforceInterface(r2)
                r4.rewind()
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeNoException()
                return r1
            L_0x0374:
                r6.enforceInterface(r2)
                r4.fastForward()
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeNoException()
                return r1
            L_0x0384:
                r6.enforceInterface(r2)
                r4.previous()
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeNoException()
                return r1
            L_0x0394:
                r6.enforceInterface(r2)
                r4.next()
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeNoException()
                return r1
            L_0x03a4:
                r6.enforceInterface(r2)
                r4.stop()
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeNoException()
                return r1
            L_0x03b4:
                r6.enforceInterface(r2)
                r4.pause()
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeNoException()
                return r1
            L_0x03c4:
                r6.enforceInterface(r2)
                long r5 = r6.readLong()
                r4.skipToQueueItem(r5)
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeNoException()
                return r1
            L_0x03d8:
                r6.enforceInterface(r2)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x03ea
                android.os.Parcelable$Creator r5 = android.net.Uri.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                android.net.Uri r5 = (android.net.Uri) r5
                goto L_0x03eb
            L_0x03ea:
                r5 = r3
            L_0x03eb:
                int r8 = r6.readInt()
                if (r8 == 0) goto L_0x03fa
                android.os.Parcelable$Creator r8 = android.os.Bundle.CREATOR
                java.lang.Object r6 = r8.createFromParcel(r6)
                r3 = r6
                android.os.Bundle r3 = (android.os.Bundle) r3
            L_0x03fa:
                r4.playFromUri(r5, r3)
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeNoException()
                return r1
            L_0x0407:
                r6.enforceInterface(r2)
                java.lang.String r5 = r6.readString()
                int r8 = r6.readInt()
                if (r8 == 0) goto L_0x041d
                android.os.Parcelable$Creator r8 = android.os.Bundle.CREATOR
                java.lang.Object r6 = r8.createFromParcel(r6)
                r3 = r6
                android.os.Bundle r3 = (android.os.Bundle) r3
            L_0x041d:
                r4.playFromSearch(r5, r3)
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeNoException()
                return r1
            L_0x042a:
                r6.enforceInterface(r2)
                java.lang.String r5 = r6.readString()
                int r8 = r6.readInt()
                if (r8 == 0) goto L_0x0440
                android.os.Parcelable$Creator r8 = android.os.Bundle.CREATOR
                java.lang.Object r6 = r8.createFromParcel(r6)
                r3 = r6
                android.os.Bundle r3 = (android.os.Bundle) r3
            L_0x0440:
                r4.playFromMediaId(r5, r3)
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeNoException()
                return r1
            L_0x044d:
                r6.enforceInterface(r2)
                r4.play()
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeNoException()
                return r1
            L_0x045d:
                r6.enforceInterface(r2)
                int r5 = r6.readInt()
                int r8 = r6.readInt()
                java.lang.String r6 = r6.readString()
                r4.setVolumeTo(r5, r8, r6)
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeNoException()
                return r1
            L_0x0479:
                r6.enforceInterface(r2)
                int r5 = r6.readInt()
                int r8 = r6.readInt()
                java.lang.String r6 = r6.readString()
                r4.adjustVolume(r5, r8, r6)
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeNoException()
                return r1
            L_0x0495:
                r6.enforceInterface(r2)
                androidx.media3.session.legacy.ParcelableVolumeInfo r5 = r4.getVolumeAttributes()
                java.lang.Object r6 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r6 = (android.os.Parcel) r6
                r6.writeNoException()
                if (r5 == 0) goto L_0x04b4
                java.lang.Object r6 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r6 = (android.os.Parcel) r6
                r6.writeInt(r1)
                r5.writeToParcel(r7, r1)
                goto L_0x04bd
            L_0x04b4:
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeInt(r0)
            L_0x04bd:
                return r1
            L_0x04be:
                r6.enforceInterface(r2)
                long r5 = r4.getFlags()
                java.lang.Object r8 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r8 = (android.os.Parcel) r8
                r8.writeNoException()
                java.lang.Object r7 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r7 = (android.os.Parcel) r7
                r7.writeLong(r5)
                return r1
            L_0x04d8:
                r6.enforceInterface(r2)
                android.app.PendingIntent r5 = r4.getLaunchPendingIntent()
                java.lang.Object r6 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r6 = (android.os.Parcel) r6
                r6.writeNoException()
                if (r5 == 0) goto L_0x04f7
                java.lang.Object r6 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r6 = (android.os.Parcel) r6
                r6.writeInt(r1)
                r5.writeToParcel(r7, r1)
                goto L_0x0500
            L_0x04f7:
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeInt(r0)
            L_0x0500:
                return r1
            L_0x0501:
                r6.enforceInterface(r2)
                java.lang.String r5 = r4.getTag()
                java.lang.Object r6 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r6 = (android.os.Parcel) r6
                r6.writeNoException()
                java.lang.Object r6 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r6 = (android.os.Parcel) r6
                r6.writeString(r5)
                return r1
            L_0x051b:
                r6.enforceInterface(r2)
                java.lang.String r5 = r4.getPackageName()
                java.lang.Object r6 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r6 = (android.os.Parcel) r6
                r6.writeNoException()
                java.lang.Object r6 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r6 = (android.os.Parcel) r6
                r6.writeString(r5)
                return r1
            L_0x0535:
                r6.enforceInterface(r2)
                boolean r5 = r4.isTransportControlEnabled()
                java.lang.Object r6 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r6 = (android.os.Parcel) r6
                r6.writeNoException()
                java.lang.Object r6 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r6 = (android.os.Parcel) r6
                r6.writeInt(r5)
                return r1
            L_0x054f:
                r6.enforceInterface(r2)
                android.os.IBinder r5 = r6.readStrongBinder()
                androidx.media3.session.legacy.IMediaControllerCallback r5 = androidx.media3.session.legacy.IMediaControllerCallback.Stub.G(r5)
                r4.v(r5)
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeNoException()
                return r1
            L_0x0567:
                r6.enforceInterface(r2)
                android.os.IBinder r5 = r6.readStrongBinder()
                androidx.media3.session.legacy.IMediaControllerCallback r5 = androidx.media3.session.legacy.IMediaControllerCallback.Stub.G(r5)
                r4.F(r5)
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeNoException()
                return r1
            L_0x057f:
                r6.enforceInterface(r2)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x0591
                android.os.Parcelable$Creator r5 = android.view.KeyEvent.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                r3 = r5
                android.view.KeyEvent r3 = (android.view.KeyEvent) r3
            L_0x0591:
                boolean r5 = r4.sendMediaButton(r3)
                java.lang.Object r6 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r6 = (android.os.Parcel) r6
                r6.writeNoException()
                java.lang.Object r6 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r6 = (android.os.Parcel) r6
                r6.writeInt(r5)
                return r1
            L_0x05a8:
                r6.enforceInterface(r2)
                java.lang.String r5 = r6.readString()
                int r8 = r6.readInt()
                if (r8 == 0) goto L_0x05be
                android.os.Parcelable$Creator r8 = android.os.Bundle.CREATOR
                java.lang.Object r8 = r8.createFromParcel(r6)
                android.os.Bundle r8 = (android.os.Bundle) r8
                goto L_0x05bf
            L_0x05be:
                r8 = r3
            L_0x05bf:
                int r0 = r6.readInt()
                if (r0 == 0) goto L_0x05ce
                android.os.Parcelable$Creator<androidx.media3.session.legacy.MediaSessionCompat$ResultReceiverWrapper> r0 = androidx.media3.session.legacy.MediaSessionCompat.ResultReceiverWrapper.CREATOR
                java.lang.Object r6 = r0.createFromParcel(r6)
                r3 = r6
                androidx.media3.session.legacy.MediaSessionCompat$ResultReceiverWrapper r3 = (androidx.media3.session.legacy.MediaSessionCompat.ResultReceiverWrapper) r3
            L_0x05ce:
                r4.o(r5, r8, r3)
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeNoException()
                return r1
            L_0x05db:
                java.lang.Object r5 = androidx.media3.common.util.Assertions.f(r7)
                android.os.Parcel r5 = (android.os.Parcel) r5
                r5.writeString(r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.legacy.IMediaSession.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void F(IMediaControllerCallback iMediaControllerCallback) throws RemoteException;

    void adjustVolume(int i2, int i3, String str) throws RemoteException;

    void b(MediaDescriptionCompat mediaDescriptionCompat, int i2) throws RemoteException;

    void fastForward() throws RemoteException;

    Bundle getExtras() throws RemoteException;

    long getFlags() throws RemoteException;

    PendingIntent getLaunchPendingIntent() throws RemoteException;

    MediaMetadataCompat getMetadata() throws RemoteException;

    String getPackageName() throws RemoteException;

    PlaybackStateCompat getPlaybackState() throws RemoteException;

    List<MediaSessionCompat.QueueItem> getQueue() throws RemoteException;

    CharSequence getQueueTitle() throws RemoteException;

    int getRatingType() throws RemoteException;

    int getRepeatMode() throws RemoteException;

    Bundle getSessionInfo() throws RemoteException;

    int getShuffleMode() throws RemoteException;

    String getTag() throws RemoteException;

    ParcelableVolumeInfo getVolumeAttributes() throws RemoteException;

    boolean isCaptioningEnabled() throws RemoteException;

    boolean isShuffleModeEnabledRemoved() throws RemoteException;

    boolean isTransportControlEnabled() throws RemoteException;

    void next() throws RemoteException;

    void o(String str, Bundle bundle, MediaSessionCompat.ResultReceiverWrapper resultReceiverWrapper) throws RemoteException;

    void p(RatingCompat ratingCompat) throws RemoteException;

    void pause() throws RemoteException;

    void play() throws RemoteException;

    void playFromMediaId(String str, Bundle bundle) throws RemoteException;

    void playFromSearch(String str, Bundle bundle) throws RemoteException;

    void playFromUri(Uri uri, Bundle bundle) throws RemoteException;

    void prepare() throws RemoteException;

    void prepareFromMediaId(String str, Bundle bundle) throws RemoteException;

    void prepareFromSearch(String str, Bundle bundle) throws RemoteException;

    void prepareFromUri(Uri uri, Bundle bundle) throws RemoteException;

    void previous() throws RemoteException;

    void r(RatingCompat ratingCompat, Bundle bundle) throws RemoteException;

    void removeQueueItemAt(int i2) throws RemoteException;

    void rewind() throws RemoteException;

    void seekTo(long j2) throws RemoteException;

    void sendCustomAction(String str, Bundle bundle) throws RemoteException;

    boolean sendMediaButton(KeyEvent keyEvent) throws RemoteException;

    void setCaptioningEnabled(boolean z2) throws RemoteException;

    void setPlaybackSpeed(float f2) throws RemoteException;

    void setRepeatMode(int i2) throws RemoteException;

    void setShuffleMode(int i2) throws RemoteException;

    void setShuffleModeEnabledRemoved(boolean z2) throws RemoteException;

    void setVolumeTo(int i2, int i3, String str) throws RemoteException;

    void skipToQueueItem(long j2) throws RemoteException;

    void stop() throws RemoteException;

    void u(MediaDescriptionCompat mediaDescriptionCompat) throws RemoteException;

    void v(IMediaControllerCallback iMediaControllerCallback) throws RemoteException;

    void y(MediaDescriptionCompat mediaDescriptionCompat) throws RemoteException;
}
