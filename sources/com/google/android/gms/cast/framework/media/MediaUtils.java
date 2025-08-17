package com.google.android.gms.cast.framework.media;

import android.annotation.TargetApi;
import android.net.Uri;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.Locale;

public class MediaUtils {
    private MediaUtils() {
    }

    public static Uri getImageUri(MediaInfo mediaInfo, int i2) {
        MediaMetadata metadata;
        if (mediaInfo == null || (metadata = mediaInfo.getMetadata()) == null || metadata.getImages() == null || metadata.getImages().size() <= i2) {
            return null;
        }
        return metadata.getImages().get(i2).getUrl();
    }

    public static String getImageUrl(MediaInfo mediaInfo, int i2) {
        Uri imageUri = getImageUri(mediaInfo, i2);
        if (imageUri == null) {
            return null;
        }
        return imageUri.toString();
    }

    @TargetApi(21)
    @Deprecated
    public static Locale getTrackLanguage(MediaTrack mediaTrack) {
        String language = mediaTrack.getLanguage();
        if (language == null) {
            return null;
        }
        if (PlatformVersion.isAtLeastLollipop()) {
            return Locale.forLanguageTag(language);
        }
        String[] split = language.split("-");
        if (split.length == 1) {
            return new Locale(split[0]);
        }
        return new Locale(split[0], split[1]);
    }
}
