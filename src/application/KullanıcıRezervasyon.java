package application;

import javafx.scene.control.TableView.TableViewSelectionModel;

public class Kullan�c�Rezervasyon { 
private int ID;
private String anayemek; // bunlar� kendimiz yaz�yoruz
private String aperatifler;
private String icecekler;
private String tatl�lar;
 


public Kullan�c�Rezervasyon()//ilk de�erlerini null yapt�k bunlar� kendimiz yazd�k
{
	 this.ID=0;
this. anayemek=null;
 this.aperatifler=null;
 this.icecekler=null;
 this.tatl�lar=null; 


} 




public Kullan�c�Rezervasyon(int ID,String anayemek, String aperatifler, String icecekler, String tatl�lar) {
	super();// sa� t�klay�p source ordan fild
	this.ID = ID;
	this.anayemek = anayemek;
	this.aperatifler = aperatifler;
	this.icecekler = icecekler;
	this.tatl�lar = tatl�lar;
	 
  
}
public int getId() { 
	return ID;
}
public void setId(int ID) {
	this.ID = ID;
}

public String getAnayemek() {// bunlar� get-setter yapt�k a�a�� kadar olan hepsini
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
public String getTatl�lar() {
	return tatl�lar;
}
public void setTatl�lar(String tatl�lar) {
	this.tatl�lar = tatl�lar;
}




public static TableViewSelectionModel<Kullan�c�Rezervasyon> getSelectionModel() {
	// TODO Auto-generated method stub
	return null;
}











}

















/*
public class Kullan�c�Rezervasyon { 
private  int anayemek; // bunlar� kendimiz yaz�yoruz
private int aperatifler;
private int icecekler;
private int tatl�lar;

public Kullan�c�Rezervasyon()//ilk de�erlerini null yapt�k bunlar� kendimiz yazd�k
{
 anayemek=0;
 aperatifler=0;
 icecekler=0;
 tatl�lar=0;

}


public Kullan�c�Rezervasyon(int anayemek, int aperatifler, int icecekler, int tatl�lar) {
	super();
	this.anayemek = anayemek;
	this.aperatifler = aperatifler;
	this.icecekler = icecekler;
	this.tatl�lar = tatl�lar;
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

public int getTatl�lar() {
	return tatl�lar;
}

public void setTatl�lar(int tatl�lar) {
	this.tatl�lar = tatl�lar;
}

}*/
