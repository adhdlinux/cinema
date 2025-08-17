package com.google.android.exoplayer2.offline;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.offline.Downloader;
import com.google.android.exoplayer2.scheduler.Requirements;
import com.google.android.exoplayer2.scheduler.RequirementsWatcher;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;

public final class DownloadManager {

    /* renamed from: q  reason: collision with root package name */
    public static final Requirements f25527q = new Requirements(1);

    /* renamed from: a  reason: collision with root package name */
    private final Context f25528a;

    /* renamed from: b  reason: collision with root package name */
    private final WritableDownloadIndex f25529b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f25530c;

    /* renamed from: d  reason: collision with root package name */
    private final InternalHandler f25531d;

    /* renamed from: e  reason: collision with root package name */
    private final RequirementsWatcher.Listener f25532e;

    /* renamed from: f  reason: collision with root package name */
    private final CopyOnWriteArraySet<Listener> f25533f;

    /* renamed from: g  reason: collision with root package name */
    private int f25534g;

    /* renamed from: h  reason: collision with root package name */
    private int f25535h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f25536i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f25537j;

    /* renamed from: k  reason: collision with root package name */
    private int f25538k;

    /* renamed from: l  reason: collision with root package name */
    private int f25539l;

    /* renamed from: m  reason: collision with root package name */
    private int f25540m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f25541n;

    /* renamed from: o  reason: collision with root package name */
    private List<Download> f25542o;

    /* renamed from: p  reason: collision with root package name */
    private RequirementsWatcher f25543p;

    private static final class DownloadUpdate {

        /* renamed from: a  reason: collision with root package name */
        public final Download f25544a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f25545b;

        /* renamed from: c  reason: collision with root package name */
        public final List<Download> f25546c;

        /* renamed from: d  reason: collision with root package name */
        public final Exception f25547d;

        public DownloadUpdate(Download download, boolean z2, List<Download> list, Exception exc) {
            this.f25544a = download;
            this.f25545b = z2;
            this.f25546c = list;
            this.f25547d = exc;
        }
    }

    private static final class InternalHandler extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public boolean f25548a;

        /* renamed from: b  reason: collision with root package name */
        private final HandlerThread f25549b;

        /* renamed from: c  reason: collision with root package name */
        private final WritableDownloadIndex f25550c;

        /* renamed from: d  reason: collision with root package name */
        private final DownloaderFactory f25551d;

        /* renamed from: e  reason: collision with root package name */
        private final Handler f25552e;

        /* renamed from: f  reason: collision with root package name */
        private final ArrayList<Download> f25553f = new ArrayList<>();

        /* renamed from: g  reason: collision with root package name */
        private final HashMap<String, Task> f25554g = new HashMap<>();

        /* renamed from: h  reason: collision with root package name */
        private int f25555h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f25556i;

        /* renamed from: j  reason: collision with root package name */
        private int f25557j;

        /* renamed from: k  reason: collision with root package name */
        private int f25558k;

        /* renamed from: l  reason: collision with root package name */
        private int f25559l;

        /* renamed from: m  reason: collision with root package name */
        private boolean f25560m;

        public InternalHandler(HandlerThread handlerThread, WritableDownloadIndex writableDownloadIndex, DownloaderFactory downloaderFactory, Handler handler, int i2, int i3, boolean z2) {
            super(handlerThread.getLooper());
            this.f25549b = handlerThread;
            this.f25550c = writableDownloadIndex;
            this.f25551d = downloaderFactory;
            this.f25552e = handler;
            this.f25557j = i2;
            this.f25558k = i3;
            this.f25556i = z2;
        }

        private void A(Task task) {
            if (task != null) {
                Assertions.g(!task.f25564e);
                task.f(false);
            }
        }

