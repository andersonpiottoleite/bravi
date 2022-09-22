package br.com.anderson.bravi.teste.testebravi.vo;

import br.com.anderson.bravi.teste.testebravi.service.SuportesBalanceladosService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuportesBalanceladosVO {
    private Boolean conchetesValidados;
}
