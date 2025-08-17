package com.vungle.ads.internal.load;

import com.vungle.ads.VungleAdSize;
import com.vungle.ads.internal.model.BidPayload;
import com.vungle.ads.internal.model.Placement;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

public final class AdRequest implements Serializable {
    private final BidPayload adMarkup;
    private final Placement placement;
    private final VungleAdSize requestAdSize;

    public AdRequest(Placement placement2, BidPayload bidPayload, VungleAdSize vungleAdSize) {
        Intrinsics.f(placement2, "placement");
        this.placement = placement2;
        this.adMarkup = bidPayload;
        this.requestAdSize = vungleAdSize;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.a(AdRequest.class, obj.getClass())) {
            return false;
        }
        AdRequest adRequest = (AdRequest) obj;
        if (!Intrinsics.a(this.placement.getReferenceId(), adRequest.placement.getReferenceId()) || !Intrinsics.a(this.requestAdSize, adRequest.requestAdSize)) {
            return false;
        }
        BidPayload bidPayload = this.adMarkup;
        BidPayload bidPayload2 = adRequest.adMarkup;
        if (bidPayload != null) {
            return Intrinsics.a(bidPayload, bidPayload2);
        }
        if (bidPayload2 == null) {
            return true;
        }
        return false;
    }

    public final BidPayload getAdMarkup() {
        return this.adMarkup;
    }

    public final Placement getPlacement() {
        return this.placement;
    }

    public final VungleAdSize getRequestAdSize() {
        return this.requestAdSize;
    }

    public int hashCode() {
        int i2;
        int hashCode = this.placement.getReferenceId().hashCode() * 31;
        VungleAdSize vungleAdSize = this.requestAdSize;
        int i3 = 0;
        if (vungleAdSize != null) {
            i2 = vungleAdSize.hashCode();
        } else {
            i2 = 0;
        }
        int i4 = (hashCode + i2) * 31;
        BidPayload bidPayload = this.adMarkup;
        if (bidPayload != null) {
            i3 = bidPayload.hashCode();
        }
        return i4 + i3;
    }

    public String toString() {
        return "AdRequest{placementId='" + this.placement.getReferenceId() + "', adMarkup=" + this.adMarkup + ", requestAdSize=" + this.requestAdSize + '}';
    }
}
