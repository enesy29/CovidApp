package covid.view;

import covid.model.CountryData;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;

/**
 *
 * @author Enes Y
 */
public class CountryStatsController {
    @FXML
    private BarChart<String, Integer> barChart;
    @FXML
    private CategoryAxis xAxis;

    private final ObservableList<String> monthNames = FXCollections.observableArrayList();
    
    private void initialize() {
        
        String[] months = DateFormatSymbols.getInstance(Locale.ENGLISH).getMonths();
        monthNames.addAll(Arrays.asList(months));
        xAxis.setCategories(monthNames);
    }
   
    public void countryDataStats(List<CountryData> countries) {
        
        int[] monthCounter = new int[12];
        for (CountryData c : countries) 
        {
            String month = c.getCases();
            int i = Integer.parseInt(month);
            monthCounter[i]++;
        }
        
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        
        for (int i = 0; i < monthCounter.length; i++) {
        	series.getData().add(new XYChart.Data<>(monthNames.get(i), monthCounter[i]));
        } 
        barChart.getData().add(series);
    }
}
