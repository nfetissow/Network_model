package RouteProviders;

import Elements.PathElement;
import GraphProcessing.Dijkstra;
import Networks.NetWork;

import java.util.ArrayList;
import java.util.List;

public class RouteProviderImpl implements RouteProvider {
    @Override
    public List<PathElement> getRoute(Integer firstID, Integer secondID, NetWork net) throws RouteNotFoundException {

        PathElement[] elements = null;
        net.getPathElements().toArray(elements);
        //We need to find where elements between which we are looking for route are situated in our elements array
        int firstIndex = 0, secondIndex = 0;
        boolean firstFound = false,
                secondFound = false;
        for (int i = 0; i < elements.length; i++) {
            if(firstFound && secondFound) {
                break;
            }
            if(elements[i].getID().equals(firstID)) {
                firstIndex = i;
                firstFound = true;
            } else if (elements[i].getID().equals(secondID)) {
                secondIndex = i;
                secondFound = true;
            }
        }
        if(! firstFound && secondFound) {
            throw new RouteNotFoundException("Can't find elements with given IDs in the net");
        }

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
