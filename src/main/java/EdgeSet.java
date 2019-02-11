package main.java;

import java.util.HashSet;

public class EdgeSet {

    private HashSet<Edge> availableEdges;
    private HashSet<Edge> selectedEdges;


    public EdgeSet(){
        availableEdges = new HashSet<>();
        selectedEdges = new HashSet<>();
        for(EdgeType type: EdgeType.values()){
            availableEdges.add(new Edge(type));
        }
    }

    public boolean selectEdge(Edge edge){
        if(availableEdges.contains(edge)){
            selectedEdges.add(edge);
            availableEdges.remove(edge);
            return true;
        }
        return false;
    }

    //looks for a triangle from the selected edges
    public boolean checkForTriangle(EdgeColor  color){
        for(Edge edge : selectedEdges){
            if(edge.getColor() == color){
                for(Edge connectedEdge : edge.connectedEdges){
                    if(connectedEdge.getColor() == color){
                        for(Edge thirdEdge : connectedEdge.connectedEdges){
                            if(thirdEdge.getColor() == color){
                                if(connectedEdge.connectedEdges.contains(edge)){
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
