package com.facebook.react.modules.blob;

import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.facebook.common.util.UriUtil;
import com.facebook.fbreact.specs.NativeBlobModuleSpec;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.network.NetworkingModule;
import com.facebook.react.modules.websocket.WebSocketModule;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.ByteString;

@ReactModule(name = "BlobModule")
public class BlobModule extends NativeBlobModuleSpec {
    public static final String NAME = "BlobModule";
    private final Map<String, byte[]> mBlobs = new HashMap();
    private final NetworkingModule.RequestBodyHandler mNetworkingRequestBodyHandler = new NetworkingModule.RequestBodyHandler() {
        public boolean supports(ReadableMap readableMap) {
            return readableMap.hasKey("blob");
        }

        public RequestBody toRequestBody(ReadableMap readableMap, String str) {
            if (readableMap.hasKey("type") && !readableMap.getString("type").isEmpty()) {
                str = readableMap.getString("type");
            }
            if (str == null) {
                str = "application/octet-stream";
            }
            ReadableMap map = readableMap.getMap("blob");
            return RequestBody.create(MediaType.parse(str), BlobModule.this.resolve(map.getString("blobId"), map.getInt("offset"), map.getInt("size")));
        }
    };
    private final NetworkingModule.ResponseHandler mNetworkingResponseHandler = new NetworkingModule.ResponseHandler() {
        public boolean supports(String str) {
            return "blob".equals(str);
        }

        public WritableMap toResponseData(ResponseBody responseBody) throws IOException {
            byte[] bytes = responseBody.bytes();
            WritableMap createMap = Arguments.createMap();
            createMap.putString("blobId", BlobModule.this.store(bytes));
            createMap.putInt("offset", 0);
            createMap.putInt("size", bytes.length);
            return createMap;
        }
    };
    private final NetworkingModule.UriHandler mNetworkingUriHandler = new NetworkingModule.UriHandler() {
        public WritableMap fetch(Uri uri) throws IOException {
            byte[] access$000 = BlobModule.this.getBytesFromUri(uri);
            WritableMap createMap = Arguments.createMap();
            createMap.putString("blobId", BlobModule.this.store(access$000));
            createMap.putInt("offset", 0);
            createMap.putInt("size", access$000.length);
            createMap.putString("type", BlobModule.this.getMimeTypeFromUri(uri));
            createMap.putString("name", BlobModule.this.getNameFromUri(uri));
            createMap.putDouble("lastModified", (double) BlobModule.this.getLastModifiedFromUri(uri));
            return createMap;
        }

        public boolean supports(Uri uri, String str) {
            boolean z2;
            String scheme = uri.getScheme();
            if (UriUtil.HTTP_SCHEME.equals(scheme) || UriUtil.HTTPS_SCHEME.equals(scheme)) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2 || !"blob".equals(str)) {
                return false;
            }
            return true;
        }
    };
    private final WebSocketModule.ContentHandler mWebSocketContentHandler = new WebSocketModule.ContentHandler() {
        public void onMessage(String str, WritableMap writableMap) {
            writableMap.putString("data", str);
        }

        public void onMessage(ByteString byteString, WritableMap writableMap) {
            byte[] x2 = byteString.x();
            WritableMap createMap = Arguments.createMap();
            createMap.putString("blobId", BlobModule.this.store(x2));
            createMap.putInt("offset", 0);
            createMap.putInt("size", x2.length);
            writableMap.putMap("data", createMap);
            writableMap.putString("type", "blob");
        }
    };

    public BlobModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    /* access modifiers changed from: private */
    public byte[] getBytesFromUri(Uri uri) throws IOException {
        InputStream openInputStream = getReactApplicationContext().getContentResolver().openInputStream(uri);
        if (openInputStream != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = openInputStream.read(bArr);
                if (read == -1) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } else {
            throw new FileNotFoundException("File not found for " + uri);
        }
    }

    /* access modifiers changed from: private */
    public long getLastModifiedFromUri(Uri uri) {
        if ("file".equals(uri.getScheme())) {
            return new File(uri.toString()).lastModified();
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public String getMimeTypeFromUri(Uri uri) {
        String fileExtensionFromUrl;
        String type = getReactApplicationContext().getContentResolver().getType(uri);
        if (type == null && (fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(uri.getPath())) != null) {
            type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        if (type == null) {
            return "";
        }
        return type;
    }

    /* access modifiers changed from: private */
    public String getNameFromUri(Uri uri) {
        if ("file".equals(uri.getScheme())) {
            return uri.getLastPathSegment();
        }
        Cursor query = getReactApplicationContext().getContentResolver().query(uri, new String[]{"_display_name"}, (String) null, (String[]) null, (String) null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    return query.getString(0);
                }
                query.close();
            } finally {
                query.close();
            }
        }
        return uri.getLastPathSegment();
    }

    private WebSocketModule getWebSocketModule(String str) {
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn != null) {
            return (WebSocketModule) reactApplicationContextIfActiveOrWarn.getNativeModule(WebSocketModule.class);
        }
        return null;
    }

    public void addNetworkingHandler() {
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn != null) {
            NetworkingModule networkingModule = (NetworkingModule) reactApplicationContextIfActiveOrWarn.getNativeModule(NetworkingModule.class);
            networkingModule.addUriHandler(this.mNetworkingUriHandler);
            networkingModule.addRequestBodyHandler(this.mNetworkingRequestBodyHandler);
            networkingModule.addResponseHandler(this.mNetworkingResponseHandler);
        }
    }

    public void addWebSocketHandler(double d2) {
        int i2 = (int) d2;
        WebSocketModule webSocketModule = getWebSocketModule("addWebSocketHandler");
        if (webSocketModule != null) {
            webSocketModule.setContentHandler(i2, this.mWebSocketContentHandler);
        }
    }

    public void createFromParts(ReadableArray readableArray, String str) {
        ArrayList arrayList = new ArrayList(readableArray.size());
        int i2 = 0;
        for (int i3 = 0; i3 < readableArray.size(); i3++) {
            ReadableMap map = readableArray.getMap(i3);
            String string = map.getString("type");
            string.hashCode();
            if (string.equals("string")) {
                byte[] bytes = map.getString("data").getBytes(Charset.forName("UTF-8"));
                i2 += bytes.length;
                arrayList.add(i3, bytes);
            } else if (string.equals("blob")) {
                ReadableMap map2 = map.getMap("data");
                i2 += map2.getInt("size");
                arrayList.add(i3, resolve(map2));
            } else {
                throw new IllegalArgumentException("Invalid type for blob: " + map.getString("type"));
            }
        }
        ByteBuffer allocate = ByteBuffer.allocate(i2);
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            allocate.put((byte[]) it2.next());
        }
        store(allocate.array(), str);
    }

    public String getName() {
        return NAME;
    }

    public Map<String, Object> getTypedExportedConstants() {
        Resources resources = getReactApplicationContext().getResources();
        int identifier = resources.getIdentifier("blob_provider_authority", "string", getReactApplicationContext().getPackageName());
        if (identifier == 0) {
            return MapBuilder.of();
        }
        return MapBuilder.of("BLOB_URI_SCHEME", "content", "BLOB_URI_HOST", resources.getString(identifier));
    }

    public void initialize() {
        BlobCollector.install(getReactApplicationContext(), this);
    }

    public void release(String str) {
        remove(str);
    }

    @DoNotStrip
    public void remove(String str) {
        synchronized (this.mBlobs) {
            this.mBlobs.remove(str);
        }
    }

    public void removeWebSocketHandler(double d2) {
        int i2 = (int) d2;
        WebSocketModule webSocketModule = getWebSocketModule("removeWebSocketHandler");
        if (webSocketModule != null) {
            webSocketModule.setContentHandler(i2, (WebSocketModule.ContentHandler) null);
        }
    }

    public byte[] resolve(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        String queryParameter = uri.getQueryParameter("offset");
        int parseInt = queryParameter != null ? Integer.parseInt(queryParameter, 10) : 0;
        String queryParameter2 = uri.getQueryParameter("size");
        return resolve(lastPathSegment, parseInt, queryParameter2 != null ? Integer.parseInt(queryParameter2, 10) : -1);
    }

    public void sendOverSocket(ReadableMap readableMap, double d2) {
        int i2 = (int) d2;
        WebSocketModule webSocketModule = getWebSocketModule("sendOverSocket");
        if (webSocketModule != null) {
            byte[] resolve = resolve(readableMap.getString("blobId"), readableMap.getInt("offset"), readableMap.getInt("size"));
            if (resolve != null) {
                webSocketModule.sendBinary(ByteString.o(resolve), i2);
            } else {
                webSocketModule.sendBinary((ByteString) null, i2);
            }
        }
    }

    public String store(byte[] bArr) {
        String uuid = UUID.randomUUID().toString();
        store(bArr, uuid);
        return uuid;
    }

    public void store(byte[] bArr, String str) {
        synchronized (this.mBlobs) {
            this.mBlobs.put(str, bArr);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0020, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] resolve(java.lang.String r3, int r4, int r5) {
        /*
            r2 = this;
            java.util.Map<java.lang.String, byte[]> r0 = r2.mBlobs
            monitor-enter(r0)
            java.util.Map<java.lang.String, byte[]> r1 = r2.mBlobs     // Catch:{ all -> 0x0021 }
            java.lang.Object r3 = r1.get(r3)     // Catch:{ all -> 0x0021 }
            byte[] r3 = (byte[]) r3     // Catch:{ all -> 0x0021 }
            if (r3 != 0) goto L_0x0010
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            r3 = 0
            return r3
        L_0x0010:
            r1 = -1
            if (r5 != r1) goto L_0x0015
            int r5 = r3.length     // Catch:{ all -> 0x0021 }
            int r5 = r5 - r4
        L_0x0015:
            if (r4 > 0) goto L_0x001a
            int r1 = r3.length     // Catch:{ all -> 0x0021 }
            if (r5 == r1) goto L_0x001f
        L_0x001a:
            int r5 = r5 + r4
            byte[] r3 = java.util.Arrays.copyOfRange(r3, r4, r5)     // Catch:{ all -> 0x0021 }
        L_0x001f:
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            return r3
        L_0x0021:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.blob.BlobModule.resolve(java.lang.String, int, int):byte[]");
    }

    public byte[] resolve(ReadableMap readableMap) {
        return resolve(readableMap.getString("blobId"), readableMap.getInt("offset"), readableMap.getInt("size"));
    }
}
