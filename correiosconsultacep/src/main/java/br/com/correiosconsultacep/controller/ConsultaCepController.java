package br.com.correiosconsultacep.controller;

import br.com.correiosconsultacep.model.dtos.Request;
import br.com.correiosconsultacep.service.interfaceservice.ServicoCalculoFrete;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Esta classe representa o controlador para realizar consultas de endereço utilizando um serviço de cálculo de frete.
 */
@RequestMapping("/v1")
@RestController
@RequiredArgsConstructor
@Tag(name = "Consulta do CEP", description = "Endpoint para buscas de CEPs")
public class ConsultaCepController {
    @Autowired
    private ServicoCalculoFrete service;

    /**
     * Endpoint para realizar a consulta de um endereço a partir do CEP fornecido na requisição.
     * @param request objeto que contém o CEP a ser consultado.
     * @return um objeto ResponseEntity com a resposta da requisição HTTP, contendo os dados do endereço consultado.
     */
    @PostMapping("/consulta-endereco")
    @Operation(summary = "Busca por cep")
    @ApiResponse(responseCode = "200",description = "OK", content ={
            @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseEntity.class))})
    public ResponseEntity consultaCep(@RequestBody Request request) {
        return ResponseEntity.ok(service.executa(request));
    }

}
