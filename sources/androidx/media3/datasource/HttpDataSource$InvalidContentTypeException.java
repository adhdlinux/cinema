package androidx.media3.datasource;

public final class HttpDataSource$InvalidContentTypeException extends HttpDataSource$HttpDataSourceException {

    /* renamed from: e  reason: collision with root package name */
    public final String f4891e;

    public HttpDataSource$InvalidContentTypeException(String str, DataSpec dataSpec) {
        super("Invalid content type: " + str, dataSpec, 2003, 1);
        this.f4891e = str;
    }
}
