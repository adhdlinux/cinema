package androidx.work.impl.model;

import androidx.arch.core.util.Function;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class WorkSpec {

    /* renamed from: s  reason: collision with root package name */
    private static final String f12514s = Logger.f("WorkSpec");

    /* renamed from: t  reason: collision with root package name */
    public static final Function<List<WorkInfoPojo>, List<WorkInfo>> f12515t = new Function<List<WorkInfoPojo>, List<WorkInfo>>() {
        /* renamed from: a */
        public List<WorkInfo> apply(List<WorkInfoPojo> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (WorkInfoPojo a2 : list) {
                arrayList.add(a2.a());
            }
            return arrayList;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public String f12516a;

    /* renamed from: b  reason: collision with root package name */
    public WorkInfo.State f12517b = WorkInfo.State.ENQUEUED;

    /* renamed from: c  reason: collision with root package name */
    public String f12518c;

    /* renamed from: d  reason: collision with root package name */
    public String f12519d;

    /* renamed from: e  reason: collision with root package name */
    public Data f12520e;

    /* renamed from: f  reason: collision with root package name */
    public Data f12521f;

    /* renamed from: g  reason: collision with root package name */
    public long f12522g;

    /* renamed from: h  reason: collision with root package name */
    public long f12523h;

    /* renamed from: i  reason: collision with root package name */
    public long f12524i;

    /* renamed from: j  reason: collision with root package name */
    public Constraints f12525j;

    /* renamed from: k  reason: collision with root package name */
    public int f12526k;

    /* renamed from: l  reason: collision with root package name */
    public BackoffPolicy f12527l;

    /* renamed from: m  reason: collision with root package name */
    public long f12528m;

    /* renamed from: n  reason: collision with root package name */
    public long f12529n;

    /* renamed from: o  reason: collision with root package name */
    public long f12530o;

    /* renamed from: p  reason: collision with root package name */
    public long f12531p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f12532q;

    /* renamed from: r  reason: collision with root package name */
    public OutOfQuotaPolicy f12533r;

    public static class IdAndState {

        /* renamed from: a  reason: collision with root package name */
        public String f12534a;

        /* renamed from: b  reason: collision with root package name */
        public WorkInfo.State f12535b;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IdAndState)) {
                return false;
            }
            IdAndState idAndState = (IdAndState) obj;
            if (this.f12535b != idAndState.f12535b) {
                return false;
            }
            return this.f12534a.equals(idAndState.f12534a);
        }

        public int hashCode() {
            return (this.f12534a.hashCode() * 31) + this.f12535b.hashCode();
        }
    }

    public static class WorkInfoPojo {

        /* renamed from: a  reason: collision with root package name */
        public String f12536a;

        /* renamed from: b  reason: collision with root package name */
        public WorkInfo.State f12537b;

        /* renamed from: c  reason: collision with root package name */
        public Data f12538c;

        /* renamed from: d  reason: collision with root package name */
        public int f12539d;

        /* renamed from: e  reason: collision with root package name */
        public List<String> f12540e;

        /* renamed from: f  reason: collision with root package name */
        public List<Data> f12541f;

        public WorkInfo a() {
            Data data;
            List<Data> list = this.f12541f;
            if (list == null || list.isEmpty()) {
                data = Data.f12167c;
            } else {
                data = this.f12541f.get(0);
            }
            return new WorkInfo(UUID.fromString(this.f12536a), this.f12537b, this.f12538c, this.f12540e, data, this.f12539d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WorkInfoPojo)) {
                return false;
            }
            WorkInfoPojo workInfoPojo = (WorkInfoPojo) obj;
            if (this.f12539d != workInfoPojo.f12539d) {
                return false;
            }
            String str = this.f12536a;
            if (str == null ? workInfoPojo.f12536a != null : !str.equals(workInfoPojo.f12536a)) {
                return false;
            }
            if (this.f12537b != workInfoPojo.f12537b) {
                return false;
            }
            Data data = this.f12538c;
            if (data == null ? workInfoPojo.f12538c != null : !data.equals(workInfoPojo.f12538c)) {
                return false;
            }
            List<String> list = this.f12540e;
            if (list == null ? workInfoPojo.f12540e != null : !list.equals(workInfoPojo.f12540e)) {
                return false;
            }
            List<Data> list2 = this.f12541f;
            List<Data> list3 = workInfoPojo.f12541f;
            if (list2 != null) {
                return list2.equals(list3);
            }
            if (list3 == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i2;
            int i3;
            int i4;
            int i5;
            String str = this.f12536a;
            int i6 = 0;
            if (str != null) {
                i2 = str.hashCode();
            } else {
                i2 = 0;
            }
            int i7 = i2 * 31;
            WorkInfo.State state = this.f12537b;
            if (state != null) {
                i3 = state.hashCode();
            } else {
                i3 = 0;
            }
            int i8 = (i7 + i3) * 31;
            Data data = this.f12538c;
            if (data != null) {
                i4 = data.hashCode();
            } else {
                i4 = 0;
            }
            int i9 = (((i8 + i4) * 31) + this.f12539d) * 31;
            List<String> list = this.f12540e;
            if (list != null) {
                i5 = list.hashCode();
            } else {
                i5 = 0;
            }
            int i10 = (i9 + i5) * 31;
            List<Data> list2 = this.f12541f;
            if (list2 != null) {
                i6 = list2.hashCode();
            }
            return i10 + i6;
        }
    }

    public WorkSpec(String str, String str2) {
        Data data = Data.f12167c;
        this.f12520e = data;
        this.f12521f = data;
        this.f12525j = Constraints.f12136i;
        this.f12527l = BackoffPolicy.EXPONENTIAL;
        this.f12528m = NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS;
        this.f12531p = -1;
        this.f12533r = OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.f12516a = str;
        this.f12518c = str2;
    }

    public long a() {
        long j2;
        long j3;
        boolean z2 = false;
        if (c()) {
            if (this.f12527l == BackoffPolicy.LINEAR) {
                z2 = true;
            }
            if (z2) {
                j3 = this.f12528m * ((long) this.f12526k);
            } else {
                j3 = (long) Math.scalb((float) this.f12528m, this.f12526k - 1);
            }
            return this.f12529n + Math.min(18000000, j3);
        }
        long j4 = 0;
        if (d()) {
            long currentTimeMillis = System.currentTimeMillis();
            long j5 = this.f12529n;
            if (j5 == 0) {
                j2 = currentTimeMillis + this.f12522g;
            } else {
                j2 = j5;
            }
            long j6 = this.f12524i;
            long j7 = this.f12523h;
            if (j6 != j7) {
                z2 = true;
            }
            if (z2) {
                if (j5 == 0) {
                    j4 = j6 * -1;
                }
                return j2 + j7 + j4;
            }
            if (j5 != 0) {
                j4 = j7;
            }
            return j2 + j4;
        }
        long j8 = this.f12529n;
        if (j8 == 0) {
            j8 = System.currentTimeMillis();
        }
        return j8 + this.f12522g;
    }

    public boolean b() {
        return !Constraints.f12136i.equals(this.f12525j);
    }

    public boolean c() {
        return this.f12517b == WorkInfo.State.ENQUEUED && this.f12526k > 0;
    }

    public boolean d() {
        return this.f12523h != 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || WorkSpec.class != obj.getClass()) {
            return false;
        }
        WorkSpec workSpec = (WorkSpec) obj;
        if (this.f12522g != workSpec.f12522g || this.f12523h != workSpec.f12523h || this.f12524i != workSpec.f12524i || this.f12526k != workSpec.f12526k || this.f12528m != workSpec.f12528m || this.f12529n != workSpec.f12529n || this.f12530o != workSpec.f12530o || this.f12531p != workSpec.f12531p || this.f12532q != workSpec.f12532q || !this.f12516a.equals(workSpec.f12516a) || this.f12517b != workSpec.f12517b || !this.f12518c.equals(workSpec.f12518c)) {
            return false;
        }
        String str = this.f12519d;
        if (str == null ? workSpec.f12519d != null : !str.equals(workSpec.f12519d)) {
            return false;
        }
        if (this.f12520e.equals(workSpec.f12520e) && this.f12521f.equals(workSpec.f12521f) && this.f12525j.equals(workSpec.f12525j) && this.f12527l == workSpec.f12527l && this.f12533r == workSpec.f12533r) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i2;
        int hashCode = ((((this.f12516a.hashCode() * 31) + this.f12517b.hashCode()) * 31) + this.f12518c.hashCode()) * 31;
        String str = this.f12519d;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        long j2 = this.f12522g;
        long j3 = this.f12523h;
        long j4 = this.f12524i;
        long j5 = this.f12528m;
        long j6 = this.f12529n;
        long j7 = this.f12530o;
        long j8 = this.f12531p;
        return ((((((((((((((((((((((((((((hashCode + i2) * 31) + this.f12520e.hashCode()) * 31) + this.f12521f.hashCode()) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + this.f12525j.hashCode()) * 31) + this.f12526k) * 31) + this.f12527l.hashCode()) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31) + ((int) (j7 ^ (j7 >>> 32)))) * 31) + ((int) (j8 ^ (j8 >>> 32)))) * 31) + (this.f12532q ? 1 : 0)) * 31) + this.f12533r.hashCode();
    }

    public String toString() {
        return "{WorkSpec: " + this.f12516a + "}";
    }

    public WorkSpec(WorkSpec workSpec) {
        Data data = Data.f12167c;
        this.f12520e = data;
        this.f12521f = data;
        this.f12525j = Constraints.f12136i;
        this.f12527l = BackoffPolicy.EXPONENTIAL;
        this.f12528m = NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS;
        this.f12531p = -1;
        this.f12533r = OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.f12516a = workSpec.f12516a;
        this.f12518c = workSpec.f12518c;
        this.f12517b = workSpec.f12517b;
        this.f12519d = workSpec.f12519d;
        this.f12520e = new Data(workSpec.f12520e);
        this.f12521f = new Data(workSpec.f12521f);
        this.f12522g = workSpec.f12522g;
        this.f12523h = workSpec.f12523h;
        this.f12524i = workSpec.f12524i;
        this.f12525j = new Constraints(workSpec.f12525j);
        this.f12526k = workSpec.f12526k;
        this.f12527l = workSpec.f12527l;
        this.f12528m = workSpec.f12528m;
        this.f12529n = workSpec.f12529n;
        this.f12530o = workSpec.f12530o;
        this.f12531p = workSpec.f12531p;
        this.f12532q = workSpec.f12532q;
        this.f12533r = workSpec.f12533r;
    }
}
