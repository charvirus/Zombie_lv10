package model;

public class AbstractZombieKing extends AbstractUnit {
	private int shield;

	public AbstractZombieKing(String name, int hp, int atk, int def, int pos, int shield) {
		super(name, hp, atk, def, pos);
		this.shield = shield;
	}

	public int getShield() {
		return shield;
	}

	public void setShield(int shield) {
		this.shield = shield;
	}

	@Override
	public void attack(AbstractUnit target) {
		if (ran.nextInt(100) > 74) {
			int dam = (this.getAtk() - target.getDef()) * (ran.nextInt(150) + 50) / 100;
			if (dam <= 0) {
				dam = 1;
			}
			dam *= 2;
			System.out.println(getName() + "�� �ʻ��");
			System.out.println(dam + "�� ���ظ� ����");
			target.setHp(target.getHp() - dam);
			System.out.println(target.getName() + "�� ���� ü�� : " + target.getHp());
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
	}
	
	
	
}
