package com.lgf.tlcodingtestdemo.ui.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lgf.tlcodingtestdemo.R;

/**
 * RecyclerView中图片和文字item的视图装载器
 * @author ligangfan
 * @date: 2018/5/21
 *
 */

public class ImageAndTextViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView title;
    public TextView content;

    public ImageAndTextViewHolder(View itemView) {
        super(itemView);
        this.imageView = (ImageView) itemView.findViewById(R.id.img_image_text_data_item);
        this.title = (TextView) itemView.findViewById(R.id.tv_image_text_data_item_title);
        this.content = (TextView) itemView.findViewById(R.id.tv_image_text_data_item_content);
    }
}
