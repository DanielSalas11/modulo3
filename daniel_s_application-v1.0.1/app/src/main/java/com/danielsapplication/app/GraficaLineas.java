package com.danielsapplication.app;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class GraficaLineas extends AppCompatActivity {

    private LineChart lineChart;
    TextView emocionLineasTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafica_lineas);

        emocionLineasTv = findViewById(R.id.EmocionLineasTv);
        String emocionSeleccionadaTv = getIntent().getStringExtra("EmocionSeleccionada");
        emocionLineasTv.setText(emocionSeleccionadaTv);

        lineChart = findViewById(R.id.lineChart);

        List<Emocion> emocionesMes = (List<Emocion>) getIntent().getSerializableExtra("EmocionMes");
        List<Emocion> emocionesDia = (List<Emocion>) getIntent().getSerializableExtra("EmocionesDia");
        List<Emocion> emocionesAño = (List<Emocion>) getIntent().getSerializableExtra("EmocionesAño");

        // Logica para los grafica de line de emocionesMes
        if (emocionesMes!=null && !emocionesMes.isEmpty()){
            Map<String, List<Float>> intensidadesPorDia = new HashMap<>();

            for (Emocion emocion : emocionesMes) {
                if (emocion.getEmocion().equals(emocionSeleccionadaTv)) {
                    String fecha = emocion.getFecha();
                    String diaMes = obtenerDiaMes(fecha);
                    float intensidad = emocion.getIntensidad();
                    if (intensidadesPorDia.containsKey(diaMes)) {
                        intensidadesPorDia.get(diaMes).add(intensidad);
                    } else {
                        List<Float> intensidades = new ArrayList<>();
                        intensidades.add(intensidad);
                        intensidadesPorDia.put(diaMes, intensidades);
                    }
                }
            }

            List<Entry> entries = new ArrayList<>();
            List<String> labels = new ArrayList<>();
            int index = 0;

            List<Map.Entry<String, List<Float>>> sortedEntries = new ArrayList<>(intensidadesPorDia.entrySet());
            Collections.sort(sortedEntries, new Comparator<Map.Entry<String, List<Float>>>() {
                @Override
                public int compare(Map.Entry<String, List<Float>> o1, Map.Entry<String, List<Float>> o2) {
                    return o1.getKey().compareTo(o2.getKey());
                }
            });

            for (Map.Entry<String, List<Float>> entry : sortedEntries) {
                String diaMes = entry.getKey();
                List<Float> intensidades = entry.getValue();
                for (Float intensidad : intensidades) {
                    entries.add(new Entry(index++, intensidad));
                    labels.add(diaMes);
                }
            }

            LineDataSet dataSet = new LineDataSet(entries, "Intensidad");
            dataSet.setColor(Color.BLUE);
            dataSet.setValueTextColor(Color.BLACK);
            LineData lineData = new LineData(dataSet);

            lineChart.setData(lineData);
            Description description = new Description();
            description.setText("");
            lineChart.setDescription(description);
            lineChart.getXAxis().setValueFormatter(new LabelFormatter(labels));
            lineChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
            lineChart.invalidate();

            lineChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
                @Override
                public void onValueSelected(Entry e, Highlight h) {
                    float intensity = e.getY();
                    String day = labels.get((int) e.getX());
                    Toast.makeText(GraficaLineas.this, "Intensidad: " + intensity + " - Día: " + day, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onNothingSelected() {
                }
            });
        }

        if (emocionesDia != null && !emocionesDia.isEmpty()) {
            // Logica para los grafica de line de emocionesDia
            Map<String, List<Float>> intensidadesPorDia = new HashMap<>();
            for (Emocion emocion : emocionesDia) {
                if (emocion.getEmocion().equals(emocionSeleccionadaTv)) {
                    String fecha = emocion.getFecha();
                    String diaMes = obtenerDiaMes(fecha);
                    float intensidad = emocion.getIntensidad();
                    if (intensidadesPorDia.containsKey(diaMes)) {
                        intensidadesPorDia.get(diaMes).add(intensidad);
                    } else {
                        List<Float> intensidades = new ArrayList<>();
                        intensidades.add(intensidad);
                        intensidadesPorDia.put(diaMes, intensidades);
                    }
                }
            }

            List<Entry> entries = new ArrayList<>();
            List<String> labels = new ArrayList<>();
            int index = 0;

            List<Map.Entry<String, List<Float>>> sortedEntries = new ArrayList<>(intensidadesPorDia.entrySet());
            Collections.sort(sortedEntries, new Comparator<Map.Entry<String, List<Float>>>() {
                @Override
                public int compare(Map.Entry<String, List<Float>> o1, Map.Entry<String, List<Float>> o2) {
                    return o1.getKey().compareTo(o2.getKey());
                }
            });

            for (Map.Entry<String, List<Float>> entry : sortedEntries) {
                String diaMes = entry.getKey();
                List<Float> intensidades = entry.getValue();
                for (Float intensidad : intensidades) {
                    entries.add(new Entry(index++, intensidad));
                    labels.add(diaMes);
                }
            }

            LineDataSet dataSet = new LineDataSet(entries, "Intensidad");
            dataSet.setColor(Color.BLUE);
            dataSet.setValueTextColor(Color.BLACK);
            LineData lineData = new LineData(dataSet);

            lineChart.setData(lineData);
            Description description = new Description();
            description.setText("");
            lineChart.setDescription(description);
            lineChart.getXAxis().setValueFormatter(new LabelFormatter(labels));
            lineChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
            lineChart.invalidate();

            lineChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
                @Override
                public void onValueSelected(Entry e, Highlight h) {
                    float intensity = e.getY();
                    String day = labels.get((int) e.getX());
                    Toast.makeText(GraficaLineas.this, "Intensidad: " + intensity + " - Día: " + day, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onNothingSelected() {
                }
            });
        }else {
        }

        if (emocionesAño!=null && !emocionesAño.isEmpty()){
            // Logica para los grafica de line de emocionesAño
            Map<String, List<Float>> intensidadesPorDia = new HashMap<>();
            for (Emocion emocion : emocionesAño) {
                if (emocion.getEmocion().equals(emocionSeleccionadaTv)) {
                    String fecha = emocion.getFecha();
                    String diaMes = obtenerDiaMes(fecha);
                    float intensidad = emocion.getIntensidad();
                    if (intensidadesPorDia.containsKey(diaMes)) {
                        intensidadesPorDia.get(diaMes).add(intensidad);
                    } else {
                        List<Float> intensidades = new ArrayList<>();
                        intensidades.add(intensidad);
                        intensidadesPorDia.put(diaMes, intensidades);
                    }
                }
            }

            List<Entry> entries = new ArrayList<>();
            List<String> labels = new ArrayList<>();
            int index = 0;

            List<Map.Entry<String, List<Float>>> sortedEntries = new ArrayList<>(intensidadesPorDia.entrySet());
            Collections.sort(sortedEntries, new Comparator<Map.Entry<String, List<Float>>>() {
                @Override
                public int compare(Map.Entry<String, List<Float>> o1, Map.Entry<String, List<Float>> o2) {
                    return o1.getKey().compareTo(o2.getKey());
                }
            });

            for (Map.Entry<String, List<Float>> entry : sortedEntries) {
                String diaMes = entry.getKey();
                List<Float> intensidades = entry.getValue();
                for (Float intensidad : intensidades) {
                    entries.add(new Entry(index++, intensidad));
                    labels.add(diaMes);
                }
            }

            LineDataSet dataSet = new LineDataSet(entries, "Intensidad");
            dataSet.setColor(Color.BLUE);
            dataSet.setValueTextColor(Color.BLACK);
            LineData lineData = new LineData(dataSet);

            lineChart.setData(lineData);
            Description description = new Description();
            description.setText("");
            lineChart.setDescription(description);
            lineChart.getXAxis().setValueFormatter(new LabelFormatter(labels));
            lineChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
            lineChart.invalidate();

            lineChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
                @Override
                public void onValueSelected(Entry e, Highlight h) {
                    float intensity = e.getY();
                    String day = labels.get((int) e.getX());
                    Toast.makeText(GraficaLineas.this, "Intensidad: " + intensity + " - Día: " + day, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onNothingSelected() {
                }
            });
        }

    }

    private String obtenerDiaMes(String fecha) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
            SimpleDateFormat output = new SimpleDateFormat("dd/MM", Locale.getDefault());
            return output.format(sdf.parse(fecha));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private class LabelFormatter extends ValueFormatter {
        private final List<String> labels;

        LabelFormatter(List<String> labels) {
            this.labels = labels;
        }

        @Override
        public String getFormattedValue(float value) {
            int index = (int) value;
            if (index >= 0 && index < labels.size()) {
                return labels.get(index);
            } else {
                return "";
            }
        }
    }
}