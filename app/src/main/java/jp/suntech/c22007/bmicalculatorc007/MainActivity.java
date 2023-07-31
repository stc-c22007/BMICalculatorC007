package jp.suntech.c22007.bmicalculatorc007;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HelloListener0 listener0 = new HelloListener0();
        HelloListener listener = new HelloListener();
        Button btClear = findViewById(R.id.btClear);
        Button btKeisan = findViewById(R.id.btKeisan);
        //button.setOnClickListener(new ButtonClickListener());
        btKeisan.setOnClickListener(listener0);
        btClear.setOnClickListener(listener);

    }

    private class HelloListener0 implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            EditText input = findViewById(R.id.etAge1);
            EditText input1 = findViewById(R.id.etHeight1);
            EditText input2 = findViewById(R.id.etWeight1);

            TextView output =findViewById(R.id.etResult);
            TextView output1 =findViewById(R.id.etResult1);
            TextView output2 =findViewById(R.id.etResult2);
            TextView output3 =findViewById(R.id.etResult3);

            String inputStr = input.getText().toString();
            String inputStr2 = input1.getText().toString();
            String inputStr3 = input2.getText().toString();

            float f =Float.parseFloat(inputStr);
            float f1 =Float.parseFloat(inputStr2);
            float f2 =Float.parseFloat(inputStr3);


            if(f<16){
                OrderConfirmDialogFragment dialogFragment = new OrderConfirmDialogFragment();
                dialogFragment.show(getSupportFragmentManager(),"OrderConfirmDialogFragment");
            }

            float BMI = f2/((f1/100)*(f1/100));
            String str = "なし";
            Float weight = ((f1/100)*(f1/100))*22;
            String str2 = String.format("%.1f",weight);


            if(BMI>=40){
                str = "肥満（4度）";
            } else if (BMI>=35) {
                str = "肥満（3度）";
            } else if (BMI>=30) {
                str = "肥満（2度）";
            } else if (BMI>=25) {
                str = "肥満（1度）";
            } else if (BMI>=18.5) {
                str = "普通体重";
            }else{
                str = "低体重";
            }
            output.setText("あなたの肥満度は");
            output1.setText(str);
            output2.setText("あなたの適正体重は");
            output3.setText("    "+str2+"kg");
        }
    }
    private class HelloListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            EditText input = findViewById(R.id.etAge1);
            EditText input1 = findViewById(R.id.etHeight1);
            EditText input2 = findViewById(R.id.etWeight1);
            TextView output = findViewById(R.id.etResult);
            TextView output1 = findViewById(R.id.etResult1);
            TextView output2 = findViewById(R.id.etResult2);
            TextView output3 = findViewById(R.id.etResult3);

            input.setText("");
            input1.setText("");
            input2.setText("");
            output.setText("");
            output1.setText("");
            output2.setText("");
            output3.setText("");
        }
    }

}