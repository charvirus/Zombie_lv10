package controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import model.InheritHero;
import model.InheritUnit;
import model.InheritZombie;
import model.InheritZombieKing;

public class AbstractGame {
	Random ran = new Random();
	Scanner scan = new Scanner(System.in);

	private AbstractGame() {

	}

	private static AbstractGame instance = new AbstractGame();

	public static AbstractGame getInstance() {
		return instance;
	};

	private InheritHero p;
	private ArrayList<InheritUnit> enemy = new ArrayList<>();

	private void init() {
		p = new InheritHero("���", 100, 5, 1, 1);
		enemy.add(new InheritZombie("�׳�����", 25, 5, 1, 3));
		enemy.add(new InheritZombie("��������", 45, 10, 2, 6));
		enemy.add(new InheritZombie("��������", 65, 15, 3, 9));
		enemy.add(new InheritZombieKing("�����", 100, 20, 4, 12, 50));
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

	private int die(InheritUnit a) {
		if (p.getHp() <= 0) {
			return 1;
		} else if (a.getHp() <= 0) {
			return 2;
		} else {
			return 0;
		}
	}

	private boolean fight(InheritUnit enemy) {
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
			System.out.println("�¸�");
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

			map(act);
			int sel = scan.nextInt();
			if (sel == 1) {
				p.setPos(p.getPos() + 1);
				int chk = chk();
				if (chk != -1) {
					boolean a = fight(enemy.get(chk));
					if (a == false) {
						break;
					}
				} else {
					System.out.println("�ƹ��ϵ� �Ͼ�� �ʾҴ�.");
				}
				act = 1;
			} else if (sel == 2&& act == 1 ) {
				int rnum = ran.nextInt(40) + 20;
				p.setHp(p.getHp() + rnum);
				System.out.println("ü�� " + rnum + " ȸ��");
				act = 2;
			} else if (sel == 3&&act == 1) {
				int rnum = ran.nextInt(2) + 1;
				if (rnum == 1) {
					rnum = ran.nextInt(3) + 1;
					p.setAtk(p.getAtk() + rnum);
					System.out.println("���ݷ� " + rnum + " ����");
				} else if (rnum == 2) {
					rnum = ran.nextInt(3) + 1;
					p.setDef(p.getDef() + rnum);
					System.out.println("���� " + rnum + " ����");
				}
				act = 2;
			}

		}
	}
}