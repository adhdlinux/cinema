package com.vungle.ads.internal.task;

import android.os.Bundle;

public interface Job {
    int onRunJob(Bundle bundle, JobRunner jobRunner);
}
