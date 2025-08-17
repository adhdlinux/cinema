package us.shandian.giga.get;

import android.os.Handler;
import android.os.Looper;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import us.shandian.giga.util.Utility;

public class DownloadMission implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public String f42190b;

    /* renamed from: c  reason: collision with root package name */
    public String f42191c;

    /* renamed from: d  reason: collision with root package name */
    public String f42192d;

    /* renamed from: e  reason: collision with root package name */
    public long f42193e;

    /* renamed from: f  reason: collision with root package name */
    public long f42194f;

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, String> f42195g;

    /* renamed from: h  reason: collision with root package name */
    public String f42196h;

    /* renamed from: i  reason: collision with root package name */
    public long f42197i;

    /* renamed from: j  reason: collision with root package name */
    public int f42198j = 3;

    /* renamed from: k  reason: collision with root package name */
    public int f42199k;

    /* renamed from: l  reason: collision with root package name */
    private List<Long> f42200l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    public final Map<Long, Boolean> f42201m = new HashMap();

    /* renamed from: n  reason: collision with root package name */
    public boolean f42202n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f42203o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f42204p;

    /* renamed from: q  reason: collision with root package name */
    public int f42205q = -1;

    /* renamed from: r  reason: collision with root package name */
    public long f42206r;

    /* renamed from: s  reason: collision with root package name */
    public transient boolean f42207s;

    /* renamed from: t  reason: collision with root package name */
    private transient ArrayList<WeakReference<MissionListener>> f42208t = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public transient boolean f42209u;

    public interface MissionListener {

        /* renamed from: a  reason: collision with root package name */
        public static final HashMap<MissionListener, Handler> f42217a = new HashMap<>();

        void a(DownloadMission downloadMission);

        void b(DownloadMission downloadMission, int i2);

        void c(DownloadMission downloadMission, long j2, long j3);
    }

    public DownloadMission() {
    }

    private void d(long j2) {
        if (j2 < 0 || j2 >= this.f42193e) {
            throw new IllegalArgumentException("illegal block identifier");
        }
    }

    private void f() {
        new File(i()).delete();
    }

    /* access modifiers changed from: private */
    public void g() {
        synchronized (this.f42201m) {
            Utility.j(i(), this);
        }
    }

    private String i() {
        return this.f42192d + "/" + this.f42190b + ".giga";
    }

    private void o() {
        if (this.f42205q <= 0) {
            this.f42202n = false;
            this.f42203o = true;
            f();
            Iterator<WeakReference<MissionListener>> it2 = this.f42208t.iterator();
            while (it2.hasNext()) {
                final MissionListener missionListener = (MissionListener) it2.next().get();
                if (missionListener != null) {
                    MissionListener.f42217a.get(missionListener).post(new Runnable() {
                        public void run() {
                            missionListener.a(DownloadMission.this);
                        }
                    });
                }
            }
        }
    }

    public synchronized void c(MissionListener missionListener) {
        MissionListener.f42217a.put(missionListener, new Handler(Looper.getMainLooper()));
        this.f42208t.add(new WeakReference(missionListener));
    }

    public void e() {
        f();
        new File(this.f42192d, this.f42190b).delete();
    }

    public File h() {
        return new File(this.f42192d, this.f42190b);
    }

    public long j(int i2) {
        return this.f42200l.get(i2).longValue();
    }

    public boolean k(long j2) {
        d(j2);
        if (this.f42201m.containsKey(Long.valueOf(j2))) {
            return this.f42201m.get(Long.valueOf(j2)).booleanValue();
        }
        return false;
    }

    public synchronized void l(int i2) {
        this.f42205q = i2;
        u();
        Iterator<WeakReference<MissionListener>> it2 = this.f42208t.iterator();
        while (it2.hasNext()) {
            final MissionListener missionListener = (MissionListener) it2.next().get();
            MissionListener.f42217a.get(missionListener).post(new Runnable() {
                public void run() {
                    MissionListener missionListener = missionListener;
                    DownloadMission downloadMission = DownloadMission.this;
                    missionListener.b(downloadMission, downloadMission.f42205q);
                }
            });
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0015, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m() {
        /*
            r2 = this;
            monitor-enter(r2)
            int r0 = r2.f42205q     // Catch:{ all -> 0x0016 }
            if (r0 <= 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            int r0 = r2.f42199k     // Catch:{ all -> 0x0016 }
            int r0 = r0 + 1
            r2.f42199k = r0     // Catch:{ all -> 0x0016 }
            int r1 = r2.f42198j     // Catch:{ all -> 0x0016 }
            if (r0 != r1) goto L_0x0014
            r2.o()     // Catch:{ all -> 0x0016 }
        L_0x0014:
            monitor-exit(r2)
            return
        L_0x0016:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: us.shandian.giga.get.DownloadMission.m():void");
    }

    public synchronized void n(long j2) {
        if (this.f42202n) {
            if (this.f42207s) {
                this.f42207s = false;
            }
            long j3 = this.f42197i + j2;
            this.f42197i = j3;
            long j4 = this.f42194f;
            if (j3 > j4) {
                this.f42197i = j4;
            }
            if (this.f42197i != j4) {
                u();
            }
            Iterator<WeakReference<MissionListener>> it2 = this.f42208t.iterator();
            while (it2.hasNext()) {
                final MissionListener missionListener = (MissionListener) it2.next().get();
                if (missionListener != null) {
                    MissionListener.f42217a.get(missionListener).post(new Runnable() {
                        public void run() {
                            MissionListener missionListener = missionListener;
                            DownloadMission downloadMission = DownloadMission.this;
                            missionListener.c(downloadMission, downloadMission.f42197i, downloadMission.f42194f);
                        }
                    });
                }
            }
        }
    }

    public void p() {
        if (this.f42202n) {
            this.f42202n = false;
            this.f42207s = true;
        }
    }

    public void q(long j2) {
        d(j2);
        synchronized (this.f42201m) {
            this.f42201m.put(Long.valueOf(j2), Boolean.TRUE);
        }
    }

    public synchronized void r(MissionListener missionListener) {
        Iterator<WeakReference<MissionListener>> it2 = this.f42208t.iterator();
        while (it2.hasNext()) {
            WeakReference next = it2.next();
            if (missionListener != null && missionListener == next.get()) {
                it2.remove();
            }
        }
    }

    public void s(int i2, long j2) {
        this.f42200l.set(i2, Long.valueOf(j2));
    }

    public void t() {
        if (!this.f42202n && !this.f42203o) {
            this.f42202n = true;
            if (!this.f42204p) {
                for (int i2 = 0; i2 < this.f42198j; i2++) {
                    if (this.f42200l.size() <= i2 && !this.f42207s) {
                        this.f42200l.add(Long.valueOf((long) i2));
                    }
                    new Thread(new DownloadRunnable(this, i2)).start();
                }
                return;
            }
            this.f42198j = 1;
            this.f42197i = 0;
            this.f42193e = 0;
            new Thread(new DownloadRunnableFallback(this)).start();
        }
    }

    public void u() {
        if (!this.f42209u) {
            this.f42209u = true;
            new Thread() {
                public void run() {
                    DownloadMission.this.g();
                    boolean unused = DownloadMission.this.f42209u = false;
                }
            }.start();
        }
    }

    public DownloadMission(String str, String str2, String str3, HashMap<String, String> hashMap) {
        if (str == null) {
            throw new NullPointerException("name is null");
        } else if (str.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        } else if (str2 == null) {
            throw new NullPointerException("url is null");
        } else if (str2.isEmpty()) {
            throw new IllegalArgumentException("url is empty");
        } else if (str3 == null) {
            throw new NullPointerException("location is null");
        } else if (!str3.isEmpty()) {
            this.f42191c = str2;
            this.f42190b = str;
            this.f42192d = str3;
            this.f42195g = hashMap;
        } else {
            throw new IllegalArgumentException("location is empty");
        }
    }
}
