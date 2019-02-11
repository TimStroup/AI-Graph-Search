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

    public boolean noneAvailable(){
        return availableEdges.isEmpty();
    }

    public Object[] getAvailable(){
        return availableEdges.toArray();
    }

    public boolean selectEdge(EdgeType type, EdgeColor color){
        Edge newEdge = new Edge(type);
        if(availableEdges.contains(newEdge)){
            newEdge.setColor(color);
            selectedEdges.add(newEdge);
            availableEdges.remove(newEdge);
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
