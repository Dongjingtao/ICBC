
import java.util.Scanner;
 
/**
 * 用户输入一个整数，程序输出该数的二进制
 * 
 * @version 1.0 2014-05-05
 * @author yifan
 */
public class OutBinary {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入一个整数:");
		int number = scan.nextInt();
		
		int tmp = 1<<31; //用于计算的临时变量
		
		System.out.println();
		for(int i=0; i<Integer.SIZE-1; i++) {
			//System.out.print(number &(tmp>>>=1));
			System.out.print( (number &(tmp>>>=1))>0? 1:0);
		}
		System.out.println();
		if(scan != null) {
			scan.close();
		}
	}
 
}