package androidx.media3.common;

import androidx.media3.common.Timeline;

public abstract class BasePlayer implements Player {

    /* renamed from: a  reason: collision with root package name */
    protected final Timeline.Window f3929a = new Timeline.Window();

    protected BasePlayer() {
    }

    private int d0() {
        int repeatMode = getRepeatMode();
        if (repeatMode == 1) {
            return 0;
        }
        return repeatMode;
    }

    private void e0(int i2) {
        g0(-1, -9223372036854775807L, i2, false);
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
        int b02 = b0();
        if (b02 == -1) {
            e0(i2);
        } else if (b02 == M()) {
            f0(i2);
        } else {
            i0(b02, i2);
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
        int c02 = c0();
        if (c02 == -1) {
            e0(i2);
        } else if (c02 == M()) {
            f0(i2);
        } else {
            i0(c02, i2);
        }
    }

    public final long D() {
        Timeline t2 = t();
        if (t2.q()) {
            return -9223372036854775807L;
        }
        return t2.n(M(), this.f3929a).d();
    }

    public final boolean H() {
        return c0() != -1;
    }

    public final boolean L() {
        Timeline t2 = t();
        if (t2.q() || !t2.n(M(), this.f3929a).f4379h) {
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
        if (t2.q() || !t2.n(M(), this.f3929a).f()) {
            return false;
        }
        return true;
    }

    @Deprecated
    public final int V() {
        return M();
    }

    public final int b0() {
        Timeline t2 = t();
        if (t2.q()) {
            return -1;
        }
        return t2.e(M(), d0(), O());
    }

    public final int c0() {
        Timeline t2 = t();
        if (t2.q()) {
            return -1;
        }
        return t2.l(M(), d0(), O());
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
        if (t().q() || f()) {
            e0(7);
            return;
        }
        boolean H = H();
        if (!U() || L()) {
            if (!H || getCurrentPosition() > C()) {
                h0(0, 7);
            } else {
                l0(7);
            }
        } else if (H) {
            l0(7);
        } else {
            e0(7);
        }
    }

    public final boolean n() {
        return b0() != -1;
    }

    public final void pause() {
        l(false);
    }

    public final void play() {
        l(true);
    }

    public final boolean q(int i2) {
        return z().b(i2);
    }

    public final boolean r() {
        Timeline t2 = t();
        if (t2.q() || !t2.n(M(), this.f3929a).f4380i) {
            return false;
        }
        return true;
    }

    public final void seekTo(long j2) {
        h0(j2, 5);
    }

    public final void setPlaybackSpeed(float f2) {
        e(b().b(f2));
    }

    public final void w() {
        if (t().q() || f()) {
            e0(9);
        } else if (n()) {
            j0(9);
        } else if (!U() || !r()) {
            e0(9);
        } else {
            i0(M(), 9);
        }
    }

    public final void y(int i2, long j2) {
        g0(i2, j2, 10, false);
    }
}
