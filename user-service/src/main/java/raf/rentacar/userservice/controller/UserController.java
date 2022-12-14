package raf.rentacar.userservice.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import raf.rentacar.userservice.dto.ClientDto;
import raf.rentacar.userservice.dto.ManagerDto;
import raf.rentacar.userservice.dto.UserDto;
import raf.rentacar.userservice.secutiry.CheckSecurity;
import raf.rentacar.userservice.secutiry.SecurityAspect;
import raf.rentacar.userservice.service.UserService;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private SecurityAspect securityAspect;

    public UserController(UserService userService, SecurityAspect securityAspect) {
        this.userService = userService;
        this.securityAspect = securityAspect;
    }

    @GetMapping
    @CheckSecurity(roles = {"ROLE_ADMIN", "ROLE_MANAGER"})
    public ResponseEntity<Page<UserDto>> getUsers(@RequestHeader("authorization") String authorization,
                                                  @ApiIgnore Pageable pageable) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @CheckSecurity(roles = {"ROLE_ADMIN", "ROLE_MANAGER, ROLE_USER"})
    public ResponseEntity<UserDto> getUser(@PathVariable("id") Long id){
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/create-client")
    public ResponseEntity<ClientDto> createClient(@RequestBody ClientDto clientDto) {
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @PostMapping("/create-manager")
    public ResponseEntity<ManagerDto> createManager(@RequestBody ManagerDto managerDto) {
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @PutMapping("/update-admin")
    @CheckSecurity(roles = {"ROLE_ADMIN"})
    public ResponseEntity<UserDto> updateAdmin(@RequestHeader("authorization") String authorization,
                                               @RequestBody UserDto userDto){
        //Long clientId = securityAspect.getUserId(authorization);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PutMapping("/update-manager")
    @CheckSecurity(roles = {"ROLE_MANAGER"})
    public ResponseEntity<ClientDto> updateManager(@RequestHeader("authorization") String authorization,
                                                   @RequestBody ManagerDto managerDto){
        //Long clientId = securityAspect.getUserId(authorization);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PutMapping("/update-client")
    @CheckSecurity(roles = {"ROLE_CLIENT"})
    public ResponseEntity<ClientDto> updateClient(@RequestHeader("authorization") String authorization,
                                                  @RequestBody ClientDto clientDto){
        //Long clientId = securityAspect.getUserId(authorization);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    @DeleteMapping
    @CheckSecurity(roles = {"ROLE_ADMIN", "ROLE_MANAGER, ROLE_USER"})
    public ResponseEntity<Object> deleteUser(@RequestHeader("authorization") String authorization){
        //Long clientId = securityAspect.getUserId(authorization);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
