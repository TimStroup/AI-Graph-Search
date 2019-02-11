package main.java.Driver;
import main.java.*;

public class AISearchDriver {

	public static void main(String[] args){
		AISearchDriver searchDriver = new AISearchDriver();

		searchDriver.dfsTreeSearch();
	}
	//goes through all of the initial starting conditions and finds a blue triangle from at-least one
	//showing that Player A always has a wining strategy
	public void dfsTreeSearch(){
		EdgeSet edgeSet;

		for(EdgeType type : EdgeType.values()){
			EdgeType[] edges = EdgeType.values();
			edgeSet = new EdgeSet();
			edgeSet.selectEdge(type, EdgeColor.BLUE);
			if(recursiveDfsSearch(edgeSet,EdgeColor.RED)){
				System.out.println("A has a winning strategy from edge: " + type);
				System.exit(0);
			}
			else {
				System.out.println("Not for edge: " + type);
			}
		}

    }

    public boolean recursiveDfsSearch(EdgeSet edgeSet,EdgeColor color){
		if(edgeSet.checkForTriangle(EdgeColor.BLUE)){
			return true;
		}
		else if(edgeSet.noneAvailable()){
			return false;
		}
		else {

			return recursiveDfsSearch(edgeSet,color);
		}
    }
}
