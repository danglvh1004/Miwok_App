package com.example.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(Activity context, ArrayList<Word> words) {
        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Chech if an existing view is being reused, otherwise infate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        // get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout wuth the ID miwok_text_view.
        TextView miwok_text_view = listItemView.findViewById(R.id.miwok_text_view);
        //Get thw Miwok translation from the currentWord object and set this text on the Miwok TextView.
        miwok_text_view.setText(currentWord.getmMiwokTranslation());

        // Find the TextView in the list_item.xml layout wuth the ID default_text_view.
        TextView default_text_view = listItemView.findViewById(R.id.default_text_view);
        //Get thw default translation from the currentWord object and set this text on the default TextView.
        default_text_view.setText(currentWord.getmDefaultTranslation());

        //Find the ImageView on the list_item.xml layout with the ID image.
        ImageView imageView = listItemView.findViewById(R.id.image);
        if (currentWord.hasImage()) {
            //Set the ImageView to the image resource specified in the current Word.
            imageView.setImageResource(currentWord.getmImageResourceId());
            //Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        //Return the whole list item layout (containing 2 TextViews) so that it can be shown in the ListView.
        return listItemView;
    }
}
