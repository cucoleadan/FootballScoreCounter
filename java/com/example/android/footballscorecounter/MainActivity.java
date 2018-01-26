package com.example.android.footballscorecounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int freeKickTeamA = 0;
    int freeKickTeamB = 0;


    //A lot of thanks to https://discussions.udacity.com/u/Essam12, without his code my app would've reset the score if it wasn't for his code

    // onSaveInstanceState method to save the content of textViews when the mobile switches from portrait mode to landscape mode

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // saving the content of textview using the key
        outState.putInt("savText1", scoreTeamA);
        outState.putInt("savText2", scoreTeamB);
        outState.putInt("savText3", freeKickTeamA);
        outState.putInt("savText4", freeKickTeamB);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        scoreTeamA = savedInstanceState.getInt("savText1");
        scoreTeamB = savedInstanceState.getInt("savText2");
        freeKickTeamA = savedInstanceState.getInt("savText3");
        freeKickTeamB = savedInstanceState.getInt("savText4");


        displayGoalForTeamA(scoreTeamA);
        displayFreeKickForTeamA(freeKickTeamA);
        displayGoalForTeamB(scoreTeamB);
        displayFreeKickForTeamB(freeKickTeamB);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    /**
     * Increase the scoreTeamA for Team A.
     */
    public void addGoalForTeamA(View v) {
        scoreTeamA = scoreTeamA + 1;
        displayGoalForTeamA(scoreTeamA);
    }

    /**
     * Increase the freeKickForTeamA for TeamA by 1.
     */
    public void addFreeKickForTeamA(View v) {
        freeKickTeamA = freeKickTeamA + 1;
        displayFreeKickForTeamA(freeKickTeamA);

    }

    /**
     * Increase the scoreTeamB for Team B.
     */
    public void addGoalForTeamB(View v) {
        scoreTeamB = scoreTeamB + 1;
        displayGoalForTeamB(scoreTeamB);
    }


    /**
     * Increase the freeKickTeamB for Team B by 1.
     */
    public void addFreeKickForTeamB(View v) {
        freeKickTeamB = freeKickTeamB + 1;
        displayFreeKickForTeamB(freeKickTeamB);
    }

    /**
     * * Reset Button
     */

    public void reset(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        freeKickTeamA = 0;
        freeKickTeamB = 0;
        displayGoalForTeamA(scoreTeamA);
        displayGoalForTeamB(scoreTeamB);
        displayFreeKickForTeamA(freeKickTeamA);
        displayFreeKickForTeamB(freeKickTeamB);

    }

    /**
     * Displays the given scoreTeamA for Team A.
     */
    public void displayGoalForTeamA(int scoreTeamA) {
        TextView scoreView = findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(scoreTeamA));
    }

    /**
     * Displays the given freeKickTeamA for Team A.
     */
    public void displayFreeKickForTeamA(int freeKickTeamA) {
        TextView scoreView = findViewById(R.id.team_a_scoreFreeKicks);
        scoreView.setText(String.valueOf(freeKickTeamA));
    }

    /**
     * Displays the given scoreTeamB for Team B.
     */
    public void displayGoalForTeamB(int scoreTeamB) {
        TextView scoreView = findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(scoreTeamB));
    }

    /**
     * Displays the given freeKickTeamB for Team B.
     */

    public void displayFreeKickForTeamB(int freeKickTeamB) {
        TextView scoreView = findViewById(R.id.team_b_scoreFreeKicks);
        scoreView.setText(String.valueOf(freeKickTeamB));
    }
}