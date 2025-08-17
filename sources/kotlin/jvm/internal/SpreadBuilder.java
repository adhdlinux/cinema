package kotlin.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class SpreadBuilder {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<Object> f40433a;

    public SpreadBuilder(int i2) {
        this.f40433a = new ArrayList<>(i2);
    }

    public void a(Object obj) {
        this.f40433a.add(obj);
    }

    public void b(Object obj) {
        if (obj != null) {
            if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                if (objArr.length > 0) {
                    ArrayList<Object> arrayList = this.f40433a;
                    arrayList.ensureCapacity(arrayList.size() + objArr.length);
                    Collections.addAll(this.f40433a, objArr);
                }
            } else if (obj instanceof Collection) {
                this.f40433a.addAll((Collection) obj);
            } else if (obj instanceof Iterable) {
                for (Object add : (Iterable) obj) {
                    this.f40433a.add(add);
                }
            } else if (obj instanceof Iterator) {
                Iterator it2 = (Iterator) obj;
                while (it2.hasNext()) {
                    this.f40433a.add(it2.next());
                }
            } else {
                throw new UnsupportedOperationException("Don't know how to spread " + obj.getClass());
            }
        }
    }

    public int c() {
        return this.f40433a.size();
    }

    public Object[] d(Object[] objArr) {
        return this.f40433a.toArray(objArr);
    }
}
