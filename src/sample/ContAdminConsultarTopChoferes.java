package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ContAdminConsultarTopChoferes implements Initializable {

    @FXML
    private BarChart<?, ?> grafico;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        XYChart.Series set1 = new XYChart.Series<>();
        ArrayList<String[]> listaConResultados = agarrarLaListaOrdenada(); //Agarra los valores ya ordenados
        int cantBarras = 5;
        for(int i = listaConResultados.size()-1; i > -1; i--){
            if(cantBarras > 0){
                set1.getData().add(new XYChart.Data<>(listaConResultados.get(i)[0],Integer.parseInt(listaConResultados.get(i)[1])));
                cantBarras--;
            }
        }

        for(int i = 0; i < listaConResultados.size(); i++){
            System.out.println(listaConResultados.get(i)[0] + " : " + listaConResultados.get(i)[1]);
        }

        grafico.getData().addAll(set1);
    }

    private ArrayList<String[]> agarrarLosTop(){
        ArrayList<String[]> tempString = new ArrayList<>();

        for(Viaje v : Main.getListaDeViajes()){

            boolean viajeEncontrado = false;
            for(int i = 0; i < tempString.size(); i++){
                if(v.getChofer().getCedula().equals(tempString.get(i)[0])){//Significa que es el mismo chofer
                    String[] temp = new  String[2];
                    temp[0] = tempString.get(i)[0];
                    temp[1] = Integer.toString(Integer.parseInt(tempString.get(i)[1]) + 1);
                    tempString.set(i, temp);
                    viajeEncontrado = true;
                }
            }

            if(!viajeEncontrado){
                String[] arrConValor = new String[2];
                arrConValor[0] = v.getChofer().getCedula();
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
