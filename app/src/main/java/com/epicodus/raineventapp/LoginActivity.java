package com.epicodus.raineventapp;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

        import butterknife.Bind;
        import butterknife.ButterKnife;

        public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
        @Bind(R.id.signInButton) Button mSignInButton;

               @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_login);

                        ButterKnife.bind(this);
                mSignInButton.setOnClickListener(this);
           }

                @Override
        public void onClick(View v) {
                if(v == mSignInButton) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
            }
    }