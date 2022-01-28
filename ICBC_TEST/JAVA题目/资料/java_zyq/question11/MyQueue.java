package newemp.work.question11;

import newemp.work.exp.MyException;

public class MyQueue implements DataStructure {
  int index=-1;
  Object [] o = new Object[10];
  public Boolean isFull(){
    return index==9;
  }
  public Boolean isEmpty(){
    return index==-1;
  }
  public void addElement(Object obj) throws MyException {
    if(isFull()){throw new MyException("队列已满");}
    o[index+1]=obj;
    index+=1;
  }
  public Object removeElement()throws MyException{
    if(isEmpty()){throw new MyException("队列为空");}
    Object temp = o[0];
    for (int j=0;j<index;j++){
      o[j]=o[j+1];
    }
    index-=1;
    return temp;
  }
}
