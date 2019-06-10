package com.example.demo.designpattern.adapterpattern;

/**
 * @package: com.example.demo.designpattern.adapterpattern
 * @author:
 * @email:
 * @createDate: 2019-06-10 18:58
 * @description:
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //do nothing
    }
}