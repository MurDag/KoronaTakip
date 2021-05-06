package application;

import java.net.URL;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


public class SampleController implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchor1;

    @FXML
    private Button sorgula;

    @FXML
    private Button ekle;

    @FXML
    private TableView<hastakayit> tableview;

    @FXML
    private TableColumn<hastakayit, Integer> id;

    @FXML
    private TableColumn<hastakayit, String> hasta_adi;

    @FXML
    private TableColumn<hastakayit, String> memleket;

    @FXML
    private TableColumn<hastakayit, String> meslek;

    @FXML
    private TableColumn<hastakayit, String> cinsiyet;

    @FXML
    private TableColumn<hastakayit, String> ates;

    @FXML
    private TableColumn<hastakayit, String> teshis;
    
    @FXML
    private TableColumn<hastakayit, String> tarih;
    
    @FXML
    private BarChart<String, Integer> grafik;

    @FXML
    private CategoryAxis grafik_sehir;

    @FXML
    private PieChart grafik2;

    @FXML
    private Button sil;

    @FXML
    private Button guncelle;

    @FXML
    private TextField hasta_adi_text;

    @FXML
    private TextField ates_text;

    @FXML
    private TextField meslek_text;

    @FXML
    private Slider slider_ates;
    
    @FXML
    private ComboBox<String> sehirler;
    
    @FXML
    private Label lbl_atesdegeri;
    
    @FXML
    private ToggleGroup cns;

    @FXML
    private ToggleGroup ms;
    
    @FXML
    private CheckBox check_teshis;
    
    
    
    @FXML
    private DatePicker islem_tarih1;

    @FXML
    private DatePicker islem_tarih2;
    
    @FXML
    private NumberAxis grafik_deger;
    
    @FXML
    private Button show;
    
  
    
 
    
    
    
    String hasta_ad;
    String sehir;
    String atess;
    String tshs;
    String column_cinsiyet;
    String column_meslek;
    LocalDate tarihh;
    int sayac=0;
    int sayac2=0;
   
    ObservableList<hastakayit> hasta=FXCollections.observableArrayList();
     
    	public int ankaraHastaSayisi=0;
        public int istanbulHastaSayisi=0;
        public int izmirHastaSayisi=0;
        public int hatayHastaSayisi=0;
        public int antalyaHastaSayisi=0;
        
        public double ankaraAtes=0;
        public double istanbulAtes=0;
        public double izmirAtes=0;
        public double hatayAtes=0;
        public double antalyaAtes=0;
        
         
        private ObservableList<String> sehirlerim = FXCollections.observableArrayList("Ankara","Ýstanbul","Ýzmir","Hatay","Antalya"); 
        
        @FXML
        void grafik2_click(MouseEvent event) {
        	
        	int ankaraindex=0;
        	int istanbulindex=0;
        	int izmirindex=0;
        	int hatayindex=0;
        	int antalyaindex=0;
        	
            for(hastakayit hast : tableview.getItems())
            {
            	
           		
           		 if(hast.getMemleket().equalsIgnoreCase("Ankara") && hast.getTeshis().equalsIgnoreCase("POZÝTÝF"))
           		 {
           			ankaraindex++;
           			
           			
           		 }
           		 if(hast.getMemleket().equalsIgnoreCase("Ýstanbul") && hast.getTeshis().equalsIgnoreCase("POZÝTÝF"))
           		 {
           			istanbulindex++;
           			
           			
           		 }
           		 if(hast.getMemleket().equalsIgnoreCase("Ýzmir") && hast.getTeshis().equalsIgnoreCase("POZÝTÝF"))
           		 {
           			izmirindex++;
           			
           			
           		 }
           		if(hast.getMemleket().equalsIgnoreCase("Hatay") && hast.getTeshis().equalsIgnoreCase("POZÝTÝF"))
          		 {
           			hatayindex++;
          			
          			
          		 }
           		if(hast.getMemleket().equalsIgnoreCase("Antalya") && hast.getTeshis().equalsIgnoreCase("POZÝTÝF"))
          		 {
           			antalyaindex++;
          			
          			
          		 }
           		 
           	 
           	 
           	 
            }
        	
        	
        	ObservableList<PieChart.Data> pieChartData =
        			FXCollections.observableArrayList( new PieChart.Data("Ankara", (ankaraindex*100)/5),
        					new PieChart.Data("Ýstanbul", (istanbulindex*100)/5),
        					new PieChart.Data("Ýzmir", (izmirindex*100)/5),
        					new PieChart.Data("Hatay", (hatayindex*100)/5),
        					new PieChart.Data("Antalya", (antalyaindex*100)/5));
        	final PieChart chart = new PieChart(pieChartData);
        	grafik2.setTitle("Hasta Sayýlarý"); 
        	grafik2.setData(pieChartData);
        	
        	
        	
       	

        }
        
        
    @FXML
    void ekle_click(ActionEvent event) {
    	

    	hasta_ad=hasta_adi_text.getText();
    	sehir =sehirler.getValue().toString();
    	 atess = lbl_atesdegeri.getText(); 
    	RadioButton cins = (RadioButton) cns.getSelectedToggle();
    	column_cinsiyet=cins.getText();
    	
    	RadioButton mslk = (RadioButton) ms.getSelectedToggle();
    	column_meslek=mslk.getText();
    	tshs=check_teshis.getText();
    	
    	
    	hasta.add(new hastakayit(sayac2,hasta_ad,sehir,column_meslek,column_cinsiyet,atess,tshs,tarihh));
    	

		Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Uyarý!");
    	alert.setHeaderText("Kayýt Baþarýlý Bir Þekilde Eklendi");
    	ButtonType tip1= new ButtonType("Kapat");	
    	
    	alert.getButtonTypes().setAll(tip1);
    	
    	alert.showAndWait();
    	
    	tableview.refresh();
    	
    	
    	
    	
    	
    	sayac2++;

    }
    
    
    

    @FXML
    void check_teshis_click(ActionEvent event) {
    	sayac++;
    	if(sayac%2==1)
    	{
    		check_teshis.setText("Pozitif");
    	}
    	if(sayac%2==0)
    	{
    		check_teshis.setText("Negatif");
    	}
    	
    	
    	
    }
    
    

    @FXML
    void guncelle_click(ActionEvent event) {
    	
    	hastakayit hasta=tableview.getSelectionModel().getSelectedItem();
    	
    	String hastaAdi=hasta_adi_text.getText();    	
    	RadioButton meslek=(RadioButton) ms.getSelectedToggle();
    	String hastaMeslek=meslek.getText();
    	String hastaSehir=sehirler.getSelectionModel().getSelectedItem().toString();
    	RadioButton cinsiyet=(RadioButton) cns.getSelectedToggle();
    	String hastaCinsiyet=cinsiyet.getText();
    	String hastaTeshis;
    	if(check_teshis.isSelected())
    	{
    		hastaTeshis="Pozitif";
    	}
    	else
    	{
    		hastaTeshis="Negatif";
    	}
    	
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Uyarý");
    	alert.setHeaderText("Seçili olan kaydý deðiþtiriyorsunuz !");
    	alert.setContentText("Gerçekten deðiþtirmek istiyor musunuz?");
    	ButtonType tip1= new ButtonType("Evet");
    	ButtonType tip2= new ButtonType("Hayýr");
    	
    	alert.getButtonTypes().setAll(tip1,tip2);
    	
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get()==tip1) {
    		
    		hasta.setAdsoyad(hastaAdi);
        	
        	hasta.setMeslek(hastaMeslek);
        	hasta.setMemleket(hastaSehir);
        	hasta.setCinsiyet(hastaCinsiyet);
        	hasta.setTeshis(hastaTeshis);
        	hasta.setAtes(lbl_atesdegeri.getText());
													}
    	
    	tableview.refresh();

    }

    @FXML
    void sil_click(ActionEvent event) {
    	
    	
    	
    	
    	
    	
    	
    	hastakayit hasta1=tableview.getSelectionModel().getSelectedItem();
    	

    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Uyarý");
    	alert.setHeaderText("Seçili olan kaydý siliyorsunuz !");
    	alert.setContentText("Gerçekten silmek istiyormusunuz ?");
    	ButtonType tip1= new ButtonType("Evet");
    	ButtonType tip2= new ButtonType("Hayýr");
    	
    	alert.getButtonTypes().setAll(tip1,tip2);
    	
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get()==tip1) {
    		hasta.remove(hasta1);
		}
    	else {
    		
    		
    	}
    	
    	tableview.refresh();

    }

    @FXML
    void sorgula_click(ActionEvent event) {
    	   	
    	
    	double toplam=0;
        int sayi=0;
        
        for(hastakayit hast : tableview.getItems())
        {
       	 if(hast.getMemleket().equalsIgnoreCase(sehirler.getSelectionModel().getSelectedItem()) && hast.getTeshis().equalsIgnoreCase("POZÝTÝF"))
       	 {
       		double ifade1 = Double.valueOf(hast.getAtes());
       		 toplam+=ifade1;
       		 ++sayi;
       		 if(hast.getMemleket().equalsIgnoreCase("Ankara"))
       		 {
       			ankaraHastaSayisi++;
       			
       		 }
       		 
       	 }
       	 
       	 
        }
        
        
       
        
        Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Þehir Durumlarý");
    	alert.setHeaderText(sehirler.getValue().toString()+" Þehrindeki ;");
    	alert.setContentText("Hastalarýn Sayýsý : "+sayi+"\nPozitif Vakalarýn Ateþ Ortalamasý : "+toplam/sayi);
    	alert.showAndWait();

    }
 
    
    
    public void DegerleriGetir(TableView<hastakayit> tableview)
    {
    	
    	
    	
    	try {
			
    		
			
			
			

			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
    	
    }
    
    @FXML
    void islem_tarih1_click(ActionEvent event) {
    	
    	
    	   
    		LocalDate TarihC= islem_tarih1.getValue();    
    		tarihh=TarihC;
    		 
    		
    	 	
    
    }
    	
    
    
    public void setPersonData(List<hastakayit> persons) { 
    	
    		
  	
    		
    		               
    		        
    		        
    		       
    		
    		
    }
    
    @FXML
    void grafik_click(MouseEvent event) {
    	
    	int ankaraindex=0;
    	int istanbulindex=0;
    	int izmirindex=0;
    	int hatayindex=0;
    	int antalyaindex=0;
    	
        for(hastakayit hast : tableview.getItems())
        {
        	
       		
       		 if(hast.getMemleket().equalsIgnoreCase("Ankara") && hast.getTeshis().equalsIgnoreCase("POZÝTÝF"))
       		 {
       			ankaraindex++;
       			
       			
       		 }
       		 if(hast.getMemleket().equalsIgnoreCase("Ýstanbul") && hast.getTeshis().equalsIgnoreCase("POZÝTÝF"))
       		 {
       			istanbulindex++;
       			
       			
       		 }
       		 if(hast.getMemleket().equalsIgnoreCase("Ýzmir") && hast.getTeshis().equalsIgnoreCase("POZÝTÝF"))
       		 {
       			izmirindex++;
       			
       			
       		 }
       		if(hast.getMemleket().equalsIgnoreCase("Hatay") && hast.getTeshis().equalsIgnoreCase("POZÝTÝF"))
      		 {
       			hatayindex++;
      			
      			
      		 }
       		if(hast.getMemleket().equalsIgnoreCase("Antalya") && hast.getTeshis().equalsIgnoreCase("POZÝTÝF"))
      		 {
       			antalyaindex++;
      			
      			
      		 }
       		 
       	 
       	 
       	 
        }

     
    		
    	XYChart.Series<String, Integer> series = new XYChart.Series<>();                
    		for (int i = 0; i < 5 ; i++) {          
    			
    			 
    			series.getData().add(new Data<String, Integer>("Hatay",hatayindex));
    			series.getData().add(new Data<String, Integer>("Ýzmir",izmirindex));
    			series.getData().add(new Data<String, Integer>("Antalya",antalyaindex));
    			series.getData().add(new Data<String, Integer>("Ýstanbul",istanbulindex));
    			series.getData().add(new Data<String, Integer>("Ankara",ankaraindex));
    			
    			}  
    		grafik.getData().clear();
    		grafik.getData().add(series); 
    		
    	
    	

    }
    
    @FXML
    void show_click(ActionEvent event) {
    	
    	
    		

    }
    
    

    @FXML
    void initialize() {
    	
    	
    	
    	
    	
    	
    	
    	
    	

    	grafik_sehir.setCategories(sehirlerim);
    	
  
    	
    	
    	
    	
    	id.setCellValueFactory(new PropertyValueFactory<hastakayit, Integer>("id"));
    	hasta_adi.setCellValueFactory(new PropertyValueFactory<hastakayit, String>("adsoyad"));
    	memleket.setCellValueFactory(new PropertyValueFactory<hastakayit, String>("memleket"));
    	meslek.setCellValueFactory(new PropertyValueFactory<hastakayit, String>("meslek"));
    	cinsiyet.setCellValueFactory(new PropertyValueFactory<hastakayit, String>("cinsiyet"));
    	ates.setCellValueFactory(new PropertyValueFactory<hastakayit, String>("ates"));
    	teshis.setCellValueFactory(new PropertyValueFactory<hastakayit, String>("teshis"));
    	tarih.setCellValueFactory(new PropertyValueFactory<hastakayit, String>("TarihC"));
    	
    	tableview.setItems(hasta);
    	
    	
    	
    	
    	slider_ates.setMax(43.7);
    	slider_ates.setMin(21.0);
    	slider_ates.setShowTickLabels(true);
    	slider_ates.setShowTickMarks(true);
    	slider_ates.setMajorTickUnit(5);
    	slider_ates.setBlockIncrement(0.1);
    	slider_ates.valueProperty().addListener(
    			
    			(Observable,OldValue,newValue)->
    			{
    				Double a=newValue.doubleValue();
    				lbl_atesdegeri.setText(Double.toString(a));
	
    			});
    	
    	ObservableList<String> sehir=FXCollections.observableArrayList("Ankara","Ýstanbul","Ýzmir","Hatay","Antalya");
    	sehirler.setItems(sehir);

    	DegerleriGetir(tableview); 
    }
    
    @Override
    
    public void initialize(URL location,ResourceBundle resources)
    {
    	initialize();
    }   
}

