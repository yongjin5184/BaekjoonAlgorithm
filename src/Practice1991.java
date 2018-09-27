import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by yong on 2018. 9. 27..
 */
public class Practice1991 {
    public static Tree tree = new Tree();
    public static void main(String[] args) throws IOException{
        /**
         * description : 백준 1991번, 트리순회
         * solution : 1. pre order, in order, post order 의 노드 순회 순서를 잘기억 한다.
         *            2. 트리 구현의 부분 요소가 되는 NODE 구현이 data, Node 형 left, right로 구성된다는 사실을 기억한다.
         *            3. Tree 는 root를 가지고 있고 search는 재귀를 통해 풀어나간다.
         *
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;


        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            tree.add(st.nextToken().charAt(0), st.nextToken().charAt(0), st.nextToken().charAt(0));
        }

        tree.preOrder(tree.root);
        System.out.println("");
        tree.inOrder(tree.root);
        System.out.println("");
        tree.postOrder(tree.root);
    }
}

class Node{
    char data;
    Node left;
    Node right;

    Node(char data){
        this.data = data;
    }
}

class Tree{
    Node root;
    public void add(char data, char LData, char RData){
        if(root == null){
            if(data != '.') root = new Node(data);
            if(LData != '.') root.left = new Node(LData);
            if(RData != '.') root.right = new Node(RData);
        }else{
            search(root, data, LData, RData);
        }
    }

    public void search(Node root, char data, char LData, char RData){
        if(root == null){
            return;
        }else if(root.data == data){
            if(LData != '.') root.left = new Node(LData);
            if(RData != '.') root.right = new Node(RData);
        }else{
            search(root.left, data, LData, RData);
            search(root.right, data, LData, RData);
        }
    }

    public void preOrder(Node root){
        System.out.print(root.data);
        if(root.left != null) preOrder(root.left);
        if(root.right != null) preOrder(root.right);
    }

    public void inOrder(Node root){
        if(root.left != null) inOrder(root.left);
        System.out.print(root.data);
        if(root.right != null) inOrder(root.right);
    }

    public void postOrder(Node root){
        if(root.left != null) postOrder(root.left);
        if(root.right != null) postOrder(root.right);
        System.out.print(root.data);
    }
}
