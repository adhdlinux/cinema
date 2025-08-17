package com.vungle.ads;

public interface BidTokenCallback {
    void onBidTokenCollected(String str);

    void onBidTokenError(String str);
}
