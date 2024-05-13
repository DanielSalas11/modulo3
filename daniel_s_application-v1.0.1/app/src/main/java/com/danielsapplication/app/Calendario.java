package com.danielsapplication.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import androidx.appcompat.app.AppCompatActivity;

import com.applandeo.materialcalendarview.CalendarDay;
import com.applandeo.materialcalendarview.CalendarView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calendario extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);

        List<CalendarDay> events = new ArrayList<>();

        ArrayList<Emocion> emociones = new ArrayList<>();
        Usuario usuario = new Usuario("1", "Joshua", emociones);
        emociones.add(new Emocion("Tristeza", 100, R.drawable.img_image_3,"Mucha tarea :c","2024/05/02"));
        emociones.add(new Emocion("Tristeza", 50, R.drawable.img_image_3,"Mucha tarea x2","2024/05/03"));
        emociones.add(new Emocion("Felicidad", 50, R.drawable.img_image_1,"Es viernes :D","2024/05/03"));
        emociones.add(new Emocion("Enojado", 50, R.drawable.img_image_2,"Tengo hambre","2024/05/04"));
        emociones.add(new Emocion("Tristeza", 100, R.drawable.img_image_3,"Tarea x_x","2024/05/05"));
        emociones.add(new Emocion("Tristeza", 100, R.drawable.img_image_3,"Tarea x2","2024/05/06"));
        emociones.add(new Emocion("Tristeza", 50, R.drawable.img_image_3,"Tarea x3","2024/05/07"));
        emociones.add(new Emocion("Felicidad", 50, R.drawable.img_image_1,"Ejercicio","2024/05/07"));
        emociones.add(new Emocion("Preocupado", 100, R.drawable.img_image_4,"No sale la tarea D:","2024/05/07"));
        emociones.add(new Emocion("Felicidad", 100, R.drawable.img_image_1,"Ya salio la tarea :D","2024/05/08"));
        emociones.add(new Emocion("Prueba", 100, R.drawable.img_image_1,"Ya salio la tarea :D","2024/04/08"));
        emociones.add(new Emocion("Prueba2", 100, R.drawable.img_image_1,"Ya salio la tarea :D","2024/04/08"));


        Map<String, List<Emocion>> emocionesPorFecha = new HashMap<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

        for (Emocion emocion : emociones) {
            emocionesPorFecha.putIfAbsent(emocion.getFecha(), new ArrayList<>());
            emocionesPorFecha.get(emocion.getFecha()).add(emocion);

        }

        for (Map.Entry<String, List<Emocion>> entry : emocionesPorFecha.entrySet()) {
            try {
                Date fecha = dateFormat.parse(entry.getKey());
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(fecha);

                CalendarDay calendarDay = new CalendarDay(calendar);

                if (entry.getValue().size() > 1) {
                    calendarDay.setImageDrawable(DrawableUtils.getImageWithText(this, String.valueOf(entry.getValue().size())));
                } else {
                    calendarDay.setImageResource(entry.getValue().get(0).getImg());
                }

                events.add(calendarDay);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView);
        calendarView.setCalendarDays(events);

        calendarView.setOnDayClickListener(eventDay -> {
            Calendar clickedDayCalendar = eventDay.getCalendar();
            String dateString = dateFormat.format(clickedDayCalendar.getTime());

            List<Emocion> emocionesDelDia = emocionesPorFecha.get(dateString);

            if (emocionesDelDia != null) {
                Intent intent = new Intent(this, DescripcionDia.class);
                intent.putExtra("EmocionesDia", (Serializable) emocionesDelDia);
                startActivity(intent);
            } else {
                Toast.makeText(this, "No hay emociones registradas", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnCalendar = findViewById(R.id.btnCalendar);
        btnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Calendario.class);

                startActivity(intent);
            }
        });

//        Button btnStats = findViewById(R.id.btnStats);
//        btnStats.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(v.getContext(), GraficaBarras.class);
//                intent.putExtra("EmocionesUsuario", new ArrayList<>(emociones));
//                startActivity(intent);
//            }
//        });

//        Button btnStatsWeek = findViewById(R.id.btnStatsWeek);
//        btnStatsWeek.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(v.getContext(), GraficaBarras.class);
//
//                startActivity(intent);
//
//                System.out.println(calendarView.getCurrentPageDate().get);
//            }
//        });

        Button btnStatsMonth = findViewById(R.id.btnStatsMonth);
        btnStatsMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), GraficaBarras.class);

                int mesActual = calendarView.getCurrentPageDate().get(Calendar.MONTH) + 1;
                String añoActual = String.valueOf(calendarView.getCurrentPageDate().get(Calendar.YEAR));
                String mesFormateado = String.format("%02d", mesActual);

                List<Emocion> emocionesMes = getEmocionesPorMesYAnio(emociones, mesFormateado, añoActual);
                if (emocionesMes.isEmpty()) {
                    Toast.makeText(v.getContext(), "No hay emociones para el mes", Toast.LENGTH_SHORT).show();
                    return;
                }

                intent.putExtra("MesActual", mesFormateado);
                intent.putExtra("AñoActual", añoActual);
                intent.putExtra("EmocionesUsuario", new ArrayList<>(emocionesMes));

                startActivity(intent);
            }
        });

        Button btnStatsYear = findViewById(R.id.btnStatsYear);
        btnStatsYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), GraficaBarras.class);

                String añoActual = String.valueOf(calendarView.getCurrentPageDate().get(Calendar.YEAR));

                List<Emocion> emocionesAnio = getEmocionesPorAnio(emociones, añoActual);
                if (emocionesAnio.isEmpty()) {
                    Toast.makeText(v.getContext(), "No hay emociones para el año", Toast.LENGTH_SHORT).show();
                    return;
                }

                intent.putExtra("AnioActual", añoActual);
                intent.putExtra("EmocionesUsuario", new ArrayList<>(emocionesAnio));
                startActivity(intent);
            }
        });


    }


    private List<Emocion> getEmocionesPorMesYAnio(List<Emocion> emociones, String mes, String anio) {
        List<Emocion> emocionesFiltradas = new ArrayList<>();
        for (Emocion emocion : emociones) {
            String[] fechaParts = emocion.getFecha().split("/");
            String emocionMes = fechaParts[1];
            String emocionAnio = fechaParts[0];
            if (emocionMes.equals(mes) && emocionAnio.equals(anio)) {
                emocionesFiltradas.add(emocion);
            }
        }
        return emocionesFiltradas;
    }

    private List<Emocion> getEmocionesPorAnio(List<Emocion> emociones, String anio) {
        List<Emocion> emocionesFiltradas = new ArrayList<>();
        for (Emocion emocion : emociones) {
            String[] fechaParts = emocion.getFecha().split("/");
            String emocionAnio = fechaParts[0];
            if (emocionAnio.equals(anio)) {
                emocionesFiltradas.add(emocion);
            }
        }
        return emocionesFiltradas;
    }


}