        private void B() {
            int i2 = 0;
            for (int i3 = 0; i3 < this.f25553f.size(); i3++) {
                Download download = this.f25553f.get(i3);
                Task task = this.f25554g.get(download.f25519a.f25572b);
                int i4 = download.f25520b;
                if (i4 == 0) {
                    task = y(task, download);
                } else if (i4 == 1) {
                    A(task);
                } else if (i4 == 2) {
                    Assertions.e(task);
                    x(task, download, i2);
                } else if (i4 == 5 || i4 == 7) {
                    z(task, download);
                } else {
                    throw new IllegalStateException();
                }
                if (task != null && !task.f25564e) {
                    i2++;
                }
            }
        }

        private void C() {
            for (int i2 = 0; i2 < this.f25553f.size(); i2++) {
                Download download = this.f25553f.get(i2);
                if (download.f25520b == 2) {
                    try {
                        this.f25550c.h(download);
                    } catch (IOException e2) {
                        Log.d("DownloadManager", "Failed to update index.", e2);
                    }
                }
            }
            sendEmptyMessageDelayed(11, 5000);
        }

        private void b(DownloadRequest downloadRequest, int i2) {
            int i3;
            Download f2 = f(downloadRequest.f25572b, true);
            long currentTimeMillis = System.currentTimeMillis();
            if (f2 != null) {
                m(DownloadManager.n(f2, downloadRequest, i2, currentTimeMillis));
            } else {
                if (i2 != 0) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                m(new Download(downloadRequest, i3, currentTimeMillis, currentTimeMillis, -1, i2, 0));
            }
            B();
        }

        private boolean c() {
            return !this.f25556i && this.f25555h == 0;
        }

        /* access modifiers changed from: private */
        public static int d(Download download, Download download2) {
            return Util.o(download.f25521c, download2.f25521c);
        }

        private static Download e(Download download, int i2, int i3) {
            return new Download(download.f25519a, i2, download.f25521c, System.currentTimeMillis(), download.f25523e, i3, 0, download.f25526h);
        }

        private Download f(String str, boolean z2) {
            int g2 = g(str);
            if (g2 != -1) {
                return this.f25553f.get(g2);
            }
            if (!z2) {
                return null;
            }
            try {
                return this.f25550c.g(str);
            } catch (IOException e2) {
                Log.d("DownloadManager", "Failed to load download: " + str, e2);
                return null;
            }
        }

        private int g(String str) {
            for (int i2 = 0; i2 < this.f25553f.size(); i2++) {
                if (this.f25553f.get(i2).f25519a.f25572b.equals(str)) {
                    return i2;
                }
            }
            return -1;
        }

        private void h(int i2) {
            this.f25555h = i2;
            DownloadCursor downloadCursor = null;
            try {
                this.f25550c.f();
                downloadCursor = this.f25550c.d(0, 1, 2, 5, 7);
                while (downloadCursor.moveToNext()) {
                    this.f25553f.add(downloadCursor.I());
                }
            } catch (IOException e2) {
                Log.d("DownloadManager", "Failed to load index.", e2);
                this.f25553f.clear();
            } catch (Throwable th) {
                Util.n((Closeable) null);
                throw th;
            }
            Util.n(downloadCursor);
            this.f25552e.obtainMessage(0, new ArrayList(this.f25553f)).sendToTarget();
            B();
        }

        private void i(Task task, long j2) {
            Download download = (Download) Assertions.e(f(task.f25561b.f25572b, false));
            if (j2 != download.f25523e && j2 != -1) {
                m(new Download(download.f25519a, download.f25520b, download.f25521c, System.currentTimeMillis(), j2, download.f25524f, download.f25525g, download.f25526h));
            }
        }

        private void j(Download download, Exception exc) {
            int i2;
            int i3;
            Download download2 = download;
            Exception exc2 = exc;
            DownloadRequest downloadRequest = download2.f25519a;
            if (exc2 == null) {
                i2 = 3;
            } else {
                i2 = 4;
            }
            long j2 = download2.f25521c;
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = download2.f25523e;
            int i4 = download2.f25524f;
            if (exc2 == null) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            Download download3 = new Download(downloadRequest, i2, j2, currentTimeMillis, j3, i4, i3, download2.f25526h);
            this.f25553f.remove(g(download3.f25519a.f25572b));
            try {
                this.f25550c.h(download3);
            } catch (IOException e2) {
                Log.d("DownloadManager", "Failed to update index.", e2);
            }
            this.f25552e.obtainMessage(2, new DownloadUpdate(download3, false, new ArrayList(this.f25553f), exc2)).sendToTarget();
        }

