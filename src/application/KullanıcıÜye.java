package application;

public class Kullan�c��ye {

	private String  Adi; // bunlar� kendimiz yaz�yoruz
	private String Soyadi;
	private String Telefon;
	private String Kullan�c�Ad�;
	private String Sifre;
	
	public Kullan�c��ye()//ilk de�erlerini null yapt�k bunlar� kendimiz yazd�k
	{

    this.Adi=null;
    this.Soyadi=null;
    this.Kullan�c�Ad�=null;
    this.Sifre=null;

	} 

	
	public Kullan�c��ye(String adi, String soyadi, String telefon, String kullan�c�Ad�, String sifre) {
		super();
		Adi = adi;
		Soyadi = soyadi;
		Telefon = telefon;
		Kullan�c�Ad� = kullan�c�Ad�;
		Sifre = sifre;
	}
	public String getAdi() {
		return Adi;
	}
	public void setAdi(String adi) {
		Adi = adi;
	}
	public String getSoyadi() {
		return Soyadi;
	}
	public void setSoyadi(String soyadi) {
		Soyadi = soyadi;
	}
	public String getTelefon() {
		return Telefon;
	}
	public void setTelefon(String telefon) {
		Telefon = telefon;
	}
	public String getKullan�c�Ad�() {
		return Kullan�c�Ad�;
	}
	public void setKullan�c�Ad�(String kullan�c�Ad�) {
		Kullan�c�Ad� = kullan�c�Ad�;
	}
	public String getSifre() {
		return Sifre;
	}
	public void setSifre(String sifre) {
		Sifre = sifre;
	}

	
}
