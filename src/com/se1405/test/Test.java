package com.se1405.test;

import java.util.Random;
import java.util.Scanner;

import com.se1405.beans.User;
import com.se1405.beans.Turn;
import com.se1405.components.NLG;

class Client extends Thread{
	public void run(){
		NLG nlg = new NLG();
		String utterance;
		Scanner sc = new Scanner(System.in);
		String response;
		User user = new User(new Random().nextInt());
		Turn turn;
		while(true) {
			utterance = sc.nextLine();
			turn = new Turn(user, utterance);
			response = nlg.nlg(turn);
			System.out.println(response);
		}
	}
}

public class Test {
	public static void main(String[] args) {
		Client c1 = new Client();
//		Client c2 = new Client();
		c1.start();
//		c2.start();
	}
}
