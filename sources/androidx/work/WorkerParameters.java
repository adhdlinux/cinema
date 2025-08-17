package androidx.work;

import android.net.Network;
import android.net.Uri;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

public final class WorkerParameters {

    /* renamed from: a  reason: collision with root package name */
    private UUID f12229a;

    /* renamed from: b  reason: collision with root package name */
    private Data f12230b;

    /* renamed from: c  reason: collision with root package name */
    private Set<String> f12231c;

    /* renamed from: d  reason: collision with root package name */
    private RuntimeExtras f12232d;

    /* renamed from: e  reason: collision with root package name */
    private int f12233e;

    /* renamed from: f  reason: collision with root package name */
    private Executor f12234f;

    /* renamed from: g  reason: collision with root package name */
    private TaskExecutor f12235g;

    /* renamed from: h  reason: collision with root package name */
    private WorkerFactory f12236h;

    /* renamed from: i  reason: collision with root package name */
    private ProgressUpdater f12237i;

    /* renamed from: j  reason: collision with root package name */
    private ForegroundUpdater f12238j;

    public static class RuntimeExtras {

        /* renamed from: a  reason: collision with root package name */
        public List<String> f12239a = Collections.emptyList();

        /* renamed from: b  reason: collision with root package name */
        public List<Uri> f12240b = Collections.emptyList();

        /* renamed from: c  reason: collision with root package name */
        public Network f12241c;
    }

    public WorkerParameters(UUID uuid, Data data, Collection<String> collection, RuntimeExtras runtimeExtras, int i2, Executor executor, TaskExecutor taskExecutor, WorkerFactory workerFactory, ProgressUpdater progressUpdater, ForegroundUpdater foregroundUpdater) {
        this.f12229a = uuid;
        this.f12230b = data;
        this.f12231c = new HashSet(collection);
        this.f12232d = runtimeExtras;
        this.f12233e = i2;
        this.f12234f = executor;
        this.f12235g = taskExecutor;
        this.f12236h = workerFactory;
        this.f12237i = progressUpdater;
        this.f12238j = foregroundUpdater;
    }

    public Executor a() {
        return this.f12234f;
    }

    public ForegroundUpdater b() {
        return this.f12238j;
    }

    public UUID c() {
        return this.f12229a;
    }

    public Data d() {
        return this.f12230b;
    }

    public Network e() {
        return this.f12232d.f12241c;
    }

    public ProgressUpdater f() {
        return this.f12237i;
    }

    public int g() {
        return this.f12233e;
    }

    public Set<String> h() {
        return this.f12231c;
    }

    public TaskExecutor i() {
        return this.f12235g;
    }

    public List<String> j() {
        return this.f12232d.f12239a;
    }

    public List<Uri> k() {
        return this.f12232d.f12240b;
    }

    public WorkerFactory l() {
        return this.f12236h;
    }
}
