// gaslighting gatekeeping girlbosses -- Lauren Lee, Kevin Xiao, Kevin Li
// APCS
// L09 -- Some Folks Call It a Charades
// 2022-04-26
// time spent: 5 hrs

import java.lang.*;
public class apcs{

  //false -- junior
  //true -- senior
  private boolean _grade;
  private int _period;
  private String _teacher;

  public apcs(boolean grade, int period, String teacher){
    _grade = grade;
    _period = period;
    _teacher = teacher;
  }

  public boolean getGrade(){
    return _grade;
  }

  public int getPeriod(){
    return _period;
  }

  public String getTeacher(){
    return _teacher;
  }

  public void setGrade(boolean grade){
    _grade = grade;
  }

  public boolean switchPeriod(int period){
    int rand = (int)(Math.random()*2);
    boolean study = false;
    if (rand == 0){
      study = true;
    }
    if(takeTest(study)<65 || isLate()){
      _period = (int)(Math.random()*8 + 3);
      return true;
    } else {
      return false;
    }
  }

  public boolean switchTeacher(String teacher){
    int rand = (int)(Math.random()*2);
    boolean study = false;
    if (rand == 0){
      study = true;
    }
    if(takeTest(study)<65){
      _teacher=teacher;
      return true;
    } else{
      return false;
    }
  }

  public int takeTest(boolean study){
    if(study){
      return (int) (Math.random() * 30)+65;
    } else{
      return (int) (Math.random()*65);
    }
  }

  public boolean hasSenioritis(){
    return _grade;
  }

  public boolean isLate(){
    if (_period<3){
      return true;
    } else{
      return false;
    }
  }

}
