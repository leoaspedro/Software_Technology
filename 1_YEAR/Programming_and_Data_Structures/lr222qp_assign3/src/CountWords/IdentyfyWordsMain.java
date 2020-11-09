package CountWords;


import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.util.Scanner;

public class IdentyfyWordsMain {
    private static String words;
    private static String textDocument="";

    public static void main(String[] args){
        readFile("/Users/AK47/IdeaProjects/1DV507/src/ak223wd_assign3/count_words/city.txt");
    }

    public static void readFile(String doc){
        try{
            File file = new File(doc);
            Scanner sc = new Scanner(file);

            while (sc.hasNext()){
                textDocument+=sc.nextLine();
            }
            for(int i=0;i<textDocument.length();i++){
                if(Character.isLetter(textDocument.charAt(i)) || Character.isWhitespace(textDocument.charAt(i))){
                    words+=textDocument.charAt(i);
                }
            }
            FileWriter filewriter = new FileWriter("words");
            filewriter.write(words);
            filewriter.close();


            //System.out.print(words);


        } catch (Exception e ){
            e.printStackTrace();
        }
    }

}

