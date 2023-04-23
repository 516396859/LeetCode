//import javax.xml.soap.Node;
//import java.util.ArrayDeque;
//import java.util.HashMap;
//
//public class BFS {
//    public void bfs(Node startNode){
//        //BFS必须用队列，不用栈
//        ArrayDeque<Node> queue = new ArrayDeque<>();
//        // hashmap 有两个作用，一个是记录一个点是否被丢进过队列了，避免重复访问
//        // 另外一个是记录 startNode 到其他所有节点的最短距离
//        //  node 做 key 的时候比较的是内存地址
//        HashMap<Node, Integer> distance = new HashMap<>();
//        // 把起点放进队列和哈希表里，如果有多个起点，都放进去
//        queue.addLast(startNode);
//        distance.put(startNode,0);
//        while(!queue.isEmpty()){
//            Node node = queue.pollFirst();
//            // 如果有明确的终点可以在这里加终点的判断
//            if(node==end){
//                // do something
//                // break or return
//            }
//            // 遍历出队节点的所有未访问的邻居
//            for(Node neighbor : node.getNeighbors()) {
//                if(distance.containsKey(neighbor)){
//                    continue;
//                }
//                queue.addLast(neighbor);
//                // 入队了就立即标记，紧跟addLast方法，滞后标记会有重复元素入队
//                distance.put(neighbor,distance.get(node)+1);
//            }
//        }
//
//        // 如果需要返回所有点离起点的距离，就return hashmap
//        // return distance;
//        // 如果需要返回所有连通的节点, 就 return HashMap 里的所有点
//        // return distance.keySet();
//        // 如果需要返回离终点的最短距离
//        // return distance.get(endNode);
//    }
//}
