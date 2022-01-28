import java.io.IOException;
class TestIf{
	public static void main(String []args) throws IOException{
		System.out.println("是否");
		System.out.println("是(y)否(n)不一定(p)");
		char c = (char)System.in.read();
		if(c == 'y')
			System.out.println("Cool");
		else if(c == 'n')
			System.out.println("Bad");
		else if(c == 'p')
			System.out.println("Sorry");
		else
			System.out.println("Input Error");
	}
}