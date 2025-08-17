package kotlinx.serialization.json;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.serialization.Serializable;

@Serializable(with = JsonArraySerializer.class)
public final class JsonArray extends JsonElement implements List<JsonElement>, KMappedMarker {

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f41120d = new Companion((DefaultConstructorMarker) null);

    /* renamed from: c  reason: collision with root package name */
    private final List<JsonElement> f41121c;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonArray(List<? extends JsonElement> list) {
        super((DefaultConstructorMarker) null);
        Intrinsics.f(list, "content");
        this.f41121c = list;
    }

    public boolean a(JsonElement jsonElement) {
        Intrinsics.f(jsonElement, "element");
        return this.f41121c.contains(jsonElement);
    }

    public /* bridge */ /* synthetic */ void add(int i2, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int i2, Collection<? extends JsonElement> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends JsonElement> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: b */
    public JsonElement get(int i2) {
        return this.f41121c.get(i2);
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof JsonElement)) {
            return false;
        }
        return a((JsonElement) obj);
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        Intrinsics.f(collection, "elements");
        return this.f41121c.containsAll(collection);
    }

    public int d() {
        return this.f41121c.size();
    }

    public int e(JsonElement jsonElement) {
        Intrinsics.f(jsonElement, "element");
        return this.f41121c.indexOf(jsonElement);
    }

    public boolean equals(Object obj) {
        return Intrinsics.a(this.f41121c, obj);
    }

    public int g(JsonElement jsonElement) {
        Intrinsics.f(jsonElement, "element");
        return this.f41121c.lastIndexOf(jsonElement);
    }

    public int hashCode() {
        return this.f41121c.hashCode();
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof JsonElement)) {
            return -1;
        }
        return e((JsonElement) obj);
    }

    public boolean isEmpty() {
        return this.f41121c.isEmpty();
    }

    public Iterator<JsonElement> iterator() {
        return this.f41121c.iterator();
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof JsonElement)) {
            return -1;
        }
        return g((JsonElement) obj);
    }

    public ListIterator<JsonElement> listIterator() {
        return this.f41121c.listIterator();
    }

    public ListIterator<JsonElement> listIterator(int i2) {
        return this.f41121c.listIterator(i2);
    }

    public /* bridge */ /* synthetic */ Object remove(int i2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void replaceAll(UnaryOperator<JsonElement> unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return d();
    }

    public void sort(Comparator<? super JsonElement> comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public List<JsonElement> subList(int i2, int i3) {
        return this.f41121c.subList(i2, i3);
    }

    public Object[] toArray() {
        return CollectionToArray.a(this);
    }

    public <T> T[] toArray(T[] tArr) {
        Intrinsics.f(tArr, "array");
        return CollectionToArray.b(this, tArr);
    }

    public String toString() {
        return CollectionsKt___CollectionsKt.J(this.f41121c, ",", "[", "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
    }
}
