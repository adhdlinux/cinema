package com.chartboost.sdk.impl;

import com.chartboost.sdk.impl.t2;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

public final class vb {

    /* renamed from: a  reason: collision with root package name */
    public final q2 f18863a;

    /* renamed from: b  reason: collision with root package name */
    public final rb f18864b;

    /* renamed from: c  reason: collision with root package name */
    public final Function1 f18865c;

    /* renamed from: d  reason: collision with root package name */
    public final z4 f18866d;

    public /* synthetic */ class a extends FunctionReferenceImpl implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public static final a f18867b = new a();

        public a() {
            super(1, JSONArray.class, "<init>", "<init>(Ljava/util/Collection;)V", 0);
        }

        /* renamed from: a */
        public final JSONArray invoke(Collection collection) {
            return new JSONArray(collection);
        }
    }

    public vb(q2 q2Var, rb rbVar, Function1 function1, z4 z4Var) {
        Intrinsics.f(q2Var, "networkService");
        Intrinsics.f(rbVar, "trackingEventCache");
        Intrinsics.f(function1, "jsonFactory");
        Intrinsics.f(z4Var, "eventTracker");
        this.f18863a = q2Var;
        this.f18864b = rbVar;
        this.f18865c = function1;
        this.f18866d = z4Var;
    }

    public final void a(String str, List list) {
        Intrinsics.f(str, ImagesContract.URL);
        Intrinsics.f(list, "events");
        wb wbVar = new wb(str, this.f18864b, (t2.a) null, this.f18866d, 4, (DefaultConstructorMarker) null);
        wbVar.f18626q = (JSONArray) this.f18865c.invoke(list);
        this.f18863a.a(wbVar);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ vb(q2 q2Var, rb rbVar, Function1 function1, z4 z4Var, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(q2Var, rbVar, (i2 & 4) != 0 ? a.f18867b : function1, z4Var);
    }
}
