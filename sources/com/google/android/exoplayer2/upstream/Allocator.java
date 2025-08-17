package com.google.android.exoplayer2.upstream;

public interface Allocator {

    public interface AllocationNode {
        Allocation a();

        AllocationNode next();
    }

    Allocation a();

    void b();

    int c();

    void d(AllocationNode allocationNode);

    void e(Allocation allocation);
}
