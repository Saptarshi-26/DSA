import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Video_Stitching {
    public int videoStitching(int[][] clips, int time) {

        TreeSet<Integer> clipsSet = new TreeSet<>(Comparator.reverseOrder());
        HashMap<Integer, Integer> clipsMap = new HashMap<>();
        int startClip = 0;

        for (int[] clip : clips) {
            clipsSet.add(clip[1]);
            clipsMap.put(clip[1], clipsMap.
                    containsKey(clip[1]) ? Math.min(clipsMap.get(clip[1]), clip[0]) : clip[0]);
            startClip = clip[0] == 0 ? Math.max(startClip, clip[1]) : startClip;
        }

        int count = 1;
        while (startClip < time) {
            if (startClip >= clipsSet.first()) return -1;
            count++;
            int anyStartTimePossibleFlag = 0;
            for (int endTime : clipsSet) {
                if (endTime > startClip) {
                    int startTime = clipsMap.get(endTime);
                    if (startTime <= startClip) {
                        startClip = endTime;
                        anyStartTimePossibleFlag = 1;
                        break;
                    }
                }
            }
            if (anyStartTimePossibleFlag == 0) return -1;
        }
        return count;


    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no of clips ");
        int[][] clips = new int[sc.nextInt()][2];
        System.out.println("enter the clips");
        IntStream.range(0, clips.length).
                forEach(i -> {
                    clips[i][0] = sc.nextInt();
                    clips[i][1] = sc.nextInt();
                });
        System.out.println("enter the time ");
        int time = sc.nextInt();
        System.out.println(new Video_Stitching().videoStitching(clips, time));
    }
}
