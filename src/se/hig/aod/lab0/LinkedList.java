package se.hig.aod.lab0;

/**
 * 
 * LinkedList implementation of List interface.
 * Author: David Sjöblom
 */
public class LinkedList<T> implements PrintableList<T> {

    private ListNode<T> root;
    private int size = 0;

    private class ListNode<T> {
        private T data;
        private ListNode<T> nextNode;

        public ListNode(T data) {
            this.data = data;
            this.nextNode = null;
        }

        public T getData() {
            return data;
        }

        public void setNextNode(ListNode<T> nextNode) {
            this.nextNode = nextNode;
        }

    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
        root = null;
    }

    @Override
    public int numberOfElements() {
        return size;
    }

    @Override
    public void insertFirst(T t) {
        ListNode<T> newNode = new ListNode<>(t);
        newNode.setNextNode(root);
        root = newNode;
        size++;
    }

    @Override
    public void insertLast(T t) {
        if (size == 0) {
            insertFirst(t);
            return;
        }

        ListNode<T> currentNode = root;

        while (currentNode.nextNode != null) {
            currentNode = currentNode.nextNode;
        }

        ListNode<T> newNode = new ListNode<>(t);
        currentNode.nextNode = newNode;
        size++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new ListEmptyException("Listan är tom");
        }

        T element = root.getData();
        root = root.nextNode;
        size--;

        return element;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new ListEmptyException("Listan är tom");
        }

        ListNode<T> currentNode = root;

        while (currentNode.nextNode != null) {
            currentNode = currentNode.nextNode;
        }

        T element = currentNode.getData();
        currentNode = null;
        size--;

        return element;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new ListEmptyException("Listan är tom");
        }
        return root.getData();
    }

    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new ListEmptyException("Listan är tom");
        }

        ListNode<T> currentNode = root;

        while (currentNode.nextNode != null) {
            currentNode = currentNode.nextNode;
        }
        
        return currentNode.getData();
    }

    @Override
    public String toStringRecursive() {
        return toStringNodeRecursive(root);
    }

    private String toStringNodeRecursive(ListNode<T> node) {
        if (node == null)
            return "";
        if (node.nextNode != null)
            return node.data.toString() + toStringNodeRecursive(node.nextNode);
        else
            return node.data.toString();
    }

    @Override
    public String toStringReverseRecursive() {
        return toStringNodeReverseRecursive(root);
    }

    private String toStringNodeReverseRecursive(ListNode<T> node) {
        if (node == null)
            return "";
        if (node.nextNode != null)
            return toStringNodeReverseRecursive(node.nextNode) + node.data.toString();
        else
            return node.data.toString();
    }

}
