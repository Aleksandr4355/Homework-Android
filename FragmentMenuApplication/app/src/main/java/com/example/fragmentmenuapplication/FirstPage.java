package com.example.fragmentmenuapplication;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Rating;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstPage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstPage extends Fragment {

    RatingBar ratingBar;
    Button ratingButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first_page, container, false);

        ratingBar = view.findViewById(R.id.ratingBar);
        ratingButton = view.findViewById(R.id.rating_btn);

        Spinner spinnerColors;
        Button buttonFindDescription;
        TextView textViewDescription;

        SeekBar seekBar;
        TextView textView;

        SeekBar seekBarDescription;
        TextView textSize;

        FloatingActionButton fab;

        ratingButton.setOnClickListener(v -> {
            Float value = ratingBar.getRating();
            Toast.makeText(getContext(),"Rating" + value, Toast.LENGTH_SHORT).show();
        });

        spinnerColors = view.findViewById(R.id.spinner_list);
        buttonFindDescription  = view.findViewById(R.id.button_find_description);
        textViewDescription = view.findViewById(R.id.text_view_description);
        fab = view.findViewById(R.id.fab);

        buttonFindDescription.setOnClickListener(v -> {
            int position = spinnerColors.getSelectedItemPosition();
            String description = getDescriptionPosition(position);
            textViewDescription.setText(description);
            String colors = getColors(position);
            buttonFindDescription.setBackgroundColor(Color.parseColor(colors));
        });

        seekBar = view.findViewById(R.id.seekBar);
        textView = view.findViewById(R.id.textView3);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView.setText(progress + "/100");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getContext(), "min", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getContext(), "max", Toast.LENGTH_SHORT).show();
            }
        });

        seekBarDescription = view.findViewById(R.id.seekBar2);
        textSize = view.findViewById(R.id.textView4);

        seekBarDescription.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textSize.setTextSize(progress  * 3);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        fab.setOnClickListener(v -> {
           showBottomDialog();
        });

        return view;
    }

    private  void  showBottomDialog(){
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.nottom_sheet_layout);

        TextView second = dialog.findViewById(R.id.second);
        TextView third = dialog.findViewById(R.id.third);
        TextView fourth = dialog.findViewById(R.id.fourth);

        second.setOnClickListener(v -> {
            dialog.dismiss();
            replaceFragment(new SecondPage());
        });
        third.setOnClickListener(v -> {
            dialog.dismiss();
            replaceFragment(new ThirdPage());
        });
        fourth.setOnClickListener(v -> {
            dialog.dismiss();
            replaceFragment(new FouthPage());
        });

        dialog.show();

        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.dialogAnimatib;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

    private String getDescriptionPosition(int position){
        String [] description =  getResources().getStringArray(R.array.description_of_temp);
        return description[position];
    }

    private String getColors(int position){
        String [] description =  getResources().getStringArray(R.array.colors_button);
        return description[position];
    }
}