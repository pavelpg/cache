package twolevelcache;

import java.util.Map;

/**
 *
 * @author Павел
 */
public class LruCachePolicy implements ICachePolicy{

    @Override
    public String getKeyDeleteCandidate(ICacheControl cache) {
        Map<String,BaseCacheEntry> c = cache.getCacheMap();
        long minTs = Long.MAX_VALUE;
        String minTsKey = null;
        
        for(String key:c.keySet()){
            long ts = c.get(key).getLastReadTs();
            if(ts < minTs){
                minTs = ts;
                minTsKey = key;
            }
        }
        return minTsKey;
    }
    
}
