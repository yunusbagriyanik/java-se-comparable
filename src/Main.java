import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class book{
    private int code;
    private String specie;
    private String name;
    private String author;

    public book(int code, String specie, String name, String author) {
        this.code = code;
        this.specie = specie;
        this.name = name;
        this.author = author;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public String getName() {
        return name;
    }

    public void setIsim(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

class librarian extends book implements Comparable<librarian>{

    public librarian(int code, String specie, String name, String author) {
        super(code, specie, name, author);
    }

    @Override
    public String toString() {
        return "||||"+"\tNumber:"+getCode()+"\tSpecie:"+getSpecie()+"\tName:"+getName()+"\tAuthor:"+getAuthor()+"\t||||";
    }

    @Override
    public int compareTo(librarian objectperson) {
        
        if(this.getCode()<objectperson.getCode()){
            return -1;
        }
        else if(this.getCode()>objectperson.getCode()){
            return 1;
        }
        return 0;
    }
}
class alphabeticalOrderBookName implements Comparator<librarian>{

    @Override
    public int compare(librarian bookname1, librarian bookname2) {
        return bookname1.getName().compareTo(bookname2.getName());
    }

   
    
}
public class Main {
    public static void main(String[] args){
        
         System.out.println("\t#####  LIBRARY PROGRAM  #####");
         
         List<librarian> booklist=new ArrayList<librarian>();
         
         
         while(true){
            System.out.println("\t1.Add New Book");
            System.out.println("\tTo quit q");
            System.out.print("\tChoose Transaction:");
            Scanner scanner=new Scanner(System.in);
            String transaction=scanner.nextLine();
            if(transaction.equals("q")){
                break;
            }
               while(true){
                     if(transaction.equals("1")){
                         
                     System.out.print("Book Code: ");
                     int code=scanner.nextInt();
                     scanner.nextLine();
                     System.out.print("Book Specie: ");
                     String specie=scanner.nextLine();
                     System.out.print("Book Name: ");
                     String name=scanner.nextLine();
                     System.out.print("Book Author: ");
                     String author=scanner.nextLine();
                     
                     booklist.add(new librarian(code, specie, name, author));
                     }
        
                     System.out.print("To quit(q)\n Add Book(a): ");
                     String addbook=scanner.nextLine();
                     if(addbook.equals("q")){
                         break;
                     }
                     else if(addbook.equals("a")){
                         continue;
                     }
                 }
             System.out.println("\n\n");
        Collections.sort(booklist);
        for(librarian k: booklist){
            System.out.println(k);
        }
        System.out.println("**********************************");
        
        Collections.sort(booklist, new alphabeticalOrderBookName());
        for(librarian a: booklist){
            System.out.println(a);
        }
        System.out.println("**********************************");
        
        Collections.sort(booklist, new Comparator<librarian>(){//anonymous object

            @Override
            public int compare(librarian o1, librarian o2) {
                return o1.getAuthor().compareTo(o2.getAuthor());   
            }
            
        });
        for(librarian author1: booklist){
            System.out.println(author1);
        }
             System.out.println("\n\n");
    }
          
        }
    }
