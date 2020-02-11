package sw2.clase04ej2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sw2.clase04ej2.dto.EmpleadosRegionDto;
import sw2.clase04ej2.repository.EmployeeRepository;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmpleadoController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping(value = {"", "/"})
    public String cantidadEmpleadosPorRegion(Model model) {

        model.addAttribute("listaEmpleadosPorRegion", employeeRepository.obtenerEmpleadosPorRegion());
        model.addAttribute("listaEmpleadosPorPais", employeeRepository.obtenerEmpleadosPorPais());
        return "employee/estadistica";
    }

    @GetMapping(value = "/buscarEmpleadoPais/{pais}")
    public String cantidadEmpleadosPorPaisBuscar(Model model,
                                             @PathVariable("pais") String paisBuscar) {

        model.addAttribute("listaEmpleadosPorPais", employeeRepository.obtenerEmpleadosPorPais(paisBuscar));
        return "employee/empleadosPorPaisFiltrado";
    }

}
