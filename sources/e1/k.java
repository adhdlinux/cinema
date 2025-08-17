package e1;

import android.view.View;
import android.widget.AdapterView;
import com.original.tase.helper.PlayerHelper;
import com.original.tase.model.media.MediaSource;
import java.util.List;

public final /* synthetic */ class k implements AdapterView.OnItemClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f38188b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PlayerHelper f38189c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MediaSource f38190d;

    public /* synthetic */ k(List list, PlayerHelper playerHelper, MediaSource mediaSource) {
        this.f38188b = list;
        this.f38189c = playerHelper;
        this.f38190d = mediaSource;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        PlayerHelper.b0(this.f38188b, this.f38189c, this.f38190d, adapterView, view, i2, j2);
    }
}
