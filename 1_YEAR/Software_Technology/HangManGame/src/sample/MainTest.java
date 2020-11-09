package sample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
Main HG;
    @BeforeEach
    void setUp() {
        HG =new Main();
    }

    @Test
    public void shouldReturnStringOfAnArray(){
        String[] input= {"w","o","r","d"};
        String expected = "w o r d ";

        String actual = HG.printUnderScore(input);

        assertEquals(expected,actual);


        String[] input1 = {"l","e","o"};
        String expected1 = "l e o ";

        String actual1 = HG.printUnderScore(input1);

        assertEquals(expected1,actual1);

    }

    @Test
    public void shouldReturnStringArrayOfUnderscore(){
        String [] text = {"o", "l", "a"};
        String [] expected = {"_","_","_"};

        String [] actual = HG.createUnderScore(text);
        assertArrayEquals(expected,actual);



        String [] text1 = {"p", "a", "t","o"};
        String [] expected1 = {"_","_","_","_"};

        String [] actual1 = HG.createUnderScore(text1);
        assertArrayEquals(expected1,actual1);
    }

    @Test
    public void shouldReturnTrueIfLetterIsInWord(){
    String  [] text = {"t","i","g","e","r"};
    String  prediction = "i";

    boolean expected = true;
    int pos = 1;
    boolean actual = HG.isletterinWord(prediction,pos,text);

    assertEquals(expected,actual);

    }

}