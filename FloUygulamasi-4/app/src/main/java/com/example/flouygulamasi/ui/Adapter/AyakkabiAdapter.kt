package com.example.flouygulamasi.ui.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.flouygulamasi.data.Ayakkabilar
import com.example.flouygulamasi.databinding.CardTasarimBinding
import com.example.flouygulamasi.ui.fragment.AnasayfaFragment
import com.example.flouygulamasi.ui.fragment.AnasayfaFragmentDirections
import com.google.android.material.snackbar.Snackbar

class AyakkabiAdapter (var mContext:Context,var ayakkabiListesi:List<Ayakkabilar>)
    :RecyclerView.Adapter<AyakkabiAdapter.HolderClass>(){

    inner class HolderClass(var binding:CardTasarimBinding):RecyclerView.ViewHolder(binding.root)




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderClass {
        val binding=CardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return HolderClass(binding)
    }

    override fun getItemCount(): Int {
       return ayakkabiListesi.size
    }

    override fun onBindViewHolder(holder: HolderClass, position: Int) {
        val ayakkabi =ayakkabiListesi.get(position)
        val t = holder.binding

        t.imageViewAyakkabi.setImageResource(
            mContext.resources.getIdentifier(ayakkabi.adi,"drawable",mContext.packageName))

        t.textViewAyakkabi.text=ayakkabi.marka
        t.textViewFiyat.text="${ayakkabi.fiyat} Tl"

        t.button.setOnClickListener {
            Snackbar.make(it,"${ayakkabi.marka} sepete eklendi",Snackbar.LENGTH_LONG).show()
        }

        t.cardViewAyakkabi.setOnClickListener{
           val gecis = AnasayfaFragmentDirections.toDetay(ayakkabi=ayakkabi)
            Navigation.findNavController(it).navigate(gecis)
        }

    }


}