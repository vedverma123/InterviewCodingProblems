package gfg;

// Given an integer x, find it’s square root. If x is not a perfect square, then return floor(√x).
public class SquareRootInteger {

    public double sqrt(int num, int precision){
        if(num==0 || num == 1)
            return num;
        int start = 1, end = num;
        int ans = 0;

        while(start <= end){
            int mid = (start + end) / 2;
            int sqre = mid*mid;
            if(sqre == num)
                return mid;
            else if(sqre > num){
                end = mid - 1;
            }else{
                start = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        SquareRootInteger obj = new SquareRootInteger();
        System.out.println(obj.sqrt(37, 2));
    }
}
