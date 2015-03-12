package RouteProviders;

import Elements.PathElement;
import Networks.NetWork;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Created by nfetissow on 3/12/15.
 */
public class RouteProviderImpl implements RouteProvider {




    @Override
    public List<PathElement> getRoute(Integer firstID, Integer secondID, NetWork net) throws RouteNotFoundException {
        Object[] elements = net.getPathElements().values().toArray();

        for(PathElement element : elements) {
          //Filling value matrix
          Collection<PathElement> neighbors = element.getConnections();

        }

        //Then using matrix we use Dijkstra's algorithm to find a route;

        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }
}
