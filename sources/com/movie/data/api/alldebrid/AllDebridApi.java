package com.movie.data.api.alldebrid;

import com.original.tase.model.debrid.alldebrid.ADPin;
import com.original.tase.model.debrid.alldebrid.ADResponceLink;
import com.original.tase.model.debrid.alldebrid.ADstatus;
import com.original.tase.model.debrid.alldebrid.ADstatusSingle;
import com.original.tase.model.debrid.alldebrid.Torrent.ADTorrentInstant;
import com.original.tase.model.debrid.alldebrid.Torrent.ADTorrentUpload;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AllDebridApi {
    @GET("/v4/magnet/delete")
    Call<ResponseBody> delete(@Query("id") String str);

    @GET("/v4/magnet/instant")
    Call<ADTorrentInstant> getAllDebridInstance(@Query("magnets[]=") List<String> list);

    @GET("/v4/pin/get")
    Call<ADPin> getPin();

    @GET("/v4/link/unlock")
    Call<ADResponceLink> getdownloadlink(@Query("link") String str);

    @GET("/v4/magnet/status")
    Call<ADstatus> status(@Query("status") String str);

    @GET("/v4/magnet/status")
    Call<ADstatusSingle> status(@Query("id") String str, @Query("status") String str2);

    @FormUrlEncoded
    @POST("/v4/magnet/upload")
    Call<ADTorrentUpload> uploadMagnet(@Field("magnets[]=") List<String> list);
}
