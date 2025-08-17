package bolts;

public class TaskCompletionSource<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final Task<TResult> f12819a = new Task<>();

    public Task<TResult> a() {
        return this.f12819a;
    }

    public void b() {
        if (!e()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    public void c(Exception exc) {
        if (!f(exc)) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }

    public void d(TResult tresult) {
        if (!g(tresult)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }

    public boolean e() {
        return this.f12819a.t();
    }

    public boolean f(Exception exc) {
        return this.f12819a.u(exc);
    }

    public boolean g(TResult tresult) {
        return this.f12819a.v(tresult);
    }
}
