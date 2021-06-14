package di.step4;
  // step4 까지 spring을 사용하지 않고 DI생성.

public class Distep4Main {
	
	DB db;
	public void abc(DB db) {
		this.db = db;
		this.db.run();
	}
	
	public static void main(String[] args) {
		Assembler ass = new Assembler();
		Distep4Main m = new Distep4Main();
		m.abc(ass.getDb());
	}
}


