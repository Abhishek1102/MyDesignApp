package com.example.mydesignapp.helper;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Spinner;

public class CustomSpinner extends Spinner {

    public CustomSpinner(Context context) {
        super(context);
        applyCustomFont(context);
    }

    public CustomSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context);
    }

    public CustomSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = com.example.mydesignapp.helper.FontCache.getTypeface("GothicA1-SemiBold.ttf", context);
        setTypeface(customFont);
    }

    private void setTypeface(Typeface customFont) {
    }
}
