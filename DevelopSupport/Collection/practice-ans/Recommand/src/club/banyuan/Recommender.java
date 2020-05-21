package club.banyuan;

import java.util.List;

public interface Recommender {

  void addLikes(String person, String project);

  boolean likesBoth(String person, String project1, String project2);

  List<String> recommendByPerson(String person);

  List<String> recommendByProject(String project);
}
