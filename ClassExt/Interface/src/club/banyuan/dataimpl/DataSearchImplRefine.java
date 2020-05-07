package club.banyuan.dataimpl;

import club.banyuan.DataSearch;
import club.banyuan.animal.Elephant;
import club.banyuan.machine.Fridgeable;

public class DataSearchImplRefine implements DataSearch, Fridgeable {

  @Override
  public Elephant[] searchElephant(int heightInCM) {
    return new Elephant[0];
  }
}
