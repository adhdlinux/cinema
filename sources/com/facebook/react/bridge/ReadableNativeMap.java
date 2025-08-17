package com.facebook.react.bridge;

import com.facebook.infer.annotation.Assertions;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@DoNotStrip
public class ReadableNativeMap extends NativeMap implements ReadableMap {
    private static int mJniCallCounter;
    private String[] mKeys;
    private HashMap<String, Object> mLocalMap;
    private HashMap<String, ReadableType> mLocalTypeMap;

    /* renamed from: com.facebook.react.bridge.ReadableNativeMap$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$ReadableType;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.facebook.react.bridge.ReadableType[] r0 = com.facebook.react.bridge.ReadableType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$react$bridge$ReadableType = r0
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Null     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Boolean     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Number     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.String     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Map     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Array     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.bridge.ReadableNativeMap.AnonymousClass3.<clinit>():void");
        }
    }

    private static class ReadableNativeMapKeySetIterator implements ReadableMapKeySetIterator {
        private final Iterator<String> mIterator;

        public ReadableNativeMapKeySetIterator(ReadableNativeMap readableNativeMap) {
            this.mIterator = readableNativeMap.getLocalMap().keySet().iterator();
        }

        public boolean hasNextKey() {
            return this.mIterator.hasNext();
        }

        public String nextKey() {
            return this.mIterator.next();
        }
    }

    static {
        ReactBridge.staticInit();
    }

    protected ReadableNativeMap(HybridData hybridData) {
        super(hybridData);
    }

    private void checkInstance(String str, Object obj, Class cls) {
        if (obj != null && !cls.isInstance(obj)) {
            throw new UnexpectedNativeTypeException("Value for " + str + " cannot be cast from " + obj.getClass().getSimpleName() + " to " + cls.getSimpleName());
        }
    }

    public static int getJNIPassCounter() {
        return mJniCallCounter;
    }

    /* access modifiers changed from: private */
    public HashMap<String, Object> getLocalMap() {
        HashMap<String, Object> hashMap = this.mLocalMap;
        if (hashMap != null) {
            return hashMap;
        }
        synchronized (this) {
            if (this.mKeys == null) {
                this.mKeys = (String[]) Assertions.assertNotNull(importKeys());
                mJniCallCounter++;
            }
            if (this.mLocalMap == null) {
                Object[] objArr = (Object[]) Assertions.assertNotNull(importValues());
                mJniCallCounter++;
                int length = this.mKeys.length;
                this.mLocalMap = new HashMap<>(length);
                for (int i2 = 0; i2 < length; i2++) {
                    this.mLocalMap.put(this.mKeys[i2], objArr[i2]);
                }
            }
        }
        return this.mLocalMap;
    }

    private HashMap<String, ReadableType> getLocalTypeMap() {
        HashMap<String, ReadableType> hashMap = this.mLocalTypeMap;
        if (hashMap != null) {
            return hashMap;
        }
        synchronized (this) {
            if (this.mKeys == null) {
                this.mKeys = (String[]) Assertions.assertNotNull(importKeys());
                mJniCallCounter++;
            }
            if (this.mLocalTypeMap == null) {
                Object[] objArr = (Object[]) Assertions.assertNotNull(importTypes());
                mJniCallCounter++;
                int length = this.mKeys.length;
                this.mLocalTypeMap = new HashMap<>(length);
                for (int i2 = 0; i2 < length; i2++) {
                    this.mLocalTypeMap.put(this.mKeys[i2], (ReadableType) objArr[i2]);
                }
            }
        }
        return this.mLocalTypeMap;
    }

    private Object getNullableValue(String str) {
        if (hasKey(str)) {
            return getLocalMap().get(str);
        }
        return null;
    }

    private Object getValue(String str) {
        if (hasKey(str) && !isNull(str)) {
            return Assertions.assertNotNull(getLocalMap().get(str));
        }
        throw new NoSuchKeyException(str);
    }

    private native String[] importKeys();

    private native Object[] importTypes();

    private native Object[] importValues();

