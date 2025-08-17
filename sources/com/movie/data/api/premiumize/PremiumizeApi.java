package com.movie.data.api.premiumize;

import com.movie.data.model.premiumize.FolderList;
import com.movie.data.model.premiumize.ItemDetails;
import com.movie.data.model.premiumize.TransferCreate;
import com.movie.data.model.premiumize.TransferList;
import com.original.tase.model.debrid.premiumize.PremiumizeCacheCheckResponse;
import com.original.tase.model.debrid.premiumize.PremiumizeCreateFolderPesponse;
import com.original.tase.model.debrid.premiumize.PremiumizeDirectDL;
import com.original.tase.model.debrid.premiumize.PremiumizeTorrentDirectDL;
import com.original.tase.model.debrid.premiumize.PremiumizeUserInfo;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface PremiumizeApi {
    @FormUrlEncoded
    @POST("/api/folder/delete")
    Call<ResponseBody> folderDelete(@Field("apikey") String str, @Field("id") String str2);

    @GET("/api/folder/list")
    Call<FolderList> folderList(@Query("apikey") String str, @Query("id") String str2, @Query("includebreadcrumbs") Boolean bool);

    @FormUrlEncoded
    @POST("/api/cache/check")
    Call<PremiumizeCacheCheckResponse> getPremiumizeCacheCheckResponse(@Field("apikey") String str, @Query("items[]") String[] strArr);

    @FormUrlEncoded
    @POST("/api/folder/create")
    Call<PremiumizeCreateFolderPesponse> getPremiumizeCreateFolderPesponse(@Field("apikey") String str, @Field("name") String str2);

    @FormUrlEncoded
    @POST("/api/transfer/directdl")
    Call<PremiumizeDirectDL> getPremiumizeDirectDL(@Field("apikey") String str, @Field("src") String str2);

    @FormUrlEncoded
    @POST("/api/transfer/directdl")
    Call<PremiumizeTorrentDirectDL> getPremiumizeTorrentDirectDL(@Field("apikey") String str, @Field("src") String str2);

    @FormUrlEncoded
    @POST("/api/transfer/create")
    Call<ResponseBody> getPremiumizeTransferPesponse(@Field("apikey") String str, @Field("src") String str2);

    @FormUrlEncoded
    @POST("/api/account/info")
    Call<PremiumizeUserInfo> getPremiumizeUserInfo(@Field("apikey") String str);

    @FormUrlEncoded
    @POST("/api/item/delete")
    Call<ResponseBody> itemDelete(@Field("apikey") String str, @Field("id") String str2);

    @GET("/api/item/details")
    Call<ItemDetails> itemDetails(@Query("apikey") String str, @Query("id") String str2);

    @FormUrlEncoded
    @POST("/api/transfer/create")
    Call<TransferCreate> transferCreate(@Field("apikey") String str, @Field("src") String str2);

    @FormUrlEncoded
    @POST("/api/transfer/delete")
    Call<ResponseBody> transferdelete(@Field("apikey") String str, @Field("id") String str2);

    @GET("/api/transfer/list")
    Call<TransferList> transferlist(@Query("apikey") String str);
}
