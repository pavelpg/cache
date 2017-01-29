package twolevelcache;

import java.util.Map;

/**
 *
 * @author Pavel
 */
public class BaseCache implements ICache,IDatasource,ICacheControl {
    private BaseCacheEntryFactory cacheEntryFactory;
    protected Map<String,CacheEntry> container;
    private IDatasource ds;
    @Override
    public Object get(String key) {
        if(container.containsKey(key)){
            return container.get(key);
        }else{
            Object value = ds.get(key);
            beforePutEntry();
            container.put(key, new CacheEntry(value));
            return value;
        }
    }

    @Override
    public void setDatasource(IDatasource datasource) {
        ds = datasource;
        container.clear();
    }

    @Override
    public Map<String, CacheEntry> getCacheMap() {
        return container;
    }

    protected void beforePutEntry() {
    }

    /**
     * @return the cacheEntryFactory
     */
    public BaseCacheEntryFactory getCacheEntryFactory() {
        return cacheEntryFactory;
    }

    /**
     * @param cacheEntryFactory the cacheEntryFactory to set
     */
    public void setCacheEntryFactory(BaseCacheEntryFactory cacheEntryFactory) {
        this.cacheEntryFactory = cacheEntryFactory;
    }
    
}
