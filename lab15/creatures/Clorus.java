package creatures;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import huglife.Creature;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;
import huglife.HugLifeUtils;

public class Clorus extends Creature {
    private int r;
    private int g;
    private int b;

    public Clorus(double e) {
        super("clorus");
        energy = e;
        r = 0;
        g = 0;
        b = 0;
    }

    /**
     * Clorus should lose 0.03 energy when move.
     */
    public void move() {
        energy -= 0.03;
        if (energy < 0) {
            energy = 0;
        }
    }

    /***
     * Clorus should lose 0.01 energy when stay
     */
    public void stay() {
        energy -= 0.01;
        if (energy < 0) {
            energy = 0;
        }
    }

    /**
     * Clorus should return r: 34, g: 0, b: 231 when color is called
     */
    public Color color() {
        r = 34;
        g = 0;
        b = 231;
        return new Color(r, g, b);
    }

    /**
     * Clorus gain the attacked Creature's energy when it attack somebody
     * The death of the attacked Creature is dealt by the simulator
     */
    public void attack(Creature c) {
        this.energy += c.energy();
    }

    /**
     * Clorus create and return another Clorus with half of its own energy
     * and halves its own energy
     */
    public Clorus replicate() {
        double newEnergy = this.energy();
        newEnergy /= 2;
        this.energy = newEnergy;
        Clorus child = new Clorus(newEnergy);
        return child;
    }


    /***
     * Clorus takes exactly the following actions
     *  1. stay when no empty squares
     *  2. if any Plips are seen, it'll attack one of them randomly
     *  3. replicate to a random empty square when its energy is greater than or equals to one
     *  4. move to a random empty square
     */
    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        java.util.List<Direction> empties = getNeighborsOfType(neighbors, "empty");
        List<Direction> plips = getNeighborsOfType(neighbors, "plips");
        Action act;
        if (empties.size() == 0) {
            act = new Action(Action.ActionType.STAY);
        } else if (plips.size() > 0) {
            Direction moveDir = HugLifeUtils.randomEntry(plips);
            act = new Action(Action.ActionType.ATTACK, moveDir);
        } else if (this.energy() >= 1.0) {
            Direction moveDir = HugLifeUtils.randomEntry(empties);
            act = new Action(Action.ActionType.REPLICATE, moveDir);
        } else {
            Direction moveDir = HugLifeUtils.randomEntry(empties);
            act = new Action(Action.ActionType.REPLICATE, moveDir);
        }
        return act;
    }

}
