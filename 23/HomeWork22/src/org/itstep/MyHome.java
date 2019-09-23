package org.itstep;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Вит on 17.04.2017.
 */
public class MyHome {
    public static void main(String[] args) {
wordWrap("input.txt");
stripHtmlTags("index.html");
    }
    public static void wordWrap(String input){
       final int newLine = 10,carriageReturn = 13;
       String line = "";
       try(InputStream in = new FileInputStream(input)){
           int count =-1,countChars = 0;
           while((count = in.read())>0){
               if(count == newLine||count==carriageReturn){
                   line+=(char)count;
                   countChars = 0;
                   continue;
               }
               if(countChars>59){
                   line+=(char)newLine;
                   line+=(char)carriageReturn;
                   countChars=0;
               }
               countChars++;
               line+=(char)count;
           }
           System.out.println(line);
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    public static void stripHtmlTags(String input) {
        String line = "";
        int leftAngleBracket = 60, rightAngleBracket = 62, newLine = 10, carriageReturn = 13, skipCount = 0, countInLine = 0;
        boolean skip = false;
        try (InputStream in = new FileInputStream(input)) {
            int count = -1;
            while ((count = in.read()) > 0) {
                countInLine++;
                if (count == newLine) {
                    if (skipCount + 2 == countInLine && skipCount != 0) {
                        skipCount = 0;
                        countInLine = 0;
                        continue;
                    }
                    skipCount = 0;
                    countInLine = 0;
                }
                if (skip && count != rightAngleBracket) {
                    skipCount++;
                    continue;
                }
                if (count == rightAngleBracket) {
                    skip = false;
                    skipCount++;
                    continue;
                }
                if (count == leftAngleBracket) {
                    skip = true;
                    skipCount++;
                    continue;
                }
                line += (char) count;
            }

            System.out.println("-------------");
            System.out.println(line);
            System.out.println("-------------");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
