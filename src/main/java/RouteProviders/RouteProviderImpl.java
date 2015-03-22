package RouteProviders;

import Elements.PathElement;
import GraphProcessing.Dijkstra;
import Networks.NetWork;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Created by nfetissow on 3/12/15.
 */
public class RouteProviderImpl implements RouteProvider {




    @Override
    public List<PathElement> getRoute(Integer firstID, Integer secondID, NetWork net) throws RouteNotFoundException {

        PathElement[] elements = null;
        net.getPathElements().toArray(elements);
        double[][] costsMatrix = new double[elements.length][elements.length];

        //Filling costsMatrix with values
        PathElement element;
        for (int i = 0; i < elements.length; i++) {
            element = elements[i];
            for(PathElement connectedElement: element.getConnections()) {
                for (int j = 0; j < elements.length; j++) {
                    if(connectedElement.equals(elements[j])) {
                        costsMatrix[i][j] = connectedElement.getCosts();
                        break;
                    }
                }
            }
        }

        int firstIndex, secondIndex;

        //Then using matrix we use Dijkstra's algorithm to find a route;
        List<Integer> almostRoute = Dijkstra.getShortestPathFromTo(firstIndex, secondIndex, costsMatrix);
        List<PathElement> route = new ArrayList<PathElement>();
        for (int i = 0; i < almostRoute.size(); i++) {
            route.add(elements[almostRoute.get(i)]);
        }
        return route;
    }

    @Override
    public String getDescription() {
        return null;
    }
}
