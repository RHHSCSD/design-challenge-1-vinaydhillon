/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package designprojectone;
import java.util.*;
import java.text.*;
/***************************************************
*
*  Program: Tech Fair Cost Calculator
*  Author: Vinay Dhillon
*  Date: March 7, 2024
*  Description:
****************************************************/

/**************** IPO CHART ************************
*INPUT:
*
*Determine which kit each student is going to use
* arduino
* vr 
* raspberry pi 
*
*PROCESSING:
* Sum up all of the totals of each kit to find each student 
* Calculate total price by summing up all of costs of each project
* Apply discounts if needed 
* Divide total price by number of students
*
*
*OUTPUT:
* Output price per student
*
***************************************************/
  
/**************** TEST CASES ************************
*Test      Input      Desired Ouput
*
*
*
*
*
*
*
***************************************************/


public class DesignProjectOne {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   //Write Pseudocode FIRST as comments and THEN write the code
    
  //CONSTANTS
  // constant to apply 5 percent discount by multiplying by 0.95
  final double fivePercentDiscount = 0.95;
  final double fivePercentDiscountAmount = 0.05;
  //VARIABLES
  //variable for each kits cost without discounts 
  double baseKitCost = 50.00;
  double arduinoCost = 10.00;
  double raspberryPiCost = 15.00;
  double vrProjectCost = 20.00;
  boolean discountApplied = false;
  double discountTotal = 0;
  
  //CODE
  //make scanner to use in code to read numbers 
  Scanner n = new Scanner(System.in);
  //make decimal format for final output
  DecimalFormat df = new DecimalFormat("#.00");
  //get number of arduino kits 
  System.out.print("Enter how many arduino kits: ");
  double arduinoQuantity = n.nextInt();
  //if number of arduino kits is greater than 15, the cost will decrease to 9 
  if (arduinoQuantity > 15){
      arduinoCost = 9.00;
  }
  // the total cost of the arduino kits, obtained by multiplying the number of kits by the cost, whether it is modified or not
  double arduinoTotalCost = arduinoQuantity * arduinoCost;
  //read in number of raspberry pi kits
  System.out.print("Enter how many raspberry pi kits: ");
  int raspberryQuantity = n.nextInt();
  //if number of raspberry pi kits is greater than 20, the cost will decrease to 12 
  if (raspberryQuantity > 20){
      raspberryPiCost = 12;
  }
  // calculate the total cost of the raspberry pi kits by multiplying the number of kits needed by the cost, whether it is modified or not
  double raspberryPiTotalCost = raspberryQuantity * raspberryPiCost;
  
  
  //read in number of vr project kits
  System.out.print("Enter how many vr project kits: ");
  int vrQuantity = n.nextInt();
  // calculate the total cost of the vr project kits by multiplying the number of kits needed by the cost of the kits
  double vrProjectTotalCost = vrQuantity * vrProjectCost;
  
  
  // calculate the number of total students by adding up the quantity of each kit
  double totalStudents = (arduinoQuantity + raspberryQuantity + vrQuantity);
  // if the total number of students is greater than 100, apply the discount to the basekit cost 
  if (totalStudents > 100){
      baseKitCost *= fivePercentDiscount;
      discountApplied = true;
     
  }
  //caclulate the total cost of all kits by multiplying the cost by the quantity of students 
  double baseKitTotalCost = baseKitCost * totalStudents;
  // calculate the total cost of everything by adding all total costs of each kit 
  double totalCost = (baseKitTotalCost + arduinoTotalCost + raspberryPiTotalCost + vrProjectTotalCost);
  //calculate the cost that each student needs to pay by dividing the total cost by the number of students 
  double costPerStudent = (totalCost / totalStudents);
  //output the number of students, the total cost, and then the cost per student 
  System.out.println("\nThe total number of students is " + totalStudents);
  System.out.print("The total cost is $" + totalCost);
  
  
  if (discountApplied == true){
      discountTotal = baseKitTotalCost * fivePercentDiscountAmount;
      System.out.println(", the 5% discount was applied to save a total of $"+discountTotal);
  } else{
      System.out.println(", the 5% discount was not applied.");
  }
  // to avoid printing NaN, create a if statement to see if there are 0 students attending. 
  if (totalStudents <= 0){
      System.out.println("There are no students going to the tech fair.");
  }
  else{
  System.out.println("Each student will need to pay $" + df.format(costPerStudent));
  }
    }
  
  
    
}
