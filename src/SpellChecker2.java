
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;

public class SpellChecker2 {
    /**
     * This is the main method
     * @param args command line arguments (2 file names)
     */
    public static void main(String[] args) throws IOException {

        for (int i = 0; i < args.length; i++) {

        }


        /**
         * Creating mock text files to run the program
         *
         * File file1 = new File("/Users/quinnwheelock/IdeaProjects/csc201-proj1-quinnwheelock/dictionary.txt");
         * FileWriter fw = new FileWriter(file1);
         * PrintWriter pw = new PrintWriter(fw);
         *
         * pw.println("it");
         * pw.println("has");
         * pw.println("some");
         * pw.println("words");
         *
         * pw.close();
         *
         * File file2 = new File("/Users/quinnwheelock/IdeaProjects/csc201-proj1-quinnwheelock/text.txt");
         * FileWriter fw2 = new FileWriter(file2);
         * PrintWriter pw2 = new PrintWriter(fw2);
         *
         * w2.println("has");
         * pw2.println("uhh");
         * pw2.println("nope");
         * pw2.println("words");
         * pw2.close();
         *
         */





          File file1 = new File("/Users/quinnwheelock/IdeaProjects/csc201-proj1v2-quinnwheelock/dictionary.txt");
          FileWriter fw = new FileWriter(file1);
          PrintWriter pw = new PrintWriter(fw);

          pw.println("it");
          pw.println("has");
          pw.println("some");
          pw.println("words");

          pw.close();

          File file2 = new File("/Users/quinnwheelock/IdeaProjects/csc201-proj1v2-quinnwheelock/text.txt");
          FileWriter fw2 = new FileWriter(file2);
         PrintWriter pw2 = new PrintWriter(fw2);

          pw2.println("has");
          pw2.println("uhh");
          pw2.println("words");
          pw2.println("nope");
          pw2.println("words");
          pw2.println("words");
          pw2.close();




        WCLinkedList dictionary = null;
        WCLinkedList text = null;
        WCLinkedList uw = null;
        WCLinkedList newText = null;
        WCLinkedList mispelled = null;

        if (args[0].equals("-s") || args[0].equals("dictionary.txt")) {
            dictionary = new WCLinkedList();
             text = new WCLinkedList();
             uw = new WCLinkedList();
             newText = new WCLinkedList();
             mispelled = new WCLinkedList();
        } else if (args[0].equals("-t")) {
             dictionary = new TWCLinkedList();
             text = new TWCLinkedList();
             uw = new TWCLinkedList();
             newText = new TWCLinkedList();
             mispelled = new TWCLinkedList();
        } else if (args[0].equals("-c")) {
             dictionary = new CWCLinkedList();
             text = new CWCLinkedList();
             uw = new CWCLinkedList();
             newText = new CWCLinkedList();
             mispelled = new CWCLinkedList();

        } else {
            throw new NullPointerException("Command Line Arguments are invalid");
        }




        //dictionary.head = null;




        if (!argsOK(args))
            System.exit(1);

        System.out.println("Spell check " + args[1] + " using dictionary " + args[2]);


        try {
            readDictionary(args[1], dictionary);
        } catch (FileNotFoundException e) {
            System.out.println("1st command line argument is invalid");
            System.exit(1);
        }
        try {
            readDictionary(args[2], text);
        } catch (FileNotFoundException e) {
            System.out.println("2nd command line argument is invalid");
            System.exit(1);
        }
        //System.out.print(dictionary.toString());


        /**
         * This is to take the text DLinkedList and eliminate any unneeded characters
         */

        String stringText = text.toString();
        //System.out.println(text.toString());

        long startTime = System.currentTimeMillis();

        for(String s: stringText.split("[^a-zA-Z_0-9]+")) {
            WordCount tmp = new WordCount("a",0);
            if(!s.equals("0")) {
                //System.out.println(s);
                tmp.setWord(s);
                newText.addFirst(tmp);
                //System.out.println(newText.toString());
            }
        }

        //System.out.println(newText.toString());


        String st2 = newText.toString();


        for(String s: st2.split("[^a-zA-Z_0-9]+")) {
            WordCount tmp2 = new WordCount("a", 0);
            if (!s.equals("0")) {
                tmp2.setWord(s);
                if (!dictionary.contains(tmp2) && !mispelled.contains(tmp2))
                    mispelled.addFirst(tmp2);
            }
        }
        //System.out.println(mispelled.toString());


        for(String s: st2.split("[^a-zA-Z_0-9]+")) {
            WordCount  help = new WordCount(s,0);
            WordCount tmp3 = new WordCount("a", 0);

            try {
                int i = Integer.parseInt(s);
            }
            catch (NumberFormatException e) {
                //System.out.println(s);

                if (!uw.contains(help)){
                    //System.out.println("entered");
                    //System.out.println(help.toString());
                    uw.addFirst(help);
                    if (dictionary.contains(help)){

                    }
                }
//                else{
//                    System.out.println("added");
//                    System.out.println(help.toString());
//                    uw.contains(help);
//                }
            }
//            if(dictionary.contains(help)) {
//                dictionary.contains(help);
//                //System.out.println(dictionary.contains(help) + " " + help.getWord());
//            }
//            tmp3.setCount(help.getCount());
//            //System.out.println(s);
//            tmp3.setWord(s);
//            //dictionary.contains(tmp3);
//
//
//
//
//            }
//            if (!s.equals("0")) {
//                if (!uw.contains(tmp3))
//                    uw.addFirst(tmp3);


        }
        //System.out.println(uw.toString());




//        WordCount b = new WordCount("has", 0);
//        System.out.println(dictionary.contains(b));



        //System.out.println(mispelled.toString());

        long endTime = System.currentTimeMillis();
        long finalTime = endTime - startTime;


        int words = text.size();
        int uniqueWords = uw.size();
        int misspelled = mispelled.size();

        File file3 = new File("/Users/quinnwheelock/IdeaProjects/csc201-proj1v2-quinnwheelock/final.dictionary.txt");
        FileWriter fw3 = new FileWriter(file3);
        PrintWriter pw3 = new PrintWriter(fw3);

        pw3.println(uw.toString());
        pw3.close();



        System.out.println("words: " + words + ", unique words: " + uniqueWords + ", misspelled: " + misspelled);
        System.out.println("Time to perform check: " + finalTime + " msec");
        System.out.println("Managed dictionary written to: final.dictionary.txt");
    }

    /**
     *  This method reads (and eventually stores) words in the dictionary file.
     *
     *  @param  filename is the dictionary filename (command line argument)
     */

    static void readDictionary(String filename, WCLinkedList dictionary) throws FileNotFoundException {
        Scanner input = new Scanner(new File(filename));
        while (input.hasNext()) {
            String line = input.nextLine();
            /* we don't want to print the words, just here for debugging */
            WordCount obj = new WordCount("a",0);
            obj.setWord(line);
            //System.out.println(obj.toString());


            dictionary.addFirst(obj);


        }
        input.close();
    }



    /**
     *  This method returns true if the command line arguments are acceptable,
     *  2 file names (Strings) must exist in args
     *
     *  @param  args list of Strings (command line arguments)
     *  @return true if the arguments are acceptable, false otherwise
     */
    private static boolean argsOK(String[] args){
        if((args.length != 2) && (args.length !=3)){
            System.out.println("Usage: java program dictionaryFile fileToCheck ");
            return false;
        }
        return true;
    }

}
