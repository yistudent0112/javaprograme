package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Question {
	private static int EveryDay = 2;
	private int SumQuestions;
	private int SumCompltedQuestions;
	private int TimetoPlay;
	private int SumTime;

	public void CalculateTime() {
		if (SumQuestions >= 10) {
			TimetoPlay = (int) Math.pow(2, SumQuestions - 10);
			SumTime = SumTime + TimetoPlay;
		}
		if (SumQuestions <= -5) {
			TimetoPlay = (int) Math.pow(2, Math.abs(SumQuestions) - 5);
			SumTime = SumTime - TimetoPlay;
		}
	}

	public Question() {
		SumCompltedQuestions = 0;
		SumQuestions = 0;
		SumTime = 0;
	}

	public Question(int sumQuestions, int sumCompltedQuestions) {
		SumQuestions = sumQuestions;
		SumCompltedQuestions = sumCompltedQuestions;
	}

	public void EveryDayWork(int TodayCompleteWork) {
		SumQuestions = SumQuestions + TodayCompleteWork - EveryDay;
		SumCompltedQuestions = SumCompltedQuestions + TodayCompleteWork;
	}

	public void write() {

		try {
			String file = "data.txt";
			BufferedWriter out = new BufferedWriter(new FileWriter(new File(file)));
			out.write("SumQuestions:" + SumQuestions + "\r\n");
			out.write("SumCompltedQuestions" + SumCompltedQuestions + "\r\n");
			out.write("SumTime" + SumTime + "\r\n");
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void read() {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		String exit = "";
		Scanner in = new Scanner(System.in);

		while (!exit.equals("exit")) {
			int temp = 0;
			System.out.println("please input today completed questions");
			temp=in.nextInt();
			q.EveryDayWork(temp);
			q.CalculateTime();
			System.out.println("if you want to quit print exit");
			exit = in.next();
		}
		q.write();
		in.close();
	}

}
