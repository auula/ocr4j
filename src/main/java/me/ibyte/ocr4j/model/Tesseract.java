package me.ibyte.ocr4j.model;

import me.ibyte.ocr4j.standard.OpticalCharacterRecognition;

import java.io.File;
import java.io.Writer;
import java.util.Stack;

/**
 * @ Author: YMDing <br/>
 * @ Version: V1.0
 * <p>
 * Created with IDEA. Date：2020/10/11 10:08 下午
 * Tesseract 模型
 * </p>
 */
public class Tesseract implements OpticalCharacterRecognition {

    // Tesseract 字符表数据文件存放目录
    private String TessData;
    // 识别类型支持 chi_sim...
    private String[] Language;
    // 存放结果的栈
    private Stack<String> ResultStack;

    public Tesseract(String tessData, String[] language) {
        TessData = tessData;
        Language = language;
        ResultStack = new Stack<String>();;
    }

    public Tesseract() {
    }

    public String getTessData() {
        return TessData;
    }

    public void setTessData(String tessData) {
        TessData = tessData;
    }

    public String[] getLanguage() {
        return Language;
    }

    public void setLanguage(String[] language) {
        Language = language;
    }


    @Override
    public boolean init() {
        return false;
    }

    @Override
    public String scanText(File file) {
        ResultStack.push("");
        return null;
    }

    @Override
    public String scanText(String path) {
        ResultStack.push("");
        return null;
    }

    @Override
    public void otFile(Writer writer) {
        String pop = ResultStack.pop();
    }
}