        private void k(Download download) {
            int i2 = 1;
            if (download.f25520b == 7) {
                int i3 = download.f25524f;
                if (i3 == 0) {
                    i2 = 0;
                }
                n(download, i2, i3);
                B();
                return;
            }
            this.f25553f.remove(g(download.f25519a.f25572b));
            try {
                this.f25550c.b(download.f25519a.f25572b);
            } catch (IOException unused) {
                Log.c("DownloadManager", "Failed to remove from database");
            }
            this.f25552e.obtainMessage(2, new DownloadUpdate(download, true, new ArrayList(this.f25553f), (Exception) null)).sendToTarget();
        }

        private void l(Task task) {
            String str = task.f25561b.f25572b;
            this.f25554g.remove(str);
            boolean b2 = task.f25564e;
            if (b2) {
                this.f25560m = false;
            } else {
                int i2 = this.f25559l - 1;
                this.f25559l = i2;
                if (i2 == 0) {
                    removeMessages(11);
                }
            }
            if (task.f25567h) {
                B();
                return;
            }
            Exception e2 = task.f25568i;
            if (e2 != null) {
                Log.d("DownloadManager", "Task failed: " + task.f25561b + ", " + b2, e2);
            }
            Download download = (Download) Assertions.e(f(str, false));
            int i3 = download.f25520b;
            if (i3 == 2) {
                Assertions.g(!b2);
                j(download, e2);
            } else if (i3 == 5 || i3 == 7) {
                Assertions.g(b2);
                k(download);
            } else {
                throw new IllegalStateException();
            }
            B();
        }

        private Download m(Download download) {
            boolean z2;
            int i2 = download.f25520b;
            boolean z3 = true;
            if (i2 == 3 || i2 == 4) {
                z2 = false;
            } else {
                z2 = true;
            }
            Assertions.g(z2);
            int g2 = g(download.f25519a.f25572b);
            if (g2 == -1) {
                this.f25553f.add(download);
                Collections.sort(this.f25553f, new d());
            } else {
                if (download.f25521c == this.f25553f.get(g2).f25521c) {
                    z3 = false;
                }
                this.f25553f.set(g2, download);
                if (z3) {
                    Collections.sort(this.f25553f, new d());
                }
            }
            try {
                this.f25550c.h(download);
            } catch (IOException e2) {
                Log.d("DownloadManager", "Failed to update index.", e2);
            }
            this.f25552e.obtainMessage(2, new DownloadUpdate(download, false, new ArrayList(this.f25553f), (Exception) null)).sendToTarget();
            return download;
        }

        private Download n(Download download, int i2, int i3) {
            boolean z2;
            if (i2 == 3 || i2 == 4) {
                z2 = false;
            } else {
                z2 = true;
            }
            Assertions.g(z2);
            return m(e(download, i2, i3));
        }

        private void o() {
            for (Task f2 : this.f25554g.values()) {
                f2.f(true);
            }
            try {
                this.f25550c.f();
            } catch (IOException e2) {
                Log.d("DownloadManager", "Failed to update index.", e2);
            }
            this.f25553f.clear();
            this.f25549b.quit();
            synchronized (this) {
                this.f25548a = true;
                notifyAll();
            }
        }

