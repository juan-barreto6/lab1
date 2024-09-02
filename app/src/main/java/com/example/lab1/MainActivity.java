package com.example.lab1;
import java.util.Arrays;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ProjectType[] projectTypes = {
                new ProjectType("Infraestructura", new String[]{"Parques", "Zonas verdes", "Vías"}),
                new ProjectType("Recreación", new String[]{"Ciclorrutas", "Parques"})
        };

        Spinner spinnerProjectTypes = findViewById(R.id.spinnerProjectTypes);
        ListView listViewInterventions = findViewById(R.id.listViewInterventions);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                Arrays.stream(projectTypes).map(ProjectType::getName).toArray(String[]::new));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerProjectTypes.setAdapter(adapter);

        spinnerProjectTypes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] interventions = projectTypes[position].getInterventions();
                ArrayAdapter<String> interventionsAdapter = new ArrayAdapter<>(MainActivity.this,
                        android.R.layout.simple_list_item_1, interventions);
                listViewInterventions.setAdapter(interventionsAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
