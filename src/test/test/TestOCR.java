package test;

import me.ibyte.ocr4j.model.Tesseract;
import me.ibyte.ocr4j.standard.OpticalCharacterRecognition;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpCookie;
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
        Tesseract tesseract = new Tesseract();
        //tesseract.init();
        OpticalCharacterRecognition ocr = tesseract.NewOCR();
        String text = ocr.scanText("");
        System.out.println(text);
        // 此方法返回一个file方便你后续操作
        File file = ocr.toFile("");
        // 你也可以通过writer来实现其他类型的存储
        ocr.writer(new FileWriter(new File("")));
    }
}
