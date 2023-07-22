package com.example.androidavanzado.list

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidavanzado.R
import com.example.androidavanzado.databinding.FragmentListBinding
import com.example.androidavanzado.model.Model
import dagger.hilt.android.AndroidEntryPoint


/**
 *
 *  RECIBE LA DEPENDENCIA MEDIANTE EL VIEWMMODEL (PASO 3)
 *
 *  - PARA INDICARLE SERÁ LA RECEPTORA DE LA DEPENDENCIA SE LE DEBE DE INDICAR LA ANOTACIÓN '@AndroidEntryPoint' SINO NUNCA SE CERSIORA
 *
 * */
class ListFragment : Fragment() {

    private lateinit var binder : FragmentListBinding
    private lateinit var adapter : ItemAdapter
    private val listOfModels = List(10) {
        Model.dummy()
    } as MutableList<Model>
    //private val viewModel : ListViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binder = FragmentListBinding.inflate(layoutInflater)

        // LLAMADO A LOS INICIALIZADORES DESDE EL 'ONCREATE'
        //initRecyclerView()
        //setObservers()
        //getItems()
        //initList(listOfModels)
        return binder.root
    }

    /**
     * VERSIÓN INICIALIZANDO DESDE EL 'ONVIEWCREATED'
     * */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        initList(listOfModels)
    }

    private fun initList(list: List<Model>) = adapter.setItems(list)

    private fun initRecyclerView() {
        binder.rvContainer.layoutManager = LinearLayoutManager(context)
        adapter = ItemAdapter()
        binder.rvContainer.adapter = adapter
    }


}