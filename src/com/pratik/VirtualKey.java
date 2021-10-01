package com.pratik;

//import java.io.CharArrayReader;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class VirtualKey {
    final String TEXT_RED = "\u001B[31m";
    final String TEXT_RESET = "\u001B[0m";
    final String TEXT_BLUE = "\u001B[34m";
    void displayFiles(){
        try {
            List<String> results = new ArrayList<>();
            File[] files1 = new File("C:\\Users\\Pratik\\IdeaProjects\\Virtual_Key_Project_Java\\src\\com\\pratik\\Directory\\").listFiles();
            assert files1 != null;
            for (File file : files1) {
                if (file.isFile()) {
                    results.add(file.getName());
                }
            }
            if (results.size() > 0) {
                String[] fileNames = new String[results.size()];
                for (int i = 0; i < results.size(); i++) {
                    fileNames[i] = results.get(i);
                }
                sort(fileNames);
                for (String fileName : fileNames) {
                    System.out.println(fileName);
                }
            }else {
                System.out.println("Directory is Currently Empty");
            }
        }catch (Exception e){
            System.out.println(TEXT_RED+"Directory Doesn't Exists"+TEXT_RESET);
        }
    }
    void addFile(String fileName) throws IOException{
        Path path =null;
        String s="";
        try{
            path= Paths.get("C:\\Users\\Pratik\\IdeaProjects\\Virtual_Key_Project_Java\\src\\com\\pratik\\Directory\\"+fileName);
            Files.createDirectories(path.getParent());
        }catch (Exception e){
            System.out.println(TEXT_RED+"Directory Doesn't Exists"+TEXT_RESET);
        }

        try {
            assert path != null;
            Files.createFile(path);
        }catch (FileAlreadyExistsException e){
            s=e.getMessage();
            System.out.println("File With Name'"+fileName+"' Already Exists, Try With Different Name");

        }
        if (s.isEmpty()){
            System.out.println(TEXT_BLUE+"File '"+fileName+"' has been Added Successfully"+TEXT_RESET);
        }
    }

    void deleteFiles(String fileName){
        if(searchFile(fileName)){
         try {
             File f=new File("C:\\Users\\Pratik\\IdeaProjects\\Virtual_Key_Project_Java\\src\\com\\pratik\\Directory\\"+fileName);
             if(f.delete()){
                 System.out.println(TEXT_BLUE+"The File Has Been Deleted Successfully"+TEXT_RESET);
             }else {
                 System.out.println(TEXT_RED+"Deletion Process Failed"+TEXT_RESET);
             }
         }catch (Exception e){
             System.out.println(TEXT_RED+"Directory Doesn't Exists"+TEXT_RESET);
         }
        }else System.out.println(TEXT_RED+"File not Found"+TEXT_RESET);
    }

    void sort(String [] fileNames){
        for (int i=0;i<fileNames.length-1;i++){
            for (int j=0;j<fileNames.length;j++){
                if (fileNames[i].toUpperCase(Locale.ROOT).compareTo(fileNames[j].toUpperCase(Locale.ROOT))>0){
                    String temp=fileNames[i];
                    fileNames[i]=fileNames[j];
                    fileNames[j]=temp;
                }
            }
        }
    }


    boolean searchFile(String fileName){
        boolean flag=false;
        try{
            List<String > results= new ArrayList<>();
            File[] files1 = new File("C:\\Users\\Pratik\\IdeaProjects\\Virtual_Key_Project_Java\\src\\com\\pratik\\Directory\\").listFiles();
            assert files1 != null;
            for (File file:files1){
                if (file.isFile()){
                    results.add(file.getName());
                }
            }
            String [] fileNames= new String [results.size()];
            for (int i=0;i<results.size();i++){
                fileNames[i]=results.get(i);
            }
            for (String name : fileNames) {
                if (name.equals(fileName)) {
                    flag = true;
                    break;
                }
            }
        }catch (Exception e){
            System.out.println(TEXT_RED+"Directory Doesn't Exists"+TEXT_RESET);
        }
        return flag;
    }
}
