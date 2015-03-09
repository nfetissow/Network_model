package Elements.PassiveElements;


import Elements.ActiveElements.ActiveElement;
import Elements.PathElement;

import java.util.Collection;

public class PassiveElement implements PathElement {

    private double timeDelay;
    private double costs;
    private Integer ID;


    public void setTimeDelay(double timeDelay) {
        this.timeDelay = timeDelay;
    }

    public void setCosts(double costs) {
        this.costs = costs;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PassiveElement other = (PassiveElement) obj;
        if(this.ID != other.getID())
            return false;
        return true;
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
    public String getInfo() {
        return "This is an instance of PassiveElement";
    }

    @Override
    public Integer getID() {
        return this.ID;
    }

    @Override
    public Collection<PathElement> getConnections() {
        return null;
    }
}
