package codifica.ecommerce.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    @GetMapping()
    public String getProducts(@AuthenticationPrincipal UserDetails userDetails) {

        return "Produtos";
    }

    @GetMapping("/admin")
    public String getAdmin(@AuthenticationPrincipal UserDetails userDetails) {
        return "Produtos Admin";
    }
}
