// gaslighting gatekeeping girlbosses -- Lauren Lee, Kevin Xiao, Kevin Li
// APCS
// L09 -- Some Folks Call It a Charades
// 2022-04-26
// time spent: 5 hrs

import java.util.ArrayList;

public class Entrepreneur extends Celebrity{


  private ArrayList<String> clueList;
  /*
  private double _netWorth;
  private int _numCompanies;
  private int _numMinions;
  */

  public Entrepreneur(String answer, String clues){
    super(answer, clues);
/*
    _netWorth = netWorth;
    _numCompanies = numCompanies;
    _numMinions = numMinions;
    */

    processClues();
  }

  private void processClues(){
    String[] clues = super.getClue().split(",");
    clueList = new ArrayList<String>();
    for(String currentClue : clues){
      clueList.add(currentClue);
    }
  }

  @Override
  public String getClue(){
    if (clueList.size() == 0){
      processClues();
    }
    String currentClue = clueList.remove(0);
    return currentClue;
  }

  @Override
  public String toString()
  {
    String dsc = "This is the Entrepreneur: " + getAnswer() + "\nThe clues are:\n";

    for (String word : super.getClue().split(","))
    {
      dsc += word + "\n";
    }

    return dsc;
  }
}
