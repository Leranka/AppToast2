package com.example.admin.apptoast;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Admin on 24-Jan-18.
 */

public class AnnouncementAdapter  extends RecyclerView.Adapter<AnnouncementAdapter.MyViewHolder> {



        private Activity context;
        private List<AnnouncementPojo> userItemPojos;
        private Activity applicationContext;
        private boolean like=false;
        private boolean checks =false;


        public AnnouncementAdapter(Activity context, List<AnnouncementPojo> userItemPojos) {
            this.context = context;
            this.userItemPojos = userItemPojos;
        }


        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.announcement_model,null);

            MyViewHolder myViewHolder = new MyViewHolder(view);
            return myViewHolder;

        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, int position) {
            final AnnouncementPojo ann = userItemPojos.get(position);

            holder.tvAnnViewTitle.setText(ann.getTitle());
            holder.tvAnnViewDesc.setText(ann.getDescription());
            holder.tvAnnViewdate.setText(ann.getDate());

            Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
//
//            Glide.with(context).load(ann.getUrlImage()).asBitmap().centerCrop().into(new BitmapImageViewTarget(holder.circleImageView) {
//                @Override
//                protected void setResource(Bitmap resource) {
//                    RoundedBitmapDrawable circularBitmapDrawable =
//                            RoundedBitmapDrawableFactory.create(context.getResources(), resource);
//                    circularBitmapDrawable.setCircular(true);
//                    holder.circleImageView.setImageDrawable(circularBitmapDrawable);
//                }
//            });
//
//            holder.tvTestTime.setText(ann.getDate());
//            holder.ivLike.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                    if(like==false) {
//                        like=true;
//                        holder.ivLike.setImageResource(R.drawable.likes);
//                    } else if (like==true) {
//                        like=false;
//                        holder.ivLike.setImageResource(R.drawable.like);
//                    }
//                }
//            });
//
////if( holder.tvAnnViewDesc.getLineCount()<=3)
////{
////    holder.ivReadMore.setVisibility(View.GONE);
////}
//            holder.ivReadMore.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
////                    Testimony   testimony = ann;
//                    Toast.makeText(context, "out", Toast.LENGTH_SHORT).show();
////                    Intent intent = new Intent(context, ReadMoreActivity.class);
////
////                    intent.putExtra("select", testimony);
////                    Toast.makeText(context, testimony.getName(), Toast.LENGTH_SHORT).show();
////                    context.startActivity(intent);
//
//                    holder.tvAnnViewDesc.setMaxLines(10000);
//                    holder.tvAnnViewDesc.setEllipsize(TextUtils.TruncateAt.MIDDLE);
//                    if(checks ==true) {
//                        checks = false;
//                        holder.tvAnnViewDesc.setMaxLines(10000);
//                        holder.tvAnnViewDesc.setEllipsize(TextUtils.TruncateAt.MIDDLE);
//
//                    }else if(checks ==false) {
//                        checks = true;
//                        holder.tvAnnViewDesc.setMaxLines(3);
//                        holder.tvAnnViewDesc.setEllipsize(TextUtils.TruncateAt.END);
//
//
//                    }
//                }
//            });

//            Glide.with(ProfileActivity.this).load(imageUrl).asBitmap().centerCrop().into(new BitmapImageViewTarget(ivEditProfile) {
//                @Override
//                protected void setResource(Bitmap resource) {
//                    RoundedBitmapDrawable circularBitmapDrawable =
//                            RoundedBitmapDrawableFactory.create(ProfileActivity.this.getResources(), resource);
//                    circularBitmapDrawable.setCircular(true);
//                    ivEditProfile.setImageDrawable(circularBitmapDrawable);
//                }
//            });
//        holder.tvAnnViewCurrentDay.setText(ann.getPostedTime()+"\n"+ann.getPostedDate());
//        holder.tvAnnViewDate.setText(ann.getTime()+"  "+ann.getEndDate());
//
//        Typeface custom_font = Typeface.createFromAsset(context.getAssets(), "fonts/Sansation-Bold.ttf");
//        holder.tvAnnViewTitle.setTypeface(custom_font);

        }

        @Override
        public int getItemCount() {
            return (null != userItemPojos ? userItemPojos.size() : 0);
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView tvAnnViewTitle,tvAnnViewDesc,tvAnnViewdate,tvAnnViewDate,tvTestTime;
            LinearLayout llUserItem;
            ImageView ivStatusColor;




            public MyViewHolder(View itemView) {
                super(itemView);
                tvAnnViewTitle= itemView.findViewById(R.id.tvAnnViewTitle);
                tvAnnViewDesc = itemView.findViewById(R.id.tvAnnViewDesc);
                tvAnnViewdate = itemView.findViewById(R.id.tvAnnViewDate);





            }
        }


    }



