package javaproject.com.BusReservation.RestController;
import javaproject.com.BusReservation.Entity.Role;
import javaproject.com.BusReservation.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleRestController {

    private RoleService roleService;
    @Autowired
    public RoleRestController(RoleService buss){
        roleService=buss;
    }

    @GetMapping("/rolees")
    public List<Role> findAll(){
        return roleService.findAll();
    }
    @GetMapping("/rolees/{id}")
    public Role findById (@PathVariable int id){
        Role agenies=roleService.findById(id);
        if(agenies==null){
            throw  new RuntimeException("Bus not Found with id " + id);
        }
        return agenies;
    }

    @PostMapping("/rolees")
    public Role addrole(@RequestBody Role role){
        roleService.save(role);
        return role;

    }





    @DeleteMapping("/role/{id}")
    public String deleteBus(@PathVariable int id){
        Role role=roleService.findById(id);
        if(role==null){
            throw new RuntimeException("Rolenot Found with id : " +id);
        }
        roleService.deleteById(id);
        return "Delete Bus  with id" + id;
    }
}
