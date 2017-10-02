package toong.vn.androidfragmentanimation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_go_to_fragment_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToFragment(new Fragment1());
            }
        });
    }

    public void goToFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        // *** Animation Fade In/Fade Out **/
        //      ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,
        //                android.R.anim.fade_in, android.R.anim.fade_out);

        // *** Animation Slide Right Left **/
        ft.setCustomAnimations(R.anim.slide_right_in, R.anim.slide_left_out, R.anim.slide_left_in,
                R.anim.slide_right_out);

        // *** Animation Bottom Up **/
        //        ft.setCustomAnimations(R.anim.slide_bottom_in, R.anim.slide_top_out,
        //                R.anim.slide_top_in, R.anim.slide_bottom_out);
        ft.replace(R.id.frame, fragment).addToBackStack("").commit();
    }

    public void pop() {
        getFragmentManager().popBackStack();
    }
}
