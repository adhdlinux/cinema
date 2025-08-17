package com.facebook.soloader;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;

public final class FileLocker implements Closeable {
    private FileLock mLock;
    private FileOutputStream mLockFileOutputStream;

    private FileLocker(File file, boolean z2) throws IOException {
        init(file, z2);
    }

    private void init(File file, boolean z2) throws IOException {
        FileLock fileLock;
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        this.mLockFileOutputStream = fileOutputStream;
        if (z2) {
            try {
                fileLock = fileOutputStream.getChannel().tryLock();
            } catch (IOException unused) {
                fileLock = null;
            }
        } else {
            try {
                fileLock = fileOutputStream.getChannel().lock();
            } catch (Throwable th) {
                this.mLockFileOutputStream.close();
                throw th;
            }
        }
        if (fileLock == null) {
            this.mLockFileOutputStream.close();
        }
        this.mLock = fileLock;
    }

    public static FileLocker lock(File file) throws IOException {
        return new FileLocker(file, false);
    }

    public static FileLocker tryLock(File file) throws IOException {
        FileLocker fileLocker = new FileLocker(file, true);
        if (fileLocker.mLock != null) {
            return fileLocker;
        }
        fileLocker.close();
        return null;
    }

    public void close() throws IOException {
        try {
            FileLock fileLock = this.mLock;
            if (fileLock != null) {
                fileLock.release();
            }
        } finally {
            this.mLockFileOutputStream.close();
        }
    }
}
