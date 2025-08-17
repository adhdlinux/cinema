package androidx.constraintlayout.solver.widgets;

import java.util.HashSet;
import java.util.Iterator;

public class ResolutionNode {

    /* renamed from: a  reason: collision with root package name */
    HashSet<ResolutionNode> f1974a = new HashSet<>(2);

    /* renamed from: b  reason: collision with root package name */
    int f1975b = 0;

    public void a(ResolutionNode resolutionNode) {
        this.f1974a.add(resolutionNode);
    }

    public void b() {
        this.f1975b = 1;
        Iterator<ResolutionNode> it2 = this.f1974a.iterator();
        while (it2.hasNext()) {
            it2.next().f();
        }
    }

    public void c() {
        this.f1975b = 0;
        Iterator<ResolutionNode> it2 = this.f1974a.iterator();
        while (it2.hasNext()) {
            it2.next().c();
        }
    }

    public boolean d() {
        return this.f1975b == 1;
    }

    public void e() {
        this.f1975b = 0;
        this.f1974a.clear();
    }

    public void f() {
    }
}
