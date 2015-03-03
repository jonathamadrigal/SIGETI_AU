
package modelo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import vista.VentanaLogin;
import vista.administrativo.PanelReportesAdmin;

public class Graficador {

    public Graficador() {
    }
    
    
    
    public void dibuja(){
        PanelReportesAdmin.obtenerInstancia().setDobjetos(new DefaultCategoryDataset());
        this.agregaBarra(PanelReportesAdmin.obtenerInstancia().getDobjetos(), "a", "b", 1);
        this.agregaBarra(PanelReportesAdmin.obtenerInstancia().getDobjetos(), "c", "d", 2);
        ChartPanel nombre = this.barraConstructor(PanelReportesAdmin.obtenerInstancia().getjObjetos(),
               PanelReportesAdmin.obtenerInstancia().getDobjetos(), "Grafico", "Quantity", "algo");
       
//    PanelReportesAdmin.obtenerInstancia().getjPanelGrafico().removeAll();
    PanelReportesAdmin.obtenerInstancia().getjPanelGrafico().add(nombre);
    PanelReportesAdmin.obtenerInstancia().getjPanelGrafico().revalidate();
    
//    VentanaLogin.obtenerInstancia().panelPrincipal.removeAll();
//        VentanaLogin.obtenerInstancia().panelPrincipal.add(nombre);
//        VentanaLogin.obtenerInstancia().mostrar();
  // PanelReportesAdmin.obtenerInstancia().revalidate();
   //PanelReportesAdmin.obtenerInstancia().repaint();
    
    
    } 
    
    public void agregaBarra(DefaultCategoryDataset base,String nombre,String medicion, int valor){
    base.addValue(valor, medicion, nombre);
    
    }
    
     public ChartPanel barraConstructor(JFreeChart Grafico, DefaultCategoryDataset base,String nombre,String medicion, String valor){
    Grafico=ChartFactory.createBarChart3D(nombre,valor,medicion,  base, PlotOrientation.VERTICAL,true,true,false);
    ChartPanel dibuja= new ChartPanel(Grafico);
    dibuja.setPreferredSize(new Dimension(200,200));
    return dibuja;
    }
    
}
