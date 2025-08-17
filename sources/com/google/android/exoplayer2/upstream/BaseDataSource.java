package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Map;
import u0.b;

public abstract class BaseDataSource implements DataSource {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f28318a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<TransferListener> f28319b = new ArrayList<>(1);

    /* renamed from: c  reason: collision with root package name */
    private int f28320c;

    /* renamed from: d  reason: collision with root package name */
    private DataSpec f28321d;

    protected BaseDataSource(boolean z2) {
        this.f28318a = z2;
    }

    public /* synthetic */ Map d() {
        return b.a(this);
    }

    public final void p(TransferListener transferListener) {
        Assertions.e(transferListener);
        if (!this.f28319b.contains(transferListener)) {
            this.f28319b.add(transferListener);
            this.f28320c++;
        }
    }

    /* access modifiers changed from: protected */
    public final void s(int i2) {
        DataSpec dataSpec = (DataSpec) Util.j(this.f28321d);
        for (int i3 = 0; i3 < this.f28320c; i3++) {
            this.f28319b.get(i3).f(this, dataSpec, this.f28318a, i2);
        }
    }

    /* access modifiers changed from: protected */
    public final void t() {
        DataSpec dataSpec = (DataSpec) Util.j(this.f28321d);
        for (int i2 = 0; i2 < this.f28320c; i2++) {
            this.f28319b.get(i2).d(this, dataSpec, this.f28318a);
        }
        this.f28321d = null;
    }

    /* access modifiers changed from: protected */
    public final void u(DataSpec dataSpec) {
        for (int i2 = 0; i2 < this.f28320c; i2++) {
            this.f28319b.get(i2).i(this, dataSpec, this.f28318a);
        }
    }

    /* access modifiers changed from: protected */
    public final void v(DataSpec dataSpec) {
        this.f28321d = dataSpec;
        for (int i2 = 0; i2 < this.f28320c; i2++) {
            this.f28319b.get(i2).h(this, dataSpec, this.f28318a);
        }
    }
}
