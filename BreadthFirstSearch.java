import java.util.*;

public class BreadthFirstSearch {

    public void breadthFirstSearch(int [][]graph, int point, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(point);
        visited[point] = true;

        while(!queue.isEmpty()){
            int x = queue.poll();
            System.out.print(x + " ");

            for (int i=0; i<graph[x].length; i++){
                int y = graph[x][i];
                
                if (visited[y] == false){
                    queue.offer(y);
                    visited[y]=true;
                }
            }
        }
    }

    public void solution(int [][] grapth, int start, int n){
        boolean []visited = new boolean[n];
        breadthFirstSearch(grapth, start, visited);
    }

    public static void main(String []args){
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        int n = 9;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 노드 1에 연결된 노드 정보 저장 
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        // 노드 2에 연결된 노드 정보 저장 
        graph.get(2).add(1);
        graph.get(2).add(7);

        // 노드 3에 연결된 노드 정보 저장 
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        // 노드 4에 연결된 노드 정보 저장 
        graph.get(4).add(3);
        graph.get(4).add(5);

        // 노드 5에 연결된 노드 정보 저장 
        graph.get(5).add(3);
        graph.get(5).add(4);

        // 노드 6에 연결된 노드 정보 저장 
        graph.get(6).add(7);

        // 노드 7에 연결된 노드 정보 저장 
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);

        // 노드 8에 연결된 노드 정보 저장 
        graph.get(8).add(1);
        graph.get(8).add(7);

        int[][] graphArray = new int[graph.size()][];
        for (int i = 0; i < graph.size(); i++) {
            ArrayList<Integer> innerList = graph.get(i);
            graphArray[i] = innerList.stream().mapToInt(Integer::intValue).toArray();
        }
        
        bfs.solution(graphArray, 1, n);
    }
}
