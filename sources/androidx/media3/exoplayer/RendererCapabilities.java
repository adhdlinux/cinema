package androidx.media3.exoplayer;

import androidx.media3.common.Format;

public interface RendererCapabilities {

    public interface Listener {
        void d(Renderer renderer);
    }

    void C(Listener listener);

    int c(Format format) throws ExoPlaybackException;

    int d();

    String getName();

    int p() throws ExoPlaybackException;

    void t();
}
