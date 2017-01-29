/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twolevelcache;

/**
 *
 * @author Pavel
 */
public class CacheEntry extends BaseCacheEntry {
    private Object value;
    public Object get(){
        super.get(); // todo: later fix bad design
        return value;
    }
    public CacheEntry(Object o){
        super();
        value = o;
        
    }
    public void dispose(){
        
    }
}
