package com.lgf.tlcodingtestdemo.ui.adapter;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lgf.tlcodingtestdemo.R;
import com.lgf.tlcodingtestdemo.bean.ShowingContentBean;
import com.lgf.tlcodingtestdemo.ui.ViewHolder.ImageAndTextViewHolder;
import com.lgf.tlcodingtestdemo.ui.ViewHolder.ImageViewHolder;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.List;

/**
 * Created by ligf on 2018/5/21.
 */

public class ContentShowingRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /** 只有图片的类型*/
    public static final int IMAGE_TYPE = 0;
    /** 有图片和文字的类型*/
    public static final int IMAGE_AND_TEST_TYPE = 1;

    private List<ShowingContentBean> contentList;

    public ContentShowingRVAdapter(List<ShowingContentBean> list){
        this.contentList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == IMAGE_TYPE){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_data_item_layout, parent, false);
            return new ImageViewHolder(view);
        }else if (viewType == IMAGE_AND_TEST_TYPE){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_text_data_item_layout, parent, false);
            return new ImageAndTextViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        ShowingContentBean showingContentBean = contentList.get(position);
        if (holder instanceof ImageViewHolder){
            final ImageAndTextViewHolder imageAndTextViewHolder = (ImageAndTextViewHolder) holder;
            ImageLoader.getInstance().loadImage(showingContentBean.imgUrl, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String s, View view) {

                }

                @Override
                public void onLoadingFailed(String s, View view, FailReason failReason) {

                }

                @Override
                public void onLoadingComplete(String s, View view, Bitmap bitmap) {
                    imageAndTextViewHolder.imageView.setImageBitmap(bitmap);
                }

                @Override
                public void onLoadingCancelled(String s, View view) {

                }
            });
        } else if (holder instanceof ImageAndTextViewHolder){
            final ImageAndTextViewHolder imageAndTextViewHolder = (ImageAndTextViewHolder) holder;
            imageAndTextViewHolder.title.setText(showingContentBean.title);
            imageAndTextViewHolder.content.setText(showingContentBean.description);
            ImageLoader.getInstance().loadImage(showingContentBean.imgUrl, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String s, View view) {

                }

                @Override
                public void onLoadingFailed(String s, View view, FailReason failReason) {

                }

                @Override
                public void onLoadingComplete(String s, View view, Bitmap bitmap) {
                    imageAndTextViewHolder.imageView.setImageBitmap(bitmap);
                }

                @Override
                public void onLoadingCancelled(String s, View view) {

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return contentList == null ? 0 : contentList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return Integer.valueOf(contentList.get(position).type);
    }
}
