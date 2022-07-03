import java.util.*;

class Node{
    int node;
    int wt;

    public Node(int _node, int _wt){
        this.node = _node;
        this.wt = _wt;
    }
}

public class Chef_and_Reversing{
    public static void main(String[] args) {
        int v, e;
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int u;
            int w;
            u = sc.nextInt();
            w = sc.nextInt();
            // Converting into 0 based
            u--;
            w--;
            adj.get(u).add(new Node(w, 0));
            adj.get(w).add(new Node(u, 1));

        }

        LinkedList<Node> q = new LinkedList<>();
        boolean[] vis = new boolean[v];
        q.addLast(new Node(0, 0));

        while(!q.isEmpty()){
            Node n = q.removeFirst();
            if(n.node == v-1){
                System.out.println(n.wt);
                return;
            }
            vis[n.node] = true;

            for (Node nodes : adj.get(n.node)) {
                if( vis[nodes.node]){
                    continue;
                }

                if(nodes.wt == 0){
                    q.addFirst(new Node(nodes.node, n.wt + 0));
                }else{
                    q.addLast(new Node(nodes.node, n.wt + 1));
                }
            }

        }
        System.out.println("-1");
    }
}