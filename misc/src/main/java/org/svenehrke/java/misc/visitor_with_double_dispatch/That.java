package org.svenehrke.java.misc.visitor_with_double_dispatch;

class That implements Element {
   public void   accept( Visitor v ) {
     v.visit( this );
   }
   public String that() {
     return "That";
   }
}
