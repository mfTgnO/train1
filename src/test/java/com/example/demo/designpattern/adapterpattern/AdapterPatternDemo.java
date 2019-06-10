package com.example.demo.designpattern.adapterpattern;

/**
 * @package: com.example.demo.designpattern.adapterpattern
 * @author:
 * @email:
 * @createDate: 2019-06-10 18:59
 * @description: https://www.tutorialspoint.com/design_pattern/adapter_pattern.htm
 */
public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}
