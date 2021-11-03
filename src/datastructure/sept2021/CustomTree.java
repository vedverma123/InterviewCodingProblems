package datastructure.sept2021;

public class CustomTree {

    private Node root;

    @Override
    public String toString() {
        return "CustomTree{" +
                "root=" + root +
                '}';
    }

    public int treeHeight(){
        if(root == null)
            return 0;
        return treeHeight(root);
    }

    private int treeHeight(Node root) {
        if(root.right == null && root.left == null)
            return 0;
        return 1 + Math.max(treeHeight(root.left), treeHeight(root.right));
    }

    public void preOrderDepthFirst(){
        preOrderDepthFirstRecursive(root);
    }

    private void preOrderDepthFirstRecursive(Node root) {
        if(root == null)
            return;
        System.out.println(root.value);
        preOrderDepthFirstRecursive(root.left);
        preOrderDepthFirstRecursive(root.right);
    }

    public void inOrderDepthFirst(){
        inOrderDepthFirstRecursive(root);
    }

    private void inOrderDepthFirstRecursive(Node root) {
        if(root == null)
            return;
        inOrderDepthFirstRecursive(root.left);
        System.out.println(root.value);
        inOrderDepthFirstRecursive(root.right);
    }


    public static void main(String[] args) {
        CustomTree tree = new CustomTree();
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
        //tree.preOrderDepthFirst();
        //tree.inOrderDepthFirst();
        System.out.println(tree);
        System.out.println("Tree height -> "+tree.treeHeight());
    }

    public void insert(int item){
        if(root == null){
            root = new Node(item);
        }else{
            Node node = new Node(item);
            Node parentNode = findParent(item);
            if(item > parentNode.value){
                parentNode.right = node;
            }else{
                parentNode.left = node;
            }
        }
    }

    private Node findParent(int item) {
        Node parent = root;
        Node current = root;
        while(current != null){
            parent = current;
            current = item >= current.value ? current.right : current.left;
        }
        return parent;
    }

    public boolean find(int item){
        if(root == null){
            throw new IllegalStateException();
        }
        while(root != null){
            if(item == root.value)
                return true;
            if(item > root.value){
                root = root.right;
            }else{
                root = root.left;
            }
        }
        return false;
    }

    private class Node{
        private Integer value;
        private Node left;
        private Node right;

        public Node(){}

        public Node(Integer value){
            this.value = value;
        }

        public Node(Integer value, Node left, Node right){
            this.value = value;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }

        public Integer getValue() {
            return value;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }
    }
}
