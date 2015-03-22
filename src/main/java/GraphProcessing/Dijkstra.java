package GraphProcessing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Никита on 22.03.2015.
 */
public class Dijkstra {
    public static void computePaths(Vertex source)
    {
        source.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();

            // Visit each edge exiting u
            for (Edge e : u.adjacencies)
            {
                Vertex v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance) {
                    vertexQueue.remove(v);

                    v.minDistance = distanceThroughU ;
                    v.previous = u;
                    vertexQueue.add(v);
                }
            }
        }
    }

    public static List<Integer> getShortestPathFromTo(int fromIndex, int toIndex, double[][] costsMatrix) {
        ArrayList<Vertex> vertexes = new ArrayList<Vertex>();
        ArrayList<Edge> edges = new ArrayList<Edge>();

        for (int i = 0; i < costsMatrix.length; i++) {
            vertexes.add(new Vertex(i));
        }

        for (int i = 0; i < costsMatrix.length; i++) {
            edges.clear();
            for (int j = 0; j < costsMatrix.length; j++) {
                if(costsMatrix[i][j] != 0) {
                    edges.add(new Edge(vertexes.get(j), costsMatrix[i][j]));
                }
            }
            edges.toArray(vertexes.get(i).adjacencies);
        }

        computePaths(vertexes.get(fromIndex));
        return getShortestPathTo(vertexes.get(toIndex));



    }

    public static List<Integer> getShortestPathTo(Vertex target) {
        List<Integer> path = new ArrayList<Integer>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex.index);
        Collections.reverse(path);
        return path;
    }



}
