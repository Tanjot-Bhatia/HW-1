package assignment1;

import java.io.*;

public class Assign1 
{
	//Calculate percentage from total points
	int getpc(int x)
	{

		float pc= (float) (((float)x/420.0)*100.0);
		float y=pc-(int)pc;
		int r;
		if(y>=0.5)
		{
			r=(int)pc+1;
		}
		else r=(int)pc;
		return r;		
	}
	
	//calculates grade from percentage
	String grade(int pc)
	{
		if(pc>=90)
			return "A";
		else if(pc>=78)
			return "B";
		else if(pc>=62)
			return "C";
		else if(pc>=46)
			return "D";
		else return "F";
	
	}
	
	String makeString(String[] str,int len)
	{
		int asum=0;
		String f=str[0]+"  ";
		
		//Traversing the string array to calculate sum of assignment marks
		for(int i=1;i<len;i++)
		{
			if(Integer.parseInt(str[i])<10)
			f=f+" "+str[i]+"  ";
			else f=f+str[i]+"  ";
			if(i>=2&&i<12)
			{
				asum=asum+Integer.parseInt(str[i]);
			}
			if(i==11)
				f=f+asum+"  ";
			
		}
		
		asum=asum+Integer.parseInt(str[1])+Integer.parseInt(str[12])+Integer.parseInt(str[13])+Integer.parseInt(str[14]);
		f=f+asum+"  ";
		
		//Total sum of marks
		asum=asum-Integer.parseInt(str[14]);
		int pc=getpc(asum);
		f=f+pc+"  ";
		f=f+grade(pc)+"\n";
		//returning the string to be printed onto output file
		return f;
		
	}
	
	
	public static void main(String a[]) throws IOException,Exception
	{
		//Opening files for reading 
		 File in=new File("C://Users//Tanjot//Documents//java assignments//assignment 1//HW1-data.txt");
		 if (!in.exists()) 
		 {
		     System.out.println("Input file not available!Check the path and try again!!");
		     return;
		 }
		 BufferedReader rd=new BufferedReader(new FileReader(in));
		 
		 
		 //Opening the file for writing
		 File out=new File("C://Users//Tanjot//Documents//java assignments//assignment 1//HW1-output-16104080.txt");
		 if (!out.exists()) 
		 {
		      out.createNewFile();
		 }
		 FileWriter fw = new FileWriter(out);
		 BufferedWriter bw = new BufferedWriter(fw);
		 
		 
		 //Headings in the output file
		 String s1="Stdnt id  Ex  ---------------Assignments------------  Tot  Mi Fin  CL  Pts Pct  Gr \n";
		 bw.write(s1);
	     s1="--------  --  --------------------------------------  ---  -- ---  --  --- ---  --\n";
		 bw.write(s1);
		 
		 String s=null;
		 
		 //Reading the input file line by line
		 while((s = rd.readLine()) != null)
		 {
			//Splitting the read line into string array 
			String[] str=s.split("\\s+");
			Assign1 obj=new Assign1();
			
			//returns a one line string to be written into output file
			String f=obj.makeString(str,str.length);
			//Writing into output file line by line
			bw.write(f);
		 }
		 //closing the files
		 bw.close();
		 rd.close();
	}

}
