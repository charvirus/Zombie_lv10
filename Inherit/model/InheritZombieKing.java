package model;

public class InheritZombieKing extends InheritUnit {
	private int shield;

	public InheritZombieKing(String name, int hp, int atk, int def, int pos, int shield) {
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
	public void attack(InheritUnit target) {
		if (ran.nextInt(100) > 74) {
			int dam = (this.getAtk() - target.getDef()) * (ran.nextInt(150) + 50) / 100;
			if (dam <= 0) {
				dam = 1;
			}
			dam *= 2;
			System.out.println(getName() + "의 필살기");
			System.out.println(dam + "의 피해를 입힘");
			target.setHp(target.getHp() - dam);
			System.out.println(target.getName() + "의 남는 체력 : " + target.getHp());
		} else {
			int dam = (this.getAtk() - target.getDef()) * (ran.nextInt(150) + 50) / 100;
			if (dam <= 0) {
				dam = 1;
			}
			System.out.println(this.getName() + "의 공격!");
			System.out.println(dam + "의 대미지!");
			target.setHp(target.getHp() - dam);
			System.out.println(target.getName() + "의 남은 체력 : " + target.getHp());
		}
	}
	
	
	
}