        private void p() {
            DownloadCursor d2;
            ArrayList arrayList = new ArrayList();
            try {
                d2 = this.f25550c.d(3, 4);
                while (d2.moveToNext()) {
                    arrayList.add(d2.I());
                }
                d2.close();
            } catch (IOException unused) {
                Log.c("DownloadManager", "Failed to load downloads.");
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
            for (int i2 = 0; i2 < this.f25553f.size(); i2++) {
                ArrayList<Download> arrayList2 = this.f25553f;
                arrayList2.set(i2, e(arrayList2.get(i2), 5, 0));
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                this.f25553f.add(e((Download) arrayList.get(i3), 5, 0));
            }
            Collections.sort(this.f25553f, new d());
            try {
                this.f25550c.e();
            } catch (IOException e2) {
                Log.d("DownloadManager", "Failed to update index.", e2);
            }
            ArrayList arrayList3 = new ArrayList(this.f25553f);
            for (int i4 = 0; i4 < this.f25553f.size(); i4++) {
                this.f25552e.obtainMessage(2, new DownloadUpdate(this.f25553f.get(i4), false, arrayList3, (Exception) null)).sendToTarget();
            }
            B();
            return;
            throw th;
        }

        private void q(String str) {
            Download f2 = f(str, true);
            if (f2 == null) {
                Log.c("DownloadManager", "Failed to remove nonexistent download: " + str);
                return;
            }
            n(f2, 5, 0);
            B();
        }

        private void r(boolean z2) {
            this.f25556i = z2;
            B();
        }

        private void s(int i2) {
            this.f25557j = i2;
            B();
        }

        private void t(int i2) {
            this.f25558k = i2;
        }

        private void u(int i2) {
            this.f25555h = i2;
            B();
        }

        private void v(Download download, int i2) {
            Download download2 = download;
            int i3 = i2;
            if (i3 == 0) {
                if (download2.f25520b == 1) {
                    n(download, 0, 0);
                }
            } else if (i3 != download2.f25524f) {
                int i4 = download2.f25520b;
                if (i4 == 0 || i4 == 2) {
                    i4 = 1;
                }
                m(new Download(download2.f25519a, i4, download2.f25521c, System.currentTimeMillis(), download2.f25523e, i2, 0, download2.f25526h));
            }
        }

        private void w(String str, int i2) {
            if (str == null) {
                for (int i3 = 0; i3 < this.f25553f.size(); i3++) {
                    v(this.f25553f.get(i3), i2);
                }
                try {
                    this.f25550c.c(i2);
                } catch (IOException e2) {
                    Log.d("DownloadManager", "Failed to set manual stop reason", e2);
                }
            } else {
                Download f2 = f(str, false);
                if (f2 != null) {
                    v(f2, i2);
                } else {
                    try {
                        this.f25550c.a(str, i2);
                    } catch (IOException e3) {
                        Log.d("DownloadManager", "Failed to set manual stop reason: " + str, e3);
                    }
                }
            }
            B();
        }

        private void x(Task task, Download download, int i2) {
            Assertions.g(!task.f25564e);
            if (!c() || i2 >= this.f25557j) {
                n(download, 0, 0);
                task.f(false);
            }
        }

        private Task y(Task task, Download download) {
            if (task != null) {
                Assertions.g(!task.f25564e);
                task.f(false);
                return task;
            } else if (!c() || this.f25559l >= this.f25557j) {
                return null;
            } else {
                Download n2 = n(download, 2, 0);
                Task task2 = new Task(n2.f25519a, this.f25551d.a(n2.f25519a), n2.f25526h, false, this.f25558k, this);
                this.f25554g.put(n2.f25519a.f25572b, task2);
                int i2 = this.f25559l;
                this.f25559l = i2 + 1;
                if (i2 == 0) {
                    sendEmptyMessageDelayed(11, 5000);
                }
                task2.start();
                return task2;
            }
        }

        private void z(Task task, Download download) {
            if (task != null) {
                if (!task.f25564e) {
                    task.f(false);
                }
            } else if (!this.f25560m) {
                Task task2 = new Task(download.f25519a, this.f25551d.a(download.f25519a), download.f25526h, true, this.f25558k, this);
                this.f25554g.put(download.f25519a.f25572b, task2);
                this.f25560m = true;
                task2.start();
            }
        }

        public void handleMessage(Message message) {
            boolean z2 = false;
            switch (message.what) {
                case 0:
                    h(message.arg1);
                    break;
                case 1:
                    if (message.arg1 != 0) {
                        z2 = true;
                    }
                    r(z2);
                    break;
                case 2:
                    u(message.arg1);
                    break;
                case 3:
                    w((String) message.obj, message.arg1);
                    break;
                case 4:
                    s(message.arg1);
                    break;
                case 5:
                    t(message.arg1);
                    break;
                case 6:
                    b((DownloadRequest) message.obj, message.arg1);
                    break;
                case 7:
                    q((String) message.obj);
                    break;
                case 8:
                    p();
                    break;
                case 9:
                    l((Task) message.obj);
                    break;
                case 10:
                    i((Task) message.obj, Util.e1(message.arg1, message.arg2));
                    return;
                case 11:
                    C();
                    return;
                case 12:
                    o();
                    return;
                default:
                    throw new IllegalStateException();
            }
            z2 = true;
            this.f25552e.obtainMessage(1, z2 ? 1 : 0, this.f25554g.size()).sendToTarget();
        }
    }

