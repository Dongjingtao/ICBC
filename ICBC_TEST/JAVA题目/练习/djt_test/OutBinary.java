
import java.util.Scanner;
 
/**
 * �û�����һ��������������������Ķ�����
 * 
 * @version 1.0 2014-05-05
 * @author yifan
 */
public class OutBinary {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("������һ������:");
		int number = scan.nextInt();
		
		int tmp = 1<<31; //���ڼ������ʱ����
		
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