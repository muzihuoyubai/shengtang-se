package club.banyuan;

public class TimerImpl implements Timer {

  long startTime;
  long endTime;
  boolean isStart;


  @Override
  public void start() throws IllegalStateException {
    if (isStart) {
      throw new IllegalStateException();
    }
    reset();
    startTime = System.currentTimeMillis();
    isStart = true;
  }

  @Override
  public void stop() throws IllegalStateException {
    if (!isStart) {
      throw new IllegalStateException();
    }
    endTime = System.currentTimeMillis();
    isStart = false;
  }

  @Override
  public void reset() {
    startTime = 0;
    endTime = 0;
    isStart = false;
  }

  @Override
  public long getTimeMillisecond() {
    return endTime - startTime;
  }
}
