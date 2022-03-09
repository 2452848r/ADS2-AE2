public class BST {

    public Node root;

    private class Node {
        private int key;
        private Node left;
        private Node right;
        private int size;

        public Node(int key) {
            this.key = key;
            this.left = null;
            this.right = null;
        }
    }

    public BST() {
        this.root = null;
    }

    public void insert(int key)  {
        root = recursiveInsert(root, key);
    }

    public Node recursiveInsert(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key) {
            root.left = recursiveInsert(root.left, key);
        } else if (key > root.key) {
            root.right = recursiveInsert(root.right, key);
        }
        return root;
    }

    public Node min(Node node){
        if(node.left == null){
            return node;
        }
        return min(node.left);
    }

    public Node extractMin(){
        if(root == null){
            return null;
        }
        return delete(root,min(root).key);
    }

    public Node delete(Node root, int key){
        if(root == null){
            return null;
        }
        if(key<root.key){
            root.left = delete(root.left,key);
        }
        else if(key>root.key){
            root.right = delete(root.right,key);
        }
        else{
            if(root.left == null){
                Node temp = root.right;
                return temp;
            }
            else if(root.right == null){
                Node temp = root.left;
                return temp;
            }
            else{
                Node temp = min(root.right);
                root.key = temp.key;
                delete(root.right, temp.key);
            }
        }
        return root;
    }

}
