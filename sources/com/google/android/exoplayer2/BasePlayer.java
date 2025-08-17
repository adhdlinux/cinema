package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import java.util.List;

public abstract class BasePlayer implements Player {

    /* renamed from: a  reason: collision with root package name */
    protected final Timeline.Window f22800a = new Timeline.Window();

    protected BasePlayer() {
    }

    private int e0() {
        int repeatMode = getRepeatMode();
        if (repeatMode == 1) {
            return 0;
        }
        return repeatMode;
    }

    private void f0(int i2) {
        g0(M(), -9223372036854775807L, i2, true);
    }

    private void h0(long j2, int i2) {
        g0(M(), j2, i2, false);
    }

    private void i0(int i2, int i3) {
        g0(i2, -9223372036854775807L, i3, false);
    }

    private void j0(int i2) {
        int c02 = c0();
        if (c02 != -1) {
            if (c02 == M()) {
                f0(i2);
            } else {
                i0(c02, i2);
            }
        }
    }

    private void k0(long j2, int i2) {
        long currentPosition = getCurrentPosition() + j2;
        long duration = getDuration();
        if (duration != -9223372036854775807L) {
            currentPosition = Math.min(currentPosition, duration);
        }
        h0(Math.max(currentPosition, 0), i2);
    }

    private void l0(int i2) {
        int d02 = d0();
        if (d02 != -1) {
            if (d02 == M()) {
                f0(i2);
            } else {
                i0(d02, i2);
            }
        }
    }

    public final long D() {
        Timeline t2 = t();
        if (t2.u()) {
            return -9223372036854775807L;
        }
        return t2.r(M(), this.f22800a).f();
    }

    public final boolean H() {
        return d0() != -1;
    }

    public final boolean L() {
        Timeline t2 = t();
        if (t2.u() || !t2.r(M(), this.f22800a).f23518i) {
            return false;
        }
        return true;
    }

    public final void Q() {
        k0(J(), 12);
    }

    public final void R() {
        k0(-T(), 11);
    }

    public final boolean U() {
        Timeline t2 = t();
        if (t2.u() || !t2.r(M(), this.f22800a).h()) {
            return false;
        }
        return true;
    }

    public final void W(MediaItem mediaItem) {
        c(ImmutableList.s(mediaItem));
    }

    public final int b0() {
        long Z = Z();
        long duration = getDuration();
        if (Z == -9223372036854775807L || duration == -9223372036854775807L) {
            return 0;
        }
        if (duration == 0) {
            return 100;
        }
        return Util.q((int) ((Z * 100) / duration), 0, 100);
    }

    public final void c(List<MediaItem> list) {
        Y(Integer.MAX_VALUE, list);
    }

    public final int c0() {
        Timeline t2 = t();
        if (t2.u()) {
            return -1;
        }
        return t2.i(M(), e0(), O());
    }

    public final int d0() {
        Timeline t2 = t();
        if (t2.u()) {
            return -1;
        }
        return t2.p(M(), e0(), O());
    }

    public abstract void g0(int i2, long j2, int i3, boolean z2);

    public final void h() {
        i0(M(), 4);
    }

    public final boolean isPlaying() {
        if (getPlaybackState() == 3 && A() && s() == 0) {
            return true;
        }
        return false;
    }

    public final void j() {
        if (!t().u() && !f()) {
            boolean H = H();
            if (!U() || L()) {
                if (!H || getCurrentPosition() > C()) {
                    h0(0, 7);
                } else {
                    l0(7);
                }
            } else if (H) {
                l0(7);
            }
        }
    }

    public final boolean n() {
        return c0() != -1;
    }

    public final void pause() {
        l(false);
    }

    public final void play() {
        l(true);
    }

    public final boolean q(int i2) {
        return z().c(i2);
    }

    public final boolean r() {
        Timeline t2 = t();
        if (t2.u() || !t2.r(M(), this.f22800a).f23519j) {
            return false;
        }
        return true;
    }

    public final void seekTo(long j2) {
        h0(j2, 5);
    }

    public final void w() {
        if (!t().u() && !f()) {
            if (n()) {
                j0(9);
            } else if (U() && r()) {
                i0(M(), 9);
            }
        }
    }

    public final void y(int i2, long j2) {
        g0(i2, j2, 10, false);
    }
}
