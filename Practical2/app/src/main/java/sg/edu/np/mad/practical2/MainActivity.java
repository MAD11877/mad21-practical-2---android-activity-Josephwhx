package sg.edu.np.mad.practical2;


import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";
    //Create user Object
    User user1 = new User("MAD", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", 1, false);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get username text by id
        TextView userName = findViewById(R.id.userName);
        //Update username on view
        userName.setText(user1.name);

        //Get description text by id
        TextView description = findViewById(R.id.userDescription);
        //Update the description
        description.setText(user1.description);

        //Get follow button by id
        Button followButton = findViewById(R.id.followButton);
        //Update text on button by calling function
        checkFollowStatus(user1.followed, followButton);

        //Create on click function
        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Update follow status
                if(user1.followed == true){
                    user1.followed = false;
                }
                else if(user1.followed == false){
                    user1.followed = true;
                }
                //Call function to update the text on button
                checkFollowStatus(user1.followed, followButton);

            }
        });
    }
    //function to check and update follow button
    private void checkFollowStatus(boolean followed, Button followButton) {
        if(followed == true){
            followButton.setText("Unfollow");
        }
        else {
            followButton.setText("Follow");
        }
    }

}