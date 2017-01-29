package twolevelcache;

/**
 *
 * @author Pavel
 */
public class TwoLevelCache {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LimitedSizeCache cache1,cache2;
        ICachePolicy policy = new DeleteRandomCachePolicy();
        cache2 = new LimitedSizeCache();
        cache2.setDatasource(new IDatasource() {
            @Override
            public Object get(String key) {
                System.out.println("generate: "+key);
                return key;
            }
        });
        cache2.setMaxSize(4);
        cache2.setPolicy(policy);
        cache2.setName("cache2");
        cache2.setCacheEntryFactory(new BaseCacheEntryFactory() {
            @Override
            public BaseCacheEntry create(Object v) {
                return new FileCacheEntry(v);
            }
        });
        
        cache1 = new LimitedSizeCache();
        cache1.setDatasource(cache2);
        cache1.setMaxSize(2);
        cache1.setPolicy(policy);
        cache1.setName("cache1");
        cache1.setCacheEntryFactory(new BaseCacheEntryFactory() {
            @Override
            public BaseCacheEntry create(Object v) {
                return new CacheEntry(v);
            }
        });
        System.out.println(cache1.get("111"));
        System.out.println(cache1.get("111"));
        System.out.println(cache1.get("222"));
        System.out.println(cache1.get("222"));
        System.out.println(cache1.get("333"));
        System.out.println(cache1.get("333"));
        System.out.println(cache1.get("111"));
        System.out.println(cache1.get("111"));
        System.out.println(cache1.get("222"));
        System.out.println(cache1.get("222"));
        System.out.println(cache1.get("333"));
        System.out.println(cache1.get("333"));
    }
    
}
