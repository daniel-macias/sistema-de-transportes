package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ContAdminConsultarTopEscuelas implements Initializable {

    @FXML
    private PieChart grafico;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<String[]> respuestas = agarrarLaListaOrdenada();   //Agarra la lista ordenada temporalmente para meter al grafico

        //PieChart.Data pd0 = new PieChart.Data(respuestas.get(0)[0],Integer.parseInt(respuestas.get(0)[1]));
        //PieChart.Data pd1 = new PieChart.Data(respuestas.get(1)[0],Integer.parseInt(respuestas.get(1)[1]));
        //PieChart.Data pd2 = new PieChart.Data(respuestas.get(2)[0],Integer.parseInt(respuestas.get(2)[1]));
        //PieChart.Data pd3 = new PieChart.Data(respuestas.get(3)[0],Integer.parseInt(respuestas.get(3)[1]));
        //PieChart.Data pd4 = new PieChart.Data(respuestas.get(4)[0],Integer.parseInt(respuestas.get(4)[1]));

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        int cantBarras = 5;
        for(int i = respuestas.size()-1; i > -1; i--){
            if(cantBarras > 0){
                PieChart.Data pd = new PieChart.Data(respuestas.get(i)[0],Integer.parseInt(respuestas.get(i)[1]));
                pieChartData.add(pd);
                cantBarras--;
            }
        }
        grafico.setData(pieChartData);

        for(int i = 0; i < respuestas.size(); i++){
            System.out.println(respuestas.get(i)[0] + " : " + respuestas.get(i)[1]);
        }

    }

    private ArrayList<String[]> agarrarLosTop(){
        ArrayList<String[]> tempString = new ArrayList<>();

        for(Viaje v : Main.getListaDeViajes()){

            boolean viajeEncontrado = false;
            for(int i = 0; i < tempString.size(); i++){
                if(v.getDepartamento().equals(tempString.get(i)[0])){//Significa que es el mismo departamento
                    String[] temp = new  String[2];
                    temp[0] = tempString.get(i)[0];
                    temp[1] = Integer.toString(Integer.parseInt(tempString.get(i)[1]) + 1);
                    tempString.set(i, temp);
                    viajeEncontrado = true;
                }
            }

            if(!viajeEncontrado){
                String[] arrConValor = new String[2];
                arrConValor[0] = v.getDepartamento();
                arrConValor[1] = "1";
                tempString.add(arrConValor);
            }
        }

        return tempString;
    }

    private ArrayList<String[]> agarrarLaListaOrdenada(){
        ArrayList<String[]> tempString = agarrarLosTop();
        int n = tempString.size();
        for(int i = 0; i < n-1 ; i++){
            for(int j = 0; j < n-i-1; j++){
                if(Integer.parseInt(tempString.get(j)[1]) > Integer.parseInt(tempString.get(j+1)[1])){
                    String[] temp = new  String[2];
                    temp[0] = tempString.get(j)[0];
                    temp[1] = tempString.get(j)[1];
                    tempString.set(j,tempString.get(j+1));
                    tempString.set(j+1,temp);
                }
            }
        }
        return tempString;
    }
}
