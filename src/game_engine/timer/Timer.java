package game_engine.timer;

import java.util.ArrayList;

import observer.Observer;
import observer.Subject;
import observer.TimerObserver;
import observer.TimerSubject;

public class Timer implements TimerSubject{
	private ArrayList<TimerObserver> observers ;
	private double time = 0; // inMilliSeconds
	private TimerStrategy timer;
	public Timer(String mode , double time) {
		observers = new ArrayList<>();
		this.time = time * 1000 ;
		if(mode.equalsIgnoreCase("rush")) {
			timer = new RushTimer();
		}
		else if(mode.equalsIgnoreCase("survival")) {
			timer = new SurvivalTimer();
		}
	}
	
	public void addTime(double timePoint1 , double timePoint2) {
		timer.addTime(this, timePoint1, timePoint2);
		notifyObservers();
	}
	
	public void setTime(double time) {
		this.time = time;
	}
	
	public double getTimeMilliSeconds() {
		return time;
	}
	
	public double getTimeSeconds() {
		return time/1000;
	}

	@Override
	public void addObserver(TimerObserver ob) {
		observers.add(ob);
		
	}

	@Override
	public void removeObserver(TimerObserver ob) {
		observers.remove(ob);
		
	}

	@Override
	public void notifyObservers() {
		for(TimerObserver ob :observers) {
			ob.update(time);
		}
	}
}
