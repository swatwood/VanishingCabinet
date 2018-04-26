/**
  Represent a list as a chain of nodes.
  
  Differs from previous implementations chiefly in having a
  sentinel node, beforeHead, to eliminate special cases for 
  inserting and deleting at the beginning of the list.
 */

public class LinkedList implements List_more {

    private Node beforeHead;  /* a reference to a node
        whose @next field holds either...
           o  null, if the list is empty; or
           o  a reference to the node that is the head of this list.
              The "head" is also known as "element 0" and
               "the first element" by people who have not yet
               learned that ordinal numbers like "first" sow
               confusion.
        The cargo field of the beforeHead node is ignored.
      */


    /** Construct an empty linked list.
     */
    public LinkedList() {
        beforeHead = new Node( null, null);
        beforeHead.next = null;
    }


    // -------------- List interface methods follow --------------

    /**
       @return the number of elements in this list
      */
     public int size(){
         Node current = beforeHead;
         int counter = 0;
         while ( current.next != null){
             counter++;
             current = current.next;
         }
         return counter;
     }
    
    /**
       Append @newValue to the end of this list
       @return true (as specified by Collection.add)
      */
     public boolean add( String newValue){
         Node newNode = new Node( newValue, null);
         Node current = beforeHead;
         while( current.next != null){
             current = current.next;
         }
         current.next = newNode;
         newNode.next = null;
         return true;
         
     }
    
    
     /**
       @return the String at the specified position in this list.
      */
     public String get( int index){
	 if ( index < 0 || index >= this.size()){
		throw new IndexOutOfBoundsException( "index not right");
	}
	 Node current = beforeHead;
         int counter = 0;
         while (counter < index){
             current = current.next;
             counter++;
		}
	return current.cargo;

         
         //write try catch after for index out of bounds
     } 
    
     /**
       Replace the String at the specified position in this list
       with @newValue.
       @return the String previously at the specified position
      */
     public String set( int index, String newValue){
         Node current = beforeHead;
         int counter = -1;
         while (counter < index){
             current = current.next;
             counter++;
         }
         String oldCargo = current.cargo;
         current.cargo = newValue;
         return oldCargo;
     }

     /**
       add-at-index, colloquially.
       Insert @newvalue at the specified position in this list.\
       Shift the element currently at that position (if any)
       and any subsequent elements to the right (adds one to 
       their indices). 
       @return void! Different from add-at-end! Who knows why?
      */
     public void add( int index, String newValue){
	 Node newNode = new Node( newValue, null);
         Node current = beforeHead;
         while( current.next != index){
             current = current.next;
         }
	 Node oldNode = current //oh no reference nonsense. 
         current.next = newNode;
         newNode.next = oldNode;
         return void;
	}


    
    // -------------- end of List interface methods --------------


    /**
      @return a string representation of this LinkedList instance
     */
    public String toString() {
        String result = "beforeHead --> ";
        if( beforeHead.next == null)
            result += "empty list";
        else result += beforeHead.next.toStringDefault()
                     + System.lineSeparator()
                     + beforeHead.next.toString();
        return result;
    }
    
    
    /**
      Represent a node in a linked list.
      The cargo is limited to String for simplicity, so that we
      concentrate on list operations. Ideally the type should be generic.
     */
    public class Node {

        private String cargo;
        private Node next;


        /**
          Construct an instance. Either param can be null.
         */
        public Node( String cargo, Node next) {
            this.cargo = cargo;
            this.next = next;
        }


        /**
          @return a string representation of this Node instance.
         */
        public String toString() {
            String result = cargo + " @ " + toStringDefault();

            // Indicate whether this node has a link to another.
            if( next == null)
                 result += " [no next]";
            else result += " --> " + next;

            return result; 
        }


        /**
          @return: the default toString for this Node instance, 
                   to aid checking references during testing
                   For example: Node@1db9742
         */
        public String toStringDefault() {
            return super.toString();
        }
    }

}
