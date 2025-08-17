package androidx.work.impl;

import android.text.TextUtils;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.WorkContinuation;
import androidx.work.WorkRequest;
import androidx.work.impl.utils.EnqueueRunnable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WorkContinuationImpl extends WorkContinuation {

    /* renamed from: j  reason: collision with root package name */
    private static final String f12261j = Logger.f("WorkContinuationImpl");

    /* renamed from: a  reason: collision with root package name */
    private final WorkManagerImpl f12262a;

    /* renamed from: b  reason: collision with root package name */
    private final String f12263b;

    /* renamed from: c  reason: collision with root package name */
    private final ExistingWorkPolicy f12264c;

    /* renamed from: d  reason: collision with root package name */
    private final List<? extends WorkRequest> f12265d;

    /* renamed from: e  reason: collision with root package name */
    private final List<String> f12266e;

    /* renamed from: f  reason: collision with root package name */
    private final List<String> f12267f;

    /* renamed from: g  reason: collision with root package name */
    private final List<WorkContinuationImpl> f12268g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f12269h;

    /* renamed from: i  reason: collision with root package name */
    private Operation f12270i;

    public WorkContinuationImpl(WorkManagerImpl workManagerImpl, List<? extends WorkRequest> list) {
        this(workManagerImpl, (String) null, ExistingWorkPolicy.KEEP, list, (List<WorkContinuationImpl>) null);
    }

    private static boolean i(WorkContinuationImpl workContinuationImpl, Set<String> set) {
        set.addAll(workContinuationImpl.c());
        Set<String> l2 = l(workContinuationImpl);
        for (String contains : set) {
            if (l2.contains(contains)) {
                return true;
            }
        }
        List<WorkContinuationImpl> e2 = workContinuationImpl.e();
        if (e2 != null && !e2.isEmpty()) {
            for (WorkContinuationImpl i2 : e2) {
                if (i(i2, set)) {
                    return true;
                }
            }
        }
        set.removeAll(workContinuationImpl.c());
        return false;
    }

    public static Set<String> l(WorkContinuationImpl workContinuationImpl) {
        HashSet hashSet = new HashSet();
        List<WorkContinuationImpl> e2 = workContinuationImpl.e();
        if (e2 != null && !e2.isEmpty()) {
            for (WorkContinuationImpl c2 : e2) {
                hashSet.addAll(c2.c());
            }
        }
        return hashSet;
    }

    public Operation a() {
        if (!this.f12269h) {
            EnqueueRunnable enqueueRunnable = new EnqueueRunnable(this);
            this.f12262a.p().b(enqueueRunnable);
            this.f12270i = enqueueRunnable.d();
        } else {
            Logger.c().h(f12261j, String.format("Already enqueued work ids (%s)", new Object[]{TextUtils.join(", ", this.f12266e)}), new Throwable[0]);
        }
        return this.f12270i;
    }

    public ExistingWorkPolicy b() {
        return this.f12264c;
    }

    public List<String> c() {
        return this.f12266e;
    }

    public String d() {
        return this.f12263b;
    }

    public List<WorkContinuationImpl> e() {
        return this.f12268g;
    }

    public List<? extends WorkRequest> f() {
        return this.f12265d;
    }

    public WorkManagerImpl g() {
        return this.f12262a;
    }

    public boolean h() {
        return i(this, new HashSet());
    }

    public boolean j() {
        return this.f12269h;
    }

    public void k() {
        this.f12269h = true;
    }

    public WorkContinuationImpl(WorkManagerImpl workManagerImpl, String str, ExistingWorkPolicy existingWorkPolicy, List<? extends WorkRequest> list, List<WorkContinuationImpl> list2) {
        this.f12262a = workManagerImpl;
        this.f12263b = str;
        this.f12264c = existingWorkPolicy;
        this.f12265d = list;
        this.f12268g = list2;
        this.f12266e = new ArrayList(list.size());
        this.f12267f = new ArrayList();
        if (list2 != null) {
            for (WorkContinuationImpl workContinuationImpl : list2) {
                this.f12267f.addAll(workContinuationImpl.f12267f);
            }
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            String a2 = ((WorkRequest) list.get(i2)).a();
            this.f12266e.add(a2);
            this.f12267f.add(a2);
        }
    }
}
