import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
	public static void main(String[] args){
		Random r = new Random();
		int num = r.nextInt(100) + 1;
		while(true){
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入要猜的数字：");
			int guessNumber = sc.nextInt();
			if(guessNumber > num) {
				System.out.println("你猜的" + guessNumber + "大了");
			}else if(guessNumber < num) {
				System.out.println("你猜的" + guessNumber + "小了");
			}else {
				System.out.println("恭喜你猜中了");
				break;
			}
		}
	}
}