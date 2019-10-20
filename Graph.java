import java.util.LinkedList;

public class Graph {
	int V;
	LinkedList<Integer> adjList[]; // Adjacency list for the Graph Array of vertexes V
	Graph(int V){
		this.V = V;
		adjList = new LinkedList[5];
		for(int i = 0; i< V; i++) {
			adjList[i] = new LinkedList<>();
		}
	}
	
	void addEdge(int src, int dest) {
		adjList[src].add(dest);
		adjList[dest].add(src);
	}
	
	void printGraph() {
		for(int i= 0; i<V;i++) {
			System.out.println("Adjecency List for the vertex "+i +" is:");
			for(int iter:adjList[i]) {
				System.out.print("->"+iter);
			}System.out.println("\n");
		}
	}
	
	void dfs(int src) {
		LinkedList<Integer> stack = new LinkedList<Integer>();
		Boolean[] visited = new Boolean[V];
		for(int i = 0; i< V; i++) visited[i] = false;
		
		stack.add(src);
		visited[src] = true;
		System.out.print(src+" ");
		int n;
		while(stack.size()!=0) {
			n = stack.getLast();
			stack.pop();
//			System.out.println(stack.toString());			
			for(int iter: adjList[n]) {
				if(!visited[iter]) {
					stack.add(iter);
					System.out.print(iter+" ");
					visited[iter] = true;
				}
			}	
		}		
	}
	
	void bfs(int src) {

		LinkedList<Integer> queue = new LinkedList<Integer>();
		Boolean[] visited = new Boolean[V];
		for(int i = 0; i< V; i++) visited[i] = false;
		
		queue.add(src);
		visited[src] = true;
		System.out.print(src+" ");
		int n;
		while(queue.size()!=0) {
			n = queue.getFirst();
			queue.removeFirst();
//			System.out.println(stack.toString());			
			for(int iter: adjList[n]) {
				if(!visited[iter]) {
					queue.add(iter);
					System.out.print(iter+" ");
					visited[iter] = true;
				}
			}	
		}	
	}
	
	void LevelOrderTraversal(int src) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		Boolean[] visited = new Boolean[V];
		for(int i = 0; i< V; i++) visited[i] = false;
		
		queue.add(src);
		visited[src] = true;
		System.out.println(src+" ");
		int n;
		while(queue.size()!=0) {
			int size = queue.size();
			for(int i = 0 ; i< size;i++) {
			n = queue.getFirst();
			queue.removeFirst();
//			System.out.println(stack.toString());			
			for(int iter: adjList[n]) {
				if(!visited[iter]) {
					queue.add(iter);
					System.out.print(iter+" ");
					visited[iter] = true;
				}
			}
			System.out.println("");
			}
		}	
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.addEdge(0,1);
		g.addEdge(0,4);
		g.addEdge(2,1);
		g.addEdge(3,1);
		g.addEdge(4,1);
		g.addEdge(2,3);
		g.addEdge(3,4);
		
//		g.printGraph();
		
		g.dfs(0);
		System.out.println(" ");
		g.bfs(0);
		System.out.println(" ");
		g.LevelOrderTraversal(0);
	}
}
