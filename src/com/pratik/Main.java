package com.pratik;
import java.util.Scanner;
import java.io.IOException;
public class Main {

    public static void main(String[] args) throws IOException {
	  String choice;
         final String TEXT_GREEN = "\u001B[32m";
        final String TEXT_RESET = "\u001B[0m";
        final String TEXT_YELLOW = "\u001B[33m";
        final String TEXT_RED = "\u001B[31m";
        final String TEXT_BLUE = "\u001B[34m";
            System.out.println(TEXT_GREEN+"*************************************************");
            System.out.println("**          Welcome to virtual key             **");
            System.out.println("*************************************************");
            System.out.println("**       Developed by Pratik Chaudhari         **");
            System.out.println("*************************************************"+TEXT_RESET);
        do{
            System.out.println(TEXT_YELLOW+"*************************************************");
            System.out.println("** 1:- Display the files in the directory      **");
            System.out.println("** 2:- More option                             **");
            System.out.println("** 3:- Close Application                       **");
            System.out.println("*************************************************"+TEXT_RESET);
            System.out.println();
            Scanner scanner=new Scanner(System.in);
            System.out.print("Enter your Choice:- ");
            choice= scanner.next();
            VirtualKey vk=new VirtualKey();
            switch (choice) {
                case "1":
                    vk.displayFiles();

                    break;
                case "2":
                    String option;
                    do {
                        System.out.println();
                        System.out.println("*******************************************************");
                        System.out.println("** 1:- Add a New file                                **");
                        System.out.println("** 2:- Delete a file                                 **");
                        System.out.println("** 3:- Search for a file                             **");
                        System.out.println("** 4:- Get back to the main menu                     **");
                        System.out.println("*******************************************************");
                        System.out.println();

                        option = scanner.next();
                        if (option.equals("1")) {
                            System.out.println("Enter the Name of File ");
                            String fileName = scanner.next();
                            vk.addFile(fileName);

                        } else if (option.equals("2")) {
                            System.out.println("Enter the name of file to be deleted:-");
                            String fileName = scanner.next();
                            vk.deleteFiles(fileName);

                        } else if (option.equals("3")) {
                            System.out.println("Enter the file name you want to search");
                            String fileName = scanner.next();
                            boolean result = vk.searchFile(fileName);
                            if (result) {
                                System.out.println(TEXT_BLUE+"Got it... File is present in the directory"+TEXT_RESET);
                            } else {
                                System.out.println(TEXT_RED+"File not found"+TEXT_RESET);
                            }
                        } else if (!option.equals("4")) {
                            System.out.println(TEXT_RED+"Invalid input!!  please try again"+TEXT_RESET);
                        }
                    } while (!option.equals("4"));
                    break;
                case "3":
                    System.out.println(TEXT_GREEN+"Thank you for using Virtual Key"+TEXT_RESET);
                    break;
            }
        }while(!choice.equals("3"));
    }
}
