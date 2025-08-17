package com.google.android.datatransport.runtime.time;

public abstract class TimeModule {
    static Clock a() {
        return new WallTimeClock();
    }

    static Clock b() {
        return new UptimeClock();
    }
}
