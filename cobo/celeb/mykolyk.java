// gaslighting gatekeeping girlbosses -- Lauren Lee, Kevin Xiao, Kevin Li
// APCS
// L09 -- Some Folks Call It a Charades
// 2022-04-26
// time spent: 5 hrs

import java.lang.*;
public class mykolyk extends apcs{

  private double _hrsSpent;
  private int _daysSinceGrassTouching;
  private boolean _holidayMaths;
  private String _SOTW;

  public mykolyk(boolean grade, int period, double hr, int days, boolean holiday, String song){
    super(grade, period, "Mykolyk");
    _hrsSpent = hr;
    _daysSinceGrassTouching = days;
    _holidayMaths = holiday;
    _SOTW = song;
  }

  @Override
  public int takeTest(boolean study){
    if (_holidayMaths == true && _hrsSpent <= 0.5 && _daysSinceGrassTouching == 0 && _SOTW.equals("Ride or Die") && study){
      return 100;
    } else if(_holidayMaths == true && _hrsSpent <= 0.5 && study){
      return (int) (Math.random()*34 + 65);
    } else {
      return (int) (Math.random()*65);
    }
  }



}
