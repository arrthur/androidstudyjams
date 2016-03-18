package com.example.arthuravila.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     * Displays the given score for Team A.
     */
    int scoreA;
    int scoreB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_scorea);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_scoreb);
        scoreView.setText(String.valueOf(score));
    }


    public void submit2A(View view){
        scoreA = scoreA+2;
        displayForTeamA(scoreA);


    }

    public void submit3A(View view){
        scoreA = scoreA+3;
        displayForTeamA(scoreA);


    }
    public void freeTrhow(View view){
        scoreA = scoreA+1;
        displayForTeamA(scoreA);

    }

    public void freeTrhowb(View view) {
        scoreB = scoreB+1;
        displayForTeamB(scoreB);

    }

    public void submit2B(View view){
        scoreB = scoreB+2;
        displayForTeamB(scoreB);


    }

    public void submit3B(View view){
        scoreB = scoreB+3;
        displayForTeamB(scoreB);


    }

    public void resetButtom(View view){
        scoreA = 0;
        scoreB = 0;
        displayForTeamA(scoreA);
        displayForTeamB(scoreB);
    }
}
