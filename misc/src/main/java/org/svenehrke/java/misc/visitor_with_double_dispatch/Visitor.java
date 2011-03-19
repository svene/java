package org.svenehrke.java.misc.visitor_with_double_dispatch;

// 2. Create a "visitor" base class with a visit() method for every "element" type
interface Visitor {
   public void visit(This e); // second dispatch
   public void visit(That e);
   public void visit(TheOther e);
}
