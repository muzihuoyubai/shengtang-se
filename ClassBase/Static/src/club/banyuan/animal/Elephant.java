package club.banyuan.animal;

public class Elephant {

  private int heightInCM;

  private final int id;

  private static int lastId = 0;

  private static final int DEFAULT_HEIGHT_IN_CM = 350;

  public Elephant(){
    this(DEFAULT_HEIGHT_IN_CM);
  }

  public Elephant(int heightInCM){
    this.heightInCM = heightInCM;
    id = ++lastId;
    System.out.printf("创建一个大象，id是%d,高度%d厘米\n", id, heightInCM);
  }

  public void setHeightInCM(int heightInCM){
  	if(heightInCM <= 0){
  		System.out.println("传入的高度不合法!");
  		return;
  	}

  	this.heightInCM = heightInCM;
  }

  public int getHeightInCM(){
  	return heightInCM;
  }

  public int getId(){
    return id;
  }

  public static int getLastId(){
    return lastId;
  }
}


