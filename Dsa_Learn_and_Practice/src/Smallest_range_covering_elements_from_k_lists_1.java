import java.util.*;

public class Smallest_range_covering_elements_from_k_lists_1 {

    public boolean check_valid_upper_range(List<List<Integer>> nums, int val,
                                           int lower_range,
                                           HashMap<Integer, HashMap<Integer,Integer>> map) {


        for (int i=0;i<nums.size();i++) {
           List<Integer> x = nums.get(i);

            int index;

            if(map.containsKey(i)){
                if(map.get(i).containsKey(val)) {
                    index = map.get(i).get(val);
                }
                else {
                    index=Collections.binarySearch(x,val);
                }
            }
            else {
                index=Collections.binarySearch(x,val);
            }


             if(map.containsKey(i)){
                 if(!map.get(i).containsKey(val)) {
                     map.get(i).put(val, index);
                 }
             }
             else {
                 map.put(i,new HashMap<>(Map.of(val,index)));
             }

            if(index==-1)index=0;
            else if(index<0){
                index = Math.abs(index) - 1;
                if(index>=x.size())index--;
            }




            if (x.get(index) > val) {

                if (index > 0) {

                    if (x.get(index - 1) > val || (x.get(index - 1) < val && x.get(index - 1) < lower_range)) {


                        return false;
                    }

                }
                else return false;
            }

            else if (x.get(index) < val && x.get(index) < lower_range) {

                return false;
            }
        }



        return true;
    }



    public int upper_range(int i, int j, List<List<Integer>> nums, int[] arr,
                           int lowe_range,
                           HashMap<Integer,HashMap<Integer,Integer>>map) {

        int ans = Integer.MAX_VALUE;

        while (i <= j) {

            int mid = (i + j) / 2;

            if (check_valid_upper_range(nums, arr[mid], lowe_range,map)) {

                ans = Math.min(ans, arr[mid]);

                j = mid - 1;
            }

            else i = mid + 1;

        }
        return ans;

    }

    public boolean check_valid_lower_range(List<List<Integer>> nums, int val) {


        for (List<Integer> x : nums) {

            int index = Collections.binarySearch(x, val);

            if(index==-1)index=0;
            else if(index<0){
                index = Math.abs(index) - 1;
                if(index>=x.size())index--;
            }

            if (x.get(index) < val) {

                if (index == x.size() - 1 || x.get(index + 1) < val) {
                    return false;
                }

            }
        }


        return true;
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        int[] arr = Arrays.stream(nums.stream().flatMap(Collection::stream).mapToInt(Integer::intValue).toArray()).sorted().distinct().toArray();

        HashMap<Integer, HashMap<Integer,Integer>> map = new HashMap<>();

        int[] ans = new int[2];
        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if (check_valid_lower_range(nums, arr[i])) {

                int upper_range_val = upper_range(i, arr.length - 1, nums, arr, arr[i],map);

                if (upper_range_val != Integer.MAX_VALUE) {

                    if (diff > upper_range_val - arr[i]) {

                        ans[0] = arr[i];
                        ans[1] = upper_range_val;
                        diff=ans[1]-ans[0];

                    }
                }

            }
        }

        return ans;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the lists");
        List<List<Integer>> nums = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if(line.isEmpty())break;
            String[] arr = line.trim().split("\\s+");
            List<Integer> list = new ArrayList<>();
            for (String x : arr) {
                list.add(Integer.parseInt(x));
            }
            nums.add(list);
        }

        Smallest_range_covering_elements_from_k_lists_1 smallestRangeCoveringElementsFromKLists = new Smallest_range_covering_elements_from_k_lists_1();
        System.out.println(Arrays.stream(smallestRangeCoveringElementsFromKLists.smallestRange(nums)).boxed().toList());

    }
}
