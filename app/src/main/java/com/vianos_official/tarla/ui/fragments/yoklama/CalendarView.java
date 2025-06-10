package com.vianos_official.tarla.ui.fragments.yoklama;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.google.android.material.card.MaterialCardView;
import com.kizitonwose.calendar.core.CalendarDay;
import com.kizitonwose.calendar.core.DayPosition;
import com.kizitonwose.calendar.view.MonthDayBinder;
import com.kizitonwose.calendar.view.ViewContainer;
import com.vianos_official.tarla.R;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;

public class CalendarView extends LinearLayout {

    View view;

    com.kizitonwose.calendar.view.CalendarView calendarView;
    TextView ay;
    LinearLayout gunler;

    public CalendarView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public CalendarView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CalendarView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public CalendarView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    public void init(Context context) {
        view = inflate(getContext(), R.layout.calendar, this);

        calendarView = view.findViewById(R.id.calendar);
        ay = view.findViewById(R.id.ay);
        gunler = view.findViewById(R.id.gunler);


        for (DayOfWeek day : DayOfWeek.values()) {
            TextView textView = new TextView(context);
            textView.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
            textView.setText(day.getDisplayName(TextStyle.SHORT, Locale.getDefault())); // z. B. "Mo"
            textView.setGravity(Gravity.CENTER);
            textView.setTextColor(Color.WHITE);
            textView.setTextSize(14);
            gunler.addView(textView);
        }
    }

    public void show(ArrayList<String> yoklama, ArrayList<String> odeme) {


        calendarView.setDayBinder(new MonthDayBinder<DayViewContainer>() {
            @Override
            public DayViewContainer create(View view) {
                return new DayViewContainer(view);
            }

            @Override
            public void bind(DayViewContainer container, CalendarDay day) {
                TextView textView = container.textView;
                MaterialCardView cardView = container.cardView;
                textView.setText(String.valueOf(day.getDate().getDayOfMonth()));

                if (day.getDate().equals(LocalDate.now())) {
                    cardView.setStrokeWidth(6);
                    cardView.setStrokeColor(Color.WHITE);
                    textView.setTypeface(Typeface.DEFAULT_BOLD);

                }

                if (day.getPosition() == DayPosition.MonthDate) {
                    textView.setTextColor(Color.WHITE);
                    if (odeme.contains(day.getDate().toString())) {
                        textView.setBackgroundColor(Color.GREEN);
                        textView.setTextColor(Color.BLACK);
                    } else if (yoklama.contains(day.getDate().toString())) {
                        textView.setBackgroundColor(Color.YELLOW);
                        textView.setTextColor(Color.BLACK);
                    } else {
                        textView.setBackgroundColor(Color.TRANSPARENT);
                    }
                } else {
                    textView.setTextColor(Color.DKGRAY);
                }

            }
        });


        YearMonth currentMonth = YearMonth.now();
        YearMonth startMonth = currentMonth.minusMonths(3);
        YearMonth endMonth = currentMonth.plusMonths(3);

        calendarView.setup(startMonth, endMonth, DayOfWeek.MONDAY);
        calendarView.scrollToMonth(currentMonth);

        calendarView.setMonthScrollListener(month -> {
            String formatted = month.getYearMonth().getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault()) + " " + month.getYearMonth().getYear();
            ay.setText(formatted);
            return null;
        });


    }

    public static class DayViewContainer extends ViewContainer {
        public final TextView textView;
        public final MaterialCardView cardView;

        public DayViewContainer(View view) {
            super(view);
            textView = view.findViewById(R.id.calendarDayText);
            cardView = view.findViewById(R.id.card);
        }
    }

}
