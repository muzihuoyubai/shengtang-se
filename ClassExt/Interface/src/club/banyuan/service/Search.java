package club.banyuan.service;

import club.banyuan.DataSearch;
import club.banyuan.animal.Elephant;
import club.banyuan.dataimpl.DataSearchImpl;
import club.banyuan.dataimpl.DataSearchImplRefine;
import club.banyuan.machine.Fridge;

public class Search {

  private DataSearch dataSearch;

  public Search(DataSearch dataSearch) {
    this.dataSearch = dataSearch;
  }

  public Elephant elephantFilter(int height) {
    Fridge fridge = new Fridge(300);
    Elephant[] elephants = dataSearch.searchElephant(height);

    // TODO

    return elephants[0];
  }

  public static void main(String[] args) {
    DataSearch search = new DataSearchImplRefine();
    Search sea1 = new Search(search);

    sea1.elephantFilter(200);
  }
}
