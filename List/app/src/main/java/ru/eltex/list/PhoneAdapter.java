package ru.eltex.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PhoneAdapter extends ArrayAdapter<User> {
    private Context context;
    private User[] users;

    public PhoneAdapter(Context context, User[] users) {
        super(context, R.layout.item, users);
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inf.inflate(R.layout.item, parent, false);

        TextView name = (TextView) view.findViewById(R.id.name);
        name.setText(this.users[position].getName());

        TextView phone = (TextView) view.findViewById(R.id.phone);
        phone.setText(this.users[position].getPhone());

        ImageView imageView = (ImageView) view.findViewById(R.id.avatar);
        if (this.users[position] instanceof Developer) {  //this user is Developer class?
            imageView.setImageResource(R.drawable.developer_image);
        } else if (this.users[position] instanceof Manager) {  //this user is Manager class?
            imageView.setImageResource(R.drawable.manager);
        } else {
            imageView.setImageResource(R.drawable.user);
        }

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, users[position].getName(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
