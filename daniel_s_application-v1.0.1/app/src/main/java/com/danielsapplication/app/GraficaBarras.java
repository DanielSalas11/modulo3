package com.danielsapplication.app;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraficaBarras extends AppCompatActivity {

    BarChart barChart;
    ArrayList<Emocion> emocionesArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafica_barras);

        barChart = findViewById(R.id.barchart);

        emocionesArrayList = (ArrayList<Emocion>) getIntent().getSerializableExtra("EmocionesUsuario");
        String mesActual = getIntent().getStringExtra("MesActual");
        String añoActual = getIntent().getStringExtra("AñoActual");
        String anioActual = getIntent().getStringExtra("AnioActual");

        // Logica para que ponga la grafica de barra del mes y año
        if (emocionesArrayList != null) {
            ArrayList<Emocion> emocionesFiltradas = new ArrayList<>();

            for (Emocion emocion : emocionesArrayList) {
                String[] fechaParts = emocion.getFecha().split("/");
                String emocionMes = fechaParts[1];
                String emocionAño = fechaParts[0];
                if (emocionMes.equals(mesActual) && emocionAño.equals(añoActual)) {
                    emocionesFiltradas.add(emocion);
                }
            }

            if (!emocionesFiltradas.isEmpty()) {
                Map<String, Integer> countByEmotion = new HashMap<>();

                for (Emocion emocion : emocionesFiltradas) {
                    String emocionName = emocion.getEmocion();
                    countByEmotion.put(emocionName, countByEmotion.getOrDefault(emocionName, 0) + 1);
                }

                ArrayList<BarEntry> barEntries = new ArrayList<>();
                ArrayList<String> labelsName = new ArrayList<>();

                int index = 0;
                for (Map.Entry<String, Integer> entry : countByEmotion.entrySet()) {
                    labelsName.add(entry.getKey());
                    barEntries.add(new BarEntry(index++, entry.getValue()));
                }

                BarDataSet barDataSet = new BarDataSet(barEntries, "Emociones");
                barDataSet.setColors(ColorTemplate.JOYFUL_COLORS);

                Description description = new Description();
                description.setText("");
                barChart.setDescription(description);
                BarData barData = new BarData(barDataSet);
                barChart.setData(barData);

                XAxis xAxis = barChart.getXAxis();
                xAxis.setValueFormatter(new IndexAxisValueFormatter(labelsName));
                xAxis.setPosition(XAxis.XAxisPosition.TOP);
                xAxis.setDrawGridLines(false);
                xAxis.setDrawAxisLine(false);
                xAxis.setGranularity(1f);
                xAxis.setLabelCount(labelsName.size());
                xAxis.setLabelRotationAngle(270);

                barChart.animateY(1000);
                barChart.invalidate();
            }


        } else {
        }

        // Logica para que ponga la grafica de barra del dia
        Intent intent = getIntent();
        Emocion[] emocionesArray = (Emocion[]) intent.getSerializableExtra("emocionesDelDia");
        List<Emocion> emocionesDelDia=null;
        if (emocionesArray != null) {
            emocionesDelDia = new ArrayList<>(Arrays.asList(emocionesArray));
        }
        if (emocionesDelDia != null && !emocionesDelDia.isEmpty()) {
            Map<String, Integer> countByEmotion = new HashMap<>();

            for (Emocion emocion : emocionesDelDia) {
                String emocionName = emocion.getEmocion();
                countByEmotion.put(emocionName, countByEmotion.getOrDefault(emocionName, 0) + 1);
            }

            ArrayList<BarEntry> barEntries = new ArrayList<>();
            ArrayList<String> labelsName = new ArrayList<>();

            int index = 0;
            for (Map.Entry<String, Integer> entry : countByEmotion.entrySet()) {
                labelsName.add(entry.getKey());
                barEntries.add(new BarEntry(index++, entry.getValue()));
            }

            BarDataSet barDataSet = new BarDataSet(barEntries, "Emociones");
            barDataSet.setColors(ColorTemplate.JOYFUL_COLORS);

            Description description = new Description();
            description.setText("");
            barChart.setDescription(description);
            BarData barData = new BarData(barDataSet);
            barChart.setData(barData);

            XAxis xAxis = barChart.getXAxis();
            xAxis.setValueFormatter(new IndexAxisValueFormatter(labelsName));
            xAxis.setPosition(XAxis.XAxisPosition.TOP);
            xAxis.setDrawGridLines(false);
            xAxis.setDrawAxisLine(false);
            xAxis.setGranularity(1f);
            xAxis.setLabelCount(labelsName.size());
            xAxis.setLabelRotationAngle(270);

            barChart.animateY(1000);
            barChart.invalidate();
        }

        // Logica para que ponga la grafica de barra del año
        if (emocionesArrayList != null) {
            ArrayList<Emocion> emocionesFiltradasAño = new ArrayList<>();

            for (Emocion emocion : emocionesArrayList) {
                String[] fechaParts = emocion.getFecha().split("/");
                String emocionMes = fechaParts[1];
                String emocionAño = fechaParts[0];

                if (emocionAño.equals(anioActual)) {
                    emocionesFiltradasAño.add(emocion);
                }
            }

            if (!emocionesFiltradasAño.isEmpty()) {
                Map<String, Integer> countByEmotion = new HashMap<>();

                for (Emocion emocion : emocionesFiltradasAño) {
                    String emocionName = emocion.getEmocion();
                    countByEmotion.put(emocionName, countByEmotion.getOrDefault(emocionName, 0) + 1);
                }

                ArrayList<BarEntry> barEntries = new ArrayList<>();
                ArrayList<String> labelsName = new ArrayList<>();

                int index = 0;
                for (Map.Entry<String, Integer> entry : countByEmotion.entrySet()) {
                    labelsName.add(entry.getKey());
                    barEntries.add(new BarEntry(index++, entry.getValue()));
                }

                BarDataSet barDataSet = new BarDataSet(barEntries, "Emociones");
                barDataSet.setColors(ColorTemplate.JOYFUL_COLORS);

                Description description = new Description();
                description.setText("");
                barChart.setDescription(description);
                BarData barData = new BarData(barDataSet);
                barChart.setData(barData);

                XAxis xAxis = barChart.getXAxis();
                xAxis.setValueFormatter(new IndexAxisValueFormatter(labelsName));
                xAxis.setPosition(XAxis.XAxisPosition.TOP);
                xAxis.setDrawGridLines(false);
                xAxis.setDrawAxisLine(false);
                xAxis.setGranularity(1f);
                xAxis.setLabelCount(labelsName.size());
                xAxis.setLabelRotationAngle(270);

                barChart.animateY(1000);
                barChart.invalidate();
            }
        }
        else {
        }

    }
}