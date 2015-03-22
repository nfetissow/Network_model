package GraphProcessing;

/**
 * Created by Никита on 22.03.2015.
 */
class Edge
{
    public final Vertex target;
    public final double weight;
    public Edge(Vertex argTarget, double argWeight)
    { target = argTarget; weight = argWeight; }
}