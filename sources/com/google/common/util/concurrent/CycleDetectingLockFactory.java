package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentMap;

public class CycleDetectingLockFactory {

    /* renamed from: a  reason: collision with root package name */
    private static final ConcurrentMap<Class<? extends Enum<?>>, Map<? extends Enum<?>, LockGraphNode>> f30761a = new MapMaker().h().f();

    /* renamed from: b  reason: collision with root package name */
    private static final LazyLogger f30762b = new LazyLogger(CycleDetectingLockFactory.class);

    /* renamed from: c  reason: collision with root package name */
    private static final ThreadLocal<ArrayList<LockGraphNode>> f30763c = new ThreadLocal<ArrayList<LockGraphNode>>() {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public ArrayList<LockGraphNode> initialValue() {
            return Lists.k(3);
        }
    };

    private static class ExampleStackTrace extends IllegalStateException {

        /* renamed from: b  reason: collision with root package name */
        static final StackTraceElement[] f30764b = new StackTraceElement[0];

        /* renamed from: c  reason: collision with root package name */
        static final ImmutableSet<String> f30765c = ImmutableSet.t(CycleDetectingLockFactory.class.getName(), ExampleStackTrace.class.getName(), LockGraphNode.class.getName());
    }

    private static class LockGraphNode {
    }

    public static final class PotentialDeadlockException extends ExampleStackTrace {

        /* renamed from: d  reason: collision with root package name */
        private final ExampleStackTrace f30766d;

        public String getMessage() {
            String message = super.getMessage();
            Objects.requireNonNull(message);
            StringBuilder sb = new StringBuilder(message);
            for (Throwable th = this.f30766d; th != null; th = th.getCause()) {
                sb.append(", ");
                sb.append(th.getMessage());
            }
            return sb.toString();
        }
    }
}
