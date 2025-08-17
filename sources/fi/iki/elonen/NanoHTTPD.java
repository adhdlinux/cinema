package fi.iki.elonen;

import com.google.protobuf.CodedOutputStream;
import com.original.tase.model.socket.UserResponces;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;

public abstract class NanoHTTPD {
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final Pattern f38199h = Pattern.compile("[ |\t]*(charset)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;]*)['|\"]?", 2);
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final Pattern f38200i = Pattern.compile("[ |\t]*(boundary)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;]*)['|\"]?", 2);
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static final Pattern f38201j = Pattern.compile("([ |\t]*Content-Disposition[ |\t]*:)(.*)", 2);
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static final Pattern f38202k = Pattern.compile("([ |\t]*content-type[ |\t]*:)(.*)", 2);
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public static final Pattern f38203l = Pattern.compile("[ |\t]*([a-zA-Z]*)[ |\t]*=[ |\t]*['|\"]([^\"^']*)['|\"]");
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public static final Logger f38204m = Logger.getLogger(NanoHTTPD.class.getName());
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final String f38205a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final int f38206b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public volatile ServerSocket f38207c;

    /* renamed from: d  reason: collision with root package name */
    private ServerSocketFactory f38208d;

    /* renamed from: e  reason: collision with root package name */
    private Thread f38209e;

    /* renamed from: f  reason: collision with root package name */
    protected AsyncRunner f38210f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public TempFileManagerFactory f38211g;

    public interface AsyncRunner {
        void a(ClientHandler clientHandler);

        void b();

        void c(ClientHandler clientHandler);
    }

    public class ClientHandler implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final InputStream f38212b;

        /* renamed from: c  reason: collision with root package name */
        private final Socket f38213c;

        public void a() {
            NanoHTTPD.t(this.f38212b);
            NanoHTTPD.t(this.f38213c);
        }

        public void run() {
            OutputStream outputStream = null;
            try {
                outputStream = this.f38213c.getOutputStream();
                HTTPSession hTTPSession = new HTTPSession(NanoHTTPD.this.f38211g.create(), this.f38212b, outputStream, this.f38213c.getInetAddress());
                while (!this.f38213c.isClosed()) {
                    hTTPSession.i();
                }
            } catch (Exception e2) {
                if ((!(e2 instanceof SocketException) || !"NanoHttpd Shutdown".equals(e2.getMessage())) && !(e2 instanceof SocketTimeoutException)) {
                    NanoHTTPD.f38204m.log(Level.FINE, "Communication with the client broken", e2);
                }
            } catch (Throwable th) {
                NanoHTTPD.t((Object) null);
                NanoHTTPD.t(this.f38212b);
                NanoHTTPD.t(this.f38213c);
                NanoHTTPD.this.f38210f.a(this);
                throw th;
            }
            NanoHTTPD.t(outputStream);
            NanoHTTPD.t(this.f38212b);
            NanoHTTPD.t(this.f38213c);
            NanoHTTPD.this.f38210f.a(this);
        }

