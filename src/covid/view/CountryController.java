package covid.view;

import covid.model.CountryData;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import covid.GetData;
import java.util.ArrayList;



/**
 * FXML Controller class
 *
 * @author Enes Y
 */
public class CountryController implements Initializable {
    
    @FXML
    private TableView<CountryData> countryTable;
    @FXML
    private TableColumn<CountryData, String> countriesAndTerritories ;
    @FXML
    private TableColumn<CountryData, Long> cases;
    @FXML
    private TableColumn<CountryData, Long> popData2018;
    @FXML
    private TableColumn<CountryData, Long> deaths;
    @FXML
    private TableColumn<CountryData, Long> dateRep;        
    
    CountryData countryData = new CountryData();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
    // Ülke-Ülkedeki Yeni Vaka Sayısı-Ülkedeki toplam vaka-Ülkedeki toplam ölüm-ülkedeki yeni ölüm
        GetData gtData = new GetData();
        ArrayList<CountryData> dataList = gtData.parseCountryData();                          
        
        for(int i=0;i<=dataList.size();i++) { 

            CountryData c1 = dataList.get(i);
            
            if(i+1 >= dataList.size()){
                return;
            }
            
            CountryData c2 = dataList.get(i+1);
            
            if(c1.equals(c2)){
                return;
            }
        if(!c1.getCountriesAndTerritories().equals(c2.getCountriesAndTerritories())){
            countryTable.getItems().add(c1);
        }        
        countriesAndTerritories.setCellValueFactory(new PropertyValueFactory<CountryData , String>("countriesAndTerritories"));
        cases.setCellValueFactory(new PropertyValueFactory<CountryData , Long>("cases"));
        popData2018.setCellValueFactory(new PropertyValueFactory<CountryData , Long>("popData2018"));
        deaths.setCellValueFactory(new PropertyValueFactory<CountryData , Long>("deaths"));
        dateRep.setCellValueFactory(new PropertyValueFactory<CountryData , Long>("dateRep"));
       
  }

}
}