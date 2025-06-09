package com.vianos_official.tarla.ui.fragments.isciler;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.kizitonwose.calendar.core.CalendarDay;
import com.kizitonwose.calendar.view.CalendarView;
import com.kizitonwose.calendar.view.MonthDayBinder;
import com.kizitonwose.calendar.view.ViewContainer;
import com.vianos_official.tarla.Isci;
import com.vianos_official.tarla.R;
import com.vianos_official.tarla.ui.MainActivity;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class IsciActivity extends AppCompatActivity {

    Isci isci;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isci);

        int index = getIntent().getIntExtra("isci_id", 0);
        isci = MainActivity.liste.get(index);

        CalendarView calendarView = findViewById(R.id.yoklama);


        ArrayList<String> highlightedDates = isci.YOKLAMA;

        calendarView.setDayBinder(new MonthDayBinder<DayViewContainer>() {
            @Override
            public DayViewContainer create(View view) {
                return new DayViewContainer(view);
            }

            @Override
            public void bind(DayViewContainer container, CalendarDay day) {
                TextView textView = container.textView;
                textView.setText(String.valueOf(day.getDate().getDayOfMonth()));


                // if (day.getDate().getMonth() == DayOwner.THIS_MONTH) {
                if (true) {
                    textView.setVisibility(View.VISIBLE);
                    if (highlightedDates.contains(day.getDate().toString())) {
                        textView.setBackgroundColor(Color.YELLOW);
                    } else {
                        textView.setBackgroundColor(Color.TRANSPARENT);
                    }
                } else {
                    textView.setVisibility(View.INVISIBLE);
                }

            }
        });

        YearMonth currentMonth = YearMonth.now();
        YearMonth startMonth = currentMonth.minusMonths(3);
        YearMonth endMonth = currentMonth.plusMonths(3);

        calendarView.setup(startMonth, endMonth, DayOfWeek.MONDAY);
        calendarView.scrollToMonth(currentMonth);
    }


    public static class DayViewContainer extends ViewContainer {
        public final TextView textView;

        public DayViewContainer(View view) {
            super(view);
            textView = view.findViewById(R.id.calendarDayText);
        }
    }
}
