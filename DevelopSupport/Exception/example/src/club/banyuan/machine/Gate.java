package club.banyuan.machine;

import java.util.Random;

public class Gate {

  private boolean isGateOpen = false;

  private Random random = new Random();

  public void openGate() throws GateException {
    isGateOpen = true;
  }

  public void closeGate() throws GateException {
    if (random.nextBoolean()) {
      throw new GateException("关门失败，门坏了");
    }
    isGateOpen = false;
  }

  public boolean isGateOpen() {
    return isGateOpen;
  }
}
