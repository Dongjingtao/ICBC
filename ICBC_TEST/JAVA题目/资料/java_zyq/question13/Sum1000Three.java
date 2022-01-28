package newemp.work.question13;

import java.math.BigDecimal;

public class Sum1000Three {
  public static void main(String[] args) {
    BigDecimal sum = new BigDecimal("0");

    for (BigDecimal i = new BigDecimal("1.1"); i.compareTo(new BigDecimal("1000")) < 1; i = i.add(new BigDecimal("0.1"))) {
      sum = sum.add(i);
    }
    System.out.println(sum);
  }
}
