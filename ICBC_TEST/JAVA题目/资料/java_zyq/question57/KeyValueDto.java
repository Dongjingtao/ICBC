package newemp.work.question57;

public class KeyValueDto implements Comparable<KeyValueDto>{
  private String key;
  private String value;

  public KeyValueDto(String key, String value) {
    this.key = key;
    this.value = value;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public int compareTo(KeyValueDto o) {
    return o.getKey().compareTo(this.key);
  }

  @Override
  public String toString() {
    return "{" +
        "key='" + key + '\'' +
        ", value='" + value + '\'' +
        '}';
  }
}
