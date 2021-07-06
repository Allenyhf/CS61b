
public class LinkedListDeque<ItemType> implements Deque<ItemType> {

    public class Node{
        private ItemType item;
        Node next;
        Node prev;

        public Node (ItemType t, Node p, Node n){
            item = t;
            prev = p;
            next = n;
        }

        public Node(){
            item = null;
        }

        //        public Node(Node p, Node n){
//            //item = t;
//            prev = p;
//            next = n;
//        }
        public ItemType getItem(){
            return item;
        }
    }

    private Node sentinel;
    private int size;


    public void addFirst(ItemType item){
        /** not looping or recursion
         *  must be O(1) run time **/

        Node ptr = new Node(item, sentinel, sentinel.next);
        sentinel.next = ptr;
        (ptr.next).prev = ptr;
        size += 1;
    }

    public void addLast(ItemType item){
        /** not looping or recursion
         *  must be O(1) run time **/

        Node ptr = new Node(item, sentinel.prev, sentinel);
        sentinel.prev = ptr;
        (ptr.prev).next = ptr;
        size += 1;
    }

    public boolean isEmpty(){
        return (sentinel.prev == sentinel);
    }

    public int size(){
        /** O(1) run time **/
        return size;
    }

    public void printDeque(){
        Node ptr = sentinel;

        while(ptr.next != sentinel){
            System.out.print(ptr.next.item);
            System.out.print(" ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    public ItemType removeFirst(){
        /** not looping or recursion
         *  must be O(1) run time **/

        if(size == 0){
            System.out.println("LinkedListDeque is empty!");
            //return sentinel.item; //return random T
            return null;
        }

        Node tmp = sentinel.next;
        (tmp.next).prev = sentinel;
        sentinel.next = tmp.next;

        size -= 1;
        return tmp.getItem();
    }

    public ItemType removeLast(){
        /** not looping or recursion
         *  must be O(1) run time **/
        if(size == 0){
            System.out.println("LinkedListDeque is empty!");
            //return (new Node(null, null )).item; //return random T
            return null;
        }

        Node tmp = sentinel.prev;
        sentinel.prev = tmp.prev;
        (tmp.prev).next = sentinel;

        size -= 1;
        return tmp.getItem();
    }

    public ItemType get(int index){
        /* use iteration not recursion */
        if(index >= size){
            System.out.println("LinkedListDeque is empty!");
            return sentinel.getItem(); //return random T
        }

        int cnt = 0;
        Node ptr = sentinel.next;
        while(/*ptr != sentinel &&*/ cnt < index){
            ptr = ptr.next;
            cnt ++;
        }
        return ptr.getItem();
    }

    public LinkedListDeque(){
        sentinel = new Node();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public ItemType getRecursive(int index){
        if(index >= size){
            System.out.println("LinkedListDeque is empty!");
//            return sentinel.item; //return random T
            return null;
        }

        return getNodeRecursive(sentinel.next, index);
    }

    private ItemType getNodeRecursive(Node start, int index){
        if(index == 0)
            return start.getItem();
        return getNodeRecursive(start.next, index - 1);
    }

}

