import org.junit.Test;
import static org.junit.Assert.*;

public class TestArrayDequeGold {

    @Test
    public void testArrayDeque() {
        StudentArrayDeque<Integer> studentADeque = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solutionADeque = new ArrayDequeSolution<>();

        for (int i = 0; i < 100; i++) {
            double random = StdRandom.uniform();
            if (random < 0.5) {
                int num = (int) random * i * 100;
                studentADeque.addFirst(num);
                solutionADeque.addFirst(num);
            } else {
                int num = (int) (1 - random) * i * 100;
                studentADeque.addLast(num);
                solutionADeque.addLast(num);
            }
        }

        for(int i = 0; i < 100; i++) {
            double random = StdRandom.uniform();
            if (random < 0.5) {
                Integer student = studentADeque.removeFirst();
                Integer solution = solutionADeque.removeFirst();
                assertEquals("removeFirst()\n", student, solution);
            } else {
                Integer student = studentADeque.removeLast();
                Integer solution = solutionADeque.removeLast();
                assertEquals("removeLast()\n", student, solution);
            }
        }

    }

}

