package twolevelcache;

import java.util.Map;

/**
 *
 * @author Pavel
 */
public interface ICacheControl {
    Map<String, BaseCacheEntry> getCacheMap();
}
