package com.google.android.exoplayer2.ui;

public interface TimeBar {

    public interface OnScrubListener {
        void p(TimeBar timeBar, long j2);

        void r(TimeBar timeBar, long j2, boolean z2);

        void u(TimeBar timeBar, long j2);
    }

    void a(long[] jArr, boolean[] zArr, int i2);

    void b(OnScrubListener onScrubListener);

    long getPreferredUpdateDelay();

    void setBufferedPosition(long j2);

    void setDuration(long j2);

    void setEnabled(boolean z2);

    void setPosition(long j2);
}
