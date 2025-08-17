package androidx.media3.common;

import java.util.HashSet;

public final class MediaLibraryInfo {

    /* renamed from: a  reason: collision with root package name */
    private static final HashSet<String> f4211a = new HashSet<>();

    /* renamed from: b  reason: collision with root package name */
    private static String f4212b = "media3.common";

    private MediaLibraryInfo() {
    }

    public static synchronized void a(String str) {
        synchronized (MediaLibraryInfo.class) {
            if (f4211a.add(str)) {
                f4212b += ", " + str;
            }
        }
    }

    public static synchronized String b() {
        String str;
        synchronized (MediaLibraryInfo.class) {
            str = f4212b;
        }
        return str;
    }
}
