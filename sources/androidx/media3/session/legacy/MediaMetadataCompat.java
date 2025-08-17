package androidx.media3.session.legacy;

import android.annotation.SuppressLint;
import android.media.MediaMetadata;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.ArrayMap;
import androidx.media3.common.util.Assertions;

@SuppressLint({"BanParcelableUsage"})
public final class MediaMetadataCompat implements Parcelable {
    public static final Parcelable.Creator<MediaMetadataCompat> CREATOR = new Parcelable.Creator<MediaMetadataCompat>() {
        /* renamed from: a */
        public MediaMetadataCompat createFromParcel(Parcel parcel) {
            return new MediaMetadataCompat(parcel);
        }

        /* renamed from: b */
        public MediaMetadataCompat[] newArray(int i2) {
            return new MediaMetadataCompat[i2];
        }
    };

    /* renamed from: d  reason: collision with root package name */
    static final ArrayMap<String, Integer> f9714d;

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f9715e = {android.support.v4.media.MediaMetadataCompat.METADATA_KEY_TITLE, android.support.v4.media.MediaMetadataCompat.METADATA_KEY_ARTIST, android.support.v4.media.MediaMetadataCompat.METADATA_KEY_ALBUM, android.support.v4.media.MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST, android.support.v4.media.MediaMetadataCompat.METADATA_KEY_WRITER, android.support.v4.media.MediaMetadataCompat.METADATA_KEY_AUTHOR, android.support.v4.media.MediaMetadataCompat.METADATA_KEY_COMPOSER};

    /* renamed from: f  reason: collision with root package name */
    private static final String[] f9716f = {android.support.v4.media.MediaMetadataCompat.METADATA_KEY_DISPLAY_ICON, android.support.v4.media.MediaMetadataCompat.METADATA_KEY_ART, android.support.v4.media.MediaMetadataCompat.METADATA_KEY_ALBUM_ART};

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f9717g = {android.support.v4.media.MediaMetadataCompat.METADATA_KEY_DISPLAY_ICON_URI, android.support.v4.media.MediaMetadataCompat.METADATA_KEY_ART_URI, android.support.v4.media.MediaMetadataCompat.METADATA_KEY_ALBUM_ART_URI};

    /* renamed from: b  reason: collision with root package name */
    final Bundle f9718b;

    /* renamed from: c  reason: collision with root package name */
    private MediaMetadata f9719c;

    static {
        ArrayMap<String, Integer> arrayMap = new ArrayMap<>();
        f9714d = arrayMap;
        arrayMap.put(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_TITLE, 1);
        arrayMap.put(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_ARTIST, 1);
        arrayMap.put(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_DURATION, 0);
        arrayMap.put(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_ALBUM, 1);
        arrayMap.put(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_AUTHOR, 1);
        arrayMap.put(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_WRITER, 1);
        arrayMap.put(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_COMPOSER, 1);
        arrayMap.put(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_COMPILATION, 1);
        arrayMap.put(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_DATE, 1);
        arrayMap.put(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_YEAR, 0);
        arrayMap.put(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_GENRE, 1);
        arrayMap.put(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_TRACK_NUMBER, 0);
        arrayMap.put(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_NUM_TRACKS, 0);
        arrayMap.put(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_DISC_NUMBER, 0);
        arrayMap.put(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST, 1);
        arrayMap.put(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_ART, 2);
        arrayMap.put(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_ART_URI, 1);
        arrayMap.put(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_ALBUM_ART, 2);
        arrayMap.put(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_ALBUM_ART_URI, 1);
        arrayMap.put(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_USER_RATING, 3);
        arrayMap.put(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_RATING, 3);
        arrayMap.put(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_DISPLAY_TITLE, 1);
        arrayMap.put(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_DISPLAY_SUBTITLE, 1);
        arrayMap.put(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_DISPLAY_DESCRIPTION, 1);
        arrayMap.put(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_DISPLAY_ICON, 2);
        arrayMap.put(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_DISPLAY_ICON_URI, 1);
        arrayMap.put(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_MEDIA_ID, 1);
        arrayMap.put(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_BT_FOLDER_TYPE, 0);
        arrayMap.put(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_MEDIA_URI, 1);
        arrayMap.put(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_ADVERTISEMENT, 0);
        arrayMap.put(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_DOWNLOAD_STATUS, 0);
    }

    MediaMetadataCompat(Parcel parcel) {
        this.f9718b = (Bundle) Assertions.f(parcel.readBundle(MediaSessionCompat.class.getClassLoader()));
    }

    public static MediaMetadataCompat b(Object obj) {
        if (obj == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        mediaMetadata.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        MediaMetadataCompat createFromParcel = CREATOR.createFromParcel(obtain);
        obtain.recycle();
        createFromParcel.f9719c = mediaMetadata;
        return createFromParcel;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeBundle(this.f9718b);
    }
}
