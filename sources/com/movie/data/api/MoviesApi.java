package com.movie.data.api;

import com.movie.data.model.AppConfig;
import com.movie.data.model.cinema.KeyResponse;
import com.movie.data.model.cinema.Movie;
import com.movie.data.model.cinema.SyncLink;
import com.movie.data.model.cinema.SyncSeasonPack;
import com.movie.data.model.gamechallenge.GameChallengeModel;
import com.movie.data.model.payment.bitcoin.BitcoinAddressResponse;
import com.movie.data.model.payment.bitcoin.BitcoinAdressRequest;
import com.movie.data.model.payment.bitcoin.BitcoinCancelPaymentRequest;
import com.movie.data.model.payment.bitcoin.BitcoinPaymentInfo;
import com.movie.data.model.payment.bitcoin.ProductResponse;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MoviesApi {
    @POST("key/active/{key}")
    Observable<AppConfig> activeKey(@Path("key") String str);

    @POST("payment/bit/v2/cancelpayment")
    Observable<ResponseBody> cancelPayment(@Body BitcoinCancelPaymentRequest bitcoinCancelPaymentRequest);

    @POST("payment/bit/v2/checkpaymentprocess")
    Observable<BitcoinAddressResponse> checkPaymentProcess(@Body BitcoinAdressRequest bitcoinAdressRequest);

    @POST("key/deactive/{key}")
    Observable<AppConfig> deactiveKey(@Path("key") String str, @Header("device_id") String str2);

    @GET("key/info/{key}")
    Observable<KeyResponse> getActivateInfo(@Path("key") String str, @Header("transaction_hash") String str2, @Header("email") String str3);

    @GET("config")
    @Headers({"Cache-control: no-cache"})
    Observable<AppConfig> getConfig();

    @GET("link/dvdlist")
    Observable<ResponseBody> getDvdList(@Query("page") int i2, @Query("type") String str);

    @GET("gamechallenge/data")
    Observable<String> getGameChallengeData(@Query("gameid") String str, @Header("deviceID") String str2);

    @GET("gamechallenge/list")
    Observable<GameChallengeModel> getGameChallengeList(@Query("os") String str, @Header("deviceID") String str2);

    @GET("link/hdlist")
    Observable<Movie.Response> getHDList(@Query("page") int i2);

    @GET("link/get")
    Observable<ResponseBody> getlink();

    @GET("health-check")
    Observable<String> healthCheck();

    @GET("payment/bit/v2/info")
    Observable<BitcoinPaymentInfo> paymentInfo(@Query("address") String str, @Query("email") String str2, @Query("deviceID") String str3, @Query("deviceName") String str4, @Query("isSplitKey") Boolean bool);

    @GET("payment/bit/v2/products")
    Observable<ProductResponse> productList();

    @POST("payment/bit/v2/requestaddress")
    Observable<BitcoinAddressResponse> requestAddress(@Body BitcoinAdressRequest bitcoinAdressRequest);

    @POST("link/push")
    Observable<ResponseBody> syncLink(@Body SyncLink syncLink);

    @POST("link/seasonpack")
    Observable<ResponseBody> syncSeasonPack(@Body SyncSeasonPack syncSeasonPack);
}
