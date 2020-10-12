# ocr4j
`ocr4j`是一个Java基于Tesseract-ocr实现的工具包`ocr4j.jar`，可以通过这个实现OCR（光学字符识别）🔥。

# 特性:
- 不需要额外安装`Tesseract`
- 不需要`tesseract.dll`
- 不需要网络
- 平台支持:`Mac`、`Linux`

# 使用示例:
```java
package test;

import me.ibyte.ocr4j.model.Tesseract;
import me.ibyte.ocr4j.standard.OpticalCharacterRecognition;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author: SDing <br/>
 * <p>
 *  测试OCR 支持Mac Linux Windows
 *  必须是64位操作系统。
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
```
# 使用其他开源项目
- [tesseract](https://github.com/tesseract-ocr/)
- [gosseract](https://github.com/otiai10/gosseract)
- [hutool](https://github.com/looly/hutool/)

