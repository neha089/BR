package javaproject.com.BusReservation.RestController;
import javaproject.com.BusReservation.Entity.Bus;
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
    public RoleRestController(RoleService roles){
        roleService=roles;
    }

    @GetMapping("/roles")
    public List<Role> findAll(){
        return roleService.findAll();
    }
    @GetMapping("/roles/{id}")
    public Role findById (@PathVariable int id){
        Role roles=roleService.findById(id);
        if(roles==null){
            throw  new RuntimeException("Role not Found with id " + id);
        }
        return roles;
    }

    @PostMapping("/role")
    public Role updateBus(@RequestBody Role role){
        roleService.save(role);
        return role;

    }


    @DeleteMapping("/role/{id}")
    public String deleteBus(@PathVariable int id){
        Role role=roleService.findById(id);
        if(role==null){
            throw new RuntimeException("Role not Found with id : " +id);
        }
        roleService.deleteById(id);
        return "Delete Role with id" + id;
    }
}
