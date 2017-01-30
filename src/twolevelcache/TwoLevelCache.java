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
        // second level cache settings
        ICachePolicy policy = new DeleteFirstCachePolicy(), policy2 = new LruCachePolicy();
        cache2 = new LimitedSizeCache();
        cache2.setDatasource(new IDatasource() {
            @Override
            public Object get(String key) {
                System.out.println("generate: "+key);
                return key;
            }
        });
        cache2.setMaxSize(4);
        cache2.setPolicy(policy2);
        cache2.setName("cache2");
        cache2.setCacheEntryFactory(new BaseCacheEntryFactory() {
            @Override
            public BaseCacheEntry create(Object v) {
                return new FileCacheEntry(v);
            }
        });
        // first level cache settings
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
        System.out.println(cache1.get("444"));
        System.out.println(cache1.get("444"));
        System.out.println(cache1.get("555"));
        System.out.println(cache1.get("555"));
        System.out.println(cache1.get("666"));
        System.out.println(cache1.get("666"));
    }
    
}
