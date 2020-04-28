package club.banyuan;

// TODO 自动将选中的学员名字加入到已选学员数组中
public class RandomStudents {

  public static final String[] studentNameArr = {
      "孙孝", "李海洋", "李星星", "杨星辰",
      "王进进", "邵寿文", "俞超", "张志",
      "田文镐", "汤典", "朱强", "朱银生",
      "卢炳杰", "田菁菁", "徐明时"
  };

  public static final String[] choosedNameArr = {"李海洋","田菁菁"};

  public static String[] generateUnchoosedNames() {
    String[] rlt = new String[studentNameArr.length - choosedNameArr.length];
    int index = 0;
    boolean isFind = false;
    for (int i = 0; i < studentNameArr.length; i++) {
      isFind = false;
      for (int j = 0; j < choosedNameArr.length; j++) {
        if (studentNameArr[i].equals(choosedNameArr[j])) {
          isFind = true;
          break;
        }
      }
      if (!isFind) {
        rlt[index++] = studentNameArr[i];
      }

    }
    return rlt;
  }

  public static void main(String[] args) {

    String[] unchosedStudentNames = generateUnchoosedNames();
    if (unchosedStudentNames.length == 0) {
      System.out.println("没有未被选择的学员，需要清空已选学员列表！");

    } else {
      int index = (int) (Math.random() * unchosedStudentNames.length);

      System.out.println("学生姓名:" + unchosedStudentNames[index]);
    }


  }


}