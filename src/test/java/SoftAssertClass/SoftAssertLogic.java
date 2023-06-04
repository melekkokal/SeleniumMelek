package SoftAssertClass;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertLogic {

   public int getSum(int number1, int number2){
       return number1+number2;
   }

   @Test
    public void hardAssert(){
       Assert.assertEquals(getSum(1,5),6); //directly call it with class name.
       System.out.println("test1");
       Assert.assertEquals(getSum(3,7), 10);//if any of these wrong it will throw an exception and not execute the rest.
       //and won't print out the rest.
       System.out.println("test2");
       Assert.assertEquals(getSum(5,9), 14);
       System.out.println("test3");
   }

   @Test
    public void softAssert(){
       SoftAssert softAssert=new SoftAssert(); //an object. you don't need to create and object for hardassert.
       softAssert.assertEquals(getSum(1,5),6);//you still use the methods since the methods are static.
       System.out.println("test1");
       softAssert.assertEquals(getSum(3,7), 11);//if any of them wrong and it fails you can still see it on the console.
       System.out.println("test2");                     //you need an activation key to not to let it pass.
       softAssert.assertEquals(getSum(5,9), 14);
       System.out.println("test3");
       softAssert.assertAll(); //activate it with this.


   }
}
