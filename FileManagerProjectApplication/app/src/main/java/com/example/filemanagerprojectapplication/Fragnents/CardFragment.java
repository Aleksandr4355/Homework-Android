package com.example.filemanagerprojectapplication.Fragnents;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Environment;
import android.provider.Settings;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.filemanagerprojectapplication.FileAdapter;
import com.example.filemanagerprojectapplication.FileOpener;
import com.example.filemanagerprojectapplication.OnFileSelectedListener;
import com.example.filemanagerprojectapplication.R;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;


public class CardFragment extends Fragment implements OnFileSelectedListener {
    private TextView tvPathHolder;
    File storage;
    View view;
    private RecyclerView recyclerView;
    private List<File> fileList;
    String data;
    private FileAdapter fileAdapter;
    String[] items = {"Details", "Rename", "Delete"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_card, container, false);

        tvPathHolder = view.findViewById(R.id.tv_path_holder_sd_card);

        // Получаем доступ к внешней памяти телефона
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) { // проверка подключения внешнией памяти телефона
            File[] externalDirs = ContextCompat.getExternalFilesDirs(getContext(), null); // получение пути
            storage = new File(externalDirs[1].getAbsolutePath().split("/Android")[0]);

            if (getArguments() != null) {
                data = getArguments().getString("path");
                storage = new File(data);
            }

            tvPathHolder.setText("SD-card:" + storage.getAbsolutePath().trim());
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
//            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
//                displayFiles();
//            }
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
            }
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                displayFiles();
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
            if (Environment.isExternalStorageManager()) {
                displayFiles();
            }
        }
    }

    public ArrayList<File> findFiles(File file) {
        ArrayList<File> arrayList = new ArrayList<>();
        File[] files = file.listFiles();
        for (File singleFile : files) {
            if (singleFile.isDirectory() && !singleFile.isHidden()) {
                arrayList.add(singleFile);
            }
        }
        for (File singleFile : files) {
            if (singleFile.getName().toLowerCase().endsWith(".jpeg") ||
                    singleFile.getName().toLowerCase().endsWith(".jpg") ||
                    singleFile.getName().toLowerCase().endsWith(".png") ||
                    singleFile.getName().toLowerCase().endsWith(".mp3") ||
                    singleFile.getName().toLowerCase().endsWith(".wav") ||
                    singleFile.getName().toLowerCase().endsWith(".mp4") ||
                    singleFile.getName().toLowerCase().endsWith(".pdf") ||
                    singleFile.getName().toLowerCase().endsWith(".doc") ||
                    singleFile.getName().toLowerCase().endsWith(".apk")) {
                arrayList.add(singleFile);
            }
        }
        return arrayList;
    }

    private void displayFiles() {
        recyclerView = view.findViewById(R.id.recycler_sd_card);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        fileList = new ArrayList<>();
        fileList.addAll(findFiles(storage));
        fileAdapter = new FileAdapter(getContext(), fileList, this);
        recyclerView.setAdapter(fileAdapter);
    }

    @Override
    public void onFileClicked(File file) {
        if (file.isDirectory()) {
            Bundle bundle = new Bundle();
            bundle.putString("path", file.getAbsolutePath());
            CardFragment cardFragment = new CardFragment();
            cardFragment.setArguments(bundle);

            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, cardFragment)
                    .addToBackStack(null).commit();
        } else {
            try {
                FileOpener.openFile(getContext(), file);
            } catch (Exception e) {
                Toast.makeText(getContext(), "Unable to open file", Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    public void onFileLongClicked(File file, int position) {
        final Dialog optionDialog = new Dialog(getContext());
        optionDialog.setContentView(R.layout.option_dialog);
        optionDialog.setTitle("Select Option.");
        ListView option = optionDialog.findViewById(R.id.list);

        CustomAdapter customAdapter = new CustomAdapter();
        option.setAdapter(customAdapter);
        optionDialog.show();

        option.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();

                switch (selectedItem) {

                    case "Details":
                        AlertDialog.Builder detailDialog = new AlertDialog.Builder(getContext());
                        detailDialog.setTitle("Details");
                        final TextView details = new TextView(getContext());
                        detailDialog.setView(details);

                        Date lastMod = new Date(file.lastModified());
                        SimpleDateFormat formatted = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                        String formattedDate = formatted.format(lastMod);

                        details.setText(String.format("File Name: %s \nSize: %s\nPath: %s\nLast Modified Date: %s", file.getName(), Formatter.formatShortFileSize(getContext(), file.length()), file.getAbsolutePath(), formattedDate));

                        details.setPadding(70, 10, 10, 10);
                        detailDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                optionDialog.cancel();
                            }
                        });

                        AlertDialog alertDialogDetails = detailDialog.create();
                        alertDialogDetails.show();
                        break;


//                    case "Rename":
//                        AlertDialog.Builder renameDialog = new AlertDialog.Builder(getContext());
//                        renameDialog.setTitle("Rename file: ");
//                        final EditText name = new EditText(getContext());
//                        renameDialog.setView(name);
//
//                        renameDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                String newName = name.getEditableText().toString();
//                                File current = new File(file.getAbsolutePath());
//                                File destinationSdCard;
//
//                                if (!file.isDirectory()) {
//                                    String extension = file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("."));
//                                    destinationSdCard = new File(file.getAbsolutePath().replace(file.getName(), newName) + extension);
//                                } else {
//                                    destinationSdCard = new File(file.getAbsolutePath().replace(file.getName(), newName));
//                                }
//
//                                if (current.renameTo(destinationSdCard)) {
//                                    fileList.set(position, destinationSdCard);
//                                    fileAdapter.notifyItemChanged(position);
//                                    Toast.makeText(getContext(), "Renamed!", Toast.LENGTH_SHORT).show();
//                                    displayFiles();
//                                } else {
//                                    Toast.makeText(getContext(), "Couldn't Rename!", Toast.LENGTH_SHORT).show();
//                                }
//                            }
//                        });
//
//                        renameDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                optionDialog.cancel();
//                            }
//                        });
//
//                        AlertDialog alertDialogRename = renameDialog.create();
//                        alertDialogRename.show();
//                        break;

//========================================RENAME====================================================
                    // если нажали Rename
                    case "Rename":
                        AlertDialog.Builder renameDialog = new AlertDialog.Builder(getContext());// renameDialog просто название
                        renameDialog.setTitle("Rename File:");
                        final EditText name = new EditText(getContext());
                        renameDialog.setView(name);

                        // добавляем кнопку Ок с обработчиком нажатия на нее
                        renameDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Шаг 1: Получаем новое имя от пользователя
                                String newName = name.getEditableText().toString().trim();
                                File parentDir = file.getParentFile();
                                String extension = "";
                                if (file.isFile()) {
                                    int dotIndex = file.getName().lastIndexOf(".");
                                    if (dotIndex != -1) {
                                        extension = file.getName().substring(dotIndex);
                                    }
                                }
                                File destination = new File(parentDir, newName + extension);
                                if (file.renameTo(destination)) {
                                    Toast.makeText(getContext(), "Renamed!", Toast.LENGTH_SHORT).show();
                                    displayFiles();
                                } else {
                                    Toast.makeText(getContext(), "Rename Error!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        // добавляем кнопку Cancel с обработчиком нажатия на нее
                        renameDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                optionDialog.cancel(); // жмем Cancel и окно Rename закрывается
                            }
                        });
                        AlertDialog alertDialogRenaime = renameDialog.create(); //вызываем AlertDialog. это для Renaim
                        alertDialogRenaime.show();
                        break;


                    case "Delete":
                        AlertDialog.Builder deleteDialog = new AlertDialog.Builder(getContext());
                        deleteDialog.setTitle("Delete " + file.getName() + "?");

                        deleteDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                file.delete();
                                displayFiles();
                                Toast.makeText(getContext(), "Delete file: " + file.getName(), Toast.LENGTH_SHORT).show();
                            }
                        });

                        deleteDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                optionDialog.cancel();
                            }
                        });
                        AlertDialog alertDialogDelete = deleteDialog.create();
                        alertDialogDelete.show();
                }
            }
        });
    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return items.length;
        }

        @Override
        public Object getItem(int position) {
            return items[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View myView = getLayoutInflater().inflate(R.layout.option_layout, null);
            TextView txtOption = myView.findViewById(R.id.option_text);
            ImageView imgOption = myView.findViewById(R.id.option_img);

            txtOption.setText(items[position]);
            if (items[position].equals("Details")) {
                imgOption.setImageResource(R.drawable.outline_chat_info_24);
            } else if (items[position].equals("Rename")) {
                imgOption.setImageResource(R.drawable.rename_img);
            } else if (items[position].equals("Delete")) {
                imgOption.setImageResource(R.drawable.delete_img);
            }

            return myView;
        }
    }
}