package androidx.media3.decoder.av1;

import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.util.LibraryLoader;

public final class Gav1Library {

    /* renamed from: a  reason: collision with root package name */
    private static final LibraryLoader f5094a = new LibraryLoader("gav1JNI") {
        /* access modifiers changed from: protected */
        public void b(String str) {
            System.loadLibrary(str);
        }
    };

    static {
        MediaLibraryInfo.a("media3.decoder.av1");
    }

    private Gav1Library() {
    }

    public static boolean a() {
        return f5094a.a();
    }
}
