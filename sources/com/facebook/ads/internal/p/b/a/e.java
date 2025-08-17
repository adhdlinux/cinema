package com.facebook.ads.internal.p.b.a;

import android.util.Log;
import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

abstract class e implements a {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f20482a = Executors.newSingleThreadExecutor();

    private class a implements Callable<Void> {

        /* renamed from: b  reason: collision with root package name */
        private final File f20484b;

        public a(File file) {
            this.f20484b = file;
        }

        /* renamed from: a */
        public Void call() {
            e.this.b(this.f20484b);
            return null;
        }
    }

    e() {
    }

    private void a(List<File> list) {
        long b2 = b(list);
        int size = list.size();
        for (File next : list) {
            if (!a(next, b2, size)) {
                long length = next.length();
                if (next.delete()) {
                    size--;
                    b2 -= length;
                    Log.i("ProxyCache", "Cache file " + next + " is deleted because it exceeds cache limit");
                } else {
                    Log.e("ProxyCache", "Error deleting file " + next + " for trimming cache");
                }
            }
        }
    }

    private long b(List<File> list) {
        long j2 = 0;
        for (File length : list) {
            j2 += length.length();
        }
        return j2;
    }

    /* access modifiers changed from: private */
    public void b(File file) {
        d.c(file);
        a(d.b(file.getParentFile()));
    }

    public void a(File file) {
        this.f20482a.submit(new a(file));
    }

    /* access modifiers changed from: protected */
    public abstract boolean a(File file, long j2, int i2);
}
