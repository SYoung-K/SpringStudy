package board;

public class BoardAttVo {
	int serial;
	int pSerial; // board table의 serial
	String oriAtt = "";
	String sysAtt = "";
	
	public int getSerial() {
		return serial;
	}
	public void setSerial(int serial) {
		this.serial = serial;
	}
	public int getpSerial() {
		return pSerial;
	}
	public void setpSerial(int pSerial) {
		this.pSerial = pSerial;
	}
	public String getOriAtt() {
		return oriAtt;
	}
	public void setOriAtt(String oriAtt) {
		this.oriAtt = oriAtt;
	}
	public String getSysAtt() {
		return sysAtt;
	}
	public void setSysAtt(String sysAtt) {
		this.sysAtt = sysAtt;
	}
	
	
}
