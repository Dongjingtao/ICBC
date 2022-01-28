public class WhileDemo {
	public static void main(String[] args){
	double paper = 0.1;
	int zf = 8844430;
	int count = 0;
		while(paper <= zf){
			paper = paper * 2;
			count++;
		}
		System.out.println("需要折叠的次数：" + count);
	}
}