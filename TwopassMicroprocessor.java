
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TwopassMicroprocessor {

	public static void main(String[] args) {

		try {
			Map<String, Integer> hm =new 	LinkedHashMap<>();
			List<String> li = new ArrayList<>();
			li.add("INCR"); 
			li.add("ADD");
			li.add("SUB");
			File fr = new File("Microproinput.txt");
			String s = "" ;
			System.out.println("Pass 1 Output");
			System.out.println("PRG		START		0");
			int f = 0;
			Scanner sc = new Scanner(fr);
			while (sc.hasNextLine()) {
				s = sc.nextLine();
				if (f == 1) {
					System.out.println(s);
				}
				if (s.startsWith("LOOP1")) {

					System.out.println(s);
					f = 1;
				}
			}
			System.out.println("\n\nMDT TABLE");
			f = 0; int c=0;
			
			Scanner sc2 = new Scanner(fr);

			System.out.println("-----------------------------\n");
			System.out.println("INDEX \t\t   NAME");
			List<String> a=new ArrayList<>();
			int cnt=1;
			while (sc2.hasNextLine() || s.endsWith("MEND")) {
				s = sc2.nextLine();
				for(int i=0;i<li.size();i++) {
					if(s.contains(li.get(i))) {
						hm.put(li.get(i), (c+1));
					}
				}
				if(s.contains("MEND")) {
					break;
				}
				if (s.startsWith("&LAB")) {
					f = 1;

				}
				
				if (f == 1) {
					
					System.out.print((c++)+1);	
					if(c==2) {
						if(s.contains("&LAB")) {
							a.add("&LAB");
							
							s=s.replace("&LAB", "#0  ");
					}
						}
					if(c>1) {
						if(s.contains("&ARG"))
						{
						String t =String.valueOf(cnt);
						String temp="&ARG"+t;
						a.add(temp);
						cnt++;
						}
						s=s.replace("&ARG", "#");
					}
					System.out.print(" \t"+s);
					if(c==5)
						
						System.out.print("   MEND");
					System.out.println();
					
				}
			}
			
			
			System.out.println("-----------------------------\n");
			System.out.println("Macro Name Table (MNT)");
			System.out.println("Index	Name	MDT Index");
			int r=1;
			for (Map.Entry<String, Integer> entry : hm.entrySet()) {
				String key = entry.getKey();
				int val = entry.getValue();
				System.out.println(r+" \t"+key+" \t"+val);
			}
			System.out.println("-----------------------------\n");
			
			System.out.println("Index	Arguments");
			for(int i=0;i<a.size();i++)
			{
				System.out.println(i+"\t"+a.get(i));
			}
			System.out.println("-----------------------------\n");
			
			
			System.out.println("\n\nPASS 2 OUTPUT");

			System.out.println("-----------------------------\n");
			f=0;
			List<String> data = new ArrayList<>();
			List<String> data2 = new ArrayList<>();
			Scanner sc3 = new Scanner(fr);
			
			System.out.println("PRG	START   0");
			while(sc3.hasNextLine()) {
				s = sc3.nextLine();
			if (f == 1) {
				System.out.println(s);
			}
			if (s.startsWith("LOOP1")) {
				System.out.print("LOOP1 \t");
				String arr[]= s.split(" ");
				int d1 =1;
				for (String string : arr) {
				if(string.contains("LOOP1" )) {
					continue;
				}else if( li.contains(string)){
					continue;
				}else {
					data.add("A"+"\t"+(d1)+","+string);
					data2.add(string.replace(',', ' '));
					d1++;
				}
				}
				
				for (int i = 0; i < data.size(); i++) {
					if(i>0) System.out.println("\t"+data.get(i));
					else	System.out.println(data.get(i));
			}
				
				f = 1;
			}
			} 

			System.out.println("-----------------------------\n");

			System.out.println("-----------------------------\n");
			System.out.println("Index	Arguments");
			System.out.println("0\tLOOP1");
			for(int i=0;i<data.size();i++) {
				System.out.println((i+1)+"\t"+data2.get(i));
			}
			
			
		} catch (Exception e) {
			System.out.println();
		}
	}

}
