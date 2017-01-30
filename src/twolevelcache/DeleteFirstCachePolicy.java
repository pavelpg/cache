package twolevelcache;

import java.util.Map;

/**
 *
 * @author Павел
 */
public class DeleteFirstCachePolicy implements ICachePolicy{

    @Override
    public String getKeyDeleteCandidate(ICacheControl cache) {
        Map<String,BaseCacheEntry> c = cache.getCacheMap();
        for(String key:c.keySet()){
            return key;
        }
        return null;
    }
    
}
