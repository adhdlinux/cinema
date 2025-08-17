package org.jsoup;

import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

public interface Connection {

    public interface Base<T extends Base> {
        T b(String str, String str2);

        URL h();

        T i(String str, String str2);

        Map<String, String> l();

        Method method();

        T n(String str);

        T p(URL url);

        T q(Method method);

        boolean r(String str);

        Map<String, List<String>> t();
    }

    public interface KeyVal {
        String a();

        boolean b();

        InputStream d();

        String key();

        String value();
    }

    public enum Method {
        GET(false),
        POST(true),
        PUT(true),
        DELETE(false),
        PATCH(true),
        HEAD(false),
        OPTIONS(false),
        TRACE(false);
        

        /* renamed from: b  reason: collision with root package name */
        private final boolean f41495b;

        private Method(boolean z2) {
            this.f41495b = z2;
        }

        public final boolean a() {
            return this.f41495b;
        }
    }

    public interface Request extends Base<Request> {
        Request a(int i2);

        Request c(boolean z2);

        boolean d();

        String e();

        Request f(String str);

        boolean g();

        Proxy j();

        Collection<KeyVal> k();

        boolean m();

        Request o(Parser parser);

        Parser parser();

        boolean s();

        int timeout();

        String u();

        int v();
    }

    public interface Response extends Base<Response> {
        Document parse() throws IOException;
    }

    Connection a(int i2);

    Connection b(String str, String str2);

    Connection c(boolean z2);

    Connection d(String str);

    Document get() throws IOException;
}
