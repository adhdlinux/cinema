package com.movie.data.api.realdebrid;

import com.movie.data.model.realdebrid.AddMagnetResponse;
import com.movie.data.model.realdebrid.RealDebridTorrentInfoObject;
import com.movie.data.model.realdebrid.UnRestrictCheckObject;
import com.movie.data.model.realdebrid.UnRestrictObject;
import com.original.tase.model.debrid.realdebrid.RealDebridCheckAuthResult;
import com.original.tase.model.debrid.realdebrid.RealDebridGetDeviceCodeResult;
import com.original.tase.model.debrid.realdebrid.RealDebridGetTokenResult;
import com.original.tase.model.debrid.realdebrid.RealDebridUserInfor;
import java.util.List;
import java.util.Map;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RealDebridApi {
    @FormUrlEncoded
    @POST("rest/1.0/torrents/addMagnet")
    Call<AddMagnetResponse> addMagnet(@Field("magnet") String str, @Field("host") String str2);

    @PUT("rest/1.0/torrents/addTorrent")
    Call<AddMagnetResponse> addTorrent(@Query("host") String str);

    @DELETE("rest/1.0/torrents/delete/{id}")
    Call<ResponseBody> delete(@Path("id") String str);

    @GET("rest/1.0/user")
    Call<RealDebridUserInfor> getUserInfo();

    @GET("rest/1.0/torrents/instantAvailability/{hash}")
    Call<ResponseBody> instantAvailability(@Path("hash") String str);

    @GET("oauth/v2/device/code?new_credentials=yes")
    Call<RealDebridGetDeviceCodeResult> oauthDeviceCode(@Query("client_id") String str);

    @GET("oauth/v2/device/credentials")
    Call<RealDebridCheckAuthResult> oauthDeviceCredentials(@Query("client_id") String str, @Query("code") String str2);

    @FormUrlEncoded
    @POST("oauth/v2/token")
    Call<RealDebridGetTokenResult> oauthtoken(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("rest/1.0/torrents/selectFiles/{id}")
    Call<ResponseBody> selectFiles(@Path("id") String str, @Field("files") String str2);

    @GET("rest/1.0/torrents/info/{id}")
    Call<RealDebridTorrentInfoObject> torrentInfos(@Path("id") String str);

    @GET("rest/1.0/torrents")
    Call<List<RealDebridTorrentInfoObject>> torrents(@Query("offset") Integer num, @Query("page") Integer num2, @Query("limit") Integer num3, @Query("filter") String str);

    @FormUrlEncoded
    @POST("rest/1.0/unrestrict/check")
    Call<UnRestrictCheckObject> unrestrictCheck(@Field("link") String str, @Field("password") String str2);

    @FormUrlEncoded
    @POST("rest/1.0/unrestrict/containerLink")
    Call<List<String>> unrestrictContainerLink(@Field("link") String str);

    @FormUrlEncoded
    @POST("rest/1.0/unrestrict/link")
    Call<UnRestrictObject> unrestrictLink(@Field("link") String str, @Field("password") String str2, @Field("remote") Integer num);
}
