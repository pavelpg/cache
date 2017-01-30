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
public class LimitedSizeCache extends BaseCache{
    private int maxSize;

    /**
     * @return the maxSize
     */
    public int getMaxSize() {
        return maxSize;
    }

    /**
     * @param maxSize the maxSize to set
     */
    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }
    private ICachePolicy policy;
    @Override
    protected void beforePutEntry(){
        if(getPolicy() != null){
            while(container.size() >= maxSize - 1){
                String key = getPolicy().getKeyDeleteCandidate(this);
                if(key != null){
                    container.get(key).dispose();
                    container.remove(key);
                }
            }
        }
    }

    /**
     * @return the policy
     */
    public ICachePolicy getPolicy() {
        return policy;
    }

    /**
     * @param policy the policy to set
     */
    public void setPolicy(ICachePolicy policy) {
        this.policy = policy;
    }
}
