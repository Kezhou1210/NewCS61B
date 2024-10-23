
public class LinkedListDeque<T> implements Deque<T> {
    public class Node{
        public T item;
        public Node prev;
        public Node next;  

        public Node(T i, Node p, Node n){
            this.item = i;
            this.next = n;
            this.prev = p;
        }

        public Node(Node p, Node n){
            this.prev = p;
            this.next = n;
        }
    }

    public int size;
    public Node sentinel;

    public LinkedListDeque(T x){
        sentinel = new Node(null, null);
        sentinel.next = new Node(x, sentinel, sentinel);
        size = 1;
    }

    public LinkedListDeque(){
        sentinel = new Node(null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public LinkedListDeque(LinkedListDeque<T> other){
        sentinel = new Node(null, null);
        int temp_size = other.size;
        while(temp_size != 0){
            this.addFirst(other.get(other.size - temp_size));
            temp_size--;
        }
    }

    @Override
    public void addFirst(T item){
        size++;
        sentinel.next = new Node(item, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
    }

    @Override
    public void addLast(T item){
        size++;
        sentinel.prev = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
    }

    @Override
    public boolean isEmpty(){
        if(size ==0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public T removeFirst(){
        T item = sentinel.next.item;
        size--;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        return item;
    }

    @Override
    public T removeLast(){
        T item = sentinel.prev.item;
        size--;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        return item;
    }

    @Override
    public T get(int index){
        if(index >= size){
            return null;
        }
        Node temp = sentinel.next;
        while(index != 0){
            temp = temp.next;
        }
        return temp.item;
    }

    public T getRecursive(int index){
        if(index > size){
            return null;
        }
        return getRecursiveHelper(sentinel, index);
    }

    private T getRecursiveHelper(Node n, int index){
        if(index == 0){
            return n.item;
        }else{
            return getRecursiveHelper(n.next, index-1);
        }
    }
    
    @Override
    public void printDeque(){
        Node temp = sentinel.next;
        while(temp != sentinel){
            System.out.print(temp.item + " ");
            temp = temp.next;
        }
    }
}
