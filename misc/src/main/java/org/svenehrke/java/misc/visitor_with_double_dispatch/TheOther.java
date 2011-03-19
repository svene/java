package org.svenehrke.java.misc.visitor_with_double_dispatch;

class TheOther implements Element {
   public void   accept( Visitor v ) {
     v.visit( this );
   }
   public String theOther() {
     return "TheOther";
   }
}
