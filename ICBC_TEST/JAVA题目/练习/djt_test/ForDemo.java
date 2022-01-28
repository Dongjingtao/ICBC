public class ForDemo {
	public static void main(String[] gergs) {
		int count = 0;
		for(int i=100; i<1000; i++){
			int ge = i % 10;
			int shi = i / 10 % 10;
			int bai = i / 100;
			if(ge*ge*ge + shi*shi*shi + bai*bai*bai == i) {
				count ++;
			}
		}
		System.out.println("水仙花数共有：" + count + "个");
	}
}