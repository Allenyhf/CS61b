import org.junit.Test;
import static org.junit.Assert.*;

public class TestArrayDequeGold {

    @Test
    public void testArrayDeque() {
        StudentArrayDeque<Integer> studentADeque = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solutionADeque = new ArrayDequeSolution<>();

        for (int i = 0; i < 200; i++) {
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
//                int studentSize = studentADeque.size();
//                int solutionSize = solutionADeque.size();
//                assertEquals("Your solution isn't correct\n" +
//                                "The size should be: " + solutionSize +
//                                " but it is: " + studentSize,
//                                studentSize, solutionSize);

                if (studentADeque.size() != 0) {
                   Integer tmpStudent =  studentADeque.removeFirst();
                   Integer tmpSolution = solutionADeque.removeFirst();
                   assertEquals("removeFirst(), studen was " + tmpStudent
                                    + " correct was " + tmpSolution,
                            tmpSolution, tmpStudent);
                }
            } else {
//                int studentSize = studentADeque.size();
//                int solutionSize = solutionADeque.size();
//                assertEquals("Your solution isn't correct\n" +
//                                "The size should be: " + solutionSize +
//                                " but it is: " + studentSize,
//                        studentSize, solutionSize);

                if (studentADeque.size() != 0) {
                    Integer tmpStudent =  studentADeque.removeLast();
                    Integer tmpSolution = solutionADeque.removeLast();
                    assertEquals("removeLast(), studen was " + tmpStudent
                                    + " correct was " + tmpSolution,
                            tmpSolution, tmpStudent);
                }

            }
        }
    }


}
