// package club.banyuan;
//
// import java.util.Objects;
//
// public class Entry {
//
//   private Object key;
//   private Object value;
//
//   public Entry() {
//   }
//
//   public Entry(Object key, Object value) {
//     this.key = key;
//     this.value = value;
//   }
//
//   public Object getKey() {
//     return key;
//   }
//
//   public void setKey(Object key) {
//     this.key = key;
//   }
//
//   public Object getValue() {
//     return value;
//   }
//
//   public void setValue(Object value) {
//     this.value = value;
//   }
//
//   @Override
//   public boolean equals(Object o) {
//     if (this == o) {
//       return true;
//     }
//     if (o == null || getClass() != o.getClass()) {
//       return false;
//     }
//     Entry entry = (Entry) o;
//     return Objects.equals(key, entry.key) &&
//         Objects.equals(value, entry.value);
//   }
//
//   @Override
//   public int hashCode() {
//     return Objects.hash(key, value);
//   }
// }
