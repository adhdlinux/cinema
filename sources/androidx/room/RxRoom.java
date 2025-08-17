package androidx.room;

import androidx.room.InvalidationTracker;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public class RxRoom {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f11501a = new Object();

    public static <T> Flowable<T> a(RoomDatabase roomDatabase, boolean z2, String[] strArr, Callable<T> callable) {
        Scheduler b2 = Schedulers.b(c(roomDatabase, z2));
        final Maybe<T> d2 = Maybe.d(callable);
        return b(roomDatabase, strArr).p(b2).r(b2).f(b2).d(new Function<Object, MaybeSource<T>>() {
            /* renamed from: a */
            public MaybeSource<T> apply(Object obj) throws Exception {
                return d2;
            }
        });
    }

    public static Flowable<Object> b(final RoomDatabase roomDatabase, final String... strArr) {
        return Flowable.c(new FlowableOnSubscribe<Object>() {
            public void a(final FlowableEmitter<Object> flowableEmitter) throws Exception {
                final AnonymousClass1 r02 = new InvalidationTracker.Observer(strArr) {
                    public void b(Set<String> set) {
                        if (!flowableEmitter.isCancelled()) {
                            flowableEmitter.onNext(RxRoom.f11501a);
                        }
                    }
                };
                if (!flowableEmitter.isCancelled()) {
                    roomDatabase.i().a(r02);
                    flowableEmitter.a(Disposables.c(new Action() {
                        public void run() throws Exception {
                            roomDatabase.i().g(r02);
                        }
                    }));
                }
                if (!flowableEmitter.isCancelled()) {
                    flowableEmitter.onNext(RxRoom.f11501a);
                }
            }
        }, BackpressureStrategy.LATEST);
    }

    private static Executor c(RoomDatabase roomDatabase, boolean z2) {
        if (z2) {
            return roomDatabase.l();
        }
        return roomDatabase.k();
    }
}
