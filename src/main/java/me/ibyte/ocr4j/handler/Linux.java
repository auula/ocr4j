package me.ibyte.ocr4j.handler;

import cn.hutool.core.util.RuntimeUtil;
import me.ibyte.ocr4j.standard.System;

/**
 * @ Author: Ding <br/>
 * @ Version: V1.0
 * <p>
 * Linux handler
 * </p>
 */
public class Linux implements System {
    private static final String OCR_BIN = "/ocr_linux";

    private String[] cmd;

    public Linux(String lang,String path,String data) {
        String cmd = this.getClass().getResource(OCR_BIN).getPath();
        this.cmd = new String[]{cmd,"-lang",lang,"-path",path,"-data",data};
    }

    public String[] getCmd() {
        return cmd;
    }

    public void setCmd(String[] cmd) {
        this.cmd = cmd;
    }

    public String exec() {
        return RuntimeUtil.execForStr(this.getCmd());
    }
}
