package ooP.School;

public class School{
  private School(){
    //code
  }
    private  static School instance;
  public static School getInstance(){
    if(instance==null){
      instance = new School();
    }
    return instance;
  }

}
