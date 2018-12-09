package assignment1;

import java.io.*;


public class part2 
{
	public static void main(String a[]) throws IOException
	{
		//Opening the output file for reading
		File file=new File("C://Users//Tanjot//Documents//java assignments//assignment 1//HW1-output-16104080.txt");
		if(!file.exists())
		{
			System.out.println("File not available!");
			return;
		}
		BufferedReader rd=new BufferedReader(new FileReader(file));
		
		//reading the heading lines
		String s=rd.readLine();s=rd.readLine();
		//count for total students to calculate average
		int count=0;
		float total=0f;
		
		//array to store number of grades
		int[] store=new int[5];
		
		//variable to store maximum points
		 int max=-100;
		 
		 //opening the file in append mode
		 FileWriter fw = new FileWriter(file,true);
		 BufferedWriter bw = new BufferedWriter(fw);
		
		 while((s = rd.readLine()) != null)
		 {
			
			String[] str=s.split("\\s+");
			count++;
			total+=Integer.parseInt(str[17]);
			if(str[18].equals("A"))store[0]++;
			else if(str[18].equals("B"))store[1]++;
			else if(str[18].equals("C")) store[2]++;
			else if(str[18].equals("D"))store[3]++;
			else if(str[18].equals("F"))store[4]++;
			if(max<Integer.parseInt(str[16]))max=Integer.parseInt(str[16]);
			
		
		 }
		 bw.write("Average total point percent of all students:"+ total/count+"\n");
		 bw.write("Number of A grades:"+store[0]+"\n");
		 bw.write("Number of B grades:"+store[1]+"\n");
		 bw.write("Number of C grades:"+store[2]+"\n");
		 bw.write("Number of D grades:"+store[3]+"\n");
		 bw.write("Number of F grades:"+store[4]+"\n");
		 bw.write("Maximum points:"+max+"\n");
		 
		 //closing the file
		 rd.close();
		 bw.close();
	}
}
