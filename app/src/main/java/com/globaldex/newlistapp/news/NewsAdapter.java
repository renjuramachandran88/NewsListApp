package com.globaldex.newlistapp.news;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.globaldex.newlistapp.R;
import com.globaldex.newlistapp.databinding.NewsItemBinding;

import java.util.ArrayList;
import java.util.List;

import globaldex.com.newlistapp.domain.model.Results;

/**
 * Created by renjumenon on 24/02/19.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    private List<Results> resultsList;
    private Context context;
    private NewsItemClickListener newsItemClickListener;

    public NewsAdapter(NewsItemClickListener newsItemClickListener) {
        this.newsItemClickListener = newsItemClickListener;
        this.resultsList = new ArrayList<>();
    }

    public void setNewsList(List<Results> resultsList) {
        this.resultsList = resultsList;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        NewsItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.news_item, parent, false);

        return new NewsHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder newsHolder, int position) {
        newsHolder.bind(position);
    }

    @Override
    public int getItemCount() {

        return resultsList.size();
    }

    interface NewsItemClickListener {
        void onListItemClick(Results results);
    }

    class NewsHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private NewsItemBinding binding;

        public NewsHolder(NewsItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(this);
        }

        void bind(int position) {
            binding.getRoot().setBackgroundColor(Color.WHITE);

            Results results = resultsList.get(position);
            binding.newsTitle.setText(results.getTitle());
            binding.newsAuthor.setText(results.getByline());
            binding.newsDate.setText(results.getPublishedDate());
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();

            if (clickedPosition > -1
                    && clickedPosition < resultsList.size()) {
                newsItemClickListener.onListItemClick(resultsList.get(clickedPosition));
            }
        }
    }
}
