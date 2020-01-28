import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

	public class Rewards {
	  
	   public static void main(String[] args){
	       File file = new File("rewardpoints.txt");
	       Scanner sc = null;
	       try{
	           sc = new Scanner(file);
	       }catch(FileNotFoundException f){
	           System.out.println("RewardPoints File not found!");
	       }
	       Map<String,Integer> customerRP = new HashMap<String,Integer>();
	       int totalReward = 0;
	       int counter = 0;
	       while(sc.hasNext()){
	           counter++;
	           if(counter ==1) { 
	               sc.next();
	               sc.next();
	               sc.next();
	               continue;
	           }
	           String customerName = sc.next();
	           double tranAmount = Double.parseDouble(sc.next());
	           String date = sc.next();
	           int currentReward = 0;
	           tranAmount = Math.floor(tranAmount);
	           if(tranAmount > 50 && tranAmount <=100){ 
	               currentReward = currentReward + 1 * (int)(tranAmount -50);
	           }
	           if(tranAmount > 100){
	               currentReward = currentReward + 2 * (int)(tranAmount - 100);
	           }
	          
	           if(customerRP.containsKey(customerName)){
	               int rewardAmt = customerRP.get(customerName);
	               rewardAmt = rewardAmt + currentReward;
	               customerRP.put(customerName, rewardAmt);
	           }else{
	               customerRP.put(customerName, currentReward);
	           }
	          
	           totalReward = totalReward + currentReward;
	       }
	      
	       sc.close();
	      
	       for(String customerName: customerRP.keySet()){
	           System.out.println("Customer Name: "+ customerName+"\t"+"RewardAmount: $"
	                   +customerRP.get(customerName));
	       }
	       System.out.println("Total Reward Amount = $"+totalReward);
	   }
}
