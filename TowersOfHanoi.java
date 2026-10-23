
public class TowersOfHanoi {

    public static void main(String[] args) {
        int disks = 4;
        towers(disks);
    }

    public static void towers(int disks) {
        if (disks <= 0) {
            System.out.println("The number of disks must be positive");
            return;
        }

        moveDisks(disks, "start", "aux", "end");
    }

    public static void moveDisks(int disks, String startPeg, String middlePeg, String endPeg) {
        if (disks == 1) {
            System.out.printf("One disk moved from %s to %s%n", startPeg, endPeg);
            return;
        }
        moveDisks(disks - 1, startPeg, endPeg, middlePeg);
        moveDisks(1, startPeg, "", endPeg);
        moveDisks(disks - 1, middlePeg, startPeg, endPeg);
    }
}
