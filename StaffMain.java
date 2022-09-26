package com.gl.caseStudy1;
import java.util.Scanner;

public class StaffMain {
	public static Double totalCalculation(Applicant applicant) {
		if(applicant.subject1Mark<50 || applicant.subject2Mark<50 || applicant.subject3Mark<50)
			return 0.0;
		else {
		applicant.total=applicant.subject1Mark+applicant.subject2Mark+applicant.subject3Mark;
		return applicant.total;
		}
	}
	public static Double percentageCalculation(Double total) {
		double percentage=Double.parseDouble(String.format("%.2f",(total/300)*100));
		return percentage;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of applicants:");
		int n=Integer.parseInt(sc.nextLine());
		Applicant aplarr[]=new Applicant[n];
		for(int i=0;i<n;i++) {
			System.out.println("Enter applicant details:");
			String str=sc.nextLine();
			try {
				String arr[]=str.split(",");
				double sub1mark=Double.parseDouble(arr[1]);
				double sub2mark=Double.parseDouble(arr[2]);
				double sub3mark=Double.parseDouble(arr[3]);
				if(sub1mark<0 || sub1mark>100)
					throw new MarksException("Invalid Marks");
				if(sub2mark<0 || sub1mark>100)
					throw new MarksException("Invalid Marks");
				if(sub3mark<0 || sub1mark>100)
					throw new MarksException("Invalid Marks");
				Applicant ap=new Applicant(arr[0],sub1mark,sub2mark,sub3mark);
				double total=totalCalculation(ap);
				if(total==0.0) {
					continue;
				}
				else {
				double percentage=percentageCalculation(total);
				Applicant applicant=new Applicant(arr[0],sub1mark,sub2mark,sub3mark,total,percentage);
				aplarr[i]=applicant;
				}
			}
			catch(MarksException me) {
        		System.out.println(me.getMessage());
        	}
		}
		for(Applicant a:aplarr)
			System.out.println(a);
	}
}
