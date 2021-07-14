package creatures;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.awt.Color;

import huglife.Direction;
import huglife.Action;
import huglife.Occupant;
import huglife.Impassible;
import huglife.Empty;

import javax.swing.*;

/** Tests the plip class   
 *  @authr FIXME
 */

public class TestPlip {

    /* Replace with the magic word given in lab.
     * If you are submitting early, just put in "early" */
    public static final String MAGIC_WORD = "";

    @Test
    public void testBasics() {
        Plip p = new Plip(2);
        assertEquals(2, p.energy(), 0.01);
        assertEquals(new Color(99, 255, 76), p.color());
        p.move();
        assertEquals(1.85, p.energy(), 0.01);
        p.move();
        assertEquals(1.70, p.energy(), 0.01);
        p.stay();
        assertEquals(1.90, p.energy(), 0.01);
        p.stay();
        assertEquals(2.00, p.energy(), 0.01);
    }

    @Test
    public void testReplicate() {
        Plip parent = new Plip(2);
        Plip child = parent.replicate();
        assertEquals(1, parent.energy(), 0.01);
        assertEquals(1, child.energy(), 0.01);
        assertNotEquals(parent, child);

        parent = new Plip(1);
        child = parent.replicate();
        assertEquals(0.5,  parent.energy(), 0.01);
        assertEquals(0.5, child.energy(), 0.01);
        assertNotEquals(parent, child);
    }

    @Test
    public void testChoose() {
        Plip p = new Plip(1.2);
        HashMap<Direction, Occupant> surrounded1 = new HashMap<Direction, Occupant>();
        surrounded1.put(Direction.TOP, new Impassible());
        surrounded1.put(Direction.BOTTOM, new Impassible());
        surrounded1.put(Direction.LEFT, new Impassible());
        surrounded1.put(Direction.RIGHT, new Impassible());
        //You can create new empties with new Empty();
        //Despite what the spec says, you cannot test for Cloruses nearby yet.
        //Sorry!
        Action actual = p.chooseAction(surrounded1);
        Action expected = new Action(Action.ActionType.STAY);

        assertEquals(expected, actual);

        HashMap<Direction, Occupant> surrounded2 = new HashMap<Direction, Occupant>();
        surrounded2.put(Direction.TOP, new Impassible());
        surrounded2.put(Direction.BOTTOM, new Empty());
        surrounded2.put(Direction.LEFT, new Impassible());
        surrounded2.put(Direction.RIGHT, new Impassible());
        actual = p.chooseAction(surrounded2);
        expected = new Action(Action.ActionType.REPLICATE, Direction.BOTTOM);
        assertEquals(expected, actual);

        Plip p2 = new Plip(0.8);
        HashMap<Direction, Occupant> surrounded3 = new HashMap<Direction, Occupant>();
        surrounded3.put(Direction.TOP, new Empty());
        surrounded3.put(Direction.BOTTOM, new Empty());
        surrounded3.put(Direction.LEFT, new Impassible());
        surrounded3.put(Direction.RIGHT, new Impassible());
        actual = p2.chooseAction(surrounded3);
        expected = new Action(Action.ActionType.STAY);
        assertEquals(expected, actual);
    }

    public static void main(String[] args) {
        System.exit(jh61b.junit.textui.runClasses(TestPlip.class));
    }
} 
