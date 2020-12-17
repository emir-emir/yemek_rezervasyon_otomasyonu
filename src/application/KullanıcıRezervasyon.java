package application;

import javafx.scene.control.TableView.TableViewSelectionModel;

public class KullanýcýRezervasyon { 
private int ID;
private String anayemek; // bunlarý kendimiz yazýyoruz
private String aperatifler;
private String icecekler;
private String tatlýlar;
 


public KullanýcýRezervasyon()//ilk deðerlerini null yaptýk bunlarý kendimiz yazdýk
{
	 this.ID=0;
this. anayemek=null;
 this.aperatifler=null;
 this.icecekler=null;
 this.tatlýlar=null; 


} 




public KullanýcýRezervasyon(int ID,String anayemek, String aperatifler, String icecekler, String tatlýlar) {
	super();// sað týklayýp source ordan fild
	this.ID = ID;
	this.anayemek = anayemek;
	this.aperatifler = aperatifler;
	this.icecekler = icecekler;
	this.tatlýlar = tatlýlar;
	 
  
}
public int getId() { 
	return ID;
}
public void setId(int ID) {
	this.ID = ID;
}

public String getAnayemek() {// bunlarý get-setter yaptýk aþaðý kadar olan hepsini
	return anayemek;
}
public void setAnayemek(String anayemek) {
	this.anayemek = anayemek;
}

public String getAperatifler() {
	return aperatifler;
}
public void setAperatifler(String aperatifler) {
	this.aperatifler = aperatifler;
}
public String getIcecekler() {
	return icecekler;
}
public void setIcecekler(String icecekler) {
	this.icecekler = icecekler;
}
public String getTatlýlar() {
	return tatlýlar;
}
public void setTatlýlar(String tatlýlar) {
	this.tatlýlar = tatlýlar;
}




public static TableViewSelectionModel<KullanýcýRezervasyon> getSelectionModel() {
	// TODO Auto-generated method stub
	return null;
}











}

















/*
public class KullanýcýRezervasyon { 
private  int anayemek; // bunlarý kendimiz yazýyoruz
private int aperatifler;
private int icecekler;
private int tatlýlar;

public KullanýcýRezervasyon()//ilk deðerlerini null yaptýk bunlarý kendimiz yazdýk
{
 anayemek=0;
 aperatifler=0;
 icecekler=0;
 tatlýlar=0;

}


public KullanýcýRezervasyon(int anayemek, int aperatifler, int icecekler, int tatlýlar) {
	super();
	this.anayemek = anayemek;
	this.aperatifler = aperatifler;
	this.icecekler = icecekler;
	this.tatlýlar = tatlýlar;
}


public int getAnayemek() {
	return anayemek;
}

public void setAnayemek(int anayemek) {
	this.anayemek = anayemek;
}

public int getAperatifler() {
	return aperatifler;
}

public void setAperatifler(int aperatifler) {
	this.aperatifler = aperatifler;
}

public int getIcecekler() {
	return icecekler;
}

public void setIcecekler(int icecekler) {
	this.icecekler = icecekler;
}

public int getTatlýlar() {
	return tatlýlar;
}

public void setTatlýlar(int tatlýlar) {
	this.tatlýlar = tatlýlar;
}

}*/
