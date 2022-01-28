import static java.lang.System.out;
class Test {
	public static void main(String[] args) {
		/*
		float x=7,y=15,v1,v2;
		v1 = x++;
		v2 = ++y;
		System.out.println("x=" + x);
		System.out.println("y=" + y);
		System.out.println("v1=" + v1);
		System.out.println("v2=" + v2);
		*/
		int a = -42;
		byte ba = (byte)a;
		int aa = a >>> 2;
		int bb = a >> 2;
		out.println("aa=" + aa);
		out.println("bb=" + bb);
	}
}

