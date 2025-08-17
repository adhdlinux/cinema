package kotlinx.coroutines;

final class Empty implements Incomplete {

    /* renamed from: b  reason: collision with root package name */
    private final boolean f40636b;

    public Empty(boolean z2) {
        this.f40636b = z2;
    }

    public NodeList a() {
        return null;
    }

    public boolean isActive() {
        return this.f40636b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(isActive() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
