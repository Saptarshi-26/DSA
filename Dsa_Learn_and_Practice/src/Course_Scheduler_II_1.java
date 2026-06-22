import java.util.*;

public class Course_Scheduler_II_1 {
    public List<Integer> order(int required, HashMap<Integer, Set<Integer>> map, HashSet<Integer> added, HashSet<Integer> loop) {
        {

            List<Integer> order = new ArrayList<>();

            loop.add(required);

            if (map.containsKey(required)) {
                for (int a : map.get(required)) {

                    if (loop.contains(a)) return new ArrayList<>();

                    if (!added.contains(a)) {

                        List<Integer> temp = order(a, map, added, loop);

                        if (temp.isEmpty()) return new ArrayList<>();

                        order.addAll(temp);
                    }

                }
            } else {
                added.add(required);
                loop.remove(required);
                return new ArrayList<>(List.of(required));
            }

            order.add(required);
            added.add(required);
            loop.remove(required);

            return order;

        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        HashMap<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            if (map.containsKey(prerequisites[i][0])) {
                map.get(prerequisites[i][0]).add(prerequisites[i][1]);
            } else {
                map.put(prerequisites[i][0], new HashSet<>(Set.of(prerequisites[i][1])));
            }
        }

        HashSet<Integer> added = new HashSet<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (map.containsKey(i)) {
                if (!added.contains(i)) {
                    List<Integer> temp = order(i, map, added, new HashSet<>());
                    if (temp.isEmpty()) return new int[0];
                    ans.addAll(temp);
                }
            } else {
                if (!added.contains(i)) {
                    ans.add(i);
                    added.add(i);
                }
            }
        }

        int[] ans1 = new int[ans.isEmpty() ? 0 : numCourses];

        for (int i = 0; i < ans1.length; i++) {
            ans1[i] = ans.get(i);
        }

        return ans1;


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter total no of courses");
        int numCourses = sc.nextInt();
        System.out.println("enter the no of prerequisites ");
        int[][] prerequisites = new int[sc.nextInt()][2];
        System.out.println("enter the prerequisites ");
        for (int i = 0; i < prerequisites.length; i++) {
            for (int j = 0; j < prerequisites[i].length; j++) {
                prerequisites[i][j] = sc.nextInt();
            }
        }
        Course_Scheduler_II_1 courseSchedulerIi = new Course_Scheduler_II_1();
        int[] ans = courseSchedulerIi.findOrder(numCourses, prerequisites);
        Arrays.stream(ans).forEach(x -> System.out.print(x + " "));
    }
}
