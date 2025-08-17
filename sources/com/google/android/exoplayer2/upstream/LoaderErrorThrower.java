package com.google.android.exoplayer2.upstream;

import java.io.IOException;

public interface LoaderErrorThrower {

    public static final class Dummy implements LoaderErrorThrower {
        public void a() {
        }
    }

    void a() throws IOException;
}
