/*
Lonely Islanders
Jacob Ng, Gabriel Thompson, Kevin Li, Eric He
APCS
HW25 -- Do I repeat myself?
2021-10-2
time spent: 0.5 hr
*/

/*
DISCO
-Base case is the one thing with a definite value. The rest of the recursion builds on the base case.
-2 ways to right the recursion. We can add the posts add the end or at the beginning. Both ways are equally funky.
QCC
-How exactly does a recursion look on a flow chart?
-Performance wise, is recursion more efficient than a loop?
-Will there be times when recursions and loops can't be used equally?
*/


public class Repeater{
	public static String fenceR(int numPosts){

		if(numPosts == 1){
			return "|";
		}
		//return "|--" + fenceR(numPosts - 1);
		return fenceR(numPosts - 1) + "--|";
		

	}

	public static String fenceW(int numPosts){
		String fence = "|";
		while(numPosts > 1){
			fence += "--|";
			numPosts--;
		}
		return fence;

	}

	public static void main(String[] args){
		System.out.println(fenceR(3));
		System.out.println(fenceR(1));
		System.out.println(fenceR(2));
		System.out.println(fenceR(4));

		System.out.println(fenceW(3));
		System.out.println(fenceW(1));
		System.out.println(fenceW(2));
		System.out.println(fenceW(4));
	}
}