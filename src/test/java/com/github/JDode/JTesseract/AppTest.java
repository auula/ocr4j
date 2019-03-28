package com.github.JDode.JTesseract;

import static org.junit.Assert.assertTrue;

import com.github.JDode.JTesseract.model.Tesseract;
import org.junit.Test;

import java.io.File;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void  test01(){
        String config  = "/Users/jdode/JTesseract/src/tesseract.properties";
        JTesseract init = new JTesseract().init(new Tesseract().build(config));
        init.setFile(new File("/Users/jdode/Desktop/3.png"));
        System.out.println(init.OCR());
    }

}
