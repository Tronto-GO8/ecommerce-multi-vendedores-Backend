package codifica.ecommerce.api.controller;

import codifica.ecommerce.api.user.User;
import codifica.ecommerce.api.user.dto.UserResponseDTO;
import codifica.ecommerce.api.user.UserService;
import codifica.ecommerce.api.user.dto.UserUpdateDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
//    private final UserRepository userRepository;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<?> getCurrentUser(@AuthenticationPrincipal UserDetails userDetails){
        if (userDetails == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario nao autenticado");
        }
        String identifier = userDetails.getUsername();

        User userDb = userService.findByUsername(identifier).orElseThrow(()->new UsernameNotFoundException("Usuario nao encontrado"));
        var UserResponse  = new UserResponseDTO(userDb.getId(), userDb.getName(), userDb.getEmail());
        return ResponseEntity.ok(UserResponse);
    }

    @PutMapping("/me")
    public ResponseEntity<?> updateCurrentUser(@AuthenticationPrincipal UserDetails userDetails,
                                               @RequestBody @Valid UserUpdateDTO data) {
        if (userDetails == null) {
            return ResponseEntity.status(401).body("Utilizador não autenticado.");
        }

        User updatedUser = userService.updateUserProfile(userDetails.getUsername(), data);

        return ResponseEntity.ok(Map.of(
                "name", updatedUser.getName(),
                "email", updatedUser.getEmail()
        ));
    }


}
