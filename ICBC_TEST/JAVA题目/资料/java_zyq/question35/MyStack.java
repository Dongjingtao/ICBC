package newemp.work.question35;

import newemp.work.exp.EmptyStackException;
import newemp.work.exp.FullStackException;

public class MyStack{
  int top=-1;
  int size;
  Object [] o;
  public MyStack(int size){
    this.size = size;
    o = new Object[size];
  }
  public Boolean isFull(){
    return size==top+1;
  }
  public Boolean isEmpty(){
    return top==-1;
  }

  public void push(Object a)throws FullStackException {
    if(isFull()){
      throw new FullStackException("堆栈满！");
    }else {
      top+=1;
      o[top] = a;
    }
  }

  public Object pop()throws EmptyStackException {
    if(isEmpty()){
      throw new EmptyStackException("堆栈空！");
    }else {
      top-=1;
      return o[top+1];
    }
  }
}
