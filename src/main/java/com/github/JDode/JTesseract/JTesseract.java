package com.github.JDode.JTesseract;

/**
 * Created by Ding on 2019/3/28 4:06 PM.
 * <p>
 * <p>App main function</p>
 * <a href="https://github.com/JDode">to see GitHub</a>
 */
public class JTesseract {

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

    public static void main(String[] args) {
        new JTesseract().init().start();

    }


    private  JTesseract init(){
        System.out.print(this.LOGOSTR);
        System.out.printf("\033[32m Version : %s\033[0m \n", this.VERSION);
        System.out.printf("\033[33m  GitHub  : \033[0m %s", this.GITHUBURI);
        return this;
    }
    private JTesseract start(){
        System.out.println("\n\033[31m  Message :  配置文件获取异常 --config [file] \033[0m");
        System.out.printf("\n\033[32m  OCR-Result: %s\033[0m",111);
        return this;
    }
}