    public boolean equals(Object obj) {
        if (!(obj instanceof ReadableNativeMap)) {
            return false;
        }
        return getLocalMap().equals(((ReadableNativeMap) obj).getLocalMap());
    }

    public ReadableArray getArray(String str) {
        return (ReadableArray) getNullableValue(str, ReadableArray.class);
    }

    public boolean getBoolean(String str) {
        return ((Boolean) getValue(str, Boolean.class)).booleanValue();
    }

    public double getDouble(String str) {
        return ((Double) getValue(str, Double.class)).doubleValue();
    }

    public Dynamic getDynamic(String str) {
        return DynamicFromMap.create(this, str);
    }

    public Iterator<Map.Entry<String, Object>> getEntryIterator() {
        if (this.mKeys == null) {
            this.mKeys = (String[]) Assertions.assertNotNull(importKeys());
        }
        final String[] strArr = this.mKeys;
        final Object[] objArr = (Object[]) Assertions.assertNotNull(importValues());
        return new Iterator<Map.Entry<String, Object>>() {
            int currentIndex = 0;

            public boolean hasNext() {
                return this.currentIndex < strArr.length;
            }

            public Map.Entry<String, Object> next() {
                final int i2 = this.currentIndex;
                this.currentIndex = i2 + 1;
                return new Map.Entry<String, Object>() {
                    public Object getValue() {
                        return objArr[i2];
                    }

                    public Object setValue(Object obj) {
                        throw new UnsupportedOperationException("Can't set a value while iterating over a ReadableNativeMap");
                    }

                    public String getKey() {
                        return strArr[i2];
                    }
                };
            }
        };
    }

    public int getInt(String str) {
        return ((Double) getValue(str, Double.class)).intValue();
    }

    public String getString(String str) {
        return (String) getNullableValue(str, String.class);
    }

    public ReadableType getType(String str) {
        if (getLocalTypeMap().containsKey(str)) {
            return (ReadableType) Assertions.assertNotNull(getLocalTypeMap().get(str));
        }
        throw new NoSuchKeyException(str);
    }

    public boolean hasKey(String str) {
        return getLocalMap().containsKey(str);
    }

    public int hashCode() {
        return getLocalMap().hashCode();
    }

    public boolean isNull(String str) {
        if (!getLocalMap().containsKey(str)) {
            throw new NoSuchKeyException(str);
        } else if (getLocalMap().get(str) == null) {
            return true;
        } else {
            return false;
        }
    }

    public ReadableMapKeySetIterator keySetIterator() {
        if (this.mKeys == null) {
            this.mKeys = (String[]) Assertions.assertNotNull(importKeys());
        }
        final String[] strArr = this.mKeys;
        return new ReadableMapKeySetIterator() {
            int currentIndex = 0;

            public boolean hasNextKey() {
                return this.currentIndex < strArr.length;
            }

            public String nextKey() {
                String[] strArr = strArr;
                int i2 = this.currentIndex;
                this.currentIndex = i2 + 1;
                return strArr[i2];
            }
        };
    }

    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> hashMap = new HashMap<>(getLocalMap());
        for (String next : hashMap.keySet()) {
            switch (AnonymousClass3.$SwitchMap$com$facebook$react$bridge$ReadableType[getType(next).ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    break;
                case 5:
                    hashMap.put(next, ((ReadableNativeMap) Assertions.assertNotNull(getMap(next))).toHashMap());
                    break;
                case 6:
                    hashMap.put(next, ((ReadableArray) Assertions.assertNotNull(getArray(next))).toArrayList());
                    break;
                default:
                    throw new IllegalArgumentException("Could not convert object with key: " + next + ".");
            }
        }
        return hashMap;
    }

    public ReadableNativeMap getMap(String str) {
        return (ReadableNativeMap) getNullableValue(str, ReadableNativeMap.class);
    }

    private <T> T getNullableValue(String str, Class<T> cls) {
        T nullableValue = getNullableValue(str);
        checkInstance(str, nullableValue, cls);
        return nullableValue;
    }

    private <T> T getValue(String str, Class<T> cls) {
        T value = getValue(str);
        checkInstance(str, value, cls);
        return value;
    }
}
