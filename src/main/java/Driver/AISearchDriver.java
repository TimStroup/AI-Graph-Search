package main.java.Driver;
import main.java.EdgeSet;
import main.java.Vertices;

public class AISearchDriver {

	public static void main(String[] args){
		AISearchDriver searchDriver = new AISearchDriver();

		EdgeSet edgeSet = new EdgeSet();

		searchDriver.dfsTreeSearch(edgeSet);
	}
	//goes through all of the initial starting conditions and finds a blue triangle from at-least one
	//showing that Player A always has a wining strategy
	public void dfsTreeSearch(EdgeSet edgeSet){

    }

    public boolean recursiveDfsSearch(){
		return true;
    }
}
