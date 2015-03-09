package Elements.PassiveElements;

import Elements.PassiveElements.PassiveElement;
import Elements.PathElement;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/***
 * Hub can be connected to many elements
 */
public class Hub extends PassiveElement {
    private HashSet<PathElement> connectedElements;

    public Hub() {
        connectedElements = new HashSet<PathElement>();
    }

    public void addConnection(PathElement element) {
        this.connectedElements.add(element);
    }

    public void disconnectElement(PathElement element) {
        this.connectedElements.remove(element);
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
