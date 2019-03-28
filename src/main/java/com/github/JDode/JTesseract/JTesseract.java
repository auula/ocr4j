package com.github.JDode.JTesseract;

import com.github.JDode.JTesseract.model.Tesseract;
import com.github.JDode.JTesseract.utils.ExecUtil;

import java.io.File;
import java.io.IOException;

/**
 * Created by Ding on 2019/3/28 4:06 PM.
 * <p>
 * <p>Application main function</p>
 * <a href="https://github.com/JDode">to see GitHub</a>
 */
public class JTesseract {

    private Tesseract tesseract;

    private ExecUtil exec;

    private File config;

    // JTesseract LOGO
    private static final String LOGOSTR = "\033[35m" + "\n" +
            "     ____.___________                                              __   \n" +
            "    |    |\\__    ___/___   ______ ______ ________________    _____/  |_ \n" +
            "    |    |  |    |_/ __ \\ /  ___//  ___// __ \\_  __ \\__  \\ _/ ___\\   __\\\n" +
            "/\\__|    |  |    |\\  ___/ \\___ \\ \\___ \\\\  ___/|  | \\// __ \\\\  \\___|  |  \n" +
            "\\________|  |____| \\___  >____  >____  >\\___  >__|  (____  /\\___  >__|  \n" +
            "                       \\/     \\/     \\/     \\/           \\/     \\/      \n " + "\033[0m";
    // JTesseract version
    private static final String VERSION = "\033[34m 1.8-SNAPSHOT\033[0m";

    //my github uri
    public static final String GITHUBURL = "https://github.com/JDode/JTesseract";

    //main
    public static void main(String[] arg) {
        System.out.print(LOGOSTR);
        System.out.printf("\033[32m Version : %s\033[0m \n", VERSION);
        System.out.printf("\033[33m  GitHub  : \033[0m %s", GITHUBURL);
        new JTesseract().start(arg);
    }

    //initialize
    private JTesseract init(Tesseract tesseract) {
        this.tesseract = tesseract;
        return this;
    }


    public String OCR() throws IOException {
        this.getExec();
        exec.exe(tesseract, config);
        return exec.putText();
    }


    public JTesseract setFile(File file) {
        this.config = file;
        return this;
    }

    private ExecUtil getExec() {
        return this.exec = new ExecUtil();
    }

    //start function
    private void start(String[] arg) {
        //获取命令行传入的参数
        if (arg.length > 0 && arg[0].equals("--help")) {
            System.out.println("\n  \n      --config  「File Path」");
            System.out.println("\n      --version  this app version");
            System.out.println("\n      --about    this Jar author information");
        }


        try {
            //这里处理--config的参数
            if (arg.length == 0 || arg[0] == null || arg[1] == null || !arg[0].equals("--config")) {
                System.err.println(" \n \033[31m Message :  Command not found （--help）\033[0m");
            } else {
                //创建对象来处理
                JTesseract jTesseract = new JTesseract().init(new Tesseract().build(arg[1])).setFile(new File(arg[2]));
                System.out.printf("\n\033[32m  OCR-Result: %s\033[0m", jTesseract.OCR());
            }
        } catch (Exception e) {
            System.err.println(" \n \033[31m 我Message :  Command not found （--help）\033[0m");
        }
    }


}

