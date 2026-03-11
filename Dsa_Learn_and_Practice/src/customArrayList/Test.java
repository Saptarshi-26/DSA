package customArrayList;

public class Test {
    public static void main(String[] args) {
        MyArrayList< Integer> arr = new MyArrayList<>();
        for(int i=0;i<5;i++)
            arr.add(i);
        System.out.println();
        for(int i=0;i<arr.size();i++){
            System.out.print(arr.get(i)+" ");
        }

        arr.add(3);arr.add(4);
        System.out.println();
        for(int i=0;i<arr.size();i++){
            System.out.print(arr.get(i)+" ");
        }
        System.out.println();
        System.out.println(arr.size());

     arr.delete_byVal(3);
        System.out.println();
        for(int i=0;i<arr.size();i++){
            System.out.print(arr.get(i)+" ");
        }
        System.out.println();
        System.out.println(arr.size());
       arr.delete_byVal(4);
        System.out.println();
        for(int i=0;i<arr.size();i++){
            System.out.print(arr.get(i)+" ");
        }
        System.out.println();
        System.out.println(arr.size());
        System.out.println(arr.toString());

    }
}
