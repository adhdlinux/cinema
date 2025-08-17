package org.apache.commons.lang3.exception;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.tuple.Pair;

public class DefaultExceptionContext implements ExceptionContext, Serializable {

    /* renamed from: b  reason: collision with root package name */
    private final List<Pair<String, Object>> f41438b = new ArrayList();

    public String a(String str) {
        String str2;
        StringBuilder sb = new StringBuilder(UserVerificationMethods.USER_VERIFY_HANDPRINT);
        if (str != null) {
            sb.append(str);
        }
        if (this.f41438b.size() > 0) {
            if (sb.length() > 0) {
                sb.append(10);
            }
            sb.append("Exception Context:\n");
            int i2 = 0;
            for (Pair next : this.f41438b) {
                sb.append("\t[");
                i2++;
                sb.append(i2);
                sb.append(':');
                sb.append((String) next.getKey());
                sb.append("=");
                Object value = next.getValue();
                if (value == null) {
                    sb.append("null");
                } else {
                    try {
                        str2 = value.toString();
                    } catch (Exception e2) {
                        str2 = "Exception thrown on toString(): " + ExceptionUtils.a(e2);
                    }
                    sb.append(str2);
                }
                sb.append("]\n");
            }
            sb.append("---------------------------------");
        }
        return sb.toString();
    }
}
