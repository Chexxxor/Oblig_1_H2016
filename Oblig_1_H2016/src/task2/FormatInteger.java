package task2;

import java.util.Scanner;
//Exercise 6.37 i Liang
public class FormatInteger {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		int number = input.nextInt();
		System.out.print("Enter the width: ");
		int width = input.nextInt();

		System.out.println("The formatted number is " + format(number, width));
		input.close();
	}
	public static String format(int number, int width) {
		String result = number + "";
		if (number < 0)
			return result;

		for (int i = 0; i < width - len(number); i++)
			result = "0" + result;

		return result;
	}
	public static int len(int number) {
		int size = 0;
		while (number > 0) {
			size += 1;
			number = number / 10;
		}
		return size;
	}
}
