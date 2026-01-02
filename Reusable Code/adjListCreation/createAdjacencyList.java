import java.util.*;

public class createAdjacencyList {
    
    public Map<Integer, List<Integer>> createAdjListFromGraph(int[][] graph){
            Map<Integer, List<Integer>> adjList = new HashMap<>();
            int node = graph.length;
            for(int i = 0; i < node; i++){
                adjList.put(i, new ArrayList<>());
            }
            for(int i = 0; i < node; i++){
                int u = i;
                for(int v : graph[i]){
                    adjList.get(u).add(v);
                }
            }
            return adjList;
    }

}
// Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
/*adjList:
    {
        0=[1, 2, 3], 
        1=[0, 2], 
        2=[0, 1, 3], 
        3=[0, 2]
    }
*/

public class createAdjacencyList1 {

    public Map<Integer, List<Integer>> createAdjListFromEdge(int[][] edges, int node){
            Map<Integer, List<Integer>> adjList = new HashMap<>();
            for(int i = 0; i < node; i++){
                adjList.put(i, new ArrayList<>());
            }
            for(int[] edge : graph){
                int u = edge[0];
                int v = edge[1];
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }
            return adjList;
    }

}
// Input: node or V = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]]
/*adjList: 
    {
        0=[1, 2], 
        1=[0,2], 
        2=[0,1,3], 
        3=[2]
    }
*/
