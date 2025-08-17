package androidx.constraintlayout.solver;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;

public class Cache {

    /* renamed from: a  reason: collision with root package name */
    Pools$Pool<ArrayRow> f1768a = new Pools$SimplePool(UserVerificationMethods.USER_VERIFY_HANDPRINT);

    /* renamed from: b  reason: collision with root package name */
    Pools$Pool<SolverVariable> f1769b = new Pools$SimplePool(UserVerificationMethods.USER_VERIFY_HANDPRINT);

    /* renamed from: c  reason: collision with root package name */
    SolverVariable[] f1770c = new SolverVariable[32];
}
