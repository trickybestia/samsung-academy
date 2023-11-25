package com.trickybestia.coolmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.RadioButton;

import com.trickybestia.coolmarket.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<CheckBox> goods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater layoutInflater = getLayoutInflater();
        ActivityMainBinding binding = ActivityMainBinding.inflate(layoutInflater);

        setContentView(binding.getRoot());

        goods = new ArrayList<>();

        for (int i = 0; i != 5; i++) {
            CheckBox good = (CheckBox) layoutInflater.inflate(R.layout.good, binding.goods, false);

            good.setText(String.format("Товар %d", i + 1));

            goods.add(good);
            binding.goods.addView(good);
        }

        binding.clear.setOnClickListener(b -> {
            goods.forEach(good -> good.setChecked(false));

            binding.deliveryMethod.clearCheck();
            binding.comment.setText("");
        });

        binding.order.setOnClickListener(button -> {
            int deliveryMethodButtonId = binding.deliveryMethod.getCheckedRadioButtonId();
            if (deliveryMethodButtonId == -1) return;

            String selectedDeliveryMethod = ((RadioButton) findViewById(deliveryMethodButtonId)).getText().toString();

            String message = "Товары:\n";
            boolean anyGoodSelected = false;

            for (int i = 0; i != goods.size(); i++) {
                CheckBox good = goods.get(i);

                if (good.isChecked()) {
                    message += String.format("- %s%n", good.getText());

                    anyGoodSelected = true;
                }
            }

            if (!anyGoodSelected) return;

            message += "Способ получения: " + selectedDeliveryMethod + "\n";

            String comment = binding.comment.getText().toString();

            if (!comment.isEmpty()) {
                message += "Комментарий: " + binding.comment.getText();
            }

            new AlertDialog.Builder(this).setMessage(message).setTitle("Информация о заказе").create().show();
        });
    }
}