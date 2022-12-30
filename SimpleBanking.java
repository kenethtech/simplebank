/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplebanking;

import java.util.*;

/**
 *
 * @author user
 */
public class SimpleBanking {

    public static Hashtable balance = new Hashtable();
    public static Scanner keyboard = new Scanner(System.in);
    public static Enumeration names;
    public void deposit(){
        double balc;
        try{
            System.out.println("Enter the accountname");
            String str = keyboard.next();
            System.out.println("Enter the amount to deposit");
            double amount = keyboard.nextDouble();
            balc = ((Double)balance.get(str)).doubleValue();
            double newamount = balc + amount;
            balance.put(str, new Double(newamount));
            System.out.println(str +" new balance is: " + balance.get(str) );
        
            System.out.println("Enter any key to go back to home page");
            String str1 = keyboard.next();
            banking();
        }
        catch(Exception e){
            System.out.println("The accountname does not exist!!!");
            System.out.println("Enter any key to go back to home page");
            String str1 = keyboard.next();
            banking();
        }
        
    }
    public void withdraw(){
        double balc;
        try{
            System.out.println("Enter the accountname");
            String str = keyboard.next();
            System.out.println("Enter the amount to withdraw");
            double amount = keyboard.nextDouble();
            balc = ((Double)balance.get(str)).doubleValue();
            if(balc < amount){
                System.out.println("The account balance is less than the amount you want to withdraw");
                System.out.println("Enter any key to go back to home page");
                String str1 = keyboard.next();
                banking();
            }
            else{
                double newamount = balc - amount;
                balance.put(str, new Double(newamount));
                System.out.println("withdrawal of amount "+ amount + " was successfull");
                System.out.println(str +" new balance is: " + balance.get(str) );
        
                System.out.println("Enter any key to go back to home page");
                String str1 = keyboard.next();
                banking();
            }
            
        
            
        }
        catch(Exception e){
            System.out.println("The accountname does not exist!!!");
            System.out.println("Enter any key to go back to home page");
            String str1 = keyboard.next();
            banking();
        }
    }
    public void transfer(){
    }
    public void createAcc(){
        
        System.out.println("Enter the first name");
        String str = keyboard.next();
        System.out.println();
        System.out.println("Enter the initial balance");
        double bal = keyboard.nextDouble();
        if(balance.containsKey(str)){
            System.out.println("sorry the username already exists");
        }
        else{
            balance.put(str, bal);
            System.out.println("account created successfull");
            
        }
        System.out.println("Enter any key to go back to home page");
        String str1 = keyboard.next();
        banking();
        
    }
    public void users(){
        
        try{
            
            names = balance.keys();
            String stry;
            if(names.hasMoreElements()== false){
                System.out.println("there are no accounts available!!!");
            }
            else{
                System.out.println("------the users are----");
                while(names.hasMoreElements()){
                   stry = (String)names.nextElement();
                   System.out.println(stry +":" + balance.get(stry));
                }
            }
            System.out.println("Enter any key to go back to home page");
            String str1 = keyboard.next();
            banking();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void banking(){
        System.out.println("-------- Welcome to Simplebanking Admin interface -------");
        System.out.println("Enter 1 to create a new account");
        System.out.println("Enter 2 to list the existing accounts with their balances");
        System.out.println("Enter 3 to deposit");
        System.out.println("Enter 4 to withdraw");
        System.out.println("Enter 5 to transfer to an existing account");
        System.out.println("Enter 6 to quit");
        
        SimpleBanking mybank = new SimpleBanking();
        
        int num = keyboard.nextInt();
        if(num == 1){
            
            mybank.createAcc();
        }
        else if(num == 2){
            mybank.users();
        }
        else if(num == 3){
            mybank.deposit();
        }
        else if(num == 4){
            mybank.withdraw();
        }
        else if(num == 5){
            mybank.transfer();
        }
        else if(num == 6){
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        SimpleBanking.banking();
    }
    
}
