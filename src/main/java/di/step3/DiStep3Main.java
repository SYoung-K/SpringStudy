package di.step3;

public class DiStep3Main {

//	Oracle o;
//	public DiStep3Main(Oracle o) {
//		this.o = o;
//	}
	
	
	DB db;
	public DiStep3Main(DB db) {
		this.db = db;
		db.run();
	}
	
	public static void main(String[] arg) {
		Mysql o = new Mysql();
		
		DiStep3Main m = new DiStep3Main(o);
		
	}
	
	
}
