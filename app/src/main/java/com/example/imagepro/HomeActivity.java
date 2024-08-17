package com.example.imagepro;



import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.util.ArrayList;
import java.util.List;


import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.relex.circleindicator.CircleIndicator3;


/*@Metadata(
       mv = {1, 7, 1},
        k = 1,
        d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0014H\u0002J\u0012\u0010!\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0015J\u0012\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u001dH\u0014J\b\u0010,\u001a\u00020\u001dH\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006-"},
        d2 = {"Lcom/example/sian/HomeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "getAuth", "()Lcom/google/firebase/auth/FirebaseAuth;", "button1", "Landroid/widget/Button;", "getButton1", "()Landroid/widget/Button;", "setButton1", "(Landroid/widget/Button;)V", "button2", "getButton2", "setButton2", "detailsList", "", "", "imageList", "", "titleList", "view_pager", "Landroidx/viewpager2/widget/ViewPager2;", "getView_pager", "()Landroidx/viewpager2/widget/ViewPager2;", "setView_pager", "(Landroidx/viewpager2/widget/ViewPager2;)V", "addToList", "", "title", "description", "image", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onStart", "postToList", "app_debug"}
)*/
public final class HomeActivity extends AppCompatActivity {
    public ViewPager2 view_pager;
    private List titleList = (List)(new ArrayList());
    private List detailsList = (List)(new ArrayList());
    private List imageList = (List)(new ArrayList());
    public Button button1;
    public Button button2;

    private final FirebaseAuth auth;
    public final ViewPager2 getView_pager() {
        ViewPager2 var10000 = this.view_pager;
     if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view_pager");
        }

        return var10000;
    }

    public final void setView_pager(ViewPager2 var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.view_pager = var1;
    }


    public final Button getButton1() {
        Button var10000 = this.button1;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("button1");
        }

        return var10000;
    }

    public final void setButton1( Button var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.button1 = var1;
    }


    public final Button getButton2() {
        Button var10000 = this.button2;
       if (var10000 == null) {
           Intrinsics.throwUninitializedPropertyAccessException("button2");
       }
        return var10000;
    }

    public final void setButton2( Button var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.button2 = var1;
    }


    public final FirebaseAuth getAuth() {
        return this.auth;
    }

    @SuppressLint({"MissingInflatedId"})
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_home);
        getSupportActionBar().setTitle("SIAN");
        this.postToList();
        View var10001 = this.findViewById(R.id.view_pager);
        Intrinsics.checkNotNullExpressionValue(var10001, "findViewById(R.id.view_pager)");
        this.view_pager = (ViewPager2)var10001;
        ViewPager2 var10000 = this.view_pager;
     if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view_pager");
       }

        var10000.setAdapter((Adapter)(new ViewPageAdapter(this.titleList, this.detailsList, this.imageList)));
        var10000 = this.view_pager;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view_pager");
        }

        var10000.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        View var3 = this.findViewById(R.id.indicator);
        Intrinsics.checkNotNullExpressionValue(var3, "findViewById<CircleIndicator3>(R.id.indicator)");
        CircleIndicator3 indicator = (CircleIndicator3)var3;
        ViewPager2 var5 = this.view_pager;
        if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view_pager");
        }

        indicator.setViewPager(var5);
        var10001 = this.findViewById(R.id.button3);
        Intrinsics.checkNotNullExpressionValue(var10001, "findViewById(R.id.button3)");
        this.button1 = (Button)var10001;
        var10001 = this.findViewById(R.id.button4);
        Intrinsics.checkNotNullExpressionValue(var10001, "findViewById(R.id.button4)");
        this.button2 = (Button)var10001;
        Button var4 = this.button1;
        if (var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("button1");
        }

        var4.setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View it) {
                Intent intent = new Intent((Context)HomeActivity.this, LoginActivity.class);
                HomeActivity.this.startActivity(intent);
            }
        }));
        var4 = this.button2;
        if (var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("button2");
        }

        var4.setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View it) {
                Intent intent = new Intent((Context)HomeActivity.this, LoginActivity.class);
                HomeActivity.this.startActivity(intent);
            }
        }));
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu1, menu);
        return true;
    }

    public boolean onOptionsItemSelected( MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
         Intent intent;
        if (item.getItemId() == R.id.signUPButton) {
            intent = new Intent((Context)this, SignUpActivity.class);
            this.startActivity(intent);
        }

        if (item.getItemId() == R.id.signInButton) {
            intent = new Intent((Context)this, LoginActivity.class);
            this.startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    protected void onStart() {
        super.onStart();
        FirebaseUser user = this.auth.getCurrentUser();
        if (user != null) {
            Toast.makeText(this.getApplicationContext(), (CharSequence)"Welcome",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent((Context)this,MainActivity.class);
            this.startActivity(intent);
            this.finish();
        }

    }

    private final void addToList(String title, String description, int image) {
        this.titleList.add(title);
        this.detailsList.add(description);
        this.imageList.add(image);
    }

    private final void postToList() {
        this.addToList("Mayank Agarwal", "Worked on the image classification model and Back End of the App\n", R.drawable.mayank);
        this.addToList("Kamran Afzal Khan", "Worked on the Front End of the App",R.drawable.kamran);
        this.addToList("Gaurav Singh Chauhan", "Worked on the image classification model",R.drawable.gaurav);
        this.addToList("Priyanka Tiwari", "Worked on the Back End of the App\n", R.drawable.priyanka);
        this.addToList("Mariya Parveen", "Worked on the Front End of the App\n",R.drawable.mariya);
    }

    public HomeActivity() {
        FirebaseAuth var10001 = FirebaseAuth.getInstance();
        Intrinsics.checkNotNullExpressionValue(var10001, "FirebaseAuth.getInstance()");
        this.auth = var10001;
    }
}
