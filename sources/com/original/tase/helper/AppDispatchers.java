package com.original.tase.helper;

import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

public enum AppDispatchers {
    Default(Dispatchers.a(), (int) null, 2, (CoroutineScope) null),
    IO(Dispatchers.b(), (int) null, 2, (CoroutineScope) null),
    Main(Dispatchers.c(), (int) null, 2, (CoroutineScope) null);
    

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f33816d = null;

    /* renamed from: b  reason: collision with root package name */
    private final CoroutineDispatcher f33822b;

    /* renamed from: c  reason: collision with root package name */
    private final CoroutineScope f33823c;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        AppDispatchers[] a2;
        f33821i = EnumEntriesKt.a(a2);
        f33816d = new Companion((DefaultConstructorMarker) null);
    }

    private AppDispatchers(CoroutineDispatcher coroutineDispatcher, CoroutineScope coroutineScope) {
        this.f33822b = coroutineDispatcher;
        this.f33823c = coroutineScope;
    }

    public final CoroutineDispatcher b() {
        return this.f33822b;
    }

    public final CoroutineScope c() {
        return this.f33823c;
    }
}
