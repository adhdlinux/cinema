package kotlinx.coroutines;

import kotlinx.coroutines.internal.Symbol;

public final class JobSupportKt {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Symbol f40676a = new Symbol("COMPLETING_ALREADY");

    /* renamed from: b  reason: collision with root package name */
    public static final Symbol f40677b = new Symbol("COMPLETING_WAITING_CHILDREN");
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final Symbol f40678c = new Symbol("COMPLETING_RETRY");
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final Symbol f40679d = new Symbol("TOO_LATE_TO_CANCEL");
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final Symbol f40680e = new Symbol("SEALED");
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final Empty f40681f = new Empty(false);
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final Empty f40682g = new Empty(true);

    public static final Object g(Object obj) {
        return obj instanceof Incomplete ? new IncompleteStateBox((Incomplete) obj) : obj;
    }

    public static final Object h(Object obj) {
        Incomplete incomplete;
        IncompleteStateBox incompleteStateBox = obj instanceof IncompleteStateBox ? (IncompleteStateBox) obj : null;
        return (incompleteStateBox == null || (incomplete = incompleteStateBox.f40655a) == null) ? obj : incomplete;
    }
}
