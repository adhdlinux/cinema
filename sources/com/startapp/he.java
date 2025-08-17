package com.startapp;

import android.content.Context;
import android.os.Bundle;
import com.startapp.be;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.sdk.jobs.JobRequest;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class he implements ge {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<Context> f34648a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<Integer, Future<?>> f34649b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final ScheduledExecutorService f34650c = Executors.newScheduledThreadPool(1, ComponentLocator.b("scheduler"));

    public class a extends ae {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JobRequest f34651b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f34652c;

        public a(JobRequest jobRequest, long j2) {
            this.f34651b = jobRequest;
            this.f34652c = j2;
        }

        public void a(be beVar) {
            he heVar = he.this;
            int a2 = JobRequest.a(this.f34651b.f36512a);
            long j2 = this.f34652c;
            synchronized (heVar) {
                heVar.f34649b.put(Integer.valueOf(a2), heVar.f34650c.scheduleAtFixedRate(beVar, j2, j2, TimeUnit.MILLISECONDS));
            }
        }
    }

    public class b implements be.a {
        public b(he heVar, JobRequest jobRequest) {
        }

        public void a(be beVar, boolean z2) {
        }
    }

    public class c extends ae {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JobRequest f34654b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f34655c;

        public c(JobRequest jobRequest, long j2) {
            this.f34654b = jobRequest;
            this.f34655c = j2;
        }

        public void a(be beVar) {
            he heVar = he.this;
            int a2 = JobRequest.a(this.f34654b.f36512a);
            long j2 = this.f34655c;
            synchronized (heVar) {
                heVar.f34649b.put(Integer.valueOf(a2), heVar.f34650c.schedule(beVar, j2, TimeUnit.MILLISECONDS));
            }
        }
    }

    public class d implements be.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JobRequest f34657a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f34658b;

        public d(JobRequest jobRequest, long j2) {
            this.f34657a = jobRequest;
            this.f34658b = j2;
        }

        public void a(be beVar, boolean z2) {
            if (z2) {
                he heVar = he.this;
                int a2 = JobRequest.a(this.f34657a.f36512a);
                long j2 = this.f34658b;
                synchronized (heVar) {
                    heVar.f34649b.put(Integer.valueOf(a2), heVar.f34650c.schedule(beVar, j2, TimeUnit.MILLISECONDS));
                }
                return;
            }
            synchronized (this) {
                he.this.f34649b.remove(Integer.valueOf(JobRequest.a(this.f34657a.f36512a)));
            }
        }
    }

    public he(Context context) {
        this.f34648a = new WeakReference<>(context);
    }

    public boolean a(JobRequest jobRequest, long j2) {
        Context context = this.f34648a.get();
        if (context == null) {
            return false;
        }
        return new a(jobRequest, j2).a(context, jobRequest.f36512a, new b(this, jobRequest), (Bundle) null);
    }

    public boolean a(JobRequest jobRequest, Long l2, Long l3) {
        Context context = this.f34648a.get();
        if (context == null) {
            return false;
        }
        long longValue = l2 != null ? l2.longValue() : 0;
        return new c(jobRequest, longValue).a(context, jobRequest.f36512a, new d(jobRequest, longValue), (Bundle) null);
    }

    public synchronized boolean a(int i2) {
        Future future = this.f34649b.get(Integer.valueOf(i2));
        if (future == null) {
            return false;
        }
        this.f34649b.remove(Integer.valueOf(i2));
        return future.cancel(true);
    }
}
