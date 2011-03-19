package org.svenehrke.java.misc.visitor_with_double_dispatch;

class This implements Element {
   // 1. accept(Visitor) implementation
   public void   accept( Visitor v ) {
     v.visit( this );
   }
   public String thiss() {
     return "This";
   }
}
