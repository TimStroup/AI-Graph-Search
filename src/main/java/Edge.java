package main.java;

import java.util.HashSet;

public class Edge{
    private EdgeType type;
    private EdgeColor color;

    public HashSet<Edge> connectedEdges;

    public Edge(EdgeType type){
        connectedEdges = new HashSet<>();
        this.type = type;
        this.color = EdgeColor.NONE;
    }


    public void connectEdge(Edge edge){
        connectedEdges.add(edge);
    }

    public boolean disconnectEdge(Edge edge){ return connectedEdges.remove(edge);}

    public void setColor(EdgeColor color) {
        this.color = color;
    }

    public EdgeColor getColor() {
        return color;
    }

    public EdgeType getType() {
        return type;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Edge){
            Edge e = (Edge) obj;
            if(e.type == this.type){
                return true;
            }
        }
        return false;
    }


    public int hashCode(){
        return type.hashCode();
    }
}
