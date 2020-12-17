package application;

public class KULLANICI {
private int id;
private String ad;
private String sifre;

public KULLANICI ()
{       super(); 
	id=0;
	ad="";
	sifre="";
}

public KULLANICI(int id, String ad, String sifre) {
	
	this.id = id;
	this.ad = ad;
	this.sifre = sifre;
}




public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getAd() {
	return ad;
}
public void setAd(String ad) {
	this.ad = ad;
}
public String getSifre() {
	return sifre;
}
public void setSifre(String sifre) {
	this.sifre = sifre;
}


}
