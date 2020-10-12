package me.ibyte.ocr4j.standard;


import java.io.File;
import java.io.Writer;

// Optical Character Recognition
public interface OpticalCharacterRecognition {

    // 传入文件路径扫描
    String scanText(String filepath);
    // Writer接口
    void writer(Writer writer);

}
