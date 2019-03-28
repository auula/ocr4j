package com.github.JDode.JTesseract;

import java.io.File;

/**
 * Created by Ding on 2019/3/28 4:06 PM.
 * <p>
 * <p>App main function</p>
 * <a href="https://github.com/JDode">to see GitHub</a>
 */
public class JTesseract {


    private static File config;

    // JTesseract LOGO
    private  final String LOGOSTR = "\033[35m" + "\n" +
            "     ____.___________                                              __   \n" +
            "    |    |\\__    ___/___   ______ ______ ________________    _____/  |_ \n" +
            "    |    |  |    |_/ __ \\ /  ___//  ___// __ \\_  __ \\__  \\ _/ ___\\   __\\\n" +
            "/\\__|    |  |    |\\  ___/ \\___ \\ \\___ \\\\  ___/|  | \\// __ \\\\  \\___|  |  \n" +
            "\\________|  |____| \\___  >____  >____  >\\___  >__|  (____  /\\___  >__|  \n" +
            "                       \\/     \\/     \\/     \\/           \\/     \\/      \n " +"\033[0m";
    // JTesseract version
    private  final String VERSION = "\033[34m 1.8-SNAPSHOT\033[0m";

    //my github uri
    public  final String GITHUBURI = "https://github.com/JDode/JTesseract";


    public static void main(String[] arg) {
        new JTesseract().init().start(arg);

    }


    private  JTesseract init(){
        System.out.print(this.LOGOSTR);
        System.out.printf("\033[32m Version : %s\033[0m \n", this.VERSION);
        System.out.printf("\033[33m  GitHub  : \033[0m %s", this.GITHUBURI);
        return this;
    }
    private void start(String[] arg){
        String[] args = arg;
        //获取命令行传入的参数
        if (args[1]==null || args[2]==null || !args[1].equals("--config")){
            System.out.println("\n\033[31m  Message :  Configuration file gets abnormal （--config [file]） \033[0m");
        }else {
            System.out.printf("\n\033[32m  OCR-Result: %s\033[0m",111);
        }
    }
}

