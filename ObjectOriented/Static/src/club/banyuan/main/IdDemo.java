package club.banyuan.main;

import club.banyuan.animal.Elephant;

public class IdDemo{

	public static void main(String[] args){
		Elephant e1 = new Elephant(300);
		System.out.println("lastId=" + Elephant.getLastId());

		Elephant e2 = new Elephant();
		System.out.println("lastId=" + Elephant.getLastId());
	}

}