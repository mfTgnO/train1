package com.example.demo.designpattern.adapterpattern;

/**
 * @package: com.example.demo.designpattern.adapterpattern
 * @author:
 * @email:
 * @createDate: 2019-06-10 18:58
 * @description:
 */
public class Mp4Player implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        //do nothing
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: " + fileName);
    }
}