package com.example.android.firebaserecyclerview;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.Query;

/**
 * Created by ccteuser on 4/17/17.
 */

public class SchoolOfEducationAdapter extends FirebaseRecyclerAdapter<SchoolOfEducation, SchoolOfEducationViewHolder> {

    public SchoolOfEducationAdapter(Query ref) {
        super(SchoolOfEducation.class, R.layout.card_view_school_of_education, SchoolOfEducationViewHolder.class, ref);
    }


    @Override
    protected void populateViewHolder(SchoolOfEducationViewHolder viewHolder, SchoolOfEducation school, int position) {
        viewHolder.bind(school);
    }

}
