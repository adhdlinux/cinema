package com.chartboost.sdk.impl;

import java.io.FileDescriptor;
import java.io.RandomAccessFile;
import kotlin.jvm.internal.Intrinsics;

public final class s9 {

    /* renamed from: a  reason: collision with root package name */
    public final RandomAccessFile f18570a;

    /* renamed from: b  reason: collision with root package name */
    public final FileDescriptor f18571b;

    public s9(RandomAccessFile randomAccessFile) {
        Intrinsics.f(randomAccessFile, "randomAccessFile");
        this.f18570a = randomAccessFile;
        FileDescriptor fd = randomAccessFile.getFD();
        Intrinsics.e(fd, "randomAccessFile.fd");
        this.f18571b = fd;
    }

    public final void a() {
        this.f18570a.close();
    }

    public final FileDescriptor b() {
        return this.f18571b;
    }

    public final long c() {
        return this.f18570a.length();
    }
}
