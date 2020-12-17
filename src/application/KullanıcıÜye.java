package application;

public class KullanýcýÜye {

	private String  Adi; // bunlarý kendimiz yazýyoruz
	private String Soyadi;
	private String Telefon;
	private String KullanýcýAdý;
	private String Sifre;
	
	public KullanýcýÜye()//ilk deðerlerini null yaptýk bunlarý kendimiz yazdýk
	{

    this.Adi=null;
    this.Soyadi=null;
    this.KullanýcýAdý=null;
    this.Sifre=null;

	} 

	
	public KullanýcýÜye(String adi, String soyadi, String telefon, String kullanýcýAdý, String sifre) {
		super();
		Adi = adi;
		Soyadi = soyadi;
		Telefon = telefon;
		KullanýcýAdý = kullanýcýAdý;
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
	public String getKullanýcýAdý() {
		return KullanýcýAdý;
	}
	public void setKullanýcýAdý(String kullanýcýAdý) {
		KullanýcýAdý = kullanýcýAdý;
	}
	public String getSifre() {
		return Sifre;
	}
	public void setSifre(String sifre) {
		Sifre = sifre;
	}

	
}
