package com.squareup.picasso;

import android.net.NetworkInfo;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestHandler;
import java.io.IOException;
import okhttp3.CacheControl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Source;

class NetworkRequestHandler extends RequestHandler {
    private static final String SCHEME_HTTP = "http";
    private static final String SCHEME_HTTPS = "https";
    private final Downloader downloader;
    private final Stats stats;

    static class ContentLengthException extends IOException {
        ContentLengthException(String str) {
            super(str);
        }
    }

    static final class ResponseException extends IOException {
        final int code;
        final int networkPolicy;

        ResponseException(int i2, int i3) {
            super("HTTP " + i2);
            this.code = i2;
            this.networkPolicy = i3;
        }
    }

    NetworkRequestHandler(Downloader downloader2, Stats stats2) {
        this.downloader = downloader2;
        this.stats = stats2;
    }

    private static Request createRequest(Request request, int i2) {
        CacheControl cacheControl;
        if (i2 == 0) {
            cacheControl = null;
        } else if (NetworkPolicy.isOfflineOnly(i2)) {
            cacheControl = CacheControl.FORCE_CACHE;
        } else {
            CacheControl.Builder builder = new CacheControl.Builder();
            if (!NetworkPolicy.shouldReadFromDiskCache(i2)) {
                builder.noCache();
            }
            if (!NetworkPolicy.shouldWriteToDiskCache(i2)) {
                builder.noStore();
            }
            cacheControl = builder.build();
        }
        Request.Builder url = new Request.Builder().url(request.uri.toString());
        if (cacheControl != null) {
            url.cacheControl(cacheControl);
        }
        return url.build();
    }

    public boolean canHandleRequest(Request request) {
        String scheme = request.uri.getScheme();
        if ("http".equals(scheme) || "https".equals(scheme)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public int getRetryCount() {
        return 2;
    }

    public RequestHandler.Result load(Request request, int i2) throws IOException {
        Picasso.LoadedFrom loadedFrom;
        Response load = this.downloader.load(createRequest(request, i2));
        ResponseBody body = load.body();
        if (load.isSuccessful()) {
            if (load.cacheResponse() == null) {
                loadedFrom = Picasso.LoadedFrom.NETWORK;
            } else {
                loadedFrom = Picasso.LoadedFrom.DISK;
            }
            if (loadedFrom == Picasso.LoadedFrom.DISK && body.contentLength() == 0) {
                body.close();
                throw new ContentLengthException("Received response with 0 content-length header.");
            }
            if (loadedFrom == Picasso.LoadedFrom.NETWORK && body.contentLength() > 0) {
                this.stats.dispatchDownloadFinished(body.contentLength());
            }
            return new RequestHandler.Result((Source) body.source(), loadedFrom);
        }
        body.close();
        throw new ResponseException(load.code(), request.networkPolicy);
    }

    /* access modifiers changed from: package-private */
    public boolean shouldRetry(boolean z2, NetworkInfo networkInfo) {
        return networkInfo == null || networkInfo.isConnected();
    }

    /* access modifiers changed from: package-private */
    public boolean supportsReplay() {
        return true;
    }
}
