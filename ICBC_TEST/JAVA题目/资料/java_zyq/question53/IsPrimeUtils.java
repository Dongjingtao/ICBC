package newemp.work.question53;

public class IsPrimeUtils {
  public static boolean isPrime(final long number) {
    if (number <= 1) return false;
    for (int i = 2; i <= Math.sqrt(number); i++)
      if (number % i == 0) return false;
    return true;
  }
}
