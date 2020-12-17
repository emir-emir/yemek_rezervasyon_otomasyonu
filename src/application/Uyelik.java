package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.IsteMysql.Util.VeritabaniUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;




public class Uyelik {
	String sql; 
	Connection baglanti=null;
	PreparedStatement sorguIfadesi=null;
	ResultSet getirilen = null;
	public Uyelik() {
	baglanti=VeritabaniUtil.Baglan();}
    @FXML
    private Button btn_kaydol;
 
    @FXML
    private Button btn_anaekran;

    @FXML
    private TextField TXT1;

    @FXML
    private TextField TXT2;

    @FXML
    private TextField TXT3;

    @FXML
    private TextField TXT4;

    @FXML
    private TextField TXT5;

    @FXML
    private Label Lbl_sonuc;

    @FXML
    void btn_AnaEkran(ActionEvent event) throws IOException {
    	Stage appStage;
        Parent root;
        
        
         
       appStage=(Stage)btn_anaekran.getScene().getWindow();
       root =FXMLLoader.load(getClass().getResource("Sahne1.fxml"));

       Scene scene=new Scene(root);
        appStage.setScene(scene);
     
        appStage.show();
    }

    @FXML
    void btn_Kaydol(ActionEvent event) {
    	  sql="insert into login(ad,soyad,telefon,kul_ad,sifre) values(?,?,?,?,?)";
      	try {
      		sorguIfadesi=baglanti.prepareStatement(sql);
      	
      		sorguIfadesi.setString(1, TXT1.getText().trim());
          	sorguIfadesi.setString(2, TXT2.getText().trim());
          	sorguIfadesi.setString(3, TXT3.getText().trim());
          	sorguIfadesi.setString(4, TXT4.getText().trim());
          	sorguIfadesi.setString(5, TXT5.getText().trim());
          	
          	
          	sorguIfadesi.executeUpdate();
          	Lbl_sonuc.setText("Ekleme iþlemi baþarýlý");
          	
      
          	
      	}  
      	catch (Exception e) {
      		 
      		Lbl_sonuc.setText(e.getMessage().toString());
               
      	}

    }

}

    
    	

