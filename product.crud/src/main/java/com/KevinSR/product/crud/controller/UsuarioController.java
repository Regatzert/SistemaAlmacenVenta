package com.KevinSR.product.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.KevinSR.product.crud.Exception.ResourceNotFoundException;
import com.KevinSR.product.crud.entity.Usuario;
import com.KevinSR.product.crud.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    //Listar Usuarios
    @GetMapping
    public List<Usuario> getAllUsuario(){
        return this.usuarioRepository.findAll();
    }
    
    //get user by id
    @GetMapping("/{id}") //declaracion del tipo de EndPoint que enviara el id mediante el url para su busqueda del usuario
    public Usuario getUserById(@PathVariable (value = "id") Integer IdUsuario){ //Creacion del metodo de busqueda/listado de un usuario en especifico por su id retornado en el URL y el tipo de variable
        return this.usuarioRepository.findById(IdUsuario) //retorno del usuario usando el metodo FindById enviando como parametro el "user id" especificado en los parametros del metodo principal
        .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con el id: "+ IdUsuario)); //en caso de encontrarse un error se utiliza el OrElseThrow y como parametros se envia la clase creada anteriormente con el mensaje personalizado
    }

    //creater user
    @PostMapping
    public Usuario createUser(@RequestBody Usuario usuario){ //creacion del metodo crear usuario de tipo User(clase designada) y enviando como parametro un @RequestBody que instanciara la clase tipo User llamada user
        return this.usuarioRepository.save(usuario); //Utilizaremos el metodo Save() enviando como parametro la clase user desde el repositorio instanciado
    }

    //update user by id
    @PutMapping("/{id}") //declaracion del tipo de EndPoint para actualizar el usuario y se envia el Id por la URL
    public Usuario updateUser(@RequestBody Usuario user, @PathVariable ("id") Integer IdUsuario){
        Usuario existing = this.usuarioRepository.findById(IdUsuario) //creacion de un objeto temporal de tipo User para la busqueda del usuario usando el metodo FindById() y almacenandolo de ser encontrado
        .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con el id: "+ IdUsuario));
        //actualizacion de valores del usuario encontrado
        existing.setUsuario(user.getUsuario()); //actualizacion del campo nombre con el objeto temporal
        existing.setContrasenia(user.getContrasenia()); //actualizacion del campo nombre con el objeto temporal
        existing.setNombre(user.getNombre()); //actualizacion del campo nombre con el objeto temporal
        existing.setApPaterno(user.getApPaterno()); //actualizacion del campo apellido con el objeto temporal
        existing.setApMaterno(user.getApMaterno()); //actualizacion del campo email con el objeto temporal
        existing.setFNacimiento(user.getFNacimiento()); //actualizacion del campo nombre con el objeto temporal
        existing.setTelefono(user.getTelefono()); //actualizacion del campo nombre con el objeto temporal
        existing.setDocumentoIdentidad(user.getDocumentoIdentidad()); //actualizacion del campo nombre con el objeto temporal        
        existing.setActivo(user.getActivo()); //actualizacion del campo nombre con el objeto temporal
        return this.usuarioRepository.save(existing); //ejecucion y retorno del metodo Save() del objeto instanciado UserRepository con los datos del objeto temporal
    }

    //delete user by id
    @DeleteMapping("/{id}") //declaracion del tipo de EndPoint para eliminar el usuario y se envia el Id por la URL
    public ResponseEntity<Usuario> deleteUser(@PathVariable("id") Integer IdUsuario){ //creacion del metodo para eliminar usuario por el Id que sera de tipo ResponseEntity<User> llamando a la clase del objeto User

        Usuario existingUser = this.usuarioRepository.findById(IdUsuario) //creacion de un objeto temporal de tipo User para la busqueda del usuario usando el metodo FindById() y almacenandolo de ser encontrado
        .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con el id: "+ IdUsuario));

        this.usuarioRepository.delete(existingUser); //utilizamos el metodo Delete() de la instancia UserRepository enviando como parametro el objeto temporal que contiene el usuario encontrado por el id
        return ResponseEntity.ok().build(); 

    }
    
}
