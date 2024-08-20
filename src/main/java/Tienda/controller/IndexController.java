package Tienda.controller;

import Tienda.Service.ItemService;
import Tienda.Service.ProductoService;
import Tienda.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @Autowired
    ProductoService productoService;

    @RequestMapping("/")
    public String page(Model model) {
        var listaProductos = productoService.getProductos(true);
        model.addAttribute("productos", listaProductos);
        return "index";
    }

    @Autowired
    private ItemService itemService;

    @RequestMapping("/refrescarBoton")
    public ModelAndView refrescarBoton(Model model) {
        var lista = itemService.gets();
        var totalCarritos = 0;
        var carritoTotalVenta = 0;
        for (Item i : lista) {
            totalCarritos += i.getCantidad();
            carritoTotalVenta += (i.getCantidad() * i.getPrecio());
        }
        model.addAttribute("listaItems", lista);
        model.addAttribute("listaTotal", totalCarritos);
        model.addAttribute("carritoTotal", carritoTotalVenta);
        return new ModelAndView("/carrito/fragmentos :: verCarrito");
    }
}
