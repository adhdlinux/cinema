package com.startapp.sdk.adsbase.crashreport;

import android.os.Looper;
import java.io.Serializable;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ThreadsState implements Serializable {
    private static final long serialVersionUID = -4777916407910409315L;

    /* renamed from: a  reason: collision with root package name */
    public final transient String f36313a;

    /* renamed from: b  reason: collision with root package name */
    public final transient boolean f36314b;

    /* renamed from: c  reason: collision with root package name */
    public final transient boolean f36315c;

    /* renamed from: d  reason: collision with root package name */
    public final transient Set<String> f36316d;
    private final long delay;
    private final String handlerDescription;
    private Map<String, ShrunkStackTraceElement[]> threadsStackTraces;

    public static class MainThreadComparator implements Comparator<String>, Serializable {

        /* renamed from: a  reason: collision with root package name */
        public final transient String f36317a = Looper.getMainLooper().getThread().getName();

        public int compare(Object obj, Object obj2) {
            String str = (String) obj;
            String str2 = (String) obj2;
            if (str.startsWith(this.f36317a)) {
                return -1;
            }
            if (str2.startsWith(this.f36317a)) {
                return 1;
            }
            return str.compareTo(str2);
        }
    }

    public static class ShrunkStackTraceElement implements Serializable {
        private static final long serialVersionUID = -7615438011343681512L;
        private final long skipBeforeAmount;
        private final StackTraceElement stackTraceElement;

        public ShrunkStackTraceElement(long j2, StackTraceElement stackTraceElement2) {
            this.skipBeforeAmount = j2;
            this.stackTraceElement = stackTraceElement2;
        }

        public long a() {
            return this.skipBeforeAmount;
        }

        public StackTraceElement b() {
            return this.stackTraceElement;
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f36318a;

        /* renamed from: b  reason: collision with root package name */
        public String f36319b;

        /* renamed from: c  reason: collision with root package name */
        public Set<String> f36320c;

        /* renamed from: d  reason: collision with root package name */
        public long f36321d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f36322e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f36323f;
    }

    public ThreadsState(a aVar) {
        this.f36313a = aVar.f36318a;
        this.f36314b = aVar.f36322e;
        this.f36315c = aVar.f36323f;
        this.delay = aVar.f36321d;
        this.handlerDescription = aVar.f36319b;
        this.f36316d = aVar.f36320c;
        a();
    }

    public final void a() {
        Thread thread = Looper.getMainLooper().getThread();
        String a2 = a(thread);
        TreeMap treeMap = new TreeMap(new MainThreadComparator());
        boolean z2 = false;
        for (Map.Entry next : Thread.getAllStackTraces().entrySet()) {
            Thread thread2 = (Thread) next.getKey();
            StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) next.getValue();
            if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
                ShrunkStackTraceElement[] b2 = b(stackTraceElementArr);
                if (b2 != null && b2.length > 0) {
                    Thread.State state = thread2.getState();
                    if (thread2 == thread) {
                        if (!a(stackTraceElementArr)) {
                            treeMap.put(a2, b2);
                            z2 = true;
                        } else {
                            return;
                        }
                    } else if (!this.f36315c || state == Thread.State.BLOCKED || state == Thread.State.WAITING) {
                        treeMap.put(a(thread2), b2);
                    }
                } else if (thread2 == thread) {
                    return;
                }
            } else if (thread2 == thread) {
                return;
            }
        }
        if (!z2) {
            StackTraceElement[] stackTrace = thread.getStackTrace();
            ShrunkStackTraceElement[] b3 = b(stackTrace);
            if (b3 != null && b3.length > 0 && !a(stackTrace)) {
                treeMap.put(a2, b3);
            } else {
                return;
            }
        }
        this.threadsStackTraces = treeMap;
    }

    public long b() {
        return this.delay;
    }

    public String c() {
        return this.handlerDescription;
    }

    public Map<String, ShrunkStackTraceElement[]> d() {
        return this.threadsStackTraces;
    }

    public final ShrunkStackTraceElement[] b(StackTraceElement[] stackTraceElementArr) {
        ShrunkStackTraceElement[] shrunkStackTraceElementArr;
        String className;
        StackTraceElement[] stackTraceElementArr2 = stackTraceElementArr;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        StackTraceElement stackTraceElement = null;
        long j2 = 0;
        boolean z2 = false;
        boolean z3 = false;
        while (i2 < stackTraceElementArr2.length) {
            StackTraceElement stackTraceElement2 = stackTraceElementArr2[i2];
            if (!(stackTraceElement2 == null || (className = stackTraceElement2.getClassName()) == null)) {
                boolean z4 = i2 < 3;
                String str = this.f36313a;
                boolean z5 = str == null || className.startsWith(str);
                if (z5) {
                    z2 = true;
                }
                if (!this.f36314b || z5 || z4 || z3) {
                    if (stackTraceElement != null) {
                        arrayList.add(new ShrunkStackTraceElement(j2, stackTraceElement));
                        stackTraceElement = null;
                        j2 = 0;
                    }
                    arrayList.add(new ShrunkStackTraceElement(0, stackTraceElement2));
                    z3 = z5;
                    i2++;
                } else {
                    if (stackTraceElement != null) {
                        j2++;
                    }
                    z3 = z5;
                    stackTraceElement = stackTraceElement2;
                }
            }
            i2++;
        }
        if (stackTraceElement != null) {
            shrunkStackTraceElementArr = null;
            arrayList.add(new ShrunkStackTraceElement(j2 + 1, (StackTraceElement) null));
        } else {
            shrunkStackTraceElementArr = null;
        }
        return z2 ? (ShrunkStackTraceElement[]) arrayList.toArray(new ShrunkStackTraceElement[0]) : shrunkStackTraceElementArr;
    }

    public final boolean a(StackTraceElement[] stackTraceElementArr) {
        if (this.f36316d == null) {
            return false;
        }
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            if (!(className == null || methodName == null)) {
                if (this.f36316d.contains(className + '.' + methodName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String a(Thread thread) {
        return thread.getName() + " (state = " + thread.getState() + ")";
    }
}
