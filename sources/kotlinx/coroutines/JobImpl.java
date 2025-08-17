package kotlinx.coroutines;

public class JobImpl extends JobSupport implements CompletableJob {

    /* renamed from: d  reason: collision with root package name */
    private final boolean f40662d = u0();

    public JobImpl(Job job) {
        super(true);
        R(job);
    }

    private final boolean u0() {
        ChildHandleNode childHandleNode;
        JobSupport s2;
        ChildHandleNode childHandleNode2;
        ChildHandle N = N();
        if (N instanceof ChildHandleNode) {
            childHandleNode = (ChildHandleNode) N;
        } else {
            childHandleNode = null;
        }
        if (!(childHandleNode == null || (s2 = childHandleNode.s()) == null)) {
            while (!s2.J()) {
                ChildHandle N2 = s2.N();
                if (N2 instanceof ChildHandleNode) {
                    childHandleNode2 = (ChildHandleNode) N2;
                } else {
                    childHandleNode2 = null;
                }
                if (childHandleNode2 != null) {
                    s2 = childHandleNode2.s();
                    if (s2 == null) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    public boolean J() {
        return this.f40662d;
    }

    public boolean K() {
        return true;
    }
}
