// gaslighting gatekeeping girlbosses -- Lauren Lee, Kevin Xiao, Kevin Li
// APCS
// L09 -- Some Folks Call It a Charades
// 2022-04-26
// time spent: 5 hrs

import java.lang.*;
/**
 * Celebrity base class for the Celebrity game.
 * @author cody.henrichsen
 * @version 1.4 17/09/2018
 */
public class Celebrity
{
	private String _name;
	private String _clue;
	private String[] _celebs = {"Kevin Xiao","Tom Holland","Blake Lively","Lauren Lee","Kevin Li","Elon Musk","Topher Mykolyk"};
	private String[] _clues = {"takes calc","is spiderman", "in Gossip Girl","cs tryhard num 1","kirby enthusiast","bought twitter","is our father"};
	/**
	 * The clue to determine the celebrity
	 */

	/**
	 * The answer or name of the celebrity.
	 */

	 public Celebrity(){
		 int rand = (int)(Math.random()*7);
		 _name = _celebs[rand];
		 _clue = _clues[rand];
	 }
	/**
	 * Creates a Celebrity instance with the supplied answer and clue
	 * @param answer
	 * @param clue
	 */
	public Celebrity(String answer, String clue)
	{
		_name = answer;
		_clue = clue;
	}

	/**
	 * Supplies the clue for the celebrity
	 * @return
	 */
	public String getClue()
	{
		return _clue;
	}

	/**
	 * Supplies the answer for the celebrity.
	 * @return
	 */
	public String getAnswer()
	{
		return _name;
	}

	/**
	 * Updates the clue to the provided String.
	 * @param clue The new clue.
	 */
	public void setClue(String clue)
	{
		_clue = clue;
	}

	/**
	 * Updates the answer to the provided String.
	 * @param answer The new answer.
	 */
	public void setAnswer(String answer)
	{
		_name = answer;
	}

	/**
	 * Provides a String representation of the Celebrity.
	 */
	@Override
	public String toString()
	{
		return _name + " is " + _clue;
	}

	public static void main(String[] args){
		Celebrity LL = new Celebrity("Lauren", "loser");
		System.out.println(LL.getClue());
		System.out.println(LL.getAnswer());
		LL.setClue("the best person ever");
		LL.setAnswer("Lau-en");
		System.out.println(LL.getClue());
		System.out.println(LL.getAnswer());

		Celebrity KXiao = new Celebrity();
		System.out.println(KXiao.getClue());
		System.out.println(KXiao.getAnswer());
	}

}
