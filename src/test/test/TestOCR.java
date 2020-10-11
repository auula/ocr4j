package test;

import me.ibyte.ocr4j.model.Tesseract;
import me.ibyte.ocr4j.standard.OpticalCharacterRecognition;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

/**
 * @ Author: YMDing <br/>
 * <p>
 * 测试OCR
 * </p>
 */

public class TestOCR {
    @Test
    public void Test() throws IOException {
        OpticalCharacterRecognition ocr = new Tesseract();
        String text = ocr.scanText("");
        ocr.otFile(new FileWriter(new File("")));
    }
}
