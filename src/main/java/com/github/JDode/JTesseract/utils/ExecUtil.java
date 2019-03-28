package com.github.JDode.JTesseract.utils;

import com.github.JDode.JTesseract.model.Tesseract;

import java.io.*;

/**
 * Created by Ding on 2019/3/28 7:06 PM.
 *
 * @Description: cmd 或者 shell命令执行工具类
 * <p>
 * <a href="https://github.com/JDode">to see GitHub</a>
 */
public class ExecUtil {

    private long timess;

    private String cmd;

    private String result;

    public String getResult() {
        return result;
    }

    public boolean exe(Tesseract tesseract, File file) {
        timess = System.currentTimeMillis();
        cmd = "tesseract" + " -l" + " " + tesseract.getLanguage() + " " + file.getPath() + " ./" + timess;
        StringBuilder sb = new StringBuilder();
        try {
            Process proc = Runtime.getRuntime().exec(this.cmd);
            InputStream inputStream = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(inputStream);
            //用缓冲器读行
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            //直到读完为止
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            result = sb.toString();
            if (result != null) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    public String putText()  {
        StringBuilder sb = new StringBuilder();
        BufferedReader buffReader = null;
        try {
            String fileurl = System.getProperty("user.dir") + "/" + timess + ".txt";
            File file = new File(fileurl);
            FileInputStream fin = new FileInputStream(file.getPath());
            InputStreamReader reader = new InputStreamReader(fin);
            buffReader = new BufferedReader(reader);
            String strTmp = "";
            while ((strTmp = buffReader.readLine()) != null) {
                sb.append(strTmp);
            }
            if (file.isFile()) {
                file.delete();
            }
            return new String(sb);
        } catch (IOException e) {
            sb.append("图片文件处理异常~"+e.getMessage());
            //e.printStackTrace();
        } finally {
            if (buffReader != null) {
                try {
                    buffReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new String(sb);
    }
}
