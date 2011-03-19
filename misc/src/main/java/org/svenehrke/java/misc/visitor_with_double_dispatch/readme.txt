see
	http://sourcemaking.com/design_patterns/visitor/java/1


// 1. Element.accept(Visitor) interface
// 1. This.accept(Visitor) interface
// 1. That.accept(Visitor) interface
// 1. TheOther.accept(Visitor) interface
// 2. Create a "visitor" base class with a visit() method for
//    every "element" type (This, That, TheOther)
// 3. Create a "visitor" derived class for each "operation" to perform on "elements" (UpVisitor, DownVisitor)
// 4. Client (VisitorDemo) creates "visitor" objects and passes each to accept() calls

class VisitorDemo {
   public static Element[] list = { new This(), new That(), new TheOther() };

   public static void main( String[] args ) {
      UpVisitor    up   = new UpVisitor();
      DownVisitor  down = new DownVisitor();
      for (int i=0; i < list.length; i++) {
         list[i].accept( up );
      }
      for (int i=0; i < list.length; i++) {
         list[i].accept( down );
      }
   }
}
