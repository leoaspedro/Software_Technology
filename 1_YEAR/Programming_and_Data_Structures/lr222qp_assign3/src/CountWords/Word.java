package CountWords;


public class Word implements Comparable<Word>{

    private String word;

    public Word(String str){
        word = str;
    }

    //Compares 2 words lexicographically
    @Override
    public int compareTo(Word w) {
        return word.compareTo(w.word);
    }

    //Compute a hash value for word
    @Override
    public int hashCode() {
        word = word.toLowerCase();
        int hc = 0;
        for(int i =0;i<word.length();i++){
            char c = word.charAt(i); //Take character of the word
            hc+=(int)c;//Take ASCII of the CHARACTER And sum it up.
            //System.out.println(c+" "+hc);
        }
        return hc;//Return the HashCode
    }

    //return true if 2 words are equal
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Word){
            Word otherWord = (Word)obj;
            return word.hashCode() == otherWord.word.hashCode();
        }
        return false;
    }


    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                '}';
    }
}

