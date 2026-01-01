import java.util.*;

public class createAdjacencyList {
    
    public Map<Integer, List<Integer>> createAdjList(int[][] graph){
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
/*Output: 

    {
        0=[1, 2, 3], 
        1=[0, 2], 
        2=[0, 1, 3], 
        3=[0, 2]
    }
*/
