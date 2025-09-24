package com.ma.services.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ma.beans.VentaKaiExcel;
import com.ma.dao.ExcelKaiDao;
import com.ma.services.ExcelService;

@Service
public class ExcelServiceImpl  implements ExcelService{

	@Autowired
	private ExcelKaiDao excelKaiDao;
	
	@Transactional
	@Override
	public void lecturaExcel() {

String ruta = "C:/Users/x/Downloads/Sales_20240917_20250917.csv";
List<VentaKaiExcel> ventas = new ArrayList<>();

try (CSVReader reader = new CSVReader(new FileReader(ruta))) {
    String[] valores;
    boolean primera = true;
    while ((valores = reader.readNext()) != null) {
        if (primera) {
            primera = false;
            continue; // saltar cabecera
        }

        // Reemplaza comas internas en columna productos (ejemplo índice 5)
        valores[5] = valores[5].replaceAll(",\\s*", "-");

        VentaKaiExcel venta = new VentaKaiExcel();
        venta.setId(valores[0]);
        venta.setFecha(valores[2]);
        venta.setTotalItems(valores[4]);
        venta.setSubtotal(valores[6]);
        venta.setDescuento(valores[7]);
        venta.setEnvio(valores[9]);
        venta.setTotal(valores[10].replace(".",""));
        venta.setGanancia(valores[11]);
        venta.setFormaPago(valores[12]);
        venta.setCliente(valores[13]);
        venta.setObservacion(valores[15]);

        ventas.add(venta);
    }
} catch (Exception e) {
    e.printStackTrace();
}

System.out.println("El número de registros es: " + ventas.size());
excelKaiDao.insertar(ventas);
System.out.println("Insertados: " + ventas.size());
          

            
	}
	
	


}
