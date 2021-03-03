package com.blandinf.retrofittraining.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.blandinf.retrofittraining.adapters.ListArticlesAdapter
import com.blandinf.retrofittraining.databinding.FragmentHomeBinding
import com.blandinf.retrofittraining.models.Article

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: ListArticlesAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.articlesList.layoutManager = LinearLayoutManager(context)
        binding.articlesList.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))

        Log.v("articles", "onCreateView")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.v("articles", "viewCreated")
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        homeViewModel.loadArticles("covid").observe(
            viewLifecycleOwner,
            Observer<List<Article>> { articles ->
                Log.v("articles", "ok")
                if (articles != null) {
                    Log.v("articles", articles.toString())
                    adapter = ListArticlesAdapter(articles)
                    binding.articlesList.adapter = adapter
                }
            }
        )
    }
}
