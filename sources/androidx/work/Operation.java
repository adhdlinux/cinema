package androidx.work;

import android.annotation.SuppressLint;

public interface Operation {
    @SuppressLint({"SyntheticAccessor"})

    /* renamed from: a  reason: collision with root package name */
    public static final State.SUCCESS f12194a = new State.SUCCESS();
    @SuppressLint({"SyntheticAccessor"})

    /* renamed from: b  reason: collision with root package name */
    public static final State.IN_PROGRESS f12195b = new State.IN_PROGRESS();

    public static abstract class State {

        public static final class FAILURE extends State {

            /* renamed from: a  reason: collision with root package name */
            private final Throwable f12196a;

            public FAILURE(Throwable th) {
                this.f12196a = th;
            }

            public Throwable a() {
                return this.f12196a;
            }

            public String toString() {
                return String.format("FAILURE (%s)", new Object[]{this.f12196a.getMessage()});
            }
        }

        public static final class IN_PROGRESS extends State {
            public String toString() {
                return "IN_PROGRESS";
            }

            private IN_PROGRESS() {
            }
        }

        public static final class SUCCESS extends State {
            public String toString() {
                return "SUCCESS";
            }

            private SUCCESS() {
            }
        }

        State() {
        }
    }
}
