/*
We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3, ..) have the normal 2 ears. 
The even bunnies (2, 4, ..) we'll say have 3 ears, because they each have a raised foot. 
Recursively return the number of "ears" in the bunny line 1, 2, ... n (without loops or multiplication).
*/

public class bunnyEars2 {
    public static int bunnyEars2(int bunnies) {
        int ears = 0;
        
        if (bunnies == 0) {
        return ears = 0;
        }
        
        if (bunnies % 2 == 0) {
        ears = 3;
        } else {
        ears = 2;
        }
        
        return ears + bunnyEars2(bunnies - 1);
    }

    public static void main(String[] args) {
        System.out.println(bunnyEars2(0));
        System.out.println(bunnyEars2(1));
        System.out.println(bunnyEars2(2));
    }
}