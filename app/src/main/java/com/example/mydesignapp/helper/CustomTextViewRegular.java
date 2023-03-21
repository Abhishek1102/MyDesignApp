package com.example.mydesignapp.helper;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

public class CustomTextViewRegular extends TextView {
    public CustomTextViewRegular(Context context) {
        super(context);
        applyCustomFont(context);

    }

    public CustomTextViewRegular(Context context, AttributeSet attrs) {
        super(context, attrs); applyCustomFont(context);
    }

    public CustomTextViewRegular(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyCustomFont(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomTextViewRegular(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = com.example.mydesignapp.helper.FontCache.getTypeface("CustomTextViewRegular", context);
        setTypeface(customFont);
    }
}
