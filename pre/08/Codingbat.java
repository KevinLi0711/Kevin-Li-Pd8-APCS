public class Codingbat{
    //force
public double force(double g, double m1, double m2, double r){
    return((g * m1 * m2) / (r * r));
  }

//average3
public double average3(int a, int b, int c){
    return((a + b + c) / 3.0);
  }
//sumOfSines
public double sumOfSines(double t){
    double x = t * (Math.PI / 180);
    double y = (Math.sin(x * 2) + Math.sin(x * 3));
    return Math.round(y * 1000.0) / 1000.0;
  }
//oddsAreNegated
public int oddsAreNegated(int x){
    if((x % 2) == 0){
      return x;
    } else{
      return -x;
    }
  }
//noTeenSum
public int noTeenSum(int a, int b, int c) {
    return(fixTeen(a) + fixTeen(b) + fixTeen(c));
  }
  public int fixTeen(int n){
    if((n == 15) || (n == 16)){
      return n;
    } else if((13 <= n) && (n <= 19)){
      return 0;
    }
    return n;
  }
//stringTimes
public String stringTimes(String str, int n) {
    String x = "";
    for(int i = 0; i < n; i++){
      x = x + str;
    }
    return x;
  }
//countEvens
public int countEvens(int[] nums) {
    int count = 0;
    for(int i = 0; i < nums.length; i++){
      if((nums[i] % 2) == 0){
        count++;
      }
    }
    return count;
  }
//sum28
public boolean sum28(int[] nums) {
    int sum = 0;
    for(int i = 0; i < nums.length; i++){
      if(nums[i] == 2){
        sum = sum + 2;
      }
    }
    return(sum == 8);
  }
//scoresIncreasing
public boolean scoresIncreasing(int[] scores) {
    boolean x = true;
    for(int i = 0; i < (scores.length - 1); i++){
      if(scores[i] <= scores[i + 1]){
        x = true;
      } else return false;
    }
    return x;
  }
}


  