    public interface Listener {
        void onDownloadChanged(DownloadManager downloadManager, Download download, Exception exc);

        void onDownloadRemoved(DownloadManager downloadManager, Download download);

        void onDownloadsPausedChanged(DownloadManager downloadManager, boolean z2);

        void onIdle(DownloadManager downloadManager);

        void onInitialized(DownloadManager downloadManager);

        void onRequirementsStateChanged(DownloadManager downloadManager, Requirements requirements, int i2);

        void onWaitingForRequirementsChanged(DownloadManager downloadManager, boolean z2);
    }

    private static class Task extends Thread implements Downloader.ProgressListener {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final DownloadRequest f25561b;

        /* renamed from: c  reason: collision with root package name */
        private final Downloader f25562c;

        /* renamed from: d  reason: collision with root package name */
        private final DownloadProgress f25563d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public final boolean f25564e;

        /* renamed from: f  reason: collision with root package name */
        private final int f25565f;

        /* renamed from: g  reason: collision with root package name */
        private volatile InternalHandler f25566g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f25567h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public Exception f25568i;

        /* renamed from: j  reason: collision with root package name */
        private long f25569j;

        private static int g(int i2) {
            return Math.min((i2 - 1) * 1000, 5000);
        }

        public void a(long j2, long j3, float f2) {
            this.f25563d.f25570a = j3;
            this.f25563d.f25571b = f2;
            if (j2 != this.f25569j) {
                this.f25569j = j2;
                InternalHandler internalHandler = this.f25566g;
                if (internalHandler != null) {
                    internalHandler.obtainMessage(10, (int) (j2 >> 32), (int) j2, this).sendToTarget();
                }
            }
        }

        public void f(boolean z2) {
            if (z2) {
                this.f25566g = null;
            }
            if (!this.f25567h) {
                this.f25567h = true;
                this.f25562c.cancel();
                interrupt();
            }
        }

