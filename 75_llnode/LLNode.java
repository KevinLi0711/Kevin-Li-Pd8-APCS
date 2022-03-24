/*
Team Three Kevins: Kevin Xiao, Kevin Li, Hamim Seam (honorary Kevin)
APCS
HW75 -- Nodal Recall
2022-03-13
time spent: 0.5 hour
*/

public class LLNode{
    private String car;
    private LLNode cdr;
    
    public LLNode(String car, LLNode cdr){
      this.car = car;
      this.cdr = cdr;
    }
    
    public String getCar(){
      return car;
    }
    
    public LLNode getCdr(){
      return cdr;
    }
    
    public String toString(){
      return getCar() + "," + getCdr();
    }
    
    public void setCar(String car){
      this.car = car;
    }
    
    public void setCdr(LLNode cdr){
      this.cdr = cdr;
    }
  }