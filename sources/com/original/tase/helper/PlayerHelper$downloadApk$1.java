package com.original.tase.helper;

import android.os.Environment;
import androidx.appcompat.app.AppCompatActivity;
import com.google.protobuf.CodedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

public final class PlayerHelper$downloadApk$1 implements Callback {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ PlayerHelper f33852b;

    PlayerHelper$downloadApk$1(PlayerHelper playerHelper) {
        this.f33852b = playerHelper;
    }

    public void onFailure(Call call, IOException iOException) {
        Intrinsics.f(call, "call");
        Intrinsics.f(iOException, "e");
        PlayerHelper playerHelper = this.f33852b;
        playerHelper.K(new PlayerHelper$downloadApk$1$onFailure$1(playerHelper));
    }

    public void onResponse(Call call, Response response) {
        ResponseBody body;
        File file;
        AppCompatActivity appCompatActivity;
        Intrinsics.f(call, "call");
        Intrinsics.f(response, "response");
        WeakReference s2 = this.f33852b.f33845h;
        if (s2 != null && ((AppCompatActivity) s2.get()) != null && (body = response.body()) != null) {
            PlayerHelper playerHelper = this.f33852b;
            WeakReference s3 = playerHelper.f33845h;
            if (s3 == null || (appCompatActivity = (AppCompatActivity) s3.get()) == null) {
                file = null;
            } else {
                file = appCompatActivity.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
            }
            File file2 = new File(file, "app-release.apk");
            InputStream byteStream = body.byteStream();
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];
            long contentLength = body.contentLength();
            long j2 = 0;
            while (true) {
                int read = byteStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                    j2 += (long) read;
                    playerHelper.K(new PlayerHelper$downloadApk$1$onResponse$1$2(playerHelper, (int) ((((long) 100) * j2) / contentLength)));
                } else {
                    fileOutputStream.close();
                    byteStream.close();
                    playerHelper.K(new PlayerHelper$downloadApk$1$onResponse$1$3(playerHelper, file2));
                    return;
                }
            }
        }
    }
}
