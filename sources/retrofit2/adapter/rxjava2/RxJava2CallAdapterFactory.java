package retrofit2.adapter.rxjava2;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;

public final class RxJava2CallAdapterFactory extends CallAdapter.Factory {
    private final boolean isAsync;
    private final Scheduler scheduler;

    private RxJava2CallAdapterFactory(Scheduler scheduler2, boolean z2) {
        this.scheduler = scheduler2;
        this.isAsync = z2;
    }

    public static RxJava2CallAdapterFactory create() {
        return new RxJava2CallAdapterFactory((Scheduler) null, false);
    }

    public static RxJava2CallAdapterFactory createAsync() {
        return new RxJava2CallAdapterFactory((Scheduler) null, true);
    }

    public static RxJava2CallAdapterFactory createWithScheduler(Scheduler scheduler2) {
        if (scheduler2 != null) {
            return new RxJava2CallAdapterFactory(scheduler2, false);
        }
        throw new NullPointerException("scheduler == null");
    }

    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Type type2;
        String str;
        Class<?> rawType = CallAdapter.Factory.getRawType(type);
        if (rawType == Completable.class) {
            return new RxJava2CallAdapter(Void.class, this.scheduler, this.isAsync, false, true, false, false, false, true);
        }
        if (rawType == Flowable.class) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (rawType == Single.class) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (rawType == Maybe.class) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (rawType != Observable.class && !z2 && !z3 && !z4) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            if (z2) {
                str = "Flowable";
            } else if (z3) {
                str = "Single";
            } else if (z4) {
                str = "Maybe";
            } else {
                str = "Observable";
            }
            throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
        }
        Type parameterUpperBound = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) type);
        Class<?> rawType2 = CallAdapter.Factory.getRawType(parameterUpperBound);
        if (rawType2 == Response.class) {
            if (parameterUpperBound instanceof ParameterizedType) {
                type2 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound);
                z6 = false;
            } else {
                throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            }
        } else if (rawType2 != Result.class) {
            type2 = parameterUpperBound;
            z6 = false;
            z5 = true;
            return new RxJava2CallAdapter(type2, this.scheduler, this.isAsync, z6, z5, z2, z3, z4, false);
        } else if (parameterUpperBound instanceof ParameterizedType) {
            type2 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound);
            z6 = true;
        } else {
            throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
        }
        z5 = false;
        return new RxJava2CallAdapter(type2, this.scheduler, this.isAsync, z6, z5, z2, z3, z4, false);
    }
}
