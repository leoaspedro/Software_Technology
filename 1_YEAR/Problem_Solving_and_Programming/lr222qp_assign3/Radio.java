package lr222qp_assign3;

public class Radio {
private int channel;
private int volume;
private boolean on;

public 	Radio() {
	on = false;
	channel = 1;
	volume = 1;
	
}
public String getSettings() {
	String text="Settings: On "+on+", Channel "+channel+", Volume "+volume;
	return text;
}
public void turnOn() {
	on =true;
	}
public void turnOff() {
	on = false;
	channel = 1;
	volume = 1;
	
}
public void setVolume(int newVolume) {
	if(newVolume<=5 & newVolume>0) {
	volume = newVolume;
	}
	else {
		System.err.println("Volume out of range, provide volume between [0,5].");
	}
}
public void volumeUp() {
	if(on=true) {
	volume = volume +1;
	}
	else {
		System.err.println("Turn on the radio in order to adjust the volume.");
	}
	}
public void volumeDown() {
	if(on=true) {
	volume -=1;
}
    else {
	System.err.println("Turn on the radio in order to adjust the volume.");
    }
}
public void setChannel(int newChannel) {
	if(newChannel<=10 & newChannel>=1) {
	channel = newChannel;
	}
	else {
		System.err.println("Channel out of range, provide a channel between [1,10].");
	}
}
public void channelUp() {
	if(on=true) {
	channel+=1;
	}
	else {
		System.err.println("Turn on the radio in order to adjust the channel.");	
	}
}
public void channelDown() {
	if(on=true) {
	channel-=1;
	}
	else {
		System.err.println("Turn on the radio in order to adjust the channel.");
	}
}

}
