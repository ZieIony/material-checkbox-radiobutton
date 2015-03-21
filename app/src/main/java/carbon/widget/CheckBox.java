package carbon.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.util.AttributeSet;

import carbon.drawable.CheckableDrawable;

/**
 * Created by Marcin on 2015-03-06.
 */
public class CheckBox extends android.widget.CheckBox {
    private CheckableDrawable drawable;

    public CheckBox(Context context) {
        this(context, null);
    }

    public CheckBox(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.checkboxStyle);
    }

    public CheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

    public void init(AttributeSet attrs, int defStyleAttr) {
        if (isInEditMode())
            return;

        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.CheckBox, defStyleAttr, 0);

        drawable = new CheckableDrawable(getContext(), R.raw.carbon_checkbox_checked, R.raw.carbon_checkbox_unchecked, R.raw.carbon_checkbox_filled, new PointF(-0.09f, 0.11f));
        setButtonDrawable(getResources().getDrawable(android.R.color.transparent));
        setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);

        ColorStateList csl = a.getColorStateList(R.styleable.CheckBox_carbon_checkColor);
        if (csl != null)
            drawable.setColor(csl);

        setCheckedImmediate(isChecked());

        a.recycle();
    }

    public void setCheckedImmediate(boolean checked) {
        super.setChecked(checked);
        drawable.setCheckedImmediate(checked);
    }

}
