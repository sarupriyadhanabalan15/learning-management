package com.Kgisl.CRUD.CRUD.Controller;

 
import java.util.List;
 
import com.Kgisl.CRUD.CRUD.entity.User;
// import com.kgisl.springboottask.projectcrud.entity.TeamDto;
import com.Kgisl.CRUD.CRUD.Service.UserService;
 
// import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
 
/**
* TeamController
*/
 
@CrossOrigin(origins = "*")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@RestController
@RequestMapping("/api/user")
public class UserController {
 
   @Autowired
private UserService userService;
 
// @Autowired
// private ModelMapper modelMapper;
 
   @PostMapping(value = "/", headers = "Accept=application/json")
public ResponseEntity<User> createUser(@RequestBody User user) {
User actualUser=userService.createUser(user);
HttpHeaders headers = new HttpHeaders();
// headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(team.getTeamid()).toUri());
return new ResponseEntity<>(actualUser,headers, HttpStatus.CREATED);
   }
 
   @GetMapping("/all")
public @ResponseBody ResponseEntity<List<User>> all() {
return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
   }
 
   @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
User user = userService.findByUserId(id);
if (user == null) {
return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
return new ResponseEntity<>(user, HttpStatus.OK);
   }
 
   @PutMapping(value = "/{id}", headers="Accept=application/json")
public ResponseEntity<User> updateUser(@PathVariable("id") long id,@RequestBody User currentUser)
   {
User user=userService.updateUser(id,currentUser);
return new ResponseEntity<>(user,HttpStatus.OK);
   }
 
   @DeleteMapping(value="/{id}", headers ="Accept=application/json")
public ResponseEntity<User> deleteUser(@PathVariable("id") Long id){
User user = userService.findByUserId(id);
if (user == null) {
return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
userService.deleteUserById(id);
return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }
 
}