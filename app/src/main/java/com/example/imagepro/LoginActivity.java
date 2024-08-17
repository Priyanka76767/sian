package com.example.imagepro;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.imagepro.databinding.ActivityLoginBinding;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import kotlin.jvm.internal.Intrinsics;
public final class LoginActivity extends AppCompatActivity {
    public ActivityLoginBinding loginBinding;
    @NotNull
    private final FirebaseAuth auth;
    public GoogleSignInClient googleSignInClient;
    public ActivityResultLauncher activityResultLauncher;

    @NotNull
    public final ActivityLoginBinding getLoginBinding() {
        ActivityLoginBinding var10000 = this.loginBinding;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loginBinding");
        }

        return var10000;
    }

    public final void setLoginBinding(@NotNull ActivityLoginBinding var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.loginBinding = var1;
    }

    @NotNull
    public final FirebaseAuth getAuth() {
        return this.auth;
    }

    @NotNull
    public final GoogleSignInClient getGoogleSignInClient() {
        GoogleSignInClient var10000 = this.googleSignInClient;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("googleSignInClient");
        }

        return var10000;
    }

    public final void setGoogleSignInClient(@NotNull GoogleSignInClient var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.googleSignInClient = var1;
    }

    @NotNull
    public final ActivityResultLauncher getActivityResultLauncher() {
        ActivityResultLauncher var10000 = this.activityResultLauncher;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityResultLauncher");
        }

        return var10000;
    }

    public final void setActivityResultLauncher(@NotNull ActivityResultLauncher var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.activityResultLauncher = var1;
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding var10001 = ActivityLoginBinding.inflate(this.getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(var10001, "ActivityLoginBinding.inflate(layoutInflater)");
        getSupportActionBar().setTitle("SIAN");
        this.loginBinding = var10001;
        ActivityLoginBinding var10000 = this.loginBinding;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loginBinding");
        }

        ConstraintLayout var4 = var10000.getRoot();
        Intrinsics.checkNotNullExpressionValue(var4, "loginBinding.root");
        ConstraintLayout view = var4;
        this.setContentView((View)view);
        var10000 = this.loginBinding;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loginBinding");
        }

        View var5 = var10000.buttonGoogle.getChildAt(0);
        if (var5 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        } else {
            TextView textOfGoogleButton = (TextView)var5;
            textOfGoogleButton.setText((CharSequence)"Continue with Google");
            textOfGoogleButton.setTextColor(-16777216);
            textOfGoogleButton.setTextSize(18.0F);
            this.registerActivityForGoogleSignIn();
            var10000 = this.loginBinding;
            if (var10000 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loginBinding");
            }

            var10000.signInButton.setOnClickListener((OnClickListener)(new OnClickListener() {
                public final void onClick(View it) {
                    TextInputEditText var10000 = LoginActivity.this.getLoginBinding().EmailText;
                    Intrinsics.checkNotNullExpressionValue(var10000, "loginBinding.EmailText");
                    String userEmail = String.valueOf(var10000.getText());
                    var10000 = LoginActivity.this.getLoginBinding().passwordText;
                    Intrinsics.checkNotNullExpressionValue(var10000, "loginBinding.passwordText");
                    String userPassword = String.valueOf(var10000.getText());
                    LoginActivity.this.signInWithFirebase(userEmail, userPassword);
                }
            }));
            var10000 = this.loginBinding;
            if (var10000 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loginBinding");
            }

            var10000.buttonGoogle.setOnClickListener((OnClickListener)(new OnClickListener() {
                public final void onClick(View it) {
                    LoginActivity.this.signInGoogle();
                }
            }));
            var10000 = this.loginBinding;
            if (var10000 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loginBinding");
            }

            var10000.signUpText.setOnClickListener((OnClickListener)(new OnClickListener() {
                public final void onClick(View it) {
                    Intent intent = new Intent((Context)LoginActivity.this, SignUpActivity.class);
                    LoginActivity.this.startActivity(intent);
                }
            }));
            var10000 = this.loginBinding;
            if (var10000 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loginBinding");
            }

            var10000.PasswordText1.setOnClickListener((OnClickListener)(new OnClickListener() {
                public final void onClick(View it) {
                    Intent intent = new Intent((Context)LoginActivity.this,ForgetActivity.class);
                    LoginActivity.this.startActivity(intent);
                }
            }));
        }
    }

    public final void signInWithFirebase(@NotNull String userEmail, @NotNull String userPassword) {
        Intrinsics.checkNotNullParameter(userEmail, "userEmail");
        Intrinsics.checkNotNullParameter(userPassword, "userPassword");
        this.auth.signInWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener((Activity)this, (OnCompleteListener)(new OnCompleteListener() {
            public final void onComplete(@NotNull Task task) {
                Intrinsics.checkNotNullParameter(task, "task");
                if (task.isSuccessful()) {
                    //--------
                    FirebaseUser user = auth.getCurrentUser();
                    Toast.makeText(LoginActivity.this.getApplicationContext(), (CharSequence)"Welcome",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent((Context)LoginActivity.this, MainActivity.class);
                   //-------
                    intent.putExtra("email",user.getEmail());
                    Log.v("DATA", user.getUid());
                    //--------
                    LoginActivity.this.startActivity(intent);
                    LoginActivity.this.finish();
                } else {
                    Context var10000 = LoginActivity.this.getApplicationContext();
                    Exception var10001 = task.getException();
                    Toast.makeText(var10000, (CharSequence)(var10001 != null ? var10001.getLocalizedMessage() : null),Toast.LENGTH_SHORT).show();
                }

            }
        }));
    }

    /*protected void onStart() {
        super.onStart();
        FirebaseUser user = this.auth.getCurrentUser();
        if (user != null) {
            Toast.makeText(this.getApplicationContext(), (CharSequence)"Welcome", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent((Context)this, MainActivity.class);
            this.startActivity(intent);
            this.finish();
        }

    }*/

    private final void signInGoogle() {
        GoogleSignInOptions var10000 = (new Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)).requestIdToken("382917181534-ffpnptrnatsis10uon4o94mbih3o01u5.apps.googleusercontent.com").requestEmail().build();
        Intrinsics.checkNotNullExpressionValue(var10000, "GoogleSignInOptions.Buil…  .requestEmail().build()");
        GoogleSignInOptions gso = var10000;
        GoogleSignInClient var10001 = GoogleSignIn.getClient((Activity)this, gso);
        Intrinsics.checkNotNullExpressionValue(var10001, "GoogleSignIn.getClient(this,gso)");
        this.googleSignInClient = var10001;
        this.signIn();
    }

    private final void signIn() {
        GoogleSignInClient var10000 = this.googleSignInClient;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("googleSignInClient");
        }

        Intent var2 = var10000.getSignInIntent();
        Intrinsics.checkNotNullExpressionValue(var2, "googleSignInClient.signInIntent");
        Intent signInIntent = var2;
        ActivityResultLauncher var3 = this.activityResultLauncher;
        if (var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityResultLauncher");
        }

        var3.launch(signInIntent);
    }

    private final void registerActivityForGoogleSignIn() {
        ActivityResultLauncher var10001 = this.registerForActivityResult((ActivityResultContract)(new StartActivityForResult()), (ActivityResultCallback)(new ActivityResultCallback() {
            // $FF: synthetic method
            // $FF: bridge method
            public void onActivityResult(Object var1) {
                this.onActivityResult((ActivityResult)var1);
            }

            public final void onActivityResult(ActivityResult result) {
                Intrinsics.checkNotNullExpressionValue(result, "result");
                int resultCode = result.getResultCode();
                Intent data = result.getData();
                if (resultCode == -1 && data != null) {
                    Task var10000 = GoogleSignIn.getSignedInAccountFromIntent(data);
                    Intrinsics.checkNotNullExpressionValue(var10000, "GoogleSignIn.getSignedInAccountFromIntent(data)");
                    Task task = var10000;
                    LoginActivity.this.firebaseSignWithGoogle(task);
                }

            }
        }));
        Intrinsics.checkNotNullExpressionValue(var10001, "registerForActivityResul…            }\n\n        })");
        this.activityResultLauncher = var10001;
    }

    private final void firebaseSignWithGoogle(Task task) {
        try {
            Object var10000 = task.getResult(ApiException.class);
            Intrinsics.checkNotNullExpressionValue(var10000, "task.getResult(ApiException::class.java)");
            GoogleSignInAccount account = (GoogleSignInAccount)var10000;
            Toast.makeText(this.getApplicationContext(), (CharSequence)"WELCOME", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent((Context)this, MainActivity.class);
            this.startActivity(intent);
            this.finish();
            this.FirebaseGoogleAccount(account);
        } catch (ApiException var4) {
            Toast.makeText(this.getApplicationContext(), (CharSequence)var4.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }

    private final void FirebaseGoogleAccount(GoogleSignInAccount account) {
        AuthCredential var10000 = GoogleAuthProvider.getCredential(account.getIdToken(), (String)null);
        Intrinsics.checkNotNullExpressionValue(var10000, "GoogleAuthProvider.getCr…ial(account.idToken,null)");
        AuthCredential authCredential = var10000;
        this.auth.signInWithCredential(authCredential).addOnCompleteListener((OnCompleteListener)null);
    }

    public LoginActivity() {
        FirebaseAuth var10001 = FirebaseAuth.getInstance();
        Intrinsics.checkNotNullExpressionValue(var10001, "FirebaseAuth.getInstance()");
        this.auth = var10001;
    }
    /*public void updateUI(FirebaseUser currentUser) {
        Intent profileIntent = new Intent(getApplicationContext(), ProfileActivity.class);
        profileIntent.putExtra("email", currentUser.getEmail());
        Log.v("DATA", currentUser.getUid());
        startActivity(profileIntent);
    }*/
}
