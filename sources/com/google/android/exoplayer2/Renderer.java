package com.google.android.exoplayer2;

import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.MediaClock;
import java.io.IOException;

public interface Renderer extends PlayerMessage.Target {

    public interface WakeupListener {
        void a();

        void b();
    }

    boolean a();

    int d();

    void disable();

    void f(long j2, long j3) throws ExoPlaybackException;

    boolean g();

    String getName();

    int getState();

    SampleStream getStream();

    void h(int i2, PlayerId playerId);

    void i();

    boolean isReady();

    void k() throws IOException;

    boolean l();

    RendererCapabilities m();

    void o(float f2, float f3) throws ExoPlaybackException;

    long q();

    void r(long j2) throws ExoPlaybackException;

    void reset();

    MediaClock s();

    void start() throws ExoPlaybackException;

    void stop();

    void t(Format[] formatArr, SampleStream sampleStream, long j2, long j3) throws ExoPlaybackException;

    void u(RendererConfiguration rendererConfiguration, Format[] formatArr, SampleStream sampleStream, long j2, boolean z2, boolean z3, long j3, long j4) throws ExoPlaybackException;
}
