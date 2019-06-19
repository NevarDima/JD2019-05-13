package by.it.zhukova.calc;

import java.util.Scanner;

import static by.it.zhukova.calc.Var.sortvar;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression;
        Parser parser = new Parser();
            Printer printer = new Printer();
            while (!(expression = scanner.nextLine()).equals("end")) {
              if (expression.equals("printvar")) {Var.printvar(); continue;}
                if (expression.equals("sortvar")) {
                    sortvar(); continue;}
                Var result = parser.calc(expression);
                    printer.print(result);
              //  if ((sorted =scanner.nextLine()).equals("sortvar")) Var.sortvar();


            }
    }
            }


