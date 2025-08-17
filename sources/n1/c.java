package n1;

import android.content.DialogInterface;
import com.yoku.house.ads.HouseAdsDialog;

public final /* synthetic */ class c implements DialogInterface.OnDismissListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HouseAdsDialog f41300b;

    public /* synthetic */ c(HouseAdsDialog houseAdsDialog) {
        this.f41300b = houseAdsDialog;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.f41300b.k(dialogInterface);
    }
}
