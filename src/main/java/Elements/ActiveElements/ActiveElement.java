package Elements.ActiveElements;

import Elements.PassiveElements.PassiveElement;
import Elements.PathElement;

import java.util.ArrayList;
import java.util.Collection;

/***
 * TODO: write useful comment
 */

public class ActiveElement implements PathElement{


    private double timeDelay;
    private double costs;
    private Integer ID;
    private ArrayList<PassiveElement> connectedPassiveElements;

    public void addConnection(PassiveElement element) {
        this.connectedPassiveElements.add(element);
    }

    public Collection<IPAddress> getIP() {
        return null;
    }


    public void setTimeDelay(double timeDelay) {
        this.timeDelay = timeDelay;
    }

    public void setCosts(double costs) {
        this.costs = costs;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ActiveElement other = (ActiveElement) obj;
        if(this.ID != other.getID())
            return false;
        return true;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    @Override
    public double getTimeDelay() {
        return this.timeDelay;
    }

    @Override
    public double getCosts() {
        return this.costs;
    }

    @Override
    public Collection<ActiveElement> getConnections() {
        return null;
    }

    @Override
    public String getInfo() {
        return "This is an instance of ActiveElement";
    }

    @Override
    public Integer getID() {
        return this.ID;
    }
}
