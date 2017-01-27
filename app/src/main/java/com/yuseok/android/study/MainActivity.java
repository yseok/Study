package com.yuseok.android.study;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton mToggle;
    RadioGroup mRadioGroup;
    RadioButton mRadio1,mRadio2,mRadio3;
    TextView mText;
    EditText mEditText;
    CheckBox mCheckBox;
    SeekBar mSeekBar;
    Spinner mSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToggle = (ToggleButton) findViewById(R.id.studyToggle);
        mRadioGroup = (RadioGroup) findViewById(R.id.studyRG);
        mRadio1 = (RadioButton) findViewById(R.id.studyRadio1);
        mRadio2 = (RadioButton) findViewById(R.id.studyRadio2);
        mRadio3 = (RadioButton) findViewById(R.id.studyRadio3);
        mText = (TextView) findViewById(R.id.studyText);
        mEditText = (EditText) findViewById(R.id.studyEdT);
        mCheckBox = (CheckBox) findViewById(R.id.studyCheck);
        mSeekBar = (SeekBar) findViewById(R.id.studySeek);
        mSpinner = (Spinner) findViewById(R.id.studySpinner);

        mToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(isChecked) {
                            mText.setText("Checked");
                        } else {
                            mText.setText("UnChecked");
                }
            }
        });
        mToggle.setOnCheckedChangeListener(new CustomCheckedChangeListener());
        mSeekBar.setMax(1000);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            // Seekbar의 값이 변경될 때마다 호출되는 메소드
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mText.setText(progress/1000);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mSpinner.setAdapter(new SimpleAdapter());
        mSpinner.setOnItemSelectedListener();
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    class CustomCheckedChangeListener implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked) {
                mText.setText("Checked");
            } else {
                mText.setText("UnChecked");
            }
        }
    }
}
