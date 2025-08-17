package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;

public final class QueueDrainHelper {
    private QueueDrainHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> boolean a(boolean z2, boolean z3, Observer<?> observer, boolean z4, SimpleQueue<?> simpleQueue, Disposable disposable, ObservableQueueDrain<T, U> observableQueueDrain) {
        if (observableQueueDrain.d()) {
            simpleQueue.clear();
            disposable.dispose();
            return true;
        } else if (!z2) {
            return false;
        } else {
            if (!z4) {
                Throwable e2 = observableQueueDrain.e();
                if (e2 != null) {
                    simpleQueue.clear();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    observer.onError(e2);
                    return true;
                } else if (!z3) {
                    return false;
                } else {
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    observer.onComplete();
                    return true;
                }
            } else if (!z3) {
                return false;
            } else {
                if (disposable != null) {
                    disposable.dispose();
                }
                Throwable e3 = observableQueueDrain.e();
                if (e3 != null) {
                    observer.onError(e3);
                } else {
                    observer.onComplete();
                }
                return true;
            }
        }
    }

    public static <T> SimpleQueue<T> b(int i2) {
        if (i2 < 0) {
            return new SpscLinkedArrayQueue(-i2);
        }
        return new SpscArrayQueue(i2);
    }

    public static <T, U> void c(SimplePlainQueue<T> simplePlainQueue, Observer<? super U> observer, boolean z2, Disposable disposable, ObservableQueueDrain<T, U> observableQueueDrain) {
        boolean z3;
        int i2 = 1;
        while (!a(observableQueueDrain.c(), simplePlainQueue.isEmpty(), observer, z2, simplePlainQueue, disposable, observableQueueDrain)) {
            while (true) {
                boolean c2 = observableQueueDrain.c();
                T poll = simplePlainQueue.poll();
                if (poll == null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!a(c2, z3, observer, z2, simplePlainQueue, disposable, observableQueueDrain)) {
                    if (z3) {
                        i2 = observableQueueDrain.b(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        observableQueueDrain.a(observer, poll);
                    }
                } else {
                    return;
                }
            }
        }
    }
}
