package ooP.Interfaces.devises;

public class SmartPhone implements MusicPlayer, Phone, Camera{
    @Override
    public void takePhoto() {
        System.out.println("Took picture in smart phone ");
    }

    @Override
    public void recordvideo() {
        System.out.println("Recorded a video in smart phone ");
    }

    @Override
    public void PlayMusic() {
        System.out.println("started Playing music in smart phone ");
    }

    @Override
    public void StopMusic() {
        System.out.println("Stopped playing music in smart phone ");
    }

    @Override
    public void MakeCall(String Number) {
        System.out.println("started a call in smart phone ");
    }

    @Override
    public void EndCall() {
        System.out.println("Ended the call in smart phone ");
    }
}
