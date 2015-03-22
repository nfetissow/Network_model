package GraphProcessing;

/**
 * Created by Никита on 22.03.2015.
 */
class Vertex implements Comparable<Vertex>
{
    public final int index;
    public Edge[] adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;
    public Vertex(int index) { this.index = index; }
    public int compareTo(Vertex other)
    {
        return Double.compare(minDistance, other.minDistance);
    }

}