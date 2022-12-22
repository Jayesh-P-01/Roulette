import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Roulette{
    private static List<Integer> redSquares = new ArrayList<Integer>(Arrays.asList(1,36,3,34,5,32,7,30,9,14,23,16,21,18,19,12,25,27));
    private static List<Integer> blackSquares = new ArrayList<Integer>(Arrays.asList(2,35,4,33,6,31,8,29,10,13,21,15,22,17,20,11,26,28));
    public static void main(String[] args) {
        int bank = 0;
        int ballance = 128;
        int betAmount = 1;
        int betPool = 0;
        int spinResult = 0;
        boolean won = false;
        while (ballance > betAmount){
            betPool = betPool + betAmount;
            ballance = ballance - betAmount;
            spinResult = ((int)(Math.random()*37));
            won = inList(spinResult);
            if (won == false){
                betAmount = betAmount*2;
            } else{
                ballance = ballance + (betPool*2);
                System.out.println(ballance);
                betAmount = 1;
            }
            betPool = 0;
            if (ballance == 256){
                ballance -= 128;
                bank += 128;
            }
        }
        System.out.println("ballance " + ballance);
        System.out.println("bank"+bank);
    }

    public static boolean inList(int spinResult){
        for (int i = 0; i< redSquares.size();i++){
            if (redSquares.get(i) == spinResult){
                return true;
            }
        }
        return false;
    }
}