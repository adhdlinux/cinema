package com.startapp;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import android.util.Log;
import com.startapp.sdk.jobs.JobRequest;
import java.util.ArrayList;
import java.util.List;

public class de implements ge {

    /* renamed from: a  reason: collision with root package name */
    public static final String f34377a = "de";

    /* renamed from: b  reason: collision with root package name */
    public final JobScheduler f34378b;

    /* renamed from: c  reason: collision with root package name */
    public final ComponentName f34379c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f34380d;

    public de(Context context, Class<? extends JobService> cls) throws IllegalStateException {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null) {
            this.f34378b = jobScheduler;
            this.f34379c = new ComponentName(context, cls);
            this.f34380d = hc.a(context, "android.permission.RECEIVE_BOOT_COMPLETED");
            return;
        }
        throw new IllegalStateException();
    }

    public final JobInfo.Builder a(JobRequest jobRequest, Integer num) {
        int i2;
        int i3;
        if (num != null) {
            i2 = num.intValue();
        } else {
            i2 = JobRequest.a(jobRequest.f36512a);
        }
        JobInfo.Builder builder = new JobInfo.Builder(i2, this.f34379c);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("extraKeyUuid", jobRequest.f36513b.toString());
        persistableBundle.putStringArray("extraKeyTags", jobRequest.f36512a);
        if (num != null) {
            persistableBundle.putInt("extraKeyDuplicate", 1);
        }
        builder.setExtras(persistableBundle);
        JobRequest.Network network = jobRequest.f36514c;
        if (network != null) {
            if (network == JobRequest.Network.UNMETERED) {
                i3 = 2;
            } else {
                i3 = network == JobRequest.Network.f36517b ? 1 : 0;
            }
            builder.setRequiredNetworkType(i3);
        }
        if (this.f34380d) {
            builder.setPersisted(true);
        }
        return builder;
    }

    public final boolean a(JobInfo jobInfo, JobRequest jobRequest) {
        try {
            return this.f34378b.schedule(jobInfo) == 1;
        } catch (IllegalStateException unused) {
            String str = f34377a;
            Log.e(str, "JobScheduler 100 job limit exceeded. Unable to schedule " + jobRequest.f36512a[0]);
            return false;
        } catch (Throwable unused2) {
            String str2 = f34377a;
            Log.e(str2, "Unable to schedule " + jobRequest.f36512a[0]);
            return false;
        }
    }

    public final List<JobInfo> a() {
        List<JobInfo> list;
        try {
            list = this.f34378b.getAllPendingJobs();
        } catch (Throwable unused) {
            Log.e(f34377a, "getAllPendingJobs() is not reliable on this device.");
            list = null;
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (JobInfo next : list) {
            if (this.f34379c.equals(next.getService())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public boolean a(JobRequest jobRequest, long j2) {
        JobInfo.Builder a2 = a(jobRequest, (Integer) null);
        if (Build.VERSION.SDK_INT >= 24) {
            return a(a2.setPeriodic(j2, JobInfo.getMinFlexMillis()).build(), jobRequest);
        }
        List<JobInfo> a3 = a();
        if (a3 == null) {
            return false;
        }
        for (JobInfo next : a3) {
            if (next.getId() == JobRequest.a(jobRequest.f36512a) && next.getIntervalMillis() == j2) {
                return false;
            }
        }
        return a(a2.setPeriodic(j2).build(), jobRequest);
    }

    public boolean a(JobRequest jobRequest, Long l2, Long l3) {
        ArrayList arrayList = null;
        JobInfo.Builder a2 = a(jobRequest, (Integer) null);
        long j2 = 0;
        if (l2 != null || Build.VERSION.SDK_INT <= 28) {
            a2.setMinimumLatency(l2 != null ? l2.longValue() : 0);
        }
        JobInfo build = a2.build();
        boolean a3 = a(build, jobRequest);
        if (Build.VERSION.SDK_INT == 23) {
            String uuid = jobRequest.f36513b.toString();
            List<JobInfo> a4 = a();
            if (a4 != null) {
                arrayList = new ArrayList(2);
                for (JobInfo next : a4) {
                    PersistableBundle extras = next.getExtras();
                    try {
                        if (extras.containsKey("extraKeyUuid") && uuid.equals(extras.getString("extraKeyUuid"))) {
                            arrayList.add(Integer.valueOf(next.getId()));
                        }
                    } catch (NullPointerException unused) {
                    }
                }
            }
            if (arrayList != null) {
                int id = build.getId();
                int indexOf = arrayList.indexOf(Integer.valueOf(id));
                if (indexOf >= 0) {
                    arrayList.remove(indexOf);
                }
                JobInfo.Builder a5 = a(jobRequest, Integer.valueOf(!arrayList.isEmpty() ? ((Integer) arrayList.get(0)).intValue() : id < Integer.MAX_VALUE ? id + 1 : id - 1));
                if (l2 != null || Build.VERSION.SDK_INT <= 28) {
                    if (l2 != null) {
                        j2 = l2.longValue();
                    }
                    a5.setMinimumLatency(j2);
                }
                a(a5.build(), jobRequest);
            }
        }
        return a3;
    }

    public boolean a(int i2) {
        List<JobInfo> a2 = a();
        if (a2 == null) {
            return false;
        }
        try {
            for (JobInfo id : a2) {
                if (id.getId() == i2) {
                    this.f34378b.cancel(i2);
                    return true;
                }
            }
        } catch (Throwable unused) {
            Log.e(f34377a, "cancel(jobId) is not reliable on this device.");
        }
        return false;
    }
}
