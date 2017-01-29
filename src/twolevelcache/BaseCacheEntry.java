/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twolevelcache;

/**
 *
 * @author Катя
 */
public abstract class BaseCacheEntry {
    protected long lastReadTs;
    protected final long createdTs;
    protected int count; // count of gets

    public BaseCacheEntry() {
        createdTs = System.currentTimeMillis();
    }

    public Object get(){
        lastReadTs = System.currentTimeMillis();
        count ++;
        return null; // todo: later fix bad design
    }

    public long getCreatedTs() {
        return createdTs;
    }

    public int getCount() {
        return count;
    }

    public long getLastReadTs() {
        return lastReadTs;
    }

    public abstract void dispose();
    
}
