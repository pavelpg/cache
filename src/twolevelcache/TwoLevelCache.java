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
        cache2 = new LimitedSizeCache();
        cache2.setDatasource(new IDatasource() {
            @Override
            public Object get(String key) {
                return key;
            }
        });
        cache2.setMaxSize(20);
        //cache2.
    }
    
}
