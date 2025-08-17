package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.work.Logger;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.List;

class ConstraintsCommandHandler {

    /* renamed from: e  reason: collision with root package name */
    private static final String f12366e = Logger.f("ConstraintsCmdHandler");

    /* renamed from: a  reason: collision with root package name */
    private final Context f12367a;

    /* renamed from: b  reason: collision with root package name */
    private final int f12368b;

    /* renamed from: c  reason: collision with root package name */
    private final SystemAlarmDispatcher f12369c;

    /* renamed from: d  reason: collision with root package name */
    private final WorkConstraintsTracker f12370d;

    ConstraintsCommandHandler(Context context, int i2, SystemAlarmDispatcher systemAlarmDispatcher) {
        this.f12367a = context;
        this.f12368b = i2;
        this.f12369c = systemAlarmDispatcher;
        this.f12370d = new WorkConstraintsTracker(context, systemAlarmDispatcher.f(), (WorkConstraintsCallback) null);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        List<WorkSpec> d2 = this.f12369c.g().o().D().d();
        ConstraintProxy.a(this.f12367a, d2);
        this.f12370d.d(d2);
        ArrayList<WorkSpec> arrayList = new ArrayList<>(d2.size());
        long currentTimeMillis = System.currentTimeMillis();
        for (WorkSpec next : d2) {
            String str = next.f12516a;
            if (currentTimeMillis >= next.a() && (!next.b() || this.f12370d.c(str))) {
                arrayList.add(next);
            }
        }
        for (WorkSpec workSpec : arrayList) {
            String str2 = workSpec.f12516a;
            Intent b2 = CommandHandler.b(this.f12367a, str2);
            Logger.c().a(f12366e, String.format("Creating a delay_met command for workSpec with id (%s)", new Object[]{str2}), new Throwable[0]);
            SystemAlarmDispatcher systemAlarmDispatcher = this.f12369c;
            systemAlarmDispatcher.k(new SystemAlarmDispatcher.AddRunnable(systemAlarmDispatcher, b2, this.f12368b));
        }
        this.f12370d.e();
    }
}
