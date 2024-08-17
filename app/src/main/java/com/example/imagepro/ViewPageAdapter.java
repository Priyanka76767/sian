package com.example.imagepro;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;


//@Metadata(
//        mv = {1, 7, 1},
//        k = 1,
//        d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0013B/\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\bH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"},
//        d2 = {"Lcom/example/sian/ViewPageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/sian/ViewPageAdapter$Pager2ViewHolder;", "title", "", "", "details", "images", "", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Pager2ViewHolder", "app_debug"}
//)
public final class ViewPageAdapter extends Adapter {
    private List title;
    private List details;
    private List images;
    public ViewPageAdapter.Pager2ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        Intrinsics.checkNotNullParameter(parent, "parent");
        View var10003 = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_page, parent, false);
//        Intrinsics.checkNotNullExpressionValue(var10003, "LayoutInflater.from(pare…y_item_page,parent,false)");
        return new ViewPageAdapter.Pager2ViewHolder(var10003);
    }

    // $FF: synthetic method
    // $FF: bridge method

    public void onBindViewHolder( ViewPageAdapter.Pager2ViewHolder holder, int position) {
//        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getItemTitle().setText((CharSequence)this.title.get(position));
        holder.getItemDetails().setText((CharSequence)this.details.get(position));
        holder.getImage().setImageResource(((Number)this.images.get(position)).intValue());
    }

    // $FF: synthetic method
    // $FF: bridge method
    public void onBindViewHolder(ViewHolder var1, int var2) {
        this.onBindViewHolder((ViewPageAdapter.Pager2ViewHolder)var1, var2);
    }

    public int getItemCount() {
        return this.title.size();
    }

    public ViewPageAdapter( List title,List details, List images) {
//        Intrinsics.checkNotNullParameter(title, "title");
//        Intrinsics.checkNotNullParameter(details, "details");
//        Intrinsics.checkNotNullParameter(images, "images");
        super();
        this.title = title;
        this.details = details;
        this.images = images;
    }

    public final class Pager2ViewHolder extends ViewHolder {
        private final TextView itemTitle;
        private final TextView itemDetails;
        private final ImageView image;
        public final TextView getItemTitle() {
            return this.itemTitle;
        }
        public final TextView getItemDetails() {
            return this.itemDetails;
        }
        public final ImageView getImage() {
            return this.image;
        }

        public Pager2ViewHolder(final View itemView) {
//            Intrinsics.checkNotNullParameter(itemView, "itemView");
            super(itemView);
            View var10001 = itemView.findViewById(R.id.textView);
//            Intrinsics.checkNotNullExpressionValue(var10001, "itemView.findViewById(R.id.textView)");
            this.itemTitle = (TextView)var10001;
            var10001 = itemView.findViewById(R.id.editTextTextMultiLine);
//            Intrinsics.checkNotNullExpressionValue(var10001, "itemView.findViewById(R.id.editTextTextMultiLine)");
            this.itemDetails = (TextView)var10001;
            var10001 = itemView.findViewById(R.id.imageView);
//            Intrinsics.checkNotNullExpressionValue(var10001, "itemView.findViewById(R.id.imageView)");
            this.image = (ImageView)var10001;
            this.image.setOnClickListener((OnClickListener)(new OnClickListener() {
                public final void onClick(View v) {
//                    Intrinsics.checkNotNullParameter(v, "v");
                    int position = Pager2ViewHolder.this.getAdapterPosition();
                    Toast.makeText(itemView.getContext(), (CharSequence)("You click on item #" + (position + 1)), Toast.LENGTH_SHORT).show();
                }
            }));
        }
    }
}
