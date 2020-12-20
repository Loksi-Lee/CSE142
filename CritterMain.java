// Lesi Li
// 07/27/2020
// CSE 142
// TA: Joe Lang
// CSE 142 Homework 8 (Critters)
// Authors: Stuart Reges and Marty Stepp
//
/*descriptions: In this program, We can see
the run of bear, lion, giant, husky, food, 
and flytrap moving. They would have different 
action when touching different things.
For example, if they touch other species, 
they will get infected. Other wise, they 
turn left, right or hop.
They will only get one species left in the end. 
And each of them represent different symbol.
*/

// CritterMain provides the main method for a simple simulation program.  Alter
// the number of each critter added to the simulation if you want to experiment
// with different scenarios.  You can also alter the width and height passed to
// the CritterFrame constructor.

public class CritterMain {
    public static void main(String[] args) {
        CritterFrame frame = new CritterFrame(60, 40);

        // uncomment each of these lines as you complete these classes
        frame.add(30, Bear.class);
        frame.add(30, Lion.class);
        frame.add(30, Giant.class);
        frame.add(30, Husky.class);

        frame.add(30, FlyTrap.class);
        frame.add(30, Food.class);

        frame.start();
    }
}
