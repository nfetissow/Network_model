package Elements;

import java.util.Collection;

/***
 * TODO: Add useful comment
 */
public interface PathElement {
    /***
     * How much time signal needs to go through given element
     * @return time
     */
    public double getTimeDelay();

    /***
     * How much it costs to send signal though given element
     * @return price
     */
    public double getCosts();

    /***
     * Return neighbour elements of given element
     * @return neighbour elements
     */
    public Collection<PathElement> getConnections();

    /***
     * Self-explanatory function name
     * @return info about given element
     */
    public String getInfo();

    /***
     * Self-explanatory function name
     * @return ID of given element
     */
    public Integer getID();


}
