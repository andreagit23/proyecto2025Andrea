package com.andrea_murillo.involucrate.ui.compras

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.andrea_murillo.involucrate.R
import com.andrea_murillo.involucrate.databinding.FragmentComprasBinding
import com.andrea_murillo.involucrate.model.Producto
import com.andrea_murillo.involucrate.model.ProductoRequest
import com.andrea_murillo.involucrate.model.Categoria
import com.andrea_murillo.involucrate.network.ApiService
import com.andrea_murillo.involucrate.network.CategoriaApi
import com.andrea_murillo.involucrate.network.ProductoApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ComprasFragment : Fragment() {

    private var _binding: FragmentComprasBinding? = null
    private val binding get() = _binding!!

    private val productoApi by lazy { ApiService.retrofit.create(ProductoApi::class.java) }
    private val categoriaApi by lazy { ApiService.retrofit.create(CategoriaApi::class.java) }

    private var todosProductos: List<Producto> = emptyList()
    private var categorias: List<Categoria> = emptyList()
    private lateinit var adapter: ComprasAdapter
    private var usuarioId: Long = -1L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        usuarioId = requireContext()
            .getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
            .getLong("usuario_id", -1L)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentComprasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        setupSearchAndFilter()
        loadCategorias()
        loadProductos()
    }

    private fun setupRecycler() {
        adapter = ComprasAdapter { producto ->
            // Construimos el Bundle con el productoId
            val bundle = Bundle().apply {
                putLong("productoId", producto.id ?: -1L)
            }
            // Navegamos al detalle de compra
            findNavController().navigate(R.id.detalleProductoCompra, bundle)
        }
        binding.recyclerViewComprar.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewComprar.adapter = adapter
    }

    private fun setupSearchAndFilter() {
        binding.searchNombre.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?) = false
            override fun onQueryTextChange(newText: String?): Boolean {
                applyFilters()
                return true
            }
        })
        binding.spinnerFiltroCategoria.onItemSelectedListener = object :
            android.widget.AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: android.widget.AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                applyFilters()
            }
            override fun onNothingSelected(parent: android.widget.AdapterView<*>?) {}
        }
    }

    private fun loadCategorias() {
        lifecycleScope.launch {
            val response = withContext(Dispatchers.IO) { categoriaApi.obtenerCategorias() }
            if (response.isSuccessful) {
                categorias = response.body() ?: emptyList()
                val nombres = listOf(getString(R.string.todas)) + categorias.map { it.nombre }
                val sprAdapter = android.widget.ArrayAdapter(
                    requireContext(),
                    android.R.layout.simple_spinner_item,
                    nombres
                ).apply { setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) }
                binding.spinnerFiltroCategoria.adapter = sprAdapter
            }
        }
    }

    private fun loadProductos() {
        lifecycleScope.launch {
            val response = withContext(Dispatchers.IO) { productoApi.listarProductosDisponibles() }
            if (response.isSuccessful) {
                todosProductos = response.body()?.filter { it.vendedor.id != usuarioId } ?: emptyList()
                adapter.submitList(todosProductos)
            }
        }
    }

    private fun applyFilters() {
        val texto = binding.searchNombre.query?.toString()?.lowercase().orEmpty()
        val catPos = binding.spinnerFiltroCategoria.selectedItemPosition
        val catId = if (catPos > 0) categorias[catPos - 1].id else null
        val filtered = todosProductos.filter { p ->
            val matchName = p.nombre.lowercase().contains(texto)
            val matchCat = catId == null || p.categoria.id == catId
            matchName && matchCat
        }
        adapter.submitList(filtered)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
