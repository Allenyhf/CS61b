import org.junit.Test;
import static org.junit.Assert.*;


public class ArrayDequeTest {

    @Test
    public void testFullEmpty(){
        ArrayDeque<Integer> arrdq = new ArrayDeque<>();
        int i = 0;
        while(i < 8){
            arrdq.addLast(i);
            i++;
        }
        assertEquals(true, arrdq.isFull());
        assertEquals(false, arrdq.isEmpty());

        i = 0;
        while(i < 7){
            arrdq.removeLast();
            i++;
        }
        assertEquals(false, arrdq.isFull());
        assertEquals(false, arrdq.isEmpty());
        arrdq.removeLast();
        assertEquals(true, arrdq.isEmpty());
    }

    @Test
    public void IntTest1(){
        // addFirst --> removeFirst
        ArrayDeque<Integer> arrdq = new ArrayDeque<>();
        assertEquals(true, arrdq.isEmpty());
        assertEquals(false, arrdq.isFull());

        arrdq.addFirst(0);
        assertEquals(false, arrdq.isEmpty());
        assertEquals(false, arrdq.isFull());

        // addFirst --> removeFirst
        for(int i = 1; i < 8; i++){
            arrdq.addFirst(i);
        }
        for(int j = 0; j < 8; j++) {
         //   assertEquals(7, (int) arrdq.get(0));
            assertEquals(7 - j, (int) arrdq.get(j));
        }

        assertEquals(8, (int)arrdq.size());

        assertEquals(false, arrdq.isEmpty());
        assertEquals(true, arrdq.isFull());


        for(int k = 0; k < 8;  k++){
            arrdq.removeFirst();
        }
        assertEquals(true, arrdq.isEmpty());
        assertEquals(false, arrdq.isFull());

    }

    @Test
    public void IntTest2(){
        // addFirst --> removeFirst
        ArrayDeque<Integer> arrdq = new ArrayDeque<>();
        assertEquals(true, arrdq.isEmpty());
        assertEquals(false, arrdq.isFull());

        arrdq.addFirst(0);
        assertEquals(false, arrdq.isEmpty());
        assertEquals(false, arrdq.isFull());

        // addFirst --> removeLast
        for(int i = 1; i < 16; i++){
            arrdq.addFirst(i);
        }
        for(int j = 0; j < 16; j++) {
            //   assertEquals(7, (int) arrdq.get(0));
            assertEquals(15 - j, (int) arrdq.get(j));
        }

        assertEquals(16, (int)arrdq.size());

        assertEquals(false, arrdq.isEmpty());
        assertEquals(true, arrdq.isFull());


        for(int k = 0; k < 16;  k++){
            arrdq.removeLast();
        }
        assertEquals(true, arrdq.isEmpty());
        assertEquals(false, arrdq.isFull());

    }

    @Test
    public void IntTest3(){
        // addFirst --> removeFirst
        ArrayDeque<Integer> arrdq = new ArrayDeque<>();
        assertEquals(true, arrdq.isEmpty());
        assertEquals(false, arrdq.isFull());

        arrdq.addLast(0);
        assertEquals(false, arrdq.isEmpty());
        assertEquals(false, arrdq.isFull());

        // addLast --> removeFirst
        for(int i = 1; i < 32; i++){
            arrdq.addLast(i);
        }
        for(int j = 0; j < 32; j++) {
            //   assertEquals(7, (int) arrdq.get(0));
            assertEquals(j, (int) arrdq.get(j));
        }

        assertEquals(32, (int)arrdq.size());

        assertEquals(false, arrdq.isEmpty());
        assertEquals(true, arrdq.isFull());


        for(int k = 0; k < 32;  k++){
            arrdq.removeFirst();
        }
        assertEquals(true, arrdq.isEmpty());
        assertEquals(false, arrdq.isFull());

    }

    @Test
    public void IntTest4(){
        // addLast --> removeLast
        ArrayDeque<Integer> arrdq = new ArrayDeque<>();
        assertEquals(true, arrdq.isEmpty());
        assertEquals(false, arrdq.isFull());

        arrdq.addLast(0);
        assertEquals(false, arrdq.isEmpty());
        assertEquals(false, arrdq.isFull());


        for(int i = 1; i < 32; i++){
            arrdq.addLast(i);
        }
        for(int j = 0; j < 32; j++) {
            //   assertEquals(7, (int) arrdq.get(0));
            assertEquals(j, (int) arrdq.get(j));
        }

        assertEquals(32, (int)arrdq.size());

        assertEquals(false, arrdq.isEmpty());
        assertEquals(true, arrdq.isFull());


        for(int k = 0; k < 32;  k++){
            arrdq.removeLast();
        }
        assertEquals(true, arrdq.isEmpty());
        assertEquals(false, arrdq.isFull());

    }


    @Test
    public void TestResize1(){

        ArrayDeque<Integer> arrdq = new ArrayDeque<>();

        for(int i = 0; i < 8; i++){
            arrdq.addLast(i);
        }

        assertEquals(true, arrdq.isFull());
        arrdq.addLast(8);
        assertEquals(false, arrdq.isFull());
        for(int j = 0; j < arrdq.size(); j++){
            assertEquals(j, (int)arrdq.get(j));
        }
        arrdq.removeFirst();
        for(int j = 0; j < arrdq.size(); j++){
            assertEquals(j + 1, (int)arrdq.get(j));
        }
        arrdq.addFirst(0);
        for(int j = 0; j < arrdq.size(); j++){
            assertEquals(j, (int)arrdq.get(j));
        }
        arrdq.removeLast();
        for(int j = 0; j < arrdq.size(); j++){
            assertEquals(j, (int)arrdq.get(j));
        }
    }


    @Test
    public void TestResize2(){

        ArrayDeque<Integer> arrdq = new ArrayDeque<>();

        for(int i = 0; i <32; i++){
            arrdq.addLast(i);
        }

        for(int j = 0; j < 12; j++){
            arrdq.removeFirst();
        }

        for (int k = 0; k < 12; k++){
            arrdq.removeLast();
        }

        arrdq.removeLast();

        for(int i = 0; i < 7; i++){
            assertEquals(i + 12, (int)arrdq.get(i));
        }
        assertEquals(arrdq.size() * 4, arrdq.getCapacity());
    }


}
