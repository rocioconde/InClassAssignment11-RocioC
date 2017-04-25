package com.example.android.firebaserecyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ccteuser on 4/17/17.
 */

public class SchoolOfEducationViewHolder extends RecyclerView.ViewHolder {

    private CardView cardView;
    private TextView schoolNameText;
    private TextView schoolEnrollmentText;
    private TextView schoolYearOfFoundationText;
    private Context context;


    public SchoolOfEducationViewHolder(View itemView) {
        super(itemView);
        cardView = (CardView) itemView.findViewById(R.id.card_view);
        schoolNameText = (TextView) itemView.findViewById(R.id.school_name);
        schoolEnrollmentText = (TextView) itemView.findViewById(R.id.school_enrollment);
        schoolYearOfFoundationText = (TextView) itemView.findViewById(R.id.school_year_of_foundation);
        this.context = itemView.getContext();
    }


    public void bind(final SchoolOfEducation school) {
        schoolNameText.setText(school.name);
        schoolEnrollmentText.setText("Total Enrollment: " + school.totalEnrollment);
        schoolYearOfFoundationText.setText("Year of Foundation: " + school.yearOfFoundation);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, schoolNameText.getText(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra(Keys.GSE, school);
                context.startActivity(intent);
            }
        });
    }

}
