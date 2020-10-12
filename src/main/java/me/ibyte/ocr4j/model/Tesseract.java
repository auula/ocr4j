package me.ibyte.ocr4j.model;

import cn.hutool.system.SystemUtil;
import me.ibyte.ocr4j.handler.Linux;
import me.ibyte.ocr4j.handler.Mac;
import me.ibyte.ocr4j.handler.Windows;
import me.ibyte.ocr4j.standard.OpticalCharacterRecognition;
import me.ibyte.ocr4j.standard.System;

import java.io.IOException;
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
    private final Stack<String> ResultStack;

    private System Sys;

    public Tesseract(String tessData, String[] language) {
        TessData = tessData;
        Language = language;
        ResultStack = new Stack<String>();
    }

    public OpticalCharacterRecognition newOCR(){
        return this;
    }

    public Tesseract() {
        ResultStack = new Stack<String>();
        ResultStack.push("1");
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

    public String scanText(String filepath) {
        StringBuffer sb = new StringBuffer();
        for (String s : this.Language) {
            sb.append(s);
            sb.append(",");
        }
        if (SystemUtil.getOsInfo().isMac()) {
            this.Sys = new Mac(sb.toString(),filepath,this.getTessData());
        }
        if (SystemUtil.getOsInfo().isLinux()) {
            this.Sys = new Linux(sb.toString(),filepath,this.getTessData());
        }
        if (SystemUtil.getOsInfo().isWindows()) {
            this.Sys = new Windows(sb.toString(),filepath,this.getTessData());
        }
        String s = this.Sys.exec();
        ResultStack.push(s);
        return s;
    }

    public void writer(Writer writer) {
        try {
            writer.write(this.ResultStack.pop());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


