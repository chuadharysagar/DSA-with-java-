public class happyNUmber {
    private int SquareOfnum(int n) {
        int sq = 0;
        int rem = 0;
        while (n > 0) {
            rem = n % 10;
            n = n / 10;
            sq += rem * rem;
        }
        return sq;
    }

    private boolean Ishappy(int n) {
        int fast = n;
        int slow = n;
        do {
            slow = SquareOfnum(slow);
            fast = SquareOfnum(SquareOfnum(fast));
        } while (fast != slow);

        if (fast == 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
             happyNUmber hn= new happyNUmber();
            int num1=2;
            int num2=19;
            int num3=52;
            System.out.println(hn.Ishappy(num1));
            System.out.println(hn.Ishappy(num2));
            System.out.println(hn.Ishappy(num3));
    }

}
