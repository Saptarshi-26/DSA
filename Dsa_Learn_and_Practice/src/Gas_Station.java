import java.util.Scanner;

public class Gas_Station {
    public int check_complete(int[] gas, int[] cost, int i) {
        int gas_amount = gas[i] - cost[i];
        int j = (i + 1) % gas.length;
        while (j != i) {
            if (gas_amount <= 0) return j;
            gas_amount += gas[j];
            gas_amount -= cost[j];

            j = (j + 1) % gas.length;

        }
        if (gas_amount < 0) return -1;
        return j;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 1) {
            if (gas[0] >= cost[0]) return 0;
            return -1;
        }

        for (int i = 0; i < gas.length; i++) {
            if (gas[i] - cost[i] > 0) {
                int temp = check_complete(gas, cost, i);
                if (temp == i) return i;
                if (temp <= i) return -1;
                i = temp - 1;
            }
        }
        return -1;
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no of gas station ");
        int[] gas = new int[sc.nextInt()];
        System.out.println("enter the amount of gas for each station ");
        for (int i = 0; i < gas.length; i++) {
            gas[i] = sc.nextInt();
        }
        System.out.println("enter the cost of the station ");
        int[] cost = new int[gas.length];
        for (int i = 0; i < cost.length; i++) {
            cost[i] = sc.nextInt();
        }
        System.out.println(new Gas_Station().canCompleteCircuit(gas, cost));
    }
}
