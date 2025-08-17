package androidx.media3.session.legacy;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaDescriptionCompat;
import androidx.media3.common.util.Util;

public final class LegacyParcelableUtil {
    private LegacyParcelableUtil() {
    }

    public static <T extends Parcelable, U extends Parcelable> T a(U u2, Parcelable.Creator<T> creator) {
        if (u2 == null) {
            return null;
        }
        Parcelable parcelable = (Parcelable) b(u2);
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            return (Parcelable) b((Parcelable) creator.createFromParcel(obtain));
        } finally {
            obtain.recycle();
        }
    }

    private static <T> T b(T t2) {
        int i2 = Util.f4714a;
        if (i2 < 21 || i2 >= 23) {
            return t2;
        }
        if (t2 instanceof MediaBrowserCompat.MediaItem) {
            MediaBrowserCompat.MediaItem mediaItem = (MediaBrowserCompat.MediaItem) t2;
            return new MediaBrowserCompat.MediaItem(c(mediaItem.getDescription()), mediaItem.getFlags());
        } else if (t2 instanceof MediaDescriptionCompat) {
            return c((MediaDescriptionCompat) t2);
        } else {
            return t2;
        }
    }

    private static MediaDescriptionCompat c(MediaDescriptionCompat mediaDescriptionCompat) {
        return new MediaDescriptionCompat.Builder().setMediaId(mediaDescriptionCompat.getMediaId()).setTitle(mediaDescriptionCompat.getTitle()).setSubtitle(mediaDescriptionCompat.getSubtitle()).setDescription(mediaDescriptionCompat.getDescription()).setIconBitmap(mediaDescriptionCompat.getIconBitmap()).setIconUri(mediaDescriptionCompat.getIconUri()).setExtras(mediaDescriptionCompat.getExtras()).setMediaUri(mediaDescriptionCompat.getMediaUri()).build();
    }
}
