package twolevelcache;

/**
 *
 * @author Pavel
 */
public interface ICachePolicy {
    /*
    when cache decides to delete one entry when maximum cache size is reached
    */
    String getKeyDeleteCandidate(ICacheControl cache); 
}
