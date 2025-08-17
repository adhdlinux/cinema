package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcel;

public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(VersionedParcel versionedParcel) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f2458a = (IconCompat) versionedParcel.v(remoteActionCompat.f2458a, 1);
        remoteActionCompat.f2459b = versionedParcel.l(remoteActionCompat.f2459b, 2);
        remoteActionCompat.f2460c = versionedParcel.l(remoteActionCompat.f2460c, 3);
        remoteActionCompat.f2461d = (PendingIntent) versionedParcel.r(remoteActionCompat.f2461d, 4);
        remoteActionCompat.f2462e = versionedParcel.h(remoteActionCompat.f2462e, 5);
        remoteActionCompat.f2463f = versionedParcel.h(remoteActionCompat.f2463f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, VersionedParcel versionedParcel) {
        versionedParcel.x(false, false);
        versionedParcel.M(remoteActionCompat.f2458a, 1);
        versionedParcel.D(remoteActionCompat.f2459b, 2);
        versionedParcel.D(remoteActionCompat.f2460c, 3);
        versionedParcel.H(remoteActionCompat.f2461d, 4);
        versionedParcel.z(remoteActionCompat.f2462e, 5);
        versionedParcel.z(remoteActionCompat.f2463f, 6);
    }
}
