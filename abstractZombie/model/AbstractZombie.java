package model;

public class AbstractZombie extends AbstractUnit{

	public AbstractZombie(String name, int hp, int atk, int def, int pos) {
		super(name, hp, atk, def, pos);
	}

	@Override
	public void attack(AbstractUnit target) {
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
