package com.mengya.game;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

public class Util {
    private static ClipboardManager _manater;
    private static Activity _activity;
    public static void init(){
        _manater = (ClipboardManager) _activity.getSystemService(Context.CLIPBOARD_SERVICE);
    }

    /*
     * 复制内容到剪切板
     * */
    public static boolean copyToClipBoard(String content){
        try {
            ClipData data = ClipData.newPlainText("com_mengya_game", content);
            _manater.setPrimaryClip(data);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static String getClipFromBoard() {
        try {
            //判断剪贴板里是否有内容
            if (!_manater.hasPrimaryClip()) {
                return "";
            }

            ClipData clip = _manater.getPrimaryClip();
            String text = clip.getItemAt(0).getText().toString();
            return text;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}