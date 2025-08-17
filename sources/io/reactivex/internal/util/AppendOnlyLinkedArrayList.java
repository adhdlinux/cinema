package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.functions.Predicate;

public class AppendOnlyLinkedArrayList<T> {

    /* renamed from: a  reason: collision with root package name */
    final int f40053a;

    /* renamed from: b  reason: collision with root package name */
    final Object[] f40054b;

    /* renamed from: c  reason: collision with root package name */
    Object[] f40055c;

    /* renamed from: d  reason: collision with root package name */
    int f40056d;

    public interface NonThrowingPredicate<T> extends Predicate<T> {
        boolean test(T t2);
    }

    public AppendOnlyLinkedArrayList(int i2) {
        this.f40053a = i2;
        Object[] objArr = new Object[(i2 + 1)];
        this.f40054b = objArr;
        this.f40055c = objArr;
    }

    public <U> boolean a(Observer<? super U> observer) {
        Object[] objArr = this.f40054b;
        int i2 = this.f40053a;
        while (true) {
            int i3 = 0;
            if (objArr == null) {
                return false;
            }
            while (i3 < i2) {
                Object[] objArr2 = objArr[i3];
                if (objArr2 == null) {
                    continue;
                    break;
                } else if (NotificationLite.b(objArr2, observer)) {
                    return true;
                } else {
                    i3++;
                }
            }
            objArr = objArr[i2];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(T r4) {
        /*
            r3 = this;
            int r0 = r3.f40053a
            int r1 = r3.f40056d
            if (r1 != r0) goto L_0x0011
            int r1 = r0 + 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Object[] r2 = r3.f40055c
            r2[r0] = r1
            r3.f40055c = r1
            r1 = 0
        L_0x0011:
            java.lang.Object[] r0 = r3.f40055c
            r0[r1] = r4
            int r1 = r1 + 1
            r3.f40056d = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.AppendOnlyLinkedArrayList.b(java.lang.Object):void");
    }

    public void c(NonThrowingPredicate<? super T> nonThrowingPredicate) {
        int i2 = this.f40053a;
        for (Object[] objArr = this.f40054b; objArr != null; objArr = objArr[i2]) {
            int i3 = 0;
            while (i3 < i2) {
                Object[] objArr2 = objArr[i3];
                if (objArr2 == null) {
                    continue;
                    break;
                } else if (!nonThrowingPredicate.test(objArr2)) {
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    public void d(T t2) {
        this.f40054b[0] = t2;
    }
}
