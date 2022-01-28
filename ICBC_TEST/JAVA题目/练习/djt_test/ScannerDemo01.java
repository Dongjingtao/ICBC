//导包
import java.util.Scanner;

public class ScannerDemo01 {
	public static void main(String[] args){
		//创建对象
		Scanner sc = new Scanner(System.in);
		//接收数据
		System.out.println("请输入第一个值");
		int x = sc.nextInt();
		System.out.println("请输入第二个值");
		int y = sc.nextInt();
		System.out.println("请输入第三个值");
		int z = sc.nextInt();
		//输出数据
		int tempMax = x > y ? x : y;
		int resMax = tempMax > z ? tempMax : z;
		System.out.println("最大的值是" + resMax);
	}
}