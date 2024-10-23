public class ArrayDeque<T> {
    public T[] array;
    private int size;
    public int length;
    private int front;
    private int last;

    public ArrayDeque(){
        array = (T[]) new Object[8];
        size = 0;
        length = 8;
        front = 4;
        last = 4;
    }

    public ArrayDeque(ArrayDeque other){
        length = other.length;
        array = (T[]) new Object[length];
        System.arraycopy(other, 0, array, 0, length);
        size = other.size;
        front = other.front;
        last = other.last;
    }

    private void grow(){
        T[] newArray = (T[]) new Object[length * 2];
        int startPos = length/2;
        for(int i = 0; i< size; i++){
            front = plusOne(front, length);
            newArray[startPos] = array[front];
            startPos = plusOne(startPos, length * 2);
        } 
        array = newArray;
        front = length/2 - 1;
        last = length/2 + size -1;
        length *= 2;


    }

    private void shrink(){
        T[] newArray = (T[]) new Object[length/2];
        int startPos = length / 8 ;
        for(int i = 0; i < size; i++){
            front = plusOne(front , length);
            newArray[startPos] = array[front];
            startPos = plusOne(startPos, length/2);
        }
        array = newArray;
        front = length/8 -1;
        last = length/8 + size - 1;
        length /= 2;
    }

    private int minusOne(int index){
        if(index == 0){
            index = length - 1;
            return index;
        }else{
            return index -1;
        }
    }

    private int plusOne(int index, int length){
        if(index == length -1){
            return 0;
        }else{
            return index + 1;
        }
    }

    public void addFirst(T item){
        size++;
        if(size == length){
            array[front] = item;
            front = minusOne(front);
            grow();
        }else{
            array[front] = item;
            front = minusOne(front);
        }
    }

    public void addLast(T item){
        size++;
        if(size == length){
            last = plusOne(last, length);
            array[last] = item;
            grow();
        }else{
            last = plusOne(last, length);
            array[last] = item;
        }
    }

    public boolean isEmpty(){
        if(size == 0){
            return true;
        }else{
            return false;
        }
    }

    public int size(){
        return size;
    }

    public T removeFirst(){

        if(size == 0){
            return null;
        }
        size--;
        int temp = plusOne(front, length);
        T firstItem = array[temp];
        front = minusOne(front);
        if(length >= 16 && length / size >= 4){
            shrink();      
        }
        return firstItem;
    }

    public T removeLast(){
        if(size == 0){
            return null;
        }
        size--;
        T lastItem = array[last];
        last = minusOne(last);
        if(length >= 16 && length / size >= 4){
            shrink();      
        }
        return lastItem;
    }

    public T get(int index){
        if(index >= size){
            return null;
        }

        int temp = front;
        for(int i = 0; i < index + 1; i++){
            temp = plusOne(temp, length);
        }
        return array[temp];
    }

    public void printDeque(){
        int temp = plusOne(front,length);
        for(int i = 0; i<size; i++){
            System.out.print(array[temp] + " ");
            temp = plusOne(temp,length);
        }
    }
}
