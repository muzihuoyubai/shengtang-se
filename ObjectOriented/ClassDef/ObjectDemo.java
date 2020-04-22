class Elephant {

    int heightInCM; //field properties


}

// 实例 instance   class => object

class Fridge {

    int heightInCM;
    Elephant store;
    // method
    void store(Elephant elephant) {
        store = elephant;
    }
}

class Main{
	public static void main(String[] args) {
		Elephant elephant = new Elephant();
		elephant.heightInCM = 300;

		Fridge fridge = new Fridge();
		fridge.heightInCM = 500;
		fridge.store(elephant);

	}
}


