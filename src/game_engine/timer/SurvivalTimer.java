package game_engine.timer;

public class SurvivalTimer implements TimerStrategy{

	@Override
	public void addTime(Timer timer, double timePoint1, double timePoint2) {
		if(timer.getTimeMilliSeconds()- (timePoint2 - timePoint1) > 0)
			timer.setTime(timer.getTimeMilliSeconds() - (timePoint2 - timePoint1));
		else
			timer.setTime(0);
	}

}
