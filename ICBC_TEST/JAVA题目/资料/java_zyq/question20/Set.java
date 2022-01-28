package newemp.work.question20;

public class Set {
  Object s[]=new Object[100];
  int index = 0;

  public boolean add(Object a){
    if (this.isInSet(a)==true){
      return false;
    }else {
      s[index]=a;
      index++;
      return true;
    }
  }

  //获取set元素数量
  public int len(){
    int i=0;
    while(s[i]!=null){ i++; }
    return i;
  }
  //判定元素是否在set内
  public boolean isInSet(Object a){
    boolean flag = false;
    for(int i=0;i<this.len();i++){
      if( a ==s[i]){
        flag = true;
      }
    }
    return flag;
  }
  //set 并交集
  public Set unionSet(Set b){
    Set c = new Set();
    for (int i=0;i<b.len();i++){
      c.add(b.s[i]);
    }
    for (int i=0;i<this.len();i++){
      if(!c.isInSet(this.s[i])){
        c.add(this.s[i]);
      }
    }
    return c;
  }
  //set 取交集
  public Set intersectionSet(Set b){
    Set c = new Set();
    for (int i=0;i<this.len();i++){
      if(b.isInSet(this.s[i])){
        c.add(this.s[i]);
      }
    }
    return c;
  }

  public void show(){
    for (int i=0;i<this.len();i++){
      System.out.println(s[i]);
    }
    if(this.len()==0){
      System.out.println("空!");
    }
  }
}
