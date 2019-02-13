package main.java.Driver;

public class AISearchDriver {

	public static void main(String[] args){
		AISearchDriver searchDriver = new AISearchDriver();

		searchDriver.dfsTreeSearch();
	}
	//goes through all of the initial starting conditions and finds a blue triangle from at-least one
	//showing that Player A always has a wining strategy
	public void dfsTreeSearch(){
		byte[][] graph = new byte[6][6];
		final boolean turn = true; //if turn is == 0 then it is blue. If turn is == 1 then it is red
		final boolean resultColor = true; //if result color == true looking for blue triangle if false looking for red triangle

		boolean result = recursiveDfsSearch(graph,turn,resultColor);
		if(result){
			System.out.println("Player A has a winning strategy to create a monochromatic triangle");
		}
		else{
			System.out.println("Player B has a winning strategy to create a monochromatic triangle");
		}

	}

    public boolean recursiveDfsSearch(byte[][] graph, boolean turn, boolean resultColor){
		int triangle = triangleExists(graph,resultColor);
		//if there is a blue triangle and we are looking for blue then it is good
		if(triangle == 1 && resultColor){
			return true;
		}
		//if there is a red triangle and we are looking for blue we failed
		else if(triangle == 2 && resultColor){
			return false;
		}
		else {
			//generate all subsequent states, || them if turn is blue, && them if turn is red
			boolean result = true;
			for(int i = 1; i < 6; i++){
				for(int j =0; j < 5;j++){
					if(i >j){
						if(turn){
							if(graph[i][j] == 0){
								byte[][] copy = graph.clone();
								copy[i][j] = 1;
								copy[j][i]= 1;
								boolean temp = recursiveDfsSearch(copy,!turn,resultColor);
								result = temp || result;
							}
						}
						else{
							if(graph[i][j] == 0){
								byte[][] copy = graph.clone();
								copy[i][j] = 2;
								copy[j][i] = 2;
								boolean temp = recursiveDfsSearch(copy,!turn, resultColor);
								result = temp && result;
							}

						}
					}

				}
			}
			return result;
		}
    }
    //returns 1 if there is a blue triangle and 2 if there is a red triangle and 0 if there is no triangle
    public static int triangleExists(byte[][] graph, boolean resultColor){
		for(int v = 0; v< 6;v++){
			for(int w = 0; w < 6; w++){
				for(int u = 0;u < 6;u++){
					if(graph[v][w] == graph[w][u] && graph[w][u] == graph[u][v] && graph[v][w] == 1 ){
						return 1;
					}
					else if(graph[v][w] == graph[w][u] && graph[w][u] == graph[u][v] && graph[v][w] == 2){
						return 2;
					}
				}
			}
		}
		return 0;
	}
}
