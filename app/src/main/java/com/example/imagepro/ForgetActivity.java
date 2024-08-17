package com.example.imagepro;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.imagepro.databinding.ActivityForgetBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*@Metadata(
        mv = {1, 7, 1},
        k = 1,
        d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0011"},
        d2 = {"Lcom/example/sian/ForgetActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "getAuth", "()Lcom/google/firebase/auth/FirebaseAuth;", "forgetBinding", "Lcom/example/sian/databinding/ActivityForgetBinding;", "getForgetBinding", "()Lcom/example/sian/databinding/ActivityForgetBinding;", "setForgetBinding", "(Lcom/example/sian/databinding/ActivityForgetBinding;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Sian.app.main"}
)*/
public final class ForgetActivity extends AppCompatActivity {
    public ActivityForgetBinding forgetBinding;
    @NotNull
    private final FirebaseAuth auth;

    @NotNull
    public final ActivityForgetBinding getForgetBinding() {
        ActivityForgetBinding var10000 = this.forgetBinding;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("forgetBinding");
        }

        return var10000;
    }

    public final void setForgetBinding(@NotNull ActivityForgetBinding var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.forgetBinding = var1;
    }

    @NotNull
    public final FirebaseAuth getAuth() {
        return this.auth;
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityForgetBinding var10001 = ActivityForgetBinding.inflate(this.getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(var10001, "ActivityForgetBinding.inflate(layoutInflater)");
        this.forgetBinding = var10001;
        ActivityForgetBinding var10000 = this.forgetBinding;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("forgetBinding");
        }

        ConstraintLayout var3 = var10000.getRoot();
        Intrinsics.checkNotNullExpressionValue(var3, "forgetBinding.root");
        ConstraintLayout view = var3;
        this.setContentView((View)view);
        var10000 = this.forgetBinding;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("forgetBinding");
        }

        var10000.ResetButton.setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View it) {
                TextInputEditText var10000 = ForgetActivity.this.getForgetBinding().ForgetEmailText;
                Intrinsics.checkNotNullExpressionValue(var10000, "forgetBinding.ForgetEmailText");
                String userEmail = String.valueOf(var10000.getText());
                ForgetActivity.this.getAuth().sendPasswordResetEmail(userEmail).addOnCompleteListener((OnCompleteListener)(new OnCompleteListener() {
                    public final void onComplete(@NotNull Task task) {
                        Intrinsics.checkNotNullParameter(task, "task");
                        if (task.isSuccessful()) {
                            Toast.makeText(ForgetActivity.this.getApplicationContext(), (CharSequence)"We sent a password reset mail to your Email address", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent((Context)ForgetActivity.this, LoginActivity.class);
                            ForgetActivity.this.startActivity(intent);
                        } else {
                            Context var10000 = ForgetActivity.this.getApplicationContext();
                            Exception var10001 = task.getException();
                            Toast.makeText(var10000, (CharSequence)(var10001 != null ? var10001.getLocalizedMessage() : null), Toast.LENGTH_SHORT).show();
                        }

                    }
                }));
            }
        }));
    }

    public ForgetActivity() {
        FirebaseAuth var10001 = FirebaseAuth.getInstance();
        Intrinsics.checkNotNullExpressionValue(var10001, "FirebaseAuth.getInstance()");
        this.auth = var10001;
    }
}
