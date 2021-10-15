package model;

public class AbstractHero extends InheritUnit {
	private int cnt = 3;

	public AbstractHero(String name, int hp, int atk, int def, int pos) {
		super(name, hp, atk, def, pos);
	}

	public int getcnt() {
		return cnt;
	}

	public void drink() {
		if (cnt > 0) {
			this.setHp(this.getHp() + 100);
			cnt--;
			System.out.println("ü���� 100ȸ�� ��");
			System.out.println("���� ü�� : " + this.getHp());
		} else {
			System.out.println("���� ����");
		}
	}

	@Override
	public void attack(InheritUnit target) {
		if (target instanceof InheritZombieKing) {
			if (((InheritZombieKing) target).getShield() > 0) {
				int dam = (this.getAtk() - target.getDef()) * (ran.nextInt(150) + 50) / 100;
				if (dam <= 0) {
					dam = 1;
				}
				System.out.println(getName() + "�� ����");
				System.out.println(dam + "�� ���� ����");
				((InheritZombieKing) target).setShield(((InheritZombieKing) target).getShield() - dam);
				if (((InheritZombieKing) target).getShield() <= 0) {
					System.out.println("���尡 �ı� �ƴ�.");
					((InheritZombieKing) target).setShield(0);
				}
				System.out.println(target.getName() + "�� ���� ü�� : " + target.getHp() + "(���� : "
						+ ((InheritZombieKing) target).getShield() + ")");
			} else {
				int dam = (this.getAtk() - target.getDef()) * (ran.nextInt(150) + 50) / 100;
				if (dam <= 0) {
					dam = 1;
				}
				System.out.println(this.getName() + "�� ����!");
				System.out.println(dam + "�� �����!");
				target.setHp(target.getHp() - dam);
				System.out.println(target.getName() + "�� ���� ü�� : " + target.getHp());
			}
		}else {
			int dam = (this.getAtk() - target.getDef()) * (ran.nextInt(150) + 50) / 100;
			if (dam <= 0) {
				dam = 1;
			}
			System.out.println(this.getName() + "�� ����!");
			System.out.println(dam + "�� �����!");
			target.setHp(target.getHp() - dam);
			System.out.println(target.getName() + "�� ���� ü�� : " + target.getHp());
		}
	}

}
