package ua.kpi.comsys.iv7216.drawing;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;
import ua.kpi.comsys.iv7216.R;

/**
 * Функція y = e^x на проміжку x ∈ [-6; 6];
 * Кільце кругової діаграми із секторами, що займають відповідний відсоток кола та мають відповідний колір: 35% (зелений), 40% (жовтий), 25% (червоний).
 */
public class DrawingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing);

        RadioButton graphRadio = findViewById(R.id.radio_graph);
        graphRadio.setOnClickListener(radioButtonClickListener);

        RadioButton diagramRadio = findViewById(R.id.radio_diagram);
        diagramRadio.setOnClickListener(radioButtonClickListener);

    }

    View.OnClickListener radioButtonClickListener = v -> {
        GraphView graph = findViewById(R.id.graph);
        PieChartView diagram = findViewById(R.id.diagram);
        RadioButton rb = (RadioButton) v;
        switch (rb.getId()) {
            case R.id.radio_graph:
                drawGraph(graph, diagram);
                break;
            case R.id.radio_diagram:
                drawPieChart(graph, diagram);
                break;
            default:
                break;
        }
    };

    private void drawPieChart(GraphView graph, PieChartView diagram) {
        graph.setVisibility(View.GONE);
        diagram.setVisibility(View.VISIBLE);

        PieChartData data;
        List<SliceValue> values = new ArrayList<>();
        values.add(new SliceValue(35, Color.GREEN));
        values.add(new SliceValue(40, Color.YELLOW));
        values.add(new SliceValue(25, Color.RED));

        data = new PieChartData(values);
        data.setHasLabels(true);
        data.setHasCenterCircle(true);

        diagram.setPieChartData(data);
    }

    private void drawGraph(GraphView graph, PieChartView diagram) {
        diagram.setVisibility(View.GONE);
        graph.setVisibility(View.VISIBLE);

        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(buildGraph());
        series.setColor(Color.BLUE);

        graph.setTitle("y = e^x");
        graph.setTitleColor(Color.BLACK);

        graph.getViewport().setMinX(-10);
        graph.getViewport().setMaxX(10);
        graph.getViewport().setMinY(-2);
        graph.getViewport().setMaxY(403);

        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setXAxisBoundsManual(true);
        graph.addSeries(series);
    }

    public DataPoint[] buildGraph() {
        double y;
        DataPoint[] result = new DataPoint[241];
        int counter = 0;
        for (double x = -6; x <= 6; x += 0.05) {
            y = Math.exp(x);
            result[counter++] = new DataPoint(x, y);
        }

        return result;
    }
}