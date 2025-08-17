package com.uwetrottmann.trakt5.services;

import com.uwetrottmann.trakt5.entities.AccessToken;
import com.uwetrottmann.trakt5.entities.AccessTokenRefreshRequest;
import com.uwetrottmann.trakt5.entities.AccessTokenRequest;
import com.uwetrottmann.trakt5.entities.ClientId;
import com.uwetrottmann.trakt5.entities.DeviceCode;
import com.uwetrottmann.trakt5.entities.DeviceCodeAccessTokenRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Authentication {
    @POST("oauth/token")
    Call<AccessToken> exchangeCodeForAccessToken(@Body AccessTokenRequest accessTokenRequest);

    @POST("oauth/device/token")
    Call<AccessToken> exchangeDeviceCodeForAccessToken(@Body DeviceCodeAccessTokenRequest deviceCodeAccessTokenRequest);

    @POST("oauth/device/code")
    Call<DeviceCode> generateDeviceCode(@Body ClientId clientId);

    @POST("oauth/token")
    Call<AccessToken> refreshAccessToken(@Body AccessTokenRefreshRequest accessTokenRefreshRequest);
}
