package club.banyuan;

public class NumberCompareResult {
    private int positionRightCount;

    private int valueRightCount;

    public int getPositionRightCount() {
        return positionRightCount;
    }
    public void setPositionRightCount(int positionRightCount) {
        this.positionRightCount = positionRightCount;
    }
    public int getValueRightCount() {
        return valueRightCount;
    }
    public void setValueRightCount(int valueRightCount) {
        this.valueRightCount = valueRightCount;
    }

    public void countOnePositionRight() {
        positionRightCount++;
        valueRightCount++;
    }

    public void countOneValueRight() {
        valueRightCount++;
    }

    boolean isSuccess() {
        return FourNumber.POSTION_TOTAL == positionRightCount;
    }

    void printResult() {
        System.out.printf("包含了%d个正确的数字\n", valueRightCount);
        if (positionRightCount == 0) {
            System.out.println("但是这些数字位置错误");
        } else {
            System.out.printf("%d个数字的位置正确 \n", positionRightCount);

        }

    }
}