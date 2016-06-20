package hello;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by navid on 2016-06-14.
 */
public class Utilities {
    public static String readFile(String path) throws FileNotFoundException {
        //TODO: Improve around string manipulations
        File file = new File (path);
        Scanner scanner = new Scanner(file);
        String content = new String();
        while (scanner.hasNextLine()){
            String nextLine = scanner.nextLine();
            content = content + nextLine + "\n";
        }
        return content;
    }

    public static ArrayList<String> tokenize(String content) {
        Scanner scanner = new Scanner(content);
        ArrayList<String> tokens= new ArrayList<String>();
        while (scanner.hasNext()){
            String nextToken = scanner.next();
            tokens.add(nextToken);
        }
        return tokens;
    }

    public static int count(ArrayList<String> tokens, String queryWord) {
        int occurrences = 0;
        for (String token : tokens){
            if (token.equals(queryWord)){
                occurrences ++;
            }
        }
        return occurrences;
    }

    public static double score(ArrayList<String> tokens, String queryWord) {
        double score = 0;
        for (int i = 0; i < tokens.size(); i++){
            if (tokens.get(i).equals(queryWord)){
                score += i * (tokens.size() - i) / tokens.size();
            }
        }
        return score;
    }
}
