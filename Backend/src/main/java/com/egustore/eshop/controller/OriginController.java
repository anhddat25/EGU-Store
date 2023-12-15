package com.egustore.eshop.controller;

import com.egustore.eshop.dto.OriginDTO;
import com.egustore.eshop.model.Origin;
import com.egustore.eshop.response.CreateOriginResponse;
import com.egustore.eshop.response.DeleteOrderDetailResponse;
import com.egustore.eshop.response.DeleteOriginResponse;
import com.egustore.eshop.response.UpdateOriginResponse;
import com.egustore.eshop.service.OriginService;
import com.egustore.eshop.utils.LocalizationUtils;
import com.egustore.eshop.utils.MessageKeys;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v0/origins")
@Validated
@CrossOrigin("*")
public class OriginController {
    private final OriginService originService;
    private final LocalizationUtils localizationUtils;
    @Autowired
    public OriginController(OriginService originService, LocalizationUtils localizationUtils) {
        this.originService = originService;
        this.localizationUtils = localizationUtils;
    }
    //Create images
    @PostMapping("")
    public ResponseEntity<?> createOrigins(@RequestBody @Valid OriginDTO originDTO, BindingResult result)
    {
        if(result.hasErrors())
        {
            List<String> errMessage = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errMessage);
        }
        originService.createOrigin(originDTO);
        return ResponseEntity.ok(CreateOriginResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.ORIGIN_SUCCESSFULLY)).build());
    }

    //Show all image
    @GetMapping("")
    public ResponseEntity<List<Origin>> getAllOrigins() {
        List<Origin> origins = originService.getAllOrigins();
        return ResponseEntity.ok(origins);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Origin> getOriginById(@PathVariable int id) {
        return ResponseEntity.ok(originService.getOriginById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateOriginResponse> updateOrigins(@PathVariable int id,@RequestBody OriginDTO originDTO) {
        originService.updateOrigins(id,originDTO);
        return ResponseEntity.ok(UpdateOriginResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.UPDATEORIGIN_SUCCESSFULLY)).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteOriginResponse> deleteOrigins(@PathVariable int id) {
        originService.deleteOrigins(id);
        return ResponseEntity.ok(DeleteOriginResponse.builder().message(localizationUtils.getLocalizedMessage(MessageKeys.DELETEORIGIN_SUCCESSFULLY)).build());
    }
}
