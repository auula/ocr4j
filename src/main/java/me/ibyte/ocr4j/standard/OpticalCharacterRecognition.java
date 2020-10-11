package me.ibyte.ocr4j.standard;


import java.io.File;
import java.io.Writer;

// Optical Character Recognition
public interface OpticalCharacterRecognition {
    // 检测系统是否安装组件
    boolean init();
    // 传入文件扫描
    String scanText(File file);
    // 传入文件路径扫描
    String scanText(String filepath);
    // 将扫描结果返回到一个文件里
    void otFile(Writer writer);

}
