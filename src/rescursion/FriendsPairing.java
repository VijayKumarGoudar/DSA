package rescursion;

/* You are given N friends.
Each friend can either:
 -> Stay single
 -> Pair up with one other friend
Find the number of ways friends can remain single or pair up.
*/

/* let's assume n  friends are there, then we have two options for the first friend:
1. The first friend can stay single,
      then the remaining n-1 friends can be arranged in f(n-1)
2. The first friend can pair up with any of the remaining n-1 friends,
      then the remaining n-2 friends can be arranged in f(n-2)

f(n) = f(n-1) + (n-1)*f(n-2)

Base case : f(0) = 1 (no friends, one way to arrange)
            f(1) = 1 (one friend, one way to arrange)
*/
public class FriendsPairing {

    public static int countFriendsPairing(int n) {
        if(n <= 0) {
            return 1;
        }

        return countFriendsPairing(n-1) + (n-1)*countFriendsPairing(n-2);
    }

    static void main() {
        int n = 3;
        int count = countFriendsPairing(n);
        System.out.println("Number of ways " + n + " friends can be paired: " + count);
    }
}
