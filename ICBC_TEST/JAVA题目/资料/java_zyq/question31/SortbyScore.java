package newemp.work.question31;
import java.util.Comparator;

class SortbyScore implements Comparator {
  @Override
  public int compare(Object a, Object b) {
    Student s1 = (Student) a;
    Student s2 = (Student) b;
    if (s1.score > s2.score)
      return -1;
    if (s1.score < s2.score)
      return 1;
    if (s1.score == s2.score)
      return s2.name.compareTo(s1.name);
    return 0;
  }
}