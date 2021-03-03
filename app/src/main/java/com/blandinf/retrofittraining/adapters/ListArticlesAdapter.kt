package com.blandinf.retrofittraining.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blandinf.retrofittraining.R
import com.blandinf.retrofittraining.databinding.ItemArticleBinding
import com.blandinf.retrofittraining.models.Article
import com.bumptech.glide.Glide

class ListArticlesAdapter(items: List<Article>) : RecyclerView.Adapter<ListArticlesAdapter.ViewHolder>() {
    private var mArticles: List<Article> = items
    private lateinit var binding: ItemArticleBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article: Article = mArticles[position]
        binding.title.text = article.title
        binding.description.text = article.description

        val context = binding.root.context
        Glide.with(context)
            .load(article.urlToImage)
            .placeholder(R.drawable.ic_person)
            .error(R.drawable.ic_person)
            .skipMemoryCache(false)
            .into(binding.image)
    }

    override fun getItemCount(): Int {
        return mArticles.size
    }

    class ViewHolder(val binding: ItemArticleBinding) : RecyclerView.ViewHolder(binding.root)
}
