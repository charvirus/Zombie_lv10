package controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import model.Hero;
import model.Unit;
import model.Zombie;
import model.ZombieKing;

public class Game {
	Random ran = new Random();
	Scanner scan = new Scanner(System.in);

	private Game() {

	}

	private static Game instance = new Game();

	public static Game getInstance() {
		return instance;
	};

	private Hero p;
	private ArrayList<Unit> enemy = new ArrayList<>();

	private void init() {
		p = new Hero("���", 100, 5, 1, 1);
		enemy.add(new Zombie("�׳�����", 25, 5, 1, 3));
		enemy.add(new Zombie("��������", 45, 10, 2, 6));
		enemy.add(new Zombie("��������", 65, 15, 3, 9));
		enemy.add(new ZombieKing("�����", 100, 20, 4, 12, 50));
	}

	private int chk() {
		for (int i = 0; i < enemy.size(); i++) {
			if (p.getPos() == enemy.get(i).getPos()) {
				System.out.println("���� ����");
				return i;
			}
		}
		return -1;
	}

	private int die(Unit a) {
		if (p.getHp() <= 0) {
			return 1;
		} else if (a.getHp() <= 0) {
			return 2;
		} else {
			return 0;
		}
	}

	private boolean fight(Unit enemy) {
		while (true) {
			p.print();
			System.out.println("==== VS ====");
			enemy.print();
			System.out.println("------------");
			System.out.println("[������ �ұ�?]");
			System.out.println("1. ���� \t2. ����(" + p.getcnt() + ")");
			int sel = scan.nextInt();
			if (sel == 1) {
				p.attack(enemy);
			} else if (sel == 2) {
				p.drink();
			}
			if (die(enemy) != 0) {
				break;
			}
			System.out.println();
			enemy.attack(p);
			if (die(enemy) != 0) {
				break;
			}
			System.out.println();
		}
		if (die(enemy) == 1) {
			System.out.println("���");
			return false;
		} else {
			System.out.println("����");
			return true;
		}
	}

	private void map(int a) {
		System.out.println("[ ���� �� : " + p.getPos() + "]");
		System.out.println("[1] : �ö󰣴�");
		if (a == 1) {
			System.out.println("[2] : ü�� ȸ��");
			System.out.println("[3] : ���� ��ȭ");
		}
	}

	public void run() {
		init();
		int act = 1;
		while (true) {
			if (p.getPos() >= 12) {
				System.out.println("�����ߴ�.");
				break;
			}
		}
		map(act);
		int sel = scan.nextInt();
		if (sel == 1) {
			p.setPos(p.getPos() + 1);
			int chk = chk();
			if (chk != -1) {
				boolean a = fight(enemy.get(chk));
			}
		}

	}
}
