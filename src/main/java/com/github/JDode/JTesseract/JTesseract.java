package com.github.JDode.JTesseract;

import com.github.JDode.JTesseract.model.Tesseract;
import com.github.JDode.JTesseract.utils.ExecUtil;

import java.io.File;

/**
 * Created by Ding on 2019/3/28 4:06 PM.
 * <p>
 * <p>Application main function</p>
 * <a href="https://github.com/JDode">to see GitHub</a>
 */
public class JTesseract {

    private Tesseract tesseract;

    private final ExecUtil exec = new ExecUtil();

    private File file;

    // JTesseract LOGO
    private  final String LOGOSTR = "\033[35m" + "\n" +
            "     ____.___________                                              __   \n" +
            "    |    |\\__    ___/___   ______ ______ ________________    _____/  |_ \n" +
            "    |    |  |    |_/ __ \\ /  ___//  ___// __ \\_  __ \\__  \\ _/ ___\\   __\\\n" +
            "/\\__|    |  |    |\\  ___/ \\___ \\ \\___ \\\\  ___/|  | \\// __ \\\\  \\___|  |  \n" +
            "\\________|  |____| \\___  >____  >____  >\\___  >__|  (____  /\\___  >__|  \n" +
            "                       \\/     \\/     \\/     \\/           \\/     \\/      \n " + "\033[0m";
    // JTesseract version
    private  final String VERSION = "\033[34m 1.8-SNAPSHOT\033[0m";

    //my github uri
    public  final String GITHUBURL = "https://github.com/JDode/JTesseract";

    //main
    public static void main(String[] arg) {
        new JTesseract().menu().start(arg);
    }

    //initialize
    public JTesseract init(Tesseract tesseract) {
        this.tesseract = tesseract;
        return this;
    }
    //menu
    private JTesseract menu(){
        System.out.print(this.LOGOSTR);
        System.out.printf("\033[32m Version : %s\033[0m \n", VERSION);
        System.out.printf("\033[33m  GitHub  : \033[0m %s", GITHUBURL);
        return this;
    }
    //OCR
    public String OCR()  {
        exec.exe(tesseract, file);
        return exec.putText();
    }

    //设置需要处理的图片文件
    public void setFile(File file) {

        this.file = file;

    }




    //start function
    private void start(String[] arg) {
        //获取命令行传入的参数
        if (arg.length > 0 && arg[0].equals("--help")) {
            System.out.println("\n      --version  this app version");
            System.out.println("\n      --about    this Jar author information");
        }

    }


}

