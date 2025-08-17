package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.time.Clock;

public abstract class SchedulingConfigModule {
    static SchedulerConfig a(Clock clock) {
        return SchedulerConfig.f(clock);
    }
}
