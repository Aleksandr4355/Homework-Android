package com.example.filemanagerprojectapplication.Fragnents;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filemanagerprojectapplication.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class CardFragment extends Fragment {
    private TextView tvPathHolder;
    File storage;

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_card, container, false);

        tvPathHolder = view.findViewById(R.id.tv_path_holder);

        // Получаем доступ к внешней памяти телефона
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){ // проверка подключения внешнией памяти телефона
            String internalStorage = Environment.getExternalStorageDirectory().getAbsolutePath(); // получение пути 
            storage = new File(internalStorage);

            tvPathHolder.setText(storage.getAbsolutePath());
            runtimePermission();
        }

        return view;
    }

    private void runtimePermission() {
        // разрешения до API 29
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.Q) {
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 100);
            }
        }
        // разрешения c API 30
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (!Environment.isExternalStorageManager()) {
                try {
                    Uri uri = Uri.fromParts("package", getActivity().getPackageName(), null);
                    Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                    intent.setData(uri);
                    intent.addCategory("android.intent.category.DEFAULT");
                    intent.setData(uri.parse(String.format("package:%s", getActivity().getPackageName())));
                    getActivity().startActivityIfNeeded(intent, 101);
                } catch (Exception e) {
                    Intent intent = new Intent();
                    intent.setAction(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                    getActivity().startActivityIfNeeded(intent, 101);
                }
            }
        }
    }

}