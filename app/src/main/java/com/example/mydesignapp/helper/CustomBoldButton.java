package com.example.mydesignapp.helper;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatButton;

public class CustomBoldButton extends AppCompatButton {

    public CustomBoldButton(Context context) {
        super(context);
        applyCustomFont(context);
    }

    public CustomBoldButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context);
    }

    public CustomBoldButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = com.example.mydesignapp.helper.FontCache.getTypeface("PlayfairDisplay-Bold.ttf", context);
        setTypeface(customFont);
    }
}
