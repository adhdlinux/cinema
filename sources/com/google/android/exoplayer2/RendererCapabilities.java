package com.google.android.exoplayer2;

public interface RendererCapabilities {
    int c(Format format) throws ExoPlaybackException;

    int d();

    String getName();

    int p() throws ExoPlaybackException;
}
