package androidx.media3.exoplayer.upstream;

import java.io.IOException;

public interface LoaderErrorThrower {

    public static final class Placeholder implements LoaderErrorThrower {
        public void a() {
        }
    }

    void a() throws IOException;
}
