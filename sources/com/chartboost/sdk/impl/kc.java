package com.chartboost.sdk.impl;

import android.content.Context;
import com.chartboost.sdk.impl.ic;
import com.chartboost.sdk.internal.Model.CBError;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

public final class kc {

    /* renamed from: a  reason: collision with root package name */
    public final ic f18047a;

    /* renamed from: b  reason: collision with root package name */
    public final List f18048b;

    /* renamed from: c  reason: collision with root package name */
    public final CoroutineDispatcher f18049c;

    public static final class a extends SuspendLambda implements Function2 {

        /* renamed from: b  reason: collision with root package name */
        public int f18050b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f18051c;

        public a(Continuation continuation) {
            super(2, continuation);
        }

        /* renamed from: a */
        public final Object invoke(ec ecVar, Continuation continuation) {
            return ((a) create(ecVar, continuation)).invokeSuspend(Unit.f40298a);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            a aVar = new a(continuation);
            aVar.f18051c = obj;
            return aVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object obj2;
            Object e2 = IntrinsicsKt__IntrinsicsKt.e();
            int i2 = this.f18050b;
            if (i2 == 0) {
                ResultKt.b(obj);
                this.f18050b = 1;
                obj2 = com.chartboost.sdk.internal.clickthrough.a.c((ec) this.f18051c, (Context) null, (Function1) null, (Function1) null, (CoroutineDispatcher) null, this, 30, (Object) null);
                if (obj2 == e2) {
                    return e2;
                }
            } else if (i2 == 1) {
                ResultKt.b(obj);
                obj2 = ((Result) obj).j();
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Result.a(obj2);
        }
    }

    public static final class b extends SuspendLambda implements Function2 {

        /* renamed from: b  reason: collision with root package name */
        public int f18052b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f18053c;

        public b(Continuation continuation) {
            super(2, continuation);
        }

        /* renamed from: a */
        public final Object invoke(ec ecVar, Continuation continuation) {
            return ((b) create(ecVar, continuation)).invokeSuspend(Unit.f40298a);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            b bVar = new b(continuation);
            bVar.f18053c = obj;
            return bVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object obj2;
            Object e2 = IntrinsicsKt__IntrinsicsKt.e();
            int i2 = this.f18052b;
            if (i2 == 0) {
                ResultKt.b(obj);
                this.f18052b = 1;
                obj2 = com.chartboost.sdk.internal.clickthrough.a.a((ec) this.f18053c, (Context) null, (q7) null, (Function1) null, (Function1) null, (CoroutineDispatcher) null, this, 62, (Object) null);
                if (obj2 == e2) {
                    return e2;
                }
            } else if (i2 == 1) {
                ResultKt.b(obj);
                obj2 = ((Result) obj).j();
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Result.a(obj2);
        }
    }

    public static final class c extends SuspendLambda implements Function2 {

        /* renamed from: b  reason: collision with root package name */
        public int f18054b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f18055c;

        public c(Continuation continuation) {
            super(2, continuation);
        }

        /* renamed from: a */
        public final Object invoke(ec ecVar, Continuation continuation) {
            return ((c) create(ecVar, continuation)).invokeSuspend(Unit.f40298a);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            c cVar = new c(continuation);
            cVar.f18055c = obj;
            return cVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object obj2;
            Object e2 = IntrinsicsKt__IntrinsicsKt.e();
            int i2 = this.f18054b;
            if (i2 == 0) {
                ResultKt.b(obj);
                this.f18054b = 1;
                obj2 = com.chartboost.sdk.internal.clickthrough.a.a((ec) this.f18055c, (Context) null, (Function1) null, (Function1) null, (CoroutineDispatcher) null, this, 30, (Object) null);
                if (obj2 == e2) {
                    return e2;
                }
            } else if (i2 == 1) {
                ResultKt.b(obj);
                obj2 = ((Result) obj).j();
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Result.a(obj2);
        }
    }

    public static final class d extends SuspendLambda implements Function2 {

        /* renamed from: b  reason: collision with root package name */
        public int f18056b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f18057c;

        public d(Continuation continuation) {
            super(2, continuation);
        }

