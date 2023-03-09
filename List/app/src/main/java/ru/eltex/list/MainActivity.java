package ru.eltex.list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

enum Role {
    user,
    developer,
    manager;
}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView mainList = (ListView) findViewById(R.id.main_list);

        User[] users = {
                new User("Ivan", "007"),
                new Developer("Mike", "3600"),
                new User("Stepan", "777"),
                new Manager("Vika", "1200"),
                new Developer("Maksim", "2400")
        };

        PhoneAdapter phoneAdapter = new PhoneAdapter(this, users);
        mainList.setAdapter(phoneAdapter);

        mainList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getApplicationContext(), users[position].getInfo(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}