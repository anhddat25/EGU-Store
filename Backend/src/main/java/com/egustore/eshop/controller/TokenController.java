package com.egustore.eshop.controller;

import com.egustore.eshop.dto.TokenDTO;
import com.egustore.eshop.model.Tokens;
import com.egustore.eshop.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v0/tokens")
@Validated
public class TokenController {
    private final TokenService tokenService;

    @Autowired
    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }
    //Create category
    @PostMapping("/create")
    public ResponseEntity<?> createToken(@RequestBody @Valid TokenDTO tokenDTO, BindingResult result)
    {
        if(result.hasErrors())
        {
            List<String> errMessage = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errMessage);
        }
        tokenService.createToken(tokenDTO);
        return ResponseEntity.ok("Create token successfully!");
    }

    //    //Show all categories
    @GetMapping("/list")
    public ResponseEntity<List<Tokens>> getAllTokens() {
        List<Tokens> tokens = tokenService.getAllTokens();
        return ResponseEntity.ok(tokens);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateToken(@PathVariable int id,@RequestBody TokenDTO tokenDTO) {
        tokenService.updateToken(id,tokenDTO);
        return ResponseEntity.ok("update token ");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteToken(@PathVariable int id) {
        tokenService.deleteToken(id);
        return ResponseEntity.ok("delete token " + id);
    }

}
