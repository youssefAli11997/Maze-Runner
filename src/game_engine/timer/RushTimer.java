package game_engine.timer;

public class RushTimer implements TimerStrategy{

	@Override
	public void addTime(Timer timer, double timePoint1, double timePoint2) {
		timer.setTime(timer.getTimeMilliSeconds()+(timePoint2-timePoint1));
	}

}
