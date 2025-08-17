package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Network;
import android.net.Uri;
import androidx.annotation.Keep;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

public abstract class ListenableWorker {
    private Context mAppContext;
    private boolean mRunInForeground;
    private volatile boolean mStopped;
    private boolean mUsed;
    private WorkerParameters mWorkerParams;

    public static abstract class Result {

        public static final class Failure extends Result {

            /* renamed from: a  reason: collision with root package name */
            private final Data f12182a;

            public Failure() {
                this(Data.f12167c);
            }

            public Data e() {
                return this.f12182a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || Failure.class != obj.getClass()) {
                    return false;
                }
                return this.f12182a.equals(((Failure) obj).f12182a);
            }

            public int hashCode() {
                return (Failure.class.getName().hashCode() * 31) + this.f12182a.hashCode();
            }

            public String toString() {
                return "Failure {mOutputData=" + this.f12182a + '}';
            }

            public Failure(Data data) {
                this.f12182a = data;
            }
        }

        public static final class Retry extends Result {
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && Retry.class == obj.getClass();
            }

            public int hashCode() {
                return Retry.class.getName().hashCode();
            }

            public String toString() {
                return "Retry";
            }
        }

        public static final class Success extends Result {

            /* renamed from: a  reason: collision with root package name */
            private final Data f12183a;

            public Success() {
                this(Data.f12167c);
            }

            public Data e() {
                return this.f12183a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || Success.class != obj.getClass()) {
                    return false;
                }
                return this.f12183a.equals(((Success) obj).f12183a);
            }

            public int hashCode() {
                return (Success.class.getName().hashCode() * 31) + this.f12183a.hashCode();
            }

            public String toString() {
                return "Success {mOutputData=" + this.f12183a + '}';
            }

            public Success(Data data) {
                this.f12183a = data;
            }
        }

        Result() {
        }

        public static Result a() {
            return new Failure();
        }

        public static Result b() {
            return new Retry();
        }

        public static Result c() {
            return new Success();
        }

        public static Result d(Data data) {
            return new Success(data);
        }
    }

    @SuppressLint({"BanKeepAnnotation"})
    @Keep
    public ListenableWorker(Context context, WorkerParameters workerParameters) {
        if (context == null) {
            throw new IllegalArgumentException("Application Context is null");
        } else if (workerParameters != null) {
            this.mAppContext = context;
            this.mWorkerParams = workerParameters;
        } else {
            throw new IllegalArgumentException("WorkerParameters is null");
        }
    }

    public final Context getApplicationContext() {
        return this.mAppContext;
    }

    public Executor getBackgroundExecutor() {
        return this.mWorkerParams.a();
    }

    public ListenableFuture<ForegroundInfo> getForegroundInfoAsync() {
        SettableFuture s2 = SettableFuture.s();
        s2.p(new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for `getForegroundInfoAsync()`"));
        return s2;
    }

    public final UUID getId() {
        return this.mWorkerParams.c();
    }

    public final Data getInputData() {
        return this.mWorkerParams.d();
    }

    public final Network getNetwork() {
        return this.mWorkerParams.e();
    }

    public final int getRunAttemptCount() {
        return this.mWorkerParams.g();
    }

    public final Set<String> getTags() {
        return this.mWorkerParams.h();
    }

    public TaskExecutor getTaskExecutor() {
        return this.mWorkerParams.i();
    }

    public final List<String> getTriggeredContentAuthorities() {
        return this.mWorkerParams.j();
    }

    public final List<Uri> getTriggeredContentUris() {
        return this.mWorkerParams.k();
    }

    public WorkerFactory getWorkerFactory() {
        return this.mWorkerParams.l();
    }

    public boolean isRunInForeground() {
        return this.mRunInForeground;
    }

    public final boolean isStopped() {
        return this.mStopped;
    }

    public final boolean isUsed() {
        return this.mUsed;
    }

    public void onStopped() {
    }

    public final ListenableFuture<Void> setForegroundAsync(ForegroundInfo foregroundInfo) {
        this.mRunInForeground = true;
        return this.mWorkerParams.b().a(getApplicationContext(), getId(), foregroundInfo);
    }

    public ListenableFuture<Void> setProgressAsync(Data data) {
        return this.mWorkerParams.f().a(getApplicationContext(), getId(), data);
    }

    public void setRunInForeground(boolean z2) {
        this.mRunInForeground = z2;
    }

    public final void setUsed() {
        this.mUsed = true;
    }

    public abstract ListenableFuture<Result> startWork();

    public final void stop() {
        this.mStopped = true;
        onStopped();
    }
}
