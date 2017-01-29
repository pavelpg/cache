package twolevelcache;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Pavel
 */
public class BaseCache implements ICache,IDatasource,ICacheControl {
    private BaseCacheEntryFactory cacheEntryFactory;
    protected Map<String,BaseCacheEntry> container = new HashMap<>();
    private String name;
    private IDatasource ds; 
    @Override
    public Object get(String key) {
        if(container.containsKey(key)){
            System.out.println("hit "+name+": "+key);
            return container.get(key).get();
        }else{
            System.out.println("miss "+name+": "+key);
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
    public Map<String, BaseCacheEntry> getCacheMap() {
        return container;
    }

    protected void beforePutEntry() {
    }

    /**
     * 
     * 
     * 
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

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
}
