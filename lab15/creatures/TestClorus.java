package creatures;

import org.junit.Test;

import java.awt.Color;
import java.util.HashMap;

import static org.junit.Assert.*;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;
import huglife.Impassible;
import huglife.Empty;

import javax.swing.*;

public class TestClorus {

    @Test
    public void testBasics() {
        Clorus c = new Clorus(2.0);
        c.move();
        assertEquals(1.97, c.energy(), 0.01);
        assertEquals(new Color(34, 0, 231), c.color());
        c.stay();
        assertEquals(1.96, c.energy(), 0.01);
        c.move();
        assertEquals(1.93, c.energy(), 0.01);
        c.stay();
        assertEquals(1.92, c.energy(), 0.01);
    }

    @Test
    public void testReplicate() {
        Clorus parent = new Clorus(2.0);
        Clorus child = parent.replicate();

        assertEquals(1.0, parent.energy(), 0.01);
        assertEquals(1.0, child.energy(), 0.01);
        assertNotEquals(child, parent);
    }

    @Test
    public void testChoose() {
        Clorus c = new Clorus(1.2);
        HashMap<Direction, Occupant> surrounded1 = new HashMap<Direction, Occupant>();
        surrounded1.put(Direction.TOP, new Impassible());
        surrounded1.put(Direction.BOTTOM, new Impassible());
        surrounded1.put(Direction.LEFT, new Impassible());
        surrounded1.put(Direction.RIGHT, new Impassible());
        //You can create new empties with new Empty();
        //Despite what the spec says, you cannot test for Cloruses nearby yet.
        //Sorry!
        Action actual = c.chooseAction(surrounded1);
        Action expected = new Action(Action.ActionType.STAY);

        assertEquals(expected, actual);

        HashMap<Direction, Occupant> surrounded2 = new HashMap<Direction, Occupant>();
        surrounded2.put(Direction.TOP, new Impassible());
        surrounded2.put(Direction.BOTTOM, new Empty());
        surrounded2.put(Direction.LEFT, new Impassible());
        surrounded2.put(Direction.RIGHT, new Impassible());
        actual = c.chooseAction(surrounded2);
        expected = new Action(Action.ActionType.REPLICATE, Direction.BOTTOM);
        assertEquals(expected, actual);
    }

}
