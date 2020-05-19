package club.banyuan;

public class PairUtil {

  public static <T> Pair<T> swap(Pair<T> a) {
    return new Pair<>(a.getSecond(), a.getFirst());
  }

  public static  <T extends Measurable> Pair<T> minmax(T[] array){
    T min = array[0];
    T max = array[0];
    for(T minElem : array){
      if(minElem.getMeasure() < min.getMeasure()){
        min = minElem;
      }
    }
    for (T maxElem : array){
      if(maxElem.getMeasure() > max.getMeasure()){
        max = maxElem;
      }
    }
    return new Pair<>(min,max);
  }

  public static  <T extends Comparable<T>> Pair<T> minmax(T[] array){
    T min = array[0];
    T max = array[0];
    for(T minElem  : array){
      if(minElem.compareTo(min) < 0){
        min = minElem;
      }
    }
    for (T maxElem : array){
      if(maxElem.compareTo(max) > 0){
        max = maxElem;
      }
    }
    return new Pair<>(min,max);
  }

}
