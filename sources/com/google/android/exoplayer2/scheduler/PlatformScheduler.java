package com.google.android.exoplayer2.scheduler;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import com.google.android.exoplayer2.offline.DownloadService;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;

public final class PlatformScheduler implements Scheduler {

    /* renamed from: d  reason: collision with root package name */
    private static final int f25668d = ((Util.f28808a >= 26 ? 16 : 0) | 15);

    /* renamed from: a  reason: collision with root package name */
    private final int f25669a;

    /* renamed from: b  reason: collision with root package name */
    private final ComponentName f25670b;

    /* renamed from: c  reason: collision with root package name */
    private final JobScheduler f25671c;

    public static final class PlatformSchedulerService extends JobService {
        public boolean onStartJob(JobParameters jobParameters) {
            PersistableBundle extras = jobParameters.getExtras();
            int d2 = new Requirements(extras.getInt(DownloadService.KEY_REQUIREMENTS)).d(this);
            if (d2 == 0) {
                Util.Z0(this, new Intent((String) Assertions.e(extras.getString("service_action"))).setPackage((String) Assertions.e(extras.getString("service_package"))));
                return false;
            }
            Log.i("PlatformScheduler", "Requirements not met: " + d2);
            jobFinished(jobParameters, true);
            return false;
        }

        public boolean onStopJob(JobParameters jobParameters) {
            return false;
        }
    }

    public PlatformScheduler(Context context, int i2) {
        Context applicationContext = context.getApplicationContext();
        this.f25669a = i2;
        this.f25670b = new ComponentName(applicationContext, PlatformSchedulerService.class);
        this.f25671c = (JobScheduler) Assertions.e((JobScheduler) applicationContext.getSystemService("jobscheduler"));
    }

    private static JobInfo c(int i2, ComponentName componentName, Requirements requirements, String str, String str2) {
        Requirements b2 = requirements.b(f25668d);
        if (!b2.equals(requirements)) {
            Log.i("PlatformScheduler", "Ignoring unsupported requirements: " + (b2.e() ^ requirements.e()));
        }
        JobInfo.Builder builder = new JobInfo.Builder(i2, componentName);
        if (requirements.n()) {
            builder.setRequiredNetworkType(2);
        } else if (requirements.k()) {
            builder.setRequiredNetworkType(1);
        }
        builder.setRequiresDeviceIdle(requirements.i());
        builder.setRequiresCharging(requirements.f());
        if (Util.f28808a >= 26 && requirements.m()) {
            JobInfo.Builder unused = builder.setRequiresStorageNotLow(true);
        }
        builder.setPersisted(true);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("service_action", str);
        persistableBundle.putString("service_package", str2);
        persistableBundle.putInt(DownloadService.KEY_REQUIREMENTS, requirements.e());
        builder.setExtras(persistableBundle);
        return builder.build();
    }

    public boolean a(Requirements requirements, String str, String str2) {
        if (this.f25671c.schedule(c(this.f25669a, this.f25670b, requirements, str2, str)) == 1) {
            return true;
        }
        return false;
    }

    public Requirements b(Requirements requirements) {
        return requirements.b(f25668d);
    }

    public boolean cancel() {
        this.f25671c.cancel(this.f25669a);
        return true;
    }
}
