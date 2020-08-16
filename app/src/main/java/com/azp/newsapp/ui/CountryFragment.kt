package com.azp.newsapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.azp.newsapp.R
import com.azp.newsapp.model4.Meal
import com.azp.newsapp.ui.adapter.CountryAdapter
import com.azp.newsapp.viewmodel.CountryViewmodel
import kotlinx.android.synthetic.main.fragment_country.*


class CountryFragment : Fragment() , CountryAdapter.ClickListener{

    lateinit var countryViewmodel: CountryViewmodel
    lateinit var countryAdapter: CountryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Country
        countryViewmodel = ViewModelProvider(this)
            .get(CountryViewmodel::class.java)

        countryAdapter = CountryAdapter()
        recyclerview2.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = countryAdapter
        }
        countryAdapter.setOnClickListener(this)
        observeViewmodel2()
    }
    private fun observeViewmodel2() {
        countryViewmodel.getResultRandom().observe(
            viewLifecycleOwner, Observer { country ->
                countryAdapter.updateCountry(country.meals)
            }
        )
    }

    override fun onClcik(meal: Meal) {

    }


    }
