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
public class RadioButton extends android.widget.RadioButton {
    private CheckableDrawable drawable;

    public RadioButton(Context context) {
        this(context, null);
    }

    public RadioButton(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.radioButtonStyle);
    }

    public RadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

    public void init(AttributeSet attrs, int defStyleAttr) {
        if (isInEditMode())
            return;

        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.RadioButton, defStyleAttr, 0);

        drawable = new CheckableDrawable(getContext(), R.raw.carbon_radiobutton_checked, R.raw.carbon_radiobutton_unchecked, R.raw.carbon_radiobutton_filled, new PointF(0, 0));
        setButtonDrawable(getResources().getDrawable(android.R.color.transparent));
        setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);

        ColorStateList csl = a.getColorStateList(R.styleable.RadioButton_carbon_radioColor);
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
