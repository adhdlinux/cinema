package androidx.room.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CopyLock {

    /* renamed from: e  reason: collision with root package name */
    private static final Map<String, Lock> f11529e = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    private final File f11530a;

    /* renamed from: b  reason: collision with root package name */
    private final Lock f11531b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f11532c;

    /* renamed from: d  reason: collision with root package name */
    private FileChannel f11533d;

    public CopyLock(String str, File file, boolean z2) {
        File file2 = new File(file, str + ".lck");
        this.f11530a = file2;
        this.f11531b = a(file2.getAbsolutePath());
        this.f11532c = z2;
    }

    private static Lock a(String str) {
        Lock lock;
        Map<String, Lock> map = f11529e;
        synchronized (map) {
            lock = map.get(str);
            if (lock == null) {
                lock = new ReentrantLock();
                map.put(str, lock);
            }
        }
        return lock;
    }

    public void b() {
        this.f11531b.lock();
        if (this.f11532c) {
            try {
                FileChannel channel = new FileOutputStream(this.f11530a).getChannel();
                this.f11533d = channel;
                channel.lock();
            } catch (IOException e2) {
                throw new IllegalStateException("Unable to grab copy lock.", e2);
            }
        }
    }

    public void c() {
        FileChannel fileChannel = this.f11533d;
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } catch (IOException unused) {
            }
        }
        this.f11531b.unlock();
    }
}
