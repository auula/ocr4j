package com.github.JDode.JTesseract.model;

import com.github.JDode.JTesseract.JTesseract;
import com.github.JDode.JTesseract.utils.PropertiesUtil;

/**
 * Created by Ding on 2019/3/28 6:53 PM.
 *
 * @Description: Tesseract model
 * <p>
 * <a href="https://github.com/JDode">to see GitHub</a>
 */
public class Tesseract {

    private String work_dir = "work_dir";

    private String version = "version";

    private String language = "language";


    public Tesseract build(String url) {
        PropertiesUtil build = new PropertiesUtil().build(url);
        this.setWork_dir(build.getProperty(work_dir));
        this.setVersion(build.getProperty(version));
        this.setLanguage(build.getProperty(language).replaceAll(",","+").replaceAll(" ",""));
        return this;
    }


    @Override
    public String toString() {
        return "Tesseract{" +
                "work_dir='" + work_dir + '\'' +
                ", version='" + version + '\'' +
                ", language='" + language + '\'' +
                '}';
    }

    public String getWork_dir() {
        return work_dir;
    }

    public void setWork_dir(String work_dir) {
        this.work_dir = work_dir;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLanguage() {

        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

}
