import org.junit.Test;
import static org.junit.Assert.*;

public class TestArrayDequeGold {

    @Test
    public void testArrayDeque() {
        StudentArrayDeque<Integer> studentADeque = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solutionADeque = new ArrayDequeSolution<>();

        for (int i = 0; i < 500; i++) {
            double randomNumberzero2one = StdRandom.uniform();
            if (randomNumberzero2one < 0.25) {
                studentADeque.addFirst(i);
                solutionADeque.addFirst(i);
            } else if (randomNumberzero2one < 0.5) {
                studentADeque.addLast(i);
                solutionADeque.addLast(i);
            } else if (randomNumberzero2one < 0.75) {
//                if (studentADeque.size() != solutionADeque.size()) {
//                    System.out.println("Your solution is not correct: ");
//                    System.out.println("the size should be: " + solutionADeque.size());
//                    System.out.println("but it is: " + studentADeque.size());
//                    break;
//                } else
                int studentSize = studentADeque.size();
                int solutionSize = solutionADeque.size();
                assertEquals("size()\n",
                                studentSize, solutionSize);

                if (studentADeque.size() != 0) {
                    Integer tmpStudent;
                    if (studentADeque.size() > 0) {
                        tmpStudent = studentADeque.removeFirst();
                    } else {
                        tmpStudent = null;
                    }
                    Integer tmpSolution;
                    if (solutionADeque.size() > 0) {
                        tmpSolution = solutionADeque.removeFirst();
                    } else {
                        tmpSolution = null;
                    }
                        assertEquals("removeFirst()\n",
                            tmpSolution, tmpStudent);
                }
            } else {
                int studentSize = studentADeque.size();
                int solutionSize = solutionADeque.size();
                assertEquals("size()\n",
                        studentSize, solutionSize);

                if (studentADeque.size() != 0) {

                    Integer tmpStudent;
                    if (studentADeque.size() > 0) {
                        tmpStudent = studentADeque.removeLast();
                    } else {
                        tmpStudent = null;
                    }
                    Integer tmpSolution;
                    if (solutionADeque.size() > 0) {
                        tmpSolution = solutionADeque.removeLast();
                    } else {
                        tmpSolution = null;
                    }
                    assertEquals("removeLast()\n",
                            tmpSolution, tmpStudent);
                }

            }
        }
    }


}
