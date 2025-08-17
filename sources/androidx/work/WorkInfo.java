package androidx.work;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public final class WorkInfo {

    /* renamed from: a  reason: collision with root package name */
    private UUID f12205a;

    /* renamed from: b  reason: collision with root package name */
    private State f12206b;

    /* renamed from: c  reason: collision with root package name */
    private Data f12207c;

    /* renamed from: d  reason: collision with root package name */
    private Set<String> f12208d;

    /* renamed from: e  reason: collision with root package name */
    private Data f12209e;

    /* renamed from: f  reason: collision with root package name */
    private int f12210f;

    public enum State {
        ENQUEUED,
        RUNNING,
        SUCCEEDED,
        FAILED,
        BLOCKED,
        CANCELLED;

        public boolean a() {
            return this == SUCCEEDED || this == FAILED || this == CANCELLED;
        }
    }

    public WorkInfo(UUID uuid, State state, Data data, List<String> list, Data data2, int i2) {
        this.f12205a = uuid;
        this.f12206b = state;
        this.f12207c = data;
        this.f12208d = new HashSet(list);
        this.f12209e = data2;
        this.f12210f = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || WorkInfo.class != obj.getClass()) {
            return false;
        }
        WorkInfo workInfo = (WorkInfo) obj;
        if (this.f12210f == workInfo.f12210f && this.f12205a.equals(workInfo.f12205a) && this.f12206b == workInfo.f12206b && this.f12207c.equals(workInfo.f12207c) && this.f12208d.equals(workInfo.f12208d)) {
            return this.f12209e.equals(workInfo.f12209e);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.f12205a.hashCode() * 31) + this.f12206b.hashCode()) * 31) + this.f12207c.hashCode()) * 31) + this.f12208d.hashCode()) * 31) + this.f12209e.hashCode()) * 31) + this.f12210f;
    }

    public String toString() {
        return "WorkInfo{mId='" + this.f12205a + '\'' + ", mState=" + this.f12206b + ", mOutputData=" + this.f12207c + ", mTags=" + this.f12208d + ", mProgress=" + this.f12209e + '}';
    }
}
