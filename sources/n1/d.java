package n1;

import android.view.View;
import com.yoku.house.ads.HouseAdsDialog;
import com.yoku.house.ads.model.DialogModal;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HouseAdsDialog f41301b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DialogModal f41302c;

    public /* synthetic */ d(HouseAdsDialog houseAdsDialog, DialogModal dialogModal) {
        this.f41301b = houseAdsDialog;
        this.f41302c = dialogModal;
    }

    public final void onClick(View view) {
        this.f41301b.l(this.f41302c, view);
    }
}
