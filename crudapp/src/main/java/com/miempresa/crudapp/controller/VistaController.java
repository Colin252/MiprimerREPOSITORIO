package com.miempresa.crudapp.controller;

import com.miempresa.crudapp.model.Producto;
import com.miempresa.crudapp.repository.ProductoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VistaController {

    private final ProductoRepository productoRepository;

    public VistaController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // Mostrar la lista de productos
    @GetMapping("/")
    public String mostrarHome(Model model) {
        List<Producto> productos = productoRepository.findAll();
        model.addAttribute("productos", productos);
        return "index"; // Carga index.html
    }

    // Guardar nuevo producto
    @PostMapping("/guardar")
    public String guardarProducto(@RequestParam String nombre, @RequestParam double precio) {
        Producto nuevo = new Producto();
        nuevo.setNombre(nombre);
        nuevo.setPrecio(precio);
        productoRepository.save(nuevo);
        return "redirect:/"; // Redirige a la página principal
    }

    // Eliminar producto
    @PostMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        productoRepository.deleteById(id);
        return "redirect:/";
    }

    // Mostrar formulario de edición
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Producto producto = productoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido"));
        model.addAttribute("producto", producto);
        return "editar";
    }

    // Actualizar producto
    @PostMapping("/actualizar")
    public String actualizarProducto(@RequestParam Long id, @RequestParam String nombre, @RequestParam double precio) {
        Producto producto = productoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido"));
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        productoRepository.save(producto);
        return "redirect:/";
    }
}