package com.example.bitirmeprojesi.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.bitirmeprojesi.R
import com.example.bitirmeprojesi.data.entity.Yemekler
import com.example.bitirmeprojesi.databinding.CardTasarimBinding
import com.example.bitirmeprojesi.ui.fragment.AnasayfaFragmentDirections
import com.example.bitirmeprojesi.ui.viewmodel.AnasayfaViewModel
import com.google.android.material.snackbar.Snackbar

class FoodsAdapter(
    var mContext: Context,
    var foodList: List<Yemekler>,
    viewModel: AnasayfaViewModel
)
    : RecyclerView.Adapter<FoodsAdapter.CardTasarimTutucu> (){

    inner class CardTasarimTutucu(var binding:CardTasarimBinding) :RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding :CardTasarimBinding= DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.card_tasarim,parent,false)
        return CardTasarimTutucu(binding)
    }




    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
      val food = foodList.get(position)
        val t=holder.binding


       t.imageViewYemek.setImageResource(mContext.resources.getIdentifier(food.yemek_resim_adi,"drawable",mContext.packageName))

        t.textViewFiyat.text= "${food.yemek_fiyat} ₺"
        t.textViewYemekAdi.text = food.yemek_adi




       t.floatingActionButton6.setOnClickListener {
           Snackbar.make(it,"${food.yemek_adi} favorilere eklendi",Snackbar.LENGTH_LONG).show()
       }



        t.cardViewYemek.setOnClickListener{
            val gecis = AnasayfaFragmentDirections.anasayfaDetay(yemek=food, yemeek = food)
            Navigation.findNavController(it).navigate(gecis)
        }


    }



}




