import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
	public static void main(String[] args){
		Random r = new Random();
		int num = r.nextInt(100) + 1;
		while(true){
			Scanner sc = new Scanner(System.in);
			System.out.println("������Ҫ�µ����֣�");
			int guessNumber = sc.nextInt();
			if(guessNumber > num) {
				System.out.println("��µ�" + guessNumber + "����");
			}else if(guessNumber < num) {
				System.out.println("��µ�" + guessNumber + "С��");
			}else {
				System.out.println("��ϲ�������");
				break;
			}
		}
	}
}