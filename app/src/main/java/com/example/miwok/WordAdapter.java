package com.example.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter (Activity context, ArrayList<Word>words){
        super(context, 0, words);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Word currentWord = getItem(position);
        TextView miwok_text_view  = listItemView.findViewById(R.id.miwok_text_view);
        miwok_text_view.setText(currentWord.getmMiwokTranslation());
        TextView default_text_view = listItemView.findViewById(R.id.default_text_view);
        default_text_view.setText(currentWord.getmDefaultTranslation());
        return listItemView;
    }
}
