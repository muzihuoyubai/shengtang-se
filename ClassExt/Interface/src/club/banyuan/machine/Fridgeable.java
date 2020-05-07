package club.banyuan.machine;

import club.banyuan.animal.Felidae;
import java.util.Collection;

public interface Fridgeable {

  int FROZEN_TIME_SEC = 3600;

  default void frozen() {
    System.out.println("frozen default");
  }

  static boolean isFrozen() {
    return true;
  }
}
