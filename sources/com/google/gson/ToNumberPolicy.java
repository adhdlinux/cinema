package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.NumberLimits;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.math.BigDecimal;

public enum ToNumberPolicy implements ToNumberStrategy {
    DOUBLE {
        /* renamed from: b */
        public Double a(JsonReader jsonReader) throws IOException {
            return Double.valueOf(jsonReader.nextDouble());
        }
    },
    LAZILY_PARSED_NUMBER {
        public Number a(JsonReader jsonReader) throws IOException {
            return new LazilyParsedNumber(jsonReader.nextString());
        }
    },
    LONG_OR_DOUBLE {
        private Number b(String str, JsonReader jsonReader) throws IOException {
            try {
                Double valueOf = Double.valueOf(str);
                if ((!valueOf.isInfinite() && !valueOf.isNaN()) || jsonReader.isLenient()) {
                    return valueOf;
                }
                throw new MalformedJsonException("JSON forbids NaN and infinities: " + valueOf + "; at path " + jsonReader.getPreviousPath());
            } catch (NumberFormatException e2) {
                throw new JsonParseException("Cannot parse " + str + "; at path " + jsonReader.getPreviousPath(), e2);
            }
        }

        public Number a(JsonReader jsonReader) throws IOException, JsonParseException {
            String nextString = jsonReader.nextString();
            if (nextString.indexOf(46) >= 0) {
                return b(nextString, jsonReader);
            }
            try {
                return Long.valueOf(Long.parseLong(nextString));
            } catch (NumberFormatException unused) {
                return b(nextString, jsonReader);
            }
        }
    },
    BIG_DECIMAL {
        /* renamed from: b */
        public BigDecimal a(JsonReader jsonReader) throws IOException {
            String nextString = jsonReader.nextString();
            try {
                return NumberLimits.b(nextString);
            } catch (NumberFormatException e2) {
                throw new JsonParseException("Cannot parse " + nextString + "; at path " + jsonReader.getPreviousPath(), e2);
            }
        }
    }
}
