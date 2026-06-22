import java.util.*;

public class Course_Scheduler_II {
    public List<Integer> order(Set<Integer> required, HashMap<Integer, Set<Integer>> map, HashSet<Integer> added, HashSet<Integer> loop) {
        {

            Set<Integer> newRequired = new HashSet<>();
            loop.addAll(required);
            for (int x : required) {

                if(map.containsKey(x)) {
                    for (int a : map.get(x)) {
                        if (loop.contains(a)) return new ArrayList<>();
                        if (!added.contains(a)) {
                            newRequired.add(a);
                        }
                    }
                }
            }
            if(newRequired.isEmpty()){
                added.addAll(required);
                loop.removeAll(required);
                return new ArrayList<>(required);

            }
            loop.addAll(required);
            List<Integer> ans = order(newRequired, map, added, loop);
            if (ans.isEmpty()) return ans;
            ans.addAll(required);
            added.addAll(required);
            loop.removeAll(required);
            return ans;

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

        for( int i=0;i<numCourses;i++){
            if(map.containsKey(i)) {
                if (!added.contains(i)) {
                    List<Integer> temp = order(new HashSet<>(Set.of(i)), map, added, new HashSet<>());
                    if (temp.isEmpty()) return new int[0];
                    ans.addAll(temp);
                }
            }
            else {
                ans.add(i);
                added.add(i);
            }
        }

        int[] ans1 = new int[ans.isEmpty()?0:numCourses];

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
        Course_Scheduler_II courseSchedulerIi = new Course_Scheduler_II();
        int[] ans = courseSchedulerIi.findOrder(numCourses, prerequisites);
        Arrays.stream(ans).forEach(x-> System.out.print(x+" "));
    }
}
