package com.startapp.sdk.jobs;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import com.startapp.ae;
import com.startapp.be;
import com.startapp.sdk.components.ComponentLocator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SchedulerService extends JobService {

    /* renamed from: a  reason: collision with root package name */
    public static final String f36523a = "SchedulerService";

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f36524b;

    /* renamed from: c  reason: collision with root package name */
    public final ae f36525c = new a();

    public class a extends ae {
        public a() {
        }

        public void a(be beVar) {
            ExecutorService executorService = SchedulerService.this.f36524b;
            if (executorService != null) {
                executorService.execute(beVar);
            }
        }
    }

    public class b implements be.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JobParameters f36527a;

        public b(PersistableBundle persistableBundle, JobParameters jobParameters) {
            this.f36527a = jobParameters;
        }

        public void a(be beVar, boolean z2) {
            SchedulerService.this.jobFinished(this.f36527a, z2);
        }
    }

    public void onCreate() {
        super.onCreate();
        this.f36524b = Executors.newSingleThreadExecutor(new ComponentLocator.h0("scheduler"));
    }

    public void onDestroy() {
        super.onDestroy();
        ExecutorService executorService = this.f36524b;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public boolean onStartJob(JobParameters jobParameters) {
        Bundle bundle;
        if (this.f36524b == null) {
            Log.e(f36523a, "Service is not initialized; requesting retry.");
            return false;
        }
        PersistableBundle extras = jobParameters.getExtras();
        if (extras.containsKey("extraKeyDuplicate")) {
            return false;
        }
        PersistableBundle persistableBundle = extras.getPersistableBundle("extraKeyBundle");
        if (persistableBundle != null) {
            bundle = new Bundle();
            bundle.putAll(persistableBundle);
        } else {
            bundle = null;
        }
        return this.f36525c.a(this, extras.getStringArray("extraKeyTags"), new b(extras, jobParameters), bundle);
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
