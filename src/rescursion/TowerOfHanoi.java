package rescursion;

/* You have N disks placed on Rod A.
You must move all disks to Rod C using Rod B as auxiliary.

Only one disk can be moved at a time
A larger disk cannot be placed on a smaller disk
Only the top disk of any rod can be moved

 */

/*

  A            B           C
--------   ---------   ---------

Moving N disks from A to C using B as helper: F(N, A, C, B)
1. Move N-1 disks from A to B using C as helper: F(N-1, A, B, C)
2. Move the Nth disk from A to C
3. Move N-1 disks from B to C using A as helper: F(N-1, B, C, A)

f(N, A, C, B) = F(N-1, A, B, C) + 1 + F(N-1, B, C, A)
 */
public class TowerOfHanoi {

    public static int solveTowerOfHanoi(int n, char source, char destination, char helper) {

        if(n == 0) {
            return 0;
        }

        int res = 0;

        res+= solveTowerOfHanoi(n-1, source, helper, destination) + 1;
        System.out.println("Move disk " + n + " from " + source + " -> " + destination);
        res += solveTowerOfHanoi(n-1, helper, destination, source);

        return res;
    }

    static void main() {
        int n = 3; // number of disks
        char source = 'A';
        char destination = 'C';
        char helper = 'B';

        System.out.println("Steps to solve Tower of Hanoi with " + n + " disks:");
        int res = solveTowerOfHanoi(n, source, destination, helper);
        System.out.println("Total moves required: " + res);
    }
}
