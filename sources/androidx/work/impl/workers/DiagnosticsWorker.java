package androidx.work.impl.workers;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DiagnosticsWorker extends Worker {

    /* renamed from: b  reason: collision with root package name */
    private static final String f12685b = Logger.f("DiagnosticsWrkr");

    public DiagnosticsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    private static String a(WorkSpec workSpec, String str, Integer num, String str2) {
        return String.format("\n%s\t %s\t %s\t %s\t %s\t %s\t", new Object[]{workSpec.f12516a, workSpec.f12518c, num, workSpec.f12517b.name(), str, str2});
    }

    private static String c(WorkNameDao workNameDao, WorkTagDao workTagDao, SystemIdInfoDao systemIdInfoDao, List<WorkSpec> list) {
        String str;
        Integer num;
        StringBuilder sb = new StringBuilder();
        if (Build.VERSION.SDK_INT >= 23) {
            str = "Job Id";
        } else {
            str = "Alarm Id";
        }
        sb.append(String.format("\n Id \t Class Name\t %s\t State\t Unique Name\t Tags\t", new Object[]{str}));
        for (WorkSpec next : list) {
            SystemIdInfo a2 = systemIdInfoDao.a(next.f12516a);
            if (a2 != null) {
                num = Integer.valueOf(a2.f12494b);
            } else {
                num = null;
            }
            sb.append(a(next, TextUtils.join(",", workNameDao.b(next.f12516a)), num, TextUtils.join(",", workTagDao.a(next.f12516a))));
        }
        return sb.toString();
    }

    public ListenableWorker.Result doWork() {
        WorkDatabase o2 = WorkManagerImpl.k(getApplicationContext()).o();
        WorkSpecDao D = o2.D();
        WorkNameDao B = o2.B();
        WorkTagDao E = o2.E();
        SystemIdInfoDao A = o2.A();
        List<WorkSpec> b2 = D.b(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1));
        List<WorkSpec> p2 = D.p();
        List<WorkSpec> j2 = D.j(200);
        if (b2 != null && !b2.isEmpty()) {
            Logger c2 = Logger.c();
            String str = f12685b;
            c2.d(str, "Recently completed work:\n\n", new Throwable[0]);
            Logger.c().d(str, c(B, E, A, b2), new Throwable[0]);
        }
        if (p2 != null && !p2.isEmpty()) {
            Logger c3 = Logger.c();
            String str2 = f12685b;
            c3.d(str2, "Running work:\n\n", new Throwable[0]);
            Logger.c().d(str2, c(B, E, A, p2), new Throwable[0]);
        }
        if (j2 != null && !j2.isEmpty()) {
            Logger c4 = Logger.c();
            String str3 = f12685b;
            c4.d(str3, "Enqueued work:\n\n", new Throwable[0]);
            Logger.c().d(str3, c(B, E, A, j2), new Throwable[0]);
        }
        return ListenableWorker.Result.c();
    }
}
