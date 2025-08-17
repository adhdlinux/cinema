package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.core.os.BuildCompat;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.ContentUriTriggers;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.model.WorkSpec;

class SystemJobInfoConverter {

    /* renamed from: b  reason: collision with root package name */
    private static final String f12403b = Logger.f("SystemJobInfoConverter");

    /* renamed from: a  reason: collision with root package name */
    private final ComponentName f12404a;

    /* renamed from: androidx.work.impl.background.systemjob.SystemJobInfoConverter$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f12405a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.work.NetworkType[] r0 = androidx.work.NetworkType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f12405a = r0
                androidx.work.NetworkType r1 = androidx.work.NetworkType.NOT_REQUIRED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f12405a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.work.NetworkType r1 = androidx.work.NetworkType.CONNECTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f12405a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.work.NetworkType r1 = androidx.work.NetworkType.UNMETERED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f12405a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.work.NetworkType r1 = androidx.work.NetworkType.NOT_ROAMING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f12405a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.work.NetworkType r1 = androidx.work.NetworkType.METERED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.systemjob.SystemJobInfoConverter.AnonymousClass1.<clinit>():void");
        }
    }

    SystemJobInfoConverter(Context context) {
        this.f12404a = new ComponentName(context.getApplicationContext(), SystemJobService.class);
    }

    private static JobInfo.TriggerContentUri b(ContentUriTriggers.Trigger trigger) {
        return new JobInfo.TriggerContentUri(trigger.a(), trigger.b() ? 1 : 0);
    }

    static int c(NetworkType networkType) {
        int i2 = AnonymousClass1.f12405a[networkType.ordinal()];
        if (i2 == 1) {
            return 0;
        }
        if (i2 == 2) {
            return 1;
        }
        if (i2 == 3) {
            return 2;
        }
        if (i2 != 4) {
            if (i2 == 5 && Build.VERSION.SDK_INT >= 26) {
                return 4;
            }
        } else if (Build.VERSION.SDK_INT >= 24) {
            return 3;
        }
        Logger.c().a(f12403b, String.format("API version too low. Cannot convert network type value %s", new Object[]{networkType}), new Throwable[0]);
        return 1;
    }

    static void d(JobInfo.Builder builder, NetworkType networkType) {
        if (Build.VERSION.SDK_INT < 30 || networkType != NetworkType.TEMPORARILY_UNMETERED) {
            builder.setRequiredNetworkType(c(networkType));
        } else {
            JobInfo.Builder unused = builder.setRequiredNetwork(new NetworkRequest.Builder().addCapability(25).build());
        }
    }

    /* access modifiers changed from: package-private */
    public JobInfo a(WorkSpec workSpec, int i2) {
        boolean z2;
        int i3;
        Constraints constraints = workSpec.f12525j;
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("EXTRA_WORK_SPEC_ID", workSpec.f12516a);
        persistableBundle.putBoolean("EXTRA_IS_PERIODIC", workSpec.d());
        JobInfo.Builder extras = new JobInfo.Builder(i2, this.f12404a).setRequiresCharging(constraints.g()).setRequiresDeviceIdle(constraints.h()).setExtras(persistableBundle);
        d(extras, constraints.b());
        boolean z3 = false;
        if (!constraints.h()) {
            if (workSpec.f12527l == BackoffPolicy.LINEAR) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            extras.setBackoffCriteria(workSpec.f12528m, i3);
        }
        long max = Math.max(workSpec.a() - System.currentTimeMillis(), 0);
        int i4 = Build.VERSION.SDK_INT;
        if (i4 <= 28) {
            extras.setMinimumLatency(max);
        } else if (max > 0) {
            extras.setMinimumLatency(max);
        } else if (!workSpec.f12532q) {
            JobInfo.Builder unused = extras.setImportantWhileForeground(true);
        }
        if (i4 >= 24 && constraints.e()) {
            for (ContentUriTriggers.Trigger b2 : constraints.a().b()) {
                JobInfo.Builder unused2 = extras.addTriggerContentUri(b(b2));
            }
            JobInfo.Builder unused3 = extras.setTriggerContentUpdateDelay(constraints.c());
            JobInfo.Builder unused4 = extras.setTriggerContentMaxDelay(constraints.d());
        }
        extras.setPersisted(false);
        if (Build.VERSION.SDK_INT >= 26) {
            JobInfo.Builder unused5 = extras.setRequiresBatteryNotLow(constraints.f());
            JobInfo.Builder unused6 = extras.setRequiresStorageNotLow(constraints.i());
        }
        if (workSpec.f12526k > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (max > 0) {
            z3 = true;
        }
        if (BuildCompat.c() && workSpec.f12532q && !z2 && !z3) {
            JobInfo.Builder unused7 = extras.setExpedited(true);
        }
        return extras.build();
    }
}