        /* renamed from: a */
        public final Object invoke(ec ecVar, Continuation continuation) {
            return ((d) create(ecVar, continuation)).invokeSuspend(Unit.f40298a);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            d dVar = new d(continuation);
            dVar.f18057c = obj;
            return dVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object obj2;
            Object e2 = IntrinsicsKt__IntrinsicsKt.e();
            int i2 = this.f18056b;
            if (i2 == 0) {
                ResultKt.b(obj);
                this.f18056b = 1;
                obj2 = com.chartboost.sdk.internal.clickthrough.a.b((ec) this.f18057c, (Context) null, (Function1) null, (Function1) null, (CoroutineDispatcher) null, this, 30, (Object) null);
                if (obj2 == e2) {
                    return e2;
                }
            } else if (i2 == 1) {
                ResultKt.b(obj);
                obj2 = ((Result) obj).j();
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Result.a(obj2);
        }
    }

    public static final class e extends ContinuationImpl {

        /* renamed from: b  reason: collision with root package name */
        public Object f18058b;

        /* renamed from: c  reason: collision with root package name */
        public Object f18059c;

        /* renamed from: d  reason: collision with root package name */
        public /* synthetic */ Object f18060d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ kc f18061e;

        /* renamed from: f  reason: collision with root package name */
        public int f18062f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(kc kcVar, Continuation continuation) {
            super(continuation);
            this.f18061e = kcVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f18060d = obj;
            this.f18062f |= Integer.MIN_VALUE;
            Object a2 = this.f18061e.a((Function2) null, (ec) null, (q3) null, (Continuation) this);
            return a2 == IntrinsicsKt__IntrinsicsKt.e() ? a2 : Result.a(a2);
        }
    }

    public static final class f extends ContinuationImpl {

        /* renamed from: b  reason: collision with root package name */
        public Object f18063b;

        /* renamed from: c  reason: collision with root package name */
        public Object f18064c;

        /* renamed from: d  reason: collision with root package name */
        public Object f18065d;

        /* renamed from: e  reason: collision with root package name */
        public Object f18066e;

        /* renamed from: f  reason: collision with root package name */
        public /* synthetic */ Object f18067f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ kc f18068g;

        /* renamed from: h  reason: collision with root package name */
        public int f18069h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(kc kcVar, Continuation continuation) {
            super(continuation);
            this.f18068g = kcVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f18067f = obj;
            this.f18069h |= Integer.MIN_VALUE;
            return this.f18068g.a((ec) null, (q3) null, (Continuation) this);
        }
    }

    public static final class g extends SuspendLambda implements Function2 {

