package com.example.travelmate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.SearchView
import com.example.travelmate.databinding.FaqBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : FaqBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FaqBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val faq = arrayOf("What is TravelMate","Travelmate is a travel planning and exploration platform that helps you discover and plan trips to your dream locations"
        )
        val faqAdapter : ArrayAdapter<String> = ArrayAdapter(
            this,android.R.layout.simple_expandable_list_item_2,
            faq
        )
        binding.listView.adapter = faqAdapter;
        binding.searchFaq.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.searchFaq.clearFocus()
                if (faq.contains(query)){
                    faqAdapter.filter.filter(query)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                faqAdapter.filter.filter(newText)
            return false
            }

        })
    }
}