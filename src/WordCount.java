public class WordCount {
    private String word;
    private int count;

    public WordCount(String word, int count){
        this.word = word;
        this.count = count;
    }
    public void setCount(int count){
        this.count = count;

    }
    public int getCount() {
        return count;
    }

    public void setWord(String word){
        this.word = word;
    }
    public String getWord(){
        return word;
    }

    public String toString(){
        String output = getWord() + " " + getCount();
        return output;
    }

    public int compareTo(WordCount wc){
        int countDiff = wc.getCount()-getCount();
        return countDiff;
    }

    public boolean equals(WordCount wc){
        boolean same = false;
        if (getWord().equals(wc.getWord()))
                same = true;
        return same;
    }
    public void incrementCount(){
        setCount(getCount()+1);

    }





}
