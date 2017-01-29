package twolevelcache;

/**
 *
 * @author Pavel
 */
public interface ICache {
    Object get(String key);
    void setDatasource(IDatasource datasource);
    
}
