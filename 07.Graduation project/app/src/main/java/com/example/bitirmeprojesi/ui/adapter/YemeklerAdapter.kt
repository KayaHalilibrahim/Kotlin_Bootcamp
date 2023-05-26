package com.example.bitirmeprojesi.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.bitirmeprojesi.R
import com.example.bitirmeprojesi.data.entity.Yemekler
import com.example.bitirmeprojesi.databinding.SatirTasarimBinding
import com.example.bitirmeprojesi.ui.viewmodel.SepetViewmodel
import com.google.android.material.snackbar.Snackbar

class YemeklerAdapter(var mContext:Context,var yemeklerListesi:List<Yemekler>,var viewModel: SepetViewmodel)
    :RecyclerView.Adapter<YemeklerAdapter.SatirTasarimTutucu>() {

    inner class SatirTasarimTutucu(var binding:SatirTasarimBinding):RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SatirTasarimTutucu {
        val binding:SatirTasarimBinding=DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.satir_tasarim,parent,false)
        return SatirTasarimTutucu(binding)
    }




    override fun getItemCount(): Int {   //kaç veri işlenecek
       return yemeklerListesi.size
    }

    override fun onBindViewHolder(holder: SatirTasarimTutucu, position: Int) {
      val yemek= yemeklerListesi.get(position)
        val t=holder.binding



        t.yemekNesne=yemek

     t.spYemekResim.setImageResource(mContext.resources.getIdentifier(yemek.yemek_resim_adi,"drawable",mContext.packageName))


        t.adet.text=yemek.yemek_siparis_adet

      t.imageViewSil.setOnClickListener{
          Snackbar.make(it,"${yemek.yemek_adi} Silinsin mi?",Snackbar.LENGTH_LONG)
              .setAction("Evet"){
                  sil(yemek.yemek_id,yemek.kullanici_adi)
              }.show()
      }

      t


    }

     fun sil(yemekid: String,kulllanici_adi: String){
      viewModel.sil(yemekid)
     }



}