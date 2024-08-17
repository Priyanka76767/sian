package com.example.imagepro;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.imagepro.databinding.ActivitySignUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*@Metadata(
        mv = {1, 7, 1},
        k = 1,
        d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\u0012\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\u0016\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001e"},
        d2 = {"Lcom/example/sian/SignUpActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "getAuth", "()Lcom/google/firebase/auth/FirebaseAuth;", "database", "Lcom/google/firebase/database/FirebaseDatabase;", "getDatabase", "()Lcom/google/firebase/database/FirebaseDatabase;", "myReference", "Lcom/google/firebase/database/DatabaseReference;", "getMyReference", "()Lcom/google/firebase/database/DatabaseReference;", "signUpBinding", "Lcom/example/sian/databinding/ActivitySignUpBinding;", "getSignUpBinding", "()Lcom/example/sian/databinding/ActivitySignUpBinding;", "setSignUpBinding", "(Lcom/example/sian/databinding/ActivitySignUpBinding;)V", "addUserToDatabase", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "signUpWithFirebase", "email", "", "password", "Sian.app.main"}
                }*/
public final class SignUpActivity extends AppCompatActivity {
    public ActivitySignUpBinding signUpBinding;
    @NotNull
    private final FirebaseAuth auth;
    @NotNull
    private final FirebaseDatabase database;
    @NotNull
    private final DatabaseReference myReference;

    @NotNull
    public final ActivitySignUpBinding getSignUpBinding() {
        ActivitySignUpBinding var10000 = this.signUpBinding;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signUpBinding");
        }

        return var10000;
    }

    public final void setSignUpBinding(@NotNull ActivitySignUpBinding var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.signUpBinding = var1;
    }

    @NotNull
    public final FirebaseAuth getAuth() {
        return this.auth;
    }

    @NotNull
    public final FirebaseDatabase getDatabase() {
        return this.database;
    }

    @NotNull
    public final DatabaseReference getMyReference() {
        return this.myReference;
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySignUpBinding var10001 = ActivitySignUpBinding.inflate(this.getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(var10001, "ActivitySignUpBinding.inflate(layoutInflater)");
        this.signUpBinding = var10001;
        ActivitySignUpBinding var10000 = this.signUpBinding;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signUpBinding");
        }
        ConstraintLayout var3 = var10000.getRoot();
        Intrinsics.checkNotNullExpressionValue(var3, "signUpBinding.root");
        ConstraintLayout view = var3;
        this.setContentView((View)view);
        getSupportActionBar().setTitle("SIAN");

        var10000 = this.signUpBinding;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signUpBinding");
        }

        var10000.signUpButton.setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View it) {
                TextInputEditText var10000 = SignUpActivity.this.getSignUpBinding().username;
                Intrinsics.checkNotNullExpressionValue(var10000, "signUpBinding.username");
                String name = String.valueOf(var10000.getText());
                var10000 = SignUpActivity.this.getSignUpBinding().signUpText;
                Intrinsics.checkNotNullExpressionValue(var10000, "signUpBinding.signUpText");
                String email = String.valueOf(var10000.getText());
                var10000 = SignUpActivity.this.getSignUpBinding().PasswordTextView;
                Intrinsics.checkNotNullExpressionValue(var10000, "signUpBinding.PasswordTextView");
                String password = String.valueOf(var10000.getText());
                SignUpActivity.this.signUpWithFirebase(email, password);
                Intent intent = new Intent((Context)SignUpActivity.this, LoginActivity.class);
                SignUpActivity.this.startActivity(intent);
                SignUpActivity.this.finish();
            }
        }));
    }

    public final void signUpWithFirebase(String email, String password) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(password, "password");
        ActivitySignUpBinding var10000 = this.signUpBinding;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signUpBinding");
        }

        ProgressBar var3 = var10000.progressBarSignUP;
        Intrinsics.checkNotNullExpressionValue(var3, "signUpBinding.progressBarSignUP");
        var3.setVisibility(View.VISIBLE);
        var10000 = this.signUpBinding;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signUpBinding");
        }

        Button var4 = var10000.signUpButton;
        Intrinsics.checkNotNullExpressionValue(var4, "signUpBinding.signUpButton");
        var4.setClickable(false);
        this.auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener((OnCompleteListener)(new OnCompleteListener() {
            public final void onComplete(@NotNull Task task) {
                Intrinsics.checkNotNullParameter(task, "task");
                if (task.isSuccessful()) {
                    ProgressBar var10000 = SignUpActivity.this.getSignUpBinding().progressBarSignUP;
                    Intrinsics.checkNotNullExpressionValue(var10000, "signUpBinding.progressBarSignUP");
                    var10000.setVisibility(View.INVISIBLE);
                    Button var2 = SignUpActivity.this.getSignUpBinding().signUpButton;
                    Intrinsics.checkNotNullExpressionValue(var2, "signUpBinding.signUpButton");
                    var2.setClickable(true);
                    SignUpActivity.this.addUserToDatabase();
                    Toast.makeText(SignUpActivity.this.getApplicationContext(), (CharSequence)"Your account has been created",Toast.LENGTH_SHORT).show();
                    SignUpActivity.this.finish();
                } else {
                    Context var3 = SignUpActivity.this.getApplicationContext();
                    Exception var10001 = task.getException();
                    Toast.makeText(var3, (CharSequence)(var10001 != null ? var10001.getLocalizedMessage() : null),Toast.LENGTH_SHORT).show();
                }

            }
        }));
    }

    public final void addUserToDatabase() {
        ActivitySignUpBinding var10000 = this.signUpBinding;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signUpBinding");
        }

        TextInputEditText var5 = var10000.username;
        Intrinsics.checkNotNullExpressionValue(var5, "signUpBinding.username");
        String name = String.valueOf(var5.getText());
        var10000 = this.signUpBinding;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signUpBinding");
        }

        var5 = var10000.signUpText;
        Intrinsics.checkNotNullExpressionValue(var5, "signUpBinding.signUpText");
        String email = String.valueOf(var5.getText());
        DatabaseReference var6 = this.myReference.push();
        Intrinsics.checkNotNullExpressionValue(var6, "myReference.push()");
        String id = String.valueOf(var6.getKey());
        Users user = new Users(id, name, email);
        this.myReference.child(id).setValue(user).addOnCompleteListener((OnCompleteListener)(new OnCompleteListener() {
            public final void onComplete(@NotNull Task task) {
                Intrinsics.checkNotNullParameter(task, "task");
                if (task.isSuccessful()) {
                    Toast.makeText(SignUpActivity.this.getApplicationContext(), (CharSequence)"The new user has  been added to the database", Toast.LENGTH_SHORT).show();
                    SignUpActivity.this.finish();
                } else {
                    Toast.makeText(SignUpActivity.this.getApplicationContext(), (CharSequence)String.valueOf(task.getException()), Toast.LENGTH_SHORT).show();
                }

            }
        }));
    }

    public SignUpActivity() {
        FirebaseAuth var10001 = FirebaseAuth.getInstance();
        Intrinsics.checkNotNullExpressionValue(var10001, "FirebaseAuth.getInstance()");
        this.auth = var10001;
        FirebaseDatabase var1 = FirebaseDatabase.getInstance();
        Intrinsics.checkNotNullExpressionValue(var1, "FirebaseDatabase.getInstance()");
        this.database = var1;
        DatabaseReference var2 = this.database.getReference().child("MyUsers");
        Intrinsics.checkNotNullExpressionValue(var2, "database.reference.child(\"MyUsers\")");
        this.myReference = var2;
    }
}
