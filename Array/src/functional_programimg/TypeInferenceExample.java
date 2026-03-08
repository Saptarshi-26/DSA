package functional_programimg;

public class TypeInferenceExample {
    public static void main(String[] args) {
//      stringLamda mylamda = s-> s.length();
//        System.out.println( mylamda.getlength("hello lambda "));
        printlamda(s->s.length());

    }
    public static void printlamda(stringLamda l){
        System.out.println(l.getlength("hello lambda "));
    }
}
interface stringLamda{
    int getlength(String s );
}