        private ClientHandler(InputStream inputStream, Socket socket) {
            this.f38212b = inputStream;
            this.f38213c = socket;
        }
    }

    public static class Cookie {

        /* renamed from: a  reason: collision with root package name */
        private final String f38215a;

        /* renamed from: b  reason: collision with root package name */
        private final String f38216b;

        /* renamed from: c  reason: collision with root package name */
        private final String f38217c;

        public String a() {
            return String.format("%s=%s; expires=%s", new Object[]{this.f38215a, this.f38216b, this.f38217c});
        }
    }

    public class CookieHandler implements Iterable<String> {

        /* renamed from: b  reason: collision with root package name */
        private final HashMap<String, String> f38218b = new HashMap<>();

        /* renamed from: c  reason: collision with root package name */
        private final ArrayList<Cookie> f38219c = new ArrayList<>();

        public CookieHandler(Map<String, String> map) {
            String str = map.get("cookie");
            if (str != null) {
                for (String trim : str.split(";")) {
                    String[] split = trim.trim().split("=");
                    if (split.length == 2) {
                        this.f38218b.put(split[0], split[1]);
                    }
                }
            }
        }

        public void a(Response response) {
            Iterator<Cookie> it2 = this.f38219c.iterator();
            while (it2.hasNext()) {
                response.a("Set-Cookie", it2.next().a());
            }
        }

        public Iterator<String> iterator() {
            return this.f38218b.keySet().iterator();
        }
    }

    public static class DefaultAsyncRunner implements AsyncRunner {

        /* renamed from: a  reason: collision with root package name */
        private long f38221a;

        /* renamed from: b  reason: collision with root package name */
        private final List<ClientHandler> f38222b = Collections.synchronizedList(new ArrayList());

        public void a(ClientHandler clientHandler) {
            this.f38222b.remove(clientHandler);
        }

        public void b() {
            Iterator it2 = new ArrayList(this.f38222b).iterator();
            while (it2.hasNext()) {
                ((ClientHandler) it2.next()).a();
            }
        }

        public void c(ClientHandler clientHandler) {
            this.f38221a++;
            Thread thread = new Thread(clientHandler);
            thread.setDaemon(true);
            thread.setName("NanoHttpd Request Processor (#" + this.f38221a + ")");
            this.f38222b.add(clientHandler);
            thread.start();
        }
    }

    public static class DefaultServerSocketFactory implements ServerSocketFactory {
        public ServerSocket create() throws IOException {
            return new ServerSocket();
        }
    }

    public static class DefaultTempFile implements TempFile {

        /* renamed from: a  reason: collision with root package name */
        private final File f38223a;

        /* renamed from: b  reason: collision with root package name */
        private final OutputStream f38224b;

        public DefaultTempFile(File file) throws IOException {
            File createTempFile = File.createTempFile("NanoHTTPD-", "", file);
            this.f38223a = createTempFile;
            this.f38224b = new FileOutputStream(createTempFile);
        }

        public void a() throws Exception {
            NanoHTTPD.t(this.f38224b);
            if (!this.f38223a.delete()) {
                throw new Exception("could not delete temporary file");
            }
        }

        public String getName() {
            return this.f38223a.getAbsolutePath();
        }
    }

    public static class DefaultTempFileManager implements TempFileManager {

        /* renamed from: a  reason: collision with root package name */
        private final File f38225a;

        /* renamed from: b  reason: collision with root package name */
        private final List<TempFile> f38226b;

        public DefaultTempFileManager() {
            File file = new File(System.getProperty("java.io.tmpdir"));
            this.f38225a = file;
            if (!file.exists()) {
                file.mkdirs();
            }
            this.f38226b = new ArrayList();
        }

        public TempFile a(String str) throws Exception {
            DefaultTempFile defaultTempFile = new DefaultTempFile(this.f38225a);
            this.f38226b.add(defaultTempFile);
            return defaultTempFile;
        }

        public void clear() {
            for (TempFile a2 : this.f38226b) {
                try {
                    a2.a();
                } catch (Exception e2) {
                    NanoHTTPD.f38204m.log(Level.WARNING, "could not delete file ", e2);
                }
            }
            this.f38226b.clear();
        }
    }

    private class DefaultTempFileManagerFactory implements TempFileManagerFactory {
        private DefaultTempFileManagerFactory() {
        }

        public TempFileManager create() {
            return new DefaultTempFileManager();
        }
    }

    protected class HTTPSession implements IHTTPSession {

        /* renamed from: a  reason: collision with root package name */
        private final TempFileManager f38228a;

        /* renamed from: b  reason: collision with root package name */
        private final OutputStream f38229b;

        /* renamed from: c  reason: collision with root package name */
        private final BufferedInputStream f38230c;

        /* renamed from: d  reason: collision with root package name */
        private int f38231d;

        /* renamed from: e  reason: collision with root package name */
        private int f38232e;

        /* renamed from: f  reason: collision with root package name */
        private String f38233f;

        /* renamed from: g  reason: collision with root package name */
        private Method f38234g;

        /* renamed from: h  reason: collision with root package name */
        private Map<String, String> f38235h;

        /* renamed from: i  reason: collision with root package name */
        private Map<String, String> f38236i;

        /* renamed from: j  reason: collision with root package name */
        private CookieHandler f38237j;

        /* renamed from: k  reason: collision with root package name */
        private String f38238k;

        /* renamed from: l  reason: collision with root package name */
        private String f38239l;

        /* renamed from: m  reason: collision with root package name */
        private String f38240m;

        public HTTPSession(TempFileManager tempFileManager, InputStream inputStream, OutputStream outputStream, InetAddress inetAddress) {
            String str;
            this.f38228a = tempFileManager;
            this.f38230c = new BufferedInputStream(inputStream, 8192);
            this.f38229b = outputStream;
            if (inetAddress.isLoopbackAddress() || inetAddress.isAnyLocalAddress()) {
                str = "127.0.0.1";
            } else {
                str = inetAddress.getHostAddress().toString();
            }
            this.f38239l = str;
            this.f38236i = new HashMap();
        }

        private void f(BufferedReader bufferedReader, Map<String, String> map, Map<String, String> map2, Map<String, String> map3) throws ResponseException {
            String str;
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    StringTokenizer stringTokenizer = new StringTokenizer(readLine);
                    if (stringTokenizer.hasMoreTokens()) {
                        map.put("method", stringTokenizer.nextToken());
                        if (stringTokenizer.hasMoreTokens()) {
                            String nextToken = stringTokenizer.nextToken();
                            int indexOf = nextToken.indexOf(63);
                            if (indexOf >= 0) {
                                h(nextToken.substring(indexOf + 1), map2);
                                str = NanoHTTPD.o(nextToken.substring(0, indexOf));
                            } else {
                                str = NanoHTTPD.o(nextToken);
                            }
                            if (stringTokenizer.hasMoreTokens()) {
                                this.f38240m = stringTokenizer.nextToken();
                            } else {
                                this.f38240m = "HTTP/1.1";
                                NanoHTTPD.f38204m.log(Level.FINE, "no protocol version specified, strange. Assuming HTTP/1.1.");
                            }
                            String readLine2 = bufferedReader.readLine();
                            while (readLine2 != null && readLine2.trim().length() > 0) {
                                int indexOf2 = readLine2.indexOf(58);
                                if (indexOf2 >= 0) {
                                    map3.put(readLine2.substring(0, indexOf2).trim().toLowerCase(Locale.US), readLine2.substring(indexOf2 + 1).trim());
                                }
                                readLine2 = bufferedReader.readLine();
                            }
                            map.put("uri", str);
                            return;
                        }
                        throw new ResponseException(Response.Status.BAD_REQUEST, "BAD REQUEST: Missing URI. Usage: GET /example/file.html");
                    }
                    throw new ResponseException(Response.Status.BAD_REQUEST, "BAD REQUEST: Syntax error. Usage: GET /example/file.html");
                }
            } catch (IOException e2) {
                Response.Status status = Response.Status.INTERNAL_ERROR;
                throw new ResponseException(status, "SERVER INTERNAL ERROR: IOException: " + e2.getMessage(), e2);
            }
        }

        private void g(String str, String str2, ByteBuffer byteBuffer, Map<String, String> map, Map<String, String> map2) throws ResponseException {
            int i2;
            ByteBuffer byteBuffer2 = byteBuffer;
            Map<String, String> map3 = map;
            Map<String, String> map4 = map2;
            try {
                int[] m2 = m(byteBuffer2, str.getBytes());
                int i3 = 2;
                if (m2.length >= 2) {
                    int i4 = 1024;
                    byte[] bArr = new byte[1024];
                    int i5 = 0;
                    int i6 = 0;
                    while (i6 < m2.length - 1) {
                        byteBuffer2.position(m2[i6]);
                        if (byteBuffer.remaining() < i4) {
                            i2 = byteBuffer.remaining();
                        } else {
                            i2 = 1024;
                        }
                        byteBuffer2.get(bArr, i5, i2);
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr, i5, i2), Charset.forName(str2)), i2);
                        if (bufferedReader.readLine().contains(str)) {
                            String readLine = bufferedReader.readLine();
                            String str3 = null;
                            String str4 = null;
                            String str5 = null;
                            int i7 = 2;
                            while (readLine != null && readLine.trim().length() > 0) {
                                Matcher matcher = NanoHTTPD.f38201j.matcher(readLine);
                                if (matcher.matches()) {
                                    Matcher matcher2 = NanoHTTPD.f38203l.matcher(matcher.group(i3));
                                    while (matcher2.find()) {
                                        String str6 = str4;
                                        String group = matcher2.group(1);
                                        if (group.equalsIgnoreCase("name")) {
                                            str5 = matcher2.group(2);
                                        } else if (group.equalsIgnoreCase("filename")) {
                                            str4 = matcher2.group(2);
                                        }
                                        str4 = str6;
                                    }
                                    String str7 = str4;
                                }
                                Matcher matcher3 = NanoHTTPD.f38202k.matcher(readLine);
                                if (matcher3.matches()) {
                                    str3 = matcher3.group(2).trim();
                                }
                                readLine = bufferedReader.readLine();
                                i7++;
                                i3 = 2;
                            }
                            int i8 = 0;
                            while (true) {
                                int i9 = i7 - 1;
                                if (i7 <= 0) {
                                    break;
                                }
                                i8 = p(bArr, i8);
                                i7 = i9;
                            }
                            if (i8 < i2 - 4) {
                                int i10 = m2[i6] + i8;
                                i6++;
                                int i11 = m2[i6] - 4;
                                byteBuffer2.position(i10);
                                if (str3 == null) {
                                    byte[] bArr2 = new byte[(i11 - i10)];
                                    byteBuffer2.get(bArr2);
                                    map3.put(str5, new String(bArr2, str2));
                                } else {
                                    String str8 = str2;
                                    String o2 = o(byteBuffer2, i10, i11 - i10, str4);
                                    if (!map4.containsKey(str5)) {
                                        map4.put(str5, o2);
                                    } else {
                                        int i12 = 2;
                                        while (true) {
                                            if (!map4.containsKey(str5 + i12)) {
                                                break;
                                            }
                                            i12++;
                                        }
                                        map4.put(str5 + i12, o2);
                                    }
                                    map3.put(str5, str4);
                                }
                                i4 = 1024;
                                i3 = 2;
                                i5 = 0;
                            } else {
                                throw new ResponseException(Response.Status.INTERNAL_ERROR, "Multipart header size exceeds MAX_HEADER_SIZE.");
                            }
                        } else {
                            throw new ResponseException(Response.Status.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but chunk does not start with boundary.");
                        }
                    }
                    return;
                }
                throw new ResponseException(Response.Status.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but contains less than two boundary strings.");
            } catch (ResponseException e2) {
                throw e2;
            } catch (Exception e3) {
                throw new ResponseException(Response.Status.INTERNAL_ERROR, e3.toString());
            }
        }

        private void h(String str, Map<String, String> map) {
            if (str == null) {
                this.f38238k = "";
                return;
            }
            this.f38238k = str;
            StringTokenizer stringTokenizer = new StringTokenizer(str, "&");
            while (stringTokenizer.hasMoreTokens()) {
                String nextToken = stringTokenizer.nextToken();
                int indexOf = nextToken.indexOf(61);
                if (indexOf >= 0) {
                    map.put(NanoHTTPD.o(nextToken.substring(0, indexOf)).trim(), NanoHTTPD.o(nextToken.substring(indexOf + 1)));
                } else {
                    map.put(NanoHTTPD.o(nextToken).trim(), "");
                }
            }
        }

        private int j(byte[] bArr, int i2) {
            int i3;
            int i4 = 0;
            while (true) {
                int i5 = i4 + 1;
                if (i5 >= i2) {
                    return 0;
                }
                byte b2 = bArr[i4];
                if (b2 == 13 && bArr[i5] == 10 && (i3 = i4 + 3) < i2 && bArr[i4 + 2] == 13 && bArr[i3] == 10) {
                    return i4 + 4;
                }
                if (b2 == 10 && bArr[i5] == 10) {
                    return i4 + 2;
                }
                i4 = i5;
            }
        }

        private String k(String str, Pattern pattern, String str2) {
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                return matcher.group(2);
            }
            return str2;
        }

        private int[] m(ByteBuffer byteBuffer, byte[] bArr) {
            int i2;
            int[] iArr = new int[0];
            if (byteBuffer.remaining() < bArr.length) {
                return iArr;
            }
            int length = bArr.length + CodedOutputStream.DEFAULT_BUFFER_SIZE;
            byte[] bArr2 = new byte[length];
            if (byteBuffer.remaining() < length) {
                i2 = byteBuffer.remaining();
            } else {
                i2 = length;
            }
            byteBuffer.get(bArr2, 0, i2);
            int length2 = i2 - bArr.length;
            int i3 = 0;
            do {
                int i4 = 0;
                while (i4 < length2) {
                    int i5 = 0;
                    while (i5 < bArr.length && bArr2[i4 + i5] == bArr[i5]) {
                        if (i5 == bArr.length - 1) {
                            int[] iArr2 = new int[(iArr.length + 1)];
                            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                            iArr2[iArr.length] = i3 + i4;
                            iArr = iArr2;
                        }
                        i5++;
                    }
                    i4++;
                }
                i3 += length2;
                System.arraycopy(bArr2, length - bArr.length, bArr2, 0, bArr.length);
                length2 = length - bArr.length;
                if (byteBuffer.remaining() < length2) {
                    length2 = byteBuffer.remaining();
                }
                byteBuffer.get(bArr2, bArr.length, length2);
            } while (length2 > 0);
            return iArr;
        }

        private RandomAccessFile n() {
            try {
                return new RandomAccessFile(this.f38228a.a((String) null).getName(), "rw");
            } catch (Exception e2) {
                throw new Error(e2);
            }
        }

        private String o(ByteBuffer byteBuffer, int i2, int i3, String str) {
            if (i3 <= 0) {
                return "";
            }
            FileOutputStream fileOutputStream = null;
            try {
                TempFile a2 = this.f38228a.a(str);
                ByteBuffer duplicate = byteBuffer.duplicate();
                FileOutputStream fileOutputStream2 = new FileOutputStream(a2.getName());
                try {
                    FileChannel channel = fileOutputStream2.getChannel();
                    duplicate.position(i2).limit(i2 + i3);
                    channel.write(duplicate.slice());
                    String name = a2.getName();
                    NanoHTTPD.t(fileOutputStream2);
                    return name;
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    try {
                        throw new Error(e);
                    } catch (Throwable th) {
                        th = th;
                        NanoHTTPD.t(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    NanoHTTPD.t(fileOutputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                throw new Error(e);
            }
        }

        private int p(byte[] bArr, int i2) {
            while (bArr[i2] != 10) {
                i2++;
            }
            return i2 + 1;
        }

        public final Map<String, String> a() {
            return this.f38236i;
        }

        public final String b() {
            return this.f38233f;
        }

        public final Map<String, String> c() {
            return this.f38235h;
        }

        public void d(Map<String, String> map) throws IOException, ResponseException {
            RandomAccessFile randomAccessFile;
            DataOutput dataOutput;
            ByteArrayOutputStream byteArrayOutputStream;
            ByteBuffer map2;
            StringTokenizer stringTokenizer;
            Map<String, String> map3 = map;
            RandomAccessFile randomAccessFile2 = null;
            try {
                long l2 = l();
                if (l2 < 1024) {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    randomAccessFile = null;
                    dataOutput = new DataOutputStream(byteArrayOutputStream);
                } else {
                    DataOutput n2 = n();
                    byteArrayOutputStream = null;
                    randomAccessFile = n2;
                    dataOutput = n2;
                }
                try {
                    byte[] bArr = new byte[512];
                    while (this.f38232e >= 0 && l2 > 0) {
                        int read = this.f38230c.read(bArr, 0, (int) Math.min(l2, 512));
                        this.f38232e = read;
                        l2 -= (long) read;
                        if (read > 0) {
                            dataOutput.write(bArr, 0, read);
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        map2 = ByteBuffer.wrap(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
                    } else {
                        map2 = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, randomAccessFile.length());
                        randomAccessFile.seek(0);
                    }
                    ByteBuffer byteBuffer = map2;
                    if (Method.POST.equals(this.f38234g)) {
                        String str = "";
                        String str2 = this.f38236i.get("content-type");
                        if (str2 != null) {
                            stringTokenizer = new StringTokenizer(str2, ",; ");
                            if (stringTokenizer.hasMoreTokens()) {
                                str = stringTokenizer.nextToken();
                            }
                        } else {
                            stringTokenizer = null;
                        }
                        if (!"multipart/form-data".equalsIgnoreCase(str)) {
                            byte[] bArr2 = new byte[byteBuffer.remaining()];
                            byteBuffer.get(bArr2);
                            String trim = new String(bArr2).trim();
                            if ("application/x-www-form-urlencoded".equalsIgnoreCase(str)) {
                                h(trim, this.f38235h);
                            } else if (trim.length() != 0) {
                                map3.put("postData", trim);
                            }
                        } else if (stringTokenizer.hasMoreTokens()) {
                            g(k(str2, NanoHTTPD.f38200i, (String) null), k(str2, NanoHTTPD.f38199h, "US-ASCII"), byteBuffer, this.f38235h, map);
                        } else {
                            throw new ResponseException(Response.Status.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but boundary missing. Usage: GET /example/file.html");
                        }
                    } else if (Method.PUT.equals(this.f38234g)) {
                        map3.put("content", o(byteBuffer, 0, byteBuffer.limit(), (String) null));
                    }
                    NanoHTTPD.t(randomAccessFile);
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile2 = randomAccessFile;
                    NanoHTTPD.t(randomAccessFile2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                NanoHTTPD.t(randomAccessFile2);
                throw th;
            }
        }

        public String e() {
            return this.f38238k;
        }

        public final Method getMethod() {
            return this.f38234g;
        }

        public void i() throws IOException {
            boolean z2;
            Response response = null;
            try {
                byte[] bArr = new byte[8192];
                boolean z3 = false;
                this.f38231d = 0;
                this.f38232e = 0;
                this.f38230c.mark(8192);
                int read = this.f38230c.read(bArr, 0, 8192);
                if (read != -1) {
                    while (true) {
                        if (read <= 0) {
                            break;
                        }
                        int i2 = this.f38232e + read;
                        this.f38232e = i2;
                        int j2 = j(bArr, i2);
                        this.f38231d = j2;
                        if (j2 > 0) {
                            break;
                        }
                        BufferedInputStream bufferedInputStream = this.f38230c;
                        int i3 = this.f38232e;
                        read = bufferedInputStream.read(bArr, i3, 8192 - i3);
                    }
                    if (this.f38231d < this.f38232e) {
                        this.f38230c.reset();
                        this.f38230c.skip((long) this.f38231d);
                    }
                    this.f38235h = new HashMap();
                    Map<String, String> map = this.f38236i;
                    if (map == null) {
                        this.f38236i = new HashMap();
                    } else {
                        map.clear();
                    }
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr, 0, this.f38232e)));
                    HashMap hashMap = new HashMap();
                    f(bufferedReader, hashMap, this.f38235h, this.f38236i);
                    String str = this.f38239l;
                    if (str != null) {
                        this.f38236i.put("remote-addr", str);
                        this.f38236i.put("http-client-ip", this.f38239l);
                    }
                    Method a2 = Method.a((String) hashMap.get("method"));
                    this.f38234g = a2;
                    if (a2 != null) {
                        this.f38233f = (String) hashMap.get("uri");
                        this.f38237j = new CookieHandler(this.f38236i);
                        String str2 = this.f38236i.get("connection");
                        if (!this.f38240m.equals("HTTP/1.1") || (str2 != null && str2.matches("(?i).*close.*"))) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        response = NanoHTTPD.this.u(this);
                        if (response != null) {
                            String str3 = this.f38236i.get("accept-encoding");
                            this.f38237j.a(response);
                            response.H(this.f38234g);
                            if (NanoHTTPD.this.A(response) && str3 != null && str3.contains("gzip")) {
                                z3 = true;
                            }
                            response.D(z3);
                            response.E(z2);
                            response.q(this.f38229b);
                            if (!z2 || MRAIDPresenter.CLOSE.equalsIgnoreCase(response.f("connection"))) {
                                throw new SocketException("NanoHttpd Shutdown");
                            }
                            NanoHTTPD.t(response);
                            this.f38228a.clear();
                            return;
                        }
                        throw new ResponseException(Response.Status.INTERNAL_ERROR, "SERVER INTERNAL ERROR: Serve() returned a null response.");
                    }
                    throw new ResponseException(Response.Status.BAD_REQUEST, "BAD REQUEST: Syntax error.");
                }
                NanoHTTPD.t(this.f38230c);
                NanoHTTPD.t(this.f38229b);
                throw new SocketException("NanoHttpd Shutdown");
            } catch (Exception unused) {
                NanoHTTPD.t(this.f38230c);
                NanoHTTPD.t(this.f38229b);
                throw new SocketException("NanoHttpd Shutdown");
            } catch (SocketException e2) {
                throw e2;
            } catch (SocketTimeoutException e3) {
                throw e3;
            } catch (IOException e4) {
                Response.Status status = Response.Status.INTERNAL_ERROR;
                NanoHTTPD.s(status, "text/plain", "SERVER INTERNAL ERROR: IOException: " + e4.getMessage()).q(this.f38229b);
                NanoHTTPD.t(this.f38229b);
            } catch (ResponseException e5) {
                try {
                    NanoHTTPD.s(e5.a(), "text/plain", e5.getMessage()).q(this.f38229b);
                    NanoHTTPD.t(this.f38229b);
                } catch (Throwable th) {
                    NanoHTTPD.t((Object) null);
                    this.f38228a.clear();
                    throw th;
                }
            }
        }

        public long l() {
            if (this.f38236i.containsKey("content-length")) {
                return Long.parseLong(this.f38236i.get("content-length"));
            }
            int i2 = this.f38231d;
            int i3 = this.f38232e;
            if (i2 < i3) {
                return (long) (i3 - i2);
            }
            return 0;
        }
    }

    public interface IHTTPSession {
        Map<String, String> a();

        String b();

        Map<String, String> c();

        void d(Map<String, String> map) throws IOException, ResponseException;

        String e();

        Method getMethod();
    }

    public enum Method {
        GET,
        PUT,
        POST,
        DELETE,
        HEAD,
        OPTIONS,
        TRACE,
        CONNECT,
        PATCH;

        static Method a(String str) {
            for (Method method : values()) {
                if (method.toString().equalsIgnoreCase(str)) {
                    return method;
                }
            }
            return null;
        }
    }

    public static class Response implements Closeable {

        /* renamed from: b  reason: collision with root package name */
        private IStatus f38252b;

        /* renamed from: c  reason: collision with root package name */
        private String f38253c;

        /* renamed from: d  reason: collision with root package name */
        private InputStream f38254d;

        /* renamed from: e  reason: collision with root package name */
        private long f38255e;

        /* renamed from: f  reason: collision with root package name */
        private final Map<String, String> f38256f = new HashMap();

        /* renamed from: g  reason: collision with root package name */
        private Method f38257g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f38258h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f38259i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f38260j;

        private static class ChunkedOutputStream extends FilterOutputStream {
            public ChunkedOutputStream(OutputStream outputStream) {
                super(outputStream);
            }

            public void a() throws IOException {
                this.out.write("0\r\n\r\n".getBytes());
            }

            public void write(int i2) throws IOException {
                write(new byte[]{(byte) i2}, 0, 1);
            }

            public void write(byte[] bArr) throws IOException {
                write(bArr, 0, bArr.length);
            }

            public void write(byte[] bArr, int i2, int i3) throws IOException {
                if (i3 != 0) {
                    this.out.write(String.format("%x\r\n", new Object[]{Integer.valueOf(i3)}).getBytes());
                    this.out.write(bArr, i2, i3);
                    this.out.write("\r\n".getBytes());
                }
            }
        }

        public interface IStatus {
            String getDescription();
        }

        public enum Status implements IStatus {
            SWITCH_PROTOCOL(101, "Switching Protocols"),
            OK(200, "OK"),
            CREATED(201, "Created"),
            ACCEPTED(202, "Accepted"),
            NO_CONTENT(204, "No Content"),
            PARTIAL_CONTENT(Sdk$SDKError.Reason.AD_ALREADY_FAILED_VALUE, "Partial Content"),
            REDIRECT(301, "Moved Permanently"),
            NOT_MODIFIED(Sdk$SDKError.Reason.AD_EXPIRED_VALUE, "Not Modified"),
            BAD_REQUEST(400, "Bad Request"),
            UNAUTHORIZED(401, "Unauthorized"),
            FORBIDDEN(403, "Forbidden"),
            NOT_FOUND(UserResponces.USER_RESPONCE_FAIL, "Not Found"),
            METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
            NOT_ACCEPTABLE(406, "Not Acceptable"),
            REQUEST_TIMEOUT(408, "Request Timeout"),
            CONFLICT(409, "Conflict"),
            RANGE_NOT_SATISFIABLE(416, "Requested Range Not Satisfiable"),
            INTERNAL_ERROR(500, "Internal Server Error"),
            NOT_IMPLEMENTED(501, "Not Implemented"),
            UNSUPPORTED_HTTP_VERSION(505, "HTTP Version Not Supported");
            

            /* renamed from: b  reason: collision with root package name */
            private final int f38282b;

            /* renamed from: c  reason: collision with root package name */
            private final String f38283c;

            private Status(int i2, String str) {
                this.f38282b = i2;
                this.f38283c = str;
            }

            public String getDescription() {
                return "" + this.f38282b + " " + this.f38283c;
            }
        }

        protected Response(IStatus iStatus, String str, InputStream inputStream, long j2) {
            this.f38252b = iStatus;
            this.f38253c = str;
            boolean z2 = false;
            if (inputStream == null) {
                this.f38254d = new ByteArrayInputStream(new byte[0]);
                this.f38255e = 0;
            } else {
                this.f38254d = inputStream;
                this.f38255e = j2;
            }
            this.f38258h = this.f38255e < 0 ? true : z2;
            this.f38260j = true;
        }

        protected static long A(PrintWriter printWriter, Map<String, String> map, long j2) {
            for (String next : map.keySet()) {
                if (next.equalsIgnoreCase("content-length")) {
                    try {
                        return Long.parseLong(map.get(next));
                    } catch (NumberFormatException unused) {
                        return j2;
                    }
                }
            }
            printWriter.print("Content-Length: " + j2 + "\r\n");
            return j2;
        }

        private static boolean k(Map<String, String> map, String str) {
            boolean z2 = false;
            for (String equalsIgnoreCase : map.keySet()) {
                z2 |= equalsIgnoreCase.equalsIgnoreCase(str);
            }
            return z2;
        }

        private void s(OutputStream outputStream, long j2) throws IOException {
            boolean z2;
            long j3;
            byte[] bArr = new byte[((int) 16384)];
            if (j2 == -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            while (true) {
                if (j2 > 0 || z2) {
                    if (z2) {
                        j3 = 16384;
                    } else {
                        j3 = Math.min(j2, 16384);
                    }
                    int read = this.f38254d.read(bArr, 0, (int) j3);
                    if (read > 0) {
                        outputStream.write(bArr, 0, read);
                        if (!z2) {
                            j2 -= (long) read;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        private void v(OutputStream outputStream, long j2) throws IOException {
            if (this.f38259i) {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                s(gZIPOutputStream, -1);
                gZIPOutputStream.finish();
                return;
            }
            s(outputStream, j2);
        }

        private void z(OutputStream outputStream, long j2) throws IOException {
            if (this.f38257g == Method.HEAD || !this.f38258h) {
                v(outputStream, j2);
                return;
            }
            ChunkedOutputStream chunkedOutputStream = new ChunkedOutputStream(outputStream);
            v(chunkedOutputStream, -1);
            chunkedOutputStream.a();
        }

        public void B(boolean z2) {
            this.f38258h = z2;
        }

        public void D(boolean z2) {
            this.f38259i = z2;
        }

        public void E(boolean z2) {
            this.f38260j = z2;
        }

        public void H(Method method) {
            this.f38257g = method;
        }

        public void a(String str, String str2) {
            this.f38256f.put(str, str2);
        }

        public void close() throws IOException {
            InputStream inputStream = this.f38254d;
            if (inputStream != null) {
                inputStream.close();
            }
        }

        public String f(String str) {
            for (String next : this.f38256f.keySet()) {
                if (next.equalsIgnoreCase(str)) {
                    return this.f38256f.get(next);
                }
            }
            return null;
        }

        public String i() {
            return this.f38253c;
        }

        /* access modifiers changed from: protected */
        public void q(OutputStream outputStream) {
            long j2;
            String str;
            String str2 = this.f38253c;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            try {
                if (this.f38252b != null) {
                    PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8")), false);
                    printWriter.print("HTTP/1.1 " + this.f38252b.getDescription() + " \r\n");
                    if (str2 != null) {
                        printWriter.print("Content-Type: " + str2 + "\r\n");
                    }
                    Map<String, String> map = this.f38256f;
                    if (map == null || map.get("Date") == null) {
                        printWriter.print("Date: " + simpleDateFormat.format(new Date()) + "\r\n");
                    }
                    Map<String, String> map2 = this.f38256f;
                    if (map2 != null) {
                        for (String next : map2.keySet()) {
                            printWriter.print(next + ": " + this.f38256f.get(next) + "\r\n");
                        }
                    }
                    if (!k(this.f38256f, "connection")) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Connection: ");
                        if (this.f38260j) {
                            str = "keep-alive";
                        } else {
                            str = MRAIDPresenter.CLOSE;
                        }
                        sb.append(str);
                        sb.append("\r\n");
                        printWriter.print(sb.toString());
                    }
                    if (k(this.f38256f, "content-length")) {
                        this.f38259i = false;
                    }
                    if (this.f38259i) {
                        printWriter.print("Content-Encoding: gzip\r\n");
                        B(true);
                    }
                    if (this.f38254d != null) {
                        j2 = this.f38255e;
                    } else {
                        j2 = 0;
                    }
                    if (this.f38257g != Method.HEAD && this.f38258h) {
                        printWriter.print("Transfer-Encoding: chunked\r\n");
                    } else if (!this.f38259i) {
                        j2 = A(printWriter, this.f38256f, j2);
                    }
                    printWriter.print("\r\n");
                    printWriter.flush();
                    z(outputStream, j2);
                    outputStream.flush();
                    NanoHTTPD.t(this.f38254d);
                    return;
                }
                throw new Error("sendResponse(): Status can't be null.");
            } catch (IOException e2) {
                NanoHTTPD.f38204m.log(Level.SEVERE, "Could not send response to the client", e2);
            }
        }
    }

    public class ServerRunnable implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final int f38285b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public IOException f38286c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public boolean f38287d;

        public void run() {
            InetSocketAddress inetSocketAddress;
            try {
                ServerSocket c2 = NanoHTTPD.this.f38207c;
                if (NanoHTTPD.this.f38205a != null) {
                    inetSocketAddress = new InetSocketAddress(NanoHTTPD.this.f38205a, NanoHTTPD.this.f38206b);
                } else {
                    inetSocketAddress = new InetSocketAddress(NanoHTTPD.this.f38206b);
                }
                c2.bind(inetSocketAddress);
                this.f38287d = true;
                do {
                    try {
                        Socket accept = NanoHTTPD.this.f38207c.accept();
                        int i2 = this.f38285b;
                        if (i2 > 0) {
                            accept.setSoTimeout(i2);
                        }
                        InputStream inputStream = accept.getInputStream();
                        NanoHTTPD nanoHTTPD = NanoHTTPD.this;
                        nanoHTTPD.f38210f.c(nanoHTTPD.m(accept, inputStream));
                    } catch (IOException e2) {
                        NanoHTTPD.f38204m.log(Level.FINE, "Communication with the client broken", e2);
                    }
                } while (!NanoHTTPD.this.f38207c.isClosed());
            } catch (IOException e3) {
                this.f38286c = e3;
            }
        }

        private ServerRunnable(int i2) {
            this.f38287d = false;
            this.f38285b = i2;
        }
    }

    public interface ServerSocketFactory {
        ServerSocket create() throws IOException;
    }

    public interface TempFile {
        void a() throws Exception;

        String getName();
    }

    public interface TempFileManager {
        TempFile a(String str) throws Exception;

        void clear();
    }

    public interface TempFileManagerFactory {
        TempFileManager create();
    }

    public NanoHTTPD(int i2) {
        this((String) null, i2);
    }

    protected static String o(String str) {
        try {
            return URLDecoder.decode(str, "UTF8");
        } catch (UnsupportedEncodingException e2) {
            f38204m.log(Level.WARNING, "Encoding not supported, ignored", e2);
            return null;
        }
    }

    public static Response r(Response.IStatus iStatus, String str, InputStream inputStream, long j2) {
        return new Response(iStatus, str, inputStream, j2);
    }

    public static Response s(Response.IStatus iStatus, String str, String str2) {
        byte[] bArr;
        if (str2 == null) {
            return r(iStatus, str, new ByteArrayInputStream(new byte[0]), 0);
        }
        try {
            bArr = str2.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e2) {
            f38204m.log(Level.SEVERE, "encoding problem, responding nothing", e2);
            bArr = new byte[0];
        }
        return r(iStatus, str, new ByteArrayInputStream(bArr), (long) bArr.length);
    }

    /* access modifiers changed from: private */
    public static final void t(Object obj) {
        if (obj != null) {
            try {
                if (obj instanceof Closeable) {
                    ((Closeable) obj).close();
                } else if (obj instanceof Socket) {
                    ((Socket) obj).close();
                } else if (obj instanceof ServerSocket) {
                    ((ServerSocket) obj).close();
                } else {
                    throw new IllegalArgumentException("Unknown object to close");
                }
            } catch (IOException e2) {
                f38204m.log(Level.SEVERE, "Could not close", e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean A(Response response) {
        return response.i() != null && response.i().toLowerCase().contains("text/");
    }

    public final boolean B() {
        return (this.f38207c == null || this.f38209e == null) ? false : true;
    }

    public synchronized void l() {
        z();
    }

    /* access modifiers changed from: protected */
    public ClientHandler m(Socket socket, InputStream inputStream) {
        return new ClientHandler(inputStream, socket);
    }

    /* access modifiers changed from: protected */
    public ServerRunnable n(int i2) {
        return new ServerRunnable(i2);
    }

    public ServerSocketFactory p() {
        return this.f38208d;
    }

    public final boolean q() {
        return B() && !this.f38207c.isClosed() && this.f38209e.isAlive();
    }

    public Response u(IHTTPSession iHTTPSession) {
        HashMap hashMap = new HashMap();
        Method method = iHTTPSession.getMethod();
        if (Method.PUT.equals(method) || Method.POST.equals(method)) {
            try {
                iHTTPSession.d(hashMap);
            } catch (IOException e2) {
                Response.Status status = Response.Status.INTERNAL_ERROR;
                return s(status, "text/plain", "SERVER INTERNAL ERROR: IOException: " + e2.getMessage());
            } catch (ResponseException e3) {
                return s(e3.a(), "text/plain", e3.getMessage());
            }
        }
        Map<String, String> c2 = iHTTPSession.c();
        c2.put("NanoHttpd.QUERY_STRING", iHTTPSession.e());
        return v(iHTTPSession.b(), method, iHTTPSession.a(), c2, hashMap);
    }

    @Deprecated
    public Response v(String str, Method method, Map<String, String> map, Map<String, String> map2, Map<String, String> map3) {
        return s(Response.Status.NOT_FOUND, "text/plain", "Not Found");
    }

    public void w(AsyncRunner asyncRunner) {
        this.f38210f = asyncRunner;
    }

    public void x(TempFileManagerFactory tempFileManagerFactory) {
        this.f38211g = tempFileManagerFactory;
    }

    public void y(int i2, boolean z2) throws IOException {
        this.f38207c = p().create();
        this.f38207c.setReuseAddress(true);
        ServerRunnable n2 = n(i2);
        Thread thread = new Thread(n2);
        this.f38209e = thread;
        thread.setDaemon(z2);
        this.f38209e.setName("NanoHttpd Main Listener");
        this.f38209e.start();
        while (!n2.f38287d && n2.f38286c == null) {
            try {
                Thread.sleep(10);
            } catch (Throwable unused) {
            }
        }
        if (n2.f38286c != null) {
            throw n2.f38286c;
        }
    }

    public void z() {
        try {
            t(this.f38207c);
            this.f38210f.b();
            Thread thread = this.f38209e;
            if (thread != null) {
                thread.join();
            }
        } catch (Exception e2) {
            f38204m.log(Level.SEVERE, "Could not stop all connections", e2);
        }
    }

    public static final class ResponseException extends Exception {

        /* renamed from: b  reason: collision with root package name */
        private final Response.Status f38284b;

        public ResponseException(Response.Status status, String str) {
            super(str);
            this.f38284b = status;
        }

        public Response.Status a() {
            return this.f38284b;
        }

        public ResponseException(Response.Status status, String str, Exception exc) {
            super(str, exc);
            this.f38284b = status;
        }
    }

    public NanoHTTPD(String str, int i2) {
        this.f38208d = new DefaultServerSocketFactory();
        this.f38205a = str;
        this.f38206b = i2;
        x(new DefaultTempFileManagerFactory());
        w(new DefaultAsyncRunner());
    }
}
