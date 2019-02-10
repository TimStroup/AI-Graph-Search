package main.java;

import java.util.HashSet;

public class EdgeSet {

    private HashSet<Edge> edges;


    public EdgeSet(){
        edges = new HashSet<>();

        for(EdgeType type: EdgeType.values()){
            edges.add(new Edge(type));
        }
    }

    public boolean checkForTriangle(){
        for(Edge edge : edges){
            for(Edge connectedEdge : edge.connectedEdges){
                if(connectedEdge.connectedEdges.contains(edge)){
                    return true;
                }
            }
        }
        return false;
    }
}
