package model;

import java.util.Random;

public abstract class Unit {
	Random ran = new Random();
	private String name;
	private int hp;
	private int atk;
	private int def;
	private int pos;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getAtk() {
		return atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	
	Unit(String name,int hp,int atk,int def,int pos){
		this.name = name;
		this.hp = hp;
		this.atk = atk;
		this.def = def;
		this.pos = pos;
	}
	public void attack(Unit target) {
		int dam = (this.atk - target.def)*(ran.nextInt(150)+50)/100;
		if(dam <= 0) {
			dam = 1;
		}
		System.out.println(name+"�� ����!");
		System.out.println(dam+"�� ���ظ� ����");
		target.setHp(target.getHp()-dam);
		System.out.println(target.name+"�� ���� ü�� : "+target.hp);
	}
	
	public void print() {
		System.out.println("[�̸�] : "+name+"  [ü��] : "+hp);
		System.out.println("[���ݷ�] : "+atk+" [����] : "+def+" [��ġ] : "+pos);
	}
}
