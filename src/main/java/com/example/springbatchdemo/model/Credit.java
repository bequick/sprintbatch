package com.example.springbatchdemo.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Credit {
    /**
     * Campo correlativo.
     */
    private String correlativo;

    /**
     * Campo credito.
     */
    private Long credito;

    /**
     * campo moneda.
     */
    private String moneda;

    /**
     * Campo rut.
     */
    private Long rut;

    /**
     * Campo dv.
     */
    private String dv;

    /**
     * Campo nombre.
     */
    private String nombre;

    /**
     * Campo oficina.
     */
    private String oficina;

    /**
     * Campo nombre oficina.
     */
    private String nombreOficina;

    /**
     * Campo cuotas.
     */
    private String cuotas;

    /**
     * Campo fecha curse.
     */
    private String feCurse;

    /**
     * Campo producto.
     */
    private String producto;

    /**
     * Campo tipo.
     */
    private String tipo;

    /**
     * Campo tasa.
     */
    private Double tasa;

    /**
     * Campo montoCuota.
     */
    private Double montoCuota;

    /**
     * Campo monto credito.
     */
    private Double montoCredito;

    /**
     * Campo familia.
     */
    private String familia;

    /**
     * Campo codigo producto.
     */
    private String codProducto;

    /**
     * Campo canal.
     */
    private String canal;

    /**
     * Campo canal de ingreso.
     */
    private String canalIngreso;

    /**
     * Campo numero de garantia.
     */
    private String nroGarantia;

    /**
     * Campo sparce1.
     */
    private String spare1;

    /**
     * Campo spare2.
     */
    private String spare2;

    /**
     * Campo ultimaCuota.
     */
    private Double ultimaCuota;

    /**
     * Campo profesion.
     */
    private String profesion;

    /**
     * Campo estadoCivil.
     */
    private String estadoCivil;

    /**
     * Campo idCliente.
     */
    private String idCliente;

    /**
     * Campo cuotasOriginales.
     */
    private Double cuotasOriginales;

    /**
     * Campo tasaOriginal.
     */
    private Double tasaOriginal;

    /**
     * Campo fechaOriginal.
     */
    private String fechaOriginal;

    /**
     * Campo saldoAdeudado.
     */
    private Double saldoAdeudado;

    /**
     * Campo primerVcmto.
     */
    private String primerVcmto;

    /**
     * Campo nroReprogramacion.
     */
    private Long nroReprogramacion;


    private String direccion;

    private String fechaDocumento;
}
