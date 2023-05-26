package com.example.filmleruygulamasi.ui.adaptar

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.filmleruygulamasi.data.Filmler
import com.example.filmleruygulamasi.databinding.FilmTasarimBinding
import com.example.filmleruygulamasi.ui.fragment.AnasayfaFragment
import com.example.filmleruygulamasi.ui.fragment.AnasayfaFragmentDirections
import com.google.android.material.snackbar.Snackbar

class FilmlerAdapter (var mContext:Context,var filmlerListesi:List<Filmler>)

    :RecyclerView.Adapter<FilmlerAdapter.HolderClass>()
{


inner class HolderClass(var binding:FilmTasarimBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderClass {
        val binding =FilmTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return HolderClass(binding)
    }

    override fun getItemCount(): Int {
        return filmlerListesi.size
    }

    override fun onBindViewHolder(holder: HolderClass, position: Int) {
        val film=filmlerListesi.get(position)
    val t = holder.binding


        t.imageViewFilm.setImageResource(
            mContext.resources.getIdentifier(film.resim_adi,"drawable",mContext.packageName))

        t.textViewFilm.text = film.adi

        t.textViewFiyat.text = "${film.fiyat}"
        t.buttonSepeteEkle.setOnClickListener {

            Snackbar.make(it,"${film.adi}  Sepete Eklendi",Snackbar.LENGTH_LONG).show()

        }

        t.cardViewFilm.setOnClickListener{

            val gecis = AnasayfaFragmentDirections.toDetay(film=film)
            Navigation.findNavController(it).navigate(gecis)
        }
    }
}