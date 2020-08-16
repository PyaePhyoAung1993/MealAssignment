package com.azp.newsapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.azp.newsapp.R
import com.azp.newsapp.model1.Meal
import com.azp.newsapp.model2.Category
import com.azp.newsapp.ui.adapter.CategoryAdapter
import com.azp.newsapp.ui.adapter.CountryAdapter
import com.azp.newsapp.ui.adapter.RandomAdapter
import com.azp.newsapp.viewmodel.CategoryViewmodel
import com.azp.newsapp.viewmodel.CountryViewmodel
import com.azp.newsapp.viewmodel.RandomViewModel
import kotlinx.android.synthetic.main.fragment_country.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), RandomAdapter.ClickListener, CategoryAdapter.ClickListener {


    lateinit var randomViewmodel: RandomViewModel
    lateinit var randomAdapter: RandomAdapter
    lateinit var categoryViewmodel: CategoryViewmodel
    lateinit var categoryAdapter: CategoryAdapter
    lateinit var countryViewmodel: CountryViewmodel
    lateinit var countryAdapter: CountryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Random
        randomViewmodel = ViewModelProvider(this)
            .get(RandomViewModel::class.java)

        randomAdapter = RandomAdapter()
        recyclerview1.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = randomAdapter
        }
        randomAdapter.setOnClickListener(this)

        //Category
        categoryViewmodel = ViewModelProvider(this)
            .get(CategoryViewmodel::class.java)

        categoryAdapter = CategoryAdapter()
        recyclerview3.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = categoryAdapter
        }
        categoryAdapter.setOnClickListener(this)


        observeViewmodel()
        observeViewmodel1()
    }

    //Random
    private fun observeViewmodel() {
        randomViewmodel.getResultRandom().observe(
            viewLifecycleOwner, Observer { random ->
                randomAdapter.updateMeal(random.meals)
            }
        )
    }

    //Category
    override fun onResume() {
        super.onResume()
        randomViewmodel.loadRandom()
        categoryViewmodel.loadCategory()
        countryViewmodel.loadCountry()
    }


    private fun observeViewmodel1() {
        categoryViewmodel.getResultRandom().observe(
            viewLifecycleOwner, Observer { category ->
                categoryAdapter.updateCategory(category.categories)
            }
        )
    }



    override fun onClcik(meal: Meal) {
//        findNavController().navigate(R.id.action_homeFragment_to_detailFragment)
//        Log.d("movie",meal.id.toString())
//        var action = HomeFragmentDirections
//            .actionHomeFragmentToDetailFragment(meal.strArea)
//        findNavController().navigate(action)
    }

    override fun onClcik(category: Category) {
        TODO("Not yet implemented")
    }


}