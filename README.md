<p align="center">
    <a href="https://github.com/JDode/"><img src="https://i.loli.net/2019/03/28/5c9cbc8198068.png" width="150"/></a>
    <h1 align="center">JTesseract</h1>
</p>
<p align="center">这是基于 <code>Tesseract 光学字符识别引擎</code>  使用Java语言开发的一个OCR自然文字工具包,支持几十种语言识别😋</p>

<p align="center">
    🤩 <a href="https://github.com/JDode/JTesseract" target="_blank">仓库地址</a> | 
    🍻<a href="https://github.com/JDode/JTesseract" target="_blank">脚手架CLI下载 </a> | 
    👷 <a href="https://wpa.qq.com/msgrd?v=3&uin=2420498526&site=qq&menu=yes" target="_blank">联系作者</a> 
</p>

### 🔝置顶通知❣️

<p align="center">
 本项目是我👩‍💻个人使用业余时间独立开发的,这是依赖于世界最精准的开源光学字符识别引擎之一<code>Tesseract 光学字符识别引擎</code>开发的方便Java语言调用的工具包,可以让Java程序员在已经配置好Tesseract环境的计算机上方便调用Tesseract进行OCR进行自然文字处理。
</p>
</br>
</br>
<p align="right">By: Ding Shuo
                    2019年03月28日20:28:26</p> 

----------
### 🚀导入jar包并且使用

> 各个开发工具导入jar包不一样所以这里我准备获取录制一个视频给大家演示,调用jar代码示例👇

```java
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
        //通过脚手架生成的配置文件，传入文件地址方便程序后续使用
        String config  = "/Users/jdode/JTesseract/src/tesseract.properties";
        //实例一个JTesseract对象传入相关参数
        JTesseract init = new JTesseract().init(new Tesseract().build(config));
        //传入被识别文字的图片
        init.setFile(new File("/Users/jdode/Desktop/3.png"));
        //调用OCR方法即可看到结果,下面有预览截图
        System.out.println(init.OCR());
    }

}

```


----------


### 🤩程序预览👨‍❤️‍👨

 1.展示
 
 ![JTesseractJTesseract](https://ws2.sinaimg.cn/large/006tKfTcly1g1isgwutr1j31c00u0u0z.jpg)
 


----------


![JTesseract](https://ws3.sinaimg.cn/large/006tKfTcly1g1isbtifmjj31i60lan1q.jpg)

----------



