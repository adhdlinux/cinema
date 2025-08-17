package retrofit2;

import java.util.Objects;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.OkHttpCall;

public final class Response<T> {
    private final T body;
    private final ResponseBody errorBody;
    private final okhttp3.Response rawResponse;

    private Response(okhttp3.Response response, T t2, ResponseBody responseBody) {
        this.rawResponse = response;
        this.body = t2;
        this.errorBody = responseBody;
    }

    public static <T> Response<T> error(int i2, ResponseBody responseBody) {
        Objects.requireNonNull(responseBody, "body == null");
        if (i2 >= 400) {
            return error(responseBody, new Response.Builder().body(new OkHttpCall.NoContentResponseBody(responseBody.contentType(), responseBody.contentLength())).code(i2).message("Response.error()").protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
        }
        throw new IllegalArgumentException("code < 400: " + i2);
    }

    public static <T> Response<T> success(T t2) {
        return success(t2, new Response.Builder().code(200).message("OK").protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
    }

    public T body() {
        return this.body;
    }

    public int code() {
        return this.rawResponse.code();
    }

    public ResponseBody errorBody() {
        return this.errorBody;
    }

    public Headers headers() {
        return this.rawResponse.headers();
    }

    public boolean isSuccessful() {
        return this.rawResponse.isSuccessful();
    }

    public String message() {
        return this.rawResponse.message();
    }

    public okhttp3.Response raw() {
        return this.rawResponse;
    }

    public String toString() {
        return this.rawResponse.toString();
    }

    public static <T> Response<T> success(int i2, T t2) {
        if (i2 >= 200 && i2 < 300) {
            return success(t2, new Response.Builder().code(i2).message("Response.success()").protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
        }
        throw new IllegalArgumentException("code < 200 or >= 300: " + i2);
    }

    public static <T> Response<T> error(ResponseBody responseBody, okhttp3.Response response) {
        Objects.requireNonNull(responseBody, "body == null");
        Objects.requireNonNull(response, "rawResponse == null");
        if (!response.isSuccessful()) {
            return new Response<>(response, (Object) null, responseBody);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    public static <T> Response<T> success(T t2, Headers headers) {
        Objects.requireNonNull(headers, "headers == null");
        return success(t2, new Response.Builder().code(200).message("OK").protocol(Protocol.HTTP_1_1).headers(headers).request(new Request.Builder().url("http://localhost/").build()).build());
    }

    public static <T> Response<T> success(T t2, okhttp3.Response response) {
        Objects.requireNonNull(response, "rawResponse == null");
        if (response.isSuccessful()) {
            return new Response<>(response, t2, (ResponseBody) null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }
}
