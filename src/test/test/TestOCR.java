package test;

import me.ibyte.ocr4j.model.Tesseract;
import me.ibyte.ocr4j.standard.OpticalCharacterRecognition;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @ Author: YMDing <br/>
 * <p>
 * 测试OCR
 * </p>
 */

public class TestOCR {
    @Test
    public void Test() throws IOException {
        // 创建tesseract
        Tesseract tesseract = new Tesseract();
        // 设置语言
        tesseract.setLanguage(new String[]{"chi_sim","eng"});
        // 设置字符模型目录
        tesseract.setTessData("/Users/ding/Desktop/tessdata");
        // 创建ocr
        OpticalCharacterRecognition ocr = tesseract.newOCR();
        // 需要识别的图片
        String text = ocr.scanText("/Users/ding/Desktop/test.png");
        // 打印识别结果内容
        System.out.println(text);
        // 你也可以通过writer来实现其他类型的存储
        ocr.writer(new FileWriter(new File("/Users/ding/Documents/ocr4j/src/main/resources/1.txt")));
    }
}
