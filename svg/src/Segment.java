import static java.lang.Math.pow;

public class Segment {
    public Point a, b;

    public double length(){
        return Math.sqrt(pow(a.x-b.x, 2) + pow(a.y-b.y, 2));
    }

    public static Segment maxSegment(Segment[] arr){
        if(arr.length == 0)
            return null;

        Segment max = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i].length() > max.length())
                max = arr[i];
        }
        return max;
    }
}
