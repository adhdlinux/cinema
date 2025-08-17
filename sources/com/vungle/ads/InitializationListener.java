package com.vungle.ads;

public interface InitializationListener {
    void onError(VungleError vungleError);

    void onSuccess();
}
