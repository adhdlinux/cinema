package com.facebook.react.bridge;

import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.NativeModule;
import com.facebook.systrace.SystraceMessage;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JavaMethodWrapper implements NativeModule.NativeMethod {
    private static final ArgumentExtractor<ReadableArray> ARGUMENT_EXTRACTOR_ARRAY = new ArgumentExtractor<ReadableArray>() {
        public ReadableArray extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i2) {
            return readableArray.getArray(i2);
        }
    };
    private static final ArgumentExtractor<Boolean> ARGUMENT_EXTRACTOR_BOOLEAN = new ArgumentExtractor<Boolean>() {
        public Boolean extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i2) {
            return Boolean.valueOf(readableArray.getBoolean(i2));
        }
    };
    /* access modifiers changed from: private */
    public static final ArgumentExtractor<Callback> ARGUMENT_EXTRACTOR_CALLBACK = new ArgumentExtractor<Callback>() {
        public Callback extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i2) {
            if (readableArray.isNull(i2)) {
                return null;
            }
            return new CallbackImpl(jSInstance, (int) readableArray.getDouble(i2));
        }
    };
    private static final ArgumentExtractor<Double> ARGUMENT_EXTRACTOR_DOUBLE = new ArgumentExtractor<Double>() {
        public Double extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i2) {
            return Double.valueOf(readableArray.getDouble(i2));
        }
    };
    private static final ArgumentExtractor<Dynamic> ARGUMENT_EXTRACTOR_DYNAMIC = new ArgumentExtractor<Dynamic>() {
        public Dynamic extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i2) {
            return DynamicFromArray.create(readableArray, i2);
        }
    };
    private static final ArgumentExtractor<Float> ARGUMENT_EXTRACTOR_FLOAT = new ArgumentExtractor<Float>() {
        public Float extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i2) {
            return Float.valueOf((float) readableArray.getDouble(i2));
        }
    };
    private static final ArgumentExtractor<Integer> ARGUMENT_EXTRACTOR_INTEGER = new ArgumentExtractor<Integer>() {
        public Integer extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i2) {
            return Integer.valueOf((int) readableArray.getDouble(i2));
        }
    };
    private static final ArgumentExtractor<ReadableMap> ARGUMENT_EXTRACTOR_MAP = new ArgumentExtractor<ReadableMap>() {
        public ReadableMap extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i2) {
            return readableArray.getMap(i2);
        }
    };
    private static final ArgumentExtractor<Promise> ARGUMENT_EXTRACTOR_PROMISE = new ArgumentExtractor<Promise>() {
        public int getJSArgumentsNeeded() {
            return 2;
        }

        public Promise extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i2) {
            return new PromiseImpl((Callback) JavaMethodWrapper.ARGUMENT_EXTRACTOR_CALLBACK.extractArgument(jSInstance, readableArray, i2), (Callback) JavaMethodWrapper.ARGUMENT_EXTRACTOR_CALLBACK.extractArgument(jSInstance, readableArray, i2 + 1));
        }
    };
    private static final ArgumentExtractor<String> ARGUMENT_EXTRACTOR_STRING = new ArgumentExtractor<String>() {
        public String extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i2) {
            return readableArray.getString(i2);
        }
    };
    private static final boolean DEBUG = PrinterHolder.getPrinter().shouldDisplayLogMessage(ReactDebugOverlayTags.BRIDGE_CALLS);
    private ArgumentExtractor[] mArgumentExtractors;
    private Object[] mArguments;
    private boolean mArgumentsProcessed = false;
    private int mJSArgumentsNeeded;
    private final Method mMethod;
    private final JavaModuleWrapper mModuleWrapper;
    private final int mParamLength;
    private final Class[] mParameterTypes;
    private String mSignature;
    private String mType = BaseJavaModule.METHOD_TYPE_ASYNC;

    private static abstract class ArgumentExtractor<T> {
        private ArgumentExtractor() {
        }

        public abstract T extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i2);

        public int getJSArgumentsNeeded() {
            return 1;
        }
    }

    public JavaMethodWrapper(JavaModuleWrapper javaModuleWrapper, Method method, boolean z2) {
        this.mModuleWrapper = javaModuleWrapper;
        this.mMethod = method;
        method.setAccessible(true);
        Class<Promise>[] parameterTypes = method.getParameterTypes();
        this.mParameterTypes = parameterTypes;
        int length = parameterTypes.length;
        this.mParamLength = length;
        if (z2) {
            this.mType = BaseJavaModule.METHOD_TYPE_SYNC;
        } else if (length > 0 && parameterTypes[length - 1] == Promise.class) {
            this.mType = BaseJavaModule.METHOD_TYPE_PROMISE;
        }
    }

    private ArgumentExtractor[] buildArgumentExtractors(Class[] clsArr) {
        ArgumentExtractor[] argumentExtractorArr = new ArgumentExtractor[clsArr.length];
        for (int i2 = 0; i2 < clsArr.length; i2 += argumentExtractorArr[i2].getJSArgumentsNeeded()) {
            Class<Dynamic> cls = clsArr[i2];
            if (cls == Boolean.class || cls == Boolean.TYPE) {
                argumentExtractorArr[i2] = ARGUMENT_EXTRACTOR_BOOLEAN;
            } else if (cls == Integer.class || cls == Integer.TYPE) {
                argumentExtractorArr[i2] = ARGUMENT_EXTRACTOR_INTEGER;
            } else if (cls == Double.class || cls == Double.TYPE) {
                argumentExtractorArr[i2] = ARGUMENT_EXTRACTOR_DOUBLE;
            } else if (cls == Float.class || cls == Float.TYPE) {
                argumentExtractorArr[i2] = ARGUMENT_EXTRACTOR_FLOAT;
            } else if (cls == String.class) {
                argumentExtractorArr[i2] = ARGUMENT_EXTRACTOR_STRING;
            } else if (cls == Callback.class) {
                argumentExtractorArr[i2] = ARGUMENT_EXTRACTOR_CALLBACK;
            } else if (cls == Promise.class) {
                argumentExtractorArr[i2] = ARGUMENT_EXTRACTOR_PROMISE;
                boolean z2 = true;
                if (i2 != clsArr.length - 1) {
                    z2 = false;
                }
                Assertions.assertCondition(z2, "Promise must be used as last parameter only");
            } else if (cls == ReadableMap.class) {
                argumentExtractorArr[i2] = ARGUMENT_EXTRACTOR_MAP;
            } else if (cls == ReadableArray.class) {
                argumentExtractorArr[i2] = ARGUMENT_EXTRACTOR_ARRAY;
            } else if (cls == Dynamic.class) {
                argumentExtractorArr[i2] = ARGUMENT_EXTRACTOR_DYNAMIC;
            } else {
                throw new RuntimeException("Got unknown argument class: " + cls.getSimpleName());
            }
        }
        return argumentExtractorArr;
    }

    private String buildSignature(Method method, Class[] clsArr, boolean z2) {
        StringBuilder sb = new StringBuilder(clsArr.length + 2);
        if (z2) {
            sb.append(returnTypeToChar(method.getReturnType()));
            sb.append('.');
        } else {
            sb.append("v.");
        }
        for (int i2 = 0; i2 < clsArr.length; i2++) {
            Class<Promise> cls = clsArr[i2];
            if (cls == Promise.class) {
                boolean z3 = true;
                if (i2 != clsArr.length - 1) {
                    z3 = false;
                }
                Assertions.assertCondition(z3, "Promise must be used as last parameter only");
            }
            sb.append(paramTypeToChar(cls));
        }
        return sb.toString();
    }

    private int calculateJSArgumentsNeeded() {
        int i2 = 0;
        for (ArgumentExtractor jSArgumentsNeeded : (ArgumentExtractor[]) Assertions.assertNotNull(this.mArgumentExtractors)) {
            i2 += jSArgumentsNeeded.getJSArgumentsNeeded();
        }
        return i2;
    }

    private static char commonTypeToChar(Class cls) {
        if (cls == Boolean.TYPE) {
            return 'z';
        }
        if (cls == Boolean.class) {
            return 'Z';
        }
        if (cls == Integer.TYPE) {
            return 'i';
        }
        if (cls == Integer.class) {
            return 'I';
        }
        if (cls == Double.TYPE) {
            return 'd';
        }
        if (cls == Double.class) {
            return 'D';
        }
        if (cls == Float.TYPE) {
            return 'f';
        }
        if (cls == Float.class) {
            return 'F';
        }
        if (cls == String.class) {
            return 'S';
        }
        return 0;
    }

    private String getAffectedRange(int i2, int i3) {
        if (i3 > 1) {
            return "" + i2 + "-" + ((i2 + i3) - 1);
        }
        return "" + i2;
    }

    private static char paramTypeToChar(Class cls) {
        char commonTypeToChar = commonTypeToChar(cls);
        if (commonTypeToChar != 0) {
            return commonTypeToChar;
        }
        if (cls == Callback.class) {
            return 'X';
        }
        if (cls == Promise.class) {
            return 'P';
        }
        if (cls == ReadableMap.class) {
            return 'M';
        }
        if (cls == ReadableArray.class) {
            return 'A';
        }
        if (cls == Dynamic.class) {
            return 'Y';
        }
        throw new RuntimeException("Got unknown param class: " + cls.getSimpleName());
    }

    private void processArguments() {
        if (!this.mArgumentsProcessed) {
            SystraceMessage.Builder beginSection = SystraceMessage.beginSection(0, "processArguments");
            beginSection.arg("method", (Object) this.mModuleWrapper.getName() + "." + this.mMethod.getName()).flush();
            try {
                this.mArgumentsProcessed = true;
                this.mArgumentExtractors = buildArgumentExtractors(this.mParameterTypes);
                this.mSignature = buildSignature(this.mMethod, this.mParameterTypes, this.mType.equals(BaseJavaModule.METHOD_TYPE_SYNC));
                this.mArguments = new Object[this.mParameterTypes.length];
                this.mJSArgumentsNeeded = calculateJSArgumentsNeeded();
            } finally {
                SystraceMessage.endSection(0).flush();
            }
        }
    }

    private static char returnTypeToChar(Class cls) {
        char commonTypeToChar = commonTypeToChar(cls);
        if (commonTypeToChar != 0) {
            return commonTypeToChar;
        }
        if (cls == Void.TYPE) {
            return 'v';
        }
        if (cls == WritableMap.class) {
            return 'M';
        }
        if (cls == WritableArray.class) {
            return 'A';
        }
        throw new RuntimeException("Got unknown return class: " + cls.getSimpleName());
    }

    public Method getMethod() {
        return this.mMethod;
    }

    public String getSignature() {
        if (!this.mArgumentsProcessed) {
            processArguments();
        }
        return (String) Assertions.assertNotNull(this.mSignature);
    }

    public String getType() {
        return this.mType;
    }

    public void invoke(JSInstance jSInstance, ReadableArray readableArray) {
        int i2;
        String str = this.mModuleWrapper.getName() + "." + this.mMethod.getName();
        SystraceMessage.beginSection(0, "callJavaModuleMethod").arg("method", (Object) str).flush();
        int i3 = 0;
        if (DEBUG) {
            PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.BRIDGE_CALLS, "JS->Java: %s.%s()", this.mModuleWrapper.getName(), this.mMethod.getName());
        }
        try {
            if (!this.mArgumentsProcessed) {
                processArguments();
            }
            if (this.mArguments == null || this.mArgumentExtractors == null) {
                throw new Error("processArguments failed");
            } else if (this.mJSArgumentsNeeded == readableArray.size()) {
                i2 = 0;
                while (true) {
                    ArgumentExtractor[] argumentExtractorArr = this.mArgumentExtractors;
                    if (i3 < argumentExtractorArr.length) {
                        this.mArguments[i3] = argumentExtractorArr[i3].extractArgument(jSInstance, readableArray, i2);
                        i2 += this.mArgumentExtractors[i3].getJSArgumentsNeeded();
                        i3++;
                    } else {
                        this.mMethod.invoke(this.mModuleWrapper.getModule(), this.mArguments);
                        SystraceMessage.endSection(0).flush();
                        return;
                    }
                }
            } else {
                throw new NativeArgumentsParseException(str + " got " + readableArray.size() + " arguments, expected " + this.mJSArgumentsNeeded);
            }
        } catch (UnexpectedNativeTypeException e2) {
            throw new NativeArgumentsParseException(e2.getMessage() + " (constructing arguments for " + str + " at argument index " + getAffectedRange(i2, this.mArgumentExtractors[i3].getJSArgumentsNeeded()) + ")", e2);
        } catch (IllegalArgumentException e3) {
            throw new RuntimeException("Could not invoke " + str, e3);
        } catch (IllegalAccessException e4) {
            throw new RuntimeException("Could not invoke " + str, e4);
        } catch (InvocationTargetException e5) {
            if (e5.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e5.getCause());
            }
            throw new RuntimeException("Could not invoke " + str, e5);
        } catch (Throwable th) {
            SystraceMessage.endSection(0).flush();
            throw th;
        }
    }
}
