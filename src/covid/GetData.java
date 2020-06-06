package covid;
import covid.model.CountryData;

import java.util.Date;
import java.io.FileNotFoundException;

import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.xml.sax.InputSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Enes Y
 */
public class GetData {
    
    private String ContentXML;
    private boolean DoesPageExist;

        public ArrayList<CountryData> parseCountryData() {
            
        ArrayList<CountryData> newCountryInfoList = new ArrayList<>();

        Date myDate = new Date(2020, 05, 25);
        String urlToBeFetched = createFetchURL(myDate);  
        String requestXML = requestXML(urlToBeFetched);       
               
        try {                
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
           
            StringReader stringReader = new StringReader(requestXML);
            InputSource inputSource = new InputSource(stringReader);
            Document doc = dBuilder.parse(inputSource);
                                                                                      
            NodeList newCountryInfoListNodeList = doc.getElementsByTagName("record");                        

            for (int parameter = 0; parameter < newCountryInfoListNodeList.getLength(); parameter++) {
                                             
                Node node = newCountryInfoListNodeList.item(parameter);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    final CountryData countryData = new CountryData();
                    Element eElement = (Element) node;
                    String countriesAndTerritories = eElement.getElementsByTagName("countriesAndTerritories").item(0).getTextContent();
                    String countryterritoryCode = eElement.getElementsByTagName("countryterritoryCode").item(0).getTextContent();
                    String cases = eElement.getElementsByTagName("cases").item(0).getTextContent();
                    String deaths = eElement.getElementsByTagName("deaths").item(0).getTextContent();
                    String popData2018 = eElement.getElementsByTagName("popData2018").item(0).getTextContent();
                    String dateRep = eElement.getElementsByTagName("dateRep").item(0).getTextContent();
                    String continentExp = eElement.getElementsByTagName("continentExp").item(0).getTextContent();                   
                    
                    countryData.setCountryterritoryCode(countryterritoryCode);
                    countryData.setCountriesAndTerritories(countriesAndTerritories);
                    countryData.setCases(cases);
                    countryData.setDeaths(deaths);
                    countryData.setPopData2018(popData2018);
                    countryData.setDateRep(dateRep);
                    countryData.setContinentExp(continentExp);
                    newCountryInfoList.add(countryData);     
                    }
                }
            }
         catch (Exception e) {
             System.out.println("Error");
        }
       
        return newCountryInfoList;
    }
    
    public boolean doesInfoExistForDate(Date dateToBeFetched) {

    String urlToBeFetched = createFetchURL(dateToBeFetched);

    ContentXML = requestXML(urlToBeFetched);

    return DoesPageExist;
    }
    
        private String createFetchURL(Date dateToBeFetched) {

        Date today = new Date(System.currentTimeMillis());

        if (dateToBeFetched.equals(today))
            return "https://opendata.ecdc.europa.eu/covid19/casedistribution/xml/";


        // YYYY-MM-DD
        String[] dateParts = dateToBeFetched.toString().split("[-]");
            return "https://opendata.ecdc.europa.eu/covid19/casedistribution/xml/";
      

    }
        private String requestXML(String urlToBeFetched) {
        ContentXML = null;
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(urlToBeFetched).openConnection();

            DoesPageExist = connection.getResponseCode() != 404;          

            Scanner scanner = new Scanner(connection.getInputStream());
            scanner.useDelimiter("\\Z");
            ContentXML = scanner.next();
            scanner.close();
        } catch (FileNotFoundException e404) {

            return null;
        } catch (Exception ex) {
            String message = ex.getMessage();
            System.out.println(message);
        }
        return ContentXML;
    }
        
       
}