package newemp.work.question11;

import newemp.work.exp.MyException;

public interface DataStructure {
  public Boolean isFull();
  public Boolean isEmpty();
  public void addElement(Object obj) throws MyException;
  public Object removeElement()throws MyException;
}
