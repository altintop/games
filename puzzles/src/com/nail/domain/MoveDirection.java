/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nail.domain;

/**
 *
 * @author nail
 */
public enum MoveDirection {
   LEFT(1),
   UP(2),
   RIGHT(3),
   DOWN(4);
   
   private int value;
   private MoveDirection(int value) {
      this.value = value;
   }
   
   public int getValue() {
      return value;
   }
}
