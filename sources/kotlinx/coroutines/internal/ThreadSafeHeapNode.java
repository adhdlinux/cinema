package kotlinx.coroutines.internal;

public interface ThreadSafeHeapNode {
    void a(ThreadSafeHeap<?> threadSafeHeap);

    ThreadSafeHeap<?> c();

    int getIndex();

    void setIndex(int i2);
}
