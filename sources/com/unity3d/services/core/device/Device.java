package com.unity3d.services.core.device;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ConfigurationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.applovin.sdk.AppLovinEventTypes;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.preferences.AndroidPreferences;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class Device {
    private static SDKMetricsSender sdkMetricsSender = ((SDKMetricsSender) Utilities.getService(SDKMetricsSender.class));

    /* renamed from: com.unity3d.services.core.device.Device$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$unity3d$services$core$device$Device$MemoryInfoType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.unity3d.services.core.device.Device$MemoryInfoType[] r0 = com.unity3d.services.core.device.Device.MemoryInfoType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$unity3d$services$core$device$Device$MemoryInfoType = r0
                com.unity3d.services.core.device.Device$MemoryInfoType r1 = com.unity3d.services.core.device.Device.MemoryInfoType.TOTAL_MEMORY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$unity3d$services$core$device$Device$MemoryInfoType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.unity3d.services.core.device.Device$MemoryInfoType r1 = com.unity3d.services.core.device.Device.MemoryInfoType.FREE_MEMORY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.device.Device.AnonymousClass1.<clinit>():void");
        }
    }

    public enum MemoryInfoType {
        TOTAL_MEMORY,
        FREE_MEMORY
    }

    public static String getAdvertisingTrackingId() {
        return AdvertisingId.getAdvertisingTrackingId();
    }

    public static int getApiLevel() {
        return Build.VERSION.SDK_INT;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0060 A[SYNTHETIC, Splitter:B:17:0x0060] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getApkDigest() throws java.lang.Exception {
        /*
            android.content.Context r0 = com.unity3d.services.core.properties.ClientProperties.getApplicationContext()
            java.lang.String r0 = r0.getPackageCodePath()
            long r1 = java.lang.System.nanoTime()
            r3 = 0
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x005d }
            r4.<init>(r0)     // Catch:{ all -> 0x005d }
            long r5 = r4.length()     // Catch:{ all -> 0x005d }
            r7 = 1048576(0x100000, double:5.180654E-318)
            long r5 = r5 / r7
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ all -> 0x005d }
            r0.<init>(r4)     // Catch:{ all -> 0x005d }
            java.lang.String r3 = com.unity3d.services.core.misc.Utilities.Sha256((java.io.InputStream) r0)     // Catch:{ all -> 0x005a }
            r0.close()     // Catch:{ IOException -> 0x0027 }
            goto L_0x0028
        L_0x0027:
        L_0x0028:
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r7 = java.lang.System.nanoTime()
            long r7 = r7 - r1
            long r0 = r0.toMillis(r7)
            r7 = 5000(0x1388, double:2.4703E-320)
            int r2 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r2 <= 0) goto L_0x0049
            com.unity3d.services.core.request.metrics.SDKMetricsSender r0 = sdkMetricsSender
            com.unity3d.services.core.request.metrics.Metric r1 = new com.unity3d.services.core.request.metrics.Metric
            java.lang.String r2 = "native_device_info_apk_digest_timeout"
            java.lang.Long r4 = java.lang.Long.valueOf(r5)
            r1.<init>(r2, r4)
            r0.sendMetric(r1)
        L_0x0049:
            com.unity3d.services.core.request.metrics.SDKMetricsSender r0 = sdkMetricsSender
            com.unity3d.services.core.request.metrics.Metric r1 = new com.unity3d.services.core.request.metrics.Metric
            java.lang.String r2 = "native_device_info_apk_size"
            java.lang.Long r4 = java.lang.Long.valueOf(r5)
            r1.<init>(r2, r4)
            r0.sendMetric(r1)
            return r3
        L_0x005a:
            r1 = move-exception
            r3 = r0
            goto L_0x005e
        L_0x005d:
            r1 = move-exception
        L_0x005e:
            if (r3 == 0) goto L_0x0063
            r3.close()     // Catch:{ IOException -> 0x0063 }
        L_0x0063:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.device.Device.getApkDigest():java.lang.String");
    }

    public static String getAuid() {
        return AndroidPreferences.getString("supersonic_shared_preferen", JsonStorageKeyNames.AUID_ID_KEY);
    }

    public static float getBatteryLevel() {
        Intent registerReceiver;
        if (ClientProperties.getApplicationContext() == null || (registerReceiver = ClientProperties.getApplicationContext().registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"))) == null) {
            return -1.0f;
        }
        return ((float) registerReceiver.getIntExtra(AppLovinEventTypes.USER_COMPLETED_LEVEL, -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
    }

    public static int getBatteryStatus() {
        Intent registerReceiver;
        if (ClientProperties.getApplicationContext() == null || (registerReceiver = ClientProperties.getApplicationContext().registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"))) == null) {
            return -1;
        }
        return registerReceiver.getIntExtra("status", -1);
    }

    public static String getBoard() {
        return Build.BOARD;
    }

    public static String getBootloader() {
        return Build.BOOTLOADER;
    }

    public static String getBrand() {
        return Build.BRAND;
    }

    public static String getBuildId() {
        return Build.ID;
    }

    public static String getBuildVersionIncremental() {
        return Build.VERSION.INCREMENTAL;
    }

    public static long getCPUCount() {
        return (long) Runtime.getRuntime().availableProcessors();
    }

    public static String getCertificateFingerprint() {
        try {
            Signature[] signatureArr = ClientProperties.getApplicationContext().getPackageManager().getPackageInfo(ClientProperties.getApplicationContext().getPackageName(), 64).signatures;
            if (signatureArr == null || signatureArr.length < 1) {
                return null;
            }
            return Utilities.toHexString(MessageDigest.getInstance("SHA-1").digest(((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getEncoded()));
        } catch (Exception e2) {
            DeviceLog.exception("Exception when signing certificate fingerprint", e2);
            return null;
        }
    }

    public static String getConnectionType() {
        if (isUsingWifi()) {
            return "wifi";
        }
        if (isActiveNetworkConnected()) {
            return "cellular";
        }
        return "none";
    }

    public static String getDevice() {
        return Build.DEVICE;
    }

    public static float getDisplayMetricDensity() {
        if (ClientProperties.getApplicationContext() != null) {
            return ClientProperties.getApplicationContext().getResources().getDisplayMetrics().density;
        }
        return -1.0f;
    }

    public static long getElapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    public static String getFingerprint() {
        return Build.FINGERPRINT;
    }

    public static long getFreeMemory() {
        return getMemoryInfo(MemoryInfoType.FREE_MEMORY);
    }

    public static long getFreeSpace(File file) {
        if (file == null || !file.exists()) {
            return -1;
        }
        return (long) Math.round((float) (file.getFreeSpace() / 1024));
    }

    public static String getGLVersion() {
        ActivityManager activityManager;
        ConfigurationInfo deviceConfigurationInfo;
        if (ClientProperties.getApplicationContext() == null || (activityManager = (ActivityManager) ClientProperties.getApplicationContext().getSystemService("activity")) == null || (deviceConfigurationInfo = activityManager.getDeviceConfigurationInfo()) == null) {
            return null;
        }
        return deviceConfigurationInfo.getGlEsVersion();
    }

    public static String getHardware() {
        return Build.HARDWARE;
    }

    public static String getHost() {
        return Build.HOST;
    }

    public static String getIdfi() {
        String string = AndroidPreferences.getString("unityads-installinfo", "unityads-idfi");
        if (string == null) {
            string = getAuid();
        }
        if (string != null) {
            return string;
        }
        String uniqueEventId = getUniqueEventId();
        AndroidPreferences.setString("unityads-installinfo", "unityads-idfi", uniqueEventId);
        return uniqueEventId;
    }

    public static String getManufacturer() {
        return Build.MANUFACTURER;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.io.RandomAccessFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004f A[SYNTHETIC, Splitter:B:25:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005e A[SYNTHETIC, Splitter:B:32:0x005e] */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long getMemoryInfo(com.unity3d.services.core.device.Device.MemoryInfoType r6) {
        /*
            java.lang.String r0 = "Error closing RandomAccessFile"
            int[] r1 = com.unity3d.services.core.device.Device.AnonymousClass1.$SwitchMap$com$unity3d$services$core$device$Device$MemoryInfoType
            int r2 = r6.ordinal()
            r1 = r1[r2]
            r2 = 1
            if (r1 == r2) goto L_0x0011
            r2 = 2
            if (r1 == r2) goto L_0x0011
            r2 = -1
        L_0x0011:
            r1 = 0
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x0036, all -> 0x0034 }
            java.lang.String r4 = "/proc/meminfo"
            java.lang.String r5 = "r"
            r3.<init>(r4, r5)     // Catch:{ IOException -> 0x0036, all -> 0x0034 }
            r4 = 0
        L_0x001c:
            if (r4 >= r2) goto L_0x0025
            java.lang.String r1 = r3.readLine()     // Catch:{ IOException -> 0x0032 }
            int r4 = r4 + 1
            goto L_0x001c
        L_0x0025:
            long r1 = getMemoryValueFromString(r1)     // Catch:{ IOException -> 0x0032 }
            r3.close()     // Catch:{ IOException -> 0x002d }
            goto L_0x0031
        L_0x002d:
            r6 = move-exception
            com.unity3d.services.core.log.DeviceLog.exception(r0, r6)
        L_0x0031:
            return r1
        L_0x0032:
            r1 = move-exception
            goto L_0x0039
        L_0x0034:
            r6 = move-exception
            goto L_0x005c
        L_0x0036:
            r2 = move-exception
            r3 = r1
            r1 = r2
        L_0x0039:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x005a }
            r2.<init>()     // Catch:{ all -> 0x005a }
            java.lang.String r4 = "Error while reading memory info: "
            r2.append(r4)     // Catch:{ all -> 0x005a }
            r2.append(r6)     // Catch:{ all -> 0x005a }
            java.lang.String r6 = r2.toString()     // Catch:{ all -> 0x005a }
            com.unity3d.services.core.log.DeviceLog.exception(r6, r1)     // Catch:{ all -> 0x005a }
            if (r3 == 0) goto L_0x0057
            r3.close()     // Catch:{ IOException -> 0x0053 }
            goto L_0x0057
        L_0x0053:
            r6 = move-exception
            com.unity3d.services.core.log.DeviceLog.exception(r0, r6)
        L_0x0057:
            r0 = -1
            return r0
        L_0x005a:
            r6 = move-exception
            r1 = r3
        L_0x005c:
            if (r1 == 0) goto L_0x0066
            r1.close()     // Catch:{ IOException -> 0x0062 }
            goto L_0x0066
        L_0x0062:
            r1 = move-exception
            com.unity3d.services.core.log.DeviceLog.exception(r0, r1)
        L_0x0066:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.device.Device.getMemoryInfo(com.unity3d.services.core.device.Device$MemoryInfoType):long");
    }

    private static long getMemoryValueFromString(String str) {
        if (str == null) {
            return -1;
        }
        Matcher matcher = Pattern.compile("(\\d+)").matcher(str);
        String str2 = "";
        while (matcher.find()) {
            str2 = matcher.group(1);
        }
        return Long.parseLong(str2);
    }

    public static String getModel() {
        return Build.MODEL;
    }

    public static String getNetworkCountryISO() {
        if (ClientProperties.getApplicationContext() != null) {
            return ((TelephonyManager) ClientProperties.getApplicationContext().getSystemService("phone")).getNetworkCountryIso();
        }
        return "";
    }

    public static boolean getNetworkMetered() {
        ConnectivityManager connectivityManager;
        if (ClientProperties.getApplicationContext() == null || (connectivityManager = (ConnectivityManager) ClientProperties.getApplicationContext().getSystemService("connectivity")) == null) {
            return false;
        }
        return connectivityManager.isActiveNetworkMetered();
    }

    public static String getNetworkOperator() {
        if (ClientProperties.getApplicationContext() != null) {
            return ((TelephonyManager) ClientProperties.getApplicationContext().getSystemService("phone")).getNetworkOperator();
        }
        return "";
    }

    public static String getNetworkOperatorName() {
        if (ClientProperties.getApplicationContext() != null) {
            return ((TelephonyManager) ClientProperties.getApplicationContext().getSystemService("phone")).getNetworkOperatorName();
        }
        return "";
    }

    public static int getNetworkType() {
        if (ClientProperties.getApplicationContext() == null) {
            return -1;
        }
        try {
            return ((TelephonyManager) ClientProperties.getApplicationContext().getSystemService("phone")).getNetworkType();
        } catch (SecurityException unused) {
            DeviceLog.warning("Unity Ads was not able to get current network type due to missing permission");
            return -1;
        }
    }

    @TargetApi(21)
    private static ArrayList<String> getNewAbiList() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(Build.SUPPORTED_ABIS));
        return arrayList;
    }

    private static ArrayList<String> getOldAbiList() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(Build.CPU_ABI);
        arrayList.add(Build.CPU_ABI2);
        return arrayList;
    }

    public static String getOpenAdvertisingTrackingId() {
        return OpenAdvertisingId.getOpenAdvertisingTrackingId();
    }

    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public static JSONObject getPackageInfo(PackageManager packageManager) throws PackageManager.NameNotFoundException, JSONException {
        String appName = ClientProperties.getAppName();
        PackageInfo packageInfo = packageManager.getPackageInfo(appName, 0);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("installer", packageManager.getInstallerPackageName(appName));
        jSONObject.put("firstInstallTime", packageInfo.firstInstallTime);
        jSONObject.put("lastUpdateTime", packageInfo.lastUpdateTime);
        jSONObject.put("versionCode", packageInfo.versionCode);
        jSONObject.put("versionName", packageInfo.versionName);
        jSONObject.put("packageName", packageInfo.packageName);
        return jSONObject;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002d A[SYNTHETIC, Splitter:B:15:0x002d] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003a A[SYNTHETIC, Splitter:B:23:0x003a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, java.lang.String> getProcessInfo() {
        /*
            java.lang.String r0 = "Error closing RandomAccessFile"
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r2 = 0
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x0022, all -> 0x0020 }
            java.lang.String r4 = "/proc/self/stat"
            java.lang.String r5 = "r"
            r3.<init>(r4, r5)     // Catch:{ IOException -> 0x0022, all -> 0x0020 }
            java.lang.String r2 = r3.readLine()     // Catch:{ IOException -> 0x001e }
            java.lang.String r4 = "stat"
            r1.put(r4, r2)     // Catch:{ IOException -> 0x001e }
            r3.close()     // Catch:{ IOException -> 0x0031 }
            goto L_0x0035
        L_0x001e:
            r2 = move-exception
            goto L_0x0026
        L_0x0020:
            r1 = move-exception
            goto L_0x0038
        L_0x0022:
            r3 = move-exception
            r6 = r3
            r3 = r2
            r2 = r6
        L_0x0026:
            java.lang.String r4 = "Error while reading processor info: "
            com.unity3d.services.core.log.DeviceLog.exception(r4, r2)     // Catch:{ all -> 0x0036 }
            if (r3 == 0) goto L_0x0035
            r3.close()     // Catch:{ IOException -> 0x0031 }
            goto L_0x0035
        L_0x0031:
            r2 = move-exception
            com.unity3d.services.core.log.DeviceLog.exception(r0, r2)
        L_0x0035:
            return r1
        L_0x0036:
            r1 = move-exception
            r2 = r3
        L_0x0038:
            if (r2 == 0) goto L_0x0042
            r2.close()     // Catch:{ IOException -> 0x003e }
            goto L_0x0042
        L_0x003e:
            r2 = move-exception
            com.unity3d.services.core.log.DeviceLog.exception(r0, r2)
        L_0x0042:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.device.Device.getProcessInfo():java.util.Map");
    }

    public static String getProduct() {
        return Build.PRODUCT;
    }

    public static int getRingerMode() {
        if (ClientProperties.getApplicationContext() == null) {
            return -1;
        }
        AudioManager audioManager = (AudioManager) ClientProperties.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (audioManager != null) {
            return audioManager.getRingerMode();
        }
        return -2;
    }

    public static int getScreenBrightness() {
        if (ClientProperties.getApplicationContext() != null) {
            return Settings.System.getInt(ClientProperties.getApplicationContext().getContentResolver(), "screen_brightness", -1);
        }
        return -1;
    }

    public static int getScreenDensity() {
        if (ClientProperties.getApplicationContext() != null) {
            return ClientProperties.getApplicationContext().getResources().getDisplayMetrics().densityDpi;
        }
        return -1;
    }

    public static int getScreenHeight() {
        if (ClientProperties.getApplicationContext() != null) {
            return ClientProperties.getApplicationContext().getResources().getDisplayMetrics().heightPixels;
        }
        return -1;
    }

    public static int getScreenLayout() {
        if (ClientProperties.getApplicationContext() != null) {
            return ClientProperties.getApplicationContext().getResources().getConfiguration().screenLayout;
        }
        return -1;
    }

    public static int getScreenWidth() {
        if (ClientProperties.getApplicationContext() != null) {
            return ClientProperties.getApplicationContext().getResources().getDisplayMetrics().widthPixels;
        }
        return -1;
    }

    public static List<Sensor> getSensorList() {
        if (ClientProperties.getApplicationContext() != null) {
            return ((SensorManager) ClientProperties.getApplicationContext().getSystemService("sensor")).getSensorList(-1);
        }
        return null;
    }

    public static int getStreamMaxVolume(int i2) {
        if (ClientProperties.getApplicationContext() == null) {
            return -1;
        }
        AudioManager audioManager = (AudioManager) ClientProperties.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (audioManager != null) {
            return audioManager.getStreamMaxVolume(i2);
        }
        return -2;
    }

    public static int getStreamVolume(int i2) {
        if (ClientProperties.getApplicationContext() == null) {
            return -1;
        }
        AudioManager audioManager = (AudioManager) ClientProperties.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (audioManager != null) {
            return audioManager.getStreamVolume(i2);
        }
        return -2;
    }

    public static ArrayList<String> getSupportedAbis() {
        if (getApiLevel() < 21) {
            return getOldAbiList();
        }
        return getNewAbiList();
    }

    public static String getSystemProperty(String str, String str2) {
        if (str2 != null) {
            return System.getProperty(str, str2);
        }
        return System.getProperty(str);
    }

    public static long getTotalMemory() {
        return getMemoryInfo(MemoryInfoType.TOTAL_MEMORY);
    }

    public static long getTotalSpace(File file) {
        if (file == null || !file.exists()) {
            return -1;
        }
        return (long) Math.round((float) (file.getTotalSpace() / 1024));
    }

    public static String getUniqueEventId() {
        return UUID.randomUUID().toString();
    }

    public static long getUptime() {
        return SystemClock.uptimeMillis();
    }

    public static boolean hasX264Decoder() {
        if (selectAllDecodeCodecs(MimeTypes.VIDEO_H264).size() > 0) {
            return true;
        }
        return false;
    }

    public static boolean hasX265Decoder() {
        if (selectAllDecodeCodecs(MimeTypes.VIDEO_H265).size() > 0) {
            return true;
        }
        return false;
    }

    public static boolean isActiveNetworkConnected() {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (ClientProperties.getApplicationContext() == null || (connectivityManager = (ConnectivityManager) ClientProperties.getApplicationContext().getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    public static Boolean isAdbEnabled() {
        if (getApiLevel() < 17) {
            return oldAdbStatus();
        }
        return newAdbStatus();
    }

    private static boolean isHardwareAccelerated(MediaCodecInfo mediaCodecInfo, String str) {
        if (getApiLevel() >= 29) {
            return isHardwareAcceleratedV29(mediaCodecInfo);
        }
        return !isSoftwareOnly(mediaCodecInfo, str);
    }

    @TargetApi(29)
    private static boolean isHardwareAcceleratedV29(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isHardwareAccelerated();
    }

    public static boolean isLimitAdTrackingEnabled() {
        return AdvertisingId.getLimitedAdTracking();
    }

    public static boolean isLimitOpenAdTrackingEnabled() {
        return OpenAdvertisingId.getLimitedOpenAdTracking();
    }

    public static boolean isRooted() {
        try {
            return searchPathForBinary("su");
        } catch (Exception e2) {
            DeviceLog.exception("Rooted check failed", e2);
            return false;
        }
    }

    private static boolean isSoftwareOnly(MediaCodecInfo mediaCodecInfo, String str) {
        if (getApiLevel() >= 29) {
            return isSoftwareOnlyV29(mediaCodecInfo);
        }
        String lowerCase = mediaCodecInfo.getName().toLowerCase();
        if (lowerCase.startsWith("arc.")) {
            return false;
        }
        if (lowerCase.startsWith("omx.google.") || lowerCase.startsWith("omx.ffmpeg.") || ((lowerCase.startsWith("omx.sec.") && lowerCase.contains(".sw.")) || lowerCase.equals("omx.qcom.video.decoder.hevcswvdec") || lowerCase.startsWith("c2.android.") || lowerCase.startsWith("c2.google.") || (!lowerCase.startsWith("omx.") && !lowerCase.startsWith("c2.")))) {
            return true;
        }
        return false;
    }

    @TargetApi(29)
    private static boolean isSoftwareOnlyV29(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isSoftwareOnly();
    }

    public static boolean isUSBConnected() {
        Intent registerReceiver;
        if (ClientProperties.getApplicationContext() == null || (registerReceiver = ClientProperties.getApplicationContext().registerReceiver((BroadcastReceiver) null, new IntentFilter("android.hardware.usb.action.USB_STATE"))) == null) {
            return false;
        }
        return registerReceiver.getBooleanExtra("connected", false);
    }

    public static boolean isUsingWifi() {
        ConnectivityManager connectivityManager;
        if (ClientProperties.getApplicationContext() == null || (connectivityManager = (ConnectivityManager) ClientProperties.getApplicationContext().getSystemService("connectivity")) == null) {
            return false;
        }
        TelephonyManager telephonyManager = (TelephonyManager) ClientProperties.getApplicationContext().getSystemService("phone");
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !connectivityManager.getBackgroundDataSetting() || !connectivityManager.getActiveNetworkInfo().isConnected() || telephonyManager == null || activeNetworkInfo.getType() != 1 || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    public static boolean isWiredHeadsetOn() {
        if (ClientProperties.getApplicationContext() != null) {
            return ((AudioManager) ClientProperties.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO)).isWiredHeadsetOn();
        }
        return false;
    }

    @TargetApi(17)
    private static Boolean newAdbStatus() {
        try {
            boolean z2 = false;
            if (1 == Settings.Global.getInt(ClientProperties.getApplicationContext().getContentResolver(), "adb_enabled", 0)) {
                z2 = true;
            }
            return Boolean.valueOf(z2);
        } catch (Exception e2) {
            DeviceLog.exception("Problems fetching adb enabled status", e2);
            return null;
        }
    }

    private static Boolean oldAdbStatus() {
        try {
            boolean z2 = false;
            if (1 == Settings.Secure.getInt(ClientProperties.getApplicationContext().getContentResolver(), "adb_enabled", 0)) {
                z2 = true;
            }
            return Boolean.valueOf(z2);
        } catch (Exception e2) {
            DeviceLog.exception("Problems fetching adb enabled status", e2);
            return null;
        }
    }

    private static boolean searchPathForBinary(String str) {
        File[] listFiles;
        for (String file : System.getenv("PATH").split(":")) {
            File file2 = new File(file);
            if (file2.exists() && file2.isDirectory() && (listFiles = file2.listFiles()) != null) {
                for (File name : listFiles) {
                    if (name.getName().equals(str)) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    public static List<MediaCodecInfo> selectAllDecodeCodecs(String str) {
        ArrayList arrayList = new ArrayList();
        int codecCount = MediaCodecList.getCodecCount();
        for (int i2 = 0; i2 < codecCount; i2++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
            if (!codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                for (String equalsIgnoreCase : supportedTypes) {
                    if (equalsIgnoreCase.equalsIgnoreCase(str) && isHardwareAccelerated(codecInfoAt, str)) {
                        arrayList.add(codecInfoAt);
                    }
                }
            }
        }
        return arrayList;
    }
}
