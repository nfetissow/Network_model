package Elements.PassiveElements;

import Elements.PathElement;

import java.util.ArrayList;
import java.util.Collection;

/***
 * Cable can connect only two elements.
 */
public class Cable extends PassiveElement {
    private PathElement[] connectedElements;

    public Cable() {
        this.connectedElements = new PathElement[2];
    }

    public void connectElements(PathElement first, PathElement second) {
        this.connectedElements[0] = first;
        this.connectedElements[1] = second;
    }

    @Override
    public Collection<PathElement> getConnections() {
        ArrayList<PathElement> connections = new ArrayList<PathElement>();
        for(PathElement element: connectedElements) {
            if(element != null) {
                connections.add(element);
            }
        }
        return connections;
    }
}
