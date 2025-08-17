package l1;

import java.util.Iterator;

public final /* synthetic */ class a {
    public static /* synthetic */ String a(CharSequence charSequence, Iterable iterable) {
        if (charSequence != null) {
            StringBuilder sb = new StringBuilder();
            Iterator it2 = iterable.iterator();
            if (it2.hasNext()) {
                while (true) {
                    sb.append((CharSequence) it2.next());
                    if (!it2.hasNext()) {
                        break;
                    }
                    sb.append(charSequence);
                }
            }
            return sb.toString();
        }
        throw new NullPointerException("delimiter");
    }
}
