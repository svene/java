package org.svenehrke.java.misc.visitor_with_double_dispatch;

interface Element {
   // 1. accept(Visitor) interface
   public void accept(Visitor v); // first dispatch
}
