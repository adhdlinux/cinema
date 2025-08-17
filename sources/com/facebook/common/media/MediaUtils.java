package com.facebook.common.media;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.infer.annotation.Nullsafe;
import java.util.Locale;
import java.util.Map;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class MediaUtils {
    public static final Map<String, String> ADDITIONAL_ALLOWED_MIME_TYPES = ImmutableMap.of("mkv", "video/x-matroska", "glb", "model/gltf-binary");

    private static String extractExtension(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0 || lastIndexOf == str.length() - 1) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }

    public static String extractMime(String str) {
        String extractExtension = extractExtension(str);
        if (extractExtension == null) {
            return null;
        }
        String lowerCase = extractExtension.toLowerCase(Locale.US);
        String mimeTypeFromExtension = MimeTypeMapWrapper.getMimeTypeFromExtension(lowerCase);
        if (mimeTypeFromExtension == null) {
            return ADDITIONAL_ALLOWED_MIME_TYPES.get(lowerCase);
        }
        return mimeTypeFromExtension;
    }

    public static boolean isNonNativeSupportedMimeType(String str) {
        return ADDITIONAL_ALLOWED_MIME_TYPES.containsValue(str);
    }

    public static boolean isPhoto(String str) {
        if (str == null || !str.startsWith("image/")) {
            return false;
        }
        return true;
    }

    public static boolean isThreeD(String str) {
        if (str == null || !str.equals("model/gltf-binary")) {
            return false;
        }
        return true;
    }

    public static boolean isVideo(String str) {
        if (str == null || !str.startsWith("video/")) {
            return false;
        }
        return true;
    }
}
