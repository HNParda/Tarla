package com.vianos_official.tarla.ui.fragments.isciler;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.kizitonwose.calendar.core.CalendarDay;
import com.kizitonwose.calendar.core.DayPosition;
import com.kizitonwose.calendar.view.MonthDayBinder;

import org.w3c.dom.Text;

import java.time.DayOfWeek;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;

public class CalendarView extends View {
    com.kizitonwose.calendar.view.CalendarView calendarView;
    TextView ay;
    LinearLayout gunler;

    public CalendarView(@NonNull Context context) {
        super(context);
    }

    public CalendarView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CalendarView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CalendarView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    public void init(ArrayList<String> highlightedDates) {/*
calendarView = findViewById(R.id)



        calendarView.setDayBinder(new MonthDayBinder<IsciActivity.DayViewContainer>() {
            @Override
            public IsciActivity.DayViewContainer create(View view) {
                return new IsciActivity.DayViewContainer(view);
            }

            @Override
            public void bind(IsciActivity.DayViewContainer container, CalendarDay day) {
                TextView textView = container.textView;
                CardView gunKutu = container.gunKutu;
                textView.setText(String.valueOf(day.getDate().getDayOfMonth()));

                if (day.getPosition() == DayPosition.MonthDate) {
                    gunKutu.setVisibility(View.VISIBLE);
                    if (highlightedDates.contains(day.getDate().toString())) {
                        textView.setBackgroundColor(Color.BLUE);
                    } else {
                        textView.setBackgroundColor(Color.TRANSPARENT);
                    }
                } else {
                    gunKutu.setVisibility(View.INVISIBLE);
                }

            }
        });

        calendarView.setMonthScrollListener(month -> {
            String formatted = month.getYearMonth().getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault())
                    + " " + month.getYearMonth().getYear();
            ay.setText(formatted);
            return null;
        });


        YearMonth currentMonth = YearMonth.now();
        YearMonth startMonth = currentMonth.minusMonths(3);
        YearMonth endMonth = currentMonth.plusMonths(3);

        calendarView.setup(startMonth, endMonth, DayOfWeek.MONDAY);
        calendarView.scrollToMonth(currentMonth);

        for (DayOfWeek day : DayOfWeek.values()) {
            TextView textView = new TextView(this);
            textView.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
            textView.setText(day.getDisplayName(TextStyle.SHORT, Locale.getDefault())); // z. B. "Mo"
            textView.setGravity(Gravity.CENTER);
            textView.setTextColor(Color.DKGRAY);
            textView.setTextSize(14);
            gunler.addView(textView);
        }*/
    }
}