        /* renamed from: b  reason: collision with root package name */
        public int f18070b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ kc f18071c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f18072d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q3 f18073e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ l3 f18074f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(kc kcVar, String str, q3 q3Var, l3 l3Var, Continuation continuation) {
            super(2, continuation);
            this.f18071c = kcVar;
            this.f18072d = str;
            this.f18073e = q3Var;
            this.f18074f = l3Var;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((g) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            return new g(this.f18071c, this.f18072d, this.f18073e, this.f18074f, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object e2 = IntrinsicsKt__IntrinsicsKt.e();
            int i2 = this.f18070b;
            if (i2 == 0) {
                ResultKt.b(obj);
                kc kcVar = this.f18071c;
                Object a2 = kcVar.a(ic.a(kcVar.f18047a, this.f18072d, 0, 2, (Object) null), this.f18072d, this.f18073e);
                String str = this.f18072d;
                Throwable e3 = Result.e(a2);
                if (e3 == null) {
                    str = (String) a2;
                } else if (e3 instanceof ic.b.e) {
                    str = ((ic.b.e) e3).a();
                }
                ec ecVar = new ec(str, this.f18074f);
                kc kcVar2 = this.f18071c;
                q3 q3Var = this.f18073e;
                this.f18070b = 1;
                if (kcVar2.a(ecVar, q3Var, (Continuation) this) == e2) {
                    return e2;
                }
            } else if (i2 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f40298a;
        }
    }

    public kc(ic icVar, List list, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.f(icVar, "urlRedirect");
        Intrinsics.f(list, "actions");
        Intrinsics.f(coroutineDispatcher, "ioDispatcher");
        this.f18047a = icVar;
        this.f18048b = list;
        this.f18049c = coroutineDispatcher;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ kc(com.chartboost.sdk.impl.ic r4, java.util.List r5, kotlinx.coroutines.CoroutineDispatcher r6, int r7, kotlin.jvm.internal.DefaultConstructorMarker r8) {
        /*
            r3 = this;
            r8 = r7 & 2
            r0 = 4
            if (r8 == 0) goto L_0x002c
            kotlin.jvm.functions.Function2[] r5 = new kotlin.jvm.functions.Function2[r0]
            com.chartboost.sdk.impl.kc$a r8 = new com.chartboost.sdk.impl.kc$a
            r1 = 0
            r8.<init>(r1)
            r2 = 0
            r5[r2] = r8
            com.chartboost.sdk.impl.kc$b r8 = new com.chartboost.sdk.impl.kc$b
            r8.<init>(r1)
            r2 = 1
            r5[r2] = r8
            com.chartboost.sdk.impl.kc$c r8 = new com.chartboost.sdk.impl.kc$c
            r8.<init>(r1)
            r2 = 2
            r5[r2] = r8
            com.chartboost.sdk.impl.kc$d r8 = new com.chartboost.sdk.impl.kc$d
            r8.<init>(r1)
            r1 = 3
            r5[r1] = r8
            java.util.List r5 = kotlin.collections.CollectionsKt__CollectionsKt.i(r5)
        L_0x002c:
            r7 = r7 & r0
            if (r7 == 0) goto L_0x0033
            kotlinx.coroutines.CoroutineDispatcher r6 = kotlinx.coroutines.Dispatchers.b()
        L_0x0033:
            r3.<init>(r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.kc.<init>(com.chartboost.sdk.impl.ic, java.util.List, kotlinx.coroutines.CoroutineDispatcher, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final CBError.CBClickError a(String str, l3 l3Var, q3 q3Var) {
        Intrinsics.f(l3Var, "clkp");
        Intrinsics.f(q3Var, "clickTracking");
        if (str == null || str.length() == 0) {
            return CBError.CBClickError.URI_INVALID;
        }
        Job unused = BuildersKt__Builders_commonKt.b(CoroutineScopeKt.a(this.f18049c), (CoroutineContext) null, (CoroutineStart) null, new g(this, str, q3Var, l3Var, (Continuation) null), 3, (Object) null);
        return null;
    }

    public final Object a(Object obj, String str, q3 q3Var) {
        Throwable e2 = Result.e(obj);
        if (e2 == null) {
            q3Var.a("Redirection successful from " + str + " to " + ((String) obj));
        } else {
            q3Var.b("Redirection failed for " + str + ": " + e2);
        }
        return obj;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0094 A[SYNTHETIC] */
    public final java.lang.Object a(com.chartboost.sdk.impl.ec r9, com.chartboost.sdk.impl.q3 r10, kotlin.coroutines.Continuation r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.chartboost.sdk.impl.kc.f
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.chartboost.sdk.impl.kc$f r0 = (com.chartboost.sdk.impl.kc.f) r0
            int r1 = r0.f18069h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f18069h = r1
            goto L_0x0018
        L_0x0013:
            com.chartboost.sdk.impl.kc$f r0 = new com.chartboost.sdk.impl.kc$f
            r0.<init>(r8, r11)
        L_0x0018:
            java.lang.Object r11 = r0.f18067f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.e()
            int r2 = r0.f18069h
            r3 = 1
            if (r2 == 0) goto L_0x0047
            if (r2 != r3) goto L_0x003f
            java.lang.Object r9 = r0.f18066e
            java.util.Iterator r9 = (java.util.Iterator) r9
            java.lang.Object r10 = r0.f18065d
            com.chartboost.sdk.impl.q3 r10 = (com.chartboost.sdk.impl.q3) r10
            java.lang.Object r2 = r0.f18064c
            com.chartboost.sdk.impl.ec r2 = (com.chartboost.sdk.impl.ec) r2
            java.lang.Object r4 = r0.f18063b
            com.chartboost.sdk.impl.kc r4 = (com.chartboost.sdk.impl.kc) r4
            kotlin.ResultKt.b(r11)
            kotlin.Result r11 = (kotlin.Result) r11
            java.lang.Object r11 = r11.j()
            goto L_0x008f
        L_0x003f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0047:
            kotlin.ResultKt.b(r11)
            java.util.List r11 = r8.f18048b
            kotlin.Result$Companion r2 = kotlin.Result.f40263c
            java.lang.Exception r2 = new java.lang.Exception
            r2.<init>()
            java.lang.Object r2 = kotlin.ResultKt.a(r2)
            java.lang.Object r2 = kotlin.Result.b(r2)
            java.util.Iterator r11 = r11.iterator()
            r4 = r8
            r7 = r10
            r10 = r9
            r9 = r11
            r11 = r7
        L_0x0064:
            boolean r5 = r9.hasNext()
            if (r5 == 0) goto L_0x0094
            java.lang.Object r5 = r9.next()
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            java.lang.Throwable r6 = kotlin.Result.e(r2)
            if (r6 != 0) goto L_0x007a
            r5 = r2
            com.chartboost.sdk.impl.dc r5 = (com.chartboost.sdk.impl.dc) r5
            goto L_0x0064
        L_0x007a:
            r0.f18063b = r4
            r0.f18064c = r10
            r0.f18065d = r11
            r0.f18066e = r9
            r0.f18069h = r3
            java.lang.Object r2 = r4.a((kotlin.jvm.functions.Function2) r5, (com.chartboost.sdk.impl.ec) r10, (com.chartboost.sdk.impl.q3) r11, (kotlin.coroutines.Continuation) r0)
            if (r2 != r1) goto L_0x008b
            return r1
        L_0x008b:
            r7 = r2
            r2 = r10
            r10 = r11
            r11 = r7
        L_0x008f:
            r7 = r11
            r11 = r10
            r10 = r2
            r2 = r7
            goto L_0x0064
        L_0x0094:
            java.lang.Throwable r9 = kotlin.Result.e(r2)
            if (r9 == 0) goto L_0x00b2
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "None of the actions was able to process URL "
            r9.append(r0)
            java.lang.String r10 = r10.b()
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r11.b(r9)
        L_0x00b2:
            kotlin.Unit r9 = kotlin.Unit.f40298a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.kc.a(com.chartboost.sdk.impl.ec, com.chartboost.sdk.impl.q3, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: com.chartboost.sdk.impl.q3} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: com.chartboost.sdk.impl.ec} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(kotlin.jvm.functions.Function2 r5, com.chartboost.sdk.impl.ec r6, com.chartboost.sdk.impl.q3 r7, kotlin.coroutines.Continuation r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.chartboost.sdk.impl.kc.e
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.chartboost.sdk.impl.kc$e r0 = (com.chartboost.sdk.impl.kc.e) r0
            int r1 = r0.f18062f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f18062f = r1
            goto L_0x0018
        L_0x0013:
            com.chartboost.sdk.impl.kc$e r0 = new com.chartboost.sdk.impl.kc$e
            r0.<init>(r4, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f18060d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.e()
            int r2 = r0.f18062f
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r5 = r0.f18059c
            r7 = r5
            com.chartboost.sdk.impl.q3 r7 = (com.chartboost.sdk.impl.q3) r7
            java.lang.Object r5 = r0.f18058b
            r6 = r5
            com.chartboost.sdk.impl.ec r6 = (com.chartboost.sdk.impl.ec) r6
            kotlin.ResultKt.b(r8)
            goto L_0x004b
        L_0x0033:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003b:
            kotlin.ResultKt.b(r8)
            r0.f18058b = r6
            r0.f18059c = r7
            r0.f18062f = r3
            java.lang.Object r8 = r5.invoke(r6, r0)
            if (r8 != r1) goto L_0x004b
            return r1
        L_0x004b:
            kotlin.Result r8 = (kotlin.Result) r8
            java.lang.Object r5 = r8.j()
            boolean r8 = kotlin.Result.h(r5)
            java.lang.String r0 = "Url "
            if (r8 == 0) goto L_0x007e
            r8 = r5
            com.chartboost.sdk.impl.dc r8 = (com.chartboost.sdk.impl.dc) r8
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r2 = r6.b()
            r1.append(r2)
            java.lang.String r2 = " opened with action "
            r1.append(r2)
            java.lang.String r8 = r8.a()
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r7.a(r8)
        L_0x007e:
            java.lang.Throwable r8 = kotlin.Result.e(r5)
            if (r8 == 0) goto L_0x00a6
            boolean r1 = r8 instanceof com.chartboost.sdk.impl.fc
            if (r1 != 0) goto L_0x00a6
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r6 = r6.b()
            r1.append(r6)
            java.lang.String r6 = " opening failed with error "
            r1.append(r6)
            r1.append(r8)
            java.lang.String r6 = r1.toString()
            r7.b(r6)
        L_0x00a6:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.kc.a(kotlin.jvm.functions.Function2, com.chartboost.sdk.impl.ec, com.chartboost.sdk.impl.q3, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