        public void run() {
            long j2;
            int i2;
            try {
                if (this.f25564e) {
                    this.f25562c.remove();
                } else {
                    j2 = -1;
                    i2 = 0;
                    while (!this.f25567h) {
                        this.f25562c.a(this);
                    }
                }
            } catch (IOException e2) {
                if (!this.f25567h) {
                    long j3 = this.f25563d.f25570a;
                    if (j3 != j2) {
                        j2 = j3;
                        i2 = 0;
                    }
                    i2++;
                    if (i2 <= this.f25565f) {
                        Thread.sleep((long) g(i2));
                    } else {
                        throw e2;
                    }
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (Exception e3) {
                this.f25568i = e3;
            }
            InternalHandler internalHandler = this.f25566g;
            if (internalHandler != null) {
                internalHandler.obtainMessage(9, this).sendToTarget();
            }
        }

        private Task(DownloadRequest downloadRequest, Downloader downloader, DownloadProgress downloadProgress, boolean z2, int i2, InternalHandler internalHandler) {
            this.f25561b = downloadRequest;
            this.f25562c = downloader;
            this.f25563d = downloadProgress;
            this.f25564e = z2;
            this.f25565f = i2;
            this.f25566g = internalHandler;
            this.f25569j = -1;
        }
    }

    public DownloadManager(Context context, DatabaseProvider databaseProvider, Cache cache, DataSource.Factory factory, Executor executor) {
        this(context, new DefaultDownloadIndex(databaseProvider), new DefaultDownloaderFactory(new CacheDataSource.Factory().i(cache).k(factory), executor));
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean B() {
        /*
            r4 = this;
            boolean r0 = r4.f25537j
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0024
            int r0 = r4.f25540m
            if (r0 == 0) goto L_0x0024
            r0 = 0
        L_0x000b:
            java.util.List<com.google.android.exoplayer2.offline.Download> r3 = r4.f25542o
            int r3 = r3.size()
            if (r0 >= r3) goto L_0x0024
            java.util.List<com.google.android.exoplayer2.offline.Download> r3 = r4.f25542o
            java.lang.Object r3 = r3.get(r0)
            com.google.android.exoplayer2.offline.Download r3 = (com.google.android.exoplayer2.offline.Download) r3
            int r3 = r3.f25520b
            if (r3 != 0) goto L_0x0021
            r0 = 1
            goto L_0x0025
        L_0x0021:
            int r0 = r0 + 1
            goto L_0x000b
        L_0x0024:
            r0 = 0
        L_0x0025:
            boolean r3 = r4.f25541n
            if (r3 == r0) goto L_0x002a
            goto L_0x002b
        L_0x002a:
            r1 = 0
        L_0x002b:
            r4.f25541n = r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.offline.DownloadManager.B():boolean");
    }

    /* access modifiers changed from: private */
    public boolean j(Message message) {
        int i2 = message.what;
        if (i2 == 0) {
            q((List) message.obj);
        } else if (i2 == 1) {
            r(message.arg1, message.arg2);
        } else if (i2 == 2) {
            p((DownloadUpdate) message.obj);
        } else {
            throw new IllegalStateException();
        }
        return true;
    }

    static Download n(Download download, DownloadRequest downloadRequest, int i2, long j2) {
        long j3;
        int i3;
        Download download2 = download;
        int i4 = download2.f25520b;
        if (i4 == 5 || download.c()) {
            j3 = j2;
        } else {
            j3 = download2.f25521c;
        }
        if (i4 == 5 || i4 == 7) {
            i3 = 7;
        } else if (i2 != 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        return new Download(download2.f25519a.b(downloadRequest), i3, j3, j2, -1, i2, 0);
    }

    private void o() {
        Iterator<Listener> it2 = this.f25533f.iterator();
        while (it2.hasNext()) {
            it2.next().onWaitingForRequirementsChanged(this, this.f25541n);
        }
    }

    private void p(DownloadUpdate downloadUpdate) {
        this.f25542o = Collections.unmodifiableList(downloadUpdate.f25546c);
        Download download = downloadUpdate.f25544a;
        boolean B = B();
        if (downloadUpdate.f25545b) {
            Iterator<Listener> it2 = this.f25533f.iterator();
            while (it2.hasNext()) {
                it2.next().onDownloadRemoved(this, download);
            }
        } else {
            Iterator<Listener> it3 = this.f25533f.iterator();
            while (it3.hasNext()) {
                it3.next().onDownloadChanged(this, download, downloadUpdate.f25547d);
            }
        }
        if (B) {
            o();
        }
    }

    private void q(List<Download> list) {
        this.f25536i = true;
        this.f25542o = Collections.unmodifiableList(list);
        boolean B = B();
        Iterator<Listener> it2 = this.f25533f.iterator();
        while (it2.hasNext()) {
            it2.next().onInitialized(this);
        }
        if (B) {
            o();
        }
    }

    private void r(int i2, int i3) {
        this.f25534g -= i2;
        this.f25535h = i3;
        if (k()) {
            Iterator<Listener> it2 = this.f25533f.iterator();
            while (it2.hasNext()) {
                it2.next().onIdle(this);
            }
        }
    }

    /* access modifiers changed from: private */
    public void s(RequirementsWatcher requirementsWatcher, int i2) {
        Requirements f2 = requirementsWatcher.f();
        if (this.f25540m != i2) {
            this.f25540m = i2;
            this.f25534g++;
            this.f25531d.obtainMessage(2, i2, 0).sendToTarget();
        }
        boolean B = B();
        Iterator<Listener> it2 = this.f25533f.iterator();
        while (it2.hasNext()) {
            it2.next().onRequirementsStateChanged(this, f2, i2);
        }
        if (B) {
            o();
        }
    }

    private void x(boolean z2) {
        if (this.f25537j != z2) {
            this.f25537j = z2;
            this.f25534g++;
            this.f25531d.obtainMessage(1, z2 ? 1 : 0, 0).sendToTarget();
            boolean B = B();
            Iterator<Listener> it2 = this.f25533f.iterator();
            while (it2.hasNext()) {
                it2.next().onDownloadsPausedChanged(this, z2);
            }
            if (B) {
                o();
            }
        }
    }

    public void A(String str, int i2) {
        this.f25534g++;
        this.f25531d.obtainMessage(3, i2, 0, str).sendToTarget();
    }

    public void c(DownloadRequest downloadRequest, int i2) {
        this.f25534g++;
        this.f25531d.obtainMessage(6, i2, 0, downloadRequest).sendToTarget();
    }

    public void d(Listener listener) {
        Assertions.e(listener);
        this.f25533f.add(listener);
    }

    public List<Download> e() {
        return this.f25542o;
    }

    public DownloadIndex f() {
        return this.f25529b;
    }

    public boolean g() {
        return this.f25537j;
    }

    public int h() {
        return this.f25540m;
    }

    public Requirements i() {
        return this.f25543p.f();
    }

    public boolean k() {
        return this.f25535h == 0 && this.f25534g == 0;
    }

    public boolean l() {
        return this.f25536i;
    }

    public boolean m() {
        return this.f25541n;
    }

    public void t() {
        x(true);
    }

    public void u() {
        this.f25534g++;
        this.f25531d.obtainMessage(8).sendToTarget();
    }

    public void v(String str) {
        this.f25534g++;
        this.f25531d.obtainMessage(7, str).sendToTarget();
    }

    public void w() {
        x(false);
    }

    public void y(int i2) {
        boolean z2;
        if (i2 > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        if (this.f25538k != i2) {
            this.f25538k = i2;
            this.f25534g++;
            this.f25531d.obtainMessage(4, i2, 0).sendToTarget();
        }
    }

    public void z(Requirements requirements) {
        if (!requirements.equals(this.f25543p.f())) {
            this.f25543p.j();
            RequirementsWatcher requirementsWatcher = new RequirementsWatcher(this.f25528a, this.f25532e, requirements);
            this.f25543p = requirementsWatcher;
            s(this.f25543p, requirementsWatcher.i());
        }
    }

    public DownloadManager(Context context, WritableDownloadIndex writableDownloadIndex, DownloaderFactory downloaderFactory) {
        this.f25528a = context.getApplicationContext();
        this.f25529b = writableDownloadIndex;
        this.f25538k = 3;
        this.f25539l = 5;
        this.f25537j = true;
        this.f25542o = Collections.emptyList();
        this.f25533f = new CopyOnWriteArraySet<>();
        Handler z2 = Util.z(new b(this));
        this.f25530c = z2;
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:DownloadManager");
        handlerThread.start();
        InternalHandler internalHandler = new InternalHandler(handlerThread, writableDownloadIndex, downloaderFactory, z2, this.f25538k, this.f25539l, this.f25537j);
        this.f25531d = internalHandler;
        c cVar = new c(this);
        this.f25532e = cVar;
        RequirementsWatcher requirementsWatcher = new RequirementsWatcher(context, cVar, f25527q);
        this.f25543p = requirementsWatcher;
        int i2 = requirementsWatcher.i();
        this.f25540m = i2;
        this.f25534g = 1;
        internalHandler.obtainMessage(0, i2, 0).sendToTarget();
    }
}
