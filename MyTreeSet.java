package HomeWork4;

import HomeWork3.MyTreeMap;

public class MyTreeSet<T> {
    // Добавление элемента, получение элемента по ключу, удаление элемента по ключу
    private int size = 0;
    private Node root = null;

    private class Node {
        public T elem;
        public Node left = null;
        public Node right = null;
        public Node (T elem) {
            this.elem = elem;
        }
    }

    public T add(T elem) {
        if (root == null) {
            root = new Node(elem);
            size++;
            return null;
        }
        return putHelper(root,elem);
    }
    private T putHelper(Node node, T elem) {
        Comparable<? super T> k = (Comparable<? super T>)elem;
        int cmp = k.compareTo(node.elem);
        if (cmp < 0) {
            if (node.left == null) {
                node.left = new Node(elem);
                size++;
                return null;
            }
            return putHelper(node.left,elem);
        }
        if (cmp > 0) {
            if (node.right == null) {
                node.right = new Node(elem);
                size++;
                return null;
            }
            return putHelper(node.right,elem);
        }
        T oldElem = node.elem;
        node.elem = elem;
        return oldElem;
    }

    private Node findNode(Object target) {
        Comparable<? super T> k = (Comparable<? super T>) target;
        Node node = root;
        while (node != null) {
            int cmp = k.compareTo(node.elem);
            if (cmp < 0) {
                node = node.left;
            }
            if (cmp > 0) {
                node = node.right;
            }
            if (cmp == 0) return node;
        }
        return null;
    }
    private Node findParent(Object target) {
        Comparable<? super T> k = (Comparable<? super T>) target;
        Node node = root;
        Node parent = root;
        while (node != null) {
            int cmp = k.compareTo(node.elem);
            if (cmp < 0) {
                parent = node;
                node = node.left;
            }
            if (cmp > 0) {
                parent = node;
                node = node.right;
            }
            if (cmp == 0) return parent;
        }
        return null;
    }
    public T remove(Object elem) {
        T oldElem = get(elem);
        if (elem == root.elem) root = delRecursive(elem);
        else delRecursive(elem);
        return oldElem;
    }

    private Node delRecursive(Object elem) {
        Node node = findNode(elem);
        Node parent = findParent(elem);
        if (node.left == null && node.right == null) {
            if (node == parent.left) parent.left = null;
            if (node == parent.right) parent.right = null;
            size--;
            return parent;
        }
        if (node.right == null) {
            if (node == parent.left) parent.left = node.left;
            if (node == parent.right) parent.right = node.left;
            size--;
            return parent;
        }
        if (node.left == null) {
            if (node == parent.left) parent.left = node.right;
            if (node == parent.right) parent.right = node.right;
            size--;
            return parent;
        }
        Node tempNode = findSmallest(node.right);
        delRecursive(tempNode.elem);
        node.elem = tempNode.elem;
        return parent;
    }

    private Node findSmallest(Node node) {
        if (node.left == null) return node;
        else {
            return findSmallest(node.left);
        }
    }

    public T get(Object elem) {
        Node node = findNode(elem);
        if (node == null) return null;
        return node.elem;
    }

    public void printTree() {
        LER(root);
        System.out.println("__________");
    }

    public boolean contains(T elem){
        Node node = findNode(elem);
        if(node == null) return false;
        return true;
    }


    private void LER(Node node) {
        if (node.left != null) LER(node.left);
        System.out.println(node.elem);
        if (node.right != null) LER(node.right);
    }
}
