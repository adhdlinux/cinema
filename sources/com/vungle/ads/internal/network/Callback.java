package com.vungle.ads.internal.network;

public interface Callback<T> {
    void onFailure(Call<T> call, Throwable th);

    void onResponse(Call<T> call, Response<T> response);
}
