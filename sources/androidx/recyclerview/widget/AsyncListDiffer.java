package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.DiffUtil;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

public class AsyncListDiffer<T> {

    /* renamed from: h  reason: collision with root package name */
    private static final Executor f11005h = new MainThreadExecutor();

    /* renamed from: a  reason: collision with root package name */
    private final ListUpdateCallback f11006a;

    /* renamed from: b  reason: collision with root package name */
    final AsyncDifferConfig<T> f11007b;

    /* renamed from: c  reason: collision with root package name */
    Executor f11008c;

    /* renamed from: d  reason: collision with root package name */
    private final List<ListListener<T>> f11009d = new CopyOnWriteArrayList();

    /* renamed from: e  reason: collision with root package name */
    private List<T> f11010e;

    /* renamed from: f  reason: collision with root package name */
    private List<T> f11011f = Collections.emptyList();

    /* renamed from: g  reason: collision with root package name */
    int f11012g;

    public interface ListListener<T> {
        void a(List<T> list, List<T> list2);
    }

    private static class MainThreadExecutor implements Executor {

        /* renamed from: b  reason: collision with root package name */
        final Handler f11021b = new Handler(Looper.getMainLooper());

        MainThreadExecutor() {
        }

        public void execute(Runnable runnable) {
            this.f11021b.post(runnable);
        }
    }

    public AsyncListDiffer(ListUpdateCallback listUpdateCallback, AsyncDifferConfig<T> asyncDifferConfig) {
        this.f11006a = listUpdateCallback;
        this.f11007b = asyncDifferConfig;
        if (asyncDifferConfig.c() != null) {
            this.f11008c = asyncDifferConfig.c();
        } else {
            this.f11008c = f11005h;
        }
    }

    private void d(List<T> list, Runnable runnable) {
        for (ListListener<T> a2 : this.f11009d) {
            a2.a(list, this.f11011f);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public void a(ListListener<T> listListener) {
        this.f11009d.add(listListener);
    }

    public List<T> b() {
        return this.f11011f;
    }

    /* access modifiers changed from: package-private */
    public void c(List<T> list, DiffUtil.DiffResult diffResult, Runnable runnable) {
        List<T> list2 = this.f11011f;
        this.f11010e = list;
        this.f11011f = Collections.unmodifiableList(list);
        diffResult.b(this.f11006a);
        d(list2, runnable);
    }

    public void e(List<T> list) {
        f(list, (Runnable) null);
    }

    public void f(List<T> list, Runnable runnable) {
        final int i2 = this.f11012g + 1;
        this.f11012g = i2;
        final List<T> list2 = this.f11010e;
        if (list != list2) {
            List<T> list3 = this.f11011f;
            if (list == null) {
                int size = list2.size();
                this.f11010e = null;
                this.f11011f = Collections.emptyList();
                this.f11006a.b(0, size);
                d(list3, runnable);
            } else if (list2 == null) {
                this.f11010e = list;
                this.f11011f = Collections.unmodifiableList(list);
                this.f11006a.a(0, list.size());
                d(list3, runnable);
            } else {
                final List<T> list4 = list;
                final Runnable runnable2 = runnable;
                this.f11007b.a().execute(new Runnable() {
                    public void run() {
                        final DiffUtil.DiffResult b2 = DiffUtil.b(new DiffUtil.Callback() {
                            public boolean a(int i2, int i3) {
                                Object obj = list2.get(i2);
                                Object obj2 = list4.get(i3);
                                if (obj != null && obj2 != null) {
                                    return AsyncListDiffer.this.f11007b.b().a(obj, obj2);
                                }
                                if (obj == null && obj2 == null) {
                                    return true;
                                }
                                throw new AssertionError();
                            }

                            public boolean b(int i2, int i3) {
                                Object obj = list2.get(i2);
                                Object obj2 = list4.get(i3);
                                if (obj != null && obj2 != null) {
                                    return AsyncListDiffer.this.f11007b.b().b(obj, obj2);
                                }
                                if (obj == null && obj2 == null) {
                                    return true;
                                }
                                return false;
                            }

                            public Object c(int i2, int i3) {
                                Object obj = list2.get(i2);
                                Object obj2 = list4.get(i3);
                                if (obj != null && obj2 != null) {
                                    return AsyncListDiffer.this.f11007b.b().c(obj, obj2);
                                }
                                throw new AssertionError();
                            }

                            public int d() {
                                return list4.size();
                            }

                            public int e() {
                                return list2.size();
                            }
                        });
                        AsyncListDiffer.this.f11008c.execute(new Runnable() {
                            public void run() {
                                AnonymousClass1 r02 = AnonymousClass1.this;
                                AsyncListDiffer asyncListDiffer = AsyncListDiffer.this;
                                if (asyncListDiffer.f11012g == i2) {
                                    asyncListDiffer.c(list4, b2, runnable2);
                                }
                            }
                        });
                    }
                });
            }
        } else if (runnable != null) {
            runnable.run();
        }
    }
}
