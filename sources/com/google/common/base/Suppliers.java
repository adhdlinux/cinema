package com.google.common.base;

import java.io.Serializable;

public final class Suppliers {

    static class MemoizingSupplier<T> implements Supplier<T>, Serializable {

        /* renamed from: b  reason: collision with root package name */
        final Supplier<T> f30415b;

        /* renamed from: c  reason: collision with root package name */
        volatile transient boolean f30416c;

        /* renamed from: d  reason: collision with root package name */
        transient T f30417d;

        MemoizingSupplier(Supplier<T> supplier) {
            this.f30415b = (Supplier) Preconditions.l(supplier);
        }

        public T get() {
            if (!this.f30416c) {
                synchronized (this) {
                    if (!this.f30416c) {
                        T t2 = this.f30415b.get();
                        this.f30417d = t2;
                        this.f30416c = true;
                        return t2;
                    }
                }
            }
            return NullnessCasts.a(this.f30417d);
        }

        public String toString() {
            Object obj;
            StringBuilder sb = new StringBuilder();
            sb.append("Suppliers.memoize(");
            if (this.f30416c) {
                obj = "<supplier that returned " + this.f30417d + ">";
            } else {
                obj = this.f30415b;
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }
    }

    static class NonSerializableMemoizingSupplier<T> implements Supplier<T> {

        /* renamed from: d  reason: collision with root package name */
        private static final Supplier<Void> f30418d = new a();

        /* renamed from: b  reason: collision with root package name */
        private volatile Supplier<T> f30419b;

        /* renamed from: c  reason: collision with root package name */
        private T f30420c;

        NonSerializableMemoizingSupplier(Supplier<T> supplier) {
            this.f30419b = (Supplier) Preconditions.l(supplier);
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ Void b() {
            throw new IllegalStateException();
        }

        public T get() {
            Supplier<T> supplier = this.f30419b;
            Supplier<Void> supplier2 = f30418d;
            if (supplier != supplier2) {
                synchronized (this) {
                    if (this.f30419b != supplier2) {
                        T t2 = this.f30419b.get();
                        this.f30420c = t2;
                        this.f30419b = supplier2;
                        return t2;
                    }
                }
            }
            return NullnessCasts.a(this.f30420c);
        }

        public String toString() {
            Object obj = this.f30419b;
            StringBuilder sb = new StringBuilder();
            sb.append("Suppliers.memoize(");
            if (obj == f30418d) {
                obj = "<supplier that returned " + this.f30420c + ">";
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }
    }

    private Suppliers() {
    }

    public static <T> Supplier<T> a(Supplier<T> supplier) {
        if ((supplier instanceof NonSerializableMemoizingSupplier) || (supplier instanceof MemoizingSupplier)) {
            return supplier;
        }
        if (supplier instanceof Serializable) {
            return new MemoizingSupplier(supplier);
        }
        return new NonSerializableMemoizingSupplier(supplier);
    }
}
