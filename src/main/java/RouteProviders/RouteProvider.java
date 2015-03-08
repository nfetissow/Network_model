package RouteProviders;

import Elements.PathElement;

import java.util.List;

import Networks.NetWork;

/***
 * TODO: add useful comment
 */
public interface RouteProvider {

    /***
     *
     * @param firstID ID of element from which you want to find route
     * @param secondID ID of element to which you want to find route
     * @param net Network in which you want to perform search
     * @return List of elements which signal will go through in order to get from 1st to 2nd element
     * @throws RouteProviders.RouteNotFoundException
     */
    public List<PathElement> getRoute(Integer firstID, Integer secondID, NetWork net)
            throws RouteProviders.RouteNotFoundException;

    /***
     *
     * @return description of given RouteProvider
     */
    public String getDescription();
}
