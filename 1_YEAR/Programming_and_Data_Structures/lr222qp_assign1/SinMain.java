package lr222qp.assign1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;
import org.knowm.xchart.style.Styler.LegendPosition;

public class SinMain {
	public static void main(String[]args) {
		
	 XYChart chart = new XYChartBuilder().width(800).height(600).build();
	    chart.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Line);
	    chart.getStyler().setChartTitleVisible(false);
	    chart.getStyler().setLegendPosition(LegendPosition.InsideSW);
	    chart.getStyler().setMarkerSize(10);

	    // Generate data
	    List<Double> xData = new ArrayList<Double>();
	    List<Double> yData = new ArrayList<Double>();
	   
	    for(double x = 0;x<2*Math.PI;x = x + 0.2) {
	    	double y = ((1+x/Math.PI)*Math.cos(x)*Math.cos(40*x));
	    	yData.add(y);
	    	xData.add(x);
	    }
	    
			    
	    // Display scatter plot
	    chart.addSeries("Results", xData, yData);
	    new SwingWrapper<XYChart>(chart).displayChart();
	}
}
