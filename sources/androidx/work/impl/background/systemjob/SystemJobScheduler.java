package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.work.Logger;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.IdGenerator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class SystemJobScheduler implements Scheduler {

    /* renamed from: f  reason: collision with root package name */
    private static final String f12406f = Logger.f("SystemJobScheduler");

    /* renamed from: b  reason: collision with root package name */
    private final Context f12407b;

    /* renamed from: c  reason: collision with root package name */
    private final JobScheduler f12408c;

    /* renamed from: d  reason: collision with root package name */
    private final WorkManagerImpl f12409d;

    /* renamed from: e  reason: collision with root package name */
    private final SystemJobInfoConverter f12410e;

    public SystemJobScheduler(Context context, WorkManagerImpl workManagerImpl) {
        this(context, workManagerImpl, (JobScheduler) context.getSystemService("jobscheduler"), new SystemJobInfoConverter(context));
    }

    public static void b(Context context) {
        List<JobInfo> g2;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null && (g2 = g(context, jobScheduler)) != null && !g2.isEmpty()) {
            for (JobInfo id : g2) {
                e(jobScheduler, id.getId());
            }
        }
    }

    private static void e(JobScheduler jobScheduler, int i2) {
        try {
            jobScheduler.cancel(i2);
        } catch (Throwable th) {
            Logger.c().b(f12406f, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", new Object[]{Integer.valueOf(i2)}), th);
        }
    }

    private static List<Integer> f(Context context, JobScheduler jobScheduler, String str) {
        List<JobInfo> g2 = g(context, jobScheduler);
        if (g2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        for (JobInfo next : g2) {
            if (str.equals(h(next))) {
                arrayList.add(Integer.valueOf(next.getId()));
            }
        }
        return arrayList;
    }

    private static List<JobInfo> g(Context context, JobScheduler jobScheduler) {
        List<JobInfo> list;
        try {
            list = jobScheduler.getAllPendingJobs();
        } catch (Throwable th) {
            Logger.c().b(f12406f, "getAllPendingJobs() is not reliable on this device.", th);
            list = null;
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ComponentName componentName = new ComponentName(context, SystemJobService.class);
        for (JobInfo next : list) {
            if (componentName.equals(next.getService())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private static String h(JobInfo jobInfo) {
        PersistableBundle extras = jobInfo.getExtras();
        if (extras == null) {
            return null;
        }
        try {
            if (extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return extras.getString("EXTRA_WORK_SPEC_ID");
            }
            return null;
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public static boolean i(Context context, WorkManagerImpl workManagerImpl) {
        int i2;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        List<JobInfo> g2 = g(context, jobScheduler);
        List<String> b2 = workManagerImpl.o().A().b();
        boolean z2 = false;
        if (g2 != null) {
            i2 = g2.size();
        } else {
            i2 = 0;
        }
        HashSet hashSet = new HashSet(i2);
        if (g2 != null && !g2.isEmpty()) {
            for (JobInfo next : g2) {
                String h2 = h(next);
                if (!TextUtils.isEmpty(h2)) {
                    hashSet.add(h2);
                } else {
                    e(jobScheduler, next.getId());
                }
            }
        }
        Iterator<String> it2 = b2.iterator();
        while (true) {
            if (it2.hasNext()) {
                if (!hashSet.contains(it2.next())) {
                    Logger.c().a(f12406f, "Reconciling jobs", new Throwable[0]);
                    z2 = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (z2) {
            WorkDatabase o2 = workManagerImpl.o();
            o2.c();
            try {
                WorkSpecDao D = o2.D();
                for (String l2 : b2) {
                    D.l(l2, -1);
                }
                o2.t();
            } finally {
                o2.g();
            }
        }
        return z2;
    }

    public void a(String str) {
        List<Integer> f2 = f(this.f12407b, this.f12408c, str);
        if (f2 != null && !f2.isEmpty()) {
            for (Integer intValue : f2) {
                e(this.f12408c, intValue.intValue());
            }
            this.f12409d.o().A().d(str);
        }
    }

    /* JADX INFO: finally extract failed */
    public void c(WorkSpec... workSpecArr) {
        int i2;
        List<Integer> f2;
        int i3;
        WorkDatabase o2 = this.f12409d.o();
        IdGenerator idGenerator = new IdGenerator(o2);
        int length = workSpecArr.length;
        int i4 = 0;
        while (i4 < length) {
            WorkSpec workSpec = workSpecArr[i4];
            o2.c();
            try {
                WorkSpec g2 = o2.D().g(workSpec.f12516a);
                if (g2 == null) {
                    Logger c2 = Logger.c();
                    String str = f12406f;
                    c2.h(str, "Skipping scheduling " + workSpec.f12516a + " because it's no longer in the DB", new Throwable[0]);
                    o2.t();
                } else if (g2.f12517b != WorkInfo.State.ENQUEUED) {
                    Logger c3 = Logger.c();
                    String str2 = f12406f;
                    c3.h(str2, "Skipping scheduling " + workSpec.f12516a + " because it is no longer enqueued", new Throwable[0]);
                    o2.t();
                } else {
                    SystemIdInfo a2 = o2.A().a(workSpec.f12516a);
                    if (a2 != null) {
                        i2 = a2.f12494b;
                    } else {
                        i2 = idGenerator.d(this.f12409d.i().i(), this.f12409d.i().g());
                    }
                    if (a2 == null) {
                        this.f12409d.o().A().c(new SystemIdInfo(workSpec.f12516a, i2));
                    }
                    j(workSpec, i2);
                    if (Build.VERSION.SDK_INT == 23 && (f2 = f(this.f12407b, this.f12408c, workSpec.f12516a)) != null) {
                        int indexOf = f2.indexOf(Integer.valueOf(i2));
                        if (indexOf >= 0) {
                            f2.remove(indexOf);
                        }
                        if (!f2.isEmpty()) {
                            i3 = f2.get(0).intValue();
                        } else {
                            i3 = idGenerator.d(this.f12409d.i().i(), this.f12409d.i().g());
                        }
                        j(workSpec, i3);
                    }
                    o2.t();
                }
                o2.g();
                i4++;
            } catch (Throwable th) {
                o2.g();
                throw th;
            }
        }
    }

    public boolean d() {
        return true;
    }

    public void j(WorkSpec workSpec, int i2) {
        int i3;
        JobInfo a2 = this.f12410e.a(workSpec, i2);
        Logger c2 = Logger.c();
        String str = f12406f;
        c2.a(str, String.format("Scheduling work ID %s Job ID %s", new Object[]{workSpec.f12516a, Integer.valueOf(i2)}), new Throwable[0]);
        try {
            if (this.f12408c.schedule(a2) == 0) {
                Logger.c().h(str, String.format("Unable to schedule work ID %s", new Object[]{workSpec.f12516a}), new Throwable[0]);
                if (workSpec.f12532q && workSpec.f12533r == OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST) {
                    workSpec.f12532q = false;
                    Logger.c().a(str, String.format("Scheduling a non-expedited job (work ID %s)", new Object[]{workSpec.f12516a}), new Throwable[0]);
                    j(workSpec, i2);
                }
            }
        } catch (IllegalStateException e2) {
            List<JobInfo> g2 = g(this.f12407b, this.f12408c);
            if (g2 != null) {
                i3 = g2.size();
            } else {
                i3 = 0;
            }
            String format = String.format(Locale.getDefault(), "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", new Object[]{Integer.valueOf(i3), Integer.valueOf(this.f12409d.o().D().d().size()), Integer.valueOf(this.f12409d.i().h())});
            Logger.c().b(f12406f, format, new Throwable[0]);
            throw new IllegalStateException(format, e2);
        } catch (Throwable th) {
            Logger.c().b(f12406f, String.format("Unable to schedule %s", new Object[]{workSpec}), th);
        }
    }

    public SystemJobScheduler(Context context, WorkManagerImpl workManagerImpl, JobScheduler jobScheduler, SystemJobInfoConverter systemJobInfoConverter) {
        this.f12407b = context;
        this.f12409d = workManagerImpl;
        this.f12408c = jobScheduler;
        this.f12410e = systemJobInfoConverter;
    }
}
