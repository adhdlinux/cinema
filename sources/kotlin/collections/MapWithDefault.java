package kotlin.collections;

import java.util.Map;
import kotlin.jvm.internal.markers.KMappedMarker;

interface MapWithDefault<K, V> extends Map<K, V>, KMappedMarker {
    V c(K k2);
}
