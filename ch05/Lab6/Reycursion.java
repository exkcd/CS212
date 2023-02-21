/*
 * This colleciton of small code snippets illustrates how recursion works.
 * 
 * R Stone
 */

 package ch05.Lab6;

 public class Reycursion {
     public int sum(int n) {
         if (n == 1) {
             return 1;
         } else {
             return sum(n - 1) + n;
         }
     }
 
     public int factorial(int n) {
         if (n != 0) {
             return factorial(n - 1) * n;
         } else {
             return 1;
         }
     }
 
     public int power10(int n) {
         if (n != 0) {
             return power10(n - 1) * 10;
         } else {
             return 1;
         }
     }
 
     public int powerOfN(int x, int p) {
         if (x == 0 || p == 0) {
             return 1;
         } else {
             return x * powerOfN(x, p - 1);
         }
     }
 
     public int bunnyEars(int n) {
         if (n == 0) {
             return 0;
         } else {
             return bunnyEars(n - 1) + 2;
         }
     }
 
     public static void main(String[] args) {
         Reycursion recursion = new Reycursion();
         System.out.println(recursion.sum(5));
         System.out.println(recursion.factorial(5));
         System.out.println(recursion.power10(3));
         System.out.println(recursion.powerOfN(3 , 3));
         System.out.println(recursion.bunnyEars(10));
     }
 }
 