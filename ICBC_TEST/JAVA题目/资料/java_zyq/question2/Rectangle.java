package newemp.work.question2;

public class Rectangle {
  int length;
  int width;

  public Rectangle(int x, int y){
    length = x;
    width = y;
  }

  public int getArea(){
    return length*width;
  }

  public int getPerimeter(){
    return 2*(length+width);
  }

  public void draw(){
    for(int j=0;j<width;j++){
      for(int i=0;i<length;i++){
        if(j==0 || j == width-1) {
          System.out.print("*");
          if(i==length-1) System.out.print('\n');
        }else if(i==0){
          System.out.print("*");
        }else if(i==length-1){
          System.out.print("*"+'\n');
        }else{
          System.out.print(' ');
        }
      }
    }
  }
}
