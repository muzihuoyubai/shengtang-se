# include <stdio.h>



typedef struct Elephant {

    int heightInCM;

} Elephant;

typedef struct Fridge {

    int heightInCM;
    Elephant *elephant;

    void (*store)(Elephant *, struct Fridge *);

} Fridge;


void store(Elephant *elephantP, Fridge *fridgeP) {
    fridgeP -> elephant = elephantP;
}
Elephant createElephant(int heightInCM) {
    printf("创建一个大象，身高%dCM\n", heightInCM);
    Elephant elephant = {heightInCM};
    return elephant;
}

Fridge createFridge(int heightInCM) {
    printf("创建一个冰箱，高度%dCM\n", heightInCM);
    Fridge fridge = {heightInCM, NULL, store};
    return fridge;
}



void putinElephant(Fridge *fridge, Elephant *elephant) {
    if (elephant->heightInCM <= fridge->heightInCM) {
        printf("将%dCM高的大象关入高度为%dCM的冰箱中\n", elephant->heightInCM, fridge->heightInCM);
        fridge->store(elephant, fridge);
    } else {
        puts("大象太大了!");
    }
}

// abc 地址保存的数据在函数调用结束后会被释放掉
char *testArr() {
    char abc[] = {'a', 'b', 'c', '\0'};
    return abc;
}

int main(int argc, char const *argv[]) {

    Elephant elephant = createElephant(300);

    Fridge fridge = createFridge(500);

    putinElephant(&fridge, &elephant);
    return 0;
}








