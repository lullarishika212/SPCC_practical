import java.util.*;
import java.io.*;

class LeftRec
{
	String [] new_prods;
	int new_p = 0;
	void ElimLeftRec(char m, String alpha_beta[])
	{
		System.out.println("\nAfter Eliminating Left Recurrsion:");
		this.new_prods[this.new_p] = m +"->"+ alpha_beta[1]+ m+"'";			//M->beta M'
		this.new_prods[this.new_p+1] = m +"'->"+ alpha_beta[0]+ m +"/#"; 	//M'->alpha M | ep
		
		System.out.println(this.new_prods[this.new_p]); 
		System.out.println(this.new_prods[this.new_p+1]);	
		this.new_p = this.new_p +2;
		
	}
	public static void main(String args[])
	{
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter no of productions: ");
		n = sc.nextInt();
		boolean is_left_rec[] = new boolean[n];
		
		String[] prods = new String[n];
		int count = 0;
		
		int index = 3;	//after ->
		System.out.println("\nEnter the productions in the form A->Ab/C:");
		sc.nextLine();
		for(int i=0;i<n;i++)
		{
			prods[i] = sc.nextLine();
			
			if(prods[i].charAt(index) == prods[i].charAt(0))
			{
				is_left_rec[i]=true;
				count++;
			}
			else	is_left_rec[i]=false;
		}
		System.out.println(Arrays.toString(is_left_rec));
		
		String[][] alpha_beta = new String[count][];
		int i,j=0;
		
		LeftRec o = new LeftRec();
		o.new_prods = new String[count*2];
		for(i=0; i<n ;i++)
		{
			System.out.print("\nProduction: "+prods[i]);
			if(is_left_rec[i]==true)
			{
				System.out.print(" is left-recursive.");
				char m = prods[i].charAt(0);
				String arr[] = prods[i].split(Character.toString(m));
				prods[i] = arr[2];
				
				alpha_beta[j] = prods[i].split("/");
				o.ElimLeftRec(m,alpha_beta[j]);
				j++;
			}
			else 
				System.out.print(" is not left-recursive.");
		}
		//
		//for(i=0;i<count;i++)
		//	System.out.println(Arrays.toString(alpha_beta[i]));
		
	}
}