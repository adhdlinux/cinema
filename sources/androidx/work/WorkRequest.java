package androidx.work;

import android.os.Build;
import androidx.work.impl.model.WorkSpec;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public abstract class WorkRequest {

    /* renamed from: a  reason: collision with root package name */
    private UUID f12219a;

    /* renamed from: b  reason: collision with root package name */
    private WorkSpec f12220b;

    /* renamed from: c  reason: collision with root package name */
    private Set<String> f12221c;

    public static abstract class Builder<B extends Builder<?, ?>, W extends WorkRequest> {

        /* renamed from: a  reason: collision with root package name */
        boolean f12222a = false;

        /* renamed from: b  reason: collision with root package name */
        UUID f12223b = UUID.randomUUID();

        /* renamed from: c  reason: collision with root package name */
        WorkSpec f12224c;

        /* renamed from: d  reason: collision with root package name */
        Set<String> f12225d = new HashSet();

        /* renamed from: e  reason: collision with root package name */
        Class<? extends ListenableWorker> f12226e;

        Builder(Class<? extends ListenableWorker> cls) {
            this.f12226e = cls;
            this.f12224c = new WorkSpec(this.f12223b.toString(), cls.getName());
            a(cls.getName());
        }

        public final B a(String str) {
            this.f12225d.add(str);
            return d();
        }

        public final W b() {
            boolean z2;
            W c2 = c();
            Constraints constraints = this.f12224c.f12525j;
            int i2 = Build.VERSION.SDK_INT;
            if ((i2 < 24 || !constraints.e()) && !constraints.f() && !constraints.g() && (i2 < 23 || !constraints.h())) {
                z2 = false;
            } else {
                z2 = true;
            }
            WorkSpec workSpec = this.f12224c;
            if (workSpec.f12532q) {
                if (z2) {
                    throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
                } else if (workSpec.f12522g > 0) {
                    throw new IllegalArgumentException("Expedited jobs cannot be delayed");
                }
            }
            this.f12223b = UUID.randomUUID();
            WorkSpec workSpec2 = new WorkSpec(this.f12224c);
            this.f12224c = workSpec2;
            workSpec2.f12516a = this.f12223b.toString();
            return c2;
        }

        /* access modifiers changed from: package-private */
        public abstract W c();

        /* access modifiers changed from: package-private */
        public abstract B d();

        public final B e(Constraints constraints) {
            this.f12224c.f12525j = constraints;
            return d();
        }

        public final B f(Data data) {
            this.f12224c.f12520e = data;
            return d();
        }
    }

    protected WorkRequest(UUID uuid, WorkSpec workSpec, Set<String> set) {
        this.f12219a = uuid;
        this.f12220b = workSpec;
        this.f12221c = set;
    }

    public String a() {
        return this.f12219a.toString();
    }

    public Set<String> b() {
        return this.f12221c;
    }

    public WorkSpec c() {
        return this.f12220b;
    }
}
