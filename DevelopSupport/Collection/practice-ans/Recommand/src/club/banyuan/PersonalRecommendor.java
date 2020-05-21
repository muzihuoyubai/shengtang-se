package club.banyuan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PersonalRecommendor implements Recommender {

  private Map<String, Set<String>> likes = new HashMap<>();

  @Override
  public void addLikes(String person, String project) {
    Set<String> personLikes;
    if (likes.containsKey(person)) {
      personLikes = likes.get(person);
    } else {
      personLikes = new HashSet<>();
      likes.put(person, personLikes);
    }
    personLikes.add(project);
  }

  @Override
  public boolean likesBoth(String person, String project1, String project2) {
    if (!likes.containsKey(person)) {
      throw new UnknownPersonException();
    }

    Set<String> projects = likes.get(person);
    // return projects.containsAll(Arrays.asList(project1, project2));
    return projects.containsAll(Set.of(project1, project2));
    // return projects.contains(project1) && projects.contains(project2)

  }

  @Override
  public List<String> recommendByPerson(String person) {
    return new ArrayList<>(likes.get(person));
  }

  @Override
  public List<String> recommendByProject(String project) {
    Set<String> rlt = new HashSet<>();
    for (Set<String> value : likes.values()) {
      if (value.contains(project)) {
        rlt.addAll(value);
      }
    }
    rlt.remove(project);
    return new ArrayList<>(rlt);
  }
}
