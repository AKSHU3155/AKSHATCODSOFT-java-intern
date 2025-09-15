
import java.util.Scanner;

public class student_grad {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("........STUDENT GRADE CALCULATOR........");
        System.out.println("Enter the Marks of all Subject out of 100.....");
        System.out.print("Maths : ");
        int math = sc.nextInt();
        System.out.print("Physics : ");
        int phy = sc.nextInt();
        System.out.print("Chemistry : ");
        int chem = sc.nextInt();
        System.out.print("Computer : ");
        int com = sc.nextInt();
        System.out.print("English : ");
        int eng = sc.nextInt();
        int sum = com + eng + math + phy + chem;
        int per = (sum * 100) / 500;
        System.out.println("Total sum : " + sum);
        System.out.println("Average Percentage : " + per + "%");
        if (per >= 60) {
            System.out.println("Grade : 'A'");
        } else if (per >= 45 && per < 60) {
            System.out.println("Grade : 'B'");
        } else if (per >= 33 && per < 45) {
            System.out.println("Grade : 'C'");
        } else {
            System.out.println("Your are Fail.....");
        }
    }
}
