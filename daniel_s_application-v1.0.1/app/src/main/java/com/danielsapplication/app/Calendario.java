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
        emociones.add(new Emocion("Felicidad", 100, R.drawable.img_image_1,"Ya salio la tarea :D","2024/05/09"));
        emociones.add(new Emocion("Felicidad", 100, R.drawable.img_image_1,"Ya salio la tarea :D","2024/05/09"));




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
                Toast.makeText(this, "No hay enventos registrados", Toast.LENGTH_SHORT).show();
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


    }

}