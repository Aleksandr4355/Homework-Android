package com.example.contectapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

//    ImageView phoneText = findViewById(R.id.contact_number_dial);
//    TextView phoneTV = findViewById(R.id.phone_tv);

    private FloatingActionButton fab;

    private RecyclerView contactRV;
    private DBHelper dbHelper;
    private AdapterContact adapterContact;

    private String sortByNewest = Contacts.C_ADDED_TIME + " DESC";
    private String sortByOldest = Contacts.C_ADDED_TIME + " ASC";

    private String sortByNameASC = Contacts.C_NAME + " ASC";
    private String sortByNameDESC = Contacts.C_NAME + " DESC";

    private String currentSort = sortByNewest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        dbHelper = new DBHelper(this);

        fab = findViewById(R.id.fab);
        contactRV = findViewById(R.id.contact_rv);

        contactRV.setHasFixedSize(true);

        fab.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddEditContact.class);
            intent.putExtra("isEditMode", false);
            startActivity(intent);
        });

//        phoneText.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String phoneNumber = phoneTV.getText().toString();
//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:" + phoneNumber));
//                startActivity(intent);
//            }
//        });

        loadData(currentSort);
    }

    private void loadData(String currentSort) {
        adapterContact = new AdapterContact(this, dbHelper.getAllData(currentSort));
        contactRV.setAdapter(adapterContact);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData(currentSort);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_top_menu, menu);

        MenuItem item = menu.findItem(R.id.search_contact);

        SearchView searchView = (SearchView) item.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchContact(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchContact(newText);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private void searchContact(String query) {
        adapterContact = new AdapterContact(this, dbHelper.getSearchContact(query));
        contactRV.setAdapter(adapterContact);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.delete_all_contact) {
            dbHelper.deleteAllContact();
            onResume();
        } else if (item.getItemId() == R.id.sort_contact) {
            sortDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    private void sortDialog() {
        String[] option = {"Newest", "Oldest", "Name ASC", "Name DESC"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Sort By");
        builder.setItems(option, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    loadData(sortByNewest);
                } else if (which == 1) {
                    loadData(sortByOldest);
                } else if (which == 2) {
                    loadData(sortByNameASC);
                } else if (which == 3) {
                    loadData(sortByNameDESC);
                }
            }
        });
        builder.create().show();
    }
}