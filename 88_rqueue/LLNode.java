public class LLNode<QUASAR> {
    //instance vars
    private QUASAR _cargo;
    private LLNode<QUASAR> _nextNode;
  
    // constructor
    public LLNode( QUASAR value, LLNode<QUASAR> next )
    {
      _cargo = value;
      _nextNode = next;
    }
  
  
    //--------------v  ACCESSORS  v--------------
    public QUASAR getCargo()
    {
      return _cargo;
    }
  
    public LLNode<QUASAR> getNext()
    {
      return _nextNode;
    }
    //--------------^  ACCESSORS  ^--------------
  
  
    //--------------v  MUTATORS  v--------------
    public QUASAR setCargo( QUASAR newCargo )
    {
      QUASAR foo = getCargo();
      _cargo = newCargo;
      return foo;
    }
  
    public LLNode<QUASAR> setNext( LLNode<QUASAR> newNext )
    {
      LLNode<QUASAR> foo = getNext();
      _nextNode = newNext;
      return foo;
    }
    //--------------^  MUTATORS  ^--------------
  
  
    // override inherited toQUASAR
    public String toString()
    {
      return _cargo.toString();
    }
  
}
  

