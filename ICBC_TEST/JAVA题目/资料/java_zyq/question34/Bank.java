package newemp.work.question34;

import newemp.work.exp.BalanceNotEnough;

public class Bank {
  int balance=0;
  public void deposite(int money){
    balance+=money;
  }
  public void drawa(int money)throws BalanceNotEnough {
    if(balance<money){
      System.out.println("当前余额为"+balance);
      throw new BalanceNotEnough("余额不足,不能取款");
    } else {
      balance -= money;
    }
  }

  public int getBalance() {
    return balance;
  }
}
