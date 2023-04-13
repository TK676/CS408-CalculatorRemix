package edu.jsu.mcis.cs408.calculatorremix;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import edu.jsu.mcis.cs408.calculatorremix.databinding.FragmentTemperatureBinding;

public class FragmentTemperature extends Fragment {

    public static final String ARG_ID = "id";
    private FragmentTemperatureBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentTemperatureBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editFahrenheit = binding.enterFahrenheit;
                EditText editCelsius = binding.enterCelsius;

                String fahrenheit = editFahrenheit.getText().toString();
                String celsius = editCelsius.getText().toString();

                boolean hasFahrenheit = !fahrenheit.isEmpty();
                boolean hasCelsius = !celsius.isEmpty();

                if (!hasFahrenheit && !hasCelsius) {
                    Toast.makeText(getContext(), "All of the fields must be filled", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (hasFahrenheit) {
                        try {
                            editCelsius.setText(TemperatureConverter.fahrenheitToCelsius(Double.valueOf(fahrenheit)));
                        }
                        catch (NumberFormatException nfe) {
                            displayNonNumericError();
                        }
                    }
                    else if (hasCelsius) {
                        try {
                            editFahrenheit.setText(TemperatureConverter.celsiusToFahrenheit(Double.valueOf(celsius)));
                        }
                        catch (NumberFormatException nfe) {
                            displayNonNumericError();
                        }
                    }
                }
            }
        });
    }

    private void displayNonNumericError() {
        Toast.makeText(getContext(), "Both fields must contain numeric values", Toast.LENGTH_SHORT).show();
    }
}