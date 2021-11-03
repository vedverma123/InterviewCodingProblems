package datastructure.sept2021;

public class AVLTree {

    private AVLNode root;

    public void insert(int item){
        root = insert(root, item);
    }

    private AVLNode insert(AVLNode root, int item) {
        if(root == null)
            return new AVLNode(item);
        if(item >= root.value)
            root.right = insert(root.right, item);
        else
            root.left = insert(root.left, item);

        root.height = 1 + Math.max(height(root.left), height(root.right));
        if(isLeftHeavy(root)){
            System.out.println(root + " is left heavy");
            root = rightRotation(root);
        }else if(isRightHeavy(root)){
            System.out.println(root + " is right heavy");
            //left rotation
        }
        return root;
    }

    private AVLNode rightRotation(AVLNode node){
        final AVLNode left = root.left;
        left.right = root;
        root.left = null;
        return left;
    }

    private int balanceFactor(AVLNode node){
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    private boolean isRightHeavy(AVLNode node) {
        return balanceFactor(node) < -1;
    }

    private boolean isLeftHeavy(AVLNode node) {
        return balanceFactor(node) > 1;
    }

    private int height(AVLNode node){
        return node == null ? -1 : node.height;
    }

    public static void main(String[] args) {
        AVLTree obj = new AVLTree();
        obj.insert(14);
        obj.insert(12);
        obj.insert(10);
        obj.insert(5);
        obj.insert(1);
        obj.insert(0);
        System.out.println(obj.root);
    }


    private class AVLNode{
        int value;
        int height;
        AVLNode left;
        AVLNode right;

        public AVLNode(int value){
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" +
                    "value=" + value +
                    '}';
        }
    }

}
