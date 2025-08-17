package androidx.media3.datasource;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import c.a;
import java.util.ArrayList;
import java.util.Map;

public abstract class BaseDataSource implements DataSource {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f4802a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<TransferListener> f4803b = new ArrayList<>(1);

    /* renamed from: c  reason: collision with root package name */
    private int f4804c;

    /* renamed from: d  reason: collision with root package name */
    private DataSpec f4805d;

    protected BaseDataSource(boolean z2) {
        this.f4802a = z2;
    }

    public /* synthetic */ Map d() {
        return a.a(this);
    }

    public final void n(TransferListener transferListener) {
        Assertions.f(transferListener);
        if (!this.f4803b.contains(transferListener)) {
            this.f4803b.add(transferListener);
            this.f4804c++;
        }
    }

    /* access modifiers changed from: protected */
    public final void o(int i2) {
        DataSpec dataSpec = (DataSpec) Util.i(this.f4805d);
        for (int i3 = 0; i3 < this.f4804c; i3++) {
            this.f4803b.get(i3).f(this, dataSpec, this.f4802a, i2);
        }
    }

    /* access modifiers changed from: protected */
    public final void p() {
        DataSpec dataSpec = (DataSpec) Util.i(this.f4805d);
        for (int i2 = 0; i2 < this.f4804c; i2++) {
            this.f4803b.get(i2).h(this, dataSpec, this.f4802a);
        }
        this.f4805d = null;
    }

    /* access modifiers changed from: protected */
    public final void q(DataSpec dataSpec) {
        for (int i2 = 0; i2 < this.f4804c; i2++) {
            this.f4803b.get(i2).i(this, dataSpec, this.f4802a);
        }
    }

    /* access modifiers changed from: protected */
    public final void r(DataSpec dataSpec) {
        this.f4805d = dataSpec;
        for (int i2 = 0; i2 < this.f4804c; i2++) {
            this.f4803b.get(i2).g(this, dataSpec, this.f4802a);
        }
    }
}
