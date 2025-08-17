package androidx.media3.session.legacy;

import android.annotation.SuppressLint;
import android.media.browse.MediaBrowser;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

@SuppressLint({"BanParcelableUsage"})
public class MediaBrowserCompat$MediaItem implements Parcelable {
    public static final Parcelable.Creator<MediaBrowserCompat$MediaItem> CREATOR = new Parcelable.Creator<MediaBrowserCompat$MediaItem>() {
        /* renamed from: a */
        public MediaBrowserCompat$MediaItem createFromParcel(Parcel parcel) {
            return new MediaBrowserCompat$MediaItem(parcel);
        }

        /* renamed from: b */
        public MediaBrowserCompat$MediaItem[] newArray(int i2) {
            return new MediaBrowserCompat$MediaItem[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final int f9678b;

    /* renamed from: c  reason: collision with root package name */
    private final MediaDescriptionCompat f9679c;

    public MediaBrowserCompat$MediaItem(MediaDescriptionCompat mediaDescriptionCompat, int i2) {
        if (mediaDescriptionCompat == null) {
            throw new IllegalArgumentException("description cannot be null");
        } else if (!TextUtils.isEmpty(mediaDescriptionCompat.d())) {
            this.f9678b = i2;
            this.f9679c = mediaDescriptionCompat;
        } else {
            throw new IllegalArgumentException("description must have a non-empty media id");
        }
    }

    public static MediaBrowserCompat$MediaItem b(Object obj) {
        if (obj == null) {
            return null;
        }
        MediaBrowser.MediaItem mediaItem = (MediaBrowser.MediaItem) obj;
        return new MediaBrowserCompat$MediaItem(MediaDescriptionCompat.b(MediaBrowserCompat$Api21Impl.a(mediaItem)), MediaBrowserCompat$Api21Impl.b(mediaItem));
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "MediaItem{" + "mFlags=" + this.f9678b + ", mDescription=" + this.f9679c + '}';
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f9678b);
        this.f9679c.writeToParcel(parcel, i2);
    }

    MediaBrowserCompat$MediaItem(Parcel parcel) {
        this.f9678b = parcel.readInt();
        this.f9679c = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
    }
}
