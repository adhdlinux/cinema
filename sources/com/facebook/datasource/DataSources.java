package com.facebook.datasource;

import com.facebook.common.internal.Supplier;
import com.facebook.infer.annotation.Nullsafe;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class DataSources {

    private static class ValueHolder<T> {
        public T value;

        private ValueHolder() {
            this.value = null;
        }
    }

    private DataSources() {
    }

    public static <T> Supplier<DataSource<T>> getFailedDataSourceSupplier(final Throwable th) {
        return new Supplier<DataSource<T>>() {
            public DataSource<T> get() {
                return DataSources.immediateFailedDataSource(th);
            }
        };
    }

    public static <T> DataSource<T> immediateDataSource(T t2) {
        SimpleDataSource create = SimpleDataSource.create();
        create.setResult(t2);
        return create;
    }

    public static <T> DataSource<T> immediateFailedDataSource(Throwable th) {
        SimpleDataSource create = SimpleDataSource.create();
        create.setFailure(th);
        return create;
    }

    public static <T> T waitForFinalResult(DataSource<T> dataSource) throws Throwable {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final ValueHolder valueHolder = new ValueHolder();
        final ValueHolder valueHolder2 = new ValueHolder();
        dataSource.subscribe(new DataSubscriber<T>() {
            public void onCancellation(DataSource<T> dataSource) {
                countDownLatch.countDown();
            }

            public void onFailure(DataSource<T> dataSource) {
                try {
                    valueHolder2.value = dataSource.getFailureCause();
                } finally {
                    countDownLatch.countDown();
                }
            }

            public void onNewResult(DataSource<T> dataSource) {
                if (dataSource.isFinished()) {
                    try {
                        valueHolder.value = dataSource.getResult();
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            }

            public void onProgressUpdate(DataSource<T> dataSource) {
            }
        }, new Executor() {
            public void execute(Runnable runnable) {
                runnable.run();
            }
        });
        countDownLatch.await();
        T t2 = valueHolder2.value;
        if (t2 == null) {
            return valueHolder.value;
        }
        throw ((Throwable) t2);
    }
}
