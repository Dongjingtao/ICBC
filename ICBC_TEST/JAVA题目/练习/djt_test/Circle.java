public class Circle implements Shape{
	
	public double getArea(){
		
		int r;
		double Area = 3.14 * r * r;
		return Area;
	}
	
	public static double main(String[] args){
		double a;
		Circle circle = new Circle();
		a = circle.getArea();
	} 
}